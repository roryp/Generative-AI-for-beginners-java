# Foundry Local Spring Boot Mafunzo

## Yaliyomo

- [Mahitaji ya Awali](#mahitaji-ya-awali)
- [Muhtasari wa Mradi](#muhtasari-wa-mradi)
- [Kuelewa Msimbo](#kuelewa-msimbo)
  - [1. Usanidi wa Programu (application.properties)](#1-usanidi-wa-programu-applicationproperties)
  - [2. Darasa Kuu la Programu (Application.java)](#2-darasa-kuu-la-programu-applicationjava)
  - [3. Tabaka la Huduma za AI (FoundryLocalService.java)](#3-tabaka-la-huduma-za-ai-foundrylocalservicejava)
  - [4. Mategemeo ya Mradi (pom.xml)](#4-mategemeo-ya-mradi-pomxml)
- [Jinsi Yote Hufanya Kazi Pamoja](#jinsi-yote-hufanya-kazi-pamoja)
- [Kuweka Foundry Local](#kuweka-foundry-local)
- [Kukimbia Programu](#kukimbia-programu)
- [Matokeo Yanayotarajiwa](#matokeo-yanayotarajiwa)
- [Hatua Zifuatazo](#hatua-zifuatazo)
- [Matatizo na Suluhisho](#matatizo-na-suluhisho)


## Mahitaji ya Awali

Kabla ya kuanza mafunzo haya, hakikisha una:

- **Java 21 au zaidi** imewekwa kwenye mfumo wako
- **Maven 3.6+** kwa kujenga mradi
- **Foundry Local** imewekwa na inaendesha

### **Sakinisha Foundry Local:**

> **Kumbuka:** CLI ya Foundry Local inapatikana tu kwa **Windows** na **macOS**. Linux inasaidiwa kupitia [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Thibitisha usakinishaji:
```bash
foundry --version
```

## Muhtasari wa Mradi

Mradi huu una vipengele vinne vikuu:

1. **Application.java** - Sehemu kuu ya kwanza ya programu ya Spring Boot
2. **FoundryLocalService.java** - Tabaka la huduma linaloshughulikia mawasiliano ya AI
3. **application.properties** - Usanidi wa muunganisho wa Foundry Local
4. **pom.xml** - Mategemeo ya Maven na usanidi wa mradi

## Kuelewa Msimbo

### 1. Usanidi wa Programu (application.properties)

**Faili:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Hii hufanya nini:**
- **base-url**: Inaelezea mahali Foundry Local inaendesha, ikiwa ni pamoja na njia ya `/v1` kwa muunganisho wa OpenAI API. Mlangoni pa default ni `5273`. Ikiwa mlangoni ni tofauti, angalia kwa `foundry service status`.
- **model** (hiari): Inataja jina la modeli ya AI kutumia kwa uzalishaji wa maandishi. **Kwa kawaida, programu hutambua modeli kiotomatiki** kwa kuulizia Foundry Local `/v1/models` wakati wa kuanzisha, hivyo huwezi kuhitaji kuibainisha. Unaweza bado kuibainisha wazi kama unahitaji kuzima utambuzi wa kiotomatiki.

**Dhana muhimu:** Spring Boot hupakia mali hizi kiotomatiki na kuzifanya zipatikane kwa programu yako kwa kutumia alama `@Value`.

### 2. Darasa Kuu la Programu (Application.java)

**Faili:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Hakuna seva ya wavuti inahitajika
        app.run(args);
    }
```

**Hii hufanya nini:**
- `@SpringBootApplication` huwezesha usanidi wa Spring Boot kiotomatiki
- `WebApplicationType.NONE` huonyesha Spring hii ni programu ya mstari wa amri, si seva ya wavuti
- Njia kuu huanzisha programu ya Spring

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

**Hii hufanya nini:**
- `@Bean` huunda sehemu inayosimamiwa na Spring
- `CommandLineRunner` huendesha msimbo baada ya Spring Boot kuanza
- `foundryLocalService` huingizwa kiotomatiki na Spring (udoaji wa utegemezi)
- Hutuma ujumbe wa jaribio kwa AI na kuonyesha jibu

### 3. Tabaka la Huduma za AI (FoundryLocalService.java)

**Faili:** `src/main/java/com/example/FoundryLocalService.java`

#### Uingizaji Usanidi:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Inatambuliwa kiotomatiki ikiwa tupu
```

**Hii hufanya nini:**
- `@Service` huambia Spring kuwa darasa hili linatoa mantiki ya biashara
- `@Value` huingiza thamani za usanidi kutoka application.properties
- Modeli huanzishwa kuwa tupu, ambayo husababisha **utambuzi wa kiotomatiki** kutoka Foundry Local wakati wa kuanzisha. Hii ina maana programu hufanya kazi na modeli yoyote iliyo kwenye Foundry Local bila usanidi wa mkono.

#### Uanzishaji wa Mteja:
```java
@PostConstruct
public void init() {
    // Kugundua moja kwa moja modeli kutoka Foundry Local ikiwa haijasanidiwa wazi
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // URL ya Msingi tayari inajumuisha /v1 kutoka kwa usanidi
            .apiKey("not-needed")            // Seva ya ndani haihitaji ufunguo halali wa API
            .build();
}
```

**Hii hufanya nini:**
- `@PostConstruct` huendesha njia hii baada ya Spring kuunda huduma
- Ikiwa hakuna modeli iliyosanidiwa, inauliza kwa Foundry Local `/v1/models` na kuchagua modeli ya kwanza iliyopakiwa
- Huunda mteja wa OpenAI unaoelekeza kwa toleo lako la Foundry Local
- URL msingi kutoka `application.properties` tayari ina `/v1` kwa muunganisho wa API wa OpenAI
- Funguo ya API imewekwa kuwa "not-needed" kwa sababu maendeleo ya ndani hayahitaji uthibitisho

#### Njia ya Chat:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Ni mfano gani wa AI wa kutumia
                .addUserMessage(message)         // Swali/lalisha lako
                .maxCompletionTokens(150)        // Weka kikomo kwa urefu wa jibu
                .temperature(0.7)                // Dhibiti ubunifu (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Chukua jibu la AI kutoka kwa matokeo ya API
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**Hii hufanya nini:**
- **ChatCompletionCreateParams**: Husanidi ombi la AI
  - `model`: Inaeleza modeli ya AI kutumia (inapaswa kulingana na kitambulisho halisi kutoka `foundry model list`)
  - `addUserMessage`: Inongeza ujumbe wako kwenye mazungumzo
  - `maxCompletionTokens`: Huongeza kikomo cha urefu wa jibu (kuokoa rasilimali)
  - `temperature`: Hudhibiti kutabirika (0.0 = thabiti, 1.0 = ubunifu)
- **API Call**: Hutuma ombi kwa Foundry Local
- **Udhibiti wa Majibu**: Huchukua kwa usalama jibu la maandishi la AI
- **Udhibiti wa Makosa**: Huizungusha mitisho na ujumbe wa kusaidia

### 4. Mategemeo ya Mradi (pom.xml)

**Mategemeo Muhimu:**

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

**Hii hufanya nini:**
- **spring-boot-starter**: Hutolewa kazi kuu za Spring Boot
- **openai-java**: SDK rasmi ya OpenAI kwa Java kwa mawasiliano ya API
- **jackson-databind**: Hushughulikia serialization/deserialization ya JSON kwa simu za API

## Jinsi Yote Hufanya Kazi Pamoja

Hapa ni mtiririko kamili unapokimbia programu:

1. **Kuanzisha**: Spring Boot huanza na kusoma `application.properties`
2. **Uundaji wa Huduma**: Spring huunda `FoundryLocalService` na kuingiza thamani za usanidi
3. **Utambuzi wa Modeli**: Ikiwa hakuna modeli isiyosanidiwa, huduma huuliza `/v1/models` ya Foundry Local na kutumia modeli ya kwanza iliyo na upakiaji kiotomatiki
4. **Kuanzisha Mteja**: `@PostConstruct` huanzisha mteja wa OpenAI kuunganishwa na Foundry Local
5. **Uendeshaji wa Demo**: `CommandLineRunner` hutekelezwa baada ya kuanzisha
6. **Simu ya AI**: Demo huita `foundryLocalService.chat()` na ujumbe wa jaribio
7. **Ombi la API**: Huduma hujenga na kutuma ombi linaloungwa mkono na OpenAI kwa Foundry Local
8. **Ushughulikiaji wa Majibu**: Huduma huchukua na kurudisha jibu la AI
9. **Kuonyesha**: Programu inapiga chapisho jibu na kutoka

## Kuweka Foundry Local

1. **Sakinisha Foundry Local** kwa kutumia maelekezo katika sehemu ya [Mahitaji ya Awali](#mahitaji-ya-awali).

2. **Anzisha huduma** (ikiwa haijaanza tayari):
   ```bash
   foundry service start
   ```

3. **Angalia hali ya huduma** kuhakikisha inaendesha na kumbuka mlangoni:
   ```bash
   foundry service status
   ```

4. **Pakua na endesha modeli** (huipakua mara ya kwanza, huhifadhi kwa mara za baadaye):
   ```bash
   foundry model run phi-4-mini
   ```
   Hii huanzisha kikao cha mazungumzo cha kuingiliana. Unaweza kutoka kwa `Ctrl+C`. Modeli huendelea kuwa imepakiwa katika huduma.

   > **Vidokezo:** Endesha `foundry model list` kuona modeli zote zinazopatikana. Badilisha `phi-4-mini` na jina lolote la kauli kutoka kwenye orodha (mfano, `qwen2.5-0.5b` kwa modeli ndogo/haraka).

5. **Thibitisha modeli imepakiwa:**
   ```bash
   foundry service ps
   ```

6. **Sasisha `application.properties`** ikiwa inahitajika:
   - `base-url` ya default (`http://localhost:5273/v1`) inalingana na mlangoni wa default wa CLI. Badilisha tu kama `foundry service status` inaonyesha mlangoni tofauti.
   - Modeli hutambuliwa **kiotomatiki** wakati wa kuanzisha — hakuna usanidi wa mkono unahitajika.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Kukimbia Programu

### Hatua ya 1: Hakikisha modeli imepakiwa ndani ya Foundry Local
```bash
foundry service ps
```
Ikiwa hakuna modeli zilizoonyeshwa, pakua moja:
```bash
foundry model run phi-4-mini
```

### Hatua ya 2: Tengeneza na Kukimbia Programu
Katika terminal tofauti:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Au tengeneza na kimbia kama JAR:
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
Hello! I'm Phi, an AI developed by Microsoft. I can assist with a wide variety of 
tasks including answering questions, helping with analysis, creative writing, coding, 
and general conversation. How can I help you today?
=========================
```

## Hatua Zifuatazo

Kwa mifano zaidi, ona [Sura 04: Mifano halisi](../README.md)

## Matatizo na Suluhisho

### Masuala ya Kawaida

**"Connection refused" au "Service unavailable"**
- Angalia huduma: `foundry service status`
- Anzisha tena kama inahitajika: `foundry service restart`
- Hakikisha mlangoni katika `application.properties` unalingana na toleo la `foundry service status`
- Hakikisha URL ina mwisho wa `/v1`: `http://localhost:5273/v1`

**"Hakuna modeli iliyopatikana" wakati wa kuanzisha**
- Programu hutambua modeli kiotomatiki. Hakikisha angalau modeli moja imepakiwa: `foundry service ps`
- Ikiwa hakuna modeli zinazopakiwa: `foundry model run phi-4-mini`
- Ikiwa umebadilisha jina la modeli katika `application.properties`, hakikisha linakubaliana na `foundry model list`

**Makosa ya "400 Bad Request"**
- Hakikisha base URL ina `/v1`: `http://localhost:5273/v1`
- Hakikisha unatumia `maxCompletionTokens()` katika msimbo wako (sio `maxTokens()` iliyopotoka)

**Makosa ya mkusanyiko ya Maven**
- Hakikisha Java 21 au zaidi: `java -version`
- Safisha na jenga upya: `mvn clean compile`
- Hakikisha una muunganisho wa intaneti kwa kupakua mategemeo

**Matatizo ya muunganisho wa huduma**
- Ikiwa unaona `Request to local service failed`, endesha: `foundry service restart`
- Angalia modeli zilizoanza: `foundry service ps`
- Angalia kumbukumbu za huduma: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Kielelezo cha Hukumu**:  
Hati hii imetafsiriwa kwa kutumia huduma ya kutafsiri kwa AI [Co-op Translator](https://github.com/Azure/co-op-translator). Ingawa tunajitahidi kwa usahihi, tafadhali fahamu kwamba tafsiri za moja kwa moja zinaweza kuwa na makosa au upungufu wa usahihi. Hati ya asili katika lugha yake ya asili inapaswa kuchukuliwa kama chanzo cha mamlaka. Kwa taarifa nyeti, tafsiri ya kitaalamu inayofanywa na binadamu inashauriwa. Hatupati dhamana yoyote kwa kutoelewana au tafsiri zinazotokana na matumizi ya tafsiri hii.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->