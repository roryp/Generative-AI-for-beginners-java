<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0efa90a880213da0aeb35e43ec717e98",
  "translation_date": "2025-12-01T08:40:34+00:00",
  "source_file": "README.md",
  "language_code": "no"
}
-->
# Generativ AI for Nybegynnere - Java-utgave
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generativ AI for Nybegynnere - Java-utgave](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.no.png)

**Tidsbruk**: Hele workshoppen kan fullføres online uten lokal oppsett. Oppsett av miljøet tar 2 minutter, mens utforsking av eksemplene tar 1-3 timer avhengig av hvor dypt du ønsker å gå.

> **Kom i gang raskt**

1. Fork dette repositoriet til din GitHub-konto
2. Klikk **Code** → **Codespaces**-fanen → **...** → **New with options...**
3. Bruk standardinnstillingene – dette vil velge utviklingscontaineren som er laget for dette kurset
4. Klikk **Create codespace**
5. Vent ~2 minutter til miljøet er klart
6. Gå direkte til [Det første eksempelet](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Støtte for flere språk

### Støttet via GitHub Action (Automatisk og alltid oppdatert)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabisk](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgarsk](../bg/README.md) | [Burmesisk (Myanmar)](../my/README.md) | [Kinesisk (Forenklet)](../zh/README.md) | [Kinesisk (Tradisjonell, Hong Kong)](../hk/README.md) | [Kinesisk (Tradisjonell, Macau)](../mo/README.md) | [Kinesisk (Tradisjonell, Taiwan)](../tw/README.md) | [Kroatisk](../hr/README.md) | [Tsjekkisk](../cs/README.md) | [Dansk](../da/README.md) | [Nederlandsk](../nl/README.md) | [Estisk](../et/README.md) | [Finsk](../fi/README.md) | [Fransk](../fr/README.md) | [Tysk](../de/README.md) | [Gresk](../el/README.md) | [Hebraisk](../he/README.md) | [Hindi](../hi/README.md) | [Ungarsk](../hu/README.md) | [Indonesisk](../id/README.md) | [Italiensk](../it/README.md) | [Japansk](../ja/README.md) | [Kannada](../kn/README.md) | [Koreansk](../ko/README.md) | [Litauisk](../lt/README.md) | [Malayisk](../ms/README.md) | [Malayalam](../ml/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Nigeriansk Pidgin](../pcm/README.md) | [Norsk](./README.md) | [Persisk (Farsi)](../fa/README.md) | [Polsk](../pl/README.md) | [Portugisisk (Brasil)](../br/README.md) | [Portugisisk (Portugal)](../pt/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Rumensk](../ro/README.md) | [Russisk](../ru/README.md) | [Serbisk (Kyrillisk)](../sr/README.md) | [Slovakisk](../sk/README.md) | [Slovensk](../sl/README.md) | [Spansk](../es/README.md) | [Swahili](../sw/README.md) | [Svensk](../sv/README.md) | [Tagalog (Filippinsk)](../tl/README.md) | [Tamil](../ta/README.md) | [Telugu](../te/README.md) | [Thai](../th/README.md) | [Tyrkisk](../tr/README.md) | [Ukrainsk](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamesisk](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Kursstruktur og læringssti

### **Kapittel 1: Introduksjon til Generativ AI**
- **Kjernebegreper**: Forstå store språkmodeller, tokens, embeddings og AI-muligheter
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

### **Kapittel 3: Kjerne teknikker for Generativ AI**
- **Prompt Engineering**: Teknikker for optimale AI-modellsvar
- **Embeddings & Vektoroperasjoner**: Implementer semantisk søk og likhetsmatching
- **Retrieval-Augmented Generation (RAG)**: Kombiner AI med dine egne datakilder
- **Funksjonskall**: Utvid AI-muligheter med tilpassede verktøy og plugins
- **[→ Start Kapittel 3](./03-CoreGenerativeAITechniques/README.md)**

### **Kapittel 4: Praktiske anvendelser og prosjekter**
- **Pet Story Generator** (`petstory/`): Kreativ innholdsgenerering med GitHub-modeller
- **Foundry Local Demo** (`foundrylocal/`): Lokal AI-modellintegrasjon med OpenAI Java SDK
- **MCP Calculator Service** (`calculator/`): Grunnleggende implementering av Model Context Protocol med Spring AI
- **[→ Start Kapittel 4](./04-PracticalSamples/README.md)**

### **Kapittel 5: Ansvarlig AI-utvikling**
- **GitHub-modellers sikkerhet**: Test innebygde innholdsfiltrerings- og sikkerhetsmekanismer (harde blokker og myke avslag)
- **Ansvarlig AI-demo**: Praktisk eksempel som viser hvordan moderne AI-sikkerhetssystemer fungerer i praksis
- **Beste praksis**: Essensielle retningslinjer for etisk AI-utvikling og distribusjon
- **[→ Start Kapittel 5](./05-ResponsibleGenAI/README.md)**

## Tilleggsressurser

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### Azure / Edge / MCP / Agenter
[![AZD for Nybegynnere](https://img.shields.io/badge/AZD%20for%20Nybegynnere-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI for Nybegynnere](https://img.shields.io/badge/Edge%20AI%20for%20Nybegynnere-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP for Nybegynnere](https://img.shields.io/badge/MCP%20for%20Nybegynnere-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI Agenter for Nybegynnere](https://img.shields.io/badge/AI%20Agenter%20for%20Nybegynnere-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Generativ AI-serie
[![Generativ AI for Nybegynnere](https://img.shields.io/badge/Generativ%20AI%20for%20Nybegynnere-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generativ AI (.NET)](https://img.shields.io/badge/Generativ%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generativ AI (Java)](https://img.shields.io/badge/Generativ%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generativ AI (JavaScript)](https://img.shields.io/badge/Generativ%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### Kjerne Læring
[![ML for Nybegynnere](https://img.shields.io/badge/ML%20for%20Nybegynnere-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Data Science for Nybegynnere](https://img.shields.io/badge/Data%20Science%20for%20Nybegynnere-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI for Nybegynnere](https://img.shields.io/badge/AI%20for%20Nybegynnere-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Cybersikkerhet for Nybegynnere](https://img.shields.io/badge/Cybersikkerhet%20for%20Nybegynnere-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Webutvikling for Nybegynnere](https://img.shields.io/badge/Webutvikling%20for%20Nybegynnere-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Nybegynnere](https://img.shields.io/badge/IoT%20for%20Nybegynnere-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR-utvikling for Nybegynnere](https://img.shields.io/badge/XR%20utvikling%20for%20Nybegynnere-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Copilot-serie
[![Copilot for AI-parprogrammering](https://img.shields.io/badge/Copilot%20for%20AI-parprogrammering-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## Få hjelp

Hvis du står fast eller har spørsmål om å bygge AI-apper, kan du bli med andre lærende og erfarne utviklere i diskusjoner om MCP. Det er et støttende fellesskap der spørsmål er velkomne og kunnskap deles fritt.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

Hvis du har tilbakemeldinger på produktet eller opplever feil under bygging, besøk:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Ansvarsfraskrivelse**:  
Dette dokumentet er oversatt ved hjelp av AI-oversettelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selv om vi streber etter nøyaktighet, vær oppmerksom på at automatiserte oversettelser kan inneholde feil eller unøyaktigheter. Det originale dokumentet på sitt opprinnelige språk bør anses som den autoritative kilden. For kritisk informasjon anbefales profesjonell menneskelig oversettelse. Vi er ikke ansvarlige for eventuelle misforståelser eller feiltolkninger som oppstår ved bruk av denne oversettelsen.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->