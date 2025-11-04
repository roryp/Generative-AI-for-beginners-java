<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "f787307400de59adc25a1404466a35f3",
  "translation_date": "2025-11-04T07:39:08+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "et"
}
-->
# Foundry Local Spring Boot Õpetus

## Sisukord

- [Eeltingimused](../../../../04-PracticalSamples/foundrylocal)
- [Projekti Ülevaade](../../../../04-PracticalSamples/foundrylocal)
- [Koodi Mõistmine](../../../../04-PracticalSamples/foundrylocal)
  - [1. Rakenduse Konfiguratsioon (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. Põhirakenduse Klass (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. AI Teenuse Kiht (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. Projekti Sõltuvused (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [Kuidas Kõik Koos Töötab](../../../../04-PracticalSamples/foundrylocal)
- [Foundry Locali Seadistamine](../../../../04-PracticalSamples/foundrylocal)
- [Rakenduse Käivitamine](../../../../04-PracticalSamples/foundrylocal)
- [Oodatav Väljund](../../../../04-PracticalSamples/foundrylocal)
- [Järgmised Sammud](../../../../04-PracticalSamples/foundrylocal)
- [Tõrkeotsing](../../../../04-PracticalSamples/foundrylocal)

## Eeltingimused

Enne õpetuse alustamist veendu, et sul on:

- **Java 21 või uuem** paigaldatud sinu süsteemi
- **Maven 3.6+** projekti ehitamiseks
- **Foundry Local** paigaldatud ja käivitatud

### **Paigalda Foundry Local:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```

## Projekti Ülevaade

Projekt koosneb neljast põhikomponendist:

1. **Application.java** - Peamine Spring Boot rakenduse käivituspunkt
2. **FoundryLocalService.java** - Teenuse kiht, mis haldab AI suhtlust
3. **application.properties** - Konfiguratsioon Foundry Locali ühenduse jaoks
4. **pom.xml** - Maven'i sõltuvused ja projekti konfiguratsioon

## Koodi Mõistmine

### 1. Rakenduse Konfiguratsioon (application.properties)

**Fail:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```

**Mida see teeb:**
- **base-url**: Määrab, kus Foundry Local töötab, sealhulgas `/v1` tee OpenAI API ühilduvuse jaoks. **Märkus**: Foundry Local määrab pordi dünaamiliselt, seega kontrolli tegelikku porti käsuga `foundry service status`
- **model**: Määrab AI mudeli nime, mida kasutatakse tekstigeneratsiooniks, sealhulgas versiooninumbri (nt `:1`). Kasuta `foundry model list`, et näha saadaolevaid mudeleid ja nende täpseid ID-sid

**Põhimõte:** Spring Boot laadib need omadused automaatselt ja teeb need rakendusele kättesaadavaks `@Value` annotatsiooni abil.

### 2. Põhirakenduse Klass (Application.java)

**Fail:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```

**Mida see teeb:**
- `@SpringBootApplication` lubab Spring Boot automaatkonfiguratsiooni
- `WebApplicationType.NONE` ütleb Springile, et tegemist on käsurearakendusega, mitte veebiserveriga
- Peamine meetod käivitab Springi rakenduse

**Demo Käivitaja:**
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

**Mida see teeb:**
- `@Bean` loob komponendi, mida Spring haldab
- `CommandLineRunner` käivitab koodi pärast Spring Booti käivitamist
- `foundryLocalService` süstitakse automaatselt Springi poolt (sõltuvuste süstimine)
- Saadab testisõnumi AI-le ja kuvab vastuse

### 3. AI Teenuse Kiht (FoundryLocalService.java)

**Fail:** `src/main/java/com/example/FoundryLocalService.java`

#### Konfiguratsiooni Süstimine:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```

**Mida see teeb:**
- `@Service` ütleb Springile, et see klass pakub äriloogikat
- `@Value` süstib konfiguratsiooniväärtused application.properties failist
- `:default-value` süntaks pakub varuväärtusi, kui omadused pole määratud

#### Kliendi Initsialiseerimine:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```

**Mida see teeb:**
- `@PostConstruct` käivitab selle meetodi pärast Springi teenuse loomist
- Loob OpenAI kliendi, mis suunab sinu kohalikule Foundry Locali instantsile
- `application.properties` failist pärit base URL sisaldab juba `/v1` OpenAI API ühilduvuse jaoks
- API võti on seatud "not-needed", kuna kohalik arendus ei nõua autentimist

#### Vestlusmeetod:
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

**Mida see teeb:**
- **ChatCompletionCreateParams**: Konfigureerib AI päringu
  - `model`: Määrab, millist AI mudelit kasutada (peab vastama täpsele ID-le `foundry model list` käsust)
  - `addUserMessage`: Lisab sinu sõnumi vestlusesse
  - `maxCompletionTokens`: Piirab vastuse pikkust (ressursside säästmiseks)
  - `temperature`: Kontrollib juhuslikkust (0.0 = deterministlik, 1.0 = loov)
- **API Päring**: Saadab päringu Foundry Localile
- **Vastuse Töötlemine**: Ekstraheerib AI tekstivastuse turvaliselt
- **Vigade Käitlemine**: Pakib erandid kasulike veateadetega

### 4. Projekti Sõltuvused (pom.xml)

**Peamised Sõltuvused:**

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

**Mida need teevad:**
- **spring-boot-starter**: Pakub Spring Booti põhifunktsionaalsust
- **openai-java**: Ametlik OpenAI Java SDK API suhtluseks
- **jackson-databind**: Haldab JSON-i serialiseerimist/deserialiseerimist API päringute jaoks

## Kuidas Kõik Koos Töötab

Siin on täielik voog, kui rakendust käivitatakse:

1. **Käivitamine**: Spring Boot käivitub ja loeb `application.properties` faili
2. **Teenuse Loomine**: Spring loob `FoundryLocalService` ja süstib konfiguratsiooniväärtused
3. **Kliendi Seadistamine**: `@PostConstruct` initsialiseerib OpenAI kliendi, et ühendada Foundry Localiga
4. **Demo Käivitamine**: `CommandLineRunner` käivitub pärast käivitamist
5. **AI Päring**: Demo kutsub `foundryLocalService.chat()` testisõnumiga
6. **API Päring**: Teenus koostab ja saadab OpenAI-ühilduva päringu Foundry Localile
7. **Vastuse Töötlemine**: Teenus ekstraheerib ja tagastab AI vastuse
8. **Kuvamine**: Rakendus kuvab vastuse ja sulgub

## Foundry Locali Seadistamine

Foundry Locali seadistamiseks järgi järgmisi samme:

1. **Paigalda Foundry Local** vastavalt juhistele [Eeltingimuste](../../../../04-PracticalSamples/foundrylocal) jaotises.

2. **Kontrolli dünaamiliselt määratud porti**. Foundry Local määrab pordi automaatselt käivitamisel. Leia oma port käsuga:
   ```bash
   foundry service status
   ```
   
   **Valikuline**: Kui eelistad kasutada kindlat porti (nt 5273), saad selle käsitsi seadistada:
   ```bash
   foundry service set --port 5273
   ```

3. **Laadi alla AI mudel**, mida soovid kasutada, näiteks `phi-3.5-mini`, järgmise käsuga:
   ```bash
   foundry model run phi-3.5-mini
   ```

4. **Konfigureeri application.properties** fail vastavalt oma Foundry Locali seadetele:
   - Uuenda porti `base-url` väljal (2. sammust), veendudes, et see sisaldab `/v1` lõpus
   - Uuenda mudeli nime, lisades versiooninumbri (kontrolli `foundry model list` käsuga)
   
   Näide:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```

## Rakenduse Käivitamine

### Samm 1: Käivita Foundry Local
```bash
foundry model run phi-3.5-mini
```

### Samm 2: Ehitamine ja Rakenduse Käivitamine
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Oodatav Väljund

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

## Järgmised Sammud

Rohkem näiteid leiad [Peatükk 04: Praktilised näited](../README.md)

## Tõrkeotsing

### Levinud Probleemid

**"Connection refused" või "Service unavailable"**
- Veendu, et Foundry Local töötab: `foundry model list`
- Kontrolli, millist porti Foundry Local kasutab: `foundry service status`
- Uuenda oma `application.properties` õige portiga, veendudes, et URL lõppeb `/v1`
- Alternatiivina määra kindel port, kui soovid: `foundry service set --port 5273`
- Proovi Foundry Locali taaskäivitada: `foundry model run phi-3.5-mini`

**"Model not found" või "404 Not Found" vead**
- Kontrolli saadaolevaid mudeleid ja nende täpseid ID-sid: `foundry model list`
- Uuenda mudeli nime `application.properties` failis, et see vastaks täpselt, sealhulgas versiooninumber (nt `Phi-3.5-mini-instruct-cuda-gpu:1`)
- Veendu, et `base-url` sisaldab `/v1` lõpus: `http://localhost:5273/v1`
- Laadi mudel alla, kui vaja: `foundry model run phi-3.5-mini`

**"400 Bad Request" vead**
- Kontrolli, et base URL sisaldab `/v1`: `http://localhost:5273/v1`
- Veendu, et mudeli ID vastab täpselt sellele, mis on näidatud `foundry model list` käsus
- Veendu, et kasutad `maxCompletionTokens()` oma koodis (mitte vananenud `maxTokens()`)

**Maven'i kompileerimisvead**
- Veendu, et Java 21 või uuem on paigaldatud: `java -version`
- Puhasta ja ehita uuesti: `mvn clean compile`
- Kontrolli internetiühendust sõltuvuste allalaadimiseks

**Rakendus käivitub, kuid väljund puudub**
- Veendu, et Foundry Local vastab: Kontrolli `http://localhost:5273/v1/models` või käivita `foundry service status`
- Kontrolli rakenduse logisid konkreetsete veateadete jaoks
- Veendu, et mudel on täielikult laaditud ja valmis

---

**Lahtiütlus**:  
See dokument on tõlgitud AI tõlketeenuse [Co-op Translator](https://github.com/Azure/co-op-translator) abil. Kuigi püüame tagada täpsust, palume arvestada, et automaatsed tõlked võivad sisaldada vigu või ebatäpsusi. Algne dokument selle algses keeles tuleks pidada autoriteetseks allikaks. Olulise teabe puhul soovitame kasutada professionaalset inimtõlget. Me ei vastuta arusaamatuste või valesti tõlgenduste eest, mis võivad tekkida selle tõlke kasutamise tõttu.