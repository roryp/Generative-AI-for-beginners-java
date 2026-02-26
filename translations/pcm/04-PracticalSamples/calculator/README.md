# MCP Calculator Tutorial for Beginners

## Table of Contents

- [Wetin You Go Learn](../../../../04-PracticalSamples/calculator)
- [Prerequisites](../../../../04-PracticalSamples/calculator)
- [Understand Di Project Structure](../../../../04-PracticalSamples/calculator)
- [Core Components Explained](../../../../04-PracticalSamples/calculator)
  - [1. Main Application](../../../../04-PracticalSamples/calculator)
  - [2. Calculator Service](../../../../04-PracticalSamples/calculator)
  - [3. Direct MCP Client](../../../../04-PracticalSamples/calculator)
  - [4. AI-Powered Client](../../../../04-PracticalSamples/calculator)
- [How to Run Di Examples](../../../../04-PracticalSamples/calculator)
- [How Everything Work Together](../../../../04-PracticalSamples/calculator)
- [Next Steps](../../../../04-PracticalSamples/calculator)

## Wetin You Go Learn

Dis tutorial go show you how to build calculator service wey dey use Model Context Protocol (MCP). You go sabi:

- How to create service wey AI fit use as tool
- How to setup direct communication wit MCP services
- How AI models fit choose tools wey dem go use automatically
- Di difference between direct protocol calls and AI-assisted interactions

## Prerequisites

Before you start, make sure say you get:
- Java 21 or higher wey don dey installed
- Maven for dependency management
- GitHub account wey get personal access token (PAT)
- Basic understanding of Java and Spring Boot

## Understand Di Project Structure

Di calculator project get some important files:

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

## Core Components Explained

### 1. Main Application

**File:** `McpServerApplication.java`

Na di entry point of our calculator service. E be standard Spring Boot application wey get one special addition:

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

**Wetin dis one dey do:**
- E dey start Spring Boot web server for port 8080
- E dey create `ToolCallbackProvider` wey go make our calculator methods dey available as MCP tools
- Di `@Bean` annotation dey tell Spring to manage am as component wey other parts fit use

### 2. Calculator Service

**File:** `CalculatorService.java`

Na here all di math dey happen. Each method dey mark wit `@Tool` to make am dey available through MCP:

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
    
    // More calculator operations...
    
    private String formatResult(double a, String operator, double b, double result) {
        return String.format("%.2f %s %.2f = %.2f", a, operator, b, result);
    }
}
```

**Key features:**

1. **`@Tool` Annotation**: E dey tell MCP say dis method fit dey called by external clients
2. **Clear Descriptions**: Each tool get description wey dey help AI models sabi when to use am
3. **Consistent Return Format**: All operations dey return human-readable strings like "5.00 + 3.00 = 8.00"
4. **Error Handling**: Division by zero and negative square roots dey return error messages

**Available Operations:**
- `add(a, b)` - Add two numbers
- `subtract(a, b)` - Subtract second number from first
- `multiply(a, b)` - Multiply two numbers
- `divide(a, b)` - Divide first number by second (wit zero-check)
- `power(base, exponent)` - Raise base to di power of exponent
- `squareRoot(number)` - Calculate square root (wit negative check)
- `modulus(a, b)` - Return remainder of division
- `absolute(number)` - Return absolute value
- `help()` - Return information about all operations

### 3. Direct MCP Client

**File:** `SDKClient.java`

Dis client dey talk directly to di MCP server without using AI. E dey manually call specific calculator functions:

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
        
        // List available tools
        ListToolsResult toolsList = client.listTools();
        System.out.println("Available Tools = " + toolsList);
        
        // Call specific calculator functions
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

**Wetin dis one dey do:**
1. **Connects** to di calculator server for `http://localhost:8080` using di builder pattern
2. **Lists** all available tools (our calculator functions)
3. **Calls** specific functions wit exact parameters
4. **Prints** di results directly

