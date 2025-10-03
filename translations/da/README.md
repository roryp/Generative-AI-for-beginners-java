<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "4d04ae8088f6a3c3fcbab18cbdfe4002",
  "translation_date": "2025-10-03T08:13:23+00:00",
  "source_file": "README.md",
  "language_code": "da"
}
-->
# Generativ AI for Begyndere - Java Edition
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generativ AI for Begyndere - Java Edition](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.da.png)

**Tidsforbrug**: Hele workshoppen kan gennemføres online uden lokal opsætning. Opsætning af miljøet tager 2 minutter, og udforskning af eksemplerne kræver 1-3 timer afhængigt af dybden af din udforskning.

> **Hurtig Start** 

1. Fork dette repository til din GitHub-konto
2. Klik på **Code** → **Codespaces** fanen → **...** → **New with options...**
3. Brug standardindstillingerne – dette vil vælge udviklingscontaineren, der er oprettet til dette kursus
4. Klik på **Create codespace**
5. Vent ~2 minutter, indtil miljøet er klar
6. Gå direkte til [Det første eksempel](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Understøttelse af flere sprog

### Understøttet via GitHub Action (Automatisk & Altid Opdateret)

[Fransk](../fr/README.md) | [Spansk](../es/README.md) | [Tysk](../de/README.md) | [Russisk](../ru/README.md) | [Arabisk](../ar/README.md) | [Persisk (Farsi)](../fa/README.md) | [Urdu](../ur/README.md) | [Kinesisk (Forenklet)](../zh/README.md) | [Kinesisk (Traditionelt, Macau)](../mo/README.md) | [Kinesisk (Traditionelt, Hong Kong)](../hk/README.md) | [Kinesisk (Traditionelt, Taiwan)](../tw/README.md) | [Japansk](../ja/README.md) | [Koreansk](../ko/README.md) | [Hindi](../hi/README.md) | [Bengali](../bn/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Portugisisk (Portugal)](../pt/README.md) | [Portugisisk (Brasilien)](../br/README.md) | [Italiensk](../it/README.md) | [Polsk](../pl/README.md) | [Tyrkisk](../tr/README.md) | [Græsk](../el/README.md) | [Thai](../th/README.md) | [Svensk](../sv/README.md) | [Dansk](./README.md) | [Norsk](../no/README.md) | [Finsk](../fi/README.md) | [Hollandsk](../nl/README.md) | [Hebraisk](../he/README.md) | [Vietnamesisk](../vi/README.md) | [Indonesisk](../id/README.md) | [Malay](../ms/README.md) | [Tagalog (Filippinsk)](../tl/README.md) | [Swahili](../sw/README.md) | [Ungarsk](../hu/README.md) | [Tjekkisk](../cs/README.md) | [Slovakisk](../sk/README.md) | [Rumænsk](../ro/README.md) | [Bulgarsk](../bg/README.md) | [Serbisk (Kyrillisk)](../sr/README.md) | [Kroatisk](../hr/README.md) | [Slovensk](../sl/README.md) | [Ukrainsk](../uk/README.md) | [Burmesisk (Myanmar)](../my/README.md)

## Kursusstruktur & Læringssti

### **Kapitel 1: Introduktion til Generativ AI**
- **Kernebegreber**: Forståelse af store sproglige modeller, tokens, embeddings og AI-funktioner
- **Java AI Økosystem**: Oversigt over Spring AI og OpenAI SDK'er
- **Model Context Protocol**: Introduktion til MCP og dens rolle i AI-agentkommunikation
- **Praktiske Anvendelser**: Virkelige scenarier, herunder chatbots og indholdsgenerering
- **[→ Start Kapitel 1](./01-IntroToGenAI/README.md)**

### **Kapitel 2: Opsætning af Udviklingsmiljø**
- **Multi-Provider Konfiguration**: Opsætning af GitHub Models, Azure OpenAI og OpenAI Java SDK integrationer
- **Spring Boot + Spring AI**: Bedste praksis for udvikling af AI-applikationer til virksomheder
- **GitHub Models**: Gratis adgang til AI-modeller til prototyper og læring (ingen kreditkort påkrævet)
- **Udviklingsværktøjer**: Docker-containere, VS Code og GitHub Codespaces konfiguration
- **[→ Start Kapitel 2](./02-SetupDevEnvironment/README.md)**

### **Kapitel 3: Kerne Generativ AI Teknikker**
- **Prompt Engineering**: Teknikker til optimale AI-modelsvar
- **Embeddings & Vektoroperationer**: Implementer semantisk søgning og lighedsmatching
- **Retrieval-Augmented Generation (RAG)**: Kombiner AI med dine egne datakilder
- **Function Calling**: Udvid AI-funktioner med brugerdefinerede værktøjer og plugins
- **[→ Start Kapitel 3](./03-CoreGenerativeAITechniques/README.md)**

### **Kapitel 4: Praktiske Anvendelser & Projekter**
- **Pet Story Generator** (`petstory/`): Kreativ indholdsgenerering med GitHub Models
- **Foundry Local Demo** (`foundrylocal/`): Lokal AI-modelintegration med OpenAI Java SDK
- **MCP Calculator Service** (`calculator/`): Grundlæggende Model Context Protocol implementering med Spring AI
- **[→ Start Kapitel 4](./04-PracticalSamples/README.md)**

### **Kapitel 5: Ansvarlig AI Udvikling**
- **GitHub Models Sikkerhed**: Test indbyggede indholdsfiltrerings- og sikkerhedsmekanismer (hårde blokeringer og bløde afvisninger)
- **Ansvarlig AI Demo**: Praktisk eksempel, der viser, hvordan moderne AI-sikkerhedssystemer fungerer i praksis
- **Bedste Praksis**: Vigtige retningslinjer for etisk AI-udvikling og implementering
- **[→ Start Kapitel 5](./05-ResponsibleGenAI/README.md)**

## Yderligere Ressourcer 

- [Edge AI for Begyndere](https://github.com/microsoft/edgeai-for-beginners)
- [MCP For Begyndere](https://github.com/microsoft/mcp-for-beginners)
- [AI Agents For Begyndere](https://github.com/microsoft/ai-agents-for-beginners)
- [Generativ AI for Begyndere med .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generativ AI for Begyndere med JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Generativ AI for Begyndere](https://github.com/microsoft/generative-ai-for-beginners)
- [ML for Begyndere](https://aka.ms/ml-beginners)
- [Data Science for Begyndere](https://aka.ms/datascience-beginners)
- [AI for Begyndere](https://aka.ms/ai-beginners)
- [Cybersikkerhed for Begyndere](https://github.com/microsoft/Security-101)
- [Webudvikling for Begyndere](https://aka.ms/webdev-beginners)
- [IoT for Begyndere](https://aka.ms/iot-beginners)
- [XR Udvikling for Begyndere](https://github.com/microsoft/xr-development-for-beginners)
- [Mastering GitHub Copilot for AI Paired Programming](https://aka.ms/GitHubCopilotAI)
- [Mastering GitHub Copilot for C#/.NET Developers](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Choose Your Own Copilot Adventure](https://github.com/microsoft/CopilotAdventures)
- [RAG Chat App med Azure AI Services](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## Få Hjælp

Hvis du sidder fast eller har spørgsmål om opbygning af AI-applikationer, så deltag i:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Hvis du har produktfeedback eller oplever fejl under opbygning, besøg:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**Ansvarsfraskrivelse**:  
Dette dokument er blevet oversat ved hjælp af AI-oversættelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selvom vi bestræber os på at opnå nøjagtighed, skal det bemærkes, at automatiserede oversættelser kan indeholde fejl eller unøjagtigheder. Det originale dokument på dets oprindelige sprog bør betragtes som den autoritative kilde. For kritisk information anbefales professionel menneskelig oversættelse. Vi påtager os ikke ansvar for misforståelser eller fejltolkninger, der måtte opstå som følge af brugen af denne oversættelse.