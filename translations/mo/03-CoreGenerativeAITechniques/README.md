<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T17:39:22+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "mo"
}
-->
# 核心生成式 AI 技術

>**注意**：本章節包含一個詳細的[**教學指南**](./TUTORIAL.md)，帶您一步步執行完成的範例。

## 您將學到什麼
在本章節中，我們將透過實際範例學習 4 種核心生成式 AI 技術：
- LLM 完成與聊天流程
- 函數呼叫
- 檢索增強生成（RAG）
- 負責任的 AI 安全措施

## 目錄

- [您將學到什麼](../../../03-CoreGenerativeAITechniques)
- [先決條件](../../../03-CoreGenerativeAITechniques)
- [開始使用](../../../03-CoreGenerativeAITechniques)
- [範例概覽](../../../03-CoreGenerativeAITechniques)
  - [1. LLM 完成與聊天流程](../../../03-CoreGenerativeAITechniques)
  - [2. 使用 LLM 的函數與插件](../../../03-CoreGenerativeAITechniques)
  - [3. 檢索增強生成（RAG）](../../../03-CoreGenerativeAITechniques)
  - [4. 負責任的 AI 安全示範](../../../03-CoreGenerativeAITechniques)
- [總結](../../../03-CoreGenerativeAITechniques)
- [下一步](../../../03-CoreGenerativeAITechniques)

## 先決條件

- 已完成[第 2 章](../../../02-SetupDevEnvironment)的環境設置

## 開始使用

1. **導航至範例**：  
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

## 範例概覽

範例存放於 `examples/` 資料夾中，結構如下：

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

學習如何構建具有串流回應與聊天歷史管理的對話式 AI。

此範例展示：
- 使用系統提示進行簡單文本完成
- 管理歷史記錄的多輪對話
- 互動式聊天會話
- 參數配置（溫度、最大字數）

### 2. 使用 LLM 的函數與插件
**檔案**：`examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

透過為模型提供自定義函數與外部 API，擴展 AI 的能力。

此範例展示：
- 天氣函數整合
- 計算器函數實作  
- 在一次對話中進行多次函數呼叫
- 使用 JSON 架構定義函數

### 3. 檢索增強生成（RAG）
**檔案**：`examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

學習如何將 AI 與您的文件和數據源結合，生成準確且具上下文的回應。

此範例展示：
- 使用 Azure OpenAI SDK 進行基於文件的問答
- 使用 GitHub 模型實現 RAG 模式

**使用方式**：針對 `document.txt` 中的內容提問，並獲得基於該上下文的 AI 回應。

### 4. 負責任的 AI 安全示範
**檔案**：`examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

預覽 AI 安全措施的運作方式，測試 GitHub 模型的內容過濾功能。

此範例展示：
- 過濾潛在有害提示的內容
- 在應用程式中處理安全回應
- 不同類別的被屏蔽內容（暴力、仇恨言論、錯誤資訊）
- 安全違規的正確錯誤處理

> **了解更多**：這只是負責任 AI 概念的入門介紹。更多關於倫理、偏見緩解、隱私考量及負責任 AI 框架的資訊，請參閱[第 5 章：負責任的生成式 AI](../05-ResponsibleGenAI/README.md)。

## 總結

在本章節中，我們探索了 LLM 完成與聊天流程，實現了增強 AI 能力的函數呼叫，創建了檢索增強生成（RAG）系統，並展示了負責任的 AI 安全措施。

> **注意**：透過提供的[**教學指南**](./TUTORIAL.md)深入學習。

## 下一步

[第 4 章：實用應用與專案](../04-PracticalSamples/README.md)

**免責聲明**：  
本文件已使用 AI 翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 進行翻譯。雖然我們致力於提供準確的翻譯，但請注意，自動翻譯可能包含錯誤或不準確之處。原始文件的母語版本應被視為權威來源。對於關鍵信息，建議使用專業人工翻譯。我們對因使用此翻譯而引起的任何誤解或誤釋不承擔責任。