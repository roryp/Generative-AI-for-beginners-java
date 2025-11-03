<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "713d81fd7d28a865068df047e26c8f12",
  "translation_date": "2025-11-03T20:19:07+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "ta"
}
-->
# Foundry Local Spring Boot பயிற்சி

## உள்ளடக்க அட்டவணை

- [முன் தேவைகள்](../../../../04-PracticalSamples/foundrylocal)
- [திட்டத்தின் மேற்பார்வை](../../../../04-PracticalSamples/foundrylocal)
- [குறியீட்டை புரிந்து கொள்வது](../../../../04-PracticalSamples/foundrylocal)
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

இந்த பயிற்சியை தொடங்குவதற்கு முன், உங்களிடம் பின்வரும் பொருட்கள் இருக்க வேண்டும்:

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
2. **FoundryLocalService.java** - AI தொடர்புகளை நிர்வகிக்கும் சேவை அடுக்கு
3. **application.properties** - Foundry Local இணைப்புக்கான அமைப்பு
4. **pom.xml** - Maven சார்புகள் மற்றும் திட்ட அமைப்பு

## குறியீட்டை புரிந்து கொள்வது

### 1. பயன்பாட்டு அமைப்பு (application.properties)

**கோப்பு:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```

**இதன் செயல்பாடு:**
- **base-url**: Foundry Local இயங்கும் இடத்தை குறிப்பிடுகிறது, `/v1` OpenAI API இணக்கத்திற்காக சேர்க்கப்பட்டுள்ளது. **குறிப்பு**: Foundry Local தானாகவே ஒரு port-ஐ ஒதுக்குகிறது, எனவே `foundry service status` மூலம் உங்கள் port-ஐ சரிபார்க்கவும்
- **model**: உரை உருவாக்கத்திற்கான AI மாதிரியை பெயரிடுகிறது, பதிப்பு எண்ணை உட்படுத்தி (எ.கா., `:1`). `foundry model list` மூலம் கிடைக்கக்கூடிய மாதிரிகளை சரிபார்க்கவும்

**முக்கிய கருத்து:** Spring Boot இந்த அமைப்புகளை தானாகவே ஏற்றுகிறது மற்றும் `@Value` annotation மூலம் உங்கள் பயன்பாட்டிற்கு கிடைக்கச் செய்கிறது.

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
- `WebApplicationType.NONE` Spring-ஐ இது ஒரு command-line பயன்பாடு என்பதைச் சொல்கிறது, ஒரு web server அல்ல
- முக்கிய முறை Spring பயன்பாட்டை தொடங்குகிறது

**Demo Runner:**
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

**இதன் செயல்பாடு:**
- `@Bean` Spring நிர்வகிக்கும் ஒரு கூறை உருவாக்குகிறது
- `CommandLineRunner` Spring Boot தொடங்கிய பிறகு குறியீட்டை இயக்குகிறது
- `foundryLocalService` Spring மூலம் தானாகவே inject செய்யப்படுகிறது (dependency injection)
- AI-க்கு ஒரு சோதனை செய்தியை அனுப்பி பதிலை காட்டுகிறது

### 3. AI சேவை அடுக்கு (FoundryLocalService.java)

**கோப்பு:** `src/main/java/com/example/FoundryLocalService.java`

#### அமைப்பு Injection:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```

**இதன் செயல்பாடு:**
- `@Service` Spring-ஐ இந்த வகுப்பு வணிகத் தரவுகளை வழங்குகிறது என்று சொல்கிறது
- `@Value` application.properties-இல் இருந்து அமைப்பு மதிப்புகளை inject செய்கிறது
- `:default-value` syntax அமைப்புகள் அமைக்கப்படவில்லை என்றால் fallback மதிப்புகளை வழங்குகிறது

#### Client Initialization:
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
- உங்கள் Foundry Local instance-க்கு பாயிண்ட் செய்யும் OpenAI client-ஐ உருவாக்குகிறது
- `application.properties`-இல் உள்ள base URL ஏற்கனவே OpenAI API இணக்கத்திற்காக `/v1`-ஐ உட்படுத்துகிறது
- உள்ளூர் மேம்பாட்டிற்கு authentication தேவையில்லை என்பதால் API key "not-needed" என அமைக்கப்படுகிறது

#### Chat முறை:
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

