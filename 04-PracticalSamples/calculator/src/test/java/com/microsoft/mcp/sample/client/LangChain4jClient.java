package com.microsoft.mcp.sample.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.azure.identity.AuthenticationUtil;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.credential.BearerTokenCredential;
import com.openai.credential.Credential;
import dev.langchain4j.mcp.McpToolProvider;
import dev.langchain4j.mcp.client.DefaultMcpClient;
import dev.langchain4j.mcp.client.McpClient;
import dev.langchain4j.mcp.client.transport.http.StreamableHttpMcpTransport;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openaiofficial.OpenAiOfficialChatModel;
import dev.langchain4j.model.openaiofficial.OpenAiOfficialChatRequestParameters;
import dev.langchain4j.service.AiServices;

/**
 * LangChain4j MCP Client Example
 * 
 * This demonstrates the power of combining AI models with MCP tools.
 * Unlike the SDKClient which requires explicit tool calls, this approach:
 * 
 * 1. Uses natural language prompts (like talking to a human)
 * 2. AI decides WHEN to call tools based on the conversation context
 * 3. AI decides WHICH tools to call and with WHAT parameters
 * 4. AI incorporates tool results into natural language responses
 * 
 * This is much more user-friendly and powerful than direct tool calling!
 * 
 * Key Learning Points:
 * - AI models can "reason" about when tools are needed
 * - No need to specify exact tool parameters - AI figures them out
 * - Results are automatically incorporated into conversational responses
 * - Same MCP server works with both direct calling and AI-mediated calling
 */
public class LangChain4jClient {
        static final String DEFAULT_MODEL = "gpt-5.6-luna";
        static final List<String> DEMO_PROMPTS = List.of(
                "Calculate the sum of 24.5 and 17.3 using the calculator service",
                "What's the square root of 144?",
                "Show me the help for the calculator service",
                "Calculate 2 to the power of 8, then divide the result by 4");

        /**
         * Run the four-prompt demo, or select --prompt, --demo, or --interactive.
         * Requires AZURE_OPENAI_ENDPOINT and a signed-in DefaultAzureCredential.
         *
         * @param args Optional execution mode and prompt
         * @throws Exception If configuration, authentication, MCP, or model execution fails
         */
        public static void main(String[] args) throws Exception {
                run(args, false);
        }

