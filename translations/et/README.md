# Generatiivne tehisintellekt algajatele - Java väljaanne
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generatiivne tehisintellekt algajatele - Java väljaanne](../../translated_images/et/beg-genai-series.8b48be9951cc574c.webp)

**Ajapühendus**: Kogu töötuba saab täita veebis ilma kohalikku seadistust tegemata. Keskkonna seadistamine võtab 2 minutit, näidiste uurimine 1-3 tundi, sõltuvalt uurimise sügavusest.

> **Kiirstart**

1. Tehke selle hoidla fork oma GitHubi kontole
2. Klõpsake **Code** → **Codespaces** vaheleht → **...** → **New with options...**
3. Kasutage vaikeseadeid – see valib kursuse jaoks loodud arenduskonteineri
4. Klõpsake **Create codespace**
5. Oodake umbes 2 minutit, kuni keskkond on valmis
6. Minge otse [Esimese näite juurde](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **Eelistate kloonida lokaalselt?**
>
> See hoidla sisaldab 50+ keele tõlget, mis suurendab märkimisväärselt allalaadimise suurust. Tõlgeteta kloonimiseks kasutage sparsereview valikut:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> See annab teile kõik vajaliku kursuse lõpetamiseks palju kiiremalt.

## Mitmekeelne tugi

### Toetatud GitHub Action'i kaudu (Automaatne ja alati ajakohane)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Araabia](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgaaria](../bg/README.md) | [Birma (Myanmar)](../my/README.md) | [Hiina (lihtsustatud)](../zh-CN/README.md) | [Hiina (traditsiooniline, Hong Kong)](../zh-HK/README.md) | [Hiina (traditsiooniline, Macau)](../zh-MO/README.md) | [Hiina (traditsiooniline, Taiwan)](../zh-TW/README.md) | [Horvaadi](../hr/README.md) | [Tšehhi](../cs/README.md) | [Taani](../da/README.md) | [Hollandi](../nl/README.md) | [Eesti](./README.md) | [Soome](../fi/README.md) | [Prantsuse](../fr/README.md) | [Saksa](../de/README.md) | [Kreeka](../el/README.md) | [Heebrea](../he/README.md) | [Hindi](../hi/README.md) | [Ungari](../hu/README.md) | [Indoneesia](../id/README.md) | [Itaalia](../it/README.md) | [Jaapani](../ja/README.md) | [Kannada](../kn/README.md) | [Korea](../ko/README.md) | [Leedu](../lt/README.md) | [Malai](../ms/README.md) | [Malayalam](../ml/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Nigeeria pidžin](../pcm/README.md) | [Norra](../no/README.md) | [Pärsia (Farsi)](../fa/README.md) | [Poola](../pl/README.md) | [Portugali (Brasiilia)](../pt-BR/README.md) | [Portugali (Portugal)](../pt-PT/README.md) | [Panjabi (Gurmukhi)](../pa/README.md) | [Rumeenia](../ro/README.md) | [Vene](../ru/README.md) | [Serbia (tsõrilitsa)](../sr/README.md) | [Slovaki](../sk/README.md) | [Sloveeni](../sl/README.md) | [Hispaania](../es/README.md) | [Suaheli](../sw/README.md) | [Rootsi](../sv/README.md) | [Tagalog (Filipiinid)](../tl/README.md) | [Tamili](../ta/README.md) | [Telugu](../te/README.md) | [Tai](../th/README.md) | [Türgi](../tr/README.md) | [Ukraina](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnami](../vi/README.md)

> **Eelistate kloonida lokaalselt?**

> See hoidla sisaldab 50+ keele tõlget, mis suurendab märkimisväärselt allalaadimise suurust. Tõlgeteta kloonimiseks kasutage sparsereview valikut:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> See annab teile kõik vajaliku kursuse lõpetamiseks palju kiiremalt.
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Kursuse struktuur ja õppeteekond

### **1. peatükk: Sissejuhatus generatiivsesse tehisintellekti**
- **Põhikontseptsioonid**: Suurte keelemudelite, tokenite, manuste ja tehisintellekti võimekuse mõistmine
- **Java tehisintellekti ökosüsteem**: Ülevaade Spring AI ja OpenAI SDK-dest
- **Mudelikontextiprotocol**: Tutvustus MCP-st ja selle rollist AI agentide suhtluses
- **Praktilised rakendused**: Reaalsed stsenaariumid, sealhulgas vestlusrobotid ja sisuloome
- **[→ Alusta 1. peatükki](./01-IntroToGenAI/README.md)**

### **2. peatükk: Arenduskeskkonna seadistamine**
- **Mitme teenusepakkuja konfiguratsioon**: GitHubi mudelite, Azure OpenAI ja OpenAI Java SDK integratsioonide seadistamine
- **Spring Boot + Spring AI**: Parimad tavad ettevõtte tehisintellekti rakenduste arendamiseks
- **GitHub mudelid**: Tasuta AI mudelite ligipääs prototüüpimiseks ja õppimiseks (pole krediitkaarti vaja)
- **Arendustööriistad**: Docker konteinerid, VS Code ja GitHub Codespaces seadistamine
- **[→ Alusta 2. peatükki](./02-SetupDevEnvironment/README.md)**

### **3. peatükk: Põhitehnoloogiad generatiivses tehisintellektis**
- **Promptide inseneritöö**: Optimaalsete AI mudeli vastuste tehnikad
- **Manused ja vektortegevused**: Semantilise otsingu ja sarnasuse sobitamise rakendamine
- **Tagasitoomisega rikastatud genereerimine (RAG)**: AI ühendamine oma andmeallikatega
- **Funktsioonikõned**: AI võimekuse laiendamine kohandatud tööriistade ja pistikprogrammidega
- **[→ Alusta 3. peatükki](./03-CoreGenerativeAITechniques/README.md)**

### **4. peatükk: Praktilised rakendused ja projektid**
- **Lemmiklooma loo generaator** (`petstory/`): Loominguline sisuloome GitHubi mudelitega
- **Foundry kohalik demo** (`foundrylocal/`): Kohalik AI mudeli integratsioon OpenAI Java SDK-ga
- **MCP kalkulaatori teenus** (`calculator/`): Põhilise Model Context Protocol rakendus Spring AI-ga
- **[→ Alusta 4. peatükki](./04-PracticalSamples/README.md)**

### **5. peatükk: Vastutustundlik tehisintellekti arendus**
- **GitHubi mudelite turvalisus**: Sisseehitatud sisufiltreerimise ja turvaprotokollide testimine (rasked blokeeringud ja pehmed keelamisotsused)
- **Vastutustundliku AI demo**: Praktiline näide sellest, kuidas moodsa AI turvasüsteemid toimivad
- **Parimad tavad**: Eetilise AI arendamise ja juurutamise põhinõuanded
- **[→ Alusta 5. peatükki](./05-ResponsibleGenAI/README.md)**

## Täiendavad ressursid

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j algajatele](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js algajatele](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)

