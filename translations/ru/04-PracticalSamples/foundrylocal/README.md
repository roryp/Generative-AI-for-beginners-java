<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2284c54d2a98090a37df0dbef1633ebf",
  "translation_date": "2025-07-25T10:43:06+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "ru"
}
-->
# Локальный учебник Foundry с использованием Spring Boot

## Содержание

- [Предварительные требования](../../../../04-PracticalSamples/foundrylocal)
- [Обзор проекта](../../../../04-PracticalSamples/foundrylocal)
- [Понимание кода](../../../../04-PracticalSamples/foundrylocal)
  - [1. Конфигурация приложения (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. Основной класс приложения (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. Слой AI-сервиса (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. Зависимости проекта (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [Как все работает вместе](../../../../04-PracticalSamples/foundrylocal)
- [Настройка Foundry Local](../../../../04-PracticalSamples/foundrylocal)
- [Запуск приложения](../../../../04-PracticalSamples/foundrylocal)
- [Ожидаемый результат](../../../../04-PracticalSamples/foundrylocal)
- [Следующие шаги](../../../../04-PracticalSamples/foundrylocal)
- [Устранение неполадок](../../../../04-PracticalSamples/foundrylocal)

## Предварительные требования

Перед началом работы убедитесь, что у вас установлены:

- **Java 21 или выше** на вашем компьютере
- **Maven 3.6+** для сборки проекта
- **Foundry Local**, установленный и запущенный

### **Установка Foundry Local:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```

## Обзор проекта

Проект состоит из четырех основных компонентов:

1. **Application.java** - Точка входа в приложение Spring Boot
2. **FoundryLocalService.java** - Сервисный слой для взаимодействия с AI
3. **application.properties** - Конфигурация для подключения к Foundry Local
4. **pom.xml** - Зависимости Maven и конфигурация проекта

## Понимание кода

### 1. Конфигурация приложения (application.properties)

**Файл:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu
```

**Что это делает:**
- **base-url**: Указывает, где запущен Foundry Local (по умолчанию порт 5273)
- **model**: Определяет, какая модель AI будет использоваться для генерации текста

**Ключевая концепция:** Spring Boot автоматически загружает эти свойства и делает их доступными в приложении с помощью аннотации `@Value`.

### 2. Основной класс приложения (Application.java)

**Файл:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```

**Что это делает:**
- `@SpringBootApplication` включает автоконфигурацию Spring Boot
- `WebApplicationType.NONE` указывает, что это консольное приложение, а не веб-сервер
- Основной метод запускает приложение Spring

**Демонстрационный Runner:**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
    };
}
```

**Что это делает:**
- `@Bean` создает компонент, управляемый Spring
- `CommandLineRunner` выполняет код после запуска Spring Boot
- `foundryLocalService` автоматически внедряется Spring (внедрение зависимостей)
- Отправляет тестовое сообщение AI и отображает ответ

### 3. Слой AI-сервиса (FoundryLocalService.java)

**Файл:** `src/main/java/com/example/FoundryLocalService.java`

#### Внедрение конфигурации:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu}")
    private String model;
```

**Что это делает:**
- `@Service` указывает Spring, что этот класс предоставляет бизнес-логику
- `@Value` внедряет значения конфигурации из application.properties
- Синтаксис `:default-value` задает значения по умолчанию, если свойства не указаны

#### Инициализация клиента:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")        // Foundry Local uses OpenAI-compatible API
            .apiKey("unused")                 // Local server doesn't need real API key
            .build();
}
```

**Что это делает:**
- `@PostConstruct` запускает этот метод после создания сервиса Spring
- Создает клиент OpenAI, который подключается к локальному Foundry Local
- Путь `/v1` необходим для совместимости с API OpenAI
- API-ключ "unused", так как для локальной разработки аутентификация не требуется

#### Метод для общения с AI:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Which AI model to use
                .addUserMessage(message)         // Your question/prompt
                .maxCompletionTokens(150)        // Limit response length
                .temperature(0.7)                // Control creativity (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Extract the AI's response from the API result
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**Что это делает:**
- **ChatCompletionCreateParams**: Настраивает запрос к AI
  - `model`: Указывает, какая модель AI будет использоваться
  - `addUserMessage`: Добавляет ваше сообщение в диалог
  - `maxCompletionTokens`: Ограничивает длину ответа (экономия ресурсов)
  - `temperature`: Контролирует случайность (0.0 = детерминированный, 1.0 = креативный)
- **API-запрос**: Отправляет запрос в Foundry Local
- **Обработка ответа**: Безопасно извлекает текстовый ответ AI
- **Обработка ошибок**: Оборачивает исключения с полезными сообщениями об ошибках

### 4. Зависимости проекта (pom.xml)

**Основные зависимости:**

```xml
<!-- Spring Boot - Application framework -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <version>${spring-boot.version}</version>
</dependency>

<!-- OpenAI Java SDK - For AI API calls -->
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>

<!-- Jackson - JSON processing -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.0</version>
</dependency>
```

**Что они делают:**
- **spring-boot-starter**: Обеспечивает основные функции Spring Boot
- **openai-java**: Официальный Java SDK OpenAI для работы с API
- **jackson-databind**: Обрабатывает сериализацию/десериализацию JSON для API-запросов

## Как все работает вместе

Вот полный процесс работы приложения:

1. **Запуск**: Spring Boot запускается и считывает `application.properties`
2. **Создание сервиса**: Spring создает `FoundryLocalService` и внедряет значения конфигурации
3. **Настройка клиента**: `@PostConstruct` инициализирует клиент OpenAI для подключения к Foundry Local
4. **Выполнение демо**: `CommandLineRunner` выполняется после запуска
5. **Вызов AI**: Демонстрация вызывает `foundryLocalService.chat()` с тестовым сообщением
6. **API-запрос**: Сервис формирует и отправляет запрос, совместимый с OpenAI, в Foundry Local
7. **Обработка ответа**: Сервис извлекает и возвращает ответ AI
8. **Отображение**: Приложение выводит ответ и завершает работу

## Настройка Foundry Local

Чтобы настроить Foundry Local, выполните следующие шаги:

1. **Установите Foundry Local**, следуя инструкциям в разделе [Предварительные требования](../../../../04-PracticalSamples/foundrylocal).
2. **Скачайте модель AI**, которую вы хотите использовать, например, `phi-3.5-mini`, с помощью следующей команды:
   ```bash
   foundry model run phi-3.5-mini
   ```
3. **Настройте файл application.properties** в соответствии с вашими настройками Foundry Local, особенно если вы используете другой порт или модель.

## Запуск приложения

### Шаг 1: Запустите Foundry Local
```bash
foundry model run phi-3.5-mini
```

### Шаг 2: Сборка и запуск приложения
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Ожидаемый результат

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi-3.5, a small language model created by Microsoft. I'm currently running 
as the Phi-3.5-mini-instruct model, which is designed to be helpful, harmless, and honest 
in my interactions. I can assist with a wide variety of tasks including answering 
questions, helping with analysis, creative writing, coding, and general conversation. 
Is there something specific you'd like help with today?
=========================
```

## Следующие шаги

Для дополнительных примеров см. [Глава 04: Практические примеры](../README.md)

## Устранение неполадок

### Распространенные проблемы

**"Connection refused" или "Service unavailable"**
- Убедитесь, что Foundry Local запущен: `foundry model list`
- Проверьте, что сервис работает на порту 5273: проверьте `application.properties`
- Попробуйте перезапустить Foundry Local: `foundry model run phi-3.5-mini`

**Ошибки "Model not found"**
- Проверьте доступные модели: `foundry model list`
- Обновите имя модели в `application.properties`, чтобы оно точно совпадало
- Скачайте модель, если это необходимо: `foundry model run phi-3.5-mini`

**Ошибки компиляции Maven**
- Убедитесь, что установлена Java 21 или выше: `java -version`
- Очистите и пересоберите проект: `mvn clean compile`
- Проверьте подключение к интернету для загрузки зависимостей

**Приложение запускается, но ничего не выводит**
- Убедитесь, что Foundry Local отвечает: откройте браузер на `http://localhost:5273`
- Проверьте логи приложения на наличие сообщений об ошибках
- Убедитесь, что модель полностью загружена и готова к работе

**Отказ от ответственности**:  
Этот документ был переведен с использованием сервиса автоматического перевода [Co-op Translator](https://github.com/Azure/co-op-translator). Хотя мы стремимся к точности, пожалуйста, учитывайте, что автоматические переводы могут содержать ошибки или неточности. Оригинальный документ на его родном языке следует считать авторитетным источником. Для получения критически важной информации рекомендуется профессиональный перевод человеком. Мы не несем ответственности за любые недоразумения или неправильные интерпретации, возникающие в результате использования данного перевода.