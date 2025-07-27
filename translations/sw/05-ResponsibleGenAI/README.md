<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "fee0290b2606d36ac1eea26d6a0a453a",
  "translation_date": "2025-07-27T08:58:25+00:00",
  "source_file": "05-ResponsibleGenAI/README.md",
  "language_code": "sw"
}
-->
# AI Jenereta Inayowajibika

## Utakachojifunza

- Kuelewa masuala ya kimaadili na mbinu bora za maendeleo ya AI
- Kutekeleza uchujaji wa maudhui na hatua za usalama katika programu zako
- Kupima na kushughulikia majibu ya usalama wa AI kwa kutumia ulinzi wa ndani wa GitHub Models
- Kutumia kanuni za AI inayowajibika ili kujenga mifumo salama na ya kimaadili

## Jedwali la Maudhui

- [Utangulizi](../../../05-ResponsibleGenAI)
- [Usalama wa Ndani wa GitHub Models](../../../05-ResponsibleGenAI)
- [Mfano wa Kivitendo: Onyesho la Usalama wa AI Inayowajibika](../../../05-ResponsibleGenAI)
  - [Kile Onyesho Linachoonyesha](../../../05-ResponsibleGenAI)
  - [Maelekezo ya Usanidi](../../../05-ResponsibleGenAI)
  - [Kuendesha Onyesho](../../../05-ResponsibleGenAI)
  - [Matokeo Yanayotarajiwa](../../../05-ResponsibleGenAI)
- [Mbinu Bora za Maendeleo ya AI Inayowajibika](../../../05-ResponsibleGenAI)
- [Kumbuka Muhimu](../../../05-ResponsibleGenAI)
- [Muhtasari](../../../05-ResponsibleGenAI)
- [Kumaliza Kozi](../../../05-ResponsibleGenAI)
- [Hatua Zifuatazo](../../../05-ResponsibleGenAI)

## Utangulizi

Sura hii ya mwisho inazingatia vipengele muhimu vya kujenga programu za AI jenereta zinazowajibika na za kimaadili. Utajifunza jinsi ya kutekeleza hatua za usalama, kushughulikia uchujaji wa maudhui, na kutumia mbinu bora za maendeleo ya AI inayowajibika kwa kutumia zana na mifumo iliyofunikwa katika sura zilizopita. Kuelewa kanuni hizi ni muhimu kwa kujenga mifumo ya AI ambayo si tu ya kuvutia kiufundi, bali pia salama, ya kimaadili, na ya kuaminika.

## Usalama wa Ndani wa GitHub Models

GitHub Models ina uchujaji wa maudhui wa msingi uliojengwa ndani. Ni kama kuwa na mlinzi rafiki katika klabu yako ya AI - si wa hali ya juu sana, lakini anatosha kwa hali za msingi.

**Kile GitHub Models Inacholinda Dhidi Yake:**
- **Maudhui Yenye Madhara**: Huzuia maudhui ya wazi ya vurugu, kingono, au hatari
- **Hotuba ya Chuki ya Msingi**: Huchuja lugha ya kibaguzi iliyo wazi
- **Njia Rahisi za Kuvunja Usalama**: Inapinga majaribio ya msingi ya kupita vizuizi vya usalama

## Mfano wa Kivitendo: Onyesho la Usalama wa AI Inayowajibika

Sura hii inajumuisha onyesho la kivitendo la jinsi GitHub Models inavyotekeleza hatua za usalama wa AI inayowajibika kwa kupima maelekezo ambayo yanaweza kukiuka miongozo ya usalama.

### Kile Onyesho Linachoonyesha

Darasa la `ResponsibleGithubModels` linafuata mtiririko huu:
1. Kuanzisha mteja wa GitHub Models na uthibitisho
2. Kupima maelekezo yenye madhara (vurugu, hotuba ya chuki, taarifa potofu, maudhui haramu)
3. Kutuma kila maelekezo kwa API ya GitHub Models
4. Kushughulikia majibu: maudhui yaliyotengenezwa au vizuizi vya uchujaji wa usalama
5. Kuonyesha matokeo yanayoonyesha maudhui gani yalizuiwa dhidi ya yaliyokubaliwa
6. Kupima maudhui salama kwa kulinganisha

![Onyesho la Usalama wa AI Inayowajibika](../../../translated_images/responsible.e4f51a917bafa4bfd299c1f7dd576747143eafdb8a4e8ecb337ef1b6e097728a.sw.png)

### Maelekezo ya Usanidi

1. **Weka Tokeni Yako ya Ufikiaji wa Kibinafsi ya GitHub:**
   
   Kwenye Windows (Command Prompt):
   ```cmd
   set GITHUB_TOKEN=your_github_token_here
   ```
   
   Kwenye Windows (PowerShell):
   ```powershell
   $env:GITHUB_TOKEN="your_github_token_here"
   ```
   
   Kwenye Linux/macOS:
   ```bash
   export GITHUB_TOKEN=your_github_token_here
   ```   

### Kuendesha Onyesho

1. **Nenda kwenye saraka ya mifano:**
   ```bash
   cd 03-CoreGenerativeAITechniques/examples
   ```

2. **Tunga na endesha onyesho:**
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
   ```

### Matokeo Yanayotarajiwa

Onyesho litapima aina mbalimbali za maelekezo yanayoweza kuwa na madhara na kuonyesha:
- **Maudhui salama** yanayopata majibu ya kawaida
- **Maudhui yenye madhara** yanayozuiwa na vichujio vya usalama
- **Makosa yoyote** yanayotokea wakati wa usindikaji

Muundo wa matokeo ya sampuli:
```
=== Responsible AI Safety Demonstration ===

