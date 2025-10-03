<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "afc90918d008cf77fd1982691f681306",
  "translation_date": "2025-10-03T08:31:27+00:00",
  "source_file": "AGENTS.md",
  "language_code": "ko"
}
-->
# AGENTS.md

## 프로젝트 개요

이 저장소는 Java를 사용한 생성형 AI 개발을 학습하기 위한 교육용 자료입니다. 대규모 언어 모델(LLMs), 프롬프트 엔지니어링, 임베딩, RAG(검색 증강 생성), 모델 컨텍스트 프로토콜(MCP)을 포괄적으로 다루는 실습형 강좌를 제공합니다.

**주요 기술:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI, OpenAI SDKs

**아키텍처:**
- 챕터별로 구성된 독립형 Spring Boot 애플리케이션
- 다양한 AI 패턴을 보여주는 샘플 프로젝트
- 사전 구성된 개발 컨테이너로 GitHub Codespaces 지원

## 설정 명령어

### 사전 요구사항
- Java 21 이상
- Maven 3.x
- GitHub 개인 액세스 토큰(GitHub Models용)
- 선택 사항: Azure OpenAI 자격 증명

### 환경 설정

**옵션 1: GitHub Codespaces (권장)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**옵션 2: 로컬 개발 컨테이너**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**옵션 3: 로컬 설정**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### 구성

**GitHub 토큰 설정:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Azure OpenAI 설정 (선택 사항):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## 개발 워크플로우

### 프로젝트 구조
```
/
├── 01-IntroToGenAI/              # Chapter 1: Introduction
├── 02-SetupDevEnvironment/       # Chapter 2: Environment setup
│   └── examples/                 # Working examples
├── 03-CoreGenerativeAITechniques/ # Chapter 3: Core techniques
├── 04-PracticalSamples/          # Chapter 4: Sample projects
│   ├── calculator/               # MCP service example
│   ├── foundrylocal/            # Local model integration
│   └── petstory/                # Multi-modal app
├── 05-ResponsibleGenAI/         # Chapter 5: Responsible AI
└── translations/                # Multi-language support
```

### 애플리케이션 실행

**Spring Boot 애플리케이션 실행:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**프로젝트 빌드:**
```bash
cd [project-directory]
mvn clean install
```

**MCP 계산기 서버 시작:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**클라이언트 예제 실행:**
```bash
# After starting the server in another terminal
cd 04-PracticalSamples/calculator

# Direct MCP client
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient"

# AI-powered client (requires GITHUB_TOKEN)
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient"

# Interactive bot
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.Bot"
```

### 핫 리로드
Spring Boot DevTools는 핫 리로드를 지원하는 프로젝트에 포함되어 있습니다:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## 테스트 지침

### 테스트 실행

**프로젝트의 모든 테스트 실행:**
```bash
cd [project-directory]
mvn test
```

**상세 출력으로 테스트 실행:**
```bash
mvn test -X
```

**특정 테스트 클래스 실행:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### 테스트 구조
- 테스트 파일은 JUnit 5(Jupiter)를 사용합니다.
- 테스트 클래스는 `src/test/java/`에 위치합니다.
- 계산기 프로젝트의 클라이언트 예제는 `src/test/java/com/microsoft/mcp/sample/client/`에 있습니다.

### 수동 테스트
많은 예제는 상호작용 애플리케이션으로 수동 테스트가 필요합니다:

1. `mvn spring-boot:run`으로 애플리케이션 시작
2. 엔드포인트 테스트 또는 CLI와 상호작용
3. 각 프로젝트의 README.md에 문서화된 예상 동작 확인

### GitHub Models로 테스트
- 무료 등급 제한: 15 요청/분, 150 요청/일
- 최대 5개의 동시 요청
- 책임 있는 AI 예제를 사용하여 콘텐츠 필터링 테스트

## 코드 스타일 지침

### Java 규칙
- **Java 버전:** 최신 기능을 포함한 Java 21
- **스타일:** 표준 Java 규칙 준수
- **명명 규칙:** 
  - 클래스: PascalCase
  - 메서드/변수: camelCase
  - 상수: UPPER_SNAKE_CASE
  - 패키지 이름: 소문자

### Spring Boot 패턴
- 비즈니스 로직에는 `@Service` 사용
- REST 엔드포인트에는 `@RestController` 사용
- `application.yml` 또는 `application.properties`를 통한 구성
- 하드코딩 값 대신 환경 변수를 선호
- MCP에 노출된 메서드에는 `@Tool` 어노테이션 사용

