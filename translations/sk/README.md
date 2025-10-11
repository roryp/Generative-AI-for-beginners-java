<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "00950ee1a40a84676b50da356c3a964a",
  "translation_date": "2025-10-11T10:33:23+00:00",
  "source_file": "README.md",
  "language_code": "sk"
}
-->
# Generatívna AI pre začiatočníkov - Java edícia
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generatívna AI pre začiatočníkov - Java edícia](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.sk.png)

**Časová náročnosť**: Celý workshop je možné dokončiť online bez lokálneho nastavenia. Nastavenie prostredia trvá 2 minúty, pričom skúmanie príkladov si vyžaduje 1-3 hodiny v závislosti od hĺbky skúmania.

> **Rýchly štart**

1. Forknite tento repozitár do svojho GitHub účtu
2. Kliknite na **Code** → záložka **Codespaces** → **...** → **New with options...**
3. Použite predvolené nastavenia – vyberie sa vývojový kontajner vytvorený pre tento kurz
4. Kliknite na **Create codespace**
5. Počkajte ~2 minúty, kým bude prostredie pripravené
6. Prejdite priamo na [Prvý príklad](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Podpora viacerých jazykov

### Podporované cez GitHub Action (Automatizované & vždy aktuálne)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabčina](../ar/README.md) | [Bengálčina](../bn/README.md) | [Bulharčina](../bg/README.md) | [Barmčina (Mjanmarsko)](../my/README.md) | [Čínština (zjednodušená)](../zh/README.md) | [Čínština (tradičná, Hongkong)](../hk/README.md) | [Čínština (tradičná, Macao)](../mo/README.md) | [Čínština (tradičná, Taiwan)](../tw/README.md) | [Chorvátčina](../hr/README.md) | [Čeština](../cs/README.md) | [Dánčina](../da/README.md) | [Holandčina](../nl/README.md) | [Estónčina](../et/README.md) | [Fínčina](../fi/README.md) | [Francúzština](../fr/README.md) | [Nemčina](../de/README.md) | [Gréčtina](../el/README.md) | [Hebrejčina](../he/README.md) | [Hindčina](../hi/README.md) | [Maďarčina](../hu/README.md) | [Indonézčina](../id/README.md) | [Taliančina](../it/README.md) | [Japončina](../ja/README.md) | [Kórejčina](../ko/README.md) | [Litovčina](../lt/README.md) | [Malajčina](../ms/README.md) | [Maráthčina](../mr/README.md) | [Nepálčina](../ne/README.md) | [Nórčina](../no/README.md) | [Perzština (Farsí)](../fa/README.md) | [Poľština](../pl/README.md) | [Portugalčina (Brazília)](../br/README.md) | [Portugalčina (Portugalsko)](../pt/README.md) | [Pandžábčina (Gurmukhi)](../pa/README.md) | [Rumunčina](../ro/README.md) | [Ruština](../ru/README.md) | [Srbčina (cyrilika)](../sr/README.md) | [Slovenčina](./README.md) | [Slovinčina](../sl/README.md) | [Španielčina](../es/README.md) | [Swahilčina](../sw/README.md) | [Švédčina](../sv/README.md) | [Tagalog (Filipínčina)](../tl/README.md) | [Tamilčina](../ta/README.md) | [Thajčina](../th/README.md) | [Turečtina](../tr/README.md) | [Ukrajinčina](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamčina](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Štruktúra kurzu & učebná cesta

### **Kapitola 1: Úvod do generatívnej AI**
- **Základné koncepty**: Porozumenie veľkým jazykovým modelom, tokenom, embeddingom a schopnostiam AI
- **Java AI ekosystém**: Prehľad Spring AI a OpenAI SDK
- **Protokol kontextu modelu**: Úvod do MCP a jeho úlohy v komunikácii AI agentov
- **Praktické aplikácie**: Reálne scenáre vrátane chatbotov a generovania obsahu
- **[→ Začať kapitolu 1](./01-IntroToGenAI/README.md)**

### **Kapitola 2: Nastavenie vývojového prostredia**
- **Konfigurácia viacerých poskytovateľov**: Nastavenie GitHub modelov, Azure OpenAI a OpenAI Java SDK integrácií
- **Spring Boot + Spring AI**: Najlepšie postupy pre vývoj podnikových AI aplikácií
- **GitHub modely**: Bezplatný prístup k AI modelom na prototypovanie a učenie (bez potreby kreditnej karty)
- **Vývojové nástroje**: Konfigurácia Docker kontajnerov, VS Code a GitHub Codespaces
- **[→ Začať kapitolu 2](./02-SetupDevEnvironment/README.md)**

### **Kapitola 3: Základné techniky generatívnej AI**
- **Prompt Engineering**: Techniky na dosiahnutie optimálnych odpovedí AI modelov
- **Embeddingy & vektorové operácie**: Implementácia semantického vyhľadávania a porovnávania podobnosti
- **Generovanie s podporou vyhľadávania (RAG)**: Kombinácia AI s vlastnými dátovými zdrojmi
- **Volanie funkcií**: Rozšírenie schopností AI pomocou vlastných nástrojov a pluginov
- **[→ Začať kapitolu 3](./03-CoreGenerativeAITechniques/README.md)**

### **Kapitola 4: Praktické aplikácie & projekty**
- **Generátor príbehov o domácich zvieratách** (`petstory/`): Kreatívne generovanie obsahu s GitHub modelmi
- **Foundry lokálna ukážka** (`foundrylocal/`): Lokálna integrácia AI modelov s OpenAI Java SDK
- **MCP kalkulačná služba** (`calculator/`): Základná implementácia protokolu kontextu modelu so Spring AI
- **[→ Začať kapitolu 4](./04-PracticalSamples/README.md)**

### **Kapitola 5: Zodpovedný vývoj AI**
- **Bezpečnosť GitHub modelov**: Testovanie zabudovaného filtrovania obsahu a bezpečnostných mechanizmov (tvrdé bloky a mäkké odmietnutia)
- **Ukážka zodpovednej AI**: Praktický príklad ukazujúci, ako moderné bezpečnostné systémy AI fungujú
- **Najlepšie postupy**: Základné pokyny pre etický vývoj a nasadenie AI
- **[→ Začať kapitolu 5](./05-ResponsibleGenAI/README.md)**

## Dodatočné zdroje

- [Edge AI pre začiatočníkov](https://github.com/microsoft/edgeai-for-beginners)
- [MCP pre začiatočníkov](https://github.com/microsoft/mcp-for-beginners)
- [AI agenti pre začiatočníkov](https://github.com/microsoft/ai-agents-for-beginners)
- [Generatívna AI pre začiatočníkov s .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generatívna AI pre začiatočníkov s JavaScriptom](https://github.com/microsoft/generative-ai-with-javascript)
- [Generatívna AI pre začiatočníkov](https://github.com/microsoft/generative-ai-for-beginners)
- [ML pre začiatočníkov](https://aka.ms/ml-beginners)
- [Data Science pre začiatočníkov](https://aka.ms/datascience-beginners)
- [AI pre začiatočníkov](https://aka.ms/ai-beginners)
- [Kybernetická bezpečnosť pre začiatočníkov](https://github.com/microsoft/Security-101)
- [Webový vývoj pre začiatočníkov](https://aka.ms/webdev-beginners)
- [IoT pre začiatočníkov](https://aka.ms/iot-beginners)
- [XR vývoj pre začiatočníkov](https://github.com/microsoft/xr-development-for-beginners)
- [Ovládnutie GitHub Copilot pre AI párové programovanie](https://aka.ms/GitHubCopilotAI)
- [Ovládnutie GitHub Copilot pre C#/.NET vývojárov](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Vyberte si vlastné dobrodružstvo s Copilotom](https://github.com/microsoft/CopilotAdventures)
- [RAG Chat App s Azure AI službami](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## Získanie pomoci

Ak narazíte na problémy alebo máte otázky ohľadom budovania AI aplikácií, pripojte sa:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Ak máte spätnú väzbu k produktu alebo chyby pri budovaní, navštívte:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**Upozornenie**:  
Tento dokument bol preložený pomocou služby AI prekladu [Co-op Translator](https://github.com/Azure/co-op-translator). Hoci sa snažíme o presnosť, prosím, berte na vedomie, že automatizované preklady môžu obsahovať chyby alebo nepresnosti. Pôvodný dokument v jeho rodnom jazyku by mal byť považovaný za autoritatívny zdroj. Pre kritické informácie sa odporúča profesionálny ľudský preklad. Nenesieme zodpovednosť za akékoľvek nedorozumenia alebo nesprávne interpretácie vyplývajúce z použitia tohto prekladu.