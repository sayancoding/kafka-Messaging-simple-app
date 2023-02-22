package com.arrows.module.kafkaMessaging.Service;

import com.arrows.module.kafkaMessaging.dto.Result;
import com.arrows.module.kafkaMessaging.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class ResultProcessor {

    public Result resultGenerator(Student student){
        Result result = new Result();

        result.setName(student.getName());
        result.setMark(student.getMark());

        if(student.getMark() > 65){
            result.setStatus("PASS");
        }else{
            result.setStatus("FAIL");
        }
        return result;
    }
}
