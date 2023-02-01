package com.tuotav.feature.shorthelper

/**
 * ===============================================
 * 短视频解析服务. (通过传入的分享信息获取短视频详细内容)
 * -----------------------------------------------
 * @author Jia Junjian
 * @since 2023/2/1 15:34
 */
interface ShortHackerService {

    /**
     * 短视频分享信息分析/解析
     * @param shareText 分享文本
     * @return {@code object: 短视频解析信息 or null}
     */
    suspend fun parsing(shareText: String): ShortInformationViewObject?
}