package com.example.kafkajsonproducer.entity;


import lombok.*;

@Getter
@AllArgsConstructor
@Builder
public class Image {

    private Long id;
    private String sourceUrl;
    private Diary diary;

}

