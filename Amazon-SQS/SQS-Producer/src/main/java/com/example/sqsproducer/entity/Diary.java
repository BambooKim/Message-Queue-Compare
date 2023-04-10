package com.example.sqsproducer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Diary {


    private Long id;
    private String title;
    private String originalContent;
    private String shortContent;
    private Boolean selected;
}
