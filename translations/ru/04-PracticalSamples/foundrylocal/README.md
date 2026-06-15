# Руководство по Foundry Local и Spring Boot

## Содержание

- [Требования](#требования)
- [Обзор проекта](#обзор-проекта)
- [Понимание кода](#понимание-кода)
  - [1. Конфигурация приложения (application.properties)](#1-конфигурация-приложения-applicationproperties)
  - [2. Основной класс приложения (Application.java)](#2-основной-класс-приложения-applicationjava)
  - [3. Сервисный слой AI (FoundryLocalService.java)](#3-сервисный-слой-ai-foundrylocalservicejava)
  - [4. Зависимости проекта (pom.xml)](#4-зависимости-проекта-pomxml)
- [Как всё работает вместе](#как-всё-работает-вместе)
- [Настройка Foundry Local](#настройка-foundry-local)
- [Запуск приложения](#запуск-приложения)
- [Ожидаемый вывод](#ожидаемый-вывод)
- [Дальнейшие шаги](#дальнейшие-шаги)
- [Устранение неполадок](#устранение-неполадок)


## Требования

Перед началом этого руководства убедитесь, что у вас установлено:

- **Java 21 или выше**
- **Maven 3.6+** для сборки проекта
- **Foundry Local**, установленный и запущенный

### **Установка Foundry Local:**

> **Примечание:** Foundry Local CLI доступен только для **Windows** и **macOS**. Linux поддерживается через [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Проверьте установку:
```bash
foundry --version
```


## Обзор проекта

Проект состоит из четырёх основных компонентов:

1. **Application.java** - основной вход в приложение Spring Boot
2. **FoundryLocalService.java** - сервисный слой для взаимодействия с AI
3. **application.properties** - конфигурация подключения к Foundry Local
4. **pom.xml** - зависимости Maven и конфигурация проекта

## Понимание кода

### 1. Конфигурация приложения (application.properties)

**Файл:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Что делает:**
- **base-url**: Указывает, где запущен Foundry Local, включая путь `/v1` для совместимости с API OpenAI. Порт по умолчанию — `5273`. Если порт отличается, проверьте его командой `foundry service status`.
- **model** (опционально): Имя AI-модели для генерации текста. **По умолчанию приложение автоматически определяет модель** запросом к Foundry Local `/v1/models` при запуске, поэтому задавать её вручную не требуется. Вы можете установить явно для переопределения автоопределения, если нужно.

**Ключевая идея:** Spring Boot автоматически загружает эти свойства и предоставляет их вашему приложению через аннотацию `@Value`.

### 2. Основной класс приложения (Application.java)

**Файл:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Веб-сервер не требуется
        app.run(args);
    }
```

**Что делает:**
- `@SpringBootApplication` включает автоконфигурацию Spring Boot
- `WebApplicationType.NONE` указывает, что это консольное приложение, а не веб-сервер
- Метод main запускает приложение Spring

**Демо-запуск:**
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

**Что делает:**
- `@Bean` создаёт управляемый Spring компонент
- `CommandLineRunner` выполняет код после старта Spring Boot
- `foundryLocalService` автоматически внедряется Spring (внедрение зависимости)
- Отправляет тестовое сообщение AI и выводит ответ

### 3. Сервисный слой AI (FoundryLocalService.java)

**Файл:** `src/main/java/com/example/FoundryLocalService.java`

#### Инъекция конфигурации:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Автоматически обнаружено, если пусто
```

**Что делает:**
- `@Service` указывает Spring, что этот класс содержит бизнес-логику
- `@Value` внедряет значения из application.properties
- Модель по умолчанию пуста, что вызывает **автоопределение** из Foundry Local при запуске. Это позволяет работать с любой загруженной моделью без ручной настройки.

#### Инициализация клиента:
```java
@PostConstruct
public void init() {
    // Автоматическое определение модели из Foundry Local, если явно не настроено
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Базовый URL уже включает /v1 из конфигурации
            .apiKey("not-needed")            // Локальному серверу не нужен настоящий API ключ
            .build();
}
```

**Что делает:**
- `@PostConstruct` выполняет метод после создания сервиса Spring
- Если модель не задана, делает запрос к эндпоинту `/v1/models` Foundry Local и выбирает первую доступную
- Создаёт OpenAI клиент, направленный на локальный Foundry Local
- Базовый URL из `application.properties` уже включает `/v1` для совместимости с OpenAI API
- Ключ API установлен как "not-needed", потому что локальная разработка не требует аутентификации

#### Метод чата:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Какую модель ИИ использовать
                .addUserMessage(message)         // Ваш вопрос/запрос
                .maxCompletionTokens(150)        // Ограничить длину ответа
                .temperature(0.7)                // Управление креативностью (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Извлечь ответ ИИ из результата API
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**Что делает:**
- **ChatCompletionCreateParams**: настраивает запрос к AI
  - `model`: указывает модель AI (должна точно совпадать с ID из `foundry model list`)
  - `addUserMessage`: добавляет ваше сообщение в разговор
  - `maxCompletionTokens`: ограничивает длину ответа (экономит ресурсы)
  - `temperature`: регулирует степень случайности (0.0 = детерминированный, 1.0 = творческий)
- **API-вызов**: отправляет запрос в Foundry Local
- **Обработка ответа**: безопасно извлекает текст ответа AI
- **Обработка ошибок**: оборачивает исключения с полезными сообщениями

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

**Что делают:**
- **spring-boot-starter**: основные возможности Spring Boot
- **openai-java**: официальный OpenAI Java SDK для API
- **jackson-databind**: сериализация/десериализация JSON для API вызовов

## Как всё работает вместе

Полный процесс работы при запуске приложения:

1. **Запуск:** Spring Boot стартует и читает `application.properties`
2. **Создание сервиса:** Spring создаёт `FoundryLocalService` и внедряет конфигурационные значения
3. **Определение модели:** Если модель не указана, сервис запрашивает `/v1/models` Foundry Local и автоматически выбирает первую модель
4. **Настройка клиента:** `@PostConstruct` инициализирует OpenAI клиент для подключения к Foundry Local
5. **Выполнение демонстрации:** `CommandLineRunner` запускается после старта
6. **Вызов AI:** демонстрация вызывает `foundryLocalService.chat()` с тестовым сообщением
7. **Отправка запроса:** сервис формирует и отправляет совместимый с OpenAI запрос в Foundry Local
8. **Обработка ответа:** сервис извлекает и возвращает ответ AI
9. **Вывод:** приложение выводит ответ и завершает работу

## Настройка Foundry Local

1. **Установите Foundry Local** согласно инструкциям в разделе [Требования](#требования).

2. **Запустите сервис** (если ещё не запущен):
   ```bash
   foundry service start
   ```

3. **Проверьте статус сервиса** чтобы убедиться, что он запущен и узнайте порт:
   ```bash
   foundry service status
   ```

4. **Загрузите и запустите модель** (скачивается при первом запуске, кэшируется для последующих):
   ```bash
   foundry model run phi-4-mini
   ```
  
   Это открывает интерактивную сессию чата. Выход — `Ctrl+C`. Модель остаётся загруженной в сервисе.

   > **Совет:** Выполните `foundry model list` для просмотра доступных моделей. Замените `phi-4-mini` на любой алиас из каталога (например, `qwen2.5-0.5b` для более компактной/быстрой модели).

5. **Проверьте, что модель загружена:**
   ```bash
   foundry service ps
   ```

6. **Обновите `application.properties`, если нужно:**
   - По умолчанию `base-url` (`http://localhost:5273/v1`) совпадает с портом CLI по умолчанию. Меняйте только если `foundry service status` покажет другой порт.
   - Модель **определяется автоматически** при запуске — настройка не требуется.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```


## Запуск приложения

### Шаг 1: Убедитесь, что модель загружена в Foundry Local
```bash
foundry service ps
```

Если моделей нет, загрузите одну:
```bash
foundry model run phi-4-mini
```


### Шаг 2: Соберите и запустите приложение
В отдельном терминале:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Или соберите и запустите JAR:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```


## Ожидаемый вывод

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI developed by Microsoft. I can assist with a wide variety of 
tasks including answering questions, helping with analysis, creative writing, coding, 
and general conversation. How can I help you today?
=========================
```


## Дальнейшие шаги

Для дополнительных примеров см. [Глава 04: Практические примеры](../README.md)

## Устранение неполадок

### Распространённые проблемы

**"Connection refused" или "Service unavailable"**
- Проверьте сервис: `foundry service status`
- Перезапустите при необходимости: `foundry service restart`
- Убедитесь, что порт в `application.properties` совпадает с выводом `foundry service status`
- Проверьте, что URL заканчивается на `/v1`: `http://localhost:5273/v1`

**"No model found" при запуске**
- Приложение автоматически определяет модель. Убедитесь, что хотя бы одна модель загружена: `foundry service ps`
- Если моделей нет: `foundry model run phi-4-mini`
- Если вы указали название модели в `application.properties`, убедитесь, что оно совпадает с `foundry model list`

**Ошибки "400 Bad Request"**
- Проверьте, что базовый URL включает `/v1`: `http://localhost:5273/v1`
- Используйте в коде `maxCompletionTokens()`, а не устаревший `maxTokens()`

**Ошибки компиляции Maven**
- Проверьте версию Java: `java -version` (должна быть 21 или выше)
- Очистите и пересоберите: `mvn clean compile`
- Убедитесь в доступности интернета для загрузки зависимостей

**Проблемы с подключением к сервису**
- Если появляется ошибка `Request to local service failed`, выполните: `foundry service restart`
- Проверьте загруженные модели: `foundry service ps`
- Посмотрите логи сервиса: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Отказ от ответственности**:  
Этот документ был переведен с помощью сервиса машинного перевода [Co-op Translator](https://github.com/Azure/co-op-translator). Несмотря на наши усилия обеспечить точность, имейте в виду, что автоматический перевод может содержать ошибки или неточности. Оригинальный документ на его исходном языке следует считать авторитетным источником. Для важной информации рекомендуется профессиональный перевод человеком. Мы не несем ответственности за любые недоразумения или неправильные толкования, возникшие в результате использования этого перевода.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->