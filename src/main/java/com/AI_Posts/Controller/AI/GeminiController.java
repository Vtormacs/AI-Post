package com.AI_Posts.Controller.AI;

import com.AI_Posts.Service.AI.GeminiService;
import org.springframework.web.bind.annotation.*;

@RestController
public class GeminiController {

    private final GeminiService geminiService;

    public GeminiController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @GetMapping("/generate")
    public String generateContent() {
        return geminiService.generateContent();
    }

    @GetMapping("/validate")
    public String validateInput(@RequestParam String userInput) {
        return geminiService.validadeAI(userInput);
    }
}
