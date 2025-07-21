<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T20:41:15+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "bg"
}
-->
# Основни Техники за Генеративен AI

>**Забележка**: Тази глава включва подробен [**Урок**](./TUTORIAL.md), който ще ви преведе през изпълнението на готовите примери.

## Какво Ще Научите
В тази глава ще разгледаме 4 основни техники за генеративен AI чрез практически примери:
- Завършване на текст и чат потоци с LLM
- Извикване на функции
- Генерация с Подобрено Извличане (RAG)
- Мерки за безопасност при отговорен AI

## Съдържание

- [Какво Ще Научите](../../../03-CoreGenerativeAITechniques)
- [Предварителни Изисквания](../../../03-CoreGenerativeAITechniques)
- [Първи Стъпки](../../../03-CoreGenerativeAITechniques)
- [Преглед на Примерите](../../../03-CoreGenerativeAITechniques)
  - [1. Завършване на Текст и Чат Потоци с LLM](../../../03-CoreGenerativeAITechniques)
  - [2. Функции и Плъгини с LLM](../../../03-CoreGenerativeAITechniques)
  - [3. Генерация с Подобрено Извличане (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Демонстрация на Безопасност при Отговорен AI](../../../03-CoreGenerativeAITechniques)
- [Обобщение](../../../03-CoreGenerativeAITechniques)
- [Следващи Стъпки](../../../03-CoreGenerativeAITechniques)

## Предварителни Изисквания

- Завършена настройка от [Глава 2](../../../02-SetupDevEnvironment)

## Първи Стъпки

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

## Преглед на Примерите

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

### 1. Завършване на Текст и Чат Потоци с LLM
**Файл**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Научете как да изграждате разговорен AI с поточни отговори и управление на историята на чата.

Този пример демонстрира:
- Просто завършване на текст със системни подсказки
- Многократни разговори с управление на историята
- Интерактивни чат сесии
- Конфигурация на параметри (температура, максимален брой токени)

### 2. Функции и Плъгини с LLM
**Файл**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Разширете възможностите на AI, като предоставите достъп до персонализирани функции и външни API.

Този пример демонстрира:
- Интеграция на функция за прогноза на времето
- Имплементация на калкулаторна функция  
- Множество извиквания на функции в един разговор
- Дефиниране на функции с JSON схеми

### 3. Генерация с Подобрено Извличане (RAG)
**Файл**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Научете как да комбинирате AI с ваши собствени документи и източници на данни за точни и контекстуално осведомени отговори.

Този пример демонстрира:
- Отговаряне на въпроси, базирани на документи, с Azure OpenAI SDK
- Имплементация на RAG модел с GitHub модели

**Употреба**: Задавайте въпроси относно съдържанието в `document.txt` и получавайте отговори от AI, базирани само на този контекст.

### 4. Демонстрация на Безопасност при Отговорен AI
**Файл**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Получете предварителен преглед на мерките за безопасност на AI, като тествате възможностите за филтриране на съдържание на GitHub модели.

Този пример демонстрира:
- Филтриране на съдържание за потенциално вредни подсказки
- Обработка на отговори за безопасност в приложения
- Различни категории блокирано съдържание (насилие, реч на омраза, дезинформация)
- Правилно управление на грешки при нарушения на безопасността

> **Научете Повече**: Това е само въведение в концепциите за отговорен AI. За повече информация относно етика, намаляване на пристрастията, съображения за поверителност и рамки за отговорен AI, вижте [Глава 5: Отговорен Генеративен AI](../05-ResponsibleGenAI/README.md).

## Обобщение

В тази глава разгледахме завършване на текст и чат потоци с LLM, имплементирахме извикване на функции за разширяване на възможностите на AI, създадохме система за Генерация с Подобрено Извличане (RAG) и демонстрирахме мерки за безопасност при отговорен AI.

> **ЗАБЕЛЕЖКА**: Разгледайте по-подробно предоставения [**Урок**](./TUTORIAL.md)

## Следващи Стъпки

[Глава 4: Практически Приложения и Проекти](../04-PracticalSamples/README.md)

**Отказ от отговорност**:  
Този документ е преведен с помощта на AI услуга за превод [Co-op Translator](https://github.com/Azure/co-op-translator). Въпреки че се стремим към точност, моля, имайте предвид, че автоматизираните преводи може да съдържат грешки или неточности. Оригиналният документ на неговия роден език трябва да се счита за авторитетен източник. За критична информация се препоръчва професионален човешки превод. Ние не носим отговорност за недоразумения или погрешни интерпретации, произтичащи от използването на този превод.