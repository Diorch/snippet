package org.dp.ch6;

import org.dp.ch6.appliance.Light;
import org.dp.ch6.command.LightOnCommand;

/**
 * @author dechuye
 */
public class RemoteControlTest {


    public static void main(String[] args) {

        final SimpleRemoteControl remote = new SimpleRemoteControl();
        final LightOnCommand command = new LightOnCommand(new Light());

        remote.setSlot(command);
        remote.btnWasPressed();
    }
}
