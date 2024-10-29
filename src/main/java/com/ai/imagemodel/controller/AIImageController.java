package com.ai.imagemodel.controller;

import com.ai.imagemodel.service.AiImageService;
import org.springframework.ai.image.ImageResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class AIImageController {

    private final AiImageService aiImageService;

    public AIImageController(AiImageService aiImageService) {
        this.aiImageService = aiImageService;
    }

    @PostMapping("/generate")
    public ImageResponse generate(@RequestBody String description) {
        return aiImageService.generate(description);
    }
}
