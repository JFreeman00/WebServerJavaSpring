package com.example.WebServer.SmartHome.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that has the Structure of the JSON
 * Class can take a command and maybe what device
 */
public class DeviceEntity {

    private String command;
    private String device;
    private String ip;

    public DeviceEntity() {

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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}
