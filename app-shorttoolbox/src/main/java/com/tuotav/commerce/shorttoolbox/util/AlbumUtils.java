package com.tuotav.commerce.shorttoolbox.util;

import android.Manifest;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.Nullable;

import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.UriUtils;
import com.blankj.utilcode.util.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.RandomUtil;

/**
 * ===============================================
 * <p> </p>
 * -----------------------------------------------
 *
 * @author Jia Junjian
 * @since 2023/2/2 13:57
 */
public class AlbumUtils {

    @Nullable
    public static File saveVideo2Album(final String video, final String dirName, final String suffix) {
        String safeDirName = TextUtils.isEmpty(dirName) ? Utils.getApp().getPackageName() : dirName;
        String fileName = System.currentTimeMillis() + "_" + RandomUtil.randomString(4) + "." + suffix;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            if (!PermissionUtils.isGranted(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Log.e("AlbumUtils", "save to album need storage permission");
                return null;
            }
            File picDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            File destFile = new File(picDir, safeDirName + "/" + fileName);
            if (!FileUtils.copy(FileUtil.file(video), destFile)) {
                return null;
            }
            FileUtils.notifySystemToScan(destFile);
            return destFile;
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put(MediaStore.Video.Media.DISPLAY_NAME, fileName);
            contentValues.put(MediaStore.Video.Media.MIME_TYPE, "video/*");
            Uri contentUri;
            if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else {
                contentUri = MediaStore.Video.Media.INTERNAL_CONTENT_URI;
            }
            contentValues.put(MediaStore.Video.Media.RELATIVE_PATH, Environment.DIRECTORY_DCIM + "/" + safeDirName);
            contentValues.put(MediaStore.MediaColumns.IS_PENDING, 1);
            Uri uri = Utils.getApp().getContentResolver().insert(contentUri, contentValues);
            if (uri == null) {
                return null;
            }
            OutputStream os = null;
            FileInputStream is = null;
            try {
                is = new FileInputStream(video);
                os = Utils.getApp().getContentResolver().openOutputStream(uri);
                IoUtil.copy(is, os, 5 *1024);

                contentValues.clear();
                contentValues.put(MediaStore.MediaColumns.IS_PENDING, 0);
                Utils.getApp().getContentResolver().update(uri, contentValues, null, null);

                return UriUtils.uri2File(uri);
            } catch (Exception e) {
                Utils.getApp().getContentResolver().delete(uri, null, null);
                e.printStackTrace();
                return null;
            } finally {
                try {
                    if (os != null) {
                        os.close();
                    }

                    if (is != null) {
                        is.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
