<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "ff95bb9d60ecd46e1a2215e341062967",
  "translation_date": "2025-07-26T17:33:24+00:00",
  "source_file": "README.md",
  "language_code": "el"
}
-->
# Γενετική Τεχνητή Νοημοσύνη για Αρχάριους - Έκδοση Java
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Γενετική Τεχνητή Νοημοσύνη για Αρχάριους - Έκδοση Java](../../translated_images/beg-genai-series.61edc4a6b2cc54284fa2d70eda26dc0ca2669e26e49655b842ea799cd6e16d2a.el.png)

**Χρονική Δέσμευση**: Το εργαστήριο μπορεί να ολοκληρωθεί εξ ολοκλήρου διαδικτυακά χωρίς τοπική εγκατάσταση. Αν θέλετε να εκτελέσετε τα παραδείγματα, η ρύθμιση του περιβάλλοντος διαρκεί 2 λεπτά, ενώ η εξερεύνηση των παραδειγμάτων απαιτεί 1-3 ώρες, ανάλογα με το βάθος της εξερεύνησης.

> **Γρήγορη Εκκίνηση**

1. Κάντε fork αυτό το αποθετήριο στον λογαριασμό σας στο GitHub
2. Κάντε κλικ στο **Code** → **Codespaces** tab → **...** → **New with options...**
3. Χρησιμοποιήστε τις προεπιλογές – αυτό θα επιλέξει το Development container που δημιουργήθηκε για αυτό το μάθημα
4. Κάντε κλικ στο **Create codespace**
5. Περιμένετε ~2 λεπτά για να είναι έτοιμο το περιβάλλον
6. Μεταβείτε απευθείας στο [Δημιουργία του GitHub Models Token](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Υποστήριξη Πολλαπλών Γλωσσών

### Υποστηρίζεται μέσω GitHub Action (Αυτοματοποιημένο & Πάντα Ενημερωμένο)

[Γαλλικά](../fr/README.md) | [Ισπανικά](../es/README.md) | [Γερμανικά](../de/README.md) | [Ρωσικά](../ru/README.md) | [Αραβικά](../ar/README.md) | [Περσικά (Φαρσί)](../fa/README.md) | [Ουρντού](../ur/README.md) | [Κινέζικα (Απλοποιημένα)](../zh/README.md) | [Κινέζικα (Παραδοσιακά, Μακάο)](../mo/README.md) | [Κινέζικα (Παραδοσιακά, Χονγκ Κονγκ)](../hk/README.md) | [Κινέζικα (Παραδοσιακά, Ταϊβάν)](../tw/README.md) | [Ιαπωνικά](../ja/README.md) | [Κορεατικά](../ko/README.md) | [Χίντι](../hi/README.md) | [Μπενγκάλι](../bn/README.md) | [Μαράθι](../mr/README.md) | [Νεπαλικά](../ne/README.md) | [Παντζάμπι (Γκουρμούκι)](../pa/README.md) | [Πορτογαλικά (Πορτογαλία)](../pt/README.md) | [Πορτογαλικά (Βραζιλία)](../br/README.md) | [Ιταλικά](../it/README.md) | [Πολωνικά](../pl/README.md) | [Τουρκικά](../tr/README.md) | [Ελληνικά](./README.md) | [Ταϊλανδικά](../th/README.md) | [Σουηδικά](../sv/README.md) | [Δανικά](../da/README.md) | [Νορβηγικά](../no/README.md) | [Φινλανδικά](../fi/README.md) | [Ολλανδικά](../nl/README.md) | [Εβραϊκά](../he/README.md) | [Βιετναμέζικα](../vi/README.md) | [Ινδονησιακά](../id/README.md) | [Μαλαισιανά](../ms/README.md) | [Ταγκαλόγκ (Φιλιππινέζικα)](../tl/README.md) | [Σουαχίλι](../sw/README.md) | [Ουγγρικά](../hu/README.md) | [Τσέχικα](../cs/README.md) | [Σλοβακικά](../sk/README.md) | [Ρουμανικά](../ro/README.md) | [Βουλγαρικά](../bg/README.md) | [Σερβικά (Κυριλλικά)](../sr/README.md) | [Κροατικά](../hr/README.md) | [Σλοβενικά](../sl/README.md) | [Ουκρανικά](../uk/README.md) | [Βιρμανικά (Μιανμάρ)](../my/README.md)

## Δομή Μαθήματος & Διαδρομή Μάθησης

### **Κεφάλαιο 1: Εισαγωγή στη Γενετική Τεχνητή Νοημοσύνη**
- **Βασικές Έννοιες**: Κατανόηση Μεγάλων Γλωσσικών Μοντέλων, tokens, embeddings και δυνατοτήτων AI
- **Οικοσύστημα AI για Java**: Επισκόπηση των Spring AI και OpenAI SDKs
- **Πρωτόκολλο Πλαισίου Μοντέλου**: Εισαγωγή στο MCP και τον ρόλο του στην επικοινωνία AI πρακτόρων
- **Πρακτικές Εφαρμογές**: Σενάρια πραγματικού κόσμου, όπως chatbots και δημιουργία περιεχομένου
- **[→ Ξεκινήστε το Κεφάλαιο 1](./01-IntroToGenAI/README.md)**

### **Κεφάλαιο 2: Ρύθμιση Περιβάλλοντος Ανάπτυξης**
- **Διαμόρφωση Πολλαπλών Παρόχων**: Ρύθμιση GitHub Models, Azure OpenAI και OpenAI Java SDK
- **Spring Boot + Spring AI**: Βέλτιστες πρακτικές για ανάπτυξη επιχειρησιακών εφαρμογών AI
- **GitHub Models**: Δωρεάν πρόσβαση σε μοντέλα AI για πρωτότυπα και μάθηση (χωρίς πιστωτική κάρτα)
- **Εργαλεία Ανάπτυξης**: Διαμόρφωση Docker containers, VS Code και GitHub Codespaces
- **[→ Ξεκινήστε το Κεφάλαιο 2](./02-SetupDevEnvironment/README.md)**

### **Κεφάλαιο 3: Βασικές Τεχνικές Γενετικής Τεχνητής Νοημοσύνης**
- **Μηχανική Προτροπών**: Τεχνικές για βέλτιστες απαντήσεις από μοντέλα AI
- **Embeddings & Λειτουργίες Διανυσμάτων**: Υλοποίηση σημασιολογικής αναζήτησης και αντιστοίχισης ομοιότητας
- **Ανάκτηση-Εμπλουτισμένη Γενετική (RAG)**: Συνδυασμός AI με δικές σας πηγές δεδομένων
- **Κλήση Λειτουργιών**: Επέκταση δυνατοτήτων AI με προσαρμοσμένα εργαλεία και plugins
- **[→ Ξεκινήστε το Κεφάλαιο 3](./03-CoreGenerativeAITechniques/README.md)**

### **Κεφάλαιο 4: Πρακτικές Εφαρμογές & Έργα**
- **Γεννήτρια Ιστοριών Κατοικίδιων** (`petstory/`): Δημιουργία δημιουργικού περιεχομένου με GitHub Models
- **Τοπική Επίδειξη Foundry** (`foundrylocal/`): Ενσωμάτωση τοπικών μοντέλων AI με OpenAI Java SDK
- **Υπηρεσία Υπολογιστή MCP** (`mcp/calculator/`): Βασική υλοποίηση Πρωτοκόλλου Πλαισίου Μοντέλου με Spring AI
- **[→ Ξεκινήστε το Κεφάλαιο 4](./04-PracticalSamples/README.md)**

### **Κεφάλαιο 5: Υπεύθυνη Ανάπτυξη AI**
- **Ασφάλεια GitHub Models**: Δοκιμή ενσωματωμένων φίλτρων περιεχομένου και μηχανισμών ασφάλειας
- **Επίδειξη Υπεύθυνης AI**: Πρακτικό παράδειγμα που δείχνει πώς λειτουργούν τα φίλτρα ασφάλειας AI
- **Βέλτιστες Πρακτικές**: Οδηγίες για ηθική ανάπτυξη και υλοποίηση AI
- **[→ Ξεκινήστε το Κεφάλαιο 5](./05-ResponsibleGenAI/README.md)**

## Πρόσθετοι Πόροι

- [AI Agents For Beginners](https://github.com/microsoft/ai-agents-for-beginners)
- [Generative AI for Beginners using .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generative AI for Beginners using JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Generative AI for Beginners](https://github.com/microsoft/generative-ai-for-beginners)
- [ML for Beginners](https://aka.ms/ml-beginners)
- [Data Science for Beginners](https://aka.ms/datascience-beginners)
- [AI for Beginners](https://aka.ms/ai-beginners)
- [Cybersecurity for Beginners](https://github.com/microsoft/Security-101)
- [Web Dev for Beginners](https://aka.ms/webdev-beginners)
- [IoT for Beginners](https://aka.ms/iot-beginners)
- [XR Development for Beginners](https://github.com/microsoft/xr-development-for-beginners)
- [Mastering GitHub Copilot for AI Paired Programming](https://aka.ms/GitHubCopilotAI)
- [Mastering GitHub Copilot for C#/.NET Developers](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Choose Your Own Copilot Adventure](https://github.com/microsoft/CopilotAdventures)
- [RAG Chat App with Azure AI Services](https://github.com/Azure-Samples/azure-search-openai-demo-java)

**Αποποίηση ευθύνης**:  
Αυτό το έγγραφο έχει μεταφραστεί χρησιμοποιώντας την υπηρεσία αυτόματης μετάφρασης [Co-op Translator](https://github.com/Azure/co-op-translator). Παρόλο που καταβάλλουμε προσπάθειες για ακρίβεια, παρακαλούμε να έχετε υπόψη ότι οι αυτόματες μεταφράσεις ενδέχεται να περιέχουν λάθη ή ανακρίβειες. Το πρωτότυπο έγγραφο στη μητρική του γλώσσα θα πρέπει να θεωρείται η αυθεντική πηγή. Για κρίσιμες πληροφορίες, συνιστάται επαγγελματική μετάφραση από άνθρωπο. Δεν φέρουμε ευθύνη για τυχόν παρεξηγήσεις ή εσφαλμένες ερμηνείες που προκύπτουν από τη χρήση αυτής της μετάφρασης.