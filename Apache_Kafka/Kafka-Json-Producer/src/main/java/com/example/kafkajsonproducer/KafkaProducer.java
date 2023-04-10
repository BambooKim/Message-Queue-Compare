package com.example.kafkajsonproducer;

import com.example.kafkajsonproducer.dto.DiaryMessageDto;
import com.example.kafkajsonproducer.entity.Diary;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final static String TOPIC = "hello.kafka";
    private final KafkaTemplate<Long, DiaryMessageDto> kafkaTemplate;

    public void pubMessage(Diary diary) {
        DiaryMessageDto message = DiaryMessageDto.of(diary);

        kafkaTemplate.send(TOPIC, message);
    }
}