**இதன் செயல்பாடு:**
- **ChatCompletionCreateParams**: AI கோரிக்கையை அமைக்கிறது
  - `model`: எந்த AI மாதிரியை பயன்படுத்த வேண்டும் என்பதை குறிப்பிடுகிறது (`foundry model list`-இல் உள்ள ID-ஐ சரியாக பொருந்த வேண்டும்)
  - `addUserMessage`: உங்கள் செய்தியை உரையாடலுக்கு சேர்க்கிறது
  - `maxTokens`: பதில் எவ்வளவு நீளமாக இருக்க வேண்டும் என்பதை வரையறுக்கிறது (வளங்களை சேமிக்கிறது)
  - `temperature`: சீர்மையின்மையை கட்டுப்படுத்துகிறது (0.0 = நிர்ணயிக்கப்பட்டது, 1.0 = படைப்பாற்றல்)
- **API Call**: Foundry Local-க்கு கோரிக்கையை அனுப்புகிறது
- **Response Handling**: AI-யின் உரை பதிலை பாதுகாப்பாக எடுக்கிறது
- **Error Handling**: பயனுள்ள பிழை செய்திகளுடன் εξαίρεσεις-ஐ சுற்றுகிறது

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
- **openai-java**: OpenAI Java SDK API தொடர்புக்கு
- **jackson-databind**: API அழைப்புகளுக்கான JSON serialization/deserialization-ஐ நிர்வகிக்கிறது

## எல்லாம் ஒன்றாக எப்படி வேலை செய்கிறது

நீங்கள் பயன்பாட்டை இயக்கும்போது முழு செயல்பாடு இங்கே:

1. **தொடக்கம்**: Spring Boot தொடங்கி `application.properties`-ஐ படிக்கிறது
2. **சேவை உருவாக்கம்**: Spring `FoundryLocalService`-ஐ உருவாக்கி அமைப்பு மதிப்புகளை inject செய்கிறது
3. **Client அமைப்பு**: `@PostConstruct` OpenAI client-ஐ Foundry Local-க்கு இணைக்க ஆரம்பிக்கிறது
4. **Demo செயல்பாடு**: `CommandLineRunner` தொடக்கத்திற்குப் பிறகு செயல்படுகிறது
5. **AI அழைப்பு**: Demo `foundryLocalService.chat()`-ஐ சோதனை செய்தியுடன் அழைக்கிறது
6. **API கோரிக்கை**: சேவை OpenAI-இன் இணக்கமான கோரிக்கையை Foundry Local-க்கு அனுப்புகிறது
7. **பதில் செயல்பாடு**: சேவை AI-யின் பதிலை எடுத்து திரும்புகிறது
8. **காட்சி**: பயன்பாடு பதிலை அச்சிட்டு வெளியேறுகிறது

## Foundry Local அமைத்தல்

Foundry Local-ஐ அமைக்க, இந்த படிகளை பின்பற்றவும்:

1. **Foundry Local-ஐ நிறுவவும்** [Prerequisites](../../../../04-PracticalSamples/foundrylocal) பகுதியில் உள்ள வழிமுறைகளைப் பயன்படுத்தி.

2. **தானாக ஒதுக்கப்பட்ட port-ஐ சரிபார்க்கவும்**. Foundry Local தொடங்கும்போது தானாகவே ஒரு port-ஐ ஒதுக்குகிறது. உங்கள் port-ஐ கண்டறிய:
   ```bash
   foundry service status
   ```
   
   **விருப்பம்**: நீங்கள் ஒரு குறிப்பிட்ட port-ஐ (எ.கா., 5273) பயன்படுத்த விரும்பினால், அதை கையேடு முறையில் அமைக்கலாம்:
   ```bash
   foundry service set --port 5273
   ```

3. **உங்கள் பயன்படுத்த விரும்பும் AI மாதிரியை பதிவிறக்கவும்**, உதாரணமாக, `phi-3.5-mini`, கீழே உள்ள கட்டளையைப் பயன்படுத்தி:
   ```bash
   foundry model run phi-3.5-mini
   ```

