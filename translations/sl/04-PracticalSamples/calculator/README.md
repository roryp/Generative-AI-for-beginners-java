# Vadnica za začetnike: MCP kalkulator

## Kazalo

- [Kaj se boste naučili](../../../../04-PracticalSamples/calculator)
- [Predpogoji](../../../../04-PracticalSamples/calculator)
- [Razumevanje strukture projekta](../../../../04-PracticalSamples/calculator)
- [Razlaga ključnih komponent](../../../../04-PracticalSamples/calculator)
  - [1. Glavna aplikacija](../../../../04-PracticalSamples/calculator)
  - [2. Storitev kalkulatorja](../../../../04-PracticalSamples/calculator)
  - [3. Neposredni MCP odjemalec](../../../../04-PracticalSamples/calculator)
  - [4. Odjemalec, ki uporablja AI](../../../../04-PracticalSamples/calculator)
- [Zagon primerov](../../../../04-PracticalSamples/calculator)
- [Kako vse deluje skupaj](../../../../04-PracticalSamples/calculator)
- [Naslednji koraki](../../../../04-PracticalSamples/calculator)

## Kaj se boste naučili

Ta vadnica pojasnjuje, kako zgraditi storitev kalkulatorja z uporabo Model Context Protocol (MCP). Spoznali boste:

- Kako ustvariti storitev, ki jo lahko AI uporablja kot orodje
- Kako vzpostaviti neposredno komunikacijo z MCP storitvami
- Kako AI modeli samodejno izberejo, katera orodja uporabiti
- Razliko med neposrednimi klici protokola in interakcijami, ki jih podpira AI

## Predpogoji

Pred začetkom se prepričajte, da imate:
- Nameščen Java 21 ali novejši
- Maven za upravljanje odvisnosti
- GitHub račun z osebnim dostopnim žetonom (PAT)
- Osnovno razumevanje Jave in Spring Boot

## Razumevanje strukture projekta

Projekt kalkulatorja vsebuje več pomembnih datotek:

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

## Razlaga ključnih komponent

### 1. Glavna aplikacija

**Datoteka:** `McpServerApplication.java`

To je vstopna točka naše storitve kalkulatorja. Gre za standardno Spring Boot aplikacijo z eno posebno funkcijo:

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

**Kaj to počne:**
- Zažene Spring Boot spletni strežnik na vratih 8080
- Ustvari `ToolCallbackProvider`, ki omogoča dostop do metod kalkulatorja kot MCP orodij
- Anotacija `@Bean` pove Springu, naj to upravlja kot komponento, ki jo lahko uporabljajo drugi deli

### 2. Storitev kalkulatorja

**Datoteka:** `CalculatorService.java`

Tu se izvajajo vse matematične operacije. Vsaka metoda je označena z `@Tool`, da je dostopna prek MCP:

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

**Ključne značilnosti:**

1. **Anotacija `@Tool`**: Označuje, da je metoda dostopna zunanjim odjemalcem prek MCP
2. **Jasni opisi**: Vsako orodje ima opis, ki pomaga AI modelom razumeti, kdaj ga uporabiti
3. **Dosleden format vračanja**: Vse operacije vračajo človeško berljive nize, kot je "5.00 + 3.00 = 8.00"
4. **Obravnava napak**: Deljenje z nič in negativne kvadratne korene vračajo sporočila o napaki

**Razpoložljive operacije:**
- `add(a, b)` - Sešteje dve števili
- `subtract(a, b)` - Odšteje drugo število od prvega
- `multiply(a, b)` - Pomnoži dve števili
- `divide(a, b)` - Deli prvo število z drugim (z preverjanjem ničle)
- `power(base, exponent)` - Potencira osnovo z eksponentom
- `squareRoot(number)` - Izračuna kvadratni koren (z negativnim preverjanjem)
- `modulus(a, b)` - Vrne ostanek deljenja
- `absolute(number)` - Vrne absolutno vrednost
- `help()` - Vrne informacije o vseh operacijah

### 3. Neposredni MCP odjemalec

**Datoteka:** `SDKClient.java`

