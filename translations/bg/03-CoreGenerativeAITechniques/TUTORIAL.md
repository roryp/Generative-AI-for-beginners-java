<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "59454ab4ec36d89840df6fcfe7633cbd",
  "translation_date": "2025-07-21T20:46:08+00:00",
  "source_file": "03-CoreGenerativeAITechniques/TUTORIAL.md",
  "language_code": "bg"
}
-->
# Основни техники за генериращ ИИ - Урок

## Съдържание

- [Предварителни изисквания](../../../03-CoreGenerativeAITechniques)
- [Начало](../../../03-CoreGenerativeAITechniques)
  - [Стъпка 1: Настройте променлива на средата](../../../03-CoreGenerativeAITechniques)
  - [Стъпка 2: Навигирайте до директорията с примери](../../../03-CoreGenerativeAITechniques)
- [Урок 1: Завършвания и чат с LLM](../../../03-CoreGenerativeAITechniques)
- [Урок 2: Извикване на функции](../../../03-CoreGenerativeAITechniques)
- [Урок 3: RAG (Генериране с подсилено извличане)](../../../03-CoreGenerativeAITechniques)
- [Урок 4: Отговорен ИИ](../../../03-CoreGenerativeAITechniques)
- [Общи модели в примерите](../../../03-CoreGenerativeAITechniques)
- [Следващи стъпки](../../../03-CoreGenerativeAITechniques)
- [Отстраняване на проблеми](../../../03-CoreGenerativeAITechniques)
  - [Чести проблеми](../../../03-CoreGenerativeAITechniques)

## Преглед

Този урок предоставя практически примери за основни техники за генериращ ИИ, използвайки Java и GitHub Models. Ще научите как да взаимодействате с големи езикови модели (LLMs), да прилагате извикване на функции, да използвате генериране с подсилено извличане (RAG) и да прилагате практики за отговорен ИИ.

## Предварителни изисквания

Преди да започнете, уверете се, че разполагате с:
- Инсталиран Java 21 или по-нов
- Maven за управление на зависимости
- GitHub акаунт с личен достъп токен (PAT)

## Начало

### Стъпка 1: Настройте променлива на средата

Първо, трябва да зададете вашия GitHub токен като променлива на средата. Този токен ви позволява да използвате GitHub Models безплатно.

**Windows (Command Prompt):**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Windows (PowerShell):**
```powershell
$env:GITHUB_TOKEN="your_github_token_here"
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

### Стъпка 2: Навигирайте до директорията с примери

```bash
cd 03-CoreGenerativeAITechniques/examples/
```

## Урок 1: Завършвания и чат с LLM

**Файл:** `src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

### Какво ще научите от този пример

Този пример демонстрира основните механизми за взаимодействие с големи езикови модели (LLM) чрез OpenAI API, включително инициализация на клиент с GitHub Models, модели на структура на съобщения за системни и потребителски подканвания, управление на състоянието на разговора чрез натрупване на история на съобщенията и настройка на параметри за контрол на дължината на отговорите и нивата на креативност.

### Основни концепции в кода

#### 1. Настройка на клиента
```java
// Create the AI client
OpenAIClient client = new OpenAIClientBuilder()
    .endpoint("https://models.inference.ai.azure.com")
    .credential(new StaticTokenCredential(pat))
    .buildClient();
```

Това създава връзка с GitHub Models, използвайки вашия токен.

#### 2. Просто завършване
```java
List<ChatRequestMessage> messages = List.of(
    // System message sets AI behavior
    new ChatRequestSystemMessage("You are a helpful Java expert."),
    // User message contains the actual question
    new ChatRequestUserMessage("Explain Java streams briefly.")
);

ChatCompletionsOptions options = new ChatCompletionsOptions(messages)
    .setModel("gpt-4o-mini")
    .setMaxTokens(200)      // Limit response length
    .setTemperature(0.7);   // Control creativity (0.0-1.0)
```

#### 3. Памет на разговора
```java
// Add AI's response to maintain conversation history
messages.add(new ChatRequestAssistantMessage(aiResponse));
messages.add(new ChatRequestUserMessage("Follow-up question"));
```

