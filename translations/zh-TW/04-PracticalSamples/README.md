# 實務應用與專案

[![實務應用與專案](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "實務應用與專案")

> **影片概覽：** [在 YouTube 上觀看「實務應用與專案」](https://www.youtube.com/watch?v=01vJsYei3H0)。

## 您將學到什麼
在本節中，我們將展示三個實務應用程式，展示使用 Java 進行生成式 AI 開發的模式：
- 建立結合客戶端與伺服器端 AI 的多模態寵物故事產生器
- 使用 Foundry Local Spring Boot 範例實現本地 AI 模型整合
- 使用計算機範例開發 Model Context Protocol (MCP) 服務

## 目錄

- [簡介](#簡介)
  - [Foundry Local Spring Boot 範例](#foundry-local-spring-boot-範例)
  - [寵物故事產生器](#寵物故事產生器)
  - [MCP 計算機服務（適合初學者的 MCP 範例）](#mcp-計算機服務（適合初學者的-mcp-範例）)
- [學習進度](#學習進度)
- [總結](#總結)
- [下一步](#下一步)

## 簡介

本章節展示了透過 Java 展示生成式 AI 開發模式的<strong>範例專案</strong>。每個專案皆為完整功能，呈現特定的 AI 技術、架構模式與最佳實務，供您參考並應用於自己的應用程式。

### Foundry Local Spring Boot 範例

**[Foundry Local Spring Boot 範例](foundrylocal/README.md)** 示範如何使用 **OpenAI Java SDK** 整合本地 AI 模型。範例展示連接執行於 Foundry Local 的模型（例如 **Phi-4-mini**），並具備自動模型偵測功能，讓您能夠在不依賴雲端服務的情況下執行 AI 應用。

### 寵物故事產生器

**[寵物故事產生器](petstory/README.md)** 是一個有趣的 Spring Boot 網頁應用程式，展示使用<strong>多模態 AI 處理</strong>來產生創意寵物故事。該應用結合客戶端與伺服器端 AI，客戶端使用 transformer.js 實現瀏覽器內 AI 互動，伺服器端則透過 OpenAI SDK 處理。

### MCP 計算機服務（適合初學者的 MCP 範例）

**[MCP 計算機服務](calculator/README.md)** 是使用 Spring AI 展示 **Model Context Protocol (MCP)** 的簡易範例。此範例為初學者友善，介紹 MCP 概念，展示如何建立一個基本的 MCP 伺服器與 MCP 客戶端互動。

## 學習進度

這些專案的設計是建立在先前章節概念之上：

1. <strong>從簡單開始</strong>：先從 Foundry Local Spring Boot 範例開始，了解使用本地模型進行 AI 整合的基礎
2. <strong>加入互動性</strong>：進階到寵物故事產生器，體驗多模態 AI 及基於網頁的互動
3. **學習 MCP 基礎**：嘗試 MCP 計算機服務，了解 Model Context Protocol 的基礎知識

## 總結

做得很好！您現在已探索了幾個實用應用：

- 在瀏覽器與伺服器端皆可運作的多模態 AI 體驗
- 使用現代 Java 框架與 SDK 進行本地 AI 模型整合
- 您的第一個 Model Context Protocol 服務，了解工具如何與 AI 整合

## 下一步

[第 5 章：負責任的生成式 AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**免責聲明**：  
本文件是使用 AI 翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 進行翻譯的。雖然我們努力追求準確性，但請注意，自動翻譯可能包含錯誤或不準確之處。原始文件的母語版本應視為權威來源。對於重要資訊，建議尋求專業人工翻譯。我們對因使用此翻譯而產生的任何誤解或誤釋不承擔任何責任。
<!-- CO-OP TRANSLATOR DISCLAIMER END -->