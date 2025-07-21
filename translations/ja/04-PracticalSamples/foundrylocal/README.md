<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T16:34:30+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "ja"
}
-->
# Foundry Local コマンドラインアプリケーション

>**Note**: この章には、完成したサンプルを実行する手順を案内する[**チュートリアル**](./TUTORIAL.md)が含まれています。

OpenAI Java SDK を使用して Foundry Local に接続する方法を示す、シンプルな Spring Boot コマンドラインアプリケーションです。

## 学べること

- OpenAI Java SDK を使用して Spring Boot アプリケーションに Foundry Local を統合する方法
- ローカル AI 開発とテストのベストプラクティス

## 目次

- [学べること](../../../../04-PracticalSamples/foundrylocal)
- [前提条件](../../../../04-PracticalSamples/foundrylocal)
  - [Foundry Local のインストール](../../../../04-PracticalSamples/foundrylocal)
  - [動作確認](../../../../04-PracticalSamples/foundrylocal)
- [設定](../../../../04-PracticalSamples/foundrylocal)
- [クイックスタート](../../../../04-PracticalSamples/foundrylocal)
- [アプリケーションの動作](../../../../04-PracticalSamples/foundrylocal)
- [サンプル出力](../../../../04-PracticalSamples/foundrylocal)
- [アーキテクチャ](../../../../04-PracticalSamples/foundrylocal)
- [コードのハイライト](../../../../04-PracticalSamples/foundrylocal)
  - [OpenAI Java SDK の統合](../../../../04-PracticalSamples/foundrylocal)
  - [Chat Completion API](../../../../04-PracticalSamples/foundrylocal)
- [トラブルシューティング](../../../../04-PracticalSamples/foundrylocal)

## 前提条件

> **⚠️ Note**: このアプリケーションは **提供されている devcontainer 内では動作しません**。ホストシステムに Foundry Local をインストールして実行する必要があります。

### Foundry Local のインストール

このアプリケーションを実行する前に、Foundry Local をインストールして起動する必要があります。以下の手順に従ってください：

1. **システム要件を確認する**:
   - **オペレーティングシステム**: Windows 10 (x64)、Windows 11 (x64/ARM)、Windows Server 2025、または macOS
   - **ハードウェア**: 
     - 最低要件: 8GB RAM、3GB の空きディスク容量
     - 推奨要件: 16GB RAM、15GB の空きディスク容量
   - **ネットワーク**: 初回モデルダウンロード用のインターネット接続（オフライン使用の場合は不要）
   - **アクセラレーション（オプション）**: NVIDIA GPU (2000 シリーズ以降)、AMD GPU (6000 シリーズ以降)、Qualcomm Snapdragon X Elite (8GB 以上のメモリ)、または Apple シリコン
   - **権限**: デバイスにソフトウェアをインストールするための管理者権限

2. **Foundry Local をインストールする**:
   
   **Windows の場合:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **macOS の場合:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   または、[Foundry Local GitHub リポジトリ](https://github.com/microsoft/Foundry-Local)からインストーラーをダウンロードすることもできます。

3. **最初のモデルを起動する**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   モデルがダウンロードされ（インターネット速度によって数分かかる場合があります）、その後実行されます。Foundry Local はシステムに最適なモデルバリアント（NVIDIA GPU 用の CUDA、または CPU バージョン）を自動的に選択します。

4. **モデルをテストする**: 同じターミナルで質問を入力します：

   ```bash
   Why is the sky blue?
   ```

   空が青く見える理由を説明する Phi モデルからの応答が表示されるはずです。

### 動作確認

以下のコマンドで正常に動作しているか確認できます：

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

また、ブラウザで `http://localhost:5273` にアクセスして Foundry Local のウェブインターフェースを確認することもできます。

## 設定

このアプリケーションは `application.properties` を通じて設定できます：

- `foundry.local.base-url` - Foundry Local のベース URL（デフォルト: http://localhost:5273）
- `foundry.local.model` - 使用する AI モデル（デフォルト: Phi-3.5-mini-instruct-cuda-gpu）

> **Note**: 設定内のモデル名は、Foundry Local がシステムにダウンロードした特定のバリアントと一致する必要があります。`foundry model run phi-3.5-mini` を実行すると、Foundry Local は最適なバリアント（NVIDIA GPU 用の CUDA、または CPU バージョン）を自動的に選択してダウンロードします。ローカルインスタンスで利用可能な正確なモデル名を確認するには、`foundry model list` を使用してください。

## クイックスタート

### 1. Foundry Local アプリケーションディレクトリに移動
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. アプリケーションを実行

```bash
mvn spring-boot:run
```

または JAR をビルドして実行：

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### 依存関係

このアプリケーションは、Foundry Local と通信するために OpenAI Java SDK を使用します。主な依存関係は以下の通りです：

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

アプリケーションは、デフォルトポートで動作する Foundry Local に接続するように事前設定されています。

## アプリケーションの動作

アプリケーションを実行すると：

1. **コマンドラインアプリケーション**として起動します（ウェブサーバーはありません）
2. **テストメッセージ**を自動的に送信します: "Hello! Can you tell me what you are and what model you're running?"
3. **Foundry Local からの応答**をコンソールに表示します
4. **デモ終了後に正常終了**します

## サンプル出力

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## アーキテクチャ

- **Application.java** - CommandLineRunner を持つメインの Spring Boot アプリケーション
- **FoundryLocalService.java** - OpenAI Java SDK を使用して Foundry Local と通信するサービス
- **OpenAI Java SDK** を使用した型安全な API 呼び出し
- SDK による自動 JSON シリアル化/デシリアル化
- Spring の `@Value` と `@PostConstruct` アノテーションを使用したクリーンな設定

## コードのハイライト

### OpenAI Java SDK の統合

アプリケーションは、Foundry Local 用に設定されたクライアントを作成するために OpenAI Java SDK を使用します：

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### Chat Completion API

チャット補完リクエストはシンプルで型安全です：

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## トラブルシューティング

接続エラーが発生した場合：
1. Foundry Local が `http://localhost:5273` で動作していることを確認してください
2. `foundry model list` を使用して Phi-3.5-mini モデルバリアントが利用可能であることを確認してください
3. `application.properties` 内のモデル名がリストに表示される正確なモデル名と一致していることを確認してください
4. ファイアウォールが接続をブロックしていないことを確認してください

よくある問題：
- **モデルが見つからない**: `foundry model run phi-3.5-mini` を実行してモデルをダウンロードして起動してください
- **サービスが動作していない**: Foundry Local サービスが停止している可能性があります。モデル実行コマンドで再起動してください
- **モデル名が間違っている**: `foundry model list` を使用して利用可能なモデルを確認し、設定を更新してください

**免責事項**:  
この文書は、AI翻訳サービス [Co-op Translator](https://github.com/Azure/co-op-translator) を使用して翻訳されています。正確性を追求しておりますが、自動翻訳には誤りや不正確な部分が含まれる可能性があることをご承知ください。元の言語で記載された文書が正式な情報源とみなされるべきです。重要な情報については、専門の人間による翻訳を推奨します。この翻訳の使用に起因する誤解や誤解釈について、当方は責任を負いません。