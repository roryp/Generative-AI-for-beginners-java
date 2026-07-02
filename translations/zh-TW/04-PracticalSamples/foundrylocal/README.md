# Foundry Local Spring Boot 教學

## 目錄

- [先決條件](#先決條件)
- [專案概覽](#專案概覽)
- [程式碼解析](#程式碼解析)
  - [1. 應用程式設定 (application.properties)](#1-應用程式設定-applicationproperties)
  - [2. 主應用程式類別 (Application.java)](#2-主應用程式類別-applicationjava)
  - [3. AI 服務層 (FoundryLocalService.java)](#3-ai-服務層-foundrylocalservicejava)
  - [4. 專案依賴 (pom.xml)](#4-專案依賴-pomxml)
- [整合運作流程](#整合運作流程)
- [設定 Foundry Local](#設定-foundry-local)
- [執行應用程式](#執行應用程式)
- [預期輸出](#預期輸出)
- [後續步驟](#後續步驟)
- [疑難排解](#疑難排解)


## 先決條件

開始本教學之前，請確認你已經具備：

- 系統安裝了 **Java 21 或以上版本**
- 使用 **Maven 3.6+** 來建置專案
- 已安裝並正在執行 **Foundry Local**

### **安裝 Foundry Local：**

> **說明:** Foundry Local CLI 僅支援 **Windows** 和 **macOS**。Linux 可使用 [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local)（Python、JavaScript、C#、Rust）。

```bash
# 微軟視窗
winget install Microsoft.FoundryLocal

# 蘋果作業系統
brew tap microsoft/foundrylocal
brew install foundrylocal
```

驗證安裝：
```bash
foundry --version
```

## 專案概覽

本專案包含四個主要組件：

1. **Application.java** - 主要的 Spring Boot 應用程式進入點
2. **FoundryLocalService.java** - 負責 AI 通訊的服務層
3. **application.properties** - Foundry Local 連線設定檔
4. **pom.xml** - Maven 依賴與專案設定

## 程式碼解析

### 1. 應用程式設定 (application.properties)

**檔案：** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**說明：**
- **base-url**：指定 Foundry Local 的執行位置，包含 `/v1` 路徑以符合 OpenAI API。預設連接埠是 `5273`，若不同請使用 `foundry service status` 確認。
- **model** (可選)：指定用於文字生成的 AI 模型名稱。**預設情況下，應用程式啟動時會自動檢測模型**，會向 Foundry Local 的 `/v1/models` 端點查詢，因此不需要手動設定。您也可明確設定以覆寫自動偵測。

**重要概念：** Spring Boot 會自動載入這些屬性，並可透過 `@Value` 注入使用。

### 2. 主應用程式類別 (Application.java)

**檔案：** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // 不需要網頁伺服器
        app.run(args);
    }
```

**說明：**
- `@SpringBootApplication` 啟用 Spring Boot 的自動配置
- `WebApplicationType.NONE` 告訴 Spring 此應用是命令列應用，而非網頁伺服器
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

**說明：**
- `@Bean` 建立由 Spring 管理的元件
- `CommandLineRunner` 用來在 Spring Boot 啟動後執行程式碼
- 透過依賴注入自動注入 `foundryLocalService`
- 傳送測試訊息給 AI 並顯示回覆

### 3. AI 服務層 (FoundryLocalService.java)

**檔案：** `src/main/java/com/example/FoundryLocalService.java`

#### 配置注入：
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // 如果為空則自動偵測
```

**說明：**
- `@Service` 表明此類提供商業邏輯服務
- `@Value` 從 application.properties 注入配置值
- 模型預設為空字串，啟動時觸發 <strong>自動偵測</strong> 功能，讓應用程式可使用任何載入的 Foundry Local 模型，無需手動設定。

#### 用戶端初始化：
```java
@PostConstruct
public void init() {
    // 如果未明確配置，則從 Foundry Local 自動檢測模型
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // 基本 URL 已從配置中包含 /v1
            .apiKey("not-needed")            // 本地伺服器不需要真正的 API 金鑰
            .build();
}
```

**說明：**
- `@PostConstruct` 會在 Spring 建立 service 後執行此方法
- 若未設定模型，會呼叫 Foundry Local 的 `/v1/models` 端點，選擇第一個已載入模型
- 建立指向本地 Foundry Local 的 OpenAI 用戶端
- `application.properties` 的 base URL 已包含 `/v1` 以符合 OpenAI API
- API key 設為「not-needed」，因本地開發不需驗證

#### 聊天方法：
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // 使用哪個 AI 模型
                .addUserMessage(message)         // 您的問題／提示
                .maxCompletionTokens(150)        // 限制回應長度
                .temperature(0.7)                // 控制創意程度（0.0-1.0）
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // 從 API 結果中擷取 AI 回應
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**說明：**
- **ChatCompletionCreateParams**：配置 AI 請求參數
  - `model`：指定使用的 AI 模型（必須與 `foundry model list` 中的 ID 完全一致）
  - `addUserMessage`：加入您的訊息至對話
  - `maxCompletionTokens`：限制回覆最大字元數（節省資源）
  - `temperature`：控制回答隨機性（0.0 為固定答案，1.0 為較具創意）
- **API 呼叫**：將請求送到 Foundry Local
- <strong>回應處理</strong>：安全擷取 AI 回覆文字
- <strong>錯誤處理</strong>：捕捉例外並提供有用的錯誤訊息

### 4. 專案依賴 (pom.xml)

**主要依賴：**

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

**說明：**
- **spring-boot-starter**：提供 Spring Boot 核心功能
- **openai-java**：OpenAI 官方 Java SDK，用於 API 通訊
- **jackson-databind**：負責 JSON 序列化及反序列化，處理 API 請求

## 整合運作流程

執行應用程式時完整流程如下：

1. <strong>啟動</strong>：Spring Boot 啟動並讀取 `application.properties`
2. <strong>服務建立</strong>：Spring 建立 `FoundryLocalService` 並注入設定值
3. <strong>模型偵測</strong>：若未設定模型，服務查詢 Foundry Local 的 `/v1/models` 端點，自動使用第一個可用模型
4. <strong>用戶端設定</strong>：`@PostConstruct` 初始化 OpenAI 用戶端以連接 Foundry Local
5. <strong>示範執行</strong>：`CommandLineRunner` 啟動後執行
6. **AI 呼叫**：示範呼叫 `foundryLocalService.chat()` 傳送測試訊息
7. **API 請求**：服務組建並送出 OpenAI 兼容請求至 Foundry Local
8. <strong>回應處理</strong>：服務擷取並返回 AI 回覆文字
9. <strong>顯示結果</strong>：應用程式打印回覆後結束

## 設定 Foundry Local

1. 依照 [先決條件](#先決條件) 章節中提供的說明安裝 Foundry Local。

2. <strong>啟動服務</strong>（若尚未啟動）：
   ```bash
   foundry service start
   ```

3. <strong>檢查服務狀態</strong>，確認正在執行並記下埠號：
   ```bash
   foundry service status
   ```

4. <strong>下載並執行模型</strong>（第一次執行會下載，後續快取使用）：
   ```bash
   foundry model run phi-4-mini
   ```
   這會開啟互動式聊天介面，按 `Ctrl+C` 可退出。模型會常駐於服務中。

   > **小提示：** 執行 `foundry model list` 可查看所有可用模型。替換範例中的 `phi-4-mini` 為任一目錄中別名（如較小較快的模型 `qwen2.5-0.5b`）。

5. **確認模型已加載：**
   ```bash
   foundry service ps
   ```

6. **如有需要，更新 `application.properties`：**
   - 預設 `base-url` (`http://localhost:5273/v1`) 與 CLI 預設埠一致，只有在 `foundry service status` 顯示不同埠時才需修改。
   - 模型名稱由應用程式啟動時自動偵測，無需設定。

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## 執行應用程式

### 步驟 1：確認 Foundry Local 中已有模型
```bash
foundry service ps
```
若無模型顯示，請執行加載：
```bash
foundry model run phi-4-mini
```

### 步驟 2：編譯並執行應用程式
使用另一個終端機執行：
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

或建置為 JAR 後執行：
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

## 後續步驟

更多範例請參考 [第 04 章：實務範例](../README.md)

## 疑難排解

### 常見問題

**「連線被拒」或「服務無法使用」**
- 檢查服務狀態：`foundry service status`
- 需要重啟時：`foundry service restart`
- 確認 `application.properties` 中的埠號與 `foundry service status` 輸出相符
- 確認 URL 以 `/v1` 結尾：`http://localhost:5273/v1`

**啟動時出現「找不到模型」**
- 應用程式會自動偵測模型。請確認至少一個模型已加載：`foundry service ps`
- 若沒有模型：`foundry model run phi-4-mini`
- 如果在 `application.properties` 中覆寫模型名稱，請確認與 `foundry model list` 中的名稱一致

**「400 Bad Request」 錯誤**
- 確認 base URL 包含 `/v1`：`http://localhost:5273/v1`
- 檢查程式碼使用的是 `maxCompletionTokens()` 而不是已棄用的 `maxTokens()`

**Maven 編譯錯誤**
- 確認 Java 版本為 21 或以上：`java -version`
- 清理並重新編譯：`mvn clean compile`
- 確認網路連線可下載依賴

<strong>服務連接問題</strong>
- 看到「Request to local service failed」時，執行：`foundry service restart`
- 檢查已加載模型：`foundry service ps`
- 查看服務日誌：`foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**免責聲明**：  
本文件由 AI 翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 進行翻譯。雖然我們力求準確，但請注意，自動翻譯可能包含錯誤或不準確之處。原始文件的母語版本應被視為權威來源。對於重要資訊，建議採用專業人工翻譯。我們不對因使用本翻譯而引起的任何誤解或誤譯負責。
<!-- CO-OP TRANSLATOR DISCLAIMER END -->