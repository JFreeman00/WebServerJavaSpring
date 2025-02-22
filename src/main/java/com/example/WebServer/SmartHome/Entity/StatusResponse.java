package com.example.WebServer.SmartHome.Entity;

/**
 * Class for Http responses.
 *
 * @author Jakob Friman Blomdahl
 */

public class StatusResponse {

    private String status;
    private String message;

    public StatusResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
