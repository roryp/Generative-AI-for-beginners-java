# MCP ಕ್ಯಾಲ್ಕುಲೇಟರ್ ಟ್ಯುಟೋರಿಯಲ್ ಪ್ರಾರಂಭಿಕರಿಗಾಗಿ

## ವಿಷಯಗಳ ಪಟ್ಟಿಯು

- [ನೀವು ಕಲಿಯುವದು](../../../../04-PracticalSamples/calculator)
- [ಪೂರ್ವಶರತ್ತುಗಳು](../../../../04-PracticalSamples/calculator)
- [ಪ್ರಾಜೆಕ್ಟ್ ರಚನೆ ಅರ್ಥಮಾಡಿಕೊಳ್ಳುವುದು](../../../../04-PracticalSamples/calculator)
- [ಮೂಲ ಘಟಕಗಳ ವಿವರಣೆ](../../../../04-PracticalSamples/calculator)
  - [1. ಮುಖ್ಯ ಅಪ್ಲಿಕೇಶನ್](../../../../04-PracticalSamples/calculator)
  - [2. ಕ್ಯಾಲ್ಕುಲೇಟರ್ ಸೇವೆ](../../../../04-PracticalSamples/calculator)
  - [3. ಡೈರೆಕ್ಟ್ MCP ಕ್ಲೈಂಟ್](../../../../04-PracticalSamples/calculator)
  - [4. AI-ಚಾಲಿತ ಕ್ಲೈಂಟ್](../../../../04-PracticalSamples/calculator)
- [ಉದಾಹರಣೆಗಳನ್ನು ಚಲಾಯಿಸುವುದು](../../../../04-PracticalSamples/calculator)
- [ಎಲ್ಲವೂ ಹೇಗೆ ಕೆಲಸ ಮಾಡುತ್ತದೆ](../../../../04-PracticalSamples/calculator)
- [ಮುಂದಿನ ಹಂತಗಳು](../../../../04-PracticalSamples/calculator)

## ನೀವು ಕಲಿಯುವದು

ಈ ಟ್ಯುಟೋರಿಯಲ್ MCP (ಮೋಡಲ್ ಕಾಂಟೆಕ್ಸ್ ಪ್ರೋಟೋಕಾಲ್) ಬಳಸಿ ಕ್ಯಾಲ್ಕುಲೇಟರ್ ಸೇವೆಯನ್ನು ಹೇಗೆ ನಿರ್ಮಿಸಬೇಕೆಂದು ವಿವರಿಸುತ್ತದೆ. ನೀವು ಈ ಕೆಳಗಿನವುಗಳನ್ನು ಅರ್ಥಮಾಡಿಕೊಳ್ಳುತ್ತೀರಿ:

- AI ಬಳಸುವ ಸಾಧನವನ್ನು ಹೇಗೆ ರಚಿಸಬೇಕು
- MCP ಸೇವೆಗಳೊಂದಿಗೆ ನೇರ ಸಂವಹನವನ್ನು ಹೇಗೆ ಸ್ಥಾಪಿಸಬೇಕು
- AI ಮಾದರಿಗಳು ಸ್ವಯಂಚಾಲಿತವಾಗಿ ಯಾವ ಸಾಧನಗಳನ್ನು ಬಳಸಬೇಕೆಂದು ಹೇಗೆ ಆಯ್ಕೆ ಮಾಡುತ್ತವೆ
- ನೇರ ಪ್ರೋಟೋಕಾಲ್ ಕರೆಗಳು ಮತ್ತು AI-ಸಹಾಯಿತ ಸಂವಹನಗಳ ನಡುವಿನ ವ್ಯತ್ಯಾಸ

## ಪೂರ್ವಶರತ್ತುಗಳು

ಪ್ರಾರಂಭಿಸುವ ಮೊದಲು, ನೀವು ಈ ಕೆಳಗಿನವುಗಳನ್ನು ಹೊಂದಿರಬೇಕು:
- Java 21 ಅಥವಾ ಹೆಚ್ಚಿನ ಆವೃತ್ತಿ ಸ್ಥಾಪಿತವಾಗಿದೆ
- Maven ಅವಲಂಬನೆ ನಿರ್ವಹಣೆಗೆ
- GitHub ಖಾತೆ ಮತ್ತು ವೈಯಕ್ತಿಕ ಪ್ರವೇಶ ಟೋಕನ್ (PAT)
- Java ಮತ್ತು Spring Boot ಬಗ್ಗೆ ಮೂಲಭೂತ ತಿಳುವಳಿಕೆ

