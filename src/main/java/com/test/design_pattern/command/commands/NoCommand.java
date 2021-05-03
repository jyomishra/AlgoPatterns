package com.test.design_pattern.command.commands;

public class NoCommand implements ICommand {

    @Override
    public void execute() {
        System.out.println("No execution");
    }

}
