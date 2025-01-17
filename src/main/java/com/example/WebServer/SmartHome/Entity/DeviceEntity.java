package com.example.WebServer.SmartHome.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity class for the device. Here we set the command, what device, the ip and data for the current device.
 * Used to store the command, device and the ip for the device.
 *
 * @author Jakob Friman Blomdahl
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
