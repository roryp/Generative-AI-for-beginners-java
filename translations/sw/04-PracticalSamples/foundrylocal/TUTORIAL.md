<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2284c54d2a98090a37df0dbef1633ebf",
  "translation_date": "2025-07-21T21:21:17+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/TUTORIAL.md",
  "language_code": "sw"
}
-->
# Mafunzo ya Foundry Local Spring Boot

## Jedwali la Yaliyomo

- [Mahitaji ya Awali](../../../../04-PracticalSamples/foundrylocal)
- [Muhtasari wa Mradi](../../../../04-PracticalSamples/foundrylocal)
- [Kuelewa Msimbo](../../../../04-PracticalSamples/foundrylocal)
  - [1. Usanidi wa Programu (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. Darasa Kuu la Programu (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. Tabaka la Huduma ya AI (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. Vitegemezi vya Mradi (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [Jinsi Kila Kitu Kinavyofanya Kazi Pamoja](../../../../04-PracticalSamples/foundrylocal)
- [Kuweka Foundry Local](../../../../04-PracticalSamples/foundrylocal)
- [Kuendesha Programu](../../../../04-PracticalSamples/foundrylocal)
- [Matokeo Yanayotarajiwa](../../../../04-PracticalSamples/foundrylocal)
- [Hatua Zifuatazo](../../../../04-PracticalSamples/foundrylocal)
- [Kutatua Shida](../../../../04-PracticalSamples/foundrylocal)

## Mahitaji ya Awali

Kabla ya kuanza mafunzo haya, hakikisha una:

- **Java 21 au zaidi** imewekwa kwenye mfumo wako
- **Maven 3.6+** kwa ajili ya kujenga mradi
- **Foundry Local** imewekwa na inafanya kazi

### **Weka Foundry Local:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```

## Muhtasari wa Mradi

Mradi huu una sehemu kuu nne:

1. **Application.java** - Kiingilio kikuu cha programu ya Spring Boot
2. **FoundryLocalService.java** - Tabaka la huduma linaloshughulikia mawasiliano ya AI
3. **application.properties** - Usanidi wa muunganisho wa Foundry Local
4. **pom.xml** - Vitegemezi vya Maven na usanidi wa mradi

## Kuelewa Msimbo

### 1. Usanidi wa Programu (application.properties)

**Faili:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu
```

**Kazi ya Hii:**
- **base-url**: Inaonyesha mahali Foundry Local inafanya kazi (bandari chaguo-msingi 5273)
- **model**: Inaeleza jina la mfano wa AI wa kutumia kwa kizazi cha maandishi

**Dhana Muhimu:** Spring Boot inasoma moja kwa moja mali hizi na kuzifanya zipatikane kwa programu yako kwa kutumia anotasheni ya `@Value`.

### 2. Darasa Kuu la Programu (Application.java)

**Faili:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```

**Kazi ya Hii:**
- `@SpringBootApplication` inawasha usanidi wa moja kwa moja wa Spring Boot
- `WebApplicationType.NONE` inaambia Spring kuwa hii ni programu ya mstari wa amri, si seva ya wavuti
- Njia kuu huanzisha programu ya Spring

**Mwendeshaji wa Demo:**
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

**Kazi ya Hii:**
- `@Bean` huunda sehemu inayosimamiwa na Spring
- `CommandLineRunner` huendesha msimbo baada ya Spring Boot kuanza
- `foundryLocalService` huingizwa moja kwa moja na Spring (utepelezaji wa utegemezi)
- Hutuma ujumbe wa majaribio kwa AI na kuonyesha jibu

### 3. Tabaka la Huduma ya AI (FoundryLocalService.java)

**Faili:** `src/main/java/com/example/FoundryLocalService.java`

#### Uingizaji wa Usanidi:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu}")
    private String model;
```

**Kazi ya Hii:**
- `@Service` inaambia Spring kuwa darasa hili linatoa mantiki ya biashara
- `@Value` huingiza thamani za usanidi kutoka application.properties
- Sintaksia ya `:default-value` hutoa thamani za akiba ikiwa mali hazijasetwa

#### Uanzishaji wa Mteja:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")        // Foundry Local uses OpenAI-compatible API
            .apiKey("unused")                 // Local server doesn't need real API key
            .build();
}
```

**Kazi ya Hii:**
- `@PostConstruct` huendesha njia hii baada ya Spring kuunda huduma
- Huunda mteja wa OpenAI anayeelekeza kwenye mfano wako wa Foundry Local
- Njia ya `/v1` inahitajika kwa utangamano wa API ya OpenAI
- Kitufe cha API ni "unused" kwa sababu maendeleo ya ndani hayahitaji uthibitishaji

#### Njia ya Mazungumzo:
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

**Kazi ya Hii:**
- **ChatCompletionCreateParams**: Husimamia ombi la AI
  - `model`: Inaeleza mfano wa AI wa kutumia
  - `addUserMessage`: Huongeza ujumbe wako kwenye mazungumzo
  - `maxCompletionTokens`: Huweka kikomo cha urefu wa jibu (kuokoa rasilimali)
  - `temperature`: Hudhibiti nasibu (0.0 = thabiti, 1.0 = ubunifu)
- **API Call**: Hutuma ombi kwa Foundry Local
- **Response Handling**: Hutoa jibu la maandishi la AI kwa usalama
- **Error Handling**: Hushughulikia makosa kwa ujumbe wa msaada

### 4. Vitegemezi vya Mradi (pom.xml)

**Vitegemezi Muhimu:**

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

**Kazi ya Hivi:**
- **spring-boot-starter**: Hutoa utendaji wa msingi wa Spring Boot
- **openai-java**: SDK rasmi ya OpenAI ya Java kwa mawasiliano ya API
- **jackson-databind**: Hushughulikia uongofu wa JSON kwa maombi ya API

## Jinsi Kila Kitu Kinavyofanya Kazi Pamoja

Hivi ndivyo mtiririko mzima unavyofanya kazi unapokimbia programu:

1. **Kuanza**: Spring Boot huanza na kusoma `application.properties`
2. **Uundaji wa Huduma**: Spring huunda `FoundryLocalService` na kuingiza thamani za usanidi
3. **Usanidi wa Mteja**: `@PostConstruct` huanzisha mteja wa OpenAI kuunganishwa na Foundry Local
4. **Utekelezaji wa Demo**: `CommandLineRunner` huendesha baada ya kuanza
5. **Mwito wa AI**: Demo inaita `foundryLocalService.chat()` na ujumbe wa majaribio
6. **Ombi la API**: Huduma hujenga na kutuma ombi linaloendana na OpenAI kwa Foundry Local
7. **Usindikaji wa Jibu**: Huduma hutoa na kurudisha jibu la AI
8. **Onyesho**: Programu inachapisha jibu na kutoka

## Kuweka Foundry Local

Ili kuweka Foundry Local, fuata hatua hizi:

1. **Weka Foundry Local** kwa kutumia maelekezo katika sehemu ya [Mahitaji ya Awali](../../../../04-PracticalSamples/foundrylocal).
2. **Pakua mfano wa AI** unaotaka kutumia, kwa mfano, `phi-3.5-mini`, kwa kutumia amri ifuatayo:
   ```bash
   foundry model run phi-3.5-mini
   ```
3. **Sanidi faili ya application.properties** ili kulinganisha na mipangilio yako ya Foundry Local, hasa ikiwa unatumia bandari au mfano tofauti.

## Kuendesha Programu

### Hatua ya 1: Anzisha Foundry Local
```bash
foundry model run phi-3.5-mini
```

### Hatua ya 2: Jenga na Endesha Programu
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Matokeo Yanayotarajiwa

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

## Hatua Zifuatazo

Kwa mifano zaidi, angalia [Sura ya 04: Mifano ya Kivitendo](../README.md)

## Kutatua Shida

### Masuala ya Kawaida

**"Connection refused" au "Service unavailable"**
- Hakikisha Foundry Local inafanya kazi: `foundry model list`
- Thibitisha huduma iko kwenye bandari 5273: Angalia `application.properties`
- Jaribu kuwasha upya Foundry Local: `foundry model run phi-3.5-mini`

**Makosa ya "Model not found"**
- Angalia mifano inayopatikana: `foundry model list`
- Sasisha jina la mfano katika `application.properties` ili lilingane kabisa
- Pakua mfano ikiwa inahitajika: `foundry model run phi-3.5-mini`

**Makosa ya uundaji wa Maven**
- Hakikisha Java 21 au zaidi: `java -version`
- Safisha na ujenge upya: `mvn clean compile`
- Angalia muunganisho wa intaneti kwa upakuaji wa vitegemezi

**Programu inaanza lakini hakuna matokeo**
- Thibitisha Foundry Local inajibu: Fungua kivinjari kwenye `http://localhost:5273`
- Angalia magogo ya programu kwa ujumbe maalum wa makosa
- Hakikisha mfano umejazwa kikamilifu na uko tayari

**Kanusho**:  
Hati hii imetafsiriwa kwa kutumia huduma ya tafsiri ya AI [Co-op Translator](https://github.com/Azure/co-op-translator). Ingawa tunajitahidi kuhakikisha usahihi, tafsiri za kiotomatiki zinaweza kuwa na makosa au kutokuwa sahihi. Hati ya asili katika lugha yake ya awali inapaswa kuzingatiwa kama chanzo cha mamlaka. Kwa taarifa muhimu, tafsiri ya kitaalamu ya binadamu inapendekezwa. Hatutawajibika kwa kutoelewana au tafsiri zisizo sahihi zinazotokana na matumizi ya tafsiri hii.