<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "00950ee1a40a84676b50da356c3a964a",
  "translation_date": "2025-10-11T10:28:44+00:00",
  "source_file": "README.md",
  "language_code": "no"
}
-->
# Generativ AI for Nybegynnere - Java-utgave
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generativ AI for Nybegynnere - Java-utgave](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.no.png)

**Tidsbruk**: Hele workshoppen kan fullføres online uten lokal oppsett. Miljøoppsettet tar 2 minutter, og utforskning av eksemplene krever 1-3 timer avhengig av hvor dypt du går.

> **Hurtigstart**

1. Fork dette repositoriet til din GitHub-konto
2. Klikk **Code** → **Codespaces**-fanen → **...** → **New with options...**
3. Bruk standardinnstillingene – dette vil velge utviklingscontaineren som er laget for dette kurset
4. Klikk **Create codespace**
5. Vent ~2 minutter til miljøet er klart
6. Gå direkte til [Det første eksempelet](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Støtte for flere språk

### Støttet via GitHub Action (Automatisk og alltid oppdatert)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabisk](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgarsk](../bg/README.md) | [Burmesisk (Myanmar)](../my/README.md) | [Kinesisk (Forenklet)](../zh/README.md) | [Kinesisk (Tradisjonell, Hong Kong)](../hk/README.md) | [Kinesisk (Tradisjonell, Macau)](../mo/README.md) | [Kinesisk (Tradisjonell, Taiwan)](../tw/README.md) | [Kroatisk](../hr/README.md) | [Tsjekkisk](../cs/README.md) | [Dansk](../da/README.md) | [Nederlandsk](../nl/README.md) | [Estisk](../et/README.md) | [Finsk](../fi/README.md) | [Fransk](../fr/README.md) | [Tysk](../de/README.md) | [Gresk](../el/README.md) | [Hebraisk](../he/README.md) | [Hindi](../hi/README.md) | [Ungarsk](../hu/README.md) | [Indonesisk](../id/README.md) | [Italiensk](../it/README.md) | [Japansk](../ja/README.md) | [Koreansk](../ko/README.md) | [Litauisk](../lt/README.md) | [Malayisk](../ms/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Norsk](./README.md) | [Persisk (Farsi)](../fa/README.md) | [Polsk](../pl/README.md) | [Portugisisk (Brasil)](../br/README.md) | [Portugisisk (Portugal)](../pt/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Rumensk](../ro/README.md) | [Russisk](../ru/README.md) | [Serbisk (Kyrillisk)](../sr/README.md) | [Slovakisk](../sk/README.md) | [Slovensk](../sl/README.md) | [Spansk](../es/README.md) | [Swahili](../sw/README.md) | [Svensk](../sv/README.md) | [Tagalog (Filippinsk)](../tl/README.md) | [Tamil](../ta/README.md) | [Thai](../th/README.md) | [Tyrkisk](../tr/README.md) | [Ukrainsk](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamesisk](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Kursstruktur og læringssti

### **Kapittel 1: Introduksjon til Generativ AI**
- **Kjernebegreper**: Forstå store språkmodeller, tokens, embeddings og AI-funksjoner
- **Java AI-økosystem**: Oversikt over Spring AI og OpenAI SDK-er
- **Model Context Protocol**: Introduksjon til MCP og dens rolle i AI-agentkommunikasjon
- **Praktiske anvendelser**: Virkelige eksempler som chatbots og innholdsgenerering
- **[→ Start Kapittel 1](./01-IntroToGenAI/README.md)**

### **Kapittel 2: Oppsett av utviklingsmiljø**
- **Konfigurasjon for flere leverandører**: Sett opp GitHub-modeller, Azure OpenAI og OpenAI Java SDK-integrasjoner
- **Spring Boot + Spring AI**: Beste praksis for utvikling av AI-applikasjoner for bedrifter
- **GitHub-modeller**: Gratis tilgang til AI-modeller for prototyping og læring (ingen kredittkort nødvendig)
- **Utviklingsverktøy**: Docker-containere, VS Code og GitHub Codespaces-konfigurasjon
- **[→ Start Kapittel 2](./02-SetupDevEnvironment/README.md)**

### **Kapittel 3: Kjerne-teknikker for Generativ AI**
- **Prompt Engineering**: Teknikker for optimale AI-modellsvar
- **Embeddings og vektoroperasjoner**: Implementer semantisk søk og likhetsmatching
- **Retrieval-Augmented Generation (RAG)**: Kombiner AI med dine egne datakilder
- **Funksjonskall**: Utvid AI-funksjoner med tilpassede verktøy og plugins
- **[→ Start Kapittel 3](./03-CoreGenerativeAITechniques/README.md)**

### **Kapittel 4: Praktiske anvendelser og prosjekter**
- **Pet Story Generator** (`petstory/`): Kreativ innholdsgenerering med GitHub-modeller
- **Foundry Local Demo** (`foundrylocal/`): Lokal AI-modellintegrasjon med OpenAI Java SDK
- **MCP Calculator Service** (`calculator/`): Grunnleggende implementering av Model Context Protocol med Spring AI
- **[→ Start Kapittel 4](./04-PracticalSamples/README.md)**

### **Kapittel 5: Ansvarlig AI-utvikling**
- **GitHub-modellers sikkerhet**: Test innebygde innholdsfiltrerings- og sikkerhetsmekanismer (harde blokker og myke avslag)
- **Ansvarlig AI-demo**: Praktisk eksempel som viser hvordan moderne AI-sikkerhetssystemer fungerer
- **Beste praksis**: Essensielle retningslinjer for etisk AI-utvikling og implementering
- **[→ Start Kapittel 5](./05-ResponsibleGenAI/README.md)**

## Ekstra ressurser

- [Edge AI for Nybegynnere](https://github.com/microsoft/edgeai-for-beginners)
- [MCP For Nybegynnere](https://github.com/microsoft/mcp-for-beginners)
- [AI-agenter For Nybegynnere](https://github.com/microsoft/ai-agents-for-beginners)
- [Generativ AI for Nybegynnere med .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generativ AI for Nybegynnere med JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Generativ AI for Nybegynnere](https://github.com/microsoft/generative-ai-for-beginners)
- [ML for Nybegynnere](https://aka.ms/ml-beginners)
- [Data Science for Nybegynnere](https://aka.ms/datascience-beginners)
- [AI for Nybegynnere](https://aka.ms/ai-beginners)
- [Cybersikkerhet for Nybegynnere](https://github.com/microsoft/Security-101)
- [Webutvikling for Nybegynnere](https://aka.ms/webdev-beginners)
- [IoT for Nybegynnere](https://aka.ms/iot-beginners)
- [XR-utvikling for Nybegynnere](https://github.com/microsoft/xr-development-for-beginners)
- [Mastering GitHub Copilot for AI Paired Programming](https://aka.ms/GitHubCopilotAI)
- [Mastering GitHub Copilot for C#/.NET Developers](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Choose Your Own Copilot Adventure](https://github.com/microsoft/CopilotAdventures)
- [RAG Chat App med Azure AI-tjenester](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## Få hjelp

Hvis du står fast eller har spørsmål om bygging av AI-applikasjoner, bli med:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Hvis du har produktfeedback eller feil under bygging, besøk:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**Ansvarsfraskrivelse**:  
Dette dokumentet er oversatt ved hjelp av AI-oversettelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selv om vi tilstreber nøyaktighet, vær oppmerksom på at automatiserte oversettelser kan inneholde feil eller unøyaktigheter. Det originale dokumentet på dets opprinnelige språk bør anses som den autoritative kilden. For kritisk informasjon anbefales profesjonell menneskelig oversettelse. Vi er ikke ansvarlige for eventuelle misforståelser eller feiltolkninger som oppstår ved bruk av denne oversettelsen.