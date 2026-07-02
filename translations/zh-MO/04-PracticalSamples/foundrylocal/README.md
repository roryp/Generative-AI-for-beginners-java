# Foundry Local Spring Boot 教學

## 目錄

- [先決條件](#先決條件)
- [專案概覽](#專案概覽)
- [理解程式碼](#理解程式碼)
  - [1. 應用程式設定 (application.properties)](#1-應用程式設定-applicationproperties)
  - [2. 主要應用程式類 (Application.java)](#2-主要應用程式類-applicationjava)
  - [3. AI 服務層 (FoundryLocalService.java)](#3-ai-服務層-foundrylocalservicejava)
  - [4. 專案相依性 (pom.xml)](#4-專案相依性-pomxml)
- [整體運作流程](#整體運作流程)
- [設定 Foundry Local](#設定-foundry-local)
- [執行應用程式](#執行應用程式)
- [預期輸出](#預期輸出)
- [下一步](#下一步)
- [故障排除](#故障排除)


## 先決條件

開始本教學前，請確保您已安裝：

- **Java 21 或更高版本**
- **Maven 3.6 以上** 用於專案建置
- **Foundry Local** 已安裝並啟動

### **安裝 Foundry Local：**

> **注意：** Foundry Local CLI 僅支援 **Windows** 與 **macOS**。Linux 可透過 [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local)（Python、JavaScript、C#、Rust）支援。

```bash
# Windows 作業系統
winget install Microsoft.FoundryLocal

# macOS 作業系統
brew tap microsoft/foundrylocal
brew install foundrylocal
```

驗證安裝：
```bash
foundry --version
```

## 專案概覽

此專案包含四個主要元件：

1. **Application.java** - 主要的 Spring Boot 應用程式進入點
2. **FoundryLocalService.java** - 處理 AI 通訊的服務層
3. **application.properties** - Foundry Local 連線設定
4. **pom.xml** - Maven 相依性與專案設定

## 理解程式碼

### 1. 應用程式設定 (application.properties)

**檔案：** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**功能說明：**
- **base-url**：指定 Foundry Local 運行位置，包含 `/v1` 路徑以相容 OpenAI API。預設埠號為 `5273`。若不同，請使用 `foundry service status` 查詢。
- **model** （可選）：指定用於文字生成的 AI 模型名稱。**預設情況下，應用程式會在啟動時透過查詢 Foundry Local 的 `/v1/models` 自動偵測模型，因此不必設定。若需要，可手動指定以覆蓋自動偵測。**

**關鍵概念：** Spring Boot 會自動載入這些屬性，並可利用 `@Value` 標註注入至您的應用程式。

### 2. 主要應用程式類 (Application.java)

**檔案：** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // 無需網絡伺服器
        app.run(args);
    }
```

**功能說明：**
- `@SpringBootApplication` 啟用 Spring Boot 自動配置
- `WebApplicationType.NONE` 表示此應用為命令行程式，而非網頁伺服器
- main 方法啟動 Spring 應用程式

**示範執行器：**
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

**功能說明：**
- `@Bean` 建立一個由 Spring 管理的元件
- `CommandLineRunner` 在 Spring Boot 啟動後執行程式碼
- `foundryLocalService` 由 Spring 自動注入（依賴注入）
- 傳送測試訊息到 AI，顯示回應結果

### 3. AI 服務層 (FoundryLocalService.java)

**檔案：** `src/main/java/com/example/FoundryLocalService.java`

#### 設定注入：
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // 若為空則自動檢測
```

**功能說明：**
- `@Service` 告訴 Spring 此類別提供業務邏輯
- `@Value` 從 application.properties 注入設定值
- 模型預設為空字串，觸發啟動時從 Foundry Local 自動偵測模型。這表示搭配任何已載入的模型時，均無需手動設定。

#### 客戶端初始化：
```java
@PostConstruct
public void init() {
    // 如果未明確配置，則自動從Foundry Local檢測模型
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // 基本URL已包含配置中的/v1
            .apiKey("not-needed")            // 本地服務器不需要真實的API密鑰
            .build();
}
```

**功能說明：**
- `@PostConstruct` 於 Spring 建立服務後執行此方法
- 若未設定模型，則查詢 Foundry Local 的 `/v1/models`，並選取第一個已載入模型
- 建立指向本地 Foundry Local 實例的 OpenAI 客戶端
- `application.properties` 所指定的 base URL 已包含 `/v1`，相容 OpenAI API
- API 密鑰設定為 "not-needed"，本地開發不需認證

#### 聊天方法：
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // 使用哪個人工智能模型
                .addUserMessage(message)         // 你的問題／提示
                .maxCompletionTokens(150)        // 限制回應長度
                .temperature(0.7)                // 控制創意程度（0.0-1.0）
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // 從API結果中提取人工智能回應
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**功能說明：**
- **ChatCompletionCreateParams**：配置 AI 請求
  - `model`：指定使用的 AI 模型（必須精確匹配 `foundry model list` 中的 ID）
  - `addUserMessage`：加入您的訊息至對話
  - `maxCompletionTokens`：限制回應字元長度（節省資源）
  - `temperature`：調節隨機性（0.0 = 決定性，1.0 = 創意）
- **API 呼叫**：發送請求至 Foundry Local
- <strong>回應處理</strong>：安全地擷取 AI 回覆文字
- <strong>錯誤處理</strong>：包裝例外並提供有用錯誤訊息

### 4. 專案相依性 (pom.xml)

**主要相依性：**

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

**功能說明：**
- **spring-boot-starter**：提供 Spring Boot 核心功能
- **openai-java**：官方 OpenAI Java SDK 供 API 通訊使用
- **jackson-databind**：用於 API JSON 序列化及反序列化

## 整體運作流程

以下為執行應用程式時的完整流程：

1. <strong>啟動</strong>：Spring Boot 啟動並讀取 `application.properties`
2. <strong>服務建立</strong>：Spring 建立 `FoundryLocalService`，注入設定值
3. <strong>模型偵測</strong>：若未設定模型，服務查詢 Foundry Local `/v1/models`，自動使用第一個可用模型
4. <strong>客戶端設定</strong>：`@PostConstruct` 初始化連接 Foundry Local 的 OpenAI 客戶端
5. <strong>示範執行</strong>：Spring 啟動後，`CommandLineRunner` 執行
6. **AI 呼叫**：示範呼叫 `foundryLocalService.chat()` 傳送測試訊息
7. **API 請求**：服務建立並發送符合 OpenAI API 的請求至 Foundry Local
8. <strong>回應處理</strong>：服務擷取並回傳 AI 回覆
9. <strong>顯示</strong>：應用程式列印回覆後結束

## 設定 Foundry Local

1. 依照 [先決條件](#先決條件) 節安裝 Foundry Local。

2. 啟動服務（若未執行）：
   ```bash
   foundry service start
   ```

3. 確認服務狀態與埠號：
   ```bash
   foundry service status
   ```

4. 下載並執行模型（首次執行時會下載，後續執行會快取）：
   ```bash
   foundry model run phi-4-mini
   ```
   此指令開啟互動聊天會話，使用 `Ctrl+C` 離開，模型將持續載入於服務中。

   > **提示：** 執行 `foundry model list` 查看所有可用模型。可依目錄替換 `phi-4-mini`，例如更小更快的 `qwen2.5-0.5b`。

5. 確認模型已載入：
   ```bash
   foundry service ps
   ```

6. 如有需要，更新 `application.properties`：
   - 預設 `base-url` (`http://localhost:5273/v1`) 與 CLI 預設埠號一致。只在 `foundry service status` 顯示不同埠號時修改。
   - 模型於啟動時 <strong>自動偵測</strong>，無須設定。

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## 執行應用程式

### 第一步：確認 Foundry Local 已載入模型
```bash
foundry service ps
```
若無列出模型，請載入一個：
```bash
foundry model run phi-4-mini
```

### 第二步：建置並執行應用程式
在另一個終端機視窗：
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

或以 JAR 方式建置與執行：
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## 預期輸出

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

更多範例請參考 [第04章：實用範例](../README.md)

## 故障排除

### 常見問題

**「連線被拒絕」或「服務無法使用」**
- 檢查服務狀態：`foundry service status`
- 需要時重新啟動：`foundry service restart`
- 確認 `application.properties` 中的埠號與 `foundry service status` 相符
- 確認 URL 以 `/v1` 結尾： `http://localhost:5273/v1`

**啟動時顯示「找不到模型」**
- 應用自動偵測模型。請確定至少載入一個模型：`foundry service ps`
- 若無模型載入：`foundry model run phi-4-mini`
- 若在 `application.properties` 指定模型名稱，請與 `foundry model list` 相符

**「400 Bad Request」錯誤**
- 確認 base URL 包含 `/v1`：`http://localhost:5273/v1`
- 確保代碼中使用 `maxCompletionTokens()`，而非舊版已棄用的 `maxTokens()`

**Maven 編譯錯誤**
- 確認 Java 版本 21 或更高：`java -version`
- 清理並重建專案：`mvn clean compile`
- 確認有網路連線下載相依性

<strong>服務連線問題</strong>
- 若看到 `Request to local service failed`，請執行：`foundry service restart`
- 檢查已載入模型：`foundry service ps`
- 查看服務日誌：`foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**免責聲明**：  
本文件已使用 AI 翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 進行翻譯。雖然我們致力於確保準確性，但請注意，自動翻譯可能包含錯誤或不準確之處。文件的原文版本應被視為權威來源。對於重要資訊，建議採用專業人工翻譯。如因使用本翻譯而導致任何誤解或誤譯，我們概不負責。
<!-- CO-OP TRANSLATOR DISCLAIMER END -->