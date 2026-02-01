# Lemmiklooma Loo Generaatori Õpetus Algajatele

## Sisukord

- [Eeltingimused](../../../../04-PracticalSamples/petstory)
- [Projekti Struktuuri Mõistmine](../../../../04-PracticalSamples/petstory)
- [Põhikomponentide Selgitus](../../../../04-PracticalSamples/petstory)
  - [1. Põhirakendus](../../../../04-PracticalSamples/petstory)
  - [2. Veebikontroller](../../../../04-PracticalSamples/petstory)
  - [3. Loo Teenus](../../../../04-PracticalSamples/petstory)
  - [4. Veebimallid](../../../../04-PracticalSamples/petstory)
  - [5. Konfiguratsioon](../../../../04-PracticalSamples/petstory)
- [Rakenduse Käivitamine](../../../../04-PracticalSamples/petstory)
- [Kuidas Kõik Koos Töötab](../../../../04-PracticalSamples/petstory)
- [AI Integratsiooni Mõistmine](../../../../04-PracticalSamples/petstory)
- [Järgmised Sammud](../../../../04-PracticalSamples/petstory)

## Eeltingimused

Enne alustamist veendu, et sul on:
- Paigaldatud Java 21 või uuem
- Maven sõltuvuste haldamiseks
- GitHubi konto koos isikliku juurdepääsutokniga (PAT) `models:read` õigustega
- Põhilised teadmised Java, Spring Booti ja veebiarenduse kohta

## Projekti Struktuuri Mõistmine

Lemmiklooma loo projekt sisaldab mitmeid olulisi faile:

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

## Põhikomponentide Selgitus

### 1. Põhirakendus

**Fail:** `PetStoryApplication.java`

See on meie Spring Booti rakenduse alguspunkt:

```java
@SpringBootApplication
public class PetStoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetStoryApplication.class, args);
    }
}
```

**Mida see teeb:**
- `@SpringBootApplication` annotatsioon võimaldab automaatset konfiguratsiooni ja komponentide skaneerimist
- Käivitab sisseehitatud veebiserveri (Tomcat) porti 8080
- Loob automaatselt kõik vajalikud Springi beanid ja teenused

### 2. Veebikontroller

**Fail:** `PetController.java`

See haldab kõiki veebipäringuid ja kasutajate interaktsioone:

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

**Peamised omadused:**

1. **Marsruutide haldamine**: `@GetMapping("/")` kuvab üleslaadimisvormi, `@PostMapping("/generate-story")` töötleb sisestusi
2. **Sisendi valideerimine**: Kontrollib tühje kirjeldusi ja pikkuse piiranguid
3. **Turvalisus**: Sanitiseerib kasutaja sisendi, et vältida XSS rünnakuid
4. **Vigade käsitlemine**: Pakub varulugusid, kui AI teenus ebaõnnestub
5. **Mudeliga sidumine**: Edastab andmed HTML mallidesse, kasutades Springi `Model`-it

**Varusüsteem:**
Kontroller sisaldab eelkirjutatud lugude malle, mida kasutatakse, kui AI teenus pole saadaval:

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

### 3. Loo Teenus

**Fail:** `StoryService.java`

See teenus suhtleb GitHubi mudelitega, et luua lugusid:

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

**Peamised komponendid:**

1. **OpenAI klient**: Kasutab ametlikku OpenAI Java SDK-d, mis on konfigureeritud GitHubi mudelite jaoks
2. **Süsteemi prompt**: Määrab AI käitumise, et kirjutada peresõbralikke lemmikloomalugusid
3. **Kasutaja prompt**: Annab AI-le täpse juhise, millist lugu kirjutada kirjelduse põhjal
4. **Parameetrid**: Kontrollib loo pikkust ja loovuse taset
5. **Vigade käsitlemine**: Viskab erandeid, mida kontroller püüab ja käsitleb

### 4. Veebimallid

**Fail:** `index.html` (Üleslaadimisvorm)

Peamine leht, kus kasutajad kirjeldavad oma lemmikloomi:

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

**Fail:** `result.html` (Loo kuvamine)

Kuvab genereeritud loo:

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

**Mallide omadused:**

1. **Thymeleaf integratsioon**: Kasutab `th:` atribuute dünaamilise sisu jaoks
2. **Responsiivne disain**: CSS stiilid mobiili ja lauaarvuti jaoks
3. **Vigade käsitlemine**: Kuvab valideerimisvead kasutajatele
4. **Kliendipoolne töötlemine**: JavaScript piltide analüüsimiseks (kasutades Transformers.js-i)

### 5. Konfiguratsioon

**Fail:** `application.properties`

