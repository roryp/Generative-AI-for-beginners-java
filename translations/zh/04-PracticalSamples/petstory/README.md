<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "69dffd84127360d3f9446b89de471abe",
  "translation_date": "2025-07-21T16:51:14+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "zh"
}
-->
# 宠物故事应用

>**注意**: 本章包含一个[**教程**](./TUTORIAL.md)，指导您运行完成的示例。

一个基于 Spring Boot 的网络应用程序，使用 GitHub 模型生成上传宠物图片的 AI 描述和故事。

## 目录

- [技术栈](../../../../04-PracticalSamples/petstory)
- [先决条件](../../../../04-PracticalSamples/petstory)
- [设置与安装](../../../../04-PracticalSamples/petstory)
- [使用方法](../../../../04-PracticalSamples/petstory)

## 技术栈

- **后端**: Spring Boot 3.5.3, Java 21
- **AI 集成**: OpenAI Java SDK 与 GitHub 模型
- **安全性**: Spring Security
- **前端**: 使用 Thymeleaf 模板和 Bootstrap 样式
- **构建工具**: Maven
- **AI 模型**: GitHub 模型

## 先决条件

- Java 21 或更高版本
- Maven 3.9+
- 具有 `models:read` 权限的 GitHub 个人访问令牌

## 设置与安装

### 1. 进入 petstory 应用程序目录
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. 设置环境变量
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. 构建应用程序
```bash
mvn clean compile
```

### 4. 运行应用程序
```bash
mvn spring-boot:run
```

## 使用方法

1. **访问应用程序**: 打开浏览器，进入 `http://localhost:8080`
2. **上传图片**: 点击“选择文件”，选择一张宠物图片
3. **分析图片**: 点击“分析图片”以获取 AI 描述
4. **生成故事**: 点击“生成故事”以创建故事

**免责声明**：  
本文档使用AI翻译服务[Co-op Translator](https://github.com/Azure/co-op-translator)进行翻译。尽管我们努力确保翻译的准确性，但请注意，自动翻译可能包含错误或不准确之处。原始语言的文档应被视为权威来源。对于关键信息，建议使用专业人工翻译。我们不对因使用此翻译而产生的任何误解或误读承担责任。