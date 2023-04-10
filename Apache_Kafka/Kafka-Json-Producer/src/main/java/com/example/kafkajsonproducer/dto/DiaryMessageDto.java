package com.example.kafkajsonproducer.dto;

import com.example.kafkajsonproducer.entity.Diary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiaryMessageDto {

    private Long diaryId;
    private String originalContent;
    private Long userSeq;

    public static DiaryMessageDto of(Diary diary) {
        return DiaryMessageDto.builder()
                .diaryId(diary.getId())
                .originalContent(diary.getOriginalContent())
                .userSeq(1L)
                .build();
    }
}
