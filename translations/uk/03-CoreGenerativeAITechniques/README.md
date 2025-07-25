<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b8a372dfc3e3e7ad9261231a22fd79c0",
  "translation_date": "2025-07-25T10:18:43+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "uk"
}
-->
# Основні техніки генеративного штучного інтелекту

>**Примітка**: У цьому розділі є детальний [**Посібник**](./TUTORIAL.md), який проведе вас через приклади.

## Що ви дізнаєтесь
У цьому розділі ми розглянемо 4 основні техніки генеративного штучного інтелекту через практичні приклади:
- Завершення тексту та чат-флоу з LLM
- Виклик функцій
- Генерація з доповненим пошуком (RAG)
- Заходи безпеки відповідального штучного інтелекту

## Зміст

- [Що ви дізнаєтесь](../../../03-CoreGenerativeAITechniques)
- [Попередні вимоги](../../../03-CoreGenerativeAITechniques)
- [Початок роботи](../../../03-CoreGenerativeAITechniques)
- [Огляд прикладів](../../../03-CoreGenerativeAITechniques)
  - [1. Завершення тексту та чат-флоу з LLM](../../../03-CoreGenerativeAITechniques)
  - [2. Функції та плагіни з LLM](../../../03-CoreGenerativeAITechniques)
  - [3. Генерація з доповненим пошуком (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Демонстрація заходів безпеки відповідального ШІ](../../../03-CoreGenerativeAITechniques)
- [Резюме](../../../03-CoreGenerativeAITechniques)
- [Наступні кроки](../../../03-CoreGenerativeAITechniques)

## Попередні вимоги

- Завершене налаштування з [Розділу 2](../../../02-SetupDevEnvironment)

## Початок роботи

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

## Огляд прикладів

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

### 1. Завершення тексту та чат-флоу з LLM
**Файл**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Навчіться створювати розмовний ШІ зі стрімінговими відповідями та управлінням історією чатів.

Цей приклад демонструє:
- Просте завершення тексту із системними підказками
- Багатокрокові розмови з управлінням історією
- Інтерактивні чат-сесії
- Налаштування параметрів (температура, максимальна кількість токенів)

### 2. Функції та плагіни з LLM
**Файл**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Розширте можливості ШІ, надаючи моделям доступ до власних функцій та зовнішніх API.

Цей приклад демонструє:
- Інтеграцію функції прогнозу погоди
- Реалізацію функції калькулятора  
- Виклик кількох функцій в одній розмові
- Визначення функцій за допомогою JSON схем

### 3. Генерація з доповненим пошуком (RAG)
**Файл**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Навчіться поєднувати ШІ з власними документами та джерелами даних для точних, контекстно-залежних відповідей.

Цей приклад демонструє:
- Відповіді на запитання на основі документів за допомогою Azure OpenAI SDK
- Реалізацію патерну RAG з моделями GitHub

**Використання**: Задавайте запитання про зміст `document.txt` і отримуйте відповіді ШІ, засновані лише на цьому контексті.

### 4. Демонстрація заходів безпеки відповідального ШІ
**Файл**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Отримайте уявлення про те, як працюють заходи безпеки ШІ, тестуючи можливості фільтрації контенту моделей GitHub.

Цей приклад демонструє:
- Фільтрацію контенту для потенційно шкідливих запитів
- Обробку відповідей безпеки в додатках
- Різні категорії заблокованого контенту (насильство, мова ненависті, дезінформація)
- Коректну обробку помилок при порушенні правил безпеки

> **Дізнайтеся більше**: Це лише вступ до концепцій відповідального ШІ. Для отримання додаткової інформації про етику, зменшення упереджень, питання конфіденційності та рамки відповідального ШІ дивіться [Розділ 5: Відповідальний генеративний ШІ](../05-ResponsibleGenAI/README.md).

## Резюме

У цьому розділі ми розглянули завершення тексту та чат-флоу з LLM, реалізували виклик функцій для розширення можливостей ШІ, створили систему генерації з доповненим пошуком (RAG) і продемонстрували заходи безпеки відповідального ШІ.

> **Примітка**: Глибше ознайомтеся з наданим [**Посібником**](./TUTORIAL.md)

## Наступні кроки

[Розділ 4: Практичні застосування та проєкти](../04-PracticalSamples/README.md)

**Відмова від відповідальності**:  
Цей документ був перекладений за допомогою сервісу автоматичного перекладу [Co-op Translator](https://github.com/Azure/co-op-translator). Хоча ми прагнемо до точності, звертаємо вашу увагу, що автоматичні переклади можуть містити помилки або неточності. Оригінальний документ на його рідній мові слід вважати авторитетним джерелом. Для критично важливої інформації рекомендується професійний переклад людиною. Ми не несемо відповідальності за будь-які непорозуміння або неправильні тлумачення, що виникли внаслідок використання цього перекладу.