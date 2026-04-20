# Foundry 本地 Spring Boot 教程

## 目录

- [先决条件](#先决条件)
- [项目概述](#项目概述)
- [理解代码](#理解代码)
  - [1. 应用配置（application.properties）](#1-应用配置（applicationproperties）)
  - [2. 主应用类（Application.java）](#2-主应用类（applicationjava）)
  - [3. AI 服务层（FoundryLocalService.java）](#3-ai-服务层（foundrylocalservicejava）)
  - [4. 项目依赖（pom.xml）](#4-项目依赖（pomxml）)
- [整体工作流程](#整体工作流程)
- [设置 Foundry 本地](#设置-foundry-本地)
- [运行应用程序](#运行应用程序)
- [预期输出](#预期输出)
- [下一步](#下一步)
- [故障排除](#故障排除)


## 先决条件

开始本教程前，请确保您已具备：

- 在系统上安装了 **Java 21 或更高版本**
- 具备构建项目所需的 **Maven 3.6+**
- 已安装并运行 **Foundry 本地**

### **安装 Foundry 本地：**

> **注意：** Foundry 本地 CLI 目前仅支持 **Windows** 和 **macOS**。Linux 支持通过 [Foundry 本地 SDK](https://github.com/microsoft/Foundry-Local)（Python、JavaScript、C#、Rust）。

```bash
# Windows（视窗操作系统）
winget install Microsoft.FoundryLocal

# macOS（苹果操作系统）
brew tap microsoft/foundrylocal
brew install foundrylocal
```

验证安装：
```bash
foundry --version
```

## 项目概述

本项目包含四个主要组件：

1. **Application.java** - 主要 Spring Boot 应用入口
2. **FoundryLocalService.java** - 处理 AI 通信的服务层
3. **application.properties** - 配置 Foundry 本地连接
4. **pom.xml** - Maven 依赖和项目配置

## 理解代码

### 1. 应用配置（application.properties）

**文件路径：** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**功能说明：**
- **base-url**：指定 Foundry 本地运行的位置，包括 `/v1` 路径以兼容 OpenAI API。默认端口为 `5273`。如果端口不同，请使用 `foundry service status` 检查。
- **model**（可选）：指定用于文本生成的 AI 模型名称。**默认情况下，应用会在启动时自动通过 Foundry 本地的 `/v1/models` 端点检测模型，无需手动设置。**如果需要，也可以显式设置以覆盖自动检测。

**关键概念：** Spring Boot 会自动加载这些属性，并通过 `@Value` 注解将它们注入应用。

### 2. 主应用类（Application.java）

**文件路径：** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // 不需要网络服务器
        app.run(args);
    }
```

**功能说明：**
- `@SpringBootApplication` 启用 Spring Boot 自动配置
- `WebApplicationType.NONE` 表明这是一个命令行应用，而非 Web 服务器
- main 方法启动 Spring 应用

**演示运行器：**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        System.out.println("Calling Foundry Local service...");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
        System.out.println("=========================");
    };
}
```

**功能说明：**
- `@Bean` 用于创建由 Spring 管理的组件
- `CommandLineRunner` 会在 Spring Boot 启动后执行代码
- `foundryLocalService` 由 Spring 自动注入（依赖注入）
- 向 AI 发送测试消息并显示响应

### 3. AI 服务层（FoundryLocalService.java）

**文件路径：** `src/main/java/com/example/FoundryLocalService.java`

#### 配置注入：
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // 如果为空则自动检测
```

**功能说明：**
- `@Service` 表明此类提供业务逻辑
- `@Value` 将 application.properties 中的配置值注入
- 模型默认为空，启动时会触发 **Foundry 本地的自动检测**。这意味着应用能支持 Foundry 本地加载的任何模型，无需手动配置。

#### 客户端初始化：
```java
@PostConstruct
public void init() {
    // 如果未明确配置，则自动从 Foundry Local 检测模型
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // 基础 URL 已包含配置中的 /v1
            .apiKey("not-needed")            // 本地服务器不需要真实的 API 密钥
            .build();
}
```

**功能说明：**
- `@PostConstruct` 使该方法在 Spring 创建服务后自动执行
- 如果未配置模型，查询 Foundry 本地的 `/v1/models` 端点并选取第一个已加载模型
- 创建指向您的本地 Foundry 实例的 OpenAI 客户端
- 来自 `application.properties` 的基本 URL 已包含 `/v1` 以兼容 OpenAI API
- API 密钥设为 "not-needed"，因为本地开发不需要认证

#### 聊天方法：
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // 使用哪个AI模型
                .addUserMessage(message)         // 你的问题/提示
                .maxCompletionTokens(150)        // 限制响应长度
                .temperature(0.7)                // 控制创造力（0.0-1.0）
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // 从API结果中提取AI的响应
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**功能说明：**
- **ChatCompletionCreateParams**：配置 AI 请求参数
  - `model`：指定使用的 AI 模型（必须精确匹配 `foundry model list` 中的 ID）
  - `addUserMessage`：将用户消息添加到对话中
  - `maxCompletionTokens`：限制响应最大长度（节省资源）
  - `temperature`：控制随机度（0.0=确定性，1.0=创造性）
- **API 调用**：将请求发送到 Foundry 本地
- <strong>响应处理</strong>：安全提取 AI 的文本响应
- <strong>错误处理</strong>：捕获异常并给出有用的错误提示

### 4. 项目依赖（pom.xml）

**关键依赖：**

```xml
<!-- Spring Boot - Application framework -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <version>${spring-boot.version}</version>
</dependency>

<!-- OpenAI Java SDK - For AI API calls -->
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>

<!-- Jackson - JSON processing -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.0</version>
</dependency>
```

**功能说明：**
- **spring-boot-starter**：提供核心 Spring Boot 功能
- **openai-java**：官方 OpenAI Java SDK 用于 API 通信
- **jackson-databind**：负责 API 调用的 JSON 序列化/反序列化

## 整体工作流程

运行应用时的完整流程如下：

1. <strong>启动</strong>：Spring Boot 启动并读取 `application.properties`
2. <strong>服务创建</strong>：Spring 创建 `FoundryLocalService` 并注入配置
3. <strong>模型检测</strong>：若未配置模型，服务会查询 Foundry 本地 `/v1/models` 端点并自动使用第一个可用模型
4. <strong>客户端设置</strong>：`@PostConstruct` 初始化 OpenAI 客户端以连接 Foundry 本地
5. <strong>演示执行</strong>：`CommandLineRunner` 在启动后执行
6. **AI 调用**：演示调用 `foundryLocalService.chat()` 发送测试消息
7. **API 请求**：服务构建并发送兼容 OpenAI 的请求给 Foundry 本地
8. <strong>响应处理</strong>：服务提取并返回 AI 响应
9. <strong>显示</strong>：应用打印响应内容并退出

## 设置 Foundry 本地

1. **根据[先决条件](#先决条件)中的说明安装 Foundry 本地**。

2. <strong>启动服务</strong>（如果尚未启动）：
   ```bash
   foundry service start
   ```

3. <strong>检查服务状态</strong>，确认运行并记录端口：
   ```bash
   foundry service status
   ```

4. <strong>下载并运行模型</strong>（首次运行时下载，后续直接缓存）：
   ```bash
   foundry model run phi-4-mini
   ```
   这将打开一个交互式聊天会话，可通过 `Ctrl+C` 退出。模型会保持加载在服务中。

   > **提示：** 运行 `foundry model list` 查看所有可用模型。用任何目录中的别名替换 `phi-4-mini`（例如，`qwen2.5-0.5b` 代表更小、更快的模型）。

5. **验证模型已加载：**
   ```bash
   foundry service ps
   ```

6. **如有需要，更新 `application.properties`：**
   - 默认的 `base-url` (`http://localhost:5273/v1`) 与 CLI 默认端口匹配。仅当 `foundry service status` 显示不同端口时进行更新。
   - 模型在启动时自动检测，无需手动配置。

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## 运行应用程序

### 步骤 1：确保 Foundry 本地已加载模型
```bash
foundry service ps
```
若无模型列表，加载一个：
```bash
foundry model run phi-4-mini
```

### 步骤 2：构建并运行应用
在另一个终端中：
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

或构建并以 JAR 方式运行：
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## 预期输出

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI developed by Microsoft. I can assist with a wide variety of 
tasks including answering questions, helping with analysis, creative writing, coding, 
and general conversation. How can I help you today?
=========================
```

## 下一步

更多示例，请参见[第 04 章节：实用示例](../README.md)

## 故障排除

### 常见问题

**“连接被拒绝”或“服务不可用”**
- 检查服务状态：`foundry service status`
- 如有必要，重启服务：`foundry service restart`
- 确认 `application.properties` 中的端口与 `foundry service status` 输出匹配
- 确认 URL 以 `/v1` 结尾，如：`http://localhost:5273/v1`

**启动时“未找到模型”**
- 应用自动检测模型，确保至少加载一个模型：`foundry service ps`
- 若无模型加载，运行：`foundry model run phi-4-mini`
- 如果你在 `application.properties` 中覆盖了模型名称，请确认它与 `foundry model list` 中匹配

**“400 错误（错误请求）”**
- 确认 base URL 包含 `/v1`，例如 `http://localhost:5273/v1`
- 确保代码中使用的是 `maxCompletionTokens()`，而非已弃用的 `maxTokens()`

**Maven 编译错误**
- 确保 Java 版本 21 或以上：`java -version`
- 清理并重新构建：`mvn clean compile`
- 检查网络连接以下载依赖

<strong>服务连接问题</strong>
- 遇到“请求本地服务失败”，运行：`foundry service restart`
- 查看已加载模型：`foundry service ps`
- 查看服务日志：`foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**免责声明**：
本文档使用 AI 翻译服务 [Co-op Translator](https://github.com/Azure/co-op-translator) 进行翻译。虽然我们力求准确，但请注意，自动翻译可能包含错误或不准确之处。原始文档的原始语言版本应被视为权威来源。对于关键信息，建议使用专业人工翻译。我们不对因使用本翻译而产生的任何误解或误释承担责任。
<!-- CO-OP TRANSLATOR DISCLAIMER END -->