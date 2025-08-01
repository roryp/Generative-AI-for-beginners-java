<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "79df2d245c12d6b8ad57148fd049f106",
  "translation_date": "2025-07-23T11:59:26+00:00",
  "source_file": "README.md",
  "language_code": "zh"
}
-->
# 初学者生成式 AI - Java 版
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![初学者生成式 AI - Java 版](../../translated_images/beg-genai-series.61edc4a6b2cc54284fa2d70eda26dc0ca2669e26e49655b842ea799cd6e16d2a.zh.png)

> **NOTE: 快速开始**：整个课程可在线完成 - 无需本地设置！
1. 将此仓库 Fork 到您的 GitHub 账户
2. 点击 **Code** → **Codespaces** 标签 → **...** → **New with options...**
3. 使用默认设置 – 这将选择为本课程创建的开发容器
4. 点击 **Create codespace**
5. 等待大约 2 分钟，环境准备就绪
6. 直接跳转到 [创建您的 GitHub 模型令牌](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## 多语言支持

### 通过 GitHub Action 支持（自动化且始终保持最新）

[法语](../fr/README.md) | [西班牙语](../es/README.md) | [德语](../de/README.md) | [俄语](../ru/README.md) | [阿拉伯语](../ar/README.md) | [波斯语 (法尔西语)](../fa/README.md) | [乌尔都语](../ur/README.md) | [中文 (简体)](./README.md) | [中文 (繁体, 澳门)](../mo/README.md) | [中文 (繁体, 香港)](../hk/README.md) | [中文 (繁体, 台湾)](../tw/README.md) | [日语](../ja/README.md) | [韩语](../ko/README.md) | [印地语](../hi/README.md) | [孟加拉语](../bn/README.md) | [马拉地语](../mr/README.md) | [尼泊尔语](../ne/README.md) | [旁遮普语 (古木基文)](../pa/README.md) | [葡萄牙语 (葡萄牙)](../pt/README.md) | [葡萄牙语 (巴西)](../br/README.md) | [意大利语](../it/README.md) | [波兰语](../pl/README.md) | [土耳其语](../tr/README.md) | [希腊语](../el/README.md) | [泰语](../th/README.md) | [瑞典语](../sv/README.md) | [丹麦语](../da/README.md) | [挪威语](../no/README.md) | [芬兰语](../fi/README.md) | [荷兰语](../nl/README.md) | [希伯来语](../he/README.md) | [越南语](../vi/README.md) | [印尼语](../id/README.md) | [马来语](../ms/README.md) | [他加禄语 (菲律宾语)](../tl/README.md) | [斯瓦希里语](../sw/README.md) | [匈牙利语](../hu/README.md) | [捷克语](../cs/README.md) | [斯洛伐克语](../sk/README.md) | [罗马尼亚语](../ro/README.md) | [保加利亚语](../bg/README.md) | [塞尔维亚语 (西里尔文)](../sr/README.md) | [克罗地亚语](../hr/README.md) | [斯洛文尼亚语](../sl/README.md) | [乌克兰语](../uk/README.md) | [缅甸语 (缅甸)](../my/README.md)

## 课程结构与学习路径

**时间投入**：环境设置需 2 分钟，动手教程每个需 1-3 小时，具体取决于探索深度。

### **第 1 章：生成式 AI 简介**
- **核心概念**：了解大型语言模型、tokens、嵌入和 AI 能力
- **Java AI 生态系统**：Spring AI 和 OpenAI SDK 的概述
- **模型上下文协议**：介绍 MCP 及其在 AI 代理通信中的作用
- **实际应用**：包括聊天机器人和内容生成的真实场景
- **[→ 开始第 1 章](./01-IntroToGenAI/README.md)**

### **第 2 章：开发环境设置**
- **多提供商配置**：设置 GitHub 模型、Azure OpenAI 和 OpenAI Java SDK 集成
- **Spring Boot + Spring AI**：企业 AI 应用开发的最佳实践
- **GitHub 模型**：免费 AI 模型访问，用于原型设计和学习（无需信用卡）
- **开发工具**：Docker 容器、VS Code 和 GitHub Codespaces 配置
- **[→ 开始第 2 章](./02-SetupDevEnvironment/README.md)**

### **第 3 章：生成式 AI 核心技术**
- **提示工程**：优化 AI 模型响应的技术
- **嵌入与向量操作**：实现语义搜索和相似性匹配
- **检索增强生成 (RAG)**：将 AI 与您自己的数据源结合
- **函数调用**：通过自定义工具和插件扩展 AI 功能
- **[→ 开始第 3 章](./03-CoreGenerativeAITechniques/README.md)**

### **第 4 章：实际应用与项目**
- **宠物故事生成器** (`petstory/`)：使用 GitHub 模型进行创意内容生成
- **Foundry 本地演示** (`foundrylocal/`)：使用 OpenAI Java SDK 的本地 AI 模型集成
- **MCP 计算器服务** (`mcp/calculator/`)：使用 Spring AI 实现基本的模型上下文协议
- **[→ 开始第 4 章](./04-PracticalSamples/README.md)**

### **第 5 章：负责任的 AI 开发**
- **GitHub 模型安全性**：测试内置内容过滤和安全机制
- **负责任的 AI 演示**：展示 AI 安全过滤器实际工作方式的动手示例
- **最佳实践**：道德 AI 开发和部署的基本指南
- **[→ 开始第 5 章](./05-ResponsibleGenAI/README.md)**

## 其他资源

- [初学者 AI 代理](https://github.com/microsoft/ai-agents-for-beginners)
- [使用 .NET 的初学者生成式 AI](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [使用 JavaScript 的初学者生成式 AI](https://github.com/microsoft/generative-ai-with-javascript)
- [初学者生成式 AI](https://github.com/microsoft/generative-ai-for-beginners)
- [初学者机器学习](https://aka.ms/ml-beginners)
- [初学者数据科学](https://aka.ms/datascience-beginners)
- [初学者 AI](https://aka.ms/ai-beginners)
- [初学者网络安全](https://github.com/microsoft/Security-101)
- [初学者 Web 开发](https://aka.ms/webdev-beginners)
- [初学者物联网](https://aka.ms/iot-beginners)
- [初学者 XR 开发](https://github.com/microsoft/xr-development-for-beginners)
- [掌握 GitHub Copilot 进行 AI 配对编程](https://aka.ms/GitHubCopilotAI)
- [掌握 GitHub Copilot 为 C#/.NET 开发者服务](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [选择您的 Copilot 冒险之旅](https://github.com/microsoft/CopilotAdventures)
- [使用 Azure AI 服务的 RAG 聊天应用](https://github.com/Azure-Samples/azure-search-openai-demo-java)

**免责声明**：  
本文档使用AI翻译服务 [Co-op Translator](https://github.com/Azure/co-op-translator) 进行翻译。尽管我们努力确保翻译的准确性，但请注意，自动翻译可能包含错误或不准确之处。应以原始语言的文档作为权威来源。对于关键信息，建议使用专业人工翻译。我们对因使用此翻译而产生的任何误解或误读不承担责任。