package com.kafka.demo.messages_handler;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;


@Service
public class MessageConsumer {

    @KafkaListener(topics = "${kafka.topic.topic_name}")
    public void receive(@Payload String payload,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) String partition,
                        @Header(KafkaHeaders.RECEIVED_TOPIC) String topic )
    {
        System.out.printf("Rec msg %s in partition %s and in topic %s \n", payload, partition, topic);
    }
}
