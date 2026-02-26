# Azure OpenAI உடன் அடிப்படை உரையாடல் - முழுமையான எடுத்துக்காட்டு

இந்த எடுத்துக்காட்டில் Azure OpenAI-க்கு இணைக்கும் ஒரு எளிய Spring Boot பயன்பாட்டை உருவாக்குவது மற்றும் உங்கள் அமைப்பை சோதிப்பது எப்படி என்பதை விளக்குகிறது.

## உள்ளடக்க அட்டவணை

- [முன்னோட்டம்](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [விரைவான தொடக்கம்](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [கட்டமைப்பு விருப்பங்கள்](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [விருப்பம் 1: சூழல் மாறிகள் (.env கோப்பு) - பரிந்துரைக்கப்படுகிறது](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [விருப்பம் 2: GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [பயன்பாட்டை இயக்குதல்](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Maven பயன்படுத்துதல்](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [VS Code பயன்படுத்துதல்](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [எதிர்பார்க்கப்படும் வெளியீடு](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [கட்டமைப்பு குறிப்புகள்](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [சூழல் மாறிகள்](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Spring கட்டமைப்பு](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [சிக்கல்களை தீர்க்க](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [பொதுவான பிரச்சினைகள்](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Debug Mode](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [அடுத்த படிகள்](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [வளங்கள்](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## முன்னோட்டம்

இந்த எடுத்துக்காட்டை இயக்குவதற்கு முன், நீங்கள் பின்வருவனவை உறுதிப்படுத்த வேண்டும்:

- [Azure OpenAI அமைப்பு வழிகாட்டி](../../getting-started-azure-openai.md) முடித்திருக்க வேண்டும்  
- Azure AI Foundry போர்டல் மூலம் Azure OpenAI வளத்தை பிரசுரித்திருக்க வேண்டும்  
- gpt-4o-mini மாடலை (அல்லது மாற்று மாடல்) பிரசுரித்திருக்க வேண்டும்  
- Azure-இல் இருந்து API விசை மற்றும் இறுதிப்புள்ளி URL பெற வேண்டும்  

## விரைவான தொடக்கம்

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## கட்டமைப்பு விருப்பங்கள்

### விருப்பம் 1: சூழல் மாறிகள் (.env கோப்பு) - பரிந்துரைக்கப்படுகிறது

**படி 1: உங்கள் கட்டமைப்பு கோப்பை உருவாக்கவும்**
```bash
cp .env.example .env
```

**படி 2: உங்கள் Azure OpenAI சான்றுகளை சேர்க்கவும்**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **பாதுகாப்பு குறிப்பு**: 
> - உங்கள் `.env` கோப்பை version control-க்கு commit செய்ய வேண்டாம்
> - `.env` கோப்பு `.gitignore`-இல் ஏற்கனவே உள்ளது
> - உங்கள் API விசைகளை பாதுகாப்பாக வைத்திருக்கவும் மற்றும் அவற்றை அடிக்கடி மாற்றவும்

### விருப்பம் 2: GitHub Codespace Secrets

GitHub Codespaces-க்கு, உங்கள் repository-யில் இந்த ரகசியங்களை அமைக்கவும்:
- `AZURE_AI_KEY` - உங்கள் Azure OpenAI API விசை
- `AZURE_AI_ENDPOINT` - உங்கள் Azure OpenAI இறுதிப்புள்ளி URL

பயன்பாடு இந்த ரகசியங்களை தானாகவே கண்டறிந்து பயன்படுத்துகிறது.

### மாற்று: நேரடி சூழல் மாறிகள்

<details>
<summary>கட்டமைப்புக்கான தள-குறிப்பான கட்டளைகளை காண கிளிக் செய்யவும்</summary>

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

## பயன்பாட்டை இயக்குதல்

### Maven பயன்படுத்துதல்

```bash
mvn spring-boot:run
```

### VS Code பயன்படுத்துதல்

1. திட்டத்தை VS Code-இல் திறக்கவும்
2. `F5` அழுத்தவும் அல்லது "Run and Debug" குழுவைப் பயன்படுத்தவும்
3. "Spring Boot-BasicChatApplication" கட்டமைப்பைத் தேர்ந்தெடுக்கவும்

> **குறிப்பு**: VS Code கட்டமைப்பு உங்கள் .env கோப்பை தானாகவே ஏற்றுகிறது

### எதிர்பார்க்கப்படும் வெளியீடு

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

## கட்டமைப்பு குறிப்புகள்

### சூழல் மாறிகள்

| மாறி | விளக்கம் | தேவை | உதாரணம் |
|------|----------|-------|---------|
| `AZURE_AI_KEY` | Azure OpenAI API விசை | ஆம் | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI இறுதிப்புள்ளி URL | ஆம் | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | மாடல் பிரசுரத்தின் பெயர் | இல்லை | `gpt-4o-mini` (இயல்புநிலை) |

### Spring கட்டமைப்பு

`application.yml` கோப்பு பின்வருவனவற்றை கட்டமைக்கிறது:
- **API விசை**: `${AZURE_AI_KEY}` - சூழல் மாறியிலிருந்து
- **இறுதிப்புள்ளி**: `${AZURE_AI_ENDPOINT}` - சூழல் மாறியிலிருந்து  
- **மாடல்**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - சூழல் மாறியிலிருந்து fallback உடன்
- **Temperature**: `0.7` - படைப்பாற்றலை கட்டுப்படுத்துகிறது (0.0 = நிர்ணயிக்கப்பட்டது, 1.0 = படைப்பாற்றல்)
- **Max Tokens**: `500` - அதிகபட்ச பதில் நீளம்

## சிக்கல்களை தீர்க்க

### பொதுவான பிரச்சினைகள்

<details>
<summary><strong>பிழை: "API விசை செல்லுபடியாகவில்லை"</strong></summary>

- உங்கள் `AZURE_AI_KEY` உங்கள் `.env` கோப்பில் சரியாக அமைக்கப்பட்டுள்ளதா என்பதை சரிபார்க்கவும்
- API விசை Azure AI Foundry போர்டலிலிருந்து துல்லியமாக நகலெடுக்கப்பட்டுள்ளதா என்பதை உறுதிப்படுத்தவும்
- விசையின் சுற்றிலும் கூடுதல் இடங்கள் அல்லது மேற்கோள்கள் இல்லாததா என்பதை உறுதிப்படுத்தவும்
</details>

<details>
<summary><strong>பிழை: "இறுதிப்புள்ளி செல்லுபடியாகவில்லை"</strong></summary>

- உங்கள் `AZURE_AI_ENDPOINT` முழு URL-ஐ (எ.கா., `https://your-hub-name.openai.azure.com/`) உள்ளடக்கியதா என்பதை உறுதிப்படுத்தவும்
- இறுதியில் சலாஷ் (slash) சீர்மறை இருப்பதை சரிபார்க்கவும்
- Azure பிரசுரத்தின் பகுதி உங்கள் இறுதிப்புள்ளியுடன் பொருந்துகிறதா என்பதை உறுதிப்படுத்தவும்
</details>

<details>
<summary><strong>பிழை: "பிரசுரம் காணப்படவில்லை"</strong></summary>

- உங்கள் மாடல் பிரசுரத்தின் பெயர் Azure-இல் பிரசுரிக்கப்பட்டதுடன் துல்லியமாக பொருந்துகிறதா என்பதை உறுதிப்படுத்தவும்
- மாடல் வெற்றிகரமாக பிரசுரிக்கப்பட்டு செயல்படுகிறதா என்பதை சரிபார்க்கவும்
- இயல்புநிலை பிரசுரத்தின் பெயரை முயற்சிக்கவும்: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: சூழல் மாறிகள் ஏற்றப்படவில்லை</strong></summary>

- உங்கள் `.env` கோப்பு திட்டத்தின் root அடைவில் (அதே நிலை `pom.xml` உடன்) உள்ளதா என்பதை உறுதிப்படுத்தவும்
- VS Code-இன் ஒருங்கிணைந்த terminal-இல் `mvn spring-boot:run` இயக்க முயற்சிக்கவும்
- VS Code Java நீட்டிப்பு சரியாக நிறுவப்பட்டதா என்பதை சரிபார்க்கவும்
- Launch configuration-ல் `"envFile": "${workspaceFolder}/.env"` உள்ளதா என்பதை உறுதிப்படுத்தவும்
</details>

### Debug Mode

விரிவான பதிவு செய்ய, `application.yml`-இல் இந்த வரிகளை uncomment செய்யவும்:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## அடுத்த படிகள்

**அமைப்பு முடிந்தது!** உங்கள் கற்றல் பயணத்தை தொடரவும்:

[அத்தியாயம் 3: முக்கிய Generative AI தொழில்நுட்பங்கள்](../../../03-CoreGenerativeAITechniques/README.md)

## வளங்கள்

- [Spring AI Azure OpenAI ஆவணங்கள்](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Azure OpenAI சேவை ஆவணங்கள்](https://learn.microsoft.com/azure/ai-services/openai/)
- [Azure AI Foundry போர்டல்](https://ai.azure.com/)
- [Azure AI Foundry ஆவணங்கள்](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

---

**குறிப்பு**:  
இந்த ஆவணம் [Co-op Translator](https://github.com/Azure/co-op-translator) என்ற AI மொழிபெயர்ப்பு சேவையைப் பயன்படுத்தி மொழிபெயர்க்கப்பட்டுள்ளது. நாங்கள் துல்லியத்திற்காக முயற்சிக்கின்றோம், ஆனால் தானியங்கி மொழிபெயர்ப்புகளில் பிழைகள் அல்லது தவறான தகவல்கள் இருக்கக்கூடும் என்பதை தயவுசெய்து கவனத்தில் கொள்ளுங்கள். அதன் தாய்மொழியில் உள்ள மூல ஆவணம் அதிகாரப்பூர்வ ஆதாரமாக கருதப்பட வேண்டும். முக்கியமான தகவல்களுக்கு, தொழில்முறை மனித மொழிபெயர்ப்பு பரிந்துரைக்கப்படுகிறது. இந்த மொழிபெயர்ப்பைப் பயன்படுத்துவதால் ஏற்படும் எந்த தவறான புரிதல்கள் அல்லது தவறான விளக்கங்களுக்கு நாங்கள் பொறுப்பல்ல.