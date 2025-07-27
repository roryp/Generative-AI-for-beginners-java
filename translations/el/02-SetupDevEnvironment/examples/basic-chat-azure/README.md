<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "efd82efe50711d7e257eb943151d682c",
  "translation_date": "2025-07-27T13:41:10+00:00",
  "source_file": "02-SetupDevEnvironment/examples/basic-chat-azure/README.md",
  "language_code": "el"
}
-->
# Βασική Συνομιλία με το Azure OpenAI - Παράδειγμα από Άκρη σε Άκρη

Αυτό το παράδειγμα δείχνει πώς να δημιουργήσετε μια απλή εφαρμογή Spring Boot που συνδέεται με το Azure OpenAI και δοκιμάζει τη ρύθμισή σας.

## Πίνακας Περιεχομένων

- [Προαπαιτούμενα](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Γρήγορη Εκκίνηση](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Επιλογές Ρύθμισης](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Επιλογή 1: Μεταβλητές Περιβάλλοντος (.env αρχείο) - Συνιστάται](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Επιλογή 2: Μυστικά GitHub Codespace](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Εκτέλεση της Εφαρμογής](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Χρήση Maven](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Χρήση VS Code](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Αναμενόμενο Αποτέλεσμα](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Αναφορά Ρυθμίσεων](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Μεταβλητές Περιβάλλοντος](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Ρύθμιση Spring](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Αντιμετώπιση Προβλημάτων](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Συνηθισμένα Προβλήματα](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Λειτουργία Εντοπισμού Σφαλμάτων](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Επόμενα Βήματα](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Πόροι](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## Προαπαιτούμενα

Πριν εκτελέσετε αυτό το παράδειγμα, βεβαιωθείτε ότι έχετε:

- Ολοκληρώσει τον [οδηγό ρύθμισης Azure OpenAI](../../getting-started-azure-openai.md)  
- Αναπτύξει πόρο Azure OpenAI (μέσω της πύλης Azure AI Foundry)  
- Αναπτύξει το μοντέλο gpt-4o-mini (ή εναλλακτικό)  
- Κλειδί API και URL τελικού σημείου από το Azure  

## Γρήγορη Εκκίνηση

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Επιλογές Ρύθμισης

### Επιλογή 1: Μεταβλητές Περιβάλλοντος (.env αρχείο) - Συνιστάται

**Βήμα 1: Δημιουργήστε το αρχείο ρυθμίσεων σας**  
```bash
cp .env.example .env
```

**Βήμα 2: Προσθέστε τα διαπιστευτήρια Azure OpenAI**  
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Σημείωση Ασφαλείας**: 
> - Μην δεσμεύετε ποτέ το αρχείο `.env` στον έλεγχο εκδόσεων
> - Το αρχείο `.env` είναι ήδη στη λίστα `.gitignore`
> - Διατηρήστε τα κλειδιά API ασφαλή και ανανεώνετέ τα τακτικά

### Επιλογή 2: Μυστικά GitHub Codespace

Για GitHub Codespaces, ορίστε αυτά τα μυστικά στο αποθετήριό σας:
- `AZURE_AI_KEY` - Το κλειδί API του Azure OpenAI
- `AZURE_AI_ENDPOINT` - Το URL τελικού σημείου του Azure OpenAI

Η εφαρμογή ανιχνεύει και χρησιμοποιεί αυτόματα αυτά τα μυστικά.

### Εναλλακτική: Άμεσες Μεταβλητές Περιβάλλοντος

<details>
<summary>Κάντε κλικ για να δείτε εντολές ανά πλατφόρμα</summary>

**Linux/macOS (bash/zsh):**  
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (Command Prompt):**  
```cmd
set AZURE_AI_KEY=your-actual-api-key-here
set AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (PowerShell):**  
```powershell
$env:AZURE_AI_KEY="your-actual-api-key-here"
$env:AZURE_AI_ENDPOINT="https://your-hub-name.openai.azure.com/"
```
</details>

## Εκτέλεση της Εφαρμογής

### Χρήση Maven

```bash
mvn spring-boot:run
```

### Χρήση VS Code

1. Ανοίξτε το έργο στο VS Code  
2. Πατήστε `F5` ή χρησιμοποιήστε τον πίνακα "Run and Debug"  
3. Επιλέξτε τη ρύθμιση "Spring Boot-BasicChatApplication"  

> **Σημείωση**: Η ρύθμιση του VS Code φορτώνει αυτόματα το αρχείο .env σας

### Αναμενόμενο Αποτέλεσμα

```
Starting Basic Chat with Azure OpenAI...
Environment variables loaded successfully
Connecting to Azure OpenAI...
Sending prompt: What is AI in a short sentence? Max 100 words.

AI Response:
================
AI, or Artificial Intelligence, is the simulation of human intelligence in machines programmed to think and learn like humans.
================

Success! Azure OpenAI connection is working correctly.
```

## Αναφορά Ρυθμίσεων

### Μεταβλητές Περιβάλλοντος

| Μεταβλητή | Περιγραφή | Υποχρεωτική | Παράδειγμα |
|-----------|-----------|-------------|------------|
| `AZURE_AI_KEY` | Κλειδί API του Azure OpenAI | Ναι | `abc123...` |
| `AZURE_AI_ENDPOINT` | URL τελικού σημείου του Azure OpenAI | Ναι | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Όνομα ανάπτυξης μοντέλου | Όχι | `gpt-4o-mini` (προεπιλογή) |

### Ρύθμιση Spring

Το αρχείο `application.yml` ρυθμίζει:
- **Κλειδί API**: `${AZURE_AI_KEY}` - Από μεταβλητή περιβάλλοντος  
- **Τελικό Σημείο**: `${AZURE_AI_ENDPOINT}` - Από μεταβλητή περιβάλλοντος  
- **Μοντέλο**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Από μεταβλητή περιβάλλοντος με εναλλακτική  
- **Θερμοκρασία**: `0.7` - Ελέγχει τη δημιουργικότητα (0.0 = ντετερμινιστικό, 1.0 = δημιουργικό)  
- **Μέγιστοι Τόκενς**: `500` - Μέγιστο μήκος απόκρισης  

## Αντιμετώπιση Προβλημάτων

### Συνηθισμένα Προβλήματα

<details>
<summary><strong>Σφάλμα: "Το κλειδί API δεν είναι έγκυρο"</strong></summary>

- Ελέγξτε ότι το `AZURE_AI_KEY` έχει οριστεί σωστά στο αρχείο `.env`  
- Βεβαιωθείτε ότι το κλειδί API έχει αντιγραφεί ακριβώς από την πύλη Azure AI Foundry  
- Ελέγξτε για επιπλέον κενά ή εισαγωγικά γύρω από το κλειδί  
</details>

<details>
<summary><strong>Σφάλμα: "Το τελικό σημείο δεν είναι έγκυρο"</strong></summary>

- Βεβαιωθείτε ότι το `AZURE_AI_ENDPOINT` περιλαμβάνει το πλήρες URL (π.χ., `https://your-hub-name.openai.azure.com/`)  
- Ελέγξτε για συνέπεια στις καταλήξεις `/`  
- Επαληθεύστε ότι το τελικό σημείο ταιριάζει με την περιοχή ανάπτυξης του Azure  
</details>

<details>
<summary><strong>Σφάλμα: "Η ανάπτυξη δεν βρέθηκε"</strong></summary>

- Επαληθεύστε ότι το όνομα ανάπτυξης του μοντέλου ταιριάζει ακριβώς με αυτό που έχει αναπτυχθεί στο Azure  
- Ελέγξτε ότι το μοντέλο έχει αναπτυχθεί με επιτυχία και είναι ενεργό  
- Δοκιμάστε να χρησιμοποιήσετε το προεπιλεγμένο όνομα ανάπτυξης: `gpt-4o-mini`  
</details>

<details>
<summary><strong>VS Code: Οι μεταβλητές περιβάλλοντος δεν φορτώνονται</strong></summary>

- Βεβαιωθείτε ότι το αρχείο `.env` βρίσκεται στον ριζικό κατάλογο του έργου (στο ίδιο επίπεδο με το `pom.xml`)  
- Δοκιμάστε να εκτελέσετε `mvn spring-boot:run` στο ενσωματωμένο τερματικό του VS Code  
- Ελέγξτε ότι η επέκταση Java του VS Code είναι σωστά εγκατεστημένη  
- Επαληθεύστε ότι η ρύθμιση εκκίνησης περιέχει `"envFile": "${workspaceFolder}/.env"`  
</details>

### Λειτουργία Εντοπισμού Σφαλμάτων

Για να ενεργοποιήσετε λεπτομερή καταγραφή, αποσχολιάστε αυτές τις γραμμές στο `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Επόμενα Βήματα

**Η Ρύθμιση Ολοκληρώθηκε!** Συνεχίστε το ταξίδι μάθησής σας:

[Κεφάλαιο 3: Βασικές Τεχνικές Γενετικής Τεχνητής Νοημοσύνης](../../../03-CoreGenerativeAITechniques/README.md)

## Πόροι

- [Τεκμηρίωση Spring AI Azure OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)  
- [Τεκμηρίωση Υπηρεσίας Azure OpenAI](https://learn.microsoft.com/azure/ai-services/openai/)  
- [Πύλη Azure AI Foundry](https://ai.azure.com/)  
- [Τεκμηρίωση Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)  

**Αποποίηση ευθύνης**:  
Αυτό το έγγραφο έχει μεταφραστεί χρησιμοποιώντας την υπηρεσία αυτόματης μετάφρασης [Co-op Translator](https://github.com/Azure/co-op-translator). Παρόλο που καταβάλλουμε προσπάθειες για ακρίβεια, παρακαλούμε να έχετε υπόψη ότι οι αυτόματες μεταφράσεις ενδέχεται να περιέχουν σφάλματα ή ανακρίβειες. Το πρωτότυπο έγγραφο στη μητρική του γλώσσα θα πρέπει να θεωρείται η αυθεντική πηγή. Για κρίσιμες πληροφορίες, συνιστάται επαγγελματική ανθρώπινη μετάφραση. Δεν φέρουμε ευθύνη για τυχόν παρεξηγήσεις ή εσφαλμένες ερμηνείες που προκύπτουν από τη χρήση αυτής της μετάφρασης.