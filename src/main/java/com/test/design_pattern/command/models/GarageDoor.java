package com.test.design_pattern.command.models;

public class GarageDoor {

    private boolean doorOpen;

    public void open() {
        doorOpen = true;
        System.out.println("Opening the door");
    }

}
