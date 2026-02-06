# Generatyvioji dirbtinis intelektas pradedantiesiems – Java leidimas
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generatyvioji dirbtinis intelektas pradedantiesiems – Java leidimas](../../translated_images/lt/beg-genai-series.8b48be9951cc574c.webp)

**Laiko sąnaudos**: visas seminaras gali būti atliktas internetu be lokalaus diegimo. Aplinkos paruošimas užtrunka 2 minutes, o pavyzdžių nagrinėjimas – nuo 1 iki 3 valandų, priklausomai nuo gilumo.

> **Greitas pradėjimas** 

1. Sukurkite šio saugyklos šaką savo GitHub paskyroje
2. Spustelėkite **Code** → skirtuką **Codespaces** → **...** → **New with options...**
3. Naudokite numatytuosius parametrus – tai pasirinks šiam kursui sukurtą kūrimo konteinerį
4. Spustelėkite **Create codespace**
5. Palaukite ~2 minutes, kol aplinka bus paruošta
6. Tiesiogiai pereikite prie [Pirmojo pavyzdžio](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **Verčiau klonuoti lokaliai?**
>
> Ši saugykla apima daugiau nei 50 kalbų vertimų, kurie žymiai padidina atsisiuntimo dydį. Norėdami klonuoti be vertimų, naudokite ribotą klonavimą:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> Tai suteiks jums viską, ko reikia kursui užbaigti, ir leis atsisiųsti greičiau.


## Daugiakalbė palaikymas

### Palaikoma per GitHub Action (automatizuota ir visada atnaujinta)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabų](../ar/README.md) | [Bengalų](../bn/README.md) | [Bulgarų](../bg/README.md) | [Birmos (Mianmaras)](../my/README.md) | [Kinų (Supaprastinta)](../zh-CN/README.md) | [Kinų (Tradicinė, Honkongas)](../zh-HK/README.md) | [Kinų (Tradicinė, Makao)](../zh-MO/README.md) | [Kinų (Tradicinė, Taivanas)](../zh-TW/README.md) | [Kroatų](../hr/README.md) | [Čekų](../cs/README.md) | [Danų](../da/README.md) | [Olandų](../nl/README.md) | [Estų](../et/README.md) | [Suomių](../fi/README.md) | [Prancūzų](../fr/README.md) | [Vokiečių](../de/README.md) | [Graikų](../el/README.md) | [Hebrajų](../he/README.md) | [Hindi](../hi/README.md) | [Vengrų](../hu/README.md) | [Indoneziečių](../id/README.md) | [Italų](../it/README.md) | [Japonų](../ja/README.md) | [Kannados](../kn/README.md) | [Korėjiečių](../ko/README.md) | [Lietuvių](./README.md) | [Malajų](../ms/README.md) | [Malajalių](../ml/README.md) | [Marati](../mr/README.md) | [Nepalų](../ne/README.md) | [Nigerijos pidžino](../pcm/README.md) | [Norvegų](../no/README.md) | [Persų (Farsi)](../fa/README.md) | [Lenkų](../pl/README.md) | [Portugalų (Brazilija)](../pt-BR/README.md) | [Portugalų (Portugalija)](../pt-PT/README.md) | [Pandžiabių (Gurmukhi)](../pa/README.md) | [Rumunų](../ro/README.md) | [Rusų](../ru/README.md) | [Serbų (Kirilica)](../sr/README.md) | [Slovakų](../sk/README.md) | [Slovėnų](../sl/README.md) | [Ispanų](../es/README.md) | [Suahelių](../sw/README.md) | [Švedų](../sv/README.md) | [Tagalogų (Filipinų)](../tl/README.md) | [Tamilų](../ta/README.md) | [Telugų](../te/README.md) | [Tajų](../th/README.md) | [Turkų](../tr/README.md) | [Ukrainiečių](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamiečių](../vi/README.md)

## Kurso struktūra ir mokymosi kelias

### **1 skyrius: Generatyvioji DI įvadas**
- **Pagrindinės sąvokos**: Dideliųjų kalbų modelių, žetonų, įterpimų ir DI galimybių supratimas
- **Java DI ekosistema**: Spring AI ir OpenAI SDK apžvalga
- **Modelio konteksto protokolas**: MCP pristatymas ir jo vaidmuo DI agentų komunikacijoje
- **Praktinės taikymo sritys**: Tikri scenarijai, įskaitant pokalbių robotus ir turinio generavimą
- **[→ Pradėti 1 skyrių](./01-IntroToGenAI/README.md)**

### **2 skyrius: Kūrimo aplinkos paruošimas**
- **Daugiaproviderinė konfigūracija**: GitHub modelių, Azure OpenAI ir OpenAI Java SDK integravimas
- **Spring Boot + Spring AI**: Geriausios praktikos įmonių DI programų kūrimui
- **GitHub modeliai**: Nemokama DI modelių prieiga prototipams ir mokymuisi (nereikia kreditinės kortelės)
- **Kūrimo įrankiai**: Docker konteineriai, VS Code ir GitHub Codespaces konfigūracija
- **[→ Pradėti 2 skyrių](./02-SetupDevEnvironment/README.md)**

### **3 skyrius: Pagrindinės generatyvios DI technikos**
- **Užklausų inžinerija**: Optimalios DI modelio atsakymų technikos
- **Įterpimai ir vektorinės operacijos**: Semantinė paieška ir panašumo atitikimas
- **Retrieval-Augmented Generation (RAG)**: DI kombinuoti su savo duomenų šaltiniais
- **Funkcijų kvietimas**: DI galimybių išplėtimas su įrankių ir papildinių pagalba
- **[→ Pradėti 3 skyrių](./03-CoreGenerativeAITechniques/README.md)**

### **4 skyrius: Praktiniai taikymai ir projektai**
- **Augintinių istorijų generatorius** (`petstory/`): Kūrybinis turinio generavimas su GitHub modeliais
- **Foundry vietinė demonstracija** (`foundrylocal/`): Vietinė DI modelių integracija su OpenAI Java SDK
- **MCP skaičiuoklės paslauga** (`calculator/`): Paprasta Modelio konteksto protokolo implementacija su Spring AI
- **[→ Pradėti 4 skyrių](./04-PracticalSamples/README.md)**

### **5 skyrius: Atsakingas DI kūrimas**
- **GitHub modelių saugumas**: Testavimas įmontuotų turinio filtravimo ir saugumo mechanizmų (griežti blokai ir minkšti atsisakymai)
- **Atsakingo DI demonstracija**: Praktinis pavyzdys, kaip veikia šiuolaikinės DI saugumo sistemos
- **Geriausios praktikos**: Būtinos etinės DI kūrimo ir diegimo gairės
- **[→ Pradėti 5 skyrių](./05-ResponsibleGenAI/README.md)**

## Papildomi ištekliai

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j pradedantiesiems](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js pradedantiesiems](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)
[![LangChain pradedantiesiems](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)
---

### Azure / Edge / MCP / Agentai
[![AZD pradedantiesiems](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge DI pradedantiesiems](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP pradedantiesiems](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![DI agentai pradedantiesiems](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Generatyvosios DI serija
[![Generatyvioji DI pradedantiesiems](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generatyvioji DI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generatyvioji DI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generatyvioji DI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### Pagrindinis mokymasis
[![ML pradedantiesiems](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Duomenų mokslas pradedantiesiems](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![DI pradedantiesiems](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Kibernetinio saugumo pradedantiesiems](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Copilot serija
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## Pagalbos gavimas

Jei užstringate ar turite klausimų apie AI programėlių kūrimą. Prisijunkite prie bendraminčių ir patyrusių programuotojų diskusijų apie MCP. Tai palaikanti bendruomenė, kurioje klausimai laukiami ir žinios dalijamos laisvai.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

Jei turite produktų atsiliepimų ar klaidų kūrimo metu, apsilankykite:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Atsakomybės apribojimas**:
Šis dokumentas buvo išverstas naudojant AI vertimo paslaugą [Co-op Translator](https://github.com/Azure/co-op-translator). Nors siekiame tikslumo, prašome atkreipti dėmesį, kad automatiniai vertimai gali turėti klaidų ar netikslumų. Originalus dokumentas jo gimtąja kalba turėtų būti laikomas autoritetingu šaltiniu. Kritinei informacijai rekomenduojamas profesionalus žmogaus vertimas. Mes neatsakome už bet kokius nesusipratimus ar neteisingus aiškinimus, kylančius dėl šio vertimo naudojimo.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->