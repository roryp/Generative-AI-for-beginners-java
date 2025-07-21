<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T18:14:29+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "ne"
}
-->
# फाउन्ड्री लोकल कमाण्ड-लाइन एप्लिकेसन

>**नोट**: यो अध्यायमा [**ट्युटोरियल**](./TUTORIAL.md) समावेश छ, जसले तपाईंलाई तयार गरिएको नमूनाहरू चलाउन मार्गदर्शन गर्दछ।

एक साधारण स्प्रिङ बुट कमाण्ड-लाइन एप्लिकेसन जसले OpenAI Java SDK प्रयोग गरेर फाउन्ड्री लोकलसँग कसरी जडान गर्ने भनेर देखाउँछ।

## तपाईंले के सिक्नुहुनेछ

- OpenAI Java SDK प्रयोग गरेर फाउन्ड्री लोकललाई स्प्रिङ बुट एप्लिकेसनहरूसँग कसरी एकीकृत गर्ने
- स्थानीय AI विकास र परीक्षणका लागि उत्तम अभ्यासहरू

## सामग्री तालिका

- [तपाईंले के सिक्नुहुनेछ](../../../../04-PracticalSamples/foundrylocal)
- [पूर्वआवश्यकताहरू](../../../../04-PracticalSamples/foundrylocal)
  - [फाउन्ड्री लोकल इन्स्टल गर्दै](../../../../04-PracticalSamples/foundrylocal)
  - [प्रमाणीकरण](../../../../04-PracticalSamples/foundrylocal)
- [कन्फिगरेसन](../../../../04-PracticalSamples/foundrylocal)
- [छिटो सुरु](../../../../04-PracticalSamples/foundrylocal)
- [एप्लिकेसनले के गर्छ](../../../../04-PracticalSamples/foundrylocal)
- [नमूना आउटपुट](../../../../04-PracticalSamples/foundrylocal)
- [आर्किटेक्चर](../../../../04-PracticalSamples/foundrylocal)
- [कोड हाइलाइट्स](../../../../04-PracticalSamples/foundrylocal)
  - [OpenAI Java SDK एकीकरण](../../../../04-PracticalSamples/foundrylocal)
  - [च्याट कम्प्लिसन API](../../../../04-PracticalSamples/foundrylocal)
- [समस्या समाधान](../../../../04-PracticalSamples/foundrylocal)

## पूर्वआवश्यकताहरू

> **⚠️ नोट**: यो एप्लिकेसन **प्रदान गरिएको डिभकन्टेनरमा चल्दैन**, किनभने यसलाई फाउन्ड्री लोकललाई होस्ट सिस्टममा इन्स्टल र चलाउन आवश्यक छ।

### फाउन्ड्री लोकल इन्स्टल गर्दै

यो एप्लिकेसन चलाउनु अघि, तपाईंले फाउन्ड्री लोकल इन्स्टल र सुरु गर्नुपर्नेछ। यी चरणहरू पालना गर्नुहोस्:

1. **तपाईंको प्रणाली आवश्यकताहरू पूरा भएको सुनिश्चित गर्नुहोस्**:
   - **अपरेटिङ सिस्टम**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025, वा macOS
   - **हार्डवेयर**: 
     - न्यूनतम: 8GB RAM, 3GB खाली डिस्क स्पेस
     - सिफारिस गरिएको: 16GB RAM, 15GB खाली डिस्क स्पेस
   - **नेटवर्क**: प्रारम्भिक मोडेल डाउनलोडका लागि इन्टरनेट जडान (अफलाइन प्रयोगका लागि वैकल्पिक)
   - **त्वरण (वैकल्पिक)**: NVIDIA GPU (2,000 सिरिज वा नयाँ), AMD GPU (6,000 सिरिज वा नयाँ), Qualcomm Snapdragon X Elite (8GB वा बढी मेमोरी), वा Apple सिलिकन
   - **अनुमतिहरू**: तपाईंको उपकरणमा सफ्टवेयर इन्स्टल गर्न प्रशासकीय विशेषाधिकार

