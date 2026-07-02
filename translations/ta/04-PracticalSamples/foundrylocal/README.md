# Foundry Local Spring Boot Tutorial

## விஷயக் குறிப்பு

- [முன்னணிப் பொருட்கள்](#முன்-நிபந்தனைகள்)
- [திட்டத்தின் கையேடு](#திட்ட-கையேடு)
- [குறியீட்டை புரிந்துகொள்வது](#குறியீட்டை-புரிந்துகொள்வது)
  - [1. பயன்பாட்டு கட்டமைப்பு (application.properties)](#1-பயன்பாட்டு-கட்டமைப்பு-applicationproperties)
  - [2. முதன்மை பயன்பாட்டுக் கிளாஸ் (Application.java)](#2-முதன்மை-பயன்பாட்டுக்-கிளாஸ்-applicationjava)
  - [3. AI சேவை அடுக்கு (FoundryLocalService.java)](#3-ai-சேவை-அடுக்கு-foundrylocalservicejava)
  - [4. திட்டத்தின் சார்பு கோப்புகள் (pom.xml)](#4-திட்டத்தின்-சார்பு-கோப்புகள்-pomxml)
- [எப்பட்டவாறு இது ஒருங்கிணைக்கிறது](#எப்பட்டவாறு-இது-ஒருங்கிணைக்கிறது)
- [Foundry Local அமைத்தல்](#foundry-local-அமைத்தல்)
- [பயன்பாட்டை இயக்கல்](#பயன்பாட்டை-இயக்கல்)
- [எதிர்பார்க்கப்படும் வெளியீடு](#எதிர்பார்க்கப்படும்-வெளியீடு)
- [அடுத்த படிகள்](#அடுத்த-படிகள்)
- [சிக்கல் தீர்வுகள்](#சிக்கல்-தீர்வுகள்)


## முன் நிபந்தனைகள்

இந்த பாடத்திட்டத்தைத் தொடங்குவதற்கு முன், நீங்கள் இதை உறுதிப்படுத்திக் கொள்ளுங்கள்:

- உங்கள் கணினியில் **Java 21 அல்லது அதற்கு மேற்பட்டது** நிறுவப்பட்டுள்ளது
- திட்டத்தை கட்ட அரசாங்கி **Maven 3.6+** உள்ளது
- **Foundry Local** நிறுவப்பட்டு இயக்கப்படுகின்றது

### **Foundry Local ஐ நிறுவவும்:**

> **குறிப்பு:** Foundry Local CLI **Windows** மற்றும் **macOS** இல் மட்டுமே கிடைக்கிறது. Linuxக்கு [Foundry Local SDKகள்](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust) மூலம் ஆதரவு உள்ளது.

```bash
# விண்டோஸ்
winget install Microsoft.FoundryLocal

# மேகோஎஸ்
brew tap microsoft/foundrylocal
brew install foundrylocal
```

நிறுவல் சரிபார்க்கவும்:
```bash
foundry --version
```

## திட்ட கையேடு

இந்த திட்டம் நான்கு முக்கிய கூறுகளைக் கொண்டுள்ளது:

1. **Application.java** - முதன்மை Spring Boot பயன்பாட்டு நுழைவாயில்
2. **FoundryLocalService.java** - AI தொடர்புக்கு சேவை அடுக்கு
3. **application.properties** - Foundry Local இணைப்பு கட்டமைப்பு
4. **pom.xml** - Maven சார்பு கோப்புகள் மற்றும் திட்ட கட்டமைப்பு

## குறியீட்டை புரிந்துகொள்வது

### 1. பயன்பாட்டு கட்டமைப்பு (application.properties)

**கோப்பு:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**இதன் செயல்:**
- **base-url**: Foundry Local எங்கு இயங்கிக் கொண்டிருக்கிறதோ அதை குறிப்பிடுகிறது, `/v1` பாதை OpenAI API உடன் பொருந்தும் படி சேர்க்கப்பட்டுள்ளது. இயல்பு போர்டு என்பது `5273`. போர்டு வேறுபட்டால், `foundry service status` கொண்டு சரிபார்க்கவும்.
- **model** (விருப்பமாக): எழுத்துக்களை உருவாக்கும் AI மாதிரியை பெயரிடுகிறது. **இயல்புநிலையில், செயலி Foundry Local `/v1/models` முடிவை பூர்வமாகக் கேட்கி மாதிரியை தானாக கண்டறிகிறது**, ஆகவே இதை அமைக்க தேவையில்லை. தேவையானால், நீங்கள் இதனை கைகளால் அமைக்கலாம்.

**முக்கிய கருத்து:** Spring Boot இவை கட்டமைப்பு மதிப்புகளை தானாக ஏற்றிக் கொண்டு, `@Value` குறிப்பை பயன்படுத்தி உங்கள் பயன்பாட்டுக்கு வழங்குகிறது.

### 2. முதன்மை பயன்பாட்டுக் கிளாஸ் (Application.java)

**கோப்பு:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // எந்த வலை சேவையகமும் தேவையில்லை
        app.run(args);
    }
```

**இதன் செயல்:**
- `@SpringBootApplication` Spring Boot தானாக கட்டமைப்பை இயக்குகிறது
- `WebApplicationType.NONE` இந்த செயலி இணையதள சேவையகம் அல்ல, ஒரு கட்டளை வரி பயன்பாடா என்பது தெரிவிக்கிறது
- முதன்மை முறை(Spring application) துவக்குகிறது

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

**இதன் செயல்:**
- `@Bean` Spring நிர்வகிக்கும் கூறை உருவாக்குகிறது
- `CommandLineRunner` Spring Boot துவங்கிய பின் குறியீட்டை இயக்குகிறது
- `foundryLocalService` Spring மூலம் தானாக உட்பெறப்படுகிறது (dependency injection)
- AIக்கு ஒரு சோதனை செய்தியை அனுப்பி பதிலை காட்டுகிறது

### 3. AI சேவை அடுக்கு (FoundryLocalService.java)

**கோப்பு:** `src/main/java/com/example/FoundryLocalService.java`

#### கட்டமைப்பு உட்புகுத்தல்:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // காலியானது என தானாக கண்டறியப்பட்டது
```

**இதன் செயல்:**
- `@Service` இந்த வகுப்பு வர்த்தக தாரகங்களை வழங்கிறதென Springக்கு கூறுகிறது
- `@Value` கட்டமைப்புப் மதிப்புகளை application.properties இருந்து உட்புகுத்துகிறது
- மாதிரி திறன் மேற்கோள் தெரியாது என்றால், இது Foundry Local ஐ ஆரம்பத்தில் கேட்டு கேட்கும் **தானியங்கி கண்டறிதலை** செயல்படுத்துகிறது. அப்படி இருந்தால், செயலி எந்த மாதிரியோ அந்த மாதிரியுடன் வேலை செய்கிறது

#### கிளையண்ட் தொடக்கம்:
```java
@PostConstruct
public void init() {
    // தெளிவாக அமைக்கப்பட না இருந்தால் Foundry Local இல் இருந்து மாதிரியை தானாக கண்டறி
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // அடிப்படைக் URL ஏற்கனவே கட்டமைப்பிலிருந்து /v1 உடன் உள்ளது
            .apiKey("not-needed")            // உள்ளூர் சேவையகத்திற்கு உண்மையான API சாவி தேவையில்லை
            .build();
}
```

**இதன் செயல்:**
- `@PostConstruct` Spring சேவையை உருவாக்கிய பின் இந்த முறைக்கு அழைக்கிறது
- மாதிரி சீரமைக்கப்படாவிட்டால், Foundry Local இன் `/v1/models` முடிகளை கேட்டு முதலாவது மாதிரியை தேர்ந்தெடுக்கிறது
- உங்கள் உள்ளூர் Foundry Local ஆதாரத்துக்கு OpenAI கிளையண்ட் உருவாக்குகிறது
- application.properties இல் base URL ஏற்கனவே `/v1` OpenAI API பொருந்திப்படுத்த உள்ளது
- API விசை வளையமின்றி (authentication இல்லாமல்) "not-needed" என்று அமைக்கப்பட்டுள்ளது ஏனெனில் உள்ளூர் அபிவிருத்திக்கு அவசியம் இல்லை

#### உரையாடல் முறை:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // எந்த AI மாதிரியை பயன்படுத்துவது
                .addUserMessage(message)         // உங்கள் கேள்வி/கோரிக்கை
                .maxCompletionTokens(150)        // பதிலின் நீளத்தை வரையறு
                .temperature(0.7)                // படைப்பாற்றலை கட்டுப்படுத்து (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // API முடிவில் இருந்து AI பதிலை அகற்று
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**இதன் செயல்:**
- **ChatCompletionCreateParams**: AI கோரிக்கையை கட்டமைக்கிறது
  - `model`: பயன்படுத்த வேண்டிய AI மாதிரியை குறிப்பிடுகிறது (தகவல் `foundry model list` இல் உள்ள சரியான ID ஆக இருக்க வேண்டும்)
  - `addUserMessage`: உரையாடலில் உங்கள் செய்தியை சேர்க்கிறது
  - `maxCompletionTokens`: பதிலின் நீளத்தைக் கட்டுப்படுத்துகிறது (மூல நிதிகள் சேமிப்பு)
  - `temperature`: சீரற்ற தன்மையை கட்டுப்படுத்துகிறது (0.0 = தீர்மானித்த, 1.0 = படைப்பாற்றல்)
- **API அழைப்பு**: Foundry Localக்கு கோரிக்கையை அனுப்புகிறது
- **பதில் கையாளுதல்**: AIயின் உரை பதிலை பாதுகாப்பாக எடுத்துக்கொள்கிறது
- **பிழை கையாளுதல்**: உதவிகரமான பிழை செய்திகள் வழங்கி விலக்குகளை சுற்றி கொண்டுள்ளது

### 4. திட்டத்தின் சார்பு கோப்புகள் (pom.xml)

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

**இவை செய்கின்றன:**
- **spring-boot-starter**: முக்கிய Spring Boot செயல்பாடுகளை வழங்குகிறது
- **openai-java**: அதிகாரபூர்வ OpenAI Java SDK API தொடர்புக்காக
- **jackson-databind**: API அழைப்புகளுக்கான JSON தொடரமைப்பு/படி அகற்றல்களை கையாள்கிறது

## எப்பட்டவாறு இது ஒருங்கிணைக்கிறது

நீங்கள் செயல்பாட்டை இயக்கும் போது நிறைவேறும் முழுமையான நடைமுறை இங்கே:

1. **துவக்கம்**: Spring Boot துவங்கி `application.properties` படிக்கிறது
2. **சேவை உருவாக்கல்**: Spring `FoundryLocalService` உருவாக்கி கட்டமைப்பு மதிப்புகளை உட்புகுத்துகிறது
3. **மாதிரி கண்டறிதல்**: மாதிரி அமைக்கப்படாவிட்டால், சேவை Foundry Local இன் `/v1/models` மூலம் கேட்டு முதலாவது கிடைக்கும் மாதிரியை தானாக பயன்படுத்துகிறது
4. **கிளையண்ட் அமைப்பு**: `@PostConstruct` OpenAI கிளையண்டு Foundry Local ஐ இணைக்க உருவாக்கப்படும்
5. **டெமோ நடைமுறை**: `CommandLineRunner` துவக்கத்திற்குப் பின் இயக்கப்படுகிறது
6. **AI அழைப்பு**: டெமோ `foundryLocalService.chat()` ஐச் சோதனை செய்தியுடன் அழைக்கிறது
7. **API கோரிக்கை**: சேவை OpenAI பொருத்தமான கோரிக்கையை Foundry Localக்கு அனுப்புகிறது
8. **பதில் சுருக்கல்**: சேவை AI பதிலை எடுத்துக்கொண்டு திருப்பி அளிக்கிறது
9. **காட்டுதல்**: பயன்பாடு பதிலை அச்சிடுகிறது மற்றும் வெளியேறுகிறது

## Foundry Local அமைத்தல்

1. [முன்னணிப் பொருட்கள்](#முன்-நிபந்தனைகள்) பகுதியில் உள்ள வழிமுறைகளைப் பின்பற்றி **Foundry Local ஐ நிறுவவும்**.

2. சேவை இயக்கப்படவில்லை என்றால், சேவையை துவக்கவும்:
   ```bash
   foundry service start
   ```

3. சேவை இயங்குகிறதா என மற்றும் போர்ட்டை கண்டறியவும்:
   ```bash
   foundry service status
   ```

4. ஒரு மாதிரியை பதிவிறக்கி இயக்கவும் (முதல் முறையாக இயக்கும்போது பதிவிறக்கப்படுகிறது, அடுத்த முறைகளில் கேஷ் செய்யப்படுகிறது):
   ```bash
   foundry model run phi-4-mini
   ```
    இது ஒரு உள்ளடக்க உரையாடல் அம்சத்தைத் திறக்கும். `Ctrl+C` மூலம் வெளியேற முடியும். மாதிரி சேவையில் ஏற்கனவே இயங்கிக் கொண்டிருக்கிறது.

   > **குறிப்பு:** கிடைக்கும் அனைத்து மாதிரிகளையும் பார்க்க `foundry model list` ஓட்டவும். `phi-4-mini` ஐ `qwen2.5-0.5b` போன்ற வேறு பெயரிட்ட மாதிரியில் மாற்றலாம் (சிறிய/வேகமான மாதிரி).

5. மாதிரி ஏற்றப்பட்டதா என்று உறுதி செய்யவும்:
   ```bash
   foundry service ps
   ```

6. தேவையானால் `application.properties` இனை புதுப்பிக்கவும்:
   - இயல்பு `base-url` (`http://localhost:5273/v1`) இயல்பு CLI போர்டுடன் பொருந்தும். `foundry service status` வில் வேறு போர்ட் இருந்தால் மட்டுமே மாற்றவும்.
   - மாதிரி **தானாகத் துவக்கத்தில் கண்டறியப்படுகிறது** — கட்டமைப்பு தேவையில்லை.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## பயன்பாட்டை இயக்கல்

### படி 1: Foundry Localல் ஒரு மாதிரி ஏற்றப்பட்டுள்ளது என்று உறுதி செய்யவும்
```bash
foundry service ps
```
மாதிரிகள் இல்லாவிட்டால், ஒரு மாதிரியை ஏற்றவும்:
```bash
foundry model run phi-4-mini
```

### படி 2: பயன்பாட்டை கட்டி இயக்கவும்
வேறு ஒரு டெர்மினலில்:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

அல்லது JAR ஆக கட்டி இயக்கவும்:
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
Hello! I'm Phi, an AI developed by Microsoft. I can assist with a wide variety of 
tasks including answering questions, helping with analysis, creative writing, coding, 
and general conversation. How can I help you today?
=========================
```

## அடுத்த படிகள்

மேலும் உதாரணங்களுக்காக, [அத்தியாயம் 04: நடைமுறை உதாரணங்கள்](../README.md) பார்க்கவும்

## சிக்கல் தீர்வுகள்

### பொதுவான பிரச்சனைகள்

**"இணைப்பு நிராகரிக்கப்பட்டது" அல்லது "சேவை கிடைக்கவில்லை"**
- சேவையை சரிபார்க்கவும்: `foundry service status`
- தேவைப்பட்டால் மீண்டும் துவக்கவும்: `foundry service restart`
- `application.properties` இல் போர்ட் `foundry service status`லுள்ளதுடன் பொருந்துகிறதா கண்டு கொள்ளவும்
- URLக்கு `/v1` எழுத்து சேர்த்துள்ளீர்களா: `http://localhost:5273/v1`

**"மாதிரி கிடைக்கவில்லை" துவக்கத்தில்**
- செயலி தானாக மாதிரியை கண்டறிகிறது. குறைந்தது ஒரு மாதிரி ஏற்றப்பட்டிருக்க வேண்டும்: `foundry service ps`
- மாதிரிகள் ஏற்றப்படவில்லை என்றால்: `foundry model run phi-4-mini`
- `application.properties` இல் நீங்கள் மாதிரி பெயரை மாற்றினால், அது `foundry model list`இல் உள்ளதைப் பொருந்தியிருக்க வேண்டும்

**"400 தவறான கோரிக்கை" பிழைகள்**
- base URLல் `/v1` சேர்ப்பு சரிபார்க்கவும்: `http://localhost:5273/v1`
- உங்கள் குறியீட்டில் `maxCompletionTokens()` பயன்படுத்தி உள்ளீர்களா (பழைய `maxTokens()` இல்லை என்பதை உறுதிசெய்யவும்)

**Maven தொகுப்பு பிழைகள்**
- Java 21 அல்லது மேலானது உள்ளதா: `java -version`
- சுத்தமாக கட்டி முயற்சி செய்யவும்: `mvn clean compile`
- சார்பு பதிவிறக்கத்திற்கு இணையதளம் சரிபார்க்கவும்

**சேவை இணைப்பு பிரச்சினைகள்**
- `Request to local service failed` எனினும், `foundry service restart` ஓட்டவும்
- ஏற்றப்பட்ட மாதிரிகளை சரிபார்க்கவும்: `foundry service ps`
- சேவை பதிவு கோப்புகளைப் பார்க்க: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**தயவுசெய்து கவனிக்கவும்**:  
இந்த ஆவணம் [Co-op Translator](https://github.com/Azure/co-op-translator) என்ற க人工 நுட்ப மொழி மாற்ற சேவையை பயன்படுத்தி மொழிமாற்றம் செய்யப்பட்டுள்ளது. நாங்கள் சரியானளவில் முயற்சி செய்தாலும், இயந்திர மொழிபெயர்ப்புகளில் பிழைகள் அல்லது தவறுகள் உள்ளதாயிருக்கலாம் என்பதை தயவுசெய்து அறிந்துகொள்ளுங்கள். முதன்மை மொழியில் இருக்கும் அசல் ஆவணம் அதிகாரபூர்வமான மூலமாகக் கொள்ளப்பட வேண்டும். முக்கியமான தகவல்களுக்கு, தொழில்முறை மனித மொழிபெயர்ப்பு பரிந்துரைக்கப்படுகிறது. இந்த மொழிபெயர்ப்பின் பயன்பாட்டு தொடர்பான எந்தப் புரிதல்களும் அல்லது தவறான விளக்கங்களுக்கும் நாங்கள் பொறுப்பேற்க மாட்டோம்.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->