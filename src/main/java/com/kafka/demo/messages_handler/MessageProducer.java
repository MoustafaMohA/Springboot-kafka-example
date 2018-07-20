package com.kafka.demo.messages_handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public void produceMessage(String topic, String payload) {
        kafkaTemplate.send(topic, payload);
    }
}
