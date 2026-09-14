package com.example.petstory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Exercises the real MVC, Thymeleaf, and CSRF configuration with a mocked model service.
 */
@SpringBootTest(properties = {
        "azure.openai.endpoint=http://127.0.0.1:1",
        "logging.level.org.springframework.security=INFO"
})
@AutoConfigureMockMvc
class PetControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private StoryService service;

    @Test
    void homeRendersTheExistingFormAndCsrfToken() throws Exception {
        MvcResult result = mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(content().string(containsString("Pet Story Generator")))
                .andExpect(content().string(containsString("id=\"storyForm\"")))
                .andExpect(content().string(containsString("action=\"/generate-story\"")))
                .andExpect(content().string(containsString("name=\"_csrf\"")))
                .andExpect(content().string(containsString("id=\"imageInput\"")))
                .andExpect(content().string(containsString("fetch('/analyze-image'")))
                .andExpect(content().string(containsString("X-CSRF-TOKEN")))
                .andExpect(content().string(not(containsString("@xenova/transformers"))))
                .andExpect(content().string(not(containsString("generateFallbackDescription"))))
                .andReturn();
        CsrfToken csrfToken = (CsrfToken) result.getRequest().getAttribute(CsrfToken.class.getName());
        assertNotNull(csrfToken);
        assertThat(csrfToken.getToken(), not(emptyOrNullString()));
        assertThat(result.getResponse().getContentAsString(),
                containsString("value=\"" + csrfToken.getToken() + "\""));
        verifyNoInteractions(service);
    }

    @Test
    void imageAnalysisAcceptsMultipartAndReturnsDescription() throws Exception {
        byte[] imageBytes = {1, 2, 3};
        when(service.analyzeImage(imageBytes, "image/png")).thenReturn("A playful pet");

        mvc.perform(multipart("/analyze-image")
                        .file(new MockMultipartFile("image", "pet.png", "image/png", imageBytes))
                        .with(csrf().asHeader()))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.description").value("A playful pet"));
        verify(service).analyzeImage(imageBytes, "image/png");
        verify(service, never()).generateStory(anyString());
    }

    @Test
    void imageAnalysisRequiresCsrf() throws Exception {
        mvc.perform(multipart("/analyze-image")
                        .file(new MockMultipartFile("image", "pet.png", "image/png", new byte[]{1})))
                .andExpect(status().isForbidden());
        verifyNoInteractions(service);
    }

    @Test
    void missingImageIsRejected() throws Exception {
        mvc.perform(multipart("/analyze-image").with(csrf().asHeader()))
                .andExpect(status().isBadRequest());
        verifyNoInteractions(service);
    }

    @Test
    void imageValidationErrorsAreReturnedAsBadRequests() throws Exception {
        when(service.analyzeImage(any(byte[].class), anyString()))
                .thenThrow(new IllegalArgumentException("Please select a nonempty image."));

        mvc.perform(multipart("/analyze-image")
                        .file(new MockMultipartFile("image", "empty.png", "image/png", new byte[0]))
                        .with(csrf().asHeader()))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Please select a nonempty image."))
                .andExpect(jsonPath("$.description").doesNotExist());
    }

    @Test
    void imageProviderFailureIsNotReportedAsSuccessfulAnalysis() throws Exception {
        when(service.analyzeImage(any(byte[].class), anyString()))
                .thenThrow(new RuntimeException("Offline provider diagnostics"));

        mvc.perform(multipart("/analyze-image")
                        .file(new MockMultipartFile("image", "pet.png", "image/png", new byte[]{1}))
                        .with(csrf().asHeader()))
                .andExpect(status().isBadGateway())
                .andExpect(jsonPath("$.error").value(containsString("Image analysis failed")))
                .andExpect(jsonPath("$.description").doesNotExist())
                .andExpect(content().string(not(containsString("Offline provider diagnostics"))));
        verify(service, never()).generateStory(anyString());
    }

    @Test
    void storyGenerationRendersTheExistingResultTemplate() throws Exception {
        when(service.generateStory("A playful pet")).thenReturn("A new adventure begins.");

        mvc.perform(post("/generate-story").with(csrf()).param("description", "A playful pet"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("caption", "A playful pet"))
                .andExpect(model().attribute("story", "A new adventure begins."))
                .andExpect(model().attribute("analysisType", "AI-powered analysis"))
                .andExpect(content().string(containsString("A new adventure begins.")));
        verify(service).generateStory("A playful pet");
    }

    @Test
    void storyGenerationRequiresCsrf() throws Exception {
        mvc.perform(post("/generate-story").param("description", "A playful pet"))
                .andExpect(status().isForbidden());
        verifyNoInteractions(service);
    }

    @Test
    void missingDescriptionIsRejected() throws Exception {
        mvc.perform(post("/generate-story").with(csrf()))
                .andExpect(status().isBadRequest());
        verifyNoInteractions(service);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " \t ", "<>\"'&"})
    void emptyDescriptionsRedirectWithoutCallingTheModel(String description) throws Exception {
        mvc.perform(post("/generate-story").with(csrf()).param("description", description))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"))
                .andExpect(flash().attributeExists("error"));
        verifyNoInteractions(service);
    }

    @Test
    void oversizedDescriptionRedirectsWithoutCallingTheModel() throws Exception {
        mvc.perform(post("/generate-story").with(csrf()).param("description", "a".repeat(1001)))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"))
                .andExpect(flash().attribute("error", "Description must be 1000 characters or fewer."));
        verifyNoInteractions(service);
    }

    @Test
    void descriptionAtTheLimitIsAccepted() throws Exception {
        String description = "a".repeat(1000);
        when(service.generateStory(description)).thenReturn("A new adventure begins.");

        mvc.perform(post("/generate-story").with(csrf()).param("description", description))
                .andExpect(status().isOk())
                .andExpect(view().name("result"));
        verify(service).generateStory(description);
    }

    @Test
    void storyProviderFailureIsVisibleInsteadOfReturningAFallbackStory() throws Exception {
        when(service.generateStory(anyString())).thenThrow(new RuntimeException("Offline provider diagnostics"));

        MvcResult failure = mvc.perform(post("/generate-story").with(csrf()).param("description", "A playful pet"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"))
                .andExpect(flash().attributeExists("error"))
                .andExpect(model().attributeDoesNotExist("story"))
                .andReturn();
        mvc.perform(get("/").flashAttrs(failure.getFlashMap()))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("An error occurred while generating your story")))
                .andExpect(content().string(not(containsString("Offline provider diagnostics"))));
    }

    @Test
    void modelOutputIsEscapedByTheResultTemplate() throws Exception {
        when(service.generateStory(anyString())).thenReturn("<script>alert(1)</script>");

        mvc.perform(post("/generate-story").with(csrf()).param("description", "A playful pet"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("&lt;script&gt;")))
                .andExpect(content().string(not(containsString("<script>alert(1)</script>"))));
    }
}