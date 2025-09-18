<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b6c16b5514d524e415a94f6097ee7d4c",
  "translation_date": "2025-09-18T15:38:33+00:00",
  "source_file": "04-PracticalSamples/calculator/README.md",
  "language_code": "hu"
}
-->
# MCP Kalkulátor Útmutató Kezdőknek

## Tartalomjegyzék

- [Mit fogsz megtanulni](../../../../04-PracticalSamples/calculator)
- [Előfeltételek](../../../../04-PracticalSamples/calculator)
- [A projekt struktúrájának megértése](../../../../04-PracticalSamples/calculator)
- [Főbb komponensek magyarázata](../../../../04-PracticalSamples/calculator)
  - [1. Fő alkalmazás](../../../../04-PracticalSamples/calculator)
  - [2. Kalkulátor szolgáltatás](../../../../04-PracticalSamples/calculator)
  - [3. Közvetlen MCP kliens](../../../../04-PracticalSamples/calculator)
  - [4. AI-alapú kliens](../../../../04-PracticalSamples/calculator)
- [Példák futtatása](../../../../04-PracticalSamples/calculator)
- [Hogyan működik együtt minden](../../../../04-PracticalSamples/calculator)
- [Következő lépések](../../../../04-PracticalSamples/calculator)

## Mit fogsz megtanulni

Ez az útmutató bemutatja, hogyan építsünk kalkulátor szolgáltatást a Model Context Protocol (MCP) segítségével. Megérted:

- Hogyan hozz létre egy szolgáltatást, amelyet az AI eszközként használhat
- Hogyan állítsd be a közvetlen kommunikációt MCP szolgáltatásokkal
- Hogyan választhatnak az AI modellek automatikusan eszközöket
- A közvetlen protokollhívások és az AI által segített interakciók közötti különbséget

## Előfeltételek

Mielőtt elkezdenéd, győződj meg róla, hogy rendelkezel az alábbiakkal:
- Telepített Java 21 vagy újabb verzió
- Maven a függőségkezeléshez
- GitHub fiók személyes hozzáférési tokennel (PAT)
- Alapvető Java és Spring Boot ismeretek

## A projekt struktúrájának megértése

A kalkulátor projekt több fontos fájlt tartalmaz:

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

## Főbb komponensek magyarázata

### 1. Fő alkalmazás

**Fájl:** `McpServerApplication.java`

Ez a kalkulátor szolgáltatás belépési pontja. Egy standard Spring Boot alkalmazás, egy különleges kiegészítéssel:

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

**Mit csinál:**
- Elindít egy Spring Boot webkiszolgálót a 8080-as porton
- Létrehoz egy `ToolCallbackProvider`-t, amely elérhetővé teszi a kalkulátor metódusait MCP eszközökként
- Az `@Bean` annotáció jelzi a Spring számára, hogy ezt komponensként kezelje, amelyet más részek használhatnak

### 2. Kalkulátor szolgáltatás

**Fájl:** `CalculatorService.java`

Itt történik minden matematikai művelet. Minden metódus `@Tool` annotációval van ellátva, hogy MCP-n keresztül elérhető legyen:

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

**Főbb jellemzők:**

1. **`@Tool` Annotáció**: Ez jelzi az MCP-nek, hogy a metódus külső kliensek által hívható
2. **Egyértelmű leírások**: Minden eszköz rendelkezik egy leírással, amely segíti az AI modelleket annak megértésében, mikor használják
3. **Konzisztens visszatérési formátum**: Minden művelet ember által olvasható szöveget ad vissza, például "5.00 + 3.00 = 8.00"
4. **Hibakezelés**: Nullával való osztás és negatív négyzetgyök esetén hibaüzeneteket ad vissza

**Elérhető műveletek:**
- `add(a, b)` - Két szám összeadása
- `subtract(a, b)` - Második szám kivonása az elsőből
- `multiply(a, b)` - Két szám szorzása
- `divide(a, b)` - Első szám osztása a másodikkal (nulla ellenőrzéssel)
- `power(base, exponent)` - Alap kitevőre emelése
- `squareRoot(number)` - Négyzetgyök számítása (negatív ellenőrzéssel)
- `modulus(a, b)` - Osztás maradékának visszaadása
- `absolute(number)` - Abszolút érték visszaadása
- `help()` - Információ visszaadása az összes műveletről

### 3. Közvetlen MCP kliens

