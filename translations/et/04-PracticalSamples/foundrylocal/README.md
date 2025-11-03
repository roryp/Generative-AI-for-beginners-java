<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "713d81fd7d28a865068df047e26c8f12",
  "translation_date": "2025-11-03T20:19:29+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "et"
}
-->
# Foundry Local Spring Boot õpetus

## Sisukord

- [Eeltingimused](../../../../04-PracticalSamples/foundrylocal)
- [Projekti ülevaade](../../../../04-PracticalSamples/foundrylocal)
- [Koodi mõistmine](../../../../04-PracticalSamples/foundrylocal)
  - [1. Rakenduse konfiguratsioon (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. Põhirakenduse klass (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. AI teenuse kiht (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. Projekti sõltuvused (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [Kuidas kõik koos töötab](../../../../04-PracticalSamples/foundrylocal)
- [Foundry Locali seadistamine](../../../../04-PracticalSamples/foundrylocal)
- [Rakenduse käivitamine](../../../../04-PracticalSamples/foundrylocal)
- [Oodatav väljund](../../../../04-PracticalSamples/foundrylocal)
- [Järgmised sammud](../../../../04-PracticalSamples/foundrylocal)
- [Tõrkeotsing](../../../../04-PracticalSamples/foundrylocal)

## Eeltingimused

Enne õpetuse alustamist veendu, et sul oleks:

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

## Projekti ülevaade

Projekt koosneb neljast põhikomponendist:

1. **Application.java** - Spring Booti rakenduse peamine käivituspunkt
2. **FoundryLocalService.java** - Teenuse kiht, mis haldab AI suhtlust
3. **application.properties** - Konfiguratsioon Foundry Locali ühenduse jaoks
4. **pom.xml** - Maven sõltuvused ja projekti konfiguratsioon

## Koodi mõistmine

### 1. Rakenduse konfiguratsioon (application.properties)

**Fail:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```

**Mida see teeb:**
- **base-url**: Määrab, kus Foundry Local töötab, sealhulgas `/v1` tee OpenAI API ühilduvuse jaoks. **Märkus**: Foundry Local määrab dünaamiliselt pordi, seega kontrolli tegelikku porti käsuga `foundry service status`
- **model**: Määrab AI mudeli nime, mida kasutatakse tekstigeneratsiooniks, sealhulgas versiooninumbri (nt `:1`). Kasuta `foundry model list`, et näha saadaolevaid mudeleid koos nende täpsete ID-dega

**Põhimõte:** Spring Boot laadib need omadused automaatselt ja teeb need rakendusele kättesaadavaks, kasutades annotatsiooni `@Value`.

### 2. Põhirakenduse klass (Application.java)

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
- `@SpringBootApplication` lubab Spring Booti automaatkonfiguratsiooni
- `WebApplicationType.NONE` ütleb Springile, et tegemist on käsurearakendusega, mitte veebiserveriga
- Peamine meetod käivitab Springi rakenduse

**Demo käivitaja:**
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

**Mida see teeb:**
- `@Bean` loob komponendi, mida Spring haldab
- `CommandLineRunner` käivitab koodi pärast Spring Booti käivitamist
- `foundryLocalService` süstitakse automaatselt Springi poolt (sõltuvuste süstimine)
- Saadab testisõnumi AI-le ja kuvab vastuse

### 3. AI teenuse kiht (FoundryLocalService.java)

**Fail:** `src/main/java/com/example/FoundryLocalService.java`

#### Konfiguratsiooni süstimine:
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
- Süntaks `:default-value` pakub varuväärtusi, kui omadused pole määratud

#### Kliendi initsialiseerimine:
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
- `application.properties` failist pärit baasaadress sisaldab juba `/v1` OpenAI API ühilduvuse jaoks
- API võti on seatud "not-needed", kuna kohalik arendus ei nõua autentimist

#### Vestlusmeetod:
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

**Mida see teeb:**
- **ChatCompletionCreateParams**: Konfigureerib AI päringu
  - `model`: Määrab, millist AI mudelit kasutada (peab vastama täpsele ID-le `foundry model list` käsust)
  - `addUserMessage`: Lisab sinu sõnumi vestlusesse
  - `maxTokens`: Piirab vastuse pikkust (säästab ressursse)
  - `temperature`: Kontrollib juhuslikkust (0.0 = deterministlik, 1.0 = loov)
- **API päring**: Saadab päringu Foundry Localile
- **Vastuse töötlemine**: Ekstraheerib AI tekstivastuse turvaliselt
- **Tõrkeotsing**: Käsitleb erandeid kasulike veateadetega

### 4. Projekti sõltuvused (pom.xml)

**Peamised sõltuvused:**

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

## Kuidas kõik koos töötab

Siin on täielik voog, kui rakendust käivitatakse:

1. **Käivitamine**: Spring Boot käivitub ja loeb `application.properties` faili
2. **Teenuse loomine**: Spring loob `FoundryLocalService` ja süstib konfiguratsiooniväärtused
3. **Kliendi seadistamine**: `@PostConstruct` initsialiseerib OpenAI kliendi, et ühendada Foundry Localiga
4. **Demo täitmine**: `CommandLineRunner` käivitub pärast käivitamist
5. **AI päring**: Demo kutsub `foundryLocalService.chat()` testisõnumiga
6. **API päring**: Teenus koostab ja saadab OpenAI-ühilduva päringu Foundry Localile
7. **Vastuse töötlemine**: Teenus ekstraheerib ja tagastab AI vastuse
8. **Kuvamine**: Rakendus prindib vastuse ja väljub

## Foundry Locali seadistamine

Foundry Locali seadistamiseks järgi neid samme:

1. **Paigalda Foundry Local** vastavalt juhistele [Eeltingimused](../../../../04-PracticalSamples/foundrylocal) jaotises.

2. **Kontrolli dünaamiliselt määratud porti**. Foundry Local määrab automaatselt pordi käivitamisel. Leia oma port käsuga:
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

4. **Konfigureeri application.properties** fail, et see vastaks sinu Foundry Locali seadetele:
   - Uuenda porti `base-url` (2. samm), veendudes, et see sisaldab `/v1` lõpus
   - Uuenda mudeli nime, et see sisaldaks versiooninumbrit (kontrolli `foundry model list` käsuga)
   
   Näide:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```

## Rakenduse käivitamine

### Samm 1: Käivita Foundry Local
```bash
foundry model run phi-3.5-mini
```

### Samm 2: Ehitamine ja rakenduse käivitamine
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Oodatav väljund

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

## Järgmised sammud

Rohkem näiteid leiad [Peatükk 04: Praktilised näited](../README.md)

## Tõrkeotsing

### Levinud probleemid

**"Connection refused" või "Service unavailable"**
- Veendu, et Foundry Local töötab: `foundry model list`
- Kontrolli, millist porti Foundry Local kasutab: `foundry service status`
- Uuenda oma `application.properties` õige portiga, veendudes, et URL lõppeb `/v1`
- Alternatiivina määra kindel port, kui soovid: `foundry service set --port 5273`
- Proovi Foundry Locali taaskäivitada: `foundry model run phi-3.5-mini`

**"Model not found" või "404 Not Found" vead**
- Kontrolli saadaolevaid mudeleid koos täpsete ID-dega: `foundry model list`
- Uuenda mudeli nime `application.properties` failis, et see vastaks täpselt, sealhulgas versiooninumber (nt `Phi-3.5-mini-instruct-cuda-gpu:1`)
- Veendu, et `base-url` sisaldab `/v1` lõpus: `http://localhost:5273/v1`
- Laadi mudel alla, kui vaja: `foundry model run phi-3.5-mini`

**"400 Bad Request" vead**
- Kontrolli, et baasaadress sisaldab `/v1`: `http://localhost:5273/v1`
- Veendu, et mudeli ID vastab täpselt sellele, mis kuvatakse `foundry model list` käsus
- Kasuta koodis `maxTokens()` asemel `maxCompletionTokens()`

**Maveni kompileerimisvead**
- Veendu, et Java 21 või uuem on paigaldatud: `java -version`
- Puhasta ja ehita uuesti: `mvn clean compile`
- Kontrolli internetiühendust sõltuvuste allalaadimiseks

**Rakendus käivitub, kuid väljund puudub**
- Kontrolli, kas Foundry Local vastab: Ava brauseris `http://localhost:5273`
- Kontrolli rakenduse logisid konkreetsete veateadete jaoks
- Veendu, et mudel on täielikult laaditud ja valmis

---

**Lahtiütlus**:  
See dokument on tõlgitud AI tõlketeenuse [Co-op Translator](https://github.com/Azure/co-op-translator) abil. Kuigi püüame tagada täpsust, palume arvestada, et automaatsed tõlked võivad sisaldada vigu või ebatäpsusi. Algne dokument selle algses keeles tuleks pidada autoriteetseks allikaks. Olulise teabe puhul soovitame kasutada professionaalset inimtõlget. Me ei vastuta selle tõlke kasutamisest tulenevate arusaamatuste või valesti tõlgenduste eest.