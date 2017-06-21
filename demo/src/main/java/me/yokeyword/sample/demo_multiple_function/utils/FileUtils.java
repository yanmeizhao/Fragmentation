package me.yokeyword.sample.demo_multiple_function.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by zhym on 05/06/2017.
 */

public class FileUtils {

    /**
     * 保存Bitmap到设备内存（设备没有sdcard）
     * */
    private void saveBitmapToFile(Context context, Bitmap bitmap) {
        String path = getSavePath(context, "id.png");
        Log.i("zhym", "-->> save file path is : "+path);

        if(path != null) {
            File imageFile = new File(path);
            if(imageFile.exists()) {
                imageFile.delete();
            }

            try {
                imageFile.createNewFile();
                FileOutputStream out = new FileOutputStream(imageFile);
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
                out.flush();
                out.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 获取设备内存路径
     * */
    public static String getSavePath(Context context, String file_name) {
        String path = null;
        File dataDir = context.getApplicationContext().getExternalFilesDir(null);
        if(dataDir != null) {
            path = dataDir.getAbsolutePath() + File.separator + file_name;
        }

        return path;
    }

    public static byte[] bgraByte = new byte[Constants.PREVIEW_WIDTH * Constants.PREVIEW_HEIGHT * 4];
    public static byte[] RGBA2BGRA(byte[] rgbaByteArr) {
        int size = Constants.PREVIEW_WIDTH * Constants.PREVIEW_HEIGHT;
        for (int i = 0; i < size; i++) {
            bgraByte[4 * i] = rgbaByteArr[4 * i + 2];
            bgraByte[4 * i + 1] = rgbaByteArr[4 * i + 1];
            bgraByte[4 * i + 2] = rgbaByteArr[4 * i];
            bgraByte[4 * i + 3] = rgbaByteArr[4 * i + 3];
        }
        return bgraByte;
    }
}
