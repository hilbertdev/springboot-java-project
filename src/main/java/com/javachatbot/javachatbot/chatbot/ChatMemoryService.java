package com.javachatbot.javachatbot.chatbot;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatMemoryService {

    private boolean memoryEnabled = false;
    private final List<String> history = new ArrayList<>();

    public void enableMemory(boolean enabled) {
        this.memoryEnabled = enabled;
        if (!enabled) {
            history.clear(); 
        }
    }

    public boolean isMemoryEnabled() {
        return memoryEnabled;
    }

    public void addMessage(String message, String response) {
        if (memoryEnabled) {
            history.add("User: " + message);
            history.add("AI: " + response);
        }
    }

    public String getContext() {
        if (!memoryEnabled)
            return "";
        return String.join("\n", history);
    }
}
