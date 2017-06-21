package me.yokeyword.sample.demo_multiple_function.command_pattern.ex_draw;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by zhym on 28/05/2017.
 */

public class DrawPath implements IDraw {
    // 需要绘制的路径
    public Path path;
    // 绘制画笔
    public Paint paint;

    @Override
    public void draw(Canvas canvas) {
        canvas.drawPath(path, paint);
    }

    @Override
    public void undo() {

    }
}
