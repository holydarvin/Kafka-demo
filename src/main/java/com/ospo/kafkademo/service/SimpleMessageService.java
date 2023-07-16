package com.ospo.kafkademo.service;


import com.ospo.kafkademo.model.SimpleMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static com.ospo.kafkademo.configuration.KafkaTopicConfiguration.TOPIC_NAME;

@Component
public record SimpleMessageService(
        KafkaTemplate<String, SimpleMessage> kafkaTemplate) {


    public void sendMessage(SimpleMessage message) {

        kafkaTemplate.send(TOPIC_NAME, null, message).thenAccept(res ->
                System.out.println(res.getRecordMetadata().hasTimestamp()));
    }
}