## ಪ್ರಾಜೆಕ್ಟ್ ರಚನೆ ಅರ್ಥಮಾಡಿಕೊಳ್ಳುವುದು

ಕ್ಯಾಲ್ಕುಲೇಟರ್ ಪ್ರಾಜೆಕ್ಟ್‌ನಲ್ಲಿ ಕೆಲವು ಮುಖ್ಯ ಫೈಲ್‌ಗಳಿವೆ:

```
calculator/
├── src/main/java/com/microsoft/mcp/sample/server/
│   ├── McpServerApplication.java          # Main Spring Boot app
│   └── service/CalculatorService.java     # Calculator operations
└── src/test/java/com/microsoft/mcp/sample/client/
    ├── SDKClient.java                     # Direct MCP communication
    ├── LangChain4jClient.java            # AI-powered client
    └── Bot.java                          # Simple chat interface
```

## ಮೂಲ ಘಟಕಗಳ ವಿವರಣೆ

### 1. ಮುಖ್ಯ ಅಪ್ಲಿಕೇಶನ್

**ಫೈಲ್:** `McpServerApplication.java`

ಇದು ನಮ್ಮ ಕ್ಯಾಲ್ಕುಲೇಟರ್ ಸೇವೆಯ ಪ್ರವೇಶ ಬಿಂದು. ಇದು ಒಂದು ಸ್ಟ್ಯಾಂಡರ್ಡ್ Spring Boot ಅಪ್ಲಿಕೇಶನ್, ಇದರಲ್ಲಿ ಒಂದು ವಿಶೇಷ ಸೇರ್ಪಡೆ ಇದೆ:

```java
@SpringBootApplication
public class McpServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(McpServerApplication.class, args);
    }
    
    @Bean
    public ToolCallbackProvider calculatorTools(CalculatorService calculator) {
        return MethodToolCallbackProvider.builder().toolObjects(calculator).build();
    }
}
```

**ಇದು ಏನು ಮಾಡುತ್ತದೆ:**
- Spring Boot ವೆಬ್ ಸರ್ವರ್ ಅನ್ನು 8080 ಪೋರ್ಟ್‌ನಲ್ಲಿ ಪ್ರಾರಂಭಿಸುತ್ತದೆ
- `ToolCallbackProvider` ಅನ್ನು ರಚಿಸುತ್ತದೆ, ಇದು MCP ಸಾಧನಗಳಾಗಿ ನಮ್ಮ ಕ್ಯಾಲ್ಕುಲೇಟರ್ ವಿಧಾನಗಳನ್ನು ಲಭ್ಯವಿರಿಸುತ್ತದೆ
- `@Bean` ಅನೋಟೇಶನ್ Spring ಇದನ್ನು ಒಂದು ಘಟಕವಾಗಿ ನಿರ್ವಹಿಸಲು ಹೇಳುತ್ತದೆ, ಇದನ್ನು ಇತರ ಭಾಗಗಳು ಬಳಸಬಹುದು

### 2. ಕ್ಯಾಲ್ಕುಲೇಟರ್ ಸೇವೆ

**ಫೈಲ್:** `CalculatorService.java`

ಇಲ್ಲಿ ಎಲ್ಲಾ ಗಣಿತ ಕಾರ್ಯಗಳು ನಡೆಯುತ್ತವೆ. ಪ್ರತಿ ವಿಧಾನವನ್ನು MCP ಮೂಲಕ ಲಭ್ಯವಿರಿಸಲು `@Tool` ಅಂಕಿತ ಮಾಡಲಾಗಿದೆ:

```java
@Service
public class CalculatorService {

    @Tool(description = "Add two numbers together")
    public String add(double a, double b) {
        double result = a + b;
        return formatResult(a, "+", b, result);
    }

    @Tool(description = "Subtract the second number from the first number")
    public String subtract(double a, double b) {
        double result = a - b;
        return formatResult(a, "-", b, result);
    }
    
    // ಇನ್ನಷ್ಟು ಕ್ಯಾಲ್ಕುಲೇಟರ್ ಕಾರ್ಯಗಳು...
    
    private String formatResult(double a, String operator, double b, double result) {
        return String.format("%.2f %s %.2f = %.2f", a, operator, b, result);
    }
}
```

