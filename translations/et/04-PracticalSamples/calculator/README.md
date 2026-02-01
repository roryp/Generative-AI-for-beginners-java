# MCP Kalkulaatori Õpetus Algajatele

## Sisukord

- [Mida Sa Õpid](../../../../04-PracticalSamples/calculator)
- [Eeltingimused](../../../../04-PracticalSamples/calculator)
- [Projekti Struktuuri Mõistmine](../../../../04-PracticalSamples/calculator)
- [Põhikomponentide Selgitus](../../../../04-PracticalSamples/calculator)
  - [1. Peamine Rakendus](../../../../04-PracticalSamples/calculator)
  - [2. Kalkulaatori Teenus](../../../../04-PracticalSamples/calculator)
  - [3. Otsene MCP Klient](../../../../04-PracticalSamples/calculator)
  - [4. AI-põhine Klient](../../../../04-PracticalSamples/calculator)
- [Näidete Käivitamine](../../../../04-PracticalSamples/calculator)
- [Kuidas Kõik Koos Töötab](../../../../04-PracticalSamples/calculator)
- [Järgmised Sammud](../../../../04-PracticalSamples/calculator)

## Mida Sa Õpid

See õpetus selgitab, kuidas luua kalkulaatori teenust, kasutades Model Context Protocol (MCP). Sa saad aru:

- Kuidas luua teenust, mida AI saab tööriistana kasutada
- Kuidas seadistada otsesuhtlust MCP teenustega
- Kuidas AI mudelid saavad automaatselt valida, milliseid tööriistu kasutada
- Erinevust otseste protokollikõnede ja AI-põhiste interaktsioonide vahel

## Eeltingimused

Enne alustamist veendu, et sul on:
- Paigaldatud Java 21 või uuem
- Maven sõltuvuste haldamiseks
- GitHubi konto koos isikliku juurdepääsutokeniga (PAT)
- Põhilised teadmised Java ja Spring Boot kohta

## Projekti Struktuuri Mõistmine

Kalkulaatori projekt sisaldab mitmeid olulisi faile:

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

## Põhikomponentide Selgitus

### 1. Peamine Rakendus

**Fail:** `McpServerApplication.java`

See on meie kalkulaatori teenuse alguspunkt. Tegemist on standardse Spring Boot rakendusega, millel on üks eriline lisand:

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

**Mida see teeb:**
- Käivitab Spring Boot veebiserveri pordil 8080
- Loob `ToolCallbackProvider`-i, mis teeb meie kalkulaatori meetodid MCP tööriistadena kättesaadavaks
- `@Bean` annotatsioon ütleb Springile, et see komponenti hallatakse ja teised osad saavad seda kasutada

### 2. Kalkulaatori Teenus

**Fail:** `CalculatorService.java`

Siin toimub kogu matemaatika. Iga meetod on märgistatud `@Tool`-iga, et see oleks MCP kaudu kättesaadav:

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

**Peamised omadused:**

1. **`@Tool` Annotatsioon**: See ütleb MCP-le, et seda meetodit saavad välised kliendid kutsuda
2. **Selged Kirjeldused**: Igal tööriistal on kirjeldus, mis aitab AI mudelitel mõista, millal seda kasutada
3. **Ühtlane Tagastusvorming**: Kõik operatsioonid tagastavad inimloetavaid stringe nagu "5.00 + 3.00 = 8.00"
4. **Vigade Käitlemine**: Nulliga jagamine ja negatiivsete arvude ruutjuured tagastavad veateateid

**Saadaval Operatsioonid:**
- `add(a, b)` - Liidab kaks arvu
- `subtract(a, b)` - Lahutab teise esimese arvust
- `multiply(a, b)` - Korrutab kaks arvu
- `divide(a, b)` - Jagab esimese teisega (nulli kontrolliga)
- `power(base, exponent)` - Tõstab baasi eksponendi astmesse
- `squareRoot(number)` - Arvutab ruutjuure (negatiivse kontrolliga)
- `modulus(a, b)` - Tagastab jagamise jäägi
- `absolute(number)` - Tagastab absoluutväärtuse
- `help()` - Tagastab teavet kõigi operatsioonide kohta

