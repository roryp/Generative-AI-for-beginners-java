<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b8a372dfc3e3e7ad9261231a22fd79c0",
  "translation_date": "2025-07-25T08:59:19+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "hk"
}
-->
# 核心生成式人工智能技術

>**Note**: 本章包含詳細的[**教學**](./TUTORIAL.md)，指導您完成範例。

## 您將學到什麼
在本章中，我們通過實際範例探討四種核心生成式人工智能技術：
- LLM補全和聊天流程
- 函數調用
- 檢索增強生成（RAG）
- 負責任的人工智能安全措施

## 目錄

- [您將學到什麼](../../../03-CoreGenerativeAITechniques)
- [先決條件](../../../03-CoreGenerativeAITechniques)
- [開始使用](../../../03-CoreGenerativeAITechniques)
- [範例概述](../../../03-CoreGenerativeAITechniques)
  - [1. LLM補全和聊天流程](../../../03-CoreGenerativeAITechniques)
  - [2. 使用LLM的函數與插件](../../../03-CoreGenerativeAITechniques)
  - [3. 檢索增強生成（RAG）](../../../03-CoreGenerativeAITechniques)
  - [4. 負責任的人工智能安全演示](../../../03-CoreGenerativeAITechniques)
- [摘要](../../../03-CoreGenerativeAITechniques)
- [下一步](../../../03-CoreGenerativeAITechniques)

## 先決條件

- 完成[第2章](../../../02-SetupDevEnvironment)的設置

## 開始使用

1. **導航至範例**：  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **設置環境**：  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **編譯並運行範例**：  
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

範例組織在`examples/`文件夾中，結構如下：

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

### 1. LLM補全和聊天流程
**文件**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

學習如何構建具有流式響應和聊天歷史管理的對話式人工智能。

此範例展示：
- 使用系統提示進行簡單文本補全
- 管理聊天歷史的多輪對話
- 互動式聊天會話
- 參數配置（溫度、最大令牌數）

### 2. 使用LLM的函數與插件
**文件**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

通過為模型提供自定義函數和外部API，擴展人工智能的能力。

此範例展示：
- 天氣函數集成
- 計算器函數實現  
- 一次對話中的多個函數調用
- 使用JSON結構定義函數

### 3. 檢索增強生成（RAG）
**文件**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

學習如何將人工智能與您的文檔和數據源結合，生成準確且具上下文的響應。

此範例展示：
- 使用Azure OpenAI SDK進行基於文檔的問答
- 使用GitHub模型實現RAG模式

**使用方法**: 提出關於`document.txt`內容的問題，並獲得基於該上下文的人工智能響應。

### 4. 負責任的人工智能安全演示
**文件**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

預覽人工智能安全措施的運作方式，測試GitHub模型的內容過濾功能。

此範例展示：
- 對潛在有害提示進行內容過濾
- 在應用中處理安全響應
- 不同類型的被屏蔽內容（暴力、仇恨言論、錯誤信息）
- 安全違規的正確錯誤處理

> **了解更多**: 這只是負責任人工智能概念的介紹。更多關於倫理、偏見緩解、隱私考量和負責任人工智能框架的信息，請參閱[第5章：負責任的生成式人工智能](../05-ResponsibleGenAI/README.md)。

## 摘要

在本章中，我們探討了LLM補全和聊天流程，實現了函數調用以增強人工智能能力，創建了檢索增強生成（RAG）系統，並演示了負責任的人工智能安全措施。

> **NOTE**: 使用提供的[**教學**](./TUTORIAL.md)深入學習。

## 下一步

[第4章：實際應用與項目](../04-PracticalSamples/README.md)

**免責聲明**：  
本文件已使用人工智能翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 進行翻譯。儘管我們致力於提供準確的翻譯，請注意自動翻譯可能包含錯誤或不準確之處。原始文件的母語版本應被視為權威來源。對於重要資訊，建議尋求專業人工翻譯。我們對因使用此翻譯而引起的任何誤解或錯誤解釋概不負責。