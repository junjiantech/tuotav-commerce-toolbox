package com.tuotav.commerce.shorttoolbox.arch.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cn.hutool.core.util.ObjectUtil
import com.blankj.utilcode.util.ToastUtils
import com.tuotav.commerce.shorttoolbox.arch.usecase.DownloadVideoToAlbumUseCase
import com.tuotav.commerce.shorttoolbox.arch.usecase.ShortShareTextParsingUseCase
import com.tuotav.commerce.shorttoolbox.lang.coroutine.Coroutines
import com.tuotav.feature.shorthelper.GsonUtils
import com.tuotav.feature.shorthelper.ShortHackerService
import com.tuotav.feature.shorthelper.ShortInformationViewObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ===============================================
 * ViewModel(首页)
 * -----------------------------------------------
 * @author Jia Junjian
 * @since 2023/2/2 10:01
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val parsingUseCase: ShortShareTextParsingUseCase,
    private val downloadUseCase: DownloadVideoToAlbumUseCase
): ViewModel() {

    private val _shortViewObject = MutableLiveData<ShortInformationViewObject>()
    val dataShortViewObject: LiveData<ShortInformationViewObject> = _shortViewObject

    private val _downloadProgress = MutableLiveData<Int>()
    val dataDownloadProgress: LiveData<Int> = _downloadProgress

    /**
     * 分析分享文本
     * @param shareText 分享文本
     */
    fun parsingShareText(shareText: String) = viewModelScope.launch(context = Coroutines.commonExceptionHandler) {
        // 分析分享链接
        val data = parsingUseCase(shareText)
        // 将短视频详细信息设置到视图中.
        _shortViewObject.value = data
    }

    /**
     * 下载短视频文件到相册中
     * @param video 视频地址
     */
    fun downloadShortFileToAlbum(video: String?) = viewModelScope.launch(context = Coroutines.commonExceptionHandler){
        if (ObjectUtil.isEmpty(video)) throw IllegalStateException("不规范的视频地址")
        // 下载视频到相册中
        downloadUseCase(video!!){ progress ->
            // 更新下载进度
            _downloadProgress.postValue(progress)
        }
    }

    /**
     * 格式化短视频详细文本
     * @param vo 短视频详细信息
     */
    fun formatShortInformationText(vo: ShortInformationViewObject): String {
        return """
        视频标题: ${vo.title}
        发布人: ${vo.nickname ?: "暂无"}
        视频播放地址: ${vo.video ?: "暂无"}
        """.trimIndent()
    }
}