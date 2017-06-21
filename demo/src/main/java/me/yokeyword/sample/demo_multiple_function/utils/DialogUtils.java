package me.yokeyword.sample.demo_multiple_function.utils;

import android.app.Dialog;
import android.view.WindowManager;

/**
 * Created by zhym on 05/06/2017.
 */

public class DialogUtils {


    /**
     * 解决Dialog弹出时，下方导航栏弹出的bug
     * */
    public void setNoNavBar(Dialog dialog) {
//        mDialog = new Dialog(activity, R.style.dialog_style);
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        //Set the dialog to immersive
        dialog.getWindow().getDecorView().setSystemUiVisibility(dialog.getWindow().getDecorView().getSystemUiVisibility());
//        mDialog.setContentView(view, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }
}
