<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "00950ee1a40a84676b50da356c3a964a",
  "translation_date": "2025-10-11T10:35:40+00:00",
  "source_file": "README.md",
  "language_code": "sl"
}
-->
# Generativna umetna inteligenca za začetnike - Java izdaja
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generativna umetna inteligenca za začetnike - Java izdaja](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.sl.png)

**Časovna zaveza**: Celotno delavnico lahko dokončate na spletu brez lokalne namestitve. Nastavitev okolja traja 2 minuti, raziskovanje primerov pa zahteva 1-3 ure, odvisno od globine raziskovanja.

> **Hiter začetek**

1. Forkajte to repozitorij na svoj GitHub račun
2. Kliknite **Code** → zavihek **Codespaces** → **...** → **New with options...**
3. Uporabite privzete nastavitve – to bo izbralo razvojni kontejner, ustvarjen za ta tečaj
4. Kliknite **Create codespace**
5. Počakajte približno 2 minuti, da je okolje pripravljeno
6. Takoj začnite z [Prvim primerom](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Podpora za več jezikov

### Podprto prek GitHub Action (samodejno in vedno posodobljeno)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabic](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgarian](../bg/README.md) | [Burmese (Myanmar)](../my/README.md) | [Chinese (Simplified)](../zh/README.md) | [Chinese (Traditional, Hong Kong)](../hk/README.md) | [Chinese (Traditional, Macau)](../mo/README.md) | [Chinese (Traditional, Taiwan)](../tw/README.md) | [Croatian](../hr/README.md) | [Czech](../cs/README.md) | [Danish](../da/README.md) | [Dutch](../nl/README.md) | [Estonian](../et/README.md) | [Finnish](../fi/README.md) | [French](../fr/README.md) | [German](../de/README.md) | [Greek](../el/README.md) | [Hebrew](../he/README.md) | [Hindi](../hi/README.md) | [Hungarian](../hu/README.md) | [Indonesian](../id/README.md) | [Italian](../it/README.md) | [Japanese](../ja/README.md) | [Korean](../ko/README.md) | [Lithuanian](../lt/README.md) | [Malay](../ms/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Norwegian](../no/README.md) | [Persian (Farsi)](../fa/README.md) | [Polish](../pl/README.md) | [Portuguese (Brazil)](../br/README.md) | [Portuguese (Portugal)](../pt/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Romanian](../ro/README.md) | [Russian](../ru/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Slovak](../sk/README.md) | [Slovenian](./README.md) | [Spanish](../es/README.md) | [Swahili](../sw/README.md) | [Swedish](../sv/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Tamil](../ta/README.md) | [Thai](../th/README.md) | [Turkish](../tr/README.md) | [Ukrainian](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamese](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Struktura tečaja in učna pot

### **Poglavje 1: Uvod v generativno umetno inteligenco**
- **Osnovni koncepti**: Razumevanje velikih jezikovnih modelov, tokenov, vektorskih predstavitev in zmogljivosti AI
- **Java AI ekosistem**: Pregled Spring AI in OpenAI SDK-jev
- **Protokol konteksta modela**: Uvod v MCP in njegovo vlogo pri komunikaciji AI agentov
- **Praktične aplikacije**: Resnični scenariji, vključno s klepetalniki in generiranjem vsebine
- **[→ Začni poglavje 1](./01-IntroToGenAI/README.md)**

### **Poglavje 2: Nastavitev razvojnega okolja**
- **Konfiguracija več ponudnikov**: Nastavitev GitHub modelov, Azure OpenAI in OpenAI Java SDK integracij
- **Spring Boot + Spring AI**: Najboljše prakse za razvoj AI aplikacij v podjetjih
- **GitHub modeli**: Brezplačen dostop do AI modelov za prototipiranje in učenje (brez kreditne kartice)
- **Razvojna orodja**: Konfiguracija Docker kontejnerjev, VS Code in GitHub Codespaces
- **[→ Začni poglavje 2](./02-SetupDevEnvironment/README.md)**

### **Poglavje 3: Osnovne tehnike generativne umetne inteligence**
- **Inženiring pozivov**: Tehnike za optimalne odgovore AI modelov
- **Vektorske predstavitve in operacije**: Implementacija semantičnega iskanja in ujemanja podobnosti
- **Generacija z obogatenim iskanjem (RAG)**: Kombinacija AI z vašimi lastnimi podatkovnimi viri
- **Klicanje funkcij**: Razširitev zmogljivosti AI z orodji in vtičniki po meri
- **[→ Začni poglavje 3](./03-CoreGenerativeAITechniques/README.md)**

### **Poglavje 4: Praktične aplikacije in projekti**
- **Generator zgodb o hišnih ljubljenčkih** (`petstory/`): Kreativno generiranje vsebine z GitHub modeli
- **Foundry lokalna predstavitev** (`foundrylocal/`): Lokalna integracija AI modelov z OpenAI Java SDK
- **MCP kalkulatorska storitev** (`calculator/`): Osnovna implementacija protokola konteksta modela z Spring AI
- **[→ Začni poglavje 4](./04-PracticalSamples/README.md)**

### **Poglavje 5: Razvoj odgovorne umetne inteligence**
- **Varnost GitHub modelov**: Testiranje vgrajenega filtriranja vsebine in varnostnih mehanizmov (trdi bloki in mehke zavrnitve)
- **Predstavitev odgovorne AI**: Praktičen primer, ki prikazuje, kako sodobni varnostni sistemi AI delujejo v praksi
- **Najboljše prakse**: Ključne smernice za etični razvoj in uvajanje AI
- **[→ Začni poglavje 5](./05-ResponsibleGenAI/README.md)**

## Dodatni viri

- [Edge AI za začetnike](https://github.com/microsoft/edgeai-for-beginners)
- [MCP za začetnike](https://github.com/microsoft/mcp-for-beginners)
- [AI agenti za začetnike](https://github.com/microsoft/ai-agents-for-beginners)
- [Generativna umetna inteligenca za začetnike z uporabo .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generativna umetna inteligenca za začetnike z uporabo JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Generativna umetna inteligenca za začetnike](https://github.com/microsoft/generative-ai-for-beginners)
- [Strojno učenje za začetnike](https://aka.ms/ml-beginners)
- [Podatkovna znanost za začetnike](https://aka.ms/datascience-beginners)
- [Umetna inteligenca za začetnike](https://aka.ms/ai-beginners)
- [Kibernetska varnost za začetnike](https://github.com/microsoft/Security-101)
- [Spletni razvoj za začetnike](https://aka.ms/webdev-beginners)
- [IoT za začetnike](https://aka.ms/iot-beginners)
- [XR razvoj za začetnike](https://github.com/microsoft/xr-development-for-beginners)
- [Obvladovanje GitHub Copilot za AI programiranje v paru](https://aka.ms/GitHubCopilotAI)
- [Obvladovanje GitHub Copilot za C#/.NET razvijalce](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Izberite svojo Copilot pustolovščino](https://github.com/microsoft/CopilotAdventures)
- [RAG klepetalna aplikacija z Azure AI storitvami](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## Pomoč

Če se zataknete ali imate kakršna koli vprašanja o gradnji AI aplikacij, se pridružite:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Če imate povratne informacije o izdelku ali napake med gradnjo, obiščite:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**Omejitev odgovornosti**:  
Ta dokument je bil preveden z uporabo storitve AI za prevajanje [Co-op Translator](https://github.com/Azure/co-op-translator). Čeprav si prizadevamo za natančnost, vas prosimo, da upoštevate, da lahko avtomatizirani prevodi vsebujejo napake ali netočnosti. Izvirni dokument v njegovem izvirnem jeziku je treba obravnavati kot avtoritativni vir. Za ključne informacije priporočamo profesionalni človeški prevod. Ne odgovarjamo za morebitna nesporazumevanja ali napačne razlage, ki izhajajo iz uporabe tega prevoda.