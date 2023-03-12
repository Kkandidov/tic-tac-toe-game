package org.astashonok.chatservice.newchat.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChatRoom {

    private String id;
    private String chatId;
    private String senderId;
    private String recipientId;
}
