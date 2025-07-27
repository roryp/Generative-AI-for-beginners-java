<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "efd82efe50711d7e257eb943151d682c",
  "translation_date": "2025-07-27T13:36:37+00:00",
  "source_file": "02-SetupDevEnvironment/examples/basic-chat-azure/README.md",
  "language_code": "ja"
}
-->
# Azure OpenAIとの基本的なチャット - エンドツーエンドの例

この例では、Azure OpenAIに接続し、セットアップをテストするシンプルなSpring Bootアプリケーションを作成する方法を示します。

## 目次

- [前提条件](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [クイックスタート](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [設定オプション](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [オプション1: 環境変数 (.envファイル) - 推奨](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [オプション2: GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [アプリケーションの実行](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Mavenを使用する場合](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [VS Codeを使用する場合](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [期待される出力](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [設定リファレンス](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [環境変数](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Spring設定](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [トラブルシューティング](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [一般的な問題](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [デバッグモード](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [次のステップ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [リソース](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## 前提条件

この例を実行する前に、以下を確認してください:

- [Azure OpenAIセットアップガイド](../../getting-started-azure-openai.md)を完了していること  
- Azure AI Foundryポータルを通じてAzure OpenAIリソースをデプロイしていること  
- gpt-4o-miniモデル（または代替モデル）をデプロイしていること  
- Azureから取得したAPIキーとエンドポイントURL  

## クイックスタート

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## 設定オプション

### オプション1: 環境変数 (.envファイル) - 推奨

**ステップ1: 設定ファイルを作成する**
```bash
cp .env.example .env
```

**ステップ2: Azure OpenAIの認証情報を追加する**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **セキュリティに関する注意**: 
> - `.env`ファイルをバージョン管理にコミットしないでください
> - `.env`ファイルはすでに`.gitignore`に含まれています
> - APIキーを安全に保管し、定期的にローテーションしてください

### オプション2: GitHub Codespace Secrets

GitHub Codespacesを使用する場合、以下のSecretsをリポジトリに設定してください:
- `AZURE_AI_KEY` - Azure OpenAI APIキー
- `AZURE_AI_ENDPOINT` - Azure OpenAIエンドポイントURL

アプリケーションはこれらのSecretsを自動的に検出して使用します。

### 代替案: 直接環境変数を設定する

<details>
<summary>プラットフォーム別のコマンドを表示</summary>

**Linux/macOS (bash/zsh):**
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (コマンドプロンプト):**
```cmd
set AZURE_AI_KEY=your-actual-api-key-here
set AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (PowerShell):**
```powershell
$env:AZURE_AI_KEY="your-actual-api-key-here"
$env:AZURE_AI_ENDPOINT="https://your-hub-name.openai.azure.com/"
```
</details>

## アプリケーションの実行

### Mavenを使用する場合

```bash
mvn spring-boot:run
```

### VS Codeを使用する場合

1. プロジェクトをVS Codeで開く
2. `F5`を押すか、「Run and Debug」パネルを使用する
3. "Spring Boot-BasicChatApplication"構成を選択する

> **注意**: VS Codeの構成は自動的に`.env`ファイルを読み込みます

### 期待される出力

```
Starting Basic Chat with Azure OpenAI...
Environment variables loaded successfully
Connecting to Azure OpenAI...
Sending prompt: What is AI in a short sentence? Max 100 words.

AI Response:
================
AI, or Artificial Intelligence, is the simulation of human intelligence in machines programmed to think and learn like humans.
================

Success! Azure OpenAI connection is working correctly.
```

## 設定リファレンス

### 環境変数

| 変数 | 説明 | 必須 | 例 |
|------|------|------|----|
| `AZURE_AI_KEY` | Azure OpenAI APIキー | 必須 | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAIエンドポイントURL | 必須 | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | モデルデプロイメント名 | 任意 | `gpt-4o-mini` (デフォルト) |

### Spring設定

`application.yml`ファイルで以下を設定します:
- **APIキー**: `${AZURE_AI_KEY}` - 環境変数から取得
- **エンドポイント**: `${AZURE_AI_ENDPOINT}` - 環境変数から取得  
- **モデル**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - 環境変数から取得し、デフォルト値を使用
- **温度**: `0.7` - 創造性を制御 (0.0 = 決定論的, 1.0 = 創造的)
- **最大トークン数**: `500` - 応答の最大長

## トラブルシューティング

### 一般的な問題

<details>
<summary><strong>エラー: "APIキーが無効です"</strong></summary>

- `.env`ファイルに`AZURE_AI_KEY`が正しく設定されていることを確認してください
- Azure AI FoundryポータルからAPIキーを正確にコピーしたことを確認してください
- キーの周囲に余分なスペースや引用符がないことを確認してください
</details>

<details>
<summary><strong>エラー: "エンドポイントが無効です"</strong></summary>

- `AZURE_AI_ENDPOINT`が完全なURLを含んでいることを確認してください (例: `https://your-hub-name.openai.azure.com/`)
- 末尾のスラッシュの一貫性を確認してください
- エンドポイントがAzureのデプロイメント地域と一致していることを確認してください
</details>

<details>
<summary><strong>エラー: "デプロイメントが見つかりません"</strong></summary>

- モデルデプロイメント名がAzureでデプロイされたものと完全に一致していることを確認してください
- モデルが正常にデプロイされており、アクティブであることを確認してください
- デフォルトのデプロイメント名`gpt-4o-mini`を試してください
</details>

<details>
<summary><strong>VS Code: 環境変数が読み込まれない</strong></summary>

- `.env`ファイルがプロジェクトのルートディレクトリ（`pom.xml`と同じ階層）にあることを確認してください
- VS Codeの統合ターミナルで`mvn spring-boot:run`を実行してみてください
- VS Code Java拡張機能が正しくインストールされていることを確認してください
- 起動構成に`"envFile": "${workspaceFolder}/.env"`が含まれていることを確認してください
</details>

### デバッグモード

詳細なログを有効にするには、`application.yml`内の以下の行をコメント解除してください:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## 次のステップ

**セットアップ完了！** 学習を続けましょう:

[第3章: コア生成AI技術](../../../03-CoreGenerativeAITechniques/README.md)

## リソース

- [Spring AI Azure OpenAI ドキュメント](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Azure OpenAI サービス ドキュメント](https://learn.microsoft.com/azure/ai-services/openai/)
- [Azure AI Foundry ポータル](https://ai.azure.com/)
- [Azure AI Foundry ドキュメント](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**免責事項**:  
この文書は、AI翻訳サービス [Co-op Translator](https://github.com/Azure/co-op-translator) を使用して翻訳されています。正確性を追求しておりますが、自動翻訳には誤りや不正確な部分が含まれる可能性があることをご承知おきください。元の言語で記載された文書が公式な情報源とみなされるべきです。重要な情報については、専門の人間による翻訳を推奨します。この翻訳の使用に起因する誤解や誤認について、当方は一切の責任を負いません。