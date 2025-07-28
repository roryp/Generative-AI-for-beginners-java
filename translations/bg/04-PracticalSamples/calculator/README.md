<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "82ea3c5a1b9d4bf4f1e2d906649e874e",
  "translation_date": "2025-07-28T11:38:56+00:00",
  "source_file": "04-PracticalSamples/calculator/README.md",
  "language_code": "bg"
}
-->
# Урок за MCP калкулатор за начинаещи

## Съдържание

- [Какво ще научите](../../../../04-PracticalSamples/calculator)
- [Предварителни изисквания](../../../../04-PracticalSamples/calculator)
- [Разбиране на структурата на проекта](../../../../04-PracticalSamples/calculator)
- [Обяснение на основните компоненти](../../../../04-PracticalSamples/calculator)
  - [1. Основно приложение](../../../../04-PracticalSamples/calculator)
  - [2. Услуга за калкулатор](../../../../04-PracticalSamples/calculator)
  - [3. Директен MCP клиент](../../../../04-PracticalSamples/calculator)
  - [4. Клиент с AI](../../../../04-PracticalSamples/calculator)
- [Стартиране на примерите](../../../../04-PracticalSamples/calculator)
- [Как всичко работи заедно](../../../../04-PracticalSamples/calculator)
- [Следващи стъпки](../../../../04-PracticalSamples/calculator)

## Какво ще научите

Този урок обяснява как да изградите услуга за калкулатор, използвайки Model Context Protocol (MCP). Ще разберете:

- Как да създадете услуга, която AI може да използва като инструмент
- Как да настроите директна комуникация с MCP услуги
- Как AI моделите автоматично избират кои инструменти да използват
- Разликата между директни протоколни извиквания и взаимодействия, подпомогнати от AI

## Предварителни изисквания

Преди да започнете, уверете се, че имате:
- Инсталиран Java 21 или по-нов
- Maven за управление на зависимости
- GitHub акаунт с персонален достъп токен (PAT)
- Основни познания по Java и Spring Boot

## Разбиране на структурата на проекта

Проектът за калкулатор има няколко важни файла:

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

## Обяснение на основните компоненти

### 1. Основно приложение

**Файл:** `McpServerApplication.java`

Това е началната точка на нашата услуга за калкулатор. Това е стандартно Spring Boot приложение с една специална добавка:

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

**Какво прави:**
- Стартира Spring Boot уеб сървър на порт 8080
- Създава `ToolCallbackProvider`, който прави методите на калкулатора достъпни като MCP инструменти
- Анотацията `@Bean` казва на Spring да управлява това като компонент, който другите части могат да използват

### 2. Услуга за калкулатор

**Файл:** `CalculatorService.java`

Тук се извършват всички математически операции. Всеки метод е маркиран с `@Tool`, за да бъде достъпен чрез MCP:

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

**Основни характеристики:**

1. **Анотация `@Tool`**: Това казва на MCP, че този метод може да бъде извикан от външни клиенти
2. **Ясни описания**: Всеки инструмент има описание, което помага на AI моделите да разберат кога да го използват
3. **Последователен формат на връщане**: Всички операции връщат четими за човека низове като "5.00 + 3.00 = 8.00"
4. **Обработка на грешки**: Деление на нула и отрицателни квадратни корени връщат съобщения за грешка

**Достъпни операции:**
- `add(a, b)` - Събира две числа
- `subtract(a, b)` - Изважда второто от първото
- `multiply(a, b)` - Умножава две числа
- `divide(a, b)` - Деление на първото с второто (с проверка за нула)
- `power(base, exponent)` - Повдига основата на степен
- `squareRoot(number)` - Изчислява квадратен корен (с проверка за отрицателни числа)
- `modulus(a, b)` - Връща остатъка от делението
- `absolute(number)` - Връща абсолютната стойност
- `help()` - Връща информация за всички операции

### 3. Директен MCP клиент

**Файл:** `SDKClient.java`

Този клиент комуникира директно със сървъра MCP, без да използва AI. Ръчно извиква специфични функции на калкулатора:

```java
public class SDKClient {
    
    public static void main(String[] args) {
        var transport = new WebFluxSseClientTransport(
            WebClient.builder().baseUrl("http://localhost:8080")
        );
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

**Какво прави:**
1. **Свързва се** със сървъра на калкулатора на `http://localhost:8080`
2. **Изброява** всички достъпни инструменти (функциите на калкулатора)
3. **Извиква** специфични функции с точни параметри
4. **Принтира** резултатите директно

**Кога да го използвате:** Когато знаете точно коя операция искате да извършите и искате да я извикате програмно.

### 4. Клиент с AI

**Файл:** `LangChain4jClient.java`

Този клиент използва AI модел (GPT-4o-mini), който може автоматично да реши кои инструменти на калкулатора да използва:

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

**Какво прави:**
1. **Създава** връзка с AI модел, използвайки вашия GitHub токен
2. **Свързва** AI с нашия MCP сървър за калкулатор
3. **Дава** на AI достъп до всички инструменти на калкулатора
4. **Позволява** заявки на естествен език като "Изчисли сумата на 24.5 и 17.3"

**AI автоматично:**
- Разбира, че искате да съберете числа
- Избира инструмента `add`
- Извиква `add(24.5, 17.3)`
- Връща резултата в естествен отговор

## Стартиране на примерите

### Стъпка 1: Стартирайте сървъра на калкулатора

Първо, задайте вашия GitHub токен (необходим за AI клиента):

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

Стартирайте сървъра:
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

Сървърът ще стартира на `http://localhost:8080`. Трябва да видите:
```
Started McpServerApplication in X.XXX seconds
```

### Стъпка 2: Тествайте с директен клиент

В **НОВ** терминал, докато сървърът все още работи, стартирайте директния MCP клиент:
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

Ще видите изход като:
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### Стъпка 3: Тествайте с AI клиент

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

Ще видите как AI автоматично използва инструменти:
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### Стъпка 4: Затворете MCP сървъра

Когато приключите с тестването, можете да спрете AI клиента, като натиснете `Ctrl+C` в неговия терминал. MCP сървърът ще продължи да работи, докато не го спрете.
За да спрете сървъра, натиснете `Ctrl+C` в терминала, където той работи.

## Как всичко работи заедно

Ето пълния процес, когато попитате AI "Колко е 5 + 3?":

1. **Вие** питате AI на естествен език
2. **AI** анализира вашата заявка и разбира, че искате събиране
3. **AI** извиква MCP сървъра: `add(5.0, 3.0)`
4. **Услугата за калкулатор** извършва: `5.0 + 3.0 = 8.0`
5. **Услугата за калкулатор** връща: `"5.00 + 3.00 = 8.00"`
6. **AI** получава резултата и го форматира в естествен отговор
7. **Вие** получавате: "Сумата на 5 и 3 е 8"

## Следващи стъпки

За повече примери, вижте [Глава 04: Практически примери](../README.md)

**Отказ от отговорност**:  
Този документ е преведен с помощта на AI услуга за превод [Co-op Translator](https://github.com/Azure/co-op-translator). Въпреки че се стремим към точност, моля, имайте предвид, че автоматизираните преводи може да съдържат грешки или неточности. Оригиналният документ на неговия роден език трябва да се счита за авторитетен източник. За критична информация се препоръчва професионален човешки превод. Не носим отговорност за недоразумения или погрешни интерпретации, произтичащи от използването на този превод.