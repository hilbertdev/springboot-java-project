package com.javachatbot.javachatbot.chatbot;

import java.util.Map;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class ChatController {

    private final ChatModel chatModel;
    private final ChatMemoryService memoryService;

    @Autowired
    public ChatController(ChatModel chatModel, ChatMemoryService memoryService) {
        this.chatModel = chatModel;
        this.memoryService = memoryService;
    }

      @GetMapping("/ai/generate")
    public Map<String, String> generate(
            @RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {

        String fullPrompt = memoryService.isMemoryEnabled()
                ? memoryService.getContext() + "\nUser: " + message
                : message;

        String response = chatModel.call(fullPrompt);

        memoryService.addMessage(message, response);

        return Map.of("generation", response);
    }

    @PostMapping("/ai/memory")
    public void toggleMemory(@RequestParam boolean enable) {
        memoryService.enableMemory(enable);
    }

    @GetMapping("/ai/generateStream")
    public Flux<ChatResponse> generateStream(
            @RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        Prompt prompt = new Prompt(message);
        return this.chatModel.stream(prompt);
    }
}
