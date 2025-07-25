<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "139c227ef39d24287257d1aff6fc6973",
  "translation_date": "2025-07-25T09:03:56+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "ja"
}
-->
# 実践的な応用とプロジェクト

> 注: 各例には、サンプルの実行方法を案内する**TUTORIAL.md**が含まれています。

## 学べること
このセクションでは、Javaを使った生成AI開発パターンを紹介する3つの実践的なアプリケーションをデモします：
- クライアントサイドとサーバーサイドのAIを組み合わせたマルチモーダルなペットストーリー生成ツールを作成
- Foundry Local Spring Bootデモを使用してローカルAIモデル統合を実装
- 電卓の例を使ってModel Context Protocol (MCP) サービスを開発

## 目次

- [はじめに](../../../04-PracticalSamples)
  - [Foundry Local Spring Bootデモ](../../../04-PracticalSamples)
  - [ペットストーリー生成ツール](../../../04-PracticalSamples)
  - [MCP電卓サービス（初心者向けMCPデモ）](../../../04-PracticalSamples)
- [学習の進め方](../../../04-PracticalSamples)
- [まとめ](../../../04-PracticalSamples)
- [次のステップ](../../../04-PracticalSamples)

## はじめに

この章では、Javaを使った生成AI開発パターンを示す**サンプルプロジェクト**を紹介します。各プロジェクトは完全に動作可能で、特定のAI技術、アーキテクチャパターン、ベストプラクティスを示しており、自分のアプリケーションに応用できます。

### Foundry Local Spring Bootデモ

**[Foundry Local Spring Bootデモ](foundrylocal/README.md)**は、**OpenAI Java SDK**を使用してローカルAIモデルと統合する方法を示します。このデモでは、Foundry Local上で動作する**Phi-3.5-mini**モデルに接続し、クラウドサービスに依存せずにAIアプリケーションを実行する方法を紹介します。

### ペットストーリー生成ツール

**[ペットストーリー生成ツール](petstory/README.md)**は、創造的なペットストーリーを生成する**マルチモーダルAI処理**をデモする、魅力的なSpring Bootウェブアプリケーションです。このツールは、ブラウザベースのAIインタラクションにtransformer.jsを使用し、サーバーサイド処理にOpenAI SDKを組み合わせています。

### MCP電卓サービス（初心者向けMCPデモ）

**[MCP電卓サービス](mcp/calculator/README.md)**は、Spring AIを使用した**Model Context Protocol (MCP)**のシンプルなデモです。MCPの基本概念を初心者向けに紹介し、MCPクライアントとやり取りする基本的なMCPサーバーの作成方法を示します。

## 学習の進め方

これらのプロジェクトは、前の章で学んだ概念を基に構築されています：

1. **シンプルに始める**: Foundry Local Spring Bootデモから始め、ローカルモデルとの基本的なAI統合を理解
2. **インタラクティブ性を追加**: ペットストーリー生成ツールに進み、マルチモーダルAIとウェブベースのインタラクションを学ぶ
3. **MCPの基礎を学ぶ**: MCP電卓サービスを試して、Model Context Protocolの基本を理解

## まとめ

**おめでとうございます！** 以下を達成しました：

- クライアントサイドとサーバーサイドのAI処理を組み合わせた**マルチモーダルAI体験**を作成
- 最新のJavaフレームワークとSDKを使用して**ローカルAIモデル統合**を実装
- ツール統合パターンを示す**Model Context Protocolサービス**を開発

## 次のステップ

[第5章: 責任ある生成AI](../05-ResponsibleGenAI/README.md)

**免責事項**:  
この文書は、AI翻訳サービス [Co-op Translator](https://github.com/Azure/co-op-translator) を使用して翻訳されています。正確性を追求しておりますが、自動翻訳には誤りや不正確な部分が含まれる可能性があることをご承知ください。元の言語で記載された文書が正式な情報源とみなされるべきです。重要な情報については、専門の人間による翻訳を推奨します。この翻訳の使用に起因する誤解や誤解釈について、当方は一切の責任を負いません。