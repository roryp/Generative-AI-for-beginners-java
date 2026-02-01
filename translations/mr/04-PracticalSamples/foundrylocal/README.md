# फाउंड्री लोकल स्प्रिंग बूट ट्युटोरियल

## विषय सूची

- [पूर्वअटलबंधन](../../../../04-PracticalSamples/foundrylocal)
- [प्रकल्पाचा आढावा](../../../../04-PracticalSamples/foundrylocal)
- [कोड समजून घेणे](../../../../04-PracticalSamples/foundrylocal)
  - [1. अनुप्रयोग कॉन्फिगरेशन (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. मुख्य अनुप्रयोग वर्ग (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. एआय सेवा स्तर (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. प्रकल्प अवलंबित्व (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [सर्व काही कसे एकत्र कार्य करते](../../../../04-PracticalSamples/foundrylocal)
- [फाउंड्री लोकल सेट अप करणे](../../../../04-PracticalSamples/foundrylocal)
- [अनुप्रयोग चालवणे](../../../../04-PracticalSamples/foundrylocal)
- [अपेक्षित आउटपुट](../../../../04-PracticalSamples/foundrylocal)
- [पुढील पावले](../../../../04-PracticalSamples/foundrylocal)
- [समस्या निवारण](../../../../04-PracticalSamples/foundrylocal)

## पूर्वअटलबंधन

या ट्युटोरियलला सुरुवात करण्यापूर्वी, खात्री करा की तुमच्याकडे खालील गोष्टी आहेत:

- **Java 21 किंवा त्याहून अधिक** तुमच्या प्रणालीवर स्थापित आहे
- प्रकल्प तयार करण्यासाठी **Maven 3.6+**
- **Foundry Local** स्थापित आणि चालू आहे

### **फाउंड्री लोकल स्थापित करा:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```


## प्रकल्पाचा आढावा

या प्रकल्पात चार मुख्य घटक आहेत:

1. **Application.java** - मुख्य स्प्रिंग बूट अनुप्रयोगाचा प्रवेश बिंदू
2. **FoundryLocalService.java** - एआय संवाद हाताळणारा सेवा स्तर
3. **application.properties** - फाउंड्री लोकल कनेक्शनसाठी कॉन्फिगरेशन
4. **pom.xml** - मावेन अवलंबित्व आणि प्रकल्प कॉन्फिगरेशन

## कोड समजून घेणे

### 1. अनुप्रयोग कॉन्फिगरेशन (application.properties)

**फाइल:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```


**हे काय करते:**
- **base-url**: फाउंड्री लोकल कोठे चालू आहे हे निर्दिष्ट करते, ज्यामध्ये OpenAI API सुसंगततेसाठी `/v1` पथ समाविष्ट आहे. **टीप**: फाउंड्री लोकल डायनॅमिक पोर्ट नियुक्त करते, त्यामुळे `foundry service status` वापरून तुमचा प्रत्यक्ष पोर्ट तपासा.
- **model**: मजकूर निर्मितीसाठी वापरायचे एआय मॉडेल नाव, त्यात आवृत्ती क्रमांक (उदा., `:1`) समाविष्ट आहे. उपलब्ध मॉडेल्स आणि त्यांचे अचूक आयडी पाहण्यासाठी `foundry model list` वापरा.

**महत्त्वाचा संकल्पना:** स्प्रिंग बूट आपोआप या प्रॉपर्टीज लोड करते आणि `@Value` अ‍ॅनोटेशन वापरून तुमच्या अनुप्रयोगासाठी उपलब्ध करते.

### 2. मुख्य अनुप्रयोग वर्ग (Application.java)

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


**हे काय करते:**
- `@SpringBootApplication` स्प्रिंग बूट ऑटो-कॉन्फिगरेशन सक्षम करते
- `WebApplicationType.NONE` स्प्रिंगला सांगते की हा एक कमांड-लाइन अनुप्रयोग आहे, वेब सर्व्हर नाही
- मुख्य पद्धत स्प्रिंग अनुप्रयोग सुरू करते

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


**हे काय करते:**
- `@Bean` एक घटक तयार करते ज्याचे व्यवस्थापन स्प्रिंग करते
- `CommandLineRunner` स्प्रिंग बूट सुरू झाल्यानंतर कोड चालवतो
- `foundryLocalService` स्प्रिंगद्वारे आपोआप इंजेक्ट केले जाते (डिपेंडन्सी इंजेक्शन)
- एआयला चाचणी संदेश पाठवतो आणि प्रतिसाद प्रदर्शित करतो

### 3. एआय सेवा स्तर (FoundryLocalService.java)

**फाइल:** `src/main/java/com/example/FoundryLocalService.java`

#### कॉन्फिगरेशन इंजेक्शन:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```


**हे काय करते:**
- `@Service` स्प्रिंगला सांगते की हा वर्ग व्यवसाय लॉजिक प्रदान करतो
- `@Value` application.properties मधून कॉन्फिगरेशन मूल्ये इंजेक्ट करते
- `:default-value` सिंटॅक्स प्रॉपर्टीज सेट नसल्यास फॉलबॅक मूल्ये प्रदान करते

#### क्लायंट प्रारंभ:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```


**हे काय करते:**
- `@PostConstruct` स्प्रिंगने सेवा तयार केल्यानंतर ही पद्धत चालवते
- तुमच्या स्थानिक फाउंड्री लोकल उदाहरणाशी जोडणारा OpenAI क्लायंट तयार करते
- `application.properties` मधील बेस URL आधीच OpenAI API सुसंगततेसाठी `/v1` समाविष्ट करते
- स्थानिक विकासासाठी प्रमाणीकरण आवश्यक नसल्यामुळे API की "not-needed" म्हणून सेट केली जाते

#### चॅट पद्धत:
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


**हे काय करते:**
- **ChatCompletionCreateParams**: एआय विनंती कॉन्फिगर करते
  - `model`: कोणते एआय मॉडेल वापरायचे ते निर्दिष्ट करते (हे अचूक आयडी `foundry model list` मधून जुळले पाहिजे)
  - `addUserMessage`: संभाषणात तुमचा संदेश जोडतो
  - `maxCompletionTokens`: प्रतिसाद किती लांब असू शकतो यावर मर्यादा घालतो (संसाधने वाचवतो)
  - `temperature`: यादृच्छिकता नियंत्रित करते (0.0 = निर्धारक, 1.0 = सर्जनशील)
- **API कॉल**: फाउंड्री लोकलला विनंती पाठवतो
- **प्रतिसाद हाताळणी**: एआयचा मजकूर प्रतिसाद सुरक्षितपणे काढतो
- **त्रुटी हाताळणी**: उपयुक्त त्रुटी संदेशांसह अपवाद लपेटतो

### 4. प्रकल्प अवलंबित्व (pom.xml)

**महत्त्वाचे अवलंबित्व:**

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


**हे काय करते:**
- **spring-boot-starter**: मुख्य स्प्रिंग बूट कार्यक्षमता प्रदान करते
- **openai-java**: API संवादासाठी अधिकृत OpenAI Java SDK
- **jackson-databind**: API कॉलसाठी JSON सिरीयलायझेशन/डिसिरीयलायझेशन हाताळते

## सर्व काही कसे एकत्र कार्य करते

जेव्हा तुम्ही अनुप्रयोग चालवता तेव्हा संपूर्ण प्रवाह असा असतो:

1. **स्टार्टअप**: स्प्रिंग बूट सुरू होते आणि `application.properties` वाचते
2. **सेवा निर्मिती**: स्प्रिंग `FoundryLocalService` तयार करते आणि कॉन्फिगरेशन मूल्ये इंजेक्ट करते
3. **क्लायंट सेटअप**: `@PostConstruct` OpenAI क्लायंट प्रारंभ करते जो फाउंड्री लोकलशी कनेक्ट होतो
4. **डेमो अंमलबजावणी**: `CommandLineRunner` स्टार्टअपनंतर अंमलात आणतो
5. **एआय कॉल**: डेमो चाचणी संदेशासह `foundryLocalService.chat()` कॉल करतो
6. **API विनंती**: सेवा OpenAI-सुसंगत विनंती तयार करते आणि फाउंड्री लोकलला पाठवते
7. **प्रतिसाद प्रक्रिया**: सेवा प्रतिसाद काढते आणि परत करते
8. **प्रदर्शन**: अनुप्रयोग प्रतिसाद मुद्रित करतो आणि बाहेर पडतो

## फाउंड्री लोकल सेट अप करणे

फाउंड्री लोकल सेट अप करण्यासाठी, खालील चरणांचे अनुसरण करा:

1. [पूर्वअटलबंधन](../../../../04-PracticalSamples/foundrylocal) विभागातील सूचनांचा वापर करून **फाउंड्री लोकल स्थापित करा**.

2. **डायनॅमिकली असाइन केलेला पोर्ट तपासा**. फाउंड्री लोकल सुरू झाल्यावर आपोआप पोर्ट असाइन करते. तुमचा पोर्ट शोधण्यासाठी:
   ```bash
   foundry service status
   ```
   
   **पर्यायी**: तुम्हाला विशिष्ट पोर्ट (उदा., 5273) वापरायचा असल्यास, तुम्ही तो मॅन्युअली कॉन्फिगर करू शकता:
   ```bash
   foundry service set --port 5273
   ```


3. **तुम्हाला हवे असलेले एआय मॉडेल डाउनलोड करा**, उदाहरणार्थ, `phi-3.5-mini`, खालील आदेशासह:
   ```bash
   foundry model run phi-3.5-mini
   ```


4. **application.properties फाइल कॉन्फिगर करा** जेणेकरून ती तुमच्या फाउंड्री लोकल सेटिंग्जशी जुळेल:
   - `base-url` मध्ये पोर्ट अपडेट करा (पायरी 2 पासून), याची खात्री करा की त्यात `/v1` शेवटी समाविष्ट आहे
   - मॉडेलचे नाव आवृत्ती क्रमांकासह अपडेट करा (ते `foundry model list` वापरून तपासा)

   उदाहरण:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```


## अनुप्रयोग चालवणे

### पायरी 1: फाउंड्री लोकल सुरू करा
```bash
foundry model run phi-3.5-mini
```


### पायरी 2: अनुप्रयोग तयार करा आणि चालवा
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


## पुढील पावले

अधिक उदाहरणांसाठी, [Chapter 04: Practical samples](../README.md) पहा

## समस्या निवारण

### सामान्य समस्या

**"कनेक्शन नाकारले" किंवा "सेवा अनुपलब्ध"**
- फाउंड्री लोकल चालू आहे याची खात्री करा: `foundry model list`
- फाउंड्री लोकल कोणता पोर्ट वापरत आहे ते तपासा: `foundry service status`
- तुमच्या `application.properties` मध्ये योग्य पोर्टसह अपडेट करा, याची खात्री करा की URL `/v1` ने समाप्त होते
- वैकल्पिकरित्या, विशिष्ट पोर्ट सेट करा: `foundry service set --port 5273`
- फाउंड्री लोकल पुन्हा सुरू करण्याचा प्रयत्न करा: `foundry model run phi-3.5-mini`

**"मॉडेल सापडले नाही" किंवा "404 Not Found" त्रुटी**
- अचूक आयडीसह उपलब्ध मॉडेल्स तपासा: `foundry model list`
- `application.properties` मध्ये मॉडेलचे नाव अचूकपणे अपडेट करा, त्यात आवृत्ती क्रमांक समाविष्ट आहे (उदा., `Phi-3.5-mini-instruct-cuda-gpu:1`)
- `base-url` मध्ये `/v1` शेवटी समाविष्ट आहे याची खात्री करा: `http://localhost:5273/v1`
- आवश्यक असल्यास मॉडेल डाउनलोड करा: `foundry model run phi-3.5-mini`

**"400 Bad Request" त्रुटी**
- बेस URL मध्ये `/v1` समाविष्ट आहे याची खात्री करा: `http://localhost:5273/v1`
- मॉडेल आयडी अचूकपणे `foundry model list` मध्ये दर्शविल्याप्रमाणे जुळत आहे का ते तपासा
- तुमच्या कोडमध्ये `maxCompletionTokens()` वापरत आहात याची खात्री करा (जुने `maxTokens()` वापरू नका)

**मावेन संकलन त्रुटी**
- Java 21 किंवा त्याहून अधिक आहे याची खात्री करा: `java -version`
- स्वच्छ करा आणि पुन्हा तयार करा: `mvn clean compile`
- अवलंबित्व डाउनलोडसाठी इंटरनेट कनेक्शन तपासा

**अनुप्रयोग सुरू होतो पण आउटपुट नाही**
- फाउंड्री लोकल प्रतिसाद देत आहे याची खात्री करा: `http://localhost:5273/v1/models` तपासा किंवा `foundry service status` चालवा
- विशिष्ट त्रुटी संदेशांसाठी अनुप्रयोग लॉग तपासा
- मॉडेल पूर्णपणे लोड झाले आहे आणि तयार आहे याची खात्री करा

---

**अस्वीकरण**:  
हा दस्तऐवज AI भाषांतर सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) वापरून भाषांतरित करण्यात आला आहे. आम्ही अचूकतेसाठी प्रयत्नशील असलो तरी कृपया लक्षात ठेवा की स्वयंचलित भाषांतरांमध्ये त्रुटी किंवा अचूकतेचा अभाव असू शकतो. मूळ भाषेतील दस्तऐवज हा अधिकृत स्रोत मानला जावा. महत्त्वाच्या माहितीसाठी व्यावसायिक मानवी भाषांतराची शिफारस केली जाते. या भाषांतराचा वापर करून उद्भवलेल्या कोणत्याही गैरसमज किंवा चुकीच्या अर्थासाठी आम्ही जबाबदार राहणार नाही.