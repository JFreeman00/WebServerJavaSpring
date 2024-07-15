package com.example.WebServer.SmartHome.Service;

import com.example.WebServer.SmartHome.Controller.DeviceController;
import com.example.WebServer.SmartHome.DeviceCommand;
import com.example.WebServer.SmartHome.Entity.StatusResponse;
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
    //private final DeviceController deviceController;

    /*public DeviceService(DeviceController deviceController) {
        this.deviceController = deviceController;
    }

     */

    public ResponseEntity<Object> sendMessageToDevice(DeviceCommand deviceCommand) {

        ResponseEntity<Object> responseCheckMessage = checkMessage(deviceCommand);

        if(responseCheckMessage.getStatusCode() == HttpStatus.OK) {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // Det vi ska skicka (Payload) så här måste vi skicka en string
            String jsonBody = "{\"command\": \"" + deviceCommand.getCommand() + "\"}";

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
            return new ResponseEntity<>(new StatusResponse("success", "Command sent to ESP"), HttpStatus.OK);
        }

        return responseCheckMessage;
    }

    public ResponseEntity<Object> checkMessage(DeviceCommand deviceCommand) {

        // Kommer nog aldrig att vara denna
        if(deviceCommand.getCommand() == null || deviceCommand.getCommand().isEmpty()) {
            return new ResponseEntity<>("Command is missing", HttpStatus.BAD_REQUEST);
        }

        if("on".equals(deviceCommand.getCommand())) {
            deviceCommand.setCommand("on");
            return new ResponseEntity<>("Command is valid", HttpStatus.OK);

            //String response = String.format("Command sent to ESP: %s", deviceCommand.getCommand());
            //StatusResponse validResponse = new StatusResponse("success", response);
            //return ResponseEntity.ok().body(validResponse);

        } else if ("off".equals(deviceCommand.getCommand())) {
            deviceCommand.setCommand("off");
            return new ResponseEntity<>("Command is valid", HttpStatus.OK);

            //String response = String.format("Command sent to ESP: %s", deviceCommand.getCommand());
            //StatusResponse validResponse = new StatusResponse("success", response);
            //return ResponseEntity.ok().body(validResponse);
        }

        else{
            //StatusResponse errorResponse = new StatusResponse("error", "Failed to send command to device");
            //return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
            return new ResponseEntity<>(new StatusResponse("error", "Failed to send command to device"), HttpStatus.BAD_REQUEST);
        }
    }
}
