package com.tuotav.commerce.shorttoolbox.arch.usecase

import android.util.Log
import cn.hutool.core.io.StreamProgress
import cn.hutool.core.util.RandomUtil
import cn.hutool.http.HttpUtil
import com.blankj.utilcode.util.FileUtils
import com.blankj.utilcode.util.ImageUtils
import com.blankj.utilcode.util.Utils
import com.tuotav.commerce.shorttoolbox.util.AlbumUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import javax.inject.Inject

/**
 * ===============================================
 * 下载文件保存到相册中...
 * -----------------------------------------------
 * @author Jia Junjian
 * @since 2023/2/2 13:44
 */
class DownloadVideoToAlbumUseCase @Inject constructor() {

    suspend operator fun invoke(video: String, listener: (progress: Int) -> Unit) = withContext(Dispatchers.IO) {
        val cacheFileDir = File(Utils.getApp().cacheDir, "downloads")
        val cacheFile = File(cacheFileDir, "${RandomUtil.randomStringUpper(12)}.mp4")
        // 下载文件大小.
        val downloadSize = HttpUtil.downloadFile(video, cacheFile, object: StreamProgress{
            override fun start() = Unit
            override fun finish() = Unit

            override fun progress(total: Long, progressSize: Long) {
                // 更新下载进度.
                listener.invoke((progressSize / total * 100).toInt())
            }
        })
        // println download file size log.
        Log.d("DownloadVideoToAlbumUseCase", "download file completed total: $downloadSize")
        // save to album
        AlbumUtils.saveVideo2Album(cacheFile.absolutePath, "", "mp4")
    }
}