# 實際應用與專案

[![Practical Applications & Projects](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "Practical Applications & Projects")

> **影片簡介：** [在 YouTube 觀看「實際應用與專案」](https://www.youtube.com/watch?v=01vJsYei3H0)。

## 你將學習的內容
本節將示範三個展示以 Java 開發生成式 AI 模式的實際應用：
- 建立結合客戶端與伺服器端 AI 的多模態寵物故事產生器
- 使用 Foundry Local Spring Boot 範例實作本地 AI 模型整合
- 使用計算器範例開發模型上下文協議（MCP）服務

## 目錄

- [簡介](#簡介)
  - [Foundry Local Spring Boot 範例](#foundry-local-spring-boot-範例)
  - [寵物故事產生器](#寵物故事產生器)
  - [MCP 計算器服務（適合初學者的 MCP 範例）](#mcp-計算器服務（適合初學者的-mcp-範例）)
- [學習進度](#學習進度)
- [摘要](#摘要)
- [下一步](#下一步)

## 簡介

本章展示了展示 Java 生成式 AI 開發模式的<strong>範例專案</strong>。每個專案均具備完整功能，展示您可以用於自身應用的特定 AI 技術、架構模式與最佳實踐。

### Foundry Local Spring Boot 範例

**[Foundry Local Spring Boot 範例](foundrylocal/README.md)** 展示如何使用 **OpenAI Java SDK** 與本地 AI 模型整合。它展示如何連接運行於 Foundry Local（例如 **Phi-4-mini**）的模型，具備自動模型偵測功能，讓您無需依賴雲端服務即可執行 AI 應用。

### 寵物故事產生器

**[寵物故事產生器](petstory/README.md)** 是一款有趣的 Spring Boot 網頁應用，示範了<strong>多模態 AI 處理</strong>以生成富有創意的寵物故事。它結合了使用 transformer.js 進行瀏覽器端 AI 互動與運用 OpenAI SDK 進行伺服器端處理的 AI 能力。

### MCP 計算器服務（適合初學者的 MCP 範例）

**[MCP 計算器服務](calculator/README.md)** 是一個使用 Spring AI 的<strong>模型上下文協議（MCP）</strong>簡易示範。它為初學者介紹 MCP 概念，展示如何建立與 MCP 用戶端互動的基本 MCP 伺服器。

## 學習進度

這些專案設計為循序漸進，建立在前章內容之上：

1. <strong>從簡入手</strong>：從 Foundry Local Spring Boot 範例開始了解與本地模型的 AI 整合基礎
2. <strong>增加互動性</strong>：進階至寵物故事產生器，體驗多模態 AI 及網頁互動
3. **學習 MCP 基本**：嘗試 MCP 計算器服務，理解模型上下文協議的基本原理

## 摘要

做得好！您現已探索一些真實應用：

- 同時在瀏覽器與伺服器執行的多模態 AI 體驗
- 使用現代 Java 架構與 SDK 的本地 AI 模型整合
- 您的第一個模型上下文協議服務，了解工具如何與 AI 整合

## 下一步

[第五章：負責任的生成式 AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**免責聲明**：  
本文件乃使用 AI 翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 進行翻譯。儘管我們力求準確，但請注意自動翻譯可能包含錯誤或不準確之處。原始文件的母語版本應視為權威來源。對於重要資訊，建議使用專業人工翻譯。我們不對因使用本翻譯而引起的任何誤解或誤釋承擔責任。
<!-- CO-OP TRANSLATOR DISCLAIMER END -->