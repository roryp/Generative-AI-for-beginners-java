<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b1a467efb7f8e13a19f961a587226f71",
  "translation_date": "2025-12-18T10:18:57+00:00",
  "source_file": "README.md",
  "language_code": "sw"
}
-->
# AI Inayozalisha kwa Waanzilishi - Toleo la Java
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.sw.png)

**Muda wa Kujitolea**: Warsha nzima inaweza kukamilika mtandaoni bila usanidi wa eneo la kazi. Usanidi wa mazingira huchukua dakika 2, na kuchunguza mifano kunahitaji saa 1-3 kulingana na kina cha uchunguzi.

> **Anza Haraka**

1. Fanya fork ya hifadhidata hii kwenye akaunti yako ya GitHub
2. Bonyeza **Code** → kichupo cha **Codespaces** → **...** → **New with options...**
3. Tumia chaguo za msingi – hii itachagua kontena la Maendeleo lililoundwa kwa kozi hii
4. Bonyeza **Create codespace**
5. Subiri takriban dakika 2 kwa mazingira kuwa tayari
6. Ruka moja kwa moja kwenda [Mfano wa kwanza](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **Unapendelea Kuikopa Kwenye Kompyuta?**
>
> Hifadhidata hii ina tafsiri zaidi ya 50 za lugha ambazo huongeza sana ukubwa wa kupakua. Ili kuikopa bila tafsiri, tumia sparse checkout:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> Hii inakupa kila kitu unachohitaji kukamilisha kozi kwa upakuaji wa haraka zaidi.


## Msaada wa Lugha Nyingi

### Inasaidiwa kupitia GitHub Action (Moja kwa Moja & Daima Imeboreshwa)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Kiarabu](../ar/README.md) | [Kibengali](../bn/README.md) | [Kibulgaria](../bg/README.md) | [Kiburma (Myanmar)](../my/README.md) | [Kichina (Rahisi)](../zh/README.md) | [Kichina (Mila, Hong Kong)](../hk/README.md) | [Kichina (Mila, Macau)](../mo/README.md) | [Kichina (Mila, Taiwan)](../tw/README.md) | [Kroeshia](../hr/README.md) | [Kicheki](../cs/README.md) | [Kidenmaki](../da/README.md) | [Kiholanzi](../nl/README.md) | [Kiestonia](../et/README.md) | [Kifini](../fi/README.md) | [Kifaransa](../fr/README.md) | [Kijerumani](../de/README.md) | [Kigiriki](../el/README.md) | [Kiebrania](../he/README.md) | [Kihindi](../hi/README.md) | [Kihungari](../hu/README.md) | [Kiindonesia](../id/README.md) | [Kiitaliano](../it/README.md) | [Kijapani](../ja/README.md) | [Kikannada](../kn/README.md) | [Kikorea](../ko/README.md) | [Kilithuania](../lt/README.md) | [Kimelayu](../ms/README.md) | [Kimalayalam](../ml/README.md) | [Kimarathi](../mr/README.md) | [Kinepali](../ne/README.md) | [Kipidgin cha Nigeria](../pcm/README.md) | [Kinorwe](../no/README.md) | [Kiajemi (Farsi)](../fa/README.md) | [Kipolandi](../pl/README.md) | [Kireno (Brazil)](../br/README.md) | [Kireno (Portugal)](../pt/README.md) | [Kipunjabi (Gurmukhi)](../pa/README.md) | [Kiromania](../ro/README.md) | [Kirusi](../ru/README.md) | [Kiserbia (Cyrillic)](../sr/README.md) | [Kislovakia](../sk/README.md) | [Kislovenia](../sl/README.md) | [Kihispania](../es/README.md) | [Kiswahili](./README.md) | [Kiswidi](../sv/README.md) | [Kitagalog (Filipino)](../tl/README.md) | [Kitamili](../ta/README.md) | [Kitelugu](../te/README.md) | [Kithai](../th/README.md) | [Kituruki](../tr/README.md) | [Kiukraini](../uk/README.md) | [Kiurdu](../ur/README.md) | [Kivietinamu](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Muundo wa Kozi & Njia ya Kujifunza

### **Sura ya 1: Utangulizi wa AI Inayozalisha**
- **Mafundisho Muhimu**: Kuelewa Modeli Kubwa za Lugha, tokeni, embeddings, na uwezo wa AI
- **Ecosystem ya AI ya Java**: Muhtasari wa Spring AI na OpenAI SDKs
- **Itifaki ya Muktadha wa Modeli**: Utangulizi wa MCP na jukumu lake katika mawasiliano ya mawakala wa AI
- **Matumizi ya Kivitendo**: Hali halisi ikijumuisha chatbots na uzalishaji wa maudhui
- **[→ Anza Sura ya 1](./01-IntroToGenAI/README.md)**

### **Sura ya 2: Usanidi wa Mazingira ya Maendeleo**
- **Usanidi wa Watoa Huduma Wengi**: Weka GitHub Models, Azure OpenAI, na OpenAI Java SDK
- **Spring Boot + Spring AI**: Mbinu bora za maendeleo ya programu za AI za biashara
- **GitHub Models**: Upatikanaji wa bure wa modeli za AI kwa majaribio na kujifunza (hakuna kadi ya mkopo inahitajika)
- **Zana za Maendeleo**: Kontena za Docker, VS Code, na usanidi wa GitHub Codespaces
- **[→ Anza Sura ya 2](./02-SetupDevEnvironment/README.md)**

### **Sura ya 3: Mbinu Muhimu za AI Inayozalisha**
- **Uhandisi wa Prompt**: Mbinu za majibu bora ya modeli za AI
- **Embeddings & Operesheni za Vector**: Tekeleza utafutaji wa maana na ulinganishaji wa usawa
- **Uzalishaji Ulioboreshwa kwa Kupata (RAG)**: Changanya AI na vyanzo vyako vya data
- **Kupiga Simu za Kazi**: Panua uwezo wa AI kwa zana na plugins maalum
- **[→ Anza Sura ya 3](./03-CoreGenerativeAITechniques/README.md)**

### **Sura ya 4: Matumizi ya Kivitendo & Miradi**
- **Mzalishaji wa Hadithi za Wanyama wa Kifugo** (`petstory/`): Uzalishaji wa maudhui ya ubunifu kwa GitHub Models
- **Demo ya Foundry Local** (`foundrylocal/`): Muunganisho wa modeli ya AI ya eneo la kazi na OpenAI Java SDK
- **Huduma ya Kihesabu ya MCP** (`calculator/`): Utekelezaji wa msingi wa Itifaki ya Muktadha wa Modeli na Spring AI
- **[→ Anza Sura ya 4](./04-PracticalSamples/README.md)**

### **Sura ya 5: Maendeleo ya AI kwa Uwajibikaji**
- **Usalama wa GitHub Models**: Jaribu vichujio vya maudhui vilivyojengwa na mifumo ya usalama (vizuizi ngumu na kukataa kwa upole)
- **Demo ya AI Inayowajibika**: Mfano wa vitendo unaoonyesha jinsi mifumo ya usalama ya AI ya kisasa inavyofanya kazi
- **Mbinu Bora**: Miongozo muhimu kwa maendeleo na utekelezaji wa AI kwa maadili
- **[→ Anza Sura ya 5](./05-ResponsibleGenAI/README.md)**

## Rasilimali Zaidi

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j kwa Waanzilishi](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js kwa Waanzilishi](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)