**ಮುಖ್ಯ ವೈಶಿಷ್ಟ್ಯಗಳು:**

1. **`@Tool` ಅನೋಟೇಶನ್**: ಇದು MCPಗೆ ಈ ವಿಧಾನವನ್ನು ಬಾಹ್ಯ ಕ್ಲೈಂಟ್‌ಗಳು ಕರೆ ಮಾಡಬಹುದು ಎಂದು ತಿಳಿಸುತ್ತದೆ
2. **ಸ್ಪಷ್ಟ ವಿವರಣೆಗಳು**: ಪ್ರತಿ ಸಾಧನವು AI ಮಾದರಿಗಳು ಯಾವಾಗ ಇದನ್ನು ಬಳಸಬೇಕು ಎಂದು ಅರ್ಥಮಾಡಿಕೊಳ್ಳಲು ಸಹಾಯ ಮಾಡುವ ವಿವರಣೆ ಹೊಂದಿದೆ
3. **ಸತತ ಫಲಿತಾಂಶ ಸ್ವರೂಪ**: ಎಲ್ಲಾ ಕಾರ್ಯಗಳು "5.00 + 3.00 = 8.00" ಎಂಬಂತೆ ಮಾನವ-ಓದಬಹುದಾದ ಸ್ಟ್ರಿಂಗ್‌ಗಳನ್ನು ಹಿಂತಿರುಗಿಸುತ್ತವೆ
4. **ದೋಷ ನಿರ್ವಹಣೆ**: ಶೂನ್ಯದಿಂದ ಭಾಗಿಸುವುದು ಮತ್ತು ಋಣಾತ್ಮಕ ಚತುರ್ಭುಜ ಮೂಲಗಳು ದೋಷ ಸಂದೇಶಗಳನ್ನು ಹಿಂತಿರುಗಿಸುತ್ತವೆ

**ಲಭ್ಯವಿರುವ ಕಾರ್ಯಗಳು:**
- `add(a, b)` - ಎರಡು ಸಂಖ್ಯೆಗಳ ಮೊತ್ತವನ್ನು ಲೆಕ್ಕಹಾಕುತ್ತದೆ
- `subtract(a, b)` - ಎರಡನೆಯ ಸಂಖ್ಯೆಯನ್ನು ಮೊದಲನೆಯ ಸಂಖ್ಯೆಯಿಂದ ಕಡಿಮೆ ಮಾಡುತ್ತದೆ
- `multiply(a, b)` - ಎರಡು ಸಂಖ್ಯೆಗಳ ಗುಣಾಕಾರವನ್ನು ಲೆಕ್ಕಹಾಕುತ್ತದೆ
- `divide(a, b)` - ಮೊದಲನೆಯ ಸಂಖ್ಯೆಯನ್ನು ಎರಡನೆಯ ಸಂಖ್ಯೆಯಿಂದ ಭಾಗಿಸುತ್ತದೆ (ಶೂನ್ಯ-ಪರಿಶೀಲನೆ)
- `power(base, exponent)` - ಮೂಲ ಸಂಖ್ಯೆಯನ್ನು ಘಾತಕ್ಕೆ ಏರಿಸುತ್ತದೆ
- `squareRoot(number)` - ಚತುರ್ಭುಜ ಮೂಲವನ್ನು ಲೆಕ್ಕಹಾಕುತ್ತದೆ (ಋಣಾತ್ಮಕ ಪರಿಶೀಲನೆ)
- `modulus(a, b)` - ಭಾಗಿಸುವಿಕೆಯ ಶೇಷವನ್ನು ಹಿಂತಿರುಗಿಸುತ್ತದೆ
- `absolute(number)` - ಪರಿಪೂರ್ಣ ಮೌಲ್ಯವನ್ನು ಹಿಂತಿರುಗಿಸುತ್ತದೆ
- `help()` - ಎಲ್ಲಾ ಕಾರ್ಯಗಳ ಬಗ್ಗೆ ಮಾಹಿತಿ ಹಿಂತಿರುಗಿಸುತ್ತದೆ

### 3. ಡೈರೆಕ್ಟ್ MCP ಕ್ಲೈಂಟ್

