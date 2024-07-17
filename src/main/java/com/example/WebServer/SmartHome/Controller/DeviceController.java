package com.example.WebServer.SmartHome.Controller;

import com.example.WebServer.SmartHome.Entity.DeviceEntity;
import com.example.WebServer.SmartHome.Service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/light")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;


    @PostMapping("/send_data")
    public ResponseEntity<Object> receiveMessage(@RequestBody DeviceEntity deviceEntity) {

        System.out.println("Received command: " + deviceEntity.getCommand());
        System.out.println("For device: " + deviceEntity.getDevice());
        // Vi måste spara våran device i databasen för att kunna skicka tillbaka den när användaren öppnar appen
        return deviceService.sendMessageToDevice(deviceEntity);

    }

    // skapa en PostMapping för att bara ta imot DeviceName


    // Här ska vi retunera information
    @GetMapping("/get_data")
    public void getMessage(){

    }
}
