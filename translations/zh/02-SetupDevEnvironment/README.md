<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c670445516e119888d8aaaa207bbee34",
  "translation_date": "2025-07-27T12:54:13+00:00",
  "source_file": "02-SetupDevEnvironment/README.md",
  "language_code": "zh"
}
-->
# 为 Java 的生成式 AI 设置开发环境

> **快速开始**：2 分钟内在云端编写代码 - 跳转到 [GitHub Codespaces 设置](../../../02-SetupDevEnvironment) - 无需本地安装，使用 GitHub 模型！

> **对 Azure OpenAI 感兴趣？** 请参阅我们的 [Azure OpenAI 设置指南](getting-started-azure-openai.md)，了解创建新的 Azure OpenAI 资源的步骤。

## 学习内容

- 设置用于 AI 应用的 Java 开发环境
- 选择并配置您偏好的开发环境（优先推荐 Codespaces 云端环境、本地开发容器或完整的本地设置）
- 通过连接到 GitHub 模型测试您的设置

## 目录

- [学习内容](../../../02-SetupDevEnvironment)
- [简介](../../../02-SetupDevEnvironment)
- [步骤 1：设置开发环境](../../../02-SetupDevEnvironment)
  - [选项 A：GitHub Codespaces（推荐）](../../../02-SetupDevEnvironment)
  - [选项 B：本地开发容器](../../../02-SetupDevEnvironment)
  - [选项 C：使用现有的本地安装](../../../02-SetupDevEnvironment)
- [步骤 2：创建 GitHub 个人访问令牌](../../../02-SetupDevEnvironment)
- [步骤 3：测试您的设置](../../../02-SetupDevEnvironment)
- [故障排除](../../../02-SetupDevEnvironment)
- [总结](../../../02-SetupDevEnvironment)
- [下一步](../../../02-SetupDevEnvironment)

## 简介

本章将指导您设置开发环境。我们将使用 **GitHub 模型** 作为主要示例，因为它免费、易于设置（只需一个 GitHub 账户）、无需信用卡，并提供多种模型供实验。

**无需本地设置！** 您可以直接使用 GitHub Codespaces 开始编写代码，它在浏览器中提供完整的开发环境。

<img src="./images/models.webp" alt="截图：GitHub 模型" width="50%">

