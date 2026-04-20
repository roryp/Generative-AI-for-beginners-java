# 実践的な応用とプロジェクト

[![実践的な応用とプロジェクト](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "Practical Applications & Projects")

> **ビデオ概要:** [YouTubeで「実践的な応用とプロジェクト」を見る](https://www.youtube.com/watch?v=01vJsYei3H0)。

## 学ぶ内容
このセクションでは、Javaを使った生成AI開発パターンを示す3つの実践的なアプリケーションをデモします：
- クライアントサイドとサーバーサイドのAIを組み合わせたマルチモーダルペットストーリージェネレーターの作成
- Foundry Local Spring BootデモでのローカルAIモデル統合の実装
- 計算機の例を使ったモデル・コンテキスト・プロトコル（MCP）サービスの開発

## 目次

- [はじめに](#はじめに)
  - [Foundry Local Spring Bootデモ](#foundry-local-spring-bootデモ)
  - [ペットストーリージェネレーター](#ペットストーリージェネレーター)
  - [MCP計算機サービス（初心者向けMCPデモ）](#mcp計算機サービス（初心者向けmcpデモ）)
- [学習の進行](#学習の進行)
- [まとめ](#まとめ)
- [次のステップ](#次のステップ)

## はじめに

この章では、Javaを使った生成AI開発パターンを示す<strong>サンプルプロジェクト</strong>を紹介します。各プロジェクトは完全に機能し、特定のAI技術、アーキテクチャパターン、および独自のアプリケーションに適用可能なベストプラクティスを示しています。

### Foundry Local Spring Bootデモ

**[Foundry Local Spring Bootデモ](foundrylocal/README.md)** は、<strong>OpenAI Java SDK</strong>を使ってローカルAIモデルと統合する方法を示しています。Foundry Local上で動作するモデル（例：**Phi-4-mini**）への接続や自動モデル検出を紹介し、クラウドサービスに依存せずにAIアプリケーションを実行できることを示します。

### ペットストーリージェネレーター

**[ペットストーリージェネレーター](petstory/README.md)** は、マルチモーダルAI処理を利用して創造的なペットストーリーを生成する魅力的なSpring Bootウェブアプリケーションです。ブラウザベースのAI対話にtransformer.jsを、サーバーサイド処理にはOpenAI SDKを利用し、クライアント・サイドとサーバー・サイドのAI機能を組み合わせています。

### MCP計算機サービス（初心者向けMCPデモ）

**[MCP計算機サービス](calculator/README.md)** は、Spring AIを使った<strong>モデル・コンテキスト・プロトコル（MCP）</strong>の簡単なデモです。MCPの基本概念を初心者向けに紹介し、MCPクライアントと連携する基本的なMCPサーバーの作成方法を示しています。

## 学習の進行

これらのプロジェクトは前の章の概念をもとに構築されています：

1. <strong>シンプルに始める</strong>: Foundry Local Spring Bootデモから始めてローカルモデルと基本的なAI統合を理解
2. <strong>インタラクティブ性を加える</strong>: ペットストーリージェネレーターでマルチモーダルAIとウェブベースの対話を体験
3. **MCPの基本を学ぶ**: MCP計算機サービスでモデル・コンテキスト・プロトコルの基礎を理解

## まとめ

よくできました！実際のアプリケーションをいくつか体験しました：

- ブラウザとサーバーの両方で動作するマルチモーダルAI体験
- 最新のJavaフレームワークとSDKを使ったローカルAIモデル統合
- ツールがAIとどのように連携するかを示す初めてのモデル・コンテキスト・プロトコルサービス

## 次のステップ

[第5章：責任ある生成AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**免責事項**:  
本書類は AI 翻訳サービス [Co-op Translator](https://github.com/Azure/co-op-translator) を使用して翻訳されています。正確性を期していますが、自動翻訳には誤りや不正確な部分が含まれる可能性があることをご了承ください。原文の母語版が権威ある情報源とみなされるべきです。重要な情報については専門の人間による翻訳を推奨します。本翻訳の使用に起因する誤解や誤訳について当方は一切の責任を負いません。
<!-- CO-OP TRANSLATOR DISCLAIMER END -->