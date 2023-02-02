package com.tuotav.feature.shorthelper

import cn.hutool.core.util.ObjectUtil
import cn.hutool.core.util.RandomUtil
import cn.hutool.core.util.ReUtil
import cn.hutool.http.HttpRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import java.util.Collections

/**
 * ===============================================
 * 针对抖音平台的短视频解析服务. (通过传入的分享信息获取短视频详细内容)
 *
 * 操作步骤:
 *  App任意视频 > 分享 > 复制链接 > 调用[DouyinShortHackerService.parsing] 获取真实信息
 * -----------------------------------------------
 * @author Jia Junjian
 * @since 2023/2/1 15:38
 */
class DouyinShortHackerService: ShortHackerService {

    companion object {
        /**
         * (正则) 分享信息中提取链接
         */
        private const val PATTERN_SHARE_TEXT_GET_URL
            = "http[s]?://(?:[a-zA-Z]|[0-9]|[\$-_@.&+]|[!*\\(\\),]|(?:%[0-9a-fA-F][0-9a-fA-F]))+"

        /**
         * (配置) 抖音视频接口模板
         */
        private const val CONFIG_TEMPLATE_DOUYIN_VIDEO_API
            = "https://www.iesdouyin.com/aweme/v1/web/aweme/detail/?aweme_id=%s&aid=1128&version_name=23.5.0&device_platform=android&os_version=2333"

        /**
         * (配置) 抖音视频播放链接
         */
        private const val CONFIG_TEMPLATE_VIDEO_PLAY
            = "https://aweme.snssdk.com/aweme/v1/play/?video_id=%s&ratio=1080p&line=0"
    }

    /**
     * 伪造请求头
     */
    private val mConfigFakeRequestHeader = HashMap<String, String>().apply {
        put("user-agent", "Mozilla/5.0 (Linux; Android 8.0; Pixel 2 Build/OPD3.170816.012) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Mobile Safari/537.36 Edg/87.0.664.66")
        put("Cookie", "msToken=%s".format(RandomUtil.randomString(107)))
    }

    override suspend fun parsing(shareText: String): ShortInformationViewObject? {
        // 视频短链
        val videoShortLink = ReUtil.get(PATTERN_SHARE_TEXT_GET_URL, shareText, 0)
        if (ObjectUtil.isEmpty(videoShortLink)) throw IllegalArgumentException("分享链接不符合规范!")
        // 解析短视频链接获取视频标识
        val (videoId, _) = parsingVideoShortLinkGetVideoId(videoShortLink)
        // 解析视频详细信息
        val videoInformation = parsingVideoLinkGetVideoInformation(videoId)
        // 精简视频详细信息并返回结果
        return reduceVideoInformation2ViewObject(videoInformation);
    }

    /**
     * 分析视频短链获取视频标识
     * @param videoShortLink 视频分享短链
     * @return (key, keyType); key: 视频标识, keyType: 视频类型
     */
    private suspend fun parsingVideoShortLinkGetVideoId(videoShortLink: String): Pair<String, String> = withContext(Dispatchers.IO){
        val response = HttpRequest.get(videoShortLink)
            .headerMap(mConfigFakeRequestHeader, true)
            .timeout(3 * 1000)
            .execute()
            .body()
        // 从短链响应中查询重定向 'a' 标签并获取重定向地址(真实的分享地址)
        val videoLink = Jsoup.parse(response).select("a").attr("href")
        // 根据链接确定链接类型及解析视频标识
        return@withContext when{
            videoLink.contains("/share/user/") -> {
                val videoId = if (videoLink.contains("?")){
                    ReUtil.get("user\\/([\\d\\D]*)([?])", videoLink, 0)
                } else{
                    ReUtil.get("user\\/([\\d\\D]*)", videoLink, 0)
                }.replace("user/", "")
                // 组装结果
                Pair(videoId, "user")
            }
            videoLink.contains("/share/video/") -> {
                val videoId = ReUtil.get("video/(\\d+)?", videoLink, 0)
                    .replace("video/", "")
                // 组装结果
                Pair(videoId, "aweme")
            }
            videoLink.contains("live.douyin.com") -> {
                val videoId = videoLink.replace("https://live.douyin.com/", "")
                // 组装结果
                Pair(videoId, "live")
            }
            else -> throw IllegalStateException("[  警告  ]:输入链接有误！无法获取 id")
        }
    }

    /**
     * https://v99-coldx.douyinvod.com/0052204e93dda2a79dbd18d29101503a/63da33bc/video/tos/cn/tos-cn-ve-15c001-alinc2/o8X2nbB8ADFCoLf97gjgeBoxQl9OAO56OAQNPK/?a=1128&ch=0&cr=0&dr=0&cd=0%7C0%7C0%7C0&cv=1&br=3471&bt=3471&cs=0&ds=4&ft=rVQ6eUwwZRdZskno1PDSu9WciDXR1bt2g~YwF_7BguUK2Nz7t&mime_type=video_mp4&qs=0&rc=Nmc5NDY2OjQ0aThoZGg1NkBpanh5dzM6ZnloaTMzNGkzM0AtNV41NV4vNi4xYDZhMV5fYSNybS1ycjQwX2BgLS1kLS9zcw%3D%3D&l=20230201164101EC1262598A8AC80B4975&btag=90000
     * 分析视频链接获取视频详细信息
     * @param videoId 视频标识
     * @return 视频详细信息
     */
    private suspend fun parsingVideoLinkGetVideoInformation(videoId: String): DouyinVideoInformationResponse = withContext(Dispatchers.IO) {
        // 抖音视频信息接口链接
        val videoInformationUrl = String.format(CONFIG_TEMPLATE_DOUYIN_VIDEO_API, videoId)
        // 通过抖音视频接口获取视频信息
        val response = HttpRequest.get(videoInformationUrl)
            .headerMap(mConfigFakeRequestHeader, true)
            .timeout(3 * 1000)
            .execute()
            .body()
        // Gson 解析响应参数
        return@withContext GsonUtils.fromJson(response, DouyinVideoInformationResponse::class.java)
    }

    /**
     * 精简视频详细信息为ViewObject
     * @param info 视频详细信息
     * @return 精简后视频详细信息
     */
    private fun reduceVideoInformation2ViewObject(info: DouyinVideoInformationResponse): ShortInformationViewObject {
        if (info.statusCode != 0) throw IllegalStateException("抖音详细信息接口失败")
        // 作者头像
        val avatar = info.awemeDetail.author.avatarThumb.urlList.firstOrNull()?.also { it.replace("100x100", "1080x1080") }
        val avatarThumb = info.awemeDetail.author.avatarThumb.urlList.firstOrNull()
        // 作者昵称
        val nickname = info.awemeDetail.author.nickname
        // 视频标题
        val signature = info.awemeDetail.author.signature
        // 用户唯一标识
        val uId = info.awemeDetail.author.shortId
        // 视频标题
        val title = info.awemeDetail.previewTitle
        // 背景音乐
        val music = info.awemeDetail.music.playUrl.uri
        // 视频播放地址
        val video = CONFIG_TEMPLATE_VIDEO_PLAY.format(info.awemeDetail.video.playAddr.uri)
        // 图片信息
        val images = info.awemeDetail.images?.urlList ?: Collections.emptyList()
        // 组装短视频详细信息
        return ShortInformationViewObject(
            avatar ?: "", avatarThumb ?: "",
            nickname, signature, uId, title,
            music, video, images)
    }
}