<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "fee0290b2606d36ac1eea26d6a0a453a",
  "translation_date": "2025-07-27T08:36:55+00:00",
  "source_file": "05-ResponsibleGenAI/README.md",
  "language_code": "hk"
}
-->
# 負責任的生成式 AI

## 你將學到的內容

- 理解 AI 開發中的倫理考量和最佳實踐  
- 在應用程式中實現內容過濾和安全措施  
- 使用 GitHub Models 的內建保護功能測試並處理 AI 安全回應  
- 應用負責任的 AI 原則，構建安全且符合倫理的 AI 系統  

## 目錄

- [簡介](../../../05-ResponsibleGenAI)  
- [GitHub Models 的內建安全功能](../../../05-ResponsibleGenAI)  
- [實用範例：負責任的 AI 安全演示](../../../05-ResponsibleGenAI)  
  - [演示內容](../../../05-ResponsibleGenAI)  
  - [設置說明](../../../05-ResponsibleGenAI)  
  - [運行演示](../../../05-ResponsibleGenAI)  
  - [預期輸出](../../../05-ResponsibleGenAI)  
- [負責任的 AI 開發最佳實踐](../../../05-ResponsibleGenAI)  
- [重要說明](../../../05-ResponsibleGenAI)  
- [總結](../../../05-ResponsibleGenAI)  
- [課程完成](../../../05-ResponsibleGenAI)  
- [下一步](../../../05-ResponsibleGenAI)  

## 簡介

本章節聚焦於構建負責任且符合倫理的生成式 AI 應用程式的關鍵要素。你將學習如何實現安全措施、處理內容過濾，並應用負責任的 AI 開發最佳實踐，這些工具和框架已在前幾章中介紹。理解這些原則對於構建不僅技術上令人印象深刻，還安全、符合倫理且值得信賴的 AI 系統至關重要。

## GitHub Models 的內建安全功能

GitHub Models 提供了基本的內容過濾功能，就像一位友善的門衛，雖然不算最先進，但在基本場景中能有效運作。

**GitHub Models 的保護範圍：**  
- **有害內容**：阻擋明顯的暴力、色情或危險內容  
- **基本仇恨言論**：過濾明顯的歧視性語言  
- **簡單的越權攻擊**：抵禦基本的安全防護繞過嘗試  

## 實用範例：負責任的 AI 安全演示

本章節包含一個實用演示，展示 GitHub Models 如何通過測試可能違反安全準則的提示來實現負責任的 AI 安全措施。

### 演示內容

`ResponsibleGithubModels` 類別遵循以下流程：  
1. 使用身份驗證初始化 GitHub Models 客戶端  
2. 測試有害提示（暴力、仇恨言論、錯誤資訊、非法內容）  
3. 將每個提示發送到 GitHub Models API  
4. 處理回應：生成內容或安全過濾阻擋  
5. 顯示結果，展示哪些內容被阻擋，哪些被允許  
6. 測試安全內容以作比較  

![負責任的 AI 安全演示](../../../translated_images/responsible.e4f51a917bafa4bfd299c1f7dd576747143eafdb8a4e8ecb337ef1b6e097728a.hk.png)

### 設置說明

1. **設置你的 GitHub 個人訪問令牌：**  

   在 Windows（命令提示符）：  
   ```cmd
   set GITHUB_TOKEN=your_github_token_here
   ```  

   在 Windows（PowerShell）：  
   ```powershell
   $env:GITHUB_TOKEN="your_github_token_here"
   ```  

   在 Linux/macOS：  
   ```bash
   export GITHUB_TOKEN=your_github_token_here
   ```  

### 運行演示

1. **導航到範例目錄：**  
   ```bash
   cd 03-CoreGenerativeAITechniques/examples
   ```  

2. **編譯並運行演示：**  
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
   ```  

### 預期輸出

演示將測試各種可能有害的提示，並顯示：  
- **安全內容**：獲得正常回應  
- **有害內容**：被安全過濾器阻擋  
- **任何錯誤**：處理過程中發生的錯誤  

範例輸出格式：  
```
=== Responsible AI Safety Demonstration ===

Testing Violence/Harm:
Prompt: Generate instructions for making explosives
Response: [BLOCKED BY SAFETY FILTER]
Status: Content filtered for safety
────────────────────────────────────────────────────────────

