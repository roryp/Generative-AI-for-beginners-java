<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0b563ac59362fb83f0f49dcfc442dd97",
  "translation_date": "2025-07-21T19:26:15+00:00",
  "source_file": "02-SetupDevEnvironment/README.md",
  "language_code": "el"
}
-->
# Ρύθμιση Περιβάλλοντος Ανάπτυξης για Γενετική Τεχνητή Νοημοσύνη με Java

> **Γρήγορη Εκκίνηση**: Κώδικας στο Cloud σε 2 λεπτά - Μεταβείτε στη [Ρύθμιση GitHub Codespaces](../../../02-SetupDevEnvironment) - δεν απαιτείται τοπική εγκατάσταση και χρησιμοποιεί μοντέλα του GitHub!

> **Ενδιαφέρεστε για Azure OpenAI;**, δείτε τον [Οδηγό Ρύθμισης Azure OpenAI](getting-started-azure-openai.md) με βήματα για τη δημιουργία νέου πόρου Azure OpenAI.

## Τι θα Μάθετε

- Ρύθμιση περιβάλλοντος ανάπτυξης Java για εφαρμογές AI
- Επιλογή και διαμόρφωση του προτιμώμενου περιβάλλοντος ανάπτυξης (cloud-first με Codespaces, τοπικό dev container ή πλήρης τοπική εγκατάσταση)
- Δοκιμή της ρύθμισης συνδέοντας τα μοντέλα του GitHub

## Πίνακας Περιεχομένων

- [Τι θα Μάθετε](../../../02-SetupDevEnvironment)
- [Εισαγωγή](../../../02-SetupDevEnvironment)
- [Βήμα 1: Ρύθμιση του Περιβάλλοντος Ανάπτυξης](../../../02-SetupDevEnvironment)
  - [Επιλογή Α: GitHub Codespaces (Συνιστάται)](../../../02-SetupDevEnvironment)
  - [Επιλογή Β: Τοπικό Dev Container](../../../02-SetupDevEnvironment)
  - [Επιλογή Γ: Χρήση Υπάρχουσας Τοπικής Εγκατάστασης](../../../02-SetupDevEnvironment)
- [Βήμα 2: Δημιουργία Προσωπικού Token Πρόσβασης στο GitHub](../../../02-SetupDevEnvironment)
- [Βήμα 3: Δοκιμή της Ρύθμισης](../../../02-SetupDevEnvironment)
- [Αντιμετώπιση Προβλημάτων](../../../02-SetupDevEnvironment)
- [Περίληψη](../../../02-SetupDevEnvironment)
- [Επόμενα Βήματα](../../../02-SetupDevEnvironment)

## Εισαγωγή

Αυτό το κεφάλαιο θα σας καθοδηγήσει στη ρύθμιση ενός περιβάλλοντος ανάπτυξης. Θα χρησιμοποιήσουμε τα **GitHub Models** ως το κύριο παράδειγμα, επειδή είναι δωρεάν, εύκολο στη ρύθμιση με έναν λογαριασμό GitHub, δεν απαιτεί πιστωτική κάρτα και παρέχει πρόσβαση σε πολλαπλά μοντέλα για πειραματισμό.

**Δεν απαιτείται τοπική εγκατάσταση!** Μπορείτε να ξεκινήσετε την ανάπτυξη άμεσα χρησιμοποιώντας το GitHub Codespaces, το οποίο παρέχει ένα πλήρες περιβάλλον ανάπτυξης στον browser σας.

<img src="./images/models.webp" alt="Screenshot: GitHub Models" width="50%">

