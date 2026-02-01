# Учебник по Foundry Local и Spring Boot

## Содержание

- [Предварительные требования](../../../../04-PracticalSamples/foundrylocal)
- [Обзор проекта](../../../../04-PracticalSamples/foundrylocal)
- [Понимание кода](../../../../04-PracticalSamples/foundrylocal)
  - [1. Конфигурация приложения (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. Основной класс приложения (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. Слой сервиса AI (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. Зависимости проекта (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [Как все работает вместе](../../../../04-PracticalSamples/foundrylocal)
- [Настройка Foundry Local](../../../../04-PracticalSamples/foundrylocal)
- [Запуск приложения](../../../../04-PracticalSamples/foundrylocal)
- [Ожидаемый результат](../../../../04-PracticalSamples/foundrylocal)
- [Следующие шаги](../../../../04-PracticalSamples/foundrylocal)
- [Устранение неполадок](../../../../04-PracticalSamples/foundrylocal)

## Предварительные требования

Перед началом работы убедитесь, что у вас установлено:

- **Java 21 или выше** на вашем компьютере
- **Maven 3.6+** для сборки проекта
- **Foundry Local**, установленный и запущенный

### **Установите Foundry Local:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```


## Обзор проекта

Проект состоит из четырех основных компонентов:

1. **Application.java** - основной входной пункт приложения Spring Boot
2. **FoundryLocalService.java** - слой сервиса, который обрабатывает взаимодействие с AI
3. **application.properties** - конфигурация для подключения к Foundry Local
4. **pom.xml** - зависимости Maven и конфигурация проекта

## Понимание кода

### 1. Конфигурация приложения (application.properties)

**Файл:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```


**Что это делает:**
- **base-url**: Указывает, где запущен Foundry Local, включая путь `/v1` для совместимости с API OpenAI. **Примечание**: Foundry Local динамически назначает порт, поэтому проверьте фактический порт с помощью команды `foundry service status`.
- **model**: Указывает имя модели AI для генерации текста, включая номер версии (например, `:1`). Используйте `foundry model list`, чтобы увидеть доступные модели с их точными идентификаторами.

**Ключевая концепция:** Spring Boot автоматически загружает эти свойства и делает их доступными для вашего приложения с помощью аннотации `@Value`.

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
- `WebApplicationType.NONE` указывает Spring, что это консольное приложение, а не веб-сервер
- Основной метод запускает приложение Spring

**Демонстрационный запуск:**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        System.out.println("Calling Foundry Local service...");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
        System.out.println("=========================");
    };
}
```


**Что это делает:**
- `@Bean` создает компонент, управляемый Spring
- `CommandLineRunner` выполняет код после запуска Spring Boot
- `foundryLocalService` автоматически внедряется Spring (внедрение зависимостей)
- Отправляет тестовое сообщение AI и отображает ответ

### 3. Слой сервиса AI (FoundryLocalService.java)

**Файл:** `src/main/java/com/example/FoundryLocalService.java`

#### Внедрение конфигурации:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```


**Что это делает:**
- `@Service` указывает Spring, что этот класс предоставляет бизнес-логику
- `@Value` внедряет значения конфигурации из application.properties
- Синтаксис `:default-value` предоставляет значения по умолчанию, если свойства не установлены

#### Инициализация клиента:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```


**Что это делает:**
- `@PostConstruct` выполняет этот метод после создания сервиса Spring
- Создает клиент OpenAI, который подключается к вашему локальному экземпляру Foundry Local
- Базовый URL из `application.properties` уже включает `/v1` для совместимости с API OpenAI
- API-ключ установлен как "not-needed", так как для локальной разработки аутентификация не требуется

#### Метод общения:
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
  - `model`: Указывает, какую модель AI использовать (должен совпадать с точным идентификатором из `foundry model list`)
  - `addUserMessage`: Добавляет ваше сообщение в разговор
  - `maxCompletionTokens`: Ограничивает длину ответа (экономит ресурсы)
  - `temperature`: Управляет случайностью (0.0 = детерминированный, 1.0 = творческий)
- **API вызов**: Отправляет запрос в Foundry Local
- **Обработка ответа**: Безопасно извлекает текстовый ответ AI
- **Обработка ошибок**: Оборачивает исключения с полезными сообщениями об ошибках

### 4. Зависимости проекта (pom.xml)

**Ключевые зависимости:**

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
- **openai-java**: Официальный Java SDK OpenAI для взаимодействия с API
- **jackson-databind**: Обрабатывает сериализацию/десериализацию JSON для API вызовов

## Как все работает вместе

Вот полный процесс работы приложения:

1. **Запуск**: Spring Boot запускается и считывает `application.properties`
2. **Создание сервиса**: Spring создает `FoundryLocalService` и внедряет значения конфигурации
3. **Настройка клиента**: `@PostConstruct` инициализирует клиент OpenAI для подключения к Foundry Local
4. **Выполнение демонстрации**: `CommandLineRunner` выполняется после запуска
5. **Вызов AI**: Демонстрация вызывает `foundryLocalService.chat()` с тестовым сообщением
6. **Запрос API**: Сервис создает и отправляет запрос, совместимый с OpenAI, в Foundry Local
7. **Обработка ответа**: Сервис извлекает и возвращает ответ AI
8. **Отображение**: Приложение выводит ответ и завершает работу

## Настройка Foundry Local

Чтобы настроить Foundry Local, выполните следующие шаги:

1. **Установите Foundry Local** согласно инструкциям в разделе [Предварительные требования](../../../../04-PracticalSamples/foundrylocal).

2. **Проверьте динамически назначенный порт**. Foundry Local автоматически назначает порт при запуске. Найдите ваш порт с помощью:
   ```bash
   foundry service status
   ```
   
   **Опционально**: Если вы предпочитаете использовать определенный порт (например, 5273), вы можете настроить его вручную:
   ```bash
   foundry service set --port 5273
   ```


3. **Скачайте модель AI**, которую вы хотите использовать, например, `phi-3.5-mini`, с помощью следующей команды:
   ```bash
   foundry model run phi-3.5-mini
   ```


4. **Настройте файл application.properties** в соответствии с вашими настройками Foundry Local:
   - Обновите порт в `base-url` (из шага 2), убедившись, что он включает `/v1` в конце
   - Обновите имя модели, добавив номер версии (проверьте с помощью `foundry model list`)
   
   Пример:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```


## Запуск приложения

### Шаг 1: Запустите Foundry Local
```bash
foundry model run phi-3.5-mini
```


### Шаг 2: Соберите и запустите приложение
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

Для получения дополнительных примеров смотрите [Глава 04: Практические примеры](../README.md)

## Устранение неполадок

### Распространенные проблемы

**"Connection refused" или "Service unavailable"**
- Убедитесь, что Foundry Local запущен: `foundry model list`
- Проверьте фактический порт, который использует Foundry Local: `foundry service status`
- Обновите ваш `application.properties` с правильным портом, убедившись, что URL заканчивается на `/v1`
- Или задайте конкретный порт, если это необходимо: `foundry service set --port 5273`
- Попробуйте перезапустить Foundry Local: `foundry model run phi-3.5-mini`

**"Model not found" или ошибки "404 Not Found"**
- Проверьте доступные модели с их точными идентификаторами: `foundry model list`
- Обновите имя модели в `application.properties`, чтобы оно точно совпадало, включая номер версии (например, `Phi-3.5-mini-instruct-cuda-gpu:1`)
- Убедитесь, что `base-url` включает `/v1` в конце: `http://localhost:5273/v1`
- Скачайте модель, если это необходимо: `foundry model run phi-3.5-mini`

**Ошибки "400 Bad Request"**
- Убедитесь, что базовый URL включает `/v1`: `http://localhost:5273/v1`
- Проверьте, что идентификатор модели точно совпадает с тем, что отображается в `foundry model list`
- Убедитесь, что вы используете `maxCompletionTokens()` в вашем коде (а не устаревший `maxTokens()`)

**Ошибки компиляции Maven**
- Убедитесь, что установлена Java 21 или выше: `java -version`
- Очистите и пересоберите проект: `mvn clean compile`
- Проверьте подключение к интернету для загрузки зависимостей

**Приложение запускается, но нет вывода**
- Убедитесь, что Foundry Local отвечает: Проверьте `http://localhost:5273/v1/models` или выполните `foundry service status`
- Проверьте журналы приложения на наличие конкретных сообщений об ошибках
- Убедитесь, что модель полностью загружена и готова

---

**Отказ от ответственности**:  
Этот документ был переведен с использованием сервиса автоматического перевода [Co-op Translator](https://github.com/Azure/co-op-translator). Несмотря на наши усилия обеспечить точность, автоматические переводы могут содержать ошибки или неточности. Оригинальный документ на его родном языке следует считать авторитетным источником. Для получения критически важной информации рекомендуется профессиональный перевод человеком. Мы не несем ответственности за любые недоразумения или неправильные интерпретации, возникающие в результате использования данного перевода.