<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "90ac762d40c6db51b8081cdb3e49e9db",
  "translation_date": "2025-08-28T21:51:18+00:00",
  "source_file": "README.md",
  "language_code": "lt"
}
-->
# Generatyvinis AI pradedantiesiems - Java leidimas
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Generatyvinis AI pradedantiesiems - Java leidimas](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.lt.png)

**Laiko sąnaudos**: Visą dirbtuvę galima atlikti internetu be vietinio nustatymo. Aplinkos paruošimas užtrunka 2 minutes, o pavyzdžių tyrinėjimas gali užtrukti 1–3 valandas, priklausomai nuo tyrinėjimo gylio.

> **Greitas startas**

1. Fork'inkite šį repozitoriją į savo GitHub paskyrą
2. Spustelėkite **Code** → **Codespaces** skirtuką → **...** → **New with options...**
3. Naudokite numatytuosius nustatymus – tai parinks šiam kursui sukurtą vystymo konteinerį
4. Spustelėkite **Create codespace**
5. Palaukite ~2 minutes, kol aplinka bus paruošta
6. Pereikite tiesiai prie [Pirmojo pavyzdžio](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Daugiakalbė palaikymas

### Palaikoma per GitHub Action (Automatizuota ir visada atnaujinta)

[Prancūzų](../fr/README.md) | [Ispanų](../es/README.md) | [Vokiečių](../de/README.md) | [Rusų](../ru/README.md) | [Arabų](../ar/README.md) | [Persų (Farsi)](../fa/README.md) | [Urdu](../ur/README.md) | [Kinų (supaprastinta)](../zh/README.md) | [Kinų (tradicinė, Makao)](../mo/README.md) | [Kinų (tradicinė, Honkongas)](../hk/README.md) | [Kinų (tradicinė, Taivanas)](../tw/README.md) | [Japonų](../ja/README.md) | [Korėjiečių](../ko/README.md) | [Hindi](../hi/README.md) | [Bengalų](../bn/README.md) | [Marathi](../mr/README.md) | [Nepalų](../ne/README.md) | [Pandžabi (Gurmukhi)](../pa/README.md) | [Portugalų (Portugalija)](../pt/README.md) | [Portugalų (Brazilija)](../br/README.md) | [Italų](../it/README.md) | [Lenkų](../pl/README.md) | [Turkų](../tr/README.md) | [Graikų](../el/README.md) | [Tajų](../th/README.md) | [Švedų](../sv/README.md) | [Danų](../da/README.md) | [Norvegų](../no/README.md) | [Suomių](../fi/README.md) | [Olandų](../nl/README.md) | [Hebrajų](../he/README.md) | [Vietnamiečių](../vi/README.md) | [Indoneziečių](../id/README.md) | [Malajų](../ms/README.md) | [Tagalog (Filipinų)](../tl/README.md) | [Svahilių](../sw/README.md) | [Vengrų](../hu/README.md) | [Čekų](../cs/README.md) | [Slovakų](../sk/README.md) | [Rumunų](../ro/README.md) | [Bulgarų](../bg/README.md) | [Serbų (kirilica)](../sr/README.md) | [Kroatų](../hr/README.md) | [Slovėnų](../sl/README.md) | [Ukrainiečių](../uk/README.md) | [Birmos (Mianmaras)](../my/README.md)

## Kurso struktūra ir mokymosi kelias

### **1 skyrius: Įvadas į generatyvinį AI**
- **Pagrindinės sąvokos**: Suprasti didelius kalbos modelius, tokenus, embedding'us ir AI galimybes
- **Java AI ekosistema**: Spring AI ir OpenAI SDK apžvalga
- **Modelio konteksto protokolas**: MCP pristatymas ir jo vaidmuo AI agentų komunikacijoje
- **Praktinės aplikacijos**: Realūs scenarijai, įskaitant chatbot'us ir turinio generavimą
- **[→ Pradėti 1 skyrių](./01-IntroToGenAI/README.md)**

### **2 skyrius: Vystymo aplinkos paruošimas**
- **Daugiaproviderinė konfigūracija**: GitHub modelių, Azure OpenAI ir OpenAI Java SDK integracijų nustatymas
- **Spring Boot + Spring AI**: Geriausios praktikos kuriant AI aplikacijas įmonėms
- **GitHub modeliai**: Nemokama AI modelių prieiga prototipavimui ir mokymuisi (nereikia kreditinės kortelės)
- **Vystymo įrankiai**: Docker konteineriai, VS Code ir GitHub Codespaces konfigūracija
- **[→ Pradėti 2 skyrių](./02-SetupDevEnvironment/README.md)**

### **3 skyrius: Pagrindinės generatyvinio AI technikos**
- **Promptų inžinerija**: Technikos optimaliems AI modelių atsakymams
- **Embedding'ai ir vektorinės operacijos**: Semantinės paieškos ir panašumo atitikimo įgyvendinimas
- **RAG (Retrieval-Augmented Generation)**: AI derinimas su jūsų duomenų šaltiniais
- **Funkcijų kvietimas**: AI galimybių plėtra naudojant pasirinktus įrankius ir papildinius
- **[→ Pradėti 3 skyrių](./03-CoreGenerativeAITechniques/README.md)**

### **4 skyrius: Praktinės aplikacijos ir projektai**
- **Gyvūnų istorijų generatorius** (`petstory/`): Kūrybinio turinio generavimas naudojant GitHub modelius
- **Foundry vietinis demo** (`foundrylocal/`): Vietinė AI modelių integracija su OpenAI Java SDK
- **MCP skaičiuoklės paslauga** (`calculator/`): Pagrindinis Modelio konteksto protokolo įgyvendinimas su Spring AI
- **[→ Pradėti 4 skyrių](./04-PracticalSamples/README.md)**

### **5 skyrius: Atsakingas AI vystymas**
- **GitHub modelių saugumas**: Įmontuotų turinio filtravimo ir saugumo mechanizmų testavimas (griežti blokavimai ir švelnūs atsisakymai)
- **Atsakingo AI demo**: Praktinis pavyzdys, kaip veikia modernios AI saugumo sistemos
- **Geriausios praktikos**: Esminės gairės etiniam AI vystymui ir diegimui
- **[→ Pradėti 5 skyrių](./05-ResponsibleGenAI/README.md)**

## Papildomi ištekliai

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
- [RAG pokalbių aplikacija su Azure AI paslaugomis](https://github.com/Azure-Samples/azure-search-openai-demo-java)

---

**Atsakomybės apribojimas**:  
Šis dokumentas buvo išverstas naudojant AI vertimo paslaugą [Co-op Translator](https://github.com/Azure/co-op-translator). Nors siekiame tikslumo, prašome atkreipti dėmesį, kad automatiniai vertimai gali turėti klaidų ar netikslumų. Originalus dokumentas jo gimtąja kalba turėtų būti laikomas autoritetingu šaltiniu. Kritinei informacijai rekomenduojama naudoti profesionalų žmogaus vertimą. Mes neprisiimame atsakomybės už nesusipratimus ar klaidingus interpretavimus, atsiradusius dėl šio vertimo naudojimo.