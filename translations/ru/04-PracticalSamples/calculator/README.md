# Учебник по MCP-калькулятору для начинающих

## Содержание

- [Чему вы научитесь](../../../../04-PracticalSamples/calculator)
- [Предварительные требования](../../../../04-PracticalSamples/calculator)
- [Понимание структуры проекта](../../../../04-PracticalSamples/calculator)
- [Объяснение основных компонентов](../../../../04-PracticalSamples/calculator)
  - [1. Основное приложение](../../../../04-PracticalSamples/calculator)
  - [2. Сервис калькулятора](../../../../04-PracticalSamples/calculator)
  - [3. Клиент MCP с прямым доступом](../../../../04-PracticalSamples/calculator)
  - [4. Клиент с поддержкой ИИ](../../../../04-PracticalSamples/calculator)
- [Запуск примеров](../../../../04-PracticalSamples/calculator)
- [Как все работает вместе](../../../../04-PracticalSamples/calculator)
- [Следующие шаги](../../../../04-PracticalSamples/calculator)

## Чему вы научитесь

Этот учебник объясняет, как создать сервис калькулятора с использованием Model Context Protocol (MCP). Вы узнаете:

- Как создать сервис, который ИИ может использовать как инструмент
- Как настроить прямую связь с MCP-сервисами
- Как модели ИИ автоматически выбирают, какие инструменты использовать
- Разницу между прямыми вызовами протокола и взаимодействиями с поддержкой ИИ

## Предварительные требования

Перед началом убедитесь, что у вас есть:
- Установленный Java 21 или выше
- Maven для управления зависимостями
- Аккаунт на GitHub с персональным токеном доступа (PAT)
- Базовые знания Java и Spring Boot

## Понимание структуры проекта

Проект калькулятора содержит несколько важных файлов:

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

## Объяснение основных компонентов

### 1. Основное приложение

**Файл:** `McpServerApplication.java`

Это точка входа для нашего сервиса калькулятора. Это стандартное приложение Spring Boot с одним особым дополнением:

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

**Что это делает:**
- Запускает веб-сервер Spring Boot на порту 8080
- Создает `ToolCallbackProvider`, который делает методы калькулятора доступными как инструменты MCP
- Аннотация `@Bean` указывает Spring управлять этим компонентом, чтобы другие части могли его использовать

### 2. Сервис калькулятора

**Файл:** `CalculatorService.java`

Здесь выполняются все математические операции. Каждый метод помечен аннотацией `@Tool`, чтобы сделать его доступным через MCP:

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

**Основные особенности:**

1. **Аннотация `@Tool`**: Указывает MCP, что этот метод может быть вызван внешними клиентами
2. **Четкие описания**: Каждый инструмент имеет описание, которое помогает моделям ИИ понять, когда его использовать
3. **Единый формат возврата**: Все операции возвращают читаемые строки, например, "5.00 + 3.00 = 8.00"
4. **Обработка ошибок**: Деление на ноль и отрицательные квадратные корни возвращают сообщения об ошибках

**Доступные операции:**
- `add(a, b)` - Сложение двух чисел
- `subtract(a, b)` - Вычитание второго числа из первого
- `multiply(a, b)` - Умножение двух чисел
- `divide(a, b)` - Деление первого числа на второе (с проверкой на ноль)
- `power(base, exponent)` - Возведение числа в степень
- `squareRoot(number)` - Вычисление квадратного корня (с проверкой на отрицательные значения)
- `modulus(a, b)` - Остаток от деления
- `absolute(number)` - Абсолютное значение
- `help()` - Информация обо всех операциях

### 3. Клиент MCP с прямым доступом

**Файл:** `SDKClient.java`

Этот клиент напрямую взаимодействует с MCP-сервером, не используя ИИ. Он вручную вызывает конкретные функции калькулятора:

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

**Что это делает:**
1. **Подключается** к серверу калькулятора по адресу `http://localhost:8080`, используя паттерн builder
2. **Список** всех доступных инструментов (функций калькулятора)
3. **Вызов** конкретных функций с точными параметрами
4. **Вывод** результатов напрямую

**Примечание:** В примере используется зависимость Spring AI 1.1.0-SNAPSHOT, которая ввела паттерн builder для `WebFluxSseClientTransport`. Если вы используете более старую стабильную версию, возможно, потребуется использовать прямой конструктор.

**Когда использовать:** Когда вы точно знаете, какую операцию хотите выполнить, и хотите вызвать ее программно.

### 4. Клиент с поддержкой ИИ

**Файл:** `LangChain4jClient.java`

Этот клиент использует модель ИИ (GPT-4o-mini), которая может автоматически выбирать, какие инструменты калькулятора использовать:

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

**Что это делает:**
1. **Создает** подключение к модели ИИ, используя ваш GitHub-токен
2. **Подключает** ИИ к нашему MCP-серверу калькулятора
3. **Предоставляет** ИИ доступ ко всем инструментам калькулятора
4. **Позволяет** выполнять запросы на естественном языке, например, "Вычисли сумму 24.5 и 17.3"

**ИИ автоматически:**
- Понимает, что нужно сложить числа
- Выбирает инструмент `add`
- Вызывает `add(24.5, 17.3)`
- Возвращает результат в естественном ответе

## Запуск примеров

### Шаг 1: Запустите сервер калькулятора

Сначала установите GitHub-токен (необходим для клиента ИИ):

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

Запустите сервер:
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

Сервер запустится по адресу `http://localhost:8080`. Вы должны увидеть:
```
Started McpServerApplication in X.XXX seconds
```

### Шаг 2: Тестирование с прямым клиентом

В **НОВОМ** терминале, пока сервер все еще работает, запустите клиент MCP с прямым доступом:
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

Вы увидите вывод, похожий на:
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### Шаг 3: Тестирование с клиентом ИИ

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

Вы увидите, как ИИ автоматически использует инструменты:
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### Шаг 4: Остановите MCP-сервер

Когда вы закончите тестирование, вы можете остановить клиент ИИ, нажав `Ctrl+C` в его терминале. MCP-сервер будет работать до тех пор, пока вы его не остановите. Чтобы остановить сервер, нажмите `Ctrl+C` в терминале, где он запущен.

## Как все работает вместе

Вот полный процесс, когда вы спрашиваете ИИ: "Сколько будет 5 + 3?":

1. **Вы** задаете вопрос ИИ на естественном языке
2. **ИИ** анализирует ваш запрос и понимает, что нужно сложить числа
3. **ИИ** вызывает MCP-сервер: `add(5.0, 3.0)`
4. **Сервис калькулятора** выполняет: `5.0 + 3.0 = 8.0`
5. **Сервис калькулятора** возвращает: `"5.00 + 3.00 = 8.00"`
6. **ИИ** получает результат и формирует естественный ответ
7. **Вы** получаете: "Сумма 5 и 3 равна 8"

## Следующие шаги

Для получения дополнительных примеров смотрите [Глава 04: Практические примеры](../README.md)

---

**Отказ от ответственности**:  
Этот документ был переведен с помощью сервиса автоматического перевода [Co-op Translator](https://github.com/Azure/co-op-translator). Несмотря на наши усилия обеспечить точность, автоматические переводы могут содержать ошибки или неточности. Оригинальный документ на его родном языке следует считать авторитетным источником. Для получения критически важной информации рекомендуется профессиональный перевод человеком. Мы не несем ответственности за любые недоразумения или неправильные интерпретации, возникающие в результате использования данного перевода.