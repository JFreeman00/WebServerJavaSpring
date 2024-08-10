package com.example.WebServer.SmartHome.Controller;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Class for publishing messages
// kanske flytta till controller
@Service
public class MqttPublisher {

    @Autowired
    private MqttClient mqttClient;

    public void publish(String topic, String payload){
        try {
            MqttMessage message = new MqttMessage(payload.getBytes());
            message.setQos(2); // Quality of service level 2
            mqttClient.publish(topic, message);
        }
        catch (MqttException e){
            e.printStackTrace();
        }
    }
}
