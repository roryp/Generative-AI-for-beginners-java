<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "00950ee1a40a84676b50da356c3a964a",
  "translation_date": "2025-10-11T10:32:57+00:00",
  "source_file": "README.md",
  "language_code": "cs"
}
-->
# Generativní AI pro začátečníky - Java edice
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generativní AI pro začátečníky - Java edice](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.cs.png)

**Časová náročnost**: Celý workshop lze dokončit online bez nutnosti lokálního nastavení. Nastavení prostředí zabere 2 minuty, průzkum ukázek vyžaduje 1–3 hodiny v závislosti na hloubce průzkumu.

> **Rychlý start** 

1. Forkněte tento repozitář do svého GitHub účtu
2. Klikněte na **Code** → záložka **Codespaces** → **...** → **New with options...**
3. Použijte výchozí nastavení – tím se vybere vývojový kontejner vytvořený pro tento kurz
4. Klikněte na **Create codespace**
5. Počkejte ~2 minuty, než bude prostředí připraveno
6. Přejděte rovnou na [První příklad](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Podpora více jazyků

### Podporováno prostřednictvím GitHub Action (automatizované a vždy aktuální)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabština](../ar/README.md) | [Bengálština](../bn/README.md) | [Bulharština](../bg/README.md) | [Barmština (Myanmar)](../my/README.md) | [Čínština (zjednodušená)](../zh/README.md) | [Čínština (tradiční, Hongkong)](../hk/README.md) | [Čínština (tradiční, Macao)](../mo/README.md) | [Čínština (tradiční, Tchaj-wan)](../tw/README.md) | [Chorvatština](../hr/README.md) | [Čeština](./README.md) | [Dánština](../da/README.md) | [Nizozemština](../nl/README.md) | [Estonština](../et/README.md) | [Finština](../fi/README.md) | [Francouzština](../fr/README.md) | [Němčina](../de/README.md) | [Řečtina](../el/README.md) | [Hebrejština](../he/README.md) | [Hindština](../hi/README.md) | [Maďarština](../hu/README.md) | [Indonéština](../id/README.md) | [Italština](../it/README.md) | [Japonština](../ja/README.md) | [Korejština](../ko/README.md) | [Litevština](../lt/README.md) | [Malajština](../ms/README.md) | [Maráthština](../mr/README.md) | [Nepálština](../ne/README.md) | [Norština](../no/README.md) | [Perština (Farsi)](../fa/README.md) | [Polština](../pl/README.md) | [Portugalština (Brazílie)](../br/README.md) | [Portugalština (Portugalsko)](../pt/README.md) | [Paňdžábština (Gurmukhi)](../pa/README.md) | [Rumunština](../ro/README.md) | [Ruština](../ru/README.md) | [Srbština (cyrilice)](../sr/README.md) | [Slovenština](../sk/README.md) | [Slovinština](../sl/README.md) | [Španělština](../es/README.md) | [Svahilština](../sw/README.md) | [Švédština](../sv/README.md) | [Tagalog (Filipíny)](../tl/README.md) | [Tamilština](../ta/README.md) | [Thajština](../th/README.md) | [Turečtina](../tr/README.md) | [Ukrajinština](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamština](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Struktura kurzu a učební cesta

### **Kapitola 1: Úvod do generativní AI**
- **Základní koncepty**: Porozumění velkým jazykovým modelům, tokenům, embeddingům a schopnostem AI
- **Java AI ekosystém**: Přehled Spring AI a OpenAI SDK
- **Protokol kontextu modelu**: Úvod do MCP a jeho role v komunikaci AI agentů
- **Praktické aplikace**: Reálné scénáře včetně chatbotů a generování obsahu
- **[→ Začít kapitolu 1](./01-IntroToGenAI/README.md)**

### **Kapitola 2: Nastavení vývojového prostředí**
- **Konfigurace více poskytovatelů**: Nastavení GitHub Models, Azure OpenAI a OpenAI Java SDK integrací
- **Spring Boot + Spring AI**: Nejlepší postupy pro vývoj podnikových AI aplikací
- **GitHub Models**: Bezplatný přístup k AI modelům pro prototypování a učení (není potřeba kreditní karta)
- **Vývojové nástroje**: Konfigurace Docker kontejnerů, VS Code a GitHub Codespaces
- **[→ Začít kapitolu 2](./02-SetupDevEnvironment/README.md)**

### **Kapitola 3: Základní techniky generativní AI**
- **Prompt Engineering**: Techniky pro optimální odpovědi AI modelů
- **Embeddingy a vektorové operace**: Implementace sémantického vyhledávání a porovnávání podobnosti
- **Generování s podporou vyhledávání (RAG)**: Kombinace AI s vlastními datovými zdroji
- **Volání funkcí**: Rozšíření schopností AI pomocí vlastních nástrojů a pluginů
- **[→ Začít kapitolu 3](./03-CoreGenerativeAITechniques/README.md)**

### **Kapitola 4: Praktické aplikace a projekty**
- **Generátor příběhů o mazlíčcích** (`petstory/`): Kreativní generování obsahu s GitHub Models
- **Foundry Local Demo** (`foundrylocal/`): Integrace lokálních AI modelů s OpenAI Java SDK
- **MCP kalkulační služba** (`calculator/`): Základní implementace protokolu kontextu modelu se Spring AI
- **[→ Začít kapitolu 4](./04-PracticalSamples/README.md)**

### **Kapitola 5: Odpovědný vývoj AI**
- **Bezpečnost GitHub Models**: Testování vestavěného filtrování obsahu a bezpečnostních mechanismů (tvrdé bloky a měkké odmítnutí)
- **Demo odpovědné AI**: Praktický příklad ukazující, jak moderní bezpečnostní systémy AI fungují
- **Nejlepší postupy**: Zásadní pokyny pro etický vývoj a nasazení AI
- **[→ Začít kapitolu 5](./05-ResponsibleGenAI/README.md)**

## Další zdroje 

- [Edge AI pro začátečníky](https://github.com/microsoft/edgeai-for-beginners)
- [MCP pro začátečníky](https://github.com/microsoft/mcp-for-beginners)
- [AI agenti pro začátečníky](https://github.com/microsoft/ai-agents-for-beginners)
- [Generativní AI pro začátečníky s .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generativní AI pro začátečníky s JavaScriptem](https://github.com/microsoft/generative-ai-with-javascript)
- [Generativní AI pro začátečníky](https://github.com/microsoft/generative-ai-for-beginners)
- [ML pro začátečníky](https://aka.ms/ml-beginners)
- [Data Science pro začátečníky](https://aka.ms/datascience-beginners)
- [AI pro začátečníky](https://aka.ms/ai-beginners)
- [Kybernetická bezpečnost pro začátečníky](https://github.com/microsoft/Security-101)
- [Webový vývoj pro začátečníky](https://aka.ms/webdev-beginners)
- [IoT pro začátečníky](https://aka.ms/iot-beginners)
- [XR vývoj pro začátečníky](https://github.com/microsoft/xr-development-for-beginners)
- [Ovládnutí GitHub Copilot pro párové programování s AI](https://aka.ms/GitHubCopilotAI)
- [Ovládnutí GitHub Copilot pro vývojáře C#/.NET](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Vyberte si vlastní dobrodružství s Copilotem](https://github.com/microsoft/CopilotAdventures)
- [RAG Chat App s Azure AI Services](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## Získání pomoci

Pokud narazíte na problém nebo máte otázky ohledně budování AI aplikací, připojte se:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Pokud máte zpětnou vazbu k produktu nebo narazíte na chyby při budování, navštivte:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**Prohlášení**:  
Tento dokument byl přeložen pomocí služby AI pro překlady [Co-op Translator](https://github.com/Azure/co-op-translator). I když se snažíme o přesnost, mějte prosím na paměti, že automatizované překlady mohou obsahovat chyby nebo nepřesnosti. Původní dokument v jeho rodném jazyce by měl být považován za autoritativní zdroj. Pro důležité informace doporučujeme profesionální lidský překlad. Neodpovídáme za žádná nedorozumění nebo nesprávné interpretace vyplývající z použití tohoto překladu.