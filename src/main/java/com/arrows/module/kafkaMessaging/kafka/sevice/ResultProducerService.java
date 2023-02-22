package com.arrows.module.kafkaMessaging.kafka.sevice;

import com.arrows.module.kafkaMessaging.dto.Result;
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
public class ResultProducerService {
    @Autowired
    public KafkaTemplate<String, Result> kafkaTemplate;

    public void sendMessage(Result result){
        if(result.getStatus().equals("PASS")){
            Message<Result> message = MessageBuilder
                    .withPayload(result)
                    .setHeader(KafkaHeaders.TOPIC,"Result-pass")
                    .build();
            kafkaTemplate.send(message);
            log.info("Send pass result : "+result);
        }
        else{
            Message<Result> message = MessageBuilder
                    .withPayload(result)
                    .setHeader(KafkaHeaders.TOPIC,"Result-fail")
                    .build();
            kafkaTemplate.send(message);
            log.info("Send fail result : "+result);
        }

    }
}
