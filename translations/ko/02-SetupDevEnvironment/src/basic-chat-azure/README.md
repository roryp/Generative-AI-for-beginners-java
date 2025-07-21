<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2289320a74aeca1eb844cd7d3a7a9e12",
  "translation_date": "2025-07-21T16:27:24+00:00",
  "source_file": "02-SetupDevEnvironment/src/basic-chat-azure/README.md",
  "language_code": "ko"
}
-->
# Azure OpenAI와의 기본 채팅 - 엔드 투 엔드 예제

이 예제는 Azure OpenAI에 연결하고 설정을 테스트하는 간단한 Spring Boot 애플리케이션을 만드는 방법을 보여줍니다.

## 목차

- [사전 요구 사항](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [빠른 시작](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [구성 옵션](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [옵션 1: 환경 변수 (.env 파일) - 권장](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [옵션 2: GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [애플리케이션 실행](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Maven 사용](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [VS Code 사용](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [예상 출력](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [구성 참조](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [환경 변수](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Spring 구성](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [문제 해결](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [일반적인 문제](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [디버그 모드](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [다음 단계](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [리소스](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)

## 사전 요구 사항

이 예제를 실행하기 전에 다음을 완료했는지 확인하세요:

- [Azure OpenAI 설정 가이드](../../getting-started-azure-openai.md)를 완료  
- Azure AI Foundry 포털을 통해 Azure OpenAI 리소스를 배포  
- gpt-4o-mini 모델(또는 대체 모델)을 배포  
- Azure에서 API 키와 엔드포인트 URL 확보  

## 빠른 시작

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/src/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## 구성 옵션

### 옵션 1: 환경 변수 (.env 파일) - 권장

**1단계: 구성 파일 생성**  
```bash
cp .env.example .env
```

**2단계: Azure OpenAI 자격 증명 추가**  
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **보안 주의**:  
> - `.env` 파일을 버전 관리 시스템에 절대 커밋하지 마세요  
> - `.env` 파일은 이미 `.gitignore`에 포함되어 있습니다  
> - API 키를 안전하게 보관하고 정기적으로 교체하세요  

### 옵션 2: GitHub Codespace Secrets

GitHub Codespaces를 사용하는 경우, 다음 Secrets를 리포지토리에 설정하세요:
- `AZURE_AI_KEY` - Azure OpenAI API 키
- `AZURE_AI_ENDPOINT` - Azure OpenAI 엔드포인트 URL

애플리케이션은 자동으로 이 Secrets를 감지하고 사용합니다.

### 대안: 직접 환경 변수 설정

<details>
<summary>플랫폼별 명령어 보기</summary>

**Linux/macOS (bash/zsh):**  
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (Command Prompt):**  
```cmd
set AZURE_AI_KEY=your-actual-api-key-here
set AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (PowerShell):**  
```powershell
$env:AZURE_AI_KEY="your-actual-api-key-here"
$env:AZURE_AI_ENDPOINT="https://your-hub-name.openai.azure.com/"
```
</details>

## 애플리케이션 실행

### Maven 사용

```bash
mvn spring-boot:run
```

### VS Code 사용

1. 프로젝트를 VS Code에서 엽니다  
2. `F5`를 누르거나 "Run and Debug" 패널을 사용합니다  
3. "Spring Boot-BasicChatApplication" 구성을 선택합니다  

> **참고**: VS Code 구성은 `.env` 파일을 자동으로 로드합니다  

### 예상 출력

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

## 구성 참조

### 환경 변수

| 변수 | 설명 | 필수 여부 | 예시 |
|------|------|-----------|------|
| `AZURE_AI_KEY` | Azure OpenAI API 키 | 예 | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI 엔드포인트 URL | 예 | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | 모델 배포 이름 | 아니요 | `gpt-4o-mini` (기본값) |

### Spring 구성

`application.yml` 파일은 다음을 구성합니다:
- **API 키**: `${AZURE_AI_KEY}` - 환경 변수에서 가져옴  
- **엔드포인트**: `${AZURE_AI_ENDPOINT}` - 환경 변수에서 가져옴  
- **모델**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - 환경 변수에서 가져오며 기본값 제공  
- **온도(Temperature)**: `0.7` - 창의성 제어 (0.0 = 결정적, 1.0 = 창의적)  
- **최대 토큰(Max Tokens)**: `500` - 응답 길이 제한  

## 문제 해결

### 일반적인 문제

<details>
<summary><strong>오류: "API 키가 유효하지 않습니다"</strong></summary>

- `.env` 파일에 `AZURE_AI_KEY`가 올바르게 설정되었는지 확인하세요  
- Azure AI Foundry 포털에서 API 키를 정확히 복사했는지 확인하세요  
- 키 주변에 공백이나 따옴표가 없는지 확인하세요  
</details>

<details>
<summary><strong>오류: "엔드포인트가 유효하지 않습니다"</strong></summary>

- `AZURE_AI_ENDPOINT`에 전체 URL이 포함되어 있는지 확인하세요 (예: `https://your-hub-name.openai.azure.com/`)  
- 슬래시(`/`) 일관성을 확인하세요  
- 엔드포인트가 Azure 배포 지역과 일치하는지 확인하세요  
</details>

<details>
<summary><strong>오류: "배포를 찾을 수 없습니다"</strong></summary>

- 모델 배포 이름이 Azure에 배포된 이름과 정확히 일치하는지 확인하세요  
- 모델이 성공적으로 배포되고 활성 상태인지 확인하세요  
- 기본 배포 이름인 `gpt-4o-mini`를 사용해 보세요  
</details>

<details>
<summary><strong>VS Code: 환경 변수가 로드되지 않음</strong></summary>

- `.env` 파일이 프로젝트 루트 디렉토리(예: `pom.xml`과 동일한 수준)에 있는지 확인하세요  
- VS Code의 통합 터미널에서 `mvn spring-boot:run`을 실행해 보세요  
- VS Code Java 확장이 제대로 설치되었는지 확인하세요  
- 실행 구성에 `"envFile": "${workspaceFolder}/.env"`가 포함되어 있는지 확인하세요  
</details>

### 디버그 모드

자세한 로깅을 활성화하려면 `application.yml`에서 다음 줄의 주석을 해제하세요:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## 다음 단계

**설정 완료!** 학습 여정을 계속하세요:

[3장: 핵심 생성 AI 기술](../../../03-CoreGenerativeAITechniques/README.md)

## 리소스

- [Spring AI Azure OpenAI 문서](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)  
- [Azure OpenAI 서비스 문서](https://learn.microsoft.com/azure/ai-services/openai/)  
- [Azure AI Foundry 포털](https://ai.azure.com/)  
- [Azure AI Foundry 문서](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)  

**면책 조항**:  
이 문서는 AI 번역 서비스 [Co-op Translator](https://github.com/Azure/co-op-translator)를 사용하여 번역되었습니다. 정확성을 위해 최선을 다하고 있지만, 자동 번역에는 오류나 부정확성이 포함될 수 있습니다. 원본 문서의 원어 버전이 권위 있는 출처로 간주되어야 합니다. 중요한 정보의 경우, 전문적인 인간 번역을 권장합니다. 이 번역 사용으로 인해 발생하는 오해나 잘못된 해석에 대해 책임을 지지 않습니다.