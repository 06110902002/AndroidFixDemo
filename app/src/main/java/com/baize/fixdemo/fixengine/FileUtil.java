package com.baize.fixdemo.fixengine;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

/**
 * author: lxb
 * created on: 2017/11/24 11:16
 * description:
 * copyright:baize ShangHai
 */

public class FileUtil {


    /**
     *
     * @param src
     * @param dest
     * @throws IOException
     */
    public static void copyFile(File src, File dest) throws IOException {
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            if (!dest.exists()) {
                dest.createNewFile();
            }
            inChannel = new FileInputStream(src).getChannel();
            outChannel = new FileOutputStream(dest).getChannel();
            inChannel.transferTo(0, inChannel.size(), outChannel);
        } finally {
            if (inChannel != null) {
                inChannel.close();
            }
            if (outChannel != null) {
                outChannel.close();
            }
        }
    }

    /**
     *
     * @param file
     * @return true if delete success
     */
    public static boolean deleteFile(File file) {
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                deleteFile(f);
            }
        }
        return file.delete();
    }

    public static boolean copyAssetsTo(Context context, String assetsName, String fullPath) {
        if (TextUtils.isEmpty(assetsName) || TextUtils.isEmpty(fullPath)) {
            return false;
        }

        try {
            File targetFile = new File(fullPath);
            InputStream inputStream = context.getAssets().open(assetsName);

            if (!targetFile.exists()) {
                targetFile.getParentFile().mkdir();
//                targetFile.createNewFile();
            }

            OutputStream os = null;
            try {
                os = new BufferedOutputStream(new FileOutputStream(targetFile));
                byte data[] = new byte[1024];
                int len;
                while ((len = inputStream.read(data, 0, 1024)) != -1) {
                    os.write(data, 0, len);
                }
                os.flush();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("FD","===>"+e);
                return false;
            } finally {
                if (os != null) {
                    try {
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}