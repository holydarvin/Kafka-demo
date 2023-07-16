package com.ospo.kafkademo;

import com.ospo.kafkademo.model.SimpleMessage;
import com.ospo.kafkademo.service.SimpleMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.ospo.kafkademo.configuration.KafkaTopicConfiguration.TOPIC_NAME;

@SpringBootApplication
@RequiredArgsConstructor
public class KafkaDemoApplication {

    private final SimpleMessageService service;

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
    }


    @Bean
    CommandLineRunner mockSomethingStreamingService(){
        return args -> {
            while (true){
                SimpleMessage simple = new SimpleMessage(UUID.randomUUID()
                        .toString(), "Event %s".formatted(LocalDateTime.now()));

                service.sendMessage(simple);
                Thread.sleep(3000);
            }

        };
    }
}
