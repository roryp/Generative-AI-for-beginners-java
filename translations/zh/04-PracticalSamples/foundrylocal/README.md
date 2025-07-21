<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T16:33:04+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "zh"
}
-->
# Foundry Local 命令行应用程序

>**注意**：本章包含一个[**教程**](./TUTORIAL.md)，指导您运行完成的示例。

一个简单的 Spring Boot 命令行应用程序，演示如何使用 OpenAI Java SDK 连接到 Foundry Local。

## 您将学到什么

- 如何使用 OpenAI Java SDK 将 Foundry Local 集成到 Spring Boot 应用程序中
- 本地 AI 开发和测试的最佳实践

## 目录

- [您将学到什么](../../../../04-PracticalSamples/foundrylocal)
- [先决条件](../../../../04-PracticalSamples/foundrylocal)
  - [安装 Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [验证](../../../../04-PracticalSamples/foundrylocal)
- [配置](../../../../04-PracticalSamples/foundrylocal)
- [快速开始](../../../../04-PracticalSamples/foundrylocal)
- [应用程序功能](../../../../04-PracticalSamples/foundrylocal)
- [示例输出](../../../../04-PracticalSamples/foundrylocal)
- [架构](../../../../04-PracticalSamples/foundrylocal)
- [代码亮点](../../../../04-PracticalSamples/foundrylocal)
  - [OpenAI Java SDK 集成](../../../../04-PracticalSamples/foundrylocal)
  - [聊天补全 API](../../../../04-PracticalSamples/foundrylocal)
- [故障排除](../../../../04-PracticalSamples/foundrylocal)

## 先决条件

> **⚠️ 注意**：此应用程序**无法在提供的 devcontainer 中运行**，因为它需要在主机系统上安装并运行 Foundry Local。

### 安装 Foundry Local

在运行此应用程序之前，您需要安装并启动 Foundry Local。请按照以下步骤操作：

1. **确保您的系统满足要求**：
   - **操作系统**：Windows 10 (x64)、Windows 11 (x64/ARM)、Windows Server 2025 或 macOS
   - **硬件**：
     - 最低配置：8GB RAM，3GB 可用磁盘空间
     - 推荐配置：16GB RAM，15GB 可用磁盘空间
   - **网络**：首次下载模型需要互联网连接（离线使用可选）
   - **加速（可选）**：NVIDIA GPU（2000 系列或更新）、AMD GPU（6000 系列或更新）、Qualcomm Snapdragon X Elite（8GB 或更多内存）或 Apple 芯片
   - **权限**：需要管理员权限以在设备上安装软件

2. **安装 Foundry Local**：

   **对于 Windows：**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **对于 macOS：**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   或者，您可以从 [Foundry Local GitHub 仓库](https://github.com/microsoft/Foundry-Local) 下载安装程序。

3. **启动您的第一个模型**：

   ```bash
   foundry model run phi-3.5-mini
   ```

   模型将被下载（根据您的网络速度可能需要几分钟），然后运行。Foundry Local 会自动为您的系统选择最佳模型版本（NVIDIA GPU 使用 CUDA，其他情况使用 CPU 版本）。

4. **通过在同一终端中提问来测试模型**：

   ```bash
   Why is the sky blue?
   ```

   您应该会看到 Phi 模型的响应，解释为什么天空看起来是蓝色的。

### 验证

您可以通过以下命令验证一切是否正常运行：

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

您还可以在浏览器中访问 `http://localhost:5273` 查看 Foundry Local 的 Web 界面。

## 配置

该应用程序可以通过 `application.properties` 文件进行配置：

- `foundry.local.base-url` - Foundry Local 的基础 URL（默认值：`http://localhost:5273`）
- `foundry.local.model` - 要使用的 AI 模型（默认值：`Phi-3.5-mini-instruct-cuda-gpu`）

> **注意**：配置中的模型名称应与 Foundry Local 为您的系统下载的具体版本匹配。当您运行 `foundry model run phi-3.5-mini` 时，Foundry Local 会自动选择并下载最佳版本（NVIDIA GPU 使用 CUDA，其他情况使用 CPU 版本）。使用 `foundry model list` 查看本地实例中可用的确切模型名称。

## 快速开始

### 1. 导航到 Foundry Local 应用程序目录
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. 运行应用程序

```bash
mvn spring-boot:run
```

或者构建并运行 JAR 文件：

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### 依赖项

此应用程序使用 OpenAI Java SDK 与 Foundry Local 通信。关键依赖项是：

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

该应用程序已预配置为连接到运行在默认端口上的 Foundry Local。

## 应用程序功能

运行应用程序时：

1. **启动**为命令行应用程序（无 Web 服务器）
2. **自动发送**测试消息："Hello! Can you tell me what you are and what model you're running?"
3. **在控制台显示**来自 Foundry Local 的响应
4. **演示结束后**干净退出

## 示例输出

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## 架构

- **Application.java** - 包含 CommandLineRunner 的 Spring Boot 主应用程序
- **FoundryLocalService.java** - 使用 OpenAI Java SDK 与 Foundry Local 通信的服务
- 使用 **OpenAI Java SDK** 进行类型安全的 API 调用
- SDK 自动处理 JSON 序列化/反序列化
- 使用 Spring 的 `@Value` 和 `@PostConstruct` 注解实现简洁配置

## 代码亮点

### OpenAI Java SDK 集成

应用程序使用 OpenAI Java SDK 创建一个为 Foundry Local 配置的客户端：

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### 聊天补全 API

进行聊天补全请求简单且类型安全：

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## 故障排除

如果出现连接错误：
1. 验证 Foundry Local 是否运行在 `http://localhost:5273`
2. 检查是否有 Phi-3.5-mini 模型版本可用，使用 `foundry model list`
3. 确保 `application.properties` 中的模型名称与列表中显示的确切模型名称匹配
4. 确保没有防火墙阻止连接

常见问题：
- **找不到模型**：运行 `foundry model run phi-3.5-mini` 下载并启动模型
- **服务未运行**：Foundry Local 服务可能已停止；使用模型运行命令重新启动
- **模型名称错误**：使用 `foundry model list` 查看可用模型并相应更新配置

**免责声明**：  
本文档使用AI翻译服务 [Co-op Translator](https://github.com/Azure/co-op-translator) 进行翻译。尽管我们努力确保翻译的准确性，但请注意，自动翻译可能包含错误或不准确之处。原始语言的文档应被视为权威来源。对于关键信息，建议使用专业人工翻译。我们对因使用此翻译而产生的任何误解或误读不承担责任。