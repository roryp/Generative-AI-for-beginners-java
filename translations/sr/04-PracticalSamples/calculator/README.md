<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b6c16b5514d524e415a94f6097ee7d4c",
  "translation_date": "2025-09-18T15:41:05+00:00",
  "source_file": "04-PracticalSamples/calculator/README.md",
  "language_code": "sr"
}
-->
# Упутство за MCP калкулатор за почетнике

## Садржај

- [Шта ћете научити](../../../../04-PracticalSamples/calculator)
- [Предуслови](../../../../04-PracticalSamples/calculator)
- [Разумевање структуре пројекта](../../../../04-PracticalSamples/calculator)
- [Објашњење основних компоненти](../../../../04-PracticalSamples/calculator)
  - [1. Главна апликација](../../../../04-PracticalSamples/calculator)
  - [2. Сервис калкулатора](../../../../04-PracticalSamples/calculator)
  - [3. Директни MCP клијент](../../../../04-PracticalSamples/calculator)
  - [4. Клијент заснован на вештачкој интелигенцији](../../../../04-PracticalSamples/calculator)
- [Покретање примера](../../../../04-PracticalSamples/calculator)
- [Како све функционише заједно](../../../../04-PracticalSamples/calculator)
- [Следећи кораци](../../../../04-PracticalSamples/calculator)

## Шта ћете научити

Ово упутство објашњава како да направите сервис калкулатора користећи Model Context Protocol (MCP). Разумећете:

- Како да направите сервис који вештачка интелигенција може да користи као алат
- Како да успоставите директну комуникацију са MCP сервисима
- Како модели вештачке интелигенције могу аутоматски да бирају које алате да користе
- Разлику између директних позива протокола и интеракција уз помоћ вештачке интелигенције

## Предуслови

Пре него што почнете, уверите се да имате:
- Инсталиран Java 21 или новији
- Maven за управљање зависностима
- GitHub налог са персоналним приступним токеном (PAT)
- Основно разумевање Java и Spring Boot-а

## Разумевање структуре пројекта

Пројекат калкулатора садржи неколико важних датотека:

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

## Објашњење основних компоненти

### 1. Главна апликација

**Датотека:** `McpServerApplication.java`

Ово је почетна тачка нашег сервиса калкулатора. То је стандардна Spring Boot апликација са једним посебним додатком:

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

**Шта ово ради:**
- Покреће Spring Boot веб сервер на порту 8080
- Креира `ToolCallbackProvider` који омогућава нашим методама калкулатора да буду доступне као MCP алати
- Анотација `@Bean` говори Spring-у да управља овим као компонентом коју други делови могу да користе

### 2. Сервис калкулатора

**Датотека:** `CalculatorService.java`

Овде се обављају све математичке операције. Сваки метод је означен са `@Tool` како би био доступан преко MCP:

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

**Кључне карактеристике:**

1. **Анотација `@Tool`**: Ово MCP-у говори да овај метод може да позивају спољни клијенти
2. **Јасни описи**: Сваки алат има опис који помаже моделима вештачке интелигенције да разумеју када да га користе
3. **Конзистентан формат повратка**: Све операције враћају читљиве стрингове као што је "5.00 + 3.00 = 8.00"
4. **Обрада грешака**: Дељење са нулом и негативни квадратни корени враћају поруке о грешци

**Доступне операције:**
- `add(a, b)` - Сабира два броја
- `subtract(a, b)` - Одузима други број од првог
- `multiply(a, b)` - Множи два броја
- `divide(a, b)` - Делити први број другим (са провером нуле)
- `power(base, exponent)` - Подиже базу на степен експонента
- `squareRoot(number)` - Израчунава квадратни корен (са провером негативних вредности)
- `modulus(a, b)` - Враћа остатак дељења
- `absolute(number)` - Враћа апсолутну вредност
- `help()` - Враћа информације о свим операцијама

### 3. Директни MCP клијент

**Датотека:** `SDKClient.java`

