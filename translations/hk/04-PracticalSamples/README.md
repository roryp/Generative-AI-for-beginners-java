<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "da1b6d87b8a73306b29f9a1bdd681221",
  "translation_date": "2025-07-21T16:30:52+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "hk"
}
-->
# 實用應用及項目

> 注意: 每個示例都包含一份 **TUTORIAL.md**，指導你如何運行應用程式。

## 你將學到什麼
在本章節中，我們將展示三個實用應用，展示使用 Java 開發生成式 AI 的模式：
- 創建一個結合客戶端和伺服器端 AI 的多模態寵物故事生成器
- 使用 Foundry Local Spring Boot 示例實現本地 AI 模型集成
- 使用計算器示例開發一個模型上下文協議 (MCP) 服務

## 目錄

- [簡介](../../../04-PracticalSamples)
  - [Foundry Local Spring Boot 示例](../../../04-PracticalSamples)
  - [寵物故事生成器](../../../04-PracticalSamples)
  - [MCP 計算器服務 (適合初學者的 MCP 示例)](../../../04-PracticalSamples)
- [學習進度](../../../04-PracticalSamples)
- [總結](../../../04-PracticalSamples)
- [下一步](../../../04-PracticalSamples)

## 簡介

本章節展示了 **示例項目**，演示使用 Java 開發生成式 AI 的模式。每個項目都是完全功能性的，展示了特定的 AI 技術、架構模式以及最佳實踐，你可以將其應用到自己的項目中。

### Foundry Local Spring Boot 示例

**[Foundry Local Spring Boot 示例](foundrylocal/README.md)** 演示了如何使用 **OpenAI Java SDK** 集成本地 AI 模型。它展示了如何連接到運行在 Foundry Local 上的 **Phi-3.5-mini** 模型，讓你能夠運行不依賴雲服務的 AI 應用。

### 寵物故事生成器

**[寵物故事生成器](petstory/README.md)** 是一個有趣的 Spring Boot 網頁應用，展示了 **多模態 AI 處理**，用於生成創意寵物故事。它結合了客戶端和伺服器端的 AI 功能，使用 transformer.js 進行基於瀏覽器的 AI 交互，以及 OpenAI SDK 進行伺服器端處理。

### MCP 計算器服務 (適合初學者的 MCP 示例)

**[MCP 計算器服務](mcp/calculator/README.md)** 是一個簡單的 **模型上下文協議 (MCP)** 示例，使用 Spring AI。它提供了一個適合初學者的 MCP 概念入門，展示了如何創建一個基本的 MCP 伺服器與 MCP 客戶端進行交互。

## 學習進度

這些項目旨在基於前面章節的概念進行學習：

1. **從簡單開始**: 從 Foundry Local Spring Boot 示例開始，了解本地模型的基本 AI 集成
2. **增加互動性**: 進一步學習寵物故事生成器，體驗多模態 AI 和基於網頁的交互
3. **學習 MCP 基礎**: 嘗試 MCP 計算器服務，了解模型上下文協議的基本概念

## 總結

**恭喜你！** 你已成功完成以下內容：

- **創建多模態 AI 體驗**，結合客戶端和伺服器端的 AI 處理
- **實現本地 AI 模型集成**，使用現代 Java 框架和 SDK
- **開發模型上下文協議服務**，展示工具集成模式

## 下一步

[第 5 章: 負責任的生成式 AI](../05-ResponsibleGenAI/README.md)

**免責聲明**：  
本文件已使用人工智能翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 進行翻譯。儘管我們致力於提供準確的翻譯，但請注意，自動翻譯可能包含錯誤或不準確之處。原始文件的母語版本應被視為權威來源。對於重要信息，建議使用專業人工翻譯。我們對因使用此翻譯而引起的任何誤解或錯誤解釋概不負責。