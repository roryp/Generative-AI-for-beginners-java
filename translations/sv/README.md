<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "90ac762d40c6db51b8081cdb3e49e9db",
  "translation_date": "2025-08-28T21:41:44+00:00",
  "source_file": "README.md",
  "language_code": "sv"
}
-->
# Generativ AI för Nybörjare - Java Edition
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generativ AI för Nybörjare - Java Edition](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.sv.png)

**Tidsåtgång**: Hela workshopen kan genomföras online utan lokal installation. Miljöinställningen tar 2 minuter, och att utforska exemplen tar 1-3 timmar beroende på hur djupt du vill gå.

> **Snabbstart**

1. Forka detta repository till ditt GitHub-konto
2. Klicka på **Code** → fliken **Codespaces** → **...** → **New with options...**
3. Använd standardinställningarna – detta väljer utvecklingscontainern som skapats för denna kurs
4. Klicka på **Create codespace**
5. Vänta ~2 minuter tills miljön är redo
6. Gå direkt till [Det första exemplet](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Stöd för flera språk

### Stöds via GitHub Action (Automatiserat & Alltid Uppdaterat)

[Franska](../fr/README.md) | [Spanska](../es/README.md) | [Tyska](../de/README.md) | [Ryska](../ru/README.md) | [Arabiska](../ar/README.md) | [Persiska (Farsi)](../fa/README.md) | [Urdu](../ur/README.md) | [Kinesiska (Förenklad)](../zh/README.md) | [Kinesiska (Traditionell, Macau)](../mo/README.md) | [Kinesiska (Traditionell, Hongkong)](../hk/README.md) | [Kinesiska (Traditionell, Taiwan)](../tw/README.md) | [Japanska](../ja/README.md) | [Koreanska](../ko/README.md) | [Hindi](../hi/README.md) | [Bengali](../bn/README.md) | [Marathi](../mr/README.md) | [Nepalesiska](../ne/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Portugisiska (Portugal)](../pt/README.md) | [Portugisiska (Brasilien)](../br/README.md) | [Italienska](../it/README.md) | [Polska](../pl/README.md) | [Turkiska](../tr/README.md) | [Grekiska](../el/README.md) | [Thailändska](../th/README.md) | [Svenska](./README.md) | [Danska](../da/README.md) | [Norska](../no/README.md) | [Finska](../fi/README.md) | [Nederländska](../nl/README.md) | [Hebreiska](../he/README.md) | [Vietnamesiska](../vi/README.md) | [Indonesiska](../id/README.md) | [Malajiska](../ms/README.md) | [Tagalog (Filippinska)](../tl/README.md) | [Swahili](../sw/README.md) | [Ungerska](../hu/README.md) | [Tjeckiska](../cs/README.md) | [Slovakiska](../sk/README.md) | [Rumänska](../ro/README.md) | [Bulgariska](../bg/README.md) | [Serbiska (Kyrilliska)](../sr/README.md) | [Kroatiska](../hr/README.md) | [Slovenska](../sl/README.md) | [Ukrainska](../uk/README.md) | [Burmesiska (Myanmar)](../my/README.md)

## Kursstruktur & Inlärningsväg

### **Kapitel 1: Introduktion till Generativ AI**
- **Grundläggande koncept**: Förstå stora språkmodeller, tokens, inbäddningar och AI-förmågor
- **Java AI-ekosystemet**: Översikt av Spring AI och OpenAI SDK:er
- **Model Context Protocol**: Introduktion till MCP och dess roll i AI-agentkommunikation
- **Praktiska tillämpningar**: Verkliga scenarier inklusive chattbotar och innehållsgenerering
- **[→ Börja Kapitel 1](./01-IntroToGenAI/README.md)**

### **Kapitel 2: Inställning av Utvecklingsmiljö**
- **Konfiguration för flera leverantörer**: Ställ in GitHub Models, Azure OpenAI och OpenAI Java SDK-integrationer
- **Spring Boot + Spring AI**: Bästa praxis för utveckling av AI-applikationer för företag
- **GitHub Models**: Gratis AI-modellåtkomst för prototyper och inlärning (ingen kreditkort krävs)
- **Utvecklingsverktyg**: Docker-containrar, VS Code och GitHub Codespaces-konfiguration
- **[→ Börja Kapitel 2](./02-SetupDevEnvironment/README.md)**

### **Kapitel 3: Kärntekniker för Generativ AI**
- **Prompt Engineering**: Tekniker för optimala AI-modellsvar
- **Inbäddningar & Vektoroperationer**: Implementera semantisk sökning och likhetsmatchning
- **Retrieval-Augmented Generation (RAG)**: Kombinera AI med dina egna datakällor
- **Funktionsanrop**: Utöka AI-förmågor med anpassade verktyg och plugins
- **[→ Börja Kapitel 3](./03-CoreGenerativeAITechniques/README.md)**

### **Kapitel 4: Praktiska Tillämpningar & Projekt**
- **Husdjursberättelsegenerator** (`petstory/`): Kreativ innehållsgenerering med GitHub Models
- **Foundry Local Demo** (`foundrylocal/`): Lokal AI-modellintegration med OpenAI Java SDK
- **MCP Kalkylator-tjänst** (`calculator/`): Grundläggande implementation av Model Context Protocol med Spring AI
- **[→ Börja Kapitel 4](./04-PracticalSamples/README.md)**

### **Kapitel 5: Ansvarsfull AI-utveckling**
- **GitHub Models Säkerhet**: Testa inbyggd innehållsfiltrering och säkerhetsmekanismer (hårda blockeringar och mjuka avslag)
- **Ansvarsfull AI-demo**: Praktiskt exempel som visar hur moderna AI-säkerhetssystem fungerar i praktiken
- **Bästa praxis**: Viktiga riktlinjer för etisk AI-utveckling och implementering
- **[→ Börja Kapitel 5](./05-ResponsibleGenAI/README.md)**

## Ytterligare Resurser

- [MCP För Nybörjare](https://github.com/microsoft/mcp-for-beginners)
- [AI-agenter För Nybörjare](https://github.com/microsoft/ai-agents-for-beginners)
- [Generativ AI för Nybörjare med .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generativ AI för Nybörjare med JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Generativ AI för Nybörjare](https://github.com/microsoft/generative-ai-for-beginners)
- [ML för Nybörjare](https://aka.ms/ml-beginners)
- [Data Science för Nybörjare](https://aka.ms/datascience-beginners)
- [AI för Nybörjare](https://aka.ms/ai-beginners)
- [Cybersäkerhet för Nybörjare](https://github.com/microsoft/Security-101)
- [Webbutveckling för Nybörjare](https://aka.ms/webdev-beginners)
- [IoT för Nybörjare](https://aka.ms/iot-beginners)
- [XR-utveckling för Nybörjare](https://github.com/microsoft/xr-development-for-beginners)
- [Bemästra GitHub Copilot för AI-parprogrammering](https://aka.ms/GitHubCopilotAI)
- [Bemästra GitHub Copilot för C#/.NET-utvecklare](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Välj Ditt Eget Copilot-äventyr](https://github.com/microsoft/CopilotAdventures)
- [RAG Chattapp med Azure AI-tjänster](https://github.com/Azure-Samples/azure-search-openai-demo-java)

---

**Ansvarsfriskrivning**:  
Detta dokument har översatts med hjälp av AI-översättningstjänsten [Co-op Translator](https://github.com/Azure/co-op-translator). Även om vi strävar efter noggrannhet, bör det noteras att automatiska översättningar kan innehålla fel eller brister. Det ursprungliga dokumentet på dess originalspråk bör betraktas som den auktoritativa källan. För kritisk information rekommenderas professionell mänsklig översättning. Vi ansvarar inte för eventuella missförstånd eller feltolkningar som kan uppstå vid användning av denna översättning.