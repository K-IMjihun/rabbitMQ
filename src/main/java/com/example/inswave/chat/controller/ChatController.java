package com.example.inswave.chat.controller;

import com.example.inswave.chat.model.ChatRoom;
import com.example.inswave.chat.dto.ChatMessage;
import com.example.inswave.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;
    private final SimpMessageSendingOperations messagingTemplate;

    // REST API 엔드포인트 - 채팅방 생성
    @PostMapping
    public ChatRoom createRoom(@RequestBody String name) {
        return chatService.createRoom(name);
    }

    // REST API 엔드포인트 - 전체 채팅방 조회
    @GetMapping
    public List<ChatRoom> findAllRoom() {
        return chatService.findAllRoom();
    }

    // WebSocket 메시지 핸들링
    @MessageMapping("/chat-sendMessage")
    public void sendMessage(@Payload ChatMessage chatMessage) {
        log.info("test");
        log.info("Received message: {}", chatMessage);
        chatService.sendMessage(chatMessage);
    }
}