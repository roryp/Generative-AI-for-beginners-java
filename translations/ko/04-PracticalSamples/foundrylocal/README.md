# Foundry Local Spring Boot 튜토리얼

## 목차

- [사전 준비 사항](#사전-준비-사항)
- [프로젝트 개요](#프로젝트-개요)
- [코드 이해하기](#코드-이해하기)
  - [1. 애플리케이션 설정 (application.properties)](#1-애플리케이션-설정-applicationproperties)
  - [2. 메인 애플리케이션 클래스 (Application.java)](#2-메인-애플리케이션-클래스-applicationjava)
  - [3. AI 서비스 계층 (FoundryLocalService.java)](#3-ai-서비스-계층-foundrylocalservicejava)
  - [4. 프로젝트 의존성 (pom.xml)](#4-프로젝트-의존성-pomxml)
- [전체 작동 방식](#전체-작동-방식)
- [Foundry Local 설정](#foundry-local-설정)
- [애플리케이션 실행](#애플리케이션-실행)
- [예상 출력](#예상-출력)
- [다음 단계](#다음-단계)
- [문제 해결](#문제-해결)


## 사전 준비 사항

이 튜토리얼을 시작하기 전에 다음이 준비되어 있는지 확인하세요:

- 시스템에 <strong>Java 21 이상</strong>이 설치되어 있어야 합니다.
- 프로젝트 빌드를 위한 **Maven 3.6+**
- <strong>Foundry Local</strong>이 설치되고 실행 중이어야 합니다.

### **Foundry Local 설치:**

> **참고:** Foundry Local CLI는 <strong>Windows</strong>와 <strong>macOS</strong>에서만 사용할 수 있습니다. Linux는 [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust)를 통해 지원됩니다.

```bash
# 윈도우
winget install Microsoft.FoundryLocal

# 맥OS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

설치 확인:
```bash
foundry --version
```

## 프로젝트 개요

이 프로젝트는 네 가지 주요 구성요소로 이루어져 있습니다:

1. **Application.java** - 주요 Spring Boot 애플리케이션 진입점
2. **FoundryLocalService.java** - AI 통신을 처리하는 서비스 계층
3. **application.properties** - Foundry Local 연결 구성
4. **pom.xml** - Maven 의존성과 프로젝트 설정

## 코드 이해하기

### 1. 애플리케이션 설정 (application.properties)

**파일:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**역할:**
- **base-url**: Foundry Local이 실행 중인 위치를 지정하며, OpenAI API 호환성을 위해 `/v1` 경로를 포함합니다. 기본 포트는 `5273`입니다. 포트가 다르면 `foundry service status` 명령으로 확인하세요.
- **model** (선택 사항): 텍스트 생성을 위한 AI 모델 이름을 지정합니다. **기본적으로 애플리케이션이 Foundry Local의 `/v1/models` 엔드포인트를 시작 시 쿼리하여 모델을 자동 감지**하므로 설정할 필요가 없습니다. 필요 시 명시적으로 지정할 수 있습니다.

**핵심 개념:** Spring Boot는 이 속성들을 자동으로 로드하여 `@Value` 어노테이션을 통해 애플리케이션에서 사용할 수 있게 합니다.

### 2. 메인 애플리케이션 클래스 (Application.java)

**파일:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // 웹 서버 불필요
        app.run(args);
    }
```

**역할:**
- `@SpringBootApplication`은 Spring Boot 자동 구성을 활성화합니다.
- `WebApplicationType.NONE`은 이 애플리케이션이 웹 서버가 아닌 커맨드라인 앱임을 Spring에 알려줍니다.
- main 메서드는 Spring 애플리케이션을 시작합니다.

**데모 실행자:**
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

**역할:**
- `@Bean`은 Spring이 관리하는 컴포넌트를 생성합니다.
- `CommandLineRunner`는 Spring Boot 시작 후 코드를 실행합니다.
- `foundryLocalService`는 Spring에 의해 자동 주입(의존성 주입)됩니다.
- AI에 테스트 메시지를 보내고 그 응답을 출력합니다.

### 3. AI 서비스 계층 (FoundryLocalService.java)

**파일:** `src/main/java/com/example/FoundryLocalService.java`

#### 구성 주입:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // 비어 있으면 자동 감지됨
```

**역할:**
- `@Service`는 이 클래스가 비즈니스 로직 제공자임을 Spring에 알립니다.
- `@Value`는 application.properties에서 설정 값을 주입합니다.
- 모델은 기본값이 비어 있으며, 이는 <strong>Foundry Local에서 시작 시 자동 감지</strong>를 트리거합니다. 즉, Foundry Local에 로드된 어떤 모델이라도 별도 설정 없이 작동합니다.

#### 클라이언트 초기화:
```java
@PostConstruct
public void init() {
    // 명시적으로 구성되지 않은 경우 Foundry Local에서 모델을 자동 감지합니다
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // 기본 URL에 구성에서 /v1이 이미 포함되어 있습니다
            .apiKey("not-needed")            // 로컬 서버는 실제 API 키가 필요하지 않습니다
            .build();
}
```

**역할:**
- `@PostConstruct`는 Spring이 서비스를 생성한 후 이 메서드를 실행합니다.
- 모델이 설정되지 않으면 Foundry Local의 `/v1/models` 엔드포인트를 쿼리하여 첫 번째 로드된 모델을 선택합니다.
- 로컬 Foundry Local 인스턴스를 가리키는 OpenAI 클라이언트를 만듭니다.
- `application.properties`의 base URL은 이미 OpenAI API 호환을 위해 `/v1`을 포함합니다.
- 인증이 필요 없는 로컬 개발 환경이므로 API 키는 "not-needed"로 설정합니다.

#### 채팅 메서드:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // 사용할 AI 모델
                .addUserMessage(message)         // 당신의 질문/프롬프트
                .maxCompletionTokens(150)        // 응답 길이 제한
                .temperature(0.7)                // 창의성 조절 (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // API 결과에서 AI의 응답 추출
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**역할:**
- **ChatCompletionCreateParams**: AI 요청을 설정합니다.
  - `model`: 사용할 AI 모델 지정 (반드시 `foundry model list`에서 정확한 ID와 일치해야 함)
  - `addUserMessage`: 대화에 사용자 메시지를 추가
  - `maxCompletionTokens`: 응답 길이 제한 (리소스 절약용)
  - `temperature`: 생성의 무작위성 제어 (0.0 = 결정적, 1.0 = 창의적)
- **API 호출**: 요청을 Foundry Local에 전송
- **응답 처리**: AI의 텍스트 응답을 안전하게 추출
- **예외 처리**: 에러 발생 시 도움말 메시지와 함께 예외 래핑

### 4. 프로젝트 의존성 (pom.xml)

**주요 의존성:**

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

**역할:**
- **spring-boot-starter**: 기본 Spring Boot 기능 제공
- **openai-java**: OpenAI 공식 Java SDK로 API 통신 지원
- **jackson-databind**: API 호출 시 JSON 직렬화/역직렬화 처리

## 전체 작동 방식

애플리케이션을 실행할 때 동작 흐름은 다음과 같습니다:

1. <strong>시작</strong>: Spring Boot가 시작되며 `application.properties`를 읽음
2. **서비스 생성**: Spring이 `FoundryLocalService`를 생성하고 설정 값을 주입
3. **모델 감지**: 설정된 모델이 없으면 Foundry Local의 `/v1/models` 엔드포인트를 쿼리하여 자동으로 첫 번째 모델을 선택
4. **클라이언트 설정**: `@PostConstruct`가 OpenAI 클라이언트를 초기화하여 Foundry Local에 연결
5. **데모 실행**: `CommandLineRunner`가 시작 후 실행됨
6. **AI 호출**: 데모가 `foundryLocalService.chat()` 메서드를 테스트 메시지로 호출
7. **API 요청**: 서비스가 OpenAI 호환 요청을 만들어 Foundry Local에 전송
8. **응답 처리**: 서비스가 AI 응답을 추출하여 반환
9. <strong>출력</strong>: 애플리케이션이 응답을 출력하고 종료

## Foundry Local 설정

1. [사전 준비 사항](#사전-준비-사항) 절의 안내를 참조하여 Foundry Local을 설치하세요.

2. **서비스 시작** (실행 중이 아니면):
   ```bash
   foundry service start
   ```

3. **서비스 상태 확인** 및 포트 확인:
   ```bash
   foundry service status
   ```

4. **모델 다운로드 및 실행** (첫 실행 시 다운로드 후 캐시):
   ```bash
   foundry model run phi-4-mini
   ```
   인터랙티브 채팅 세션이 열립니다. `Ctrl+C`로 종료할 수 있으며, 모델은 서비스에 계속 로드됩니다.

   > **팁:** `foundry model list`로 사용 가능한 모든 모델을 확인하세요. `phi-4-mini` 대신 카탈로그의 다른 별칭(예: 작은/빠른 모델인 `qwen2.5-0.5b`)을 사용할 수 있습니다.

5. **모델이 로드됐는지 확인:**
   ```bash
   foundry service ps
   ```

6. 필요 시 `application.properties` 업데이트:
   - 기본 `base-url` (`http://localhost:5273/v1`)은 CLI 기본 포트와 일치합니다. `foundry service status`에서 다른 포트를 확인하면 업데이트하세요.
   - 모델은 시작 시 <strong>자동 감지</strong>되므로 별도의 설정이 필요 없습니다.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## 애플리케이션 실행

### 1단계: Foundry Local에 모델이 로드되어 있는지 확인
```bash
foundry service ps
```
모델이 없으면 로드:
```bash
foundry model run phi-4-mini
```

### 2단계: 애플리케이션 빌드 및 실행
다른 터미널에서:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

또는 JAR로 빌드 및 실행:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## 예상 출력

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

## 다음 단계

추가 예제는 [Chapter 04: Practical samples](../README.md)를 참고하세요.

## 문제 해결

### 일반 문제

**"Connection refused" 또는 "Service unavailable" 에러**
- 서비스 상태 확인: `foundry service status`
- 필요 시 재시작: `foundry service restart`
- `application.properties`의 포트가 `foundry service status` 출력과 일치하는지 확인
- URL이 `/v1`로 끝나는지 확인: `http://localhost:5273/v1`

**시작 시 "모델을 찾을 수 없음"**
- 애플리케이션이 자동으로 모델을 감지합니다. 모델이 적어도 하나 로드됐는지 확인: `foundry service ps`
- 모델이 없다면: `foundry model run phi-4-mini` 실행
- `application.properties`에서 모델명을 오버라이드했다면, `foundry model list`와 일치하는지 확인

**"400 Bad Request" 에러**
- 기본 URL에 `/v1`이 포함되었는지 확인: `http://localhost:5273/v1`
- 코드에서 `maxCompletionTokens()`를 사용했는지 확인 (더 이상 쓰이지 않는 `maxTokens()` 사용하지 말 것)

**Maven 컴파일 에러**
- Java 21 이상 버전인지 확인: `java -version`
- 클린 빌드 수행: `mvn clean compile`
- 의존성 다운로드를 위한 인터넷 연결 상태 확인

**서비스 연결 문제**
- `Request to local service failed` 에러 시: `foundry service restart` 실행
- 로드된 모델 확인: `foundry service ps`
- 서비스 로그 보기: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**면책 조항**:  
이 문서는 AI 번역 서비스 [Co-op Translator](https://github.com/Azure/co-op-translator)를 이용하여 번역되었습니다. 정확성을 위해 노력하였으나, 자동 번역에는 오류나 부정확성이 포함될 수 있음을 양지하시기 바랍니다. 원문은 해당 언어로 된 원본 문서를 권위 있는 출처로 간주해야 합니다. 중요한 정보의 경우 전문적인 인간 번역을 권장합니다. 본 번역 사용으로 인해 발생하는 오해나 오해의 소지에 대해 당사는 책임을 지지 않습니다.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->