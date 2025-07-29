<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c2a244c959e00da1ae1613d2ebfdac65",
  "translation_date": "2025-07-29T09:54:54+00:00",
  "source_file": "02-SetupDevEnvironment/README.md",
  "language_code": "sw"
}
-->
# Kuweka Mazingira ya Maendeleo kwa Generative AI kwa Java

> **Anza Haraka**: Andika msimbo mtandaoni kwa dakika 2 - Ruka hadi [GitHub Codespaces Setup](../../../02-SetupDevEnvironment) - hakuna usakinishaji wa ndani unaohitajika na hutumia mifano ya GitHub!

> **Unavutiwa na Azure OpenAI?**, angalia [Mwongozo wetu wa Usanidi wa Azure OpenAI](getting-started-azure-openai.md) na hatua za kuunda rasilimali mpya ya Azure OpenAI.

## Unachojifunza

- Jinsi ya kuweka mazingira ya maendeleo ya Java kwa programu za AI
- Chagua na usanidi mazingira yako ya maendeleo unayopendelea (kipaumbele kwa Codespaces, kontena la ndani la maendeleo, au usanidi kamili wa ndani)
- Jaribu usanidi wako kwa kuunganisha na Mifano ya GitHub

## Jedwali la Yaliyomo

- [Unachojifunza](../../../02-SetupDevEnvironment)
- [Utangulizi](../../../02-SetupDevEnvironment)
- [Hatua ya 1: Weka Mazingira Yako ya Maendeleo](../../../02-SetupDevEnvironment)
  - [Chaguo A: GitHub Codespaces (Inapendekezwa)](../../../02-SetupDevEnvironment)
  - [Chaguo B: Kontena la Ndani la Maendeleo](../../../02-SetupDevEnvironment)
  - [Chaguo C: Tumia Usanidi Wako wa Ndani Uliopo](../../../02-SetupDevEnvironment)
- [Hatua ya 2: Unda Tokeni ya Kibinafsi ya GitHub](../../../02-SetupDevEnvironment)
- [Hatua ya 3: Jaribu Usanidi Wako](../../../02-SetupDevEnvironment)
- [Utatuzi wa Shida](../../../02-SetupDevEnvironment)
- [Muhtasari](../../../02-SetupDevEnvironment)
- [Hatua Zifuatazo](../../../02-SetupDevEnvironment)

## Utangulizi

Sura hii itakuongoza jinsi ya kuweka mazingira ya maendeleo. Tutatumia **Mifano ya GitHub** kama mfano wetu wa msingi kwa sababu ni bure, rahisi kusanidi kwa akaunti ya GitHub pekee, haihitaji kadi ya mkopo, na inatoa ufikiaji wa mifano mingi ya kujaribu.

**Hakuna usanidi wa ndani unaohitajika!** Unaweza kuanza kuandika msimbo mara moja ukitumia GitHub Codespaces, ambayo hutoa mazingira kamili ya maendeleo kwenye kivinjari chako.

<img src="./images/models.webp" alt="Picha ya skrini: Mifano ya GitHub" width="50%">

