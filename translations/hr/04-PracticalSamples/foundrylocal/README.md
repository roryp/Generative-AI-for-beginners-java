# Foundry Local Spring Boot Vodič

## Sadržaj

- [Preduvjeti](../../../../04-PracticalSamples/foundrylocal)
- [Pregled projekta](../../../../04-PracticalSamples/foundrylocal)
- [Razumijevanje koda](../../../../04-PracticalSamples/foundrylocal)
  - [1. Konfiguracija aplikacije (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. Glavna klasa aplikacije (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. AI servisni sloj (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. Ovisnosti projekta (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [Kako sve funkcionira zajedno](../../../../04-PracticalSamples/foundrylocal)
- [Postavljanje Foundry Local](../../../../04-PracticalSamples/foundrylocal)
- [Pokretanje aplikacije](../../../../04-PracticalSamples/foundrylocal)
- [Očekivani izlaz](../../../../04-PracticalSamples/foundrylocal)
- [Sljedeći koraci](../../../../04-PracticalSamples/foundrylocal)
- [Rješavanje problema](../../../../04-PracticalSamples/foundrylocal)

## Preduvjeti

Prije nego započnete ovaj vodič, provjerite imate li:

- **Java 21 ili noviju verziju** instaliranu na vašem sustavu
- **Maven 3.6+** za izgradnju projekta
- **Foundry Local** instaliran i pokrenut

### **Instalirajte Foundry Local:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```


## Pregled projekta

Ovaj projekt sastoji se od četiri glavne komponente:

1. **Application.java** - Glavna ulazna točka Spring Boot aplikacije
2. **FoundryLocalService.java** - Servisni sloj koji upravlja komunikacijom s AI-jem
3. **application.properties** - Konfiguracija za povezivanje s Foundry Local
4. **pom.xml** - Maven ovisnosti i konfiguracija projekta

## Razumijevanje koda

### 1. Konfiguracija aplikacije (application.properties)

**Datoteka:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```


**Što ovo radi:**
- **base-url**: Određuje gdje je Foundry Local pokrenut, uključujući `/v1` put za kompatibilnost s OpenAI API-jem. **Napomena**: Foundry Local dinamički dodjeljuje port, pa provjerite stvarni port koristeći `foundry service status`
- **model**: Navodi naziv AI modela za generiranje teksta, uključujući broj verzije (npr. `:1`). Koristite `foundry model list` za pregled dostupnih modela s njihovim točnim ID-ovima

**Ključni koncept:** Spring Boot automatski učitava ove postavke i čini ih dostupnima vašoj aplikaciji koristeći `@Value` anotaciju.

### 2. Glavna klasa aplikacije (Application.java)

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


**Što ovo radi:**
- `@SpringBootApplication` omogućuje automatsku konfiguraciju Spring Boot-a
- `WebApplicationType.NONE` govori Springu da je ovo aplikacija za naredbeni redak, a ne web poslužitelj
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
- `@Bean` stvara komponentu koju Spring upravlja
- `CommandLineRunner` pokreće kod nakon što se Spring Boot pokrene
- `foundryLocalService` automatski se ubrizgava od strane Springa (ubrizgavanje ovisnosti)
- Šalje testnu poruku AI-ju i prikazuje odgovor

### 3. AI servisni sloj (FoundryLocalService.java)

**Datoteka:** `src/main/java/com/example/FoundryLocalService.java`

#### Ubrizgavanje konfiguracije:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```


**Što ovo radi:**
- `@Service` označava da ova klasa pruža poslovnu logiku
- `@Value` ubrizgava vrijednosti konfiguracije iz application.properties
- Sintaksa `:default-value` pruža rezervne vrijednosti ako postavke nisu definirane

#### Inicijalizacija klijenta:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```


**Što ovo radi:**
- `@PostConstruct` pokreće ovu metodu nakon što Spring kreira servis
- Stvara OpenAI klijent koji pokazuje na vašu lokalnu Foundry Local instancu
- Osnovni URL iz `application.properties` već uključuje `/v1` za kompatibilnost s OpenAI API-jem
- API ključ je postavljen na "not-needed" jer lokalni razvoj ne zahtijeva autentifikaciju

#### Metoda za razgovor:
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


**Što ovo radi:**
- **ChatCompletionCreateParams**: Konfigurira AI zahtjev
  - `model`: Određuje koji AI model koristiti (mora odgovarati točnom ID-u iz `foundry model list`)
  - `addUserMessage`: Dodaje vašu poruku u razgovor
  - `maxCompletionTokens`: Ograničava duljinu odgovora (štedi resurse)
  - `temperature`: Kontrolira slučajnost (0.0 = deterministički, 1.0 = kreativno)
- **API poziv**: Šalje zahtjev Foundry Local
- **Obrada odgovora**: Sigurno izvlači tekstualni odgovor AI-ja
- **Rukovanje greškama**: Omotava iznimke s korisnim porukama o grešci

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


**Što ovo radi:**
- **spring-boot-starter**: Pruža osnovnu funkcionalnost Spring Boot-a
- **openai-java**: Službeni OpenAI Java SDK za komunikaciju s API-jem
- **jackson-databind**: Upravljanje JSON serijalizacijom/deserijalizacijom za API pozive

## Kako sve funkcionira zajedno

Evo kompletnog toka kada pokrenete aplikaciju:

1. **Pokretanje**: Spring Boot se pokreće i čita `application.properties`
2. **Kreiranje servisa**: Spring kreira `FoundryLocalService` i ubrizgava vrijednosti konfiguracije
3. **Postavljanje klijenta**: `@PostConstruct` inicijalizira OpenAI klijent za povezivanje s Foundry Local
4. **Izvršenje demo-a**: `CommandLineRunner` se izvršava nakon pokretanja
5. **AI poziv**: Demo poziva `foundryLocalService.chat()` s testnom porukom
6. **API zahtjev**: Servis gradi i šalje zahtjev kompatibilan s OpenAI API-jem Foundry Local
7. **Obrada odgovora**: Servis izvlači i vraća AI-jev odgovor
8. **Prikaz**: Aplikacija ispisuje odgovor i izlazi

## Postavljanje Foundry Local

Za postavljanje Foundry Local, slijedite ove korake:

1. **Instalirajte Foundry Local** koristeći upute iz odjeljka [Preduvjeti](../../../../04-PracticalSamples/foundrylocal).

2. **Provjerite dinamički dodijeljeni port**. Foundry Local automatski dodjeljuje port prilikom pokretanja. Pronađite svoj port koristeći:
   ```bash
   foundry service status
   ```
   
   **Opcionalno**: Ako želite koristiti određeni port (npr. 5273), možete ga ručno konfigurirati:
   ```bash
   foundry service set --port 5273
   ```


3. **Preuzmite AI model** koji želite koristiti, na primjer, `phi-3.5-mini`, koristeći sljedeću naredbu:
   ```bash
   foundry model run phi-3.5-mini
   ```


4. **Konfigurirajte datoteku application.properties** kako bi odgovarala vašim postavkama Foundry Local:
   - Ažurirajte port u `base-url` (iz koraka 2), osiguravajući da uključuje `/v1` na kraju
   - Ažurirajte naziv modela kako bi uključivao broj verzije (provjerite s `foundry model list`)
   
   Primjer:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```


## Pokretanje aplikacije

### Korak 1: Pokrenite Foundry Local
```bash
foundry model run phi-3.5-mini
```


### Korak 2: Izgradite i pokrenite aplikaciju
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
Hello! I'm Phi-3.5, a small language model created by Microsoft. I'm currently running 
as the Phi-3.5-mini-instruct model, which is designed to be helpful, harmless, and honest 
in my interactions. I can assist with a wide variety of tasks including answering 
questions, helping with analysis, creative writing, coding, and general conversation. 
Is there something specific you'd like help with today?
=========================
```


## Sljedeći koraci

Za više primjera, pogledajte [Poglavlje 04: Praktični primjeri](../README.md)

## Rješavanje problema

### Uobičajeni problemi

**"Connection refused" ili "Service unavailable"**
- Provjerite je li Foundry Local pokrenut: `foundry model list`
- Provjerite stvarni port koji Foundry Local koristi: `foundry service status`
- Ažurirajte svoj `application.properties` s točnim portom, osiguravajući da URL završava s `/v1`
- Alternativno, postavite određeni port ako želite: `foundry service set --port 5273`
- Pokušajte ponovno pokrenuti Foundry Local: `foundry model run phi-3.5-mini`

**"Model not found" ili "404 Not Found" greške**
- Provjerite dostupne modele s njihovim točnim ID-ovima: `foundry model list`
- Ažurirajte naziv modela u `application.properties` kako bi točno odgovarao, uključujući broj verzije (npr. `Phi-3.5-mini-instruct-cuda-gpu:1`)
- Osigurajte da `base-url` uključuje `/v1` na kraju: `http://localhost:5273/v1`
- Preuzmite model ako je potrebno: `foundry model run phi-3.5-mini`

**"400 Bad Request" greške**
- Provjerite da osnovni URL uključuje `/v1`: `http://localhost:5273/v1`
- Provjerite da ID modela točno odgovara onome što je prikazano u `foundry model list`
- Osigurajte da koristite `maxCompletionTokens()` u svom kodu (ne zastarjeli `maxTokens()`)

**Maven greške pri kompilaciji**
- Provjerite imate li Java 21 ili noviju verziju: `java -version`
- Očistite i ponovno izgradite: `mvn clean compile`
- Provjerite internetsku vezu za preuzimanje ovisnosti

**Aplikacija se pokreće, ali nema izlaza**
- Provjerite odgovara li Foundry Local: Provjerite `http://localhost:5273/v1/models` ili pokrenite `foundry service status`
- Provjerite logove aplikacije za specifične poruke o grešci
- Osigurajte da je model potpuno učitan i spreman

---

**Izjava o odricanju odgovornosti**:  
Ovaj dokument je preveden pomoću AI usluge za prevođenje [Co-op Translator](https://github.com/Azure/co-op-translator). Iako nastojimo osigurati točnost, imajte na umu da automatski prijevodi mogu sadržavati pogreške ili netočnosti. Izvorni dokument na izvornom jeziku treba smatrati autoritativnim izvorom. Za ključne informacije preporučuje se profesionalni prijevod od strane čovjeka. Ne preuzimamo odgovornost za nesporazume ili pogrešna tumačenja koja proizlaze iz korištenja ovog prijevoda.