<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "d064108b2142d32246ccbd8a42e76b4d",
  "translation_date": "2025-07-25T09:06:31+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "ko"
}
-->
# Foundry Local 명령줄 애플리케이션

>**Note**: 이 챕터에는 샘플을 안내하는 [**튜토리얼**](./TUTORIAL.md)이 포함되어 있습니다.

OpenAI Java SDK를 사용하여 Foundry Local에 연결하는 방법을 보여주는 간단한 Spring Boot 명령줄 애플리케이션입니다.

## 학습 내용

- OpenAI Java SDK를 사용하여 Spring Boot 애플리케이션에 Foundry Local을 통합하는 방법
- 로컬 AI 개발 및 테스트를 위한 모범 사례

## 목차

- [학습 내용](../../../../04-PracticalSamples/foundrylocal)
- [사전 준비](../../../../04-PracticalSamples/foundrylocal)
  - [Foundry Local 설치](../../../../04-PracticalSamples/foundrylocal)
  - [검증](../../../../04-PracticalSamples/foundrylocal)
- [구성](../../../../04-PracticalSamples/foundrylocal)
- [빠른 시작](../../../../04-PracticalSamples/foundrylocal)
- [애플리케이션 기능](../../../../04-PracticalSamples/foundrylocal)
- [샘플 출력](../../../../04-PracticalSamples/foundrylocal)
- [아키텍처](../../../../04-PracticalSamples/foundrylocal)
- [코드 하이라이트](../../../../04-PracticalSamples/foundrylocal)
  - [OpenAI Java SDK 통합](../../../../04-PracticalSamples/foundrylocal)
  - [Chat Completion API](../../../../04-PracticalSamples/foundrylocal)
- [문제 해결](../../../../04-PracticalSamples/foundrylocal)

## 사전 준비

> **⚠️ Note**: 이 애플리케이션은 **제공된 devcontainer에서 실행되지 않습니다**. Foundry Local이 호스트 시스템에 설치되고 실행되어야 합니다.

### Foundry Local 설치

애플리케이션을 실행하기 전에 Foundry Local을 설치하고 시작해야 합니다. 다음 단계를 따르세요:

1. **시스템 요구 사항 확인**:
   - **운영 체제**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025, 또는 macOS
   - **하드웨어**: 
     - 최소: 8GB RAM, 3GB의 여유 디스크 공간
     - 권장: 16GB RAM, 15GB의 여유 디스크 공간
   - **네트워크**: 초기 모델 다운로드를 위한 인터넷 연결 (오프라인 사용 시 선택 사항)
   - **가속화 (선택 사항)**: NVIDIA GPU (2,000 시리즈 이상), AMD GPU (6,000 시리즈 이상), Qualcomm Snapdragon X Elite (8GB 이상의 메모리), 또는 Apple 실리콘
   - **권한**: 장치에 소프트웨어를 설치할 수 있는 관리자 권한

