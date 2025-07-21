<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T18:14:07+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "mr"
}
-->
# Foundry स्थानिक कमांड-लाइन अनुप्रयोग

>**टीप**: या अध्यायामध्ये [**ट्युटोरियल**](./TUTORIAL.md) समाविष्ट आहे, जे तुम्हाला तयार नमुन्ये चालवण्याचे मार्गदर्शन करते.

एक साधा Spring Boot कमांड-लाइन अनुप्रयोग जो OpenAI Java SDK वापरून Foundry Local शी कसे कनेक्ट करायचे हे दाखवतो.

## तुम्ही काय शिकाल

- OpenAI Java SDK वापरून Spring Boot अनुप्रयोगांमध्ये Foundry Local कसे समाकलित करायचे
- स्थानिक AI विकास आणि चाचणीसाठी सर्वोत्तम पद्धती

## विषय सूची

- [तुम्ही काय शिकाल](../../../../04-PracticalSamples/foundrylocal)
- [पूर्वतयारी](../../../../04-PracticalSamples/foundrylocal)
  - [Foundry Local स्थापित करणे](../../../../04-PracticalSamples/foundrylocal)
  - [सत्यापन](../../../../04-PracticalSamples/foundrylocal)
- [कॉन्फिगरेशन](../../../../04-PracticalSamples/foundrylocal)
- [जलद सुरुवात](../../../../04-PracticalSamples/foundrylocal)
- [अनुप्रयोग काय करतो](../../../../04-PracticalSamples/foundrylocal)
- [नमुन्य आउटपुट](../../../../04-PracticalSamples/foundrylocal)
- [आर्किटेक्चर](../../../../04-PracticalSamples/foundrylocal)
- [कोड हायलाइट्स](../../../../04-PracticalSamples/foundrylocal)
  - [OpenAI Java SDK समाकलन](../../../../04-PracticalSamples/foundrylocal)
  - [चॅट पूर्णता API](../../../../04-PracticalSamples/foundrylocal)
- [समस्या निवारण](../../../../04-PracticalSamples/foundrylocal)

## पूर्वतयारी

> **⚠️ टीप**: हा अनुप्रयोग **पुरवलेल्या devcontainer मध्ये चालत नाही** कारण यासाठी Foundry Local यजमान प्रणालीवर स्थापित आणि चालू असणे आवश्यक आहे.

### Foundry Local स्थापित करणे

हा अनुप्रयोग चालवण्यापूर्वी, तुम्हाला Foundry Local स्थापित करणे आणि सुरू करणे आवश्यक आहे. खालील चरणांचे अनुसरण करा:

1. **तुमची प्रणाली आवश्यकता पूर्ण करते याची खात्री करा**:
   - **ऑपरेटिंग सिस्टम**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025, किंवा macOS
   - **हार्डवेअर**: 
     - किमान: 8GB RAM, 3GB मोकळी डिस्क जागा
     - शिफारस केलेली: 16GB RAM, 15GB मोकळी डिस्क जागा
   - **नेटवर्क**: प्रारंभिक मॉडेल डाउनलोडसाठी इंटरनेट कनेक्शन (ऑफलाइन वापरासाठी पर्यायी)
   - **गती वाढवणे (पर्यायी)**: NVIDIA GPU (2,000 मालिका किंवा नवीन), AMD GPU (6,000 मालिका किंवा नवीन), Qualcomm Snapdragon X Elite (8GB किंवा अधिक मेमरी), किंवा Apple silicon
   - **परवानग्या**: तुमच्या डिव्हाइसवर सॉफ्टवेअर स्थापित करण्यासाठी प्रशासकीय विशेषाधिकार