**ಫೈಲ್:** `SDKClient.java`

ಈ ಕ್ಲೈಂಟ್ AI ಬಳಸದೆ MCP ಸರ್ವರ್‌ಗೆ ನೇರವಾಗಿ ಮಾತನಾಡುತ್ತದೆ. ಇದು ನಿರ್ದಿಷ್ಟ ಕ್ಯಾಲ್ಕುಲೇಟರ್ ಕಾರ್ಯಗಳನ್ನು ಕೈಗೊಳ್ಳುತ್ತದೆ:

```java
public class SDKClient {
    
    public static void main(String[] args) {
        McpClientTransport transport = WebFluxSseClientTransport.builder(
            WebClient.builder().baseUrl("http://localhost:8080")
        ).build();
        new SDKClient(transport).run();
    }
    
    public void run() {
        var client = McpClient.sync(this.transport).build();
        client.initialize();
        
        // ಲಭ್ಯವಿರುವ ಸಾಧನಗಳನ್ನು ಪಟ್ಟಿ ಮಾಡಿ
        ListToolsResult toolsList = client.listTools();
        System.out.println("Available Tools = " + toolsList);
        
        // ನಿರ್ದಿಷ್ಟ ಕ್ಯಾಲ್ಕುಲೇಟರ್ ಕಾರ್ಯಗಳನ್ನು ಕರೆ ಮಾಡಿ
        CallToolResult resultAdd = client.callTool(
            new CallToolRequest("add", Map.of("a", 5.0, "b", 3.0))
        );
        System.out.println("Add Result = " + resultAdd);
        
        CallToolResult resultSqrt = client.callTool(
            new CallToolRequest("squareRoot", Map.of("number", 16.0))
        );
        System.out.println("Square Root Result = " + resultSqrt);
        
        client.closeGracefully();
    }
}
```

**ಇದು ಏನು ಮಾಡುತ್ತದೆ:**
1. **ಸಂಪರ್ಕಿಸುತ್ತದೆ** `http://localhost:8080` ನಲ್ಲಿ ಕ್ಯಾಲ್ಕುಲೇಟರ್ ಸರ್ವರ್‌ಗೆ ಬಿಲ್ಡರ್ ಪ್ಯಾಟರ್ನ್ ಬಳಸಿ
2. **ಸೂಚಿಸುತ್ತದೆ** ಎಲ್ಲಾ ಲಭ್ಯವಿರುವ ಸಾಧನಗಳನ್ನು (ನಮ್ಮ ಕ್ಯಾಲ್ಕುಲೇಟರ್ ಕಾರ್ಯಗಳು)
3. **ಕರೆಮಾಡುತ್ತದೆ** ನಿರ್ದಿಷ್ಟ ಕಾರ್ಯಗಳನ್ನು ನಿಖರವಾದ ಪ್ಯಾರಾಮೀಟರ್‌ಗಳೊಂದಿಗೆ
4. **ಮುದ್ರಿಸುತ್ತದೆ** ಫಲಿತಾಂಶಗಳನ್ನು ನೇರವಾಗಿ

**ಗಮನಿಸಿ:** ಈ ಉದಾಹರಣೆ Spring AI 1.1.0-SNAPSHOT ಅವಲಂಬನೆಯನ್ನು ಬಳಸುತ್ತದೆ, ಇದು `WebFluxSseClientTransport` ಗೆ ಬಿಲ್ಡರ್ ಪ್ಯಾಟರ್ನ್ ಅನ್ನು ಪರಿಚಯಿಸಿದೆ. ನೀವು ಹಳೆಯ ಸ್ಥಿರ ಆವೃತ್ತಿಯನ್ನು ಬಳಸುತ್ತಿದ್ದರೆ, ನೀವು ನೇರ ಕಾನ್ಸ್ಟ್ರಕ್ಟರ್ ಅನ್ನು ಬಳಸಬೇಕಾಗಬಹುದು.

**ಇದನ್ನು ಯಾವಾಗ ಬಳಸಬೇಕು:** ನೀವು ಯಾವ ಲೆಕ್ಕಾಚಾರವನ್ನು ಮಾಡಬೇಕೆಂದು ನಿಖರವಾಗಿ ತಿಳಿದಿದ್ದಾಗ ಮತ್ತು ಅದನ್ನು ಪ್ರೋಗ್ರಾಮ್ಯಾತ್ಮಕವಾಗಿ ಕರೆಮಾಡಲು ಬಯಸಿದಾಗ.

