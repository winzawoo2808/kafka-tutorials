package com.winzaw.kafkatest.payload;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student {

    private String id;
    private String firstName;
    private String lastName;

}
