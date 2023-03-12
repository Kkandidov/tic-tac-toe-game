package org.astashonok.chatservice.newchat.controller;

import lombok.RequiredArgsConstructor;
import org.astashonok.chatservice.newchat.model.ChatMessage;
import org.astashonok.chatservice.newchat.service.ChatMessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AppController {

    private final ChatMessageService chatMessageService;

    @PostMapping("/post")
    public void post(@RequestBody ChatMessage message) {
        chatMessageService.save(message);
        System.out.println(message);
    }
}
