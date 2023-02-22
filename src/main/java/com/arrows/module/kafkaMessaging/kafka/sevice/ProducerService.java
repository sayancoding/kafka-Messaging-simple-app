package com.arrows.module.kafkaMessaging.kafka.sevice;

import com.arrows.module.kafkaMessaging.dto.Student;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProducerService {

    @Autowired
    public KafkaTemplate<String, Student> kafkaTemplate;

    public void sendMessage(Student student){
        Message<Student> message = MessageBuilder
                .withPayload(student)
                .setHeader(KafkaHeaders.TOPIC,"TestTopic")
                .build();
        kafkaTemplate.send(message);
        log.info("Send Student : "+student);
    }
}
