<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2289320a74aeca1eb844cd7d3a7a9e12",
  "translation_date": "2025-07-21T16:29:57+00:00",
  "source_file": "02-SetupDevEnvironment/src/basic-chat-azure/README.md",
  "language_code": "hi"
}
-->
# Azure OpenAI के साथ बेसिक चैट - एंड-टू-एंड उदाहरण

यह उदाहरण दिखाता है कि कैसे एक साधारण Spring Boot एप्लिकेशन बनाया जाए, जो Azure OpenAI से कनेक्ट हो और आपकी सेटअप को टेस्ट करे।

## सामग्री तालिका

- [पूर्वापेक्षाएँ](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [त्वरित शुरुआत](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [कॉन्फ़िगरेशन विकल्प](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [विकल्प 1: एनवायरनमेंट वेरिएबल्स (.env फ़ाइल) - अनुशंसित](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [विकल्प 2: GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [एप्लिकेशन चलाना](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Maven का उपयोग करना](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [VS Code का उपयोग करना](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [अपेक्षित आउटपुट](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [कॉन्फ़िगरेशन संदर्भ](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [एनवायरनमेंट वेरिएबल्स](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Spring कॉन्फ़िगरेशन](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [समस्या निवारण](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [सामान्य समस्याएँ](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [डिबग मोड](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [अगले कदम](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [संसाधन](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)

## पूर्वापेक्षाएँ

इस उदाहरण को चलाने से पहले सुनिश्चित करें कि आपने:

- [Azure OpenAI सेटअप गाइड](../../getting-started-azure-openai.md) पूरा कर लिया है  
- Azure AI Foundry पोर्टल के माध्यम से Azure OpenAI संसाधन डिप्लॉय कर लिया है  
- gpt-4o-mini मॉडल (या वैकल्पिक) डिप्लॉय कर लिया है  
- Azure से API कुंजी और एंडपॉइंट URL प्राप्त कर लिया है  

## त्वरित शुरुआत

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/src/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## कॉन्फ़िगरेशन विकल्प

### विकल्प 1: एनवायरनमेंट वेरिएबल्स (.env फ़ाइल) - अनुशंसित

**चरण 1: अपनी कॉन्फ़िगरेशन फ़ाइल बनाएं**  
```bash
cp .env.example .env
```

**चरण 2: अपनी Azure OpenAI क्रेडेंशियल्स जोड़ें**  
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **सुरक्षा नोट**: 
> - कभी भी अपनी `.env` फ़ाइल को वर्जन कंट्रोल में कमिट न करें  
> - `.env` फ़ाइल पहले से ही `.gitignore` में शामिल है  
> - अपनी API कुंजियों को सुरक्षित रखें और नियमित रूप से उन्हें बदलें  

### विकल्प 2: GitHub Codespace Secrets

GitHub Codespaces के लिए, अपने रिपॉजिटरी में ये सीक्रेट्स सेट करें:
- `AZURE_AI_KEY` - आपकी Azure OpenAI API कुंजी
- `AZURE_AI_ENDPOINT` - आपका Azure OpenAI एंडपॉइंट URL

एप्लिकेशन स्वचालित रूप से इन सीक्रेट्स का पता लगाता है और उपयोग करता है।

### वैकल्पिक: डायरेक्ट एनवायरनमेंट वेरिएबल्स

<details>
<summary>प्लेटफ़ॉर्म-विशिष्ट कमांड देखने के लिए क्लिक करें</summary>

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

## एप्लिकेशन चलाना

### Maven का उपयोग करना

```bash
mvn spring-boot:run
```

### VS Code का उपयोग करना

1. प्रोजेक्ट को VS Code में खोलें  
2. `F5` दबाएँ या "Run and Debug" पैनल का उपयोग करें  
3. "Spring Boot-BasicChatApplication" कॉन्फ़िगरेशन चुनें  

> **नोट**: VS Code कॉन्फ़िगरेशन स्वचालित रूप से आपकी .env फ़ाइल को लोड करता है  

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

## कॉन्फ़िगरेशन संदर्भ

### एनवायरनमेंट वेरिएबल्स

| वेरिएबल | विवरण | आवश्यक | उदाहरण |
|----------|-------------|----------|---------|
| `AZURE_AI_KEY` | Azure OpenAI API कुंजी | हाँ | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI एंडपॉइंट URL | हाँ | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | मॉडल डिप्लॉयमेंट का नाम | नहीं | `gpt-4o-mini` (डिफ़ॉल्ट) |

### Spring कॉन्फ़िगरेशन

`application.yml` फ़ाइल में निम्नलिखित कॉन्फ़िगर किया गया है:
- **API कुंजी**: `${AZURE_AI_KEY}` - एनवायरनमेंट वेरिएबल से  
- **एंडपॉइंट**: `${AZURE_AI_ENDPOINT}` - एनवायरनमेंट वेरिएबल से  
- **मॉडल**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - एनवायरनमेंट वेरिएबल से या डिफ़ॉल्ट  
- **टेम्परेचर**: `0.7` - क्रिएटिविटी को नियंत्रित करता है (0.0 = निश्चित, 1.0 = रचनात्मक)  
- **मैक्स टोकन्स**: `500` - अधिकतम प्रतिक्रिया लंबाई  

## समस्या निवारण

### सामान्य समस्याएँ

<details>
<summary><strong>त्रुटि: "API कुंजी मान्य नहीं है"</strong></summary>

- सुनिश्चित करें कि आपकी `AZURE_AI_KEY` आपकी `.env` फ़ाइल में सही सेट है  
- API कुंजी को Azure AI Foundry पोर्टल से ठीक से कॉपी करें  
- कुंजी के चारों ओर कोई अतिरिक्त स्पेस या कोट्स न हों  
</details>

<details>
<summary><strong>त्रुटि: "एंडपॉइंट मान्य नहीं है"</strong></summary>

- सुनिश्चित करें कि आपका `AZURE_AI_ENDPOINT` पूरा URL शामिल करता है (जैसे, `https://your-hub-name.openai.azure.com/`)  
- ट्रेलिंग स्लैश की संगति की जाँच करें  
- सुनिश्चित करें कि एंडपॉइंट आपके Azure डिप्लॉयमेंट क्षेत्र से मेल खाता है  
</details>

<details>
<summary><strong>त्रुटि: "डिप्लॉयमेंट नहीं मिला"</strong></summary>

- सुनिश्चित करें कि आपका मॉडल डिप्लॉयमेंट नाम Azure में डिप्लॉय किए गए नाम से मेल खाता है  
- जाँचें कि मॉडल सफलतापूर्वक डिप्लॉय और सक्रिय है  
- डिफ़ॉल्ट डिप्लॉयमेंट नाम का उपयोग करने का प्रयास करें: `gpt-4o-mini`  
</details>

<details>
<summary><strong>VS Code: एनवायरनमेंट वेरिएबल्स लोड नहीं हो रहे</strong></summary>

- सुनिश्चित करें कि आपकी `.env` फ़ाइल प्रोजेक्ट रूट डायरेक्टरी (उसी स्तर पर जहां `pom.xml` है) में है  
- VS Code के इंटीग्रेटेड टर्मिनल में `mvn spring-boot:run` चलाने का प्रयास करें  
- सुनिश्चित करें कि VS Code Java एक्सटेंशन सही तरीके से इंस्टॉल है  
- वेरिफाई करें कि लॉन्च कॉन्फ़िगरेशन में `"envFile": "${workspaceFolder}/.env"` है  
</details>

### डिबग मोड

विस्तृत लॉगिंग सक्षम करने के लिए, `application.yml` में इन लाइनों को अनकमेंट करें:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## अगले कदम

**सेटअप पूरा!** अपनी लर्निंग यात्रा जारी रखें:

[अध्याय 3: कोर जनरेटिव AI तकनीकें](../../../03-CoreGenerativeAITechniques/README.md)

## संसाधन

- [Spring AI Azure OpenAI डाक्यूमेंटेशन](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)  
- [Azure OpenAI सेवा डाक्यूमेंटेशन](https://learn.microsoft.com/azure/ai-services/openai/)  
- [Azure AI Foundry पोर्टल](https://ai.azure.com/)  
- [Azure AI Foundry डाक्यूमेंटेशन](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)  

**अस्वीकरण**:  
यह दस्तावेज़ AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) का उपयोग करके अनुवादित किया गया है। जबकि हम सटीकता सुनिश्चित करने का प्रयास करते हैं, कृपया ध्यान दें कि स्वचालित अनुवाद में त्रुटियां या अशुद्धियां हो सकती हैं। मूल भाषा में उपलब्ध मूल दस्तावेज़ को प्रामाणिक स्रोत माना जाना चाहिए। महत्वपूर्ण जानकारी के लिए, पेशेवर मानव अनुवाद की सिफारिश की जाती है। इस अनुवाद के उपयोग से उत्पन्न किसी भी गलतफहमी या गलत व्याख्या के लिए हम उत्तरदायी नहीं हैं।