<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "ff595bec5b6294cb68860d540eae6302",
  "translation_date": "2025-11-18T17:51:30+00:00",
  "source_file": "README.md",
  "language_code": "et"
}
-->
# Generatiivne tehisintellekt algajatele - Java väljaanne
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generatiivne tehisintellekt algajatele - Java väljaanne](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.et.png)

**Ajakulu**: Kogu töötuba saab läbida veebis ilma kohalikku seadistust tegemata. Keskkonna seadistamine võtab 2 minutit, näidete uurimine 1-3 tundi, sõltuvalt süvenemise tasemest.

> **Kiire algus**

1. Forki see repositoorium oma GitHubi kontole
2. Klõpsa **Code** → **Codespaces** vahekaart → **...** → **New with options...**
3. Kasuta vaikeseadeid – see valib selle kursuse jaoks loodud arenduskonteineri
4. Klõpsa **Create codespace**
5. Oota ~2 minutit, kuni keskkond on valmis
6. Alusta kohe [Esimese näitega](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Mitmekeelne tugi

### Toetatud GitHub Actioni kaudu (Automatiseeritud ja alati ajakohane)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Araabia](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgaaria](../bg/README.md) | [Birma (Myanmar)](../my/README.md) | [Hiina (lihtsustatud)](../zh/README.md) | [Hiina (traditsiooniline, Hongkong)](../hk/README.md) | [Hiina (traditsiooniline, Macau)](../mo/README.md) | [Hiina (traditsiooniline, Taiwan)](../tw/README.md) | [Horvaatia](../hr/README.md) | [Tšehhi](../cs/README.md) | [Taani](../da/README.md) | [Hollandi](../nl/README.md) | [Eesti](./README.md) | [Soome](../fi/README.md) | [Prantsuse](../fr/README.md) | [Saksa](../de/README.md) | [Kreeka](../el/README.md) | [Heebrea](../he/README.md) | [Hindi](../hi/README.md) | [Ungari](../hu/README.md) | [Indoneesia](../id/README.md) | [Itaalia](../it/README.md) | [Jaapani](../ja/README.md) | [Korea](../ko/README.md) | [Leedu](../lt/README.md) | [Malai](../ms/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Nigeeria pidgin](../pcm/README.md) | [Norra](../no/README.md) | [Pärsia (Farsi)](../fa/README.md) | [Poola](../pl/README.md) | [Portugali (Brasiilia)](../br/README.md) | [Portugali (Portugal)](../pt/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Rumeenia](../ro/README.md) | [Vene](../ru/README.md) | [Serbia (kirillitsa)](../sr/README.md) | [Slovaki](../sk/README.md) | [Sloveeni](../sl/README.md) | [Hispaania](../es/README.md) | [Suahiili](../sw/README.md) | [Rootsi](../sv/README.md) | [Tagalogi (Filipiinid)](../tl/README.md) | [Tamili](../ta/README.md) | [Tai](../th/README.md) | [Türgi](../tr/README.md) | [Ukraina](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnami](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Kursuse struktuur ja õpitee

### **1. peatükk: Sissejuhatus generatiivsesse tehisintellekti**
- **Põhimõisted**: Suurte keelemudelite, tokenite, sisendite ja tehisintellekti võimekuste mõistmine
- **Java AI ökosüsteem**: Ülevaade Spring AI ja OpenAI SDK-dest
- **Model Context Protocol**: MCP tutvustus ja selle roll AI agentide suhtluses
- **Praktilised rakendused**: Reaalsed näited, sealhulgas vestlusrobotid ja sisuloome
- **[→ Alusta 1. peatükki](./01-IntroToGenAI/README.md)**

### **2. peatükk: Arenduskeskkonna seadistamine**
- **Mitme pakkuja konfiguratsioon**: GitHubi mudelite, Azure OpenAI ja OpenAI Java SDK integreerimine
- **Spring Boot + Spring AI**: Parimad tavad ettevõtte AI rakenduste arendamiseks
- **GitHubi mudelid**: Tasuta AI mudelite juurdepääs prototüüpimiseks ja õppimiseks (krediitkaarti pole vaja)
- **Arendustööriistad**: Docker konteinerid, VS Code ja GitHub Codespaces konfiguratsioon
- **[→ Alusta 2. peatükki](./02-SetupDevEnvironment/README.md)**

### **3. peatükk: Generatiivse tehisintellekti põhitehnikad**
- **Prompt Engineering**: Tehnikad AI mudelite optimaalseks vastamiseks
- **Sisendid ja vektoroperatsioonid**: Semantilise otsingu ja sarnasuse sobitamise rakendamine
- **Retrieval-Augmented Generation (RAG)**: AI kombineerimine oma andmeallikatega
- **Funktsioonide kutsumine**: AI võimekuse laiendamine kohandatud tööriistade ja pluginatega
- **[→ Alusta 3. peatükki](./03-CoreGenerativeAITechniques/README.md)**

### **4. peatükk: Praktilised rakendused ja projektid**
- **Lemmikloolugude generaator** (`petstory/`): Loov sisuloome GitHubi mudelitega
- **Foundry kohalik demo** (`foundrylocal/`): Kohaliku AI mudeli integreerimine OpenAI Java SDK-ga
- **MCP kalkulaatoriteenus** (`calculator/`): Põhiline Model Context Protocoli rakendus Spring AI-ga
- **[→ Alusta 4. peatükki](./04-PracticalSamples/README.md)**

### **5. peatükk: Vastutustundlik AI arendus**
- **GitHubi mudelite turvalisus**: Sisseehitatud sisufiltreerimise ja turvamehhanismide testimine (karmid blokeeringud ja pehmed keeldumised)
- **Vastutustundliku AI demo**: Praktiline näide, kuidas kaasaegsed AI turvasüsteemid töötavad
- **Parimad tavad**: Olulised juhised eetiliseks AI arendamiseks ja kasutuselevõtuks
- **[→ Alusta 5. peatükki](./05-ResponsibleGenAI/README.md)**

## Täiendavad ressursid

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### Azure / Edge / MCP / Agendid
[![AZD algajatele](https://img.shields.io/badge/AZD%20algajatele-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI algajatele](https://img.shields.io/badge/Edge%20AI%20algajatele-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP algajatele](https://img.shields.io/badge/MCP%20algajatele-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI agendid algajatele](https://img.shields.io/badge/AI%20agendid%20algajatele-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Generatiivse tehisintellekti sari
[![Generatiivne AI algajatele](https://img.shields.io/badge/Generatiivne%20AI%20algajatele-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generatiivne AI (.NET)](https://img.shields.io/badge/Generatiivne%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generatiivne AI (Java)](https://img.shields.io/badge/Generatiivne%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generatiivne AI (JavaScript)](https://img.shields.io/badge/Generatiivne%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### Põhiõpe
[![ML algajatele](https://img.shields.io/badge/ML%20algajatele-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Andmeteadus algajatele](https://img.shields.io/badge/Andmeteadus%20algajatele-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI algajatele](https://img.shields.io/badge/AI%20algajatele-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Küberjulgeolek algajatele](https://img.shields.io/badge/Küberjulgeolek%20algajatele-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Veebiarendus algajatele](https://img.shields.io/badge/Veebiarendus%20algajatele-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT algajatele](https://img.shields.io/badge/IoT%20algajatele-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR arendus algajatele](https://img.shields.io/badge/XR%20arendus%20algajatele-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Copilot sari
[![Copilot AI paarisprogrammeerimiseks](https://img.shields.io/badge/Copilot%20AI%20paarisprogrammeerimiseks-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)  
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)  
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## Abi saamine

Kui jääd hätta või sul on küsimusi AI rakenduste loomise kohta, liitu teiste õppijate ja kogenud arendajatega MCP aruteludes. See on toetav kogukond, kus küsimused on teretulnud ja teadmisi jagatakse vabalt.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

Kui sul on tagasisidet toodete kohta või esineb vigu arendamise ajal, külasta:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Lahtiütlus**:  
See dokument on tõlgitud AI tõlketeenuse [Co-op Translator](https://github.com/Azure/co-op-translator) abil. Kuigi püüame tagada täpsust, palume arvestada, et automaatsed tõlked võivad sisaldada vigu või ebatäpsusi. Algne dokument selle algkeeles tuleks lugeda autoriteetseks allikaks. Olulise teabe puhul soovitame kasutada professionaalset inimtõlget. Me ei vastuta selle tõlke kasutamisest tulenevate arusaamatuste või valede tõlgenduste eest.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->