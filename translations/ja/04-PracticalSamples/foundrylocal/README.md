# Foundry Local Spring Boot チュートリアル

## 目次

- [前提条件](#前提条件)
- [プロジェクト概要](#プロジェクト概要)
- [コードの理解](#コードの理解)
  - [1. アプリケーション設定 (application.properties)](#1-アプリケーション設定-applicationproperties)
  - [2. メインアプリケーションクラス (Application.java)](#2-メインアプリケーションクラス-applicationjava)
  - [3. AIサービスレイヤー (FoundryLocalService.java)](#3-aiサービスレイヤー-foundrylocalservicejava)
  - [4. プロジェクト依存関係 (pom.xml)](#4-プロジェクト依存関係-pomxml)
- [動作の全体像](#動作の全体像)
- [Foundry Local のセットアップ](#foundry-local-のセットアップ)
- [アプリケーションの実行](#アプリケーションの実行)
- [期待される出力](#期待される出力)
- [次のステップ](#次のステップ)
- [トラブルシューティング](#トラブルシューティング)


## 前提条件

このチュートリアルを始める前に、以下を確認してください：

- システムに **Java 21以上** がインストールされていること
- プロジェクトをビルドするための **Maven 3.6以上**
- **Foundry Local** がインストールされ、起動していること

### **Foundry Local のインストール:**

> **注意:** Foundry Local CLI は **Windows** と **macOS** のみ対応しています。Linux は [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local)（Python、JavaScript、C#、Rust）経由でサポートされています。

```bash
# ウィンドウズ
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

インストールを確認:
```bash
foundry --version
```


## プロジェクト概要

このプロジェクトは以下の4つの主要コンポーネントで構成されています：

1. **Application.java** - メインの Spring Boot アプリケーションエントリーポイント
2. **FoundryLocalService.java** - AI通信を処理するサービス層
3. **application.properties** - Foundry Local 接続の設定
4. **pom.xml** - Maven 依存関係およびプロジェクト設定

## コードの理解

### 1. アプリケーション設定 (application.properties)

**ファイル:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**内容説明:**
- **base-url**: Foundry Local が動作する場所を指定し、OpenAI API互換のために `/v1` パスを含みます。デフォルトのポートは `5273` です。ポートが異なる場合は、`foundry service status` で確認してください。
- **model** (オプション): テキスト生成に使用するAIモデル名を指定します。**デフォルトでは、アプリケーションは起動時に Foundry Local の `/v1/models` エンドポイントをクエリしてモデルを自動検出するため、設定不要です。** 明示的に設定することで自動検出を上書きできます。

**重要ポイント:** Spring Boot はこれらのプロパティを自動で読み込み、`@Value` アノテーションでアプリケーションに提供します。

### 2. メインアプリケーションクラス (Application.java)

**ファイル:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // ウェブサーバーは不要です
        app.run(args);
    }
```

**内容説明:**
- `@SpringBootApplication` は Spring Boot の自動設定を有効化
- `WebApplicationType.NONE` はWebサーバーではなくコマンドラインアプリであることを示す
- mainメソッドは Spring アプリケーションを起動する

**デモランナー:**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        System.out.println("Calling Foundry Local service...");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
        System.out.println("=========================");
    };
}
```

**内容説明:**
- `@Bean` は Spring が管理するコンポーネントを作成
- `CommandLineRunner` は Spring Boot 起動後にコードを実行
- `foundryLocalService` は Spring によって自動的に注入される（DI）
- AIにテストメッセージを送信し、応答を表示する

### 3. AIサービスレイヤー (FoundryLocalService.java)

**ファイル:** `src/main/java/com/example/FoundryLocalService.java`

#### 設定値の注入:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // 空の場合は自動検出
```

**内容説明:**
- `@Service` はこのクラスがビジネスロジックを提供するサービスであることをSpringに示す
- `@Value` は `application.properties` から設定値を注入
- modelは空文字列がデフォルトで、これにより起動時にFoundry Localが自動検出を行う。これにより、Foundry Local にロードされている任意のモデルで動作可能です。

#### クライアント初期化:
```java
@PostConstruct
public void init() {
    // 明示的に設定されていない場合はFoundry Localからモデルを自動検出する
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // ベースURLには設定から既に/v1が含まれている
            .apiKey("not-needed")            // ローカルサーバーは実際のAPIキーを必要としない
            .build();
}
```

**内容説明:**
- `@PostConstruct` はSpringがサービスを作成後にこのメソッドを実行
- モデルが設定されていなければ、Foundry Localの `/v1/models` エンドポイントを照会し、最初にロードされたモデルを選択
- OpenAIクライアントをローカルFoundry Localに接続するように作成
- `application.properties` の base URL は既に OpenAI API互換の `/v1` を含む
- APIキーはローカル開発なので "not-needed" に設定

#### チャットメソッド:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // 使用するAIモデル
                .addUserMessage(message)         // あなたの質問／プロンプト
                .maxCompletionTokens(150)        // 応答の長さを制限
                .temperature(0.7)                // 創造性の制御（0.0-1.0）
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // API結果からAIの応答を抽出する
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**内容説明:**
- **ChatCompletionCreateParams**: AIリクエストの設定
  - `model`: 使うAIモデルを指定 (必ず `foundry model list` の正確なIDと一致)
  - `addUserMessage`: 会話にユーザーメッセージを追加
  - `maxCompletionTokens`: 応答の最大トークン数制限（リソース節約）
  - `temperature`: ランダム性の制御（0.0は決定的、1.0は創造的）
- **APIコール**: リクエストをFoundry Localに送信
- <strong>レスポンス処理</strong>: AIの応答テキストを安全に抽出
- <strong>エラー処理</strong>: 例外をわかりやすいエラーメッセージでラップ

### 4. プロジェクト依存関係 (pom.xml)

**重要な依存関係:**

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

**内容説明:**
- **spring-boot-starter**: コアの Spring Boot 機能を提供
- **openai-java**: OpenAI公式Java SDKによるAPI通信
- **jackson-databind**: API呼び出しJSONのシリアライズ/デシリアライズ処理

## 動作の全体像

アプリケーション実行時のフローは以下の通りです：

1. <strong>起動</strong>: Spring Boot が起動し、`application.properties` を読み込む
2. <strong>サービス生成</strong>: Spring が `FoundryLocalService` を作成し設定値を注入
3. <strong>モデル検出</strong>: モデル未設定なら Foundry Local の `/v1/models` エンドポイントを呼び、最初のモデルを自動利用
4. <strong>クライアント設定</strong>: `@PostConstruct` によりOpenAIクライアントがFoundry Localへ接続設定
5. <strong>デモ実行</strong>: `CommandLineRunner` が起動後に実行される
6. **AI呼び出し**: `foundryLocalService.chat()` にテストメッセージを渡す
7. **APIリクエスト**: OpenAI互換リクエストをFoundry Localに送信
8. <strong>レスポンス処理</strong>: サービスがAI応答を抽出し返却
9. <strong>表示</strong>: アプリケーションが応答を表示し終了

## Foundry Local のセットアップ

1. [前提条件](#前提条件) セクションの手順に従って **Foundry Local をインストール** してください。

2. <strong>サービスを起動</strong>（まだ起動していない場合）:
   ```bash
   foundry service start
   ```

3. <strong>サービスの状態を確認</strong>し、動作中かと使用ポートをチェック:
   ```bash
   foundry service status
   ```

4. <strong>モデルをダウンロードして実行</strong>（初回実行時にダウンロードされ、以降はキャッシュ使用）:
   ```bash
   foundry model run phi-4-mini
   ```
   これで対話チャットセッションが開きます。`Ctrl+C` で終了可能。モデルはサービスで読み込み続けます。

   > **ヒント:** `foundry model list` を実行して利用可能なモデル一覧を確認できます。`phi-4-mini` の代わりにカタログにある任意のエイリアスを使用可能です（例: より小型かつ高速な `qwen2.5-0.5b` など）。

5. **モデルがロードされていることを確認:**
   ```bash
   foundry service ps
   ```

6. **必要に応じて `application.properties` を更新:**
   - デフォルトの `base-url` (`http://localhost:5273/v1`) はCLIのデフォルトポートに合致しています。`foundry service status` でポートが異なっていれば更新してください。
   - モデルは起動時に <strong>自動検出</strong> されますので設定不要です。

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```


## アプリケーションの実行

### ステップ1: Foundry Local にモデルがロードされていることを確認
```bash
foundry service ps
```

もしモデルがリストされていなければ、ロードしてください:
```bash
foundry model run phi-4-mini
```


### ステップ2: アプリケーションのビルドと実行
別のターミナルで:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

または JARとしてビルドし実行:
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
Hello! I'm Phi, an AI developed by Microsoft. I can assist with a wide variety of 
tasks including answering questions, helping with analysis, creative writing, coding, 
and general conversation. How can I help you today?
=========================
```


## 次のステップ

さらに多くの例は [Chapter 04: Practical samples](../README.md) を参照してください。

## トラブルシューティング

### よくある問題

**「接続拒否」や「サービス利用不可」**
- サービス状態確認: `foundry service status`
- 必要なら再起動: `foundry service restart`
- `application.properties` のポートが `foundry service status` の出力と一致しているか確認
- URLの末尾が `/v1` になっているか確認: `http://localhost:5273/v1`

**起動時に「モデルが見つからない」**
- アプリはモデルを自動検出します。少なくとも1つのモデルがロードされていることを確認: `foundry service ps`
- モデル未ロードなら: `foundry model run phi-4-mini`
- `application.properties` でモデル名を上書きしている場合は、`foundry model list` と名前が一致しているか確認

**「400 Bad Request」エラー**
- base URL に `/v1` が含まれているか確認: `http://localhost:5273/v1`
- コードで `maxCompletionTokens()` を使っているか（非推奨の `maxTokens()` は使わない）

**Maven コンパイルエラー**
- Java 21以上がインストールされているか: `java -version`
- クリーンビルド: `mvn clean compile`
- 依存関係ダウンロード用にインターネット接続があるか確認

<strong>サービス接続問題</strong>
- `Request to local service failed` が表示される場合: `foundry service restart` を実行
- ロードされているモデルを確認: `foundry service ps`
- サービスログを確認: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**免責事項**:  
本書類はAI翻訳サービス [Co-op Translator](https://github.com/Azure/co-op-translator) を使用して翻訳されています。正確性を期していますが、自動翻訳には誤りや不正確な箇所が含まれる可能性があることをご理解ください。原文の母国語版が正式な情報源と見なされます。重要な情報については、専門の人間による翻訳を推奨します。本翻訳の利用による誤解や誤訳について当方は一切の責任を負いかねます。
<!-- CO-OP TRANSLATOR DISCLAIMER END -->