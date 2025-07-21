<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T19:46:24+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "el"
}
-->
# Τοπική Εφαρμογή Γραμμής Εντολών Foundry

>**Σημείωση**: Αυτό το κεφάλαιο περιλαμβάνει ένα [**Tutorial**](./TUTORIAL.md) που σας καθοδηγεί στη χρήση των ολοκληρωμένων παραδειγμάτων.

Μια απλή εφαρμογή γραμμής εντολών Spring Boot που δείχνει πώς να συνδεθείτε στο Foundry Local χρησιμοποιώντας το OpenAI Java SDK.

## Τι Θα Μάθετε

- Πώς να ενσωματώσετε το Foundry Local σε εφαρμογές Spring Boot χρησιμοποιώντας το OpenAI Java SDK
- Βέλτιστες πρακτικές για τοπική ανάπτυξη και δοκιμή AI

## Πίνακας Περιεχομένων

- [Τι Θα Μάθετε](../../../../04-PracticalSamples/foundrylocal)
- [Προαπαιτούμενα](../../../../04-PracticalSamples/foundrylocal)
  - [Εγκατάσταση του Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [Επαλήθευση](../../../../04-PracticalSamples/foundrylocal)
- [Ρύθμιση](../../../../04-PracticalSamples/foundrylocal)
- [Γρήγορη Εκκίνηση](../../../../04-PracticalSamples/foundrylocal)
- [Τι Κάνει η Εφαρμογή](../../../../04-PracticalSamples/foundrylocal)
- [Παραδείγματα Εξόδου](../../../../04-PracticalSamples/foundrylocal)
- [Αρχιτεκτονική](../../../../04-PracticalSamples/foundrylocal)
- [Κύρια Σημεία Κώδικα](../../../../04-PracticalSamples/foundrylocal)
  - [Ενσωμάτωση OpenAI Java SDK](../../../../04-PracticalSamples/foundrylocal)
  - [Chat Completion API](../../../../04-PracticalSamples/foundrylocal)
- [Αντιμετώπιση Προβλημάτων](../../../../04-PracticalSamples/foundrylocal)

## Προαπαιτούμενα

> **⚠️ Σημείωση**: Αυτή η εφαρμογή **δεν εκτελείται στο παρεχόμενο devcontainer**, καθώς απαιτεί το Foundry Local να είναι εγκατεστημένο και να εκτελείται στο σύστημα υποδοχής.

### Εγκατάσταση του Foundry Local

Πριν εκτελέσετε αυτήν την εφαρμογή, πρέπει να εγκαταστήσετε και να ξεκινήσετε το Foundry Local. Ακολουθήστε τα παρακάτω βήματα:

1. **Βεβαιωθείτε ότι το σύστημά σας πληροί τις απαιτήσεις**:
   - **Λειτουργικό Σύστημα**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025 ή macOS
   - **Υλικό**: 
     - Ελάχιστο: 8GB RAM, 3GB ελεύθερος χώρος στο δίσκο
     - Συνιστώμενο: 16GB RAM, 15GB ελεύθερος χώρος στο δίσκο
   - **Δίκτυο**: Σύνδεση στο διαδίκτυο για την αρχική λήψη του μοντέλου (προαιρετικό για offline χρήση)
   - **Επιτάχυνση (προαιρετικό)**: NVIDIA GPU (σειρά 2,000 ή νεότερη), AMD GPU (σειρά 6,000 ή νεότερη), Qualcomm Snapdragon X Elite (8GB ή περισσότερη μνήμη) ή Apple silicon
   - **Δικαιώματα**: Διοικητικά δικαιώματα για την εγκατάσταση λογισμικού στη συσκευή σας

2. **Εγκαταστήστε το Foundry Local**:
   
   **Για Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **Για macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Εναλλακτικά, μπορείτε να κατεβάσετε τον εγκαταστάτη από το [Foundry Local GitHub repository](https://github.com/microsoft/Foundry-Local).

3. **Ξεκινήστε το πρώτο σας μοντέλο**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   Το μοντέλο κατεβαίνει (αυτό μπορεί να διαρκέσει λίγα λεπτά, ανάλογα με την ταχύτητα του διαδικτύου σας) και στη συνέχεια εκτελείται. Το Foundry Local επιλέγει αυτόματα την καλύτερη παραλλαγή μοντέλου για το σύστημά σας (CUDA για NVIDIA GPUs, CPU έκδοση διαφορετικά).

4. **Δοκιμάστε το μοντέλο** κάνοντας μια ερώτηση στο ίδιο τερματικό:

   ```bash
   Why is the sky blue?
   ```

   Θα πρέπει να δείτε μια απάντηση από το μοντέλο Phi που εξηγεί γιατί ο ουρανός φαίνεται μπλε.

### Επαλήθευση

Μπορείτε να επαληθεύσετε ότι όλα λειτουργούν σωστά με αυτές τις εντολές:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

Μπορείτε επίσης να επισκεφθείτε τη διεύθυνση `http://localhost:5273` στον περιηγητή σας για να δείτε τη διεπαφή ιστού του Foundry Local.

## Ρύθμιση

Η εφαρμογή μπορεί να ρυθμιστεί μέσω του `application.properties`:

- `foundry.local.base-url` - Βασική διεύθυνση URL για το Foundry Local (προεπιλογή: http://localhost:5273)
- `foundry.local.model` - Μοντέλο AI που θα χρησιμοποιηθεί (προεπιλογή: Phi-3.5-mini-instruct-cuda-gpu)

> **Σημείωση**: Το όνομα του μοντέλου στη ρύθμιση πρέπει να ταιριάζει με την συγκεκριμένη παραλλαγή που κατέβασε το Foundry Local για το σύστημά σας. Όταν εκτελείτε `foundry model run phi-3.5-mini`, το Foundry Local επιλέγει και κατεβάζει αυτόματα την καλύτερη παραλλαγή (CUDA για NVIDIA GPUs, CPU έκδοση διαφορετικά). Χρησιμοποιήστε `foundry model list` για να δείτε το ακριβές όνομα του μοντέλου που είναι διαθέσιμο στην τοπική σας εγκατάσταση.

## Γρήγορη Εκκίνηση

### 1. Μεταβείτε στον κατάλογο της εφαρμογής foundry local
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Εκτελέστε την Εφαρμογή

```bash
mvn spring-boot:run
```

Ή δημιουργήστε και εκτελέστε το JAR:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Εξαρτήσεις

Αυτή η εφαρμογή χρησιμοποιεί το OpenAI Java SDK για να επικοινωνεί με το Foundry Local. Η βασική εξάρτηση είναι:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

Η εφαρμογή είναι προρυθμισμένη για σύνδεση με το Foundry Local που εκτελείται στην προεπιλεγμένη θύρα.

## Τι Κάνει η Εφαρμογή

Όταν εκτελείτε την εφαρμογή:

1. **Ξεκινά** ως εφαρμογή γραμμής εντολών (χωρίς web server)
2. **Στέλνει αυτόματα** ένα δοκιμαστικό μήνυμα: "Γεια! Μπορείς να μου πεις τι είσαι και ποιο μοντέλο εκτελείς;"
3. **Εμφανίζει την απάντηση** από το Foundry Local στην κονσόλα
4. **Τερματίζει καθαρά** μετά την επίδειξη

## Παραδείγματα Εξόδου

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Αρχιτεκτονική

- **Application.java** - Κύρια εφαρμογή Spring Boot με CommandLineRunner
- **FoundryLocalService.java** - Υπηρεσία που χρησιμοποιεί το OpenAI Java SDK για επικοινωνία με το Foundry Local
- Χρησιμοποιεί **OpenAI Java SDK** για κλήσεις API με ασφάλεια τύπων
- Αυτόματη σειριοποίηση/αποσειριοποίηση JSON που διαχειρίζεται το SDK
- Καθαρή ρύθμιση μέσω των annotations `@Value` και `@PostConstruct` του Spring

## Κύρια Σημεία Κώδικα

### Ενσωμάτωση OpenAI Java SDK

Η εφαρμογή χρησιμοποιεί το OpenAI Java SDK για να δημιουργήσει έναν πελάτη ρυθμισμένο για το Foundry Local:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### Chat Completion API

Η δημιουργία αιτημάτων για ολοκλήρωση συνομιλίας είναι απλή και ασφαλής ως προς τους τύπους:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Αντιμετώπιση Προβλημάτων

Αν δείτε σφάλματα σύνδεσης:
1. Επαληθεύστε ότι το Foundry Local εκτελείται στη διεύθυνση `http://localhost:5273`
2. Ελέγξτε ότι μια παραλλαγή του μοντέλου Phi-3.5-mini είναι διαθέσιμη με `foundry model list`
3. Βεβαιωθείτε ότι το όνομα του μοντέλου στο `application.properties` ταιριάζει με το ακριβές όνομα του μοντέλου που εμφανίζεται στη λίστα
4. Βεβαιωθείτε ότι δεν υπάρχει firewall που να μπλοκάρει τη σύνδεση

Συνηθισμένα προβλήματα:
- **Το μοντέλο δεν βρέθηκε**: Εκτελέστε `foundry model run phi-3.5-mini` για να κατεβάσετε και να ξεκινήσετε το μοντέλο
- **Η υπηρεσία δεν εκτελείται**: Η υπηρεσία Foundry Local μπορεί να έχει σταματήσει. Επανεκκινήστε την με την εντολή εκτέλεσης του μοντέλου
- **Λάθος όνομα μοντέλου**: Χρησιμοποιήστε `foundry model list` για να δείτε τα διαθέσιμα μοντέλα και ενημερώστε τη ρύθμισή σας αναλόγως

**Αποποίηση ευθύνης**:  
Αυτό το έγγραφο έχει μεταφραστεί χρησιμοποιώντας την υπηρεσία αυτόματης μετάφρασης [Co-op Translator](https://github.com/Azure/co-op-translator). Παρόλο που καταβάλλουμε προσπάθειες για ακρίβεια, παρακαλούμε να έχετε υπόψη ότι οι αυτοματοποιημένες μεταφράσεις ενδέχεται να περιέχουν λάθη ή ανακρίβειες. Το πρωτότυπο έγγραφο στη μητρική του γλώσσα θα πρέπει να θεωρείται η αυθεντική πηγή. Για κρίσιμες πληροφορίες, συνιστάται επαγγελματική ανθρώπινη μετάφραση. Δεν φέρουμε ευθύνη για τυχόν παρεξηγήσεις ή εσφαλμένες ερμηνείες που προκύπτουν από τη χρήση αυτής της μετάφρασης.