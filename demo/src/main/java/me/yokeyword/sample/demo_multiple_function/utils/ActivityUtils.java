package me.yokeyword.sample.demo_multiple_function.utils;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by zhym on 05/06/2017.
 */

public class ActivityUtils {

    /**
     * 设置不显示导航bar
     * */
    public void setNoNavBar(Activity activity) {
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
        activity.getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);

        // 避免fragment切换时黑屏
        activity.getWindow().setFormat(PixelFormat.TRANSLUCENT);

        int uiFlags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                | View.SYSTEM_UI_FLAG_FULLSCREEN; // hide status bar

        if( android.os.Build.VERSION.SDK_INT >= 19 ){
            uiFlags|= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        } else {
            uiFlags |= View.SYSTEM_UI_FLAG_LOW_PROFILE;
        }
        activity.getWindow().getDecorView().setSystemUiVisibility(uiFlags);

    }

}
