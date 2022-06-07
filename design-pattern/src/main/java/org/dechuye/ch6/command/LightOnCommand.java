package org.dechuye.ch6.command;

import lombok.extern.slf4j.Slf4j;
import org.dechuye.ch6.appliance.Light;

/**
 * @author dechuye
 */
@Slf4j
public class LightOnCommand implements Command {

    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