Ta odjemalec neposredno komunicira z MCP strežnikom brez uporabe AI. Ročno kliče specifične funkcije kalkulatorja:

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

**Kaj to počne:**
1. **Poveže se** s strežnikom kalkulatorja na `http://localhost:8080` z uporabo vzorca graditelja
2. **Prikaže** vsa razpoložljiva orodja (funkcije kalkulatorja)
3. **Kliče** specifične funkcije z natančnimi parametri
4. **Neposredno izpiše** rezultate

**Opomba:** Ta primer uporablja odvisnost Spring AI 1.1.0-SNAPSHOT, ki je uvedla vzorec graditelja za `WebFluxSseClientTransport`. Če uporabljate starejšo stabilno različico, boste morda morali uporabiti neposreden konstruktor.

**Kdaj uporabiti:** Ko natančno veste, katero operacijo želite izvesti, in jo želite programatično poklicati.

### 4. Odjemalec, ki uporablja AI

**Datoteka:** `LangChain4jClient.java`

Ta odjemalec uporablja AI model (GPT-4o-mini), ki lahko samodejno odloči, katera orodja kalkulatorja uporabiti:

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

**Kaj to počne:**
1. **Vzpostavi** povezavo z AI modelom z vašim GitHub žetonom
2. **Poveže** AI z našim MCP strežnikom kalkulatorja
3. **Omogoči** AI dostop do vseh orodij kalkulatorja
4. **Dovoli** naravne jezikovne zahteve, kot je "Izračunaj vsoto 24.5 in 17.3"

**AI samodejno:**
- Razume, da želite sešteti števila
- Izbere orodje `add`
- Pokliče `add(24.5, 17.3)`
- Vrne rezultat v naravnem odgovoru

## Zagon primerov

### Korak 1: Zaženite strežnik kalkulatorja

Najprej nastavite svoj GitHub žeton (potreben za AI odjemalca):

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

Zaženite strežnik:
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

Strežnik se bo zagnal na `http://localhost:8080`. Videli boste:
```
Started McpServerApplication in X.XXX seconds
```

### Korak 2: Testirajte z neposrednim odjemalcem

V **NOVEM** terminalu, medtem ko strežnik še vedno deluje, zaženite neposredni MCP odjemalec:
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

Videli boste izpis, kot je:
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### Korak 3: Testirajte z AI odjemalcem

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

Videli boste, da AI samodejno uporablja orodja:
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### Korak 4: Ustavite MCP strežnik

Ko končate testiranje, lahko ustavite AI odjemalca s pritiskom na `Ctrl+C` v njegovem terminalu. MCP strežnik bo deloval, dokler ga ne ustavite.
Za ustavitev strežnika pritisnite `Ctrl+C` v terminalu, kjer deluje.

## Kako vse deluje skupaj

Tukaj je celoten potek, ko AI vprašate "Koliko je 5 + 3?":

1. **Vi** vprašate AI v naravnem jeziku
2. **AI** analizira vašo zahtevo in ugotovi, da želite seštevanje
3. **AI** pokliče MCP strežnik: `add(5.0, 3.0)`
4. **Storitev kalkulatorja** izvede: `5.0 + 3.0 = 8.0`
5. **Storitev kalkulatorja** vrne: `"5.00 + 3.00 = 8.00"`
6. **AI** prejme rezultat in oblikuje naravni odgovor
7. **Vi** dobite: "Vsota 5 in 3 je 8"

## Naslednji koraki

Za več primerov si oglejte [Poglavje 04: Praktični primeri](../README.md)

---

**Omejitev odgovornosti**:  
Ta dokument je bil preveden z uporabo storitve za prevajanje z umetno inteligenco [Co-op Translator](https://github.com/Azure/co-op-translator). Čeprav si prizadevamo za natančnost, vas prosimo, da upoštevate, da lahko avtomatizirani prevodi vsebujejo napake ali netočnosti. Izvirni dokument v njegovem maternem jeziku je treba obravnavati kot avtoritativni vir. Za ključne informacije priporočamo profesionalni človeški prevod. Ne prevzemamo odgovornosti za morebitna nesporazume ali napačne razlage, ki bi nastale zaradi uporabe tega prevoda.