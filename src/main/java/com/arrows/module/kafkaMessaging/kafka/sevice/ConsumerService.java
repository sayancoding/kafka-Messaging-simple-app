package com.arrows.module.kafkaMessaging.kafka.sevice;

import com.arrows.module.kafkaMessaging.Service.ResultProcessor;
import com.arrows.module.kafkaMessaging.dto.Result;
import com.arrows.module.kafkaMessaging.dto.Student;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ConsumerService {

    @Autowired
    public ResultProducerService resultProducerService;
    @Autowired
    public ResultProcessor resultProcessor;

    @KafkaListener(topics = "TestTopic", groupId = "my-group")
    public void consumeFromStudent(Student student){
        log.info("Getting.."+student);
        Result result = resultProcessor.resultGenerator(student);
        resultProducerService.sendMessage(result);
    }
}
