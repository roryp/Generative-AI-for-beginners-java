<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "fe08a184d8a753a0f497673921f77759",
  "translation_date": "2025-11-04T06:48:34+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "el"
}
-->
# Τοπικό Εργαστήριο Foundry - Οδηγός για Spring Boot

## Περιεχόμενα

- [Προαπαιτούμενα](../../../../04-PracticalSamples/foundrylocal)
- [Επισκόπηση Έργου](../../../../04-PracticalSamples/foundrylocal)
- [Κατανόηση του Κώδικα](../../../../04-PracticalSamples/foundrylocal)
  - [1. Ρύθμιση Εφαρμογής (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. Κύρια Κλάση Εφαρμογής (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. Επίπεδο Υπηρεσίας AI (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. Εξαρτήσεις Έργου (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [Πώς Λειτουργούν Όλα Μαζί](../../../../04-PracticalSamples/foundrylocal)
- [Ρύθμιση του Foundry Local](../../../../04-PracticalSamples/foundrylocal)
- [Εκτέλεση της Εφαρμογής](../../../../04-PracticalSamples/foundrylocal)
- [Αναμενόμενο Αποτέλεσμα](../../../../04-PracticalSamples/foundrylocal)
- [Επόμενα Βήματα](../../../../04-PracticalSamples/foundrylocal)
- [Αντιμετώπιση Προβλημάτων](../../../../04-PracticalSamples/foundrylocal)

## Προαπαιτούμενα

Πριν ξεκινήσετε αυτόν τον οδηγό, βεβαιωθείτε ότι έχετε:

- **Java 21 ή νεότερη έκδοση** εγκατεστημένη στο σύστημά σας
- **Maven 3.6+** για τη δημιουργία του έργου
- **Foundry Local** εγκατεστημένο και σε λειτουργία

### **Εγκατάσταση του Foundry Local:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```


## Επισκόπηση Έργου

Αυτό το έργο αποτελείται από τέσσερα κύρια μέρη:

1. **Application.java** - Το κύριο σημείο εκκίνησης της εφαρμογής Spring Boot
2. **FoundryLocalService.java** - Επίπεδο υπηρεσίας που διαχειρίζεται την επικοινωνία με την AI
3. **application.properties** - Ρυθμίσεις για τη σύνδεση με το Foundry Local
4. **pom.xml** - Εξαρτήσεις Maven και ρυθμίσεις έργου

## Κατανόηση του Κώδικα

### 1. Ρύθμιση Εφαρμογής (application.properties)

**Αρχείο:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```


**Τι κάνει αυτό:**
- **base-url**: Καθορίζει πού εκτελείται το Foundry Local, συμπεριλαμβανομένου του μονοπατιού `/v1` για συμβατότητα με το OpenAI API. **Σημείωση**: Το Foundry Local εκχωρεί δυναμικά μια θύρα, οπότε ελέγξτε την πραγματική θύρα σας χρησιμοποιώντας την εντολή `foundry service status`
- **model**: Ορίζει το όνομα του μοντέλου AI που θα χρησιμοποιηθεί για τη δημιουργία κειμένου, συμπεριλαμβανομένου του αριθμού έκδοσης (π.χ., `:1`). Χρησιμοποιήστε την εντολή `foundry model list` για να δείτε τα διαθέσιμα μοντέλα με τα ακριβή τους IDs.

**Βασική έννοια:** Το Spring Boot φορτώνει αυτόματα αυτές τις ρυθμίσεις και τις καθιστά διαθέσιμες στην εφαρμογή σας χρησιμοποιώντας τον σχολιασμό `@Value`.

### 2. Κύρια Κλάση Εφαρμογής (Application.java)

**Αρχείο:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```


**Τι κάνει αυτό:**
- Ο σχολιασμός `@SpringBootApplication` ενεργοποιεί την αυτόματη ρύθμιση του Spring Boot
- Το `WebApplicationType.NONE` ενημερώνει το Spring ότι πρόκειται για εφαρμογή γραμμής εντολών και όχι για διακομιστή ιστού
- Η κύρια μέθοδος εκκινεί την εφαρμογή Spring

**Ο Εκτελεστής Επίδειξης:**
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


**Τι κάνει αυτό:**
- Ο σχολιασμός `@Bean` δημιουργεί ένα στοιχείο που διαχειρίζεται το Spring
- Το `CommandLineRunner` εκτελεί κώδικα μετά την εκκίνηση του Spring Boot
- Το `foundryLocalService` εισάγεται αυτόματα από το Spring (dependency injection)
- Στέλνει ένα δοκιμαστικό μήνυμα στην AI και εμφανίζει την απάντηση

### 3. Επίπεδο Υπηρεσίας AI (FoundryLocalService.java)

**Αρχείο:** `src/main/java/com/example/FoundryLocalService.java`

#### Εισαγωγή Ρυθμίσεων:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```


**Τι κάνει αυτό:**
- Ο σχολιασμός `@Service` ενημερώνει το Spring ότι αυτή η κλάση παρέχει επιχειρησιακή λογική
- Ο σχολιασμός `@Value` εισάγει τιμές ρυθμίσεων από το application.properties
- Η σύνταξη `:default-value` παρέχει εναλλακτικές τιμές αν δεν έχουν οριστεί οι ρυθμίσεις

#### Αρχικοποίηση Πελάτη:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```


**Τι κάνει αυτό:**
- Ο σχολιασμός `@PostConstruct` εκτελεί αυτή τη μέθοδο μετά τη δημιουργία της υπηρεσίας από το Spring
- Δημιουργεί έναν πελάτη OpenAI που συνδέεται με την τοπική σας εγκατάσταση Foundry Local
- Η βασική διεύθυνση URL από το `application.properties` περιλαμβάνει ήδη το `/v1` για συμβατότητα με το OpenAI API
- Το API key ορίζεται σε "not-needed" επειδή η τοπική ανάπτυξη δεν απαιτεί αυθεντικοποίηση

#### Μέθοδος Συνομιλίας:
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


**Τι κάνει αυτό:**
- **ChatCompletionCreateParams**: Ρυθμίζει το αίτημα προς την AI
  - `model`: Καθορίζει ποιο μοντέλο AI θα χρησιμοποιηθεί (πρέπει να ταιριάζει ακριβώς με το ID από το `foundry model list`)
  - `addUserMessage`: Προσθέτει το μήνυμά σας στη συνομιλία
  - `maxCompletionTokens`: Περιορίζει το μήκος της απάντησης (εξοικονόμηση πόρων)
  - `temperature`: Ελέγχει την τυχαιότητα (0.0 = ντετερμινιστικό, 1.0 = δημιουργικό)
- **Κλήση API**: Στέλνει το αίτημα στο Foundry Local
- **Διαχείριση Απάντησης**: Εξάγει με ασφάλεια την απάντηση της AI
- **Διαχείριση Σφαλμάτων**: Τυλίγει τις εξαιρέσεις με χρήσιμα μηνύματα σφάλματος

### 4. Εξαρτήσεις Έργου (pom.xml)

**Κύριες Εξαρτήσεις:**

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


**Τι κάνουν αυτά:**
- **spring-boot-starter**: Παρέχει βασική λειτουργικότητα του Spring Boot
- **openai-java**: Επίσημο OpenAI Java SDK για επικοινωνία με το API
- **jackson-databind**: Διαχειρίζεται τη σειριοποίηση/αποσειριοποίηση JSON για κλήσεις API

## Πώς Λειτουργούν Όλα Μαζί

Ακολουθεί η πλήρης ροή όταν εκτελείτε την εφαρμογή:

1. **Εκκίνηση**: Το Spring Boot ξεκινά και διαβάζει το `application.properties`
2. **Δημιουργία Υπηρεσίας**: Το Spring δημιουργεί το `FoundryLocalService` και εισάγει τις τιμές ρυθμίσεων
3. **Ρύθμιση Πελάτη**: Το `@PostConstruct` αρχικοποιεί τον πελάτη OpenAI για σύνδεση με το Foundry Local
4. **Εκτέλεση Επίδειξης**: Το `CommandLineRunner` εκτελείται μετά την εκκίνηση
5. **Κλήση AI**: Η επίδειξη καλεί τη μέθοδο `foundryLocalService.chat()` με ένα δοκιμαστικό μήνυμα
6. **Αίτημα API**: Η υπηρεσία δημιουργεί και στέλνει ένα αίτημα συμβατό με το OpenAI στο Foundry Local
7. **Επεξεργασία Απάντησης**: Η υπηρεσία εξάγει και επιστρέφει την απάντηση της AI
8. **Εμφάνιση**: Η εφαρμογή εκτυπώνει την απάντηση και τερματίζει

## Ρύθμιση του Foundry Local

Για να ρυθμίσετε το Foundry Local, ακολουθήστε τα παρακάτω βήματα:

1. **Εγκαταστήστε το Foundry Local** χρησιμοποιώντας τις οδηγίες στην ενότητα [Προαπαιτούμενα](../../../../04-PracticalSamples/foundrylocal).

2. **Ελέγξτε τη δυναμικά εκχωρημένη θύρα**. Το Foundry Local εκχωρεί αυτόματα μια θύρα κατά την εκκίνηση. Βρείτε τη θύρα σας με:
   ```bash
   foundry service status
   ```
   
   **Προαιρετικό**: Αν προτιμάτε να χρησιμοποιήσετε μια συγκεκριμένη θύρα (π.χ., 5273), μπορείτε να τη ρυθμίσετε χειροκίνητα:
   ```bash
   foundry service set --port 5273
   ```

3. **Κατεβάστε το μοντέλο AI** που θέλετε να χρησιμοποιήσετε, για παράδειγμα, `phi-3.5-mini`, με την παρακάτω εντολή:
   ```bash
   foundry model run phi-3.5-mini
   ```

4. **Ρυθμίστε το αρχείο application.properties** ώστε να ταιριάζει με τις ρυθμίσεις του Foundry Local:
   - Ενημερώστε τη θύρα στο `base-url` (από το βήμα 2), διασφαλίζοντας ότι περιλαμβάνει το `/v1` στο τέλος
   - Ενημερώστε το όνομα του μοντέλου ώστε να περιλαμβάνει τον αριθμό έκδοσης (ελέγξτε με `foundry model list`)
   
   Παράδειγμα:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```


## Εκτέλεση της Εφαρμογής

### Βήμα 1: Εκκινήστε το Foundry Local
```bash
foundry model run phi-3.5-mini
```

### Βήμα 2: Δημιουργήστε και Εκτελέστε την Εφαρμογή
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```


## Αναμενόμενο Αποτέλεσμα

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


## Επόμενα Βήματα

Για περισσότερα παραδείγματα, δείτε το [Κεφάλαιο 04: Πρακτικά παραδείγματα](../README.md)

## Αντιμετώπιση Προβλημάτων

### Συνηθισμένα Προβλήματα

**"Connection refused" ή "Service unavailable"**
- Βεβαιωθείτε ότι το Foundry Local εκτελείται: `foundry model list`
- Ελέγξτε την πραγματική θύρα που χρησιμοποιεί το Foundry Local: `foundry service status`
- Ενημερώστε το `application.properties` με τη σωστή θύρα, διασφαλίζοντας ότι η διεύθυνση URL τελειώνει με `/v1`
- Εναλλακτικά, ορίστε μια συγκεκριμένη θύρα αν το επιθυμείτε: `foundry service set --port 5273`
- Δοκιμάστε να επανεκκινήσετε το Foundry Local: `foundry model run phi-3.5-mini`

**"Model not found" ή "404 Not Found" σφάλματα**
- Ελέγξτε τα διαθέσιμα μοντέλα με τα ακριβή τους IDs: `foundry model list`
- Ενημερώστε το όνομα του μοντέλου στο `application.properties` ώστε να ταιριάζει ακριβώς, συμπεριλαμβανομένου του αριθμού έκδοσης (π.χ., `Phi-3.5-mini-instruct-cuda-gpu:1`)
- Διασφαλίστε ότι το `base-url` περιλαμβάνει το `/v1` στο τέλος: `http://localhost:5273/v1`
- Κατεβάστε το μοντέλο αν χρειάζεται: `foundry model run phi-3.5-mini`

**"400 Bad Request" σφάλματα**
- Επαληθεύστε ότι η βασική διεύθυνση URL περιλαμβάνει το `/v1`: `http://localhost:5273/v1`
- Ελέγξτε ότι το ID του μοντέλου ταιριάζει ακριβώς με αυτό που εμφανίζεται στο `foundry model list`
- Διασφαλίστε ότι χρησιμοποιείτε το `maxCompletionTokens()` στον κώδικά σας (όχι το παρωχημένο `maxTokens()`)

**Σφάλματα κατά τη μεταγλώττιση με Maven**
- Βεβαιωθείτε ότι χρησιμοποιείτε Java 21 ή νεότερη: `java -version`
- Καθαρίστε και επαναδημιουργήστε: `mvn clean compile`
- Ελέγξτε τη σύνδεση στο διαδίκτυο για λήψη εξαρτήσεων

**Η εφαρμογή ξεκινά αλλά δεν εμφανίζει αποτέλεσμα**
- Επαληθεύστε ότι το Foundry Local ανταποκρίνεται: Ανοίξτε τον περιηγητή στη διεύθυνση `http://localhost:5273`
- Ελέγξτε τα logs της εφαρμογής για συγκεκριμένα μηνύματα σφάλματος
- Διασφαλίστε ότι το μοντέλο έχει φορτωθεί πλήρως και είναι έτοιμο

---

**Αποποίηση ευθύνης**:  
Αυτό το έγγραφο έχει μεταφραστεί χρησιμοποιώντας την υπηρεσία αυτόματης μετάφρασης [Co-op Translator](https://github.com/Azure/co-op-translator). Παρόλο που καταβάλλουμε προσπάθειες για ακρίβεια, παρακαλούμε να έχετε υπόψη ότι οι αυτόματες μεταφράσεις ενδέχεται να περιέχουν λάθη ή ανακρίβειες. Το πρωτότυπο έγγραφο στη μητρική του γλώσσα θα πρέπει να θεωρείται η αυθεντική πηγή. Για κρίσιμες πληροφορίες, συνιστάται επαγγελματική ανθρώπινη μετάφραση. Δεν φέρουμε ευθύνη για τυχόν παρεξηγήσεις ή εσφαλμένες ερμηνείες που προκύπτουν από τη χρήση αυτής της μετάφρασης.