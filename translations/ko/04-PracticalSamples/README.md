# 실용적인 응용 프로그램 및 프로젝트

[![실용적인 응용 프로그램 및 프로젝트](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "실용적인 응용 프로그램 및 프로젝트")

> **비디오 개요:** [YouTube에서 "실용적인 응용 프로그램 및 프로젝트" 시청하기](https://www.youtube.com/watch?v=01vJsYei3H0).

## 학습 내용
이 섹션에서는 Java로 생성형 AI 개발 패턴을 보여주는 세 가지 실용적인 응용 프로그램을 시연합니다:
- 클라이언트 측과 서버 측 AI를 결합한 다중 양식 반려동물 이야기 생성기 만들기
- Foundry Local Spring Boot 데모로 로컬 AI 모델 통합 구현하기
- 계산기 예제로 모델 컨텍스트 프로토콜(MCP) 서비스 개발하기

## 목차

- [소개](#소개)
  - [Foundry Local Spring Boot 데모](#foundry-local-spring-boot-데모)
  - [반려동물 이야기 생성기](#반려동물-이야기-생성기)
  - [MCP 계산기 서비스 (초보자 친화적인 MCP 데모)](#mcp-계산기-서비스-초보자-친화적인-mcp-데모)
- [학습 진행](#학습-진행)
- [요약](#요약)
- [다음 단계](#다음-단계)

## 소개

이 장에서는 Java로 생성형 AI 개발 패턴을 보여주는 <strong>샘플 프로젝트</strong>를 소개합니다. 각 프로젝트는 완전한 기능을 갖추고 있으며, 특정 AI 기술, 아키텍처 패턴 및 모범 사례를 보여주어 여러분이 자신의 응용 프로그램에 적용할 수 있습니다.

### Foundry Local Spring Boot 데모

<strong>[Foundry Local Spring Boot 데모](foundrylocal/README.md)</strong>는 <strong>OpenAI Java SDK</strong>를 사용하여 로컬 AI 모델과 통합하는 방법을 보여줍니다. Foundry Local에서 실행되는 **Phi-3.5-mini** 모델에 연결하는 방법을 시연하여 클라우드 서비스에 의존하지 않고 AI 응용 프로그램을 실행할 수 있습니다.

### 반려동물 이야기 생성기

<strong>[반려동물 이야기 생성기](petstory/README.md)</strong>는 창의적인 반려동물 이야기를 생성하는 <strong>다중 양식 AI 처리</strong>를 보여주는 흥미로운 Spring Boot 웹 응용 프로그램입니다. transformer.js를 사용해 브라우저 기반 AI 상호작용과 OpenAI SDK를 통한 서버 사이드 처리를 결합합니다.

### MCP 계산기 서비스 (초보자 친화적인 MCP 데모)

<strong>[MCP 계산기 서비스](calculator/README.md)</strong>는 Spring AI를 사용한 <strong>모델 컨텍스트 프로토콜(MCP)</strong>의 간단한 시연입니다. MCP 개념을 초보자도 쉽게 이해할 수 있도록 기본 MCP 서버를 생성하고 MCP 클라이언트와 상호작용하는 방법을 보여줍니다.

## 학습 진행

이 프로젝트들은 이전 장의 개념을 기반으로 구성되었습니다:

1. **간단하게 시작하기**: Foundry Local Spring Boot 데모로 로컬 모델과 기본 AI 통합 이해하기
2. **상호작용 추가하기**: 반려동물 이야기 생성기로 다중 양식 AI 및 웹 기반 상호작용 경험하기
3. **MCP 기본 배우기**: MCP 계산기 서비스로 모델 컨텍스트 프로토콜 기본 개념 익히기

## 요약

잘 하셨습니다! 이제 실제 응용 프로그램을 탐색했습니다:

- 브라우저와 서버 양쪽에서 작동하는 다중 양식 AI 경험
- 현대 Java 프레임워크와 SDK를 사용한 로컬 AI 모델 통합
- 도구가 AI와 통합되는 방식을 살펴보는 첫 번째 모델 컨텍스트 프로토콜 서비스

## 다음 단계

[5장: 책임 있는 생성형 AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**면책 조항**:  
이 문서는 AI 번역 서비스 [Co-op Translator](https://github.com/Azure/co-op-translator)를 사용하여 번역되었습니다. 정확성을 위해 노력하고 있지만, 자동 번역 결과에 오류나 부정확성이 포함될 수 있음을 알려드립니다. 원본 문서의 원어 버전을 권위 있는 자료로 간주해야 합니다. 중요한 정보의 경우 전문 인간 번역을 권장합니다. 본 번역 사용으로 인해 발생하는 오해나 잘못된 해석에 대해서는 책임을 지지 않습니다.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->