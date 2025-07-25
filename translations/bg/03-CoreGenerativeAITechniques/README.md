<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b8a372dfc3e3e7ad9261231a22fd79c0",
  "translation_date": "2025-07-25T10:07:23+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "bg"
}
-->
# Основни техники за генеративен AI

>**Note**: Тази глава включва подробен [**Урок**](./TUTORIAL.md), който ви води през примерите.

## Какво ще научите
В тази глава разглеждаме 4 основни техники за генеративен AI чрез практически примери:
- Завършване на LLM и чат потоци
- Извикване на функции
- Генерация с допълнително извличане на информация (RAG)
- Мерки за безопасност при отговорен AI

## Съдържание

- [Какво ще научите](../../../03-CoreGenerativeAITechniques)
- [Предпоставки](../../../03-CoreGenerativeAITechniques)
- [Първи стъпки](../../../03-CoreGenerativeAITechniques)
- [Преглед на примерите](../../../03-CoreGenerativeAITechniques)
  - [1. Завършване на LLM и чат потоци](../../../03-CoreGenerativeAITechniques)
  - [2. Функции и плъгини с LLM](../../../03-CoreGenerativeAITechniques)
  - [3. Генерация с допълнително извличане на информация (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Демонстрация на безопасност при отговорен AI](../../../03-CoreGenerativeAITechniques)
- [Резюме](../../../03-CoreGenerativeAITechniques)
- [Следващи стъпки](../../../03-CoreGenerativeAITechniques)

## Предпоставки

- Завършена настройка от [Глава 2](../../../02-SetupDevEnvironment)

## Първи стъпки

1. **Навигирайте до примерите**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **Настройте средата**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **Компилирайте и стартирайте примерите**:  
```bash
   # Run completions example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
   
   # Run functions example  
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
   
   # Run RAG example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
   
   # Run responsible AI demo
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
   ```  

## Преглед на примерите

Примерите са организирани в папката `examples/` със следната структура:

```
examples/
├── src/main/java/com/example/genai/techniques/
│   ├── completions/
│   │   └── LLMCompletionsApp.java        # Basic completions 
│   ├── functions/
│   │   └── FunctionsApp.java             # Function calling examples
│   ├── rag/
│   │   └── SimpleReaderDemo.java         # Retrieval-Augmented Generation
│   └── responsibleai/
│       └── ResponsibleGithubModels.java  # Responsible AI safety demonstration
├── document.txt                          # Sample document for RAG example
└── pom.xml                               # Maven configuration
```

### 1. Завършване на LLM и чат потоци
**Файл**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Научете как да изградите разговорен AI със стрийминг отговори и управление на историята на чата.

Този пример демонстрира:
- Просто текстово завършване със системни подсказки
- Разговори с няколко хода и управление на историята
- Интерактивни чат сесии
- Конфигурация на параметри (температура, максимален брой токени)

### 2. Функции и плъгини с LLM
**Файл**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Разширете възможностите на AI, като предоставите на моделите достъп до персонализирани функции и външни API.

Този пример демонстрира:
- Интеграция на функция за прогноза за времето
- Имплементация на калкулаторна функция  
- Множество извиквания на функции в един разговор
- Дефиниране на функции с JSON схеми

### 3. Генерация с допълнително извличане на информация (RAG)
**Файл**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Научете как да комбинирате AI с ваши собствени документи и източници на данни за точни, контекстуално осведомени отговори.

Този пример демонстрира:
- Отговаряне на въпроси, базирани на документи, с Azure OpenAI SDK
- Имплементация на RAG модел с GitHub модели

**Употреба**: Задавайте въпроси относно съдържанието в `document.txt` и получавайте AI отговори, базирани само на този контекст.

### 4. Демонстрация на безопасност при отговорен AI
**Файл**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Получете предварителен преглед на това как работят мерките за безопасност на AI, като тествате възможностите за филтриране на съдържание на GitHub модели.

Този пример демонстрира:
- Филтриране на съдържание за потенциално вредни подсказки
- Управление на безопасни отговори в приложения
- Различни категории блокирано съдържание (насилие, реч на омраза, дезинформация)
- Правилно обработване на грешки при нарушения на безопасността

> **Научете повече**: Това е само въведение в концепциите за отговорен AI. За повече информация относно етика, намаляване на пристрастията, съображения за поверителност и рамки за отговорен AI, вижте [Глава 5: Отговорен генеративен AI](../05-ResponsibleGenAI/README.md).

## Резюме

В тази глава разгледахме завършване на LLM и чат потоци, имплементирахме извикване на функции за разширяване на възможностите на AI, създадохме система за генерация с допълнително извличане на информация (RAG) и демонстрирахме мерки за безопасност при отговорен AI.

> **NOTE**: Разгледайте подробно предоставения [**Урок**](./TUTORIAL.md)

## Следващи стъпки

[Глава 4: Практически приложения и проекти](../04-PracticalSamples/README.md)

**Отказ от отговорност**:  
Този документ е преведен с помощта на AI услуга за превод [Co-op Translator](https://github.com/Azure/co-op-translator). Въпреки че се стремим към точност, моля, имайте предвид, че автоматичните преводи може да съдържат грешки или неточности. Оригиналният документ на неговия изходен език трябва да се счита за авторитетен източник. За критична информация се препоръчва професионален превод от човек. Ние не носим отговорност за каквито и да било недоразумения или погрешни интерпретации, произтичащи от използването на този превод.