Rakenduse konfiguratsiooniseaded:

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

**Konfiguratsiooni selgitus:**

1. **Faili üleslaadimine**: Lubab kuni 10MB suuruseid pilte
2. **Logimine**: Kontrollib, millist teavet täitmise ajal logitakse
3. **GitHubi mudelid**: Määrab, millist AI mudelit ja lõpp-punkti kasutada
4. **Turvalisus**: Vigade käsitlemise konfiguratsioon, et vältida tundliku teabe avaldamist

## Rakenduse Käivitamine

### Samm 1: Määra GitHubi Token

Esmalt tuleb määrata GitHubi token keskkonnamuutujana:

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

**Miks see vajalik on:**
- GitHubi mudelid nõuavad autentimist, et pääseda AI mudelitele
- Keskkonnamuutujate kasutamine hoiab tundlikud tokenid lähtekoodist eemal
- `models:read` ulatus võimaldab AI järelduste kasutamist

### Samm 2: Ehita ja Käivita

Liigu projekti kataloogi:
```bash
cd 04-PracticalSamples/petstory
```

Ehita rakendus:
```bash
mvn clean compile
```

Käivita server:
```bash
mvn spring-boot:run
```

Rakendus käivitub aadressil `http://localhost:8080`.

### Samm 3: Testi Rakendust

1. **Ava** `http://localhost:8080` oma brauseris
2. **Kirjelda** oma lemmiklooma tekstialas (nt "Mänguhimuline kuldne retriiver, kes armastab asju tuua")
3. **Klõpsa** "Genereeri lugu", et saada AI poolt loodud lugu
4. **Alternatiivina**, laadi üles lemmiklooma pilt, et automaatselt kirjeldus genereerida
5. **Vaata** loovat lugu, mis põhineb sinu lemmiklooma kirjeldusele

## Kuidas Kõik Koos Töötab

Siin on täielik voog, kui genereerid lemmiklooma loo:

1. **Kasutaja sisend**: Sa kirjeldad oma lemmiklooma veebivormil
2. **Vormi esitamine**: Brauser saadab POST päringu aadressile `/generate-story`
3. **Kontrolleri töötlemine**: `PetController` valideerib ja sanitiseerib sisendi
4. **AI teenuse kutse**: `StoryService` saadab päringu GitHubi mudelite API-le
5. **Loo genereerimine**: AI genereerib loova loo kirjelduse põhjal
6. **Vastuse käsitlemine**: Kontroller saab loo ja lisab selle mudelisse
7. **Malli renderdamine**: Thymeleaf renderdab `result.html` loo kuvamiseks
8. **Kuvamine**: Kasutaja näeb genereeritud lugu oma brauseris

**Vigade käsitlemise voog:**
Kui AI teenus ebaõnnestub:
1. Kontroller püüab erandi
2. Genereerib varuloo eelkirjutatud mallide abil
3. Kuvab varuloo koos märkusega AI teenuse kättesaamatusest
4. Kasutaja saab siiski loo, tagades hea kasutajakogemuse

## AI Integratsiooni Mõistmine

### GitHubi Mudelite API
Rakendus kasutab GitHubi mudeleid, mis pakuvad tasuta juurdepääsu erinevatele AI mudelitele:

```java
// Authentication with GitHub token
this.openAIClient = OpenAIOkHttpClient.builder()
    .baseUrl("https://models.github.ai/inference")
    .apiKey(githubToken)
    .build();
```

### Promptide Inseneeria
Teenuses kasutatakse hoolikalt koostatud promte, et saada häid tulemusi:

```java
String systemPrompt = "You are a creative storyteller who writes fun, " +
                     "family-friendly short stories about pets. " +
                     "Keep stories under 500 words and appropriate for all ages.";
```

### Vastuse Töötlemine
AI vastus eraldatakse ja valideeritakse:

```java
ChatCompletion response = openAIClient.chat().completions().create(params);
String story = response.choices().get(0).message().content().orElse("");
```

## Järgmised Sammud

Rohkem näiteid leiad [Peatükk 04: Praktilised näited](../README.md)

---

**Lahtiütlus**:  
See dokument on tõlgitud AI tõlketeenuse [Co-op Translator](https://github.com/Azure/co-op-translator) abil. Kuigi püüame tagada täpsust, palume arvestada, et automaatsed tõlked võivad sisaldada vigu või ebatäpsusi. Algne dokument selle algses keeles tuleks pidada autoriteetseks allikaks. Olulise teabe puhul soovitame kasutada professionaalset inimtõlget. Me ei vastuta selle tõlke kasutamisest tulenevate arusaamatuste või valesti tõlgenduste eest.