<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b6c16b5514d524e415a94f6097ee7d4c",
  "translation_date": "2025-09-18T15:27:07+00:00",
  "source_file": "04-PracticalSamples/calculator/README.md",
  "language_code": "ja"
}
-->
# MCP計算機チュートリアル初心者向け

## 目次

- [学べること](../../../../04-PracticalSamples/calculator)
- [前提条件](../../../../04-PracticalSamples/calculator)
- [プロジェクト構造の理解](../../../../04-PracticalSamples/calculator)
- [主要コンポーネントの説明](../../../../04-PracticalSamples/calculator)
  - [1. メインアプリケーション](../../../../04-PracticalSamples/calculator)
  - [2. 計算機サービス](../../../../04-PracticalSamples/calculator)
  - [3. 直接MCPクライアント](../../../../04-PracticalSamples/calculator)
  - [4. AI駆動型クライアント](../../../../04-PracticalSamples/calculator)
- [例の実行方法](../../../../04-PracticalSamples/calculator)
- [全体の仕組み](../../../../04-PracticalSamples/calculator)
- [次のステップ](../../../../04-PracticalSamples/calculator)

## 学べること

このチュートリアルでは、Model Context Protocol (MCP)を使用して計算機サービスを構築する方法を説明します。以下を理解できます：

- AIがツールとして使用できるサービスの作成方法
- MCPサービスとの直接通信の設定方法
- AIモデルがどのツールを使用するかを自動的に選択する仕組み
- 直接プロトコル呼び出しとAI支援型インタラクションの違い

## 前提条件

始める前に以下を準備してください：
- Java 21以上がインストールされていること
- 依存関係管理のためのMaven
- 個人アクセストークン(PAT)を持つGitHubアカウント
- JavaとSpring Bootの基本的な理解

## プロジェクト構造の理解

計算機プロジェクトにはいくつかの重要なファイルがあります：

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

## 主要コンポーネントの説明

### 1. メインアプリケーション

**ファイル:** `McpServerApplication.java`

これは計算機サービスのエントリーポイントです。標準的なSpring Bootアプリケーションですが、特別な追加があります：

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

**これが行うこと:**
- ポート8080でSpring Bootウェブサーバーを起動
- `ToolCallbackProvider`を作成し、計算機メソッドをMCPツールとして利用可能にする
- `@Bean`アノテーションはSpringにこれをコンポーネントとして管理させ、他の部分で使用可能にする

### 2. 計算機サービス

**ファイル:** `CalculatorService.java`

ここで全ての計算が行われます。各メソッドは`@Tool`でマークされ、MCPを通じて利用可能になります：

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

**主な特徴:**

1. **`@Tool`アノテーション**: このメソッドが外部クライアントによって呼び出されることをMCPに伝える
2. **明確な説明**: 各ツールにはAIモデルが使用するタイミングを理解するための説明が付いている
3. **一貫した返却形式**: 全ての操作は「5.00 + 3.00 = 8.00」のような人間が読める文字列を返す
4. **エラーハンドリング**: ゼロ除算や負の平方根はエラーメッセージを返す

**利用可能な操作:**
- `add(a, b)` - 2つの数値を加算
- `subtract(a, b)` - 1つ目から2つ目を減算
- `multiply(a, b)` - 2つの数値を乗算
- `divide(a, b)` - 1つ目を2つ目で除算（ゼロチェック付き）
- `power(base, exponent)` - 基数を指数で累乗
- `squareRoot(number)` - 平方根を計算（負の値チェック付き）
- `modulus(a, b)` - 剰余を返す
- `absolute(number)` - 絶対値を返す
- `help()` - 全ての操作に関する情報を返す

### 3. 直接MCPクライアント

**ファイル:** `SDKClient.java`

このクライアントはAIを使用せず、MCPサーバーと直接通信します。特定の計算機関数を手動で呼び出します：

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

**これが行うこと:**
1. **接続**: ビルダーパターンを使用して`http://localhost:8080`の計算機サーバーに接続
2. **ツール一覧**: 利用可能な全てのツール（計算機関数）をリスト化
3. **特定の関数を呼び出し**: 正確なパラメータで関数を呼び出す
4. **結果を直接出力**: 結果をそのまま出力

**注意:** この例ではSpring AI 1.1.0-SNAPSHOT依存関係を使用しており、`WebFluxSseClientTransport`のビルダーパターンを導入しています。古い安定版を使用している場合は、直接コンストラクタを使用する必要があるかもしれません。

**使用する場面:** 実行したい計算が正確に分かっており、プログラム的に呼び出したい場合。

### 4. AI駆動型クライアント

**ファイル:** `LangChain4jClient.java`

このクライアントはAIモデル(GPT-4o-mini)を使用し、どの計算機ツールを使用するかを自動的に決定します：

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

**これが行うこと:**
1. **AIモデル接続を作成**: GitHubトークンを使用して接続
2. **AIを計算機MCPサーバーに接続**: MCPサーバーに接続
3. **AIに全ての計算機ツールへのアクセスを提供**: ツールを利用可能にする
4. **自然言語リクエストを許可**: 「24.5と17.3の合計を計算して」のようなリクエストを受け付ける

**AIが自動的に行うこと:**
- 数値を加算したいことを理解
- `add`ツールを選択
- `add(24.5, 17.3)`を呼び出し
- 自然な応答で結果を返す

## 例の実行方法

### ステップ1: 計算機サーバーを起動

まず、GitHubトークンを設定します（AIクライアントに必要です）：

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

サーバーを起動します：
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

サーバーは`http://localhost:8080`で起動します。以下が表示されます：
```
Started McpServerApplication in X.XXX seconds
```

### ステップ2: 直接クライアントでテスト

**新しい**ターミナルでサーバーを起動したまま、直接MCPクライアントを実行します：
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

以下のような出力が表示されます：
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### ステップ3: AIクライアントでテスト

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

AIがツールを自動的に使用する様子が表示されます：
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### ステップ4: MCPサーバーを終了

テストが終了したら、AIクライアントを終了するにはそのターミナルで`Ctrl+C`を押します。MCPサーバーは停止するまで動作し続けます。
サーバーを停止するには、サーバーが実行されているターミナルで`Ctrl+C`を押します。

## 全体の仕組み

AIに「5 + 3は何？」と尋ねた場合の完全な流れは以下の通りです：

1. **あなた**がAIに自然言語で質問
2. **AI**がリクエストを分析し、加算を求めていることを理解
3. **AI**がMCPサーバーを呼び出し: `add(5.0, 3.0)`
4. **計算機サービス**が計算を実行: `5.0 + 3.0 = 8.0`
5. **計算機サービス**が結果を返す: `"5.00 + 3.00 = 8.00"`
6. **AI**が結果を受け取り、自然な応答をフォーマット
7. **あなた**が応答を受け取る: 「5と3の合計は8です」

## 次のステップ

さらなる例については、[第4章: 実用サンプル](../README.md)をご覧ください。

---

**免責事項**:  
この文書は、AI翻訳サービス [Co-op Translator](https://github.com/Azure/co-op-translator) を使用して翻訳されています。正確性を追求しておりますが、自動翻訳には誤りや不正確な部分が含まれる可能性があります。元の言語で記載された文書を正式な情報源としてお考えください。重要な情報については、専門の人間による翻訳を推奨します。この翻訳の使用に起因する誤解や誤解について、当社は責任を負いません。