---

### Azure / Edge / MCP / Agendid
[![AZD algajatele](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI algajatele](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP algajatele](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI agendid algajatele](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### Generatiivne tehisintellekti sari
[![Generatiivne tehisintellekt algajatele](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generatiivne tehisintellekt (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generatiivne tehisintellekt (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generatiivne tehisintellekt (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---

### Põhiõpe
[![Masinõpe algajatele](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Andmeteadus algajatele](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![Tehisintellekt algajatele](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Küberkaitse algajatele](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Veebiarendus algajatele](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT algajatele](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR arendus algajatele](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Copiloti sari
[![Copilot tehisintellekti paarisprogrammeerimiseks](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot C#/.NET jaoks](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copiloti seiklus](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## Abi saamine

Kui jääd hätta või sul on küsimusi tehisintellekti rakenduste koostamise kohta. Liitu teiste õppijate ja kogenud arendajatega aruteludes MCP kohta. See on toetav kogukond, kus küsimused on teretulnud ja teadmisi jagatakse vabalt.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

Kui sul on toote tagasisidet või ehitamise ajal vigu, külasta:

[![Microsoft Foundry arendajate foorum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Vastutusest loobumine**:  
See dokument on tõlgitud tehisintellekti tõlketeenuse [Co-op Translator](https://github.com/Azure/co-op-translator) abil. Kuigi püüdleme täpsuse poole, tuleb arvestada, et automaatsed tõlked võivad sisaldada vigu või ebatäpsusi. Originaaldokument oma emakeeles on ametlik allikas. Kriitilise teabe puhul soovitatakse kasutada professionaalset inimtõlget. Me ei vastuta selle tõlke kasutamisest tingitud arusaamatuste või valesti tõlgendamise eest.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->