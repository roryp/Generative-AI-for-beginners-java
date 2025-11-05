<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "f787307400de59adc25a1404466a35f3",
  "translation_date": "2025-11-04T07:38:44+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "ta"
}
-->
# Foundry Local Spring Boot பயிற்சி

## உள்ளடக்க அட்டவணை

- [முன் தேவைகள்](../../../../04-PracticalSamples/foundrylocal)
- [திட்டத்தின் மேற்பார்வை](../../../../04-PracticalSamples/foundrylocal)
- [குறியீட்டை புரிந்துகொள்வது](../../../../04-PracticalSamples/foundrylocal)
  - [1. பயன்பாட்டு அமைப்பு (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. முக்கிய பயன்பாட்டு வகுப்பு (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. AI சேவை அடுக்கு (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. திட்ட சார்புகள் (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [எல்லாம் ஒன்றாக எப்படி வேலை செய்கிறது](../../../../04-PracticalSamples/foundrylocal)
- [Foundry Local அமைத்தல்](../../../../04-PracticalSamples/foundrylocal)
- [பயன்பாட்டை இயக்குதல்](../../../../04-PracticalSamples/foundrylocal)
- [எதிர்பார்க்கப்படும் வெளியீடு](../../../../04-PracticalSamples/foundrylocal)
- [அடுத்த படிகள்](../../../../04-PracticalSamples/foundrylocal)
- [சிக்கல்களை சரிசெய்தல்](../../../../04-PracticalSamples/foundrylocal)

## முன் தேவைகள்

இந்த பயிற்சியைத் தொடங்குவதற்கு முன், உங்களிடம் பின்வரும் பொருட்கள் இருக்க வேண்டும்:

- உங்கள் கணினியில் **Java 21 அல்லது அதற்கு மேல்** நிறுவப்பட்டிருக்க வேண்டும்
- திட்டத்தை உருவாக்க **Maven 3.6+**
- **Foundry Local** நிறுவப்பட்டு இயங்க வேண்டும்

### **Foundry Local நிறுவுதல்:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```


## திட்டத்தின் மேற்பார்வை

இந்த திட்டம் நான்கு முக்கிய கூறுகளை கொண்டுள்ளது:

1. **Application.java** - முக்கிய Spring Boot பயன்பாட்டின் தொடக்க புள்ளி
2. **FoundryLocalService.java** - AI தொடர்புகளை கையாளும் சேவை அடுக்கு
3. **application.properties** - Foundry Local இணைப்புக்கான அமைப்பு
4. **pom.xml** - Maven சார்புகள் மற்றும் திட்ட அமைப்பு

## குறியீட்டை புரிந்துகொள்வது

### 1. பயன்பாட்டு அமைப்பு (application.properties)

**கோப்பு:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```


**இதன் செயல்பாடு:**
- **base-url**: Foundry Local இயங்கும் இடத்தை குறிப்பிடுகிறது, OpenAI API இணக்கத்திற்கான `/v1` பாதையை உள்ளடக்கியது. **குறிப்பு**: Foundry Local தானாகவே ஒரு போர்ட்டை ஒதுக்குகிறது, எனவே `foundry service status` மூலம் உங்கள் உண்மையான போர்ட்டை சரிபார்க்கவும்.
- **model**: உரம் உருவாக்குவதற்கான AI மாதிரியை பெயரிடுகிறது, பதிப்பு எண்ணை (எ.கா., `:1`) உட்படுத்துகிறது. `foundry model list` மூலம் கிடைக்கக்கூடிய மாதிரிகளை மற்றும் அவற்றின் சரியான ஐடிகளை பார்க்கவும்.

**முக்கிய கருத்து:** Spring Boot இந்த பண்புகளை தானாகவே ஏற்றுகிறது மற்றும் `@Value` அடையாளத்தைப் பயன்படுத்தி உங்கள் பயன்பாட்டிற்கு கிடைக்கச் செய்கிறது.

### 2. முக்கிய பயன்பாட்டு வகுப்பு (Application.java)

**கோப்பு:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```


**இதன் செயல்பாடு:**
- `@SpringBootApplication` Spring Boot தானியக்க-அமைப்பை இயக்குகிறது
- `WebApplicationType.NONE` Spring இது ஒரு கட்டளை வரி பயன்பாடு, வலை சேவையகம் அல்ல என்பதைச் சொல்கிறது
- முக்கிய முறை Spring பயன்பாட்டைத் தொடங்குகிறது

**டெமோ ரன்னர்:**
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


**இதன் செயல்பாடு:**
- `@Bean` Spring நிர்வகிக்கும் ஒரு கூறை உருவாக்குகிறது
- `CommandLineRunner` Spring Boot தொடங்கிய பிறகு குறியீட்டை இயக்குகிறது
- `foundryLocalService` Spring மூலம் தானாகவே செலுத்தப்படுகிறது (சார்பு செலுத்தல்)
- AIக்கு ஒரு சோதனை செய்தியை அனுப்பி பதிலை காட்டுகிறது

### 3. AI சேவை அடுக்கு (FoundryLocalService.java)

**கோப்பு:** `src/main/java/com/example/FoundryLocalService.java`

#### அமைப்பு செலுத்தல்:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```


**இதன் செயல்பாடு:**
- `@Service` Spring இந்த வகுப்பு வணிக தத்துவத்தை வழங்குகிறது என்பதைச் சொல்கிறது
- `@Value` application.properties-இல் இருந்து அமைப்பு மதிப்புகளை செலுத்துகிறது
- `:default-value` வடிவம் பண்புகள் அமைக்கப்படவில்லை என்றால் மாற்று மதிப்புகளை வழங்குகிறது

#### கிளையன்ட் தொடக்கத்தல்:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```


**இதன் செயல்பாடு:**
- `@PostConstruct` Spring சேவையை உருவாக்கிய பிறகு இந்த முறையை இயக்குகிறது
- உங்கள் உள்ளூர் Foundry Local நிகழ்வுடன் இணைக்க OpenAI கிளையன்டை உருவாக்குகிறது
- `application.properties`-இல் உள்ள அடிப்படை URL ஏற்கனவே OpenAI API இணக்கத்திற்கான `/v1`-ஐ உள்ளடக்கியது
- உள்ளூர் மேம்பாட்டிற்கு அங்கீகாரம் தேவையில்லை என்பதால் API விசை "not-needed" என அமைக்கப்படுகிறது

#### உரையாடல் முறை:
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


**இதன் செயல்பாடு:**
- **ChatCompletionCreateParams**: AI கோரிக்கையை அமைக்கிறது
  - `model`: எந்த AI மாதிரியைப் பயன்படுத்த வேண்டும் என்பதை குறிப்பிடுகிறது (`foundry model list`-இல் உள்ள சரியான ஐடியுடன் பொருந்த வேண்டும்)
  - `addUserMessage`: உங்கள் செய்தியை உரையாடலுக்கு சேர்க்கிறது
  - `maxCompletionTokens`: பதில் எவ்வளவு நீளமாக இருக்க வேண்டும் என்பதை வரையறுக்கிறது (வளங்களைச் சேமிக்கிறது)
  - `temperature`: சீரற்ற தன்மையை கட்டுப்படுத்துகிறது (0.0 = தீர்மானமானது, 1.0 = படைப்பாற்றல்)
- **API அழைப்பு**: Foundry Local-க்கு கோரிக்கையை அனுப்புகிறது
- **பதில் கையாளுதல்**: AI-யின் உரை பதிலை பாதுகாப்பாக எடுக்கிறது
- **பிழை கையாளுதல்**: உதவியான பிழை செய்திகளுடன் விதிவிலக்குகளை சுற்றுகிறது

### 4. திட்ட சார்புகள் (pom.xml)

**முக்கிய சார்புகள்:**

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


**இதன் செயல்பாடு:**
- **spring-boot-starter**: முக்கிய Spring Boot செயல்பாட்டை வழங்குகிறது
- **openai-java**: API தொடர்புகளுக்கான OpenAI Java SDK
- **jackson-databind**: API அழைப்புகளுக்கான JSON சீரமைப்பு/சீரமைப்பு

## எல்லாம் ஒன்றாக எப்படி வேலை செய்கிறது

பயன்பாட்டை இயக்கும்போது முழு செயல்பாடு இங்கே:

1. **தொடக்கம்**: Spring Boot தொடங்கி `application.properties`-ஐப் படிக்கிறது
2. **சேவை உருவாக்கம்**: Spring `FoundryLocalService`-ஐ உருவாக்கி அமைப்பு மதிப்புகளை செலுத்துகிறது
3. **கிளையன்ட் அமைப்பு**: `@PostConstruct` OpenAI கிளையன்டை Foundry Local-க்கு இணைக்க தொடங்குகிறது
4. **டெமோ செயல்பாடு**: `CommandLineRunner` தொடக்கத்திற்குப் பிறகு செயல்படுகிறது
5. **AI அழைப்பு**: டெமோ `foundryLocalService.chat()`-ஐ சோதனை செய்தியுடன் அழைக்கிறது
6. **API கோரிக்கை**: சேவை OpenAI-இன் இணக்கமான கோரிக்கையை Foundry Local-க்கு அனுப்புகிறது
7. **பதில் செயலாக்கம்**: சேவை AI-யின் பதிலை எடுத்து திரும்புகிறது
8. **காட்சி**: பயன்பாடு பதிலை அச்சிட்டு வெளியேறுகிறது

## Foundry Local அமைத்தல்

Foundry Local-ஐ அமைக்க, இந்த படிகளைப் பின்பற்றவும்:

1. **Foundry Local-ஐ நிறுவவும்** [முன் தேவைகள்](../../../../04-PracticalSamples/foundrylocal) பிரிவில் உள்ள வழிமுறைகளைப் பயன்படுத்தி.

2. **தானாக ஒதுக்கப்பட்ட போர்ட்டை சரிபார்க்கவும்**. Foundry Local தொடங்கும்போது தானாகவே ஒரு போர்ட்டை ஒதுக்குகிறது. உங்கள் போர்ட்டை கண்டறிய:
   ```bash
   foundry service status
   ```
   
   **விருப்பத்தேர்வு**: நீங்கள் ஒரு குறிப்பிட்ட போர்ட்டை (எ.கா., 5273) பயன்படுத்த விரும்பினால், அதை கையேடு முறையில் அமைக்கலாம்:
   ```bash
   foundry service set --port 5273
   ```


3. **உங்கள் பயன்படுத்த விரும்பும் AI மாதிரியை பதிவிறக்கவும்**, உதாரணமாக, `phi-3.5-mini`, பின்வரும் கட்டளையைப் பயன்படுத்தி:
   ```bash
   foundry model run phi-3.5-mini
   ```


4. **application.properties** கோப்பை உங்கள் Foundry Local அமைப்புகளுக்கு பொருந்துமாறு அமைக்கவும்:
   - `base-url`-இல் போர்ட்டை (படி 2-இல் இருந்து) புதுப்பிக்கவும், இது `/v1`-ஐ இறுதியில் உள்ளடக்கியது என்பதை உறுதிப்படுத்தவும்
   - `model` பெயரை பதிப்பு எண்ணை உள்ளடக்கியவாறு புதுப்பிக்கவும் (`foundry model list` மூலம் சரிபார்க்கவும்)

   உதாரணம்:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```


## பயன்பாட்டை இயக்குதல்

### படி 1: Foundry Local தொடங்கவும்
```bash
foundry model run phi-3.5-mini
```


### படி 2: பயன்பாட்டை உருவாக்கி இயக்கவும்
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```


## எதிர்பார்க்கப்படும் வெளியீடு

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


## அடுத்த படிகள்

மேலும் உதாரணங்களுக்கு, [அத்தியாயம் 04: நடைமுறை மாதிரிகள்](../README.md) பார்க்கவும்

## சிக்கல்களை சரிசெய்தல்

### பொதுவான சிக்கல்கள்

**"Connection refused" அல்லது "Service unavailable"**
- Foundry Local இயங்குகிறதா என்பதை உறுதிப்படுத்தவும்: `foundry model list`
- Foundry Local பயன்படுத்தும் உண்மையான போர்ட்டை சரிபார்க்கவும்: `foundry service status`
- உங்கள் `application.properties`-ஐ சரியான போர்ட்டுடன் புதுப்பிக்கவும், URL `/v1`-இல் முடிவடைவதை உறுதிப்படுத்தவும்
- விருப்பமாக, ஒரு குறிப்பிட்ட போர்ட்டை அமைக்கவும்: `foundry service set --port 5273`
- Foundry Local-ஐ மீண்டும் தொடங்க முயற்சிக்கவும்: `foundry model run phi-3.5-mini`

**"Model not found" அல்லது "404 Not Found" பிழைகள்**
- கிடைக்கக்கூடிய மாதிரிகளை சரியான ஐடிகளுடன் சரிபார்க்கவும்: `foundry model list`
- `application.properties`-இல் மாதிரி பெயரை சரியாக புதுப்பிக்கவும், பதிப்பு எண்ணை உட்படுத்தி (எ.கா., `Phi-3.5-mini-instruct-cuda-gpu:1`)
- `base-url` `/v1`-இல் முடிவடைவதை உறுதிப்படுத்தவும்: `http://localhost:5273/v1`
- தேவையான மாதிரியை பதிவிறக்கவும்: `foundry model run phi-3.5-mini`

**"400 Bad Request" பிழைகள்**
- அடிப்படை URL `/v1`-ஐ உள்ளடக்கியது என்பதை உறுதிப்படுத்தவும்: `http://localhost:5273/v1`
- மாதிரி ஐடி `foundry model list`-இல் காட்டப்படுவதுடன் சரியாக பொருந்துகிறது என்பதை சரிபார்க்கவும்
- உங்கள் குறியீட்டில் `maxCompletionTokens()` பயன்படுத்துகிறீர்களா என்பதை உறுதிப்படுத்தவும் (முந்தைய `maxTokens()` பயன்படுத்த வேண்டாம்)

**Maven தொகுப்பு பிழைகள்**
- Java 21 அல்லது அதற்கு மேல்: `java -version`
- சுத்தம் செய்து மீண்டும் உருவாக்கவும்: `mvn clean compile`
- சார்பு பதிவிறக்கங்களுக்கு இணைய இணைப்பைச் சரிபார்க்கவும்

**பயன்பாடு தொடங்குகிறது ஆனால் வெளியீடு இல்லை**
- Foundry Local பதிலளிக்கிறதா என்பதை உறுதிப்படுத்தவும்: `http://localhost:5273/v1/models` அல்லது `foundry service status` இயக்கவும்
- குறிப்பிட்ட பிழை செய்திகளுக்கான பயன்பாட்டு பதிவுகளைச் சரிபார்க்கவும்
- மாதிரி முழுமையாக ஏற்றப்பட்டு தயாராக உள்ளதா என்பதை உறுதிப்படுத்தவும்

---

**குறிப்பு**:  
இந்த ஆவணம் AI மொழிபெயர்ப்பு சேவை [Co-op Translator](https://github.com/Azure/co-op-translator) பயன்படுத்தி மொழிபெயர்க்கப்பட்டுள்ளது. நாங்கள் துல்லியத்திற்காக முயற்சிக்கிறோம், ஆனால் தானியங்கி மொழிபெயர்ப்புகளில் பிழைகள் அல்லது தவறுகள் இருக்கக்கூடும் என்பதை கவனத்தில் கொள்ளவும். அதன் தாய்மொழியில் உள்ள மூல ஆவணம் அதிகாரப்பூர்வ ஆதாரமாக கருதப்பட வேண்டும். முக்கியமான தகவல்களுக்கு, தொழில்முறை மனித மொழிபெயர்ப்பு பரிந்துரைக்கப்படுகிறது. இந்த மொழிபெயர்ப்பைப் பயன்படுத்துவதால் ஏற்படும் எந்த தவறான புரிதல்கள் அல்லது தவறான விளக்கங்களுக்கு நாங்கள் பொறுப்பல்ல.