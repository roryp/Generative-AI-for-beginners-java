# Основний чат з Azure OpenAI - приклад від початку до кінця

Цей приклад демонструє, як створити простий додаток Spring Boot, який підключається до Azure OpenAI і тестує вашу конфігурацію.

## Зміст

- [Попередні вимоги](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Швидкий старт](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Опції конфігурації](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Опція 1: Змінні середовища (.env файл) - рекомендовано](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Опція 2: Секрети GitHub Codespace](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Запуск додатку](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [За допомогою Maven](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [За допомогою VS Code](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Очікуваний результат](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Довідник конфігурації](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Змінні середовища](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Конфігурація Spring](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Вирішення проблем](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Поширені проблеми](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Режим налагодження](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Наступні кроки](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Ресурси](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## Попередні вимоги

Перед запуском цього прикладу переконайтеся, що ви:

- Завершили [посібник з налаштування Azure OpenAI](../../getting-started-azure-openai.md)  
- Розгорнули ресурс Azure OpenAI (через портал Azure AI Foundry)  
- Розгорнули модель gpt-4o-mini (або альтернативну)  
- Отримали API-ключ і URL-адресу кінцевої точки з Azure  

## Швидкий старт

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Опції конфігурації

### Опція 1: Змінні середовища (.env файл) - рекомендовано

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
> - `.env` файл вже включений до `.gitignore`
> - Зберігайте свої API-ключі в безпеці та регулярно змінюйте їх

### Опція 2: Секрети GitHub Codespace

Для GitHub Codespaces встановіть ці секрети у вашому репозиторії:
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

## Запуск додатку

### За допомогою Maven

```bash
mvn spring-boot:run
```

### За допомогою VS Code

1. Відкрийте проект у VS Code
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
- **API-ключ**: `${AZURE_AI_KEY}` - з змінної середовища
- **Кінцева точка**: `${AZURE_AI_ENDPOINT}` - з змінної середовища  
- **Модель**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - з змінної середовища з резервним значенням
- **Температура**: `0.7` - Контролює креативність (0.0 = детермінований, 1.0 = креативний)
- **Максимальна кількість токенів**: `500` - Максимальна довжина відповіді

## Вирішення проблем

### Поширені проблеми

<details>
<summary><strong>Помилка: "API-ключ недійсний"</strong></summary>

- Перевірте, чи правильно встановлено `AZURE_AI_KEY` у вашому `.env` файлі
- Переконайтеся, що API-ключ скопійовано точно з порталу Azure AI Foundry
- Перевірте, чи немає зайвих пробілів або лапок навколо ключа
</details>

<details>
<summary><strong>Помилка: "Кінцева точка недійсна"</strong></summary>

- Переконайтеся, що ваш `AZURE_AI_ENDPOINT` включає повну URL-адресу (наприклад, `https://your-hub-name.openai.azure.com/`)
- Перевірте узгодженість зі слешами в кінці
- Переконайтеся, що кінцева точка відповідає вашому регіону розгортання Azure
</details>

<details>
<summary><strong>Помилка: "Розгортання не знайдено"</strong></summary>

- Перевірте, чи назва розгортання моделі точно відповідає тому, що розгорнуто в Azure
- Переконайтеся, що модель успішно розгорнута та активна
- Спробуйте використати назву розгортання за замовчуванням: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: Змінні середовища не завантажуються</strong></summary>

- Переконайтеся, що ваш `.env` файл знаходиться в кореневій директорії проекту (на тому ж рівні, що і `pom.xml`)
- Спробуйте запустити `mvn spring-boot:run` у вбудованому терміналі VS Code
- Перевірте, чи правильно встановлено розширення Java для VS Code
- Переконайтеся, що конфігурація запуску має `"envFile": "${workspaceFolder}/.env"`
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

[Розділ 3: Основні техніки генеративного AI](../../../03-CoreGenerativeAITechniques/README.md)

## Ресурси

- [Документація Spring AI Azure OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Документація Azure OpenAI Service](https://learn.microsoft.com/azure/ai-services/openai/)
- [Портал Azure AI Foundry](https://ai.azure.com/)
- [Документація Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**Відмова від відповідальності**:  
Цей документ був перекладений за допомогою сервісу автоматичного перекладу [Co-op Translator](https://github.com/Azure/co-op-translator). Хоча ми прагнемо до точності, будь ласка, майте на увазі, що автоматичні переклади можуть містити помилки або неточності. Оригінальний документ на його рідній мові слід вважати авторитетним джерелом. Для критичної інформації рекомендується професійний людський переклад. Ми не несемо відповідальності за будь-які непорозуміння або неправильні тлумачення, що виникають внаслідок використання цього перекладу.