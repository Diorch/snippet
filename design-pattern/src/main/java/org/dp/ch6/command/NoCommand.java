package org.dp.ch6.command;

/**
 * @author dechuye
 */
public class NoCommand implements Command{
    @Override
    public void execute() {
        System.out.println(this.getClass().getName());
    }

    @Override
    public void undo() {
        System.out.println("");
    }
}
