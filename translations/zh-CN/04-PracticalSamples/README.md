# 实际应用与项目

[![实际应用与项目](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "实际应用与项目")

> **视频概览：** [在 YouTube 上观看“实际应用与项目”](https://www.youtube.com/watch?v=01vJsYei3H0)。

## 你将学习到的内容
本节将演示三个展示使用 Java 的生成式 AI 开发模式的实际应用：
- 创建一个结合客户端和服务器端 AI 的多模态宠物故事生成器
- 使用 Foundry Local Spring Boot 演示实现本地 AI 模型集成
- 利用计算器示例开发模型上下文协议（MCP）服务

## 目录

- [介绍](#介绍)
  - [Foundry Local Spring Boot 演示](#foundry-local-spring-boot-演示)
  - [宠物故事生成器](#宠物故事生成器)
  - [MCP 计算器服务（初学者友好的 MCP 演示）](#mcp-计算器服务（初学者友好的-mcp-演示）)
- [学习进展](#学习进展)
- [总结](#总结)
- [下一步](#下一步)

## 介绍

本章展示了演示生成式 AI 使用 Java 开发模式的<strong>示例项目</strong>。每个项目都是完整可用的，并展示了特定的 AI 技术、架构模式和最佳实践，供你适配到自己的应用中。

### Foundry Local Spring Boot 演示

**[Foundry Local Spring Boot 演示](foundrylocal/README.md)** 演示如何使用 **OpenAI Java SDK** 集成本地 AI 模型。它展示了如何连接运行于 Foundry Local（例如 **Phi-4-mini**）的模型，并支持自动模型检测，让你无需依赖云服务即可运行 AI 应用。

### 宠物故事生成器

**[宠物故事生成器](petstory/README.md)** 是一个有趣的 Spring Boot Web 应用，展示了<strong>多模态 AI 处理</strong>，用于生成创意宠物故事。它结合了客户端和服务器端 AI 功能，利用 transformer.js 实现在浏览器端的 AI 交互，和 OpenAI SDK 在服务器端的处理。

### MCP 计算器服务（初学者友好的 MCP 演示）

**[MCP 计算器服务](calculator/README.md)** 是一个使用 Spring AI 演示<strong>模型上下文协议（MCP）</strong>的简单示例。它为初学者提供了 MCP 概念的入门介绍，展示如何创建一个与 MCP 客户端交互的基础 MCP 服务器。

## 学习进展

这些项目旨在建立前几章的概念基础：

1. <strong>从简单开始</strong>：从 Foundry Local Spring Boot 演示入手，了解与本地模型的基本 AI 集成
2. <strong>添加交互性</strong>：进阶到宠物故事生成器，实现多模态 AI 及基于 Web 的交互
3. **学习 MCP 基础**：尝试 MCP 计算器服务，理解模型上下文协议的基本原理

## 总结

干得好！你已经探索了真实的应用：

- 在浏览器和服务器端均可运行的多模态 AI 体验
- 使用现代 Java 框架和 SDK 进行本地 AI 模型集成
- 你第一个模型上下文协议服务，了解工具与 AI 的集成方式

## 下一步

[第 5 章：负责任的生成式 AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**免责声明**：
本文件使用AI翻译服务[Co-op Translator](https://github.com/Azure/co-op-translator)进行翻译。虽然我们努力确保准确性，但请注意，自动翻译可能包含错误或不准确之处。原始语言的文档应被视为权威来源。对于重要信息，建议采用专业人工翻译。对于因使用本翻译而产生的任何误解或错误解释，我们不承担任何责任。
<!-- CO-OP TRANSLATOR DISCLAIMER END -->