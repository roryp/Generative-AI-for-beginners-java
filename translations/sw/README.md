# AI Inayozalisha kwa Waanzilishi - Toleo la Java
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI for Beginners - Java Edition](../../translated_images/sw/beg-genai-series.8b48be9951cc574c.webp)

**Muda wa Kutoa**: Warsha nzima inaweza kukamilishwa mtandaoni bila usanidi wa eneo mahali. Usanidi wa mazingira unachukua dakika 2, na kuchunguza mifano kunahitaji saa 1-3 kulingana na kina cha uchunguzi.

> **Anza Haraka** 

1. Fikia hifadhidata hii kwenye akaunti yako ya GitHub
2. Bonyeza **Code** → kichupo cha **Codespaces** → **...** → **Mpya na chaguo...**
3. Tumia chaguo-msingi – hii itachagua Kontena la Maendeleo lililotengenezwa kwa kozi hii
4. Bonyeza **Unda codespace**
5. Subiri takriban dakika 2 kwa mazingira kuwa tayari
6. Ruka moja kwa moja kwa [Mfano wa kwanza](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **Unapendelea Kukopa Kwenye Eneo Mahali?**
>
> Hifadhidata hii inajumuisha tafsiri zaidi ya 50 za lugha ambazo huongeza sana ukubwa wa kupakua. Ili kukopa bila tafsiri, tumia sparse checkout:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> Hii inakupa kila kitu unachohitaji kukamilisha kozi na upakuaji wa haraka zaidi.


## Msaada wa Lugha Nyingi

### Imeungwa mkono kupitia GitHub Action (Iliyot automatika na Inasasishwa daima)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Kiarabu](../ar/README.md) | [Kibengali](../bn/README.md) | [Kibulgaria](../bg/README.md) | [Kiburma (Myanmar)](../my/README.md) | [Kichina (Rahisi)](../zh-CN/README.md) | [Kichina (Mila, Hong Kong)](../zh-HK/README.md) | [Kichina (Mila, Macau)](../zh-MO/README.md) | [Kichina (Mila, Taiwan)](../zh-TW/README.md) | [Kikroatia](../hr/README.md) | [Kicheki](../cs/README.md) | [Kidenmaki](../da/README.md) | [Kiholanzi](../nl/README.md) | [Kiestonia](../et/README.md) | [Kifini](../fi/README.md) | [Kifaransa](../fr/README.md) | [Kijerumani](../de/README.md) | [Kigiriki](../el/README.md) | [Kiebrania](../he/README.md) | [Kihindi](../hi/README.md) | [Kihungari](../hu/README.md) | [Kiindonesia](../id/README.md) | [Kiitaliano](../it/README.md) | [Kijapani](../ja/README.md) | [Kikannada](../kn/README.md) | [Kikorea](../ko/README.md) | [Kilithuania](../lt/README.md) | [Kimalay](../ms/README.md) | [Kimalayalam](../ml/README.md) | [Kimarathi](../mr/README.md) | [Kinepali](../ne/README.md) | [Kipidgin cha Nijeria](../pcm/README.md) | [Kinorwe](../no/README.md) | [Kiajemi (Farsi)](../fa/README.md) | [Kipolandi](../pl/README.md) | [Kireno (Brazil)](../pt-BR/README.md) | [Kireno (Ureno)](../pt-PT/README.md) | [Kipunia (Gurmukhi)](../pa/README.md) | [Kiromania](../ro/README.md) | [Kirusi](../ru/README.md) | [Kiserbia (Cyrillic)](../sr/README.md) | [Kislovakia](../sk/README.md) | [Kislovenia](../sl/README.md) | [Kihispania](../es/README.md) | [Kiswahili](./README.md) | [Kiswidi](../sv/README.md) | [Kitagalog (Kifilipino)](../tl/README.md) | [Kitamili](../ta/README.md) | [Kitelugu](../te/README.md) | [Kithai](../th/README.md) | [Kituruki](../tr/README.md) | [Kiukraini](../uk/README.md) | [Kiurdu](../ur/README.md) | [Kivietinamu](../vi/README.md)

> **Unapendelea Kukopa Kwenye Eneo Mahali?**

> Hifadhidata hii inajumuisha tafsiri zaidi ya 50 za lugha ambazo huongeza sana ukubwa wa kupakua. Ili kukopa bila tafsiri, tumia sparse checkout:
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> Hii inakupa kila kitu unachohitaji kukamilisha kozi na upakuaji wa haraka zaidi.
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Muundo wa Kozi & Njia ya Kujifunza

### **Sura 1: Utangulizi wa AI Inayozalisha**
- **Mafanikio Muhimu**: Kuelewa Modeli Kubwa za Lugha, tokeni, embeddings, na uwezo wa AI
- **Ekosistimu ya AI ya Java**: Muhtasari wa Spring AI na OpenAI SDKs
- **Itifaki ya Muktadha wa Modeli**: Utangulizi wa MCP na jukumu lake katika mawasiliano ya mawakala wa AI
- **Matumizi Halisi**: Hali halisi ikiwa ni pamoja na roboti wa mazungumzo na uzalishaji wa maudhui
- **[→ Anza Sura 1](./01-IntroToGenAI/README.md)**

### **Sura 2: Usanidi wa Mazingira ya Maendeleo**
- **Usanidi wa Watoa Huduma Wengi**: Weka GitHub Models, Azure OpenAI, na ushirikiano wa OpenAI Java SDK
- **Spring Boot + Spring AI**: Mbinu bora za maendeleo ya programu za AI za shirika
- **GitHub Models**: Ufikiaji bure wa modeli za AI kwa majaribio na kujifunza (hakuna kadi ya mkopo inayohitajika)
- **Zana za Maendeleo**: Kontena za Docker, VS Code, na usanidi wa GitHub Codespaces
- **[→ Anza Sura 2](./02-SetupDevEnvironment/README.md)**

### **Sura 3: Mbinu Muhimu za AI Inayozalisha**
- **Uhandisi wa Mchochezi (Prompt)**: Mbinu za majibu bora za modeli za AI
- **Embeddings & Operesheni za Vector**: Tekeleza utafutaji wa semantiki na ulinganifu wa ushujaa
- **Uzalishaji Ulioboreshwa na Upataji (RAG)**: Changanya AI na vyanzo vyako vya data
- **Kupigia Kifunctioni**: Panua uwezo wa AI kwa zana na viendelezi maalum
- **[→ Anza Sura 3](./03-CoreGenerativeAITechniques/README.md)**

### **Sura 4: Matumizi Halisi & Miradi**
- **Mzalishaji wa Hadithi za Mbuzi** (`petstory/`): Uzalishaji wa maudhui ya ubunifu kwa kutumia GitHub Models
- **Onyesho la Kielektroniki la Foundry Local** (`foundrylocal/`): Ushirikiano wa modeli za AI za eneo mahali na OpenAI Java SDK
- **Huduma ya Kikokotoo cha MCP** (`calculator/`): Utekelezaji wa msingi wa Itifaki ya Muktadha wa Modeli kwa Spring AI
- **[→ Anza Sura 4](./04-PracticalSamples/README.md)**

### **Sura 5: Maendeleo ya AI ya Kuwajibika**
- **Usalama wa GitHub Models**: Jaribu vuto kutoka kwa uondoaji wa maudhui uliojengwa na mifumo ya usalama (vizuizi vikali na kukataa laini)
- **Onyesho la AI ya Kuwajibika**: Mfano wa vitendo unaoonyesha jinsi mifumo ya kisasa ya usalama wa AI inavyofanya kazi
- **Mbinu Bora**: Miongozo muhimu ya maendeleo na uanzishaji wa AI yenye maadili
- **[→ Anza Sura 5](./05-ResponsibleGenAI/README.md)**

## Rasilimali Zaidi

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j kwa Waanzilishi](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js kwa Waanzilishi](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)

