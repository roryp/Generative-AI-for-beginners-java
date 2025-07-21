<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T18:12:05+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "ru"
}
-->
# Локальное приложение командной строки Foundry

>**Note**: В этой главе есть [**Учебник**](./TUTORIAL.md), который поможет вам запустить готовые примеры.

Простое приложение командной строки на Spring Boot, демонстрирующее, как подключиться к Foundry Local с использованием OpenAI Java SDK.

## Чему вы научитесь

- Как интегрировать Foundry Local с приложениями Spring Boot, используя OpenAI Java SDK
- Лучшие практики для локальной разработки и тестирования ИИ

## Содержание

- [Чему вы научитесь](../../../../04-PracticalSamples/foundrylocal)
- [Предварительные требования](../../../../04-PracticalSamples/foundrylocal)
  - [Установка Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [Проверка](../../../../04-PracticalSamples/foundrylocal)
- [Конфигурация](../../../../04-PracticalSamples/foundrylocal)
- [Быстрый старт](../../../../04-PracticalSamples/foundrylocal)
- [Что делает приложение](../../../../04-PracticalSamples/foundrylocal)
- [Пример вывода](../../../../04-PracticalSamples/foundrylocal)
- [Архитектура](../../../../04-PracticalSamples/foundrylocal)
- [Основные моменты кода](../../../../04-PracticalSamples/foundrylocal)
  - [Интеграция OpenAI Java SDK](../../../../04-PracticalSamples/foundrylocal)
  - [API завершения чата](../../../../04-PracticalSamples/foundrylocal)
- [Устранение неполадок](../../../../04-PracticalSamples/foundrylocal)

## Предварительные требования

> **⚠️ Note**: Это приложение **не работает в предоставленном devcontainer**, так как требует установки и запуска Foundry Local на хост-системе.

### Установка Foundry Local

Перед запуском этого приложения необходимо установить и запустить Foundry Local. Следуйте этим шагам:

1. **Убедитесь, что ваша система соответствует требованиям**:
   - **Операционная система**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025 или macOS
   - **Аппаратное обеспечение**: 
     - Минимум: 8 ГБ оперативной памяти, 3 ГБ свободного места на диске
     - Рекомендуется: 16 ГБ оперативной памяти, 15 ГБ свободного места на диске
   - **Сеть**: Интернет-соединение для первоначальной загрузки модели (опционально для автономного использования)
   - **Ускорение (опционально)**: NVIDIA GPU (серия 2000 или новее), AMD GPU (серия 6000 или новее), Qualcomm Snapdragon X Elite (8 ГБ или больше памяти) или Apple silicon
   - **Разрешения**: Административные права для установки программного обеспечения на вашем устройстве

2. **Установите Foundry Local**:
   
   **Для Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **Для macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Также вы можете скачать установщик из [репозитория Foundry Local на GitHub](https://github.com/microsoft/Foundry-Local).

3. **Запустите вашу первую модель**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   Модель загружается (это может занять несколько минут, в зависимости от скорости вашего интернета) и затем запускается. Foundry Local автоматически выбирает лучший вариант модели для вашей системы (CUDA для NVIDIA GPU, версия для CPU в противном случае).

4. **Протестируйте модель**, задав вопрос в том же терминале:

   ```bash
   Why is the sky blue?
   ```

   Вы должны увидеть ответ от модели Phi, объясняющий, почему небо кажется синим.

### Проверка

Вы можете проверить, что все работает правильно, с помощью этих команд:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

Также вы можете посетить `http://localhost:5273` в вашем браузере, чтобы увидеть веб-интерфейс Foundry Local.

## Конфигурация

Приложение можно настроить через `application.properties`:

- `foundry.local.base-url` - Базовый URL для Foundry Local (по умолчанию: http://localhost:5273)
- `foundry.local.model` - AI-модель для использования (по умолчанию: Phi-3.5-mini-instruct-cuda-gpu)

> **Note**: Имя модели в конфигурации должно совпадать с конкретным вариантом, который Foundry Local загрузил для вашей системы. Когда вы запускаете `foundry model run phi-3.5-mini`, Foundry Local автоматически выбирает и загружает лучший вариант (CUDA для NVIDIA GPU, версия для CPU в противном случае). Используйте `foundry model list`, чтобы увидеть точное имя модели, доступной в вашей локальной инстанции.

## Быстрый старт

### 1. Перейдите в директорию приложения Foundry Local
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Запустите приложение

```bash
mvn spring-boot:run
```

Или соберите и запустите JAR:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Зависимости

Это приложение использует OpenAI Java SDK для взаимодействия с Foundry Local. Основная зависимость:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

Приложение предварительно настроено для подключения к Foundry Local, работающему на порту по умолчанию.

## Что делает приложение

Когда вы запускаете приложение:

1. **Запускается** как приложение командной строки (без веб-сервера)
2. **Автоматически отправляет** тестовое сообщение: "Привет! Можете рассказать, что вы такое и какую модель вы используете?"
3. **Отображает ответ** от Foundry Local в консоли
4. **Корректно завершает работу** после демонстрации

## Пример вывода

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Архитектура

- **Application.java** - Основное приложение Spring Boot с CommandLineRunner
- **FoundryLocalService.java** - Сервис, использующий OpenAI Java SDK для взаимодействия с Foundry Local
- Использует **OpenAI Java SDK** для типизированных API-вызовов
- Автоматическая сериализация/десериализация JSON, обрабатываемая SDK
- Чистая конфигурация с использованием аннотаций Spring `@Value` и `@PostConstruct`

## Основные моменты кода

### Интеграция OpenAI Java SDK

Приложение использует OpenAI Java SDK для создания клиента, настроенного для Foundry Local:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### API завершения чата

Запросы на завершение чата выполняются просто и безопасно:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Устранение неполадок

Если вы видите ошибки подключения:
1. Убедитесь, что Foundry Local работает на `http://localhost:5273`
2. Проверьте, что вариант модели Phi-3.5-mini доступен с помощью `foundry model list`
3. Убедитесь, что имя модели в `application.properties` совпадает с точным именем модели, указанным в списке
4. Убедитесь, что брандмауэр не блокирует соединение

Распространенные проблемы:
- **Модель не найдена**: Запустите `foundry model run phi-3.5-mini`, чтобы загрузить и запустить модель
- **Сервис не работает**: Сервис Foundry Local мог остановиться; перезапустите его с помощью команды запуска модели
- **Неправильное имя модели**: Используйте `foundry model list`, чтобы увидеть доступные модели и обновить вашу конфигурацию соответственно

**Отказ от ответственности**:  
Этот документ был переведен с использованием сервиса автоматического перевода [Co-op Translator](https://github.com/Azure/co-op-translator). Хотя мы стремимся к точности, пожалуйста, имейте в виду, что автоматические переводы могут содержать ошибки или неточности. Оригинальный документ на его родном языке следует считать авторитетным источником. Для получения критически важной информации рекомендуется профессиональный перевод человеком. Мы не несем ответственности за любые недоразумения или неправильные интерпретации, возникающие в результате использования данного перевода.