package com.microsoft.mcp.sample.client;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;

import com.openai.client.OpenAIClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LangChain4jClientTest {

    @ParameterizedTest
    @ValueSource(strings = {"https://example.openai.azure.com", "https://example.openai.azure.com/",
        "https://example.openai.azure.com/openai/v1", "https://example.openai.azure.com/openai/v1/"})
    void normalizesResourceAndV1Endpoints(String endpoint) {
        assertThat(LangChain4jClient.openAiBaseUrl(endpoint)).isEqualTo("https://example.openai.azure.com/openai/v1/");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "not-a-url", "https://example.com/other", "https://example.com/?key=value"})
    void rejectsInvalidEndpoints(String endpoint) {
        assertThrows(IllegalArgumentException.class, () -> LangChain4jClient.openAiBaseUrl(endpoint));
    }

    @Test
    void defaultsToLunaWithoutReasoningAndSupportsOverrides() {
        var client = mock(OpenAIClient.class);
        var defaults = LangChain4jClient.createModel(client, Map.of()).defaultRequestParameters();
        assertThat(defaults.modelName()).isEqualTo("gpt-5.6-luna");
        assertThat(defaults.reasoningEffort()).isEqualTo("none");
        assertThat(defaults.maxCompletionTokens()).isEqualTo(1024);
        var overrides = LangChain4jClient.createModel(client,
            Map.of("AZURE_OPENAI_DEPLOYMENT", "custom-deployment", "AZURE_OPENAI_MAX_COMPLETION_TOKENS", "512"))
            .defaultRequestParameters();
        assertThat(overrides.modelName()).isEqualTo("custom-deployment");
        assertThat(overrides.maxCompletionTokens()).isEqualTo(512);
        assertThat(overrides.reasoningEffort()).isEqualTo("none");
        assertThrows(IllegalArgumentException.class, () -> LangChain4jClient.createModel(client,
            Map.of("AZURE_OPENAI_MAX_COMPLETION_TOKENS", "0")));
        assertThrows(IllegalArgumentException.class, () -> LangChain4jClient.createModel(client,
            Map.of("AZURE_OPENAI_DEPLOYMENT", " ")));
    }

    @Test
    void defaultsAndPromptOptionsMatchBothEntrypoints() {
        assertThat(LangChain4jClient.parseOptions(new String[0], false).prompts())
            .containsExactlyElementsOf(LangChain4jClient.DEMO_PROMPTS);
        assertThat(LangChain4jClient.parseOptions(new String[0], true).interactive()).isTrue();
        for (boolean interactiveByDefault : new boolean[] {false, true}) {
            var options = LangChain4jClient.parseOptions(new String[] {"--prompt", "Add 5 and 3"}, interactiveByDefault);
            assertThat(options.interactive()).isFalse();
            assertThat(options.prompts()).containsExactly("Add 5 and 3");
        }
        assertThrows(IllegalArgumentException.class,
            () -> LangChain4jClient.parseOptions(new String[] {"--prompt"}, false));
        assertThrows(IllegalArgumentException.class,
            () -> LangChain4jClient.parseOptions(new String[] {"--prompt", " "}, true));
        assertThrows(IllegalArgumentException.class,
            () -> LangChain4jClient.parseOptions(new String[] {"--unknown"}, false));
    }

    @ParameterizedTest
    @ValueSource(strings = {"\nAdd 5 and 3\nquit\nignored\n", "Add 5 and 3\nEXIT\nignored\n", "Add 5 and 3\n"})
    void interactiveBotHandlesBlankLinesQuitAndEof(String input) throws Exception {
        var prompts = new ArrayList<String>();
        Bot bot = prompt -> {
            prompts.add(prompt);
            return "8";
        };
        var buffer = new ByteArrayOutputStream();
        try (var reader = new BufferedReader(new StringReader(input));
             var output = new PrintStream(buffer, true, StandardCharsets.UTF_8)) {
            LangChain4jClient.runConversation(bot, LangChain4jClient.parseOptions(new String[0], true), reader, output);
        }
        assertThat(prompts).containsExactly("Add 5 and 3");
        assertThat(buffer.toString(StandardCharsets.UTF_8)).contains("AI: 8").doesNotContain("ignored");
    }

    @Test
    void promptModeDoesNotReadInputAndPropagatesErrors() throws Exception {
        var options = LangChain4jClient.parseOptions(new String[] {"--prompt", "Add 5 and 3"}, true);
        var reader = mock(BufferedReader.class);
        var prompts = new ArrayList<String>();
        LangChain4jClient.runConversation(prompt -> {
            prompts.add(prompt);
            return "8";
        }, options, reader, System.out);
        assertThat(prompts).containsExactly("Add 5 and 3");
        org.mockito.Mockito.verifyNoInteractions(reader);
        assertThrows(IllegalStateException.class, () -> LangChain4jClient.runConversation(prompt -> {
            throw new IllegalStateException("model unavailable");
        }, options, reader, System.out));
        assertThrows(IllegalStateException.class,
            () -> LangChain4jClient.runConversation(prompt -> "", options, reader, System.out));
    }
}