package com.test.design_pattern.command.commands;

import com.test.design_pattern.command.models.Light;

public class LightOffCommand implements ICommand {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.off();
    }
}
