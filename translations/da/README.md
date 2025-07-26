<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "ff95bb9d60ecd46e1a2215e341062967",
  "translation_date": "2025-07-26T17:34:49+00:00",
  "source_file": "README.md",
  "language_code": "da"
}
-->
# Generativ AI for Begyndere - Java Edition
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generativ AI for Begyndere - Java Edition](../../translated_images/beg-genai-series.61edc4a6b2cc54284fa2d70eda26dc0ca2669e26e49655b842ea799cd6e16d2a.da.png)

**Tidsforbrug**: Hele workshoppen kan gennemføres online uden lokal opsætning. Hvis du ønsker at køre eksemplerne, tager miljøopsætningen 2 minutter, og det kræver 1-3 timer at udforske eksemplerne, afhængigt af hvor dybt du går.

> **Hurtig Start**

1. Fork dette repository til din GitHub-konto
2. Klik på **Code** → **Codespaces** fanen → **...** → **New with options...**
3. Brug standardindstillingerne – dette vælger den udviklingscontainer, der er oprettet til dette kursus
4. Klik på **Create codespace**
5. Vent ca. 2 minutter, indtil miljøet er klar
6. Gå direkte til [Oprettelse af din GitHub Models Token](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Understøttelse af flere sprog

### Understøttet via GitHub Action (Automatisk & Altid Opdateret)

[Fransk](../fr/README.md) | [Spansk](../es/README.md) | [Tysk](../de/README.md) | [Russisk](../ru/README.md) | [Arabisk](../ar/README.md) | [Persisk (Farsi)](../fa/README.md) | [Urdu](../ur/README.md) | [Kinesisk (Forenklet)](../zh/README.md) | [Kinesisk (Traditionelt, Macau)](../mo/README.md) | [Kinesisk (Traditionelt, Hong Kong)](../hk/README.md) | [Kinesisk (Traditionelt, Taiwan)](../tw/README.md) | [Japansk](../ja/README.md) | [Koreansk](../ko/README.md) | [Hindi](../hi/README.md) | [Bengali](../bn/README.md) | [Marathi](../mr/README.md) | [Nepalesisk](../ne/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Portugisisk (Portugal)](../pt/README.md) | [Portugisisk (Brasilien)](../br/README.md) | [Italiensk](../it/README.md) | [Polsk](../pl/README.md) | [Tyrkisk](../tr/README.md) | [Græsk](../el/README.md) | [Thai](../th/README.md) | [Svensk](../sv/README.md) | [Dansk](./README.md) | [Norsk](../no/README.md) | [Finsk](../fi/README.md) | [Hollandsk](../nl/README.md) | [Hebraisk](../he/README.md) | [Vietnamesisk](../vi/README.md) | [Indonesisk](../id/README.md) | [Malay](../ms/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Swahili](../sw/README.md) | [Ungarsk](../hu/README.md) | [Tjekkisk](../cs/README.md) | [Slovakisk](../sk/README.md) | [Rumænsk](../ro/README.md) | [Bulgarsk](../bg/README.md) | [Serbisk (Kyrillisk)](../sr/README.md) | [Kroatisk](../hr/README.md) | [Slovensk](../sl/README.md) | [Ukrainsk](../uk/README.md) | [Burmesisk (Myanmar)](../my/README.md)

## Kursusstruktur & Læringssti

### **Kapitel 1: Introduktion til Generativ AI**
- **Kernebegreber**: Forståelse af store sprogmodeller, tokens, embeddings og AI-funktioner
- **Java AI Økosystem**: Oversigt over Spring AI og OpenAI SDK'er
- **Model Context Protocol**: Introduktion til MCP og dens rolle i AI-agentkommunikation
- **Praktiske Anvendelser**: Virkelige scenarier, herunder chatbots og indholdsgenerering
- **[→ Start Kapitel 1](./01-IntroToGenAI/README.md)**

### **Kapitel 2: Opsætning af Udviklingsmiljø**
- **Multi-Provider Konfiguration**: Opsætning af GitHub Models, Azure OpenAI og OpenAI Java SDK-integrationer
- **Spring Boot + Spring AI**: Bedste praksis for udvikling af AI-applikationer til virksomheder
- **GitHub Models**: Gratis adgang til AI-modeller til prototyper og læring (ingen kreditkort påkrævet)
- **Udviklingsværktøjer**: Docker-containere, VS Code og GitHub Codespaces-konfiguration
- **[→ Start Kapitel 2](./02-SetupDevEnvironment/README.md)**

### **Kapitel 3: Kerne Generative AI Teknikker**
- **Prompt Engineering**: Teknikker til optimale AI-modelsvar
- **Embeddings & Vektoroperationer**: Implementer semantisk søgning og lighedsmatchning
- **Retrieval-Augmented Generation (RAG)**: Kombiner AI med dine egne datakilder
- **Function Calling**: Udvid AI-funktioner med brugerdefinerede værktøjer og plugins
- **[→ Start Kapitel 3](./03-CoreGenerativeAITechniques/README.md)**

### **Kapitel 4: Praktiske Anvendelser & Projekter**
- **Pet Story Generator** (`petstory/`): Kreativ indholdsgenerering med GitHub Models
- **Foundry Local Demo** (`foundrylocal/`): Lokal AI-modelintegration med OpenAI Java SDK
- **MCP Calculator Service** (`mcp/calculator/`): Grundlæggende Model Context Protocol-implementering med Spring AI
- **[→ Start Kapitel 4](./04-PracticalSamples/README.md)**

### **Kapitel 5: Ansvarlig AI-udvikling**
- **GitHub Models Sikkerhed**: Test indbyggede indholdsfiltre og sikkerhedsmekanismer
- **Ansvarlig AI Demo**: Praktisk eksempel, der viser, hvordan AI-sikkerhedsfiltre fungerer i praksis
- **Bedste Praksis**: Vigtige retningslinjer for etisk AI-udvikling og implementering
- **[→ Start Kapitel 5](./05-ResponsibleGenAI/README.md)**

## Yderligere Ressourcer

- [AI Agents For Beginners](https://github.com/microsoft/ai-agents-for-beginners)
- [Generativ AI for Begyndere med .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generativ AI for Begyndere med JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Generativ AI for Begyndere](https://github.com/microsoft/generative-ai-for-beginners)
- [ML for Begyndere](https://aka.ms/ml-beginners)
- [Data Science for Begyndere](https://aka.ms/datascience-beginners)
- [AI for Begyndere](https://aka.ms/ai-beginners)
- [Cybersikkerhed for Begyndere](https://github.com/microsoft/Security-101)
- [Webudvikling for Begyndere](https://aka.ms/webdev-beginners)
- [IoT for Begyndere](https://aka.ms/iot-beginners)
- [XR-udvikling for Begyndere](https://github.com/microsoft/xr-development-for-beginners)
- [Mastering GitHub Copilot for AI Paired Programming](https://aka.ms/GitHubCopilotAI)
- [Mastering GitHub Copilot for C#/.NET Developers](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Choose Your Own Copilot Adventure](https://github.com/microsoft/CopilotAdventures)
- [RAG Chat App med Azure AI Services](https://github.com/Azure-Samples/azure-search-openai-demo-java)

**Ansvarsfraskrivelse**:  
Dette dokument er blevet oversat ved hjælp af AI-oversættelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selvom vi bestræber os på nøjagtighed, skal det bemærkes, at automatiserede oversættelser kan indeholde fejl eller unøjagtigheder. Det originale dokument på dets oprindelige sprog bør betragtes som den autoritative kilde. For kritisk information anbefales professionel menneskelig oversættelse. Vi påtager os intet ansvar for misforståelser eller fejltolkninger, der måtte opstå som følge af brugen af denne oversættelse.