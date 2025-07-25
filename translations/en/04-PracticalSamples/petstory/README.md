<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T08:39:29+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "en"
}
-->
# Pet Story App

>**Note**: This chapter includes a [**Tutorial**](./TUTORIAL.md) that walks you through the examples.

A Spring Boot web application that creates AI-generated descriptions and stories for uploaded pet images using GitHub Models.

## Table of Contents

- [Technology Stack](../../../../04-PracticalSamples/petstory)
- [Prerequisites](../../../../04-PracticalSamples/petstory)
- [Setup & Installation](../../../../04-PracticalSamples/petstory)
- [Usage](../../../../04-PracticalSamples/petstory)

## Technology Stack

- **Backend**: Spring Boot 3.5.3, Java 21
- **AI Integration**: OpenAI Java SDK with GitHub Models
- **Security**: Spring Security
- **Frontend**: Thymeleaf templates with Bootstrap styling
- **Build Tool**: Maven
- **AI Models**: GitHub Models

## Prerequisites

- Java 21 or higher
- Maven 3.9+
- GitHub Personal Access Token with `models:read` scope

## Setup & Installation

### 1. Navigate to the petstory application directory
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Set Environment Variable
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Build the Application
```bash
mvn clean compile
```

### 4. Run the Application
```bash
mvn spring-boot:run
```

## Usage

1. **Access the Application**: Go to `http://localhost:8080`
2. **Upload Image**: Click "Choose File" and select a pet image
3. **Analyze Image**: Click "Analyze Image" to receive an AI-generated description
4. **Generate Story**: Click "Generate Story" to create a story

**Disclaimer**:  
This document has been translated using the AI translation service [Co-op Translator](https://github.com/Azure/co-op-translator). While we aim for accuracy, please note that automated translations may include errors or inaccuracies. The original document in its native language should be regarded as the authoritative source. For critical information, professional human translation is advised. We are not responsible for any misunderstandings or misinterpretations resulting from the use of this translation.