ИИ запомня предишни съобщения само ако ги включите в следващите заявки.

### Стартиране на примера
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
```

### Какво се случва при стартиране

1. **Просто завършване**: ИИ отговаря на въпрос за Java с помощта на системно подканване.
2. **Многократен чат**: ИИ поддържа контекст през няколко въпроса.
3. **Интерактивен чат**: Можете да проведете реален разговор с ИИ.

## Урок 2: Извикване на функции

**Файл:** `src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

### Какво ще научите от този пример

Извикването на функции позволява на ИИ моделите да заявяват изпълнение на външни инструменти и API чрез структуриран протокол, при който моделът анализира заявки на естествен език, определя необходимите извиквания на функции с подходящи параметри, използвайки JSON Schema дефиниции, и обработва върнатите резултати, за да генерира контекстуални отговори, докато реалното изпълнение на функциите остава под контрола на разработчика за сигурност и надеждност.

### Основни концепции в кода

#### 1. Дефиниция на функция
```java
ChatCompletionsFunctionToolDefinitionFunction weatherFunction = 
    new ChatCompletionsFunctionToolDefinitionFunction("get_weather");
weatherFunction.setDescription("Get current weather information for a city");

// Define parameters using JSON Schema
weatherFunction.setParameters(BinaryData.fromString("""
    {
        "type": "object",
        "properties": {
            "city": {
                "type": "string",
                "description": "The city name"
            }
        },
        "required": ["city"]
    }
    """));
```

Това казва на ИИ какви функции са налични и как да ги използва.

#### 2. Поток на изпълнение на функция
```java
// 1. AI requests a function call
if (choice.getFinishReason() == CompletionsFinishReason.TOOL_CALLS) {
    ChatCompletionsFunctionToolCall functionCall = ...;
    
    // 2. You execute the function
    String result = simulateWeatherFunction(functionCall.getFunction().getArguments());
    
    // 3. You give the result back to AI
    messages.add(new ChatRequestToolMessage(result, toolCall.getId()));
    
    // 4. AI provides final response with function result
    ChatCompletions finalResponse = client.getChatCompletions(MODEL, options);
}
```

#### 3. Имплементация на функция
```java
private static String simulateWeatherFunction(String arguments) {
    // Parse arguments and call real weather API
    // For demo, we return mock data
    return """
        {
            "city": "Seattle",
            "temperature": "22",
            "condition": "partly cloudy"
        }
        """;
}
```

### Стартиране на примера
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
```

### Какво се случва при стартиране

1. **Функция за времето**: ИИ заявява данни за времето в Сиатъл, вие ги предоставяте, ИИ форматира отговор.
2. **Функция за калкулатор**: ИИ заявява изчисление (15% от 240), вие го изчислявате, ИИ обяснява резултата.

## Урок 3: RAG (Генериране с подсилено извличане)

**Файл:** `src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

### Какво ще научите от този пример

Генерирането с подсилено извличане (RAG) комбинира извличане на информация с езиково генериране, като вмъква контекст от външни документи в подканванията на ИИ. Това позволява на моделите да предоставят точни отговори, базирани на конкретни източници на знания, вместо на потенциално остарели или неточни тренировъчни данни, като същевременно поддържат ясни граници между потребителските въпроси и авторитетните източници на информация чрез стратегическо инженерство на подканванията.

### Основни концепции в кода

#### 1. Зареждане на документи
```java
// Load your knowledge source
String doc = Files.readString(Paths.get("document.txt"));
```

#### 2. Вмъкване на контекст
```java
List<ChatRequestMessage> messages = List.of(
    new ChatRequestSystemMessage(
        "Use only the CONTEXT to answer. If not in context, say you cannot find it."
    ),
    new ChatRequestUserMessage(
        "CONTEXT:\n\"\"\"\n" + doc + "\n\"\"\"\n\nQUESTION:\n" + question
    )
);
```

Тройните кавички помагат на ИИ да различи контекста от въпроса.

#### 3. Безопасно обработване на отговори
```java
if (response != null && response.getChoices() != null && !response.getChoices().isEmpty()) {
    String answer = response.getChoices().get(0).getMessage().getContent();
    System.out.println("Assistant: " + answer);
} else {
    System.err.println("Error: No response received from the API.");
}
```

