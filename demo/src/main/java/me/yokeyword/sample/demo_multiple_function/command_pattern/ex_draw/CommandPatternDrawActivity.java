package me.yokeyword.sample.demo_multiple_function.command_pattern.ex_draw;

import android.app.Activity;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.yokeyword.sample.R;

/**
 * Created by zhym on 28/05/2017.
 */

public class CommandPatternDrawActivity extends Activity {
    @BindView(R.id.id_sv_design_patterns_command_pattern_draw_canvas)
    DrawCanvas mDcDraw;
    @BindView(R.id.id_btn_design_patterns_command_pattern_withdraw)
    Button mBtnWithDraw;
    @BindView(R.id.id_btn_design_patterns_command_pattern_redo)
    Button mBtnRedo;

    private DrawPath mPath;
    private Paint mPaint;
    private IBrush mBrush;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_design_patterns_command_pattern_draw);
        ButterKnife.bind(this);

        mPaint = new Paint();
        mPaint.setColor(0xFFFFFFFF);
        mPaint.setStrokeWidth(3);

        mBrush = new NormalBrush();

        mDcDraw.setOnTouchListener(new DrawTouchListener());

        mBtnRedo.setEnabled(false);
        mBtnWithDraw.setEnabled(false);
    }

    @OnClick(R.id.id_btn_design_patterns_command_pattern_draw_red)
    void onClickDrawRed() {
        mPaint = new Paint();
        mPaint.setStrokeWidth(3);
        mPaint.setColor(0xFFFF0000); // ARGB
    }

    @OnClick(R.id.id_btn_design_patterns_command_pattern_draw_green)
    void onClickDrawGreen() {
        mPaint = new Paint();
        mPaint.setStrokeWidth(3);
        mPaint.setColor(0xFF00FF00);
    }

    @OnClick(R.id.id_btn_design_patterns_command_pattern_draw_blue)
    void onClickDrawBlue() {
        mPaint = new Paint();
        mPaint.setStrokeWidth(3);
        mPaint.setColor(0xFF0000FF);
    }

    @OnClick(R.id.id_btn_design_patterns_command_pattern_draw_shape_normal)
    void onClickDrawShapeNormal() {
        mBrush = new NormalBrush();
    }

    @OnClick(R.id.id_btn_design_patterns_command_pattern_draw_shape_circle)
    void onClickDrawShapeCircle() {
        mBrush = new CircleBrush();
    }

    @OnClick(R.id.id_btn_design_patterns_command_pattern_withdraw)
    void onClickDrawWithDraw() {
        mDcDraw.undo();
        if(!mDcDraw.canUndo()) {
            mBtnWithDraw.setEnabled(false);
        }
        mBtnRedo.setEnabled(true);
    }

    @OnClick(R.id.id_btn_design_patterns_command_pattern_redo)
    void onClickDrawRedo() {
        mDcDraw.redo();
        if(!mDcDraw.canRedo()) {
            mBtnRedo.setEnabled(true);
        }
        mBtnWithDraw.setEnabled(true);
    }

    private class DrawTouchListener implements View.OnTouchListener{

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_DOWN) {
                mPath = new DrawPath();
                mPath.paint = mPaint;
                mPath.path = new Path();
                mBrush.down(mPath.path, event.getX(), event.getY());
            } else if(event.getAction() == MotionEvent.ACTION_MOVE) {
                mBrush.move(mPath.path, event.getX(), event.getY());
            } else if(event.getAction() == MotionEvent.ACTION_UP) {
                mBrush.up(mPath.path, event.getX(), event.getY());
                mDcDraw.add(mPath);
                mDcDraw.isDrawing = true;
                mBtnWithDraw.setEnabled(true);
                mBtnRedo.setEnabled(false);
            }
            return true;
        }
    }
}
