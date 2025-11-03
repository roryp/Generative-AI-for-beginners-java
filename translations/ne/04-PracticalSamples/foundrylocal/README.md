<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "713d81fd7d28a865068df047e26c8f12",
  "translation_date": "2025-11-03T20:03:44+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "ne"
}
-->
# फाउन्ड्री लोकल स्प्रिंग बूट ट्युटोरियल

## सामग्री तालिका

- [पूर्व आवश्यकताहरू](../../../../04-PracticalSamples/foundrylocal)
- [प्रोजेक्टको अवलोकन](../../../../04-PracticalSamples/foundrylocal)
- [कोडको समझ](../../../../04-PracticalSamples/foundrylocal)
  - [१. एप्लिकेशन कन्फिगरेसन (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [२. मुख्य एप्लिकेशन क्लास (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [३. एआई सेवा तह (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [४. प्रोजेक्ट निर्भरता (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [सबै कुरा कसरी सँगै काम गर्छ](../../../../04-PracticalSamples/foundrylocal)
- [फाउन्ड्री लोकल सेटअप गर्नुहोस्](../../../../04-PracticalSamples/foundrylocal)
- [एप्लिकेशन चलाउनुहोस्](../../../../04-PracticalSamples/foundrylocal)
- [अपेक्षित आउटपुट](../../../../04-PracticalSamples/foundrylocal)
- [अर्को कदमहरू](../../../../04-PracticalSamples/foundrylocal)
- [समस्या समाधान](../../../../04-PracticalSamples/foundrylocal)

## पूर्व आवश्यकताहरू

यो ट्युटोरियल सुरु गर्नु अघि, सुनिश्चित गर्नुहोस् कि तपाईंसँग:

- **Java 21 वा उच्च संस्करण** तपाईंको प्रणालीमा स्थापना भएको छ
- **Maven 3.6+** प्रोजेक्ट निर्माणको लागि
- **Foundry Local** स्थापना गरिएको र चलिरहेको छ

### **फाउन्ड्री लोकल स्थापना गर्नुहोस्:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```

## प्रोजेक्टको अवलोकन

यो प्रोजेक्ट चार मुख्य कम्पोनेन्टहरू समावेश गर्दछ:

1. **Application.java** - मुख्य स्प्रिंग बूट एप्लिकेशन प्रवेश बिन्दु
2. **FoundryLocalService.java** - सेवा तह जसले एआई संचारलाई व्यवस्थापन गर्छ
3. **application.properties** - फाउन्ड्री लोकल कनेक्शनको लागि कन्फिगरेसन
4. **pom.xml** - Maven निर्भरता र प्रोजेक्ट कन्फिगरेसन

## कोडको समझ

### १. एप्लिकेशन कन्फिगरेसन (application.properties)

**फाइल:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```

**यसले के गर्छ:**
- **base-url**: फाउन्ड्री लोकल कहाँ चलिरहेको छ भनेर निर्दिष्ट गर्दछ, `/v1` पथ सहित OpenAI API अनुकूलताको लागि। **नोट**: फाउन्ड्री लोकलले पोर्टलाई गतिशील रूपमा असाइन गर्दछ, त्यसैले `foundry service status` प्रयोग गरेर तपाईंको वास्तविक पोर्ट जाँच गर्नुहोस्।
- **model**: टेक्स्ट जेनेरेसनको लागि प्रयोग गर्न AI मोडेलको नाम निर्दिष्ट गर्दछ, संस्करण नम्बर सहित (जस्तै, `:1`)। उपलब्ध मोडेलहरू र तिनीहरूको सटीक आईडीहरू हेर्न `foundry model list` प्रयोग गर्नुहोस्।

**मुख्य अवधारणा:** स्प्रिंग बूटले यी गुणहरू स्वचालित रूपमा लोड गर्दछ र `@Value` एनोटेसन प्रयोग गरेर तपाईंको एप्लिकेशनमा उपलब्ध गराउँछ।

### २. मुख्य एप्लिकेशन क्लास (Application.java)

**फाइल:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```

**यसले के गर्छ:**
- `@SpringBootApplication` स्प्रिंग बूट स्वतः-कन्फिगरेसन सक्षम बनाउँछ।
- `WebApplicationType.NONE` स्प्रिंगलाई यो कमाण्ड-लाइन एप हो भनेर बताउँछ, वेब सर्भर होइन।
- मुख्य मेथडले स्प्रिंग एप्लिकेशन सुरु गर्छ।

**डेमो रनर:**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
    };
}
```

**यसले के गर्छ:**
- `@Bean` स्प्रिंगले व्यवस्थापन गर्ने कम्पोनेन्ट सिर्जना गर्छ।
- `CommandLineRunner` स्प्रिंग बूट सुरु भएपछि कोड चलाउँछ।
- `foundryLocalService` स्प्रिंगले स्वचालित रूपमा इन्जेक्ट गर्छ (निर्भरता इन्जेक्शन)।
- एआईलाई परीक्षण सन्देश पठाउँछ र प्रतिक्रिया देखाउँछ।

### ३. एआई सेवा तह (FoundryLocalService.java)

**फाइल:** `src/main/java/com/example/FoundryLocalService.java`

#### कन्फिगरेसन इन्जेक्शन:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```

**यसले के गर्छ:**
- `@Service` स्प्रिंगलाई यो क्लासले व्यापारिक तर्क प्रदान गर्छ भनेर बताउँछ।
- `@Value` एप्लिकेशन.properties बाट कन्फिगरेसन मानहरू इन्जेक्ट गर्छ।
- `:default-value` सिन्ट्याक्सले गुणहरू सेट नभएमा फालब्याक मानहरू प्रदान गर्छ।

#### क्लाइन्ट इनिसियलाइजेसन:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```

**यसले के गर्छ:**
- `@PostConstruct` स्प्रिंगले सेवा सिर्जना गरेपछि यो मेथड चलाउँछ।
- OpenAI क्लाइन्ट सिर्जना गर्छ जुन तपाईंको स्थानीय फाउन्ड्री लोकल इन्स्ट्यान्समा जोडिन्छ।
- एप्लिकेशन.properties बाट बेस URL पहिले नै OpenAI API अनुकूलताको लागि `/v1` समावेश गर्दछ।
- एपीआई कुञ्जी "not-needed" सेट गरिएको छ किनभने स्थानीय विकासले प्रमाणीकरण आवश्यक पर्दैन।

#### च्याट मेथड:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Which AI model to use
                .addUserMessage(message)         // Your question/prompt
                .maxTokens(150)                  // Limit response length
                .temperature(0.7)                // Control creativity (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Extract the AI's response from the API result
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**यसले के गर्छ:**
- **ChatCompletionCreateParams**: एआई अनुरोध कन्फिगर गर्छ।
  - `model`: कुन एआई मोडेल प्रयोग गर्ने भनेर निर्दिष्ट गर्छ (फाउन्ड्री मोडेल सूचीबाट सटीक आईडी मिल्नुपर्छ)।
  - `addUserMessage`: सन्देशलाई कुराकानीमा थप्छ।
  - `maxTokens`: प्रतिक्रिया कति लामो हुन सक्छ सीमित गर्छ (स्रोत बचत गर्छ)।
  - `temperature`: अनियमितता नियन्त्रण गर्छ (0.0 = निर्धारणात्मक, 1.0 = रचनात्मक)।
- **API Call**: अनुरोध फाउन्ड्री लोकलमा पठाउँछ।
- **Response Handling**: एआईको टेक्स्ट प्रतिक्रिया सुरक्षित रूपमा निकाल्छ।
- **Error Handling**: सहायक त्रुटि सन्देशहरू सहित अपवादहरू समेट्छ।

### ४. प्रोजेक्ट निर्भरता (pom.xml)

**मुख्य निर्भरता:**

```xml
<!-- Spring Boot - Application framework -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <version>${spring-boot.version}</version>
</dependency>

<!-- OpenAI Java SDK - For AI API calls -->
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>

<!-- Jackson - JSON processing -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.0</version>
</dependency>
```

**यसले के गर्छ:**
- **spring-boot-starter**: कोर स्प्रिंग बूट कार्यक्षमता प्रदान गर्छ।
- **openai-java**: API संचारको लागि आधिकारिक OpenAI Java SDK।
- **jackson-databind**: API कलहरूको लागि JSON सिरियलाइजेसन/डिसिरियलाइजेसन व्यवस्थापन गर्छ।

## सबै कुरा कसरी सँगै काम गर्छ

जब तपाईं एप्लिकेशन चलाउनुहुन्छ, यहाँ पूर्ण प्रवाह छ:

1. **सुरु:** स्प्रिंग बूट सुरु हुन्छ र `application.properties` पढ्छ।
2. **सेवा सिर्जना:** स्प्रिंगले `FoundryLocalService` सिर्जना गर्छ र कन्फिगरेसन मानहरू इन्जेक्ट गर्छ।
3. **क्लाइन्ट सेटअप:** `@PostConstruct` OpenAI क्लाइन्टलाई फाउन्ड्री लोकलमा जोड्न इनिसियलाइज गर्छ।
4. **डेमो कार्यान्वयन:** `CommandLineRunner` सुरु भएपछि कार्यान्वयन गर्छ।
5. **एआई कल:** डेमोले परीक्षण सन्देशसहित `foundryLocalService.chat()` कल गर्छ।
6. **API अनुरोध:** सेवा OpenAI-संगत अनुरोध फाउन्ड्री लोकलमा निर्माण र पठाउँछ।
7. **प्रतिक्रिया प्रशोधन:** सेवा प्रतिक्रिया निकाल्छ र फर्काउँछ।
8. **प्रदर्शन:** एप्लिकेशनले प्रतिक्रिया प्रिन्ट गर्छ र बाहिरिन्छ।

## फाउन्ड्री लोकल सेटअप गर्नुहोस्

फाउन्ड्री लोकल सेटअप गर्न, यी चरणहरू पालना गर्नुहोस्:

1. **फाउन्ड्री लोकल स्थापना गर्नुहोस्** [पूर्व आवश्यकताहरू](../../../../04-PracticalSamples/foundrylocal) खण्डमा दिइएको निर्देशनहरू प्रयोग गरेर।

2. **गतिशील रूपमा असाइन गरिएको पोर्ट जाँच गर्नुहोस्।** फाउन्ड्री लोकलले सुरु हुँदा पोर्ट स्वचालित रूपमा असाइन गर्छ। तपाईंको पोर्ट फेला पार्न:
   ```bash
   foundry service status
   ```
   
   **वैकल्पिक:** यदि तपाईं विशिष्ट पोर्ट (जस्तै, 5273) प्रयोग गर्न चाहनुहुन्छ भने, तपाईं यसलाई म्यानुअली कन्फिगर गर्न सक्नुहुन्छ:
   ```bash
   foundry service set --port 5273
   ```

3. **एआई मोडेल डाउनलोड गर्नुहोस्** जुन तपाईं प्रयोग गर्न चाहनुहुन्छ, उदाहरणका लागि, `phi-3.5-mini`, निम्न कमाण्ड प्रयोग गरेर:
   ```bash
   foundry model run phi-3.5-mini
   ```

4. **application.properties फाइल कन्फिगर गर्नुहोस्** तपाईंको फाउन्ड्री लोकल सेटिङ्ससँग मेल खाने:
   - `base-url` मा पोर्ट अपडेट गर्नुहोस् (चरण २ बाट), सुनिश्चित गर्दै कि यसमा `/v1` अन्त्यमा समावेश छ।
   - मोडेल नाम संस्करण नम्बर सहित अपडेट गर्नुहोस् (`foundry model list` प्रयोग गरेर जाँच गर्नुहोस्)।

   उदाहरण:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```

## एप्लिकेशन चलाउनुहोस्

### चरण १: फाउन्ड्री लोकल सुरु गर्नुहोस्
```bash
foundry model run phi-3.5-mini
```

### चरण २: एप्लिकेशन निर्माण र चलाउनुहोस्
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## अपेक्षित आउटपुट

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi-3.5, a small language model created by Microsoft. I'm currently running 
as the Phi-3.5-mini-instruct model, which is designed to be helpful, harmless, and honest 
in my interactions. I can assist with a wide variety of tasks including answering 
questions, helping with analysis, creative writing, coding, and general conversation. 
Is there something specific you'd like help with today?
=========================
```

## अर्को कदमहरू

थप उदाहरणहरूको लागि, [अध्याय ०४: व्यावहारिक नमूनाहरू](../README.md) हेर्नुहोस्।

## समस्या समाधान

### सामान्य समस्याहरू

**"Connection refused" वा "Service unavailable"**
- सुनिश्चित गर्नुहोस् कि फाउन्ड्री लोकल चलिरहेको छ: `foundry model list`
- फाउन्ड्री लोकलले प्रयोग गरिरहेको वास्तविक पोर्ट जाँच गर्नुहोस्: `foundry service status`
- तपाईंको `application.properties` सही पोर्टसँग अपडेट गर्नुहोस्, सुनिश्चित गर्दै कि URL `/v1` अन्त्यमा समावेश छ।
- वैकल्पिक रूपमा, यदि चाहनुहुन्छ भने विशिष्ट पोर्ट सेट गर्नुहोस्: `foundry service set --port 5273`
- फाउन्ड्री लोकल पुनः सुरु गर्न प्रयास गर्नुहोस्: `foundry model run phi-3.5-mini`

**"Model not found" वा "404 Not Found" त्रुटिहरू**
- उपलब्ध मोडेलहरू र तिनीहरूको सटीक आईडीहरू जाँच गर्नुहोस्: `foundry model list`
- एप्लिकेशन.properties मा मोडेल नाम सटीक रूपमा अपडेट गर्नुहोस्, संस्करण नम्बर सहित (जस्तै, `Phi-3.5-mini-instruct-cuda-gpu:1`)
- सुनिश्चित गर्नुहोस् कि `base-url` अन्त्यमा `/v1` समावेश छ: `http://localhost:5273/v1`
- आवश्यक भएमा मोडेल डाउनलोड गर्नुहोस्: `foundry model run phi-3.5-mini`

**"400 Bad Request" त्रुटिहरू**
- सुनिश्चित गर्नुहोस् कि बेस URL `/v1` समावेश छ: `http://localhost:5273/v1`
- मोडेल आईडी फाउन्ड्री मोडेल सूचीमा देखिएको सटीकसँग मेल खान्छ भनेर जाँच गर्नुहोस्।
- तपाईंको कोडमा `maxCompletionTokens()` सट्टा `maxTokens()` प्रयोग गर्दै हुनुहुन्छ भनेर सुनिश्चित गर्नुहोस्।

**Maven कम्पाइल त्रुटिहरू**
- सुनिश्चित गर्नुहोस् कि Java 21 वा उच्च संस्करण छ: `java -version`
- सफा र पुनः निर्माण गर्नुहोस्: `mvn clean compile`
- निर्भरता डाउनलोडको लागि इन्टरनेट कनेक्शन जाँच गर्नुहोस्।

**एप्लिकेशन सुरु हुन्छ तर कुनै आउटपुट छैन**
- सुनिश्चित गर्नुहोस् कि फाउन्ड्री लोकल प्रतिक्रिया दिइरहेको छ: `http://localhost:5273` मा ब्राउजर खोल्नुहोस्।
- विशिष्ट त्रुटि सन्देशहरूको लागि एप्लिकेशन लगहरू जाँच गर्नुहोस्।
- सुनिश्चित गर्नुहोस् कि मोडेल पूर्ण रूपमा लोड गरिएको छ र तयार छ।

---

**अस्वीकरण**:  
यो दस्तावेज़ AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) प्रयोग गरेर अनुवाद गरिएको छ। हामी शुद्धताको लागि प्रयास गर्छौं, तर कृपया ध्यान दिनुहोस् कि स्वचालित अनुवादमा त्रुटिहरू वा अशुद्धताहरू हुन सक्छ। यसको मूल भाषा मा रहेको दस्तावेज़लाई आधिकारिक स्रोत मानिनुपर्छ। महत्वपूर्ण जानकारीको लागि, व्यावसायिक मानव अनुवाद सिफारिस गरिन्छ। यस अनुवादको प्रयोगबाट उत्पन्न हुने कुनै पनि गलतफहमी वा गलत व्याख्याको लागि हामी जिम्मेवार हुने छैनौं।