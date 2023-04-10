package com.example.kafkajsonproducer;

import com.example.kafkajsonproducer.dto.DiaryRequestDto;
import com.example.kafkajsonproducer.entity.Diary;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RequiredArgsConstructor
@RestController
public class ProducerController {

    private final KafkaProducer kafkaProducer;

    @PostMapping("/publish")
    public ResponseEntity<?> publishMessage(@RequestBody DiaryRequestDto.CreateRequest requestDto) {
        Diary diary = Diary.builder()
                .id(1L)
                .title(requestDto.getTitle())
                .originalContent(requestDto.getContent())
                .shortContent("")
                .selected(false)
                .build();

        kafkaProducer.pubMessage(diary);

        return ResponseEntity.status(HttpStatus.OK).body("Published");
    }
}
