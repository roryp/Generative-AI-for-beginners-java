<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b8a372dfc3e3e7ad9261231a22fd79c0",
  "translation_date": "2025-07-25T09:30:33+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "el"
}
-->
# Βασικές Τεχνικές Γενετικής Τεχνητής Νοημοσύνης

>**Note**: Αυτό το κεφάλαιο περιλαμβάνει ένα λεπτομερές [**Tutorial**](./TUTORIAL.md) που σας καθοδηγεί μέσα από τα παραδείγματα.

## Τι Θα Μάθετε
Σε αυτό το κεφάλαιο, εξετάζουμε 4 βασικές τεχνικές γενετικής τεχνητής νοημοσύνης μέσα από πρακτικά παραδείγματα:
- Συμπληρώσεις LLM και ροές συνομιλίας
- Κλήση λειτουργιών
- Δημιουργία με Ενισχυμένη Ανάκτηση (RAG)
- Μέτρα ασφαλείας για υπεύθυνη τεχνητή νοημοσύνη

## Πίνακας Περιεχομένων

- [Τι Θα Μάθετε](../../../03-CoreGenerativeAITechniques)
- [Προαπαιτούμενα](../../../03-CoreGenerativeAITechniques)
- [Ξεκινώντας](../../../03-CoreGenerativeAITechniques)
- [Επισκόπηση Παραδειγμάτων](../../../03-CoreGenerativeAITechniques)
  - [1. Συμπληρώσεις LLM και Ροές Συνομιλίας](../../../03-CoreGenerativeAITechniques)
  - [2. Λειτουργίες & Plugins με LLMs](../../../03-CoreGenerativeAITechniques)
  - [3. Δημιουργία με Ενισχυμένη Ανάκτηση (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Επίδειξη Ασφαλείας Υπεύθυνης Τεχνητής Νοημοσύνης](../../../03-CoreGenerativeAITechniques)
- [Περίληψη](../../../03-CoreGenerativeAITechniques)
- [Επόμενα Βήματα](../../../03-CoreGenerativeAITechniques)

## Προαπαιτούμενα

- Ολοκληρωμένη εγκατάσταση από [Κεφάλαιο 2](../../../02-SetupDevEnvironment)

## Ξεκινώντας

1. **Μεταβείτε στα παραδείγματα**: 
```bash
cd 03-CoreGenerativeAITechniques/examples/
```
2. **Ορίστε το περιβάλλον**: 
```bash
export GITHUB_TOKEN=your_token_here
```
3. **Συγκεντρώστε και εκτελέστε τα παραδείγματα**:
```bash
   # Run completions example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
   
   # Run functions example  
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
   
   # Run RAG example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
   
   # Run responsible AI demo
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
   ```

## Επισκόπηση Παραδειγμάτων

Τα παραδείγματα είναι οργανωμένα στον φάκελο `examples/` με την εξής δομή:

```
examples/
├── src/main/java/com/example/genai/techniques/
│   ├── completions/
│   │   └── LLMCompletionsApp.java        # Basic completions 
│   ├── functions/
│   │   └── FunctionsApp.java             # Function calling examples
│   ├── rag/
│   │   └── SimpleReaderDemo.java         # Retrieval-Augmented Generation
│   └── responsibleai/
│       └── ResponsibleGithubModels.java  # Responsible AI safety demonstration
├── document.txt                          # Sample document for RAG example
└── pom.xml                               # Maven configuration
```

### 1. Συμπληρώσεις LLM και Ροές Συνομιλίας
**Αρχείο**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Μάθετε πώς να δημιουργείτε συνομιλιακή τεχνητή νοημοσύνη με ροές απαντήσεων και διαχείριση ιστορικού συνομιλιών.

Αυτό το παράδειγμα δείχνει:
- Απλή συμπλήρωση κειμένου με προτροπές συστήματος
- Συνομιλίες πολλαπλών γύρων με διαχείριση ιστορικού
- Διαδραστικές συνεδρίες συνομιλίας
- Ρύθμιση παραμέτρων (θερμοκρασία, μέγιστος αριθμός tokens)

### 2. Λειτουργίες & Plugins με LLMs
**Αρχείο**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Επεκτείνετε τις δυνατότητες της τεχνητής νοημοσύνης δίνοντας στα μοντέλα πρόσβαση σε προσαρμοσμένες λειτουργίες και εξωτερικά APIs.

Αυτό το παράδειγμα δείχνει:
- Ενσωμάτωση λειτουργίας καιρού
- Υλοποίηση λειτουργίας αριθμομηχανής  
- Πολλαπλές κλήσεις λειτουργιών σε μία συνομιλία
- Ορισμός λειτουργιών με JSON schemas

### 3. Δημιουργία με Ενισχυμένη Ανάκτηση (RAG)
**Αρχείο**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Μάθετε πώς να συνδυάζετε την τεχνητή νοημοσύνη με τα δικά σας έγγραφα και πηγές δεδομένων για ακριβείς, προσαρμοσμένες απαντήσεις.

Αυτό το παράδειγμα δείχνει:
- Απαντήσεις σε ερωτήσεις βασισμένες σε έγγραφα με το Azure OpenAI SDK
- Υλοποίηση μοτίβου RAG με GitHub Models

**Χρήση**: Κάντε ερωτήσεις σχετικά με το περιεχόμενο του `document.txt` και λάβετε απαντήσεις από την τεχνητή νοημοσύνη βασισμένες μόνο σε αυτό το πλαίσιο.

### 4. Επίδειξη Ασφαλείας Υπεύθυνης Τεχνητής Νοημοσύνης
**Αρχείο**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Αποκτήστε μια προεπισκόπηση του πώς λειτουργούν τα μέτρα ασφαλείας της τεχνητής νοημοσύνης δοκιμάζοντας τις δυνατότητες φιλτραρίσματος περιεχομένου των GitHub Models.

Αυτό το παράδειγμα δείχνει:
- Φιλτράρισμα περιεχομένου για πιθανώς επιβλαβείς προτροπές
- Διαχείριση απαντήσεων ασφαλείας σε εφαρμογές
- Διαφορετικές κατηγορίες αποκλεισμένου περιεχομένου (βία, ρητορική μίσους, παραπληροφόρηση)
- Σωστή διαχείριση σφαλμάτων για παραβιάσεις ασφαλείας

> **Μάθετε Περισσότερα**: Αυτή είναι μόνο μια εισαγωγή στις έννοιες της υπεύθυνης τεχνητής νοημοσύνης. Για περισσότερες πληροφορίες σχετικά με την ηθική, τη μείωση προκαταλήψεων, τις ανησυχίες για την ιδιωτικότητα και τα πλαίσια υπεύθυνης τεχνητής νοημοσύνης, δείτε [Κεφάλαιο 5: Υπεύθυνη Γενετική Τεχνητή Νοημοσύνη](../05-ResponsibleGenAI/README.md).

## Περίληψη

Σε αυτό το κεφάλαιο, εξετάσαμε τις συμπληρώσεις LLM και τις ροές συνομιλίας, υλοποιήσαμε κλήση λειτουργιών για την ενίσχυση των δυνατοτήτων της τεχνητής νοημοσύνης, δημιουργήσαμε ένα σύστημα Ενισχυμένης Ανάκτησης (RAG) και παρουσιάσαμε μέτρα ασφαλείας για υπεύθυνη τεχνητή νοημοσύνη. 

> **NOTE**: Εμβαθύνετε με το παρεχόμενο [**Tutorial**](./TUTORIAL.md)

## Επόμενα Βήματα

[Κεφάλαιο 4: Πρακτικές Εφαρμογές & Έργα](../04-PracticalSamples/README.md)

**Αποποίηση ευθύνης**:  
Αυτό το έγγραφο έχει μεταφραστεί χρησιμοποιώντας την υπηρεσία αυτόματης μετάφρασης AI [Co-op Translator](https://github.com/Azure/co-op-translator). Παρόλο που καταβάλλουμε προσπάθειες για ακρίβεια, παρακαλούμε να έχετε υπόψη ότι οι αυτόματες μεταφράσεις ενδέχεται να περιέχουν λάθη ή ανακρίβειες. Το πρωτότυπο έγγραφο στη μητρική του γλώσσα θα πρέπει να θεωρείται η αυθεντική πηγή. Για κρίσιμες πληροφορίες, συνιστάται επαγγελματική ανθρώπινη μετάφραση. Δεν φέρουμε ευθύνη για τυχόν παρεξηγήσεις ή εσφαλμένες ερμηνείες που προκύπτουν από τη χρήση αυτής της μετάφρασης.