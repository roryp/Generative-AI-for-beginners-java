<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "59454ab4ec36d89840df6fcfe7633cbd",
  "translation_date": "2025-07-25T10:42:26+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "ru"
}
-->
# Основные техники генеративного ИИ: учебное пособие

## Содержание

- [Предварительные требования](../../../03-CoreGenerativeAITechniques)
- [Начало работы](../../../03-CoreGenerativeAITechniques)
  - [Шаг 1: Установите переменную окружения](../../../03-CoreGenerativeAITechniques)
  - [Шаг 2: Перейдите в каталог с примерами](../../../03-CoreGenerativeAITechniques)
- [Учебное пособие 1: Завершения и чат с LLM](../../../03-CoreGenerativeAITechniques)
- [Учебное пособие 2: Вызов функций](../../../03-CoreGenerativeAITechniques)
- [Учебное пособие 3: RAG (генерация с дополнением извлечением данных)](../../../03-CoreGenerativeAITechniques)
- [Учебное пособие 4: Ответственный ИИ](../../../03-CoreGenerativeAITechniques)
- [Общие шаблоны в примерах](../../../03-CoreGenerativeAITechniques)
- [Следующие шаги](../../../03-CoreGenerativeAITechniques)
- [Устранение неполадок](../../../03-CoreGenerativeAITechniques)
  - [Распространенные проблемы](../../../03-CoreGenerativeAITechniques)

## Обзор

Это учебное пособие предоставляет практические примеры основных техник генеративного ИИ с использованием Java и GitHub Models. Вы научитесь взаимодействовать с крупными языковыми моделями (LLM), реализовывать вызов функций, использовать генерацию с дополнением извлечением данных (RAG) и применять принципы ответственного ИИ.

## Предварительные требования

Перед началом убедитесь, что у вас есть:
- Установленный Java версии 21 или выше
- Maven для управления зависимостями
- Аккаунт GitHub с персональным токеном доступа (PAT)

## Начало работы

### Шаг 1: Установите переменную окружения

Сначала вам нужно установить токен GitHub как переменную окружения. Этот токен позволяет вам бесплатно использовать GitHub Models.

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

### Шаг 2: Перейдите в каталог с примерами

```bash
cd 03-CoreGenerativeAITechniques/examples/
```

## Учебное пособие 1: Завершения и чат с LLM

**Файл:** `src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

### Чему учит этот пример

Этот пример демонстрирует основные механизмы взаимодействия с крупными языковыми моделями (LLM) через API OpenAI, включая инициализацию клиента с использованием GitHub Models, шаблоны структуры сообщений для системных и пользовательских запросов, управление состоянием беседы через накопление истории сообщений и настройку параметров для контроля длины ответа и уровня креативности.

### Основные концепции кода

#### 1. Настройка клиента
```java
// Create the AI client
OpenAIClient client = new OpenAIClientBuilder()
    .endpoint("https://models.inference.ai.azure.com")
    .credential(new StaticTokenCredential(pat))
    .buildClient();
```

Создает подключение к GitHub Models с использованием вашего токена.

#### 2. Простое завершение
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

#### 3. Память беседы
```java
// Add AI's response to maintain conversation history
messages.add(new ChatRequestAssistantMessage(aiResponse));
messages.add(new ChatRequestUserMessage("Follow-up question"));
```

ИИ запоминает предыдущие сообщения только если вы включаете их в последующие запросы.

### Запуск примера
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
```

### Что происходит при запуске

1. **Простое завершение**: ИИ отвечает на вопрос по Java с помощью системного запроса.
2. **Многократный чат**: ИИ сохраняет контекст между несколькими вопросами.
3. **Интерактивный чат**: Вы можете вести реальный диалог с ИИ.

## Учебное пособие 2: Вызов функций

**Файл:** `src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

### Чему учит этот пример

Вызов функций позволяет моделям ИИ запрашивать выполнение внешних инструментов и API через структурированный протокол, где модель анализирует запросы на естественном языке, определяет необходимые вызовы функций с соответствующими параметрами, используя определения JSON Schema, и обрабатывает возвращенные результаты для генерации контекстуальных ответов, при этом выполнение функций остается под контролем разработчика для обеспечения безопасности и надежности.

### Основные концепции кода

#### 1. Определение функции
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

Сообщает ИИ, какие функции доступны и как их использовать.

#### 2. Поток выполнения функции
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

#### 3. Реализация функции
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

### Запуск примера
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
```

### Что происходит при запуске

1. **Функция погоды**: ИИ запрашивает данные о погоде в Сиэтле, вы предоставляете их, ИИ формирует ответ.
2. **Функция калькулятора**: ИИ запрашивает расчет (15% от 240), вы вычисляете, ИИ объясняет результат.

