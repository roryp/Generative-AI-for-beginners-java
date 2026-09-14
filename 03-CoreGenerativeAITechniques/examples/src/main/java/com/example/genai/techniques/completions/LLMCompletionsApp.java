package com.example.genai.techniques.completions;

import com.example.genai.techniques.AzureOpenAIConfig;
import com.example.genai.techniques.ChatResponses;
import com.openai.client.OpenAIClient;
import com.openai.models.chat.completions.ChatCompletionMessageParam;
import com.openai.models.chat.completions.ChatCompletionSystemMessageParam;
import com.openai.models.chat.completions.ChatCompletionUserMessageParam;
import com.openai.models.chat.completions.ChatCompletionAssistantMessageParam;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Simple completions, multi-turn conversations, and bounded interactive chat history. */
public class LLMCompletionsApp {
    /** Runs all three demonstrations; type exit or end standard input to finish. */
    public static void main(String[] args) {
        var config = AzureOpenAIConfig.fromEnvironment();
        OpenAIClient client = config.createClient();
        try (Scanner scanner = new Scanner(System.in)) {
            runExamples(client, config, scanner, System.out);
        } finally {
            client.close();
        }
    }

    static void runExamples(OpenAIClient client, AzureOpenAIConfig config, Scanner scanner, PrintStream output) {
        output.println("\n=== Simple Completion ===");
        var simple = config.chatOptions(200)
                .addSystemMessage("You are a concise Java expert who explains concepts clearly and practically.")
            .addUserMessage("Explain Java streams in under 80 words, including one short example.")
                .build();
        output.println("AI: " + ChatResponses.text(client.chat().completions().create(simple)));

        output.println("\n=== Multi-turn Conversation ===");
        var conversation = config.chatOptions(300)
            .addSystemMessage("You are a helpful Java tutor. Answer each question in under 100 words, "
                + "including at most one short code example.")
                .addUserMessage("What is a HashMap in Java?");
        var firstResponse = client.chat().completions().create(conversation.build());
        output.println("AI: " + ChatResponses.text(firstResponse));
        conversation.addMessage(firstResponse.choices().getFirst().message())
                .addUserMessage("How is HashMap different from TreeMap? Give me a practical example.")
                .maxCompletionTokens(400);
        output.println("\nAI: " + ChatResponses.text(client.chat().completions().create(conversation.build())));

        interactiveChat(client, config, scanner, output);
    }

    static void interactiveChat(OpenAIClient client, AzureOpenAIConfig config, Scanner scanner, PrintStream output) {
        output.println("\n=== Interactive Chat (type 'exit' to quit) ===");
        List<ChatCompletionMessageParam> messages = new ArrayList<>();
        messages.add(ChatCompletionMessageParam.ofSystem(ChatCompletionSystemMessageParam.builder()
            .content("You are a friendly AI assistant specializing in programming and technology. "
                + "Keep each answer under 150 words.")
                .build()));
        while (true) {
            output.print("\nYou: ");
            if (!scanner.hasNextLine()) {
                return;
            }
            String input = scanner.nextLine().strip();
            if ("exit".equalsIgnoreCase(input)) {
                output.println("Goodbye!");
                return;
            }
            if (input.isEmpty()) {
                continue;
            }
            messages.add(ChatCompletionMessageParam.ofUser(ChatCompletionUserMessageParam.builder()
                    .content(input).build()));
            var request = config.chatOptions(500).messages(messages).build();
            String answer = ChatResponses.text(client.chat().completions().create(request));
            output.println("AI: " + answer);
            messages.add(ChatCompletionMessageParam.ofAssistant(ChatCompletionAssistantMessageParam.builder()
                    .content(answer).build()));
            if (messages.size() > 19) {
                messages.subList(1, messages.size() - 18).clear();
            }
        }
    }
}
