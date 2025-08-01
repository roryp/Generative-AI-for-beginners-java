<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0cbf68d605615a1e602c832a24616859",
  "translation_date": "2025-07-21T20:07:44+00:00",
  "source_file": "04-PracticalSamples/petstory/TUTORIAL.md",
  "language_code": "el"
}
-->
# Οδηγός για Αρχάριους: Δημιουργία Ιστοριών για Κατοικίδια

## Πίνακας Περιεχομένων

- [Προαπαιτούμενα](../../../../04-PracticalSamples/petstory)
- [Κατανόηση της Δομής του Έργου](../../../../04-PracticalSamples/petstory)
- [Επεξήγηση Βασικών Στοιχείων](../../../../04-PracticalSamples/petstory)
  - [1. Κύρια Εφαρμογή](../../../../04-PracticalSamples/petstory)
  - [2. Web Controller](../../../../04-PracticalSamples/petstory)
  - [3. Υπηρεσία Ιστοριών](../../../../04-PracticalSamples/petstory)
  - [4. Web Templates](../../../../04-PracticalSamples/petstory)
  - [5. Ρυθμίσεις](../../../../04-PracticalSamples/petstory)
- [Εκτέλεση της Εφαρμογής](../../../../04-PracticalSamples/petstory)
- [Πώς Όλα Συνδέονται Μεταξύ τους](../../../../04-PracticalSamples/petstory)
- [Κατανόηση της Ενσωμάτωσης AI](../../../../04-PracticalSamples/petstory)
- [Επόμενα Βήματα](../../../../04-PracticalSamples/petstory)

## Προαπαιτούμενα

Πριν ξεκινήσετε, βεβαιωθείτε ότι έχετε:
- Εγκατεστημένο Java 21 ή νεότερη έκδοση
- Maven για τη διαχείριση εξαρτήσεων
- Έναν λογαριασμό GitHub με προσωπικό access token (PAT) με το scope `models:read`
- Βασική κατανόηση της Java, του Spring Boot και της ανάπτυξης web

## Κατανόηση της Δομής του Έργου

Το έργο δημιουργίας ιστοριών για κατοικίδια περιλαμβάνει αρκετά σημαντικά αρχεία:

```
petstory/
├── src/main/java/com/example/petstory/
│   ├── PetStoryApplication.java       # Main Spring Boot application
│   ├── PetController.java             # Web request handler
│   ├── StoryService.java              # AI story generation service
│   └── SecurityConfig.java            # Security configuration
├── src/main/resources/
│   ├── application.properties         # App configuration
│   └── templates/
│       ├── index.html                 # Upload form page
│       └── result.html               # Story display page
└── pom.xml                           # Maven dependencies
```

## Επεξήγηση Βασικών Στοιχείων

### 1. Κύρια Εφαρμογή

**Αρχείο:** `PetStoryApplication.java`

Αυτό είναι το σημείο εκκίνησης για την εφαρμογή Spring Boot:

```java
@SpringBootApplication
public class PetStoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetStoryApplication.class, args);
    }
}
```

**Τι κάνει:**
- Το annotation `@SpringBootApplication` ενεργοποιεί την αυτόματη ρύθμιση και τη σάρωση στοιχείων
- Ξεκινά έναν ενσωματωμένο web server (Tomcat) στην πόρτα 8080
- Δημιουργεί αυτόματα όλα τα απαραίτητα Spring beans και υπηρεσίες

### 2. Web Controller

**Αρχείο:** `PetController.java`

Αυτό διαχειρίζεται όλα τα web αιτήματα και τις αλληλεπιδράσεις με τον χρήστη:

```java
@Controller
public class PetController {
    
    private final StoryService storyService;
    
    public PetController(StoryService storyService) {
        this.storyService = storyService;
    }
    
    @GetMapping("/")
    public String index() {
        return "index";  // Returns index.html template
    }
    
    @PostMapping("/generate-story")
    public String generateStory(@RequestParam("description") String description, 
                               Model model, 
                               RedirectAttributes redirectAttributes) {
        
        // Input validation
        if (description.trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Please provide a description.");
            return "redirect:/";
        }
        
        // Sanitize input for security
        String sanitizedDescription = sanitizeInput(description);
        
        // Generate story with error handling
        try {
            String story = storyService.generateStory(sanitizedDescription);
            model.addAttribute("caption", sanitizedDescription);
            model.addAttribute("story", story);
            return "result";  // Returns result.html template
            
        } catch (Exception e) {
            // Use fallback story if AI fails
            String fallbackStory = generateFallbackStory(sanitizedDescription);
            model.addAttribute("story", fallbackStory);
            return "result";
        }
    }
    
    private String sanitizeInput(String input) {
        return input.replaceAll("[<>\"'&]", "")  // Remove dangerous characters
                   .trim()
                   .substring(0, Math.min(input.length(), 500));  // Limit length
    }
}
```