        static void run(String[] args, boolean interactiveByDefault) throws Exception {
                RunOptions options = parseOptions(args, interactiveByDefault);
                Map<String, String> environment = System.getenv();
                String endpoint = openAiBaseUrl(environment.get("AZURE_OPENAI_ENDPOINT"));
                Credential credential = BearerTokenCredential.create(AuthenticationUtil.getBearerTokenSupplier(
                        new DefaultAzureCredentialBuilder().build(), "https://ai.azure.com/.default"));

                OpenAIClient openAiClient = createOpenAiClient(endpoint, credential);
                try (var transport = new StreamableHttpMcpTransport.Builder()
                                 .url(URI.create(SDKClient.serverUrl()).resolve("/mcp").toString())
                                 .timeout(Duration.ofSeconds(15)).build();
                         McpClient mcpClient = new DefaultMcpClient.Builder().transport(transport)
                                 .initializationTimeout(Duration.ofSeconds(15))
                                 .toolExecutionTimeout(Duration.ofSeconds(15)).build()) {
                        Bot bot = createBot(createModel(openAiClient, environment), mcpClient, System.out);
                        runConversation(bot, options,
                                new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8)), System.out);
                } finally {
                        openAiClient.close();
                }
        }

        static String openAiBaseUrl(String endpoint) {
                if (endpoint == null || endpoint.isBlank()) {
                        throw new IllegalArgumentException("Set AZURE_OPENAI_ENDPOINT and sign in with 'az login'.");
                }
                URI uri = URI.create(endpoint.strip());
                if (uri.getHost() == null || !("https".equals(uri.getScheme()) || "http".equals(uri.getScheme()))
                                || uri.getUserInfo() != null || uri.getQuery() != null || uri.getFragment() != null
                                || !List.of("", "/", "/openai/v1", "/openai/v1/").contains(uri.getPath())) {
                        throw new IllegalArgumentException("AZURE_OPENAI_ENDPOINT must be a resource URL or its /openai/v1 endpoint.");
                }
                return uri.resolve("/openai/v1/").toString();
        }

        static OpenAIClient createOpenAiClient(String endpoint, Credential credential) {
                return OpenAIOkHttpClient.builder().baseUrl(openAiBaseUrl(endpoint)).credential(credential)
                        .timeout(Duration.ofSeconds(60)).maxRetries(0).build();
        }

        static OpenAiOfficialChatModel createModel(OpenAIClient openAiClient, Map<String, String> environment) {
                String deployment = environment.getOrDefault("AZURE_OPENAI_DEPLOYMENT", DEFAULT_MODEL).strip();
                int maxCompletionTokens = Integer.parseInt(environment.getOrDefault("AZURE_OPENAI_MAX_COMPLETION_TOKENS", "1024"));
                if (deployment.isEmpty() || maxCompletionTokens <= 0) {
                        throw new IllegalArgumentException("Deployment must not be blank and max completion tokens must be positive.");
                }
                var parameters = OpenAiOfficialChatRequestParameters.builder()
                        .modelName(deployment).reasoningEffort("none").maxCompletionTokens(maxCompletionTokens)
                        .parallelToolCalls(false).build();
                return OpenAiOfficialChatModel.builder().openAIClient(openAiClient)
                        .defaultRequestParameters(parameters).maxRetries(0).build();
        }

        static Bot createBot(ChatModel model, McpClient mcpClient, PrintStream output) {
                mcpClient.checkHealth();
                var toolNames = mcpClient.listTools().stream().map(tool -> tool.name()).collect(Collectors.toSet());
                SDKClient.requireCalculatorTools(toolNames);
                output.println("Available Tools = " + toolNames);
                var executions = new AtomicInteger();
                Bot delegate = AiServices.builder(Bot.class).chatModel(model)
                        .systemMessage("You are an MCP calculator. Use calculator tools for every request; never calculate "
                                + "answers yourself. For questions about capabilities or other topics, use the help tool. "
                                + "For multi-step calculations, pass the actual tool result into the next tool. Be concise.")
                        .chatMemory(MessageWindowChatMemory.withMaxMessages(20))
                        .toolProvider(McpToolProvider.builder().mcpClients(mcpClient).failIfOneServerFails(true).build())
                        .maxToolCallingRoundTrips(4)
                        .toolExecutionErrorHandler((error, context) -> {
                                throw new IllegalStateException("Calculator tool execution failed", error);
                        })
                        .afterToolExecution(execution -> {
                                if (execution.hasFailed()) {
                                        throw new IllegalStateException("Calculator tool failed: " + execution.result());
                                }
                                executions.incrementAndGet();
                                output.println("Tool executed: " + execution.request().name()
                                        + "(" + execution.request().arguments() + ") -> " + execution.result());
                        }).build();
                return prompt -> {
                        int before = executions.get();
                        String answer = delegate.chat(prompt);
                        if (executions.get() == before) {
                                throw new IllegalStateException("The model returned without executing a calculator tool.");
                        }
                        return answer;
                };
        }

        record RunOptions(boolean interactive, List<String> prompts) { }

        static RunOptions parseOptions(String[] args, boolean interactiveByDefault) {
                if (args.length == 0) {
                        return new RunOptions(interactiveByDefault, interactiveByDefault ? List.of() : DEMO_PROMPTS);
                }
                if (args.length == 2 && "--prompt".equals(args[0]) && !args[1].isBlank()) {
                        return new RunOptions(false, List.of(args[1]));
                }
                if (args.length == 1 && "--demo".equals(args[0])) {
                        return new RunOptions(false, DEMO_PROMPTS);
                }
                if (args.length == 1 && "--interactive".equals(args[0])) {
                        return new RunOptions(true, List.of());
                }
                throw new IllegalArgumentException("Usage: [--prompt \"question\" | --demo | --interactive]");
        }

        static void runConversation(Bot bot, RunOptions options, BufferedReader input, PrintStream output) throws IOException {
                if (!options.interactive()) {
                        for (String prompt : options.prompts()) {
                                printAnswer(bot, prompt, output);
                        }
                        return;
                }
                output.println("MCP Calculator. Enter exit or quit to finish.");
                while (true) {
                        output.print("You: ");
                        output.flush();
                        String line = input.readLine();
                        if (line == null) {
                                return;
                        }
                        String prompt = line.strip();
                        if ("exit".equalsIgnoreCase(prompt) || "quit".equalsIgnoreCase(prompt)) {
                                return;
                        }
                        if (!prompt.isEmpty()) {
                                printAnswer(bot, prompt, output);
                        }
                }
        }

        private static void printAnswer(Bot bot, String prompt, PrintStream output) {
                output.println("Human: " + prompt);
                String answer = bot.chat(prompt);
                if (answer == null || answer.isBlank()) {
                        throw new IllegalStateException("The model returned an empty answer.");
                }
                output.println("AI: " + answer);
        }
}