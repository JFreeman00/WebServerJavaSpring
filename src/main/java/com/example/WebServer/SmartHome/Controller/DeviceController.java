package com.example.WebServer.SmartHome.Controller;

import com.example.WebServer.SmartHome.Entity.DeviceEntity;
import com.example.WebServer.SmartHome.Service.DeviceService;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @Autowired
    private MqttClient mqttClient;

    // Vi sparar command, device och ip
    List<DeviceEntity> devices = new ArrayList<>(); // Lista för att samla all enheter i

    // ska ändra till MQTT protocol  instället. I denna ska vi kalla på controlDevice
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

    @GetMapping("/{device}/{state}")
    public String controlDevice(@PathVariable String device, @PathVariable String state){

        String topic = "zigbee2mqtt/" + device + "/set";
        String payload = "{\"state\": \"" + state.toUpperCase() + "\"}";

        try{
            MqttMessage message = new MqttMessage(payload.getBytes());
             mqttClient.publish(topic,message);
            return "Sent command to " + device + " to turn " + state.toUpperCase();
        }
        catch (Exception e){
            return "Error sending command: " + e.getMessage();
        }
    }

}