**Κύρια χαρακτηριστικά:**

1. **Διαχείριση Διαδρομών**: Το `@GetMapping("/")` εμφανίζει τη φόρμα μεταφόρτωσης, ενώ το `@PostMapping("/generate-story")` επεξεργάζεται τις υποβολές
2. **Επικύρωση Εισόδου**: Ελέγχει για κενές περιγραφές και όρια μήκους
3. **Ασφάλεια**: Καθαρίζει την είσοδο του χρήστη για την αποφυγή επιθέσεων XSS
4. **Διαχείριση Σφαλμάτων**: Παρέχει προκαθορισμένες ιστορίες όταν η υπηρεσία AI αποτυγχάνει
5. **Σύνδεση Μοντέλου**: Μεταφέρει δεδομένα στα HTML templates χρησιμοποιώντας το `Model` του Spring

**Σύστημα Εναλλακτικών Λύσεων:**
Ο controller περιλαμβάνει προκαθορισμένα πρότυπα ιστοριών που χρησιμοποιούνται όταν η υπηρεσία AI δεν είναι διαθέσιμη:

```java
private String generateFallbackStory(String description) {
    String[] storyTemplates = {
        "Meet the most wonderful pet in the world – a furry ball of energy...",
        "Once upon a time, there lived a remarkable pet whose heart was as big...",
        "In a cozy home filled with love, there lived an extraordinary pet..."
    };
    
    // Use description hash for consistent responses
    int index = Math.abs(description.hashCode() % storyTemplates.length);
    return storyTemplates[index];
}
```

### 3. Υπηρεσία Ιστοριών

**Αρχείο:** `StoryService.java`

Αυτή η υπηρεσία επικοινωνεί με τα GitHub Models για τη δημιουργία ιστοριών:

```java
@Service
public class StoryService {
    
    private final OpenAIClient openAIClient;
    private final String modelName;
    
    public StoryService(@Value("${github.models.endpoint}") String endpoint,
                       @Value("${github.models.model}") String modelName) {
        
        String githubToken = System.getenv("GITHUB_TOKEN");
        if (githubToken == null || githubToken.isBlank()) {
            throw new IllegalStateException("GITHUB_TOKEN environment variable must be set");
        }
        
        // Create OpenAI client configured for GitHub Models
        this.openAIClient = OpenAIOkHttpClient.builder()
                .baseUrl(endpoint)
                .apiKey(githubToken)
                .build();
    }
    
    public String generateStory(String description) {
        String systemPrompt = "You are a creative storyteller who writes fun, " +
                             "family-friendly short stories about pets. " +
                             "Keep stories under 500 words and appropriate for all ages.";
        
        String userPrompt = "Write a fun short story about a pet described as: " + description;
        
        // Configure the AI request
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(modelName)
                .addSystemMessage(systemPrompt)
                .addUserMessage(userPrompt)
                .maxCompletionTokens(500)  // Limit response length
                .temperature(0.8)          // Control creativity (0.0-1.0)
                .build();
        
        // Send request and get response
        ChatCompletion response = openAIClient.chat().completions().create(params);
        
        return response.choices().get(0).message().content().orElse("");
    }
}
```

**Κύρια στοιχεία:**

1. **OpenAI Client**: Χρησιμοποιεί το επίσημο OpenAI Java SDK ρυθμισμένο για τα GitHub Models
2. **System Prompt**: Ορίζει τη συμπεριφορά του AI ώστε να γράφει οικογενειακές ιστορίες για κατοικίδια
3. **User Prompt**: Ενημερώνει το AI για το τι ακριβώς να γράψει με βάση την περιγραφή
4. **Παράμετροι**: Ελέγχει το μήκος της ιστορίας και το επίπεδο δημιουργικότητας
5. **Διαχείριση Σφαλμάτων**: Ρίχνει εξαιρέσεις που ο controller αναλαμβάνει να διαχειριστεί

### 4. Web Templates

**Αρχείο:** `index.html` (Φόρμα Μεταφόρτωσης)

Η κύρια σελίδα όπου οι χρήστες περιγράφουν τα κατοικίδιά τους:

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Pet Story Generator</title>
    <!-- CSS styling -->