## Учебное пособие 3: RAG (генерация с дополнением извлечением данных)

**Файл:** `src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

### Чему учит этот пример

Генерация с дополнением извлечением данных (RAG) объединяет извлечение информации с генерацией текста, добавляя контекст из внешних документов в запросы ИИ, что позволяет моделям предоставлять точные ответы на основе конкретных источников знаний, а не потенциально устаревших или неточных данных обучения, при этом сохраняя четкие границы между пользовательскими запросами и авторитетной информацией через стратегическое проектирование запросов.

### Основные концепции кода

#### 1. Загрузка документа
```java
// Load your knowledge source
String doc = Files.readString(Paths.get("document.txt"));
```

#### 2. Введение контекста
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

Тройные кавычки помогают ИИ различать контекст и вопрос.

#### 3. Безопасная обработка ответов
```java
if (response != null && response.getChoices() != null && !response.getChoices().isEmpty()) {
    String answer = response.getChoices().get(0).getMessage().getContent();
    System.out.println("Assistant: " + answer);
} else {
    System.err.println("Error: No response received from the API.");
}
```

Всегда проверяйте ответы API, чтобы избежать сбоев.

### Запуск примера
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
```

### Что происходит при запуске

1. Программа загружает `document.txt` (содержит информацию о GitHub Models).
2. Вы задаете вопрос о документе.
3. ИИ отвечает только на основе содержимого документа, а не общего знания.

Попробуйте спросить: "Что такое GitHub Models?" и "Какая сейчас погода?"

## Учебное пособие 4: Ответственный ИИ

**Файл:** `src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

### Чему учит этот пример

Пример ответственного ИИ демонстрирует важность внедрения мер безопасности в приложения ИИ. Он показывает фильтры безопасности, которые обнаруживают вредоносные категории контента, включая ненавистнические высказывания, домогательства, самоповреждения, сексуальный контент и насилие, демонстрируя, как производственные приложения ИИ должны корректно обрабатывать нарушения политики контента через правильное управление исключениями, механизмы обратной связи с пользователем и стратегии резервных ответов.

### Основные концепции кода

#### 1. Фреймворк тестирования безопасности
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

#### 2. Тестируемые категории безопасности
- Инструкции о насилии/вреде
- Ненавистнические высказывания
- Нарушения конфиденциальности
- Медицинская дезинформация
- Незаконные действия

### Запуск примера
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
```

### Что происходит при запуске

Программа тестирует различные вредоносные запросы и показывает, как система безопасности ИИ:
1. **Блокирует опасные запросы** с ошибками HTTP 400.
2. **Разрешает безопасный контент** генерироваться нормально.
3. **Защищает пользователей** от вредоносных выходных данных ИИ.

## Общие шаблоны в примерах

### Шаблон аутентификации
Все примеры используют этот шаблон для аутентификации с GitHub Models:

```java
String pat = System.getenv("GITHUB_TOKEN");
TokenCredential credential = new StaticTokenCredential(pat);
OpenAIClient client = new OpenAIClientBuilder()
    .endpoint("https://models.inference.ai.azure.com")
    .credential(credential)
    .buildClient();
```

### Шаблон обработки ошибок
```java
try {
    // AI operation
} catch (HttpResponseException e) {
    // Handle API errors (rate limits, safety filters)
} catch (Exception e) {
    // Handle general errors (network, parsing)
}
```

### Шаблон структуры сообщений
```java
List<ChatRequestMessage> messages = List.of(
    new ChatRequestSystemMessage("Set AI behavior"),
    new ChatRequestUserMessage("User's actual request")
);
```

## Следующие шаги

[Глава 04: Практические примеры](../04-PracticalSamples/README.md)

## Устранение неполадок

### Распространенные проблемы

**"GITHUB_TOKEN не установлен"**
- Убедитесь, что вы установили переменную окружения.
- Проверьте, что ваш токен имеет область `models:read`.

**"Нет ответа от API"**
- Проверьте подключение к интернету.
- Убедитесь, что ваш токен действителен.
- Проверьте, не превысили ли вы лимиты запросов.

**Ошибки компиляции Maven**
- Убедитесь, что у вас установлен Java версии 21 или выше.
- Запустите `mvn clean compile`, чтобы обновить зависимости.

**Отказ от ответственности**:  
Этот документ был переведен с использованием сервиса автоматического перевода [Co-op Translator](https://github.com/Azure/co-op-translator). Хотя мы стремимся к точности, пожалуйста, учитывайте, что автоматические переводы могут содержать ошибки или неточности. Оригинальный документ на его родном языке следует считать авторитетным источником. Для получения критически важной информации рекомендуется профессиональный перевод человеком. Мы не несем ответственности за любые недоразумения или неправильные интерпретации, возникающие в результате использования данного перевода.