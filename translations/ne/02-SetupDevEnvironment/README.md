<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0b563ac59362fb83f0f49dcfc442dd97",
  "translation_date": "2025-07-21T17:56:29+00:00",
  "source_file": "02-SetupDevEnvironment/README.md",
  "language_code": "ne"
}
-->
# जेनरेटिभ एआईको लागि जाभा विकास वातावरण सेटअप गर्नुहोस्

> **छिटो सुरु**: क्लाउडमा २ मिनेटमा कोड लेख्न सुरु गर्नुहोस् - [GitHub Codespaces सेटअप](../../../02-SetupDevEnvironment) मा जानुहोस् - कुनै स्थानीय इन्स्टलेशन आवश्यक छैन र GitHub मोडेलहरू प्रयोग गर्दछ!

> **Azure OpenAI मा रुचि छ?**, हाम्रो [Azure OpenAI सेटअप गाइड](getting-started-azure-openai.md) हेर्नुहोस् जसले नयाँ Azure OpenAI स्रोत सिर्जना गर्ने चरणहरू समावेश गर्दछ।

## तपाईंले के सिक्नुहुनेछ

- एआई एप्लिकेसनहरूको लागि जाभा विकास वातावरण सेटअप गर्नुहोस्
- आफ्नो मनपर्ने विकास वातावरण चयन र कन्फिगर गर्नुहोस् (Codespaces मार्फत क्लाउड-फर्स्ट, स्थानीय डिभ कन्टेनर, वा पूर्ण स्थानीय सेटअप)
- GitHub मोडेलहरूसँग जडान गरेर आफ्नो सेटअप परीक्षण गर्नुहोस्

## सामग्री तालिका

- [तपाईंले के सिक्नुहुनेछ](../../../02-SetupDevEnvironment)
- [परिचय](../../../02-SetupDevEnvironment)
- [चरण १: आफ्नो विकास वातावरण सेटअप गर्नुहोस्](../../../02-SetupDevEnvironment)
  - [विकल्प A: GitHub Codespaces (सिफारिस गरिएको)](../../../02-SetupDevEnvironment)
  - [विकल्प B: स्थानीय डिभ कन्टेनर](../../../02-SetupDevEnvironment)
  - [विकल्प C: आफ्नो हालको स्थानीय इन्स्टलेशन प्रयोग गर्नुहोस्](../../../02-SetupDevEnvironment)
- [चरण २: GitHub व्यक्तिगत पहुँच टोकन सिर्जना गर्नुहोस्](../../../02-SetupDevEnvironment)
- [चरण ३: आफ्नो सेटअप परीक्षण गर्नुहोस्](../../../02-SetupDevEnvironment)
- [समस्या समाधान](../../../02-SetupDevEnvironment)
- [सारांश](../../../02-SetupDevEnvironment)
- [अगाडि के गर्ने](../../../02-SetupDevEnvironment)

## परिचय

यो अध्यायले तपाईंलाई विकास वातावरण सेटअप गर्न मार्गदर्शन गर्नेछ। हामी **GitHub मोडेलहरू**लाई हाम्रो प्राथमिक उदाहरणको रूपमा प्रयोग गर्नेछौं किनभने यो निःशुल्क छ, GitHub खाता मात्र आवश्यक छ, क्रेडिट कार्ड आवश्यक छैन, र विभिन्न मोडेलहरूमा प्रयोग गर्न सजिलो छ।

**कुनै स्थानीय सेटअप आवश्यक छैन!** तपाईं GitHub Codespaces प्रयोग गरेर तुरुन्तै ब्राउजरमा पूर्ण विकास वातावरण सुरु गर्न सक्नुहुन्छ।

<img src="./images/models.webp" alt="स्क्रिनशट: GitHub मोडेलहरू" width="50%">

