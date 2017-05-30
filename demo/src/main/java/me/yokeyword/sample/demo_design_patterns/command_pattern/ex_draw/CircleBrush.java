package me.yokeyword.sample.demo_design_patterns.command_pattern.ex_draw;

import android.graphics.Path;

/**
 * Created by zhym on 28/05/2017.
 */

public class CircleBrush implements IBrush {
    @Override
    public void down(Path path, float x, float y) {
    }

    @Override
    public void move(Path path, float x, float y) {
        path.addCircle(x, y, 10, Path.Direction.CW);
    }

    @Override
    public void up(Path path, float x, float y) {

    }
}