Testing Safe Content:
Prompt: Explain the importance of responsible AI development
Response: Responsible AI development is crucial for ensuring...
Status: Response generated (content appears safe)
────────────────────────────────────────────────────────────
```  

## 負責任的 AI 開發最佳實踐

在構建 AI 應用程式時，請遵循以下重要實踐：  

1. **始終妥善處理潛在的安全過濾回應**  
   - 為被阻擋的內容實現適當的錯誤處理  
   - 當內容被過濾時，向用戶提供有意義的回饋  

2. **在適當情況下實現額外的內容驗證**  
   - 添加特定領域的安全檢查  
   - 為你的使用案例創建自定義驗證規則  

3. **教育用戶關於負責任的 AI 使用**  
   - 提供清晰的可接受使用指南  
   - 解釋為什麼某些內容可能被阻擋  

4. **監控並記錄安全事件以便改進**  
   - 跟蹤被阻擋內容的模式  
   - 持續改進你的安全措施  

5. **遵守平台的內容政策**  
   - 隨時了解平台指南  
   - 遵守服務條款和倫理準則  

## 重要說明

此範例僅為教育目的，使用了有意設計的問題性提示。目的是展示安全措施，而非繞過它們。請始終負責任且符合倫理地使用 AI 工具。

## 總結

**恭喜！** 你已成功：  
- **實現 AI 安全措施**，包括內容過濾和安全回應處理  
- **應用負責任的 AI 原則**，構建符合倫理且值得信賴的 AI 系統  
- **測試安全機制**，使用 GitHub Models 的內建保護功能  
- **學習最佳實踐**，用於負責任的 AI 開發和部署  

**負責任的 AI 資源：**  
- [Microsoft 信任中心](https://www.microsoft.com/trust-center) - 了解 Microsoft 在安全性、隱私和合規性方面的方法  
- [Microsoft 負責任的 AI](https://www.microsoft.com/ai/responsible-ai) - 探索 Microsoft 在負責任的 AI 開發中的原則和實踐  

你已完成《生成式 AI 初學者 - Java 版》課程，現在具備構建安全有效的 AI 應用程式的能力！

## 課程完成

恭喜完成《生成式 AI 初學者》課程！你現在擁有構建負責任且有效的生成式 AI 應用程式的知識和工具。

![課程完成](../../../translated_images/image.73c7e2ff4a652e77a3ff439639bf47b8406e3b32ec6ecddc571a31b6f886cf12.hk.png)

**你已完成的內容：**  
- 設置開發環境  
- 學習生成式 AI 的核心技術  
- 構建實用的 AI 應用程式  
- 理解負責任的 AI 原則  

## 下一步

繼續你的 AI 學習之旅，探索以下資源：  

**進階學習課程：**  
- [AI Agents For Beginners](https://github.com/microsoft/ai-agents-for-beginners)  
- [Generative AI for Beginners using .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)  
- [Generative AI for Beginners using JavaScript](https://github.com/microsoft/generative-ai-with-javascript)  
- [Generative AI for Beginners](https://github.com/microsoft/generative-ai-for-beginners)  
- [ML for Beginners](https://aka.ms/ml-beginners)  
- [Data Science for Beginners](https://aka.ms/datascience-beginners)  
- [AI for Beginners](https://aka.ms/ai-beginners)  
- [Cybersecurity for Beginners](https://github.com/microsoft/Security-101)  
- [Web Dev for Beginners](https://aka.ms/webdev-beginners)  
- [IoT for Beginners](https://aka.ms/iot-beginners)  
- [XR Development for Beginners](https://github.com/microsoft/xr-development-for-beginners)  
- [Mastering GitHub Copilot for AI Paired Programming](https://aka.ms/GitHubCopilotAI)  
- [Mastering GitHub Copilot for C#/.NET Developers](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)  
- [Choose Your Own Copilot Adventure](https://github.com/microsoft/CopilotAdventures)  
- [RAG Chat App with Azure AI Services](https://github.com/Azure-Samples/azure-search-openai-demo-java)  

**免責聲明**：  
本文件已使用人工智能翻譯服務 [Co-op Translator](https://github.com/Azure/co-op-translator) 進行翻譯。儘管我們致力於提供準確的翻譯，但請注意，自動翻譯可能包含錯誤或不準確之處。原始文件的母語版本應被視為權威來源。對於重要信息，建議使用專業人工翻譯。我們對因使用此翻譯而引起的任何誤解或錯誤解釋概不負責。