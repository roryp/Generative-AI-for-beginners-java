<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "14c0a61ecc1cd2012a9c129236dfdf71",
  "translation_date": "2025-07-29T08:32:01+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "ja"
}
-->
# 実践的な応用とプロジェクト

## 学べること
このセクションでは、Javaを使った生成型AI開発パターンを示す3つの実践的なアプリケーションをデモします：
- クライアント側とサーバー側のAIを組み合わせたマルチモーダルなペットストーリー生成器を作成
- Foundry Local Spring Bootデモを使用したローカルAIモデルの統合を実装
- 電卓の例を使ったModel Context Protocol (MCP)サービスを開発

## 目次

- [イントロダクション](../../../04-PracticalSamples)
  - [Foundry Local Spring Bootデモ](../../../04-PracticalSamples)
  - [ペットストーリー生成器](../../../04-PracticalSamples)
  - [MCP電卓サービス（初心者向けMCPデモ）](../../../04-PracticalSamples)
- [学習の進行](../../../04-PracticalSamples)
- [まとめ](../../../04-PracticalSamples)
- [次のステップ](../../../04-PracticalSamples)

## イントロダクション

この章では、Javaを使った生成型AI開発パターンを示す**サンプルプロジェクト**を紹介します。各プロジェクトは完全に機能し、特定のAI技術、アーキテクチャパターン、ベストプラクティスを示しており、自分のアプリケーションに適応させることができます。

### Foundry Local Spring Bootデモ

**[Foundry Local Spring Bootデモ](foundrylocal/README.md)**は、**OpenAI Java SDK**を使用してローカルAIモデルと統合する方法を示します。このデモでは、Foundry Local上で動作する**Phi-3.5-mini**モデルに接続し、クラウドサービスに依存せずにAIアプリケーションを実行する方法を紹介します。

### ペットストーリー生成器

**[ペットストーリー生成器](petstory/README.md)**は、創造的なペットストーリーを生成する**マルチモーダルAI処理**を示す魅力的なSpring Bootウェブアプリケーションです。このアプリケーションは、ブラウザベースのAIインタラクションにtransformer.jsを使用し、サーバー側処理にOpenAI SDKを組み合わせています。

### MCP電卓サービス（初心者向けMCPデモ）

**[MCP電卓サービス](calculator/README.md)** は、Spring AIを使用した **Model Context Protocol (MCP)** の簡単なデモです。基本的なMCPサーバーを作成し、MCPクライアントとやり取りする方法を示す初心者向けのMCP概念の導入を提供します。

## 学習の進行

これらのプロジェクトは、前の章で学んだ概念を基に構築されています：

1. **シンプルに始める**: Foundry Local Spring Bootデモから始めて、ローカルモデルとの基本的なAI統合を理解
2. **インタラクティブ性を追加**: ペットストーリー生成器に進み、マルチモーダルAIとウェブベースのインタラクションを学ぶ
3. **MCPの基礎を学ぶ**: MCP電卓サービスを試して、Model Context Protocolの基本を理解

## まとめ

お疲れ様でした！以下のような実際のアプリケーションを探索しました：

- ブラウザとサーバーの両方で動作するマルチモーダルAI体験
- 最新のJavaフレームワークとSDKを使用したローカルAIモデルの統合
- AIとツールの統合方法を示す初めてのModel Context Protocolサービス

## 次のステップ

[第5章: 責任ある生成型AI](../05-ResponsibleGenAI/README.md)

**免責事項**:  
この文書は、AI翻訳サービス [Co-op Translator](https://github.com/Azure/co-op-translator) を使用して翻訳されています。正確性を追求しておりますが、自動翻訳には誤りや不正確な部分が含まれる可能性があります。元の言語で記載された文書が正式な情報源と見なされるべきです。重要な情報については、専門の人間による翻訳を推奨します。この翻訳の使用に起因する誤解や誤訳について、当社は一切の責任を負いません。
