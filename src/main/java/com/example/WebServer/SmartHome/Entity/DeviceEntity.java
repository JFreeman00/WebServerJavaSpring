package com.example.WebServer.SmartHome.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that has the Structure of the JSON
 * Class can take a command and what device
 */
public class DeviceEntity {

    private String command;
    private String device;
    private String ip;

    private LocalDate date;

    public DeviceEntity() {

    }

    public DeviceEntity(String command, String device, String ip, LocalDate date) {
        this.command = command;
        this.device = device;
        this.ip = ip;
        this.date = date;
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

    @Override
    public String toString() {
        return "DeviceEntity{" +
                "command='" + command + '\'' +
                ", device='" + device + '\'' +
                ", ip='" + ip + '\'' +
                ", date=" + date +
                '}';
    }
}
