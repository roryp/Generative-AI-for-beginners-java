<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2289320a74aeca1eb844cd7d3a7a9e12",
  "translation_date": "2025-07-21T21:12:43+00:00",
  "source_file": "02-SetupDevEnvironment/src/basic-chat-azure/README.md",
  "language_code": "uk"
}
-->
# Основний чат з Azure OpenAI - приклад від початку до кінця

Цей приклад демонструє, як створити простий додаток Spring Boot, який підключається до Azure OpenAI і перевіряє вашу конфігурацію.

## Зміст

- [Попередні вимоги](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Швидкий старт](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Опції конфігурації](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Опція 1: Змінні середовища (.env файл) - Рекомендовано](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Опція 2: Секрети GitHub Codespace](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Запуск додатка](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [За допомогою Maven](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [За допомогою VS Code](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Очікуваний результат](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Довідник конфігурації](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Змінні середовища](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Конфігурація Spring](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Усунення несправностей](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Поширені проблеми](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Режим налагодження](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Наступні кроки](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Ресурси](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)

## Попередні вимоги

Перед запуском цього прикладу переконайтеся, що ви:

- Завершили [посібник із налаштування Azure OpenAI](../../getting-started-azure-openai.md)  
- Розгорнули ресурс Azure OpenAI (через портал Azure AI Foundry)  
- Розгорнули модель gpt-4o-mini (або альтернативну)  
- Отримали API-ключ і URL-адресу кінцевої точки з Azure  

## Швидкий старт

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/src/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Опції конфігурації

### Опція 1: Змінні середовища (.env файл) - Рекомендовано

**Крок 1: Створіть файл конфігурації**
```bash
cp .env.example .env
```

**Крок 2: Додайте свої облікові дані Azure OpenAI**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Примітка щодо безпеки**: 
> - Ніколи не додавайте `.env` файл до системи контролю версій
> - `.env` файл вже додано до `.gitignore`
> - Зберігайте свої API-ключі в безпеці та регулярно змінюйте їх

### Опція 2: Секрети GitHub Codespace

Для GitHub Codespaces додайте ці секрети до вашого репозиторію:
- `AZURE_AI_KEY` - Ваш API-ключ Azure OpenAI
- `AZURE_AI_ENDPOINT` - URL-адреса кінцевої точки Azure OpenAI

Додаток автоматично виявляє та використовує ці секрети.

### Альтернатива: Прямі змінні середовища

<details>
<summary>Натисніть, щоб побачити команди для конкретних платформ</summary>

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

## Запуск додатка

### За допомогою Maven

```bash
mvn spring-boot:run
```

### За допомогою VS Code

1. Відкрийте проєкт у VS Code
2. Натисніть `F5` або скористайтеся панеллю "Run and Debug"
3. Виберіть конфігурацію "Spring Boot-BasicChatApplication"

> **Примітка**: Конфігурація VS Code автоматично завантажує ваш `.env` файл

### Очікуваний результат

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

## Довідник конфігурації

### Змінні середовища

| Змінна | Опис | Обов'язково | Приклад |
|--------|------|-------------|---------|
| `AZURE_AI_KEY` | API-ключ Azure OpenAI | Так | `abc123...` |
| `AZURE_AI_ENDPOINT` | URL-адреса кінцевої точки Azure OpenAI | Так | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Назва розгортання моделі | Ні | `gpt-4o-mini` (за замовчуванням) |

### Конфігурація Spring

Файл `application.yml` налаштовує:
- **API-ключ**: `${AZURE_AI_KEY}` - Змінна середовища
- **Кінцева точка**: `${AZURE_AI_ENDPOINT}` - Змінна середовища  
- **Модель**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Змінна середовища з резервним значенням
- **Temperature**: `0.7` - Контролює креативність (0.0 = детермінованість, 1.0 = креативність)
- **Max Tokens**: `500` - Максимальна довжина відповіді

## Усунення несправностей

### Поширені проблеми

<details>
<summary><strong>Помилка: "API-ключ недійсний"</strong></summary>

- Перевірте, чи правильно вказано `AZURE_AI_KEY` у вашому `.env` файлі
- Переконайтеся, що API-ключ скопійовано точно з порталу Azure AI Foundry
- Перевірте, чи немає зайвих пробілів або лапок навколо ключа
</details>

<details>
<summary><strong>Помилка: "Кінцева точка недійсна"</strong></summary>

- Переконайтеся, що ваш `AZURE_AI_ENDPOINT` включає повний URL (наприклад, `https://your-hub-name.openai.azure.com/`)
- Перевірте узгодженість зі слешем в кінці
- Переконайтеся, що кінцева точка відповідає вашому регіону розгортання Azure
</details>

<details>
<summary><strong>Помилка: "Розгортання не знайдено"</strong></summary>

- Перевірте, чи назва розгортання моделі точно відповідає тій, що розгорнута в Azure
- Переконайтеся, що модель успішно розгорнута та активна
- Спробуйте використати назву розгортання за замовчуванням: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: Змінні середовища не завантажуються</strong></summary>

- Переконайтеся, що ваш `.env` файл знаходиться в кореневій директорії проєкту (на тому ж рівні, що й `pom.xml`)
- Спробуйте запустити `mvn spring-boot:run` у вбудованому терміналі VS Code
- Перевірте, чи встановлено розширення Java для VS Code
- Переконайтеся, що конфігурація запуску містить `"envFile": "${workspaceFolder}/.env"`
</details>

### Режим налагодження

Щоб увімкнути детальне логування, розкоментуйте ці рядки у `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Наступні кроки

**Налаштування завершено!** Продовжуйте навчання:

[Розділ 3: Основні техніки генеративного ШІ](../../../03-CoreGenerativeAITechniques/README.md)

## Ресурси

- [Документація Spring AI Azure OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Документація Azure OpenAI Service](https://learn.microsoft.com/azure/ai-services/openai/)
- [Портал Azure AI Foundry](https://ai.azure.com/)
- [Документація Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**Відмова від відповідальності**:  
Цей документ було перекладено за допомогою сервісу автоматичного перекладу [Co-op Translator](https://github.com/Azure/co-op-translator). Хоча ми прагнемо до точності, звертаємо вашу увагу, що автоматичні переклади можуть містити помилки або неточності. Оригінальний документ на його рідній мові слід вважати авторитетним джерелом. Для критично важливої інформації рекомендується професійний людський переклад. Ми не несемо відповідальності за будь-які непорозуміння або неправильні тлумачення, що виникли внаслідок використання цього перекладу.