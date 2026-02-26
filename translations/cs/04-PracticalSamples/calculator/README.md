# Návod na MCP kalkulačku pro začátečníky

## Obsah

- [Co se naučíte](../../../../04-PracticalSamples/calculator)
- [Předpoklady](../../../../04-PracticalSamples/calculator)
- [Porozumění struktuře projektu](../../../../04-PracticalSamples/calculator)
- [Vysvětlení hlavních komponent](../../../../04-PracticalSamples/calculator)
  - [1. Hlavní aplikace](../../../../04-PracticalSamples/calculator)
  - [2. Kalkulační služba](../../../../04-PracticalSamples/calculator)
  - [3. Přímý MCP klient](../../../../04-PracticalSamples/calculator)
  - [4. Klient s podporou AI](../../../../04-PracticalSamples/calculator)
- [Spuštění příkladů](../../../../04-PracticalSamples/calculator)
- [Jak vše spolupracuje](../../../../04-PracticalSamples/calculator)
- [Další kroky](../../../../04-PracticalSamples/calculator)

## Co se naučíte

Tento návod vysvětluje, jak vytvořit kalkulační službu pomocí Model Context Protocol (MCP). Naučíte se:

- Jak vytvořit službu, kterou může AI používat jako nástroj
- Jak nastavit přímou komunikaci s MCP službami
- Jak AI modely automaticky vybírají, které nástroje použít
- Rozdíl mezi přímými voláními protokolu a interakcemi asistovanými AI

## Předpoklady

Než začnete, ujistěte se, že máte:
- Nainstalovaný Java 21 nebo vyšší
- Maven pro správu závislostí
- GitHub účet s osobním přístupovým tokenem (PAT)
- Základní znalosti Java a Spring Boot

## Porozumění struktuře projektu

Projekt kalkulačky obsahuje několik důležitých souborů:

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

## Vysvětlení hlavních komponent

### 1. Hlavní aplikace

**Soubor:** `McpServerApplication.java`

Toto je vstupní bod naší kalkulační služby. Jedná se o standardní Spring Boot aplikaci s jedním speciálním doplňkem:

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

**Co to dělá:**
- Spouští Spring Boot webový server na portu 8080
- Vytváří `ToolCallbackProvider`, který zpřístupňuje naše kalkulační metody jako MCP nástroje
- Anotace `@Bean` říká Springu, aby tento komponent spravoval a umožnil jeho použití v jiných částech

### 2. Kalkulační služba

**Soubor:** `CalculatorService.java`

Zde probíhají všechny matematické operace. Každá metoda je označena anotací `@Tool`, aby byla dostupná přes MCP:

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

**Klíčové vlastnosti:**

1. **Anotace `@Tool`**: Označuje, že tuto metodu mohou volat externí klienti
2. **Jasné popisy**: Každý nástroj má popis, který pomáhá AI modelům pochopit, kdy jej použít
3. **Konzistentní formát návratu**: Všechny operace vrací čitelné řetězce, jako například "5.00 + 3.00 = 8.00"
4. **Zpracování chyb**: Dělení nulou a záporné odmocniny vrací chybové zprávy

**Dostupné operace:**
- `add(a, b)` - Sčítá dvě čísla
- `subtract(a, b)` - Odečítá druhé číslo od prvního
- `multiply(a, b)` - Násobí dvě čísla
- `divide(a, b)` - Dělí první číslo druhým (s kontrolou nulového dělení)
- `power(base, exponent)` - Umocňuje základ na exponent
- `squareRoot(number)` - Vypočítává odmocninu (s kontrolou záporných čísel)
- `modulus(a, b)` - Vrací zbytek po dělení
- `absolute(number)` - Vrací absolutní hodnotu
- `help()` - Vrací informace o všech operacích

### 3. Přímý MCP klient

**Soubor:** `SDKClient.java`

Tento klient komunikuje přímo s MCP serverem bez použití AI. Manuálně volá specifické kalkulační funkce:

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

**Co to dělá:**
1. **Připojuje se** k kalkulačnímu serveru na `http://localhost:8080` pomocí builder patternu
2. **Vypisuje** všechny dostupné nástroje (naše kalkulační funkce)
3. **Volá** specifické funkce s přesnými parametry
4. **Přímo vypisuje** výsledky

**Poznámka:** Tento příklad používá Spring AI 1.1.0-SNAPSHOT závislost, která zavedla builder pattern pro `WebFluxSseClientTransport`. Pokud používáte starší stabilní verzi, možná budete muset použít přímý konstruktor.

**Kdy použít:** Když přesně víte, jaký výpočet chcete provést, a chcete jej volat programově.

### 4. Klient s podporou AI

**Soubor:** `LangChain4jClient.java`

Tento klient používá AI model (GPT-4o-mini), který automaticky rozhoduje, které kalkulační nástroje použít:

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

**Co to dělá:**
1. **Vytváří** připojení k AI modelu pomocí vašeho GitHub tokenu
2. **Připojuje** AI k našemu MCP kalkulačnímu serveru
3. **Dává** AI přístup ke všem našim kalkulačním nástrojům
4. **Umožňuje** požadavky v přirozeném jazyce, jako například "Spočítej součet 24.5 a 17.3"

**AI automaticky:**
- Pochopí, že chcete sčítat čísla
- Vybere nástroj `add`
- Zavolá `add(24.5, 17.3)`
- Vrátí výsledek v přirozené odpovědi

## Spuštění příkladů

### Krok 1: Spusťte kalkulační server

Nejprve nastavte svůj GitHub token (potřebný pro AI klienta):

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

Spusťte server:
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

Server se spustí na `http://localhost:8080`. Měli byste vidět:
```
Started McpServerApplication in X.XXX seconds
```

### Krok 2: Testování s přímým klientem

V **NOVÉM** terminálu, zatímco server stále běží, spusťte přímý MCP klient:
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

Uvidíte výstup jako:
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### Krok 3: Testování s AI klientem

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

Uvidíte, jak AI automaticky používá nástroje:
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### Krok 4: Ukončení MCP serveru

Až dokončíte testování, můžete zastavit AI klient stisknutím `Ctrl+C` v jeho terminálu. MCP server bude běžet, dokud jej nezastavíte.
Pro zastavení serveru stiskněte `Ctrl+C` v terminálu, kde běží.

## Jak vše spolupracuje

Zde je kompletní tok, když se zeptáte AI "Kolik je 5 + 3?":

1. **Vy** se zeptáte AI v přirozeném jazyce
2. **AI** analyzuje váš požadavek a zjistí, že chcete sčítání
3. **AI** zavolá MCP server: `add(5.0, 3.0)`
4. **Kalkulační služba** provede: `5.0 + 3.0 = 8.0`
5. **Kalkulační služba** vrátí: `"5.00 + 3.00 = 8.00"`
6. **AI** obdrží výsledek a formátuje přirozenou odpověď
7. **Vy** dostanete: "Součet 5 a 3 je 8"

## Další kroky

Pro více příkladů viz [Kapitola 04: Praktické ukázky](../README.md)

---

**Prohlášení**:  
Tento dokument byl přeložen pomocí služby pro automatický překlad [Co-op Translator](https://github.com/Azure/co-op-translator). Ačkoli se snažíme o přesnost, mějte prosím na paměti, že automatické překlady mohou obsahovat chyby nebo nepřesnosti. Původní dokument v jeho původním jazyce by měl být považován za autoritativní zdroj. Pro důležité informace doporučujeme profesionální lidský překlad. Neodpovídáme za žádná nedorozumění nebo nesprávné interpretace vyplývající z použití tohoto překladu.