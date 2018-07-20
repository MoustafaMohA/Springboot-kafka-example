package com.kafka.demo.services;

import com.kafka.demo.messages_handler.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ProducerService {

    @Autowired
    private MessageProducer messageProducer;

    @Value("${kafka.topic.topic_name}")
    private String topic;

    @Scheduled(fixedRate = 2000)
    public void sendMessages( ) {
        System.out.println("SENDMESSAGE()");
        messageProducer.produceMessage(topic, "THIS IS A SERVICE");
    }
}
