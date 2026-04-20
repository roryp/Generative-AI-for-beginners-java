# Tutorial Foundry Local Spring Boot

## Cuprins

- [Cerințe preliminare](#cerințe-preliminare)
- [Prezentarea proiectului](#prezentarea-proiectului)
- [Înțelegerea codului](#înțelegerea-codului)
  - [1. Configurarea aplicației (application.properties)](#1-configurarea-aplicației-applicationproperties)
  - [2. Clasa principală a aplicației (Application.java)](#2-clasa-principală-a-aplicației-applicationjava)
  - [3. Stratul de servicii AI (FoundryLocalService.java)](#3-strat-de-servicii-ai-foundrylocalservicejava)
  - [4. Dependențe proiect (pom.xml)](#4-dependențe-proiect-pomxml)
- [Cum funcționează totul împreună](#cum-funcționează-totul-împreună)
- [Configurarea Foundry Local](#configurarea-foundry-local)
- [Rularea aplicației](#rularea-aplicației)
- [Rezultate așteptate](#rezultate-așteptate)
- [Pași următori](#pași-următori)
- [Depanare](#depanare)


## Cerințe preliminare

Înainte de a începe acest tutorial, asigură-te că ai:

- **Java 21 sau o versiune superioară** instalată pe sistemul tău
- **Maven 3.6+** pentru construirea proiectului
- **Foundry Local** instalat și pornit

### **Instalare Foundry Local:**

> **Notă:** Foundry Local CLI este disponibil doar pe **Windows** și **macOS**. Linux este suportat prin intermediul [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Verifică instalarea:
```bash
foundry --version
```

## Prezentarea proiectului

Acest proiect este format din patru componente principale:

1. **Application.java** - Punctul de intrare principal al aplicației Spring Boot
2. **FoundryLocalService.java** - Strat de servicii care gestionează comunicarea cu AI
3. **application.properties** - Configurația pentru conexiunea Foundry Local
4. **pom.xml** - Dependențele Maven și configurația proiectului

## Înțelegerea codului

### 1. Configurarea aplicației (application.properties)

**Fișier:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Ce face acest fișier:**
- **base-url**: Specifică unde rulează Foundry Local, incluzând calea `/v1` pentru compatibilitatea cu API-ul OpenAI. Portul implicit este `5273`. Dacă portul este diferit, verifică-l cu `foundry service status`.
- **model** (opțional): Numele modelului AI folosit pentru generarea textului. **Implicit, aplicația detectează automat modelul** interogând endpoint-ul `/v1/models` al Foundry Local la pornire, deci nu trebuie să îl setezi manual. Totuși, îl poți seta explicit pentru a suprascrie detectarea automată.

**Concept cheie:** Spring Boot încarcă automat aceste proprietăți și le face disponibile aplicației folosind adnotarea `@Value`.

### 2. Clasa principală a aplicației (Application.java)

**Fișier:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Nu este necesar niciun server web
        app.run(args);
    }
```

**Ce face această clasă:**
- `@SpringBootApplication` activează configurarea automată Spring Boot
- `WebApplicationType.NONE` indică faptul că este o aplicație de comandă, nu un server web
- Metoda main pornește aplicația Spring

**Runner-ul demo:**
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

**Ce face acest runner:**
- `@Bean` creează un component gestionat de Spring
- `CommandLineRunner` execută cod după pornirea Spring Boot
- `foundryLocalService` este injectat automat de Spring (injeție de dependență)
- Trimite un mesaj de test către AI și afișează răspunsul

### 3. Strat de servicii AI (FoundryLocalService.java)

**Fișier:** `src/main/java/com/example/FoundryLocalService.java`

#### Injecția configurației:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Detectat automat dacă este gol
```

**Ce face:**
- `@Service` spune lui Spring că această clasă oferă logica business
- `@Value` injectează valorile din `application.properties`
- Modelul are valoarea implicită goală, ceea ce declanșează **detectarea automată** la pornire din Foundry Local. Astfel, aplicația funcționează cu orice model încărcat în Foundry Local fără configurare manuală.

#### Inițializarea clientului:
```java
@PostConstruct
public void init() {
    // Detectează automat modelul din Foundry Local dacă nu este configurat explicit
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // URL-ul de bază include deja /v1 din configurație
            .apiKey("not-needed")            // Serverul local nu are nevoie de o cheie API reală
            .build();
}
```

**Ce face:**
- `@PostConstruct` execută această metodă după ce Spring creează serviciul
- Dacă nu este configurat niciun model, interoghează endpoint-ul `/v1/models` al Foundry Local și alege primul model încărcat
- Creează un client OpenAI care se conectează la instanța locală Foundry Local
- URL-ul de bază din `application.properties` include deja `/v1` pentru compatibilitatea cu API-ul OpenAI
- Cheia API este setată la "not-needed" deoarece dezvoltarea locală nu necesită autentificare

#### Metoda chat:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Ce model AI să folosească
                .addUserMessage(message)         // Întrebarea/solicitarea ta
                .maxCompletionTokens(150)        // Limitează lungimea răspunsului
                .temperature(0.7)                // Controlează creativitatea (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Extrage răspunsul AI din rezultatul API-ului
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**Ce face:**
- **ChatCompletionCreateParams**: Configurează cererea către AI
  - `model`: Specifică modelul AI de folosit (trebuie să corespundă exact ID-ului din `foundry model list`)
  - `addUserMessage`: Adaugă mesajul tău la conversație
  - `maxCompletionTokens`: Limitează lungimea răspunsului (economisește resurse)
  - `temperature`: Controlează aleatorietatea (0.0 = determinist, 1.0 = creativ)
- **Apel API**: Trimite cererea către Foundry Local
- **Gestionarea răspunsului**: Extrage în siguranță textul răspunsului AI
- **Gestionarea erorilor**: Învelește excepțiile cu mesaje de eroare utile

### 4. Dependențe proiect (pom.xml)

**Dependențe cheie:**

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

**Ce oferă:**
- **spring-boot-starter**: Funcționalități de bază Spring Boot
- **openai-java**: SDK oficial OpenAI Java pentru comunicarea API
- **jackson-databind**: Serializare/deserializare JSON pentru apeluri API

## Cum funcționează totul împreună

Fluxul complet când rulezi aplicația:

1. **Pornire**: Spring Boot pornește și citește `application.properties`
2. **Crearea serviciului**: Spring creează `FoundryLocalService` și injectează valorile de configurare
3. **Detectarea modelului**: Dacă nu este configurat un model, serviciul interoghează Foundry Local la `/v1/models` și folosește automat primul model disponibil
4. **Configurarea clientului**: `@PostConstruct` inițializează clientul OpenAI pentru conexiunea cu Foundry Local
5. **Executarea demo-ului**: `CommandLineRunner` rulează după pornire
6. **Apel AI**: Demo-ul apelează `foundryLocalService.chat()` cu un mesaj de test
7. **Cerere API**: Serviciul construiește și trimite cererea compatibilă OpenAI către Foundry Local
8. **Procesarea răspunsului**: Serviciul extrage și returnează răspunsul AI
9. **Afișare**: Aplicația tipărește răspunsul și se încheie

## Configurarea Foundry Local

1. **Instalează Foundry Local** urmând instrucțiunile din secțiunea [Cerințe preliminare](#cerințe-preliminare).

2. **Pornește serviciul** (dacă nu este deja pornit):
   ```bash
   foundry service start
   ```

3. **Verifică starea serviciului** pentru a confirma că rulează și notează portul:
   ```bash
   foundry service status
   ```

4. **Descarcă și rulează un model** (se descarcă la prima rulare, apoi este cache-uit):
   ```bash
   foundry model run phi-4-mini
   ```
   Aceasta deschide o sesiune interactivă de chat. Poți ieși cu `Ctrl+C`. Modelul rămâne încărcat în serviciu.

   > **Sfat:** Rulează `foundry model list` pentru a vedea toate modelele disponibile. Înlocuiește `phi-4-mini` cu orice alias din catalog (de exemplu `qwen2.5-0.5b` pentru un model mai mic/mai rapid).

5. **Verifică că modelul este încărcat:**
   ```bash
   foundry service ps
   ```

6. **Actualizează `application.properties`** dacă este necesar:
   - URL-ul implicit `base-url` (`http://localhost:5273/v1`) se potrivește cu portul implicit CLI. Actualizează-l doar dacă `foundry service status` afișează un port diferit.
   - Modelul este **detectat automat** la pornire — nu necesită configurare.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Rularea aplicației

### Pasul 1: Asigură-te că un model este încărcat în Foundry Local
```bash
foundry service ps
```
Dacă nu sunt listate modele, încarcă unul:
```bash
foundry model run phi-4-mini
```

### Pasul 2: Construiește și rulează aplicația
Într-un terminal separat:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Sau construiește și rulează ca un JAR:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Rezultate așteptate

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

## Pași următori

Pentru mai multe exemple, vezi [Capitolul 04: Exemple practice](../README.md)

## Depanare

### Probleme comune

**„Conexiune refuzată” sau „Serviciu indisponibil”**
- Verifică serviciul: `foundry service status`
- Repornește dacă e nevoie: `foundry service restart`
- Verifică să se potrivească portul din `application.properties` cu cel din `foundry service status`
- Asigură-te că URL-ul se termină cu `/v1`: `http://localhost:5273/v1`

**„Niciun model găsit” la pornire**
- Aplicația detectează automat modelul. Asigură-te că există cel puțin un model încărcat: `foundry service ps`
- Dacă nu sunt modele încărcate: `foundry model run phi-4-mini`
- Dacă ai suprascris numele modelului în `application.properties`, verifică să fie identic cu `foundry model list`

**Erori „400 Bad Request”**
- Verifică că URL-ul de bază include `/v1`: `http://localhost:5273/v1`
- Folosește `maxCompletionTokens()` în cod, nu `maxTokens()` care este învechit

**Erori la compilarea Maven**
- Asigură-te că folosești Java 21 sau versiune superioară: `java -version`
- Curăță și recompilă: `mvn clean compile`
- Verifică conexiunea la internet pentru descărcarea dependențelor

**Probleme de conexiune cu serviciul**
- Dacă vezi `Request to local service failed`, rulează: `foundry service restart`
- Verifică modelele încărcate: `foundry service ps`
- Vezi jurnalele serviciului: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Declinare a responsabilității**:  
Acest document a fost tradus folosind serviciul de traducere AI [Co-op Translator](https://github.com/Azure/co-op-translator). Deși ne străduim pentru acuratețe, vă rugăm să rețineți că traducerile automate pot conține erori sau inexactități. Documentul original în limba sa nativă trebuie considerat sursa autorizată. Pentru informații critice, se recomandă traducerea profesională umană. Nu ne asumăm răspunderea pentru eventualele neînțelegeri sau interpretări greșite care pot apărea în urma utilizării acestei traduceri.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->