<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2289320a74aeca1eb844cd7d3a7a9e12",
  "translation_date": "2025-07-21T21:10:19+00:00",
  "source_file": "02-SetupDevEnvironment/src/basic-chat-azure/README.md",
  "language_code": "bg"
}
-->
# Основен чат с Azure OpenAI - Пример от край до край

Този пример демонстрира как да създадете просто Spring Boot приложение, което се свързва с Azure OpenAI и тества вашата конфигурация.

## Съдържание

- [Предварителни изисквания](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Бърз старт](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Опции за конфигурация](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Опция 1: Променливи на средата (.env файл) - Препоръчително](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Опция 2: Тайни в GitHub Codespace](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Стартиране на приложението](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [С помощта на Maven](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [С помощта на VS Code](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Очакван резултат](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Референция за конфигурация](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Променливи на средата](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Spring конфигурация](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Отстраняване на проблеми](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Често срещани проблеми](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Режим на отстраняване на грешки](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Следващи стъпки](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Ресурси](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)

## Предварителни изисквания

Преди да стартирате този пример, уверете се, че имате:

- Завършили [ръководството за настройка на Azure OpenAI](../../getting-started-azure-openai.md)  
- Разположен ресурс Azure OpenAI (чрез портала Azure AI Foundry)  
- Разположен модел gpt-4o-mini (или алтернативен)  
- API ключ и URL адрес на крайна точка от Azure  

## Бърз старт

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/src/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Опции за конфигурация

### Опция 1: Променливи на средата (.env файл) - Препоръчително

**Стъпка 1: Създайте вашия конфигурационен файл**  
```bash
cp .env.example .env
```

**Стъпка 2: Добавете вашите Azure OpenAI идентификационни данни**  
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Бележка за сигурност**:  
> - Никога не качвайте `.env` файла във версията за контрол  
> - `.env` файлът вече е добавен в `.gitignore`  
> - Пазете вашите API ключове сигурни и ги обновявайте редовно  

### Опция 2: Тайни в GitHub Codespace

За GitHub Codespaces задайте следните тайни във вашето хранилище:
- `AZURE_AI_KEY` - Вашият Azure OpenAI API ключ
- `AZURE_AI_ENDPOINT` - Вашият Azure OpenAI URL адрес на крайна точка

Приложението автоматично открива и използва тези тайни.

### Алтернатива: Директни променливи на средата

<details>
<summary>Кликнете, за да видите команди за конкретни платформи</summary>

**Linux/macOS (bash/zsh):**  
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (Command Prompt):**  
```cmd
set AZURE_AI_KEY=your-actual-api-key-here
set AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (PowerShell):**  
```powershell
$env:AZURE_AI_KEY="your-actual-api-key-here"
$env:AZURE_AI_ENDPOINT="https://your-hub-name.openai.azure.com/"
```
</details>

## Стартиране на приложението

### С помощта на Maven

```bash
mvn spring-boot:run
```

### С помощта на VS Code

1. Отворете проекта във VS Code  
2. Натиснете `F5` или използвайте панела "Run and Debug"  
3. Изберете конфигурацията "Spring Boot-BasicChatApplication"  

> **Бележка**: Конфигурацията на VS Code автоматично зарежда вашия .env файл  

### Очакван резултат

```
Starting Basic Chat with Azure OpenAI...
Environment variables loaded successfully
Connecting to Azure OpenAI...
Sending prompt: What is AI in a short sentence? Max 100 words.

AI Response:
================
AI, or Artificial Intelligence, is the simulation of human intelligence in machines programmed to think and learn like humans.
================

Success! Azure OpenAI connection is working correctly.
```

## Референция за конфигурация

### Променливи на средата

| Променлива | Описание | Задължителна | Пример |
|------------|----------|--------------|--------|
| `AZURE_AI_KEY` | Azure OpenAI API ключ | Да | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI URL адрес на крайна точка | Да | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Име на разположения модел | Не | `gpt-4o-mini` (по подразбиране) |

### Spring конфигурация

Файлът `application.yml` конфигурира:
- **API ключ**: `${AZURE_AI_KEY}` - От променлива на средата  
- **Крайна точка**: `${AZURE_AI_ENDPOINT}` - От променлива на средата  
- **Модел**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - От променлива на средата с резервна стойност  
- **Температура**: `0.7` - Контролира креативността (0.0 = детерминирано, 1.0 = креативно)  
- **Максимален брой токени**: `500` - Максимална дължина на отговора  

## Отстраняване на проблеми

### Често срещани проблеми

<details>
<summary><strong>Грешка: "API ключът не е валиден"</strong></summary>

- Проверете дали вашият `AZURE_AI_KEY` е правилно зададен във вашия `.env` файл  
- Уверете се, че API ключът е копиран точно от портала Azure AI Foundry  
- Уверете се, че няма допълнителни интервали или кавички около ключа  
</details>

<details>
<summary><strong>Грешка: "Крайната точка не е валидна"</strong></summary>

- Уверете се, че вашият `AZURE_AI_ENDPOINT` включва пълния URL адрес (например `https://your-hub-name.openai.azure.com/`)  
- Проверете за последователност на наклонените черти  
- Уверете се, че крайната точка съответства на вашия регион на разполагане в Azure  
</details>

<details>
<summary><strong>Грешка: "Разполагането не е намерено"</strong></summary>

- Проверете дали името на разположения модел съвпада точно с това, което е разположено в Azure  
- Уверете се, че моделът е успешно разположен и активен  
- Опитайте да използвате името на разположението по подразбиране: `gpt-4o-mini`  
</details>

<details>
<summary><strong>VS Code: Променливите на средата не се зареждат</strong></summary>

- Уверете се, че вашият `.env` файл е в основната директория на проекта (на същото ниво като `pom.xml`)  
- Опитайте да стартирате `mvn spring-boot:run` в интегрирания терминал на VS Code  
- Проверете дали разширението за Java във VS Code е правилно инсталирано  
- Уверете се, че конфигурацията за стартиране съдържа `"envFile": "${workspaceFolder}/.env"`  
</details>

### Режим на отстраняване на грешки

За да активирате подробни логове, разкоментирайте тези редове в `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Следващи стъпки

**Настройката е завършена!** Продължете вашето обучение:

[Глава 3: Основни техники за генеративен AI](../../../03-CoreGenerativeAITechniques/README.md)

## Ресурси

- [Spring AI Azure OpenAI документация](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)  
- [Документация за Azure OpenAI Service](https://learn.microsoft.com/azure/ai-services/openai/)  
- [Портал Azure AI Foundry](https://ai.azure.com/)  
- [Документация за Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)  

**Отказ от отговорност**:  
Този документ е преведен с помощта на AI услуга за превод [Co-op Translator](https://github.com/Azure/co-op-translator). Въпреки че се стремим към точност, моля, имайте предвид, че автоматизираните преводи може да съдържат грешки или неточности. Оригиналният документ на неговия роден език трябва да се счита за авторитетен източник. За критична информация се препоръчва професионален човешки превод. Не носим отговорност за недоразумения или погрешни интерпретации, произтичащи от използването на този превод.