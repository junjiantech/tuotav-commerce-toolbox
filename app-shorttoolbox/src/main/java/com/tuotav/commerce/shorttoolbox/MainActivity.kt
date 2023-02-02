package com.tuotav.commerce.shorttoolbox

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.ClickUtils
import com.blankj.utilcode.util.KeyboardUtils
import com.blankj.utilcode.util.ObjectUtils
import com.blankj.utilcode.util.PermissionUtils
import com.blankj.utilcode.util.ToastUtils
import com.tuotav.commerce.shorttoolbox.arch.vm.MainViewModel
import com.tuotav.commerce.shorttoolbox.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * ===============================================
 * <p> 主页 </p>
 * -----------------------------------------------
 * @author Jia Junjian
 * @since 2023/2/2 10:13
 */
@AndroidEntryPoint
class MainActivity: AppCompatActivity() {

    private val vm: MainViewModel by viewModels<MainViewModel>()
    private val vb: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vb.root)

        // 监听数据变化
        vm.dataShortViewObject.observe(this){ vo ->
            // 设置文本显示信息
            vb.tvMainShortInformation.text = vm.formatShortInformationText(vo)
            // 显示结果显示.
            vb.layoutMainShortInformation.visibility = View.VISIBLE
            // 清除输入框文本信息
            vb.editMainShareText.text = null
        }
        vm.dataDownloadProgress.observe(this) { progress ->
            // 更新进度
            vb.progressMainDownloadShort.progress = progress
            // 如果下载完成则提示下载完成
            if (progress >= 100) {
                ToastUtils.showShort(R.string.text_download_completed)
                // 更新下载相关视图的显示状态
                vb.btnMainDownloadShort.visibility = View.VISIBLE
                vb.progressMainDownloadShort.visibility = View.GONE
            }
        }

        // 解析短视频
        ClickUtils.applyGlobalDebouncing(vb.btnMainParsingShort){_ ->
            // 隐藏结果显示.
            vb.layoutMainShortInformation.visibility = View.GONE
            // 解析分享文本
            vm.parsingShareText(ObjectUtils.toString(vb.editMainShareText.text))
            // 隐藏软键盘
            KeyboardUtils.hideSoftInput(vb.editMainShareText)
        }

        // 复制视频播放地址
        ClickUtils.applyGlobalDebouncing(vb.tvMainShortInformation){_ ->
            // empty
        }

        // 下载到相册
        ClickUtils.applyGlobalDebouncing(vb.btnMainDownloadShort) {_ ->
            if (PermissionUtils.isGranted(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                vb.btnMainDownloadShort.visibility = View.GONE
                vb.progressMainDownloadShort.visibility = View.VISIBLE
                // 下载短视频保存到相册中
                vm.downloadShortFileToAlbum(vm.dataShortViewObject.value?.video)
            } else {
                // 请求存储权限
                PermissionUtils.permission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE).request()
            }
        }
    }
}