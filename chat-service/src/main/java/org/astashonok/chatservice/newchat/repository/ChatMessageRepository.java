package org.astashonok.chatservice.newchat.repository;

import org.astashonok.chatservice.newchat.model.ChatMessage;
import org.astashonok.chatservice.newchat.model.MessageStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {

    long countBySenderIdAndRecipientIdAndStatus(String senderId, String recipientId, MessageStatus status);

    List<ChatMessage> findByChatId(String chatId);
}
