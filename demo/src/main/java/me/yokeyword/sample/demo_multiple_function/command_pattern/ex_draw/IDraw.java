package me.yokeyword.sample.demo_multiple_function.command_pattern.ex_draw;

import android.graphics.Canvas;

/**
 * Created by zhym on 28/05/2017.
 */

public interface IDraw {
    void draw(Canvas canvas);
    void undo();
}
