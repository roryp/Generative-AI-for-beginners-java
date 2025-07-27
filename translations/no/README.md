<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "d684972689e288a83779255116bb42c3",
  "translation_date": "2025-07-27T08:51:37+00:00",
  "source_file": "README.md",
  "language_code": "no"
}
-->
# Generativ AI for Nybegynnere - Java Edition
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generativ AI for Nybegynnere - Java Edition](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.no.png)

**Tidsforpliktelse**: Hele workshoppen kan fullføres online uten lokal oppsett. Hvis du ønsker å kjøre eksemplene, tar miljøoppsettet 2 minutter, og utforskning av eksemplene krever 1-3 timer avhengig av hvor dypt du går.

> **Hurtigstart** 

1. Fork dette repositoriet til din GitHub-konto
2. Klikk **Code** → **Codespaces**-fanen → **...** → **New with options...**
3. Bruk standardinnstillingene – dette vil velge utviklingscontaineren som er laget for dette kurset
4. Klikk **Create codespace**
5. Vent ~2 minutter til miljøet er klart
6. Gå direkte til [Oppretting av din GitHub Models Token](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Støtte for flere språk

### Støttet via GitHub Action (Automatisk & Alltid Oppdatert)

[Fransk](../fr/README.md) | [Spansk](../es/README.md) | [Tysk](../de/README.md) | [Russisk](../ru/README.md) | [Arabisk](../ar/README.md) | [Persisk (Farsi)](../fa/README.md) | [Urdu](../ur/README.md) | [Kinesisk (Forenklet)](../zh/README.md) | [Kinesisk (Tradisjonell, Macau)](../mo/README.md) | [Kinesisk (Tradisjonell, Hong Kong)](../hk/README.md) | [Kinesisk (Tradisjonell, Taiwan)](../tw/README.md) | [Japansk](../ja/README.md) | [Koreansk](../ko/README.md) | [Hindi](../hi/README.md) | [Bengali](../bn/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Portugisisk (Portugal)](../pt/README.md) | [Portugisisk (Brasil)](../br/README.md) | [Italiensk](../it/README.md) | [Polsk](../pl/README.md) | [Tyrkisk](../tr/README.md) | [Gresk](../el/README.md) | [Thai](../th/README.md) | [Svensk](../sv/README.md) | [Dansk](../da/README.md) | [Norsk](./README.md) | [Finsk](../fi/README.md) | [Nederlandsk](../nl/README.md) | [Hebraisk](../he/README.md) | [Vietnamesisk](../vi/README.md) | [Indonesisk](../id/README.md) | [Malayisk](../ms/README.md) | [Tagalog (Filippinsk)](../tl/README.md) | [Swahili](../sw/README.md) | [Ungarsk](../hu/README.md) | [Tsjekkisk](../cs/README.md) | [Slovakisk](../sk/README.md) | [Rumensk](../ro/README.md) | [Bulgarsk](../bg/README.md) | [Serbisk (Kyrillisk)](../sr/README.md) | [Kroatisk](../hr/README.md) | [Slovensk](../sl/README.md) | [Ukrainsk](../uk/README.md) | [Burmesisk (Myanmar)](../my/README.md)

## Kursstruktur & Læringssti

### **Kapittel 1: Introduksjon til Generativ AI**
- **Kjernebegreper**: Forståelse av store språkmodeller, tokens, embeddings og AI-funksjoner
- **Java AI-økosystem**: Oversikt over Spring AI og OpenAI SDK-er
- **Model Context Protocol**: Introduksjon til MCP og dens rolle i AI-agentkommunikasjon
- **Praktiske anvendelser**: Virkelige eksempler som chatbots og innholdsgenerering
- **[→ Start Kapittel 1](./01-IntroToGenAI/README.md)**

### **Kapittel 2: Oppsett av Utviklingsmiljø**
- **Konfigurasjon for flere leverandører**: Sett opp GitHub Models, Azure OpenAI og OpenAI Java SDK-integrasjoner
- **Spring Boot + Spring AI**: Beste praksis for utvikling av AI-applikasjoner for bedrifter
- **GitHub Models**: Gratis tilgang til AI-modeller for prototyping og læring (ingen kredittkort nødvendig)
- **Utviklingsverktøy**: Docker-containere, VS Code og GitHub Codespaces-konfigurasjon
- **[→ Start Kapittel 2](./02-SetupDevEnvironment/README.md)**

### **Kapittel 3: Kjerne Generativ AI-teknikker**
- **Prompt Engineering**: Teknikker for optimale AI-modellsvar
- **Embeddings & Vektoroperasjoner**: Implementer semantisk søk og likhetsmatching
- **Retrieval-Augmented Generation (RAG)**: Kombiner AI med dine egne datakilder
- **Funksjonskalling**: Utvid AI-funksjoner med tilpassede verktøy og plugins
- **[→ Start Kapittel 3](./03-CoreGenerativeAITechniques/README.md)**

### **Kapittel 4: Praktiske Anvendelser & Prosjekter**
- **Pet Story Generator** (`petstory/`): Kreativ innholdsgenerering med GitHub Models
- **Foundry Local Demo** (`foundrylocal/`): Lokal AI-modellintegrasjon med OpenAI Java SDK
- **MCP Calculator Service** (`mcp/calculator/`): Grunnleggende implementering av Model Context Protocol med Spring AI
- **[→ Start Kapittel 4](./04-PracticalSamples/README.md)**

### **Kapittel 5: Ansvarlig AI-utvikling**
- **GitHub Models Sikkerhet**: Test innebygde innholdsfiltre og sikkerhetsmekanismer
- **Ansvarlig AI-demo**: Praktisk eksempel som viser hvordan AI-sikkerhetsfiltre fungerer i praksis
- **Beste praksis**: Essensielle retningslinjer for etisk AI-utvikling og implementering
- **[→ Start Kapittel 5](./05-ResponsibleGenAI/README.md)**

## Ekstra Ressurser 

- [AI-agenter for Nybegynnere](https://github.com/microsoft/ai-agents-for-beginners)
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
- [Mestre GitHub Copilot for AI-parprogrammering](https://aka.ms/GitHubCopilotAI)
- [Mestre GitHub Copilot for C#/.NET-utviklere](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Velg Din Egen Copilot-eventyr](https://github.com/microsoft/CopilotAdventures)
- [RAG Chat App med Azure AI-tjenester](https://github.com/Azure-Samples/azure-search-openai-demo-java)

**Ansvarsfraskrivelse**:  
Dette dokumentet er oversatt ved hjelp av AI-oversettelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selv om vi streber etter nøyaktighet, vær oppmerksom på at automatiserte oversettelser kan inneholde feil eller unøyaktigheter. Det originale dokumentet på sitt opprinnelige språk bør anses som den autoritative kilden. For kritisk informasjon anbefales profesjonell menneskelig oversettelse. Vi er ikke ansvarlige for eventuelle misforståelser eller feiltolkninger som oppstår ved bruk av denne oversettelsen.