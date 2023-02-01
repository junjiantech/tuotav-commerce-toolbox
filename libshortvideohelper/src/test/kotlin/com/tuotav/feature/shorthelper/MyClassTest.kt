package com.tuotav.feature.shorthelper

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test


/**
 * ===============================================
 *
 *
 * -----------------------------------------------
 * @author Jia Junjian
 * @since 2023/2/1 15:23
 */
@OptIn(ExperimentalCoroutinesApi::class)
internal class MyClassTest {

    companion object {
        // 抖音测试分享文本
        const val DOUYIN_TEST_SHARE_TEXT
            = "4.89 UYm:/ 微博已经卸载了 # 胡歌 # 胡歌官宣结婚当爸爸 # 胡歌老婆是谁# 办公室日常 # 摸鱼  https://v.douyin.com/BFXAvVV/ 复制此链接，打开Dou音搜索，直接观看视频！"
    }

    @Test
    fun testShortHackerServiceParsing() = runTest {
        val service: ShortHackerService = DouyinShortHackerService()
        // 解析抖音详细信息
        val viewObject = service.parsing(DOUYIN_TEST_SHARE_TEXT)
        // 打印结果
        println("data: $viewObject")
    }
}