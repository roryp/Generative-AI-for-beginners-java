# 実践的な応用とプロジェクト

[![実践的な応用とプロジェクト](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "Practical Applications & Projects")

> **ビデオ概要:** [YouTubeで「実践的な応用とプロジェクト」を見る](https://www.youtube.com/watch?v=01vJsYei3H0)。

## 学べること
このセクションでは、Javaによる生成AI開発パターンを紹介する3つの実践的なアプリケーションをデモします：
- クライアントサイドとサーバーサイドのAIを組み合わせたマルチモーダルなペットストーリージェネレーターの作成
- Foundry Local Spring BootデモによるローカルAIモデル統合の実装
- 計算機の例を使ったモデルコンテキストプロトコル（MCP）サービスの開発

## 目次

- [イントロダクション](#イントロダクション)
  - [Foundry Local Spring Bootデモ](#foundry-local-spring-bootデモ)
  - [ペットストーリージェネレーター](#ペットストーリージェネレーター)
  - [MCP計算機サービス（初心者向けMCPデモ）](#mcp計算機サービス（初心者向けmcpデモ）)
- [学習の進行](#学習の進行)
- [まとめ](#まとめ)
- [次のステップ](#次のステップ)

## イントロダクション

この章では、Javaでの生成AI開発パターンを示す<strong>サンプルプロジェクト</strong>を紹介します。各プロジェクトは完全に機能し、特定のAI技術、アーキテクチャパターン、ベストプラクティスを実演しており、自分のアプリケーションに適用できます。

### Foundry Local Spring Bootデモ

**[Foundry Local Spring Bootデモ](foundrylocal/README.md)** は、<strong>OpenAI Java SDK</strong>を使ったローカルAIモデルとの統合を示します。Foundry Local上で動作する<strong>Phi-3.5-mini</strong>モデルへの接続をデモしており、クラウドサービスに依存せずにAIアプリケーションを実行できます。

### ペットストーリージェネレーター

**[ペットストーリージェネレーター](petstory/README.md)** は、創造的なペットの物語を生成する<strong>マルチモーダルAI処理</strong>を示す魅力的なSpring Bootウェブアプリケーションです。transformer.jsを利用したブラウザベースのAI対話と、サーバーサイド処理にはOpenAI SDKを組み合わせています。

### MCP計算機サービス（初心者向けMCPデモ）

**[MCP計算機サービス](calculator/README.md)** は、Spring AIを使った<strong>モデルコンテキストプロトコル（MCP）</strong>のシンプルなデモです。MCPの概念を初心者向けに紹介し、MCPクライアントと連携できる基本的なMCPサーバーの作成方法を示します。

## 学習の進行

これらのプロジェクトは、前章の概念を基に構築するよう設計されています：

1. <strong>シンプルに始める</strong>：Foundry Local Spring Bootデモでローカルモデルとの基本的なAI統合を理解
2. <strong>インタラクティブに進む</strong>：ペットストーリージェネレーターでマルチモーダルAIおよびウェブベースの対話を体験
3. **MCPの基礎を学ぶ**：MCP計算機サービスでモデルコンテキストプロトコルの基本を理解

## まとめ

よく頑張りました！これで実際のアプリケーションをいくつか探求しました：

- ブラウザとサーバーの両方で動作するマルチモーダルAI体験
- 最新のJavaフレームワークとSDKを使ったローカルAIモデル統合
- ツールがAIと連携する様子を示す最初のモデルコンテキストプロトコルサービス

## 次のステップ

[第5章: 責任ある生成AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**免責事項**:  
本書類はAI翻訳サービス [Co-op Translator](https://github.com/Azure/co-op-translator) を使用して翻訳されています。正確性の確保に努めていますが、自動翻訳には誤りや不正確な箇所が含まれている可能性があります。原文のネイティブ言語による文書が権威ある情報源と見なされるべきです。重要な情報については、専門の人間による翻訳を推奨します。本翻訳の利用により生じる誤解や誤訳について、当方は一切の責任を負いかねます。
<!-- CO-OP TRANSLATOR DISCLAIMER END -->