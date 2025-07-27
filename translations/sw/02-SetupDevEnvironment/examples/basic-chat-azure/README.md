<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "efd82efe50711d7e257eb943151d682c",
  "translation_date": "2025-07-27T13:45:27+00:00",
  "source_file": "02-SetupDevEnvironment/examples/basic-chat-azure/README.md",
  "language_code": "sw"
}
-->
# Mazungumzo ya Msingi na Azure OpenAI - Mfano wa Mwisho kwa Mwisho

Mfano huu unaonyesha jinsi ya kuunda programu rahisi ya Spring Boot inayounganisha na Azure OpenAI na kujaribu usanidi wako.

## Jedwali la Yaliyomo

- [Mahitaji ya Awali](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Kuanza Haraka](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Chaguo za Usanidi](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Chaguo 1: Vigezo vya Mazingira (Faili ya .env) - Inapendekezwa](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Chaguo 2: Siri za GitHub Codespace](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Kuendesha Programu](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Kutumia Maven](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Kutumia VS Code](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Matokeo Yanayotarajiwa](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Marejeleo ya Usanidi](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Vigezo vya Mazingira](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Usanidi wa Spring](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Kutatua Matatizo](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Masuala ya Kawaida](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Hali ya Urekebishaji](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Hatua Zifuatazo](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Rasilimali](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## Mahitaji ya Awali

Kabla ya kuendesha mfano huu, hakikisha una:

- Umekamilisha [mwongozo wa usanidi wa Azure OpenAI](../../getting-started-azure-openai.md)  
- Umeweka rasilimali ya Azure OpenAI (kupitia portal ya Azure AI Foundry)  
- Umeweka mfano wa gpt-4o-mini (au mbadala)  
- Umepewa funguo za API na URL ya mwisho kutoka Azure  

## Kuanza Haraka

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Chaguo za Usanidi

### Chaguo 1: Vigezo vya Mazingira (Faili ya .env) - Inapendekezwa

**Hatua ya 1: Unda faili yako ya usanidi**
```bash
cp .env.example .env
```

**Hatua ya 2: Ongeza maelezo yako ya Azure OpenAI**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Kumbuka Kuhusu Usalama**: 
> - Kamwe usiweke faili yako ya `.env` kwenye udhibiti wa toleo
> - Faili ya `.env` tayari imejumuishwa kwenye `.gitignore`
> - Linda funguo zako za API na uzibadilishe mara kwa mara

### Chaguo 2: Siri za GitHub Codespace

Kwa GitHub Codespaces, weka siri hizi kwenye hifadhi yako:
- `AZURE_AI_KEY` - Funguo yako ya API ya Azure OpenAI
- `AZURE_AI_ENDPOINT` - URL ya mwisho ya Azure OpenAI

Programu inatambua na kutumia siri hizi moja kwa moja.

### Mbadala: Vigezo vya Mazingira Moja kwa Moja

<details>
<summary>Bofya kuona amri maalum za jukwaa</summary>

**Linux/macOS (bash/zsh):**
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (Command Prompt):**
```cmd
set AZURE_AI_KEY=your-actual-api-key-here
set AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (PowerShell):**
```powershell
$env:AZURE_AI_KEY="your-actual-api-key-here"
$env:AZURE_AI_ENDPOINT="https://your-hub-name.openai.azure.com/"
```
</details>

## Kuendesha Programu

### Kutumia Maven

```bash
mvn spring-boot:run
```

### Kutumia VS Code

1. Fungua mradi kwenye VS Code
2. Bonyeza `F5` au tumia paneli ya "Run and Debug"
3. Chagua usanidi wa "Spring Boot-BasicChatApplication"

> **Kumbuka**: Usanidi wa VS Code unapakua faili yako ya .env moja kwa moja

### Matokeo Yanayotarajiwa

```
Starting Basic Chat with Azure OpenAI...
Environment variables loaded successfully
Connecting to Azure OpenAI...
Sending prompt: What is AI in a short sentence? Max 100 words.

AI Response:
================
AI, or Artificial Intelligence, is the simulation of human intelligence in machines programmed to think and learn like humans.
================

Success! Azure OpenAI connection is working correctly.
```

## Marejeleo ya Usanidi

### Vigezo vya Mazingira

| Kigezo | Maelezo | Inahitajika | Mfano |
|--------|---------|-------------|-------|
| `AZURE_AI_KEY` | Funguo ya API ya Azure OpenAI | Ndio | `abc123...` |
| `AZURE_AI_ENDPOINT` | URL ya mwisho ya Azure OpenAI | Ndio | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Jina la mfano uliowekwa | Hapana | `gpt-4o-mini` (chaguo-msingi) |

### Usanidi wa Spring

Faili ya `application.yml` inasanidi:
- **Funguo ya API**: `${AZURE_AI_KEY}` - Kutoka kwa kigezo cha mazingira
- **URL ya mwisho**: `${AZURE_AI_ENDPOINT}` - Kutoka kwa kigezo cha mazingira  
- **Mfano**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Kutoka kwa kigezo cha mazingira na chaguo-msingi
- **Joto**: `0.7` - Hudhibiti ubunifu (0.0 = hakika, 1.0 = ubunifu)
- **Idadi ya Juu ya Tokeni**: `500` - Urefu wa majibu ya juu zaidi

## Kutatua Matatizo

### Masuala ya Kawaida

<details>
<summary><strong>Kosa: "Funguo ya API si sahihi"</strong></summary>

- Hakikisha `AZURE_AI_KEY` yako imewekwa kwa usahihi kwenye faili yako ya `.env`
- Thibitisha funguo ya API imekopiwa kama ilivyo kutoka portal ya Azure AI Foundry
- Hakikisha hakuna nafasi za ziada au nukuu karibu na funguo
</details>

<details>
<summary><strong>Kosa: "URL ya mwisho si sahihi"</strong></summary>

- Hakikisha `AZURE_AI_ENDPOINT` yako inajumuisha URL kamili (mfano, `https://your-hub-name.openai.azure.com/`)
- Angalia uthabiti wa alama ya mwisho ya slash
- Thibitisha URL ya mwisho inalingana na eneo la usanidi wa Azure
</details>

<details>
<summary><strong>Kosa: "Mfano haukupatikana"</strong></summary>

- Thibitisha jina la mfano uliowekwa linalingana kabisa na lililowekwa kwenye Azure
- Angalia kuwa mfano umewekwa kwa mafanikio na uko hai
- Jaribu kutumia jina la mfano chaguo-msingi: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: Vigezo vya mazingira havipakui</strong></summary>

- Hakikisha faili yako ya `.env` iko kwenye saraka ya mizizi ya mradi (ngazi sawa na `pom.xml`)
- Jaribu kuendesha `mvn spring-boot:run` kwenye terminal iliyojumuishwa ya VS Code
- Angalia kuwa kiendelezi cha Java cha VS Code kimewekwa vizuri
- Thibitisha usanidi wa uzinduzi una `"envFile": "${workspaceFolder}/.env"`
</details>

### Hali ya Urekebishaji

Ili kuwezesha ufuatiliaji wa kina, toa maoni kwenye mistari hii katika `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Hatua Zifuatazo

**Usanidi Umekamilika!** Endelea na safari yako ya kujifunza:

[Sehemu ya 3: Mbinu za Msingi za AI ya Kizazi](../../../03-CoreGenerativeAITechniques/README.md)

## Rasilimali

- [Nyaraka za Spring AI Azure OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Nyaraka za Huduma ya Azure OpenAI](https://learn.microsoft.com/azure/ai-services/openai/)
- [Portal ya Azure AI Foundry](https://ai.azure.com/)
- [Nyaraka za Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**Kanusho**:  
Hati hii imetafsiriwa kwa kutumia huduma ya kutafsiri ya AI [Co-op Translator](https://github.com/Azure/co-op-translator). Ingawa tunajitahidi kuhakikisha usahihi, tafadhali fahamu kuwa tafsiri za kiotomatiki zinaweza kuwa na makosa au kutokuwa sahihi. Hati ya asili katika lugha yake ya awali inapaswa kuzingatiwa kama chanzo cha mamlaka. Kwa taarifa muhimu, tafsiri ya kitaalamu ya binadamu inapendekezwa. Hatutawajibika kwa kutoelewana au tafsiri zisizo sahihi zinazotokana na matumizi ya tafsiri hii.