package me.yokeyword.sample.demo_design_patterns.command_pattern.ex_draw;

import android.graphics.Path;

/**
 * Created by zhym on 28/05/2017.
 */

public class NormalBrush implements IBrush {
    @Override
    public void down(Path path, float x, float y) {
        path.moveTo(x, y);
    }

    @Override
    public void move(Path path, float x, float y) {
        path.lineTo(x, y);
    }

    @Override
    public void up(Path path, float x, float y) {

    }
}
