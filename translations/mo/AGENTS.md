<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "afc90918d008cf77fd1982691f681306",
  "translation_date": "2025-10-03T08:28:53+00:00",
  "source_file": "AGENTS.md",
  "language_code": "mo"
}
-->
# AGENTS.md

## 專案概述

這是一個用於學習使用 Java 開發生成式 AI 的教育性資源庫。它提供了一個全面的實作課程，涵蓋大型語言模型 (LLMs)、提示工程、嵌入技術、RAG（檢索增強生成）以及模型上下文協議 (MCP)。

**主要技術：**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models、Azure OpenAI 和 OpenAI SDKs

**架構：**
- 多個獨立的 Spring Boot 應用程式，按章節組織
- 示範不同 AI 模式的範例專案
- 支援 GitHub Codespaces，並預先配置開發容器

## 設置指令

### 先決條件
- Java 21 或更高版本
- Maven 3.x
- GitHub 個人訪問令牌（用於 GitHub Models）
- 選擇性：Azure OpenAI 憑證

### 環境設置

**選項 1：GitHub Codespaces（推薦）**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**選項 2：本地開發容器**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**選項 3：本地設置**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```


### 配置

**GitHub Token 設置：**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Azure OpenAI 設置（選擇性）：**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```


## 開發工作流程

### 專案結構
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


### 運行應用程式

**運行 Spring Boot 應用程式：**
```bash
cd [project-directory]
mvn spring-boot:run
```

**建置專案：**
```bash
cd [project-directory]
mvn clean install
```

**啟動 MCP 計算器伺服器：**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**運行客戶端範例：**
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


### 熱重載
Spring Boot DevTools 已包含在支持熱重載的專案中：
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```


## 測試指導

### 運行測試

**運行專案中的所有測試：**
```bash
cd [project-directory]
mvn test
```

**以詳細輸出運行測試：**
```bash
mvn test -X
```

**運行特定測試類：**
```bash
mvn test -Dtest=CalculatorServiceTest
```


### 測試結構
- 測試文件使用 JUnit 5 (Jupiter)
- 測試類位於 `src/test/java/`
- 計算器專案中的客戶端範例位於 `src/test/java/com/microsoft/mcp/sample/client/`

### 手動測試
許多範例是需要手動測試的互動式應用程式：

1. 使用 `mvn spring-boot:run` 啟動應用程式
2. 測試端點或與 CLI 互動
3. 驗證預期行為是否符合每個專案的 README.md 文件

### 使用 GitHub Models 進行測試
- 免費層限制：15 次請求/分鐘，150 次/天
- 最多 5 個並發請求
- 使用負責任的 AI 範例測試內容過濾

## 代碼風格指南

### Java 慣例
- **Java 版本：** 使用 Java 21 的現代功能
- **風格：** 遵循標準 Java 慣例
- **命名：** 
  - 類：PascalCase
  - 方法/變數：camelCase
  - 常量：UPPER_SNAKE_CASE
  - 套件名稱：小寫

### Spring Boot 模式
- 使用 `@Service` 處理業務邏輯
- 使用 `@RestController` 處理 REST 端點
- 通過 `application.yml` 或 `application.properties` 進行配置
- 優先使用環境變數而非硬編碼值
- 使用 `@Tool` 註解標記 MCP 暴露的方法

### 文件組織
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


### 依賴項
- 通過 Maven `pom.xml` 管理
- 使用 Spring AI BOM 管理版本
- 使用 LangChain4j 進行 AI 集成
- Spring Boot starter parent 用於 Spring 依賴項

### 代碼註解
- 為公共 API 添加 JavaDoc
- 為複雜的 AI 交互添加解釋性註解
- 清晰記錄 MCP 工具描述

## 建置與部署

### 建置專案

**跳過測試建置：**
```bash
mvn clean install -DskipTests
```

**包含所有檢查的建置：**
```bash
mvn clean install
```

**打包應用程式：**
```bash
mvn package
# Creates JAR in target/ directory
```


### 輸出目錄
- 編譯類：`target/classes/`
- 測試類：`target/test-classes/`
- JAR 文件：`target/*.jar`
- Maven 工件：`target/`

### 特定環境配置

**開發環境：**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**生產環境：**
- 使用 Azure AI Foundry Models 替代 GitHub Models
- 將 base-url 更新為 Azure OpenAI 端點
- 通過 Azure Key Vault 或環境變數管理密鑰

### 部署注意事項
- 這是一個教育性資源庫，包含範例應用程式
- 不適合直接用於生產部署
- 範例展示了可適應生產使用的模式
- 具體部署注意事項請參閱各專案的 README 文件

## 附加說明

### GitHub Models 與 Azure OpenAI
- **GitHub Models：** 免費層供學習使用，無需信用卡
- **Azure OpenAI：** 適合生產環境，需要 Azure 訂閱
- 代碼在兩者之間兼容，只需更改端點和 API 密鑰

### 處理多個專案
每個範例專案都是獨立的：
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```


### 常見問題

**Java 版本不匹配：**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**依賴項下載問題：**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub Token 未找到：**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**端口已被佔用：**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```


### 多語言支持
- 文檔可通過自動翻譯提供 45+ 種語言版本
- 翻譯文件位於 `translations/` 目錄
- 翻譯由 GitHub Actions 工作流程管理

### 學習路徑
1. 從 [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md) 開始
2. 按順序學習章節（01 → 05）
3. 完成每章中的實作範例
4. 探索第 4 章中的範例專案
5. 在第 5 章學習負責任的 AI 實踐

### 開發容器
`.devcontainer/devcontainer.json` 配置包括：
- Java 21 開發環境
- 預裝 Maven
- VS Code Java 擴展
- Spring Boot 工具
- GitHub Copilot 集成
- Docker-in-Docker 支持
- Azure CLI

### 性能考量
- GitHub Models 免費層有速率限制
- 為嵌入技術使用適當的批量大小
- 考慮對重複的 API 調用進行緩存
- 監控令牌使用以優化成本

### 安全注意事項
- 切勿提交 `.env` 文件（已在 `.gitignore` 中）
- 使用環境變數存儲 API 密鑰
- GitHub Token 應具有最低必要的範圍
- 遵循第 5 章中的負責任 AI 指南

---

**免責聲明**：  
本文件已使用 AI 翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 進行翻譯。雖然我們致力於提供準確的翻譯，但請注意，自動翻譯可能包含錯誤或不準確之處。原始文件的母語版本應被視為權威來源。對於關鍵資訊，建議使用專業人工翻譯。我們對因使用此翻譯而產生的任何誤解或錯誤解釋不承擔責任。