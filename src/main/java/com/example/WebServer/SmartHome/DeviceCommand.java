package com.example.WebServer.SmartHome;

/**
 * Class that has the Structure of the JSON
 * Class can take a command and maybe what device
 */
public class DeviceCommand {

    private String command;
    private String device;

    public DeviceCommand() {

    }

    public DeviceCommand(String command) {
        this.command = command;
    }

    //Getters and setters
    public String getCommand() {
        return command; // This returns
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
