# Foundry Local vadnica za Spring Boot

## Kazalo

- [Pogoji](#pogoji)
- [Pregled projekta](#pregled-projekta)
- [Razumevanje kode](#razumevanje-kode)
  - [1. Konfiguracija aplikacije (application.properties)](#1-konfiguracija-aplikacije-applicationproperties)
  - [2. Glavna aplikacijska razredna datoteka (Application.java)](#2-glavna-aplikacijska-razredna-datoteka-applicationjava)
  - [3. Plastična storitev AI (FoundryLocalService.java)](#3-plastična-storitev-ai-foundrylocalservicejava)
  - [4. Odvisnosti projekta (pom.xml)](#4-odvisnosti-projekta-pomxml)
- [Kako vse skupaj deluje](#kako-vse-skupaj-deluje)
- [Namestitev Foundry Local](#namestitev-foundry-local-1)
- [Zagon aplikacije](#zagon-aplikacije)
- [Pričakovani rezultat](#pričakovani-rezultat)
- [Naslednji koraki](#naslednji-koraki)
- [Reševanje težav](#reševanje-težav)


## Pogoji

Pred začetkom te vadnice poskrbite, da imate:

- **Java 21 ali novejši** nameščen na vašem sistemu
- **Maven 3.6+** za gradnjo projekta
- **Foundry Local** nameščen in zagnan

### **Namestitev Foundry Local:**

> **Opomba:** Foundry Local CLI je na voljo samo za **Windows** in **macOS**. Linux je podprt preko [Foundry Local SDK-jev](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Preverite namestitev:
```bash
foundry --version
```

## Pregled projekta

Ta projekt vsebuje štiri glavne komponente:

1. **Application.java** - glavni vhodna točka Spring Boot aplikacije
2. **FoundryLocalService.java** - storitvena plast, ki upravlja komunikacijo z AI
3. **application.properties** - konfiguracija za povezavo do Foundry Local
4. **pom.xml** - Maven odvisnosti in konfiguracija projekta

## Razumevanje kode

### 1. Konfiguracija aplikacije (application.properties)

**Datoteka:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Kaj to počne:**
- **base-url**: Določa, kje teče Foundry Local, vključno s potjo `/v1` za združljivost z OpenAI API. Privzeta vrata so `5273`. Če so vrata drugačna, jih preverite z `foundry service status`.
- **model** (opcijsko): Ime AI modela za generiranje besedila. **Aplikacija privzeto samodejno zazna model** s klicem na Foundry Local `/v1/models` ob zagonu, zato tega ni treba nastavljati. Lahko pa ga nastavite ročno, če želite nadpisati samodejno zaznavanje.

**Ključni koncept:** Spring Boot samodejno naloži te lastnosti in jih omogoči v aplikaciji preko `@Value` annotacije.

### 2. Glavna aplikacijska razredna datoteka (Application.java)

**Datoteka:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Ni potreben spletni strežnik
        app.run(args);
    }
```

**Kaj to počne:**
- `@SpringBootApplication` omogoči samodejno konfiguracijo Spring Boot
- `WebApplicationType.NONE` sporoči Springu, da gre za aplikacijo ukazne vrstice, ne spletni strežnik
- Glavna metoda zažene Spring aplikacijo

**Demo izvajalec:**
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
- `@Bean` ustvari komponento, ki jo Spring upravlja
- `CommandLineRunner` izvede kodo po zagonu Spring Boot
- `foundryLocalService` je samodejno injiciran (odvisnostno vstavljanje)
- Pošlje testno sporočilo AI in prikaže odgovor

### 3. Plastična storitev AI (FoundryLocalService.java)

**Datoteka:** `src/main/java/com/example/FoundryLocalService.java`

#### Vbrizgavanje konfiguracije:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Samodejno zaznano, če je prazno
```

**Kaj to počne:**
- `@Service` pove Springu, da ta razred nudi poslovno logiko
- `@Value` vstavi vrednosti iz application.properties
- Model je privzeto prazen, kar sproži **samodejno zaznavanje** iz Foundry Local ob zagonu. To pomeni, da aplikacija deluje z vsakim modelom, ki je naložen v Foundry Local, brez ročne nastavitve.

#### Inicializacija odjemalca:
```java
@PostConstruct
public void init() {
    // Samodejno zaznaj model iz Foundry Local, če ni izrecno konfiguriran
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Osnovni URL že vključuje /v1 iz konfiguracije
            .apiKey("not-needed")            // Lokalni strežnik ne potrebuje pravega API ključa
            .build();
}
```

**Kaj to počne:**
- `@PostConstruct` zažene to metodo po tem, ko Spring ustvari storitev
- Če model ni konfiguriran, poizve na Foundry Local `/v1/models` endpoint in izbere prvi naloženi model
- Ustvari OpenAI odjemalca, ki kaže na lokalni Foundry Local primer
- Osnovni URL iz `application.properties` že vključuje `/v1` za združljivost z OpenAI API
- API ključ je nastavljen na "not-needed", ker lokalni razvoj ne zahteva preverjanja pristnosti

#### Metoda za klepet:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Kateri model umetne inteligence uporabiti
                .addUserMessage(message)         // Vaše vprašanje/spodbudnik
                .maxCompletionTokens(150)        // Omeji dolžino odgovora
                .temperature(0.7)                // Nadzoruj ustvarjalnost (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Izvleci odgovor umetne inteligence iz rezultata API-ja
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
  - `maxCompletionTokens`: Omeji dolžino odgovora (varčevanje z viri)
  - `temperature`: Nadzor naključnosti (0.0 = determinističen, 1.0 = kreativen)
- **API klic**: Pošlje zahtevo Foundry Local
- **Obdelava odgovora**: Varno pridobi besedilo odgovora AI
- **Obravnava napak**: Zajame izjeme z uporabnimi napakami

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

**Kaj to počnejo:**
- **spring-boot-starter**: Zagotavlja osnovno funkcionalnost Spring Boot
- **openai-java**: Uradni OpenAI Java SDK za komunikacijo z API
- **jackson-databind**: Upravlja JSON seralizacijo/deseralizacijo za API klice

## Kako vse skupaj deluje

Tukaj je celoten potek, ko zaženete aplikacijo:

1. **Zagon:** Spring Boot se zažene in prebere `application.properties`
2. **Ustvarjanje storitve:** Spring ustvari `FoundryLocalService` in vbrizga konfiguracijske vrednosti
3. **Zaznavanje modela:** Če model ni konfiguriran, storitev poizve Foundry Local `/v1/models` endpoint in samodejno uporabi prvi na voljo model
4. **Nastavitev odjemalca:** `@PostConstruct` inicializira OpenAI odjemalca za povezavo z Foundry Local
5. **Izvajanje demo:** `CommandLineRunner` se izvaja po zagonu
6. **Klic AI:** Demo kliče `foundryLocalService.chat()` z testnim sporočilom
7. **Zahteva API:** Storitev sestavi in pošlje OpenAI združljivo zahtevo v Foundry Local
8. **Obdelava odgovora:** Storitev pridobi in vrne odgovor AI
9. **Izpis:** Aplikacija izpiše odgovor in konča

## Namestitev Foundry Local

1. **Namestite Foundry Local** po navodilih v razdelku [Pogoji](#pogoji).

2. **Zaženite storitev** (če že ne teče):
   ```bash
   foundry service start
   ```

3. **Preverite stanje storitve**, da potrdite, da teče in zabeležite vrata:
   ```bash
   foundry service status
   ```

4. **Prenesite in zaženite model** (prenese se ob prvem zagonu, predpomni za nadaljnje zagon):
   ```bash
   foundry model run phi-4-mini
   ```
   Ta ukaz odpre interaktivno klepetalno sejo. Izhod je možen z `Ctrl+C`. Model ostane naložen v storitvi.

   > **Namig:** Za prikaz vseh razpoložljivih modelov zaženite `foundry model list`. Zamenjajte `phi-4-mini` z katerimkoli aliasom iz kataloga (npr. `qwen2.5-0.5b` za manjši/hitrejši model).

5. **Preverite, da je model naložen:**
   ```bash
   foundry service ps
   ```

6. **Posodobite `application.properties`, če je potrebno:**
   - Privzeti `base-url` (`http://localhost:5273/v1`) ustreza privzetim CLI vratom. Posodobite samo, če `foundry service status` pokaže drugačna vrata.
   - Model je **samodejno zaznan** ob zagonu — konfiguracija ni potrebna.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Zagon aplikacije

### Korak 1: Preverite, da je model naložen v Foundry Local
```bash
foundry service ps
```
Če niso na voljo modeli, naložite enega:
```bash
foundry model run phi-4-mini
```

### Korak 2: Sestavite in zaženite aplikacijo
V drugem terminalu:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Ali sestavite in zaženite kot JAR:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Pričakovani rezultat

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

## Naslednji koraki

Za več primerov glejte [Poglavje 04: Praktični primeri](../README.md)

## Reševanje težav

### Pogoste težave

**"Povezava zavrnjena" ali "Storitev ni na voljo"**
- Preverite storitev: `foundry service status`
- Ponovno zaženite, če je potrebno: `foundry service restart`
- Preverite, da vrata v `application.properties` ustrezajo izpisu `foundry service status`
- Prepričajte se, da URL konča z `/v1`: `http://localhost:5273/v1`

**"Model ni najden" ob zagonu**
- Aplikacija samodejno zazna model. Prepričajte se, da je naložen vsaj en model: `foundry service ps`
- Če ni naloženih modelov: `foundry model run phi-4-mini`
- Če ste ročno nastavili ime modela v `application.properties`, preverite, da ustreza izpisu `foundry model list`

**Napake "400 Bad Request"**
- Prepričajte se, da osnovni URL vključuje `/v1`: `http://localhost:5273/v1`
- Poskrbite, da v kodi uporabljate `maxCompletionTokens()` (ne zastarelega `maxTokens()`)

**Napake pri prevajanju Maven**
- Poskrbite, da imate Java 21 ali novejšo: `java -version`
- Počistite in ponovno sestavite: `mvn clean compile`
- Preverite internetno povezavo za prenos odvisnosti

**Težave s povezavo do storitve**
- Če vidite `Request to local service failed`, zaženite: `foundry service restart`
- Preverite naložene modele: `foundry service ps`
- Oglejte si dnevniške datoteke storitve: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Omejitev odgovornosti**:
Ta dokument je bil preveden z uporabo storitve za prevajanje z umetno inteligenco [Co-op Translator](https://github.com/Azure/co-op-translator). Čeprav si prizadevamo za natančnost, vas opozarjamo, da avtomatizirani prevodi lahko vsebujejo napake ali netočnosti. Izvirni dokument v njegovem izvirnem jeziku velja za avtoritativni vir. Za kritične informacije priporočamo strokovni človeški prevod. Nismo odgovorni za morebitna nesporazume ali napačne interpretacije, ki izhajajo iz uporabe tega prevoda.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->