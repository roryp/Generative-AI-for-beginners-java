# 實際應用程式與項目

[![實際應用程式與項目](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "實際應用程式與項目")

> **影片概覽：** [在 YouTube 上觀看「實際應用程式與項目」](https://www.youtube.com/watch?v=01vJsYei3H0)。

## 你將會學到什麼
在本節中，我們將示範三個展示如何使用 Java 實現生成式 AI 開發模式的實際應用程式：
- 創建結合客戶端與伺服器端 AI 的多模態寵物故事生成器
- 透過 Foundry Local Spring Boot 範例實現本地 AI 模型整合
- 使用計算器範例開發模型上下文協議（MCP）服務

## 目錄

- [簡介](#簡介)
  - [Foundry Local Spring Boot 範例](#foundry-local-spring-boot-範例)
  - [寵物故事生成器](#寵物故事生成器)
  - [MCP 計算器服務（適合初學者的 MCP 範例）](#mcp-計算器服務（適合初學者的-mcp-範例）)
- [學習進度](#學習進度)
- [總結](#總結)
- [後續步驟](#後續步驟)

## 簡介

本章展示了示範使用 Java 實現生成式 AI 開發模式的<strong>範例項目</strong>。每個項目皆完全可運作，展示特定的 AI 技術、架構模式及最佳實踐，供你在自己的應用程式中加以應用。

### Foundry Local Spring Boot 範例

**[Foundry Local Spring Boot 範例](foundrylocal/README.md)** 演示如何使用 **OpenAI Java SDK** 整合本地 AI 模型。展示了連結至在 Foundry Local 運行的 **Phi-3.5-mini** 模型，讓你能運行不依賴雲端服務的 AI 應用。

### 寵物故事生成器

**[寵物故事生成器](petstory/README.md)** 是一個有趣的 Spring Boot 網頁應用，展示如何使用<strong>多模態 AI 處理</strong>來產生創意寵物故事。結合客戶端與伺服器端 AI 功能，使用 transformer.js 實現瀏覽器端 AI 互動，並透過 OpenAI SDK 進行伺服器端處理。

### MCP 計算器服務（適合初學者的 MCP 範例）

**[MCP 計算器服務](calculator/README.md)** 是一個簡單示範使用 Spring AI 的<strong>模型上下文協議（MCP）</strong>。提供適合初學者的 MCP 概念入門，展示如何創建基本 MCP 伺服器與 MCP 用戶端互動。

## 學習進度

這些項目設計為依序建立於前面章節的概念之上：

1. <strong>從簡單開始</strong>：先從 Foundry Local Spring Boot 範例開始，了解基本的本地模型 AI 整合
2. <strong>加入互動性</strong>：再進階到寵物故事生成器，體驗多模態 AI 及網頁互動
3. **學習 MCP 基礎**：最後嘗試 MCP 計算器服務，理解模型上下文協議的基本原理

## 總結

做得好！你現在已探索了一些實際應用：

- 在瀏覽器與伺服器上都可運作的多模態 AI 體驗
- 使用現代 Java 框架與 SDK 的本地 AI 模型整合
- 你的第一個模型上下文協議服務，了解工具如何與 AI 整合

## 後續步驟

[第5章：負責任的生成式 AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**免責聲明**：
本文件經由 AI 翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 進行翻譯。雖然我們盡力確保準確性，但請注意自動翻譯可能包含錯誤或不準確之處。原始文件的母語版本應視為權威來源。對於關鍵資訊，建議採用專業人工翻譯。本公司對於因使用本翻譯所引起的任何誤解或誤譯概不負責。
<!-- CO-OP TRANSLATOR DISCLAIMER END -->