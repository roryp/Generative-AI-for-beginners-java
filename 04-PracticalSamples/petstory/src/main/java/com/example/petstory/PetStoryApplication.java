package com.example.petstory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the Pet Story Generator.
 * This Spring Boot application creates personalized pet stories
 * provides a web interface for users to generate
 * creative stories about their pets.
 */
@SpringBootApplication
public class PetStoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetStoryApplication.class, args);
    }
}
