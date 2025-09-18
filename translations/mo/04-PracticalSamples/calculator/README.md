<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b6c16b5514d524e415a94f6097ee7d4c",
  "translation_date": "2025-09-18T15:25:51+00:00",
  "source_file": "04-PracticalSamples/calculator/README.md",
  "language_code": "mo"
}
-->
# MCP 計算器初學者教學

## 目錄

- [你將學到什麼](../../../../04-PracticalSamples/calculator)
- [先決條件](../../../../04-PracticalSamples/calculator)
- [了解專案結構](../../../../04-PracticalSamples/calculator)
- [核心元件解析](../../../../04-PracticalSamples/calculator)
  - [1. 主應用程式](../../../../04-PracticalSamples/calculator)
  - [2. 計算器服務](../../../../04-PracticalSamples/calculator)
  - [3. 直接 MCP 客戶端](../../../../04-PracticalSamples/calculator)
  - [4. AI 驅動的客戶端](../../../../04-PracticalSamples/calculator)
- [執行範例](../../../../04-PracticalSamples/calculator)
- [如何整合運作](../../../../04-PracticalSamples/calculator)
- [下一步](../../../../04-PracticalSamples/calculator)

## 你將學到什麼

本教學將解釋如何使用模型上下文協議（MCP）建立計算器服務。你將了解：

- 如何建立 AI 可用作工具的服務
- 如何設置與 MCP 服務的直接通信
- AI 模型如何自動選擇使用哪些工具
- 直接協議呼叫與 AI 協助互動的差異

## 先決條件

開始之前，請確保你已經具備以下條件：
- 安裝 Java 21 或更高版本
- 使用 Maven 進行依賴管理
- 擁有 GitHub 帳戶及個人訪問令牌（PAT）
- 基本的 Java 和 Spring Boot 知識

## 了解專案結構

計算器專案包含幾個重要檔案：

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

## 核心元件解析

### 1. 主應用程式

**檔案:** `McpServerApplication.java`

這是我們計算器服務的入口點。它是一個標準的 Spring Boot 應用程式，並有一個特殊的功能：

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

**此功能的作用:**
- 啟動一個埠號為 8080 的 Spring Boot 網頁伺服器
- 建立一個 `ToolCallbackProvider`，使我們的計算器方法可作為 MCP 工具使用
- `@Bean` 註解告訴 Spring 管理此元件，供其他部分使用

### 2. 計算器服務

**檔案:** `CalculatorService.java`

這是所有數學運算的核心。每個方法都使用 `@Tool` 標記，使其可透過 MCP 使用：

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

**主要特點:**

1. **`@Tool` 註解**：告訴 MCP 此方法可供外部客戶端呼叫
2. **清晰的描述**：每個工具都有描述，幫助 AI 模型了解何時使用
3. **一致的返回格式**：所有操作返回人類可讀的字串，例如 "5.00 + 3.00 = 8.00"
4. **錯誤處理**：如除以零或負數平方根，會返回錯誤訊息

**可用操作:**
- `add(a, b)` - 加法
- `subtract(a, b)` - 減法
- `multiply(a, b)` - 乘法
- `divide(a, b)` - 除法（含零檢查）
- `power(base, exponent)` - 指數運算
- `squareRoot(number)` - 平方根（含負數檢查）
- `modulus(a, b)` - 求餘數
- `absolute(number)` - 絕對值
- `help()` - 返回所有操作的資訊

### 3. 直接 MCP 客戶端

**檔案:** `SDKClient.java`

此客戶端直接與 MCP 伺服器通信，不使用 AI。它手動呼叫特定的計算器功能：

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

**此功能的作用:**
1. **連接**到計算器伺服器 `http://localhost:8080`，使用建構器模式
2. **列出**所有可用工具（計算器功能）
3. **呼叫**特定功能並提供精確參數
4. **直接打印**結果

**注意:** 此範例使用 Spring AI 1.1.0-SNAPSHOT 依賴，該版本引入了 `WebFluxSseClientTransport` 的建構器模式。如果你使用較舊的穩定版本，可能需要使用直接建構函數。

**使用時機:** 當你確切知道要執行的計算並希望以程式方式呼叫。

### 4. AI 驅動的客戶端

**檔案:** `LangChain4jClient.java`

此客戶端使用 AI 模型（GPT-4o-mini），可自動決定使用哪些計算器工具：

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

**此功能的作用:**
1. **建立**與 AI 模型的連接，使用你的 GitHub 令牌
2. **連接** AI 到我們的計算器 MCP 伺服器
3. **提供** AI 使用所有計算器工具的權限
4. **允許**自然語言請求，例如 "計算 24.5 和 17.3 的總和"

**AI 自動執行:**
- 理解你想進行加法
- 選擇 `add` 工具
- 呼叫 `add(24.5, 17.3)`
- 返回自然語言的結果

## 執行範例

### 步驟 1: 啟動計算器伺服器

首先，設置你的 GitHub 令牌（AI 客戶端需要）：

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

啟動伺服器：
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

伺服器將啟動於 `http://localhost:8080`。你應該看到：
```
Started McpServerApplication in X.XXX seconds
```

### 步驟 2: 使用直接客戶端測試

在 **新** 終端中（伺服器仍在運行），執行直接 MCP 客戶端：
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

你將看到類似以下的輸出：
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### 步驟 3: 使用 AI 客戶端測試

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

你將看到 AI 自動使用工具：
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### 步驟 4: 關閉 MCP 伺服器

測試完成後，你可以按下客戶端終端中的 `Ctrl+C` 停止 AI 客戶端。MCP 伺服器將繼續運行，直到你停止它。
要停止伺服器，請在其運行的終端中按下 `Ctrl+C`。

## 如何整合運作

以下是當你問 AI "5 + 3 是多少？" 的完整流程：

1. **你**以自然語言向 AI 提問
2. **AI**分析你的請求，判斷你需要加法
3. **AI**呼叫 MCP 伺服器：`add(5.0, 3.0)`
4. **計算器服務**執行：`5.0 + 3.0 = 8.0`
5. **計算器服務**返回：`"5.00 + 3.00 = 8.00"`
6. **AI**接收結果並格式化自然語言回應
7. **你**收到："5 和 3 的總和是 8"

## 下一步

更多範例請參閱 [第 04 章：實用範例](../README.md)

---

**免責聲明**：  
本文件已使用 AI 翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 進行翻譯。雖然我們努力確保翻譯的準確性，但請注意，自動翻譯可能包含錯誤或不準確之處。原始文件的母語版本應被視為權威來源。對於關鍵信息，建議使用專業人工翻譯。我們對因使用此翻譯而引起的任何誤解或誤釋不承擔責任。