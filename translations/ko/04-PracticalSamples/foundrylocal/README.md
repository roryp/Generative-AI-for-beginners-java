<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "f787307400de59adc25a1404466a35f3",
  "translation_date": "2025-11-04T07:18:12+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "ko"
}
-->
# Foundry Local Spring Boot 튜토리얼

## 목차

- [사전 준비](../../../../04-PracticalSamples/foundrylocal)
- [프로젝트 개요](../../../../04-PracticalSamples/foundrylocal)
- [코드 이해하기](../../../../04-PracticalSamples/foundrylocal)
  - [1. 애플리케이션 설정 (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. 메인 애플리케이션 클래스 (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. AI 서비스 계층 (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. 프로젝트 종속성 (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [전체 작동 방식](../../../../04-PracticalSamples/foundrylocal)
- [Foundry Local 설정하기](../../../../04-PracticalSamples/foundrylocal)
- [애플리케이션 실행하기](../../../../04-PracticalSamples/foundrylocal)
- [예상 출력 결과](../../../../04-PracticalSamples/foundrylocal)
- [다음 단계](../../../../04-PracticalSamples/foundrylocal)
- [문제 해결](../../../../04-PracticalSamples/foundrylocal)

## 사전 준비

이 튜토리얼을 시작하기 전에 다음을 준비하세요:

- **Java 21 이상**이 시스템에 설치되어 있어야 합니다.
- **Maven 3.6+**을 사용하여 프로젝트를 빌드합니다.
- **Foundry Local**이 설치되어 실행 중이어야 합니다.

### **Foundry Local 설치:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```

## 프로젝트 개요

이 프로젝트는 네 가지 주요 구성 요소로 이루어져 있습니다:

1. **Application.java** - Spring Boot 애플리케이션의 메인 진입점
2. **FoundryLocalService.java** - AI 통신을 처리하는 서비스 계층
3. **application.properties** - Foundry Local 연결을 위한 설정 파일
4. **pom.xml** - Maven 종속성과 프로젝트 설정

## 코드 이해하기

### 1. 애플리케이션 설정 (application.properties)

**파일:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```

**이 설정의 역할:**
- **base-url**: Foundry Local이 실행 중인 위치를 지정하며, OpenAI API 호환성을 위해 `/v1` 경로를 포함합니다. **참고**: Foundry Local은 동적으로 포트를 할당하므로 `foundry service status` 명령어를 사용하여 실제 포트를 확인하세요.
- **model**: 텍스트 생성을 위한 AI 모델 이름과 버전 번호를 지정합니다 (예: `:1`). `foundry model list` 명령어를 사용하여 사용 가능한 모델과 정확한 ID를 확인하세요.

**핵심 개념:** Spring Boot는 이 설정을 자동으로 로드하며, `@Value` 애노테이션을 사용하여 애플리케이션에서 사용할 수 있도록 합니다.

### 2. 메인 애플리케이션 클래스 (Application.java)

**파일:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```

**이 코드의 역할:**
- `@SpringBootApplication`은 Spring Boot의 자동 설정을 활성화합니다.
- `WebApplicationType.NONE`은 Spring이 이 애플리케이션을 웹 서버가 아닌 커맨드라인 앱으로 인식하도록 합니다.
- 메인 메서드는 Spring 애플리케이션을 시작합니다.

**데모 실행기:**
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

**이 코드의 역할:**
- `@Bean`은 Spring이 관리하는 컴포넌트를 생성합니다.
- `CommandLineRunner`는 Spring Boot가 시작된 후 코드를 실행합니다.
- `foundryLocalService`는 Spring에 의해 자동으로 주입됩니다 (의존성 주입).
- 테스트 메시지를 AI에 보내고 응답을 표시합니다.

### 3. AI 서비스 계층 (FoundryLocalService.java)

**파일:** `src/main/java/com/example/FoundryLocalService.java`

#### 설정 주입:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```

**이 코드의 역할:**
- `@Service`는 Spring에게 이 클래스가 비즈니스 로직을 제공한다고 알립니다.
- `@Value`는 application.properties에서 설정 값을 주입합니다.
- `:default-value` 구문은 설정 값이 없을 경우 기본값을 제공합니다.

#### 클라이언트 초기화:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```

**이 코드의 역할:**
- `@PostConstruct`는 Spring이 서비스를 생성한 후 이 메서드를 실행합니다.
- OpenAI 클라이언트를 생성하여 로컬 Foundry Local 인스턴스에 연결합니다.
- `application.properties`의 base URL은 이미 OpenAI API 호환성을 위해 `/v1`을 포함합니다.
- 로컬 개발에서는 인증이 필요하지 않으므로 API 키를 "not-needed"로 설정합니다.

#### 채팅 메서드:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Which AI model to use
                .addUserMessage(message)         // Your question/prompt
                .maxCompletionTokens(150)        // Limit response length
                .temperature(0.7)                // Control creativity (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Extract the AI's response from the API result
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**이 코드의 역할:**
- **ChatCompletionCreateParams**: AI 요청을 구성합니다.
  - `model`: 사용할 AI 모델을 지정합니다 (정확한 ID는 `foundry model list`에서 확인해야 함).
  - `addUserMessage`: 대화에 메시지를 추가합니다.
  - `maxCompletionTokens`: 응답 길이를 제한하여 리소스를 절약합니다.
  - `temperature`: 무작위성을 제어합니다 (0.0 = 결정적, 1.0 = 창의적).
- **API 호출**: 요청을 Foundry Local에 보냅니다.
- **응답 처리**: AI의 텍스트 응답을 안전하게 추출합니다.
- **오류 처리**: 유용한 오류 메시지로 예외를 감싸서 처리합니다.

### 4. 프로젝트 종속성 (pom.xml)

**주요 종속성:**

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

**이 종속성의 역할:**
- **spring-boot-starter**: 핵심 Spring Boot 기능을 제공합니다.
- **openai-java**: OpenAI Java SDK를 사용하여 API 통신을 처리합니다.
- **jackson-databind**: API 호출을 위한 JSON 직렬화/역직렬화를 처리합니다.

## 전체 작동 방식

애플리케이션을 실행하면 다음과 같은 흐름으로 작동합니다:

1. **시작**: Spring Boot가 시작되고 `application.properties`를 읽습니다.
2. **서비스 생성**: Spring이 `FoundryLocalService`를 생성하고 설정 값을 주입합니다.
3. **클라이언트 설정**: `@PostConstruct`가 OpenAI 클라이언트를 초기화하여 Foundry Local에 연결합니다.
4. **데모 실행**: `CommandLineRunner`가 시작 후 실행됩니다.
5. **AI 호출**: 데모가 테스트 메시지로 `foundryLocalService.chat()`을 호출합니다.
6. **API 요청**: 서비스가 OpenAI 호환 요청을 Foundry Local에 보냅니다.
7. **응답 처리**: 서비스가 응답을 추출하고 반환합니다.
8. **표시**: 애플리케이션이 응답을 출력하고 종료합니다.

## Foundry Local 설정하기

Foundry Local을 설정하려면 다음 단계를 따르세요:

1. **Foundry Local 설치**: [사전 준비](../../../../04-PracticalSamples/foundrylocal) 섹션의 지침을 따르세요.

2. **동적으로 할당된 포트 확인**: Foundry Local은 시작 시 자동으로 포트를 할당합니다. 포트를 확인하려면 다음 명령어를 사용하세요:
   ```bash
   foundry service status
   ```
   
   **선택 사항**: 특정 포트(예: 5273)를 사용하려면 수동으로 설정할 수 있습니다:
   ```bash
   foundry service set --port 5273
   ```

3. **사용할 AI 모델 다운로드**: 예를 들어 `phi-3.5-mini` 모델을 다운로드하려면 다음 명령어를 사용하세요:
   ```bash
   foundry model run phi-3.5-mini
   ```

4. **application.properties 파일 구성**: Foundry Local 설정에 맞게 파일을 업데이트하세요:
   - `base-url`의 포트를 업데이트하세요 (2단계에서 확인한 포트 사용). 끝에 `/v1`을 포함해야 합니다.
   - 모델 이름을 버전 번호와 함께 업데이트하세요 (`foundry model list`로 확인).

   예시:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```

## 애플리케이션 실행하기

### 1단계: Foundry Local 시작
```bash
foundry model run phi-3.5-mini
```

### 2단계: 애플리케이션 빌드 및 실행
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## 예상 출력 결과

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi-3.5, a small language model created by Microsoft. I'm currently running 
as the Phi-3.5-mini-instruct model, which is designed to be helpful, harmless, and honest 
in my interactions. I can assist with a wide variety of tasks including answering 
questions, helping with analysis, creative writing, coding, and general conversation. 
Is there something specific you'd like help with today?
=========================
```

## 다음 단계

더 많은 예제를 보려면 [Chapter 04: Practical samples](../README.md)를 참조하세요.

## 문제 해결

### 일반적인 문제

**"Connection refused" 또는 "Service unavailable"**
- Foundry Local이 실행 중인지 확인하세요: `foundry model list`
- Foundry Local이 사용하는 실제 포트를 확인하세요: `foundry service status`
- `application.properties`를 올바른 포트로 업데이트하세요. URL 끝에 `/v1`이 포함되어야 합니다.
- 원하는 경우 특정 포트를 설정하세요: `foundry service set --port 5273`
- Foundry Local을 다시 시작해 보세요: `foundry model run phi-3.5-mini`

**"Model not found" 또는 "404 Not Found" 오류**
- 사용 가능한 모델과 정확한 ID를 확인하세요: `foundry model list`
- `application.properties`에서 모델 이름을 정확히 업데이트하세요. 버전 번호를 포함해야 합니다 (예: `Phi-3.5-mini-instruct-cuda-gpu:1`).
- `base-url` 끝에 `/v1`이 포함되어 있는지 확인하세요: `http://localhost:5273/v1`
- 필요한 경우 모델을 다운로드하세요: `foundry model run phi-3.5-mini`

**"400 Bad Request" 오류**
- base URL에 `/v1`이 포함되어 있는지 확인하세요: `http://localhost:5273/v1`
- 모델 ID가 `foundry model list`에 표시된 것과 정확히 일치하는지 확인하세요.
- 코드에서 `maxCompletionTokens()`를 사용하고 있는지 확인하세요 (더 이상 사용되지 않는 `maxTokens()`를 사용하지 마세요).

**Maven 컴파일 오류**
- Java 21 이상인지 확인하세요: `java -version`
- 클린 빌드 실행: `mvn clean compile`
- 종속성 다운로드를 위한 인터넷 연결을 확인하세요.

**애플리케이션이 시작되었지만 출력이 없음**
- Foundry Local이 응답하는지 확인하세요: `http://localhost:5273/v1/models`를 확인하거나 `foundry service status`를 실행하세요.
- 특정 오류 메시지를 확인하려면 애플리케이션 로그를 확인하세요.
- 모델이 완전히 로드되고 준비되었는지 확인하세요.

---

**면책 조항**:  
이 문서는 AI 번역 서비스 [Co-op Translator](https://github.com/Azure/co-op-translator)를 사용하여 번역되었습니다. 정확성을 위해 최선을 다하고 있지만, 자동 번역에는 오류나 부정확성이 포함될 수 있습니다. 원본 문서의 원어 버전을 권위 있는 출처로 간주해야 합니다. 중요한 정보의 경우, 전문적인 인간 번역을 권장합니다. 이 번역 사용으로 인해 발생하는 오해나 잘못된 해석에 대해 책임지지 않습니다.