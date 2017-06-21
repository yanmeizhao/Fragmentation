package me.yokeyword.sample.demo_multiple_function.command_pattern.ex_tetris;


/**
 * Created by zhym on 30/05/2017.
 */

public class FallCommand implements Command {
    private TetrisMachine machine;

    public FallCommand(TetrisMachine machine) {
        this.machine = machine;
    }

    @Override
    public void execute() {
        machine.fastToBottom();
    }
}
