package com.javachatbot.javachatbot.chatbot.UI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UiController {

    @GetMapping("/chat")
    public String chatPage() {
        return "chat"; 
    }
}
