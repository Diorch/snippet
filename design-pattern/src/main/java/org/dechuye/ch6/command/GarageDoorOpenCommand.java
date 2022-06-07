package org.dechuye.ch6.command;

import lombok.Setter;
import org.dechuye.ch6.appliance.GarageDoor;

/**
 * @author dechuye
 */
@Setter
public class GarageDoorOpenCommand implements Command{

    GarageDoor garageDoor;

    public GarageDoorOpenCommand() {
    }

    @Override
    public void execute() {
       garageDoor.up();
    }

    @Override
    public void undo() {
        garageDoor.down();
    }
}
