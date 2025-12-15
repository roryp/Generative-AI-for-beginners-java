<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "afc90918d008cf77fd1982691f681306",
  "translation_date": "2025-10-03T08:30:59+00:00",
  "source_file": "AGENTS.md",
  "language_code": "ja"
}
-->
# AGENTS.md

## プロジェクト概要

このリポジトリは、Javaを使用した生成型AI開発を学ぶための教育用リポジトリです。大規模言語モデル（LLM）、プロンプトエンジニアリング、埋め込み、RAG（検索強化生成）、およびモデルコンテキストプロトコル（MCP）を網羅した実践的なコースを提供します。

**主要技術:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models、Azure OpenAI、OpenAI SDKs

**アーキテクチャ:**
- 章ごとに整理された複数の独立したSpring Bootアプリケーション
- 異なるAIパターンを示すサンプルプロジェクト
- 開発コンテナが事前設定されたGitHub Codespaces対応

## セットアップコマンド

### 前提条件
- Java 21以上
- Maven 3.x
- GitHub個人アクセストークン（GitHub Models用）
- オプション: Azure OpenAIの認証情報

### 環境セットアップ

**オプション1: GitHub Codespaces（推奨）**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**オプション2: ローカル開発コンテナ**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**オプション3: ローカルセットアップ**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### 設定

**GitHubトークンの設定:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Azure OpenAIの設定（オプション）:**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## 開発ワークフロー

### プロジェクト構造
```
/
├── 01-IntroToGenAI/              # Chapter 1: Introduction
├── 02-SetupDevEnvironment/       # Chapter 2: Environment setup
│   └── examples/                 # Working examples
├── 03-CoreGenerativeAITechniques/ # Chapter 3: Core techniques
├── 04-PracticalSamples/          # Chapter 4: Sample projects
│   ├── calculator/               # MCP service example
│   ├── foundrylocal/            # Local model integration
│   └── petstory/                # Multi-modal app
├── 05-ResponsibleGenAI/         # Chapter 5: Responsible AI
└── translations/                # Multi-language support
```

### アプリケーションの実行

**Spring Bootアプリケーションの実行:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**プロジェクトのビルド:**
```bash
cd [project-directory]
mvn clean install
```

**MCP計算サーバーの起動:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**クライアント例の実行:**
```bash
# After starting the server in another terminal
cd 04-PracticalSamples/calculator

# Direct MCP client
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient"

# AI-powered client (requires GITHUB_TOKEN)
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient"

# Interactive bot
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.Bot"
```

### ホットリロード
Spring Boot DevToolsがホットリロードをサポートするプロジェクトに含まれています:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## テスト手順

### テストの実行

**プロジェクト内のすべてのテストを実行:**
```bash
cd [project-directory]
mvn test
```

**詳細出力でテストを実行:**
```bash
mvn test -X
```

**特定のテストクラスを実行:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### テスト構造
- テストファイルはJUnit 5（Jupiter）を使用
- テストクラスは`src/test/java/`に配置
- 計算プロジェクトのクライアント例は`src/test/java/com/microsoft/mcp/sample/client/`に配置

### 手動テスト
多くの例はインタラクティブなアプリケーションであり、手動テストが必要です:

1. `mvn spring-boot:run`でアプリケーションを起動
2. エンドポイントをテストするかCLIと対話
3. 各プロジェクトのREADME.mdに記載されたドキュメントと期待される動作が一致することを確認

### GitHub Modelsを使用したテスト
- 無料プランの制限: 15リクエスト/分、150リクエスト/日
- 最大5つの同時リクエスト
- 責任あるAI例を使用してコンテンツフィルタリングをテスト

## コードスタイルガイドライン

### Javaの規約
- **Javaバージョン:** Java 21の最新機能を使用
- **スタイル:** 標準的なJavaの規約に従う
- **命名規則:** 
  - クラス: PascalCase
  - メソッド/変数: camelCase
  - 定数: UPPER_SNAKE_CASE
  - パッケージ名: 小文字

### Spring Bootのパターン
- ビジネスロジックには`@Service`を使用
- RESTエンドポイントには`@RestController`を使用
- 設定は`application.yml`または`application.properties`で管理
- ハードコードされた値より環境変数を推奨
- MCPで公開されるメソッドには`@Tool`アノテーションを使用