हामी [**GitHub मोडेलहरू**](https://github.com/marketplace?type=models) प्रयोग गर्न सिफारिस गर्छौं किनभने:
- **निःशुल्क** सुरु गर्न
- **सजिलो** सेटअप, केवल GitHub खाता आवश्यक
- **कुनै क्रेडिट कार्ड** आवश्यक छैन
- **धेरै मोडेलहरू** प्रयोग गर्न उपलब्ध

> **नोट**: यो तालिममा प्रयोग गरिएका GitHub मोडेलहरूको निःशुल्क सीमा:
> - प्रति मिनेट १५ अनुरोध (प्रति दिन १५०)
> - ~८,००० शब्द इनपुट, ~४,००० शब्द आउटपुट प्रति अनुरोध
> - ५ समवर्ती अनुरोधहरू
> 
> उत्पादन प्रयोगको लागि, Azure AI Foundry मोडेलहरूमा अपग्रेड गर्नुहोस्। तपाईंको कोड परिवर्तन गर्न आवश्यक छैन। [Azure AI Foundry डकुमेन्टेशन](https://learn.microsoft.com/azure/ai-foundry/foundry-models/how-to/quickstart-github-models) हेर्नुहोस्।

## चरण १: आफ्नो विकास वातावरण सेटअप गर्नुहोस्

<a name="quick-start-cloud"></a>

हामीले यो जेनरेटिभ एआईको लागि जाभा कोर्सको लागि आवश्यक सबै उपकरणहरू सहित पूर्व-कन्फिगर गरिएको विकास कन्टेनर तयार गरेका छौं। आफ्नो मनपर्ने विकास विधि चयन गर्नुहोस्:

### वातावरण सेटअप विकल्पहरू:

#### विकल्प A: GitHub Codespaces (सिफारिस गरिएको)

**२ मिनेटमा कोड लेख्न सुरु गर्नुहोस् - कुनै स्थानीय सेटअप आवश्यक छैन!**

1. यो रिपोजिटरीलाई आफ्नो GitHub खातामा फोर्क गर्नुहोस्
   > **नोट**: यदि तपाईं आधारभूत कन्फिग सम्पादन गर्न चाहनुहुन्छ भने [Dev Container Configuration](../../../.devcontainer/devcontainer.json) हेर्नुहोस्।
2. **Code** → **Codespaces** ट्याब → **...** → **New with options...** क्लिक गर्नुहोस्।
3. डिफल्ट सेटिङहरू प्रयोग गर्नुहोस् – यसले **Generative AI Java Development Environment** कस्टम डिभकन्टेनर चयन गर्नेछ।
4. **Create codespace** क्लिक गर्नुहोस्।
5. वातावरण तयार हुन ~२ मिनेट कुर्नुहोस्।
6. [चरण २: GitHub टोकन सिर्जना गर्नुहोस्](../../../02-SetupDevEnvironment) मा अगाडि बढ्नुहोस्।

<img src="./images/codespaces.png" alt="स्क्रिनशट: Codespaces सबमेनु" width="50%">

<img src="./images/image.png" alt="स्क्रिनशट: New with options" width="50%">

<img src="./images/codespaces-create.png" alt="स्क्रिनशट: Create codespace options" width="50%">


> **Codespaces को फाइदा**:
> - कुनै स्थानीय इन्स्टलेशन आवश्यक छैन
> - ब्राउजर भएको कुनै पनि उपकरणमा काम गर्दछ
> - सबै उपकरण र निर्भरताहरू सहित पूर्व-कन्फिगर गरिएको
> - व्यक्तिगत खाताहरूको लागि प्रति महिना निःशुल्क ६० घण्टा
> - सबै सिक्नेहरूका लागि समान वातावरण

#### विकल्प B: स्थानीय डिभ कन्टेनर

**Docker प्रयोग गरेर स्थानीय विकासलाई प्राथमिकता दिने विकासकर्ताहरूका लागि**

1. यो रिपोजिटरीलाई आफ्नो स्थानीय मेसिनमा फोर्क र क्लोन गर्नुहोस्।
   > **नोट**: यदि तपाईं आधारभूत कन्फिग सम्पादन गर्न चाहनुहुन्छ भने [Dev Container Configuration](../../../.devcontainer/devcontainer.json) हेर्नुहोस्।
2. [Docker Desktop](https://www.docker.com/products/docker-desktop/) र [VS Code](https://code.visualstudio.com/) इन्स्टल गर्नुहोस्।
3. VS Code मा [Dev Containers extension](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) इन्स्टल गर्नुहोस्।
4. रिपोजिटरी फोल्डरलाई VS Code मा खोल्नुहोस्।
5. जब सोधिन्छ, **Reopen in Container** क्लिक गर्नुहोस् (वा `Ctrl+Shift+P` → "Dev Containers: Reopen in Container" प्रयोग गर्नुहोस्)।
6. कन्टेनर निर्माण र सुरु हुन कुर्नुहोस्।
7. [चरण २: GitHub टोकन सिर्जना गर्नुहोस्](../../../02-SetupDevEnvironment) मा अगाडि बढ्नुहोस्।

<img src="./images/devcontainer.png" alt="स्क्रिनशट: Dev container सेटअप" width="50%">

<img src="./images/image-3.png" alt="स्क्रिनशट: Dev container निर्माण पूरा" width="50%">

#### विकल्प C: आफ्नो हालको स्थानीय इन्स्टलेशन प्रयोग गर्नुहोस्

**पहिले नै जाभा वातावरण सेटअप गरेका विकासकर्ताहरूका लागि**

आवश्यकताहरू:
- [Java 21+](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) 
- [Maven 3.9+](https://maven.apache.org/download.cgi)
- [VS Code](https://code.visualstudio.com) वा आफ्नो मनपर्ने IDE

चरणहरू:
1. यो रिपोजिटरीलाई आफ्नो स्थानीय मेसिनमा क्लोन गर्नुहोस्।
2. परियोजनालाई आफ्नो IDE मा खोल्नुहोस्।
3. [चरण २: GitHub टोकन सिर्जना गर्नुहोस्](../../../02-SetupDevEnvironment) मा अगाडि बढ्नुहोस्।

> **प्रो टिप**: यदि तपाईंको मेसिन कम-स्पेक छ तर स्थानीय रूपमा VS Code चाहनुहुन्छ भने, GitHub Codespaces प्रयोग गर्नुहोस्! तपाईं आफ्नो स्थानीय VS Code लाई क्लाउड-होस्ट गरिएको Codespace मा जडान गर्न सक्नुहुन्छ।

<img src="./images/image-2.png" alt="स्क्रिनशट: स्थानीय डिभकन्टेनर इन्स्टेन्स सिर्जना गरिएको" width="50%">


## चरण २: GitHub व्यक्तिगत पहुँच टोकन सिर्जना गर्नुहोस्

1. [GitHub सेटिङहरू](https://github.com/settings/profile) मा जानुहोस् र आफ्नो प्रोफाइल मेनुबाट **Settings** चयन गर्नुहोस्।
2. बाँया साइडबारमा, **Developer settings** क्लिक गर्नुहोस् (सामान्यतया तलतिर हुन्छ)।
3. **Personal access tokens** अन्तर्गत, **Fine-grained tokens** क्लिक गर्नुहोस् (वा यो [लिङ्क](https://github.com/settings/personal-access-tokens) प्रयोग गर्नुहोस्)।
4. **Generate new token** क्लिक गर्नुहोस्।
5. "Token name" अन्तर्गत, वर्णनात्मक नाम प्रदान गर्नुहोस् (जस्तै, `GenAI-Java-Course-Token`)।
6. समाप्ति मिति सेट गर्नुहोस् (सुरक्षा दृष्टिकोणले ७ दिन सिफारिस गरिएको)।
7. "Resource owner" अन्तर्गत, आफ्नो प्रयोगकर्ता खाता चयन गर्नुहोस्।
8. "Repository access" अन्तर्गत, तपाईंले GitHub मोडेलहरूसँग प्रयोग गर्न चाहनुभएको रिपोजिटरीहरू चयन गर्नुहोस् (वा "All repositories" यदि आवश्यक छ भने)।
9. "Repository permissions" अन्तर्गत, **Models** फेला पार्नुहोस् र यसलाई **Read and write** मा सेट गर्नुहोस्।
10. **Generate token** क्लिक गर्नुहोस्।
11. **अब आफ्नो टोकन कपी र सुरक्षित गर्नुहोस्** – तपाईं यसलाई फेरि देख्नुहुनेछैन!

> **सुरक्षा टिप**: पहुँच टोकनहरूको लागि न्यूनतम आवश्यक स्कोप र छोटो व्यावहारिक समाप्ति समय प्रयोग गर्नुहोस्।

## चरण ३: GitHub मोडेलहरूको उदाहरणसँग आफ्नो सेटअप परीक्षण गर्नुहोस्

जब तपाईंको विकास वातावरण तयार हुन्छ, GitHub मोडेलहरूको एकीकरण हाम्रो उदाहरण एप्लिकेसनसँग परीक्षण गरौं [`02-SetupDevEnvironment/src/github-models`](../../../02-SetupDevEnvironment/src/github-models)।

1. आफ्नो विकास वातावरणमा टर्मिनल खोल्नुहोस्।
2. GitHub मोडेलहरूको उदाहरणमा जानुहोस्:
   ```bash
   cd 02-SetupDevEnvironment/src/github-models
   ```
3. आफ्नो GitHub टोकनलाई वातावरण चरको रूपमा सेट गर्नुहोस्:
   ```bash
   # macOS/Linux
   export GITHUB_TOKEN=your_token_here
   
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_token_here"
   ```

4. एप्लिकेसन चलाउनुहोस्:
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.githubmodels.App"
   ```

तपाईंले निम्न जस्तै आउटपुट देख्नुहुनेछ:
```text
Using model: gpt-4.1-nano
Sending request to GitHub Models...
Response: Hello World!
```

### उदाहरण कोड बुझ्दै

पहिले, हामी के चलाउन लागेका छौं बुझौं। उदाहरणले OpenAI Java SDK प्रयोग गरेर GitHub मोडेलहरूसँग जडान गर्दछ:

**यो कोडले के गर्छ:**
- **जडान गर्दछ** GitHub मोडेलहरूसँग तपाईंको व्यक्तिगत पहुँच टोकन प्रयोग गरेर
- **सन्देश पठाउँछ** "Say Hello World!" एआई मोडेललाई
- **प्राप्त गर्दछ** र एआईको प्रतिक्रिया देखाउँछ
- **पुष्टि गर्दछ** कि तपाईंको सेटअप सही रूपमा काम गरिरहेको छ

**मुख्य निर्भरता** (`pom.xml` मा):
```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

**मुख्य कोड** (`App.java`):
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

## सारांश

**बधाई छ!** तपाईंले सफलतापूर्वक:

- **GitHub व्यक्तिगत पहुँच टोकन सिर्जना गर्नुभयो** सही अनुमति सहित एआई मोडेल पहुँचको लागि
- **जाभा विकास वातावरण सेटअप गर्नुभयो** Codespaces, डिभ कन्टेनरहरू, वा स्थानीय इन्स्टलेशन प्रयोग गरेर
- **GitHub मोडेलहरूसँग जडान गर्नुभयो** OpenAI Java SDK प्रयोग गरेर निःशुल्क एआई विकास पहुँचको लागि
- **एकीकरण परीक्षण गर्नुभयो** काम गर्ने उदाहरण एप्लिकेसनसँग जसले एआई मोडेलहरूसँग संवाद गर्दछ

## अगाडि के गर्ने

[अध्याय ३: कोर जेनरेटिभ एआई प्रविधिहरू](../03-CoreGenerativeAITechniques/README.md)

## समस्या समाधान

समस्या छ? यहाँ सामान्य समस्या र समाधानहरू छन्:

- **टोकन काम गरिरहेको छैन?** 
  - सुनिश्चित गर्नुहोस् कि तपाईंले टोकनलाई कुनै अतिरिक्त स्पेस बिना पूर्ण रूपमा कपी गर्नुभएको छ।
  - टोकन सही रूपमा वातावरण चरको रूपमा सेट गरिएको छ भनी पुष्टि गर्नुहोस्।
  - तपाईंको टोकनसँग सही अनुमति छ भनी जाँच गर्नुहोस् (Models: Read and write)।

- **Maven फेला परेन?** 
  - यदि डिभ कन्टेनरहरू/Codespaces प्रयोग गर्दै हुनुहुन्छ भने Maven पूर्व-इन्स्टल गरिएको हुनुपर्छ।
  - स्थानीय सेटअपको लागि, सुनिश्चित गर्नुहोस् कि Java 21+ र Maven 3.9+ इन्स्टल गरिएको छ।
  - `mvn --version` चलाएर इन्स्टलेशन पुष्टि गर्नुहोस्।

- **जडान समस्या?** 
  - आफ्नो इन्टरनेट जडान जाँच गर्नुहोस्।
  - GitHub तपाईंको नेटवर्कबाट पहुँचयोग्य छ भनी पुष्टि गर्नुहोस्।
  - GitHub मोडेलहरूको अन्त बिन्दु अवरोध गर्ने फायरवाल छैन भनी सुनिश्चित गर्नुहोस्।

- **डिभ कन्टेनर सुरु भइरहेको छैन?** 
  - सुनिश्चित गर्नुहोस् कि Docker Desktop चलिरहेको छ (स्थानीय विकासको लागि)।
  - कन्टेनर पुनर्निर्माण प्रयास गर्नुहोस्: `Ctrl+Shift+P` → "Dev Containers: Rebuild Container"।

- **एप्लिकेसन कम्पाइल त्रुटिहरू?**
  - सुनिश्चित गर्नुहोस् कि तपाईं सही डाइरेक्टरीमा हुनुहुन्छ: `02-SetupDevEnvironment/src/github-models`
  - सफा र पुनर्निर्माण प्रयास गर्नुहोस्: `mvn clean compile`

> **मद्दत चाहिन्छ?**: अझै समस्या छ? रिपोजिटरीमा समस्या खोल्नुहोस्, हामी तपाईंलाई सहयोग गर्नेछौं।

**अस्वीकरण**:  
यो दस्तावेज़ AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) प्रयोग गरेर अनुवाद गरिएको छ। हामी यथार्थताको लागि प्रयास गर्छौं, तर कृपया ध्यान दिनुहोस् कि स्वचालित अनुवादहरूमा त्रुटिहरू वा अशुद्धताहरू हुन सक्छ। यसको मूल भाषा मा रहेको मूल दस्तावेज़लाई आधिकारिक स्रोत मानिनुपर्छ। महत्वपूर्ण जानकारीको लागि, व्यावसायिक मानव अनुवाद सिफारिस गरिन्छ। यस अनुवादको प्रयोगबाट उत्पन्न हुने कुनै पनि गलतफहमी वा गलत व्याख्याको लागि हामी जिम्मेवार हुने छैनौं।