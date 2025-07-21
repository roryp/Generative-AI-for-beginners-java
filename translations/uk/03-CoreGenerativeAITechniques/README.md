<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T20:42:58+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "uk"
}
-->
# Основні Техніки Генеративного ШІ

>**Примітка**: У цьому розділі є детальний [**Посібник**](./TUTORIAL.md), який допоможе вам запустити готові приклади.

## Що Ви Дізнаєтесь
У цьому розділі ми розглянемо 4 основні техніки генеративного ШІ через практичні приклади:
- Завершення LLM і чат-флоу
- Виклик функцій
- Генерація з доповненням пошуку (RAG)
- Заходи безпеки відповідального ШІ

## Зміст

- [Що Ви Дізнаєтесь](../../../03-CoreGenerativeAITechniques)
- [Попередні Вимоги](../../../03-CoreGenerativeAITechniques)
- [Початок Роботи](../../../03-CoreGenerativeAITechniques)
- [Огляд Прикладів](../../../03-CoreGenerativeAITechniques)
  - [1. Завершення LLM і Чат-Флоу](../../../03-CoreGenerativeAITechniques)
  - [2. Функції та Плагіни з LLM](../../../03-CoreGenerativeAITechniques)
  - [3. Генерація з Доповненням Пошуку (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Демонстрація Безпеки Відповідального ШІ](../../../03-CoreGenerativeAITechniques)
- [Резюме](../../../03-CoreGenerativeAITechniques)
- [Наступні Кроки](../../../03-CoreGenerativeAITechniques)

## Попередні Вимоги

- Завершене налаштування з [Розділу 2](../../../02-SetupDevEnvironment)

## Початок Роботи

1. **Перейдіть до прикладів**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **Налаштуйте середовище**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **Скомпілюйте та запустіть приклади**:  
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

## Огляд Прикладів

Приклади організовані в папці `examples/` зі структурою:

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

### 1. Завершення LLM і Чат-Флоу
**Файл**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Навчіться створювати розмовний ШІ з потоковими відповідями та управлінням історією чату.

Цей приклад демонструє:
- Просте завершення тексту із системними підказками
- Багатоходові розмови з управлінням історії
- Інтерактивні чат-сесії
- Налаштування параметрів (температура, максимальна кількість токенів)

### 2. Функції та Плагіни з LLM
**Файл**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Розширюйте можливості ШІ, надаючи моделям доступ до користувацьких функцій та зовнішніх API.

Цей приклад демонструє:
- Інтеграцію функції прогнозу погоди
- Реалізацію функції калькулятора  
- Виклик кількох функцій в одній розмові
- Визначення функцій за допомогою JSON-схем

### 3. Генерація з Доповненням Пошуку (RAG)
**Файл**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Дізнайтеся, як поєднувати ШІ з вашими документами та джерелами даних для точних, контекстно-залежних відповідей.

Цей приклад демонструє:
- Відповіді на запитання на основі документів за допомогою Azure OpenAI SDK
- Реалізацію патерну RAG з моделями GitHub

**Використання**: Ставте запитання про вміст у `document.txt` і отримуйте відповіді ШІ, засновані лише на цьому контексті.

### 4. Демонстрація Безпеки Відповідального ШІ
**Файл**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Отримайте уявлення про те, як працюють заходи безпеки ШІ, тестуючи можливості фільтрації контенту моделей GitHub.

Цей приклад демонструє:
- Фільтрацію контенту для потенційно шкідливих запитів
- Обробку безпечних відповідей у додатках
- Різні категорії заблокованого контенту (насильство, мова ненависті, дезінформація)
- Правильну обробку помилок у разі порушення безпеки

> **Дізнайтеся більше**: Це лише вступ до концепцій відповідального ШІ. Для отримання додаткової інформації про етику, зменшення упередженості, питання конфіденційності та рамки відповідального ШІ дивіться [Розділ 5: Відповідальний Генеративний ШІ](../05-ResponsibleGenAI/README.md).

## Резюме

У цьому розділі ми розглянули завершення LLM і чат-флоу, реалізували виклик функцій для розширення можливостей ШІ, створили систему Генерації з Доповненням Пошуку (RAG) і продемонстрували заходи безпеки відповідального ШІ.

> **Примітка**: Глибше ознайомтеся з наданим [**Посібником**](./TUTORIAL.md)

## Наступні Кроки

[Розділ 4: Практичні Застосування та Проєкти](../04-PracticalSamples/README.md)

**Відмова від відповідальності**:  
Цей документ було перекладено за допомогою сервісу автоматичного перекладу [Co-op Translator](https://github.com/Azure/co-op-translator). Хоча ми прагнемо до точності, будь ласка, майте на увазі, що автоматичні переклади можуть містити помилки або неточності. Оригінальний документ на його рідній мові слід вважати авторитетним джерелом. Для критично важливої інформації рекомендується професійний людський переклад. Ми не несемо відповідальності за будь-які непорозуміння або неправильні тлумачення, що виникають внаслідок використання цього перекладу.