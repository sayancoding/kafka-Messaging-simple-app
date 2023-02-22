package com.arrows.module.kafkaMessaging.controller;

import com.arrows.module.kafkaMessaging.dto.Student;
import com.arrows.module.kafkaMessaging.kafka.sevice.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    public ProducerService producerService;

    @PostMapping
    public String send(@RequestBody Student student){
        producerService.sendMessage(student);
        return "new message has send.";
    }
}
