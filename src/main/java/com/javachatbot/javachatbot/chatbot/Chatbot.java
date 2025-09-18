package com.javachatbot.javachatbot.chatbot;

public class Chatbot {

    private String apiKey;

    public Chatbot(String apiKey) {
        this.apiKey = apiKey;
    }

    public String submitPrompt(String userPrompt) {
        return "You have submitted a prompt successfully. API Key: " + apiKey;
    }
}
