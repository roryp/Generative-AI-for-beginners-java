<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "fe08a184d8a753a0f497673921f77759",
  "translation_date": "2025-11-04T06:40:56+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "ja"
}
-->
# Foundry Local Spring Boot チュートリアル

## 目次

- [前提条件](../../../../04-PracticalSamples/foundrylocal)
- [プロジェクト概要](../../../../04-PracticalSamples/foundrylocal)
- [コードの理解](../../../../04-PracticalSamples/foundrylocal)
  - [1. アプリケーション設定 (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. メインアプリケーションクラス (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. AIサービス層 (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. プロジェクト依存関係 (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [全体の動作](../../../../04-PracticalSamples/foundrylocal)
- [Foundry Localのセットアップ](../../../../04-PracticalSamples/foundrylocal)
- [アプリケーションの実行](../../../../04-PracticalSamples/foundrylocal)
- [期待される出力](../../../../04-PracticalSamples/foundrylocal)
- [次のステップ](../../../../04-PracticalSamples/foundrylocal)
- [トラブルシューティング](../../../../04-PracticalSamples/foundrylocal)

## 前提条件

このチュートリアルを始める前に、以下を確認してください：

- **Java 21以上** がシステムにインストールされていること
- プロジェクトをビルドするための **Maven 3.6+**
- **Foundry Local** がインストールされ、実行されていること

### **Foundry Localのインストール:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```


## プロジェクト概要

このプロジェクトは以下の4つの主要コンポーネントで構成されています：

1. **Application.java** - メインのSpring Bootアプリケーションのエントリポイント
2. **FoundryLocalService.java** - AIとの通信を処理するサービス層
3. **application.properties** - Foundry Local接続の設定
4. **pom.xml** - Maven依存関係とプロジェクト設定

## コードの理解

### 1. アプリケーション設定 (application.properties)

**ファイル:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```


**これが行うこと:**
- **base-url**: Foundry Localが実行されている場所を指定し、OpenAI API互換のための`/v1`パスを含みます。**注意**: Foundry Localは動的にポートを割り当てるため、`foundry service status`を使用して実際のポートを確認してください。
- **model**: テキスト生成に使用するAIモデルの名前とバージョン番号（例: `:1`）。`foundry model list`を使用して、利用可能なモデルとその正確なIDを確認してください。

**重要な概念:** Spring Bootはこれらのプロパティを自動的に読み込み、`@Value`アノテーションを使用してアプリケーションで利用可能にします。

### 2. メインアプリケーションクラス (Application.java)

**ファイル:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```


**これが行うこと:**
- `@SpringBootApplication` はSpring Bootの自動構成を有効にします。
- `WebApplicationType.NONE` はSpringに対して、これはWebサーバーではなくコマンドラインアプリであることを伝えます。
- メインメソッドはSpringアプリケーションを起動します。

**デモランナー:**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
    };
}
```


**これが行うこと:**
- `@Bean` はSpringが管理するコンポーネントを作成します。
- `CommandLineRunner` はSpring Bootが起動した後にコードを実行します。
- `foundryLocalService` はSpringによって自動的に注入されます（依存性注入）。
- AIにテストメッセージを送信し、応答を表示します。

### 3. AIサービス層 (FoundryLocalService.java)

**ファイル:** `src/main/java/com/example/FoundryLocalService.java`

#### 設定の注入:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```


**これが行うこと:**
- `@Service` は、このクラスがビジネスロジックを提供することをSpringに伝えます。
- `@Value` はapplication.propertiesから設定値を注入します。
- `:default-value` の構文は、プロパティが設定されていない場合のフォールバック値を提供します。

#### クライアントの初期化:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```


**これが行うこと:**
- `@PostConstruct` は、Springがサービスを作成した後にこのメソッドを実行します。
- OpenAIクライアントを作成し、ローカルのFoundry Localインスタンスに接続します。
- `application.properties`のbase URLにはすでにOpenAI API互換の`/v1`が含まれています。
- ローカル開発では認証が不要なため、APIキーは"not-needed"に設定されます。

#### チャットメソッド:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Which AI model to use
                .addUserMessage(message)         // Your question/prompt
                .maxCompletionTokens(150)        // Limit response length
                .temperature(0.7)                // Control creativity (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Extract the AI's response from the API result
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```


**これが行うこと:**
- **ChatCompletionCreateParams**: AIリクエストを設定
  - `model`: 使用するAIモデルを指定（`foundry model list`で表示される正確なIDと一致する必要があります）
  - `addUserMessage`: 会話にメッセージを追加
  - `maxCompletionTokens`: 応答の長さを制限（リソース節約のため）
  - `temperature`: ランダム性を制御（0.0 = 決定的、1.0 = 創造的）
- **APIコール**: リクエストをFoundry Localに送信
- **応答処理**: AIのテキスト応答を安全に抽出
- **エラーハンドリング**: 役立つエラーメッセージで例外をラップ

### 4. プロジェクト依存関係 (pom.xml)

**主要な依存関係:**

```xml
<!-- Spring Boot - Application framework -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <version>${spring-boot.version}</version>
</dependency>

<!-- OpenAI Java SDK - For AI API calls -->
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>

<!-- Jackson - JSON processing -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.0</version>
</dependency>
```


**これが行うこと:**
- **spring-boot-starter**: Spring Bootの基本機能を提供
- **openai-java**: OpenAI Java SDKでAPI通信を実現
- **jackson-databind**: APIコールのためのJSONシリアル化/デシリアル化を処理

## 全体の動作

アプリケーションを実行するときの完全なフローは以下の通りです：

1. **起動**: Spring Bootが起動し、`application.properties`を読み込みます。
2. **サービス作成**: Springが`FoundryLocalService`を作成し、設定値を注入します。
3. **クライアント設定**: `@PostConstruct`がOpenAIクライアントを初期化し、Foundry Localに接続します。
4. **デモ実行**: `CommandLineRunner`が起動後に実行されます。
5. **AIコール**: デモがテストメッセージを`foundryLocalService.chat()`に送信します。
6. **APIリクエスト**: サービスがOpenAI互換のリクエストをFoundry Localに送信します。
7. **応答処理**: サービスがAIの応答を抽出して返します。
8. **表示**: アプリケーションが応答を表示して終了します。

## Foundry Localのセットアップ

Foundry Localをセットアップするには、以下の手順を実行してください：

1. **Foundry Localをインストール** [前提条件](../../../../04-PracticalSamples/foundrylocal)セクションの指示に従ってください。

2. **動的に割り当てられたポートを確認** Foundry Localは起動時にポートを自動的に割り当てます。ポートを確認するには以下を使用してください：
   ```bash
   foundry service status
   ```
   
   **オプション**: 特定のポート（例: 5273）を使用したい場合は、手動で設定できます：
   ```bash
   foundry service set --port 5273
   ```


3. **使用するAIモデルをダウンロード** 例えば、`phi-3.5-mini`を以下のコマンドでダウンロードします：
   ```bash
   foundry model run phi-3.5-mini
   ```


4. **application.propertiesファイルを設定** Foundry Localの設定に合わせて以下を更新してください：
   - `base-url`のポートを更新（ステップ2から）、`/v1`を末尾に含めることを確認
   - モデル名をバージョン番号を含めて更新（`foundry model list`で確認）

   例:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```


## アプリケーションの実行

### ステップ1: Foundry Localを起動
```bash
foundry model run phi-3.5-mini
```


### ステップ2: アプリケーションをビルドして実行
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```


## 期待される出力

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi-3.5, a small language model created by Microsoft. I'm currently running 
as the Phi-3.5-mini-instruct model, which is designed to be helpful, harmless, and honest 
in my interactions. I can assist with a wide variety of tasks including answering 
questions, helping with analysis, creative writing, coding, and general conversation. 
Is there something specific you'd like help with today?
=========================
```


## 次のステップ

さらなる例については、[Chapter 04: Practical samples](../README.md) を参照してください。

## トラブルシューティング

### よくある問題

**"Connection refused" または "Service unavailable"**
- Foundry Localが実行されていることを確認してください: `foundry model list`
- Foundry Localが使用している実際のポートを確認してください: `foundry service status`
- 正しいポートで`application.properties`を更新し、URLが`/v1`で終わることを確認してください。
- または、特定のポートを設定する場合: `foundry service set --port 5273`
- Foundry Localを再起動してみてください: `foundry model run phi-3.5-mini`

**"Model not found" または "404 Not Found" エラー**
- 利用可能なモデルとその正確なIDを確認してください: `foundry model list`
- `application.properties`のモデル名を正確に更新し、バージョン番号を含めてください（例: `Phi-3.5-mini-instruct-cuda-gpu:1`）。
- `base-url`が`/v1`で終わることを確認してください: `http://localhost:5273/v1`
- 必要に応じてモデルをダウンロードしてください: `foundry model run phi-3.5-mini`

**"400 Bad Request" エラー**
- base URLが`/v1`を含むことを確認してください: `http://localhost:5273/v1`
- モデルIDが`foundry model list`で表示されるものと正確に一致していることを確認してください。
- コードで`maxCompletionTokens()`を使用していることを確認してください（非推奨の`maxTokens()`ではない）。

**Mavenコンパイルエラー**
- Java 21以上を確認してください: `java -version`
- クリーンビルドを実行してください: `mvn clean compile`
- 依存関係のダウンロードのためにインターネット接続を確認してください。

**アプリケーションは起動するが出力がない**
- Foundry Localが応答していることを確認してください: ブラウザで`http://localhost:5273`を開く
- アプリケーションログで特定のエラーメッセージを確認してください。
- モデルが完全にロードされ、準備が整っていることを確認してください。

---

**免責事項**:  
この文書はAI翻訳サービス[Co-op Translator](https://github.com/Azure/co-op-translator)を使用して翻訳されています。正確性を追求しておりますが、自動翻訳には誤りや不正確な部分が含まれる可能性があります。元の言語で記載された文書を正式な情報源としてお考えください。重要な情報については、専門の人間による翻訳を推奨します。この翻訳の使用に起因する誤解や誤解について、当社は責任を負いません。