### 4. AI-ಚಾಲಿತ ಕ್ಲೈಂಟ್

**ಫೈಲ್:** `LangChain4jClient.java`

ಈ ಕ್ಲೈಂಟ್ AI ಮಾದರಿಯನ್ನು (GPT-4o-mini) ಬಳಸುತ್ತದೆ, ಇದು ಸ್ವಯಂಚಾಲಿತವಾಗಿ ಯಾವ ಕ್ಯಾಲ್ಕುಲೇಟರ್ ಸಾಧನಗಳನ್ನು ಬಳಸಬೇಕೆಂದು ನಿರ್ಧರಿಸುತ್ತದೆ:

```java
public class LangChain4jClient {
    
    public static void main(String[] args) throws Exception {
        // AI ಮಾದರಿಯನ್ನು ಸ್ಥಾಪಿಸಿ (GitHub ಮಾದರಿಗಳನ್ನು ಬಳಸುವುದು)
        ChatLanguageModel model = OpenAiOfficialChatModel.builder()
                .isGitHubModels(true)
                .apiKey(System.getenv("GITHUB_TOKEN"))
                .modelName("gpt-4o-mini")
                .build();

        // ನಮ್ಮ ಕ್ಯಾಲ್ಕುಲೇಟರ್ MCP ಸರ್ವರ್‌ಗೆ ಸಂಪರ್ಕಿಸಿ
        McpTransport transport = new HttpMcpTransport.Builder()
                .sseUrl("http://localhost:8080/sse")
                .logRequests(true)  // AI ಏನು ಮಾಡುತ್ತಿದೆ ಎಂಬುದನ್ನು ತೋರಿಸುತ್ತದೆ
                .logResponses(true)
                .build();

        McpClient mcpClient = new DefaultMcpClient.Builder()
                .transport(transport)
                .build();

        // AI ಗೆ ನಮ್ಮ ಕ್ಯಾಲ್ಕುಲೇಟರ್ ಸಾಧನಗಳಿಗೆ ಪ್ರವೇಶವನ್ನು ನೀಡಿ
        ToolProvider toolProvider = McpToolProvider.builder()
                .mcpClients(List.of(mcpClient))
                .build();

        // ನಮ್ಮ ಕ್ಯಾಲ್ಕುಲೇಟರ್ ಅನ್ನು ಬಳಸುವ AI ಬಾಟ್ ಅನ್ನು ರಚಿಸಿ
        Bot bot = AiServices.builder(Bot.class)
                .chatLanguageModel(model)
                .toolProvider(toolProvider)
                .build();

        // ಈಗ ನಾವು AI ಗೆ ನೈಸರ್ಗಿಕ ಭಾಷೆಯಲ್ಲಿ ಲೆಕ್ಕಾಚಾರಗಳನ್ನು ಮಾಡಲು ಕೇಳಬಹುದು
        String response = bot.chat("Calculate the sum of 24.5 and 17.3 using the calculator service");
        System.out.println(response);

        response = bot.chat("What's the square root of 144?");
        System.out.println(response);
    }
}
```

**ಇದು ಏನು ಮಾಡುತ್ತದೆ:**
1. **AI ಮಾದರಿಯ ಸಂಪರ್ಕವನ್ನು** ನಿಮ್ಮ GitHub ಟೋಕನ್ ಬಳಸಿ ರಚಿಸುತ್ತದೆ
2. **AI ಅನ್ನು** ನಮ್ಮ ಕ್ಯಾಲ್ಕುಲೇಟರ್ MCP ಸರ್ವರ್‌ಗೆ ಸಂಪರ್ಕಿಸುತ್ತದೆ
3. **AI ಗೆ** ನಮ್ಮ ಎಲ್ಲಾ ಕ್ಯಾಲ್ಕುಲೇಟರ್ ಸಾಧನಗಳಿಗೆ ಪ್ರವೇಶವನ್ನು ನೀಡುತ್ತದೆ
4. **ಸ್ವಾಭಾವಿಕ ಭಾಷಾ ವಿನಂತಿಗಳನ್ನು** ಅನುಮತಿಸುತ್ತದೆ, ಉದಾಹರಣೆಗೆ "24.5 ಮತ್ತು 17.3 ಮೊತ್ತವನ್ನು ಲೆಕ್ಕಹಾಕಿ"

