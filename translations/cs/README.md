<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "ff595bec5b6294cb68860d540eae6302",
  "translation_date": "2025-11-18T17:36:24+00:00",
  "source_file": "README.md",
  "language_code": "cs"
}
-->
# Generativní AI pro začátečníky - Java edice
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generativní AI pro začátečníky - Java edice](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.cs.png)

**Časová náročnost**: Celý workshop lze dokončit online bez nutnosti lokálního nastavení. Nastavení prostředí zabere 2 minuty, prozkoumání ukázek vyžaduje 1-3 hodiny v závislosti na hloubce průzkumu.

> **Rychlý start** 

1. Forkněte tento repozitář do svého GitHub účtu
2. Klikněte na **Code** → záložka **Codespaces** → **...** → **New with options...**
3. Použijte výchozí nastavení – to vybere vývojový kontejner vytvořený pro tento kurz
4. Klikněte na **Create codespace**
5. Počkejte ~2 minuty, než bude prostředí připraveno
6. Přejděte rovnou na [První příklad](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Podpora více jazyků

### Podporováno prostřednictvím GitHub Action (Automatizované & vždy aktuální)

[Arabština](../ar/README.md) | [Bengálština](../bn/README.md) | [Bulharština](../bg/README.md) | [Barmština (Myanmar)](../my/README.md) | [Čínština (zjednodušená)](../zh/README.md) | [Čínština (tradiční, Hongkong)](../hk/README.md) | [Čínština (tradiční, Macao)](../mo/README.md) | [Čínština (tradiční, Tchaj-wan)](../tw/README.md) | [Chorvatština](../hr/README.md) | [Čeština](./README.md) | [Dánština](../da/README.md) | [Nizozemština](../nl/README.md) | [Estonština](../et/README.md) | [Finština](../fi/README.md) | [Francouzština](../fr/README.md) | [Němčina](../de/README.md) | [Řečtina](../el/README.md) | [Hebrejština](../he/README.md) | [Hindština](../hi/README.md) | [Maďarština](../hu/README.md) | [Indonéština](../id/README.md) | [Italština](../it/README.md) | [Japonština](../ja/README.md) | [Korejština](../ko/README.md) | [Litevština](../lt/README.md) | [Malajština](../ms/README.md) | [Maráthština](../mr/README.md) | [Nepálština](../ne/README.md) | [Nigerijský pidgin](../pcm/README.md) | [Norština](../no/README.md) | [Perština (Fársí)](../fa/README.md) | [Polština](../pl/README.md) | [Portugalština (Brazílie)](../br/README.md) | [Portugalština (Portugalsko)](../pt/README.md) | [Paňdžábština (Gurmukhi)](../pa/README.md) | [Rumunština](../ro/README.md) | [Ruština](../ru/README.md) | [Srbština (cyrilice)](../sr/README.md) | [Slovenština](../sk/README.md) | [Slovinština](../sl/README.md) | [Španělština](../es/README.md) | [Svahilština](../sw/README.md) | [Švédština](../sv/README.md) | [Tagalog (Filipínština)](../tl/README.md) | [Tamilština](../ta/README.md) | [Thajština](../th/README.md) | [Turečtina](../tr/README.md) | [Ukrajinština](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamština](../vi/README.md)

## Struktura kurzu & vzdělávací cesta

### **Kapitola 1: Úvod do generativní AI**
- **Základní koncepty**: Porozumění velkým jazykovým modelům, tokenům, embeddingům a schopnostem AI
- **Java AI ekosystém**: Přehled Spring AI a OpenAI SDK
- **Protokol Model Context**: Úvod do MCP a jeho role v komunikaci AI agentů
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
- **Embeddingy & vektorové operace**: Implementace sémantického vyhledávání a porovnávání podobnosti
- **Retrieval-Augmented Generation (RAG)**: Kombinace AI s vlastními datovými zdroji
- **Volání funkcí**: Rozšíření schopností AI pomocí vlastních nástrojů a pluginů
- **[→ Začít kapitolu 3](./03-CoreGenerativeAITechniques/README.md)**

### **Kapitola 4: Praktické aplikace & projekty**
- **Generátor příběhů o mazlíčcích** (`petstory/`): Kreativní generování obsahu s GitHub Models
- **Foundry Local Demo** (`foundrylocal/`): Integrace lokálního AI modelu s OpenAI Java SDK
- **MCP Kalkulačka** (`calculator/`): Základní implementace Model Context Protocol se Spring AI
- **[→ Začít kapitolu 4](./04-PracticalSamples/README.md)**

### **Kapitola 5: Odpovědný vývoj AI**
- **Bezpečnost GitHub Models**: Testování vestavěného filtrování obsahu a bezpečnostních mechanismů (tvrdé bloky a měkké odmítnutí)
- **Demo odpovědné AI**: Praktický příklad ukazující, jak moderní bezpečnostní systémy AI fungují v praxi
- **Nejlepší postupy**: Základní pokyny pro etický vývoj a nasazení AI
- **[→ Začít kapitolu 5](./05-ResponsibleGenAI/README.md)**

## Další zdroje

### Azure / Edge / MCP / Agenti
[![AZD pro začátečníky](https://img.shields.io/badge/AZD%20pro%20začátečníky-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI pro začátečníky](https://img.shields.io/badge/Edge%20AI%20pro%20začátečníky-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP pro začátečníky](https://img.shields.io/badge/MCP%20pro%20začátečníky-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI Agenti pro začátečníky](https://img.shields.io/badge/AI%20Agenti%20pro%20začátečníky-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### Série Generativní AI
[![Generativní AI pro začátečníky](https://img.shields.io/badge/Generativní%20AI%20pro%20začátečníky-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generativní AI (.NET)](https://img.shields.io/badge/Generativní%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generativní AI (Java)](https://img.shields.io/badge/Generativní%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generativní AI (JavaScript)](https://img.shields.io/badge/Generativní%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---

### Základní vzdělávání
[![ML pro začátečníky](https://img.shields.io/badge/ML%20pro%20začátečníky-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Data Science pro začátečníky](https://img.shields.io/badge/Data%20Science%20pro%20začátečníky-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI pro začátečníky](https://img.shields.io/badge/AI%20pro%20začátečníky-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Kybernetická bezpečnost pro začátečníky](https://img.shields.io/badge/Kybernetická%20bezpečnost%20pro%20začátečníky-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Webový vývoj pro začátečníky](https://img.shields.io/badge/Webový%20vývoj%20pro%20začátečníky-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT pro začátečníky](https://img.shields.io/badge/IoT%20pro%20začátečníky-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![Vývoj XR pro začátečníky](https://img.shields.io/badge/Vývoj%20XR%20pro%20začátečníky-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### Série Copilot
[![Copilot pro AI párové programování](https://img.shields.io/badge/Copilot%20pro%20AI%20párové%20programování-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot pro C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)  
[![Copilot Dobrodružství](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)  
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## Získání pomoci

Pokud narazíte na problém nebo máte otázky ohledně vytváření AI aplikací, připojte se k diskuzím o MCP s ostatními studenty a zkušenými vývojáři. Je to podpůrná komunita, kde jsou otázky vítány a znalosti se volně sdílejí.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

Pokud máte zpětnou vazbu k produktu nebo narazíte na chyby při vývoji, navštivte:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Prohlášení**:  
Tento dokument byl přeložen pomocí služby AI pro překlad [Co-op Translator](https://github.com/Azure/co-op-translator). I když se snažíme o přesnost, mějte prosím na paměti, že automatické překlady mohou obsahovat chyby nebo nepřesnosti. Původní dokument v jeho rodném jazyce by měl být považován za autoritativní zdroj. Pro důležité informace se doporučuje profesionální lidský překlad. Nejsme zodpovědní za jakékoli nedorozumění nebo nesprávné interpretace vyplývající z použití tohoto překladu.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->