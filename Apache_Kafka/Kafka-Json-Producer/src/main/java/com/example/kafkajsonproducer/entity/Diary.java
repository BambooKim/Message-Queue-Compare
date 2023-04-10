package com.example.kafkajsonproducer.entity;

import lombok.*;

@Getter
@AllArgsConstructor
@Builder
public class Diary {


    private Long id;
    private User user;
    private String title;
    private String originalContent;
    private String shortContent;
    private Boolean selected;
}
