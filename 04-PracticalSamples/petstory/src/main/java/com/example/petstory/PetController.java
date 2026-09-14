package com.example.petstory;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.constraints.NotNull;

/**
 * Web controller that handles HTTP requests for the Pet Story Generator application.
 * Manages the web interface for story generation, input validation, error handling,
 * and image uploads for the AI service.
 */
@Controller
public class PetController {

    private static final Logger logger = LoggerFactory.getLogger(PetController.class);
    
    private final StoryService storyService;

    public PetController(StoryService storyService) {
        this.storyService = storyService;
    }

    @GetMapping("/")
    public String index() {
        logger.info("Accessing index page");
        return "index";
    }

    /**
     * Analyzes a multipart image and returns a description or an explicit error.
     */
    @PostMapping(value = "/analyze-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Map<String, String>> analyzeImage(@RequestParam("image") MultipartFile image) {
        try {
            String description = storyService.analyzeImage(image.getBytes(), image.getContentType());
            return ResponseEntity.ok(Map.of("description", description));
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.badRequest().body(Map.of("error", exception.getMessage()));
        } catch (Exception exception) {
            logger.error("Error analyzing uploaded image", exception);
            return ResponseEntity.status(502).body(Map.of("error",
                    "Image analysis failed. Check the Azure endpoint, deployment, and sign-in, then try again."));
        }
    }

    @PostMapping("/generate-story")
    public String generateStory(@RequestParam("description") @NotNull String description, 
                             Model model, 
                             RedirectAttributes redirectAttributes) {
        
        logger.info("Received story generation request with description length: {}", description.length());
        
        try {
            // Validate description
            if (description.trim().isEmpty()) {
                logger.warn("Empty description provided");
                redirectAttributes.addFlashAttribute("error", "Please provide a description of your pet.");
                return "redirect:/";
            }
            
            if (description.length() > 1000) {
                logger.warn("Description too long: {} characters", description.length());
                redirectAttributes.addFlashAttribute("error", "Description must be 1000 characters or fewer.");
                return "redirect:/";
            }
            
            // Sanitize description before generating story
            String sanitizedDescription = sanitizeInput(description);
            
            if (sanitizedDescription.isBlank()) {
                redirectAttributes.addFlashAttribute("error", "Please provide a description of your pet.");
                return "redirect:/";
            }

            String story = storyService.generateStory(sanitizedDescription);
            logger.info("Generated story using AI service of length: {}", story.length());
            
            // Add results to model
            model.addAttribute("caption", sanitizedDescription);
            model.addAttribute("story", story);
            model.addAttribute("analysisType", "AI-powered analysis");
            
            return "result";
            
        } catch (Exception e) {
            logger.error("Error generating story", e);
            redirectAttributes.addFlashAttribute("error", "An error occurred while generating your story. Please try again.");
            return "redirect:/";
        }
    }
    
    /**
     * Sanitize input to prevent injection attacks
     */
    private String sanitizeInput(String input) {
        if (input == null) {
            return "";
        }
        // Remove potentially dangerous characters and limit length
        String sanitized = input.replaceAll("[<>\"'&]", "").trim();
        return sanitized.substring(0, Math.min(sanitized.length(), 1000));
    }
    
}
