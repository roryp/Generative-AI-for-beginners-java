<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T17:38:27+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "ru"
}
-->
# Основные техники генеративного ИИ

>**Примечание**: В этой главе представлен подробный [**Учебник**](./TUTORIAL.md), который поможет вам запустить готовые примеры.

## Чему вы научитесь
В этой главе мы рассмотрим 4 основные техники генеративного ИИ на практических примерах:
- Завершение текста и чат-потоки с использованием LLM
- Вызов функций
- Генерация с дополнением извлеченной информации (RAG)
- Меры безопасности для ответственного использования ИИ

## Содержание

- [Чему вы научитесь](../../../03-CoreGenerativeAITechniques)
- [Предварительные требования](../../../03-CoreGenerativeAITechniques)
- [Начало работы](../../../03-CoreGenerativeAITechniques)
- [Обзор примеров](../../../03-CoreGenerativeAITechniques)
  - [1. Завершение текста и чат-потоки с использованием LLM](../../../03-CoreGenerativeAITechniques)
  - [2. Функции и плагины с использованием LLM](../../../03-CoreGenerativeAITechniques)
  - [3. Генерация с дополнением извлеченной информации (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Демонстрация мер безопасности ответственного ИИ](../../../03-CoreGenerativeAITechniques)
- [Резюме](../../../03-CoreGenerativeAITechniques)
- [Следующие шаги](../../../03-CoreGenerativeAITechniques)

## Предварительные требования

- Завершение настройки из [Главы 2](../../../02-SetupDevEnvironment)

## Начало работы

1. **Перейдите к примерам**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **Настройте окружение**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **Скомпилируйте и запустите примеры**:  
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

## Обзор примеров

Примеры организованы в папке `examples/` со следующей структурой:

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

### 1. Завершение текста и чат-потоки с использованием LLM
**Файл**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Научитесь создавать разговорный ИИ с потоковыми ответами и управлением историей чатов.

Этот пример демонстрирует:
- Простое завершение текста с использованием системных подсказок
- Многоходовые диалоги с управлением историей
- Интерактивные сеансы чата
- Настройку параметров (temperature, max tokens)

### 2. Функции и плагины с использованием LLM
**Файл**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Расширьте возможности ИИ, предоставив моделям доступ к пользовательским функциям и внешним API.

Этот пример демонстрирует:
- Интеграцию функции прогноза погоды
- Реализацию функции калькулятора  
- Несколько вызовов функций в рамках одного диалога
- Определение функций с использованием JSON-схем

### 3. Генерация с дополнением извлеченной информации (RAG)
**Файл**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Узнайте, как объединить ИИ с вашими документами и источниками данных для точных и контекстуальных ответов.

Этот пример демонстрирует:
- Ответы на вопросы на основе документов с использованием Azure OpenAI SDK
- Реализацию паттерна RAG с моделями GitHub

**Использование**: Задавайте вопросы о содержимом файла `document.txt` и получайте ответы ИИ, основанные только на этом контексте.

### 4. Демонстрация мер безопасности ответственного ИИ
**Файл**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Получите представление о том, как работают меры безопасности ИИ, протестировав возможности фильтрации контента моделей GitHub.

Этот пример демонстрирует:
- Фильтрацию контента для потенциально опасных запросов
- Обработку ответов безопасности в приложениях
- Различные категории блокируемого контента (насилие, разжигание ненависти, дезинформация)
- Корректную обработку ошибок при нарушении правил безопасности

> **Узнайте больше**: Это лишь введение в концепции ответственного ИИ. Для получения дополнительной информации об этике, снижении предвзятости, защите конфиденциальности и рамках ответственного ИИ см. [Главу 5: Ответственный генеративный ИИ](../05-ResponsibleGenAI/README.md).

## Резюме

В этой главе мы изучили завершение текста и чат-потоки с использованием LLM, реализовали вызов функций для расширения возможностей ИИ, создали систему генерации с дополнением извлеченной информации (RAG) и продемонстрировали меры безопасности для ответственного использования ИИ.

> **Примечание**: Более подробно изучите материал с помощью предоставленного [**Учебника**](./TUTORIAL.md)

## Следующие шаги

[Глава 4: Практические приложения и проекты](../04-PracticalSamples/README.md)

**Отказ от ответственности**:  
Этот документ был переведен с использованием сервиса автоматического перевода [Co-op Translator](https://github.com/Azure/co-op-translator). Хотя мы стремимся к точности, пожалуйста, учитывайте, что автоматические переводы могут содержать ошибки или неточности. Оригинальный документ на его родном языке следует считать авторитетным источником. Для получения критически важной информации рекомендуется профессиональный перевод человеком. Мы не несем ответственности за любые недоразумения или неправильные интерпретации, возникшие в результате использования данного перевода.