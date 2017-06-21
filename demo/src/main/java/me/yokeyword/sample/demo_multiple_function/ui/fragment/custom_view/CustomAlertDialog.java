package me.yokeyword.sample.demo_multiple_function.ui.fragment.custom_view;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

public class CustomAlertDialog {
    private Context context;
    private int customeLayoutId;
    private String dialogTitle;
    private String dialogMessage;
    private String positiveText;
    private String negativeText;

    private View dialogView;
    private OnDialogListener listener;
    //带有自定义view的构造器
    public CustomAlertDialog(Context context, int customeLayoutId, String dialogTitle, String positiveText, String negativeText) {
        this.context = context;
        this.customeLayoutId = customeLayoutId;
        this.dialogTitle = dialogTitle;
        this.positiveText = positiveText;
        this.negativeText = negativeText;
        this.dialogView=View.inflate(context,customeLayoutId,null);
    }
    //不带自定义view的构造器
    public CustomAlertDialog(Context context, String dialogMessage, String dialogTitle, String positiveText, String negativeText) {
        this.context = context;
        this.dialogTitle = dialogTitle;
        this.dialogMessage = dialogMessage;
        this.positiveText = positiveText;
        this.negativeText = negativeText;
    }

    public View getDialogView() {
        return dialogView;
    }

    public void setDialogView(View dialogView) {
        this.dialogView = dialogView;
    }

    public void showDialog(){
        BaseCustomDialog.Builder dialog=new BaseCustomDialog.Builder(context);
        dialog.setTitle(dialogTitle);//设置标题
        //注意:dialogMessage和dialogView是互斥关系也就是dialogMessage存在dialogView就不存在,dialogView不存在dialogMessage就存在
        if (dialogMessage!=null){
            dialog.setMessage(dialogMessage);//设置对话框内容
        }else{
            dialog.setContentView(dialogView);//设置对话框的自定义view对象
        }
        dialog.setPositiveButton(positiveText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
                if (listener!=null){
                    listener.dialogPositiveListener(dialogView,dialogInterface,which);
                }
            }
        }).setNegativeButton(negativeText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
                if (listener!=null){
                    listener.dialogNegativeListener(dialogView,dialogInterface,which);
                }
            }
        }).create().show();
    }
    //注册监听器方法
    public CustomAlertDialog setOnDiaLogListener(OnDialogListener listener){
        this.listener=listener;
        return this;//把当前对象返回,用于链式编程
    }
    //定义一个监听器接口
    public interface OnDialogListener{
        //customView　这个参数需要注意就是如果没有自定义view,那么它则为null
        public void dialogPositiveListener(View customView, DialogInterface dialogInterface, int which);
        public void dialogNegativeListener(View customView, DialogInterface dialogInterface, int which);
    }
}
