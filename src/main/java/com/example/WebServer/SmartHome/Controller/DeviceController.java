package com.example.WebServer.SmartHome.Controller;

import com.example.WebServer.SmartHome.DeviceCommand;
import com.example.WebServer.SmartHome.Entity.StatusResponse;
import com.example.WebServer.SmartHome.Service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/light")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @PostMapping("/send_data")
    public ResponseEntity<Object> receiveMessage(@RequestBody DeviceCommand deviceCommand) {

        System.out.println("Received command: " + deviceCommand.getCommand());
        //System.out.println("For device: " + deviceCommand.getDevice());

        // TODO flytta denna check till DeviceService
        if("on".equals(deviceCommand.getCommand())) {
            deviceService.sendMessageToDevice(deviceCommand.getCommand());
            //------------------------------ allt under ska över till DeviceService
            deviceCommand.setCommand("on");
            String response = String.format("Command sent to ESP: %s", deviceCommand.getCommand());
            StatusResponse validResponse = new StatusResponse("success", response);
            return ResponseEntity.ok().body(validResponse);
        }

        else if("off".equals(deviceCommand.getCommand())) {
            deviceService.sendMessageToDevice(deviceCommand.getCommand());
            //---------------------------- allt under ska över till DeviceService
            deviceCommand.setCommand("off");
            String response = String.format("Command sent to ESP: %s", deviceCommand.getCommand());
            StatusResponse validResponse = new StatusResponse("success", response);
            return ResponseEntity.ok().body(validResponse);
        }
        else{
            StatusResponse errorResponse = new StatusResponse("error", "Failed to send command to device");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    // Här ska vi retunera information
    @GetMapping("/get_data")
    public void getMessage(){

    }
}
