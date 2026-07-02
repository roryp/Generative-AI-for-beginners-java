# Foundry Local Spring Boot ट्यूटोरियल

## सामग्री सूची

- [पूर्वअटी](#पूर्वअटी)
- [प्रकल्पाचा आढावा](#प्रकल्पाचा-आढावा)
- [कोड समजून घेणे](#कोड-समजून-घेणे)
  - [1. अनुप्रयोग कॉन्फिगरेशन (application.properties)](#1-अनुप्रयोग-कॉन्फिगरेशन-applicationproperties)
  - [2. मुख्य अनुप्रयोग वर्ग (Application.java)](#2-मुख्य-अनुप्रयोग-वर्ग-applicationjava)
  - [3. AI सेवा स्तर (FoundryLocalService.java)](#3-ai-सेवा-स्तर-foundrylocalservicejava)
  - [4. प्रकल्प अवलंबित्व (pom.xml)](#4-प्रकल्प-अवलंबित्व-pomxml)
- [हे सर्व कसे काम करते](#हे-सर्व-कसे-काम-करते)
- [Foundry Local सेटअप करणे](#foundry-local-सेटअप-करणे)
- [अनुप्रयोग चालवणे](#अनुप्रयोग-चालवणे)
- [अपेक्षित आउटपुट](#अपेक्षित-आउटपुट)
- [पुढील टप्पे](#पुढील-टप्पे)
- [समस्या निवारण](#समस्या-निवारण)


## पूर्वअटी

हा ट्यूटोरियल सुरू करण्यापूर्वी, याची खात्री करा की तुमच्याकडे आहे:

- **Java 21 किंवा त्याहून वर** तुमच्या सिस्टिमवर स्थापित आहे
- प्रकल्प तयार करण्यासाठी **Maven 3.6+**
- **Foundry Local** स्थापित आणि चालू आहे

### **Foundry Local इंस्टॉल करा:**

> **नोट:** Foundry Local CLI फक्त **Windows** आणि **macOS** वर उपलब्ध आहे. Linux साठी [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust) द्वारे समर्थन दिले जाते.

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

इंस्टॉलेशन तपासा:
```bash
foundry --version
```

## प्रकल्पाचा आढावा

हा प्रकल्प चार मुख्य घटकांपासून बनलेला आहे:

1. **Application.java** - मुख्य Spring Boot अनुप्रयोगाची एंट्री पॉइंट
2. **FoundryLocalService.java** - AI संवाद सांभाळणारी सेवा स्तर
3. **application.properties** - Foundry Local कनेक्शन साठी कॉन्फिगरेशन
4. **pom.xml** - Maven अवलंबित्वे आणि प्रकल्प कॉन्फिगरेशन

## कोड समजून घेणे

### 1. अनुप्रयोग कॉन्फिगरेशन (application.properties)

**फाईल:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**हे काय करते:**
- **base-url**: Foundry Local कुठे चालू आहे हे निर्दिष्ट करते, ज्यामध्ये OpenAI API अनुकूलतेसाठी `/v1` पाथ समाविष्ट आहे. डीफॉल्ट पोर्ट `5273` आहे. जर पोर्ट वेगळा असेल, तर `foundry service status` वापरून तपासा.
- **model** (पर्यायी): टेक्स्ट जनरेशनसाठी वापरायचा AI मॉडेलचे नाव देते. **मुळात, अनुप्रयोग स्वयं-ओळखणी करून मॉडेल शोधतो** Foundry Local च्या `/v1/models` एंडपॉइंटवर स्टार्टअपला, त्यामुळे तुम्हाला हे सेट करण्याची गरज नाही. तरीही, हव्यास असल्यास स्वतःहून सेट करू शकता.

**मुख्य संकल्पना:** Spring Boot हे प्रॉपर्टीज आपोआप लोड करते आणि तुमच्या अनुप्रयोगासाठी `@Value` ऍनोटेशन वापरून उपलब्ध करून देते.

### 2. मुख्य अनुप्रयोग वर्ग (Application.java)

**फाईल:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // कोणत्याही वेब सर्व्हरची गरज नाही
        app.run(args);
    }
```

**हे काय करते:**
- `@SpringBootApplication` Spring Boot ऑटो-कॉन्फिगरेशन सक्षम करते
- `WebApplicationType.NONE` Spring ला सांगते की हा वेब सर्व्हर नाही, तर कमांड-लाइन अॅप आहे
- मुख्य मेथड Spring अनुप्रयोग सुरू करते

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
- `@Bean` एक कॉम्पोनंट तयार करते ज्याचे व्यवस्थापन Spring करते
- `CommandLineRunner` Spring Boot सुरू झाल्यानंतर कोड चालवतो
- `foundryLocalService` स्वयंचलितपणे Spring कडून इंजेक्ट होते (dependency injection)
- AI कडे एक तपासणी संदेश पाठवतो आणि प्रतिसाद दाखवतो

### 3. AI सेवा स्तर (FoundryLocalService.java)

**फाईल:** `src/main/java/com/example/FoundryLocalService.java`

#### कॉन्फिगरेशन इंजेक्शन:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // रिक्त असल्यास आपोआप ओळखले गेले
```

**हे काय करते:**
- `@Service` Spring ला सांगते की हा वर्ग व्यवसाय लॉजिक पुरवतो
- `@Value` application.properties मधून कॉन्फिगरेशन मूल्ये इंजेक्ट करते
- मॉडेल मुळतः रिक्त आहे, ज्यामुळे Foundry Local कडून प्रारंभी **स्वयं-ओळखणी** होते. याचा अर्थ अनुप्रयोग Foundry Local मध्ये लोड झालेल्या कोणत्याही मॉडेलसह निर्बाध काम करू शकतो.

#### क्लायंट इनिशियलायझेशन:
```java
@PostConstruct
public void init() {
    // जर स्पष्टपणे संरचित केले नसेल तर Foundry Local मधून मॉडेल आपोआप ओळखा
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // बेस URL मध्ये आधीच संरचनेतून /v1 समाविष्ट आहे
            .apiKey("not-needed")            // स्थानिक सर्व्हरला खऱ्या API कीची गरज नाही
            .build();
}
```

**हे काय करते:**
- `@PostConstruct` या मेथडला Spring सेवा तयार केल्यावर कॉल करते
- जर मॉडेल सेट नसेल, तर Foundry Local च्या `/v1/models` एंडपॉइंटवर क्वेरी करून पहिले लोड झालेले मॉडेल निवडते
- एक OpenAI क्लायंट तयार करतो जो तुमच्या स्थानिक Foundry Local इंस्टन्सशी जोडतो
- application.properties मधील बेस URL मध्ये आधीच OpenAI API अनुकूलतेसाठी `/v1` समाविष्ट आहे
- API की "not-needed" सेट केली आहे कारण स्थानिक विकासासाठी प्रमाणीकरण आवश्यक नाही

#### चॅट मेथड:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // कोणता AI मॉडेल वापरायचा
                .addUserMessage(message)         // तुमचा प्रश्न/प्रांप्ट
                .maxCompletionTokens(150)        // प्रतिसादाची लांबी मर्यादित करा
                .temperature(0.7)                // सृजनशीलता नियंत्रित करा (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // API परिणामातून AI चे प्रतिसाद काढा
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
- **ChatCompletionCreateParams**: AI विनंती कॉन्फिगर करते
  - `model`: कोणते AI मॉडेल वापरायचे ते निर्दिष्ट करते (योग्य ID घेतलेली असावी `foundry model list` वरून)
  - `addUserMessage`: संभाषणाला तुमचा संदेश जोडतो
  - `maxCompletionTokens`: प्रतिसाद किती लांब असू शकतो याला मर्यादा घालतो (संसाधने वाचवते)
  - `temperature`: यादृच्छिकतेवर नियंत्रण ठेवतो (0.0 = निश्चित, 1.0 = सर्जनशील)
- **API कॉल**: Foundry Local कडे विनंती पाठवतो
- **प्रतिसाद हाताळणी**: AI चा टेक्स्ट प्रतिसाद सुरक्षितपणे मिळवतो
- **त्रुटी हाताळणी**: अपवादांना मदत करणारे त्रुटी संदेश देतो

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

**हे काय करतात:**
- **spring-boot-starter**: मूळ Spring Boot कार्यक्षमता प्रदान करते
- **openai-java**: OpenAI अधिकृत Java SDK API संवादासाठी
- **jackson-databind**: API कॉल्ससाठी JSON सीरियलायझेशन/डिसीरियलायझेशन हाताळते

## हे सर्व कसे काम करते

अंडीटीप करण्याची प्रक्रिया खालीलप्रमाणे आहे:

1. **स्टार्टअप**: Spring Boot सुरू होतो आणि `application.properties` वाचतो
2. **सेवा निर्मिती**: Spring `FoundryLocalService` तयार करतो आणि कॉन्फिगरेशन मूल्ये इंजेक्ट करतो
3. **मॉडेल शोध**: जर मॉडेल सेट नसेल, तर सेवा Foundry Local च्या `/v1/models` एंडपॉइंटवर क्वेरी करते आणि पहिला उपलब्ध मॉडेल स्वयं-ऑप्ट करून वापरते
4. **क्लायंट सेटअप**: `@PostConstruct` OpenAI क्लायंट इनिशियलायझ करते जे Foundry Local शी कनेक्ट होतं
5. **डेमो अंमलबजावणी**: `CommandLineRunner` स्टार्टअपनंतर कार्यान्वित होतो
6. **AI कॉल**: डेमो `foundryLocalService.chat()` चा वापर करून तपासणी संदेश पाठवतो
7. **API विनंती**: सेवा OpenAI अनुकूल विनंती तयार करते आणि Foundry Local कडे पाठवते
8. **प्रतिसाद प्रक्रिया**: सेवा AI चा प्रतिसाद घेते आणि परत करते
9. **प्रदर्शन**: अनुप्रयोग प्रतिसाद छापतो आणि बाहेर पडतो

## Foundry Local सेटअप करणे

1. [पूर्वअटी](#पूर्वअटी) विभागातील सूचनांनुसार **Foundry Local इंस्टॉल करा**.

2. **सेवा सुरू करा** (जर आधीपासून नसेल तर):
   ```bash
   foundry service start
   ```

3. **सेवा स्थिती तपासा** आणि चालू असल्याची खात्री करा, तसेच पोर्ट लक्षात ठेवा:
   ```bash
   foundry service status
   ```

4. **मॉडेल डाउनलोड आणि चालवा** (प्रथम वेळी डाउनलोड होईल, नंतर कॅशे होईल):
   ```bash
   foundry model run phi-4-mini
   ```
   हे एक संवादात्मक चॅट सत्र उघडते. `Ctrl+C` वापरून बाहेर पडू शकता. मॉडेल सेवा मध्ये लोड झालेले राहते.

   > **टीप:** `foundry model list` चालवा सर्व उपलब्ध मॉडेल बघण्यासाठी. `phi-4-mini` ऐवजी कोणताही अॅलियस वापरू शकता (उदा., `qwen2.5-0.5b` लहान/जलद मॉडेलसाठी).

5. **मॉडेल लोड झाले आहे का ते तपासा:**
   ```bash
   foundry service ps
   ```

6. आवश्यक असल्यास **`application.properties` अपडेट करा**:
   - डीफॉल्ट `base-url` (`http://localhost:5273/v1`) CLI पोर्टशी जुळतो. `foundry service status` वेगळा पोर्ट दाखवला तरच बदल करा.
   - मॉडेल स्टार्टअपवेळी **स्वतः शोधून काढला जातो** — कोणतीही अतिरिक्त कॉन्फिगरेशन आवश्यक नाही.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## अनुप्रयोग चालवणे

### टप्पा 1: Foundry Local मध्ये मॉडेल लोड आहे याची खात्री करा
```bash
foundry service ps
```
जर कोणताही मॉडेल दिसत नसेल तर, एक मॉडेल लोड करा:
```bash
foundry model run phi-4-mini
```

### टप्पा 2: अनुप्रयोग तयार करा आणि चालवा
वेगळ्या टर्मिनलमध्ये:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

किंवा JAR म्हणून तयार करा आणि चालवा:
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

## पुढील टप्पे

अधिक उदाहरणांसाठी, [अध्याय ०४: व्यावहारिक नमुने](../README.md) पहा

## समस्या निवारण

### सामान्य समस्या

**"Connection refused" किंवा "Service unavailable"**
- सेवा तपासा: `foundry service status`
- गरज लागल्यास पुन्हा सुरू करा: `foundry service restart`
- `application.properties` मधील पोर्ट `foundry service status` आउटपुटशी जुळतो का तपासा
- URL नक्की `/v1` सुटलंय का ते पाहा: `http://localhost:5273/v1`

**"No model found" प्रारंभात**
- अनुप्रयोग स्वयंचलितपणे मॉडेल शोधतो. किमान एक मॉडेल लोड आहे याची खात्री करा: `foundry service ps`
- जर कोणताही मॉडेल लोड नसेल: `foundry model run phi-4-mini`
- जर `application.properties` मध्ये मॉडेल नाव ओव्हरराईड केले असेल, तर ते `foundry model list` शी जुळते का तपासा

**"400 Bad Request" त्रुटी**
- बेस URL मध्ये `/v1` आहे का तपासा: `http://localhost:5273/v1`
- तुमच्या कोडमध्ये `maxCompletionTokens()` वापर करत आहात का, जुना `maxTokens()` नाही

**Maven संकलन त्रुटी**
- Java 21 किंवा त्याहून वर आहे का: `java -version`
- क्लीन आणि पुन्हा संकलित करा: `mvn clean compile`
- डिपेंडन्सी डाउनलोडसाठी इंटरनेट कनेक्शन तपासा

**सेवा कनेक्शन समस्या**
- जर `Request to local service failed` दिसत असेल, तर `foundry service restart` करा
- लोड झालेले मॉडेल पहा: `foundry service ps`
- सेवा लॉग बघा: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**अस्वीकरण**:
हा दस्तऐवज AI भाषांतर सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) वापरून अनुवादित केला आहे. आम्ही अचूकतेसाठी प्रयत्नशील आहोत, तरी कृपया लक्षात घ्या की स्वयंचलित अनुवादांमध्ये चुका किंवा चुका असू शकतात. मूळ दस्तऐवज त्याच्या स्थानिक भाषेमध्ये अधिकारप्राप्त स्रोत मानला जावा लागतो. महत्त्वाची माहिती साठी व्यावसायिक मानव अनुवाद शिफारस केला जातो. या अनुवादाचा वापर करून झालेल्या कोणत्याही गैरसमजुती किंवा चुकीच्या अर्थसंग्रहासाठी आम्ही जबाबदार नाही.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->