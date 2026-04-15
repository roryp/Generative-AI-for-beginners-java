# 實際應用與專案

[![實際應用與專案](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "實際應用與專案")

> **影片概覽：** [在 YouTube 上觀看「實際應用與專案」](https://www.youtube.com/watch?v=01vJsYei3H0)。

## 你將學到的內容
在本節中，我們將展示三個實際應用，展示使用 Java 進行生成式 AI 開發的模式：
- 建立結合客戶端與伺服器端 AI 的多模態寵物故事產生器
- 使用 Foundry Local Spring Boot 範例實作本地 AI 模型整合
- 使用計算機範例開發模型上下文協定（MCP）服務

## 目錄

- [介紹](#介紹)
  - [Foundry Local Spring Boot 範例](#foundry-local-spring-boot-範例)
  - [寵物故事產生器](#寵物故事產生器)
  - [MCP 計算機服務（適合初學者的 MCP 範例）](#mcp-計算機服務（適合初學者的-mcp-範例）)
- [學習進程](#學習進程)
- [總結](#總結)
- [後續步驟](#後續步驟)

## 介紹

本章展示了演示生成式 AI 開發模式的<strong>範例專案</strong>，使用 Java 實作。每個專案均可正常運作，並展示特定的 AI 技術、架構模式及最佳實踐，您可以將其套用到自身的應用程式中。

### Foundry Local Spring Boot 範例

**[Foundry Local Spring Boot 範例](foundrylocal/README.md)** 示範如何使用 **OpenAI Java SDK** 整合本地 AI 模型。它展示了如何連接在 Foundry Local 上運行的 **Phi-3.5-mini** 模型，讓您在不依賴雲端服務的情況下運行 AI 應用。

### 寵物故事產生器

**[寵物故事產生器](petstory/README.md)** 是一個引人入勝的 Spring Boot 網頁應用，展示了用於產生創意寵物故事的<strong>多模態 AI 處理</strong>。它結合使用 transformer.js 於瀏覽器端進行 AI 互動，及使用 OpenAI SDK 在伺服器端處理。

### MCP 計算機服務（適合初學者的 MCP 範例）

**[MCP 計算機服務](calculator/README.md)** 是使用 Spring AI 展示<strong>模型上下文協定（MCP）</strong>的簡單示範。它提供適合初學者的 MCP 概念介紹，展示如何建立與 MCP 用戶端互動的基礎 MCP 伺服器。

## 學習進程

這些專案設計用來建立在前面章節的概念上：

1. **從簡單開始：** 從 Foundry Local Spring Boot 範例開始，了解本地模型的基本 AI 整合
2. **增加互動性：** 前進到寵物故事產生器，學習多模態 AI 及基於網頁的互動
3. **學習 MCP 基礎：** 嘗試 MCP 計算機服務，以理解模型上下文協定基本原理

## 總結

幹得好！您現在已探索了一些實際應用：

- 瀏覽器與伺服器皆可運作的多模態 AI 體驗
- 使用現代 Java 框架與 SDK 進行本地 AI 模型整合
- 您的第一個模型上下文協定服務，了解工具如何與 AI 整合

## 後續步驟

[第 5 章：負責任的生成式 AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**免責聲明**：  
本文件係使用 AI 翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 進行翻譯。雖然我們致力於確保準確性，但請注意自動翻譯可能包含錯誤或不準確之處。原始文件的母語版本應視為權威來源。對於重要資訊，建議採用專業人工翻譯。對於因使用本翻譯而引起之任何誤解或誤譯，我們概不負責。
<!-- CO-OP TRANSLATOR DISCLAIMER END -->