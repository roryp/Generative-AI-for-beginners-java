<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2ee0f50497c11d1941347ac61fb017a9",
  "translation_date": "2025-07-21T19:02:13+00:00",
  "source_file": "README.md",
  "language_code": "no"
}
-->
# Generativ AI for Nybegynnere - Java Edition
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generativ AI for Nybegynnere - Java Edition](../../translated_images/beg-genai-series.61edc4a6b2cc54284fa2d70eda26dc0ca2669e26e49655b842ea799cd6e16d2a.no.png)

> **NOTE: Kom i gang raskt**: Hele kurset kan gjennomføres online – Ingen lokal oppsett nødvendig!
1. Fork dette repositoriet til din GitHub-konto
2. Klikk **Code** → **Codespaces**-fanen → **...** → **New with options...**
3. Bruk standardinnstillingene – dette vil velge utviklingscontaineren som er opprettet for dette kurset
4. Klikk **Create codespace**
5. Vent ~2 minutter til miljøet er klart
6. Gå direkte til [Opprette din GitHub Models Token](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Støtte for flere språk

### Støttet via GitHub Action (Automatisk og alltid oppdatert)

[Fransk](../fr/README.md) | [Spansk](../es/README.md) | [Tysk](../de/README.md) | [Russisk](../ru/README.md) | [Arabisk](../ar/README.md) | [Persisk (Farsi)](../fa/README.md) | [Urdu](../ur/README.md) | [Kinesisk (Forenklet)](../zh/README.md) | [Kinesisk (Tradisjonell, Macau)](../mo/README.md) | [Kinesisk (Tradisjonell, Hong Kong)](../hk/README.md) | [Kinesisk (Tradisjonell, Taiwan)](../tw/README.md) | [Japansk](../ja/README.md) | [Koreansk](../ko/README.md) | [Hindi](../hi/README.md) | [Bengali](../bn/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Portugisisk (Portugal)](../pt/README.md) | [Portugisisk (Brasil)](../br/README.md) | [Italiensk](../it/README.md) | [Polsk](../pl/README.md) | [Tyrkisk](../tr/README.md) | [Gresk](../el/README.md) | [Thai](../th/README.md) | [Svensk](../sv/README.md) | [Dansk](../da/README.md) | [Norsk](./README.md) | [Finsk](../fi/README.md) | [Nederlandsk](../nl/README.md) | [Hebraisk](../he/README.md) | [Vietnamesisk](../vi/README.md) | [Indonesisk](../id/README.md) | [Malayisk](../ms/README.md) | [Tagalog (Filippinsk)](../tl/README.md) | [Swahili](../sw/README.md) | [Ungarsk](../hu/README.md) | [Tsjekkisk](../cs/README.md) | [Slovakisk](../sk/README.md) | [Rumensk](../ro/README.md) | [Bulgarsk](../bg/README.md) | [Serbisk (Kyrillisk)](../sr/README.md) | [Kroatisk](../hr/README.md) | [Slovensk](../sl/README.md) | [Ukrainsk](../uk/README.md) | [Burmesisk (Myanmar)](../my/README.md)

## Kursstruktur og læringssti

**Tidsbruk**: Oppsett av miljø tar 2 minutter, mens praktiske opplæringer krever 1-3 timer hver, avhengig av hvor dypt du utforsker.

### **Kapittel 1: Introduksjon til Generativ AI**
- **Kjernebegreper**: Forståelse av store språkmodeller, tokens, embeddings og AI-muligheter
- **Java AI-økosystem**: Oversikt over Spring AI og OpenAI SDK-er
- **Model Context Protocol**: Introduksjon til MCP og dens rolle i AI-agentkommunikasjon
- **Praktiske anvendelser**: Virkelige scenarier som chatbots og innholdsgenerering
- **[→ Start Kapittel 1](./01-IntroToGenAI/README.md)**

### **Kapittel 2: Oppsett av utviklingsmiljø**
- **Konfigurasjon for flere leverandører**: Sett opp GitHub Models, Azure OpenAI og OpenAI Java SDK-integrasjoner
- **Spring Boot + Spring AI**: Beste praksis for utvikling av AI-applikasjoner for bedrifter
- **GitHub Models**: Gratis tilgang til AI-modeller for prototyping og læring (ingen kredittkort nødvendig)
- **Utviklingsverktøy**: Konfigurasjon av Docker-containere, VS Code og GitHub Codespaces
- **[→ Start Kapittel 2](./02-SetupDevEnvironment/README.md)**

### **Kapittel 3: Kjerne teknikker for generativ AI**
- **Prompt Engineering**: Teknikker for optimale AI-modellsvar
- **Embeddings og vektoroperasjoner**: Implementer semantisk søk og likhetsmatching
- **Retrieval-Augmented Generation (RAG)**: Kombiner AI med dine egne datakilder
- **Funksjonskall**: Utvid AI-muligheter med tilpassede verktøy og plugins
- **[→ Start Kapittel 3](./03-CoreGenerativeAITechniques/README.md)**

### **Kapittel 4: Praktiske anvendelser og prosjekter**
- **Pet Story Generator** (`petstory/`): Kreativ innholdsgenerering med GitHub Models
- **Foundry Local Demo** (`foundrylocal/`): Lokal AI-modellintegrasjon med OpenAI Java SDK
- **MCP Calculator Service** (`mcp/calculator/`): Grunnleggende implementering av Model Context Protocol med Spring AI
- **[→ Start Kapittel 4](./04-PracticalSamples/README.md)**

### **Kapittel 5: Ansvarlig AI-utvikling**
- **GitHub Models Sikkerhet**: Test innebygde innholdsfiltre og sikkerhetsmekanismer
- **Ansvarlig AI-demo**: Praktisk eksempel som viser hvordan AI-sikkerhetsfiltre fungerer i praksis
- **Beste praksis**: Essensielle retningslinjer for etisk AI-utvikling og distribusjon
- **[→ Start Kapittel 5](./05-ResponsibleGenAI/README.md)**

## Ekstra ressurser 

- [AI-agenter for nybegynnere](https://github.com/microsoft/ai-agents-for-beginners)
- [Generativ AI for nybegynnere med .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generativ AI for nybegynnere med JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Generativ AI for nybegynnere](https://github.com/microsoft/generative-ai-for-beginners)
- [ML for nybegynnere](https://aka.ms/ml-beginners)
- [Data Science for nybegynnere](https://aka.ms/datascience-beginners)
- [AI for nybegynnere](https://aka.ms/ai-beginners)
- [Cybersikkerhet for nybegynnere](https://github.com/microsoft/Security-101)
- [Webutvikling for nybegynnere](https://aka.ms/webdev-beginners)
- [IoT for nybegynnere](https://aka.ms/iot-beginners)
- [XR-utvikling for nybegynnere](https://github.com/microsoft/xr-development-for-beginners)
- [Mestre GitHub Copilot for AI-parprogrammering](https://aka.ms/GitHubCopilotAI)
- [Mestre GitHub Copilot for C#/.NET-utviklere](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Velg ditt eget Copilot-eventyr](https://github.com/microsoft/CopilotAdventures)
- [RAG Chat App med Azure AI-tjenester](https://github.com/Azure-Samples/azure-search-openai-demo-java)

**Ansvarsfraskrivelse**:  
Dette dokumentet er oversatt ved hjelp av AI-oversettelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selv om vi streber etter nøyaktighet, vær oppmerksom på at automatiserte oversettelser kan inneholde feil eller unøyaktigheter. Det originale dokumentet på sitt opprinnelige språk bør anses som den autoritative kilden. For kritisk informasjon anbefales profesjonell menneskelig oversettelse. Vi er ikke ansvarlige for misforståelser eller feiltolkninger som oppstår ved bruk av denne oversettelsen.