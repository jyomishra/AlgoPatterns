package com.test.design_pattern.command.commands;

import com.test.design_pattern.command.models.Light;

public class LightOnCommand implements ICommand {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.on();
    }
}
