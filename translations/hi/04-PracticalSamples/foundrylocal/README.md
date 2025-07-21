<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T16:37:17+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "hi"
}
-->
# Foundry Local कमांड-लाइन एप्लिकेशन

>**नोट**: इस अध्याय में एक [**ट्यूटोरियल**](./TUTORIAL.md) शामिल है जो आपको तैयार नमूनों को चलाने के लिए मार्गदर्शन करता है।

एक सरल Spring Boot कमांड-लाइन एप्लिकेशन जो दिखाता है कि OpenAI Java SDK का उपयोग करके Foundry Local से कैसे कनेक्ट करें।

## आप क्या सीखेंगे

- OpenAI Java SDK का उपयोग करके Spring Boot एप्लिकेशन के साथ Foundry Local को कैसे एकीकृत करें
- स्थानीय AI विकास और परीक्षण के लिए सर्वोत्तम प्रथाएँ

## सामग्री की तालिका

- [आप क्या सीखेंगे](../../../../04-PracticalSamples/foundrylocal)
- [पूर्व आवश्यकताएँ](../../../../04-PracticalSamples/foundrylocal)
  - [Foundry Local स्थापित करना](../../../../04-PracticalSamples/foundrylocal)
  - [सत्यापन](../../../../04-PracticalSamples/foundrylocal)
- [कॉन्फ़िगरेशन](../../../../04-PracticalSamples/foundrylocal)
- [त्वरित शुरुआत](../../../../04-PracticalSamples/foundrylocal)
- [एप्लिकेशन क्या करता है](../../../../04-PracticalSamples/foundrylocal)
- [नमूना आउटपुट](../../../../04-PracticalSamples/foundrylocal)
- [आर्किटेक्चर](../../../../04-PracticalSamples/foundrylocal)
- [कोड हाइलाइट्स](../../../../04-PracticalSamples/foundrylocal)
  - [OpenAI Java SDK एकीकरण](../../../../04-PracticalSamples/foundrylocal)
  - [चैट पूर्णता API](../../../../04-PracticalSamples/foundrylocal)
- [समस्या निवारण](../../../../04-PracticalSamples/foundrylocal)

## पूर्व आवश्यकताएँ

> **⚠️ नोट**: यह एप्लिकेशन **प्रदान किए गए devcontainer में नहीं चलता है** क्योंकि इसे Foundry Local को होस्ट सिस्टम पर स्थापित और चलाने की आवश्यकता होती है।

### Foundry Local स्थापित करना

इस एप्लिकेशन को चलाने से पहले, आपको Foundry Local को स्थापित और शुरू करना होगा। इन चरणों का पालन करें:

1. **सुनिश्चित करें कि आपका सिस्टम आवश्यकताओं को पूरा करता है**:
   - **ऑपरेटिंग सिस्टम**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025, या macOS
   - **हार्डवेयर**: 
     - न्यूनतम: 8GB RAM, 3GB खाली डिस्क स्थान
     - अनुशंसित: 16GB RAM, 15GB खाली डिस्क स्थान
   - **नेटवर्क**: प्रारंभिक मॉडल डाउनलोड के लिए इंटरनेट कनेक्शन (ऑफ़लाइन उपयोग के लिए वैकल्पिक)
   - **त्वरण (वैकल्पिक)**: NVIDIA GPU (2,000 सीरीज़ या नया), AMD GPU (6,000 सीरीज़ या नया), Qualcomm Snapdragon X Elite (8GB या अधिक मेमोरी), या Apple सिलिकॉन
   - **अनुमतियाँ**: आपके डिवाइस पर सॉफ़्टवेयर स्थापित करने के लिए प्रशासनिक विशेषाधिकार