Винаги валидирайте отговорите от API, за да предотвратите сривове.

### Стартиране на примера
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
```

### Какво се случва при стартиране

1. Програмата зарежда `document.txt` (съдържа информация за GitHub Models).
2. Задавате въпрос за документа.
3. ИИ отговаря само въз основа на съдържанието на документа, а не на общите си знания.

Опитайте да попитате: "Какво представляват GitHub Models?" срещу "Какво е времето?"

## Урок 4: Отговорен ИИ

**Файл:** `src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

### Какво ще научите от този пример

Примерът за отговорен ИИ подчертава важността на прилагането на мерки за безопасност в ИИ приложенията. Демонстрира филтри за безопасност, които откриват категории вредно съдържание, включително реч на омразата, тормоз, самонараняване, сексуално съдържание и насилие, показвайки как производствените ИИ приложения трябва да се справят с нарушения на политиката за съдържание чрез подходящо обработване на изключения, механизми за обратна връзка от потребителите и стратегии за резервни отговори.

### Основни концепции в кода

#### 1. Рамка за тестване на безопасност
```java
private void testPromptSafety(String prompt, String category) {
    try {
        // Attempt to get AI response
        ChatCompletions response = client.getChatCompletions(modelId, options);
        System.out.println("Response generated (content appears safe)");
        
    } catch (HttpResponseException e) {
        if (e.getResponse().getStatusCode() == 400) {
            System.out.println("[BLOCKED BY SAFETY FILTER]");
            System.out.println("This is GOOD - safety system working!");
        }
    }
}
```

#### 2. Тествани категории за безопасност
- Инструкции за насилие/вреда
- Реч на омразата
- Нарушения на поверителността
- Медицинска дезинформация
- Незаконни дейности

### Стартиране на примера
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
```

### Какво се случва при стартиране

Програмата тества различни вредни подканвания и показва как системата за безопасност на ИИ:
1. **Блокира опасни заявки** с грешки HTTP 400.
2. **Позволява безопасно съдържание** да се генерира нормално.
3. **Защитава потребителите** от вредни изходи на ИИ.

## Общи модели в примерите

### Модел за удостоверяване
Всички примери използват този модел за удостоверяване с GitHub Models:

```java
String pat = System.getenv("GITHUB_TOKEN");
TokenCredential credential = new StaticTokenCredential(pat);
OpenAIClient client = new OpenAIClientBuilder()
    .endpoint("https://models.inference.ai.azure.com")
    .credential(credential)
    .buildClient();
```

### Модел за обработка на грешки
```java
try {
    // AI operation
} catch (HttpResponseException e) {
    // Handle API errors (rate limits, safety filters)
} catch (Exception e) {
    // Handle general errors (network, parsing)
}
```

### Модел за структура на съобщения
```java
List<ChatRequestMessage> messages = List.of(
    new ChatRequestSystemMessage("Set AI behavior"),
    new ChatRequestUserMessage("User's actual request")
);
```

## Следващи стъпки

[Глава 04: Практически примери](../04-PracticalSamples/README.md)

## Отстраняване на проблеми

### Чести проблеми

**"GITHUB_TOKEN не е зададен"**
- Уверете се, че сте задали променливата на средата.
- Проверете дали токенът ви има обхват `models:read`.

**"Няма отговор от API"**
- Проверете интернет връзката си.
- Уверете се, че токенът ви е валиден.
- Проверете дали сте достигнали лимитите за заявки.

**Грешки при компилация с Maven**
- Уверете се, че използвате Java 21 или по-нов.
- Стартирайте `mvn clean compile`, за да обновите зависимостите.

**Отказ от отговорност**:  
Този документ е преведен с помощта на AI услуга за превод [Co-op Translator](https://github.com/Azure/co-op-translator). Въпреки че се стремим към точност, моля, имайте предвид, че автоматизираните преводи може да съдържат грешки или неточности. Оригиналният документ на неговия роден език трябва да се счита за авторитетен източник. За критична информация се препоръчва професионален човешки превод. Ние не носим отговорност за недоразумения или погрешни интерпретации, произтичащи от използването на този превод.