2. **फाउन्ड्री लोकल इन्स्टल गर्नुहोस्**:
   
   **Windows का लागि:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **macOS का लागि:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   वैकल्पिक रूपमा, तपाईं [फाउन्ड्री लोकल GitHub रिपोजिटरी](https://github.com/microsoft/Foundry-Local) बाट इन्स्टलर डाउनलोड गर्न सक्नुहुन्छ।

3. **आफ्नो पहिलो मोडेल सुरु गर्नुहोस्**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   मोडेल डाउनलोड हुन्छ (जसमा तपाईंको इन्टरनेट स्पीड अनुसार केही मिनेट लाग्न सक्छ) र त्यसपछि चल्छ। फाउन्ड्री लोकलले तपाईंको प्रणालीका लागि उत्तम मोडेल भेरियन्ट (NVIDIA GPU का लागि CUDA, अन्यथा CPU संस्करण) स्वचालित रूपमा चयन गर्दछ।

4. **मोडेल परीक्षण गर्नुहोस्** सोही टर्मिनलमा प्रश्न सोधेर:

   ```bash
   Why is the sky blue?
   ```

   तपाईंले Phi मोडेलबाट आकाश निलो देखिने कारणको व्याख्या गर्ने प्रतिक्रिया देख्नु पर्नेछ।

### प्रमाणीकरण

तपाईं यी कमाण्डहरू प्रयोग गरेर सबै ठीक छ भनी प्रमाणीकरण गर्न सक्नुहुन्छ:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

तपाईं `http://localhost:5273` मा आफ्नो ब्राउजरमा गएर फाउन्ड्री लोकल वेब इन्टरफेस पनि हेर्न सक्नुहुन्छ।

## कन्फिगरेसन

एप्लिकेसनलाई `application.properties` मार्फत कन्फिगर गर्न सकिन्छ:

- `foundry.local.base-url` - फाउन्ड्री लोकलको आधार URL (डिफल्ट: http://localhost:5273)
- `foundry.local.model` - प्रयोग गर्नुपर्ने AI मोडेल (डिफल्ट: Phi-3.5-mini-instruct-cuda-gpu)

> **नोट**: कन्फिगरेसनमा मोडेल नामले फाउन्ड्री लोकलले तपाईंको प्रणालीका लागि डाउनलोड गरेको विशिष्ट भेरियन्टसँग मेल खानुपर्छ। जब तपाईं `foundry model run phi-3.5-mini` चलाउनुहुन्छ, फाउन्ड्री लोकलले स्वचालित रूपमा उत्तम भेरियन्ट चयन र डाउनलोड गर्दछ (NVIDIA GPU का लागि CUDA, अन्यथा CPU संस्करण)। तपाईंको स्थानीय इन्स्ट्यान्समा उपलब्ध ठ्याक्कै मोडेल नाम हेर्न `foundry model list` प्रयोग गर्नुहोस्।

## छिटो सुरु

### 1. फाउन्ड्री लोकल एप्लिकेसन डाइरेक्टरीमा जानुहोस्
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. एप्लिकेसन चलाउनुहोस्

```bash
mvn spring-boot:run
```

वा JAR निर्माण गरेर चलाउनुहोस्:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### निर्भरताहरू

यो एप्लिकेसनले फाउन्ड्री लोकलसँग संवाद गर्न OpenAI Java SDK प्रयोग गर्दछ। मुख्य निर्भरता हो:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

एप्लिकेसनलाई डिफल्ट पोर्टमा चलिरहेको फाउन्ड्री लोकलसँग जडान गर्न पूर्व-कन्फिगर गरिएको छ।

## एप्लिकेसनले के गर्छ

जब तपाईं एप्लिकेसन चलाउनुहुन्छ:

1. **कमाण्ड-लाइन एप्लिकेसनको रूपमा सुरु हुन्छ** (वेब सर्भर छैन)
2. **स्वचालित रूपमा एउटा परीक्षण सन्देश पठाउँछ**: "नमस्ते! के तपाईं मलाई भन्न सक्नुहुन्छ कि तपाईं के हो र कुन मोडेल चलाउँदै हुनुहुन्छ?"
3. **फाउन्ड्री लोकलबाट प्रतिक्रिया कन्सोलमा देखाउँछ**
4. **डेमोपछि सफासँग बन्द हुन्छ**

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

- **Application.java** - मुख्य स्प्रिङ बुट एप्लिकेसन CommandLineRunner सहित
- **FoundryLocalService.java** - सेवा जसले OpenAI Java SDK प्रयोग गरेर फाउन्ड्री लोकलसँग संवाद गर्छ
- **OpenAI Java SDK** प्रयोग गरेर प्रकार-सुरक्षित API कलहरू
- SDK द्वारा स्वचालित JSON सिरियलाइजेसन/डिसिरियलाइजेसन
- स्प्रिङको `@Value` र `@PostConstruct` एनोटेसनहरू प्रयोग गरेर सफा कन्फिगरेसन

## कोड हाइलाइट्स

### OpenAI Java SDK एकीकरण

एप्लिकेसनले फाउन्ड्री लोकलका लागि कन्फिगर गरिएको क्लाइन्ट बनाउन OpenAI Java SDK प्रयोग गर्दछ:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### च्याट कम्प्लिसन API

च्याट कम्प्लिसन अनुरोधहरू बनाउनु सरल र प्रकार-सुरक्षित छ:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## समस्या समाधान

यदि तपाईंले जडान त्रुटिहरू देख्नुभयो भने:
1. फाउन्ड्री लोकल `http://localhost:5273` मा चलिरहेको छ भनी सुनिश्चित गर्नुहोस्
2. `foundry model list` प्रयोग गरेर Phi-3.5-mini मोडेल भेरियन्ट उपलब्ध छ भनी जाँच गर्नुहोस्
3. `application.properties` मा मोडेल नाम ठ्याक्कै सूचीमा देखिएको मोडेल नामसँग मेल खान्छ भनी सुनिश्चित गर्नुहोस्
4. कुनै फायरवालले जडानलाई अवरोध गरेको छैन भनी सुनिश्चित गर्नुहोस्

सामान्य समस्याहरू:
- **मोडेल फेला परेन**: `foundry model run phi-3.5-mini` चलाएर मोडेल डाउनलोड र सुरु गर्नुहोस्
- **सेवा चलिरहेको छैन**: फाउन्ड्री लोकल सेवा बन्द भएको हुन सक्छ; मोडेल रन कमाण्ड प्रयोग गरेर पुन: सुरु गर्नुहोस्
- **गलत मोडेल नाम**: उपलब्ध मोडेलहरू हेर्न `foundry model list` प्रयोग गर्नुहोस् र आफ्नो कन्फिगरेसनलाई तदनुसार अद्यावधिक गर्नुहोस्

**अस्वीकरण**:  
यो दस्तावेज़ AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) प्रयोग गरेर अनुवाद गरिएको छ। हामी शुद्धताको लागि प्रयास गर्छौं, तर कृपया ध्यान दिनुहोस् कि स्वचालित अनुवादमा त्रुटिहरू वा अशुद्धताहरू हुन सक्छ। यसको मूल भाषा मा रहेको मूल दस्तावेज़लाई आधिकारिक स्रोत मानिनुपर्छ। महत्वपूर्ण जानकारीको लागि, व्यावसायिक मानव अनुवाद सिफारिस गरिन्छ। यस अनुवादको प्रयोगबाट उत्पन्न हुने कुनै पनि गलतफहमी वा गलत व्याख्याको लागि हामी जिम्मेवार हुने छैनौं।