**AI ಸ್ವಯಂಚಾಲಿತವಾಗಿ:**
- ನೀವು ಸಂಖ್ಯೆಗಳ ಮೊತ್ತವನ್ನು ಲೆಕ್ಕಹಾಕಲು ಬಯಸುತ್ತೀರಿ ಎಂದು ಅರ್ಥಮಾಡಿಕೊಳ್ಳುತ್ತದೆ
- `add` ಸಾಧನವನ್ನು ಆಯ್ಕೆ ಮಾಡುತ್ತದೆ
- `add(24.5, 17.3)` ಅನ್ನು ಕರೆಮಾಡುತ್ತದೆ
- ಸ್ವಾಭಾವಿಕ ಪ್ರತಿಕ್ರಿಯೆಯಲ್ಲಿ ಫಲಿತಾಂಶವನ್ನು ಹಿಂತಿರುಗಿಸುತ್ತದೆ

## ಉದಾಹರಣೆಗಳನ್ನು ಚಲಾಯಿಸುವುದು

### ಹಂತ 1: ಕ್ಯಾಲ್ಕುಲೇಟರ್ ಸರ್ವರ್ ಪ್ರಾರಂಭಿಸಿ

ಮೊದಲು, ನಿಮ್ಮ GitHub ಟೋಕನ್ ಅನ್ನು ಸೆಟ್ ಮಾಡಿ (AI ಕ್ಲೈಂಟ್‌ಗಾಗಿ ಅಗತ್ಯವಿದೆ):

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

ಸರ್ವರ್ ಪ್ರಾರಂಭಿಸಿ:
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

ಸರ್ವರ್ `http://localhost:8080` ನಲ್ಲಿ ಪ್ರಾರಂಭವಾಗುತ್ತದೆ. ನೀವು ಈ ಕೆಳಗಿನವುಗಳನ್ನು ನೋಡುತ್ತೀರಿ:
```
Started McpServerApplication in X.XXX seconds
```

### ಹಂತ 2: ಡೈರೆಕ್ಟ್ ಕ್ಲೈಂಟ್ ಬಳಸಿ ಪರೀಕ್ಷಿಸಿ

**ಹೊಸ** ಟರ್ಮಿನಲ್‌ನಲ್ಲಿ, ಸರ್ವರ್ ಇನ್ನೂ ಚಲಿಸುತ್ತಿರುವಾಗ, ಡೈರೆಕ್ಟ್ MCP ಕ್ಲೈಂಟ್ ಅನ್ನು ಚಲಾಯಿಸಿ:
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

ನೀವು ಈ ರೀತಿಯ ಔಟ್‌ಪುಟ್ ಅನ್ನು ನೋಡುತ್ತೀರಿ:
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### ಹಂತ 3: AI ಕ್ಲೈಂಟ್ ಬಳಸಿ ಪರೀಕ್ಷಿಸಿ

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

ನೀವು AI ಸ್ವಯಂಚಾಲಿತವಾಗಿ ಸಾಧನಗಳನ್ನು ಬಳಸುತ್ತಿರುವುದನ್ನು ನೋಡುತ್ತೀರಿ:
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### ಹಂತ 4: MCP ಸರ್ವರ್ ಅನ್ನು ಮುಚ್ಚಿ

ಪರೀಕ್ಷೆ ಮುಗಿದ ನಂತರ, ಅದರ ಟರ್ಮಿನಲ್‌ನಲ್ಲಿ `Ctrl+C` ಒತ್ತುವ ಮೂಲಕ AI ಕ್ಲೈಂಟ್ ಅನ್ನು ನಿಲ್ಲಿಸಬಹುದು. MCP ಸರ್ವರ್ ನೀವು ನಿಲ್ಲಿಸುವವರೆಗೆ ಚಲಿಸುತ್ತಿರುತ್ತದೆ.
ಸರ್ವರ್ ಅನ್ನು ನಿಲ್ಲಿಸಲು, ಅದು ಚಲಿಸುತ್ತಿರುವ ಟರ್ಮಿನಲ್‌ನಲ್ಲಿ `Ctrl+C` ಒತ್ತಿ.

