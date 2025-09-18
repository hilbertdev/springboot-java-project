package com.javachatbot.javachatbot.chatbot;

import org.springframework.ai.chat.client.ChatClient;

public class ChatbotService {

private final ChatClient chatClient;

ChatbotService(ChatClient.Builder chatClientBuilder) {
    this.chatClient = chatClientBuilder.build();
}

    String generate() {
        return chatClient
                .prompt("Write a playful haiku about morning coffee following the traditional 5-7-5 syllable structure.")
                .call()
                .content();
    }
}
