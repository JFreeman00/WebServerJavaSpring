package com.example.WebServer.SmartHome.Config;

import com.example.WebServer.SmartHome.Controller.MqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Class that sets up the MQTT connection and handles messages
@Configuration
public class MqttConfig {
    private static final String BROKER_URL = "tcp://localhost:1883";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "jakesmarthome";


    //
    @Bean
    public MqttClient mqttClient() throws Exception {

        String CLIENT_ID = MqttClient.generateClientId();
        MqttClient client = new MqttClient(BROKER_URL, CLIENT_ID);

        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(true);
        options.setUserName(USERNAME);
        options.setPassword(PASSWORD.toCharArray());

        client.connect(options);
        return client;
    }

    @Bean(name = "mqttMessageListener")
    public MqttMessageListener mqttMessageListener (MqttClient mqttClient){
        MqttMessageListener listener = new MqttMessageListener();
        mqttClient.setCallback(listener);

        try {
            mqttClient.subscribe("device/light");
        }
        catch (MqttException e){
            e.printStackTrace();
        }

        return listener;
    }

}
