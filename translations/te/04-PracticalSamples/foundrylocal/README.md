# ఫౌన్రీ లోకల్ స్ప్రింగ్ బూట్ ట్యూటోరియల్

## సూచిక

- [ముందస్తు పరిజ్ఞానం](#ముందస్తు-పరిజ్ఞానం)
- [ప్రాజెక్ట్ అవలోకనం](#ప్రాజెక్ట్-అవలోకనం)
- [కోడ్ అర్థం చేసుకోవడం](#కోడ్-అర్థం-చేసుకోవడం)
  - [1. అప్లికేషన్ కాన్ఫిగరేషన్ (application.properties)](#1-అప్లికేషన్-కాన్ఫిగరేషన్-applicationproperties)
  - [2. మెయిన్ అప్లికేషన్ క్లాస్ (Application.java)](#2-మెయిన్-అప్లికేషన్-క్లాస్-applicationjava)
  - [3. AI సర్వీస్ లేయర్ (FoundryLocalService.java)](#3-ai-సర్వీస్-లేయర్-foundrylocalservicejava)
  - [4. ప్రాజెక్ట్ డిపెండెన్సీలు (pom.xml)](#4-ప్రాజెక్ట్-డిపెండెన్సీలు-pomxml)
- [ఇది ఎలా కలిసి పనిచేస్తుంది](#ఇది-ఎలా-కలిసి-పనిచేస్తుంది)
- [ఫౌన్రీ లోకల్ సెటప్ చేయడం](#ఫౌన్రీ-లోకల్-సెటప్-చేయడం)
- [అప్లికేషన్ నడపడం](#అప్లికేషన్-నడపడం)
- [నిరాకరించబడిన అవుట్పుట్](#నిరాకరించబడిన-అవుట్పుట్)
- [తర్వాతి దశలు](#తర్వాతి-దశలు)
- [తొలగింపుల నివారణ](#తొలగింపుల-నివారణ)


## ముందస్తు పరిజ్ఞానం

ఈ ట్యూటోరియల్ ప్రారంభించే ముందు, మీరు నిర్ధారించుకోండి:

- **Java 21 లేదా అంతకంటే పైభాగం** మీ సిస్టమ్లో ఇన్‌స్టాల్ అయి ఉందని
- **Maven 3.6+** ప్రాజెక్ట్ నిర్మించే కోసం
- **Foundry Local** ఇన్‌స్టాల్ చేసి నడుస్తోంది

### **Foundry Local ఇన్‌స్టాల్ చేయండి:**

> **గమనిక:** Foundry Local CLI **Windows** మరియు **macOS** కోసం మాత్రమే అందుబాటులో ఉంటుంది. లినక్స్ కోసం [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust) ద్వారా మద్దతు ఉంటుంది.

```bash
# విండోస్
winget install Microsoft.FoundryLocal

# మాకోఎస్
brew tap microsoft/foundrylocal
brew install foundrylocal
```

ఇన్‌స్టలేషన్‌ను నిర్ధారించండి:
```bash
foundry --version
```

## ప్రాజెక్ట్ అవలోకనం

ఈ ప్రాజెక్ట్ నాలుగు ప్రధాన భాగాల నుండి కూడి ఉంటుంది:

1. **Application.java** - ప్రధాన స్ప్రింగ్ బూట్ అప్లికేషన్ ప్రవేశ బిందువు
2. **FoundryLocalService.java** - AI కమ్యూనికేషన్ నిర్వహించే సర్వీస్ లేయర్
3. **application.properties** - Foundry Local కనెక్షన్ కాన్ఫిగరేషన్
4. **pom.xml** - Maven డిపెండెన్సీలు మరియు ప్రాజెక్ట్ కాన్ఫిగరేషన్

## కోడ్ అర్థం చేసుకోవడం

### 1. అప్లికేషన్ కాన్ఫిగరేషన్ (application.properties)

**ఫైల్:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**ఇది ఏమి చేస్తుంది:**
- **base-url**: Foundry Local ఎక్కడ నడుస్తోందో సూచిస్తుంది, OpenAI API అనుగుణంగా `/v1` పాథ్‌తో సహా. డిఫాల్ట్ పోర్ట్ `5273`. పోర్ట్ వేరైతే, `foundry service status` ద్వారా చెక్ చేయండి.
- **model** (ఐచ్ఛికం): టెక్స్ట్ జనరేషన్ కోసం ఉపయోగించే AI మోడల్ పేరు. **డిఫాల్ట్ గా, అప్లికేషన్ Foundry Local `/v1/models` ఎండ్‌పాయింట్‌ను స్టార్ట్‌అప్‌లో క్విల్యరి చేసి మోడల్‌ను ఆటో-డిటెక్ట్ చేస్తుంది**, కాబట్టి మీరు దాన్ని సెట్ చేయాల్సిన అవసరం లేదు. అవసరమైతే స్పష్టంగా సెట్ చేయవచ్చు.

**ప్రధాన భావన:** స్ప్రింగ్ బూట్ ఈ ప్రాపర్టీస్‌ను ఆటోమేటిక్‌గా లోడ్ చేసి, `@Value` యానోటేషన్ ఉపయోగించి మీ అప్లికేషన్‌కు అందజేస్తుంది.

### 2. మెయిన్ అప్లికేషన్ క్లాస్ (Application.java)

**ఫైల్:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // ఏ వెబ్ సర్వర్ అవసరం లేదు
        app.run(args);
    }
```

**ఇది ఏమి చేస్తుంది:**
- `@SpringBootApplication` స్ప్రింగ్ బూట్ ఆటో-కాన్ఫిగరేషన్‌ను ఎనేబుల్ చేస్తుంది
- `WebApplicationType.NONE` స్ప్రింగ్‌కు ఇది వెబ్ సర్వర్ కాకుండా కమాండ్-లైన్ యాప్ అని తెలియజేస్తుంది
- మెయిన్ మెతడ్ స్ప్రింగ్ అప్లికేషన్‌ను ప్రారంభిస్తుంది

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
- `@Bean` స్ప్రింగ్ నిర్వహించే కంపోనెంట్ సృష్టిస్తుంది
- `CommandLineRunner` స్ప్రింగ్ బూట్ ప్రారంభమైన తర్వాత కోడ్ నడిపిస్తుంది
- `foundryLocalService` స్ప్రింగ్ ఆటోమేటిక్‌గా ఇంజెక్ట్ చేస్తుంది (డిపెండెన్సీ ఇంజెక్షన్)
- AIకి టెస్ట్ సందేశం పంపి, ప్రతిస్పందనను చూపిస్తుంది

### 3. AI సర్వీస్ లేయర్ (FoundryLocalService.java)

**ఫైల్:** `src/main/java/com/example/FoundryLocalService.java`

#### కాన్ఫిగరేషన్ ఇంజెక్షన్:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // ఖాళీగా ఉంటే ఆటోగా గుర్తించబడింది
```

**ఇది ఏమి చేస్తుంది:**
- `@Service` స్ప్రింగ్‌కి ఈ క్లాస్ బిజినెస్ లాజిక్ అందిస్తుంది అని చెబుతుంది
- `@Value` application.properties నుండి కాన్ఫిగరేషన్ విలువలను ఇంజెక్ట్ చేస్తుంది
- మోడల్ ఉంటే ఖాళీగా ఉంటే, ఇది Foundry Local నుండి స్టార్ట్‌అప్ వద్ద **ఆటో-డిటెక్షన్** ఆప్షన్ ప్రేరేపిస్తుంది. అంటే ఏదైనా లోడ్ అయిన మోడల్‌తో ఈ యాప్ పనిచేస్తుంది, మాన్యువల్ కాన్ఫిగరేషన్ అవసరం లేదు

#### క్లయింట్ ప్రారంభం:
```java
@PostConstruct
public void init() {
    // స్పష్టంగా కాన్ఫిగర్ చేయబడకపోతే Foundry Local నుండి మోడల్‌ను ఆటోమేటిక్‌గా గుర్తించండి
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // బయస్ URL ఇప్పటికే కాన్ఫిగరేషన్ నుండి /v1 ను కలిగి ఉంది
            .apiKey("not-needed")            // లోకల్ సర్వర్‌కు నిజమైన API కీల్లు అవసరం లేదు
            .build();
}
```

**ఇది ఏమి చేస్తుంది:**
- `@PostConstruct` స్ప్రింగ్ సర్వీస్ సృష్టించిన తర్వాత ఈ మెతడ్ నడిపిస్తుంది
- మోడల్ సెట్ కానప్పుడు, Foundry Local `/v1/models` ఎండ్‌పాయింట్‌ను క్విల్యరి చేసి మొదటి లోడ్ అయిన మోడల్‌ను ఎంచుకుంటుంది
- మీరు లోకల్ Foundry Local ఇన్స్టెన్స్ కు పాయింట్ చేసే OpenAI క్లయింట్ సృష్టిస్తుంది
- application.properties నుండి base URL ఇప్పటికే OpenAI API అనుగుణంగా `/v1`ను కలిగి ఉంటుంది
- API కీ "not-needed"గా సెట్ చేయబడి ఉంది, ఎందుకంటే లోకల్ డెవలప్‌మెంట్‌లో ధృవీకరణ అవసరం లేదు

#### చాట్ మెతడ్:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // ఏ ఏఐ మోడల్ ఉపయోగించాలి
                .addUserMessage(message)         // మీ ప్రశ్న/ప్రాంప్ట్
                .maxCompletionTokens(150)        // స్పందన పొడవు పరిమితం చేయండి
                .temperature(0.7)                // సృజనాత్మకత నియంత్రించండి (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // API ఫలితం నుంచి ఏఐ యొక్క స్పందనను తీసుకోండి
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
- **ChatCompletionCreateParams**: AI అభ్యర్థనను కాన్ఫిగర్ చేస్తుంది
  - `model`: ఉపయోగించే AI మోడల్ ను పేర్కొంటుంది (exact ID తో `foundry model list` నుండి సరిపోలాలి)
  - `addUserMessage`: మీ సందేశాన్ని సంభాషణలో జత చేస్తుంది
  - `maxCompletionTokens`: జవాబు పొడవును పరిమితం చేస్తుంది (సంప్రదాయ వనరుల పరిరక్షణ)
  - `temperature`: యాదృచ్ఛికత నియంత్రిస్తుంది (0.0 = నిర్దిష్టమైన, 1.0 = సృజనాత్మక)
- **API కాల్**: Foundry Localకి అభ్యర్థన పంపుతుంది
- **ప్రతిస్పందన ప్రాసెసింగ్**: AI యొక్క టెక్స్ట్ ప్రతిస్పందనను సురక్షితంగా తీసుకుంటుంది
- **లోపం నిర్వహణ**: సహాయక లోప సందేశాలతో ఎక్స్‌సెప్షన్స్‌ను వ్రాప్ చేస్తుంది

### 4. ప్రాజెక్ట్ డిపెండెన్సీలు (pom.xml)

**ప్రధాన డిపెండెన్సీలు:**

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
- **spring-boot-starter**: కోర్ స్ప్రింగ్ బూట్ ఫంక్షనాలిటీ అందిస్తుంది
- **openai-java**: అధికారిక OpenAI జావా SDK API కమ్యూనికేషన్ కోసం
- **jackson-databind**: API కాల్స్ JSON సీరియలైజేషన్/డీసీరియలైజేషన్ నిర్వహిస్తుంది

## ఇది ఎలా కలిసి పనిచేస్తుంది

మీరు అప్లికేషన్ నడపగానే పూర్తి ఫ్లో ఇలా ఉంటుంది:

1. **స్టార్ట్‌అప్**: స్ప్రింగ్ బూట్ ప్రారంభమై `application.properties` చదవడం
2. **సర్వీస్ సృష్టి**: స్ప్రింగ్ `FoundryLocalService`ను సృష్టించి కాన్ఫిగర్ విలువలను ఇంజెక్ట్ చేస్తుంది
3. **మోడల్ గుర్తింపు**: మోడల్ సెట్ కానపోతే, సర్వీస్ Foundry Local `/v1/models` ఎండ్‌పాయింట్‌ను క్విల్యరి చేసి మొదటి అందుబాటులో ఉన్న మోడల్‌ను ఆటోమేటిక్ గా ఉపయోగిస్తుంది
4. **క్లయింట్ సెటప్**: `@PostConstruct` OpenAI క్లయింట్‌ను Foundry Localతో కనెక్ట్ అయ్యేటట్లు ఇనిషియలైజ్ చేస్తుంది
5. **డెమో అమలు**: `CommandLineRunner` స్టార్ట్‌అప్ తర్వాత నడుస్తుంది
6. **AI కాల్**: డెమో `foundryLocalService.chat()` మెతడ్‌ను టెస్ట్ మెసేజ్‌తో పిలుస్తుంది
7. **API అభ్యర్థన**: సర్వీస్ OpenAI అనుగుణంగా అభ్యర్థనను తయారు చేసి Foundry Localకి పంపిస్తుంది
8. **ప్రతిస్పందన ప్రాసెసింగ్**: సర్వీస్ AI ప్రతిస్పందన తీసుకుంటుంది మరియు వాపాస్ చేస్తుంది
9. **ప్రదర్శన**: అప్లికేషన్ ప్రతిస్పందనను ప్రింట్ చేసి బయటకు వస్తుంది

## ఫౌన్రీ లోకల్ సెటప్ చేయడం

1. [ముందస్తు పరిజ్ఞానం](#ముందస్తు-పరిజ్ఞానం) విభాగంలో ఇచ్చిన సూచనల ప్రకారం **Foundry Local ఇన్‌స్టాల్ చేయండి**.

2. **సర్వీస్ ప్రారంభించండి** (ఇంతవరకు ప్రారంభించకపోతే):
   ```bash
   foundry service start
   ```

3. **సర్వీస్ స్థితిని తనిఖీ చేయండి** మరియు పోర్ట్ గమనించండి:
   ```bash
   foundry service status
   ```

4. **మోడల్ డౌన్లోడ్ చేసి నడపండి** (మొదటి రన్ లో డౌన్లోడ్ చేయబడుతుంది, తర్వాతి రన్లకు క్యాష్ చేయబడింది):
   ```bash
   foundry model run phi-4-mini
   ```
   ఇది ఇంటరాక్టివ్ చాట్ సెషన్ ను ఓపెన్ చేస్తుంది. మీరు `Ctrl+C` తో బహిష్కరించవచ్చు. మోడల్ సర్వీస్ లో లోడ్ అయి ఉంటుంది.

   > **సలహా:** `foundry model list` ను నడపండి అందుబాటులో ఉన్న అన్ని మోడల్స్ చూడటానికి. `phi-4-mini` ని అవసరమైతే క్యాటలాగ్‌లోని ఏ ఇతర అలియాస్ తో మార్చండి (ఉదా: `qwen2.5-0.5b` ఒక చిన్న/వేగవంతమైన మోడల్ కోసం).

5. **మోడల్ లోడ్ అయిందేమో నిర్ధారించండి:**
   ```bash
   foundry service ps
   ```

6. అవసరమైతే **`application.properties` నవీకరించండి:**
   - డిఫాల్ట్ `base-url` (`http://localhost:5273/v1`) డిఫాల్ట్ CLI పోర్ట్ తో సరిపోలుతుంది. `foundry service status` వేరియల్ పోర్ట్ చూపిస్తే మాత్రమే నవీకరించండి.
   - మోడల్ స్టార్ట్‌అప్ సమయంలో ఆటో-డిటెక్ట్ అవుతుంది — ఎటువంటి సెటప్ అవసరం లేదు.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## అప్లికేషన్ నడపడం

### దశ 1: Foundry Localలో ఒక మోడల్ లోడ్ అయిందని నిర్ధారించుకోండి
```bash
foundry service ps
```
మోడల్స్ ఏవీ లేకుంటే లోడ్ చేయండి:
```bash
foundry model run phi-4-mini
```

### దశ 2: అప్లికేషన్ నిర్మించి నడపండి
వేరే టెర్మినల్లో:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

లేదా JAR గా రూపొందించి నడపండి:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## నిరాకరించబడిన అవుట్పుట్

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

## తర్వాతి దశలు

మరిన్ని ఉదాహరణల కోసం, చూడండి [అధ్యాయం 04: ప్రాక్టికల్ సామ్పిల్స్](../README.md)

## తొలగింపుల నివారణ

### సాధారణ సమస్యలు

**"Connection refused" లేదా "Service unavailable"**
- సర్వీస్ తనిఖీ చేయండి: `foundry service status`
- అవసరమైతే రీస్టార్ట్ చేయండి: `foundry service restart`
- `application.properties` లోని పోర్ట్ `foundry service status` అవుట్‌పుట్‌తో సరిపోలుతుందో చూడండి
- URL `/v1` తో ముగుస్తున్నదని నిర్ధారించుకోండి: `http://localhost:5273/v1`

**స్టార్ట్‌అప్ వద్ద "No model found"**
- అప్లికేషన్ ఆటోమేటిక్ గా మోడల్ డిటెక్ట్ చేస్తుంది. కనీసం ఒక మోడల్ లోడ్ అయి ఉందని నిర్ధారించుకోండి: `foundry service ps`
- మోడల్స్ లోడ్ కాకపోతే: `foundry model run phi-4-mini`
- మీరు `application.properties` లో మోడల్ పేరును మానually మార్పిడి చేసినట్లయితే, అది `foundry model list` లో సరిపోలుతుందో చూసుకోండి

**"400 Bad Request" లోపాలు**
- base URL `/v1` తో ముగుస్తుందని నిర్ధారించుకోండి: `http://localhost:5273/v1`
- మీ కోడ్‌లో `maxCompletionTokens()` ఉపయోగిస్తున్నారని నిర్ధారించుకోండి (పాత `maxTokens()` కాదు)

**Maven కంపైల్ లోపాలు**
- Java 21 లేదా అంతకంటే పైభాగం ఉందని తనిఖీ చేయండి: `java -version`
- క్లీన్ చేసి మళ్లీ కంపైల్ చేయండి: `mvn clean compile`
- డిపెండెన్సీస్ డౌన్‌లోడ్ కోసం ఇంటర్నెట్ కనెక్షన్ ఉందని చూసుకోండి

**సర్వీస్ కనెక్షన్ సమస్యలు**
- "Request to local service failed" చూపిస్తే, ఈ కమాండ్ నడపండి: `foundry service restart`
- లోడ్ అయిన మోడల్స్ తనిఖీ చేయండి: `foundry service ps`
- సర్వీస్ లాగ్స్ చూడండి: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**అస్పష్టత**:  
ఈ డాక్యుమెంట్‌ను AI అనువాద సేవ [Co-op Translator](https://github.com/Azure/co-op-translator) ఉపయోగించి అనువదಿಸಲಾಗಿದೆ. మేము సరిగ్గా ఉండేందుకు ప్రయత్నిస్తున్నప్పటికీ, స్వయంచాలక అనువాదాల్లో పొరపాట్లు లేదా అకురసిటీలు ఉండవచ్చును. స్థానిక భాషలోని అసలు డాక్యుమెంట్‌ను అధికారిక మూలంగా పరిగణించాలి. కీలకమైన సమాచారానికి, ప్రొఫెషనల్ మానవ అనువాదాన్ని సిఫార్సు చేస్తాము. ఈ అనువాదంలో ఉపయోగంతో జరిగే ఏదైనా తప్పుదోవ లేదా అర్థ విఫలమయ్యే దుష్ప్రభావాలకు మేము బాధ్యత వహించమని కోరుకుంటాము.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->