# AI Inayozalisha kwa Waanzilishi - Toleo la Java
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/sw/beg-genai-series.8b48be9951cc574c.webp)

**Muda wa Kujitolea**: Warsha yote inaweza kukamilika mtandaoni bila mpangilio wa ndani. Mpangilio wa mazingira huchukua dakika 2, huku kuchunguza mifano kunahitaji saa 1-3 kulingana na kina cha uchunguzi.

> **Anza Haraka**

1. Fokosa hifadhi hii kwenye akaunti yako ya GitHub
2. Bonyeza **Code** → kichupo cha **Codespaces** → **...** → **New with options...**
3. Tumia mipangilio ya chaguo-msingi – hii itachagua kontena la Maendeleo lililotengenezwa kwa ajili ya kozi hii
4. Bonyeza **Create codespace**
5. Subiri takriban dakika 2 kwa mazingira kuwa tayari
6. Ruka moja kwa moja hadi [Mfano wa kwanza](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **Unapendelea Kukopa Mbali?**
>
> Hifadhi hii ina tafsiri zaidi ya 50 za lugha ambazo huongeza kwa kiasi kikubwa ukubwa wa kupakua. Ili kukopa bila tafsiri, tumia sparse checkout:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> Hii inakupa kila kitu unachohitaji kukamilisha kozi kwa upakuaji wa haraka zaidi.


## Msaada wa Lugha Nyingi

### Inasaidiwa kupitia GitHub Action (Kiotomatiki & Daima Katika Hali ya Kisasa)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Kiarabu](../ar/README.md) | [Kibengali](../bn/README.md) | [Kibulgaria](../bg/README.md) | [Kiburma (Myanmar)](../my/README.md) | [Kichina (Rahisi)](../zh-CN/README.md) | [Kichina (Mila Isiyo Rarimu, Hong Kong)](../zh-HK/README.md) | [Kichina (Mila Isiyo Rarimu, Macau)](../zh-MO/README.md) | [Kichina (Mila Isiyo Rarimu, Taiwan)](../zh-TW/README.md) | [Kroatia](../hr/README.md) | [Cheki](../cs/README.md) | [Denmaki](../da/README.md) | [Kiholanzi](../nl/README.md) | [Estonia](../et/README.md) | [Kifini](../fi/README.md) | [Kifaransa](../fr/README.md) | [Kijerumani](../de/README.md) | [Kigreki](../el/README.md) | [Kiheberu](../he/README.md) | [Kihindi](../hi/README.md) | [Kihungari](../hu/README.md) | [Kiindonesian](../id/README.md) | [Kiitaliano](../it/README.md) | [Kijapani](../ja/README.md) | [Kikannada](../kn/README.md) | [Kikorea](../ko/README.md) | [Kilithuania](../lt/README.md) | [Kimalaizya](../ms/README.md) | [Kimalayalam](../ml/README.md) | [Kimarathi](../mr/README.md) | [Kinepali](../ne/README.md) | [Kipidgin cha Nigeria](../pcm/README.md) | [Kinorwe](../no/README.md) | [Kifarsi (Persian)](../fa/README.md) | [Kipolishi](../pl/README.md) | [Kireno (Brazil)](../pt-BR/README.md) | [Kireno (Ureno)](../pt-PT/README.md) | [Kipunja (Gurmukhi)](../pa/README.md) | [Kiromania](../ro/README.md) | [Kirusi](../ru/README.md) | [Kiserbia (Cyrillic)](../sr/README.md) | [Kislovakia](../sk/README.md) | [Kislovenia](../sl/README.md) | [Kihispania](../es/README.md) | [Kiswahili](./README.md) | [Kiswidi](../sv/README.md) | [Kitagalog (Filipino)](../tl/README.md) | [Kitamili](../ta/README.md) | [Kitelugu](../te/README.md) | [Kithai](../th/README.md) | [Kituruki](../tr/README.md) | [Kiukraine](../uk/README.md) | [Kiurdu](../ur/README.md) | [Kivietinamu](../vi/README.md)

## Muundo wa Kozi & Njia ya Kujifunza

### **Sura ya 1: Utangulizi wa AI Inayozalisha**
- **Dhana za Msingi**: Uelewa wa Mifano Mikubwa ya Lugha, tokeni, embeddings, na uwezo wa AI
- **Eneo la AI la Java**: Muhtasari wa Spring AI na OpenAI SDKs
- **Itifaki ya Muktadha wa Mfano (MCP)**: Utangulizi wa MCP na jukumu lake katika mawasiliano ya mawakala wa AI
- **Matumizi ya Vitendo**: Hali halisi ikiwa ni pamoja na chatbots na uzalishaji wa maudhui
- **[→ Anza Sura ya 1](./01-IntroToGenAI/README.md)**

### **Sura ya 2: Mpangilio wa Mazingira ya Maendeleo**
- **Mpangilio wa Watoa Huduma Wengi**: Weka GitHub Models, Azure OpenAI, na ushirikiano wa OpenAI Java SDK
- **Spring Boot + Spring AI**: Mbinu bora za maendeleo ya programu za AI za biashara
- **GitHub Models**: Upatikanaji wa bure wa modeli za AI kwa majaribio na kujifunza (hakuna kadi ya mkopo inahitajika)
- **Zana za Maendeleo**: Kontena za Docker, VS Code, na usanidi wa GitHub Codespaces
- **[→ Anza Sura ya 2](./02-SetupDevEnvironment/README.md)**

### **Sura ya 3: Mbinu Za Msingi za AI Inayozalisha**
- **Uhandisi wa Prompt**: Mbinu za majibu bora kutoka kwa modeli za AI
- **Embeddings & Uendeshaji wa Vector**: Tekeleza utafutaji wa semantiki na ulinganishaji wa usawa
- **Uzalishaji Unaoungwa Mkono na Urejeshaji (RAG)**: Changanya AI na vyanzo vyako vya data
- **Kupiga Simu Kazi**: Panua uwezo wa AI kwa zana na programu-jalizi maalum
- **[→ Anza Sura ya 3](./03-CoreGenerativeAITechniques/README.md)**

### **Sura ya 4: Matumizi ya Vitendo & Miradi**
- **Mzalishaji wa Hadithi za Wanyama wa Kutunza** (`petstory/`): Uzalishaji wa maudhui ya ubunifu kwa GitHub Models
- **Onyesho la Foundry Local** (`foundrylocal/`): Ushirikiano wa mfano wa AI wa ndani na OpenAI Java SDK
- **Huduma ya Kipimo cha MCP** (`calculator/`): Utekelezaji wa msingi wa Itifaki ya Muktadha wa Mfano na Spring AI
- **[→ Anza Sura ya 4](./04-PracticalSamples/README.md)**

### **Sura ya 5: Maendeleo ya AI kwa Uangalifu**
- **Usalama wa GitHub Models**: Jaribu chujio la maudhui lililoingia ndani na mifumo ya usalama (vizuizi vikubwa na kukataa kwa mpole)
- **Onyesho la AI Inayohusika**: Mfano wa vitendo unaoonyesha jinsi mifumo ya usalama ya AI ya kisasa inavyofanya kazi
- **Mbinu Bora**: Miongozo muhimu kwa maendeleo ya AI yenye maadili na usambazaji
- **[→ Anza Sura ya 5](./05-ResponsibleGenAI/README.md)**

## Rasilimali Zaidi

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j kwa Waanzilishi](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js kwa Waanzilishi](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)
[![LangChain kwa Waanzilishi](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)
---

### Azure / Edge / MCP / Mawakala
[![AZD kwa Waanzilishi](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI kwa Waanzilishi](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP kwa Waanzilishi](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Mawala AI kwa Waanzilishi](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Mfululizo wa AI Inayozalisha
[![AI Inayozalisha kwa Waanzilishi](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI Inayozalisha (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![AI Inayozalisha (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![AI Inayozalisha (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### Msingi wa Kujifunza
[![ML kwa Waanzilishi](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Sayansi ya Data kwa Waanzilishi](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI kwa Waanzilishi](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Usalama wa Mtandao kwa Waanzilishi](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web Dev kwa Wanaoanza](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT kwa Wanaoanza](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![Maendeleo ya XR kwa Wanaoanza](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Mfululizo wa Copilot
[![Copilot kwa Uandishi wa Programu kwa AI kwa Wawili](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot kwa C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Mchezo wa Copilot](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## Kupata Msaada

Kama utakwama au una maswali yoyote kuhusu ujenzi wa programu za AI. Jiunge na wanaojifunza pamoja na watengenezaji wenye uzoefu katika mijadala kuhusu MCP. Ni jamii inayounga mkono ambapo maswali yanakaribishwa na ujuzi unashirikiwa kwa uhuru.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

Kama una maoni kuhusu bidhaa au makosa unapotengeneza ziara:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Tangazo la Msamaha**:
Hati hii imetafsiriwa kwa kutumia huduma ya tafsiri ya AI [Co-op Translator](https://github.com/Azure/co-op-translator). Ingawa tunajitahidi kwa usahihi, tafadhali fahamu kuwa tafsiri za kiotomatiki zinaweza kuwa na makosa au hitilafu. Hati ya asili katika lugha yake ya asili inapaswa kuzingatiwa kama chanzo cha mamlaka. Kwa taarifa muhimu, tafsiri ya kitaalamu inayofanywa na binadamu inashauriwa. Hatuwajibiki kwa uelewa au tafsiri potofu zinazotokana na matumizi ya tafsiri hii.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->