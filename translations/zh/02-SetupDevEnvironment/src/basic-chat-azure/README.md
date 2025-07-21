<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2289320a74aeca1eb844cd7d3a7a9e12",
  "translation_date": "2025-07-21T16:25:37+00:00",
  "source_file": "02-SetupDevEnvironment/src/basic-chat-azure/README.md",
  "language_code": "zh"
}
-->
# 使用 Azure OpenAI 的基础聊天 - 端到端示例

此示例展示了如何创建一个简单的 Spring Boot 应用程序，连接到 Azure OpenAI 并测试您的设置。

## 目录

- [前置条件](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [快速开始](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [配置选项](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [选项 1：环境变量 (.env 文件) - 推荐](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [选项 2：GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [运行应用程序](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [使用 Maven](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [使用 VS Code](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [预期输出](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [配置参考](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [环境变量](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Spring 配置](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [故障排除](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [常见问题](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [调试模式](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [下一步](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [资源](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)

## 前置条件

在运行此示例之前，请确保您已完成以下步骤：

- 完成 [Azure OpenAI 设置指南](../../getting-started-azure-openai.md)  
- 部署 Azure OpenAI 资源（通过 Azure AI Foundry 门户）  
- 部署 gpt-4o-mini 模型（或其他替代模型）  
- 获取 Azure 的 API 密钥和端点 URL  

## 快速开始

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/src/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## 配置选项

### 选项 1：环境变量 (.env 文件) - 推荐

**步骤 1：创建您的配置文件**  
```bash
cp .env.example .env
```

**步骤 2：添加您的 Azure OpenAI 凭据**  
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **安全提示**：  
> - 切勿将 `.env` 文件提交到版本控制  
> - `.env` 文件已被添加到 `.gitignore`  
> - 确保您的 API 密钥安全并定期轮换  

### 选项 2：GitHub Codespace Secrets

对于 GitHub Codespaces，请在您的仓库中设置以下 Secrets：
- `AZURE_AI_KEY` - 您的 Azure OpenAI API 密钥
- `AZURE_AI_ENDPOINT` - 您的 Azure OpenAI 端点 URL

应用程序会自动检测并使用这些 Secrets。

### 替代方案：直接使用环境变量

<details>
<summary>点击查看平台特定命令</summary>

**Linux/macOS (bash/zsh):**  
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (命令提示符):**  
```cmd
set AZURE_AI_KEY=your-actual-api-key-here
set AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (PowerShell):**  
```powershell
$env:AZURE_AI_KEY="your-actual-api-key-here"
$env:AZURE_AI_ENDPOINT="https://your-hub-name.openai.azure.com/"
```
</details>

## 运行应用程序

### 使用 Maven

```bash
mvn spring-boot:run
```

### 使用 VS Code

1. 在 VS Code 中打开项目  
2. 按 `F5` 或使用 "运行和调试" 面板  
3. 选择 "Spring Boot-BasicChatApplication" 配置  

> **注意**：VS Code 配置会自动加载您的 .env 文件  

### 预期输出

```
Starting Basic Chat with Azure OpenAI...
Environment variables loaded successfully
Connecting to Azure OpenAI...
Sending prompt: What is AI in a short sentence? Max 100 words.

AI Response:
================
AI, or Artificial Intelligence, is the simulation of human intelligence in machines programmed to think and learn like humans.
================

Success! Azure OpenAI connection is working correctly.
```

## 配置参考

### 环境变量

| 变量 | 描述 | 必需 | 示例 |
|------|------|------|------|
| `AZURE_AI_KEY` | Azure OpenAI API 密钥 | 是 | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI 端点 URL | 是 | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | 模型部署名称 | 否 | `gpt-4o-mini`（默认值） |

### Spring 配置

`application.yml` 文件配置内容包括：
- **API 密钥**：`${AZURE_AI_KEY}` - 来自环境变量  
- **端点**：`${AZURE_AI_ENDPOINT}` - 来自环境变量  
- **模型**：`${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - 来自环境变量，带默认值  
- **温度**：`0.7` - 控制创意性（0.0 = 确定性，1.0 = 创意性）  
- **最大 Token 数**：`500` - 响应的最大长度  

## 故障排除

### 常见问题

<details>
<summary><strong>错误："API 密钥无效"</strong></summary>

- 检查您的 `.env` 文件中是否正确设置了 `AZURE_AI_KEY`  
- 确保 API 密钥与 Azure AI Foundry 门户中的完全一致  
- 确保密钥周围没有额外的空格或引号  
</details>

<details>
<summary><strong>错误："端点无效"</strong></summary>

- 确保您的 `AZURE_AI_ENDPOINT` 包含完整的 URL（例如 `https://your-hub-name.openai.azure.com/`）  
- 检查是否有一致的尾部斜杠  
- 确保端点与您的 Azure 部署区域匹配  
</details>

<details>
<summary><strong>错误："未找到部署"</strong></summary>

- 确保您的模型部署名称与 Azure 中部署的名称完全一致  
- 检查模型是否已成功部署并处于活动状态  
- 尝试使用默认部署名称：`gpt-4o-mini`  
</details>

<details>
<summary><strong>VS Code：环境变量未加载</strong></summary>

- 确保您的 `.env` 文件位于项目根目录（与 `pom.xml` 同级）  
- 尝试在 VS Code 的集成终端中运行 `mvn spring-boot:run`  
- 检查 VS Code 的 Java 扩展是否正确安装  
- 验证启动配置是否包含 `"envFile": "${workspaceFolder}/.env"`  
</details>

### 调试模式

要启用详细日志记录，请取消注释 `application.yml` 中的以下行：

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## 下一步

**设置完成！** 继续您的学习之旅：

[第 3 章：核心生成式 AI 技术](../../../03-CoreGenerativeAITechniques/README.md)

## 资源

- [Spring AI Azure OpenAI 文档](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)  
- [Azure OpenAI 服务文档](https://learn.microsoft.com/azure/ai-services/openai/)  
- [Azure AI Foundry 门户](https://ai.azure.com/)  
- [Azure AI Foundry 文档](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)  

**免责声明**：  
本文档使用AI翻译服务 [Co-op Translator](https://github.com/Azure/co-op-translator) 进行翻译。尽管我们努力确保翻译的准确性，但请注意，自动翻译可能包含错误或不准确之处。原始语言的文档应被视为权威来源。对于关键信息，建议使用专业人工翻译。我们不对因使用此翻译而产生的任何误解或误读承担责任。