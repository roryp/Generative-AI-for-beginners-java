# 使用 Azure OpenAI 的基礎聊天範例 - 端到端示例

此範例展示如何建立一個簡單的 Spring Boot 應用程式，連接到 Azure OpenAI 並測試您的設定。

## 目錄

- [先決條件](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [快速開始](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [配置選項](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [選項 1：環境變數 (.env 檔案) - 推薦](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [選項 2：GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [執行應用程式](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [使用 Maven](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [使用 VS Code](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [預期輸出](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [配置參考](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [環境變數](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Spring 配置](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [疑難排解](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [常見問題](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [除錯模式](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [後續步驟](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [資源](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## 先決條件

在執行此範例之前，請確保您已完成以下事項：

- 完成 [Azure OpenAI 設定指南](../../getting-started-azure-openai.md)  
- 部署 Azure OpenAI 資源（透過 Azure AI Foundry 入口網站）  
- 部署 gpt-4o-mini 模型（或其他替代模型）  
- 從 Azure 獲取 API 金鑰和端點 URL  

## 快速開始

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## 配置選項

### 選項 1：環境變數 (.env 檔案) - 推薦

**步驟 1：建立您的配置檔案**  
```bash
cp .env.example .env
```

**步驟 2：新增您的 Azure OpenAI 憑證**  
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **安全提示**：  
> - 切勿將 `.env` 檔案提交到版本控制系統  
> - `.env` 檔案已包含在 `.gitignore` 中  
> - 確保您的 API 金鑰安全，並定期更換  

### 選項 2：GitHub Codespace Secrets

對於 GitHub Codespaces，請在您的儲存庫中設定以下 Secrets：
- `AZURE_AI_KEY` - 您的 Azure OpenAI API 金鑰
- `AZURE_AI_ENDPOINT` - 您的 Azure OpenAI 端點 URL

應用程式會自動檢測並使用這些 Secrets。

### 替代方案：直接使用環境變數

<details>
<summary>點擊查看特定平台的指令</summary>

**Linux/macOS (bash/zsh)：**  
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (命令提示字元)：**  
```cmd
set AZURE_AI_KEY=your-actual-api-key-here
set AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (PowerShell)：**  
```powershell
$env:AZURE_AI_KEY="your-actual-api-key-here"
$env:AZURE_AI_ENDPOINT="https://your-hub-name.openai.azure.com/"
```
</details>

## 執行應用程式

### 使用 Maven

```bash
mvn spring-boot:run
```

### 使用 VS Code

1. 在 VS Code 中打開專案  
2. 按下 `F5` 或使用「執行與除錯」面板  
3. 選擇「Spring Boot-BasicChatApplication」配置  

> **注意**：VS Code 配置會自動載入您的 .env 檔案

### 預期輸出

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

## 配置參考

### 環境變數

| 變數名稱 | 描述 | 是否必需 | 範例 |
|----------|-------------|----------|---------|
| `AZURE_AI_KEY` | Azure OpenAI API 金鑰 | 是 | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI 端點 URL | 是 | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | 模型部署名稱 | 否 | `gpt-4o-mini`（預設） |

### Spring 配置

`application.yml` 檔案配置內容包括：
- **API 金鑰**：`${AZURE_AI_KEY}` - 來自環境變數  
- **端點**：`${AZURE_AI_ENDPOINT}` - 來自環境變數  
- **模型**：`${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - 來自環境變數，並有預設值  
- **溫度**：`0.7` - 控制創意程度（0.0 = 確定性，1.0 = 創意性）  
- **最大 Tokens**：`500` - 最大回應長度  

## 疑難排解

### 常見問題

<details>
<summary><strong>錯誤：「API 金鑰無效」</strong></summary>

- 檢查您的 `.env` 檔案中是否正確設定了 `AZURE_AI_KEY`  
- 確保 API 金鑰與 Azure AI Foundry 入口網站中的完全一致  
- 確保金鑰周圍沒有多餘的空格或引號  
</details>

<details>
<summary><strong>錯誤：「端點無效」</strong></summary>

- 確保您的 `AZURE_AI_ENDPOINT` 包含完整的 URL（例如：`https://your-hub-name.openai.azure.com/`）  
- 檢查是否有多餘的斜線  
- 確保端點與您的 Azure 部署區域一致  
</details>

<details>
<summary><strong>錯誤：「找不到部署」</strong></summary>

- 確保您的模型部署名稱與 Azure 中的名稱完全一致  
- 檢查模型是否已成功部署並處於啟用狀態  
- 嘗試使用預設部署名稱：`gpt-4o-mini`  
</details>

<details>
<summary><strong>VS Code：環境變數未載入</strong></summary>

- 確保您的 `.env` 檔案位於專案根目錄（與 `pom.xml` 同層級）  
- 嘗試在 VS Code 的整合終端中執行 `mvn spring-boot:run`  
- 檢查是否正確安裝了 VS Code 的 Java 擴展  
- 確認啟動配置中包含 `"envFile": "${workspaceFolder}/.env"`  
</details>

### 除錯模式

若要啟用詳細日誌記錄，請取消註解 `application.yml` 中的以下行：

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## 後續步驟

**設定完成！** 繼續您的學習旅程：

[第 3 章：核心生成式 AI 技術](../../../03-CoreGenerativeAITechniques/README.md)

## 資源

- [Spring AI Azure OpenAI 文件](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)  
- [Azure OpenAI 服務文件](https://learn.microsoft.com/azure/ai-services/openai/)  
- [Azure AI Foundry 入口網站](https://ai.azure.com/)  
- [Azure AI Foundry 文件](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)  

**免責聲明**：  
本文件使用 AI 翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 進行翻譯。我們致力於提供準確的翻譯，但請注意，自動翻譯可能包含錯誤或不準確之處。應以原始語言的文件作為權威來源。對於關鍵資訊，建議尋求專業人工翻譯。我們對因使用此翻譯而引起的任何誤解或誤讀概不負責。