### 파일 구성
```
src/
├── main/
│   ├── java/
│   │   └── com/microsoft/[component]/
│   │       ├── [Component]Application.java
│   │       ├── config/
│   │       ├── controller/
│   │       ├── service/
│   │       └── exception/
│   └── resources/
│       ├── application.yml
│       └── static/
└── test/
    └── java/
        └── com/microsoft/[component]/
```

### 종속성
- Maven `pom.xml`로 관리
- Spring AI BOM을 사용한 버전 관리
- LangChain4j를 통한 AI 통합
- Spring Boot starter parent로 Spring 종속성 관리

### 코드 주석
- 공개 API에 JavaDoc 추가
- 복잡한 AI 상호작용에 대한 설명 주석 포함
- MCP 도구 설명을 명확히 문서화

## 빌드 및 배포

### 프로젝트 빌드

**테스트 없이 빌드:**
```bash
mvn clean install -DskipTests
```

**모든 체크 포함 빌드:**
```bash
mvn clean install
```

**애플리케이션 패키징:**
```bash
mvn package
# Creates JAR in target/ directory
```

### 출력 디렉토리
- 컴파일된 클래스: `target/classes/`
- 테스트 클래스: `target/test-classes/`
- JAR 파일: `target/*.jar`
- Maven 아티팩트: `target/`

### 환경별 구성

**개발 환경:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**프로덕션 환경:**
- GitHub Models 대신 Azure AI Foundry Models 사용
- base-url을 Azure OpenAI 엔드포인트로 업데이트
- Azure Key Vault 또는 환경 변수를 통해 비밀 관리

### 배포 고려사항
- 이 저장소는 샘플 애플리케이션을 포함한 교육용 자료입니다.
- 현재 상태로는 프로덕션 배포에 적합하지 않습니다.
- 샘플은 프로덕션에 맞게 조정할 수 있는 패턴을 보여줍니다.
- 개별 프로젝트 README에서 특정 배포 노트를 확인하세요.

## 추가 참고 사항

### GitHub Models vs Azure OpenAI
- **GitHub Models:** 학습용 무료 등급, 신용카드 불필요
- **Azure OpenAI:** 프로덕션 준비 완료, Azure 구독 필요
- 두 플랫폼 간 코드 호환 가능 - 엔드포인트와 API 키만 변경

### 여러 프로젝트 작업
각 샘플 프로젝트는 독립형입니다:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### 일반적인 문제

**Java 버전 불일치:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**종속성 다운로드 문제:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub 토큰을 찾을 수 없음:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**포트가 이미 사용 중:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### 다국어 지원
- 자동 번역을 통해 45개 이상의 언어로 문서 제공
- 번역은 `translations/` 디렉토리에 저장
- GitHub Actions 워크플로우로 번역 관리

### 학습 경로
1. [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)부터 시작
2. 챕터 순서대로 진행 (01 → 05)
3. 각 챕터의 실습 예제 완료
4. 챕터 4의 샘플 프로젝트 탐색
5. 챕터 5에서 책임 있는 AI 실습 학습

### 개발 컨테이너
`.devcontainer/devcontainer.json`은 다음을 구성합니다:
- Java 21 개발 환경
- Maven 사전 설치
- VS Code Java 확장
- Spring Boot 도구
- GitHub Copilot 통합
- Docker-in-Docker 지원
- Azure CLI

### 성능 고려사항
- GitHub Models 무료 등급은 속도 제한이 있음
- 임베딩에 적합한 배치 크기 사용
- 반복 API 호출에 캐싱 고려
- 비용 최적화를 위한 토큰 사용 모니터링

### 보안 참고 사항
- `.env` 파일을 절대 커밋하지 않음 (`.gitignore`에 이미 포함됨)
- API 키는 환경 변수를 사용
- GitHub 토큰은 최소한의 필요한 범위로 설정
- 챕터 5의 책임 있는 AI 지침 준수

---

**면책 조항**:  
이 문서는 AI 번역 서비스 [Co-op Translator](https://github.com/Azure/co-op-translator)를 사용하여 번역되었습니다. 정확성을 위해 최선을 다하고 있으나, 자동 번역에는 오류나 부정확성이 포함될 수 있습니다. 원본 문서의 원어 버전이 권위 있는 출처로 간주되어야 합니다. 중요한 정보의 경우, 전문적인 인간 번역을 권장합니다. 이 번역 사용으로 인해 발생하는 오해나 잘못된 해석에 대해 당사는 책임을 지지 않습니다.