<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "f787307400de59adc25a1404466a35f3",
  "translation_date": "2025-11-04T07:31:50+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
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
  - [4. Mahitaji ya Mradi (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [Jinsi Yote Inavyofanya Kazi Pamoja](../../../../04-PracticalSamples/foundrylocal)
- [Kuweka Foundry Local](../../../../04-PracticalSamples/foundrylocal)
- [Kuendesha Programu](../../../../04-PracticalSamples/foundrylocal)
- [Matokeo Yanayotarajiwa](../../../../04-PracticalSamples/foundrylocal)
- [Hatua Zifuatazo](../../../../04-PracticalSamples/foundrylocal)
- [Kutatua Tatizo](../../../../04-PracticalSamples/foundrylocal)

## Mahitaji ya Awali

Kabla ya kuanza mafunzo haya, hakikisha una:

- **Java 21 au zaidi** imewekwa kwenye mfumo wako
- **Maven 3.6+** kwa ajili ya kujenga mradi
- **Foundry Local** imewekwa na inaendesha

### **Weka Foundry Local:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```

## Muhtasari wa Mradi

Mradi huu una sehemu kuu nne:

1. **Application.java** - Sehemu kuu ya kuanzia programu ya Spring Boot
2. **FoundryLocalService.java** - Tabaka la huduma linaloshughulikia mawasiliano ya AI
3. **application.properties** - Usanidi wa muunganisho wa Foundry Local
4. **pom.xml** - Mahitaji ya Maven na usanidi wa mradi

## Kuelewa Msimbo

### 1. Usanidi wa Programu (application.properties)

**Faili:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```

**Kazi ya Hii:**
- **base-url**: Inaonyesha mahali Foundry Local inaendesha, ikijumuisha njia ya `/v1` kwa ulinganifu wa API ya OpenAI. **Kumbuka**: Foundry Local inatoa bandari kwa njia ya kiotomatiki, kwa hivyo angalia bandari yako halisi kwa kutumia `foundry service status`
- **model**: Inaonyesha jina la mfano wa AI wa kutumia kwa kizazi cha maandishi, ikijumuisha namba ya toleo (mfano, `:1`). Tumia `foundry model list` kuona mifano inayopatikana na vitambulisho vyake halisi

**Dhana Muhimu:** Spring Boot inasoma kiotomatiki mali hizi na kuzifanya zipatikane kwa programu yako kwa kutumia `@Value`.

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
- `@SpringBootApplication` inawezesha usanidi wa kiotomatiki wa Spring Boot
- `WebApplicationType.NONE` inaambia Spring kuwa hii ni programu ya mstari wa amri, si seva ya wavuti
- Njia kuu inaanzisha programu ya Spring

**Mwendeshaji wa Demo:**
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

**Kazi ya Hii:**
- `@Bean` huunda sehemu ambayo Spring inasimamia
- `CommandLineRunner` inaendesha msimbo baada ya Spring Boot kuanza
- `foundryLocalService` inaingizwa kiotomatiki na Spring (kuingiza utegemezi)
- Inatuma ujumbe wa majaribio kwa AI na kuonyesha majibu

### 3. Tabaka la Huduma ya AI (FoundryLocalService.java)

**Faili:** `src/main/java/com/example/FoundryLocalService.java`

#### Usanidi wa Kuingiza:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```

**Kazi ya Hii:**
- `@Service` inaonyesha Spring kuwa darasa hili linatoa mantiki ya biashara
- `@Value` inaingiza thamani za usanidi kutoka application.properties
- Sintaksia ya `:default-value` inatoa thamani mbadala ikiwa mali hazijawekwa

#### Uanzishaji wa Mteja:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```

**Kazi ya Hii:**
- `@PostConstruct` inaendesha njia hii baada ya Spring kuunda huduma
- Inaunda mteja wa OpenAI anayeelekea kwenye Foundry Local yako ya ndani
- URL ya msingi kutoka `application.properties` tayari inajumuisha `/v1` kwa ulinganifu wa API ya OpenAI
- Funguo ya API imewekwa kuwa "not-needed" kwa sababu maendeleo ya ndani hayahitaji uthibitisho

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
- **ChatCompletionCreateParams**: Inasanidi ombi la AI
  - `model`: Inaonyesha ni mfano gani wa AI wa kutumia (lazima ulingane na ID halisi kutoka `foundry model list`)
  - `addUserMessage`: Inaongeza ujumbe wako kwenye mazungumzo
  - `maxCompletionTokens`: Inapunguza urefu wa majibu (inaokoa rasilimali)
  - `temperature`: Inadhibiti nasibu (0.0 = ya uhakika, 1.0 = ya ubunifu)
- **API Call**: Inatuma ombi kwa Foundry Local
- **Response Handling**: Inatoa majibu ya maandishi ya AI kwa usalama
- **Error Handling**: Inafunga makosa na ujumbe wa msaada

### 4. Mahitaji ya Mradi (pom.xml)

**Mahitaji Muhimu:**

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

**Kazi ya Hii:**
- **spring-boot-starter**: Inatoa utendaji wa msingi wa Spring Boot
- **openai-java**: SDK rasmi ya OpenAI Java kwa mawasiliano ya API
- **jackson-databind**: Inashughulikia usawazishaji/usawazishaji wa JSON kwa miito ya API

## Jinsi Yote Inavyofanya Kazi Pamoja

Hivi ndivyo mtiririko mzima unavyofanya kazi unapokimbia programu:

1. **Kuanza**: Spring Boot inaanza na kusoma `application.properties`
2. **Uundaji wa Huduma**: Spring inaunda `FoundryLocalService` na kuingiza thamani za usanidi
3. **Usanidi wa Mteja**: `@PostConstruct` inaanzisha mteja wa OpenAI kuunganishwa na Foundry Local
4. **Utekelezaji wa Demo**: `CommandLineRunner` inaendesha baada ya kuanza
5. **Mwito wa AI**: Demo inaita `foundryLocalService.chat()` na ujumbe wa majaribio
6. **Ombi la API**: Huduma inajenga na kutuma ombi linalolingana na OpenAI kwa Foundry Local
7. **Usindikaji wa Majibu**: Huduma inatoa na kurudisha majibu ya AI
8. **Onyesho**: Programu inaonyesha majibu na kuacha

## Kuweka Foundry Local

Ili kuweka Foundry Local, fuata hatua hizi:

1. **Weka Foundry Local** kwa kutumia maelekezo katika sehemu ya [Mahitaji ya Awali](../../../../04-PracticalSamples/foundrylocal).

2. **Angalia bandari iliyotolewa kiotomatiki**. Foundry Local inatoa bandari kiotomatiki inapowashwa. Tafuta bandari yako kwa:
   ```bash
   foundry service status
   ```
   
   **Hiari**: Ikiwa unapendelea kutumia bandari maalum (mfano, 5273), unaweza kuisanidi kwa mikono:
   ```bash
   foundry service set --port 5273
   ```

3. **Pakua mfano wa AI** unaotaka kutumia, kwa mfano, `phi-3.5-mini`, kwa amri ifuatayo:
   ```bash
   foundry model run phi-3.5-mini
   ```

4. **Sanidi faili ya application.properties** ili kulingana na mipangilio yako ya Foundry Local:
   - Sasisha bandari katika `base-url` (kutoka hatua ya 2), ukihakikisha inajumuisha `/v1` mwishoni
   - Sasisha jina la mfano ili kujumuisha namba ya toleo (angalia kwa `foundry model list`)
   
   Mfano:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```

## Kuendesha Programu

### Hatua ya 1: Washa Foundry Local
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

Kwa mifano zaidi, angalia [Sura ya 04: Sampuli za vitendo](../README.md)

## Kutatua Tatizo

### Masuala ya Kawaida

**"Connection refused" au "Service unavailable"**
- Hakikisha Foundry Local inaendesha: `foundry model list`
- Angalia bandari halisi Foundry Local inatumia: `foundry service status`
- Sasisha `application.properties` yako na bandari sahihi, ukihakikisha URL inaishia na `/v1`
- Vinginevyo, weka bandari maalum ikiwa unataka: `foundry service set --port 5273`
- Jaribu kuwasha upya Foundry Local: `foundry model run phi-3.5-mini`

**"Model not found" au "404 Not Found" errors**
- Angalia mifano inayopatikana na vitambulisho vyake halisi: `foundry model list`
- Sasisha jina la mfano katika `application.properties` ili kulingana kabisa, ikijumuisha namba ya toleo (mfano, `Phi-3.5-mini-instruct-cuda-gpu:1`)
- Hakikisha `base-url` inajumuisha `/v1` mwishoni: `http://localhost:5273/v1`
- Pakua mfano ikiwa inahitajika: `foundry model run phi-3.5-mini`

**"400 Bad Request" errors**
- Thibitisha URL ya msingi inajumuisha `/v1`: `http://localhost:5273/v1`
- Angalia kuwa ID ya mfano inalingana kabisa na inavyoonyeshwa katika `foundry model list`
- Hakikisha unatumia `maxCompletionTokens()` katika msimbo wako (si `maxTokens()` ambayo imepitwa na wakati)

**Makosa ya mkusanyiko wa Maven**
- Hakikisha Java 21 au zaidi: `java -version`
- Safisha na jenga upya: `mvn clean compile`
- Angalia muunganisho wa intaneti kwa upakuaji wa mahitaji

**Programu inaanza lakini hakuna matokeo**
- Thibitisha Foundry Local inajibu: Angalia `http://localhost:5273/v1/models` au endesha `foundry service status`
- Angalia kumbukumbu za programu kwa ujumbe maalum wa makosa
- Hakikisha mfano umepakiwa kikamilifu na uko tayari

---

**Kanusho**:  
Hati hii imetafsiriwa kwa kutumia huduma ya tafsiri ya AI [Co-op Translator](https://github.com/Azure/co-op-translator). Ingawa tunajitahidi kwa usahihi, tafadhali fahamu kuwa tafsiri za kiotomatiki zinaweza kuwa na makosa au kutokuwa sahihi. Hati ya asili katika lugha yake ya awali inapaswa kuzingatiwa kama chanzo cha mamlaka. Kwa taarifa muhimu, tafsiri ya kitaalamu ya binadamu inapendekezwa. Hatutawajibika kwa kutoelewana au tafsiri zisizo sahihi zinazotokana na matumizi ya tafsiri hii.