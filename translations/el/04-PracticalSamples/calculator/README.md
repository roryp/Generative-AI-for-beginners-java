<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b6c16b5514d524e415a94f6097ee7d4c",
  "translation_date": "2025-09-18T15:32:47+00:00",
  "source_file": "04-PracticalSamples/calculator/README.md",
  "language_code": "el"
}
-->
# Εκπαιδευτικό Υλικό MCP Calculator για Αρχάριους

## Πίνακας Περιεχομένων

- [Τι Θα Μάθετε](../../../../04-PracticalSamples/calculator)
- [Προαπαιτούμενα](../../../../04-PracticalSamples/calculator)
- [Κατανόηση της Δομής του Έργου](../../../../04-PracticalSamples/calculator)
- [Επεξήγηση Βασικών Στοιχείων](../../../../04-PracticalSamples/calculator)
  - [1. Κύρια Εφαρμογή](../../../../04-PracticalSamples/calculator)
  - [2. Υπηρεσία Αριθμομηχανής](../../../../04-PracticalSamples/calculator)
  - [3. Άμεσος MCP Client](../../../../04-PracticalSamples/calculator)
  - [4. Client με Υποστήριξη AI](../../../../04-PracticalSamples/calculator)
- [Εκτέλεση Παραδειγμάτων](../../../../04-PracticalSamples/calculator)
- [Πώς Λειτουργούν Όλα Μαζί](../../../../04-PracticalSamples/calculator)
- [Επόμενα Βήματα](../../../../04-PracticalSamples/calculator)

## Τι Θα Μάθετε

Αυτό το εκπαιδευτικό υλικό εξηγεί πώς να δημιουργήσετε μια υπηρεσία αριθμομηχανής χρησιμοποιώντας το Model Context Protocol (MCP). Θα κατανοήσετε:

- Πώς να δημιουργήσετε μια υπηρεσία που μπορεί να χρησιμοποιηθεί ως εργαλείο από AI
- Πώς να ρυθμίσετε άμεση επικοινωνία με υπηρεσίες MCP
- Πώς τα μοντέλα AI μπορούν να επιλέγουν αυτόματα ποια εργαλεία να χρησιμοποιήσουν
- Τη διαφορά μεταξύ άμεσων κλήσεων πρωτοκόλλου και αλληλεπιδράσεων με υποστήριξη AI

## Προαπαιτούμενα

Πριν ξεκινήσετε, βεβαιωθείτε ότι έχετε:
- Εγκατεστημένο Java 21 ή νεότερη έκδοση
- Maven για διαχείριση εξαρτήσεων
- Λογαριασμό GitHub με προσωπικό access token (PAT)
- Βασική κατανόηση της Java και του Spring Boot

## Κατανόηση της Δομής του Έργου

Το έργο της αριθμομηχανής περιλαμβάνει αρκετά σημαντικά αρχεία:

```
calculator/
├── src/main/java/com/microsoft/mcp/sample/server/
│   ├── McpServerApplication.java          # Main Spring Boot app
│   └── service/CalculatorService.java     # Calculator operations
└── src/test/java/com/microsoft/mcp/sample/client/
    ├── SDKClient.java                     # Direct MCP communication
    ├── LangChain4jClient.java            # AI-powered client
    └── Bot.java                          # Simple chat interface
```

## Επεξήγηση Βασικών Στοιχείων

### 1. Κύρια Εφαρμογή

**Αρχείο:** `McpServerApplication.java`

Αυτό είναι το σημείο εκκίνησης της υπηρεσίας αριθμομηχανής μας. Είναι μια τυπική εφαρμογή Spring Boot με μια ειδική προσθήκη:

```java
@SpringBootApplication
public class McpServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(McpServerApplication.class, args);
    }
    
    @Bean
    public ToolCallbackProvider calculatorTools(CalculatorService calculator) {
        return MethodToolCallbackProvider.builder().toolObjects(calculator).build();
    }
}
```

**Τι κάνει:**
- Εκκινεί έναν web server Spring Boot στην πόρτα 8080
- Δημιουργεί έναν `ToolCallbackProvider` που καθιστά τις μεθόδους της αριθμομηχανής διαθέσιμες ως εργαλεία MCP
- Το `@Bean` υποδεικνύει στο Spring να διαχειριστεί αυτό ως ένα component που μπορούν να χρησιμοποιήσουν άλλα μέρη

### 2. Υπηρεσία Αριθμομηχανής

**Αρχείο:** `CalculatorService.java`

Εδώ πραγματοποιούνται όλες οι μαθηματικές πράξεις. Κάθε μέθοδος έχει την ένδειξη `@Tool` για να είναι διαθέσιμη μέσω MCP:

```java
@Service
public class CalculatorService {

    @Tool(description = "Add two numbers together")
    public String add(double a, double b) {
        double result = a + b;
        return formatResult(a, "+", b, result);
    }

    @Tool(description = "Subtract the second number from the first number")
    public String subtract(double a, double b) {
        double result = a - b;
        return formatResult(a, "-", b, result);
    }
    
    // More calculator operations...
    
    private String formatResult(double a, String operator, double b, double result) {
        return String.format("%.2f %s %.2f = %.2f", a, operator, b, result);
    }
}
```

