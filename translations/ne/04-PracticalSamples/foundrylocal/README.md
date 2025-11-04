<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "fe08a184d8a753a0f497673921f77759",
  "translation_date": "2025-11-04T06:44:12+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "ne"
}
-->
# Foundry Local Spring Boot ट्यूटोरियल

## सामग्री तालिका

- [पूर्व आवश्यकताहरू](../../../../04-PracticalSamples/foundrylocal)
- [प्रोजेक्ट अवलोकन](../../../../04-PracticalSamples/foundrylocal)
- [कोड बुझ्दै](../../../../04-PracticalSamples/foundrylocal)
  - [१. एप्लिकेशन कन्फिगरेसन (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [२. मुख्य एप्लिकेशन क्लास (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [३. एआई सेवा तह (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [४. प्रोजेक्ट निर्भरता (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [सबै कुरा कसरी सँगै काम गर्छ](../../../../04-PracticalSamples/foundrylocal)
- [Foundry Local सेटअप गर्दै](../../../../04-PracticalSamples/foundrylocal)
- [एप्लिकेशन चलाउँदै](../../../../04-PracticalSamples/foundrylocal)
- [अपेक्षित आउटपुट](../../../../04-PracticalSamples/foundrylocal)
- [अर्को चरणहरू](../../../../04-PracticalSamples/foundrylocal)
- [समस्या समाधान](../../../../04-PracticalSamples/foundrylocal)

## पूर्व आवश्यकताहरू

यो ट्यूटोरियल सुरु गर्नु अघि, सुनिश्चित गर्नुहोस् कि तपाईंसँग:

- **Java 21 वा उच्च संस्करण** तपाईंको प्रणालीमा स्थापना गरिएको छ
- **Maven 3.6+** प्रोजेक्ट निर्माणको लागि
- **Foundry Local** स्थापना गरिएको र चलिरहेको छ

### **Foundry Local स्थापना गर्नुहोस्:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```


## प्रोजेक्ट अवलोकन

यो प्रोजेक्ट चार मुख्य घटकहरूमा विभाजित छ:

1. **Application.java** - मुख्य Spring Boot एप्लिकेशनको प्रवेश बिन्दु
2. **FoundryLocalService.java** - एआईसँगको संचारको लागि सेवा तह
3. **application.properties** - Foundry Local कनेक्शनको लागि कन्फिगरेसन
4. **pom.xml** - Maven निर्भरता र प्रोजेक्ट कन्फिगरेसन

## कोड बुझ्दै

### १. एप्लिकेशन कन्फिगरेसन (application.properties)

**फाइल:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```


**यसले के गर्छ:**
- **base-url**: Foundry Local कहाँ चलिरहेको छ भनेर निर्दिष्ट गर्दछ, `/v1` बाट OpenAI API अनुकूलता सुनिश्चित गर्दै। **नोट**: Foundry Local ले पोर्टलाई गतिशील रूपमा असाइन गर्छ, त्यसैले `foundry service status` प्रयोग गरेर वास्तविक पोर्ट जाँच गर्नुहोस्।
- **model**: टेक्स्ट जेनेरेशनको लागि प्रयोग हुने एआई मोडेलको नाम र संस्करण नम्बर निर्दिष्ट गर्दछ (जस्तै, `:1`)। उपलब्ध मोडेलहरूको सटीक आईडी हेर्न `foundry model list` प्रयोग गर्नुहोस्।

**मुख्य अवधारणा:** Spring Boot ले यी गुणहरू स्वचालित रूपमा लोड गर्छ र `@Value` एनोटेसन प्रयोग गरेर तपाईंको एप्लिकेशनमा उपलब्ध गराउँछ।

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
- `@SpringBootApplication` Spring Boot को स्वचालित कन्फिगरेसन सक्षम बनाउँछ।
- `WebApplicationType.NONE` Spring लाई यो कमाण्ड-लाइन एप्लिकेशन हो भनेर बताउँछ, वेब सर्भर होइन।
- मुख्य मेथडले Spring एप्लिकेशन सुरु गर्छ।

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
- `@Bean` Spring द्वारा व्यवस्थापन गरिने कम्पोनेन्ट सिर्जना गर्छ।
- `CommandLineRunner` Spring Boot सुरु भएपछि कोड चलाउँछ।
- `foundryLocalService` Spring द्वारा स्वचालित रूपमा इन्जेक्ट गरिन्छ (निर्भरता इन्जेक्शन)।
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
- `@Service` Spring लाई यो क्लासले व्यापारिक तर्क प्रदान गर्छ भनेर बताउँछ।
- `@Value` application.properties बाट कन्फिगरेसन मानहरू इन्जेक्ट गर्छ।
- `:default-value` सिन्ट्याक्सले गुणहरू सेट नभएको अवस्थामा फालब्याक मानहरू प्रदान गर्छ।

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
- `@PostConstruct` Spring ले सेवा सिर्जना गरेपछि यो मेथड चलाउँछ।
- OpenAI क्लाइन्ट सिर्जना गर्छ जुन तपाईंको स्थानीय Foundry Local इन्स्ट्यान्समा जोडिन्छ।
- `application.properties` बाट base URL पहिले नै `/v1` समावेश गर्दछ OpenAI API अनुकूलताको लागि।
- एपीआई कुञ्जी "not-needed" मा सेट गरिएको छ किनभने स्थानीय विकासले प्रमाणीकरण आवश्यक पर्दैन।

#### च्याट मेथड:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Which AI model to use
                .addUserMessage(message)         // Your question/prompt
                .maxCompletionTokens(150)        // Limit response length
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
  - `model`: प्रयोग गर्नुपर्ने एआई मोडेल निर्दिष्ट गर्छ (Foundry Local मा उपलब्ध मोडेलको सटीक आईडी मिल्नुपर्छ)।
  - `addUserMessage`: सन्देशलाई कुराकानीमा थप्छ।
  - `maxCompletionTokens`: प्रतिक्रिया कति लामो हुन सक्छ सीमित गर्छ (स्रोत बचत गर्न)।
  - `temperature`: अनियमितता नियन्त्रण गर्छ (०.० = निश्चित, १.० = रचनात्मक)।
- **API Call**: अनुरोध Foundry Local मा पठाउँछ।
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
- **spring-boot-starter**: मुख्य Spring Boot कार्यक्षमता प्रदान गर्छ।
- **openai-java**: API संचारको लागि आधिकारिक OpenAI Java SDK।
- **jackson-databind**: API कलहरूको लागि JSON सिरियलाइजेसन/डिसिरियलाइजेसन ह्यान्डल गर्छ।

## सबै कुरा कसरी सँगै काम गर्छ

जब तपाईं एप्लिकेशन चलाउनुहुन्छ, यहाँ सम्पूर्ण प्रक्रिया छ:

1. **सुरु:** Spring Boot सुरु हुन्छ र `application.properties` पढ्छ।
2. **सेवा सिर्जना:** Spring `FoundryLocalService` सिर्जना गर्छ र कन्फिगरेसन मानहरू इन्जेक्ट गर्छ।
3. **क्लाइन्ट सेटअप:** `@PostConstruct` OpenAI क्लाइन्टलाई Foundry Local मा जोड्न इनिसियलाइज गर्छ।
4. **डेमो कार्यान्वयन:** `CommandLineRunner` सुरु भएपछि कार्यान्वयन हुन्छ।
5. **एआई कल:** डेमोले परीक्षण सन्देशसहित `foundryLocalService.chat()` कल गर्छ।
6. **API अनुरोध:** सेवा OpenAI अनुरूप अनुरोध निर्माण गर्छ र Foundry Local मा पठाउँछ।
7. **प्रतिक्रिया प्रक्रिया:** सेवा प्रतिक्रिया निकाल्छ र फर्काउँछ।
8. **प्रदर्शन:** एप्लिकेशन प्रतिक्रिया प्रिन्ट गर्छ र बन्द हुन्छ।

## Foundry Local सेटअप गर्दै

Foundry Local सेटअप गर्न, यी चरणहरू पालना गर्नुहोस्:

1. **Foundry Local स्थापना गर्नुहोस्** [पूर्व आवश्यकताहरू](../../../../04-PracticalSamples/foundrylocal) खण्डमा दिइएको निर्देशनहरू प्रयोग गरेर।

2. **गतिशील रूपमा असाइन गरिएको पोर्ट जाँच गर्नुहोस्।** Foundry Local सुरु हुँदा स्वचालित रूपमा पोर्ट असाइन गर्छ। तपाईंको पोर्ट पत्ता लगाउन:
   ```bash
   foundry service status
   ```
   
   **वैकल्पिक:** यदि तपाईं विशिष्ट पोर्ट (जस्तै, ५२७३) प्रयोग गर्न चाहनुहुन्छ भने, तपाईं यसलाई म्यानुअली कन्फिगर गर्न सक्नुहुन्छ:
   ```bash
   foundry service set --port 5273
   ```


3. **एआई मोडेल डाउनलोड गर्नुहोस्** जुन तपाईं प्रयोग गर्न चाहनुहुन्छ, उदाहरणका लागि, `phi-3.5-mini`, निम्न कमाण्ड प्रयोग गरेर:
   ```bash
   foundry model run phi-3.5-mini
   ```


4. **application.properties फाइल कन्फिगर गर्नुहोस्** तपाईंको Foundry Local सेटिङसँग मिलाउन:
   - `base-url` मा पोर्ट अपडेट गर्नुहोस् (चरण २ बाट), सुनिश्चित गर्दै कि यसमा `/v1` अन्त्यमा समावेश छ।
   - मोडेल नाम संस्करण नम्बर सहित अपडेट गर्नुहोस् (`foundry model list` प्रयोग गरेर जाँच गर्नुहोस्)।

   उदाहरण:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```


## एप्लिकेशन चलाउँदै

### चरण १: Foundry Local सुरु गर्नुहोस्
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


## अर्को चरणहरू

थप उदाहरणहरूको लागि, [Chapter 04: Practical samples](../README.md) हेर्नुहोस्।

## समस्या समाधान

### सामान्य समस्याहरू

**"Connection refused" वा "Service unavailable"**
- सुनिश्चित गर्नुहोस् Foundry Local चलिरहेको छ: `foundry model list`
- Foundry Local ले प्रयोग गरिरहेको वास्तविक पोर्ट जाँच गर्नुहोस्: `foundry service status`
- तपाईंको `application.properties` मा सही पोर्ट अपडेट गर्नुहोस्, सुनिश्चित गर्दै कि URL `/v1` मा समाप्त हुन्छ।
- वैकल्पिक रूपमा, विशिष्ट पोर्ट सेट गर्नुहोस् यदि चाहिन्छ: `foundry service set --port 5273`
- Foundry Local पुनः सुरु गर्न प्रयास गर्नुहोस्: `foundry model run phi-3.5-mini`

**"Model not found" वा "404 Not Found" त्रुटिहरू**
- उपलब्ध मोडेलहरूको सटीक आईडी जाँच गर्नुहोस्: `foundry model list`
- `application.properties` मा मोडेल नाम सटीक रूपमा अपडेट गर्नुहोस्, संस्करण नम्बर सहित (जस्तै, `Phi-3.5-mini-instruct-cuda-gpu:1`)।
- सुनिश्चित गर्नुहोस् `base-url` `/v1` मा समाप्त हुन्छ: `http://localhost:5273/v1`
- आवश्यक भएमा मोडेल डाउनलोड गर्नुहोस्: `foundry model run phi-3.5-mini`

**"400 Bad Request" त्रुटिहरू**
- सुनिश्चित गर्नुहोस् base URL `/v1` समावेश गर्दछ: `http://localhost:5273/v1`
- मोडेल आईडी सटीक रूपमा मिल्छ भनेर जाँच गर्नुहोस् जुन `foundry model list` मा देखाइएको छ।
- सुनिश्चित गर्नुहोस् तपाईंको कोडमा `maxCompletionTokens()` प्रयोग भइरहेको छ (पुरानो `maxTokens()` होइन)।

**Maven कम्पाइल त्रुटिहरू**
- सुनिश्चित गर्नुहोस् Java 21 वा उच्च संस्करण: `java -version`
- सफा गर्नुहोस् र पुनः निर्माण गर्नुहोस्: `mvn clean compile`
- निर्भरता डाउनलोडको लागि इन्टरनेट कनेक्शन जाँच गर्नुहोस्।

**एप्लिकेशन सुरु हुन्छ तर कुनै आउटपुट छैन**
- सुनिश्चित गर्नुहोस् Foundry Local प्रतिक्रिया दिइरहेको छ: ब्राउजर खोल्नुहोस् `http://localhost:5273`
- एप्लिकेशन लगहरूमा विशिष्ट त्रुटि सन्देशहरू जाँच गर्नुहोस्।
- सुनिश्चित गर्नुहोस् मोडेल पूर्ण रूपमा लोड भएको छ र तयार छ।

---

**अस्वीकरण**:  
यो दस्तावेज़ AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) प्रयोग गरेर अनुवाद गरिएको छ। हामी शुद्धताको लागि प्रयास गर्छौं, तर कृपया ध्यान दिनुहोस् कि स्वचालित अनुवादमा त्रुटिहरू वा अशुद्धताहरू हुन सक्छ। यसको मूल भाषा मा रहेको दस्तावेज़लाई आधिकारिक स्रोत मानिनुपर्छ। महत्वपूर्ण जानकारीको लागि, व्यावसायिक मानव अनुवाद सिफारिस गरिन्छ। यस अनुवादको प्रयोगबाट उत्पन्न हुने कुनै पनि गलतफहमी वा गलत व्याख्याको लागि हामी जिम्मेवार हुने छैनौं।