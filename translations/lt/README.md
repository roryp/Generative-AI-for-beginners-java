<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "ff595bec5b6294cb68860d540eae6302",
  "translation_date": "2025-11-18T17:48:13+00:00",
  "source_file": "README.md",
  "language_code": "lt"
}
-->
# Generatyvinė AI pradedantiesiems - Java leidimas
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generatyvinė AI pradedantiesiems - Java leidimas](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.lt.png)

**Laiko sąnaudos**: Visą dirbtuvę galima atlikti internetu be vietinio nustatymo. Aplinkos paruošimas užtrunka 2 minutes, o pavyzdžių tyrinėjimas gali užtrukti 1-3 valandas, priklausomai nuo tyrinėjimo gylio.

> **Greitas startas**

1. Sukurkite šio saugyklos šaką savo GitHub paskyroje
2. Spustelėkite **Code** → **Codespaces** skirtuką → **...** → **New with options...**
3. Naudokite numatytuosius nustatymus – tai parinks šiam kursui sukurtą vystymo konteinerį
4. Spustelėkite **Create codespace**
5. Palaukite ~2 minutes, kol aplinka bus paruošta
6. Pereikite tiesiai prie [Pirmojo pavyzdžio](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Daugiakalbė parama

### Palaikoma per GitHub Action (Automatizuota ir visada atnaujinta)

[Arabų](../ar/README.md) | [Bengalų](../bn/README.md) | [Bulgarų](../bg/README.md) | [Birmos (Mianmaras)](../my/README.md) | [Kinų (supaprastinta)](../zh/README.md) | [Kinų (tradicinė, Honkongas)](../hk/README.md) | [Kinų (tradicinė, Makao)](../mo/README.md) | [Kinų (tradicinė, Taivanas)](../tw/README.md) | [Kroatų](../hr/README.md) | [Čekų](../cs/README.md) | [Danų](../da/README.md) | [Olandų](../nl/README.md) | [Estų](../et/README.md) | [Suomių](../fi/README.md) | [Prancūzų](../fr/README.md) | [Vokiečių](../de/README.md) | [Graikų](../el/README.md) | [Hebrajų](../he/README.md) | [Hindi](../hi/README.md) | [Vengrų](../hu/README.md) | [Indoneziečių](../id/README.md) | [Italų](../it/README.md) | [Japonų](../ja/README.md) | [Korėjiečių](../ko/README.md) | [Lietuvių](./README.md) | [Malajų](../ms/README.md) | [Maratų](../mr/README.md) | [Nepalų](../ne/README.md) | [Nigerijos pidžinas](../pcm/README.md) | [Norvegų](../no/README.md) | [Persų (farsi)](../fa/README.md) | [Lenkų](../pl/README.md) | [Portugalų (Brazilija)](../br/README.md) | [Portugalų (Portugalija)](../pt/README.md) | [Pandžabų (Gurmukhi)](../pa/README.md) | [Rumunų](../ro/README.md) | [Rusų](../ru/README.md) | [Serbų (kirilica)](../sr/README.md) | [Slovakų](../sk/README.md) | [Slovėnų](../sl/README.md) | [Ispanų](../es/README.md) | [Svahilių](../sw/README.md) | [Švedų](../sv/README.md) | [Tagalogų (Filipinai)](../tl/README.md) | [Tamilų](../ta/README.md) | [Tajų](../th/README.md) | [Turkų](../tr/README.md) | [Ukrainiečių](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamiečių](../vi/README.md)

## Kurso struktūra ir mokymosi kelias

### **1 skyrius: Generatyvinės AI įvadas**
- **Pagrindinės sąvokos**: Dideli kalbos modeliai, tokenai, įterpimai ir AI galimybės
- **Java AI ekosistema**: Spring AI ir OpenAI SDK apžvalga
- **Modelio konteksto protokolas**: MCP pristatymas ir jo vaidmuo AI agentų komunikacijoje
- **Praktinės taikymo sritys**: Realūs scenarijai, tokie kaip pokalbių robotai ir turinio generavimas
- **[→ Pradėti 1 skyrių](./01-IntroToGenAI/README.md)**

### **2 skyrius: Vystymo aplinkos paruošimas**
- **Daugiaproviderinė konfigūracija**: GitHub modelių, Azure OpenAI ir OpenAI Java SDK integracijų nustatymas
- **Spring Boot + Spring AI**: Geriausios praktikos kuriant įmonės AI programas
- **GitHub modeliai**: Nemokama AI modelių prieiga prototipavimui ir mokymuisi (nereikia kredito kortelės)
- **Vystymo įrankiai**: Docker konteineriai, VS Code ir GitHub Codespaces konfigūracija
- **[→ Pradėti 2 skyrių](./02-SetupDevEnvironment/README.md)**

### **3 skyrius: Pagrindinės generatyvinės AI technikos**
- **Promptų inžinerija**: Technikos optimaliems AI modelių atsakymams
- **Įterpimai ir vektorinės operacijos**: Semantinės paieškos ir panašumo atitikimo įgyvendinimas
- **RAG (Retrieval-Augmented Generation)**: AI derinimas su jūsų duomenų šaltiniais
- **Funkcijų kvietimas**: AI galimybių plėtra naudojant pasirinktus įrankius ir papildinius
- **[→ Pradėti 3 skyrių](./03-CoreGenerativeAITechniques/README.md)**

### **4 skyrius: Praktinės taikymo sritys ir projektai**
- **Gyvūnų istorijų generatorius** (`petstory/`): Kūrybinio turinio generavimas su GitHub modeliais
- **Foundry vietinis demonstravimas** (`foundrylocal/`): Vietinė AI modelių integracija su OpenAI Java SDK
- **MCP skaičiuoklės paslauga** (`calculator/`): Pagrindinis Modelio konteksto protokolo įgyvendinimas su Spring AI
- **[→ Pradėti 4 skyrių](./04-PracticalSamples/README.md)**

### **5 skyrius: Atsakingas AI vystymas**
- **GitHub modelių saugumas**: Įmontuotų turinio filtravimo ir saugumo mechanizmų testavimas (griežti blokavimai ir švelnūs atsisakymai)
- **Atsakingo AI demonstravimas**: Praktinis pavyzdys, kaip veikia šiuolaikinės AI saugumo sistemos
- **Geriausios praktikos**: Esminės gairės etiniam AI vystymui ir diegimui
- **[→ Pradėti 5 skyrių](./05-ResponsibleGenAI/README.md)**

## Papildomi ištekliai

### Azure / Edge / MCP / Agentai
[![AZD pradedantiesiems](https://img.shields.io/badge/AZD%20pradedantiesiems-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI pradedantiesiems](https://img.shields.io/badge/Edge%20AI%20pradedantiesiems-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP pradedantiesiems](https://img.shields.io/badge/MCP%20pradedantiesiems-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI agentai pradedantiesiems](https://img.shields.io/badge/AI%20agentai%20pradedantiesiems-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### Generatyvinės AI serija
[![Generatyvinė AI pradedantiesiems](https://img.shields.io/badge/Generatyvinė%20AI%20pradedantiesiems-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generatyvinė AI (.NET)](https://img.shields.io/badge/Generatyvinė%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generatyvinė AI (Java)](https://img.shields.io/badge/Generatyvinė%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generatyvinė AI (JavaScript)](https://img.shields.io/badge/Generatyvinė%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---

### Pagrindinis mokymasis
[![ML pradedantiesiems](https://img.shields.io/badge/ML%20pradedantiesiems-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Duomenų mokslas pradedantiesiems](https://img.shields.io/badge/Duomenų%20mokslas%20pradedantiesiems-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI pradedantiesiems](https://img.shields.io/badge/AI%20pradedantiesiems-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Kibernetinis saugumas pradedantiesiems](https://img.shields.io/badge/Kibernetinis%20saugumas%20pradedantiesiems-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web kūrimas pradedantiesiems](https://img.shields.io/badge/Web%20kūrimas%20pradedantiesiems-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT pradedantiesiems](https://img.shields.io/badge/IoT%20pradedantiesiems-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR kūrimas pradedantiesiems](https://img.shields.io/badge/XR%20kūrimas%20pradedantiesiems-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### Copilot serija
[![Copilot AI poriniam programavimui](https://img.shields.io/badge/Copilot%20AI%20poriniam%20programavimui-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)  
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)  
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## Pagalbos gavimas

Jei susiduriate su sunkumais ar turite klausimų apie AI programų kūrimą, prisijunkite prie kitų mokinių ir patyrusių kūrėjų diskusijų apie MCP. Tai palaikanti bendruomenė, kurioje laukiami klausimai ir laisvai dalijamasi žiniomis.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

Jei turite atsiliepimų apie produktą ar susiduriate su klaidomis kūrimo metu, apsilankykite:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Atsakomybės apribojimas**:  
Šis dokumentas buvo išverstas naudojant dirbtinio intelekto vertimo paslaugą [Co-op Translator](https://github.com/Azure/co-op-translator). Nors siekiame tikslumo, atkreipkite dėmesį, kad automatiniai vertimai gali turėti klaidų ar netikslumų. Originalus dokumentas jo gimtąja kalba turėtų būti laikomas autoritetingu šaltiniu. Dėl svarbios informacijos rekomenduojama profesionali žmogaus vertimo paslauga. Mes neprisiimame atsakomybės už nesusipratimus ar klaidingus aiškinimus, kylančius dėl šio vertimo naudojimo.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->