<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "da1b6d87b8a73306b29f9a1bdd681221",
  "translation_date": "2025-07-21T18:10:03+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "mo"
}
-->
# 實用應用與專案

> 注意：每個範例都包含一個 **TUTORIAL.md**，指導您如何運行應用程式。

## 您將學到什麼
在本章節中，我們將展示三個實用應用，展示如何使用 Java 開發生成式 AI 的模式：
- 創建一個結合客戶端與伺服器端 AI 的多模態寵物故事生成器
- 使用 Foundry Local Spring Boot 範例實現本地 AI 模型整合
- 使用計算器範例開發一個模型上下文協議 (MCP) 服務

## 目錄

- [介紹](../../../04-PracticalSamples)
  - [Foundry Local Spring Boot 範例](../../../04-PracticalSamples)
  - [寵物故事生成器](../../../04-PracticalSamples)
  - [MCP 計算器服務（適合初學者的 MCP 範例）](../../../04-PracticalSamples)
- [學習進程](../../../04-PracticalSamples)
- [總結](../../../04-PracticalSamples)
- [下一步](../../../04-PracticalSamples)

## 介紹

本章節展示了 **範例專案**，這些專案演示了如何使用 Java 開發生成式 AI 的模式。每個專案都是完整可運行的，展示了特定的 AI 技術、架構模式以及最佳實踐，您可以將其應用於自己的開發中。

### Foundry Local Spring Boot 範例

**[Foundry Local Spring Boot 範例](foundrylocal/README.md)** 展示了如何使用 **OpenAI Java SDK** 整合本地 AI 模型。它展示了如何連接到運行於 Foundry Local 的 **Phi-3.5-mini** 模型，讓您能夠在不依賴雲端服務的情況下運行 AI 應用程式。

### 寵物故事生成器

**[寵物故事生成器](petstory/README.md)** 是一個有趣的 Spring Boot 網頁應用程式，展示了 **多模態 AI 處理**，用於生成創意寵物故事。它結合了客戶端與伺服器端的 AI 功能，使用 transformer.js 進行瀏覽器端的 AI 互動，並使用 OpenAI SDK 進行伺服器端處理。

### MCP 計算器服務（適合初學者的 MCP 範例）

**[MCP 計算器服務](mcp/calculator/README.md)** 是一個簡單的範例，展示了如何使用 Spring AI 實現 **模型上下文協議 (MCP)**。它提供了一個適合初學者的 MCP 概念入門，展示了如何創建一個基本的 MCP 伺服器與 MCP 客戶端進行互動。

## 學習進程

這些專案設計為循序漸進地構建概念：

1. **從簡單開始**：從 Foundry Local Spring Boot 範例開始，了解如何與本地模型進行基本的 AI 整合
2. **增加互動性**：進一步學習寵物故事生成器，體驗多模態 AI 和基於網頁的互動
3. **學習 MCP 基礎**：嘗試 MCP 計算器服務，理解模型上下文協議的基本概念

## 總結

**恭喜您！** 您已成功：

- **創建多模態 AI 體驗**，結合客戶端與伺服器端的 AI 處理
- **實現本地 AI 模型整合**，使用現代 Java 框架與 SDK
- **開發模型上下文協議服務**，展示工具整合模式

## 下一步

[第 5 章：負責任的生成式 AI](../05-ResponsibleGenAI/README.md)

**免責聲明**：  
本文件已使用 AI 翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 進行翻譯。儘管我們努力確保準確性，但請注意，自動翻譯可能包含錯誤或不準確之處。原始文件的母語版本應被視為權威來源。對於關鍵信息，建議使用專業人工翻譯。我們對因使用此翻譯而引起的任何誤解或錯誤解釋不承擔責任。