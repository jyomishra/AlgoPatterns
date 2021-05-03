package com.test.design_pattern.command;

import com.test.design_pattern.command.commands.GarageDoorOpenCommand;
import com.test.design_pattern.command.commands.LightOnCommand;
import com.test.design_pattern.command.models.GarageDoor;
import com.test.design_pattern.command.models.Light;

public class RemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        GarageDoor door = new GarageDoor();
        GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(door);
        Light light = new Light();
        LightOnCommand lightOn = new LightOnCommand(light);
        remote.setCommand(lightOn);
        remote.buttonPressed();
        remote.setCommand(garageDoorOpen);
        remote.buttonPressed();
    }
}