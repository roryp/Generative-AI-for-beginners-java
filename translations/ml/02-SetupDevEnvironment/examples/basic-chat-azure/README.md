# Azure OpenAI ഉപയോഗിച്ച് അടിസ്ഥാന ചാറ്റ് - എന്റു-ടു-എന്റ് ഉദാഹരണം

ഈ ഉദാഹരണം Azure OpenAI-യുമായി ബന്ധിപ്പിക്കുന്ന ഒരു ലളിതമായ Spring Boot ആപ്ലിക്കേഷൻ സൃഷ്ടിക്കുകയും നിങ്ങളുടെ സജ്ജീകരണം പരിശോധിക്കുകയും ചെയ്യുന്നതാണ്.

## ഉള്ളടക്ക പട്ടിക

- [ആവശ്യകതകൾ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [ദ്രുത തുടക്കം](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [കോൺഫിഗറേഷൻ ഓപ്ഷനുകൾ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [ഓപ്ഷൻ 1: പരിസ്ഥിതി ചോദ്യങ്ങൾ (.env ഫയൽ) - ശുപാർശ ചെയ്യുന്നു](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [ഓപ്ഷൻ 2: GitHub Codespace രഹസ്യങ്ങൾ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [ആപ്ലിക്കേഷൻ പ്രവർത്തിപ്പിക്കൽ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Maven ഉപയോഗിച്ച്](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [VS Code ഉപയോഗിച്ച്](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [പ്രതീക്ഷിക്കുന്ന ഔട്ട്പുട്ട്](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [കോൺഫിഗറേഷൻ റഫറൻസ്](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [പരിസ്ഥിതി ചോദ്യങ്ങൾ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Spring കോൺഫിഗറേഷൻ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [പ്രശ്നപരിഹാരം](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [സാധാരണ പ്രശ്നങ്ങൾ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [ഡീബഗ് മോഡ്](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [അടുത്ത ഘട്ടങ്ങൾ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [സ്രോതസുകൾ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## ആവശ്യകതകൾ

ഈ ഉദാഹരണം പ്രവർത്തിപ്പിക്കുന്നതിന് മുമ്പ്, നിങ്ങൾക്ക് താഴെ പറയുന്നവ ഉറപ്പാക്കണം:

- [Azure OpenAI സജ്ജീകരണ ഗൈഡ്](../../getting-started-azure-openai.md) പൂർത്തിയാക്കുക  
- Azure AI Foundry പോർട്ടൽ വഴി Azure OpenAI റിസോഴ്‌സ് വിന്യസിക്കുക  
- gpt-4o-mini മോഡൽ (അല്ലെങ്കിൽ മറ്റൊരു മോഡൽ) വിന്യസിക്കുക  
- Azure-ൽ നിന്ന് API കീയും എന്റ്പോയിന്റ് URL-യും ലഭിക്കുക  

## ദ്രുത തുടക്കം

```bash
# 1. പ്രോജക്റ്റിലേക്ക് നാവിഗേറ്റ് ചെയ്യുക
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. ക്രെഡൻഷ്യലുകൾ കോൺഫിഗർ ചെയ്യുക
cp .env.example .env
# നിങ്ങളുടെ Azure OpenAI ക്രെഡൻഷ്യലുകൾ ഉപയോഗിച്ച് .env എഡിറ്റ് ചെയ്യുക

# 3. ആപ്ലിക്കേഷൻ പ്രവർത്തിപ്പിക്കുക
mvn spring-boot:run
```

## കോൺഫിഗറേഷൻ ഓപ്ഷനുകൾ

### ഓപ്ഷൻ 1: പരിസ്ഥിതി ചോദ്യങ്ങൾ (.env ഫയൽ) - ശുപാർശ ചെയ്യുന്നു

**ചുവടെയുള്ള ഘട്ടം 1: നിങ്ങളുടെ കോൺഫിഗറേഷൻ ഫയൽ സൃഷ്ടിക്കുക**
```bash
cp .env.example .env
```

**ചുവടെയുള്ള ഘട്ടം 2: നിങ്ങളുടെ Azure OpenAI ക്രെഡൻഷ്യലുകൾ ചേർക്കുക**
```bash
# നിങ്ങളുടെ Azure OpenAI API കീ (Azure AI Foundry പോർട്ടലിൽ നിന്ന്)
AZURE_AI_KEY=your-actual-api-key-here

# നിങ്ങളുടെ Azure OpenAI എൻഡ്പോയിന്റ് URL (ഉദാ., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **സുരക്ഷാ കുറിപ്പ്**: 
> - നിങ്ങളുടെ `.env` ഫയൽ വേർഷൻ കൺട്രോളിലേക്ക് ഒരിക്കലും കമ്മിറ്റ് ചെയ്യരുത്
> - `.env` ഫയൽ ഇതിനകം `.gitignore`-ൽ ഉൾപ്പെടുത്തിയിട്ടുണ്ട്
> - നിങ്ങളുടെ API കീകൾ സുരക്ഷിതമായി സൂക്ഷിക്കുകയും അവയെ സ്ഥിരമായി മാറ്റുകയും ചെയ്യുക

### ഓപ്ഷൻ 2: GitHub Codespace രഹസ്യങ്ങൾ

GitHub Codespaces-ക്കായി, നിങ്ങളുടെ റിപോസിറ്ററിയിൽ ഈ രഹസ്യങ്ങൾ സജ്ജമാക്കുക:
- `AZURE_AI_KEY` - നിങ്ങളുടെ Azure OpenAI API കീ
- `AZURE_AI_ENDPOINT` - നിങ്ങളുടെ Azure OpenAI എന്റ്പോയിന്റ് URL

ആപ്ലിക്കേഷൻ ഈ രഹസ്യങ്ങൾ സ്വയം കണ്ടെത്തുകയും ഉപയോഗിക്കുകയും ചെയ്യുന്നു.

### പകരം: നേരിട്ട് പരിസ്ഥിതി ചോദ്യങ്ങൾ

<details>
<summary>പ്ലാറ്റ്ഫോം-സ്പെസിഫിക് കമാൻഡുകൾ കാണാൻ ക്ലിക്ക് ചെയ്യുക</summary>

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

## ആപ്ലിക്കേഷൻ പ്രവർത്തിപ്പിക്കൽ

### Maven ഉപയോഗിച്ച്

```bash
mvn spring-boot:run
```

### VS Code ഉപയോഗിച്ച്

1. പ്രോജക്റ്റ് VS Code-ൽ തുറക്കുക
2. `F5` അമർത്തുക അല്ലെങ്കിൽ "Run and Debug" പാനൽ ഉപയോഗിക്കുക
3. "Spring Boot-BasicChatApplication" കോൺഫിഗറേഷൻ തിരഞ്ഞെടുക്കുക

> **കുറിപ്പ്**: VS Code കോൺഫിഗറേഷൻ നിങ്ങളുടെ .env ഫയൽ സ്വയം ലോഡ് ചെയ്യുന്നു

### പ്രതീക്ഷിക്കുന്ന ഔട്ട്പുട്ട്

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

## കോൺഫിഗറേഷൻ റഫറൻസ്

### പരിസ്ഥിതി ചോദ്യങ്ങൾ

| ചോദ്യങ്ങൾ | വിവരണം | ആവശ്യമാണ് | ഉദാഹരണം |
|----------|-------------|----------|---------|
| `AZURE_AI_KEY` | Azure OpenAI API കീ | ആവശ്യമാണ് | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI എന്റ്പോയിന്റ് URL | ആവശ്യമാണ് | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | മോഡൽ വിന്യാസത്തിന്റെ പേര് | ആവശ്യമില്ല | `gpt-4o-mini` (ഡീഫോൾട്ട്) |

### Spring കോൺഫിഗറേഷൻ

`application.yml` ഫയൽ കോൺഫിഗർ ചെയ്യുന്നു:
- **API കീ**: `${AZURE_AI_KEY}` - പരിസ്ഥിതി ചോദ്യത്തിൽ നിന്ന്
- **എന്റ്പോയിന്റ്**: `${AZURE_AI_ENDPOINT}` - പരിസ്ഥിതി ചോദ്യത്തിൽ നിന്ന്  
- **മോഡൽ**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - പരിസ്ഥിതി ചോദ്യത്തിൽ നിന്ന് ഫാൾബാക്ക് ഉപയോഗിച്ച്
- **ടെംപറേച്ചർ**: `0.7` - സൃഷ്ടിപരത്വം നിയന്ത്രിക്കുന്നു (0.0 = നിർണായകമായത്, 1.0 = സൃഷ്ടിപരമായത്)
- **മാക്സ് ടോക്കൺസ്**: `500` - പരമാവധി പ്രതികരണ ദൈർഘ്യം

## പ്രശ്നപരിഹാരം

### സാധാരണ പ്രശ്നങ്ങൾ

<details>
<summary><strong>പിശക്: "API കീ സാധുവല്ല"</strong></summary>

- നിങ്ങളുടെ `.env` ഫയലിൽ `AZURE_AI_KEY` ശരിയായി സജ്ജീകരിച്ചിട്ടുണ്ടെന്ന് പരിശോധിക്കുക
- API കീ Azure AI Foundry പോർട്ടലിൽ നിന്ന് കൃത്യമായി പകർത്തിയിട്ടുണ്ടെന്ന് ഉറപ്പാക്കുക
- കീയുടെ ചുറ്റും അധിക സ്പേസുകൾ അല്ലെങ്കിൽ ക്വോട്ടുകൾ ഇല്ലെന്ന് ഉറപ്പാക്കുക
</details>

<details>
<summary><strong>പിശക്: "എന്റ്പോയിന്റ് സാധുവല്ല"</strong></summary>

- നിങ്ങളുടെ `AZURE_AI_ENDPOINT` പൂർണ്ണ URL ഉൾക്കൊള്ളുന്നുണ്ടെന്ന് ഉറപ്പാക്കുക (ഉദാ: `https://your-hub-name.openai.azure.com/`)
- ട്രെയിലിംഗ് സ്ലാഷ് സ്ഥിരത പരിശോധിക്കുക
- എന്റ്പോയിന്റ് നിങ്ങളുടെ Azure വിന്യാസ പ്രദേശവുമായി പൊരുത്തപ്പെടുന്നുണ്ടെന്ന് ഉറപ്പാക്കുക
</details>

<details>
<summary><strong>പിശക്: "വിന്യാസം കണ്ടെത്തിയില്ല"</strong></summary>

- നിങ്ങളുടെ മോഡൽ വിന്യാസത്തിന്റെ പേര് Azure-ൽ വിന്യസിച്ചിരിക്കുന്നതുമായി കൃത്യമായി പൊരുത്തപ്പെടുന്നുണ്ടെന്ന് ഉറപ്പാക്കുക
- മോഡൽ വിജയകരമായി വിന്യസിച്ചിട്ടുണ്ടെന്നും സജീവമാണെന്നും പരിശോധിക്കുക
- ഡീഫോൾട്ട് വിന്യാസത്തിന്റെ പേര് ഉപയോഗിക്കാൻ ശ്രമിക്കുക: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: പരിസ്ഥിതി ചോദ്യങ്ങൾ ലോഡുചെയ്യുന്നില്ല</strong></summary>

- നിങ്ങളുടെ `.env` ഫയൽ പ്രോജക്റ്റ് റൂട്ട് ഡയറക്ടറിയിൽ (പോം.xml-ന്റെ സമനിലയിൽ) ഉള്ളതായിരിക്കണം
- VS Code-ന്റെ ഇന്റഗ്രേറ്റഡ് ടെർമിനലിൽ `mvn spring-boot:run` പ്രവർത്തിപ്പിക്കാൻ ശ്രമിക്കുക
- VS Code Java എക്സ്റ്റൻഷൻ ശരിയായി ഇൻസ്റ്റാൾ ചെയ്തിട്ടുണ്ടെന്ന് ഉറപ്പാക്കുക
- ലോഞ്ച് കോൺഫിഗറേഷനിൽ `"envFile": "${workspaceFolder}/.env"` ഉള്ളതായിരിക്കണം
</details>

### ഡീബഗ് മോഡ്

വിശദമായ ലോഗിംഗ് സജ്ജമാക്കാൻ, `application.yml`-ൽ ഈ വരികൾ അൺകമ്മെന്റ് ചെയ്യുക:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## അടുത്ത ഘട്ടങ്ങൾ

**സജ്ജീകരണം പൂർത്തിയായി!** നിങ്ങളുടെ പഠന യാത്ര തുടരുക:

[അധ്യായം 3: കോർ ജനറേറ്റീവ് AI സാങ്കേതികവിദ്യകൾ](../../../03-CoreGenerativeAITechniques/README.md)

## സ്രോതസുകൾ

- [Spring AI Azure OpenAI ഡോക്യുമെന്റേഷൻ](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Azure OpenAI സർവീസ് ഡോക്യുമെന്റേഷൻ](https://learn.microsoft.com/azure/ai-services/openai/)
- [Azure AI Foundry പോർട്ടൽ](https://ai.azure.com/)
- [Azure AI Foundry ഡോക്യുമെന്റേഷൻ](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**അറിയിപ്പ്**:  
ഈ രേഖ AI വിവർത്തന സേവനം [Co-op Translator](https://github.com/Azure/co-op-translator) ഉപയോഗിച്ച് വിവർത്തനം ചെയ്തതാണ്. ഞങ്ങൾ കൃത്യതയ്ക്കായി ശ്രമിക്കുന്നുവെങ്കിലും, ഓട്ടോമേറ്റഡ് വിവർത്തനങ്ങളിൽ പിഴവുകൾ അല്ലെങ്കിൽ തെറ്റായ വിവരങ്ങൾ ഉണ്ടാകാൻ സാധ്യതയുണ്ട്. അതിന്റെ സ്വഭാവ ഭാഷയിലുള്ള അസൽ രേഖയാണ് പ്രാമാണികമായ ഉറവിടം എന്ന് പരിഗണിക്കണം. നിർണായകമായ വിവരങ്ങൾക്ക്, പ്രൊഫഷണൽ മനുഷ്യ വിവർത്തനം ശുപാർശ ചെയ്യുന്നു. ഈ വിവർത്തനം ഉപയോഗിച്ച് ഉണ്ടാകുന്ന തെറ്റിദ്ധാരണകൾ അല്ലെങ്കിൽ തെറ്റായ വ്യാഖ്യാനങ്ങൾക്കായി ഞങ്ങൾ ഉത്തരവാദികളല്ല.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->