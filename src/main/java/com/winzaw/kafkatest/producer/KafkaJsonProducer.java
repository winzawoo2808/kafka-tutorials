package com.winzaw.kafkatest.producer;

import com.winzaw.kafkatest.payload.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaJsonProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(Student student){
        Message<Student> msg = MessageBuilder
                .withPayload(student)
                        .setHeader(KafkaHeaders.TOPIC, "winzawoo")
                                .build();
        log.info(format("Sending Message to winzawoo topic:: %s", msg));
        kafkaTemplate.send(msg);
    }
}
