package org.dp.ch6;

import org.dp.ch6.command.Command;

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
