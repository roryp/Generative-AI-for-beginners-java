# Βιβλιοθήκη Foundry Local Spring Boot Tutorial

## Πίνακας Περιεχομένων

- [Προαπαιτούμενα](#προαπαιτούμενα)
- [Επισκόπηση Έργου](#επισκόπηση-έργου)
- [Κατανόηση του Κώδικα](#κατανόηση-του-κώδικα)
  - [1. Διαμόρφωση Εφαρμογής (application.properties)](#1-διαμόρφωση-εφαρμογής-applicationproperties)
  - [2. Κύρια Κλάση Εφαρμογής (Application.java)](#2-κύρια-κλάση-εφαρμογής-applicationjava)
  - [3. Επίπεδο Υπηρεσίας Τεχνητής Νοημοσύνης (FoundryLocalService.java)](#3-επίπεδο-υπηρεσίας-τεχνητής-νοημοσύνης-foundrylocalservicejava)
  - [4. Εξαρτήσεις Έργου (pom.xml)](#4-εξαρτήσεις-έργου-pomxml)
- [Πως Λειτουργεί Όλα Μαζί](#πως-λειτουργεί-όλα-μαζί)
- [Ρύθμιση του Foundry Local](#ρύθμιση-του-foundry-local)
- [Εκτέλεση της Εφαρμογής](#εκτέλεση-της-εφαρμογής)
- [Αναμενόμενη Έξοδος](#αναμενόμενη-έξοδος)
- [Επόμενα Βήματα](#επόμενα-βήματα)
- [Επίλυση Προβλημάτων](#επίλυση-προβλημάτων)


## Προαπαιτούμενα

Πριν ξεκινήσετε αυτό το tutorial, βεβαιωθείτε ότι έχετε:

- **Εγκατεστημένο το Java 21 ή ανώτερο** στο σύστημά σας
- **Maven 3.6+** για τη δημιουργία του έργου
- **Installed and running Foundry Local**

### **Εγκατάσταση Foundry Local:**

> **Σημείωση:** Το Foundry Local CLI είναι διαθέσιμο μόνο σε **Windows** και **macOS**. Το Linux υποστηρίζεται μέσω των [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Επαληθεύστε την εγκατάσταση:
```bash
foundry --version
```

## Επισκόπηση Έργου

Αυτό το έργο αποτελείται από τέσσερα βασικά μέρη:

1. **Application.java** – Το κύριο σημείο εισόδου της εφαρμογής Spring Boot
2. **FoundryLocalService.java** – Επίπεδο υπηρεσίας που χειρίζεται την επικοινωνία με την Τεχνητή Νοημοσύνη
3. **application.properties** – Διαμόρφωση σύνδεσης για το Foundry Local
4. **pom.xml** – Εξαρτήσεις Maven και διαμόρφωση έργου

## Κατανόηση του Κώδικα

### 1. Διαμόρφωση Εφαρμογής (application.properties)

**Αρχείο:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Τι κάνει:**
- **base-url**: Καθορίζει που τρέχει το Foundry Local, συμπεριλαμβανομένης της διαδρομής `/v1` για συμβατότητα με το OpenAI API. Η προεπιλεγμένη θύρα είναι η `5273`. Εάν η θύρα διαφέρει, ελέγξτε με `foundry service status`.
- **model** (προαιρετικό): Ορίζει το μοντέλο AI που θα χρησιμοποιηθεί για τη δημιουργία κειμένων. **Από προεπιλογή, η εφαρμογή ανιχνεύει αυτόματα το μοντέλο** ερωτώντας το Foundry Local στο τέλος της διαδρομής `/v1/models` κατά την εκκίνηση, έτσι δεν χρειάζεται να το ορίσετε χειροκίνητα. Μπορείτε ωστόσο να το ορίσετε ρητά αν θέλετε να υπερισχύσετε της αυτόματης ανίχνευσης.

**Κύρια ιδέα:** Το Spring Boot φορτώνει αυτόματα αυτές τις ιδιότητες και τις καθιστά διαθέσιμες στην εφαρμογή σας μέσω της σημείωσης `@Value`.

### 2. Κύρια Κλάση Εφαρμογής (Application.java)

**Αρχείο:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Δεν απαιτείται διακομιστής ιστού
        app.run(args);
    }
```

**Τι κάνει:**
- `@SpringBootApplication` ενεργοποιεί την αυτόματη διαμόρφωση Spring Boot
- `WebApplicationType.NONE` δηλώνει στο Spring ότι πρόκειται για εφαρμογή γραμμής εντολών, όχι διακομιστή web
- Η κύρια μέθοδος ξεκινά την εφαρμογή Spring

**Ο Demo Runner:**
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

**Τι κάνει:**
- `@Bean` δημιουργεί ένα συστατικό που διαχειρίζεται το Spring
- `CommandLineRunner` εκτελεί κώδικα μετά την εκκίνηση του Spring Boot
- `foundryLocalService` εισάγεται αυτόματα από το Spring (dependency injection)
- Στέλνει ένα δοκιμαστικό μήνυμα στην AI και εμφανίζει την απάντηση

### 3. Επίπεδο Υπηρεσίας Τεχνητής Νοημοσύνης (FoundryLocalService.java)

**Αρχείο:** `src/main/java/com/example/FoundryLocalService.java`

#### Έγχυση Διαμόρφωσης:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Αυτόματη ανίχνευση αν είναι κενό
```

**Τι κάνει:**
- `@Service` λέει στο Spring ότι αυτή η κλάση παρέχει επιχειρησιακή λογική
- `@Value` εγχέει τιμές διαμόρφωσης από το application.properties
- Το μοντέλο έχει προεπιλεγμένη τιμή κενή, που ενεργοποιεί την **αυτόματη ανίχνευση** από το Foundry Local κατά την εκκίνηση. Αυτό σημαίνει ότι η εφαρμογή δουλεύει με οποιοδήποτε μοντέλο φορτωθεί στο Foundry Local χωρίς χειροκίνητη ρύθμιση.

#### Αρχικοποίηση Πελάτη:
```java
@PostConstruct
public void init() {
    // Αυτόματη ανίχνευση του μοντέλου από το Foundry Local αν δεν έχει ρυθμιστεί ρητά
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Η βασική διεύθυνση URL ήδη περιλαμβάνει /v1 από τη διαμόρφωση
            .apiKey("not-needed")            // Ο τοπικός διακομιστής δεν χρειάζεται πραγματικό κλειδί API
            .build();
}
```

**Τι κάνει:**
- `@PostConstruct` εκτελεί αυτή τη μέθοδο μετά τη δημιουργία της υπηρεσίας από το Spring
- Αν δεν έχει επιλεγεί μοντέλο, ερωτά το endpoint `/v1/models` του Foundry Local και επιλέγει το πρώτο διαθέσιμο μοντέλο
- Δημιουργεί έναν πελάτη OpenAI που δείχνει στην τοπική σας εγκατάσταση Foundry Local
- Η βασική διεύθυνση URL στο `application.properties` περιλαμβάνει ήδη το `/v1` για συμβατότητα με OpenAI API
- Το κλειδί API τέθηκε σε "not-needed" καθώς η τοπική ανάπτυξη δεν απαιτεί αυθεντικοποίηση

#### Μέθοδος Chat:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Ποιο μοντέλο AI να χρησιμοποιηθεί
                .addUserMessage(message)         // Η ερώτησή σας/εντολή σας
                .maxCompletionTokens(150)        // Όριο στο μήκος της απάντησης
                .temperature(0.7)                // Έλεγχος δημιουργικότητας (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Εξαγωγή της απάντησης του AI από το αποτέλεσμα του API
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**Τι κάνει:**
- **ChatCompletionCreateParams**: Διαμορφώνει το αίτημα προς την AI
  - `model`: Καθορίζει ποιο μοντέλο AI θα χρησιμοποιηθεί (πρέπει να ταιριάζει ακριβώς με το ID από το `foundry model list`)
  - `addUserMessage`: Προσθέτει το μήνυμά σας στη συζήτηση
  - `maxCompletionTokens`: Περιορίζει το μέγιστο μέγεθος της απάντησης (εξοικονομά πόρους)
  - `temperature`: Ελέγχει το βαθμό τυχαιότητας (0.0 = αποφασιστικό, 1.0 = πιο δημιουργικό)
- **Κλήση API**: Στέλνει το αίτημα στο Foundry Local
- **Διαχείριση Απάντησης**: Εξάγει με ασφάλεια το κείμενο της απάντησης της AI
- **Διαχείριση Σφαλμάτων**: Τυλίγει τις εξαιρέσεις με κατατοπιστικά μηνύματα λάθους

### 4. Εξαρτήσεις Έργου (pom.xml)

**Βασικές Εξαρτήσεις:**

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

**Τι κάνουν:**
- **spring-boot-starter**: Παρέχει βασική λειτουργικότητα Spring Boot
- **openai-java**: Επίσημο OpenAI Java SDK για επικοινωνία μέσω API
- **jackson-databind**: Χειρίζεται την σειριοποίηση/αποσειριοποίηση JSON για τις κλήσεις API

## Πως Λειτουργεί Όλα Μαζί

Ακολουθεί η πλήρης ροή όταν τρέχετε την εφαρμογή:

1. **Εκκίνηση**: Το Spring Boot ξεκινά και διαβάζει το `application.properties`
2. **Δημιουργία Υπηρεσίας**: Το Spring δημιουργεί το `FoundryLocalService` και εγχέει τις διαμορφώσεις
3. **Ανίχνευση Μοντέλου**: Αν δεν έχει οριστεί μοντέλο, η υπηρεσία ερωτά το `/v1/models` του Foundry Local και επιλέγει αυτόματα το πρώτο διαθέσιμο μοντέλο
4. **Ρύθμιση Πελάτη**: Το `@PostConstruct` αρχικοποιεί τον OpenAI πελάτη για σύνδεση με το Foundry Local
5. **Εκτέλεση Demo**: Ο `CommandLineRunner` εκτελείται μετά την εκκίνηση
6. **Κλήση AI**: Το demo καλεί το `foundryLocalService.chat()` με ένα δοκιμαστικό μήνυμα
7. **API Αίτημα**: Η υπηρεσία δημιουργεί και στέλνει αίτημα συμβατό με OpenAI στο Foundry Local
8. **Επεξεργασία Απάντησης**: Η υπηρεσία εξάγει και επιστρέφει την απάντηση της AI
9. **Εμφάνιση**: Η εφαρμογή εμφανίζει την απάντηση και τερματίζει

## Ρύθμιση του Foundry Local

1. **Εγκαταστήστε το Foundry Local** χρησιμοποιώντας τις οδηγίες στην ενότητα [Προαπαιτούμενα](#προαπαιτούμενα).

2. **Ξεκινήστε την υπηρεσία** (αν δεν τρέχει ήδη):
   ```bash
   foundry service start
   ```

3. **Ελέγξτε την κατάσταση της υπηρεσίας** για να επιβεβαιώσετε ότι τρέχει και δείτε τη θύρα:
   ```bash
   foundry service status
   ```

4. **Κατεβάστε και εκτελέστε ένα μοντέλο** (κατεβαίνει την πρώτη φορά, στη συνέχεια αποθηκεύεται για μελλοντική χρήση):
   ```bash
   foundry model run phi-4-mini
   ```
   Αυτό ανοίγει μια διαδραστική συνεδρία chat. Μπορείτε να εξέλθετε με `Ctrl+C`. Το μοντέλο παραμένει φορτωμένο στην υπηρεσία.

   > **Συμβουλή:** Εκτελέστε `foundry model list` για να δείτε όλα τα διαθέσιμα μοντέλα. Αντικαταστήστε το `phi-4-mini` με οποιοδήποτε ψευδώνυμο από τον κατάλογο (π.χ., `qwen2.5-0.5b` για μικρότερο/γρηγορότερο μοντέλο).

5. **Επαληθεύστε ότι το μοντέλο έχει φορτωθεί:**
   ```bash
   foundry service ps
   ```

6. **Ενημερώστε το `application.properties` αν χρειάζεται:**
   - Η προεπιλεγμένη τιμή του `base-url` (`http://localhost:5273/v1`) ταιριάζει με την προεπιλεγμένη θύρα CLI. Ενημερώστε μόνο αν το `foundry service status` εμφανίζει διαφορετική θύρα.
   - Το μοντέλο ανιχνεύεται **αυτόματα** κατά την εκκίνηση — δεν απαιτείται επιπλέον ρύθμιση.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Εκτέλεση της Εφαρμογής

### Βήμα 1: Βεβαιωθείτε ότι ένα μοντέλο είναι φορτωμένο στο Foundry Local
```bash
foundry service ps
```
Αν δεν υπάρχουν μοντέλα, φορτώστε ένα:
```bash
foundry model run phi-4-mini
```

### Βήμα 2: Δημιουργία και Εκτέλεση της Εφαρμογής
Σε ξεχωριστό τερματικό:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Ή χτίστε και εκτελέστε ως JAR:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Αναμενόμενη Έξοδος

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

## Επόμενα Βήματα

Για περισσότερα παραδείγματα, δείτε [Κεφάλαιο 04: Πρακτικά δείγματα](../README.md)

## Επίλυση Προβλημάτων

### Συνήθη Προβλήματα

**"Connection refused" ή "Service unavailable"**
- Ελέγξτε την υπηρεσία: `foundry service status`
- Επανεκκινήστε αν χρειάζεται: `foundry service restart`
- Βεβαιωθείτε ότι η θύρα στο `application.properties` ταιριάζει με την έξοδο του `foundry service status`
- Εξασφαλίστε ότι η διεύθυνση URL τελειώνει σε `/v1`: `http://localhost:5273/v1`

**"No model found" κατά την εκκίνηση**
- Η εφαρμογή ανιχνεύει αυτόματα το μοντέλο. Βεβαιωθείτε ότι το λιγότερο ένα μοντέλο είναι φορτωμένο: `foundry service ps`
- Αν δεν υπάρχει κανένα μοντέλο: `foundry model run phi-4-mini`
- Αν έχετε ορίσει το μοντέλο χειροκίνητα στο `application.properties`, βεβαιωθείτε ότι ταιριάζει με το αποτέλεσμα του `foundry model list`

**Σφάλματα "400 Bad Request"**
- Βεβαιωθείτε ότι το base URL περιλαμβάνει το `/v1`: `http://localhost:5273/v1`
- Βεβαιωθείτε ότι χρησιμοποιείτε `maxCompletionTokens()` στον κώδικα και όχι το παρωχημένο `maxTokens()`

**Σφάλματα μεταγλώττισης Maven**
- Βεβαιωθείτε για το Java 21 ή νεότερο: `java -version`
- Καθαρίστε και κατασκευάστε ξανά: `mvn clean compile`
- Ελέγξτε τη σύνδεσή σας στο Internet για τη λήψη εξαρτήσεων

**Προβλήματα σύνδεσης με την υπηρεσία**
- Αν δείτε `Request to local service failed`, τρέξτε: `foundry service restart`
- Ελέγξτε τα φορτωμένα μοντέλα: `foundry service ps`
- Δείτε τα logs της υπηρεσίας: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Αποποίηση ευθυνών**:  
Το παρόν έγγραφο έχει μεταφραστεί χρησιμοποιώντας την υπηρεσία αυτόματης μετάφρασης AI [Co-op Translator](https://github.com/Azure/co-op-translator). Ενώ προσπαθούμε για ακρίβεια, παρακαλούμε να λάβετε υπόψη ότι οι αυτοματοποιημένες μεταφράσεις ενδέχεται να περιέχουν λάθη ή ανακρίβειες. Το πρωτότυπο έγγραφο στη γλώσσα του θεωρείται η αυθεντική πηγή. Για κρίσιμες πληροφορίες, η επαγγελματική ανθρώπινη μετάφραση συνιστάται. Δεν φέρουμε ευθύνη για οποιεσδήποτε παρανοήσεις ή λανθασμένες ερμηνείες που προκύπτουν από τη χρήση αυτής της μετάφρασης.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->