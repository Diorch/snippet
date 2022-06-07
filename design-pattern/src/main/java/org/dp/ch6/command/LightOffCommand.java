package org.dp.ch6.command;

import lombok.Setter;
import org.dp.ch6.appliance.Light;

/**
 * @author dechuye
 */
@Setter
public class LightOffCommand implements Command{

    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public LightOffCommand() {
    }

    @Override
    public void execute() {
       light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
