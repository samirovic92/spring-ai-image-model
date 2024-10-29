package com.ai.imagemodel.service;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

@Service
public class AiImageService {
    private final OpenAiImageModel imageModel;

    public AiImageService(OpenAiImageModel imageModel) {
        this.imageModel = imageModel;
    }

    public ImageResponse generate(String description) {
        var imagePrompt = new ImagePrompt(
                description,
                OpenAiImageOptions.builder()
                        .withResponseFormat("url")
                        .withQuality("hd")
                        .withN(1)
                        .withHeight(1024)
                        .withWidth(1024).build()
        );
        return this.imageModel.call(imagePrompt);
    }
}
