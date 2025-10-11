<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "00950ee1a40a84676b50da356c3a964a",
  "translation_date": "2025-10-11T10:38:29+00:00",
  "source_file": "README.md",
  "language_code": "et"
}
-->
# Generatiivne AI algajatele - Java versioon
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generatiivne AI algajatele - Java versioon](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.et.png)

**Ajakulu**: Kogu töötuba saab läbida veebis ilma kohalikku seadistust tegemata. Keskkonna seadistamine võtab 2 minutit, näidiste uurimine 1-3 tundi, sõltuvalt süvenemise tasemest.

> **Kiire algus**

1. Forki see repositoorium oma GitHubi kontole
2. Klõpsa **Code** → **Codespaces** vahekaart → **...** → **New with options...**
3. Kasuta vaikeseadeid – see valib selle kursuse jaoks loodud arenduskonteineri
4. Klõpsa **Create codespace**
5. Oota ~2 minutit, kuni keskkond on valmis
6. Alusta kohe [Esimesest näitest](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Mitmekeelne tugi

### Toetatud GitHub Actioni kaudu (automaatne ja alati ajakohane)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Araabia](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgaaria](../bg/README.md) | [Birma (Myanmar)](../my/README.md) | [Hiina (lihtsustatud)](../zh/README.md) | [Hiina (traditsiooniline, Hongkong)](../hk/README.md) | [Hiina (traditsiooniline, Macau)](../mo/README.md) | [Hiina (traditsiooniline, Taiwan)](../tw/README.md) | [Horvaatia](../hr/README.md) | [Tšehhi](../cs/README.md) | [Taani](../da/README.md) | [Hollandi](../nl/README.md) | [Eesti](./README.md) | [Soome](../fi/README.md) | [Prantsuse](../fr/README.md) | [Saksa](../de/README.md) | [Kreeka](../el/README.md) | [Heebrea](../he/README.md) | [Hindi](../hi/README.md) | [Ungari](../hu/README.md) | [Indoneesia](../id/README.md) | [Itaalia](../it/README.md) | [Jaapani](../ja/README.md) | [Korea](../ko/README.md) | [Leedu](../lt/README.md) | [Malai](../ms/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Norra](../no/README.md) | [Pärsia (Farsi)](../fa/README.md) | [Poola](../pl/README.md) | [Portugali (Brasiilia)](../br/README.md) | [Portugali (Portugal)](../pt/README.md) | [Pandžabi (Gurmukhi)](../pa/README.md) | [Rumeenia](../ro/README.md) | [Vene](../ru/README.md) | [Serbia (kirillitsa)](../sr/README.md) | [Slovaki](../sk/README.md) | [Sloveeni](../sl/README.md) | [Hispaania](../es/README.md) | [Suahiili](../sw/README.md) | [Rootsi](../sv/README.md) | [Tagalogi (Filipino)](../tl/README.md) | [Tamili](../ta/README.md) | [Tai](../th/README.md) | [Türgi](../tr/README.md) | [Ukraina](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnami](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Kursuse struktuur ja õpiteekond

### **1. peatükk: Generatiivse AI tutvustus**
- **Põhimõisted**: Suurte keelemudelite, tokenite, sisendite ja AI võimekuste mõistmine
- **Java AI ökosüsteem**: Ülevaade Spring AI ja OpenAI SDK-dest
- **Model Context Protocol**: MCP tutvustus ja selle roll AI agentide suhtluses
- **Praktilised rakendused**: Reaalsed näited, sealhulgas vestlusrobotid ja sisuloome
- **[→ Alusta 1. peatükki](./01-IntroToGenAI/README.md)**

### **2. peatükk: Arenduskeskkonna seadistamine**
- **Mitme pakkuja konfiguratsioon**: GitHubi mudelite, Azure OpenAI ja OpenAI Java SDK integreerimine
- **Spring Boot + Spring AI**: Parimad tavad ettevõtte AI rakenduste arendamiseks
- **GitHubi mudelid**: Tasuta AI mudelite kasutamine prototüüpimiseks ja õppimiseks (krediitkaarti pole vaja)
- **Arendustööriistad**: Docker konteinerid, VS Code ja GitHub Codespaces konfiguratsioon
- **[→ Alusta 2. peatükki](./02-SetupDevEnvironment/README.md)**

### **3. peatükk: Generatiivse AI põhitehnikad**
- **Prompt Engineering**: Tehnikad AI mudelite optimaalseks vastuseks
- **Sisendid ja vektoroperatsioonid**: Semantilise otsingu ja sarnasuse rakendamine
- **Retrieval-Augmented Generation (RAG)**: AI kombineerimine oma andmeallikatega
- **Funktsioonide kutsumine**: AI võimekuste laiendamine kohandatud tööriistade ja pluginatega
- **[→ Alusta 3. peatükki](./03-CoreGenerativeAITechniques/README.md)**

### **4. peatükk: Praktilised rakendused ja projektid**
- **Lemmikloolugude generaator** (`petstory/`): Loov sisuloome GitHubi mudelitega
- **Foundry kohalik demo** (`foundrylocal/`): Kohaliku AI mudeli integreerimine OpenAI Java SDK-ga
- **MCP kalkulaatoriteenus** (`calculator/`): Põhiline Model Context Protocol rakendus Spring AI-ga
- **[→ Alusta 4. peatükki](./04-PracticalSamples/README.md)**

### **5. peatükk: Vastutustundlik AI arendus**
- **GitHubi mudelite turvalisus**: Sisseehitatud sisufiltri ja turvamehhanismide testimine (kõvad blokeeringud ja pehmed keeldumised)
- **Vastutustundliku AI demo**: Praktiline näide, kuidas kaasaegsed AI turvasüsteemid töötavad
- **Parimad tavad**: Olulised juhised eetiliseks AI arenduseks ja kasutuselevõtuks
- **[→ Alusta 5. peatükki](./05-ResponsibleGenAI/README.md)**

## Lisamaterjalid

- [Edge AI algajatele](https://github.com/microsoft/edgeai-for-beginners)
- [MCP algajatele](https://github.com/microsoft/mcp-for-beginners)
- [AI agendid algajatele](https://github.com/microsoft/ai-agents-for-beginners)
- [Generatiivne AI algajatele .NET-i kasutades](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generatiivne AI algajatele JavaScripti kasutades](https://github.com/microsoft/generative-ai-with-javascript)
- [Generatiivne AI algajatele](https://github.com/microsoft/generative-ai-for-beginners)
- [ML algajatele](https://aka.ms/ml-beginners)
- [Andmeteadus algajatele](https://aka.ms/datascience-beginners)
- [AI algajatele](https://aka.ms/ai-beginners)
- [Küberjulgeolek algajatele](https://github.com/microsoft/Security-101)
- [Veebiarendus algajatele](https://aka.ms/webdev-beginners)
- [IoT algajatele](https://aka.ms/iot-beginners)
- [XR arendus algajatele](https://github.com/microsoft/xr-development-for-beginners)
- [GitHub Copiloti meistriklass AI paarisprogrammeerimiseks](https://aka.ms/GitHubCopilotAI)
- [GitHub Copiloti meistriklass C#/.NET arendajatele](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Vali oma Copiloti seiklus](https://github.com/microsoft/CopilotAdventures)
- [RAG vestlusrakendus Azure AI teenustega](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## Abi saamine

Kui jääd hätta või sul on küsimusi AI rakenduste loomise kohta, liitu:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Kui sul on tootetagasisidet või vigu arendamisel, külasta:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**Lahtiütlus**:  
See dokument on tõlgitud, kasutades AI tõlketeenust [Co-op Translator](https://github.com/Azure/co-op-translator). Kuigi püüame tagada täpsust, palun arvestage, et automaatsed tõlked võivad sisaldada vigu või ebatäpsusi. Algne dokument selle algkeeles tuleks lugeda autoriteetseks allikaks. Olulise teabe puhul on soovitatav kasutada professionaalset inimtõlget. Me ei vastuta selle tõlke kasutamisest tulenevate arusaamatuste või valede tõlgenduste eest.