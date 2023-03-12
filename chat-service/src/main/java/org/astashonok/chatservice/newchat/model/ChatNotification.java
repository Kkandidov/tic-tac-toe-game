package org.astashonok.chatservice.newchat.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChatNotification {

    private String id;
    private String senderId;
    private String senderName;
}