</head>
<body>
    <div class="container">
        <h1>Pet Story Generator</h1>
        <p>Describe your pet and we'll create a fun story about them!</p>
        
        <!-- Error message display -->
        <div th:if="${error}" class="error" th:text="${error}"></div>
        
        <!-- Story generation form -->
        <form action="/generate-story" method="post">
            <div class="form-group">
                <label for="description">Describe your pet:</label>
                <textarea id="description" name="description" 
                         placeholder="Tell us about your pet - what they look like, their personality, favorite activities..."
                         maxlength="1000" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Generate Story</button>
        </form>
        
        <!-- Image upload section with client-side processing -->
        <div class="upload-section">
            <h2>Or Upload a Photo</h2>
            <input type="file" id="imageInput" accept="image/*" />
            <button onclick="analyzeImage()" class="upload-btn">Analyze Image</button>
        </div>
        
        <script>
            // Client-side image analysis using Transformers.js
            async function analyzeImage() {
                // Image processing code here
                // Generates description automatically from uploaded image
            }
        </script>
    </div>
</body>
</html>
```

**Αρχείο:** `result.html` (Εμφάνιση Ιστορίας)

Εμφανίζει την παραγόμενη ιστορία:

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Pet Story Result</title>
</head>
<body>
    <div class="container">
        <h1>Your Pet's Story</h1>
        
        <div class="result-section">
            <div class="result-label">Pet Description:</div>
            <div class="result-content" th:text="${caption}"></div>
        </div>
        
        <div class="result-section">
            <div class="result-label">Generated Story:</div>
            <div class="result-content" th:text="${story}"></div>
        </div>
        
        <div class="result-section" th:if="${analysisType}">
            <div class="result-label">Analysis Type:</div>
            <div class="result-content" th:text="${analysisType}"></div>
        </div>
        
        <a href="/" class="back-link">Generate Another Story</a>
    </div>
</body>
</html>
```

**Χαρακτηριστικά Template:**

1. **Ενσωμάτωση Thymeleaf**: Χρησιμοποιεί `th:` attributes για δυναμικό περιεχόμενο
2. **Ανταποκρινόμενος Σχεδιασμός**: CSS styling για κινητά και desktop
3. **Διαχείριση Σφαλμάτων**: Εμφανίζει μηνύματα επικύρωσης στους χρήστες
4. **Επεξεργασία στην Πλευρά του Πελάτη**: JavaScript για ανάλυση εικόνων (χρησιμοποιώντας Transformers.js)

### 5. Ρυθμίσεις

**Αρχείο:** `application.properties`

Ρυθμίσεις για την εφαρμογή:

```properties
spring.application.name=pet-story-app

# File upload limits
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB

# Logging configuration
logging.level.com.example.petstory=INFO

# GitHub Models configuration
github.models.endpoint=https://models.github.ai/inference
github.models.model=openai/gpt-4.1-nano
```

**Επεξήγηση Ρυθμίσεων:**

1. **Μεταφόρτωση Αρχείων**: Επιτρέπει εικόνες έως 10MB
2. **Καταγραφή**: Ελέγχει ποιες πληροφορίες καταγράφονται κατά την εκτέλεση
3. **GitHub Models**: Καθορίζει ποιο AI μοντέλο και endpoint θα χρησιμοποιηθεί
4. **Ασφάλεια**: Ρυθμίσεις διαχείρισης σφαλμάτων για την αποφυγή αποκάλυψης ευαίσθητων πληροφοριών

## Εκτέλεση της Εφαρμογής

### Βήμα 1: Ορίστε το GitHub Token σας

Πρώτα, πρέπει να ορίσετε το GitHub token σας ως μεταβλητή περιβάλλοντος:

**Windows (Command Prompt):**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Windows (PowerShell):**
```powershell
$env:GITHUB_TOKEN="your_github_token_here"
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

**Γιατί είναι απαραίτητο:**
- Τα GitHub Models απαιτούν αυθεντικοποίηση για πρόσβαση στα AI μοντέλα
- Η χρήση μεταβλητών περιβάλλοντος διατηρεί τα ευαίσθητα tokens εκτός του πηγαίου κώδικα
- Το scope `models:read` παρέχει πρόσβαση σε AI inference

### Βήμα 2: Δημιουργία και Εκτέλεση

Μεταβείτε στον φάκελο του έργου:
```bash
cd 04-PracticalSamples/petstory
```

Δημιουργήστε την εφαρμογή:
```bash
mvn clean compile
```

Ξεκινήστε τον server:
```bash
mvn spring-boot:run
```

Η εφαρμογή θα ξεκινήσει στο `http://localhost:8080`.

