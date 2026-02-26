# MCP skaičiuoklės pamoka pradedantiesiems

## Turinys

- [Ką išmoksite](../../../../04-PracticalSamples/calculator)
- [Reikalavimai](../../../../04-PracticalSamples/calculator)
- [Projekto struktūros supratimas](../../../../04-PracticalSamples/calculator)
- [Pagrindinių komponentų paaiškinimas](../../../../04-PracticalSamples/calculator)
  - [1. Pagrindinė aplikacija](../../../../04-PracticalSamples/calculator)
  - [2. Skaičiuoklės paslauga](../../../../04-PracticalSamples/calculator)
  - [3. Tiesioginis MCP klientas](../../../../04-PracticalSamples/calculator)
  - [4. AI valdomas klientas](../../../../04-PracticalSamples/calculator)
- [Pavyzdžių paleidimas](../../../../04-PracticalSamples/calculator)
- [Kaip viskas veikia kartu](../../../../04-PracticalSamples/calculator)
- [Kiti žingsniai](../../../../04-PracticalSamples/calculator)

## Ką išmoksite

Ši pamoka paaiškina, kaip sukurti skaičiuoklės paslaugą naudojant Model Context Protocol (MCP). Suprasite:

- Kaip sukurti paslaugą, kurią AI gali naudoti kaip įrankį
- Kaip nustatyti tiesioginį ryšį su MCP paslaugomis
- Kaip AI modeliai automatiškai pasirenka, kokius įrankius naudoti
- Skirtumą tarp tiesioginių protokolo užklausų ir AI valdomų sąveikų

## Reikalavimai

Prieš pradėdami, įsitikinkite, kad turite:
- Įdiegtą Java 21 ar naujesnę versiją
- Maven priklausomybių valdymui
- GitHub paskyrą su asmeniniu prieigos raktu (PAT)
- Pagrindines Java ir Spring Boot žinias

## Projekto struktūros supratimas

Skaičiuoklės projektas turi kelis svarbius failus:

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

## Pagrindinių komponentų paaiškinimas

### 1. Pagrindinė aplikacija

**Failas:** `McpServerApplication.java`

Tai yra mūsų skaičiuoklės paslaugos pradžios taškas. Tai standartinė Spring Boot aplikacija su viena ypatinga funkcija:

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

**Ką tai daro:**
- Paleidžia Spring Boot žiniatinklio serverį 8080 prievade
- Sukuria `ToolCallbackProvider`, kuris leidžia mūsų skaičiuoklės metodus naudoti kaip MCP įrankius
- `@Bean` anotacija nurodo Spring valdyti šį komponentą, kad jį galėtų naudoti kitos dalys

### 2. Skaičiuoklės paslauga

**Failas:** `CalculatorService.java`

Čia vyksta visi skaičiavimai. Kiekvienas metodas pažymėtas `@Tool`, kad būtų prieinamas per MCP:

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

**Pagrindinės savybės:**

1. **`@Tool` anotacija**: Nurodo MCP, kad šį metodą gali iškviesti išoriniai klientai
2. **Aiškūs aprašymai**: Kiekvienas įrankis turi aprašymą, kuris padeda AI modeliams suprasti, kada jį naudoti
3. **Nuoseklus grąžinimo formatas**: Visi veiksmai grąžina lengvai suprantamus tekstus, pvz., "5.00 + 3.00 = 8.00"
4. **Klaidų tvarkymas**: Dalijimas iš nulio ir neigiamos kvadratinės šaknys grąžina klaidų pranešimus

**Galimi veiksmai:**
- `add(a, b)` - Sudeda du skaičius
- `subtract(a, b)` - Atima antrą iš pirmo
- `multiply(a, b)` - Padaugina du skaičius
- `divide(a, b)` - Padalija pirmą iš antro (su nulio patikra)
- `power(base, exponent)` - Pakelia pagrindą laipsniu
- `squareRoot(number)` - Apskaičiuoja kvadratinę šaknį (su neigiamų skaičių patikra)
- `modulus(a, b)` - Grąžina dalybos likutį
- `absolute(number)` - Grąžina absoliučią vertę
- `help()` - Grąžina informaciją apie visus veiksmus

### 3. Tiesioginis MCP klientas

**Failas:** `SDKClient.java`

Šis klientas tiesiogiai bendrauja su MCP serveriu, nenaudodamas AI. Jis rankiniu būdu iškviečia konkrečias skaičiuoklės funkcijas:

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

