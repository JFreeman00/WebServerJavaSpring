package com.example.WebServer.SmartHome.Controller;

import com.example.WebServer.SmartHome.Entity.DeviceEntity;
import com.example.WebServer.SmartHome.Service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The controller class for the Device. Here we receive the http request and then sends that information over to
 * {@link DeviceService}.
 *
 * @author Jakob Friman Blomdahl
 */


@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    // Vi sparar command, device och ip
    List<DeviceEntity> devices = new ArrayList<>();

    @PostMapping("/send_data")
    public ResponseEntity<Object> receiveMessage(@RequestBody DeviceEntity deviceEntity) {

        System.out.println("Received command: " + deviceEntity.getCommand());
        System.out.println("For device: " + deviceEntity.getDevice());

        // Vi måste spara våran device i databasen för att kunna skicka tillbaka den när användaren öppnar appen
        return deviceService.sendMessageToDevice(deviceEntity);

    }

    // Kommer från esp då den startas
    @PostMapping("/availableDevice")
    public ResponseEntity<String> registerDevice (@RequestBody DeviceEntity deviceEntity) {

        System.out.println(deviceEntity.getDevice());
        System.out.println(deviceEntity.getIp());

        devices.add(deviceEntity);
        return ResponseEntity.ok("Device registered successfully");
    }

    // Retunerar alla enheter
    @GetMapping("/get_local_device")
    public List<DeviceEntity> getDevice() {
        return devices;
    }

    // Här ska vi retunera information från databasen
    @GetMapping("/get_data")
    public List<Object> getMessage(){
        return List.of("No data found");
    }

}
