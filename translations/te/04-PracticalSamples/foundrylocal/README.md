<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "f787307400de59adc25a1404466a35f3",
  "translation_date": "2025-12-01T09:21:08+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "te"
}
-->
# Foundry Local Spring Boot ట్యుటోరియల్

## విషయ సూచిక

- [ముందస్తు అవసరాలు](../../../../04-PracticalSamples/foundrylocal)
- [ప్రాజెక్ట్ అవలోకనం](../../../../04-PracticalSamples/foundrylocal)
- [కోడ్‌ను అర్థం చేసుకోవడం](../../../../04-PracticalSamples/foundrylocal)
  - [1. అప్లికేషన్ కాన్ఫిగరేషన్ (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. మెయిన్ అప్లికేషన్ క్లాస్ (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. AI సర్వీస్ లేయర్ (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. ప్రాజెక్ట్ డిపెండెన్సీలు (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [అన్నీ కలిసి ఎలా పనిచేస్తాయి](../../../../04-PracticalSamples/foundrylocal)
- [Foundry Local సెటప్ చేయడం](../../../../04-PracticalSamples/foundrylocal)
- [అప్లికేషన్‌ను రన్ చేయడం](../../../../04-PracticalSamples/foundrylocal)
- [అంచనా ఫలితాలు](../../../../04-PracticalSamples/foundrylocal)
- [తదుపరి దశలు](../../../../04-PracticalSamples/foundrylocal)
- [ట్రబుల్‌షూటింగ్](../../../../04-PracticalSamples/foundrylocal)

## ముందస్తు అవసరాలు

ఈ ట్యుటోరియల్ ప్రారంభించడానికి ముందు, మీ వద్ద ఉండాలి:

- **Java 21 లేదా అంతకంటే ఎక్కువ** మీ సిస్టమ్‌లో ఇన్‌స్టాల్ చేయబడింది
- **Maven 3.6+** ప్రాజెక్ట్‌ను బిల్డ్ చేయడానికి
- **Foundry Local** ఇన్‌స్టాల్ చేయబడింది మరియు రన్ అవుతోంది

### **Foundry Local ఇన్‌స్టాల్ చేయండి:**

```bash
# విండోస్
winget install Microsoft.FoundryLocal

# మాక్‌ఓఎస్ (ఇన్‌స్టాల్ చేసిన తర్వాత)
foundry model run phi-3.5-mini
```


## ప్రాజెక్ట్ అవలోకనం

ఈ ప్రాజెక్ట్ నాలుగు ప్రధాన భాగాలను కలిగి ఉంటుంది:

1. **Application.java** - ప్రధాన Spring Boot అప్లికేషన్ ఎంట్రీ పాయింట్
2. **FoundryLocalService.java** - AI కమ్యూనికేషన్‌ను నిర్వహించే సర్వీస్ లేయర్
3. **application.properties** - Foundry Local కనెక్షన్ కోసం కాన్ఫిగరేషన్
4. **pom.xml** - Maven డిపెండెన్సీలు మరియు ప్రాజెక్ట్ కాన్ఫిగరేషన్

## కోడ్‌ను అర్థం చేసుకోవడం

### 1. అప్లికేషన్ కాన్ఫిగరేషన్ (application.properties)

**ఫైల్:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```


**ఇది ఏమి చేస్తుంది:**
- **base-url**: Foundry Local ఎక్కడ రన్ అవుతోంది అనేది స్పెసిఫై చేస్తుంది, `/v1` పాత్ OpenAI API అనుకూలత కోసం చేర్చబడింది. **గమనిక**: Foundry Local డైనమిక్‌గా పోర్ట్‌ను అసైన్ చేస్తుంది, కాబట్టి `foundry service status` ఉపయోగించి మీ అసలు పోర్ట్‌ను చెక్ చేయండి
- **model**: టెక్స్ట్ జనరేషన్ కోసం ఉపయోగించాల్సిన AI మోడల్ పేరు, వెర్షన్ నంబర్‌తో సహా (ఉదా., `:1`). `foundry model list` ఉపయోగించి అందుబాటులో ఉన్న మోడల్స్ మరియు వాటి ఖచ్చితమైన IDs చూడండి

**ముఖ్యమైన కాన్సెప్ట్:** Spring Boot ఈ ప్రాపర్టీస్‌ను ఆటోమేటిక్‌గా లోడ్ చేసి, `@Value` అనోటేషన్ ఉపయోగించి మీ అప్లికేషన్‌కు అందుబాటులో ఉంచుతుంది.

### 2. మెయిన్ అప్లికేషన్ క్లాస్ (Application.java)

**ఫైల్:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // వెబ్ సర్వర్ అవసరం లేదు
        app.run(args);
    }
```


**ఇది ఏమి చేస్తుంది:**
- `@SpringBootApplication` Spring Boot ఆటో-కాన్ఫిగరేషన్‌ను ఎనేబుల్ చేస్తుంది
- `WebApplicationType.NONE` Spring ఇది వెబ్ సర్వర్ కాకుండా కమాండ్-లైన్ అప్లికేషన్ అని చెబుతుంది
- మెయిన్ మెథడ్ Spring అప్లికేషన్‌ను ప్రారంభిస్తుంది

**డెమో రన్నర్:**
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


**ఇది ఏమి చేస్తుంది:**
- `@Bean` Spring నిర్వహించే ఒక కాంపోనెంట్‌ను క్రియేట్ చేస్తుంది
- `CommandLineRunner` Spring Boot ప్రారంభమైన తర్వాత కోడ్‌ను రన్ చేస్తుంది
- `foundryLocalService` Spring ద్వారా ఆటోమేటిక్‌గా ఇంజెక్ట్ చేయబడుతుంది (డిపెండెన్సీ ఇంజెక్షన్)
- AIకి ఒక టెస్ట్ మెసేజ్‌ను పంపి, రిస్పాన్స్‌ను ప్రదర్శిస్తుంది

### 3. AI సర్వీస్ లేయర్ (FoundryLocalService.java)

**ఫైల్:** `src/main/java/com/example/FoundryLocalService.java`

#### కాన్ఫిగరేషన్ ఇంజెక్షన్:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```


**ఇది ఏమి చేస్తుంది:**
- `@Service` Spring ఈ క్లాస్ బిజినెస్ లాజిక్‌ను అందిస్తుందని చెబుతుంది
- `@Value` application.properties నుండి కాన్ఫిగరేషన్ విలువలను ఇంజెక్ట్ చేస్తుంది
- `:default-value` సింటాక్స్ ప్రాపర్టీస్ సెట్ చేయబడని సందర్భంలో ఫాల్బ్యాక్ విలువలను అందిస్తుంది

#### క్లయింట్ ఇనిషియలైజేషన్:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // బేస్ URL ఇప్పటికే కాన్ఫిగరేషన్ నుండి /v1 ను కలిగి ఉంది
            .apiKey("not-needed")            // లోకల్ సర్వర్ నిజమైన API కీ అవసరం లేదు
            .build();
}
```


**ఇది ఏమి చేస్తుంది:**
- `@PostConstruct` Spring ఈ సర్వీస్‌ను క్రియేట్ చేసిన తర్వాత ఈ మెథడ్‌ను రన్ చేస్తుంది
- మీ స్థానిక Foundry Local instanceకి పాయింట్ చేసే OpenAI క్లయింట్‌ను క్రియేట్ చేస్తుంది
- `application.properties` నుండి base URL ఇప్పటికే OpenAI API అనుకూలత కోసం `/v1` కలిగి ఉంటుంది
- స్థానిక డెవలప్‌మెంట్ ఆథెంటికేషన్ అవసరం లేకపోవడంతో API key "not-needed"గా సెట్ చేయబడింది

#### చాట్ మెథడ్:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // ఏ AI మోడల్ ఉపయోగించాలి
                .addUserMessage(message)         // మీ ప్రశ్న/ప్రాంప్ట్
                .maxCompletionTokens(150)        // ప్రతిస్పందన పొడవును పరిమితం చేయండి
                .temperature(0.7)                // సృజనాత్మకతను నియంత్రించండి (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // API ఫలితం నుండి AI యొక్క ప్రతిస్పందనను తీసుకోండి
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```


**ఇది ఏమి చేస్తుంది:**
- **ChatCompletionCreateParams**: AI రిక్వెస్ట్‌ను కాన్ఫిగర్ చేస్తుంది
  - `model`: ఏ AI మోడల్‌ను ఉపయోగించాలో స్పెసిఫై చేస్తుంది (ఖచ్చితమైన ID `foundry model list` నుండి మ్యాచ్ చేయాలి)
  - `addUserMessage`: మీ మెసేజ్‌ను సంభాషణకు జోడిస్తుంది
  - `maxCompletionTokens`: రిస్పాన్స్ ఎంత పొడవుగా ఉండాలో పరిమితం చేస్తుంది (వనరులను సేవ్ చేస్తుంది)
  - `temperature`: రాండమ్‌నెస్‌ను నియంత్రిస్తుంది (0.0 = డిటర్మినిస్టిక్, 1.0 = క్రియేటివ్)
- **API కాల్**: Foundry Localకు రిక్వెస్ట్‌ను పంపుతుంది
- **రిస్పాన్స్ హ్యాండ్లింగ్**: AI యొక్క టెక్స్ట్ రిస్పాన్స్‌ను సురక్షితంగా ఎక్స్‌ట్రాక్ట్ చేస్తుంది
- **ఎర్రర్ హ్యాండ్లింగ్**: సహాయకమైన ఎర్రర్ మెసేజ్‌లతో ఎక్సెప్షన్‌లను ర్యాప్ చేస్తుంది

### 4. ప్రాజెక్ట్ డిపెండెన్సీలు (pom.xml)

**ముఖ్యమైన డిపెండెన్సీలు:**

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


**ఇవి ఏమి చేస్తాయి:**
- **spring-boot-starter**: Spring Boot యొక్క కోర్ ఫంక్షనాలిటీని అందిస్తుంది
- **openai-java**: API కమ్యూనికేషన్ కోసం అధికారిక OpenAI Java SDK
- **jackson-databind**: API కాల్స్ కోసం JSON సీరియలైజేషన్/డీసీరియలైజేషన్‌ను నిర్వహిస్తుంది

## అన్నీ కలిసి ఎలా పనిచేస్తాయి

మీరు అప్లికేషన్‌ను రన్ చేసినప్పుడు పూర్తి ఫ్లో ఇక్కడ ఉంది:

1. **స్టార్టప్**: Spring Boot ప్రారంభమై `application.properties`ను చదువుతుంది
2. **సర్వీస్ క్రియేషన్**: Spring `FoundryLocalService`ను క్రియేట్ చేసి, కాన్ఫిగరేషన్ విలువలను ఇంజెక్ట్ చేస్తుంది
3. **క్లయింట్ సెటప్**: `@PostConstruct` OpenAI క్లయింట్‌ను Foundry Localకు కనెక్ట్ చేయడానికి ఇనిషియలైజ్ చేస్తుంది
4. **డెమో ఎగ్జిక్యూషన్**: `CommandLineRunner` స్టార్టప్ తర్వాత ఎగ్జిక్యూట్ అవుతుంది
5. **AI కాల్**: డెమో `foundryLocalService.chat()`తో టెస్ట్ మెసేజ్‌ను పంపుతుంది
6. **API రిక్వెస్ట్**: సర్వీస్ OpenAI-కంపాటిబుల్ రిక్వెస్ట్‌ను Foundry Localకు పంపుతుంది
7. **రిస్పాన్స్ ప్రాసెసింగ్**: సర్వీస్ రిస్పాన్స్‌ను ఎక్స్‌ట్రాక్ట్ చేసి రిటర్న్ చేస్తుంది
8. **డిస్ప్లే**: అప్లికేషన్ రిస్పాన్స్‌ను ప్రింట్ చేసి ఎగ్జిట్ అవుతుంది

## Foundry Local సెటప్ చేయడం

Foundry Localను సెటప్ చేయడానికి ఈ స్టెప్స్‌ను ఫాలో అవండి:

1. **Foundry Local ఇన్‌స్టాల్ చేయండి** [ముందస్తు అవసరాలు](../../../../04-PracticalSamples/foundrylocal) సెక్షన్‌లోని ఇన్‌స్ట్రక్షన్స్‌ను ఉపయోగించి.

2. **డైనమిక్‌గా అసైన్ చేయబడిన పోర్ట్‌ను చెక్ చేయండి**. Foundry Local ప్రారంభమైనప్పుడు ఆటోమేటిక్‌గా పోర్ట్‌ను అసైన్ చేస్తుంది. మీ పోర్ట్‌ను కనుగొనడానికి:
   ```bash
   foundry service status
   ```
   
   **ఐచ్ఛికం**: మీరు ఒక నిర్దిష్ట పోర్ట్ (ఉదా., 5273) ఉపయోగించాలనుకుంటే, మీరు దానిని మాన్యువల్‌గా కాన్ఫిగర్ చేయవచ్చు:
   ```bash
   foundry service set --port 5273
   ```


3. **మీరు ఉపయోగించాలనుకుంటున్న AI మోడల్‌ను డౌన్‌లోడ్ చేయండి**, ఉదాహరణకు, `phi-3.5-mini`, ఈ కమాండ్‌తో:
   ```bash
   foundry model run phi-3.5-mini
   ```


4. **application.properties ఫైల్‌ను మీ Foundry Local సెట్టింగ్స్‌కు అనుగుణంగా కాన్ఫిగర్ చేయండి**:
   - `base-url`లో పోర్ట్‌ను అప్‌డేట్ చేయండి (స్టెప్ 2 నుండి), ఇది `/v1`తో ముగియాలి
   - మోడల్ పేరు వెర్షన్ నంబర్‌తో అప్‌డేట్ చేయండి (`foundry model list`తో చెక్ చేయండి)

   ఉదాహరణ:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```


## అప్లికేషన్‌ను రన్ చేయడం

### స్టెప్ 1: Foundry Local ప్రారంభించండి
```bash
foundry model run phi-3.5-mini
```


### స్టెప్ 2: అప్లికేషన్‌ను బిల్డ్ చేసి రన్ చేయండి
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```


## అంచనా ఫలితాలు

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


## తదుపరి దశలు

మరిన్ని ఉదాహరణల కోసం, [Chapter 04: Practical samples](../README.md) చూడండి

## ట్రబుల్‌షూటింగ్

### సాధారణ సమస్యలు

**"Connection refused" లేదా "Service unavailable"**
- Foundry Local రన్ అవుతున్నదని నిర్ధారించండి: `foundry model list`
- Foundry Local ఉపయోగిస్తున్న అసలు పోర్ట్‌ను చెక్ చేయండి: `foundry service status`
- మీ `application.properties`ను సరైన పోర్ట్‌తో అప్‌డేట్ చేయండి, URL `/v1`తో ముగియాలి
- ఐచ్ఛికంగా, మీరు నిర్దిష్ట పోర్ట్‌ను సెట్ చేయవచ్చు: `foundry service set --port 5273`
- Foundry Localను రీస్టార్ట్ చేయడానికి ప్రయత్నించండి: `foundry model run phi-3.5-mini`

**"Model not found" లేదా "404 Not Found" ఎర్రర్స్**
- ఖచ్చితమైన IDsతో అందుబాటులో ఉన్న మోడల్స్‌ను చెక్ చేయండి: `foundry model list`
- `application.properties`లో మోడల్ పేరును ఖచ్చితంగా అప్‌డేట్ చేయండి, వెర్షన్ నంబర్‌తో సహా (ఉదా., `Phi-3.5-mini-instruct-cuda-gpu:1`)
- `base-url` `/v1`తో ముగియాలని నిర్ధారించండి: `http://localhost:5273/v1`
- అవసరమైతే మోడల్‌ను డౌన్‌లోడ్ చేయండి: `foundry model run phi-3.5-mini`

**"400 Bad Request" ఎర్రర్స్**
- base URL `/v1`తో ముగియాలని నిర్ధారించండి: `http://localhost:5273/v1`
- మోడల్ ID `foundry model list`లో చూపినదానికి ఖచ్చితంగా మ్యాచ్ అవుతుందని చెక్ చేయండి
- మీ కోడ్‌లో `maxCompletionTokens()` ఉపయోగిస్తున్నారని నిర్ధారించండి (డిప్రికేటెడ్ `maxTokens()` కాకుండా)

**Maven కంపైలేషన్ ఎర్రర్స్**
- Java 21 లేదా అంతకంటే ఎక్కువ ఉందని నిర్ధారించండి: `java -version`
- క్లీన్ చేసి రీబిల్డ్ చేయండి: `mvn clean compile`
- డిపెండెన్సీ డౌన్‌లోడ్స్ కోసం ఇంటర్నెట్ కనెక్షన్ చెక్ చేయండి

**అప్లికేషన్ ప్రారంభమై కానీ అవుట్‌పుట్ లేదు**
- Foundry Local స్పందిస్తున్నదని నిర్ధారించండి: `http://localhost:5273/v1/models` చెక్ చేయండి లేదా `foundry service status` రన్ చేయండి
- స్పెసిఫిక్ ఎర్రర్ మెసేజ్‌ల కోసం అప్లికేషన్ లాగ్‌లను చెక్ చేయండి
- మోడల్ పూర్తిగా లోడ్ చేయబడిందని మరియు రెడీగా ఉందని నిర్ధారించండి

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**విమర్శ**:  
ఈ పత్రాన్ని AI అనువాద సేవ [Co-op Translator](https://github.com/Azure/co-op-translator) ఉపయోగించి అనువదించారు. మేము ఖచ్చితత్వానికి ప్రయత్నిస్తున్నప్పటికీ, ఆటోమేటెడ్ అనువాదాలలో తప్పులు లేదా అసమానతలు ఉండవచ్చు. దయచేసి, మూల భాషలో ఉన్న అసలు పత్రాన్ని అధికారం కలిగిన మూలంగా పరిగణించండి. ముఖ్యమైన సమాచారం కోసం, ప్రొఫెషనల్ మానవ అనువాదాన్ని సిఫారసు చేస్తాము. ఈ అనువాదాన్ని ఉపయోగించడం వల్ల కలిగే ఏవైనా అపార్థాలు లేదా తప్పుదారులు కోసం మేము బాధ్యత వహించము.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->