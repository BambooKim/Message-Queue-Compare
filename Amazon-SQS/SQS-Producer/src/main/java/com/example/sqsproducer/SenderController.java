package com.example.sqsproducer;


import com.example.sqsproducer.dto.DiaryMessageDto;
import com.example.sqsproducer.dto.DiaryRequestDto;
import com.example.sqsproducer.entity.Diary;
import com.fasterxml.jackson.core.JsonProcessingException;
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
public class SenderController {

    private final SqsSenderService senderService;

    @PostMapping("/send")
    public ResponseEntity<?> publishMessage(@RequestBody DiaryRequestDto.CreateRequest requestDto) {
        Diary diary = Diary.builder()
                .id(1L)
                .title(requestDto.getTitle())
                .originalContent(requestDto.getContent())
                .shortContent("")
                .selected(false)
                .build();

        try {
            senderService.sendMessage(DiaryMessageDto.of(diary));
        } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Json Processing Exception");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Send Success");
    }
}