**Κύρια χαρακτηριστικά:**

1. **Σχολιασμός `@Tool`**: Υποδεικνύει στο MCP ότι αυτή η μέθοδος μπορεί να κληθεί από εξωτερικούς clients
2. **Σαφείς Περιγραφές**: Κάθε εργαλείο έχει μια περιγραφή που βοηθά τα μοντέλα AI να κατανοήσουν πότε να το χρησιμοποιήσουν
3. **Συνεπής Μορφή Επιστροφής**: Όλες οι πράξεις επιστρέφουν ευανάγνωστες συμβολοσειρές όπως "5.00 + 3.00 = 8.00"
4. **Διαχείριση Σφαλμάτων**: Η διαίρεση με το μηδέν και οι αρνητικές τετραγωνικές ρίζες επιστρέφουν μηνύματα σφάλματος

**Διαθέσιμες Πράξεις:**
- `add(a, b)` - Προσθέτει δύο αριθμούς
- `subtract(a, b)` - Αφαιρεί τον δεύτερο από τον πρώτο
- `multiply(a, b)` - Πολλαπλασιάζει δύο αριθμούς
- `divide(a, b)` - Διαιρεί τον πρώτο με τον δεύτερο (με έλεγχο μηδενισμού)
- `power(base, exponent)` - Υψώνει τη βάση στη δύναμη του εκθέτη
- `squareRoot(number)` - Υπολογίζει την τετραγωνική ρίζα (με έλεγχο αρνητικών)
- `modulus(a, b)` - Επιστρέφει το υπόλοιπο της διαίρεσης
- `absolute(number)` - Επιστρέφει την απόλυτη τιμή
- `help()` - Επιστρέφει πληροφορίες για όλες τις πράξεις

### 3. Άμεσος MCP Client

**Αρχείο:** `SDKClient.java`

Αυτός ο client επικοινωνεί απευθείας με τον MCP server χωρίς να χρησιμοποιεί AI. Καλεί χειροκίνητα συγκεκριμένες λειτουργίες της αριθμομηχανής:

```java
public class SDKClient {
    
    public static void main(String[] args) {
        McpClientTransport transport = WebFluxSseClientTransport.builder(
            WebClient.builder().baseUrl("http://localhost:8080")
        ).build();
        new SDKClient(transport).run();
    }
    
    public void run() {
        var client = McpClient.sync(this.transport).build();
        client.initialize();
        
        // List available tools
        ListToolsResult toolsList = client.listTools();
        System.out.println("Available Tools = " + toolsList);
        
        // Call specific calculator functions
        CallToolResult resultAdd = client.callTool(
            new CallToolRequest("add", Map.of("a", 5.0, "b", 3.0))
        );
        System.out.println("Add Result = " + resultAdd);
        
        CallToolResult resultSqrt = client.callTool(
            new CallToolRequest("squareRoot", Map.of("number", 16.0))
        );
        System.out.println("Square Root Result = " + resultSqrt);
        
        client.closeGracefully();
    }
}
```

**Τι κάνει:**
1. **Συνδέεται** με τον server της αριθμομηχανής στο `http://localhost:8080` χρησιμοποιώντας το builder pattern
2. **Λίστα** όλων των διαθέσιμων εργαλείων (τις λειτουργίες της αριθμομηχανής)
3. **Κλήση** συγκεκριμένων λειτουργιών με ακριβείς παραμέτρους
4. **Εκτύπωση** των αποτελεσμάτων απευθείας

**Σημείωση:** Το παράδειγμα χρησιμοποιεί την εξάρτηση Spring AI 1.1.0-SNAPSHOT, η οποία εισήγαγε το builder pattern για το `WebFluxSseClientTransport`. Εάν χρησιμοποιείτε παλαιότερη σταθερή έκδοση, ίσως χρειαστεί να χρησιμοποιήσετε τον άμεσο constructor.

**Πότε να το χρησιμοποιήσετε:** Όταν γνωρίζετε ακριβώς ποιον υπολογισμό θέλετε να εκτελέσετε και θέλετε να τον καλέσετε προγραμματιστικά.

### 4. Client με Υποστήριξη AI

**Αρχείο:** `LangChain4jClient.java`

Αυτός ο client χρησιμοποιεί ένα μοντέλο AI (GPT-4o-mini) που μπορεί να αποφασίσει αυτόματα ποια εργαλεία της αριθμομηχανής να χρησιμοποιήσει:

