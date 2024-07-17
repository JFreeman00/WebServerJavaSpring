package com.example.WebServer.SmartHome.Entity;

/**
 * Class that has the Structure of the JSON
 * Class can take a command and maybe what device
 */
public class DeviceEntity {

    private String command;
    private String device;

    public DeviceEntity() {

    }

    public DeviceEntity(String command) {
        this.command = command;
    }

    //Getters and setters
    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }
}