---

### Azure / Edge / MCP / Wakala
[![AZD kwa Waanzilishi](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI kwa Waanzilishi](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP kwa Waanzilishi](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Wakala wa AI kwa Waanzilishi](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

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

[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Mfululizo wa Copilot
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## Kupata Msaada

Ikiwa unakwama au una maswali yoyote kuhusu kujenga programu za AI. Jiunge na wanafunzi wenzako na waendelezaji wenye uzoefu katika mijadala kuhusu MCP. Ni jumuiya yenye msaada ambapo maswali yanakaribishwa na maarifa yanashirikiwa kwa uhuru.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

Ikiwa una maoni kuhusu bidhaa au makosa wakati wa kujenga tembelea:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Angalizo**:
Nyaraka hii imetafsiriwa kwa kutumia huduma ya utafsiri wa AI [Co-op Translator](https://github.com/Azure/co-op-translator). Ingawa tunajitahidi kuhakikisha usahihi, tafadhali fahamu kwamba tafsiri za kiotomatiki zinaweza kuwa na makosa au kasoro. Nyaraka ya asili katika lugha yake ya asili inapaswa kuchukuliwa kama chanzo halali. Kwa taarifa muhimu, tafsiri ya kitaalamu inayofanywa na binadamu inapendekezwa. Hatubebwi jukumu kwa maelewano au tafsiri zisizo sahihi zinazotokana na matumizi ya tafsiri hii.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->