# Foundry Local Spring Boot ट्यूटोरियल

## विषय सूची

- [पूर्वआवश्यकताहरू](#पूर्वआवश्यकताहरू)
- [परियोजना अवलोकन](#परियोजना-अवलोकन)
- [कोड बुझाइ](#कोड-बुझाइ)
  - [1. एप्लिकेशन कन्फिगरेसन (application.properties)](#1-एप्लिकेशन-कन्फिगरेसन-applicationproperties)
  - [2. मुख्य एप्लिकेशन क्लास (Application.java)](#2-मुख्य-एप्लिकेशन-क्लास-applicationjava)
  - [3. AI सेवा तह (FoundryLocalService.java)](#3-ai-सेवा-तह-foundrylocalservicejava)
  - [4. परियोजना निर्भरताहरू (pom.xml)](#4-परियोजना-निर्भरताहरू-pomxml)
- [सबै कुरा कसरी सँगै काम गर्छ](#सबै-कुरा-कसरी-सँगै-काम-गर्छ)
- [Foundry Local सेटअप गर्ने तरिका](#foundry-local-सेटअप-गर्ने-तरिका)
- [एप्लिकेशन चलाउने तरिका](#एप्लिकेशन-चलाउने-तरिका)
- [अपेक्षित आउटपुट](#अपेक्षित-आउटपुट)
- [अगाडि के गर्ने](#अगाडि-के-गर्ने)
- [समस्या समाधान](#समस्या-समाधान)


## पूर्वआवश्यकताहरू

यो ट्यूटोरियल सुरु गर्नुअघि, सुनिश्चित गर्नुहोस् तपाईंले:

- **Java 21 वा माथि** आफ्नो सिस्टममा स्थापना गरेको छ
- **Maven 3.6+** परियोजना बिल्ड गर्नका लागि
- **Foundry Local** स्थापना गरिएको र चलिरहेको छ

### **Foundry Local इन्स्टल गर्ने तरिका:**

> **नोट:** Foundry Local CLI केवल **Windows** र **macOS** मा उपलब्ध छ। Linux का लागि [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust) मार्फत समर्थन छ।

```bash
# विन्डोज
winget install Microsoft.FoundryLocal

# म्याकओएस
brew tap microsoft/foundrylocal
brew install foundrylocal
```

इन्स्टलेसन पुष्टि गर्नुहोस्:
```bash
foundry --version
```

## परियोजना अवलोकन

यो परियोजनामा चार मुख्य भागहरू छन्:

1. **Application.java** - मुख्य Spring Boot एप्लिकेशन प्रवेश बिन्दु
2. **FoundryLocalService.java** - AI संवादको लागि सेवा तह
3. **application.properties** - Foundry Local कनेक्शनको कन्फिगरेसन
4. **pom.xml** - Maven निर्भरता र परियोजना कन्फिगरेसन

## कोड बुझाइ

### 1. एप्लिकेशन कन्फिगरेसन (application.properties)

**फाइल:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**यसले के गर्छ:**
- **base-url**: Foundry Local कहाँ चलिरहेको छ भनेर निर्दिष्ट गर्छ, `/v1` पथ समेत जुन OpenAI API सँग मेल खान्छ। डिफल्ट पोर्ट `5273` हो। यदि पोर्ट फरक छ भने, `foundry service status` बाट जाँच गर्नुहोस्।
- **model** (वैकल्पिक): पाठ उत्पादनको लागि प्रयोग हुने AI मोडेलको नाम। **डिफल्ट रूपमा, एप्लिकेशन Foundry Local को `/v1/models` एन्डपॉइन्टलाई स्टार्टअपमा सोधेर मोडेल स्वचालित खोज्छ**, त्यसैले तपाईँले यसलाई सेट गर्नु आवश्यक छैन। आवश्यक परे यसलाई स्पष्ट रूपमा सेट गर्न सक्नुहुन्छ।

**मुख्य अवधारणा:** Spring Boot यी प्रोपर्टीहरू स्वचालित रूपमा लोड गर्छ र `@Value` एनोटेशन प्रयोग गरेर तपाईंको एप्लिकेशनमा उपलब्ध गराउँछ।

### 2. मुख्य एप्लिकेशन क्लास (Application.java)

**फाइल:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // कुनै वेब सर्भर आवश्यक छैन
        app.run(args);
    }
```

**यसले के गर्छ:**
- `@SpringBootApplication` ले Spring Boot को स्वचालित कन्फिगरेसन सक्षम गर्छ
- `WebApplicationType.NONE` ले Spring लाई यो वेब सर्भर नभएर कमाण्ड-लाइन एप्लिकेशन हो भनी जनाउँछ
- मुख्य मेथडले Spring एप्लिकेशन सुरु गर्छ

**डेमो रनर:**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        System.out.println("Calling Foundry Local service...");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
        System.out.println("=========================");
    };
}
```

**यसले के गर्छ:**
- `@Bean` ले Spring द्वारा व्यवस्थापन गरिने कम्पोनेंट बनाउँछ
- `CommandLineRunner` Spring Boot सुरुवात पछि कोड चलाउँछ
- `foundryLocalService` स्वतः Spring द्वारा इन्जेक्ट गरिएको छ (डिपेन्डेन्सी इन्जेक्सन)
- AI लाई परीक्षण सन्देश पठाउँछ र प्रतिक्रिया देखाउँछ

### 3. AI सेवा तह (FoundryLocalService.java)

**फाइल:** `src/main/java/com/example/FoundryLocalService.java`

#### कन्फिगरेसन इन्जेक्सन:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // खाली भएमा स्वत: पत्ता लगाइयो
```

**यसले के गर्छ:**
- `@Service` ले Spring लाई यो क्लास व्यवसायिक तर्क प्रदान गर्दछ भनी जनाउँछ
- `@Value` ले application.properties बाट कन्फिगरेसन मानहरू इन्जेक्ट गर्छ
- मोडेल खाली छ भने, स्वचालित पहिचान Foundry Local बाट स्टार्टअपमा गरिन्छ। यसको मतलब एपले Foundry Local मा लोड भएका कुनै पनि मोडेलसँग काम गर्छ बिना म्यानुअल कन्फिगरेसन।

#### क्लाइन्ट सुरु गर्नु:
```java
@PostConstruct
public void init() {
    // स्पष्ट रूपमा कन्फिगर नगरिएको भए Foundry Local बाट मोडल स्वचालित रूपमा पत्ता लगाउनुहोस्
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // आधार URL मा कन्फिगरेसनबाट /v1 पहिले नै समावेश गरिएको छ
            .apiKey("not-needed")            // स्थानीय सर्भरलाई वास्तविक API कुञ्जी आवश्यक पर्दैन
            .build();
}
```

**यसले के गर्छ:**
- `@PostConstruct` ले Spring सेवा बनाइसकेपछि यो मेथड चलाउँछ
- यदि मोडेल कन्फिगरेसन छैन भने, Foundry Local को `/v1/models` एन्डपॉइन्ट सोध्छ र पहिलो लोड गरिएको मोडेल छान्छ
- OpenAI क्लाइन्ट बनाउँछ जुन तपाईंको स्थानीय Foundry Local इंस्ट्यान्समा संकेत गर्छ
- `application.properties` बाट प्राप्त base URL मा `/v1` पहिले नै समावेश छ OpenAI API अनुपालनको लागि
- API कुञ्जी "not-needed" मा सेट गरिएको छ किनकि स्थानीय विकासमा प्रमाणीकरण आवश्यक छैन

#### च्याट मेथड:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // कुन AI मोडेल प्रयोग गर्ने
                .addUserMessage(message)         // तपाईंको प्रश्न/प्रोम्प्ट
                .maxCompletionTokens(150)        // प्रतिक्रिया लामो सीमा
                .temperature(0.7)                // सिर्जनात्मकता नियन्त्रण गर्नुहोस् (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // API नतिजाबाट AI को प्रतिक्रिया निकाल्नुहोस्
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
- **ChatCompletionCreateParams**: AI अनुरोध कन्फिगर गर्छ
  - `model`: प्रयोग गर्ने AI मोडेल निर्दिष्ट गर्छ (ठीक `foundry model list` बाट ID मेल खानुपर्छ)
  - `addUserMessage`: वार्तालापमा तपाईंको सन्देश थप्छ
  - `maxCompletionTokens`: जवाफको अधिकतम लम्बाइ सीमित गर्छ (स्रोत बचत)
  - `temperature`: अनियमितता नियन्त्रण गर्छ (0.0 = निश्चित, 1.0 = सर्जनशील)
- **API कल:** अनुरोध Foundry Local मा पठाउँछ
- **प्रतिक्रिया ह्यान्डलिङ:** AI को पाठ जवाफ सुरक्षित रूपमा निकाल्छ
- **त्रुटि ह्यान्डलिङ:** सहायक त्रुटि सन्देशसहित अपवादलाई बाहिर ल्याउँछ

### 4. परियोजना निर्भरताहरू (pom.xml)

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
- **spring-boot-starter**: मुख्य Spring Boot कार्यक्षमता प्रदान गर्छ
- **openai-java**: API संवादका लागि आधिकारिक OpenAI Java SDK
- **jackson-databind**: API कलका लागि JSON सिरियलाइजेशन/डिसिरियलाइजेशन मेनेज गर्छ

## सबै कुरा कसरी सँगै काम गर्छ

एप्लिकेशन चलाउँदा सम्पूर्ण प्रक्रिया यस्तो हुन्छ:

1. **स्टार्टअप**: Spring Boot सुरु हुन्छ र `application.properties` पढ्छ
2. **सेवा सिर्जना**: Spring ले `FoundryLocalService` बनाउँछ र कन्फिगरेसन मानहरू इन्जेक्ट गर्छ
3. **मोडेल पत्ता लगाउने**: मोडेल कन्फिगरेसन नभएमा, Foundry Local को `/v1/models` सोधेर पहिलो उपलब्ध मोडेल स्वतः प्रयोग गर्छ
4. **क्लाइन्ट सेटअप**: `@PostConstruct` ले Foundry Local सँग जडान गर्न OpenAI क्लाइन्ट इनिसियलाइज गर्छ
5. **डेमो कार्यान्वयन**: `CommandLineRunner` स्टार्टअप पछि चल्छ
6. **AI कल**: डेमोले `foundryLocalService.chat()` लाई परीक्षण सन्देशसहित कल गर्छ
7. **API अनुरोध**: सेवा OpenAI अनुकूल अनुरोध बनाउँदै Foundry Local मा पठाउँछ
8. **प्रतिक्रिया प्रशोधन**: सेवा AI को प्रतिक्रिया निकालेर पठाउँछ
9. **प्रदर्शन**: एप्लिकेशन जवाफ छाप्छ र बन्द हुन्छ

## Foundry Local सेटअप गर्ने तरिका

1. [पूर्वआवश्यकताहरू](#पूर्वआवश्यकताहरू) अनुसार Foundry Local स्थापना गर्नुहोस्।

2. **सेवा सुरु गर्नुहोस्** (यदि पहिले चलिरहेको छैन भने):
   ```bash
   foundry service start
   ```

3. **सेवा स्थिति जाँच्नुहोस्** कि यो चलिरहेको छ र पोर्ट नोट गर्नुहोस्:
   ```bash
   foundry service status
   ```

4. **मोडेल डाउनलोड र चलाउनुहोस्** (पहिलो पटक रन गर्दा डाउनलोड हुन्छ, पछि क्याच हुन्छ):
   ```bash
   foundry model run phi-4-mini
   ```
   यसले अन्तरक्रियात्मक च्याट सत्र खोल्छ। `Ctrl+C` दबाएर बाहिर निस्कन सकिन्छ। मोडेल सेवामा लोड रहीन्छ।

   > **टिप:** सबै उपलब्ध मोडेलहरू हेर्न `foundry model list` चलाउनुहोस्। `phi-4-mini` संग कुनै पनि एलियास प्रतिस्थापन गर्न सकिन्छ (जस्तै, सानो/छिटो मोडेलको लागि `qwen2.5-0.5b`)।

5. **मोडेल लोड भएको पुष्ट्याउनुस्:**
   ```bash
   foundry service ps
   ```

6. **आवश्यक परे `application.properties` अपडेट गर्नुहोस्:**
   - डिफल्ट `base-url` (`http://localhost:5273/v1`) CLI को डिफल्ट पोर्टसँग मेल खान्छ। केवल यदि `foundry service status` ले फरक पोर्ट देखायो भने मात्र परिवर्तन गर्नुहोस्।
   - मोडेल स्टार्टअपमा **स्वचालित पहिचान** हुन्छ — कुनै कन्फिगरेसन आवश्यक छैन।

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## एप्लिकेशन चलाउने तरिका

### चरण 1: Foundry Local मा मोडेल लोड छ कि छैन पक्का पार्नुहोस्
```bash
foundry service ps
```
यदि मोडेलहरू सूचीबद्ध छैनन् भने, एउटा लोड गर्नुहोस्:
```bash
foundry model run phi-4-mini
```

### चरण 2: एप्लिकेशन बिल्ड र रन गर्नुहोस्
अर्को टर्मिनलमा:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

वा JAR रूपमा बिल्ड र रन गर्नुहोस्:
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
Hello! I'm Phi, an AI developed by Microsoft. I can assist with a wide variety of 
tasks including answering questions, helping with analysis, creative writing, coding, 
and general conversation. How can I help you today?
=========================
```

## अगाडि के गर्ने

अझ उदाहरणहरूका लागि, हेर्नुहोस् [अध्याय ०४: व्यवहारिक नमूनाहरू](../README.md)

## समस्या समाधान

### सामान्य समस्या

**"Connection refused" वा "Service unavailable"**
- सेवा जाँच्नुहोस्: `foundry service status`
- आवश्यक परे पुनः सुरु गर्नुहोस्: `foundry service restart`
- `application.properties` को पोर्ट `foundry service status` को नतिजासँग मिल्छ कि छैन जाँच्नुहोस्
- URL अन्त्यमा `/v1` थपिएको छ कि छैन पक्का गर्नुहोस्: `http://localhost:5273/v1`

**"No model found" स्टार्टअपमा**
- एपले मोडेल स्वचालित पत्ता लगाउँछ। कम्तिमा एउटा मोडेल लोड छ कि छैन पक्का पार्नुहोस्: `foundry service ps`
- यदि कुनै मोडेल छैन भने: `foundry model run phi-4-mini`
- यदि तपाईंले `application.properties` मा मोडेल नाम परिवर्तन गर्नुभएको छ भने, यो `foundry model list` सँग मिल्छ कि छैन जाँच्नुहोस्

**"400 Bad Request" त्रुटिहरू**
- base URL मा `/v1` समावेश छ कि छैन जाँच्नुहोस्: `http://localhost:5273/v1`
- तपाईंको कोडमा `maxCompletionTokens()` प्रयोग गरिएको छ (`maxTokens()` पुरानो हो)

**Maven कम्पाइल त्रुटिहरू**
- Java 21 वा माथि छ कि छैन जाँच्नुहोस्: `java -version`
- सफा र पुनः बनाउनुहोस्: `mvn clean compile`
- निर्भरता डाउनलोडका लागि इन्टरनेट कनेक्शन छ कि छैन सुनिश्चित गर्नुहोस्

**सेवा कनेक्शन समस्या**
- `Request to local service failed` देखियो भने `foundry service restart` चलाउनुहोस्
- लोड भएका मोडेल जाँच्नुहोस्: `foundry service ps`
- सेवा लग हेर्नुहोस्: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**अस्वीकरण**:  
यो दस्तावेज AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) प्रयोग गरेर अनुवाद गरिएको हो। हामी शुद्धता को लागि प्रयास गर्छौं, तर कृपया जानकार हुनुहोस् कि स्वचालित अनुवादमा त्रुटिहरू वा शुद्धतामा कमी हुन सक्छ। मूल कागजात यसको स्थानीय भाषामा अधिकारिक स्रोत मानिनुपर्छ। महत्वपूर्ण जानकारीको लागि व्यावसायिक मानव अनुवाद सिफारिस गरिन्छ। यस अनुवादको प्रयोगबाट उत्पन्न हुने कुनै पनि गलत बुझाइ वा गलत व्याख्यामा हामी जिम्मेवार छैनौं।
<!-- CO-OP TRANSLATOR DISCLAIMER END -->