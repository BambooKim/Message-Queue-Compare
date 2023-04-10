package com.example.kafkajsonproducer.dto;


import lombok.*;

public class DiaryRequestDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    public static class CreateRequest {

        private String title;

        private String content;

    }
}
