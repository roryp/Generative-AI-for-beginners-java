# Foundry Local Spring Boot 教學

## 目錄

- [先決條件](#先決條件)
- [專案概覽](#專案概覽)
- [程式碼解析](#程式碼解析)
  - [1. 應用程式設定 (application.properties)](#1-應用程式設定-applicationproperties)
  - [2. 主應用程式類別 (Application.java)](#2-主應用程式類別-applicationjava)
  - [3. AI 服務層 (FoundryLocalService.java)](#3-ai-服務層-foundrylocalservicejava)
  - [4. 專案相依性 (pom.xml)](#4-專案相依性-pomxml)
- [整體運作流程](#整體運作流程)
- [設定 Foundry Local](#設定-foundry-local)
- [執行應用程式](#執行應用程式)
- [預期輸出](#預期輸出)
- [接下來步驟](#接下來步驟)
- [故障排除](#故障排除)


## 先決條件

開始本教學之前，請確定您已經：

- 在系統安裝了 **Java 21 或更高版本**
- 具備 **Maven 3.6+** 用於建置專案
- 已安裝並運行 **Foundry Local**

### **安裝 Foundry Local:**

> **注意：** Foundry Local CLI 僅於 **Windows** 和 **macOS** 平台提供。Linux 支援可透過 [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust) 使用。

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

本專案包含四個主要組件：

1. **Application.java** - 主 Spring Boot 應用程式入口
2. **FoundryLocalService.java** - 負責 AI 通訊的服務層
3. **application.properties** - Foundry Local 連線設定檔
4. **pom.xml** - Maven 相依性和專案設定

## 程式碼解析

### 1. 應用程式設定 (application.properties)

**檔案:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**作用說明：**
- **base-url**：指定 Foundry Local 運作位置，包括 OpenAI API 相容的 `/v1` 路徑。預設連接埠是 `5273`。若連接埠不同，可使用 `foundry service status` 查詢。
- **model**（可選）：指定用於文本生成的 AI 模型。**預設情況下，應用程式會在啟動時自動從 Foundry Local 的 `/v1/models` 端點檢索模型，因此通常不需設定此項。必要時可手動設定以覆蓋自動偵測。**

**重要觀念：** Spring Boot 會自動載入這些設定並使用 `@Value` 註解將其提供給應用程式。

### 2. 主應用程式類別 (Application.java)

**檔案:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // 無需網絡伺服器
        app.run(args);
    }
```

**作用說明：**
- `@SpringBootApplication` 啟用 Spring Boot 自動設定功能
- `WebApplicationType.NONE` 表示這是命令列應用程式，不是網頁伺服器
- main 方法啟動 Spring 應用程式

**示範執行器（Demo Runner）：**
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

**作用說明：**
- `@Bean` 建立由 Spring 管理的組件
- `CommandLineRunner` 會在 Spring Boot 啟動後執行程式碼
- `foundryLocalService` 由 Spring 自動注入（依賴注入）
- 發送一則測試訊息予 AI，並顯示回應結果

### 3. AI 服務層 (FoundryLocalService.java)

**檔案:** `src/main/java/com/example/FoundryLocalService.java`

#### 設定注入：
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // 自動檢測是否為空
```

**作用說明：**
- `@Service` 告訴 Spring 這個類別提供商業邏輯
- `@Value` 將 application.properties 的設定值注入變數
- 預設 model 為空字串，在啟動時觸發從 Foundry Local 自動偵測。這表示應用程式可直接使用 Foundry Local 中的任意模型，無須額外設定。

#### 用戶端初始化：
```java
@PostConstruct
public void init() {
    // 如果未明確配置，則自動從 Foundry Local 檢測模型
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // 基本 URL 已包含配置中的 /v1
            .apiKey("not-needed")            // 本地服務器不需要真實的 API 密鑰
            .build();
}
```

**作用說明：**
- `@PostConstruct` 在 Spring 建立此服務後執行該方法
- 若未配置模型名稱，會呼叫 Foundry Local `/v1/models` 端點，自動選擇第一個已載入模型
- 建立一個指向本地 Foundry Local 實例的 OpenAI 用戶端
- application.properties 中的 base URL 已包含 `/v1`，確保 OpenAI API 相容性
- API key 設為 "not-needed" 因為本地開發不需驗證

#### 聊天方法：
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // 選擇使用哪個 AI 模型
                .addUserMessage(message)         // 你的問題/提示
                .maxCompletionTokens(150)        // 限制回應長度
                .temperature(0.7)                // 控制創意程度 (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // 從 API 結果中提取 AI 的回應
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**作用說明：**
- **ChatCompletionCreateParams**：配置 AI 請求
  - `model`：指定使用哪個 AI 模型（必須精確符合 `foundry model list` 中的 ID）
  - `addUserMessage`：將用戶訊息加入對話
  - `maxCompletionTokens`：限制回應長度（節省資源）
  - `temperature`：控制隨機程度（0.0 = 確定性，1.0 = 創意）
- **API 呼叫**：送出符合 OpenAI 格式的請求給 Foundry Local
- <strong>回應處理</strong>：安全擷取 AI 回應文字
- <strong>錯誤處理</strong>：捕捉例外並包裝詳細錯誤訊息

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
- **openai-java**：OpenAI 官方 Java SDK 用於 API 通訊
- **jackson-databind**：負責 JSON 序列化／反序列化以便 API 呼叫

## 整體運作流程

執行應用程式時，完整流程如下：

1. <strong>啟動</strong>：Spring Boot 啟動並讀取 `application.properties`
2. <strong>服務建立</strong>：Spring 建立 `FoundryLocalService` 並注入設定值
3. <strong>模型偵測</strong>：若未指定模型，服務自動呼叫 Foundry Local 的 `/v1/models` 並選擇第一個可用模型
4. <strong>用戶端設定</strong>：`@PostConstruct` 初始化 OpenAI 用戶端連線至 Foundry Local
5. <strong>示範執行</strong>：`CommandLineRunner` 在啟動後執行
6. **AI 呼叫**：示範呼叫 `foundryLocalService.chat()` 發送測試訊息
7. **API 請求**：服務組合並發送符合 OpenAI 規範的請求給 Foundry Local
8. <strong>回應處理</strong>：擷取並回傳 AI 回應
9. <strong>輸出</strong>：應用程式列印結果並結束

## 設定 Foundry Local

1. 依據 [先決條件](#先決條件) 中的說明安裝 Foundry Local。

2. <strong>啟動服務</strong>（如果尚未運行）：
   ```bash
   foundry service start
   ```

3. <strong>檢查服務狀態</strong>，確認運行中並記下連接埠：
   ```bash
   foundry service status
   ```

4. <strong>下載並執行模型</strong>（首次執行時會下載，之後會快取）：
   ```bash
   foundry model run phi-4-mini
   ```
   這會打開互動式聊天介面，使用 Ctrl+C 可離開。模型會持續載入於服務中。

   > **提示：** 執行 `foundry model list` 查看所有可用模型。將 `phi-4-mini` 替換為目錄中的任意別名（例如：較小且更快的模型 `qwen2.5-0.5b`）。

5. **確認模型已載入：**
   ```bash
   foundry service ps
   ```

6. **如有需要，更新 `application.properties`：**
   - 預設的 `base-url` (`http://localhost:5273/v1`) 是 CLI 預設連接埠。只有在 `foundry service status` 顯示不同連接埠時才更改。
   - 模型會在啟動時 <strong>自動偵測</strong>，通常無須設定。

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## 執行應用程式

### 步驟 1：確保 Foundry Local 中已有模型載入
```bash
foundry service ps
```
若未列出模型，請執行載入：
```bash
foundry model run phi-4-mini
```

### 步驟 2：建置並執行應用程式
請在另一個終端機視窗執行：
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

或以 JAR 檔方式建置並執行：
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

## 接下來步驟

更多範例，請參考 [第 04 章：實用範例](../README.md)

## 故障排除

### 常見問題

**「連線被拒絕」或「服務不可用」**
- 檢查服務狀態：`foundry service status`
- 必要時重啟服務：`foundry service restart`
- 確認 `application.properties` 中的連接埠與 `foundry service status` 輸出相符
- URL 必須以 `/v1` 結尾，例如：`http://localhost:5273/v1`

**啟動時顯示「找不到模型」**
- 應用程式會自動偵測模型。請確保至少有一個模型已載入：`foundry service ps`
- 若無模型載入，執行：`foundry model run phi-4-mini`
- 若在 `application.properties` 覆寫了模型名稱，請確認與 `foundry model list` 相符

**400 Bad Request 錯誤**
- 確保 base URL 包含 `/v1`：`http://localhost:5273/v1`
- 確保程式碼中使用 `maxCompletionTokens()` 而非已棄用的 `maxTokens()`

**Maven 編譯錯誤**
- 確認 Java 版本為 21 或更高：`java -version`
- 清理並重新建置專案：`mvn clean compile`
- 確保網路可下載相依性

<strong>無法連接服務</strong>
- 若出現 `Request to local service failed`，請執行：`foundry service restart`
- 檢查已載入模型：`foundry service ps`
- 查看服務日誌：`foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**免責聲明**：  
本文件乃使用 AI 翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 進行翻譯。雖然我們致力於翻譯的準確性，但請注意自動翻譯可能包含錯誤或不準確之處。原文以其母語版本為準，應視為權威來源。對於重要資訊，建議聘請專業人類翻譯。我們不對因使用本翻譯而導致的任何誤解或錯誤解讀承擔責任。
<!-- CO-OP TRANSLATOR DISCLAIMER END -->