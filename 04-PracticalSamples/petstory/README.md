# Pet Story App

>**Note**: This chapter includes a [**Tutorial**](./TUTORIAL.md) that guides you through running the finished samples.

A Spring Boot web application that generates AI-powered descriptions and stories for uploaded pet images using GitHub Models.

## Table of Contents

- [Technology Stack](#technology-stack)
- [Prerequisites](#prerequisites)
- [Setup & Installation](#setup--installation)
- [Usage](#usage)

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

1. **Access the Application**: Navigate to `http://localhost:8080`
2. **Upload Image**: Click "Choose File" and select a pet image
3. **Analyze Image**: Click "Analyze Image" to get AI description
4. **Generate Story**: Click "Generate Story" to create the story
