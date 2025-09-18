<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b6c16b5514d524e415a94f6097ee7d4c",
  "translation_date": "2025-09-18T15:26:43+00:00",
  "source_file": "04-PracticalSamples/calculator/README.md",
  "language_code": "tw"
}
-->
# MCP 計算器初學者教程

## 目錄

- [您將學到什麼](../../../../04-PracticalSamples/calculator)
- [先決條件](../../../../04-PracticalSamples/calculator)
- [了解項目結構](../../../../04-PracticalSamples/calculator)
- [核心組件解析](../../../../04-PracticalSamples/calculator)
  - [1. 主應用程式](../../../../04-PracticalSamples/calculator)
  - [2. 計算器服務](../../../../04-PracticalSamples/calculator)
  - [3. 直接 MCP 客戶端](../../../../04-PracticalSamples/calculator)
  - [4. AI 驅動的客戶端](../../../../04-PracticalSamples/calculator)
- [運行範例](../../../../04-PracticalSamples/calculator)
- [如何協同工作](../../../../04-PracticalSamples/calculator)
- [下一步](../../../../04-PracticalSamples/calculator)

## 您將學到什麼

本教程講解如何使用模型上下文協議 (MCP) 構建計算器服務。您將了解：

- 如何創建 AI 可用作工具的服務
- 如何設置與 MCP 服務的直接通信
- AI 模型如何自動選擇使用哪些工具
- 直接協議調用與 AI 協助交互的區別

## 先決條件

在開始之前，請確保您已經具備以下條件：
- 安裝了 Java 21 或更高版本
- 使用 Maven 進行依賴管理
- 擁有 GitHub 帳戶及個人訪問令牌 (PAT)
- 基本的 Java 和 Spring Boot 知識

## 了解項目結構

計算器項目包含幾個重要文件：

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

## 核心組件解析

### 1. 主應用程式

**文件:** `McpServerApplication.java`

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
- 在端口 8080 上啟動 Spring Boot 網絡伺服器
- 創建一個 `ToolCallbackProvider`，使我們的計算器方法可作為 MCP 工具使用
- `@Bean` 註解告訴 Spring 將其管理為其他部分可使用的組件

### 2. 計算器服務

**文件:** `CalculatorService.java`

這是所有數學運算的核心。每個方法都使用 `@Tool` 標註，以便通過 MCP 調用：

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

1. **`@Tool` 註解**: 告訴 MCP 此方法可供外部客戶端調用
2. **清晰的描述**: 每個工具都有描述，幫助 AI 模型理解何時使用
3. **一致的返回格式**: 所有操作返回人類可讀的字符串，例如 "5.00 + 3.00 = 8.00"
4. **錯誤處理**: 除以零和負數平方根會返回錯誤信息

**可用操作:**
- `add(a, b)` - 加法
- `subtract(a, b)` - 減法
- `multiply(a, b)` - 乘法
- `divide(a, b)` - 除法（含零檢查）
- `power(base, exponent)` - 指數運算
- `squareRoot(number)` - 計算平方根（含負數檢查）
- `modulus(a, b)` - 返回除法的餘數
- `absolute(number)` - 返回絕對值
- `help()` - 返回所有操作的相關信息

### 3. 直接 MCP 客戶端

**文件:** `SDKClient.java`

此客戶端直接與 MCP 伺服器通信，而不使用 AI。它手動調用特定的計算器功能：

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
1. **連接**到計算器伺服器 `http://localhost:8080`，使用建造者模式
2. **列出**所有可用工具（計算器功能）
3. **調用**特定功能並提供精確參數
4. **直接打印**結果

**注意:** 此範例使用 Spring AI 1.1.0-SNAPSHOT 依賴，該版本引入了 `WebFluxSseClientTransport` 的建造者模式。如果您使用的是較舊的穩定版本，可能需要使用直接構造函數。

**使用場景:** 當您確切知道需要執行的計算並希望以程式化方式調用時。

### 4. AI 驅動的客戶端

**文件:** `LangChain4jClient.java`

此客戶端使用 AI 模型 (GPT-4o-mini)，能自動決定使用哪些計算器工具：

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
1. **創建**與 AI 模型的連接，使用您的 GitHub 令牌
2. **連接** AI 到我們的計算器 MCP 伺服器
3. **授予** AI 使用所有計算器工具的權限
4. **允許**自然語言請求，例如 "計算 24.5 和 17.3 的和"

**AI 自動執行:**
- 理解您想進行加法
- 選擇 `add` 工具
- 調用 `add(24.5, 17.3)`
- 返回自然語言格式的結果

## 運行範例

### 步驟 1: 啟動計算器伺服器

首先，設置您的 GitHub 令牌（AI 客戶端需要）：

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

啟動伺服器:
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

伺服器將啟動在 `http://localhost:8080`。您應該看到：
```
Started McpServerApplication in X.XXX seconds
```

### 步驟 2: 使用直接客戶端測試

在 **新** 終端中（伺服器仍在運行），運行直接 MCP 客戶端：
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

您將看到類似以下的輸出：
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### 步驟 3: 使用 AI 客戶端測試

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

您將看到 AI 自動使用工具：
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### 步驟 4: 關閉 MCP 伺服器

測試完成後，您可以通過在其終端中按 `Ctrl+C` 停止 AI 客戶端。MCP 伺服器將繼續運行，直到您停止它。
要停止伺服器，請在其運行的終端中按 `Ctrl+C`。

## 如何協同工作

以下是當您向 AI 提問 "5 + 3 是多少？" 時的完整流程：

1. **您** 使用自然語言向 AI 提問
2. **AI** 分析您的請求並判斷您需要加法
3. **AI** 調用 MCP 伺服器: `add(5.0, 3.0)`
4. **計算器服務** 執行: `5.0 + 3.0 = 8.0`
5. **計算器服務** 返回: `"5.00 + 3.00 = 8.00"`
6. **AI** 接收結果並格式化自然語言響應
7. **您** 得到: "5 和 3 的和是 8"

## 下一步

更多範例請參見 [第 04 章: 實用範例](../README.md)

---

**免責聲明**：  
本文件已使用 AI 翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 進行翻譯。雖然我們致力於提供準確的翻譯，但請注意，自動翻譯可能包含錯誤或不準確之處。原始文件的母語版本應被視為權威來源。對於關鍵資訊，建議尋求專業人工翻譯。我們對因使用此翻譯而引起的任何誤解或錯誤解釋不承擔責任。