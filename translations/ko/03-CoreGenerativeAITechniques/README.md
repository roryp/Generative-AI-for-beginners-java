<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T16:02:01+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "ko"
}
-->
# 핵심 생성 AI 기술

>**Note**: 이 챕터에는 완성된 샘플을 실행하는 방법을 안내하는 자세한 [**튜토리얼**](./TUTORIAL.md)이 포함되어 있습니다.

## 학습 내용
이 챕터에서는 실용적인 예제를 통해 4가지 핵심 생성 AI 기술을 살펴봅니다:
- LLM 완성과 채팅 흐름
- 함수 호출
- 검색 증강 생성(RAG)
- 책임 있는 AI 안전 조치

## 목차

- [학습 내용](../../../03-CoreGenerativeAITechniques)
- [사전 준비](../../../03-CoreGenerativeAITechniques)
- [시작하기](../../../03-CoreGenerativeAITechniques)
- [예제 개요](../../../03-CoreGenerativeAITechniques)
  - [1. LLM 완성과 채팅 흐름](../../../03-CoreGenerativeAITechniques)
  - [2. LLM을 활용한 함수 및 플러그인](../../../03-CoreGenerativeAITechniques)
  - [3. 검색 증강 생성(RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. 책임 있는 AI 안전 데모](../../../03-CoreGenerativeAITechniques)
- [요약](../../../03-CoreGenerativeAITechniques)
- [다음 단계](../../../03-CoreGenerativeAITechniques)

## 사전 준비

- [챕터 2](../../../02-SetupDevEnvironment)에서 설정 완료

## 시작하기

1. **예제 폴더로 이동**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **환경 설정**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **예제 컴파일 및 실행**:  
```bash
   # Run completions example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
   
   # Run functions example  
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
   
   # Run RAG example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
   
   # Run responsible AI demo
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
   ```  

## 예제 개요

예제는 `examples/` 폴더에 다음과 같은 구조로 구성되어 있습니다:

```
examples/
├── src/main/java/com/example/genai/techniques/
│   ├── completions/
│   │   └── LLMCompletionsApp.java        # Basic completions 
│   ├── functions/
│   │   └── FunctionsApp.java             # Function calling examples
│   ├── rag/
│   │   └── SimpleReaderDemo.java         # Retrieval-Augmented Generation
│   └── responsibleai/
│       └── ResponsibleGithubModels.java  # Responsible AI safety demonstration
├── document.txt                          # Sample document for RAG example
└── pom.xml                               # Maven configuration
```  

### 1. LLM 완성과 채팅 흐름
**파일**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

스트리밍 응답과 채팅 기록 관리를 통해 대화형 AI를 구축하는 방법을 배웁니다.

이 예제에서는 다음을 다룹니다:
- 시스템 프롬프트를 활용한 간단한 텍스트 완성
- 기록 관리를 포함한 다중 턴 대화
- 대화형 채팅 세션
- 매개변수 설정(온도, 최대 토큰 수)

### 2. LLM을 활용한 함수 및 플러그인
**파일**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

모델에 사용자 정의 함수와 외부 API를 연결하여 AI 기능을 확장합니다.

이 예제에서는 다음을 다룹니다:
- 날씨 함수 통합
- 계산기 함수 구현  
- 하나의 대화에서 여러 함수 호출
- JSON 스키마를 활용한 함수 정의

### 3. 검색 증강 생성(RAG)
**파일**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

AI를 사용자 문서 및 데이터 소스와 결합하여 정확하고 맥락에 맞는 응답을 생성하는 방법을 배웁니다.

이 예제에서는 다음을 다룹니다:
- Azure OpenAI SDK를 활용한 문서 기반 질문 응답
- GitHub 모델을 활용한 RAG 패턴 구현

**사용법**: `document.txt`의 내용을 기반으로 질문을 하고 해당 맥락에만 의존한 AI 응답을 받습니다.

### 4. 책임 있는 AI 안전 데모
**파일**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

GitHub 모델의 콘텐츠 필터링 기능을 테스트하여 AI 안전 조치가 작동하는 방식을 미리 살펴봅니다.

이 예제에서는 다음을 다룹니다:
- 잠재적으로 유해한 프롬프트에 대한 콘텐츠 필터링
- 애플리케이션에서 안전 응답 처리
- 차단된 콘텐츠의 다양한 카테고리(폭력, 증오 발언, 허위 정보)
- 안전 위반에 대한 적절한 오류 처리

> **자세히 알아보기**: 이는 책임 있는 AI 개념에 대한 간단한 소개입니다. 윤리, 편향 완화, 개인정보 보호 고려사항, 책임 있는 AI 프레임워크에 대한 자세한 내용은 [챕터 5: 책임 있는 생성 AI](../05-ResponsibleGenAI/README.md)를 참조하세요.

## 요약

이 챕터에서는 LLM 완성과 채팅 흐름을 탐구하고, AI 기능을 확장하기 위해 함수 호출을 구현했으며, 검색 증강 생성(RAG) 시스템을 구축하고, 책임 있는 AI 안전 조치를 시연했습니다.

> **NOTE**: 제공된 [**튜토리얼**](./TUTORIAL.md)을 통해 더 깊이 탐구하세요.

## 다음 단계

[챕터 4: 실용적인 응용 및 프로젝트](../04-PracticalSamples/README.md)

**면책 조항**:  
이 문서는 AI 번역 서비스 [Co-op Translator](https://github.com/Azure/co-op-translator)를 사용하여 번역되었습니다. 정확성을 위해 최선을 다하고 있지만, 자동 번역에는 오류나 부정확성이 포함될 수 있습니다. 원본 문서를 해당 언어로 작성된 상태에서 권위 있는 자료로 간주해야 합니다. 중요한 정보의 경우, 전문적인 인간 번역을 권장합니다. 이 번역 사용으로 인해 발생하는 오해나 잘못된 해석에 대해 당사는 책임을 지지 않습니다.