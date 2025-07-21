<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T16:00:51+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "tw"
}
-->
# 核心生成式 AI 技術

>**注意**：本章包含詳細的[**教學**](./TUTORIAL.md)，指導您如何執行完成的範例。

## 您將學到什麼
在本章中，我們透過實際範例探討四種核心生成式 AI 技術：
- LLM 完成與聊天流程
- 函數呼叫
- 檢索增強生成 (RAG)
- 負責任的 AI 安全措施

## 目錄

- [您將學到什麼](../../../03-CoreGenerativeAITechniques)
- [先決條件](../../../03-CoreGenerativeAITechniques)
- [開始使用](../../../03-CoreGenerativeAITechniques)
- [範例概述](../../../03-CoreGenerativeAITechniques)
  - [1. LLM 完成與聊天流程](../../../03-CoreGenerativeAITechniques)
  - [2. 使用 LLM 的函數與插件](../../../03-CoreGenerativeAITechniques)
  - [3. 檢索增強生成 (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. 負責任的 AI 安全示範](../../../03-CoreGenerativeAITechniques)
- [摘要](../../../03-CoreGenerativeAITechniques)
- [下一步](../../../03-CoreGenerativeAITechniques)

## 先決條件

- 已完成[第 2 章](../../../02-SetupDevEnvironment)的環境設置

## 開始使用

1. **進入範例目錄**：  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **設置環境**：  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **編譯並執行範例**：  
```bash
   # Run completions example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
   
   # Run functions example  
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
   
   # Run RAG example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
   
   # Run responsible AI demo
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
   ```  

## 範例概述

範例位於 `examples/` 資料夾中，結構如下：

```
examples/
├── src/main/java/com/example/genai/techniques/
│   ├── completions/
│   │   └── LLMCompletionsApp.java        # Basic completions 
│   ├── functions/
│   │   └── FunctionsApp.java             # Function calling examples
│   ├── rag/
│   │   └── SimpleReaderDemo.java         # Retrieval-Augmented Generation
│   └── responsibleai/
│       └── ResponsibleGithubModels.java  # Responsible AI safety demonstration
├── document.txt                          # Sample document for RAG example
└── pom.xml                               # Maven configuration
```  

### 1. LLM 完成與聊天流程
**檔案**：`examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

學習如何構建具有串流回應和聊天歷史管理的對話式 AI。

此範例展示：
- 使用系統提示進行簡單文本完成
- 管理多輪對話的聊天歷史
- 互動式聊天會話
- 參數配置（溫度、最大 token 數）

### 2. 使用 LLM 的函數與插件
**檔案**：`examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

透過提供模型自定義函數和外部 API，擴展 AI 的能力。

此範例展示：
- 天氣函數整合
- 計算器函數實現  
- 在一次對話中進行多次函數呼叫
- 使用 JSON schema 定義函數

### 3. 檢索增強生成 (RAG)
**檔案**：`examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

學習如何結合 AI 與您自己的文件和數據來源，以提供準確且具上下文的回應。

此範例展示：
- 使用 Azure OpenAI SDK 進行基於文件的問答
- 使用 GitHub 模型實現 RAG 模式

**使用方式**：針對 `document.txt` 中的內容提問，並獲得基於該上下文的 AI 回應。

### 4. 負責任的 AI 安全示範
**檔案**：`examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

預覽 AI 安全措施的運作方式，測試 GitHub 模型的內容過濾功能。

此範例展示：
- 對可能有害的提示進行內容過濾
- 在應用程式中處理安全回應
- 不同類型的被屏蔽內容（暴力、仇恨言論、錯誤資訊）
- 安全違規的正確錯誤處理方式

> **了解更多**：這只是負責任 AI 概念的介紹。欲了解更多關於倫理、偏見緩解、隱私考量及負責任 AI 框架的資訊，請參閱[第 5 章：負責任的生成式 AI](../05-ResponsibleGenAI/README.md)。

## 摘要

在本章中，我們探討了 LLM 完成與聊天流程，實現了函數呼叫以增強 AI 能力，創建了檢索增強生成 (RAG) 系統，並展示了負責任的 AI 安全措施。

> **注意**：透過提供的[**教學**](./TUTORIAL.md)深入學習。

## 下一步

[第 4 章：實用應用與專案](../04-PracticalSamples/README.md)

**免責聲明**：  
本文件使用 AI 翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 進行翻譯。雖然我們致力於提供準確的翻譯，但請注意，自動翻譯可能包含錯誤或不準確之處。原始文件的母語版本應被視為權威來源。對於關鍵資訊，建議使用專業人工翻譯。我們對因使用此翻譯而產生的任何誤解或錯誤解釋不承擔責任。