2. **Foundry Local स्थापित करें**:
   
   **Windows के लिए:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **macOS के लिए:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   वैकल्पिक रूप से, आप इंस्टॉलर को [Foundry Local GitHub रिपॉजिटरी](https://github.com/microsoft/Foundry-Local) से डाउनलोड कर सकते हैं।

3. **अपना पहला मॉडल शुरू करें**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   मॉडल डाउनलोड होता है (जो आपकी इंटरनेट स्पीड के आधार पर कुछ मिनट लग सकता है) और फिर चलता है। Foundry Local स्वचालित रूप से आपके सिस्टम के लिए सबसे अच्छा मॉडल वेरिएंट चुनता है (NVIDIA GPUs के लिए CUDA, अन्यथा CPU संस्करण)।

4. **मॉडल का परीक्षण करें** उसी टर्मिनल में एक प्रश्न पूछकर:

   ```bash
   Why is the sky blue?
   ```

   आपको Phi मॉडल से एक प्रतिक्रिया दिखाई देनी चाहिए जो समझाएगी कि आकाश नीला क्यों दिखता है।

### सत्यापन

आप इन कमांड्स के साथ सत्यापित कर सकते हैं कि सब कुछ सही तरीके से काम कर रहा है:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

आप `http://localhost:5273` पर जाकर Foundry Local वेब इंटरफ़ेस भी देख सकते हैं।

## कॉन्फ़िगरेशन

एप्लिकेशन को `application.properties` के माध्यम से कॉन्फ़िगर किया जा सकता है:

- `foundry.local.base-url` - Foundry Local के लिए बेस URL (डिफ़ॉल्ट: http://localhost:5273)
- `foundry.local.model` - उपयोग करने के लिए AI मॉडल (डिफ़ॉल्ट: Phi-3.5-mini-instruct-cuda-gpu)

> **नोट**: कॉन्फ़िगरेशन में मॉडल का नाम उस विशिष्ट वेरिएंट से मेल खाना चाहिए जिसे Foundry Local ने आपके सिस्टम के लिए डाउनलोड किया है। जब आप `foundry model run phi-3.5-mini` चलाते हैं, तो Foundry Local स्वचालित रूप से सबसे अच्छा वेरिएंट चुनता और डाउनलोड करता है (NVIDIA GPUs के लिए CUDA, अन्यथा CPU संस्करण)। अपने स्थानीय इंस्टेंस में उपलब्ध सटीक मॉडल नाम देखने के लिए `foundry model list` का उपयोग करें।

## त्वरित शुरुआत

### 1. Foundry Local एप्लिकेशन डायरेक्टरी पर जाएं
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. एप्लिकेशन चलाएं

```bash
mvn spring-boot:run
```

या JAR बनाएं और चलाएं:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### निर्भरताएँ

यह एप्लिकेशन Foundry Local के साथ संवाद करने के लिए OpenAI Java SDK का उपयोग करता है। मुख्य निर्भरता है:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

एप्लिकेशन को डिफ़ॉल्ट पोर्ट पर चल रहे Foundry Local से कनेक्ट करने के लिए पहले से कॉन्फ़िगर किया गया है।

## एप्लिकेशन क्या करता है

जब आप एप्लिकेशन चलाते हैं:

1. **एक कमांड-लाइन एप्लिकेशन के रूप में शुरू होता है** (कोई वेब सर्वर नहीं)
2. **स्वचालित रूप से एक परीक्षण संदेश भेजता है**: "नमस्ते! क्या आप मुझे बता सकते हैं कि आप क्या हैं और कौन सा मॉडल चला रहे हैं?"
3. **Foundry Local से प्रतिक्रिया प्रदर्शित करता है** कंसोल में
4. **डेमो के बाद साफ़ तरीके से बाहर निकलता है**

## नमूना आउटपुट

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## आर्किटेक्चर

- **Application.java** - मुख्य Spring Boot एप्लिकेशन CommandLineRunner के साथ
- **FoundryLocalService.java** - सेवा जो OpenAI Java SDK का उपयोग करके Foundry Local के साथ संवाद करती है
- **OpenAI Java SDK** का उपयोग टाइप-सुरक्षित API कॉल्स के लिए
- SDK द्वारा स्वचालित JSON सीरियलाइज़ेशन/डिसीरियलाइज़ेशन
- Spring के `@Value` और `@PostConstruct` एनोटेशन का उपयोग करके साफ़ कॉन्फ़िगरेशन

## कोड हाइलाइट्स

### OpenAI Java SDK एकीकरण

एप्लिकेशन OpenAI Java SDK का उपयोग करके एक क्लाइंट बनाता है जो Foundry Local के लिए कॉन्फ़िगर किया गया है:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### चैट पूर्णता API

चैट पूर्णता अनुरोध करना सरल और टाइप-सुरक्षित है:

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

यदि आपको कनेक्शन त्रुटियाँ दिखाई देती हैं:
1. सुनिश्चित करें कि Foundry Local `http://localhost:5273` पर चल रहा है
2. जांचें कि Phi-3.5-mini मॉडल वेरिएंट `foundry model list` के साथ उपलब्ध है
3. सुनिश्चित करें कि `application.properties` में मॉडल का नाम उपलब्ध मॉडल नाम से मेल खाता है
4. सुनिश्चित करें कि कोई फ़ायरवॉल कनेक्शन को ब्लॉक नहीं कर रहा है

सामान्य समस्याएँ:
- **मॉडल नहीं मिला**: `foundry model run phi-3.5-mini` चलाकर मॉडल डाउनलोड और शुरू करें
- **सेवा नहीं चल रही**: Foundry Local सेवा बंद हो सकती है; इसे मॉडल रन कमांड के साथ पुनः शुरू करें
- **गलत मॉडल नाम**: उपलब्ध मॉडलों को देखने और अपनी कॉन्फ़िगरेशन को अपडेट करने के लिए `foundry model list` का उपयोग करें

**अस्वीकरण**:  
यह दस्तावेज़ AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) का उपयोग करके अनुवादित किया गया है। जबकि हम सटीकता के लिए प्रयासरत हैं, कृपया ध्यान दें कि स्वचालित अनुवाद में त्रुटियां या अशुद्धियां हो सकती हैं। मूल भाषा में उपलब्ध मूल दस्तावेज़ को प्रामाणिक स्रोत माना जाना चाहिए। महत्वपूर्ण जानकारी के लिए, पेशेवर मानव अनुवाद की सिफारिश की जाती है। इस अनुवाद के उपयोग से उत्पन्न किसी भी गलतफहमी या गलत व्याख्या के लिए हम उत्तरदायी नहीं हैं।