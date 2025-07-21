<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T16:01:40+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "ja"
}
-->
# コア生成AI技術

>**Note**: この章には、完成したサンプルを実行するための詳細な[**チュートリアル**](./TUTORIAL.md)が含まれています。

## 学べること
この章では、4つのコア生成AI技術を実践的な例を通じて学びます：
- LLMの補完とチャットフロー
- 関数呼び出し
- 検索強化生成（RAG）
- 責任あるAIの安全対策

## 目次

- [学べること](../../../03-CoreGenerativeAITechniques)
- [前提条件](../../../03-CoreGenerativeAITechniques)
- [はじめに](../../../03-CoreGenerativeAITechniques)
- [例の概要](../../../03-CoreGenerativeAITechniques)
  - [1. LLMの補完とチャットフロー](../../../03-CoreGenerativeAITechniques)
  - [2. LLMを使った関数とプラグイン](../../../03-CoreGenerativeAITechniques)
  - [3. 検索強化生成（RAG）](../../../03-CoreGenerativeAITechniques)
  - [4. 責任あるAIの安全性デモ](../../../03-CoreGenerativeAITechniques)
- [まとめ](../../../03-CoreGenerativeAITechniques)
- [次のステップ](../../../03-CoreGenerativeAITechniques)

## 前提条件

- [第2章](../../../02-SetupDevEnvironment)でのセットアップが完了していること

## はじめに

1. **例のディレクトリに移動**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **環境を設定**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **例をコンパイルして実行**:  
```bash
   # Run completions example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
   
   # Run functions example  
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
   
   # Run RAG example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
   
   # Run responsible AI demo
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
   ```  

## 例の概要

例は`examples/`フォルダに以下の構造で整理されています：

```
examples/
├── src/main/java/com/example/genai/techniques/
│   ├── completions/
│   │   └── LLMCompletionsApp.java        # Basic completions 
│   ├── functions/
│   │   └── FunctionsApp.java             # Function calling examples
│   ├── rag/
│   │   └── SimpleReaderDemo.java         # Retrieval-Augmented Generation
│   └── responsibleai/
│       └── ResponsibleGithubModels.java  # Responsible AI safety demonstration
├── document.txt                          # Sample document for RAG example
└── pom.xml                               # Maven configuration
```

### 1. LLMの補完とチャットフロー
**ファイル**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

ストリーミング応答とチャット履歴管理を活用して会話型AIを構築する方法を学びます。

この例では以下を示します：
- システムプロンプトを使用したシンプルなテキスト補完
- 履歴管理を伴うマルチターン会話
- インタラクティブなチャットセッション
- パラメータ設定（temperature、max tokens）

### 2. LLMを使った関数とプラグイン
**ファイル**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

カスタム関数や外部APIへのアクセスを通じてAIの能力を拡張します。

この例では以下を示します：
- 天気情報関数の統合
- 電卓関数の実装  
- 1つの会話内での複数の関数呼び出し
- JSONスキーマを用いた関数定義

### 3. 検索強化生成（RAG）
**ファイル**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

AIを独自のドキュメントやデータソースと組み合わせ、正確で文脈に応じた応答を生成する方法を学びます。

この例では以下を示します：
- Azure OpenAI SDKを使用したドキュメントベースの質問応答
- GitHubモデルを用いたRAGパターンの実装

**使用方法**: `document.txt`の内容に関する質問を行い、その文脈に基づいたAI応答を得ることができます。

### 4. 責任あるAIの安全性デモ
**ファイル**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

GitHubモデルのコンテンツフィルタリング機能をテストしながら、AIの安全対策のプレビューを体験します。

この例では以下を示します：
- 潜在的に有害なプロンプトに対するコンテンツフィルタリング
- アプリケーション内での安全応答の処理
- ブロックされるコンテンツの異なるカテゴリ（暴力、ヘイトスピーチ、誤情報）
- 安全違反に対する適切なエラーハンドリング

> **詳細を学ぶ**: これは責任あるAIの概念への導入に過ぎません。倫理、バイアス軽減、プライバシーの考慮、責任あるAIフレームワークに関する詳細は[第5章: 責任ある生成AI](../05-ResponsibleGenAI/README.md)をご覧ください。

## まとめ

この章では、LLMの補完とチャットフロー、AI能力を拡張するための関数呼び出し、検索強化生成（RAG）システムの作成、そして責任あるAIの安全対策を実演しました。

> **NOTE**: 提供された[**チュートリアル**](./TUTORIAL.md)を使ってさらに深く学びましょう。

## 次のステップ

[第4章: 実践的な応用とプロジェクト](../04-PracticalSamples/README.md)

**免責事項**:  
この文書は、AI翻訳サービス [Co-op Translator](https://github.com/Azure/co-op-translator) を使用して翻訳されています。正確性を追求しておりますが、自動翻訳には誤りや不正確な部分が含まれる可能性があることをご承知ください。元の言語で記載された文書が正式な情報源とみなされるべきです。重要な情報については、専門の人間による翻訳を推奨します。この翻訳の使用に起因する誤解や誤認について、当方は一切の責任を負いません。