## ಎಲ್ಲವೂ ಹೇಗೆ ಕೆಲಸ ಮಾಡುತ್ತದೆ

ನೀವು AI ಗೆ "5 + 3 ಎಷ್ಟು?" ಎಂದು ಕೇಳಿದಾಗ ಸಂಪೂರ್ಣ ಪ್ರಕ್ರಿಯೆ ಹೀಗಿದೆ:

1. **ನೀವು** AI ಗೆ ಸ್ವಾಭಾವಿಕ ಭಾಷೆಯಲ್ಲಿ ಕೇಳುತ್ತೀರಿ
2. **AI** ನಿಮ್ಮ ವಿನಂತಿಯನ್ನು ವಿಶ್ಲೇಷಿಸುತ್ತದೆ ಮತ್ತು ನೀವು ಮೊತ್ತವನ್ನು ಲೆಕ್ಕಹಾಕಲು ಬಯಸುತ್ತೀರೆಂದು ಅರ್ಥಮಾಡಿಕೊಳ್ಳುತ್ತದೆ
3. **AI** MCP ಸರ್ವರ್ ಅನ್ನು ಕರೆಮಾಡುತ್ತದೆ: `add(5.0, 3.0)`
4. **ಕ್ಯಾಲ್ಕುಲೇಟರ್ ಸೇವೆ** ಕಾರ್ಯವನ್ನು ನಿರ್ವಹಿಸುತ್ತದೆ: `5.0 + 3.0 = 8.0`
5. **ಕ್ಯಾಲ್ಕುಲೇಟರ್ ಸೇವೆ** ಹಿಂತಿರುಗಿಸುತ್ತದೆ: `"5.00 + 3.00 = 8.00"`
6. **AI** ಫಲಿತಾಂಶವನ್ನು ಸ್ವೀಕರಿಸುತ್ತದೆ ಮತ್ತು ಸ್ವಾಭಾವಿಕ ಪ್ರತಿಕ್ರಿಯೆಯನ್ನು ರೂಪಿಸುತ್ತದೆ
7. **ನೀವು** ಪಡೆಯುತ್ತೀರಿ: "5 ಮತ್ತು 3 ಮೊತ್ತ 8"

## ಮುಂದಿನ ಹಂತಗಳು

ಹೆಚ್ಚಿನ ಉದಾಹರಣೆಗಳಿಗಾಗಿ, [ಅಧ್ಯಾಯ 04: ಪ್ರಾಯೋಗಿಕ ಮಾದರಿಗಳು](../README.md) ನೋಡಿ

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ಅಸ್ವೀಕಾರ**:  
ಈ ದಸ್ತಾವೇಜು AI ಅನುವಾದ ಸೇವೆ [Co-op Translator](https://github.com/Azure/co-op-translator) ಬಳಸಿ ಅನುವಾದಿಸಲಾಗಿದೆ. ನಾವು ಶುದ್ಧತೆಯನ್ನು ಸಾಧಿಸಲು ಪ್ರಯತ್ನಿಸುತ್ತಿದ್ದರೂ, ದಯವಿಟ್ಟು ಗಮನಿಸಿ, ಸ್ವಯಂಚಾಲಿತ ಅನುವಾದಗಳಲ್ಲಿ ದೋಷಗಳು ಅಥವಾ ಅಸಡ್ಡೆಗಳು ಇರಬಹುದು. ಮೂಲ ಭಾಷೆಯಲ್ಲಿರುವ ಮೂಲ ದಸ್ತಾವೇಜು ಪ್ರಾಮಾಣಿಕ ಮೂಲವೆಂದು ಪರಿಗಣಿಸಬೇಕು. ಮಹತ್ವದ ಮಾಹಿತಿಗಾಗಿ, ವೃತ್ತಿಪರ ಮಾನವ ಅನುವಾದವನ್ನು ಶಿಫಾರಸು ಮಾಡಲಾಗುತ್ತದೆ. ಈ ಅನುವಾದವನ್ನು ಬಳಸುವ ಮೂಲಕ ಉಂಟಾಗುವ ಯಾವುದೇ ತಪ್ಪು ಅರ್ಥಗಳ ಅಥವಾ ತಪ್ಪು ವ್ಯಾಖ್ಯಾನಗಳ ಬಗ್ಗೆ ನಾವು ಹೊಣೆಗಾರರಲ್ಲ.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->