---

### Azure / Edge / MCP / Mawakala
[![AZD kwa Waanzilishi](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI kwa Waanzilishi](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP kwa Waanzilishi](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Mawakala wa AI kwa Waanzilishi](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Mfululizo wa AI Inayozalisha
[![AI Inayozalisha kwa Waanzilishi](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![AI Inayozalisha (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![AI Inayozalisha (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![AI Inayozalisha (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### Kujifunza Msingi
[![ML kwa Waanzilishi](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Sayansi ya Data kwa Waanzilishi](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![AI kwa Waanzilishi](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Usalama wa Mtandao kwa Waanzilishi](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Uendelezaji wa Wavuti kwa Waanzilishi](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT kwa Waanzilishi](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![Maendeleo ya XR kwa Waanzilishi](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Mfululizo wa Copilot
[![Copilot kwa Uandishi wa Pamoja wa AI](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot kwa C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## Kupata Msaada

Ikiwa unakumbwa na shida au una maswali yoyote kuhusu kujenga programu za AI. Jiunge na wanafunzi wenzako na waendelezaji wenye uzoefu katika mijadala kuhusu MCP. Ni jamii inayounga mkono ambapo maswali yanakaribishwa na maarifa yanashirikiwa kwa uhuru.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

Ikiwa una maoni kuhusu bidhaa au makosa wakati wa kujenga tembelea:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Kiarifu cha Kutotegemea**:
Hati hii imetafsiriwa kwa kutumia huduma ya tafsiri ya AI [Co-op Translator](https://github.com/Azure/co-op-translator). Ingawa tunajitahidi kwa usahihi, tafadhali fahamu kwamba tafsiri za kiotomatiki zinaweza kuwa na makosa au upungufu wa usahihi. Hati ya asili katika lugha yake ya asili inapaswa kuchukuliwa kama chanzo cha mamlaka. Kwa taarifa muhimu, tafsiri ya kitaalamu ya binadamu inapendekezwa. Hatubebei dhamana kwa kutoelewana au tafsiri potofu zinazotokana na matumizi ya tafsiri hii.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->