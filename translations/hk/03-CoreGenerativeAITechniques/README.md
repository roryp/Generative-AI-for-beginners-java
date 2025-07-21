<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T16:01:05+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "hk"
}
-->
# 核心生成式 AI 技術

>**注意**：本章包含一個詳細的[**教學指南**](./TUTORIAL.md)，帶領你完成範例的運行。

## 你將學到什麼
在本章中，我們通過實際範例探討四種核心生成式 AI 技術：
- LLM 完成和聊天流程
- 函數調用
- 檢索增強生成 (RAG)
- 負責任的 AI 安全措施

## 目錄

- [你將學到什麼](../../../03-CoreGenerativeAITechniques)
- [先決條件](../../../03-CoreGenerativeAITechniques)
- [開始使用](../../../03-CoreGenerativeAITechniques)
- [範例概覽](../../../03-CoreGenerativeAITechniques)
  - [1. LLM 完成和聊天流程](../../../03-CoreGenerativeAITechniques)
  - [2. 使用 LLM 的函數與插件](../../../03-CoreGenerativeAITechniques)
  - [3. 檢索增強生成 (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. 負責任的 AI 安全示範](../../../03-CoreGenerativeAITechniques)
- [總結](../../../03-CoreGenerativeAITechniques)
- [下一步](../../../03-CoreGenerativeAITechniques)

## 先決條件

- 已完成[第 2 章](../../../02-SetupDevEnvironment)的環境設置

## 開始使用

1. **導航到範例**：  
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

### 1. LLM 完成和聊天流程
**檔案**：`examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

學習如何構建具有串流回應和聊天歷史管理的對話式 AI。

此範例展示：
- 使用系統提示進行簡單文本完成
- 帶有歷史管理的多輪對話
- 互動式聊天會話
- 參數配置（溫度、最大字元數）

### 2. 使用 LLM 的函數與插件
**檔案**：`examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

通過為模型提供自定義函數和外部 API，擴展 AI 的能力。

此範例展示：
- 天氣函數整合
- 計算器函數實現  
- 在一次對話中進行多次函數調用
- 使用 JSON 架構定義函數

### 3. 檢索增強生成 (RAG)
**檔案**：`examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

學習如何將 AI 與你的文件和數據源結合，提供準確且具上下文的回應。

此範例展示：
- 使用 Azure OpenAI SDK 進行基於文件的問答
- 使用 GitHub 模型實現 RAG 模式

**使用方式**：針對 `document.txt` 中的內容提問，AI 僅基於該上下文提供回應。

### 4. 負責任的 AI 安全示範
**檔案**：`examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

預覽 AI 安全措施的運作方式，測試 GitHub 模型的內容過濾功能。

此範例展示：
- 對潛在有害提示的內容過濾
- 應用中的安全回應處理
- 不同類別的被屏蔽內容（暴力、仇恨言論、錯誤資訊）
- 安全違規的正確錯誤處理

> **了解更多**：這只是負責任 AI 概念的介紹。關於倫理、偏見緩解、隱私考量和負責任 AI 框架的更多資訊，請參閱[第 5 章：負責任的生成式 AI](../05-ResponsibleGenAI/README.md)。

## 總結

在本章中，我們探討了 LLM 完成和聊天流程，實現了增強 AI 能力的函數調用，創建了檢索增強生成 (RAG) 系統，並展示了負責任的 AI 安全措施。

> **注意**：可通過提供的[**教學指南**](./TUTORIAL.md)進一步深入學習。

## 下一步

[第 4 章：實用應用與專案](../04-PracticalSamples/README.md)

**免責聲明**：  
本文件已使用 AI 翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 進行翻譯。儘管我們致力於提供準確的翻譯，請注意自動翻譯可能包含錯誤或不準確之處。原始語言的文件應被視為具權威性的來源。對於重要資訊，建議使用專業人工翻譯。我們對因使用此翻譯而引起的任何誤解或錯誤解釋概不負責。