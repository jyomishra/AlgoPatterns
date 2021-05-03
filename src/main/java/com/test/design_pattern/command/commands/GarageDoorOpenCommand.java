package com.test.design_pattern.command.commands;

import com.test.design_pattern.command.models.GarageDoor;

public class GarageDoorOpenCommand implements ICommand {

    GarageDoor door;

    public GarageDoorOpenCommand(GarageDoor door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.open();
    }

}