**Note:** Dis example dey use di Spring AI 1.1.0-SNAPSHOT dependency, wey introduce builder pattern for di `WebFluxSseClientTransport`. If you dey use older stable version, you fit need to use di direct constructor instead.

**When to use dis:** When you sabi di exact calculation wey you wan perform and wan call am programmatically.

### 4. AI-Powered Client

**File:** `LangChain4jClient.java`

Dis client dey use AI model (GPT-4o-mini) wey fit automatically decide which calculator tools to use:

```java
public class LangChain4jClient {
    
    public static void main(String[] args) throws Exception {
        // Set up the AI model (using GitHub Models)
        ChatLanguageModel model = OpenAiOfficialChatModel.builder()
                .isGitHubModels(true)
                .apiKey(System.getenv("GITHUB_TOKEN"))
                .modelName("gpt-4o-mini")
                .build();

        // Connect to our calculator MCP server
        McpTransport transport = new HttpMcpTransport.Builder()
                .sseUrl("http://localhost:8080/sse")
                .logRequests(true)  // Shows what the AI is doing
                .logResponses(true)
                .build();

        McpClient mcpClient = new DefaultMcpClient.Builder()
                .transport(transport)
                .build();

        // Give the AI access to our calculator tools
        ToolProvider toolProvider = McpToolProvider.builder()
                .mcpClients(List.of(mcpClient))
                .build();

        // Create an AI bot that can use our calculator
        Bot bot = AiServices.builder(Bot.class)
                .chatLanguageModel(model)
                .toolProvider(toolProvider)
                .build();

        // Now we can ask the AI to do calculations in natural language
        String response = bot.chat("Calculate the sum of 24.5 and 17.3 using the calculator service");
        System.out.println(response);

        response = bot.chat("What's the square root of 144?");
        System.out.println(response);
    }
}
```

**Wetin dis one dey do:**
1. **Creates** AI model connection using your GitHub token
2. **Connects** di AI to our calculator MCP server
3. **Gives** di AI access to all our calculator tools
4. **Allows** natural language requests like "Calculate di sum of 24.5 and 17.3"

**Di AI automatically:**
- E go sabi say you wan add numbers
- E go choose di `add` tool
- E go call `add(24.5, 17.3)`
- E go return di result in natural response

## How to Run Di Examples

### Step 1: Start Di Calculator Server

First, set your GitHub token (e dey needed for di AI client):

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

Start di server:
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

Di server go start for `http://localhost:8080`. You go see:
```
Started McpServerApplication in X.XXX seconds
```

### Step 2: Test wit Direct Client

For **NEW** terminal wey di Server still dey run, run di direct MCP client:
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

You go see output like:
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### Step 3: Test wit AI Client

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

You go see di AI dey use tools automatically:
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### Step 4: Close Di MCP Server

When you don finish testing, you fit stop di AI client by pressing `Ctrl+C` for di terminal wey e dey. Di MCP server go still dey run until you stop am.
To stop di server, press `Ctrl+C` for di terminal wey e dey run.

## How Everything Work Together

Dis na di complete flow when you ask di AI "Wetin be 5 + 3?":

1. **You** go ask di AI for natural language
2. **AI** go analyze your request and sabi say you wan do addition
3. **AI** go call di MCP server: `add(5.0, 3.0)`
4. **Calculator Service** go perform: `5.0 + 3.0 = 8.0`
5. **Calculator Service** go return: `"5.00 + 3.00 = 8.00"`
6. **AI** go receive di result and format natural response
7. **You** go get: "Di sum of 5 and 3 na 8"

## Next Steps

For more examples, check [Chapter 04: Practical samples](../README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Disclaimer**:  
Dis docu don use AI translation service [Co-op Translator](https://github.com/Azure/co-op-translator) take translate am. Even though we dey try make e correct well, abeg sabi say automatic translation fit get mistake or no dey accurate well. Di original docu for di language wey dem first write am na di main correct one. For important information, e good make una use professional human translation. We no go fit take blame for any misunderstanding or wrong interpretation wey fit happen because of dis translation.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->