4. **application.properties** கோப்பை உங்கள் Foundry Local அமைப்புகளுடன் பொருந்த하도록 அமைக்கவும்:
   - `base-url`-இல் port-ஐ (படி 2-இல் இருந்து) புதுப்பிக்கவும், இது `/v1`-ஐ இறுதியில் கொண்டிருக்க வேண்டும்
   - `model` பெயரை பதிப்பு எண்ணுடன் புதுப்பிக்கவும் (`foundry model list` மூலம் சரிபார்க்கவும்)
   
   உதாரணம்:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```

## பயன்பாட்டை இயக்குதல்

### படி 1: Foundry Local-ஐ தொடங்கவும்
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

மேலும் உதாரணங்களுக்கு, [Chapter 04: Practical samples](../README.md) பார்க்கவும்

## சிக்கல்களை சரிசெய்தல்

### பொதுவான சிக்கல்கள்

**"Connection refused" அல்லது "Service unavailable"**
- Foundry Local இயங்குகிறதா என்பதை உறுதிப்படுத்தவும்: `foundry model list`
- Foundry Local பயன்படுத்தும் port-ஐ சரிபார்க்கவும்: `foundry service status`
- உங்கள் `application.properties`-ஐ சரியான port-ஐ கொண்டு புதுப்பிக்கவும், URL `/v1`-ஐ இறுதியில் கொண்டிருக்க வேண்டும்
- விருப்பமாக, ஒரு குறிப்பிட்ட port-ஐ அமைக்கவும்: `foundry service set --port 5273`
- Foundry Local-ஐ மீண்டும் தொடங்க முயற்சிக்கவும்: `foundry model run phi-3.5-mini`

**"Model not found" அல்லது "404 Not Found" பிழைகள்**
- கிடைக்கக்கூடிய மாதிரிகளை சரியான ID-களுடன் சரிபார்க்கவும்: `foundry model list`
- `application.properties`-இல் மாதிரி பெயரை சரியாக புதுப்பிக்கவும், பதிப்பு எண்ணை உட்படுத்தி (எ.கா., `Phi-3.5-mini-instruct-cuda-gpu:1`)
- `base-url` `/v1`-ஐ இறுதியில் கொண்டிருக்க வேண்டும் என்பதை உறுதிப்படுத்தவும்: `http://localhost:5273/v1`
- தேவையான மாதிரியை பதிவிறக்கவும்: `foundry model run phi-3.5-mini`

**"400 Bad Request" பிழைகள்**
- base URL `/v1`-ஐ கொண்டிருக்க வேண்டும் என்பதை உறுதிப்படுத்தவும்: `http://localhost:5273/v1`
- மாதிரி ID `foundry model list`-இல் காட்டப்பட்டதை சரியாக பொருந்த வேண்டும்
- உங்கள் குறியீட்டில் `maxTokens()`-ஐ பயன்படுத்துகிறீர்களா என்பதை உறுதிப்படுத்தவும், `maxCompletionTokens()`-ஐ அல்ல

**Maven தொகுப்பு பிழைகள்**
- Java 21 அல்லது அதற்கு மேல் இருக்கிறதா என்பதை உறுதிப்படுத்தவும்: `java -version`
- சுத்தம் செய்து மீண்டும் தொகுக்கவும்: `mvn clean compile`
- சார்பு பதிவிறக்கங்களுக்கு இணைய இணைப்பை சரிபார்க்கவும்

**பயன்பாடு தொடங்குகிறது ஆனால் வெளியீடு இல்லை**
- Foundry Local பதிலளிக்கிறதா என்பதை உறுதிப்படுத்தவும்: `http://localhost:5273`-ஐ உலாவியில் திறக்கவும்
- குறிப்பிட்ட பிழை செய்திகளுக்கான பயன்பாட்டு பதிவுகளை சரிபார்க்கவும்
- மாதிரி முழுமையாக ஏற்றப்பட்டு தயாராக இருக்கிறதா என்பதை உறுதிப்படுத்தவும்

---

**குறிப்பு**:  
இந்த ஆவணம் AI மொழிபெயர்ப்பு சேவை [Co-op Translator](https://github.com/Azure/co-op-translator) பயன்படுத்தி மொழிபெயர்க்கப்பட்டுள்ளது. நாங்கள் துல்லியத்திற்காக முயற்சிக்கிறோம், ஆனால் தானியங்கி மொழிபெயர்ப்புகளில் பிழைகள் அல்லது தவறுகள் இருக்கக்கூடும் என்பதை கவனத்தில் கொள்ளவும். அதன் தாய்மொழியில் உள்ள மூல ஆவணம் அதிகாரப்பூர்வ ஆதாரமாக கருதப்பட வேண்டும். முக்கியமான தகவல்களுக்கு, தொழில்முறை மனித மொழிபெயர்ப்பு பரிந்துரைக்கப்படுகிறது. இந்த மொழிபெயர்ப்பைப் பயன்படுத்துவதால் ஏற்படும் எந்த தவறான புரிதல்கள் அல்லது தவறான விளக்கங்களுக்கு நாங்கள் பொறுப்பல்ல.