2. **Foundry Local स्थापित करा**:
   
   **Windows साठी:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **macOS साठी:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   पर्यायाने, तुम्ही [Foundry Local GitHub रिपॉझिटरी](https://github.com/microsoft/Foundry-Local) वरून इंस्टॉलर डाउनलोड करू शकता.

3. **तुमचे पहिले मॉडेल सुरू करा**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   मॉडेल डाउनलोड होते (तुमच्या इंटरनेटच्या वेगावर अवलंबून काही मिनिटे लागू शकतात) आणि नंतर चालते. Foundry Local तुमच्या प्रणालीसाठी सर्वोत्तम मॉडेल प्रकार आपोआप निवडते (NVIDIA GPUs साठी CUDA, अन्यथा CPU आवृत्ती).

4. **मॉडेलची चाचणी घ्या** त्याच टर्मिनलमध्ये प्रश्न विचारून:

   ```bash
   Why is the sky blue?
   ```

   तुम्हाला Phi मॉडेलकडून उत्तर दिसेल ज्यामध्ये आकाश निळे का दिसते याचे स्पष्टीकरण दिले जाईल.

### सत्यापन

तुम्ही खालील कमांड्स वापरून सर्वकाही योग्य प्रकारे कार्य करत आहे याची खात्री करू शकता:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

तुम्ही `http://localhost:5273` वर तुमच्या ब्राउझरमध्ये Foundry Local वेब इंटरफेस देखील पाहू शकता.

## कॉन्फिगरेशन

अनुप्रयोग `application.properties` द्वारे कॉन्फिगर केला जाऊ शकतो:

- `foundry.local.base-url` - Foundry Local साठी बेस URL (डीफॉल्ट: http://localhost:5273)
- `foundry.local.model` - वापरण्यासाठी AI मॉडेल (डीफॉल्ट: Phi-3.5-mini-instruct-cuda-gpu)

> **टीप**: कॉन्फिगरेशनमधील मॉडेलचे नाव तुमच्या प्रणालीसाठी Foundry Local ने डाउनलोड केलेल्या विशिष्ट प्रकाराशी जुळले पाहिजे. जेव्हा तुम्ही `foundry model run phi-3.5-mini` चालवता, तेव्हा Foundry Local सर्वोत्तम प्रकार आपोआप निवडते आणि डाउनलोड करते (NVIDIA GPUs साठी CUDA, अन्यथा CPU आवृत्ती). तुमच्या स्थानिक उदाहरणामध्ये उपलब्ध असलेले अचूक मॉडेल नाव पाहण्यासाठी `foundry model list` वापरा.

## जलद सुरुवात

### 1. Foundry Local अनुप्रयोग निर्देशिकेत जा
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. अनुप्रयोग चालवा

```bash
mvn spring-boot:run
```

किंवा JAR तयार करून चालवा:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### अवलंबित्वे

हा अनुप्रयोग Foundry Local शी संवाद साधण्यासाठी OpenAI Java SDK वापरतो. मुख्य अवलंबित्व आहे:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

अनुप्रयोग डीफॉल्ट पोर्टवर चालणाऱ्या Foundry Local शी कनेक्ट होण्यासाठी पूर्व-कॉन्फिगर केलेला आहे.

## अनुप्रयोग काय करतो

जेव्हा तुम्ही अनुप्रयोग चालवता:

1. **कमांड-लाइन अनुप्रयोग म्हणून सुरू होते** (वेब सर्व्हर नाही)
2. **आपोआप एक चाचणी संदेश पाठवते**: "नमस्कार! तुम्ही काय आहात आणि कोणते मॉडेल चालवत आहात हे तुम्ही सांगू शकता का?"
3. **Foundry Local कडून प्रतिसाद कन्सोलमध्ये प्रदर्शित करते**
4. **डेमो नंतर स्वच्छपणे बंद होते**

## नमुन्य आउटपुट

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## आर्किटेक्चर

- **Application.java** - मुख्य Spring Boot अनुप्रयोग CommandLineRunner सह
- **FoundryLocalService.java** - OpenAI Java SDK वापरून Foundry Local शी संवाद साधणारी सेवा
- **OpenAI Java SDK** वापरून प्रकार-सुरक्षित API कॉल्स
- SDK द्वारे स्वयंचलित JSON सिरियलायझेशन/डिसिरियलायझेशन
- Spring च्या `@Value` आणि `@PostConstruct` अ‍ॅनोटेशन वापरून स्वच्छ कॉन्फिगरेशन

## कोड हायलाइट्स

### OpenAI Java SDK समाकलन

अनुप्रयोग OpenAI Java SDK वापरतो जे Foundry Local साठी क्लायंट तयार करते:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### चॅट पूर्णता API

चॅट पूर्णता विनंत्या करणे सोपे आणि प्रकार-सुरक्षित आहे:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## समस्या निवारण

जर तुम्हाला कनेक्शन त्रुटी दिसत असतील:
1. Foundry Local `http://localhost:5273` वर चालू आहे याची खात्री करा
2. `foundry model list` वापरून Phi-3.5-mini मॉडेल प्रकार उपलब्ध आहे याची खात्री करा
3. `application.properties` मधील मॉडेलचे नाव उपलब्ध मॉडेलच्या अचूक नावाशी जुळते याची खात्री करा
4. कोणताही फायरवॉल कनेक्शन ब्लॉक करत नाही याची खात्री करा

सामान्य समस्या:
- **मॉडेल सापडले नाही**: मॉडेल डाउनलोड आणि सुरू करण्यासाठी `foundry model run phi-3.5-mini` चालवा
- **सेवा चालू नाही**: Foundry Local सेवा थांबली असू शकते; मॉडेल रन कमांडसह ती पुन्हा सुरू करा
- **चुकीचे मॉडेल नाव**: उपलब्ध मॉडेल्स पाहण्यासाठी `foundry model list` वापरा आणि तुमची कॉन्फिगरेशन तदनुसार अपडेट करा

**अस्वीकरण**:  
हा दस्तऐवज AI भाषांतर सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) वापरून भाषांतरित करण्यात आला आहे. आम्ही अचूकतेसाठी प्रयत्नशील असलो तरी कृपया लक्षात ठेवा की स्वयंचलित भाषांतरांमध्ये त्रुटी किंवा अचूकतेचा अभाव असू शकतो. मूळ भाषेतील दस्तऐवज हा अधिकृत स्रोत मानला जावा. महत्त्वाच्या माहितीसाठी व्यावसायिक मानवी भाषांतराची शिफारस केली जाते. या भाषांतराचा वापर करून उद्भवलेल्या कोणत्याही गैरसमज किंवा चुकीच्या अर्थासाठी आम्ही जबाबदार राहणार नाही.