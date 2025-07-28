<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "d45b8e2291ab1357592c904c103cbc81",
  "translation_date": "2025-07-28T10:25:21+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "mo"
}
-->
# 實用應用與專案

## 你將學到什麼
在本章節中，我們將展示三個實用應用，這些應用展示了使用 Java 開發生成式 AI 的模式：
- 創建一個結合客戶端與伺服器端 AI 的多模態寵物故事生成器
- 使用 Foundry Local Spring Boot 範例實現本地 AI 模型整合
- 使用計算器範例開發一個 Model Context Protocol (MCP) 服務

## 目錄

- [簡介](../../../04-PracticalSamples)
  - [Foundry Local Spring Boot 範例](../../../04-PracticalSamples)
  - [寵物故事生成器](../../../04-PracticalSamples)
  - [MCP 計算器服務（適合初學者的 MCP 範例）](../../../04-PracticalSamples)
- [學習進程](../../../04-PracticalSamples)
- [總結](../../../04-PracticalSamples)
- [下一步](../../../04-PracticalSamples)

## 簡介

本章節展示了**範例專案**，這些專案展示了使用 Java 開發生成式 AI 的模式。每個專案都是完整可運行的，展示了特定的 AI 技術、架構模式以及最佳實踐，這些都可以應用到你的專案中。

### Foundry Local Spring Boot 範例

**[Foundry Local Spring Boot 範例](foundrylocal/README.md)** 展示了如何使用 **OpenAI Java SDK** 整合本地 AI 模型。該範例展示了如何連接到運行於 Foundry Local 的 **Phi-3.5-mini** 模型，讓你能夠在不依賴雲端服務的情況下運行 AI 應用。

### 寵物故事生成器

**[寵物故事生成器](petstory/README.md)** 是一個有趣的 Spring Boot 網頁應用，展示了**多模態 AI 處理**來生成創意寵物故事。它結合了使用 transformer.js 的瀏覽器端 AI 互動以及使用 OpenAI SDK 的伺服器端處理。

### MCP 計算器服務（適合初學者的 MCP 範例）

**[MCP 計算器服務](calculator/README.md)** 是一個使用 Spring AI 展示 **Model Context Protocol (MCP)** 的簡單範例。它提供了一個適合初學者的 MCP 概念入門，展示了如何創建一個基本的 MCP 伺服器與 MCP 客戶端進行互動。

## 學習進程

這些專案的設計是基於前面章節的概念逐步構建的：

1. **從簡單開始**：從 Foundry Local Spring Boot 範例開始，了解如何與本地模型進行基本的 AI 整合
2. **增加互動性**：進一步學習寵物故事生成器，體驗多模態 AI 和基於網頁的互動
3. **學習 MCP 基礎**：嘗試 MCP 計算器服務，理解 Model Context Protocol 的基本概念

## 總結

**恭喜你！** 你已成功完成以下內容：

- **創建多模態 AI 體驗**，結合客戶端與伺服器端的 AI 處理
- **實現本地 AI 模型整合**，使用現代 Java 框架與 SDK
- **開發 Model Context Protocol 服務**，展示工具整合模式

## 下一步

[第 5 章：負責任的生成式 AI](../05-ResponsibleGenAI/README.md)

**免責聲明**：  
本文件使用 AI 翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 進行翻譯。我們致力於提供準確的翻譯，但請注意，自動翻譯可能包含錯誤或不準確之處。應以原始語言的文件作為權威來源。對於關鍵資訊，建議尋求專業人工翻譯。我們對因使用此翻譯而引起的任何誤解或錯誤解釋概不負責。