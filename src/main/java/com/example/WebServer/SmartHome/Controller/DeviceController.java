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

    // ResponseEntity<Object>
    @PostMapping("/send_data")
    public ResponseEntity<Object> receiveMessage(@RequestBody DeviceCommand deviceCommand) {

        System.out.println("Received command: " + deviceCommand.getCommand());
        //System.out.println("For device: " + deviceCommand.getDevice());
        return deviceService.sendMessageToDevice(deviceCommand);

    }

    // Här ska vi retunera information
    @GetMapping("/get_data")
    public void getMessage(){

    }
}