我们推荐使用 [**GitHub 模型**](https://github.com/marketplace?type=models) 进行本课程，因为它：
- **免费** 开始使用
- **简单** 设置，只需一个 GitHub 账户
- **无需信用卡**
- **多种模型** 可供实验

> **注意**：本培训中使用的 GitHub 模型有以下免费限制：
> - 每分钟 15 次请求（每天 150 次）
> - 每次请求约 8,000 字输入，约 4,000 字输出
> - 5 个并发请求
> 
> 对于生产用途，请使用您的 Azure 账户升级到 Azure AI Foundry 模型。代码无需更改。请参阅 [Azure AI Foundry 文档](https://learn.microsoft.com/azure/ai-foundry/foundry-models/how-to/quickstart-github-models)。

## 步骤 1：设置开发环境

<a name="quick-start-cloud"></a>

我们创建了一个预配置的开发容器，以最大限度减少设置时间，并确保您拥有完成本课程所需的所有工具。选择您偏好的开发方式：

### 环境设置选项：

#### 选项 A：GitHub Codespaces（推荐）

**2 分钟内开始编写代码 - 无需本地设置！**

1. 将此仓库 Fork 到您的 GitHub 账户
   > **注意**：如果您想编辑基本配置，请查看 [开发容器配置](../../../.devcontainer/devcontainer.json)
2. 点击 **Code** → **Codespaces** 标签 → **...** → **New with options...**
3. 使用默认设置 - 这将选择 **开发容器配置**：为本课程创建的 **生成式 AI Java 开发环境** 自定义开发容器
4. 点击 **Create codespace**
5. 等待约 2 分钟，环境准备就绪
6. 继续 [步骤 2：创建 GitHub 令牌](../../../02-SetupDevEnvironment)

<img src="./images/codespaces.png" alt="截图：Codespaces 子菜单" width="50%">

<img src="./images/image.png" alt="截图：New with options" width="50%">

<img src="./images/codespaces-create.png" alt="截图：创建 Codespace 选项" width="50%">

> **Codespaces 的优势**：
> - 无需本地安装
> - 适用于任何带浏览器的设备
> - 预配置所有工具和依赖项
> - 个人账户每月免费 60 小时
> - 为所有学习者提供一致的环境

#### 选项 B：本地开发容器

**适合偏好使用 Docker 进行本地开发的开发者**

1. 将此仓库 Fork 并克隆到您的本地机器
   > **注意**：如果您想编辑基本配置，请查看 [开发容器配置](../../../.devcontainer/devcontainer.json)
2. 安装 [Docker Desktop](https://www.docker.com/products/docker-desktop/) 和 [VS Code](https://code.visualstudio.com/)
3. 在 VS Code 中安装 [开发容器扩展](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers)
4. 在 VS Code 中打开仓库文件夹
5. 当提示时，点击 **Reopen in Container**（或使用 `Ctrl+Shift+P` → "Dev Containers: Reopen in Container"）
6. 等待容器构建并启动
7. 继续 [步骤 2：创建 GitHub 令牌](../../../02-SetupDevEnvironment)

<img src="./images/devcontainer.png" alt="截图：开发容器设置" width="50%">

<img src="./images/image-3.png" alt="截图：开发容器构建完成" width="50%">

#### 选项 C：使用现有的本地安装

**适合已有 Java 环境的开发者**

前提条件：
- [Java 21+](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) 
- [Maven 3.9+](https://maven.apache.org/download.cgi)
- [VS Code](https://code.visualstudio.com) 或您偏好的 IDE

步骤：
1. 将此仓库克隆到您的本地机器
2. 在您的 IDE 中打开项目
3. 继续 [步骤 2：创建 GitHub 令牌](../../../02-SetupDevEnvironment)

> **专业提示**：如果您的机器配置较低但希望本地使用 VS Code，可以使用 GitHub Codespaces！您可以将本地 VS Code 连接到云托管的 Codespace，享受两者的优势。

<img src="./images/image-2.png" alt="截图：创建的本地开发容器实例" width="50%">

## 步骤 2：创建 GitHub 个人访问令牌

1. 进入 [GitHub 设置](https://github.com/settings/profile)，从您的个人资料菜单中选择 **Settings**。
2. 在左侧边栏中，点击 **Developer settings**（通常在底部）。
3. 在 **Personal access tokens** 下，点击 **Fine-grained tokens**（或直接访问此 [链接](https://github.com/settings/personal-access-tokens)）。
4. 点击 **Generate new token**。
5. 在“Token name”下提供一个描述性名称（例如 `GenAI-Java-Course-Token`）。
6. 设置过期日期（推荐：7 天以符合安全最佳实践）。
7. 在“Resource owner”下选择您的用户账户。
8. 在“Repository access”下选择您希望与 GitHub 模型一起使用的仓库（或选择“所有仓库”）。
9. 在“Repository permissions”下找到 **Models** 并设置为 **Read and write**。
10. 点击 **Generate token**。
11. **立即复制并保存您的令牌** - 您之后将无法再次查看！

> **安全提示**：为您的访问令牌使用最低所需范围和最短的实用过期时间。

## 步骤 3：使用 GitHub 模型示例测试您的设置

一旦您的开发环境准备就绪，让我们使用 [`02-SetupDevEnvironment/examples/github-models`](../../../02-SetupDevEnvironment/examples/github-models) 中的示例应用测试 GitHub 模型集成。

1. 在您的开发环境中打开终端。
2. 导航到 GitHub 模型示例：
   ```bash
   cd 02-SetupDevEnvironment/examples/github-models
   ```
3. 将您的 GitHub 令牌设置为环境变量：
   ```bash
   # macOS/Linux
   export GITHUB_TOKEN=your_token_here
   
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_token_here"
   ```

4. 运行应用程序：
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.githubmodels.App"
   ```

您应该看到类似以下的输出：
```text
Using model: gpt-4.1-nano
Sending request to GitHub Models...
Response: Hello World!
```

### 理解示例代码

首先，让我们理解刚刚运行的内容。`examples/github-models` 下的示例使用 OpenAI Java SDK 连接到 GitHub 模型：

**此代码的功能：**
- **连接**到 GitHub 模型，使用您的个人访问令牌
- **发送**一个简单的“Say Hello World!”消息给 AI 模型
- **接收**并显示 AI 的响应
- **验证**您的设置是否正常工作

**关键依赖项**（在 `pom.xml` 中）：
```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

**主代码**（`App.java`）：
```java
// Connect to GitHub Models using OpenAI Java SDK
OpenAIClient client = OpenAIOkHttpClient.builder()
    .apiKey(pat)
    .baseUrl("https://models.inference.ai.azure.com")
    .build();

// Create chat completion request
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .model(modelId)
    .addSystemMessage("You are a concise assistant.")
    .addUserMessage("Say Hello World!")
    .build();

// Get AI response
ChatCompletion response = client.chat().completions().create(params);
System.out.println("Response: " + response.choices().get(0).message().content().orElse("No response content"));
```

## 总结

**恭喜！** 您已成功完成以下任务：

- **创建了 GitHub 个人访问令牌**，并为 AI 模型访问设置了正确的权限
- **设置了 Java 开发环境**，使用 Codespaces、开发容器或本地安装
- **连接到 GitHub 模型**，使用 OpenAI Java SDK 免费访问 AI 开发
- **测试了集成**，运行了一个与 AI 模型通信的示例应用

## 下一步

[第 3 章：生成式 AI 核心技术](../03-CoreGenerativeAITechniques/README.md)

## 故障排除

遇到问题？以下是常见问题及解决方案：

- **令牌无法使用？** 
  - 确保您复制了完整的令牌，没有额外的空格
  - 验证令牌是否正确设置为环境变量
  - 检查令牌是否具有正确的权限（Models: Read and write）

- **找不到 Maven？** 
  - 如果使用开发容器/Codespaces，Maven 应已预安装
  - 对于本地设置，请确保安装了 Java 21+ 和 Maven 3.9+
  - 尝试运行 `mvn --version` 验证安装

- **连接问题？** 
  - 检查您的网络连接
  - 验证 GitHub 是否可以从您的网络访问
  - 确保您没有被防火墙阻止 GitHub 模型端点

- **开发容器无法启动？** 
  - 确保 Docker Desktop 正在运行（用于本地开发）
  - 尝试重建容器：`Ctrl+Shift+P` → "Dev Containers: Rebuild Container"

- **应用程序编译错误？**
  - 确保您在正确的目录：`02-SetupDevEnvironment/examples/github-models`
  - 尝试清理并重新编译：`mvn clean compile`

> **需要帮助？**：仍有问题？在仓库中打开一个 issue，我们会帮助您解决。

**免责声明**：  
本文档使用AI翻译服务 [Co-op Translator](https://github.com/Azure/co-op-translator) 进行翻译。尽管我们努力确保翻译的准确性，但请注意，自动翻译可能包含错误或不准确之处。应以原始语言的文档作为权威来源。对于关键信息，建议使用专业人工翻译。因使用本翻译而引起的任何误解或误读，我们概不负责。