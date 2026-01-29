# Azure OpenAI सँग आधारभूत च्याट - अन्त-देखि-अन्त उदाहरण

यो उदाहरणले कसरी एक साधारण Spring Boot एप्लिकेसन बनाउने र Azure OpenAI सँग जडान गर्ने तथा आफ्नो सेटअप परीक्षण गर्ने देखाउँछ।

## सामग्री तालिका

- [पूर्वापेक्षाहरू](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [छिटो सुरु](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [कन्फिगरेसन विकल्पहरू](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [विकल्प १: वातावरण चरहरू (.env फाइल) - सिफारिस गरिएको](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [विकल्प २: GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [एप्लिकेसन चलाउने](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Maven प्रयोग गर्दै](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [VS Code प्रयोग गर्दै](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [अपेक्षित आउटपुट](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [कन्फिगरेसन सन्दर्भ](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [वातावरण चरहरू](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Spring कन्फिगरेसन](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [समस्या समाधान](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [सामान्य समस्याहरू](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [डिबग मोड](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [अर्को चरणहरू](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [स्रोतहरू](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## पूर्वापेक्षाहरू

यो उदाहरण चलाउनु अघि सुनिश्चित गर्नुहोस् कि तपाईंले:

- [Azure OpenAI सेटअप गाइड](../../getting-started-azure-openai.md) पूरा गर्नुभएको छ  
- Azure AI Foundry पोर्टल मार्फत Azure OpenAI स्रोत तैनात गर्नुभएको छ  
- gpt-4o-mini मोडेल (वा विकल्प) तैनात गर्नुभएको छ  
- Azure बाट API कुञ्जी र अन्तबिन्दु URL प्राप्त गर्नुभएको छ  

## छिटो सुरु

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## कन्फिगरेसन विकल्पहरू

### विकल्प १: वातावरण चरहरू (.env फाइल) - सिफारिस गरिएको

**चरण १: आफ्नो कन्फिगरेसन फाइल बनाउनुहोस्**
```bash
cp .env.example .env
```

**चरण २: आफ्नो Azure OpenAI प्रमाणपत्रहरू थप्नुहोस्**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **सुरक्षा नोट**: 
> - कहिल्यै आफ्नो `.env` फाइललाई संस्करण नियन्त्रणमा समावेश नगर्नुहोस्
> - `.env` फाइल पहिले नै `.gitignore` मा समावेश गरिएको छ
> - आफ्नो API कुञ्जीहरू सुरक्षित राख्नुहोस् र नियमित रूपमा परिवर्तन गर्नुहोस्

### विकल्प २: GitHub Codespace Secrets

GitHub Codespaces को लागि, आफ्नो रिपोजिटरीमा यी गोप्य जानकारीहरू सेट गर्नुहोस्:
- `AZURE_AI_KEY` - तपाईंको Azure OpenAI API कुञ्जी
- `AZURE_AI_ENDPOINT` - तपाईंको Azure OpenAI अन्तबिन्दु URL

एप्लिकेसनले स्वतः यी गोप्य जानकारीहरू पत्ता लगाउँछ र प्रयोग गर्दछ।

### विकल्प: प्रत्यक्ष वातावरण चरहरू

<details>
<summary>प्लेटफर्म-विशिष्ट आदेशहरू हेर्न क्लिक गर्नुहोस्</summary>

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

## एप्लिकेसन चलाउने

### Maven प्रयोग गर्दै

```bash
mvn spring-boot:run
```

### VS Code प्रयोग गर्दै

1. परियोजना VS Code मा खोल्नुहोस्
2. `F5` थिच्नुहोस् वा "Run and Debug" प्यानल प्रयोग गर्नुहोस्
3. "Spring Boot-BasicChatApplication" कन्फिगरेसन चयन गर्नुहोस्

> **Note**: VS Code कन्फिगरेसनले स्वतः तपाईंको .env फाइल लोड गर्दछ

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

## कन्फिगरेसन सन्दर्भ

### वातावरण चरहरू

| चर | विवरण | आवश्यक | उदाहरण |
|----|-------|---------|---------|
| `AZURE_AI_KEY` | Azure OpenAI API कुञ्जी | हो | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI अन्तबिन्दु URL | हो | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | मोडेल तैनाती नाम | होइन | `gpt-4o-mini` (डिफल्ट) |

### Spring कन्फिगरेसन

`application.yml` फाइलले कन्फिगर गर्दछ:
- **API कुञ्जी**: `${AZURE_AI_KEY}` - वातावरण चरबाट
- **अन्तबिन्दु**: `${AZURE_AI_ENDPOINT}` - वातावरण चरबाट  
- **मोडेल**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - वातावरण चरबाट फलब्याक सहित
- **तापक्रम**: `0.7` - सिर्जनशीलता नियन्त्रण गर्दछ (0.0 = निर्धारणात्मक, 1.0 = सिर्जनशील)
- **अधिकतम टोकनहरू**: `500` - अधिकतम प्रतिक्रिया लम्बाइ

## समस्या समाधान

### सामान्य समस्याहरू

<details>
<summary><strong>त्रुटि: "API कुञ्जी मान्य छैन"</strong></summary>

- सुनिश्चित गर्नुहोस् कि तपाईंको `AZURE_AI_KEY` सही रूपमा तपाईंको `.env` फाइलमा सेट गरिएको छ
- API कुञ्जी Azure AI Foundry पोर्टलबाट ठ्याक्कै प्रतिलिपि गरिएको छ भनी जाँच गर्नुहोस्
- कुञ्जी वरिपरि कुनै अतिरिक्त स्पेस वा उद्धरणहरू छैनन् भनी सुनिश्चित गर्नुहोस्
</details>

<details>
<summary><strong>त्रुटि: "अन्तबिन्दु मान्य छैन"</strong></summary>

- सुनिश्चित गर्नुहोस् कि तपाईंको `AZURE_AI_ENDPOINT` पूर्ण URL समावेश गर्दछ (जस्तै, `https://your-hub-name.openai.azure.com/`)
- ट्रेलिङ स्ल्यासको स्थिरता जाँच गर्नुहोस्
- अन्तबिन्दु तपाईंको Azure तैनाती क्षेत्रसँग मेल खान्छ भनी पुष्टि गर्नुहोस्
</details>

<details>
<summary><strong>त्रुटि: "तैनाती फेला परेन"</strong></summary>

- सुनिश्चित गर्नुहोस् कि तपाईंको मोडेल तैनाती नाम Azure मा तैनात गरिएको नामसँग ठ्याक्कै मेल खान्छ
- मोडेल सफलतापूर्वक तैनात गरिएको र सक्रिय छ भनी जाँच गर्नुहोस्
- डिफल्ट तैनाती नाम प्रयोग गरेर प्रयास गर्नुहोस्: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: वातावरण चरहरू लोड हुँदै छैन</strong></summary>

- सुनिश्चित गर्नुहोस् कि तपाईंको `.env` फाइल परियोजना मूल निर्देशिकामा छ (उस्तै स्तरमा `pom.xml`)
- VS Code को एकीकृत टर्मिनलमा `mvn spring-boot:run` चलाउने प्रयास गर्नुहोस्
- VS Code Java विस्तार सही रूपमा स्थापना गरिएको छ भनी जाँच गर्नुहोस्
- लन्च कन्फिगरेसनमा `"envFile": "${workspaceFolder}/.env"` समावेश छ भनी पुष्टि गर्नुहोस्
</details>

### डिबग मोड

विस्तृत लगिङ सक्षम गर्न, `application.yml` मा यी लाइनहरू अनकमेण्ट गर्नुहोस्:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## अर्को चरणहरू

**सेटअप पूरा भयो!** आफ्नो सिकाइ यात्रा जारी राख्नुहोस्:

[अध्याय ३: कोर जेनेरेटिभ AI प्रविधिहरू](../../../03-CoreGenerativeAITechniques/README.md)

## स्रोतहरू

- [Spring AI Azure OpenAI डकुमेन्टेसन](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Azure OpenAI सेवा डकुमेन्टेसन](https://learn.microsoft.com/azure/ai-services/openai/)
- [Azure AI Foundry पोर्टल](https://ai.azure.com/)
- [Azure AI Foundry डकुमेन्टेसन](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**अस्वीकरण**:  
यो दस्तावेज़ AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) प्रयोग गरेर अनुवाद गरिएको छ। हामी शुद्धताको लागि प्रयास गर्छौं, तर कृपया ध्यान दिनुहोस् कि स्वचालित अनुवादहरूमा त्रुटिहरू वा अशुद्धताहरू हुन सक्छ। यसको मूल भाषा मा रहेको मूल दस्तावेज़लाई आधिकारिक स्रोत मानिनुपर्छ। महत्वपूर्ण जानकारीको लागि, व्यावसायिक मानव अनुवाद सिफारिस गरिन्छ। यस अनुवादको प्रयोगबाट उत्पन्न हुने कुनै पनि गलतफहमी वा गलत व्याख्याको लागि हामी जिम्मेवार हुने छैनौं।