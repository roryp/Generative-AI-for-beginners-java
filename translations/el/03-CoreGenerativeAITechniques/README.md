<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T19:10:23+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "el"
}
-->
# Βασικές Τεχνικές Γενετικής Τεχνητής Νοημοσύνης

>**Σημείωση**: Αυτό το κεφάλαιο περιλαμβάνει έναν αναλυτικό [**Οδηγό**](./TUTORIAL.md) που σας καθοδηγεί στη χρήση των ολοκληρωμένων παραδειγμάτων.

## Τι Θα Μάθετε
Σε αυτό το κεφάλαιο, εξετάζουμε 4 βασικές τεχνικές γενετικής τεχνητής νοημοσύνης μέσα από πρακτικά παραδείγματα:
- Συμπληρώσεις LLM και ροές συνομιλιών
- Κλήσεις λειτουργιών
- Δημιουργία με Ενισχυμένη Ανάκτηση (RAG)
- Μέτρα ασφαλείας για υπεύθυνη τεχνητή νοημοσύνη

## Πίνακας Περιεχομένων

- [Τι Θα Μάθετε](../../../03-CoreGenerativeAITechniques)
- [Προαπαιτούμενα](../../../03-CoreGenerativeAITechniques)
- [Ξεκινώντας](../../../03-CoreGenerativeAITechniques)
- [Επισκόπηση Παραδειγμάτων](../../../03-CoreGenerativeAITechniques)
  - [1. Συμπληρώσεις LLM και Ροές Συνομιλιών](../../../03-CoreGenerativeAITechniques)
  - [2. Λειτουργίες & Πρόσθετα με LLMs](../../../03-CoreGenerativeAITechniques)
  - [3. Δημιουργία με Ενισχυμένη Ανάκτηση (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Επίδειξη Ασφαλούς Τεχνητής Νοημοσύνης](../../../03-CoreGenerativeAITechniques)
- [Σύνοψη](../../../03-CoreGenerativeAITechniques)
- [Επόμενα Βήματα](../../../03-CoreGenerativeAITechniques)

## Προαπαιτούμενα

- Ολοκληρωμένη ρύθμιση από το [Κεφάλαιο 2](../../../02-SetupDevEnvironment)

## Ξεκινώντας

1. **Μεταβείτε στα παραδείγματα**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **Ορίστε το περιβάλλον**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **Μεταγλώττιση και εκτέλεση παραδειγμάτων**:  
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

### 1. Συμπληρώσεις LLM και Ροές Συνομιλιών
**Αρχείο**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Μάθετε πώς να δημιουργείτε συνομιλιακή τεχνητή νοημοσύνη με ροές απαντήσεων και διαχείριση ιστορικού συνομιλιών.

Αυτό το παράδειγμα περιλαμβάνει:
- Απλή συμπλήρωση κειμένου με συστημικές προτροπές
- Συνομιλίες πολλαπλών γύρων με διαχείριση ιστορικού
- Διαδραστικές συνεδρίες συνομιλίας
- Ρύθμιση παραμέτρων (θερμοκρασία, μέγιστος αριθμός tokens)

### 2. Λειτουργίες & Πρόσθετα με LLMs
**Αρχείο**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Επεκτείνετε τις δυνατότητες της τεχνητής νοημοσύνης δίνοντας στα μοντέλα πρόσβαση σε προσαρμοσμένες λειτουργίες και εξωτερικά APIs.

Αυτό το παράδειγμα περιλαμβάνει:
- Ενσωμάτωση λειτουργίας καιρού
- Υλοποίηση λειτουργίας αριθμομηχανής  
- Πολλαπλές κλήσεις λειτουργιών σε μία συνομιλία
- Ορισμός λειτουργιών με JSON schemas

### 3. Δημιουργία με Ενισχυμένη Ανάκτηση (RAG)
**Αρχείο**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Μάθετε πώς να συνδυάζετε την τεχνητή νοημοσύνη με τα δικά σας έγγραφα και πηγές δεδομένων για ακριβείς, προσαρμοσμένες απαντήσεις.

Αυτό το παράδειγμα περιλαμβάνει:
- Απαντήσεις σε ερωτήσεις βασισμένες σε έγγραφα με το Azure OpenAI SDK
- Υλοποίηση του μοτίβου RAG με τα μοντέλα του GitHub

**Χρήση**: Κάντε ερωτήσεις σχετικά με το περιεχόμενο του `document.txt` και λάβετε απαντήσεις από την τεχνητή νοημοσύνη βασισμένες αποκλειστικά σε αυτό το πλαίσιο.

### 4. Επίδειξη Ασφαλούς Τεχνητής Νοημοσύνης
**Αρχείο**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Αποκτήστε μια προεπισκόπηση του πώς λειτουργούν τα μέτρα ασφαλείας της τεχνητής νοημοσύνης δοκιμάζοντας τις δυνατότητες φιλτραρίσματος περιεχομένου των μοντέλων του GitHub.

Αυτό το παράδειγμα περιλαμβάνει:
- Φιλτράρισμα περιεχομένου για δυνητικά επιβλαβείς προτροπές
- Διαχείριση απαντήσεων ασφαλείας σε εφαρμογές
- Διαφορετικές κατηγορίες αποκλεισμένου περιεχομένου (βία, ρητορική μίσους, παραπληροφόρηση)
- Σωστή διαχείριση σφαλμάτων για παραβιάσεις ασφαλείας

> **Μάθετε Περισσότερα**: Αυτή είναι μόνο μια εισαγωγή στις έννοιες της υπεύθυνης τεχνητής νοημοσύνης. Για περισσότερες πληροφορίες σχετικά με την ηθική, τη μείωση προκαταλήψεων, τις ανησυχίες για την ιδιωτικότητα και τα πλαίσια υπεύθυνης τεχνητής νοημοσύνης, δείτε το [Κεφάλαιο 5: Υπεύθυνη Γενετική Τεχνητή Νοημοσύνη](../05-ResponsibleGenAI/README.md).

## Σύνοψη

Σε αυτό το κεφάλαιο, εξερευνήσαμε τις συμπληρώσεις LLM και τις ροές συνομιλιών, υλοποιήσαμε κλήσεις λειτουργιών για την ενίσχυση των δυνατοτήτων της τεχνητής νοημοσύνης, δημιουργήσαμε ένα σύστημα Δημιουργίας με Ενισχυμένη Ανάκτηση (RAG) και παρουσιάσαμε μέτρα ασφαλείας για υπεύθυνη τεχνητή νοημοσύνη.

> **ΣΗΜΕΙΩΣΗ**: Εμβαθύνετε με τον παρεχόμενο [**Οδηγό**](./TUTORIAL.md)

## Επόμενα Βήματα

[Κεφάλαιο 4: Πρακτικές Εφαρμογές & Έργα](../04-PracticalSamples/README.md)

**Αποποίηση Ευθύνης**:  
Αυτό το έγγραφο έχει μεταφραστεί χρησιμοποιώντας την υπηρεσία αυτόματης μετάφρασης [Co-op Translator](https://github.com/Azure/co-op-translator). Παρόλο που καταβάλλουμε προσπάθειες για ακρίβεια, παρακαλούμε να έχετε υπόψη ότι οι αυτόματες μεταφράσεις ενδέχεται να περιέχουν λάθη ή ανακρίβειες. Το πρωτότυπο έγγραφο στη μητρική του γλώσσα θα πρέπει να θεωρείται η αυθεντική πηγή. Για κρίσιμες πληροφορίες, συνιστάται επαγγελματική ανθρώπινη μετάφραση. Δεν φέρουμε ευθύνη για τυχόν παρεξηγήσεις ή εσφαλμένες ερμηνείες που προκύπτουν από τη χρήση αυτής της μετάφρασης.