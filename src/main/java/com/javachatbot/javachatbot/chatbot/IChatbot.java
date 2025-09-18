package com.javachatbot.javachatbot.chatbot;

import com.javachatbot.javachatbot.DTOs.ChatCompletionDto;

public interface IChatbot {
    ChatCompletionDto CompleteChat(String prompt);
}
