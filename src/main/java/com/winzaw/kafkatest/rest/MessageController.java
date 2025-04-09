package com.winzaw.kafkatest.rest;


import com.winzaw.kafkatest.payload.Student;
import com.winzaw.kafkatest.producer.KafkaJsonProducer;
import com.winzaw.kafkatest.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

    public final KafkaProducer kafkaProducer;

    public final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message queued successfully");
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Student student){
        kafkaJsonProducer.sendMessage(student);
        return ResponseEntity.ok("Message queued successfully");
    }
}
