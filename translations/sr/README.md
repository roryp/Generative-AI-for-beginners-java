# Генеративна AI за почетнике - Јава издање
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/sr/beg-genai-series.8b48be9951cc574c.webp)

**Време трајања**: Цео радионицa се може завршити онлајн без локалне поставке. Постављање окружења траје 2 минута, а истраживање примера захтева 1-3 сата у зависности од дубине истраживања.

> **Брз почетак** 

1. Форкујте овај репозиторијум на свој GitHub налог
2. Кликните **Code** → картица **Codespaces** → **...** → **New with options...**
3. Користите подразумеване опције – ово ће изабрати Development контејнер креиран за овај курс
4. Кликните **Create codespace**
5. Сачекајте ~2 минута док окружење не буде спремно
6. Одмах пређите на [Први пример](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **Више волите локално клонирање?**
>
> Овај репозиторијум садржи више од 50 превода језика што знатно повећава величину преузимања. Да бисте клонирали без превода, користите sparse checkout:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> Ово вам даје све што вам је потребно за завршетак курса са знатно бржим преузимањем.


## Подршка за више језика

### Подржано путем GitHub Action (Аутоматизовано и увек ажурно)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[арапски](../ar/README.md) | [бенгалски](../bn/README.md) | [бугарски](../bg/README.md) | [бирмански (Мјанмар)](../my/README.md) | [кинески (поједностављени)](../zh-CN/README.md) | [кинески (традиционални, Хонг Конг)](../zh-HK/README.md) | [кинески (традиционални, Макао)](../zh-MO/README.md) | [кинески (традиционални, Тајван)](../zh-TW/README.md) | [хрватски](../hr/README.md) | [чешки](../cs/README.md) | [дански](../da/README.md) | [холандски](../nl/README.md) | [естонски](../et/README.md) | [фински](../fi/README.md) | [француски](../fr/README.md) | [немачки](../de/README.md) | [грчки](../el/README.md) | [хебрејски](../he/README.md) | [хинди](../hi/README.md) | [мађарски](../hu/README.md) | [индонежански](../id/README.md) | [италијански](../it/README.md) | [јапански](../ja/README.md) | [каннада](../kn/README.md) | [корејски](../ko/README.md) | [литвански](../lt/README.md) | [малајски](../ms/README.md) | [малајалам](../ml/README.md) | [маратхи](../mr/README.md) | [непалски](../ne/README.md) | [нигеријски пидгин](../pcm/README.md) | [норвешки](../no/README.md) | [персијски (фарси)](../fa/README.md) | [пољски](../pl/README.md) | [португалски (Бразил)](../pt-BR/README.md) | [португалски (Португалија)](../pt-PT/README.md) | [пунџаби (Гурмуки)](../pa/README.md) | [румунски](../ro/README.md) | [руски](../ru/README.md) | [српски (ћирилица)](./README.md) | [словачки](../sk/README.md) | [словеначки](../sl/README.md) | [шпански](../es/README.md) | [свахили](../sw/README.md) | [шведски](../sv/README.md) | [тагалог (филипински)](../tl/README.md) | [тамилски](../ta/README.md) | [телугу](../te/README.md) | [тајландски](../th/README.md) | [турски](../tr/README.md) | [украјински](../uk/README.md) | [урду](../ur/README.md) | [вијетнамски](../vi/README.md)

## Структура курса и пут учења

### **Поглавље 1: Увод у генеративну AI**
- **Основни концепти**: Разумевање великих језичких модела, токена, угравирања и AI капацитета
- **Java AI екосистем**: Преглед Spring AI и OpenAI SDK-ова
- **Протокол контекста модела**: Увод у MCP и његова улога у комуникацији AI агената
- **Практичне примене**: Ситуације из стварног света укључујући четботове и генерисање садржаја
- **[→ Почни поглавље 1](./01-IntroToGenAI/README.md)**

### **Поглавље 2: Постављање развојног окружења**
- **Мулти-пробаверска конфигурација**: Подешавање GitHub модела, Azure OpenAI и OpenAI Java SDK интеграција
- **Spring Boot + Spring AI**: Најбоље праксе за развој ентерпрајс AI апликација
- **GitHub модели**: Бесплатан приступ AI моделима за прототиповање и учење (без кредитне картице)
- **Развојни алати**: Docker контејнери, VS Code и GitHub Codespaces конфигурација
- **[→ Почни поглавље 2](./02-SetupDevEnvironment/README.md)**

### **Поглавље 3: Основне технике генеративне AI**
- **Prompt инженеринг**: Технике за оптималне одговоре AI модела
- **Угравирања и операције над векторима**: Имплементација семантичке претраге и подударања сличности
- **Retrieval-Augmented Generation (RAG)**: Комбинација AI са сопственим изворима података
- **Позив функција**: Проширите AI могућности уз помоћ прилагођених алата и додатака
- **[→ Почни поглавље 3](./03-CoreGenerativeAITechniques/README.md)**

### **Поглавље 4: Практичне примене и пројекти**
- **Генератор прича о кућним љубимцима** (`petstory/`): Креативно генерисање садржаја са GitHub моделима
- **Foundry локална демонстрација** (`foundrylocal/`): Локална интеграција AI модела преко OpenAI Java SDK
- **MCP сервис за калкулатор** (`calculator/`): Основна имплементација протокола модела контекста са Spring AI
- **[→ Почни поглавље 4](./04-PracticalSamples/README.md)**

### **Поглавље 5: Одговоран развој AI**
- **GitHub модели безбедности**: Тестирање уграђене филтрације садржаја и механизама безбедности (чврсти блокови и меке одбијености)
- **Демо одговорног AI**: Практични пример показујући како савремени системи безбедности AI функционишу у пракси
- **Најбоље праксе**: Основне смернице за етички развој и имплементацију AI
- **[→ Почни поглавље 5](./05-ResponsibleGenAI/README.md)**

## Додатни ресурси

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j за почетнике](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js за почетнике](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)
[![LangChain за почетнике](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)
---

### Azure / Edge / MCP / Агенти
[![AZD за почетнике](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI за почетнике](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP за почетнике](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI агенти за почетнике](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Серия Генеративне AI
[![Генеративна AI за почетнике](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Генеративна AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Генеративна AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Генеративна AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### Основно учење
[![Машинско учење за почетнике](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Наука о подацима за почетнике](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI за почетнике](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Cybersecurity за почетнике](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Серия Copilot
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## Добијање помоћи

Ако запнете или имате питања о изградњи AI апликација. Придружите се другим ученицима и искусним програмерима у дискусијама о MCP. То је подржавајућа заједница у којој су питања добродошла и знање се слободно дели.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

Ако имате повратне информације о производу или грешке током изградње посетите:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Одрицање од одговорности**:  
Овај документ је преведен коришћењем АИ услуге за превођење [Co-op Translator](https://github.com/Azure/co-op-translator). Иако тежимо тачности, молимо Вас да имате у виду да аутоматски преводи могу садржати грешке или нетачности. Изворни документ на његовом изворном језику треба сматрати ауторитетним извором. За критичне информације препоручује се професионални људски превод. Нисмо одговорни за било каква неспоразума или погрешне тумачење која произилазе из употребе овог превода.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->