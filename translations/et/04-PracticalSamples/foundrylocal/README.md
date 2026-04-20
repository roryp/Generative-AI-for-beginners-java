# Foundry kohalik Spring Booti juhend

## Sisukord

- [Eeltingimused](#eeltingimused)
- [Projekti ülevaade](#projekti-ülevaade)
- [Koodi mõistmine](#koodi-mõistmine)
  - [1. Rakenduse konfiguratsioon (application.properties)](#1-rakenduse-konfiguratsioon-applicationproperties)
  - [2. Põhirakenduse klass (Application.java)](#2-põhirakenduse-klass-applicationjava)
  - [3. AI teenuse kiht (FoundryLocalService.java)](#3-ai-teenuse-kiht-foundrylocalservicejava)
  - [4. Projekti sõltuvused (pom.xml)](#4-projekti-sõltuvused-pomxml)
- [Kuidas see kõik koos toimib](#kuidas-see-kõik-koos-toimib)
- [Foundry Local seadistamine](#foundry-local-seadistamine)
- [Rakenduse käivitamine](#rakenduse-käivitamine)
- [Oodatav väljund](#oodatav-väljund)
- [Järgmised sammud](#järgmised-sammud)
- [Tõrkeotsing](#tõrkeotsing)


## Eeltingimused

Enne selle juhendi alustamist veendu, et sul on:

- **Java 21 või uuem** süsteemi installitud
- **Maven 3.6+** projekti ehitamiseks
- **Foundry Local** paigaldatud ja töötamas

### **Foundry Local paigaldamine:**

> **Märkus:** Foundry Local CLI on saadaval ainult **Windowsi** ja **macOSi** jaoks. Linuxit toetatakse [Foundry Local SDKde](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust) kaudu.

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Kontrolli paigaldust:
```bash
foundry --version
```

## Projekti ülevaade

See projekt koosneb neljast põhikomponendist:

1. **Application.java** - Põhirakenduse Spring Booti sissepääsupunkt
2. **FoundryLocalService.java** - Teenuse kiht, mis haldab AI suhtlust
3. **application.properties** - Foundry Local ühenduse konfiguratsioon
4. **pom.xml** - Maveni sõltuvused ja projekti konfiguratsioon

## Koodi mõistmine

### 1. Rakenduse konfiguratsioon (application.properties)

**Fail:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Mida see teeb:**
- **base-url**: Määrab, kus Foundry Local töötab, sealhulgas `/v1` tee OpenAI API jaoks. Vaiketrepid on `5273`. Kui port erineb, kontrolli seda käsuga `foundry service status`.
- **model** (valikuline): AI mudeli nimi tekstigeneratsiooniks. **Vaikimisi rakendus tuvastab mudeli automaatselt** pärides Foundry Local `/v1/models` lõpp-punkti käivitamisel, nii et sul ei ole vaja seda ise määrata. Võid selle siiski vajadusel käsitsi seada automaatse tuvastuse ülekirjutamiseks.

**Oluline mõiste:** Spring Boot laadib need omadused automaatselt ja teeb need rakendusele kättesaadavaks `@Value` annotatsiooni kaudu.

### 2. Põhirakenduse klass (Application.java)

**Fail:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Veebiserverit pole vaja
        app.run(args);
    }
```

**Mida see teeb:**
- `@SpringBootApplication` lubab Spring Booti automaatse konfiguratsiooni
- `WebApplicationType.NONE` ütleb Springile, et tegu on käsurea rakendusega, mitte veebiserveriga
- Põhimeetod käivitab Springi rakenduse

**Demo käivitaja:**
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
- Saadab test-sõnumi AI-le ja kuvab vastuse

### 3. AI teenuse kiht (FoundryLocalService.java)

**Fail:** `src/main/java/com/example/FoundryLocalService.java`

#### Konfiguratsiooni süstimine:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Kui tühi, tuvastatakse automaatselt
```

**Mida see teeb:**
- `@Service` ütleb Springile, et see klass pakub äriloogikat
- `@Value` süstib väärtusi application.properties failist
- Mudeli vaikimisi väärtus on tühi, mis käivitamisel põhjustab **automaatse tuvastuse** Foundry Localist. See tähendab, et rakendus töötab suvalise Foundry Locali mudeliga ilma käsitsi konfigureerimiseta.

#### Kliendi initsialiseerimine:
```java
@PostConstruct
public void init() {
    // Automaatne mudeli tuvastus Foundry kohalikust, kui pole selgesõnaliselt seadistatud
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Põhi-URL sisaldab konfiguratsioonist juba /v1
            .apiKey("not-needed")            // Kohalik server ei vaja tegelikku API võtit
            .build();
}
```

**Mida see teeb:**
- `@PostConstruct` käivitab selle meetodi pärast teenuse loomist Springi poolt
- Kui mudelit pole seadistatud, küsib Foundry Locali `/v1/models` lõpp-punktist ja valib esimese laetud mudeli
- Loob OpenAI kliendi, mis on suunatud sinu kohalikule Foundry Locali instantsile
- Base URL `application.properties` failist sisaldab juba `/v1` OpenAI API ühilduvuse jaoks
- API võti on seatud "not-needed", sest lokaalarendus ei nõua autentimist

#### Vestluse meetod:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Millist tehisintellekti mudelit kasutada
                .addUserMessage(message)         // Teie küsimus/käsk
                .maxCompletionTokens(150)        // Piira vastuse pikkust
                .temperature(0.7)                // Kontrolli loovust (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Eristage tehisintellekti vastus API tulemusest
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
  - `model`: Määrab, millist AI mudelit kasutada (peab täpselt vastama `foundry model list` IDle)
  - `addUserMessage`: Lisab sinu sõnumi vestlusse
  - `maxCompletionTokens`: Piirab vastuse pikkust (ressursside säästmiseks)
  - `temperature`: Kontrollib juhuslikkust (0,0 = deterministlik, 1,0 = loominguline)
- **API Päring**: Saadab päringu Foundry Localile
- **Vastuse käsitlemine**: Turvaliselt eraldab AI-st saadud tekstivastuse
- **Vigade käsitlemine**: Pakub kasulikke veateateid errorite käitlemisel

### 4. Projekti sõltuvused (pom.xml)

**Põhisõltuvused:**

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
- **openai-java**: OpenAI ametlik Java SDK API suhtluseks
- **jackson-databind**: Tegeleb JSONi serialiseerimisega/deserialiseerimisega API kõnede jaoks

## Kuidas see kõik koos toimib

Siin on kogu töövoog, kui käivitad rakenduse:

1. **Käivitamine**: Spring Boot käivitub ja loeb `application.properties`
2. **Teenuse loomine**: Spring loob `FoundryLocalService` ja süstib konfiguratsiooniväärtused
3. **Mudeli tuvastus**: Kui mudelit pole konfigureeritud, pärib teenus Foundry Locali `/v1/models` lõpp-punktist ning kasutab automaatselt esimest saadaolevat mudelit
4. **Kliendi seadistamine**: `@PostConstruct` initsialiseerib OpenAI kliendi ühenduseks Foundry Localiga
5. **Demo täitmine**: `CommandLineRunner` käivitub pärast käivitamist
6. **AI kõne**: Demo kutsub `foundryLocalService.chat()` test-sõnumiga
7. **API päring**: Teenus koostab ja saadab OpenAI ühilduva päringu Foundry Localile
8. **Vastuse töötlemine**: Teenus eraldab ja tagastab AI vastuse
9. **Kuvamine**: Rakendus prindib vastuse ja lõpetab töö

## Foundry Local seadistamine

1. **Paigalda Foundry Local** juhiste järgi [Eeltingimused](#eeltingimused) sektsioonis.

2. **Käivita teenus** (kui see veel ei tööta):
   ```bash
   foundry service start
   ```

3. **Kontrolli teenuse staatust**, veendumaks, et teenus töötab ja märgi üles port:
   ```bash
   foundry service status
   ```

4. **Laadi alla ja käivita mudel** (laetakse esimesel käivitamisel alla, järgnevatel kordadel on vahemälus):
   ```bash
   foundry model run phi-4-mini
   ```
   See avab interaktiivse vestluse. Väljumiseks kasuta `Ctrl+C`. Mudel jääb teenusesse laetuks.

   > **Näpunäide:** Kasuta `foundry model list`, et näha kõiki saadaolevaid mudeleid. Asenda `phi-4-mini` suvalise kataloogi aliasega (nt `qwen2.5-0.5b` väiksema/kiirema mudeli jaoks).

5. **Kontrolli, et mudel on laetud:**
   ```bash
   foundry service ps
   ```

6. **Värskenda vajadusel `application.properties`:**
   - Vaikimisi `base-url` (`http://localhost:5273/v1`) vastab vaikimisi CLI pordile. Muuda ainult siis, kui `foundry service status` näitab mõnda teist porti.
   - Mudel tuvastatakse käivitamisel **automaatselt** — konfiguratsiooni pole vaja muuta.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Rakenduse käivitamine

### Samm 1: Veendu, et Foundry Locali mudel on laetud
```bash
foundry service ps
```
Kui mudeleid ei kuvata, laadi üks mudel:
```bash
foundry model run phi-4-mini
```

### Samm 2: Ehitamine ja käivitamine
Teises terminalis:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Või ehita ja käivita JAR failina:
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
Hello! I'm Phi, an AI developed by Microsoft. I can assist with a wide variety of 
tasks including answering questions, helping with analysis, creative writing, coding, 
and general conversation. How can I help you today?
=========================
```

## Järgmised sammud

Lisaks näidetele vaata [Peatükk 04: Praktilised näited](../README.md)

## Tõrkeotsing

### Levinumad probleemid

**"Connection refused" või "Service unavailable"**
- Kontrolli teenust: `foundry service status`
- Taaskäivitamine vajadusel: `foundry service restart`
- Veendu, et port `application.properties` failis vastab `foundry service status` väljundile
- Kontrolli, et URL lõpeb `/v1`-ga: `http://localhost:5273/v1`

**"No model found" käivitamisel**
- Rakendus tuvastab mudeli automaatselt. Veendu, et vähemalt üks mudel on laetud: `foundry service ps`
- Kui mudeleid pole laetud: `foundry model run phi-4-mini`
- Kui oled mudeli nime käsitsi seadnud `application.properties` failis, kontrolli, et see vastab `foundry model list` nimele

**"400 Bad Request" vead**
- Kontrolli, et base URL sisaldab `/v1`: `http://localhost:5273/v1`
- Veendu, et kasutad koodis `maxCompletionTokens()` (mitte aegunud `maxTokens()`)

**Maveni kompileerimisvead**
- Veendu, et Java versioon on 21 või uuem: `java -version`
- Puhasta ja ehita uuesti: `mvn clean compile`
- Kontrolli internetiühendust sõltuvuste allalaadimiseks

**Teenusega ühenduse probleemid**
- Kui näed „Request to local service failed“, käivita `foundry service restart`
- Kontrolli laetud mudeleid: `foundry service ps`
- Vaata teenuse logisid: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Vastutusest loobumine**:
See dokument on tõlgitud kasutades tehisintellekti tõlketeenust [Co-op Translator](https://github.com/Azure/co-op-translator). Kuigi me püüame täpsust, palun arvestage, et automatiseeritud tõlgetes võib esineda vigu või ebatäpsusi. Originaaldokument selle emakeeles tuleks lugeda autoriteetseks allikaks. Olulise info puhul on soovitatav kasutada professionaalset inimtõlget. Me ei vastuta võimalike arusaamatuste ega valesti tõlgenduste eest, mis võivad tuleneda selle tõlke kasutamisest.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->