package org.dp.ch6.command;

/**
 * @author dechuye
 */
public interface Command {

    void execute();

    void undo();
}
