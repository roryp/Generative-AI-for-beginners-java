<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "f787307400de59adc25a1404466a35f3",
  "translation_date": "2025-11-04T07:36:23+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "sl"
}
-->
# Foundry Local Spring Boot Vadnica

## Kazalo

- [Predpogoji](../../../../04-PracticalSamples/foundrylocal)
- [Pregled projekta](../../../../04-PracticalSamples/foundrylocal)
- [Razumevanje kode](../../../../04-PracticalSamples/foundrylocal)
  - [1. Konfiguracija aplikacije (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. Glavni razred aplikacije (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. Plast storitve AI (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. Odvisnosti projekta (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [Kako vse deluje skupaj](../../../../04-PracticalSamples/foundrylocal)
- [Nastavitev Foundry Local](../../../../04-PracticalSamples/foundrylocal)
- [Zagon aplikacije](../../../../04-PracticalSamples/foundrylocal)
- [Pričakovani izhod](../../../../04-PracticalSamples/foundrylocal)
- [Naslednji koraki](../../../../04-PracticalSamples/foundrylocal)
- [Odpravljanje težav](../../../../04-PracticalSamples/foundrylocal)

## Predpogoji

Preden začnete s to vadnico, se prepričajte, da imate:

- **Java 21 ali novejšo** nameščeno na vašem sistemu
- **Maven 3.6+** za gradnjo projekta
- **Foundry Local** nameščen in zagnan

### **Namestitev Foundry Local:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```


## Pregled projekta

Ta projekt vsebuje štiri glavne komponente:

1. **Application.java** - Glavna vstopna točka aplikacije Spring Boot
2. **FoundryLocalService.java** - Plast storitve, ki upravlja komunikacijo z AI
3. **application.properties** - Konfiguracija za povezavo s Foundry Local
4. **pom.xml** - Maven odvisnosti in konfiguracija projekta

## Razumevanje kode

### 1. Konfiguracija aplikacije (application.properties)

**Datoteka:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```

**Kaj to počne:**
- **base-url**: Določa, kje teče Foundry Local, vključno s potjo `/v1` za združljivost z OpenAI API. **Opomba**: Foundry Local dinamično dodeli vrata, zato preverite dejanska vrata z ukazom `foundry service status`
- **model**: Ime AI modela za generiranje besedila, vključno s številko različice (npr. `:1`). Uporabite `foundry model list`, da vidite razpoložljive modele z njihovimi natančnimi ID-ji

**Ključni koncept:** Spring Boot samodejno naloži te lastnosti in jih naredi dostopne vaši aplikaciji z uporabo oznake `@Value`.

### 2. Glavni razred aplikacije (Application.java)

**Datoteka:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```

**Kaj to počne:**
- `@SpringBootApplication` omogoča samodejno konfiguracijo Spring Boot
- `WebApplicationType.NONE` pove Springu, da gre za aplikacijo ukazne vrstice, ne za spletni strežnik
- Glavna metoda zažene Spring aplikacijo

**Demo Runner:**
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

**Kaj to počne:**
- `@Bean` ustvari komponento, ki jo upravlja Spring
- `CommandLineRunner` zažene kodo po zagonu Spring Boot
- `foundryLocalService` je samodejno vbrizgan s strani Springa (odvisnostna injekcija)
- Pošlje testno sporočilo AI-ju in prikaže odgovor

### 3. Plast storitve AI (FoundryLocalService.java)

**Datoteka:** `src/main/java/com/example/FoundryLocalService.java`

#### Vbrizgavanje konfiguracije:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```

**Kaj to počne:**
- `@Service` pove Springu, da ta razred zagotavlja poslovno logiko
- `@Value` vbrizga vrednosti konfiguracije iz application.properties
- Sintaksa `:default-value` zagotavlja privzete vrednosti, če lastnosti niso nastavljene

#### Inicializacija odjemalca:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```

**Kaj to počne:**
- `@PostConstruct` zažene to metodo po tem, ko Spring ustvari storitev
- Ustvari OpenAI odjemalca, ki kaže na vašo lokalno instanco Foundry Local
- Osnovni URL iz `application.properties` že vključuje `/v1` za združljivost z OpenAI API
- API ključ je nastavljen na "not-needed", ker lokalni razvoj ne zahteva avtentikacije

#### Metoda za klepet:
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

**Kaj to počne:**
- **ChatCompletionCreateParams**: Konfigurira zahtevo AI
  - `model`: Določa, kateri AI model uporabiti (mora ustrezati natančnemu ID-ju iz `foundry model list`)
  - `addUserMessage`: Doda vaše sporočilo v pogovor
  - `maxCompletionTokens`: Omeji dolžino odgovora (prihrani vire)
  - `temperature`: Nadzoruje naključnost (0.0 = deterministično, 1.0 = kreativno)
- **API klic**: Pošlje zahtevo Foundry Local
- **Obdelava odgovora**: Varno pridobi besedilni odgovor AI-ja
- **Obdelava napak**: Ovije izjeme s koristnimi sporočili o napakah

### 4. Odvisnosti projekta (pom.xml)

**Ključne odvisnosti:**

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

**Kaj te počnejo:**
- **spring-boot-starter**: Zagotavlja osnovno funkcionalnost Spring Boot
- **openai-java**: Uradni OpenAI Java SDK za komunikacijo z API-jem
- **jackson-databind**: Upravljanje JSON serializacije/deserializacije za API klice

## Kako vse deluje skupaj

Tukaj je celoten potek, ko zaženete aplikacijo:

1. **Zagon**: Spring Boot se zažene in prebere `application.properties`
2. **Ustvarjanje storitve**: Spring ustvari `FoundryLocalService` in vbrizga vrednosti konfiguracije
3. **Nastavitev odjemalca**: `@PostConstruct` inicializira OpenAI odjemalca za povezavo s Foundry Local
4. **Izvedba demo**: `CommandLineRunner` se zažene po zagonu
5. **Klic AI**: Demo pokliče `foundryLocalService.chat()` s testnim sporočilom
6. **API zahteva**: Storitev sestavi in pošlje zahtevo, združljivo z OpenAI, na Foundry Local
7. **Obdelava odgovora**: Storitev pridobi in vrne AI-jev odgovor
8. **Prikaz**: Aplikacija prikaže odgovor in se zapre

## Nastavitev Foundry Local

Za nastavitev Foundry Local sledite tem korakom:

1. **Namestite Foundry Local** z navodili v razdelku [Predpogoji](../../../../04-PracticalSamples/foundrylocal).

2. **Preverite dinamično dodeljena vrata**. Foundry Local samodejno dodeli vrata ob zagonu. Poiščite svoja vrata z:
   ```bash
   foundry service status
   ```
   
   **Neobvezno**: Če želite uporabiti določena vrata (npr. 5273), jih lahko ročno nastavite:
   ```bash
   foundry service set --port 5273
   ```

3. **Prenesite AI model**, ki ga želite uporabiti, na primer `phi-3.5-mini`, z naslednjim ukazom:
   ```bash
   foundry model run phi-3.5-mini
   ```

4. **Konfigurirajte datoteko application.properties**, da ustreza nastavitvam Foundry Local:
   - Posodobite vrata v `base-url` (iz koraka 2), pri čemer zagotovite, da vključuje `/v1` na koncu
   - Posodobite ime modela, da vključuje številko različice (preverite z `foundry model list`)
   
   Primer:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```


## Zagon aplikacije

### Korak 1: Zaženite Foundry Local
```bash
foundry model run phi-3.5-mini
```

### Korak 2: Zgradite in zaženite aplikacijo
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```


## Pričakovani izhod

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


## Naslednji koraki

Za več primerov si oglejte [Poglavje 04: Praktični primeri](../README.md)

## Odpravljanje težav

### Pogoste težave

**"Connection refused" ali "Service unavailable"**
- Prepričajte se, da Foundry Local deluje: `foundry model list`
- Preverite dejanska vrata, ki jih uporablja Foundry Local: `foundry service status`
- Posodobite svoj `application.properties` z ustreznimi vrati, pri čemer zagotovite, da URL konča z `/v1`
- Alternativno nastavite določena vrata, če želite: `foundry service set --port 5273`
- Poskusite znova zagnati Foundry Local: `foundry model run phi-3.5-mini`

**"Model not found" ali "404 Not Found" napake**
- Preverite razpoložljive modele z njihovimi natančnimi ID-ji: `foundry model list`
- Posodobite ime modela v `application.properties`, da se natančno ujema, vključno s številko različice (npr. `Phi-3.5-mini-instruct-cuda-gpu:1`)
- Prepričajte se, da `base-url` vključuje `/v1` na koncu: `http://localhost:5273/v1`
- Prenesite model, če je potrebno: `foundry model run phi-3.5-mini`

**"400 Bad Request" napake**
- Preverite, da osnovni URL vključuje `/v1`: `http://localhost:5273/v1`
- Preverite, da se ID modela natančno ujema s tistim, ki je prikazan v `foundry model list`
- Prepričajte se, da uporabljate `maxCompletionTokens()` v svoji kodi (ne zastareli `maxTokens()`)

**Napake pri Maven kompilaciji**
- Prepričajte se, da imate Java 21 ali novejšo: `java -version`
- Očistite in ponovno zgradite: `mvn clean compile`
- Preverite internetno povezavo za prenos odvisnosti

**Aplikacija se zažene, vendar ni izhoda**
- Preverite, ali Foundry Local odgovarja: Preverite `http://localhost:5273/v1/models` ali zaženite `foundry service status`
- Preverite dnevniške datoteke aplikacije za specifična sporočila o napakah
- Prepričajte se, da je model popolnoma naložen in pripravljen

---

**Omejitev odgovornosti**:  
Ta dokument je bil preveden z uporabo storitve za prevajanje AI [Co-op Translator](https://github.com/Azure/co-op-translator). Čeprav si prizadevamo za natančnost, vas prosimo, da upoštevate, da lahko avtomatizirani prevodi vsebujejo napake ali netočnosti. Izvirni dokument v njegovem maternem jeziku naj se šteje za avtoritativni vir. Za ključne informacije priporočamo profesionalni človeški prevod. Ne odgovarjamo za morebitna nesporazumevanja ali napačne razlage, ki izhajajo iz uporabe tega prevoda.