Овај клијент директно комуницира са MCP сервером без коришћења вештачке интелигенције. Ручно позива одређене функције калкулатора:

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

**Шта ово ради:**
1. **Повезује се** са сервером калкулатора на `http://localhost:8080` користећи builder pattern
2. **Листира** све доступне алате (функције нашег калкулатора)
3. **Позива** одређене функције са тачним параметрима
4. **Штампа** резултате директно

**Напомена:** Овај пример користи Spring AI 1.1.0-SNAPSHOT зависност, која је увела builder pattern за `WebFluxSseClientTransport`. Ако користите старију стабилну верзију, можда ћете морати да користите директан конструктор.

**Када користити ово:** Када тачно знате коју операцију желите да извршите и желите да је позовете програмски.

### 4. Клијент заснован на вештачкој интелигенцији

**Датотека:** `LangChain4jClient.java`

Овај клијент користи модел вештачке интелигенције (GPT-4o-mini) који може аутоматски да одлучи које алате калкулатора да користи:

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

**Шта ово ради:**
1. **Креира** везу са моделом вештачке интелигенције користећи ваш GitHub токен
2. **Повезује** вештачку интелигенцију са нашим MCP сервером калкулатора
3. **Омогућава** вештачкој интелигенцији приступ свим алатима нашег калкулатора
4. **Дозвољава** захтеве на природном језику као што је "Израчунај збир 24.5 и 17.3"

**Вештачка интелигенција аутоматски:**
- Разуме да желите да саберете бројеве
- Бира алат `add`
- Позива `add(24.5, 17.3)`
- Враћа резултат у природном одговору

## Покретање примера

### Корак 1: Покрените сервер калкулатора

Прво, подесите ваш GitHub токен (потребан за клијент заснован на вештачкој интелигенцији):

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

Покрените сервер:
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

Сервер ће се покренути на `http://localhost:8080`. Требало би да видите:
```
Started McpServerApplication in X.XXX seconds
```

### Корак 2: Тестирајте са директним клијентом

У **НОВОМ** терминалу док сервер још увек ради, покрените директни MCP клијент:
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

Видећете излаз као:
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### Корак 3: Тестирајте са клијентом заснованим на вештачкој интелигенцији

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

Видећете како вештачка интелигенција аутоматски користи алате:
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### Корак 4: Затворите MCP сервер

Када завршите тестирање, можете зауставити клијент заснован на вештачкој интелигенцији притиском на `Ctrl+C` у његовом терминалу. MCP сервер ће наставити да ради док га не зауставите.
Да бисте зауставили сервер, притисните `Ctrl+C` у терминалу где је покренут.

## Како све функционише заједно

Ево комплетног тока када питате вештачку интелигенцију "Колико је 5 + 3?":

1. **Ви** питате вештачку интелигенцију на природном језику
2. **Вештачка интелигенција** анализира ваш захтев и схвата да желите сабирање
3. **Вештачка интелигенција** позива MCP сервер: `add(5.0, 3.0)`
4. **Сервис калкулатора** извршава: `5.0 + 3.0 = 8.0`
5. **Сервис калкулатора** враћа: `"5.00 + 3.00 = 8.00"`
6. **Вештачка интелигенција** прима резултат и форматира природан одговор
7. **Ви** добијате: "Збир 5 и 3 је 8"

## Следећи кораци

За више примера, погледајте [Поглавље 04: Практични примери](../README.md)

---

**Одрицање од одговорности**:  
Овај документ је преведен помоћу услуге за превођење уз помоћ вештачке интелигенције [Co-op Translator](https://github.com/Azure/co-op-translator). Иако се трудимо да превод буде тачан, молимо вас да имате у виду да аутоматизовани преводи могу садржати грешке или нетачности. Оригинални документ на његовом изворном језику треба сматрати меродавним извором. За критичне информације препоручује се професионални превод од стране људи. Не преузимамо одговорност за било каква погрешна тумачења или неспоразуме који могу настати услед коришћења овог превода.