# 實用應用程式與專案

[![實用應用程式與專案](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "實用應用程式與專案")

> **影片概覽：** [在 YouTube 觀看《實用應用程式與專案》](https://www.youtube.com/watch?v=01vJsYei3H0)。

## 你將學到什麼
本節將展示三個示範實用應用程式，展示使用 Java 的生成式 AI 開發範式：
- 建立結合客戶端與伺服器端 AI 的多模態寵物故事產生器
- 使用 Foundry Local Spring Boot 示範實作本地 AI 模型整合
- 以計算機範例開發模型上下文協定 (MCP) 服務

## 內容目錄

- [介紹](#介紹)
  - [Foundry Local Spring Boot 示範](#foundry-local-spring-boot-示範)
  - [寵物故事產生器](#寵物故事產生器)
  - [MCP 計算機服務（適合初學者的 MCP 示範）](#mcp-計算機服務（適合初學者的-mcp-示範）)
- [學習進程](#學習進程)
- [總結](#總結)
- [後續步驟](#後續步驟)

## 介紹

本章展示了數個 <strong>範例專案</strong>，示範使用 Java 的生成式 AI 開發範式。每個專案皆為完整功能，展示特定 AI 技術、架構範式與最佳實務，供你為自己的應用程式調整應用。

### Foundry Local Spring Boot 示範

**[Foundry Local Spring Boot 示範](foundrylocal/README.md)** 展示如何使用 **OpenAI Java SDK** 整合本地 AI 模型。它展示連接在 Foundry Local 上運行的模型（例如 **Phi-4-mini**），並自動偵測模型，讓你能夠在不依賴雲端服務的情況下運行 AI 應用程式。

### 寵物故事產生器

**[寵物故事產生器](petstory/README.md)** 是一款引人入勝的 Spring Boot 網頁應用程式，展示了 **多模態 AI 處理** 以產生富有創意的寵物故事。它結合了使用 transformer.js 執行瀏覽器端 AI 互動及伺服器端使用 OpenAI SDK 的 AI 功能。

### MCP 計算機服務（適合初學者的 MCP 示範）

**[MCP 計算機服務](calculator/README.md)** 是示範使用 Spring AI 的 **模型上下文協定 (MCP)** 的簡單範例。它為初學者提供 MCP 概念介紹，展示如何建立基本的 MCP 伺服器與 MCP 用戶端互動。

## 學習進程

這些專案設計用於基於前章節的概念逐步建立：

1. <strong>從簡開始</strong>：先從 Foundry Local Spring Boot 示範入門，了解本地模型的基本 AI 整合
2. <strong>增加互動性</strong>：接著進階到寵物故事產生器，學習多模態 AI 及網頁互動
3. **學習 MCP 基礎**：最後嘗試 MCP 計算機服務，了解模型上下文協定的基礎原理

## 總結

做得好！你已經探索了一些實際應用：

- 瀏覽器和伺服器端皆能運作的多模態 AI 體驗
- 使用現代 Java 框架與 SDK 進行本地 AI 模型整合
- 你的第一個模型上下文協定服務，了解工具如何與 AI 整合

## 後續步驟

[第 5 章：負責任的生成式 AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**免責聲明**：  
本文件經由 AI 翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 進行翻譯。雖然我們力求準確，但請注意自動翻譯可能包含錯誤或不準確之處。原始文件的母語版本應被視為權威來源。對於重要資訊，建議採用專業人工翻譯。我們不對因使用本翻譯而引起的任何誤解或曲解承擔責任。
<!-- CO-OP TRANSLATOR DISCLAIMER END -->