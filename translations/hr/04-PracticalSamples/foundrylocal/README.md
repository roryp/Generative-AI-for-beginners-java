# Foundry Local Spring Boot Tutorijal

## Sadržaj

- [Preduvjeti](#preduvjeti)
- [Pregled projekta](#pregled-projekta)
- [Razumijevanje koda](#razumijevanje-koda)
  - [1. Konfiguracija aplikacije (application.properties)](#1-konfiguracija-aplikacije-applicationproperties)
  - [2. Glavna klasa aplikacije (Application.java)](#2-glavna-klasa-aplikacije-applicationjava)
  - [3. AI servisni sloj (FoundryLocalService.java)](#3-ai-servisni-sloj-foundrylocalservicejava)
  - [4. Ovisnosti projekta (pom.xml)](#4-ovisnosti-projekta-pomxml)
- [Kako sve zajedno funkcionira](#kako-sve-zajedno-funkcionira)
- [Postavljanje Foundry Local](#postavljanje-foundry-local)
- [Pokretanje aplikacije](#pokretanje-aplikacije)
- [Očekivani izlaz](#očekivani-izlaz)
- [Sljedeći koraci](#sljedeći-koraci)
- [Rješavanje problema](#rješavanje-problema)


## Preduvjeti

Prije nego što započnete ovaj tutorijal, pobrinite se da imate:

- **Java 21 ili noviju verziju** instaliranu na vašem sustavu
- **Maven 3.6+** za build projekta
- **Foundry Local** instaliran i pokrenut

### **Instalirajte Foundry Local:**

> **Napomena:** Foundry Local CLI je dostupan samo na **Windows** i **macOS** platformama. Linux je podržan preko [Foundry Local SDK-ova](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Provjerite instalaciju:
```bash
foundry --version
```

## Pregled projekta

Ovaj projekt se sastoji od četiri glavne komponente:

1. **Application.java** - Glavna ulazna točka Spring Boot aplikacije
2. **FoundryLocalService.java** - Servisni sloj koji upravlja komunikacijom s AI-jem
3. **application.properties** - Konfiguracija za povezivanje na Foundry Local
4. **pom.xml** - Maven ovisnosti i konfiguracija projekta

## Razumijevanje koda

### 1. Konfiguracija aplikacije (application.properties)

**Datoteka:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Što ovo radi:**
- **base-url**: Određuje gdje Foundry Local radi, uključujući `/v1` put za kompatibilnost s OpenAI API-jem. Zadani port je `5273`. Ako vam je drugačiji port, provjerite ga s `foundry service status`.
- **model** (opcionalno): Ime AI modela koji će se koristiti za generiranje teksta. **Po defaultu, aplikacija automatski otkriva model** tako da na početku upita Foundry Local `/v1/models` endpoint, pa ga nije potrebno postavljati ručno. Ipak, možete ga postaviti eksplicitno ako želite prebrisati automatsko otkrivanje.

**Ključni koncept:** Spring Boot automatski učitava ove postavke i čini ih dostupnima aplikaciji putem `@Value` anotacije.

### 2. Glavna klasa aplikacije (Application.java)

**Datoteka:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Nije potreban web poslužitelj
        app.run(args);
    }
```

**Što ovo radi:**
- `@SpringBootApplication` omogućuje Spring Boot automatsku konfiguraciju
- `WebApplicationType.NONE` govori Springu da je ovo aplikacija za naredbeni redak, a ne web server
- Glavna metoda pokreće Spring aplikaciju

**Demo pokretač:**
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

**Što ovo radi:**
- `@Bean` stvara komponentu kojom Spring upravlja
- `CommandLineRunner` izvršava kod nakon pokretanja Spring Boota
- `foundryLocalService` se automatski injektira od strane Springa (dependency injection)
- Šalje testnu poruku AI-ju i prikazuje odgovor

### 3. AI servisni sloj (FoundryLocalService.java)

**Datoteka:** `src/main/java/com/example/FoundryLocalService.java`

#### Injekcija konfiguracije:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Automatski otkriveno ako je prazno
```

**Što ovo radi:**
- `@Service` govori Springu da ova klasa pruža poslovnu logiku
- `@Value` ubacuje konfiguracijske vrijednosti iz application.properties
- Model je prema defaultu prazan, što pokreće **automatsko otkrivanje** modela prilikom startupa. To znači da aplikacija radi s bilo kojim modelom učitanim u Foundry Local bez ručne konfiguracije.

#### Inicijalizacija klijenta:
```java
@PostConstruct
public void init() {
    // Automatski otkrij model iz Foundry Local ako nije eksplicitno konfiguriran
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Osnovni URL već uključuje /v1 iz konfiguracije
            .apiKey("not-needed")            // Lokalni poslužitelj ne treba pravi API ključ
            .build();
}
```

**Što ovo radi:**
- `@PostConstruct` pokreće ovu metodu nakon što Spring kreira servis
- Ako model nije konfiguriran, dohvaća Foundry Local `/v1/models` endpoint i bira prvi učitani model
- Stvara OpenAI klijent koji pokazuje na lokalnu Foundry Local instancu
- Osnovni URL iz `application.properties` već uključuje `/v1` radi kompatibilnosti s OpenAI API-jem
- API ključ je postavljen na "not-needed" jer lokalni razvoj ne zahtijeva autentikaciju

#### Chat metoda:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Koji AI model koristiti
                .addUserMessage(message)         // Vaše pitanje/upit
                .maxCompletionTokens(150)        // Ograniči duljinu odgovora
                .temperature(0.7)                // Kontroliraj kreativnost (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Izvuci odgovor AI-ja iz rezultata API-ja
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**Što ovo radi:**
- **ChatCompletionCreateParams**: Konfigurira AI zahtjev
  - `model`: Navodi koji AI model koristiti (mora točno odgovarati ID-u iz `foundry model list`)
  - `addUserMessage`: Dodaje vašu poruku u razgovor
  - `maxCompletionTokens`: Ograničava duljinu odgovora (štednja resursa)
  - `temperature`: Kontrolira slučajnost (0.0 = deterministički, 1.0 = kreativan)
- **API poziv**: Šalje zahtjev Foundry Localu
- **Obrada odgovora**: Sigurno izvlači tekst odgovora AI-ja
- **Rukovanje greškama**: Omotava iznimke korisnim porukama o grešci

### 4. Ovisnosti projekta (pom.xml)

**Ključne ovisnosti:**

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

**Što one rade:**
- **spring-boot-starter**: Pruža osnovne funkcionalnosti Spring Boota
- **openai-java**: Službeni OpenAI Java SDK za API komunikaciju
- **jackson-databind**: Rukuje serijalizacijom/deserijalizacijom JSON-a za API pozive

## Kako sve zajedno funkcionira

Evo kompletnog toka kada pokrenete aplikaciju:

1. **Pokretanje:** Spring Boot se pali i čita `application.properties`
2. **Kreiranje servisa:** Spring kreira `FoundryLocalService` i ubacuje konfiguracijske vrijednosti
3. **Otkrivanje modela:** Ako nije konfiguriran model, servis upita Foundry Local `/v1/models` endpoint i automatski koristi prvi dostupan model
4. **Postavljanje klijenta:** `@PostConstruct` inicijalizira OpenAI klijenta za povezivanje na Foundry Local
5. **Izvršavanje demo koda:** `CommandLineRunner` se izvršava nakon startupa
6. **Poziv AI-ju:** Demo poziva `foundryLocalService.chat()` s testnom porukom
7. **API zahtjev:** Servis kreira i šalje OpenAI-kompatibilan zahtjev Foundry Localu
8. **Obrada odgovora:** Servis izvlači i vraća AI-jevu poruku
9. **Prikaz:** Aplikacija ispisuje odgovor i završava izvedbu

## Postavljanje Foundry Local

1. **Instalirajte Foundry Local** koristeći upute u odjeljku [Preduvjeti](#preduvjeti).

2. **Pokrenite servis** (ako već nije pokrenut):
   ```bash
   foundry service start
   ```

3. **Provjerite status servisa** da biste potvrdili da radi i zabilježite port:
   ```bash
   foundry service status
   ```

4. **Preuzmite i pokrenite model** (preuzima se pri prvom pokretanju, sprema se u cache za sljedeće pokretanje):
   ```bash
   foundry model run phi-4-mini
   ```
   Ovo otvara interaktivnu chat sesiju. Izlaziti možete s `Ctrl+C`. Model ostaje učitan u servisu.

   > **Savjet:** Pokrenite `foundry model list` da vidite sve dostupne modele. Zamijenite `phi-4-mini` bilo kojim aliasom iz kataloga (npr. `qwen2.5-0.5b` za manji/brži model).

5. **Provjerite je li model učitan:**
   ```bash
   foundry service ps
   ```

6. **Ažurirajte `application.properties` ako je potrebno:**
   - Zadani `base-url` (`http://localhost:5273/v1`) odgovara zadanoj CLI luci. Ažurirajte samo ako `foundry service status` pokazuje drugi port.
   - Model se **automatski otkriva** pri pokretanju — nije potrebna konfiguracija.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Pokretanje aplikacije

### Korak 1: Provjerite je li model učitan u Foundry Local
```bash
foundry service ps
```
Ako nema učitanih modela, učitajte jedan:
```bash
foundry model run phi-4-mini
```

### Korak 2: Izgradite i pokrenite aplikaciju
U drugom terminalu:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Ili izgradite i pokrenite kao JAR:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Očekivani izlaz

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

## Sljedeći koraci

Za više primjera, pogledajte [Poglavlje 04: Praktični primjeri](../README.md)

## Rješavanje problema

### Česti problemi

**"Connection refused" ili "Service unavailable"**
- Provjerite servis: `foundry service status`
- Restartajte ako je potrebno: `foundry service restart`
- Provjerite odgovara li port u `application.properties` portu prikazanom kod `foundry service status`
- Provjerite završava li URL s `/v1`: `http://localhost:5273/v1`

**"No model found" prilikom starta**
- Aplikacija automatski otkriva model. Pobrinite se da je barem jedan model učitan: `foundry service ps`
- Ako nema učitanih modela: `foundry model run phi-4-mini`
- Ako ste ručno postavili ime modela u `application.properties`, provjerite da odgovara zapisu u `foundry model list`

**"400 Bad Request" greške**
- Provjerite uključuje li osnovni URL `/v1`: `http://localhost:5273/v1`
- Pobrinite se da koristite `maxCompletionTokens()` u svom kodu (a ne zastarjeli `maxTokens()`)

**Maven greške pri kompilaciji**
- Provjerite imate li Java 21 ili noviju verziju: `java -version`
- Očistite i ponovno izgradite: `mvn clean compile`
- Provjerite internet vezu za preuzimanje ovisnosti

**Problemi s povezivanjem na servis**
- Ako vidite `Request to local service failed`, pokrenite: `foundry service restart`
- Provjerite učitane modele: `foundry service ps`
- Pregledajte logove servisa: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Odricanje od odgovornosti**:  
Ovaj dokument je preveden korištenjem AI usluge za prijevod [Co-op Translator](https://github.com/Azure/co-op-translator). Iako težimo točnosti, molimo imajte na umu da automatizirani prijevodi mogu sadržavati pogreške ili netočnosti. Izvorni dokument na izvornom jeziku treba smatrati autoritativnim izvorom. Za kritične informacije preporučuje se profesionalni ljudski prijevod. Ne odgovaramo za bilo kakve nesporazume ili pogrešne interpretacije koje proizlaze iz korištenja ovog prijevoda.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->