<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "59454ab4ec36d89840df6fcfe7633cbd",
  "translation_date": "2025-07-25T12:00:09+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "sr"
}
-->
# Основне технике генеративне вештачке интелигенције - Туторијал

## Садржај

- [Предуслови](../../../03-CoreGenerativeAITechniques)
- [Почетак](../../../03-CoreGenerativeAITechniques)
  - [Корак 1: Поставите променљиву окружења](../../../03-CoreGenerativeAITechniques)
  - [Корак 2: Пређите у директоријум са примерима](../../../03-CoreGenerativeAITechniques)
- [Туторијал 1: Завршетак и разговор са LLM](../../../03-CoreGenerativeAITechniques)
- [Туторијал 2: Позивање функција](../../../03-CoreGenerativeAITechniques)
- [Туторијал 3: RAG (Генерација уз помоћ претраживања)](../../../03-CoreGenerativeAITechniques)
- [Туторијал 4: Одговорна вештачка интелигенција](../../../03-CoreGenerativeAITechniques)
- [Заједнички обрасци у примерима](../../../03-CoreGenerativeAITechniques)
- [Следећи кораци](../../../03-CoreGenerativeAITechniques)
- [Решавање проблема](../../../03-CoreGenerativeAITechniques)
  - [Уобичајени проблеми](../../../03-CoreGenerativeAITechniques)

## Преглед

Овај туторијал пружа практичне примере основних техника генеративне вештачке интелигенције користећи Java и GitHub моделе. Научићете како да комуницирате са великим језичким моделима (LLM), имплементирате позивање функција, користите генерацију уз помоћ претраживања (RAG) и примените праксе одговорне вештачке интелигенције.

## Предуслови

Пре него што почнете, уверите се да имате:
- Инсталирану Java 21 или новију верзију
- Maven за управљање зависностима
- GitHub налог са личним приступним токеном (PAT)

## Почетак

### Корак 1: Поставите променљиву окружења

Прво, потребно је да поставите свој GitHub токен као променљиву окружења. Овај токен вам омогућава приступ GitHub моделима бесплатно.

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

### Корак 2: Пређите у директоријум са примерима

```bash
cd 03-CoreGenerativeAITechniques/examples/
```

## Туторијал 1: Завршетак и разговор са LLM

**Фајл:** `src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

### Шта овај пример учи

Овај пример демонстрира основне механизме интеракције са великим језичким моделима (LLM) преко OpenAI API-ја, укључујући иницијализацију клијента са GitHub моделима, обрасце структуре порука за системске и корисничке упите, управљање стањем разговора кроз акумулацију историје порука и подешавање параметара за контролу дужине одговора и нивоа креативности.

### Кључни концепти кода

#### 1. Постављање клијента
```java
// Create the AI client
OpenAIClient client = new OpenAIClientBuilder()
    .endpoint("https://models.inference.ai.azure.com")
    .credential(new StaticTokenCredential(pat))
    .buildClient();
```

Ово креира везу са GitHub моделима користећи ваш токен.

#### 2. Једноставан завршетак
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

#### 3. Меморија разговора
```java
// Add AI's response to maintain conversation history
messages.add(new ChatRequestAssistantMessage(aiResponse));
messages.add(new ChatRequestUserMessage("Follow-up question"));
```

Вештачка интелигенција памти претходне поруке само ако их укључите у наредне захтеве.

### Покрените пример
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
```

### Шта се дешава када га покренете

1. **Једноставан завршетак**: Вештачка интелигенција одговара на питање о Java уз смернице системског упита
2. **Разговор у више корака**: Вештачка интелигенција одржава контекст кроз више питања
3. **Интерактивни разговор**: Можете водити прави разговор са вештачком интелигенцијом

## Туторијал 2: Позивање функција

**Фајл:** `src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

### Шта овај пример учи

Позивање функција омогућава моделима вештачке интелигенције да затраже извршење спољашњих алата и API-ја кроз структуриран протокол где модел анализира захтеве на природном језику, одређује потребне позиве функција са одговарајућим параметрима користећи JSON Schema дефиниције и обрађује добијене резултате за генерисање контекстуалних одговора, док стварно извршење функција остаје под контролом програмера ради безбедности и поузданости.

### Кључни концепти кода

#### 1. Дефиниција функције
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

Ово говори вештачкој интелигенцији које функције су доступне и како да их користи.

#### 2. Ток извршења функције
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

#### 3. Имплементација функције
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

### Покрените пример
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
```

### Шта се дешава када га покренете

1. **Функција за временску прогнозу**: Вештачка интелигенција тражи податке о времену за Сијетл, ви их обезбеђујете, а вештачка интелигенција форматира одговор
2. **Функција калкулатора**: Вештачка интелигенција тражи израчунавање (15% од 240), ви га извршавате, а вештачка интелигенција објашњава резултат

