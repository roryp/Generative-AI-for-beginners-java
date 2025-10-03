<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "4d04ae8088f6a3c3fcbab18cbdfe4002",
  "translation_date": "2025-10-03T08:11:44+00:00",
  "source_file": "README.md",
  "language_code": "el"
}
-->
# Γενετική Τεχνητή Νοημοσύνη για Αρχάριους - Έκδοση Java
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Γενετική Τεχνητή Νοημοσύνη για Αρχάριους - Έκδοση Java](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.el.png)

**Χρόνος Δέσμευσης**: Το εργαστήριο μπορεί να ολοκληρωθεί εξ ολοκλήρου online χωρίς τοπική εγκατάσταση. Η ρύθμιση του περιβάλλοντος απαιτεί 2 λεπτά, ενώ η εξερεύνηση των παραδειγμάτων μπορεί να διαρκέσει 1-3 ώρες, ανάλογα με το βάθος της εξερεύνησης.

> **Γρήγορη Εκκίνηση**

1. Κάντε fork αυτό το αποθετήριο στον λογαριασμό σας στο GitHub
2. Κάντε κλικ στο **Code** → καρτέλα **Codespaces** → **...** → **New with options...**
3. Χρησιμοποιήστε τις προεπιλογές – αυτό θα επιλέξει το Development container που δημιουργήθηκε για αυτό το μάθημα
4. Κάντε κλικ στο **Create codespace**
5. Περιμένετε ~2 λεπτά για να είναι έτοιμο το περιβάλλον
6. Μεταβείτε απευθείας στο [Το πρώτο παράδειγμα](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Υποστήριξη Πολλαπλών Γλωσσών

### Υποστηρίζεται μέσω GitHub Action (Αυτοματοποιημένο & Πάντα Ενημερωμένο)

[Γαλλικά](../fr/README.md) | [Ισπανικά](../es/README.md) | [Γερμανικά](../de/README.md) | [Ρωσικά](../ru/README.md) | [Αραβικά](../ar/README.md) | [Περσικά (Φαρσί)](../fa/README.md) | [Ουρντού](../ur/README.md) | [Κινέζικα (Απλοποιημένα)](../zh/README.md) | [Κινέζικα (Παραδοσιακά, Μακάο)](../mo/README.md) | [Κινέζικα (Παραδοσιακά, Χονγκ Κονγκ)](../hk/README.md) | [Κινέζικα (Παραδοσιακά, Ταϊβάν)](../tw/README.md) | [Ιαπωνικά](../ja/README.md) | [Κορεατικά](../ko/README.md) | [Χίντι](../hi/README.md) | [Μπενγκάλι](../bn/README.md) | [Μαραθικά](../mr/README.md) | [Νεπαλικά](../ne/README.md) | [Παντζάμπι (Γκουρμούκι)](../pa/README.md) | [Πορτογαλικά (Πορτογαλία)](../pt/README.md) | [Πορτογαλικά (Βραζιλία)](../br/README.md) | [Ιταλικά](../it/README.md) | [Πολωνικά](../pl/README.md) | [Τουρκικά](../tr/README.md) | [Ελληνικά](./README.md) | [Ταϊλανδικά](../th/README.md) | [Σουηδικά](../sv/README.md) | [Δανικά](../da/README.md) | [Νορβηγικά](../no/README.md) | [Φινλανδικά](../fi/README.md) | [Ολλανδικά](../nl/README.md) | [Εβραϊκά](../he/README.md) | [Βιετναμέζικα](../vi/README.md) | [Ινδονησιακά](../id/README.md) | [Μαλαισιανά](../ms/README.md) | [Ταγκαλόγκ (Φιλιππινέζικα)](../tl/README.md) | [Σουαχίλι](../sw/README.md) | [Ουγγρικά](../hu/README.md) | [Τσέχικα](../cs/README.md) | [Σλοβακικά](../sk/README.md) | [Ρουμανικά](../ro/README.md) | [Βουλγαρικά](../bg/README.md) | [Σερβικά (Κυριλλικά)](../sr/README.md) | [Κροατικά](../hr/README.md) | [Σλοβενικά](../sl/README.md) | [Ουκρανικά](../uk/README.md) | [Βιρμανικά (Μιανμάρ)](../my/README.md)

## Δομή Μαθήματος & Διαδρομή Μάθησης

### **Κεφάλαιο 1: Εισαγωγή στη Γενετική Τεχνητή Νοημοσύνη**
- **Βασικές Έννοιες**: Κατανόηση Μεγάλων Γλωσσικών Μοντέλων, tokens, embeddings και δυνατοτήτων AI
- **Java AI Οικοσύστημα**: Επισκόπηση των Spring AI και OpenAI SDKs
- **Πρωτόκολλο Context Μοντέλου**: Εισαγωγή στο MCP και τον ρόλο του στην επικοινωνία AI agents
- **Πρακτικές Εφαρμογές**: Σενάρια πραγματικού κόσμου, όπως chatbots και δημιουργία περιεχομένου
- **[→ Ξεκινήστε το Κεφάλαιο 1](./01-IntroToGenAI/README.md)**

### **Κεφάλαιο 2: Ρύθμιση Περιβάλλοντος Ανάπτυξης**
- **Ρύθμιση Πολλαπλών Παρόχων**: Ενσωμάτωση GitHub Models, Azure OpenAI και OpenAI Java SDK
- **Spring Boot + Spring AI**: Βέλτιστες πρακτικές για ανάπτυξη εφαρμογών AI σε επιχειρήσεις
- **GitHub Models**: Δωρεάν πρόσβαση σε μοντέλα AI για πρωτότυπα και μάθηση (χωρίς πιστωτική κάρτα)
- **Εργαλεία Ανάπτυξης**: Ρύθμιση Docker containers, VS Code και GitHub Codespaces
- **[→ Ξεκινήστε το Κεφάλαιο 2](./02-SetupDevEnvironment/README.md)**

### **Κεφάλαιο 3: Βασικές Τεχνικές Γενετικής Τεχνητής Νοημοσύνης**
- **Prompt Engineering**: Τεχνικές για βέλτιστες απαντήσεις από μοντέλα AI
- **Embeddings & Vector Operations**: Υλοποίηση σημασιολογικής αναζήτησης και αντιστοίχισης ομοιότητας
- **Ανάκτηση-Εμπλουτισμένη Γενετική (RAG)**: Συνδυασμός AI με δικές σας πηγές δεδομένων
- **Function Calling**: Επέκταση δυνατοτήτων AI με προσαρμοσμένα εργαλεία και plugins
- **[→ Ξεκινήστε το Κεφάλαιο 3](./03-CoreGenerativeAITechniques/README.md)**

### **Κεφάλαιο 4: Πρακτικές Εφαρμογές & Έργα**
- **Γεννήτρια Ιστοριών Κατοικίδιων** (`petstory/`): Δημιουργία περιεχομένου με GitHub Models
- **Τοπική Επίδειξη Foundry** (`foundrylocal/`): Ενσωμάτωση τοπικών μοντέλων AI με OpenAI Java SDK
- **Υπηρεσία Υπολογιστή MCP** (`calculator/`): Βασική υλοποίηση Πρωτοκόλλου Context Μοντέλου με Spring AI
- **[→ Ξεκινήστε το Κεφάλαιο 4](./04-PracticalSamples/README.md)**

### **Κεφάλαιο 5: Υπεύθυνη Ανάπτυξη AI**
- **Ασφάλεια GitHub Models**: Δοκιμή ενσωματωμένων μηχανισμών φιλτραρίσματος περιεχομένου και ασφάλειας (σκληρά μπλοκ και ήπιες αρνήσεις)
- **Επίδειξη Υπεύθυνης AI**: Πρακτικό παράδειγμα που δείχνει πώς λειτουργούν τα σύγχρονα συστήματα ασφάλειας AI
- **Βέλτιστες Πρακτικές**: Οδηγίες για ηθική ανάπτυξη και υλοποίηση AI
- **[→ Ξεκινήστε το Κεφάλαιο 5](./05-ResponsibleGenAI/README.md)**

## Πρόσθετοι Πόροι

- [Edge AI για Αρχάριους](https://github.com/microsoft/edgeai-for-beginners)
- [MCP για Αρχάριους](https://github.com/microsoft/mcp-for-beginners)
- [AI Agents για Αρχάριους](https://github.com/microsoft/ai-agents-for-beginners)
- [Γενετική Τεχνητή Νοημοσύνη για Αρχάριους με .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Γενετική Τεχνητή Νοημοσύνη για Αρχάριους με JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Γενετική Τεχνητή Νοημοσύνη για Αρχάριους](https://github.com/microsoft/generative-ai-for-beginners)
- [ML για Αρχάριους](https://aka.ms/ml-beginners)
- [Επιστήμη Δεδομένων για Αρχάριους](https://aka.ms/datascience-beginners)
- [AI για Αρχάριους](https://aka.ms/ai-beginners)
- [Κυβερνοασφάλεια για Αρχάριους](https://github.com/microsoft/Security-101)
- [Web Dev για Αρχάριους](https://aka.ms/webdev-beginners)
- [IoT για Αρχάριους](https://aka.ms/iot-beginners)
- [Ανάπτυξη XR για Αρχάριους](https://github.com/microsoft/xr-development-for-beginners)
- [Mastering GitHub Copilot για AI Συνεργατική Προγραμματιστική](https://aka.ms/GitHubCopilotAI)
- [Mastering GitHub Copilot για Προγραμματιστές C#/.NET](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Choose Your Own Copilot Adventure](https://github.com/microsoft/CopilotAdventures)
- [RAG Chat App με Azure AI Services](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## Λήψη Βοήθειας

Αν αντιμετωπίζετε δυσκολίες ή έχετε ερωτήσεις σχετικά με την ανάπτυξη εφαρμογών AI, συμμετάσχετε:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Αν έχετε σχόλια για το προϊόν ή σφάλματα κατά την ανάπτυξη, επισκεφθείτε:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**Αποποίηση ευθύνης**:  
Αυτό το έγγραφο έχει μεταφραστεί χρησιμοποιώντας την υπηρεσία αυτόματης μετάφρασης [Co-op Translator](https://github.com/Azure/co-op-translator). Παρόλο που καταβάλλουμε προσπάθειες για ακρίβεια, παρακαλούμε να έχετε υπόψη ότι οι αυτόματες μεταφράσεις ενδέχεται να περιέχουν λάθη ή ανακρίβειες. Το πρωτότυπο έγγραφο στη μητρική του γλώσσα θα πρέπει να θεωρείται η αυθεντική πηγή. Για κρίσιμες πληροφορίες, συνιστάται επαγγελματική ανθρώπινη μετάφραση. Δεν φέρουμε ευθύνη για τυχόν παρεξηγήσεις ή εσφαλμένες ερμηνείες που προκύπτουν από τη χρήση αυτής της μετάφρασης.