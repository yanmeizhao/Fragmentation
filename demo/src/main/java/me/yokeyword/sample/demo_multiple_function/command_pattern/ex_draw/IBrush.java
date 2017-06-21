package me.yokeyword.sample.demo_multiple_function.command_pattern.ex_draw;

import android.graphics.Path;

/**
 * Created by zhym on 28/05/2017.
 */

public interface IBrush {
    void down(Path path, float x, float y);
    void move(Path path, float x, float y);
    void up(Path path, float x, float y);
}
