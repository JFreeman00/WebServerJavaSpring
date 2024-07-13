package com.example.WebServer.SmartHome.Service;

import com.example.WebServer.SmartHome.Controller.DeviceController;
import com.example.WebServer.SmartHome.DeviceCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeviceService {

    // Default port for Http for ESP is 80
    // We use 1337 that's why we need to specify the port number in the URL
    // http://192.168.0.97 for ESP
    private final String ESP_URL = "http://192.168.0.97:1337";
    private final DeviceController deviceController;

    public DeviceService(DeviceController deviceController) {
        this.deviceController = deviceController;
    }


    public void sendMessageToDevice(String command) {

        // Lägga till checken för om det ör on eller off
        //checkMessage(command);

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Det vi ska skicka (Payload)
        String jsonBody = "{\"command\": \"" + command + "\"}";

        HttpEntity<String> requestEntity = new HttpEntity<>(jsonBody, headers);

        String URL = ESP_URL + "/process_data";

        // Here we try to send the payload to the esp
        try {
            ResponseEntity<String> response = restTemplate.exchange(URL,HttpMethod.POST, requestEntity, String.class);
            System.out.println("Response: " + response.getStatusCode());
            System.out.println("Response body: " + response.getBody());
        }
        catch (Exception e) {
            System.err.println("Error sending command to ESP32: " + e.getMessage());
        }

    }

    public String checkMessage(String command) {

        if("on".equals(command)) {
            DeviceCommand deviceCommand = new DeviceCommand();
        }

        return "";
    }
}
