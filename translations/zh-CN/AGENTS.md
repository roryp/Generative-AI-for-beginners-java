# AGENTS.md

## 项目概述

这是一个用于学习使用 Java 开发生成式 AI的教育性代码库。它提供了一个全面的实践课程，涵盖了大型语言模型（LLMs）、提示工程、嵌入技术、RAG（检索增强生成）以及模型上下文协议（MCP）。

**关键技术：**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models、Azure OpenAI 和 OpenAI SDKs

**架构：**
- 按章节组织的多个独立 Spring Boot 应用程序
- 展示不同 AI 模式的示例项目
- 支持 GitHub Codespaces，预配置开发容器

## 设置命令

### 前置条件
- Java 21 或更高版本
- Maven 3.x
- GitHub 个人访问令牌（用于 GitHub Models）
- 可选：Azure OpenAI 凭证

### 环境设置

**选项 1：GitHub Codespaces（推荐）**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**选项 2：本地开发容器**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**选项 3：本地设置**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```


### 配置

**GitHub 令牌设置：**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Azure OpenAI 设置（可选）：**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```


## 开发工作流程

### 项目结构
```
/
├── 01-IntroToGenAI/              # Chapter 1: Introduction
├── 02-SetupDevEnvironment/       # Chapter 2: Environment setup
│   └── examples/                 # Working examples
├── 03-CoreGenerativeAITechniques/ # Chapter 3: Core techniques
├── 04-PracticalSamples/          # Chapter 4: Sample projects
│   ├── calculator/               # MCP service example
│   ├── foundrylocal/            # Local model integration
│   └── petstory/                # Multi-modal app
├── 05-ResponsibleGenAI/         # Chapter 5: Responsible AI
└── translations/                # Multi-language support
```


### 运行应用程序

**运行 Spring Boot 应用程序：**
```bash
cd [project-directory]
mvn spring-boot:run
```

**构建项目：**
```bash
cd [project-directory]
mvn clean install
```

**启动 MCP 计算器服务器：**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**运行客户端示例：**
```bash
# After starting the server in another terminal
cd 04-PracticalSamples/calculator

# Direct MCP client
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient"

# AI-powered client (requires GITHUB_TOKEN)
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient"

# Interactive bot
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.Bot"
```


### 热重载
支持热重载的项目已包含 Spring Boot DevTools：
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```


## 测试说明

### 运行测试

**运行项目中的所有测试：**
```bash
cd [project-directory]
mvn test
```

**运行带详细输出的测试：**
```bash
mvn test -X
```

**运行特定测试类：**
```bash
mvn test -Dtest=CalculatorServiceTest
```


### 测试结构
- 测试文件使用 JUnit 5（Jupiter）
- 测试类位于 `src/test/java/`
- 计算器项目中的客户端示例位于 `src/test/java/com/microsoft/mcp/sample/client/`

### 手动测试
许多示例是交互式应用程序，需要手动测试：

1. 使用 `mvn spring-boot:run` 启动应用程序
2. 测试端点或与 CLI 交互
3. 验证预期行为是否与每个项目的 README.md 中的文档一致

### 使用 GitHub Models 进行测试
- 免费层限制：15 次请求/分钟，150 次/天
- 最大并发请求数：5
- 使用负责任的 AI 示例测试内容过滤

## 代码风格指南

### Java 约定
- **Java 版本：** 使用 Java 21 的现代特性
- **风格：** 遵循标准 Java 约定
- **命名：** 
  - 类名：PascalCase
  - 方法/变量名：camelCase
  - 常量名：UPPER_SNAKE_CASE
  - 包名：小写

### Spring Boot 模式
- 使用 `@Service` 处理业务逻辑
- 使用 `@RestController` 处理 REST 端点
- 配置通过 `application.yml` 或 `application.properties`
- 优先使用环境变量而非硬编码值
- 使用 `@Tool` 注解标记 MCP 暴露的方法

### 文件组织
```
src/
├── main/
│   ├── java/
│   │   └── com/microsoft/[component]/
│   │       ├── [Component]Application.java
│   │       ├── config/
│   │       ├── controller/
│   │       ├── service/
│   │       └── exception/
│   └── resources/
│       ├── application.yml
│       └── static/
└── test/
    └── java/
        └── com/microsoft/[component]/
```


### 依赖
- 通过 Maven `pom.xml` 管理
- 使用 Spring AI BOM 管理版本
- 使用 LangChain4j 进行 AI 集成
- Spring Boot starter parent 管理 Spring 依赖

### 代码注释
- 为公共 API 添加 JavaDoc
- 为复杂的 AI 交互添加解释性注释
- 清晰记录 MCP 工具描述

## 构建与部署

### 构建项目

**跳过测试构建：**
```bash
mvn clean install -DskipTests
```

**完整检查构建：**
```bash
mvn clean install
```

**打包应用程序：**
```bash
mvn package
# Creates JAR in target/ directory
```


### 输出目录
- 编译类文件：`target/classes/`
- 测试类文件：`target/test-classes/`
- JAR 文件：`target/*.jar`
- Maven 工件：`target/`

### 环境特定配置

**开发环境：**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**生产环境：**
- 使用 Azure AI Foundry Models 替代 GitHub Models
- 更新 base-url 为 Azure OpenAI 端点
- 通过 Azure Key Vault 或环境变量管理密钥

### 部署注意事项
- 这是一个教育性代码库，包含示例应用程序
- 不适合直接用于生产部署
- 示例展示了可用于生产的模式
- 具体部署说明请参阅各项目的 README 文件

## 附加说明

### GitHub Models 与 Azure OpenAI
- **GitHub Models：** 免费层用于学习，无需信用卡
- **Azure OpenAI：** 适用于生产环境，需要 Azure 订阅
- 代码兼容两者，只需更改端点和 API 密钥

### 使用多个项目
每个示例项目都是独立的：
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```


### 常见问题

**Java 版本不匹配：**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**依赖下载问题：**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**未找到 GitHub 令牌：**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**端口已被占用：**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```


### 多语言支持
- 文档通过自动翻译支持 45+ 种语言
- 翻译文件位于 `translations/` 目录
- 翻译由 GitHub Actions 工作流管理

### 学习路径
1. 从 [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md) 开始
2. 按顺序学习章节（01 → 05）
3. 完成每章中的实践示例
4. 探索第 4 章中的示例项目
5. 在第 5 章学习负责任的 AI 实践

### 开发容器
`.devcontainer/devcontainer.json` 配置了：
- Java 21 开发环境
- 预安装 Maven
- VS Code Java 扩展
- Spring Boot 工具
- GitHub Copilot 集成
- Docker-in-Docker 支持
- Azure CLI

### 性能注意事项
- GitHub Models 免费层有速率限制
- 为嵌入选择合适的批量大小
- 对重复的 API 调用考虑使用缓存
- 监控令牌使用以优化成本

### 安全注意事项
- 不要提交 `.env` 文件（已在 `.gitignore` 中）
- 使用环境变量存储 API 密钥
- GitHub 令牌应具有最低必要权限
- 在第 5 章遵循负责任的 AI 指南

---

**免责声明**：  
本文档使用AI翻译服务 [Co-op Translator](https://github.com/Azure/co-op-translator) 进行翻译。尽管我们努力确保翻译的准确性，但请注意，自动翻译可能包含错误或不准确之处。原始语言的文档应被视为权威来源。对于关键信息，建议使用专业人工翻译。我们对因使用此翻译而产生的任何误解或误读不承担责任。