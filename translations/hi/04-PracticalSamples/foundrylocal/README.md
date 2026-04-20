# Foundry Local Spring Boot ट्यूटोरियल

## Table of Contents

- [पूर्वापेक्षाएँ](#पूर्वापेक्षाएँ)
- [परियोजना अवलोकन](#परियोजना-अवलोकन)
- [कोड को समझना](#कोड-को-समझना)
  - [1. एप्लिकेशन कॉन्फ़िगरेशन (application.properties)](#1-एप्लिकेशन-कॉन्फ़िगरेशन-applicationproperties)
  - [2. मुख्य एप्लिकेशन क्लास (Application.java)](#2-मुख्य-एप्लिकेशन-क्लास-applicationjava)
  - [3. AI सेवा परत (FoundryLocalService.java)](#3-ai-सेवा-परत-foundrylocalservicejava)
  - [4. परियोजना निर्भरताएँ (pom.xml)](#4-परियोजना-निर्भरताएँ-pomxml)
- [यह सब साथ मिलकर कैसे काम करता है](#यह-सब-साथ-मिलकर-कैसे-काम-करता-है)
- [Foundry Local सेटअप करना](#foundry-local-सेटअप-करना)
- [एप्लिकेशन चलाना](#एप्लिकेशन-चलाना)
- [अपेक्षित आउटपुट](#अपेक्षित-आउटपुट)
- [अगले कदम](#अगले-कदम)
- [समस्या समाधान](#समस्या-समाधान)


## पूर्वापेक्षाएँ

इस ट्यूटोरियल को शुरू करने से पहले, सुनिश्चित करें कि आपके पास हैं:

- **Java 21 या उच्चतर** आपके सिस्टम पर स्थापित
- **Maven 3.6+** परियोजना बनाने के लिए
- **Foundry Local** स्थापित और चल रहा हो

### **Foundry Local इंस्टॉल करें:**

> **नोट:** Foundry Local CLI केवल **Windows** और **macOS** पर उपलब्ध है। Linux को [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust) के माध्यम से समर्थित किया जाता है।

```bash
# विंडोज़
winget install Microsoft.FoundryLocal

# मैकओएस
brew tap microsoft/foundrylocal
brew install foundrylocal
```

इंस्टॉलेशन सत्यापित करें:
```bash
foundry --version
```

## परियोजना अवलोकन

यह परियोजना चार मुख्य घटकों से मिलकर बनी है:

1. **Application.java** - मुख्य Spring Boot एप्लिकेशन प्रवेश बिंदु
2. **FoundryLocalService.java** - सेवा परत जो AI संचार को संभालती है
3. **application.properties** - Foundry Local कनेक्शन के लिए कॉन्फ़िगरेशन
4. **pom.xml** - Maven निर्भरताएँ और परियोजना कॉन्फ़िगरेशन

## कोड को समझना

### 1. एप्लिकेशन कॉन्फ़िगरेशन (application.properties)

**फ़ाइल:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**यह क्या करता है:**
- **base-url**: यह निर्दिष्ट करता है कि Foundry Local कहाँ चल रहा है, जिसमें OpenAI API संगतता के लिए `/v1` पथ शामिल है। डिफ़ॉल्ट पोर्ट `5273` है। यदि पोर्ट अलग है, तो इसे `foundry service status` से जांचें।
- **model** (वैकल्पिक): टेक्स्ट जनरेशन के लिए उपयोग किए जाने वाले AI मॉडल का नाम। **डिफ़ॉल्ट रूप से, एप्लिकेशन Foundry Local के `/v1/models` एंडपॉइंट से स्टार्टअप पर मॉडल का स्वचालित पता लगाता है**, इसलिए इसे सेट करने की जरूरत नहीं है। आवश्यकता होने पर आप इसे विशेष रूप से सेट करके स्वचालित पता लगाने को ओवरराइड कर सकते हैं।

**मुख्य अवधारणा:** Spring Boot स्वचालित रूप से इन प्रॉपर्टीज़ को लोड करता है और `@Value` एनोटेशन के माध्यम से आपके एप्लिकेशन के लिए उपलब्ध कराता है।

### 2. मुख्य एप्लिकेशन क्लास (Application.java)

**फ़ाइल:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // किसी वेब सर्वर की आवश्यकता नहीं है
        app.run(args);
    }
```

**यह क्या करता है:**
- `@SpringBootApplication` Spring Boot ऑटो-कॉन्फ़िगरेशन सक्षम करता है
- `WebApplicationType.NONE` Spring को बताता है कि यह एक कमांड-लाइन ऐप है, वेब सर्वर नहीं
- मुख्य मेथड Spring एप्लिकेशन शुरू करता है

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

**यह क्या करता है:**
- `@Bean` ऐसा घटक बनाता है जिसे Spring मैनेज करता है
- `CommandLineRunner` कोड को Spring Boot के स्टार्टअप के बाद चलाता है
- `foundryLocalService` स्वचालित रूप से Spring द्वारा इंजेक्ट किया जाता है (डिपेंडेंसी इंजेक्शन)
- AI को एक टेस्ट संदेश भेजता है और प्रतिक्रिया प्रदर्शित करता है

### 3. AI सेवा परत (FoundryLocalService.java)

**फ़ाइल:** `src/main/java/com/example/FoundryLocalService.java`

#### कॉन्फ़िगरेशन इंजेक्शन:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // यदि खाली हो तो स्वचालित रूप से पता लगाया गया
```

**यह क्या करता है:**
- `@Service` Spring को बताता है कि यह क्लास बिजनेस लॉजिक प्रदान करता है
- `@Value` application.properties से कॉन्फ़िगरेशन मान इंजेक्ट करता है
- मॉडल डिफ़ॉल्ट रूप से खाली रहता है, जो स्टार्टअप पर Foundry Local से **स्वचालित पता लगाने** को ट्रिगर करता है। इसका मतलब एप्लिकेशन बिना मैनुअल कॉन्फ़िगरेशन के Foundry Local में लोड किसी भी मॉडल के साथ काम करता है।

#### क्लाइंट इनिशियलाइज़ेशन:
```java
@PostConstruct
public void init() {
    // यदि स्पष्ट रूप से कॉन्फ़िगर नहीं किया गया है तो Foundry Local से मॉडल को स्वचालित रूप से पहचानें
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // बेस URL में पहले से ही कॉन्फ़िगरेशन से /v1 शामिल है
            .apiKey("not-needed")            // स्थानीय सर्वर को वास्तविक API कुंजी की आवश्यकता नहीं है
            .build();
}
```

**यह क्या करता है:**
- `@PostConstruct` Spring द्वारा सेवा बनने के बाद यह मेथड चलाता है
- यदि कोई मॉडल कॉन्फ़िगर नहीं है, तो यह Foundry Local के `/v1/models` एंडपॉइंट को क्वेरी करता है और पहला लोड किया गया मॉडल चुनता है
- एक OpenAI क्लाइंट बनाता है जो आपके स्थानीय Foundry Local इंस्टेंस से जुड़ता है
- `application.properties` से बेस URL पहले से `/v1` शामिल करता है OpenAI API संगतता के लिए
- API कुंजी को "not-needed" सेट करता है क्योंकि लोकल विकास में प्रमाणीकरण की आवश्यकता नहीं होती

#### चैट मेथड:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // कौन सा एआई मॉडल उपयोग करना है
                .addUserMessage(message)         // आपका प्रश्न/प्रॉम्प्ट
                .maxCompletionTokens(150)        // प्रतिक्रिया की लंबाई सीमित करें
                .temperature(0.7)                // रचनात्मकता नियंत्रित करें (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // एपीआई परिणाम से एआई की प्रतिक्रिया निकालें
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**यह क्या करता है:**
- **ChatCompletionCreateParams**: AI अनुरोध को कॉन्फ़िगर करता है
  - `model`: उपयोग करने वाले AI मॉडल को निर्दिष्ट करता है (जो `foundry model list` से सटीक ID से मेल खाना चाहिए)
  - `addUserMessage`: आपकी बातचीत में आपका संदेश जोड़ता है
  - `maxCompletionTokens`: प्रतिक्रिया की अधिकतम लंबाई सीमित करता है (संसाधन बचाता है)
  - `temperature`: रैंडमनेस को नियंत्रित करता है (0.0 = निश्चित, 1.0 = रचनात्मक)
- **API कॉल**: Foundry Local को अनुरोध भेजता है
- **प्रतिक्रिया हैंडलिंग**: AI के टेक्स्ट उत्तर को सुरक्षित ढंग से निकालता है
- **त्रुटि हैंडलिंग**: सहायक त्रुटि संदेशों के साथ एक्सेप्शन्स को रैप करता है

### 4. परियोजना निर्भरताएँ (pom.xml)

**मुख्य निर्भरताएँ:**

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

**यह ये करते हैं:**
- **spring-boot-starter**: कोर Spring Boot कार्यक्षमता प्रदान करता है
- **openai-java**: OpenAI API संचार के लिए आधिकारिक OpenAI Java SDK
- **jackson-databind**: API कॉल के लिए JSON सीरियलाइज़ेशन/डेसिरियलाइज़ेशन संभालता है

## यह सब साथ मिलकर कैसे काम करता है

जब आप एप्लिकेशन चलाते हैं तो पूरा फ्लो इस प्रकार है:

1. **स्टार्टअप**: Spring Boot शुरू होता है और `application.properties` पढ़ता है
2. **सेवा निर्माण**: Spring `FoundryLocalService` बनाता है और कॉन्फ़िगरेशन मान इंजेक्ट करता है
3. **मॉडल पता लगाना**: अगर कोई मॉडल कॉन्फिगर नहीं है, तो सेवा Foundry Local के `/v1/models` को क्वेरी करती है और पहला उपलब्ध मॉडल स्वचालित रूप से उपयोग करती है
4. **क्लाइंट सेटअप**: `@PostConstruct` OpenAI क्लाइंट को Foundry Local से कनेक्ट करने के लिए इनिशियलाइज़ करता है
5. **डेमो निष्पादन**: `CommandLineRunner` स्टार्टअप के बाद चलता है
6. **AI कॉल**: डेमो `foundryLocalService.chat()` को एक टेस्ट संदेश के साथ कॉल करता है
7. **API अनुरोध**: सेवा OpenAI-संगत अनुरोध बनाती है और Foundry Local को भेजती है
8. **प्रतिक्रिया प्रसंस्करण**: सेवा AI की प्रतिक्रिया निकालती है और वापस करती है
9. **प्रदर्शन**: एप्लिकेशन प्रतिक्रिया प्रिंट करता है और बाहर निकलता है

## Foundry Local सेटअप करना

1. [पूर्वापेक्षाएँ](#पूर्वापेक्षाएँ) अनुभाग में दिए निर्देशों का उपयोग करके **Foundry Local इंस्टॉल करें**।

2. सेवा चालू करें (यदि पहले से नहीं चल रही है):
   ```bash
   foundry service start
   ```

3. सेवा की स्थिति जांचें यह पुष्टि करने के लिए कि यह चल रही है और पोर्ट नोट करें:
   ```bash
   foundry service status
   ```

4. एक मॉडल डाउनलोड और चलाएं (पहली बार चलाने पर डाउनलोड होता है, बाद के लिए कैश्ड रहता है):
   ```bash
   foundry model run phi-4-mini
   ```
   यह एक इंटरएक्टिव चैट सेशन खोलता है। आप `Ctrl+C` से बाहर निकल सकते हैं। मॉडल सेवा में लोड रहता है।

   > **टिप:** `foundry model list` चलाएं उपलब्ध सभी मॉडलों को देखने के लिए। `phi-4-mini` की जगह कैटलॉग में से कोई भी एलियास इस्तेमाल करें (जैसे छोटा/तेज़ मॉडल के लिए `qwen2.5-0.5b`)।

5. यह सत्यापित करें कि मॉडल लोड हो गया है:
   ```bash
   foundry service ps
   ```

6. जरूरत हो तो `application.properties` अपडेट करें:
   - डिफ़ॉल्ट `base-url` (`http://localhost:5273/v1`) CLI के डिफ़ॉल्ट पोर्ट से मेल खाता है। केवल तब अपडेट करें यदि `foundry service status` कोई अलग पोर्ट दिखाता है।
   - मॉडल **स्वचालित पता लगाया जाता है** स्टार्टअप पर — कोई कॉन्फ़िगरेशन आवश्यक नहीं।

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## एप्लिकेशन चलाना

### Step 1: सुनिश्चित करें कि Foundry Local में कोई मॉडल लोड है
```bash
foundry service ps
```
अगर कोई मॉडल सूचीबद्ध नहीं है, तो एक लोड करें:
```bash
foundry model run phi-4-mini
```

### Step 2: एप्लिकेशन बनाएं और चलाएं
किसी अलग टर्मिनल में:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

या JAR के रूप में बनाएं और चलाएं:
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

## अगले कदम

अधिक उदाहरणों के लिए देखें [Chapter 04: Practical samples](../README.md)

## समस्या समाधान

### सामान्य समस्याएँ

**"Connection refused" या "Service unavailable"**
- सेवा जांचें: `foundry service status`
- जरूरत हो तो पुनः प्रारंभ करें: `foundry service restart`
- सत्यापित करें कि `application.properties` में पोर्ट `foundry service status` आउटपुट से मेल खाता हो
- सुनिश्चित करें कि URL `/v1` पर समाप्त होता है: `http://localhost:5273/v1`

**स्टार्टअप पर "No model found"**
- एप्लिकेशन मॉडल को स्वचालित पता लगाता है। सुनिश्चित करें कम से कम एक मॉडल लोड है: `foundry service ps`
- यदि कोई मॉडल लोड नहीं है: `foundry model run phi-4-mini`
- यदि आपने `application.properties` में मॉडल नाम ओवरराइड किया है, तो जांचें कि वह `foundry model list` से मेल खाता हो

**"400 Bad Request" त्रुटियां**
- सत्यापित करें कि बेस URL में `/v1` शामिल है: `http://localhost:5273/v1`
- सुनिश्चित करें कि आप अपने कोड में `maxCompletionTokens()` का उपयोग कर रहे हैं (डिप्रिकेटेड `maxTokens()` नहीं)

**Maven संकलन त्रुटियां**
- सुनिश्चित करें Java 21 या उच्चतर है: `java -version`
- साफ़ और पुनः निर्माण करें: `mvn clean compile`
- निर्भरता डाउनलोड के लिए इंटरनेट कनेक्शन जांचें

**सेवा कनेक्शन समस्याएं**
- यदि `Request to local service failed` दिखता है, तो चलाएं: `foundry service restart`
- लोड किए गए मॉडल जांचें: `foundry service ps`
- सेवा लॉग देखें: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**अस्वीकरण**:  
इस दस्तावेज़ का अनुवाद AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) का उपयोग करके किया गया है। जबकि हम सटीकता के लिए प्रयास करते हैं, कृपया ध्यान रखें कि स्वचालित अनुवाद में त्रुटियाँ या अशुद्धियाँ हो सकती हैं। मूल भाषा में दस्तावेज़ को अधिकारिक स्रोत माना जाना चाहिए। महत्वपूर्ण जानकारी के लिए, पेशेवर मानव अनुवाद की सिफारिश की जाती है। इस अनुवाद के उपयोग से उत्पन्न किसी भी गलतफहमी या गलत व्याख्या के लिए हम जिम्मेदार नहीं हैं।
<!-- CO-OP TRANSLATOR DISCLAIMER END -->