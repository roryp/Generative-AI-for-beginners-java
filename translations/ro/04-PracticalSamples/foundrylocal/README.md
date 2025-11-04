<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "f787307400de59adc25a1404466a35f3",
  "translation_date": "2025-11-04T07:34:06+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "ro"
}
-->
# Tutorial Local Foundry Spring Boot

## Cuprins

- [Prerechizite](../../../../04-PracticalSamples/foundrylocal)
- [Prezentarea Proiectului](../../../../04-PracticalSamples/foundrylocal)
- [Înțelegerea Codului](../../../../04-PracticalSamples/foundrylocal)
  - [1. Configurarea Aplicației (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. Clasa Principală a Aplicației (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. Stratul de Servicii AI (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. Dependențele Proiectului (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [Cum Funcționează Totul Împreună](../../../../04-PracticalSamples/foundrylocal)
- [Configurarea Foundry Local](../../../../04-PracticalSamples/foundrylocal)
- [Rularea Aplicației](../../../../04-PracticalSamples/foundrylocal)
- [Rezultatul Așteptat](../../../../04-PracticalSamples/foundrylocal)
- [Pași Următori](../../../../04-PracticalSamples/foundrylocal)
- [Depanare](../../../../04-PracticalSamples/foundrylocal)

## Prerechizite

Înainte de a începe acest tutorial, asigură-te că ai:

- **Java 21 sau o versiune mai recentă** instalată pe sistemul tău
- **Maven 3.6+** pentru construirea proiectului
- **Foundry Local** instalat și funcțional

### **Instalare Foundry Local:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```

## Prezentarea Proiectului

Acest proiect constă în patru componente principale:

1. **Application.java** - Punctul de intrare principal al aplicației Spring Boot
2. **FoundryLocalService.java** - Stratul de servicii care gestionează comunicarea AI
3. **application.properties** - Configurarea conexiunii pentru Foundry Local
4. **pom.xml** - Dependențele Maven și configurarea proiectului

## Înțelegerea Codului

### 1. Configurarea Aplicației (application.properties)

**Fișier:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```

**Ce face:**
- **base-url**: Specifică unde rulează Foundry Local, incluzând calea `/v1` pentru compatibilitatea cu API-ul OpenAI. **Notă**: Foundry Local atribuie dinamic un port, așa că verifică portul real folosind `foundry service status`
- **model**: Numește modelul AI utilizat pentru generarea textului, incluzând numărul versiunii (ex.: `:1`). Folosește `foundry model list` pentru a vedea modelele disponibile cu ID-urile lor exacte

**Concept cheie:** Spring Boot încarcă automat aceste proprietăți și le face disponibile aplicației tale folosind adnotarea `@Value`.

### 2. Clasa Principală a Aplicației (Application.java)

**Fișier:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```

**Ce face:**
- `@SpringBootApplication` activează configurarea automată Spring Boot
- `WebApplicationType.NONE` indică Spring că aceasta este o aplicație de linie de comandă, nu un server web
- Metoda principală pornește aplicația Spring

**Runner-ul Demo:**
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

**Ce face:**
- `@Bean` creează un component gestionat de Spring
- `CommandLineRunner` rulează codul după ce Spring Boot pornește
- `foundryLocalService` este injectat automat de Spring (injection de dependențe)
- Trimite un mesaj de test către AI și afișează răspunsul

### 3. Stratul de Servicii AI (FoundryLocalService.java)

**Fișier:** `src/main/java/com/example/FoundryLocalService.java`

#### Injectarea Configurării:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```

**Ce face:**
- `@Service` indică Spring că această clasă oferă logică de afaceri
- `@Value` injectează valorile de configurare din application.properties
- Sintaxa `:default-value` oferă valori implicite dacă proprietățile nu sunt setate

#### Inițializarea Clientului:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```

**Ce face:**
- `@PostConstruct` rulează această metodă după ce Spring creează serviciul
- Creează un client OpenAI care indică instanța locală Foundry Local
- URL-ul de bază din `application.properties` include deja `/v1` pentru compatibilitatea cu API-ul OpenAI
- Cheia API este setată la "not-needed" deoarece dezvoltarea locală nu necesită autentificare

#### Metoda Chat:
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

**Ce face:**
- **ChatCompletionCreateParams**: Configurează cererea AI
  - `model`: Specifică modelul AI utilizat (trebuie să se potrivească exact cu ID-ul din `foundry model list`)
  - `addUserMessage`: Adaugă mesajul tău la conversație
  - `maxCompletionTokens`: Limitează lungimea răspunsului (economisește resurse)
  - `temperature`: Controlează aleatoritatea (0.0 = determinist, 1.0 = creativ)
- **Apel API**: Trimite cererea către Foundry Local
- **Gestionarea Răspunsului**: Extrage răspunsul text al AI în siguranță
- **Gestionarea Erorilor**: Împachetează excepțiile cu mesaje de eroare utile

### 4. Dependențele Proiectului (pom.xml)

**Dependențe Cheie:**

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

**Ce fac:**
- **spring-boot-starter**: Oferă funcționalitatea de bază Spring Boot
- **openai-java**: SDK-ul oficial OpenAI Java pentru comunicarea API
- **jackson-databind**: Gestionează serializarea/deserializarea JSON pentru apelurile API

## Cum Funcționează Totul Împreună

Iată fluxul complet când rulezi aplicația:

1. **Pornire**: Spring Boot pornește și citește `application.properties`
2. **Crearea Serviciului**: Spring creează `FoundryLocalService` și injectează valorile de configurare
3. **Configurarea Clientului**: `@PostConstruct` inițializează clientul OpenAI pentru a se conecta la Foundry Local
4. **Executarea Demo**: `CommandLineRunner` se execută după pornire
5. **Apel AI**: Demo-ul apelează `foundryLocalService.chat()` cu un mesaj de test
6. **Cerere API**: Serviciul construiește și trimite cererea compatibilă OpenAI către Foundry Local
7. **Procesarea Răspunsului**: Serviciul extrage și returnează răspunsul AI
8. **Afișare**: Aplicația afișează răspunsul și se închide

## Configurarea Foundry Local

Pentru a configura Foundry Local, urmează acești pași:

1. **Instalează Foundry Local** folosind instrucțiunile din secțiunea [Prerechizite](../../../../04-PracticalSamples/foundrylocal).

2. **Verifică portul atribuit dinamic**. Foundry Local atribuie automat un port la pornire. Găsește portul tău cu:
   ```bash
   foundry service status
   ```
   
   **Opțional**: Dacă preferi să folosești un port specific (ex.: 5273), îl poți configura manual:
   ```bash
   foundry service set --port 5273
   ```

3. **Descarcă modelul AI** pe care vrei să-l folosești, de exemplu, `phi-3.5-mini`, cu următoarea comandă:
   ```bash
   foundry model run phi-3.5-mini
   ```

4. **Configurează fișierul application.properties** pentru a se potrivi cu setările Foundry Local:
   - Actualizează portul în `base-url` (din pasul 2), asigurându-te că include `/v1` la final
   - Actualizează numele modelului pentru a include numărul versiunii (verifică cu `foundry model list`)
   
   Exemplu:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```

## Rularea Aplicației

### Pasul 1: Pornește Foundry Local
```bash
foundry model run phi-3.5-mini
```

### Pasul 2: Construiește și Rulează Aplicația
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Rezultatul Așteptat

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

## Pași Următori

Pentru mai multe exemple, vezi [Capitolul 04: Exemple practice](../README.md)

## Depanare

### Probleme Comune

**"Connection refused" sau "Service unavailable"**
- Asigură-te că Foundry Local rulează: `foundry model list`
- Verifică portul real utilizat de Foundry Local: `foundry service status`
- Actualizează `application.properties` cu portul corect, asigurându-te că URL-ul se termină cu `/v1`
- Alternativ, setează un port specific dacă dorești: `foundry service set --port 5273`
- Încearcă să repornești Foundry Local: `foundry model run phi-3.5-mini`

**"Model not found" sau erori "404 Not Found"**
- Verifică modelele disponibile cu ID-urile lor exacte: `foundry model list`
- Actualizează numele modelului în `application.properties` pentru a se potrivi exact, incluzând numărul versiunii (ex.: `Phi-3.5-mini-instruct-cuda-gpu:1`)
- Asigură-te că `base-url` include `/v1` la final: `http://localhost:5273/v1`
- Descarcă modelul dacă este necesar: `foundry model run phi-3.5-mini`

**Erori "400 Bad Request"**
- Verifică dacă URL-ul de bază include `/v1`: `http://localhost:5273/v1`
- Asigură-te că ID-ul modelului se potrivește exact cu ceea ce este afișat în `foundry model list`
- Asigură-te că folosești `maxCompletionTokens()` în codul tău (nu metoda depreciată `maxTokens()`)

**Erori de compilare Maven**
- Asigură-te că ai Java 21 sau o versiune mai recentă: `java -version`
- Curăță și reconstruiește: `mvn clean compile`
- Verifică conexiunea la internet pentru descărcarea dependențelor

**Aplicația pornește, dar nu afișează nimic**
- Verifică dacă Foundry Local răspunde: Verifică `http://localhost:5273/v1/models` sau rulează `foundry service status`
- Verifică jurnalele aplicației pentru mesaje de eroare specifice
- Asigură-te că modelul este complet încărcat și gata

---

**Declinare de responsabilitate**:  
Acest document a fost tradus folosind serviciul de traducere AI [Co-op Translator](https://github.com/Azure/co-op-translator). Deși ne străduim să asigurăm acuratețea, vă rugăm să fiți conștienți că traducerile automate pot conține erori sau inexactități. Documentul original în limba sa maternă ar trebui considerat sursa autoritară. Pentru informații critice, se recomandă traducerea profesională realizată de oameni. Nu ne asumăm responsabilitatea pentru neînțelegeri sau interpretări greșite care pot apărea din utilizarea acestei traduceri.