### Βήμα 3: Δοκιμάστε την Εφαρμογή

1. **Ανοίξτε** το `http://localhost:8080` στον browser σας
2. **Περιγράψτε** το κατοικίδιό σας στο πεδίο κειμένου (π.χ., "Ένας παιχνιδιάρης golden retriever που λατρεύει να φέρνει αντικείμενα")
3. **Κάντε κλικ** στο "Generate Story" για να λάβετε μια ιστορία που δημιουργήθηκε από AI
4. **Εναλλακτικά**, ανεβάστε μια εικόνα κατοικίδιου για αυτόματη δημιουργία περιγραφής
5. **Δείτε** τη δημιουργική ιστορία που βασίζεται στην περιγραφή του κατοικίδιου σας

## Πώς Όλα Συνδέονται Μεταξύ τους

Ακολουθεί η πλήρης ροή όταν δημιουργείτε μια ιστορία για κατοικίδιο:

1. **Είσοδος Χρήστη**: Περιγράφετε το κατοικίδιό σας στη φόρμα web
2. **Υποβολή Φόρμας**: Ο browser στέλνει POST αίτημα στο `/generate-story`
3. **Επεξεργασία από τον Controller**: Ο `PetController` επικυρώνει και καθαρίζει την είσοδο
4. **Κλήση Υπηρεσίας AI**: Ο `StoryService` στέλνει αίτημα στο API των GitHub Models
5. **Δημιουργία Ιστορίας**: Το AI δημιουργεί μια δημιουργική ιστορία βασισμένη στην περιγραφή
6. **Διαχείριση Απόκρισης**: Ο controller λαμβάνει την ιστορία και την προσθέτει στο μοντέλο
7. **Απόδοση Template**: Το Thymeleaf αποδίδει το `result.html` με την ιστορία
8. **Εμφάνιση**: Ο χρήστης βλέπει την παραγόμενη ιστορία στον browser του

**Ροή Διαχείρισης Σφαλμάτων:**
Αν η υπηρεσία AI αποτύχει:
1. Ο controller πιάνει την εξαίρεση
2. Δημιουργεί μια εναλλακτική ιστορία χρησιμοποιώντας προκαθορισμένα πρότυπα
3. Εμφανίζει την εναλλακτική ιστορία με σημείωση για τη μη διαθεσιμότητα του AI
4. Ο χρήστης λαμβάνει ιστορία, διασφαλίζοντας καλή εμπειρία χρήστη

## Κατανόηση της Ενσωμάτωσης AI

### GitHub Models API
Η εφαρμογή χρησιμοποιεί τα GitHub Models, τα οποία παρέχουν δωρεάν πρόσβαση σε διάφορα AI μοντέλα:

```java
// Authentication with GitHub token
this.openAIClient = OpenAIOkHttpClient.builder()
    .baseUrl("https://models.github.ai/inference")
    .apiKey(githubToken)
    .build();
```

### Prompt Engineering
Η υπηρεσία χρησιμοποιεί προσεκτικά σχεδιασμένα prompts για να επιτύχει καλά αποτελέσματα:

```java
String systemPrompt = "You are a creative storyteller who writes fun, " +
                     "family-friendly short stories about pets. " +
                     "Keep stories under 500 words and appropriate for all ages.";
```

### Επεξεργασία Απόκρισης
Η απόκριση του AI εξάγεται και επικυρώνεται:

```java
ChatCompletion response = openAIClient.chat().completions().create(params);
String story = response.choices().get(0).message().content().orElse("");
```

## Επόμενα Βήματα

Για περισσότερα παραδείγματα, δείτε [Chapter 04: Practical samples](../README.md)

**Αποποίηση ευθύνης**:  
Αυτό το έγγραφο έχει μεταφραστεί χρησιμοποιώντας την υπηρεσία αυτόματης μετάφρασης [Co-op Translator](https://github.com/Azure/co-op-translator). Παρόλο που καταβάλλουμε προσπάθειες για ακρίβεια, παρακαλούμε να έχετε υπόψη ότι οι αυτόματες μεταφράσεις ενδέχεται να περιέχουν λάθη ή ανακρίβειες. Το πρωτότυπο έγγραφο στη μητρική του γλώσσα θα πρέπει να θεωρείται η αυθεντική πηγή. Για κρίσιμες πληροφορίες, συνιστάται επαγγελματική μετάφραση από ανθρώπους. Δεν φέρουμε ευθύνη για τυχόν παρεξηγήσεις ή εσφαλμένες ερμηνείες που προκύπτουν από τη χρήση αυτής της μετάφρασης.