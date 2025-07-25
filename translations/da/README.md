<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a49b35508745c032a0033d914df7901b",
  "translation_date": "2025-07-25T09:36:37+00:00",
  "source_file": "README.md",
  "language_code": "da"
}
-->
# Generativ AI for begyndere - Java-udgave
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generativ AI for begyndere - Java-udgave](../../translated_images/beg-genai-series.61edc4a6b2cc54284fa2d70eda26dc0ca2669e26e49655b842ea799cd6e16d2a.da.png)

**Tidsforbrug**: Hele workshoppen kan gennemføres online uden lokal opsætning. Hvis du ønsker at køre eksemplerne, tager miljøopsætningen 2 minutter, og det kræver 1-3 timer at udforske eksemplerne, afhængigt af hvor dybt du går.

> **Hurtig start**

1. Fork dette repository til din GitHub-konto
2. Klik på **Code** → **Codespaces** fanen → **...** → **New with options...**
3. Brug standardindstillingerne – dette vælger den udviklingscontainer, der er oprettet til dette kursus
4. Klik på **Create codespace**
5. Vent ca. 2 minutter, indtil miljøet er klar
6. Gå direkte til [Oprettelse af din GitHub Models Token](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Flersproget support

### Understøttet via GitHub Action (Automatisk & altid opdateret)

[Fransk](../fr/README.md) | [Spansk](../es/README.md) | [Tysk](../de/README.md) | [Russisk](../ru/README.md) | [Arabisk](../ar/README.md) | [Persisk (Farsi)](../fa/README.md) | [Urdu](../ur/README.md) | [Kinesisk (Forenklet)](../zh/README.md) | [Kinesisk (Traditionel, Macau)](../mo/README.md) | [Kinesisk (Traditionel, Hong Kong)](../hk/README.md) | [Kinesisk (Traditionel, Taiwan)](../tw/README.md) | [Japansk](../ja/README.md) | [Koreansk](../ko/README.md) | [Hindi](../hi/README.md) | [Bengali](../bn/README.md) | [Marathi](../mr/README.md) | [Nepalesisk](../ne/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Portugisisk (Portugal)](../pt/README.md) | [Portugisisk (Brasilien)](../br/README.md) | [Italiensk](../it/README.md) | [Polsk](../pl/README.md) | [Tyrkisk](../tr/README.md) | [Græsk](../el/README.md) | [Thai](../th/README.md) | [Svensk](../sv/README.md) | [Dansk](./README.md) | [Norsk](../no/README.md) | [Finsk](../fi/README.md) | [Hollandsk](../nl/README.md) | [Hebraisk](../he/README.md) | [Vietnamesisk](../vi/README.md) | [Indonesisk](../id/README.md) | [Malay](../ms/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Swahili](../sw/README.md) | [Ungarsk](../hu/README.md) | [Tjekkisk](../cs/README.md) | [Slovakisk](../sk/README.md) | [Rumænsk](../ro/README.md) | [Bulgarsk](../bg/README.md) | [Serbisk (Kyrillisk)](../sr/README.md) | [Kroatisk](../hr/README.md) | [Slovensk](../sl/README.md) | [Ukrainsk](../uk/README.md) | [Burmesisk (Myanmar)](../my/README.md)

## Kursusstruktur & læringssti

### **Kapitel 1: Introduktion til generativ AI**
- **Kernebegreber**: Forståelse af store sprogmodeller, tokens, embeddings og AI-kapaciteter
- **Java AI-økosystem**: Oversigt over Spring AI og OpenAI SDK'er
- **Model Context Protocol**: Introduktion til MCP og dens rolle i AI-agentkommunikation
- **Praktiske anvendelser**: Virkelige scenarier, herunder chatbots og indholdsgenerering
- **[→ Start kapitel 1](./01-IntroToGenAI/README.md)**

### **Kapitel 2: Opsætning af udviklingsmiljø**
- **Multi-udbyder konfiguration**: Opsætning af GitHub Models, Azure OpenAI og OpenAI Java SDK-integrationer
- **Spring Boot + Spring AI**: Bedste praksis for udvikling af AI-applikationer til virksomheder
- **GitHub Models**: Gratis adgang til AI-modeller til prototyper og læring (ingen kreditkort påkrævet)
- **Udviklingsværktøjer**: Konfiguration af Docker-containere, VS Code og GitHub Codespaces
- **[→ Start kapitel 2](./02-SetupDevEnvironment/README.md)**

### **Kapitel 3: Kerne generative AI-teknikker**
- **Prompt Engineering**: Teknikker til at opnå optimale AI-modelsvar
- **Embeddings & vektoroperationer**: Implementer semantisk søgning og lighedsmatching
- **Retrieval-Augmented Generation (RAG)**: Kombiner AI med dine egne datakilder
- **Funktionskald**: Udvid AI-kapaciteter med brugerdefinerede værktøjer og plugins
- **[→ Start kapitel 3](./03-CoreGenerativeAITechniques/README.md)**

### **Kapitel 4: Praktiske anvendelser & projekter**
- **Pet Story Generator** (`petstory/`): Kreativ indholdsgenerering med GitHub Models
- **Foundry Local Demo** (`foundrylocal/`): Lokal AI-modelintegration med OpenAI Java SDK
- **MCP Calculator Service** (`mcp/calculator/`): Grundlæggende implementering af Model Context Protocol med Spring AI
- **[→ Start kapitel 4](./04-PracticalSamples/README.md)**

### **Kapitel 5: Ansvarlig AI-udvikling**
- **GitHub Models sikkerhed**: Test af indbyggede indholdsfiltre og sikkerhedsmekanismer
- **Ansvarlig AI-demo**: Praktisk eksempel, der viser, hvordan AI-sikkerhedsfiltre fungerer i praksis
- **Bedste praksis**: Vigtige retningslinjer for etisk AI-udvikling og implementering
- **[→ Start kapitel 5](./05-ResponsibleGenAI/README.md)**

## Yderligere ressourcer 

- [AI-agenter for begyndere](https://github.com/microsoft/ai-agents-for-beginners)
- [Generativ AI for begyndere med .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generativ AI for begyndere med JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Generativ AI for begyndere](https://github.com/microsoft/generative-ai-for-beginners)
- [ML for begyndere](https://aka.ms/ml-beginners)
- [Data Science for begyndere](https://aka.ms/datascience-beginners)
- [AI for begyndere](https://aka.ms/ai-beginners)
- [Cybersikkerhed for begyndere](https://github.com/microsoft/Security-101)
- [Webudvikling for begyndere](https://aka.ms/webdev-beginners)
- [IoT for begyndere](https://aka.ms/iot-beginners)
- [XR-udvikling for begyndere](https://github.com/microsoft/xr-development-for-beginners)
- [Mastering GitHub Copilot for AI Paired Programming](https://aka.ms/GitHubCopilotAI)
- [Mastering GitHub Copilot for C#/.NET Developers](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Vælg dit eget Copilot-eventyr](https://github.com/microsoft/CopilotAdventures)
- [RAG Chat App med Azure AI Services](https://github.com/Azure-Samples/azure-search-openai-demo-java)

**Ansvarsfraskrivelse**:  
Dette dokument er blevet oversat ved hjælp af AI-oversættelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selvom vi bestræber os på at sikre nøjagtighed, skal det bemærkes, at automatiserede oversættelser kan indeholde fejl eller unøjagtigheder. Det originale dokument på dets oprindelige sprog bør betragtes som den autoritative kilde. For kritisk information anbefales professionel menneskelig oversættelse. Vi påtager os ikke ansvar for eventuelle misforståelser eller fejltolkninger, der måtte opstå som følge af brugen af denne oversættelse.