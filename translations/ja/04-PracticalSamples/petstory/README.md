<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "69dffd84127360d3f9446b89de471abe",
  "translation_date": "2025-07-21T16:51:46+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "ja"
}
-->
# ペットストーリーアプリ

>**Note**: この章には、完成したサンプルを実行する手順を示した[**チュートリアル**](./TUTORIAL.md)が含まれています。

Spring Bootを使用したウェブアプリケーションで、GitHub Modelsを活用してアップロードされたペット画像に基づいたAI生成の説明やストーリーを作成します。

## 目次

- [技術スタック](../../../../04-PracticalSamples/petstory)
- [前提条件](../../../../04-PracticalSamples/petstory)
- [セットアップとインストール](../../../../04-PracticalSamples/petstory)
- [使い方](../../../../04-PracticalSamples/petstory)

## 技術スタック

- **バックエンド**: Spring Boot 3.5.3, Java 21
- **AI統合**: OpenAI Java SDKとGitHub Models
- **セキュリティ**: Spring Security
- **フロントエンド**: ThymeleafテンプレートとBootstrapスタイリング
- **ビルドツール**: Maven
- **AIモデル**: GitHub Models

## 前提条件

- Java 21以上
- Maven 3.9以上
- `models:read`スコープを持つGitHubの個人アクセストークン

## セットアップとインストール

### 1. petstoryアプリケーションディレクトリに移動
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. 環境変数を設定
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. アプリケーションをビルド
```bash
mvn clean compile
```

### 4. アプリケーションを実行
```bash
mvn spring-boot:run
```

## 使い方

1. **アプリケーションにアクセス**: `http://localhost:8080`に移動
2. **画像をアップロード**: 「ファイルを選択」をクリックしてペット画像を選択
3. **画像を分析**: 「画像を分析」をクリックしてAIによる説明を取得
4. **ストーリーを生成**: 「ストーリーを生成」をクリックしてストーリーを作成

**免責事項**:  
この文書は、AI翻訳サービス [Co-op Translator](https://github.com/Azure/co-op-translator) を使用して翻訳されています。正確性を追求しておりますが、自動翻訳には誤りや不正確な部分が含まれる可能性があることをご承知ください。元の言語で記載された文書が正式な情報源とみなされるべきです。重要な情報については、専門の人間による翻訳を推奨します。この翻訳の使用に起因する誤解や誤解釈について、当方は責任を負いません。