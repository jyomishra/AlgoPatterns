package com.test.design_pattern.command.control;

import com.test.design_pattern.command.commands.ICommand;
import com.test.design_pattern.command.commands.NoCommand;

public class RemoteControl {
    ICommand[] onCommands;
    ICommand[] offCommands;

    public RemoteControl() {
        onCommands = new ICommand[7];
        offCommands = new ICommand[7];
        ICommand noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }
}
