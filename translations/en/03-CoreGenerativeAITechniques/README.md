<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T20:39:37+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "en"
}
-->
# Core Generative AI Techniques

>**Note**: This chapter includes a detailed [**Tutorial**](./TUTORIAL.md) that guides you through running the finished samples.

## What You'll Learn
In this chapter, we explore 4 essential generative AI techniques through practical examples:
- LLM completions and chat flows
- Function calling
- Retrieval-Augmented Generation (RAG)
- Responsible AI safety measures

## Table of Contents

- [What You'll Learn](../../../03-CoreGenerativeAITechniques)
- [Prerequisites](../../../03-CoreGenerativeAITechniques)
- [Getting Started](../../../03-CoreGenerativeAITechniques)
- [Examples Overview](../../../03-CoreGenerativeAITechniques)
  - [1. LLM Completions and Chat Flows](../../../03-CoreGenerativeAITechniques)
  - [2. Functions & Plugins with LLMs](../../../03-CoreGenerativeAITechniques)
  - [3. Retrieval-Augmented Generation (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Responsible AI Safety Demonstration](../../../03-CoreGenerativeAITechniques)
- [Summary](../../../03-CoreGenerativeAITechniques)
- [Next Steps](../../../03-CoreGenerativeAITechniques)

## Prerequisites

- Completed setup from [Chapter 2](../../../02-SetupDevEnvironment)

## Getting Started

1. **Navigate to examples**: 
```bash
cd 03-CoreGenerativeAITechniques/examples/
```
2. **Set environment**: 
```bash
export GITHUB_TOKEN=your_token_here
```
3. **Compile and run examples**:
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

## Examples Overview

The examples are organized in the `examples/` folder with the following structure:

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

### 1. LLM Completions and Chat Flows
**File**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Learn how to create conversational AI with streaming responses and chat history management.

This example covers:
- Basic text completion using system prompts
- Multi-turn conversations with history tracking
- Interactive chat sessions
- Configuring parameters like temperature and max tokens

### 2. Functions & Plugins with LLMs
**File**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Enhance AI capabilities by enabling models to use custom functions and external APIs.

This example covers:
- Integrating a weather function
- Implementing a calculator function  
- Handling multiple function calls in a single conversation
- Defining functions using JSON schemas

### 3. Retrieval-Augmented Generation (RAG)
**File**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Learn how to combine AI with your own documents and data sources for precise, context-aware responses.

This example covers:
- Answering questions based on documents using the Azure OpenAI SDK
- Implementing the RAG pattern with GitHub Models

**Usage**: Ask questions about the content in `document.txt` and receive AI responses based solely on that context.

### 4. Responsible AI Safety Demonstration
**File**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Explore how AI safety measures work by testing GitHub Models' content filtering features.

This example covers:
- Filtering content for potentially harmful prompts
- Handling safety responses in applications
- Categories of blocked content (e.g., violence, hate speech, misinformation)
- Managing errors related to safety violations

> **Learn More**: This is just an introduction to responsible AI concepts. For more details on ethics, bias mitigation, privacy considerations, and responsible AI frameworks, see [Chapter 5: Responsible Generative AI](../05-ResponsibleGenAI/README.md).

## Summary

In this chapter, we explored LLM completions and chat flows, implemented function calling to extend AI capabilities, created a Retrieval-Augmented Generation (RAG) system, and demonstrated responsible AI safety measures. 

> **NOTE**: Dive deeper with the provided [**Tutorial**](./TUTORIAL.md)

## Next Steps

[Chapter 4: Practical Applications & Projects](../04-PracticalSamples/README.md)

**Disclaimer**:  
This document has been translated using the AI translation service [Co-op Translator](https://github.com/Azure/co-op-translator). While we aim for accuracy, please note that automated translations may include errors or inaccuracies. The original document in its native language should be regarded as the authoritative source. For critical information, professional human translation is advised. We are not responsible for any misunderstandings or misinterpretations resulting from the use of this translation.