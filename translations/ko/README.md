<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0efa90a880213da0aeb35e43ec717e98",
  "translation_date": "2025-12-01T08:24:25+00:00",
  "source_file": "README.md",
  "language_code": "ko"
}
-->
# 초보자를 위한 생성형 AI - Java 에디션
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![초보자를 위한 생성형 AI - Java 에디션](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.ko.png)

**소요 시간**: 워크숍 전체는 로컬 설정 없이 온라인으로 완료할 수 있습니다. 환경 설정은 2분이 소요되며, 샘플 탐색은 탐구 깊이에 따라 1~3시간이 필요합니다.

> **빠른 시작**

1. 이 저장소를 GitHub 계정으로 포크하세요.
2. **Code** → **Codespaces** 탭 → **...** → **New with options...**를 클릭하세요.
3. 기본값을 사용하세요 – 이 과정에 맞게 생성된 개발 컨테이너가 선택됩니다.
4. **Create codespace**를 클릭하세요.
5. 환경이 준비될 때까지 약 2분 기다리세요.
6. [첫 번째 예제](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)로 바로 이동하세요.

## 다국어 지원

### GitHub Action을 통한 지원 (자동화 및 항상 최신 상태)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[아랍어](../ar/README.md) | [벵골어](../bn/README.md) | [불가리아어](../bg/README.md) | [버마어 (미얀마)](../my/README.md) | [중국어 (간체)](../zh/README.md) | [중국어 (번체, 홍콩)](../hk/README.md) | [중국어 (번체, 마카오)](../mo/README.md) | [중국어 (번체, 대만)](../tw/README.md) | [크로아티아어](../hr/README.md) | [체코어](../cs/README.md) | [덴마크어](../da/README.md) | [네덜란드어](../nl/README.md) | [에스토니아어](../et/README.md) | [핀란드어](../fi/README.md) | [프랑스어](../fr/README.md) | [독일어](../de/README.md) | [그리스어](../el/README.md) | [히브리어](../he/README.md) | [힌디어](../hi/README.md) | [헝가리어](../hu/README.md) | [인도네시아어](../id/README.md) | [이탈리아어](../it/README.md) | [일본어](../ja/README.md) | [칸나다어](../kn/README.md) | [한국어](./README.md) | [리투아니아어](../lt/README.md) | [말레이어](../ms/README.md) | [말라얄람어](../ml/README.md) | [마라티어](../mr/README.md) | [네팔어](../ne/README.md) | [나이지리아 피진어](../pcm/README.md) | [노르웨이어](../no/README.md) | [페르시아어 (파르시)](../fa/README.md) | [폴란드어](../pl/README.md) | [포르투갈어 (브라질)](../br/README.md) | [포르투갈어 (포르투갈)](../pt/README.md) | [펀자브어 (구르무키)](../pa/README.md) | [루마니아어](../ro/README.md) | [러시아어](../ru/README.md) | [세르비아어 (키릴)](../sr/README.md) | [슬로바키아어](../sk/README.md) | [슬로베니아어](../sl/README.md) | [스페인어](../es/README.md) | [스와힐리어](../sw/README.md) | [스웨덴어](../sv/README.md) | [타갈로그어 (필리핀어)](../tl/README.md) | [타밀어](../ta/README.md) | [텔루구어](../te/README.md) | [태국어](../th/README.md) | [터키어](../tr/README.md) | [우크라이나어](../uk/README.md) | [우르두어](../ur/README.md) | [베트남어](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## 과정 구조 및 학습 경로

### **1장: 생성형 AI 소개**
- **핵심 개념**: 대규모 언어 모델, 토큰, 임베딩, AI 기능 이해
- **Java AI 생태계**: Spring AI 및 OpenAI SDK 개요
- **모델 컨텍스트 프로토콜**: MCP와 AI 에이전트 간 통신 역할 소개
- **실용적 응용**: 챗봇 및 콘텐츠 생성 등 실제 사례
- **[→ 1장 시작하기](./01-IntroToGenAI/README.md)**

### **2장: 개발 환경 설정**
- **다중 제공자 구성**: GitHub 모델, Azure OpenAI, OpenAI Java SDK 통합 설정
- **Spring Boot + Spring AI**: 엔터프라이즈 AI 애플리케이션 개발을 위한 모범 사례
- **GitHub 모델**: 프로토타입 및 학습을 위한 무료 AI 모델 액세스 (신용카드 불필요)
- **개발 도구**: Docker 컨테이너, VS Code, GitHub Codespaces 구성
- **[→ 2장 시작하기](./02-SetupDevEnvironment/README.md)**

### **3장: 핵심 생성형 AI 기술**
- **프롬프트 엔지니어링**: 최적의 AI 모델 응답을 위한 기술
- **임베딩 및 벡터 연산**: 의미 검색 및 유사성 매칭 구현
- **검색 증강 생성 (RAG)**: AI와 자체 데이터 소스 결합
- **함수 호출**: 사용자 정의 도구 및 플러그인으로 AI 기능 확장
- **[→ 3장 시작하기](./03-CoreGenerativeAITechniques/README.md)**

### **4장: 실용적 응용 및 프로젝트**
- **펫 스토리 생성기** (`petstory/`): GitHub 모델을 활용한 창의적 콘텐츠 생성
- **Foundry 로컬 데모** (`foundrylocal/`): OpenAI Java SDK를 활용한 로컬 AI 모델 통합
- **MCP 계산기 서비스** (`calculator/`): Spring AI를 활용한 기본 모델 컨텍스트 프로토콜 구현
- **[→ 4장 시작하기](./04-PracticalSamples/README.md)**

### **5장: 책임 있는 AI 개발**
- **GitHub 모델 안전성**: 내장 콘텐츠 필터링 및 안전 메커니즘 테스트 (강력 차단 및 부드러운 거부)
- **책임 있는 AI 데모**: 현대 AI 안전 시스템이 실제로 작동하는 방식에 대한 실습 예제
- **모범 사례**: 윤리적 AI 개발 및 배포를 위한 필수 지침
- **[→ 5장 시작하기](./05-ResponsibleGenAI/README.md)**

## 추가 자료

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### Azure / Edge / MCP / 에이전트
[![AZD for Beginners](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI for Beginners](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP for Beginners](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI Agents for Beginners](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### 생성형 AI 시리즈
[![Generative AI for Beginners](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---

### 핵심 학습
[![ML for Beginners](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Data Science for Beginners](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI for Beginners](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Cybersecurity for Beginners](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### Copilot 시리즈
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)  
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)  
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## 도움 받기

AI 앱을 개발하다가 막히거나 질문이 생기셨나요? MCP에 대해 배우는 동료 학습자들과 경험 많은 개발자들과 함께 토론에 참여하세요. 질문을 환영하고 지식을 자유롭게 공유하는 지원적인 커뮤니티입니다.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

제품 피드백을 제공하거나 개발 중 오류가 발생한 경우 아래를 방문하세요:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**면책 조항**:  
이 문서는 AI 번역 서비스 [Co-op Translator](https://github.com/Azure/co-op-translator)를 사용하여 번역되었습니다. 정확성을 위해 최선을 다하고 있지만, 자동 번역에는 오류나 부정확성이 포함될 수 있습니다. 원본 문서의 원어 버전이 권위 있는 출처로 간주되어야 합니다. 중요한 정보의 경우, 전문적인 인간 번역을 권장합니다. 이 번역 사용으로 인해 발생하는 오해나 잘못된 해석에 대해 책임을 지지 않습니다.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->