**Ką tai daro:**
1. **Prisijungia** prie skaičiuoklės serverio adresu `http://localhost:8080` naudodamas kūrimo modelį
2. **Išvardija** visus galimus įrankius (mūsų skaičiuoklės funkcijas)
3. **Iškviečia** konkrečias funkcijas su tiksliais parametrais
4. **Atspausdina** rezultatus tiesiogiai

**Pastaba:** Šiame pavyzdyje naudojama Spring AI 1.1.0-SNAPSHOT priklausomybė, kuri įdiegė kūrimo modelį `WebFluxSseClientTransport`. Jei naudojate senesnę stabilios versijos versiją, gali tekti naudoti tiesioginį konstruktorių.

**Kada naudoti:** Kai tiksliai žinote, kokį skaičiavimą norite atlikti, ir norite jį iškviesti programiškai.

### 4. AI valdomas klientas

**Failas:** `LangChain4jClient.java`

Šis klientas naudoja AI modelį (GPT-4o-mini), kuris automatiškai nusprendžia, kokius skaičiuoklės įrankius naudoti:

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

**Ką tai daro:**
1. **Sukuria** AI modelio ryšį naudojant jūsų GitHub raktą
2. **Prisijungia** AI prie mūsų skaičiuoklės MCP serverio
3. **Suteikia** AI prieigą prie visų mūsų skaičiuoklės įrankių
4. **Leidžia** natūralios kalbos užklausas, pvz., "Apskaičiuok 24.5 ir 17.3 sumą"

**AI automatiškai:**
- Supranta, kad norite sudėti skaičius
- Pasirenka `add` įrankį
- Iškviečia `add(24.5, 17.3)`
- Grąžina rezultatą natūraliu atsakymu

## Pavyzdžių paleidimas

### 1 žingsnis: Paleiskite skaičiuoklės serverį

Pirmiausia nustatykite savo GitHub raktą (reikalingą AI klientui):

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

Paleiskite serverį:
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

Serveris bus paleistas adresu `http://localhost:8080`. Turėtumėte matyti:
```
Started McpServerApplication in X.XXX seconds
```

### 2 žingsnis: Testuokite su tiesioginiu klientu

Atidarykite **NAUJĄ** terminalą, kol serveris vis dar veikia, ir paleiskite tiesioginį MCP klientą:
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

Pamatysite išvestį, panašią į:
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### 3 žingsnis: Testuokite su AI klientu

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

Pamatysite, kaip AI automatiškai naudoja įrankius:
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### 4 žingsnis: Uždarykite MCP serverį

Kai baigsite testavimą, galite sustabdyti AI klientą paspausdami `Ctrl+C` jo terminale. MCP serveris veiks tol, kol jį sustabdysite.
Norėdami sustabdyti serverį, paspauskite `Ctrl+C` terminale, kuriame jis veikia.

## Kaip viskas veikia kartu

Štai visas procesas, kai paprašote AI "Kiek yra 5 + 3?":

1. **Jūs** paprašote AI natūralia kalba
2. **AI** analizuoja jūsų užklausą ir supranta, kad norite sudėti
3. **AI** iškviečia MCP serverį: `add(5.0, 3.0)`
4. **Skaičiuoklės paslauga** atlieka: `5.0 + 3.0 = 8.0`
5. **Skaičiuoklės paslauga** grąžina: `"5.00 + 3.00 = 8.00"`
6. **AI** gauna rezultatą ir suformuoja natūralų atsakymą
7. **Jūs** gaunate: "5 ir 3 suma yra 8"

## Kiti žingsniai

Daugiau pavyzdžių rasite [4 skyriuje: Praktiniai pavyzdžiai](../README.md)

---

**Atsakomybės apribojimas**:  
Šis dokumentas buvo išverstas naudojant AI vertimo paslaugą [Co-op Translator](https://github.com/Azure/co-op-translator). Nors siekiame tikslumo, prašome atkreipti dėmesį, kad automatiniai vertimai gali turėti klaidų ar netikslumų. Originalus dokumentas jo gimtąja kalba turėtų būti laikomas autoritetingu šaltiniu. Dėl svarbios informacijos rekomenduojama profesionali žmogaus vertimo paslauga. Mes neprisiimame atsakomybės už nesusipratimus ar klaidingus interpretavimus, atsiradusius naudojant šį vertimą.