# 實際應用與專案

[![實際應用與專案](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "實際應用與專案")

> **影片概覽：** [於 YouTube 觀看「實際應用與專案」](https://www.youtube.com/watch?v=01vJsYei3H0)。

## 你將會學到什麼
在本節中，我們將展示三個實際應用程式，展示使用 Java 的生成式 AI 開發模式：
- 建立結合客戶端和伺服器端 AI 的多模態寵物故事產生器
- 以 Foundry Local Spring Boot 範例實作本地 AI 模型整合
- 利用計算器範例開發模型上下文協議（MCP）服務

## 目錄

- [介紹](#介紹)
  - [Foundry Local Spring Boot 範例](#foundry-local-spring-boot-範例)
  - [寵物故事產生器](#寵物故事產生器)
  - [MCP 計算器服務（適合新手的 MCP 範例）](#mcp-計算器服務（適合新手的-mcp-範例）)
- [學習進程](#學習進程)
- [總結](#總結)
- [後續步驟](#後續步驟)

## 介紹

本章展示了使用 Java 展示生成式 AI 開發模式的<strong>示範專案</strong>。每個專案均功能完整，展示特定 AI 技術、架構模式及最佳實務，您可以據此調整應用。

### Foundry Local Spring Boot 範例

**[Foundry Local Spring Boot 範例](foundrylocal/README.md)** 展示如何使用 **OpenAI Java SDK** 與本地 AI 模型整合。它示範連接在 Foundry Local 上執行的 **Phi-3.5-mini** 模型，使您能在無需雲端服務的情況下執行 AI 應用。

### 寵物故事產生器

**[寵物故事產生器](petstory/README.md)** 是一個有趣的 Spring Boot 網頁應用，演示如何透過<strong>多模態 AI 處理</strong>產生創意寵物故事。它結合客戶端與伺服器端的 AI 能力，使用 transformer.js 於瀏覽器端進行 AI 互動，並用 OpenAI SDK 於伺服器端處理。

### MCP 計算器服務（適合新手的 MCP 範例）

**[MCP 計算器服務](calculator/README.md)** 是使用 Spring AI 的<strong>模型上下文協議（MCP）</strong>簡易示範。它提供 MCP 概念的初學者入門，展示如何建立與 MCP 用戶端互動的基本 MCP 伺服器。

## 學習進程

這些專案設計為逐步建立於先前章節概念之上：

1. <strong>從簡單開始</strong>：先從 Foundry Local Spring Boot 範例了解本地模型的基本 AI 整合
2. <strong>加入互動性</strong>：進一步進入寵物故事產生器，體驗多模態 AI 與網頁互動
3. **學 MCP 基本**：嘗試 MCP 計算器服務，理解模型上下文協議基礎

## 總結

做得好！您現在已探索一些實際應用：

- 可在瀏覽器及伺服器端運作的多模態 AI 體驗
- 使用現代 Java 框架與 SDK 的本地 AI 模型整合
- 您的第一個模型上下文協議服務，了解工具如何與 AI 整合

## 後續步驟

[第 5 章：負責任的生成式 AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**免責聲明**：
本文件是使用 AI 翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 翻譯而成。雖然我們致力於準確性，但請注意，自動翻譯可能包含錯誤或不準確之處。原始文件的母語版本應被視為權威來源。對於關鍵資訊，建議採用專業人工翻譯。我們不對因使用本翻譯而產生的任何誤解或誤釋負責。
<!-- CO-OP TRANSLATOR DISCLAIMER END -->