Tunapendekeza kutumia [**Mifano ya GitHub**](https://github.com/marketplace?type=models) kwa kozi hii kwa sababu:
- **Bure** kuanza
- **Rahisi** kusanidi kwa akaunti ya GitHub pekee
- **Hakuna kadi ya mkopo** inayohitajika
- **Mifano mingi** inapatikana kwa majaribio

> **Kumbuka**: Mifano ya GitHub inayotumika katika mafunzo haya ina mipaka hii ya bure:
> - Maombi 15 kwa dakika (150 kwa siku)
> - ~Maneno 8,000 ndani, ~maneno 4,000 nje kwa ombi
> - Maombi 5 yanayofanyika kwa wakati mmoja
> 
> Kwa matumizi ya uzalishaji, boresha hadi Azure AI Foundry Models kwa akaunti yako ya Azure. Msimbo wako hauhitaji kubadilishwa. Angalia [nyaraka za Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/foundry-models/how-to/quickstart-github-models).

## Hatua ya 1: Weka Mazingira Yako ya Maendeleo

<a name="quick-start-cloud"></a>

Tumeunda kontena la maendeleo lililowekwa tayari ili kupunguza muda wa usanidi na kuhakikisha una zana zote muhimu kwa kozi hii ya Generative AI kwa Java. Chagua njia yako ya maendeleo unayopendelea:

### Chaguo za Usanidi wa Mazingira:

#### Chaguo A: GitHub Codespaces (Inapendekezwa)

**Anza kuandika msimbo kwa dakika 2 - hakuna usanidi wa ndani unaohitajika!**

1. Fanya nakala ya hifadhi hii kwenye akaunti yako ya GitHub  
   > **Kumbuka**: Ikiwa unataka kuhariri usanidi wa msingi tafadhali angalia [Usanidi wa Kontena la Maendeleo](../../../.devcontainer/devcontainer.json)
2. Bonyeza **Code** → kichupo cha **Codespaces** → **...** → **New with options...**
3. Tumia chaguo-msingi – hii itachagua **Usanidi wa kontena la maendeleo**: **Mazingira ya Maendeleo ya Generative AI Java** kontena maalum la maendeleo lililoundwa kwa kozi hii
4. Bonyeza **Create codespace**
5. Subiri ~dakika 2 kwa mazingira kuwa tayari
6. Endelea hadi [Hatua ya 2: Unda Tokeni ya GitHub](../../../02-SetupDevEnvironment)

<img src="./images/codespaces.png" alt="Picha ya skrini: Menyu ya Codespaces" width="50%">

<img src="./images/image.png" alt="Picha ya skrini: New with options" width="50%">

<img src="./images/codespaces-create.png" alt="Picha ya skrini: Chaguo za kuunda codespace" width="50%">

> **Faida za Codespaces**:
> - Hakuna usakinishaji wa ndani unaohitajika
> - Inafanya kazi kwenye kifaa chochote chenye kivinjari
> - Imewekwa tayari na zana zote na utegemezi
> - Saa 60 za bure kwa mwezi kwa akaunti za kibinafsi
> - Mazingira thabiti kwa wanafunzi wote

#### Chaguo B: Kontena la Ndani la Maendeleo

**Kwa watengenezaji wanaopendelea maendeleo ya ndani na Docker**

1. Fanya nakala na pakua hifadhi hii kwenye mashine yako ya ndani  
   > **Kumbuka**: Ikiwa unataka kuhariri usanidi wa msingi tafadhali angalia [Usanidi wa Kontena la Maendeleo](../../../.devcontainer/devcontainer.json)
2. Sakinisha [Docker Desktop](https://www.docker.com/products/docker-desktop/) na [VS Code](https://code.visualstudio.com/)
3. Sakinisha [Kiendelezi cha Dev Containers](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) kwenye VS Code
4. Fungua folda ya hifadhi kwenye VS Code
5. Unapoulizwa, bonyeza **Reopen in Container** (au tumia `Ctrl+Shift+P` → "Dev Containers: Reopen in Container")
6. Subiri kontena lijengwe na kuanza
7. Endelea hadi [Hatua ya 2: Unda Tokeni ya GitHub](../../../02-SetupDevEnvironment)

<img src="./images/devcontainer.png" alt="Picha ya skrini: Usanidi wa kontena la maendeleo" width="50%">

<img src="./images/image-3.png" alt="Picha ya skrini: Ujenzi wa kontena la maendeleo umekamilika" width="50%">

#### Chaguo C: Tumia Usanidi Wako wa Ndani Uliopo

**Kwa watengenezaji wenye mazingira ya Java yaliyopo**

Mahitaji:
- [Java 21+](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) 
- [Maven 3.9+](https://maven.apache.org/download.cgi)
- [VS Code](https://code.visualstudio.com) au IDE unayopendelea

Hatua:
1. Pakua hifadhi hii kwenye mashine yako ya ndani
2. Fungua mradi kwenye IDE yako
3. Endelea hadi [Hatua ya 2: Unda Tokeni ya GitHub](../../../02-SetupDevEnvironment)

> **Kidokezo cha Mtaalamu**: Ikiwa una mashine yenye uwezo mdogo lakini unataka kutumia VS Code ndani, tumia GitHub Codespaces! Unaweza kuunganisha VS Code yako ya ndani na Codespace inayohifadhiwa mtandaoni kwa manufaa ya pande zote mbili.

<img src="./images/image-2.png" alt="Picha ya skrini: Kontena la maendeleo la ndani limeundwa" width="50%">

## Hatua ya 2: Unda Tokeni ya Kibinafsi ya GitHub

1. Nenda kwenye [Mipangilio ya GitHub](https://github.com/settings/profile) na uchague **Settings** kutoka kwenye menyu ya wasifu wako.
2. Kwenye upau wa kushoto, bonyeza **Developer settings** (kawaida iko chini).
3. Chini ya **Personal access tokens**, bonyeza **Fine-grained tokens** (au fuata kiungo hiki cha moja kwa moja [hapa](https://github.com/settings/personal-access-tokens)).
4. Bonyeza **Generate new token**.
5. Chini ya "Token name", toa jina la kuelezea (mfano, `GenAI-Java-Course-Token`).
6. Weka tarehe ya kumalizika muda (inapendekezwa: siku 7 kwa usalama bora).
7. Chini ya "Resource owner", chagua akaunti yako ya mtumiaji.
8. Chini ya "Repository access", chagua hifadhi unazotaka kutumia na Mifano ya GitHub (au "All repositories" ikiwa inahitajika).
9. Chini ya "Repository permissions", tafuta **Models** na uweke kuwa **Read and write**.
10. Bonyeza **Generate token**.
11. **Nakili na uhifadhi tokeni yako sasa** – huwezi kuiona tena!

> **Kidokezo cha Usalama**: Tumia wigo wa chini unaohitajika na muda mfupi wa kumalizika kwa tokeni zako za ufikiaji.

## Hatua ya 3: Jaribu Usanidi Wako na Mfano wa Mifano ya GitHub

Mazingira yako ya maendeleo yanapokuwa tayari, hebu tujaribu ushirikiano wa Mifano ya GitHub na programu yetu ya mfano katika [`02-SetupDevEnvironment/examples/github-models`](../../../02-SetupDevEnvironment/examples/github-models).

1. Fungua terminali kwenye mazingira yako ya maendeleo.
2. Nenda kwenye mfano wa Mifano ya GitHub:
   ```bash
   cd 02-SetupDevEnvironment/examples/github-models
   ```
3. Weka tokeni yako ya GitHub kama mabadiliko ya mazingira:
   ```bash
   # macOS/Linux
   export GITHUB_TOKEN=your_token_here
   
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_token_here"
   ```

4. Endesha programu:
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.githubmodels.App"
   ```

Unapaswa kuona matokeo yanayofanana na:
```text
Using model: gpt-4.1-nano
Sending request to GitHub Models...
Response: Hello World!
```

### Kuelewa Msimbo wa Mfano

Kwanza, hebu tuelewe tulichokimbia. Mfano chini ya `examples/github-models` unatumia OpenAI Java SDK kuunganisha na Mifano ya GitHub:

**Msimbo huu unafanya nini:**
- **Unaunganisha** na Mifano ya GitHub ukitumia tokeni yako ya kibinafsi
- **Inatuma** ujumbe rahisi wa "Say Hello World!" kwa mfano wa AI
- **Inapokea** na kuonyesha jibu la AI
- **Inathibitisha** kuwa usanidi wako unafanya kazi vizuri

**Utegemezi Muhimu** (katika `pom.xml`):
```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

**Msimbo Mkuu** (`App.java`):
```java
// Connect to GitHub Models using OpenAI Java SDK
OpenAIClient client = OpenAIOkHttpClient.builder()
    .apiKey(pat)
    .baseUrl("https://models.inference.ai.azure.com")
    .build();

// Create chat completion request
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .model(modelId)
    .addSystemMessage("You are a concise assistant.")
    .addUserMessage("Say Hello World!")
    .build();

// Get AI response
ChatCompletion response = client.chat().completions().create(params);
System.out.println("Response: " + response.choices().get(0).message().content().orElse("No response content"));
```

## Muhtasari

Hongera! Sasa una kila kitu kimewekwa:

- Umeunda Tokeni ya Kibinafsi ya GitHub yenye ruhusa sahihi za ufikiaji wa mifano ya AI
- Umeendesha mazingira yako ya maendeleo ya Java (iwe ni Codespaces, kontena la maendeleo, au ndani kabisa)
- Umeunganisha na Mifano ya GitHub ukitumia OpenAI Java SDK kwa maendeleo ya AI ya bure
- Umejaribu na kuhakikisha kila kitu kinafanya kazi kwa mfano rahisi unaozungumza na mifano ya AI

## Hatua Zifuatazo

[Chapter 3: Core Generative AI Techniques](../03-CoreGenerativeAITechniques/README.md)

## Utatuzi wa Shida

Unakutana na changamoto? Hapa kuna matatizo ya kawaida na suluhisho:

- **Tokeni haifanyi kazi?** 
  - Hakikisha umenakili tokeni yote bila nafasi za ziada
  - Thibitisha kuwa tokeni imewekwa kwa usahihi kama mabadiliko ya mazingira
  - Hakikisha tokeni yako ina ruhusa sahihi (Models: Read and write)

- **Maven haipatikani?** 
  - Ikiwa unatumia kontena za maendeleo/Codespaces, Maven inapaswa kuwa imewekwa tayari
  - Kwa usanidi wa ndani, hakikisha Java 21+ na Maven 3.9+ zimesakinishwa
  - Jaribu `mvn --version` kuthibitisha usakinishaji

- **Shida za muunganisho?** 
  - Angalia muunganisho wako wa intaneti
  - Thibitisha kuwa GitHub inapatikana kutoka kwenye mtandao wako
  - Hakikisha hauko nyuma ya ukuta wa moto unaozuia mwisho wa Mifano ya GitHub

- **Kontena la maendeleo halianzi?** 
  - Hakikisha Docker Desktop inaendesha (kwa maendeleo ya ndani)
  - Jaribu kujenga upya kontena: `Ctrl+Shift+P` → "Dev Containers: Rebuild Container"

- **Hitilafu za uundaji wa programu?**
  - Hakikisha uko kwenye saraka sahihi: `02-SetupDevEnvironment/examples/github-models`
  - Jaribu kusafisha na kujenga upya: `mvn clean compile`

> **Unahitaji msaada?**: Bado unakutana na changamoto? Fungua suala kwenye hifadhi na tutakusaidia.

**Kanusho**:  
Hati hii imetafsiriwa kwa kutumia huduma ya tafsiri ya AI [Co-op Translator](https://github.com/Azure/co-op-translator). Ingawa tunajitahidi kuhakikisha usahihi, tafadhali fahamu kuwa tafsiri za kiotomatiki zinaweza kuwa na makosa au kutokuwa sahihi. Hati ya asili katika lugha yake ya awali inapaswa kuzingatiwa kama chanzo cha mamlaka. Kwa taarifa muhimu, inashauriwa kutumia huduma ya tafsiri ya kitaalamu ya binadamu. Hatutawajibika kwa maelewano mabaya au tafsiri zisizo sahihi zinazotokana na matumizi ya tafsiri hii.