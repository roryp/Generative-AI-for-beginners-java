<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T09:07:24+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "ko"
}
-->
# 펫 스토리 앱

>**Note**: 이 장에는 샘플을 안내하는 [**튜토리얼**](./TUTORIAL.md)이 포함되어 있습니다.

GitHub Models를 사용하여 업로드된 반려동물 이미지에 대해 AI 기반 설명과 이야기를 생성하는 Spring Boot 웹 애플리케이션입니다.

## 목차

- [기술 스택](../../../../04-PracticalSamples/petstory)
- [사전 준비 사항](../../../../04-PracticalSamples/petstory)
- [설치 및 설정](../../../../04-PracticalSamples/petstory)
- [사용법](../../../../04-PracticalSamples/petstory)

## 기술 스택

- **백엔드**: Spring Boot 3.5.3, Java 21
- **AI 통합**: OpenAI Java SDK와 GitHub Models
- **보안**: Spring Security
- **프론트엔드**: Thymeleaf 템플릿과 Bootstrap 스타일링
- **빌드 도구**: Maven
- **AI 모델**: GitHub Models

## 사전 준비 사항

- Java 21 이상
- Maven 3.9+
- `models:read` 권한이 있는 GitHub 개인 액세스 토큰

## 설치 및 설정

### 1. petstory 애플리케이션 디렉토리로 이동
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. 환경 변수 설정
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. 애플리케이션 빌드
```bash
mvn clean compile
```

### 4. 애플리케이션 실행
```bash
mvn spring-boot:run
```

## 사용법

1. **애플리케이션 접속**: `http://localhost:8080`로 이동
2. **이미지 업로드**: "파일 선택"을 클릭하고 반려동물 이미지를 선택
3. **이미지 분석**: "이미지 분석"을 클릭하여 AI 설명 확인
4. **스토리 생성**: "스토리 생성"을 클릭하여 이야기를 생성

**면책 조항**:  
이 문서는 AI 번역 서비스 [Co-op Translator](https://github.com/Azure/co-op-translator)를 사용하여 번역되었습니다. 정확성을 위해 최선을 다하고 있지만, 자동 번역에는 오류나 부정확성이 포함될 수 있습니다. 원본 문서를 해당 언어로 작성된 상태에서 권위 있는 자료로 간주해야 합니다. 중요한 정보의 경우, 전문 번역가에 의한 번역을 권장합니다. 이 번역 사용으로 인해 발생하는 오해나 잘못된 해석에 대해 당사는 책임을 지지 않습니다.  