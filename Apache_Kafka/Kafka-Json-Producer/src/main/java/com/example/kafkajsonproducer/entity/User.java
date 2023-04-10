package com.example.kafkajsonproducer.entity;


import lombok.*;

@Getter
@AllArgsConstructor
@Builder
public class User {

    private Long seq;
    private String userId;
    private String username;
    private String password;
}

