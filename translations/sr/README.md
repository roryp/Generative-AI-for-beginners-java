<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "4d04ae8088f6a3c3fcbab18cbdfe4002",
  "translation_date": "2025-10-03T08:20:49+00:00",
  "source_file": "README.md",
  "language_code": "sr"
}
-->
# Генеративна вештачка интелигенција за почетнике - Јава издање
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Генеративна вештачка интелигенција за почетнике - Јава издање](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.sr.png)

**Време потребно**: Цео радионица може се завршити онлајн без локалног подешавања. Постављање окружења траје 2 минута, док истраживање примера захтева 1-3 сата, у зависности од дубине истраживања.

> **Брзи почетак**

1. Форкујте овај репозиторијум на свој GitHub налог
2. Кликните **Code** → **Codespaces** таб → **...** → **New with options...**
3. Користите подразумеване опције – ово ће изабрати Development container креиран за овај курс
4. Кликните **Create codespace**
5. Сачекајте ~2 минута да окружење буде спремно
6. Пређите директно на [Први пример](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Подршка за више језика

### Подржано преко GitHub Action (аутоматски и увек ажурирано)

[Француски](../fr/README.md) | [Шпански](../es/README.md) | [Немачки](../de/README.md) | [Руски](../ru/README.md) | [Арапски](../ar/README.md) | [Персијски (Фарси)](../fa/README.md) | [Урду](../ur/README.md) | [Кинески (поједностављени)](../zh/README.md) | [Кинески (традиционални, Макао)](../mo/README.md) | [Кинески (традиционални, Хонг Конг)](../hk/README.md) | [Кинески (традиционални, Тајван)](../tw/README.md) | [Јапански](../ja/README.md) | [Корејски](../ko/README.md) | [Хинди](../hi/README.md) | [Бенгалски](../bn/README.md) | [Марати](../mr/README.md) | [Непалски](../ne/README.md) | [Пенџабски (Гурмуки)](../pa/README.md) | [Португалски (Португалија)](../pt/README.md) | [Португалски (Бразил)](../br/README.md) | [Италијански](../it/README.md) | [Пољски](../pl/README.md) | [Турски](../tr/README.md) | [Грчки](../el/README.md) | [Тајландски](../th/README.md) | [Шведски](../sv/README.md) | [Дански](../da/README.md) | [Норвешки](../no/README.md) | [Фински](../fi/README.md) | [Холандски](../nl/README.md) | [Хебрејски](../he/README.md) | [Вијетнамски](../vi/README.md) | [Индонежански](../id/README.md) | [Малајски](../ms/README.md) | [Тагалог (Филипински)](../tl/README.md) | [Свахили](../sw/README.md) | [Мађарски](../hu/README.md) | [Чешки](../cs/README.md) | [Словачки](../sk/README.md) | [Румунски](../ro/README.md) | [Бугарски](../bg/README.md) | [Српски (Ћирилица)](./README.md) | [Хрватски](../hr/README.md) | [Словеначки](../sl/README.md) | [Украјински](../uk/README.md) | [Бурмански (Мјанмар)](../my/README.md)

## Структура курса и пут учења

### **Поглавље 1: Увод у генеративну вештачку интелигенцију**
- **Основни концепти**: Разумевање великих језичких модела, токена, уграђивања и могућности вештачке интелигенције
- **Јава AI екосистем**: Преглед Spring AI и OpenAI SDK-ова
- **Протокол контекста модела**: Увод у MCP и његову улогу у комуникацији AI агената
- **Практичне примене**: Реални сценарији укључујући четботове и генерисање садржаја
- **[→ Почните Поглавље 1](./01-IntroToGenAI/README.md)**

### **Поглавље 2: Постављање развојног окружења**
- **Конфигурација за више провајдера**: Поставите GitHub моделе, Azure OpenAI и OpenAI Java SDK интеграције
- **Spring Boot + Spring AI**: Најбоље праксе за развој AI апликација за предузећа
- **GitHub модели**: Бесплатан приступ AI моделима за прототипе и учење (без потребе за кредитном картицом)
- **Развојни алати**: Конфигурација Docker контејнера, VS Code-а и GitHub Codespaces-а
- **[→ Почните Поглавље 2](./02-SetupDevEnvironment/README.md)**

### **Поглавље 3: Основне технике генеративне вештачке интелигенције**
- **Инжењеринг упита**: Технике за оптималне одговоре AI модела
- **Уграђивања и векторске операције**: Имплементација семантичке претраге и упоређивања сличности
- **Генерација уз помоћ претраживања (RAG)**: Комбинујте AI са сопственим изворима података
- **Позивање функција**: Проширите могућности AI-а помоћу прилагођених алата и додатака
- **[→ Почните Поглавље 3](./03-CoreGenerativeAITechniques/README.md)**

### **Поглавље 4: Практичне примене и пројекти**
- **Генератор прича о кућним љубимцима** (`petstory/`): Креативно генерисање садржаја помоћу GitHub модела
- **Foundry локална демонстрација** (`foundrylocal/`): Локална интеграција AI модела са OpenAI Java SDK-ом
- **MCP услуга калкулатора** (`calculator/`): Основна имплементација Протокола контекста модела са Spring AI
- **[→ Почните Поглавље 4](./04-PracticalSamples/README.md)**

### **Поглавље 5: Одговорни развој вештачке интелигенције**
- **Безбедност GitHub модела**: Тестирајте уграђено филтрирање садржаја и механизме безбедности (тврде блокаде и меко одбијање)
- **Демонстрација одговорне AI**: Практичан пример који показује како модерни системи безбедности AI функционишу у пракси
- **Најбоље праксе**: Основне смернице за етички развој и примену AI-а
- **[→ Почните Поглавље 5](./05-ResponsibleGenAI/README.md)**

## Додатни ресурси

- [Edge AI за почетнике](https://github.com/microsoft/edgeai-for-beginners)
- [MCP за почетнике](https://github.com/microsoft/mcp-for-beginners)
- [AI агенти за почетнике](https://github.com/microsoft/ai-agents-for-beginners)
- [Генеративна вештачка интелигенција за почетнике користећи .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Генеративна вештачка интелигенција за почетнике користећи JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Генеративна вештачка интелигенција за почетнике](https://github.com/microsoft/generative-ai-for-beginners)
- [Машинско учење за почетнике](https://aka.ms/ml-beginners)
- [Наука о подацима за почетнике](https://aka.ms/datascience-beginners)
- [Вештачка интелигенција за почетнике](https://aka.ms/ai-beginners)
- [Сајбер безбедност за почетнике](https://github.com/microsoft/Security-101)
- [Веб развој за почетнике](https://aka.ms/webdev-beginners)
- [IoT за почетнике](https://aka.ms/iot-beginners)
- [XR развој за почетнике](https://github.com/microsoft/xr-development-for-beginners)
- [Усавршавање GitHub Copilot-а за парно програмирање са AI-ом](https://aka.ms/GitHubCopilotAI)
- [Усавршавање GitHub Copilot-а за C#/.NET програмере](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Изаберите своју авантуру са Copilot-ом](https://github.com/microsoft/CopilotAdventures)
- [RAG чет апликација са Azure AI услугама](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## Добијање помоћи

Ако се заглавите или имате питања о изградњи AI апликација, придружите се:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Ако имате повратне информације о производу или грешке током изградње, посетите:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**Одрицање од одговорности**:  
Овај документ је преведен коришћењем услуге за превођење помоћу вештачке интелигенције [Co-op Translator](https://github.com/Azure/co-op-translator). Иако се трудимо да превод буде тачан, молимо вас да имате у виду да аутоматски преводи могу садржати грешке или нетачности. Оригинални документ на изворном језику треба сматрати ауторитативним извором. За критичне информације препоручује се професионални превод од стране људи. Не преузимамо одговорност за било каква погрешна тумачења или неспоразуме који могу настати услед коришћења овог превода.