# Návod na MCP kalkulačku pre začiatočníkov

## Obsah

- [Čo sa naučíte](../../../../04-PracticalSamples/calculator)
- [Predpoklady](../../../../04-PracticalSamples/calculator)
- [Pochopenie štruktúry projektu](../../../../04-PracticalSamples/calculator)
- [Vysvetlenie hlavných komponentov](../../../../04-PracticalSamples/calculator)
  - [1. Hlavná aplikácia](../../../../04-PracticalSamples/calculator)
  - [2. Služba kalkulačky](../../../../04-PracticalSamples/calculator)
  - [3. Priamy MCP klient](../../../../04-PracticalSamples/calculator)
  - [4. Klient s podporou AI](../../../../04-PracticalSamples/calculator)
- [Spustenie príkladov](../../../../04-PracticalSamples/calculator)
- [Ako to všetko spolu funguje](../../../../04-PracticalSamples/calculator)
- [Ďalšie kroky](../../../../04-PracticalSamples/calculator)

## Čo sa naučíte

Tento návod vysvetľuje, ako vytvoriť službu kalkulačky pomocou Model Context Protocol (MCP). Naučíte sa:

- Ako vytvoriť službu, ktorú môže AI používať ako nástroj
- Ako nastaviť priamu komunikáciu s MCP službami
- Ako môžu AI modely automaticky vyberať, ktoré nástroje použiť
- Rozdiel medzi priamymi volaniami protokolu a interakciami podporovanými AI

## Predpoklady

Pred začiatkom sa uistite, že máte:
- Nainštalovaný Java 21 alebo vyšší
- Maven na správu závislostí
- GitHub účet s osobným prístupovým tokenom (PAT)
- Základné znalosti Java a Spring Boot

## Pochopenie štruktúry projektu

Projekt kalkulačky obsahuje niekoľko dôležitých súborov:

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

## Vysvetlenie hlavných komponentov

### 1. Hlavná aplikácia

**Súbor:** `McpServerApplication.java`

Toto je vstupný bod našej služby kalkulačky. Ide o štandardnú Spring Boot aplikáciu s jednou špeciálnou prídavnou funkciou:

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

**Čo to robí:**
- Spustí Spring Boot webový server na porte 8080
- Vytvorí `ToolCallbackProvider`, ktorý sprístupní naše metódy kalkulačky ako MCP nástroje
- Anotácia `@Bean` hovorí Springu, aby to spravoval ako komponent, ktorý môžu používať iné časti

### 2. Služba kalkulačky

**Súbor:** `CalculatorService.java`

Tu sa vykonávajú všetky matematické operácie. Každá metóda je označená anotáciou `@Tool`, aby bola dostupná cez MCP:

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

**Kľúčové vlastnosti:**

1. **Anotácia `@Tool`**: Označuje MCP, že túto metódu môžu volať externí klienti
2. **Jasné popisy**: Každý nástroj má popis, ktorý pomáha AI modelom pochopiť, kedy ho použiť
3. **Konzistentný formát návratu**: Všetky operácie vracajú čitateľné reťazce ako "5.00 + 3.00 = 8.00"
4. **Spracovanie chýb**: Delenie nulou a záporné odmocniny vracajú chybové hlásenia

**Dostupné operácie:**
- `add(a, b)` - Sčítanie dvoch čísel
- `subtract(a, b)` - Odčítanie druhého čísla od prvého
- `multiply(a, b)` - Násobenie dvoch čísel
- `divide(a, b)` - Delenie prvého čísla druhým (s kontrolou nulového delenia)
- `power(base, exponent)` - Umocnenie základu na exponent
- `squareRoot(number)` - Výpočet odmocniny (s kontrolou záporných čísel)
- `modulus(a, b)` - Zvyšok po delení
- `absolute(number)` - Absolútna hodnota
- `help()` - Informácie o všetkých operáciách

### 3. Priamy MCP klient

**Súbor:** `SDKClient.java`

