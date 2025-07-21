# Core Generative AI Techniques

>**Note**: This chapter includes a detailed [**Tutorial**](./TUTORIAL.md) that guides you through running the finished samples.

## What You'll Learn
In this chapter, we look at 4 core generative AI techniques through practical examples:
- LLM completions and chat flows
- Function calling
- Retrieval-Augmented Generation (RAG)
- Responsible AI safety measures

## Table of Contents

- [What You'll Learn](#what-youll-learn)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Examples Overview](#examples-overview)
  - [1. LLM Completions and Chat Flows](#1-llm-completions-and-chat-flows)
  - [2. Functions & Plugins with LLMs](#2-functions--plugins-with-llms)
  - [3. Retrieval-Augmented Generation (RAG)](#3-retrieval-augmented-generation-rag)
  - [4. Responsible AI Safety Demonstration](#4-responsible-ai-safety-demonstration)
- [Summary](#summary)
- [Next Steps](#next-steps)

## Prerequisites

- Completed setup from [Chapter 2](../02-SetupDevEnvironment/)

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

Learn to build conversational AI with streaming responses and chat history management.

This example demonstrates:
- Simple text completion with system prompts
- Multi-turn conversations with history management
- Interactive chat sessions
- Parameter configuration (temperature, max tokens)

### 2. Functions & Plugins with LLMs
**File**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Extend AI capabilities by giving models access to custom functions and external APIs.

This example demonstrates:
- Weather function integration
- Calculator function implementation  
- Multiple function calls in one conversation
- Function definition with JSON schemas

### 3. Retrieval-Augmented Generation (RAG)
**File**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Learn how to combine AI with your own documents and data sources for accurate, context-aware responses.

This example demonstrates:
- Document-based question answering with Azure OpenAI SDK
- RAG pattern implementation with GitHub Models

**Usage**: Ask questions about the content in `document.txt` and get AI responses based only on that context.

### 4. Responsible AI Safety Demonstration
**File**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Get a preview of how AI safety measures work by testing GitHub Models' content filtering capabilities.

This example demonstrates:
- Content filtering for potentially harmful prompts
- Safety response handling in applications
- Different categories of blocked content (violence, hate speech, misinformation)
- Proper error handling for safety violations

> **Learn More**: This is just an introduction to responsible AI concepts. For more information on ethics, bias mitigation, privacy considerations, and responsible AI frameworks, see [Chapter 5: Responsible Generative AI](../05-ResponsibleGenAI/README.md).

## Summary

In this chapter, we explored LLM completions and chat flows, implemented function calling to enhance AI capabilities, created a Retrieval-Augmented Generation (RAG) system, and demonstrated responsible AI safety measures. 

> **NOTE**: Dive deeper with the provided [**Tutorial**](./TUTORIAL.md)


## Next Steps

[Chapter 4: Practical Applications & Projects](../04-PracticalSamples/README.md)
