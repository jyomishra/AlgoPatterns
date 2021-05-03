package com.test.design_pattern.command;

import com.test.design_pattern.command.commands.ICommand;

public class SimpleRemoteControl {

    ICommand command;

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void buttonPressed() {
        command.execute();
    }

}
