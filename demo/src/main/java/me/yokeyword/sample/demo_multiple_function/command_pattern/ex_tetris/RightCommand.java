package me.yokeyword.sample.demo_multiple_function.command_pattern.ex_tetris;


/**
 * Created by zhym on 30/05/2017.
 */

public class RightCommand implements Command {
    private TetrisMachine machine;

    public RightCommand(TetrisMachine machine) {
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.toRight();
    }
}