```java
public class LangChain4jClient {
    
    public static void main(String[] args) throws Exception {
        // Set up the AI model (using GitHub Models)
        ChatLanguageModel model = OpenAiOfficialChatModel.builder()
                .isGitHubModels(true)
                .apiKey(System.getenv("GITHUB_TOKEN"))
                .modelName("gpt-4o-mini")
                .build();

        // Connect to our calculator MCP server
        McpTransport transport = new HttpMcpTransport.Builder()
                .sseUrl("http://localhost:8080/sse")
                .logRequests(true)  // Shows what the AI is doing
                .logResponses(true)
                .build();

        McpClient mcpClient = new DefaultMcpClient.Builder()
                .transport(transport)
                .build();

        // Give the AI access to our calculator tools
        ToolProvider toolProvider = McpToolProvider.builder()
                .mcpClients(List.of(mcpClient))
                .build();

        // Create an AI bot that can use our calculator
        Bot bot = AiServices.builder(Bot.class)
                .chatLanguageModel(model)
                .toolProvider(toolProvider)
                .build();

        // Now we can ask the AI to do calculations in natural language
        String response = bot.chat("Calculate the sum of 24.5 and 17.3 using the calculator service");
        System.out.println(response);

        response = bot.chat("What's the square root of 144?");
        System.out.println(response);
    }
}
```

**Τι κάνει:**
1. **Δημιουργεί** σύνδεση με το μοντέλο AI χρησιμοποιώντας το GitHub token σας
2. **Συνδέει** το AI με τον MCP server της αριθμομηχανής μας
3. **Δίνει** στο AI πρόσβαση σε όλα τα εργαλεία της αριθμομηχανής
4. **Επιτρέπει** αιτήματα σε φυσική γλώσσα όπως "Υπολόγισε το άθροισμα του 24.5 και του 17.3"

**Το AI αυτόματα:**
- Κατανοεί ότι θέλετε να προσθέσετε αριθμούς
- Επιλέγει το εργαλείο `add`
- Καλεί `add(24.5, 17.3)`
- Επιστρέφει το αποτέλεσμα σε φυσική απάντηση

## Εκτέλεση Παραδειγμάτων

### Βήμα 1: Εκκίνηση του Server της Αριθμομηχανής

Πρώτα, ορίστε το GitHub token σας (απαραίτητο για τον client AI):

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

Εκκινήστε τον server:
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

Ο server θα ξεκινήσει στο `http://localhost:8080`. Θα δείτε:
```
Started McpServerApplication in X.XXX seconds
```

### Βήμα 2: Δοκιμή με Άμεσο Client

Σε **ΝΕΟ** τερματικό με τον Server να τρέχει ακόμα, εκτελέστε τον άμεσο MCP client:
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

Θα δείτε έξοδο όπως:
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### Βήμα 3: Δοκιμή με Client AI

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

Θα δείτε το AI να χρησιμοποιεί αυτόματα εργαλεία:
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### Βήμα 4: Κλείσιμο του MCP Server

Όταν τελειώσετε τις δοκιμές, μπορείτε να σταματήσετε τον client AI πατώντας `Ctrl+C` στο τερματικό του. Ο MCP server θα συνεχίσει να τρέχει μέχρι να τον σταματήσετε.
Για να σταματήσετε τον server, πατήστε `Ctrl+C` στο τερματικό όπου τρέχει.

## Πώς Λειτουργούν Όλα Μαζί

Ακολουθεί η πλήρης ροή όταν ρωτάτε το AI "Ποιο είναι το 5 + 3;":

1. **Εσείς** ρωτάτε το AI σε φυσική γλώσσα
2. **Το AI** αναλύει το αίτημά σας και καταλαβαίνει ότι θέλετε πρόσθεση
3. **Το AI** καλεί τον MCP server: `add(5.0, 3.0)`
4. **Η Υπηρεσία Αριθμομηχανής** εκτελεί: `5.0 + 3.0 = 8.0`
5. **Η Υπηρεσία Αριθμομηχανής** επιστρέφει: `"5.00 + 3.00 = 8.00"`
6. **Το AI** λαμβάνει το αποτέλεσμα και το μορφοποιεί σε φυσική απάντηση
7. **Εσείς** λαμβάνετε: "Το άθροισμα του 5 και του 3 είναι 8"

## Επόμενα Βήματα

Για περισσότερα παραδείγματα, δείτε [Κεφάλαιο 04: Πρακτικά παραδείγματα](../README.md)

---

**Αποποίηση ευθύνης**:  
Αυτό το έγγραφο έχει μεταφραστεί χρησιμοποιώντας την υπηρεσία αυτόματης μετάφρασης [Co-op Translator](https://github.com/Azure/co-op-translator). Παρόλο που καταβάλλουμε προσπάθειες για ακρίβεια, παρακαλούμε να έχετε υπόψη ότι οι αυτοματοποιημένες μεταφράσεις ενδέχεται να περιέχουν λάθη ή ανακρίβειες. Το πρωτότυπο έγγραφο στη μητρική του γλώσσα θα πρέπει να θεωρείται η αυθεντική πηγή. Για κρίσιμες πληροφορίες, συνιστάται επαγγελματική ανθρώπινη μετάφραση. Δεν φέρουμε ευθύνη για τυχόν παρεξηγήσεις ή εσφαλμένες ερμηνείες που προκύπτουν από τη χρήση αυτής της μετάφρασης.