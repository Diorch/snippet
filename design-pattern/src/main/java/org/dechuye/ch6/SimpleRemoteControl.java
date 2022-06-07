package org.dechuye.ch6;

import org.dechuye.ch6.command.Command;

/**
 * @author dechuye
 */
public class SimpleRemoteControl {

    Command slot;

    public SimpleRemoteControl() {
    }

    public void setSlot(Command slot) {
        this.slot = slot;
    }

    public void btnWasPressed() {
        slot.execute();
    }
}