## Туторијал 3: RAG (Генерација уз помоћ претраживања)

**Фајл:** `src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

### Шта овај пример учи

Генерација уз помоћ претраживања (RAG) комбинује претраживање информација са језичком генерацијом убацивањем контекста из спољашњих докумената у упите вештачке интелигенције, омогућавајући моделима да пруже тачне одговоре засноване на специфичним изворима знања, а не на потенцијално застарелим или нетачним подацима из обуке, уз јасно разграничење између корисничких упита и ауторитативних извора информација кроз стратешко инжењерство упита.

### Кључни концепти кода

#### 1. Учитавање докумената
```java
// Load your knowledge source
String doc = Files.readString(Paths.get("document.txt"));
```

#### 2. Убацивање контекста
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

Троструки наводници помажу вештачкој интелигенцији да разликује контекст од питања.

#### 3. Безбедно руковање одговорима
```java
if (response != null && response.getChoices() != null && !response.getChoices().isEmpty()) {
    String answer = response.getChoices().get(0).getMessage().getContent();
    System.out.println("Assistant: " + answer);
} else {
    System.err.println("Error: No response received from the API.");
}
```

Увек валидирајте одговоре API-ја како бисте спречили пад система.

### Покрените пример
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
```

### Шта се дешава када га покренете

1. Програм учитава `document.txt` (садржи информације о GitHub моделима)
2. Постављате питање о документу
3. Вештачка интелигенција одговара само на основу садржаја документа, а не на основу свог општег знања

Покушајте да питате: "Шта су GitHub модели?" у поређењу са "Какво је време?"

## Туторијал 4: Одговорна вештачка интелигенција

**Фајл:** `src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

### Шта овај пример учи

Пример одговорне вештачке интелигенције истиче важност примене безбедносних мера у апликацијама вештачке интелигенције. Демонстрира безбедносне филтере који откривају категорије штетног садржаја, укључујући говор мржње, узнемиравање, самоповређивање, сексуални садржај и насиље, показујући како производне апликације вештачке интелигенције треба да се елегантно носе са кршењем политике садржаја кроз правилно руковање изузецима, механизме повратних информација корисника и стратегије резервних одговора.

### Кључни концепти кода

#### 1. Оквир за тестирање безбедности
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

#### 2. Тестиране категорије безбедности
- Упутства за насиље/штету
- Говор мржње
- Повреде приватности
- Медицинске дезинформације
- Незаконите активности

### Покрените пример
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
```

### Шта се дешава када га покренете

Програм тестира различите штетне упите и показује како систем безбедности вештачке интелигенције:
1. **Блокира опасне захтеве** са HTTP 400 грешкама
2. **Дозвољава безбедан садржај** да се генерише нормално
3. **Штити кориснике** од штетних излазних података вештачке интелигенције

## Заједнички обрасци у примерима

### Образац аутентификације
Сви примери користе овај образац за аутентификацију са GitHub моделима:

```java
String pat = System.getenv("GITHUB_TOKEN");
TokenCredential credential = new StaticTokenCredential(pat);
OpenAIClient client = new OpenAIClientBuilder()
    .endpoint("https://models.inference.ai.azure.com")
    .credential(credential)
    .buildClient();
```

### Образац руковања грешкама
```java
try {
    // AI operation
} catch (HttpResponseException e) {
    // Handle API errors (rate limits, safety filters)
} catch (Exception e) {
    // Handle general errors (network, parsing)
}
```

### Образац структуре порука
```java
List<ChatRequestMessage> messages = List.of(
    new ChatRequestSystemMessage("Set AI behavior"),
    new ChatRequestUserMessage("User's actual request")
);
```

## Следећи кораци

[Поглавље 04: Практични примери](../04-PracticalSamples/README.md)

## Решавање проблема

### Уобичајени проблеми

**"GITHUB_TOKEN није постављен"**
- Уверите се да сте поставили променљиву окружења
- Проверите да ли ваш токен има `models:read` дозволу

**"Нема одговора од API-ја"**
- Проверите своју интернет конекцију
- Проверите да ли је ваш токен валидан
- Проверите да ли сте достигли ограничење броја захтева

**Грешке при компилацији Maven-а**
- Уверите се да имате Java 21 или новију верзију
- Покрените `mvn clean compile` да освежите зависности

**Одрицање од одговорности**:  
Овај документ је преведен коришћењем услуге за превођење помоћу вештачке интелигенције [Co-op Translator](https://github.com/Azure/co-op-translator). Иако настојимо да обезбедимо тачност, молимо вас да имате у виду да аутоматски преводи могу садржати грешке или нетачности. Оригинални документ на његовом изворном језику треба сматрати меродавним извором. За критичне информације препоручује се професионални превод од стране људи. Не преузимамо одговорност за било каква погрешна тумачења или неспоразуме који могу настати услед коришћења овог превода.