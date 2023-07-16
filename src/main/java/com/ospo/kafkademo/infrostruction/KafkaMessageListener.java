package com.ospo.kafkademo.infrostruction;


import com.ospo.kafkademo.configuration.KafkaTopicConfiguration;
import com.ospo.kafkademo.model.SimpleMessage;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.ospo.kafkademo.configuration.KafkaTopicConfiguration.*;

@Component
@KafkaListener(topics = TOPIC_NAME,

        containerFactory = "kafkaListenerContainerFactory")
public class KafkaMessageListener {

    @KafkaHandler(isDefault = true)
    public void handleSimpleMessage(SimpleMessage message) {
        System.out.println("Received "+message);
    }

    @KafkaHandler
    public void handleAnyMessage(Object message) {
        System.out.println("Received Any"+message);
    }

}
