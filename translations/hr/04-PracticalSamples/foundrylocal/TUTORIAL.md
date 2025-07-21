<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2284c54d2a98090a37df0dbef1633ebf",
  "translation_date": "2025-07-21T21:24:27+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/TUTORIAL.md",
  "language_code": "hr"
}
-->
# Foundry Local Spring Boot Vodič

## Sadržaj

- [Preduvjeti](../../../../04-PracticalSamples/foundrylocal)
- [Pregled Projekta](../../../../04-PracticalSamples/foundrylocal)
- [Razumijevanje Koda](../../../../04-PracticalSamples/foundrylocal)
  - [1. Konfiguracija Aplikacije (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. Glavna Klasa Aplikacije (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. AI Servisni Sloj (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. Ovisnosti Projekta (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [Kako Sve Zajedno Funkcionira](../../../../04-PracticalSamples/foundrylocal)
- [Postavljanje Foundry Local](../../../../04-PracticalSamples/foundrylocal)
- [Pokretanje Aplikacije](../../../../04-PracticalSamples/foundrylocal)
- [Očekivani Izlaz](../../../../04-PracticalSamples/foundrylocal)
- [Sljedeći Koraci](../../../../04-PracticalSamples/foundrylocal)
- [Rješavanje Problema](../../../../04-PracticalSamples/foundrylocal)

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

## Pregled Projekta

Ovaj projekt sastoji se od četiri glavne komponente:

1. **Application.java** - Glavna ulazna točka Spring Boot aplikacije
2. **FoundryLocalService.java** - Servisni sloj koji upravlja komunikacijom s AI-jem
3. **application.properties** - Konfiguracija za povezivanje s Foundry Local
4. **pom.xml** - Maven ovisnosti i konfiguracija projekta

## Razumijevanje Koda

### 1. Konfiguracija Aplikacije (application.properties)

**Datoteka:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu
```

**Što ovo radi:**
- **base-url**: Definira gdje je pokrenut Foundry Local (zadani port 5273)
- **model**: Navodi AI model koji će se koristiti za generiranje teksta

**Ključni koncept:** Spring Boot automatski učitava ove postavke i čini ih dostupnima vašoj aplikaciji pomoću `@Value` anotacije.

### 2. Glavna Klasa Aplikacije (Application.java)

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
- `WebApplicationType.NONE` govori Springu da je ovo aplikacija naredbenog retka, a ne web poslužitelj
- Glavna metoda pokreće Spring aplikaciju

**Demo Pokretač:**
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

**Što ovo radi:**
- `@Bean` stvara komponentu kojom Spring upravlja
- `CommandLineRunner` izvršava kod nakon što se Spring Boot pokrene
- `foundryLocalService` se automatski ubrizgava pomoću Springa (injektiranje ovisnosti)
- Šalje testnu poruku AI-ju i prikazuje odgovor

### 3. AI Servisni Sloj (FoundryLocalService.java)

**Datoteka:** `src/main/java/com/example/FoundryLocalService.java`

#### Ubrizgavanje Konfiguracije:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu}")
    private String model;
```

**Što ovo radi:**
- `@Service` označava da ova klasa pruža poslovnu logiku
- `@Value` ubrizgava vrijednosti konfiguracije iz application.properties
- Sintaksa `:default-value` pruža zadane vrijednosti ako postavke nisu definirane

#### Inicijalizacija Klijenta:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")        // Foundry Local uses OpenAI-compatible API
            .apiKey("unused")                 // Local server doesn't need real API key
            .build();
}
```

**Što ovo radi:**
- `@PostConstruct` pokreće ovu metodu nakon što Spring kreira servis
- Stvara OpenAI klijent koji pokazuje na vašu lokalnu Foundry Local instancu
- Putanja `/v1` je potrebna za kompatibilnost s OpenAI API-jem
- API ključ je "neiskorišten" jer lokalni razvoj ne zahtijeva autentifikaciju

#### Chat Metoda:
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
- **ChatCompletionCreateParams**: Konfigurira zahtjev za AI
  - `model`: Navodi koji AI model koristiti
  - `addUserMessage`: Dodaje vašu poruku u razgovor
  - `maxCompletionTokens`: Ograničava duljinu odgovora (štedi resurse)
  - `temperature`: Kontrolira nasumičnost (0.0 = deterministički, 1.0 = kreativno)
- **API Poziv**: Šalje zahtjev Foundry Local-u
- **Obrada Odgovora**: Sigurno izvlači tekstualni odgovor AI-ja
- **Rukovanje Pogreškama**: Omotava iznimke korisnim porukama o pogrešci

### 4. Ovisnosti Projekta (pom.xml)

**Ključne Ovisnosti:**

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

## Kako Sve Zajedno Funkcionira

Evo kompletnog tijeka kada pokrenete aplikaciju:

1. **Pokretanje**: Spring Boot se pokreće i učitava `application.properties`
2. **Kreiranje Servisa**: Spring kreira `FoundryLocalService` i ubrizgava konfiguracijske vrijednosti
3. **Postavljanje Klijenta**: `@PostConstruct` inicijalizira OpenAI klijent za povezivanje s Foundry Local
4. **Izvršavanje Dema**: `CommandLineRunner` se izvršava nakon pokretanja
5. **AI Poziv**: Demo poziva `foundryLocalService.chat()` s testnom porukom
6. **API Zahtjev**: Servis gradi i šalje zahtjev kompatibilan s OpenAI API-jem Foundry Local-u
7. **Obrada Odgovora**: Servis izvlači i vraća AI-jev odgovor
8. **Prikaz**: Aplikacija ispisuje odgovor i zatvara se

## Postavljanje Foundry Local

Za postavljanje Foundry Local, slijedite ove korake:

1. **Instalirajte Foundry Local** koristeći upute iz odjeljka [Preduvjeti](../../../../04-PracticalSamples/foundrylocal).
2. **Preuzmite AI model** koji želite koristiti, na primjer, `phi-3.5-mini`, pomoću sljedeće naredbe:
   ```bash
   foundry model run phi-3.5-mini
   ```
3. **Konfigurirajte datoteku application.properties** kako bi odgovarala vašim postavkama Foundry Local, posebno ako koristite drugačiji port ili model.

## Pokretanje Aplikacije

### Korak 1: Pokrenite Foundry Local
```bash
foundry model run phi-3.5-mini
```

### Korak 2: Izgradite i Pokrenite Aplikaciju
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Očekivani Izlaz

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

## Sljedeći Koraci

Za više primjera, pogledajte [Poglavlje 04: Praktični primjeri](../README.md)

## Rješavanje Problema

### Uobičajeni Problemi

**"Connection refused" ili "Service unavailable"**
- Provjerite je li Foundry Local pokrenut: `foundry model list`
- Provjerite je li servis na portu 5273: Provjerite `application.properties`
- Pokušajte ponovno pokrenuti Foundry Local: `foundry model run phi-3.5-mini`

**Pogreške "Model not found"**
- Provjerite dostupne modele: `foundry model list`
- Ažurirajte naziv modela u `application.properties` kako bi se točno podudarao
- Preuzmite model ako je potrebno: `foundry model run phi-3.5-mini`

**Pogreške pri Maven kompilaciji**
- Provjerite imate li Java 21 ili noviju verziju: `java -version`
- Očistite i ponovno izgradite: `mvn clean compile`
- Provjerite internetsku vezu za preuzimanje ovisnosti

**Aplikacija se pokreće, ali nema izlaza**
- Provjerite odgovara li Foundry Local: Otvorite preglednik na `http://localhost:5273`
- Provjerite logove aplikacije za specifične poruke o pogrešci
- Provjerite je li model potpuno učitan i spreman

**Odricanje od odgovornosti**:  
Ovaj dokument je preveden pomoću AI usluge za prevođenje [Co-op Translator](https://github.com/Azure/co-op-translator). Iako nastojimo osigurati točnost, imajte na umu da automatski prijevodi mogu sadržavati pogreške ili netočnosti. Izvorni dokument na izvornom jeziku treba smatrati autoritativnim izvorom. Za kritične informacije preporučuje se profesionalni prijevod od strane čovjeka. Ne preuzimamo odgovornost za bilo kakva nesporazuma ili pogrešna tumačenja koja proizlaze iz korištenja ovog prijevoda.