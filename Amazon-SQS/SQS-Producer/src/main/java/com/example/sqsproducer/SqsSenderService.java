package com.example.sqsproducer;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.example.sqsproducer.dto.DiaryMessageDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SqsSenderService {

    @Value("${cloud.aws.sqs.endpoint}")
    private String url;

    private final ObjectMapper objectMapper;
    private final AmazonSQS amazonSQS;

    public SendMessageResult sendMessage(DiaryMessageDto message) throws JsonProcessingException {
        SendMessageRequest sendMessageRequest = new SendMessageRequest(url, objectMapper.writeValueAsString(message));

        return amazonSQS.sendMessage(sendMessageRequest);
    }
}
