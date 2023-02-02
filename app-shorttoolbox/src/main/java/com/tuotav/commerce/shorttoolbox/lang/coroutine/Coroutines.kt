package com.tuotav.commerce.shorttoolbox.lang.coroutine

import android.util.Log
import com.blankj.utilcode.util.ThrowableUtils
import com.blankj.utilcode.util.ToastUtils
import kotlinx.coroutines.CoroutineExceptionHandler

/**
 * ===============================================
 * 协程工具
 * -----------------------------------------------
 * @author Jia Junjian
 * @since 2023/2/2 11:56
 */
object Coroutines {

    /**
     * 公共异常处理器
     */
    val commonExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        // println exception log.
        Log.e("CommonExceptionHandler", ThrowableUtils.getFullStackTrace(throwable))
        // 简单提示信息.
        ToastUtils.showShort(throwable.message)
    }
}