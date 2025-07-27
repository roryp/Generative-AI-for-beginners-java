<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "efd82efe50711d7e257eb943151d682c",
  "translation_date": "2025-07-27T13:38:09+00:00",
  "source_file": "02-SetupDevEnvironment/examples/basic-chat-azure/README.md",
  "language_code": "mr"
}
-->
# Azure OpenAI सह बेसिक चॅट - एंड-टू-एंड उदाहरण

हे उदाहरण Azure OpenAI शी कनेक्ट होणारे एक साधे Spring Boot अॅप्लिकेशन कसे तयार करायचे आणि तुमची सेटअप कशी तपासायची हे दाखवते.

## विषय सूची

- [पूर्वअट](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [जलद प्रारंभ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [कॉन्फिगरेशन पर्याय](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [पर्याय 1: पर्यावरणीय व्हेरिएबल्स (.env फाइल) - शिफारस केलेले](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [पर्याय 2: GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [अॅप्लिकेशन चालवणे](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Maven वापरून](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [VS Code वापरून](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [अपेक्षित आउटपुट](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [कॉन्फिगरेशन संदर्भ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [पर्यावरणीय व्हेरिएबल्स](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Spring कॉन्फिगरेशन](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [समस्या निवारण](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [सामान्य समस्या](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [डिबग मोड](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [पुढील पावले](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [स्रोत](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## पूर्वअट

हे उदाहरण चालवण्यापूर्वी, खात्री करा की तुम्ही खालील गोष्टी पूर्ण केल्या आहेत:

- [Azure OpenAI सेटअप मार्गदर्शक](../../getting-started-azure-openai.md) पूर्ण केला आहे  
- Azure AI Foundry पोर्टलद्वारे Azure OpenAI संसाधन तैनात केले आहे  
- gpt-4o-mini मॉडेल (किंवा पर्याय) तैनात केले आहे  
- Azure कडून API की आणि एंडपॉइंट URL प्राप्त केला आहे  

## जलद प्रारंभ

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## कॉन्फिगरेशन पर्याय

### पर्याय 1: पर्यावरणीय व्हेरिएबल्स (.env फाइल) - शिफारस केलेले

**पायरी 1: तुमची कॉन्फिगरेशन फाइल तयार करा**  
```bash
cp .env.example .env
```

**पायरी 2: तुमचे Azure OpenAI क्रेडेन्शियल्स जोडा**  
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **सुरक्षा टीप**:  
> - तुमची `.env` फाइल कधीही व्हर्जन कंट्रोलमध्ये कमिट करू नका  
> - `.env` फाइल आधीच `.gitignore` मध्ये समाविष्ट आहे  
> - तुमच्या API कीज सुरक्षित ठेवा आणि त्यांचे नियमितपणे रोटेशन करा  

### पर्याय 2: GitHub Codespace Secrets

GitHub Codespaces साठी, तुमच्या रेपॉझिटरीमध्ये खालील Secrets सेट करा:  
- `AZURE_AI_KEY` - तुमची Azure OpenAI API की  
- `AZURE_AI_ENDPOINT` - तुमचा Azure OpenAI एंडपॉइंट URL  

अॅप्लिकेशन आपोआप हे Secrets शोधते आणि वापरते.

### पर्याय: थेट पर्यावरणीय व्हेरिएबल्स

<details>
<summary>प्लॅटफॉर्म-विशिष्ट कमांड्स पाहण्यासाठी क्लिक करा</summary>

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

## अॅप्लिकेशन चालवणे

### Maven वापरून

```bash
mvn spring-boot:run
```

### VS Code वापरून

1. प्रकल्प VS Code मध्ये उघडा  
2. `F5` दाबा किंवा "Run and Debug" पॅनेल वापरा  
3. "Spring Boot-BasicChatApplication" कॉन्फिगरेशन निवडा  

> **टीप**: VS Code कॉन्फिगरेशन आपोआप तुमची `.env` फाइल लोड करते  

### अपेक्षित आउटपुट

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

## कॉन्फिगरेशन संदर्भ

### पर्यावरणीय व्हेरिएबल्स

| व्हेरिएबल | वर्णन | आवश्यक | उदाहरण |
|-----------|--------|---------|---------|
| `AZURE_AI_KEY` | Azure OpenAI API की | होय | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI एंडपॉइंट URL | होय | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | मॉडेल तैनातीचे नाव | नाही | `gpt-4o-mini` (डिफॉल्ट) |

### Spring कॉन्फिगरेशन

`application.yml` फाइलमध्ये खालील गोष्टी कॉन्फिगर केल्या जातात:  
- **API की**: `${AZURE_AI_KEY}` - पर्यावरणीय व्हेरिएबलमधून  
- **एंडपॉइंट**: `${AZURE_AI_ENDPOINT}` - पर्यावरणीय व्हेरिएबलमधून  
- **मॉडेल**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - पर्यावरणीय व्हेरिएबलमधून किंवा डिफॉल्ट  
- **टेम्परेचर**: `0.7` - सर्जनशीलता नियंत्रित करते (0.0 = निश्चित, 1.0 = सर्जनशील)  
- **कमाल टोकन्स**: `500` - प्रतिसादाची जास्तीत जास्त लांबी  

## समस्या निवारण

### सामान्य समस्या

<details>
<summary><strong>त्रुटी: "API की वैध नाही"</strong></summary>

- तुमची `AZURE_AI_KEY` `.env` फाइलमध्ये योग्यरित्या सेट केली आहे का ते तपासा  
- Azure AI Foundry पोर्टलमधून API की अचूक कॉपी केली आहे का ते सत्यापित करा  
- कीभोवती अतिरिक्त स्पेस किंवा कोट्स नाहीत याची खात्री करा  
</details>

<details>
<summary><strong>त्रुटी: "एंडपॉइंट वैध नाही"</strong></summary>

- तुमचा `AZURE_AI_ENDPOINT` पूर्ण URL समाविष्ट करतो का ते तपासा (उदा., `https://your-hub-name.openai.azure.com/`)  
- शेवटच्या स्लॅशची सुसंगतता तपासा  
- एंडपॉइंट तुमच्या Azure तैनाती प्रदेशाशी जुळतो का ते सत्यापित करा  
</details>

<details>
<summary><strong>त्रुटी: "तैनाती सापडली नाही"</strong></summary>

- तुमचे मॉडेल तैनातीचे नाव Azure मध्ये तैनात केलेल्या नावाशी अचूक जुळते का ते तपासा  
- मॉडेल यशस्वीरित्या तैनात आणि सक्रिय आहे का ते तपासा  
- डिफॉल्ट तैनातीचे नाव वापरून पहा: `gpt-4o-mini`  
</details>

<details>
<summary><strong>VS Code: पर्यावरणीय व्हेरिएबल्स लोड होत नाहीत</strong></summary>

- तुमची `.env` फाइल प्रकल्पाच्या मूळ डिरेक्टरीमध्ये आहे का (जिथे `pom.xml` आहे) ते तपासा  
- VS Code च्या इंटिग्रेटेड टर्मिनलमध्ये `mvn spring-boot:run` चालवून पहा  
- VS Code Java एक्स्टेंशन योग्यरित्या स्थापित आहे का ते तपासा  
- लॉन्च कॉन्फिगरेशनमध्ये `"envFile": "${workspaceFolder}/.env"` आहे का ते सत्यापित करा  
</details>

### डिबग मोड

तपशीलवार लॉगिंग सक्षम करण्यासाठी, `application.yml` मधील या ओळी अनकॉमेंट करा:  

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## पुढील पावले

**सेटअप पूर्ण!** तुमच्या शिकण्याच्या प्रवासाला पुढे सुरू ठेवा:  

[Chapter 3: Core Generative AI Techniques](../../../03-CoreGenerativeAITechniques/README.md)

## स्रोत

- [Spring AI Azure OpenAI दस्तऐवज](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)  
- [Azure OpenAI सेवा दस्तऐवज](https://learn.microsoft.com/azure/ai-services/openai/)  
- [Azure AI Foundry पोर्टल](https://ai.azure.com/)  
- [Azure AI Foundry दस्तऐवज](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)  

**अस्वीकरण**:  
हा दस्तऐवज AI भाषांतर सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) वापरून भाषांतरित करण्यात आला आहे. आम्ही अचूकतेसाठी प्रयत्नशील असलो तरी, कृपया लक्षात ठेवा की स्वयंचलित भाषांतरे त्रुटी किंवा अचूकतेच्या अभावाने युक्त असू शकतात. मूळ भाषेतील दस्तऐवज हा अधिकृत स्रोत मानला जावा. महत्त्वाच्या माहितीसाठी, व्यावसायिक मानवी भाषांतराची शिफारस केली जाते. या भाषांतराचा वापर करून उद्भवलेल्या कोणत्याही गैरसमज किंवा चुकीच्या अर्थासाठी आम्ही जबाबदार नाही.