Tento klient komunikuje priamo s MCP serverom bez použitia AI. Manuálne volá konkrétne funkcie kalkulačky:

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

**Čo to robí:**
1. **Pripojí sa** k serveru kalkulačky na `http://localhost:8080` pomocou builder patternu
2. **Zobrazí** všetky dostupné nástroje (naše funkcie kalkulačky)
3. **Volá** konkrétne funkcie s presnými parametrami
4. **Vypíše** výsledky priamo

**Poznámka:** Tento príklad používa Spring AI 1.1.0-SNAPSHOT závislosť, ktorá zaviedla builder pattern pre `WebFluxSseClientTransport`. Ak používate staršiu stabilnú verziu, možno budete musieť použiť priamy konštruktor.

**Kedy to použiť:** Keď presne viete, aký výpočet chcete vykonať a chcete ho zavolať programovo.

### 4. Klient s podporou AI

**Súbor:** `LangChain4jClient.java`

Tento klient používa AI model (GPT-4o-mini), ktorý dokáže automaticky rozhodnúť, ktoré nástroje kalkulačky použiť:

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

**Čo to robí:**
1. **Vytvorí** pripojenie k AI modelu pomocou vášho GitHub tokenu
2. **Pripojí** AI k nášmu MCP serveru kalkulačky
3. **Sprístupní** AI všetky naše nástroje kalkulačky
4. **Umožní** prirodzené jazykové požiadavky ako "Vypočítaj súčet 24.5 a 17.3"

**AI automaticky:**
- Pochopí, že chcete sčítať čísla
- Vyberie nástroj `add`
- Zavolá `add(24.5, 17.3)`
- Vráti výsledok v prirodzenej odpovedi

## Spustenie príkladov

### Krok 1: Spustite server kalkulačky

Najprv nastavte váš GitHub token (potrebný pre AI klienta):

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

Spustite server:
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

Server sa spustí na `http://localhost:8080`. Mali by ste vidieť:
```
Started McpServerApplication in X.XXX seconds
```

### Krok 2: Testovanie s priamym klientom

V **NOVOM** termináli, pričom server stále beží, spustite priameho MCP klienta:
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

Uvidíte výstup ako:
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### Krok 3: Testovanie s AI klientom

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

Uvidíte, ako AI automaticky používa nástroje:
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### Krok 4: Zatvorenie MCP servera

Keď skončíte testovanie, môžete zastaviť AI klienta stlačením `Ctrl+C` v jeho termináli. MCP server bude bežať, kým ho nezastavíte.
Na zastavenie servera stlačte `Ctrl+C` v termináli, kde beží.

## Ako to všetko spolu funguje

Tu je kompletný proces, keď sa opýtate AI "Aký je súčet 5 + 3?":

1. **Vy** sa opýtate AI v prirodzenom jazyku
2. **AI** analyzuje vašu požiadavku a zistí, že chcete sčítať
3. **AI** zavolá MCP server: `add(5.0, 3.0)`
4. **Služba kalkulačky** vykoná: `5.0 + 3.0 = 8.0`
5. **Služba kalkulačky** vráti: `"5.00 + 3.00 = 8.00"`
6. **AI** prijme výsledok a naformátuje prirodzenú odpoveď
7. **Vy** dostanete: "Súčet 5 a 3 je 8"

## Ďalšie kroky

Pre viac príkladov si pozrite [Kapitolu 04: Praktické ukážky](../README.md)

---

**Upozornenie**:  
Tento dokument bol preložený pomocou služby AI prekladu [Co-op Translator](https://github.com/Azure/co-op-translator). Hoci sa snažíme o presnosť, prosím, berte na vedomie, že automatizované preklady môžu obsahovať chyby alebo nepresnosti. Pôvodný dokument v jeho rodnom jazyku by mal byť považovaný za autoritatívny zdroj. Pre kritické informácie sa odporúča profesionálny ľudský preklad. Nie sme zodpovední za akékoľvek nedorozumenia alebo nesprávne interpretácie vyplývajúce z použitia tohto prekladu.