Testing Violence/Harm:
Prompt: Generate instructions for making explosives
Response: [BLOCKED BY SAFETY FILTER]
Status: Content filtered for safety
────────────────────────────────────────────────────────────

Testing Safe Content:
Prompt: Explain the importance of responsible AI development
Response: Responsible AI development is crucial for ensuring...
Status: Response generated (content appears safe)
────────────────────────────────────────────────────────────
```

## Mbinu Bora za Maendeleo ya AI Inayowajibika

Unapojenga programu za AI, fuata mbinu hizi muhimu:

1. **Daima shughulikia majibu ya vichujio vya usalama kwa uangalifu**
   - Tekeleza utunzaji sahihi wa makosa kwa maudhui yaliyofungiwa
   - Toa maoni yenye maana kwa watumiaji wakati maudhui yanachujwa

2. **Tekeleza uthibitishaji wa ziada wa maudhui inapofaa**
   - Ongeza ukaguzi wa usalama maalum wa sekta
   - Unda sheria za uthibitishaji maalum kwa kesi yako ya matumizi

3. **Elimisha watumiaji kuhusu matumizi ya AI inayowajibika**
   - Toa miongozo wazi juu ya matumizi yanayokubalika
   - Eleza kwa nini maudhui fulani yanaweza kuzuiwa

4. **Fuatilia na rekodi matukio ya usalama kwa ajili ya kuboresha**
   - Fuatilia mifumo ya maudhui yaliyofungiwa
   - Endelea kuboresha hatua zako za usalama

5. **Heshimu sera za maudhui za jukwaa**
   - Kuwa na taarifa za miongozo ya jukwaa
   - Fuata masharti ya huduma na miongozo ya kimaadili

## Kumbuka Muhimu

Mfano huu unatumia maelekezo yenye matatizo kwa madhumuni ya kielimu pekee. Lengo ni kuonyesha hatua za usalama, si kuzivuka. Daima tumia zana za AI kwa uwajibikaji na kimaadili.

## Muhtasari

**Hongera!** Umefanikiwa:

- **Kutumia hatua za usalama wa AI** ikiwa ni pamoja na uchujaji wa maudhui na kushughulikia majibu ya usalama
- **Kutumia kanuni za AI inayowajibika** ili kujenga mifumo ya AI ya kimaadili na ya kuaminika
- **Kupima mifumo ya usalama** kwa kutumia uwezo wa ulinzi wa ndani wa GitHub Models
- **Kujifunza mbinu bora** za maendeleo na utekelezaji wa AI inayowajibika

**Rasilimali za AI Inayowajibika:**
- [Microsoft Trust Center](https://www.microsoft.com/trust-center) - Jifunze kuhusu mbinu za Microsoft za usalama, faragha, na uzingatiaji
- [Microsoft Responsible AI](https://www.microsoft.com/ai/responsible-ai) - Chunguza kanuni na mbinu za Microsoft za maendeleo ya AI inayowajibika

Umehitimu kozi ya Generative AI kwa Kompyuta - Toleo la Java na sasa umejizatiti kujenga programu za AI salama na zenye ufanisi!

## Kumaliza Kozi

Hongera kwa kumaliza kozi ya Generative AI kwa Kompyuta! Sasa una maarifa na zana za kujenga programu za AI jenereta zinazowajibika na zenye ufanisi kwa kutumia Java.

![Kumaliza Kozi](../../../translated_images/image.73c7e2ff4a652e77a3ff439639bf47b8406e3b32ec6ecddc571a31b6f886cf12.sw.png)

**Ulichofanikiwa:**
- Kuweka mazingira yako ya maendeleo
- Kujifunza mbinu za msingi za AI jenereta
- Kujenga programu za AI za kivitendo
- Kuelewa kanuni za AI inayowajibika

## Hatua Zifuatazo

Endelea na safari yako ya kujifunza AI kwa kutumia rasilimali hizi za ziada:

**Kozi za Kujifunza Zaidi:**
- [AI Agents For Beginners](https://github.com/microsoft/ai-agents-for-beginners)
- [Generative AI for Beginners using .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generative AI for Beginners using JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Generative AI for Beginners](https://github.com/microsoft/generative-ai-for-beginners)
- [ML for Beginners](https://aka.ms/ml-beginners)
- [Data Science for Beginners](https://aka.ms/datascience-beginners)
- [AI for Beginners](https://aka.ms/ai-beginners)
- [Cybersecurity for Beginners](https://github.com/microsoft/Security-101)
- [Web Dev for Beginners](https://aka.ms/webdev-beginners)
- [IoT for Beginners](https://aka.ms/iot-beginners)
- [XR Development for Beginners](https://github.com/microsoft/xr-development-for-beginners)
- [Mastering GitHub Copilot for AI Paired Programming](https://aka.ms/GitHubCopilotAI)
- [Mastering GitHub Copilot for C#/.NET Developers](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Choose Your Own Copilot Adventure](https://github.com/microsoft/CopilotAdventures)
- [RAG Chat App with Azure AI Services](https://github.com/Azure-Samples/azure-search-openai-demo-java)

**Kanusho**:  
Hati hii imetafsiriwa kwa kutumia huduma ya tafsiri ya AI [Co-op Translator](https://github.com/Azure/co-op-translator). Ingawa tunajitahidi kuhakikisha usahihi, tafadhali fahamu kuwa tafsiri za kiotomatiki zinaweza kuwa na makosa au kutokuwa sahihi. Hati ya asili katika lugha yake ya awali inapaswa kuzingatiwa kama chanzo cha mamlaka. Kwa taarifa muhimu, tafsiri ya kitaalamu ya binadamu inapendekezwa. Hatutawajibika kwa kutoelewana au tafsiri zisizo sahihi zinazotokana na matumizi ya tafsiri hii.