### 3. Otsene MCP Klient

**Fail:** `SDKClient.java`

See klient suhtleb otse MCP serveriga, kasutamata AI-d. See kutsub käsitsi konkreetseid kalkulaatori funktsioone:

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

**Mida see teeb:**
1. **Ühendub** kalkulaatori serveriga aadressil `http://localhost:8080`, kasutades builder mustrit
2. **Loetleb** kõik saadaval olevad tööriistad (meie kalkulaatori funktsioonid)
3. **Kutsub** konkreetseid funktsioone täpsete parameetritega
4. **Prindib** tulemused otse

**Märkus:** See näide kasutab Spring AI 1.1.0-SNAPSHOT sõltuvust, mis tutvustas builder mustrit `WebFluxSseClientTransport` jaoks. Kui kasutad vanemat stabiilset versiooni, võib olla vajalik kasutada otsest konstruktorit.

**Millal seda kasutada:** Kui tead täpselt, millist arvutust soovid teha ja tahad seda programmiliselt kutsuda.

### 4. AI-põhine Klient

**Fail:** `LangChain4jClient.java`

See klient kasutab AI mudelit (GPT-4o-mini), mis suudab automaatselt otsustada, milliseid kalkulaatori tööriistu kasutada:

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

**Mida see teeb:**
1. **Loob** AI mudeli ühenduse, kasutades sinu GitHubi tokenit
2. **Ühendab** AI meie kalkulaatori MCP serveriga
3. **Annab** AI-le juurdepääsu kõigile meie kalkulaatori tööriistadele
4. **Võimaldab** loomuliku keele päringuid nagu "Arvuta 24.5 ja 17.3 summa"

**AI automaatselt:**
- Mõistab, et soovid arve liita
- Valib `add` tööriista
- Kutsub `add(24.5, 17.3)`
- Tagastab tulemuse loomulikus vastuses

## Näidete Käivitamine

### Samm 1: Käivita Kalkulaatori Server

Kõigepealt seadista oma GitHubi token (vajalik AI kliendi jaoks):

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

Käivita server:
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

Server käivitub aadressil `http://localhost:8080`. Sa peaksid nägema:
```
Started McpServerApplication in X.XXX seconds
```

### Samm 2: Testi Otsese Kliendiga

**UUES** terminalis, kus server endiselt töötab, käivita otsene MCP klient:
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

Sa näed väljundit nagu:
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### Samm 3: Testi AI Kliendiga

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

Sa näed, kuidas AI automaatselt tööriistu kasutab:
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### Samm 4: Sulge MCP Server

Kui testimine on lõpetatud, saad AI kliendi sulgeda, vajutades `Ctrl+C` selle terminalis. MCP server jääb tööle, kuni sa selle peatad.
Serveri peatamiseks vajuta `Ctrl+C` terminalis, kus see töötab.

## Kuidas Kõik Koos Töötab

Siin on täielik voog, kui küsid AI-lt "Mis on 5 + 3?":

1. **Sina** küsid AI-lt loomulikus keeles
2. **AI** analüüsib sinu päringut ja mõistab, et soovid liitmist
3. **AI** kutsub MCP serverit: `add(5.0, 3.0)`
4. **Kalkulaatori Teenus** sooritab: `5.0 + 3.0 = 8.0`
5. **Kalkulaatori Teenus** tagastab: `"5.00 + 3.00 = 8.00"`
6. **AI** saab tulemuse ja vormindab loomuliku vastuse
7. **Sina** saad: "5 ja 3 summa on 8"

## Järgmised Sammud

Rohkem näiteid leiad [Peatükist 04: Praktilised näited](../README.md)

---

**Lahtiütlus**:  
See dokument on tõlgitud AI tõlketeenuse [Co-op Translator](https://github.com/Azure/co-op-translator) abil. Kuigi püüame tagada täpsust, palume arvestada, et automaatsed tõlked võivad sisaldada vigu või ebatäpsusi. Algne dokument selle algses keeles tuleks pidada autoriteetseks allikaks. Olulise teabe puhul soovitame kasutada professionaalset inimtõlget. Me ei vastuta selle tõlke kasutamisest tulenevate arusaamatuste või valesti tõlgenduste eest.