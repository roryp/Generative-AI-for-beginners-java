<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T08:58:43+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "mo"
}
-->
# 寵物故事應用程式

>**注意**：本章節包含一個[**教學指南**](./TUTORIAL.md)，帶您一步步完成範例操作。

這是一個基於 Spring Boot 的網頁應用程式，使用 GitHub 模型生成 AI 驅動的描述和故事，適用於上傳的寵物圖片。

## 目錄

- [技術堆疊](../../../../04-PracticalSamples/petstory)
- [先決條件](../../../../04-PracticalSamples/petstory)
- [設定與安裝](../../../../04-PracticalSamples/petstory)
- [使用方式](../../../../04-PracticalSamples/petstory)

## 技術堆疊

- **後端**：Spring Boot 3.5.3, Java 21
- **AI 整合**：OpenAI Java SDK 與 GitHub 模型
- **安全性**：Spring Security
- **前端**：Thymeleaf 模板搭配 Bootstrap 樣式
- **建置工具**：Maven
- **AI 模型**：GitHub 模型

## 先決條件

- Java 21 或更高版本
- Maven 3.9+
- 具有 `models:read` 權限的 GitHub 個人訪問令牌

## 設定與安裝

### 1. 移動到 petstory 應用程式目錄
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. 設定環境變數
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. 建置應用程式
```bash
mvn clean compile
```

### 4. 啟動應用程式
```bash
mvn spring-boot:run
```

## 使用方式

1. **進入應用程式**：打開瀏覽器並前往 `http://localhost:8080`
2. **上傳圖片**：點擊「選擇檔案」，選擇一張寵物圖片
3. **分析圖片**：點擊「分析圖片」以獲取 AI 描述
4. **生成故事**：點擊「生成故事」來創建故事

**免責聲明**：  
本文件已使用 AI 翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 進行翻譯。雖然我們致力於提供準確的翻譯，但請注意，自動翻譯可能包含錯誤或不準確之處。原始文件的母語版本應被視為權威來源。對於關鍵信息，建議尋求專業人工翻譯。我們對因使用此翻譯而引起的任何誤解或錯誤解釋不承擔責任。