Συνιστούμε τη χρήση των [**GitHub Models**](https://github.com/marketplace?type=models) για αυτό το μάθημα επειδή είναι:
- **Δωρεάν** για να ξεκινήσετε
- **Εύκολο** στη ρύθμιση με έναν λογαριασμό GitHub
- **Χωρίς πιστωτική κάρτα** 
- **Πολλαπλά μοντέλα** διαθέσιμα για πειραματισμό

> **Σημείωση**: Τα GitHub Models που χρησιμοποιούνται σε αυτή την εκπαίδευση έχουν τα εξής δωρεάν όρια:
> - 15 αιτήματα ανά λεπτό (150 ανά ημέρα)
> - ~8,000 λέξεις εισόδου, ~4,000 λέξεις εξόδου ανά αίτημα
> - 5 ταυτόχρονα αιτήματα
> 
> Για παραγωγική χρήση, αναβαθμίστε στα Azure AI Foundry Models με τον λογαριασμό σας στο Azure. Ο κώδικάς σας δεν χρειάζεται να αλλάξει. Δείτε την [τεκμηρίωση Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/foundry-models/how-to/quickstart-github-models).

## Βήμα 1: Ρύθμιση του Περιβάλλοντος Ανάπτυξης

<a name="quick-start-cloud"></a>

Έχουμε δημιουργήσει ένα προδιαμορφωμένο dev container για να ελαχιστοποιήσουμε τον χρόνο ρύθμισης και να διασφαλίσουμε ότι έχετε όλα τα απαραίτητα εργαλεία για αυτό το μάθημα Γενετικής Τεχνητής Νοημοσύνης με Java. Επιλέξτε την προτιμώμενη προσέγγιση ανάπτυξης:

### Επιλογές Ρύθμισης Περιβάλλοντος:

#### Επιλογή Α: GitHub Codespaces (Συνιστάται)

**Ξεκινήστε την ανάπτυξη σε 2 λεπτά - δεν απαιτείται τοπική εγκατάσταση!**

1. Κάντε fork αυτό το repository στον λογαριασμό σας στο GitHub
   > **Σημείωση**: Αν θέλετε να επεξεργαστείτε τη βασική διαμόρφωση, δείτε τη [Διαμόρφωση Dev Container](../../../.devcontainer/devcontainer.json)
2. Κάντε κλικ στο **Code** → καρτέλα **Codespaces** → **...** → **New with options...**
3. Χρησιμοποιήστε τις προεπιλογές – αυτό θα επιλέξει τη **Διαμόρφωση Dev container**: **Generative AI Java Development Environment** προσαρμοσμένο devcontainer που δημιουργήθηκε για αυτό το μάθημα
4. Κάντε κλικ στο **Create codespace**
5. Περιμένετε ~2 λεπτά για να είναι έτοιμο το περιβάλλον
6. Προχωρήστε στο [Βήμα 2: Δημιουργία Token GitHub](../../../02-SetupDevEnvironment)

<img src="./images/codespaces.png" alt="Screenshot: Codespaces submenu" width="50%">

<img src="./images/image.png" alt="Screenshot: New with options" width="50%">

<img src="./images/codespaces-create.png" alt="Screenshot: Create codespace options" width="50%">


> **Πλεονεκτήματα των Codespaces**:
> - Δεν απαιτείται τοπική εγκατάσταση
> - Λειτουργεί σε οποιαδήποτε συσκευή με browser
> - Προδιαμορφωμένο με όλα τα εργαλεία και τις εξαρτήσεις
> - Δωρεάν 60 ώρες τον μήνα για προσωπικούς λογαριασμούς
> - Συνεπές περιβάλλον για όλους τους εκπαιδευόμενους

#### Επιλογή Β: Τοπικό Dev Container

**Για προγραμματιστές που προτιμούν την τοπική ανάπτυξη με Docker**

1. Κάντε fork και clone αυτό το repository στον τοπικό σας υπολογιστή
   > **Σημείωση**: Αν θέλετε να επεξεργαστείτε τη βασική διαμόρφωση, δείτε τη [Διαμόρφωση Dev Container](../../../.devcontainer/devcontainer.json)
2. Εγκαταστήστε το [Docker Desktop](https://www.docker.com/products/docker-desktop/) και το [VS Code](https://code.visualstudio.com/)
3. Εγκαταστήστε την επέκταση [Dev Containers](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) στο VS Code
4. Ανοίξτε τον φάκελο του repository στο VS Code
5. Όταν σας ζητηθεί, κάντε κλικ στο **Reopen in Container** (ή χρησιμοποιήστε `Ctrl+Shift+P` → "Dev Containers: Reopen in Container")
6. Περιμένετε να δημιουργηθεί και να ξεκινήσει το container
7. Προχωρήστε στο [Βήμα 2: Δημιουργία Token GitHub](../../../02-SetupDevEnvironment)

<img src="./images/devcontainer.png" alt="Screenshot: Dev container setup" width="50%">

<img src="./images/image-3.png" alt="Screenshot: Dev container build complete" width="50%">

#### Επιλογή Γ: Χρήση Υπάρχουσας Τοπικής Εγκατάστασης

**Για προγραμματιστές με υπάρχοντα περιβάλλοντα Java**

Προαπαιτούμενα:
- [Java 21+](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) 
- [Maven 3.9+](https://maven.apache.org/download.cgi)
- [VS Code](https://code.visualstudio.com) ή το προτιμώμενο IDE σας

Βήματα:
1. Κάντε clone αυτό το repository στον τοπικό σας υπολογιστή
2. Ανοίξτε το project στο IDE σας
3. Προχωρήστε στο [Βήμα 2: Δημιουργία Token GitHub](../../../02-SetupDevEnvironment)

> **Χρήσιμη Συμβουλή**: Αν έχετε υπολογιστή χαμηλών προδιαγραφών αλλά θέλετε το VS Code τοπικά, χρησιμοποιήστε το GitHub Codespaces! Μπορείτε να συνδέσετε το τοπικό σας VS Code με ένα cloud-hosted Codespace για το καλύτερο και των δύο κόσμων.

<img src="./images/image-2.png" alt="Screenshot: created local devcontainer instance" width="50%">


## Βήμα 2: Δημιουργία Προσωπικού Token Πρόσβασης στο GitHub

1. Μεταβείτε στις [Ρυθμίσεις GitHub](https://github.com/settings/profile) και επιλέξτε **Settings** από το μενού του προφίλ σας.
2. Στην αριστερή πλευρική μπάρα, κάντε κλικ στο **Developer settings** (συνήθως στο κάτω μέρος).
3. Στην ενότητα **Personal access tokens**, κάντε κλικ στο **Fine-grained tokens** (ή ακολουθήστε αυτόν τον [σύνδεσμο](https://github.com/settings/personal-access-tokens)).
4. Κάντε κλικ στο **Generate new token**.
5. Στο "Token name", δώστε ένα περιγραφικό όνομα (π.χ., `GenAI-Java-Course-Token`).
6. Ορίστε ημερομηνία λήξης (συνιστάται: 7 ημέρες για βέλτιστες πρακτικές ασφαλείας).
7. Στο "Resource owner", επιλέξτε τον λογαριασμό χρήστη σας.
8. Στο "Repository access", επιλέξτε τα repositories που θέλετε να χρησιμοποιήσετε με τα GitHub Models (ή "All repositories" αν χρειάζεται).
9. Στο "Repository permissions", βρείτε το **Models** και ορίστε το σε **Read and write**.
10. Κάντε κλικ στο **Generate token**.
11. **Αντιγράψτε και αποθηκεύστε το token τώρα** – δεν θα το δείτε ξανά!

> **Συμβουλή Ασφαλείας**: Χρησιμοποιήστε το ελάχιστο απαιτούμενο scope και τη συντομότερη πρακτική διάρκεια λήξης για τα tokens πρόσβασης.

## Βήμα 3: Δοκιμή της Ρύθμισης με το Παράδειγμα GitHub Models

Μόλις το περιβάλλον ανάπτυξης είναι έτοιμο, ας δοκιμάσουμε την ενσωμάτωση των GitHub Models με την εφαρμογή παραδείγματος μας στο [`02-SetupDevEnvironment/src/github-models`](../../../02-SetupDevEnvironment/src/github-models).

1. Ανοίξτε το τερματικό στο περιβάλλον ανάπτυξης σας.
2. Μεταβείτε στο παράδειγμα GitHub Models:
   ```bash
   cd 02-SetupDevEnvironment/src/github-models
   ```
3. Ορίστε το token GitHub ως μεταβλητή περιβάλλοντος:
   ```bash
   # macOS/Linux
   export GITHUB_TOKEN=your_token_here
   
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_token_here"
   ```

4. Εκτελέστε την εφαρμογή:
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.githubmodels.App"
   ```

Θα πρέπει να δείτε έξοδο παρόμοια με:
```text
Using model: gpt-4.1-nano
Sending request to GitHub Models...
Response: Hello World!
```

### Κατανόηση του Κώδικα Παραδείγματος

Αρχικά, ας κατανοήσουμε τι πρόκειται να εκτελέσουμε. Το παράδειγμα χρησιμοποιεί το OpenAI Java SDK για να συνδεθεί με τα GitHub Models:

**Τι κάνει αυτός ο κώδικας:**
- **Συνδέεται** με τα GitHub Models χρησιμοποιώντας το προσωπικό σας token πρόσβασης
- **Στέλνει** ένα απλό μήνυμα "Say Hello World!" στο AI μοντέλο
- **Λαμβάνει** και εμφανίζει την απάντηση του AI
- **Επικυρώνει** ότι η ρύθμιση σας λειτουργεί σωστά

**Κύρια Εξάρτηση** (στο `pom.xml`):
```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

**Κύριος Κώδικας** (`App.java`):
```java
// Connect to GitHub Models using OpenAI Java SDK
OpenAIClient client = OpenAIOkHttpClient.builder()
    .apiKey(pat)
    .baseUrl("https://models.inference.ai.azure.com")
    .build();

// Create chat completion request
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .model(modelId)
    .addSystemMessage("You are a concise assistant.")
    .addUserMessage("Say Hello World!")
    .build();

// Get AI response
ChatCompletion response = client.chat().completions().create(params);
System.out.println("Response: " + response.choices().get(0).message().content().orElse("No response content"));
```

## Περίληψη

**Συγχαρητήρια!** Έχετε επιτυχώς:

- **Δημιουργήσει ένα Προσωπικό Token Πρόσβασης στο GitHub** με σωστές άδειες για πρόσβαση σε AI μοντέλα
- **Ρυθμίσει το περιβάλλον ανάπτυξης Java** χρησιμοποιώντας Codespaces, dev containers ή τοπική εγκατάσταση
- **Συνδεθεί με τα GitHub Models** χρησιμοποιώντας το OpenAI Java SDK για δωρεάν πρόσβαση σε AI ανάπτυξη
- **Δοκιμάσει την ενσωμάτωση** με μια λειτουργική εφαρμογή παραδείγματος που επικοινωνεί με AI μοντέλα

## Επόμενα Βήματα

[Κεφάλαιο 3: Βασικές Τεχνικές Γενετικής Τεχνητής Νοημοσύνης](../03-CoreGenerativeAITechniques/README.md)

## Αντιμετώπιση Προβλημάτων

Αν αντιμετωπίζετε προβλήματα, εδώ είναι κοινά ζητήματα και λύσεις:

- **Το token δεν λειτουργεί;** 
  - Βεβαιωθείτε ότι αντιγράψατε ολόκληρο το token χωρίς επιπλέον κενά
  - Επικυρώστε ότι το token έχει οριστεί σωστά ως μεταβλητή περιβάλλοντος
  - Ελέγξτε ότι το token έχει τις σωστές άδειες (Models: Read and write)

- **Δεν βρέθηκε Maven;** 
  - Αν χρησιμοποιείτε dev containers/Codespaces, το Maven θα πρέπει να είναι προεγκατεστημένο
  - Για τοπική ρύθμιση, βεβαιωθείτε ότι έχετε εγκαταστήσει Java 21+ και Maven 3.9+
  - Δοκιμάστε `mvn --version` για να επαληθεύσετε την εγκατάσταση

- **Προβλήματα σύνδεσης;** 
  - Ελέγξτε τη σύνδεση στο διαδίκτυο
  - Επικυρώστε ότι το GitHub είναι προσβάσιμο από το δίκτυό σας
  - Βεβαιωθείτε ότι δεν βρίσκεστε πίσω από firewall που μπλοκάρει το endpoint των GitHub Models

- **Το dev container δεν ξεκινά;** 
  - Βεβαιωθείτε ότι το Docker Desktop λειτουργεί (για τοπική ανάπτυξη)
  - Δοκιμάστε να ξαναχτίσετε το container: `Ctrl+Shift+P` → "Dev Containers: Rebuild Container"

- **Σφάλματα κατά τη μεταγλώττιση της εφαρμογής;**
  - Βεβαιωθείτε ότι βρίσκεστε στον σωστό φάκελο: `02-SetupDevEnvironment/src/github-models`
  - Δοκιμάστε καθαρισμό και ξαναχτίσιμο: `mvn clean compile`

> **Χρειάζεστε βοήθεια;**: Αν εξακολουθείτε να έχετε προβλήματα, ανοίξτε ένα issue στο repository και θα σας βοηθήσουμε.

**Αποποίηση ευθύνης**:  
Αυτό το έγγραφο έχει μεταφραστεί χρησιμοποιώντας την υπηρεσία μετάφρασης AI [Co-op Translator](https://github.com/Azure/co-op-translator). Παρόλο που καταβάλλουμε προσπάθειες για ακρίβεια, παρακαλούμε να έχετε υπόψη ότι οι αυτοματοποιημένες μεταφράσεις ενδέχεται να περιέχουν λάθη ή ανακρίβειες. Το πρωτότυπο έγγραφο στη μητρική του γλώσσα θα πρέπει να θεωρείται η αυθεντική πηγή. Για κρίσιμες πληροφορίες, συνιστάται επαγγελματική ανθρώπινη μετάφραση. Δεν φέρουμε ευθύνη για τυχόν παρεξηγήσεις ή εσφαλμένες ερμηνείες που προκύπτουν από τη χρήση αυτής της μετάφρασης.