2. **Foundry Local 설치**:
   
   **Windows의 경우:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **macOS의 경우:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   또는 [Foundry Local GitHub 저장소](https://github.com/microsoft/Foundry-Local)에서 설치 프로그램을 다운로드할 수 있습니다.

3. **첫 번째 모델 시작**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   모델이 다운로드되며(인터넷 속도에 따라 몇 분이 소요될 수 있음) 실행됩니다. Foundry Local은 시스템에 가장 적합한 모델 변형(CUDA는 NVIDIA GPU용, CPU 버전은 그 외)을 자동으로 선택합니다.

4. **모델 테스트**: 동일한 터미널에서 질문을 입력하세요:

   ```bash
   Why is the sky blue?
   ```

   하늘이 왜 파랗게 보이는지에 대한 Phi 모델의 응답을 확인할 수 있습니다.

### 검증

다음 명령어를 사용하여 모든 것이 제대로 작동하는지 확인할 수 있습니다:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

또한 브라우저에서 `http://localhost:5273`를 방문하여 Foundry Local 웹 인터페이스를 확인할 수 있습니다.

## 구성

애플리케이션은 `application.properties`를 통해 구성할 수 있습니다:

- `foundry.local.base-url` - Foundry Local의 기본 URL (기본값: http://localhost:5273)
- `foundry.local.model` - 사용할 AI 모델 (기본값: Phi-3.5-mini-instruct-cuda-gpu)

> **Note**: 구성의 모델 이름은 Foundry Local이 시스템에 다운로드한 특정 변형과 일치해야 합니다. `foundry model run phi-3.5-mini`를 실행하면 Foundry Local이 가장 적합한 변형(CUDA는 NVIDIA GPU용, CPU 버전은 그 외)을 자동으로 선택하고 다운로드합니다. 로컬 인스턴스에서 사용 가능한 정확한 모델 이름을 확인하려면 `foundry model list`를 사용하세요.

## 빠른 시작

### 1. Foundry Local 애플리케이션 디렉터리로 이동
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. 애플리케이션 실행

```bash
mvn spring-boot:run
```

또는 JAR을 빌드하고 실행:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### 종속성

이 애플리케이션은 Foundry Local과 통신하기 위해 OpenAI Java SDK를 사용합니다. 주요 종속성은 다음과 같습니다:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

애플리케이션은 기본 포트에서 실행 중인 Foundry Local에 연결하도록 사전 구성되어 있습니다.

## 애플리케이션 기능

애플리케이션을 실행하면:

1. **명령줄 애플리케이션으로 시작** (웹 서버 없음)
2. **테스트 메시지 자동 전송**: "안녕하세요! 당신이 무엇인지와 실행 중인 모델에 대해 알려줄 수 있나요?"
3. **Foundry Local의 응답을 콘솔에 표시**
4. **데모 후 깔끔하게 종료**

## 샘플 출력

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## 아키텍처

- **Application.java** - CommandLineRunner를 포함한 주요 Spring Boot 애플리케이션
- **FoundryLocalService.java** - OpenAI Java SDK를 사용하여 Foundry Local과 통신하는 서비스
- **OpenAI Java SDK**를 사용하여 타입 안전한 API 호출
- SDK를 통한 자동 JSON 직렬화/역직렬화 처리
- Spring의 `@Value` 및 `@PostConstruct` 애노테이션을 사용한 간단한 구성

## 코드 하이라이트

### OpenAI Java SDK 통합

애플리케이션은 Foundry Local에 대해 구성된 클라이언트를 생성하기 위해 OpenAI Java SDK를 사용합니다:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### Chat Completion API

Chat Completion 요청은 간단하고 타입 안전합니다:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## 문제 해결

연결 오류가 발생하면:
1. Foundry Local이 `http://localhost:5273`에서 실행 중인지 확인하세요.
2. `foundry model list`를 사용하여 Phi-3.5-mini 모델 변형이 사용 가능한지 확인하세요.
3. `application.properties`의 모델 이름이 목록에 표시된 정확한 모델 이름과 일치하는지 확인하세요.
4. 방화벽이 연결을 차단하지 않는지 확인하세요.

일반적인 문제:
- **모델을 찾을 수 없음**: `foundry model run phi-3.5-mini`를 실행하여 모델을 다운로드하고 시작하세요.
- **서비스가 실행 중이지 않음**: Foundry Local 서비스가 중지되었을 수 있습니다. 모델 실행 명령으로 다시 시작하세요.
- **잘못된 모델 이름**: 사용 가능한 모델을 확인하려면 `foundry model list`를 사용하고 구성 파일을 업데이트하세요.

**면책 조항**:  
이 문서는 AI 번역 서비스 [Co-op Translator](https://github.com/Azure/co-op-translator)를 사용하여 번역되었습니다. 정확성을 위해 최선을 다하고 있지만, 자동 번역에는 오류나 부정확성이 포함될 수 있습니다. 원본 문서의 원어 버전을 권위 있는 출처로 간주해야 합니다. 중요한 정보에 대해서는 전문적인 인간 번역을 권장합니다. 이 번역 사용으로 인해 발생하는 오해나 잘못된 해석에 대해 책임을 지지 않습니다.