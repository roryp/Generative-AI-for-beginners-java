<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T16:33:23+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "tw"
}
-->
# Foundry Local 命令列應用程式

>**注意**：本章節包含一個[**教學**](./TUTORIAL.md)，指導您如何執行完成的範例。

一個簡單的 Spring Boot 命令列應用程式，展示如何使用 OpenAI Java SDK 連接到 Foundry Local。

## 您將學到什麼

- 如何使用 OpenAI Java SDK 將 Foundry Local 整合到 Spring Boot 應用程式中
- 本地 AI 開發與測試的最佳實踐

## 目錄

- [您將學到什麼](../../../../04-PracticalSamples/foundrylocal)
- [先決條件](../../../../04-PracticalSamples/foundrylocal)
  - [安裝 Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [驗證](../../../../04-PracticalSamples/foundrylocal)
- [配置](../../../../04-PracticalSamples/foundrylocal)
- [快速開始](../../../../04-PracticalSamples/foundrylocal)
- [應用程式的功能](../../../../04-PracticalSamples/foundrylocal)
- [範例輸出](../../../../04-PracticalSamples/foundrylocal)
- [架構](../../../../04-PracticalSamples/foundrylocal)
- [程式碼亮點](../../../../04-PracticalSamples/foundrylocal)
  - [OpenAI Java SDK 整合](../../../../04-PracticalSamples/foundrylocal)
  - [聊天完成 API](../../../../04-PracticalSamples/foundrylocal)
- [疑難排解](../../../../04-PracticalSamples/foundrylocal)

## 先決條件

> **⚠️ 注意**：此應用程式**無法在提供的 devcontainer 中執行**，因為它需要在主機系統上安裝並運行 Foundry Local。

### 安裝 Foundry Local

在執行此應用程式之前，您需要安裝並啟動 Foundry Local。請按照以下步驟操作：

1. **確保您的系統符合要求**：
   - **作業系統**：Windows 10 (x64)、Windows 11 (x64/ARM)、Windows Server 2025 或 macOS
   - **硬體**：
     - 最低要求：8GB RAM，3GB 可用磁碟空間
     - 推薦配置：16GB RAM，15GB 可用磁碟空間
   - **網路**：初次下載模型需要網路連線（離線使用可選）
   - **加速（可選）**：NVIDIA GPU（2000 系列或更新）、AMD GPU（6000 系列或更新）、Qualcomm Snapdragon X Elite（8GB 或更多記憶體）或 Apple Silicon
   - **權限**：安裝軟體需要管理員權限

2. **安裝 Foundry Local**：
   
   **對於 Windows：**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **對於 macOS：**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   或者，您可以從 [Foundry Local GitHub 儲存庫](https://github.com/microsoft/Foundry-Local) 下載安裝程式。

3. **啟動您的第一個模型**：

   ```bash
   foundry model run phi-3.5-mini
   ```

   模型將被下載（根據您的網速可能需要幾分鐘），然後開始運行。Foundry Local 會自動為您的系統選擇最佳的模型版本（NVIDIA GPU 使用 CUDA，否則使用 CPU 版本）。

4. **在同一終端中測試模型**，輸入問題：

   ```bash
   Why is the sky blue?
   ```

   您應該會看到 Phi 模型的回應，解釋為什麼天空看起來是藍色的。

### 驗證

您可以使用以下命令驗證一切是否正常運行：

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

您也可以在瀏覽器中訪問 `http://localhost:5273` 查看 Foundry Local 的網頁介面。

## 配置

此應用程式可以通過 `application.properties` 進行配置：

- `foundry.local.base-url` - Foundry Local 的基礎 URL（預設值：http://localhost:5273）
- `foundry.local.model` - 要使用的 AI 模型（預設值：Phi-3.5-mini-instruct-cuda-gpu）

> **注意**：配置中的模型名稱應與 Foundry Local 為您的系統下載的具體版本相匹配。當您執行 `foundry model run phi-3.5-mini` 時，Foundry Local 會自動選擇並下載最佳版本（NVIDIA GPU 使用 CUDA，否則使用 CPU 版本）。使用 `foundry model list` 查看本地實例中可用的具體模型名稱。

## 快速開始

### 1. 導航到 Foundry Local 應用程式目錄
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. 執行應用程式

```bash
mvn spring-boot:run
```

或者構建並運行 JAR：

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### 依賴項

此應用程式使用 OpenAI Java SDK 與 Foundry Local 通信。主要依賴項為：

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

應用程式已預先配置為連接到運行在預設埠上的 Foundry Local。

## 應用程式的功能

當您運行此應用程式時：

1. **啟動**為命令列應用程式（無網頁伺服器）
2. **自動發送**測試訊息："Hello! Can you tell me what you are and what model you're running?"
3. **在控制台顯示**來自 Foundry Local 的回應
4. **在演示結束後**正常退出

## 範例輸出

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## 架構

- **Application.java** - 主 Spring Boot 應用程式，包含 CommandLineRunner
- **FoundryLocalService.java** - 使用 OpenAI Java SDK 與 Foundry Local 通信的服務
- 使用 **OpenAI Java SDK** 進行類型安全的 API 調用
- SDK 自動處理 JSON 序列化/反序列化
- 使用 Spring 的 `@Value` 和 `@PostConstruct` 註解進行清晰的配置

## 程式碼亮點

### OpenAI Java SDK 整合

應用程式使用 OpenAI Java SDK 創建一個為 Foundry Local 配置的客戶端：

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### 聊天完成 API

進行聊天完成請求既簡單又類型安全：

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## 疑難排解

如果出現連接錯誤：
1. 確認 Foundry Local 正在 `http://localhost:5273` 運行
2. 使用 `foundry model list` 檢查是否有 Phi-3.5-mini 模型版本可用
3. 確保 `application.properties` 中的模型名稱與列表中顯示的具體模型名稱匹配
4. 確保沒有防火牆阻止連接

常見問題：
- **找不到模型**：執行 `foundry model run phi-3.5-mini` 下載並啟動模型
- **服務未運行**：Foundry Local 服務可能已停止；使用模型運行命令重新啟動
- **模型名稱錯誤**：使用 `foundry model list` 查看可用模型並相應更新您的配置

**免責聲明**：  
本文件使用 AI 翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 進行翻譯。儘管我們努力確保翻譯的準確性，但請注意，自動翻譯可能包含錯誤或不準確之處。原始文件的母語版本應被視為權威來源。對於關鍵資訊，建議使用專業人工翻譯。我們對因使用此翻譯而引起的任何誤解或錯誤解釋不承擔責任。