### ファイル構成
```
src/
├── main/
│   ├── java/
│   │   └── com/microsoft/[component]/
│   │       ├── [Component]Application.java
│   │       ├── config/
│   │       ├── controller/
│   │       ├── service/
│   │       └── exception/
│   └── resources/
│       ├── application.yml
│       └── static/
└── test/
    └── java/
        └── com/microsoft/[component]/
```

### 依存関係
- Mavenの`pom.xml`で管理
- Spring AI BOMでバージョン管理
- LangChain4jでAI統合
- Spring BootスターターペアレントでSpring依存関係を管理

### コードコメント
- 公開APIにはJavaDocを追加
- 複雑なAIの相互作用には説明コメントを含める
- MCPツールの説明を明確に記述

## ビルドとデプロイ

### プロジェクトのビルド

**テストなしでビルド:**
```bash
mvn clean install -DskipTests
```

**すべてのチェックを含めてビルド:**
```bash
mvn clean install
```

**アプリケーションをパッケージ化:**
```bash
mvn package
# Creates JAR in target/ directory
```

### 出力ディレクトリ
- コンパイル済みクラス: `target/classes/`
- テストクラス: `target/test-classes/`
- JARファイル: `target/*.jar`
- Mavenアーティファクト: `target/`

### 環境別設定

**開発環境:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**本番環境:**
- GitHub Modelsの代わりにAzure AI Foundry Modelsを使用
- ベースURLをAzure OpenAIエンドポイントに更新
- Azure Key Vaultまたは環境変数で秘密情報を管理

### デプロイに関する注意点
- このリポジトリは教育用でサンプルアプリケーションを含む
- 現状では本番環境向けに設計されていない
- サンプルは本番環境で使用するためのパターンを示す
- 個々のプロジェクトのREADMEを参照して具体的なデプロイノートを確認

## 追加の注意事項

### GitHub ModelsとAzure OpenAIの比較
- **GitHub Models:** 学習用の無料プラン、クレジットカード不要
- **Azure OpenAI:** 本番環境向け、Azureサブスクリプションが必要
- 両者間でコードは互換性あり - エンドポイントとAPIキーを変更するだけ

### 複数プロジェクトの扱い
各サンプルプロジェクトは独立しています:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### よくある問題

**Javaバージョンの不一致:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**依存関係のダウンロード問題:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHubトークンが見つからない:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**ポートがすでに使用中:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### 多言語対応
- ドキュメントは45以上の言語で利用可能（自動翻訳）
- 翻訳は`translations/`ディレクトリに保存
- 翻訳はGitHub Actionsワークフローで管理

### 学習パス
1. [02-開発環境のセットアップ](02-SetupDevEnvironment/README.md)から始める
2. 章を順番に進める（01 → 05）
3. 各章の実践例を完了する
4. 第4章のサンプルプロジェクトを探索する
5. 第5章で責任あるAIの実践を学ぶ

### 開発コンテナ
`.devcontainer/devcontainer.json`で以下を設定:
- Java 21開発環境
- Maven事前インストール済み
- VS Code Java拡張機能
- Spring Bootツール
- GitHub Copilot統合
- Docker-in-Dockerサポート
- Azure CLI

### パフォーマンスに関する注意点
- GitHub Modelsの無料プランにはレート制限あり
- 埋め込みには適切なバッチサイズを使用
- 繰り返しAPI呼び出しにはキャッシュを検討
- コスト最適化のためにトークン使用量を監視

### セキュリティに関する注意点
- `.env`ファイルをコミットしない（すでに`.gitignore`に含まれている）
- APIキーには環境変数を使用
- GitHubトークンは必要最小限のスコープにする
- 第5章で責任あるAIガイドラインに従う

---

**免責事項**:  
この文書は、AI翻訳サービス [Co-op Translator](https://github.com/Azure/co-op-translator) を使用して翻訳されています。正確性を追求しておりますが、自動翻訳には誤りや不正確な部分が含まれる可能性があることをご承知ください。元の言語で記載された文書が正式な情報源とみなされるべきです。重要な情報については、専門の人間による翻訳を推奨します。この翻訳の使用に起因する誤解や誤解釈について、当方は責任を負いません。