**Fájl:** `SDKClient.java`

Ez a kliens közvetlenül kommunikál az MCP szerverrel AI használata nélkül. Manuálisan hívja meg a kalkulátor funkcióit:

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

**Mit csinál:**
1. **Kapcsolódik** a kalkulátor szerverhez a `http://localhost:8080` címen a builder mintázat segítségével
2. **Listázza** az összes elérhető eszközt (a kalkulátor funkcióinkat)
3. **Hívja** meg a konkrét funkciókat pontos paraméterekkel
4. **Közvetlenül kiírja** az eredményeket

**Megjegyzés:** Ez a példa a Spring AI 1.1.0-SNAPSHOT függőséget használja, amely bevezette a builder mintázatot a `WebFluxSseClientTransport`-hoz. Ha régebbi stabil verziót használsz, lehet, hogy közvetlen konstruktort kell használnod.

**Mikor használd:** Ha pontosan tudod, milyen számítást szeretnél elvégezni, és programozottan akarod meghívni.

### 4. AI-alapú kliens

**Fájl:** `LangChain4jClient.java`

Ez a kliens egy AI modellt (GPT-4o-mini) használ, amely automatikusan eldönti, mely kalkulátor eszközöket használja:

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

**Mit csinál:**
1. **Létrehoz** egy AI modellkapcsolatot a GitHub tokened segítségével
2. **Kapcsolódik** az AI a kalkulátor MCP szerverhez
3. **Hozzáférést biztosít** az AI-nak az összes kalkulátor eszközhöz
4. **Lehetővé teszi** a természetes nyelvű kéréseket, például "Számold ki 24.5 és 17.3 összegét"

**Az AI automatikusan:**
- Megérti, hogy összeadást szeretnél
- Kiválasztja az `add` eszközt
- Meghívja az `add(24.5, 17.3)` metódust
- Természetes válaszban adja vissza az eredményt

## Példák futtatása

### 1. lépés: Kalkulátor szerver indítása

Először állítsd be a GitHub tokened (szükséges az AI klienshez):

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

Indítsd el a szervert:
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

A szerver elindul a `http://localhost:8080` címen. Ezt kell látnod:
```
Started McpServerApplication in X.XXX seconds
```

### 2. lépés: Tesztelés közvetlen klienssel

Egy **ÚJ** terminálban, miközben a szerver még fut, futtasd a közvetlen MCP klienst:
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

Ezt fogod látni:
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### 3. lépés: Tesztelés AI klienssel

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

Látni fogod, hogy az AI automatikusan használja az eszközöket:
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### 4. lépés: MCP szerver leállítása

Ha befejezted a tesztelést, az AI klienst leállíthatod a `Ctrl+C` megnyomásával a termináljában. Az MCP szerver tovább fut, amíg le nem állítod.
A szerver leállításához nyomd meg a `Ctrl+C`-t abban a terminálban, ahol fut.

## Hogyan működik együtt minden

Így néz ki a teljes folyamat, amikor az AI-tól megkérdezed: "Mennyi 5 + 3?":

1. **Te** természetes nyelven kérdezed az AI-t
2. **AI** elemzi a kérésedet, és rájön, hogy összeadást szeretnél
3. **AI** meghívja az MCP szervert: `add(5.0, 3.0)`
4. **Kalkulátor szolgáltatás** elvégzi: `5.0 + 3.0 = 8.0`
5. **Kalkulátor szolgáltatás** visszaadja: `"5.00 + 3.00 = 8.00"`
6. **AI** megkapja az eredményt, és természetes válaszban formázza
7. **Te** megkapod: "Az 5 és 3 összege 8"

## Következő lépések

További példákért lásd: [4. fejezet: Gyakorlati minták](../README.md)

---

**Felelősség kizárása**:  
Ez a dokumentum az AI fordítási szolgáltatás [Co-op Translator](https://github.com/Azure/co-op-translator) segítségével lett lefordítva. Bár törekszünk a pontosságra, kérjük, vegye figyelembe, hogy az automatikus fordítások hibákat vagy pontatlanságokat tartalmazhatnak. Az eredeti dokumentum az eredeti nyelvén tekintendő hiteles forrásnak. Kritikus információk esetén javasolt professzionális emberi fordítást igénybe venni. Nem vállalunk felelősséget semmilyen félreértésért vagy téves értelmezésért, amely a fordítás használatából eredhet.