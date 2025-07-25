<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b8a372dfc3e3e7ad9261231a22fd79c0",
  "translation_date": "2025-07-25T08:55:14+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "zh"
}
-->
# 核心生成式 AI 技术

>**Note**: 本章包含一个详细的[**教程**](./TUTORIAL.md)，通过示例引导您学习。

## 您将学到什么
在本章中，我们通过实际示例学习 4 种核心生成式 AI 技术：
- LLM 完成和聊天流程
- 函数调用
- 检索增强生成 (RAG)
- 负责任的 AI 安全措施

## 目录

- [您将学到什么](../../../03-CoreGenerativeAITechniques)
- [前置条件](../../../03-CoreGenerativeAITechniques)
- [开始使用](../../../03-CoreGenerativeAITechniques)
- [示例概览](../../../03-CoreGenerativeAITechniques)
  - [1. LLM 完成和聊天流程](../../../03-CoreGenerativeAITechniques)
  - [2. 使用 LLM 的函数和插件](../../../03-CoreGenerativeAITechniques)
  - [3. 检索增强生成 (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. 负责任的 AI 安全演示](../../../03-CoreGenerativeAITechniques)
- [总结](../../../03-CoreGenerativeAITechniques)
- [下一步](../../../03-CoreGenerativeAITechniques)

## 前置条件

- 完成[第 2 章](../../../02-SetupDevEnvironment)中的环境设置

## 开始使用

1. **导航到示例**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **设置环境**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **编译并运行示例**:  
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

## 示例概览

这些示例组织在 `examples/` 文件夹中，结构如下：

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
**文件**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

学习如何构建具有流式响应和聊天历史管理的对话式 AI。

此示例演示：
- 使用系统提示进行简单文本完成
- 带有历史管理的多轮对话
- 交互式聊天会话
- 参数配置（temperature，max tokens）

### 2. 使用 LLM 的函数和插件
**文件**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

通过为模型提供自定义函数和外部 API 来扩展 AI 的能力。

此示例演示：
- 天气功能集成
- 计算器功能实现  
- 在一次对话中调用多个函数
- 使用 JSON schema 定义函数

### 3. 检索增强生成 (RAG)
**文件**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

学习如何将 AI 与您自己的文档和数据源结合，以生成准确且具有上下文的响应。

此示例演示：
- 使用 Azure OpenAI SDK 基于文档的问答
- 使用 GitHub 模型实现 RAG 模式

**使用方法**: 针对 `document.txt` 中的内容提问，AI 将仅基于该上下文提供响应。

### 4. 负责任的 AI 安全演示
**文件**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

通过测试 GitHub 模型的内容过滤功能，预览 AI 安全措施的工作方式。

此示例演示：
- 对潜在有害提示的内容过滤
- 应用中的安全响应处理
- 不同类别的屏蔽内容（暴力、仇恨言论、错误信息）
- 针对安全违规的正确错误处理

> **了解更多**: 这只是负责任 AI 概念的介绍。有关伦理、偏见缓解、隐私考虑和负责任 AI 框架的更多信息，请参阅[第 5 章：负责任的生成式 AI](../05-ResponsibleGenAI/README.md)。

## 总结

在本章中，我们探索了 LLM 完成和聊天流程，实施了函数调用以增强 AI 能力，创建了检索增强生成 (RAG) 系统，并演示了负责任的 AI 安全措施。

> **NOTE**: 使用提供的[**教程**](./TUTORIAL.md)深入学习。

## 下一步

[第 4 章：实用应用与项目](../04-PracticalSamples/README.md)

**免责声明**：  
本文档使用AI翻译服务 [Co-op Translator](https://github.com/Azure/co-op-translator) 进行翻译。尽管我们努力确保翻译的准确性，但请注意，自动翻译可能包含错误或不准确之处。原始语言的文档应被视为权威来源。对于重要信息，建议使用专业人工翻译。我们不对因使用此翻译而产生的任何误解或误读承担责任。