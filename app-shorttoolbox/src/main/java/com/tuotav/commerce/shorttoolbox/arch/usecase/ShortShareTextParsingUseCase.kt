package com.tuotav.commerce.shorttoolbox.arch.usecase

import com.tuotav.feature.shorthelper.ShortHackerService
import com.tuotav.feature.shorthelper.ShortInformationViewObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * ===============================================
 * (功能用例) 短视频分享链接分析
 * -----------------------------------------------
 * @author Jia Junjian
 * @since 2023/2/2 11:18
 */
class ShortShareTextParsingUseCase @Inject constructor(val hackerService: ShortHackerService) {

    @Throws(IllegalArgumentException::class, IllegalStateException::class)
    suspend operator fun invoke(shareText: String): ShortInformationViewObject = withContext(Dispatchers.IO) {
        return@withContext hackerService.parsing(shareText) ?: throw IllegalStateException("解析失败")
    }
}