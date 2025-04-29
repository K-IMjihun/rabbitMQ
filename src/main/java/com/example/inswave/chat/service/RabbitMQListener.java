package com.example.inswave.chat.service;

import com.example.inswave.chat.dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RabbitMQListener {

    private final SimpMessageSendingOperations messagingTemplate;

    @RabbitListener(queues = "chat.queue")
    public void receiveMessage(ChatMessage message) {
        log.info("Received message from RabbitMQ: {}", message);
        messagingTemplate.convertAndSend("/topic/chat." + message.getRoomId(), message);
    }
}