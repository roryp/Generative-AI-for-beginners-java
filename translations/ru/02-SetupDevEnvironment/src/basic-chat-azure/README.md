<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2289320a74aeca1eb844cd7d3a7a9e12",
  "translation_date": "2025-07-21T18:04:26+00:00",
  "source_file": "02-SetupDevEnvironment/src/basic-chat-azure/README.md",
  "language_code": "ru"
}
-->
# Простой чат с Azure OpenAI - Пример от начала до конца

Этот пример демонстрирует, как создать простое приложение Spring Boot, которое подключается к Azure OpenAI и проверяет вашу настройку.

## Содержание

- [Предварительные требования](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Быстрый старт](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Варианты конфигурации](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Вариант 1: Переменные окружения (файл .env) - Рекомендуется](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Вариант 2: Секреты GitHub Codespace](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Запуск приложения](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [С использованием Maven](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [С использованием VS Code](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Ожидаемый результат](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Справочник по конфигурации](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Переменные окружения](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Конфигурация Spring](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Устранение неполадок](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Распространенные проблемы](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Режим отладки](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Следующие шаги](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Ресурсы](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)

## Предварительные требования

Перед запуском этого примера убедитесь, что вы:

- Завершили [руководство по настройке Azure OpenAI](../../getting-started-azure-openai.md)  
- Развернули ресурс Azure OpenAI (через портал Azure AI Foundry)  
- Развернули модель gpt-4o-mini (или альтернативную)  
- Получили API-ключ и URL конечной точки из Azure  

## Быстрый старт

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/src/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Варианты конфигурации

### Вариант 1: Переменные окружения (файл .env) - Рекомендуется

**Шаг 1: Создайте файл конфигурации**
```bash
cp .env.example .env
```

**Шаг 2: Добавьте свои учетные данные Azure OpenAI**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Примечание по безопасности**: 
> - Никогда не добавляйте файл `.env` в систему контроля версий
> - Файл `.env` уже добавлен в `.gitignore`
> - Храните свои API-ключи в безопасности и регулярно их обновляйте

### Вариант 2: Секреты GitHub Codespace

Для GitHub Codespaces настройте следующие секреты в вашем репозитории:
- `AZURE_AI_KEY` - Ваш API-ключ Azure OpenAI
- `AZURE_AI_ENDPOINT` - URL конечной точки Azure OpenAI

Приложение автоматически обнаруживает и использует эти секреты.

### Альтернатива: Прямые переменные окружения

<details>
<summary>Нажмите, чтобы увидеть команды для разных платформ</summary>

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

## Запуск приложения

### С использованием Maven

```bash
mvn spring-boot:run
```

### С использованием VS Code

1. Откройте проект в VS Code
2. Нажмите `F5` или используйте панель "Run and Debug"
3. Выберите конфигурацию "Spring Boot-BasicChatApplication"

> **Примечание**: Конфигурация VS Code автоматически загружает ваш файл .env

### Ожидаемый результат

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

## Справочник по конфигурации

### Переменные окружения

| Переменная | Описание | Обязательно | Пример |
|------------|----------|-------------|--------|
| `AZURE_AI_KEY` | API-ключ Azure OpenAI | Да | `abc123...` |
| `AZURE_AI_ENDPOINT` | URL конечной точки Azure OpenAI | Да | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Имя развертывания модели | Нет | `gpt-4o-mini` (по умолчанию) |

### Конфигурация Spring

Файл `application.yml` настраивает:
- **API-ключ**: `${AZURE_AI_KEY}` - Из переменной окружения
- **Конечная точка**: `${AZURE_AI_ENDPOINT}` - Из переменной окружения  
- **Модель**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Из переменной окружения с резервным значением
- **Температура**: `0.7` - Контролирует креативность (0.0 = детерминированно, 1.0 = креативно)
- **Максимальное количество токенов**: `500` - Максимальная длина ответа

## Устранение неполадок

### Распространенные проблемы

<details>
<summary><strong>Ошибка: "API-ключ недействителен"</strong></summary>

- Проверьте, что ваш `AZURE_AI_KEY` правильно указан в файле `.env`
- Убедитесь, что API-ключ скопирован точно из портала Azure AI Foundry
- Убедитесь, что вокруг ключа нет лишних пробелов или кавычек
</details>

<details>
<summary><strong>Ошибка: "Конечная точка недействительна"</strong></summary>

- Убедитесь, что ваш `AZURE_AI_ENDPOINT` включает полный URL (например, `https://your-hub-name.openai.azure.com/`)
- Проверьте наличие или отсутствие завершающего слэша
- Убедитесь, что конечная точка соответствует вашему региону развертывания Azure
</details>

<details>
<summary><strong>Ошибка: "Развертывание не найдено"</strong></summary>

- Убедитесь, что имя развертывания модели точно совпадает с тем, что развернуто в Azure
- Проверьте, что модель успешно развернута и активна
- Попробуйте использовать имя развертывания по умолчанию: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: Переменные окружения не загружаются</strong></summary>

- Убедитесь, что ваш файл `.env` находится в корневой директории проекта (на том же уровне, что и `pom.xml`)
- Попробуйте запустить `mvn spring-boot:run` в интегрированном терминале VS Code
- Проверьте, что расширение Java для VS Code установлено правильно
- Убедитесь, что в конфигурации запуска указано `"envFile": "${workspaceFolder}/.env"`
</details>

### Режим отладки

Чтобы включить подробное логирование, раскомментируйте эти строки в `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Следующие шаги

**Настройка завершена!** Продолжайте изучение:

[Глава 3: Основные техники генеративного ИИ](../../../03-CoreGenerativeAITechniques/README.md)

## Ресурсы

- [Документация Spring AI Azure OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Документация Azure OpenAI Service](https://learn.microsoft.com/azure/ai-services/openai/)
- [Портал Azure AI Foundry](https://ai.azure.com/)
- [Документация Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**Отказ от ответственности**:  
Этот документ был переведен с использованием сервиса автоматического перевода [Co-op Translator](https://github.com/Azure/co-op-translator). Хотя мы стремимся к точности, пожалуйста, учитывайте, что автоматические переводы могут содержать ошибки или неточности. Оригинальный документ на его родном языке следует считать авторитетным источником. Для получения критически важной информации рекомендуется профессиональный перевод человеком. Мы не несем ответственности за любые недоразумения или неправильные интерпретации, возникающие в результате использования данного перевода.