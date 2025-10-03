<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "4d04ae8088f6a3c3fcbab18cbdfe4002",
  "translation_date": "2025-10-03T08:23:40+00:00",
  "source_file": "README.md",
  "language_code": "lt"
}
-->
# Generatyvinis AI pradedantiesiems - Java leidimas
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generatyvinis AI pradedantiesiems - Java leidimas](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.lt.png)

**Laiko sąnaudos**: Visą dirbtuvę galima atlikti internetu be vietinio nustatymo. Aplinkos paruošimas užtrunka 2 minutes, o pavyzdžių tyrinėjimas gali užtrukti 1–3 valandas, priklausomai nuo tyrinėjimo gylio.

> **Greitas startas**

1. Sukurkite šio saugyklos kopiją savo GitHub paskyroje
2. Spustelėkite **Code** → **Codespaces** skirtuką → **...** → **New with options...**
3. Naudokite numatytuosius nustatymus – tai parinks šiam kursui sukurtą vystymo konteinerį
4. Spustelėkite **Create codespace**
5. Palaukite ~2 minutes, kol aplinka bus paruošta
6. Pradėkite nuo [Pirmojo pavyzdžio](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Daugiakalbė palaikymas

### Palaikoma per GitHub Action (automatizuota ir visada atnaujinta)

[Prancūzų](../fr/README.md) | [Ispanų](../es/README.md) | [Vokiečių](../de/README.md) | [Rusų](../ru/README.md) | [Arabų](../ar/README.md) | [Persų (Farsi)](../fa/README.md) | [Urdu](../ur/README.md) | [Kinų (supaprastinta)](../zh/README.md) | [Kinų (tradicinė, Makao)](../mo/README.md) | [Kinų (tradicinė, Honkongas)](../hk/README.md) | [Kinų (tradicinė, Taivanas)](../tw/README.md) | [Japonų](../ja/README.md) | [Korėjiečių](../ko/README.md) | [Hindi](../hi/README.md) | [Bengalų](../bn/README.md) | [Marathi](../mr/README.md) | [Nepalų](../ne/README.md) | [Pandžabi (Gurmukhi)](../pa/README.md) | [Portugalų (Portugalija)](../pt/README.md) | [Portugalų (Brazilija)](../br/README.md) | [Italų](../it/README.md) | [Lenkų](../pl/README.md) | [Turkų](../tr/README.md) | [Graikų](../el/README.md) | [Tajų](../th/README.md) | [Švedų](../sv/README.md) | [Danų](../da/README.md) | [Norvegų](../no/README.md) | [Suomių](../fi/README.md) | [Olandų](../nl/README.md) | [Hebrajų](../he/README.md) | [Vietnamiečių](../vi/README.md) | [Indoneziečių](../id/README.md) | [Malajų](../ms/README.md) | [Tagalogų (Filipinų)](../tl/README.md) | [Svahilių](../sw/README.md) | [Vengrų](../hu/README.md) | [Čekų](../cs/README.md) | [Slovakų](../sk/README.md) | [Rumunų](../ro/README.md) | [Bulgarų](../bg/README.md) | [Serbų (kirilica)](../sr/README.md) | [Kroatų](../hr/README.md) | [Slovėnų](../sl/README.md) | [Ukrainiečių](../uk/README.md) | [Birmos (Mianmaras)](../my/README.md)

## Kurso struktūra ir mokymosi kelias

### **1 skyrius: Generatyvinio AI įvadas**
- **Pagrindinės sąvokos**: Suprasti didelius kalbos modelius, tokenus, įterpimus ir AI galimybes
- **Java AI ekosistema**: Spring AI ir OpenAI SDK apžvalga
- **Modelio konteksto protokolas**: MCP įvadas ir jo vaidmuo AI agentų komunikacijoje
- **Praktinės taikymo sritys**: Realūs scenarijai, įskaitant pokalbių robotus ir turinio generavimą
- **[→ Pradėti 1 skyrių](./01-IntroToGenAI/README.md)**

### **2 skyrius: Vystymo aplinkos paruošimas**
- **Daugiaproviderinė konfigūracija**: GitHub modelių, Azure OpenAI ir OpenAI Java SDK integracijų nustatymas
- **Spring Boot + Spring AI**: Geriausios praktikos kuriant įmonės AI programas
- **GitHub modeliai**: Nemokama AI modelių prieiga prototipavimui ir mokymuisi (nereikia kredito kortelės)
- **Vystymo įrankiai**: Docker konteineriai, VS Code ir GitHub Codespaces konfigūracija
- **[→ Pradėti 2 skyrių](./02-SetupDevEnvironment/README.md)**

### **3 skyrius: Pagrindinės generatyvinio AI technikos**
- **Promptų inžinerija**: Technikos optimaliems AI modelio atsakymams
- **Įterpimai ir vektorinės operacijos**: Semantinės paieškos ir panašumo atitikimo įgyvendinimas
- **RAG (Retrieval-Augmented Generation)**: AI derinimas su jūsų duomenų šaltiniais
- **Funkcijų kvietimas**: AI galimybių plėtra naudojant pasirinktus įrankius ir papildinius
- **[→ Pradėti 3 skyrių](./03-CoreGenerativeAITechniques/README.md)**

### **4 skyrius: Praktinės taikymo sritys ir projektai**
- **Gyvūnų istorijų generatorius** (`petstory/`): Kūrybinio turinio generavimas naudojant GitHub modelius
- **Foundry vietinis demo** (`foundrylocal/`): Vietinė AI modelių integracija su OpenAI Java SDK
- **MCP skaičiuoklės paslauga** (`calculator/`): Pagrindinis Modelio konteksto protokolo įgyvendinimas su Spring AI
- **[→ Pradėti 4 skyrių](./04-PracticalSamples/README.md)**

### **5 skyrius: Atsakingas AI vystymas**
- **GitHub modelių saugumas**: Įmontuotų turinio filtravimo ir saugumo mechanizmų testavimas (griežti blokavimai ir švelnūs atsisakymai)
- **Atsakingo AI demo**: Praktinis pavyzdys, kaip veikia šiuolaikinės AI saugumo sistemos
- **Geriausios praktikos**: Esminės gairės etiniam AI vystymui ir diegimui
- **[→ Pradėti 5 skyrių](./05-ResponsibleGenAI/README.md)**

## Papildomi ištekliai

- [Edge AI pradedantiesiems](https://github.com/microsoft/edgeai-for-beginners)
- [MCP pradedantiesiems](https://github.com/microsoft/mcp-for-beginners)
- [AI agentai pradedantiesiems](https://github.com/microsoft/ai-agents-for-beginners)
- [Generatyvinis AI pradedantiesiems naudojant .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generatyvinis AI pradedantiesiems naudojant JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Generatyvinis AI pradedantiesiems](https://github.com/microsoft/generative-ai-for-beginners)
- [ML pradedantiesiems](https://aka.ms/ml-beginners)
- [Duomenų mokslas pradedantiesiems](https://aka.ms/datascience-beginners)
- [AI pradedantiesiems](https://aka.ms/ai-beginners)
- [Kibernetinis saugumas pradedantiesiems](https://github.com/microsoft/Security-101)
- [Web kūrimas pradedantiesiems](https://aka.ms/webdev-beginners)
- [IoT pradedantiesiems](https://aka.ms/iot-beginners)
- [XR vystymas pradedantiesiems](https://github.com/microsoft/xr-development-for-beginners)
- [GitHub Copilot meistriškumas AI poriniam programavimui](https://aka.ms/GitHubCopilotAI)
- [GitHub Copilot meistriškumas C#/.NET programuotojams](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Pasirinkite savo Copilot nuotykį](https://github.com/microsoft/CopilotAdventures)
- [RAG pokalbių programa su Azure AI paslaugomis](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## Pagalbos gavimas

Jei susiduriate su sunkumais ar turite klausimų apie AI programų kūrimą, prisijunkite:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Jei turite produktų atsiliepimų ar klaidų, apsilankykite:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**Atsakomybės atsisakymas**:  
Šis dokumentas buvo išverstas naudojant AI vertimo paslaugą [Co-op Translator](https://github.com/Azure/co-op-translator). Nors stengiamės užtikrinti tikslumą, prašome atkreipti dėmesį, kad automatiniai vertimai gali turėti klaidų ar netikslumų. Originalus dokumentas jo gimtąja kalba turėtų būti laikomas autoritetingu šaltiniu. Kritinei informacijai rekomenduojama naudoti profesionalų žmogaus vertimą. Mes neprisiimame atsakomybės už nesusipratimus ar neteisingus interpretavimus, atsiradusius dėl šio vertimo naudojimo.