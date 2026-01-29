# Локальний підручник Foundry Spring Boot

## Зміст

- [Передумови](../../../../04-PracticalSamples/foundrylocal)
- [Огляд проекту](../../../../04-PracticalSamples/foundrylocal)
- [Розуміння коду](../../../../04-PracticalSamples/foundrylocal)
  - [1. Конфігурація додатку (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. Головний клас додатку (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. Сервісний шар AI (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. Залежності проекту (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [Як усе працює разом](../../../../04-PracticalSamples/foundrylocal)
- [Налаштування Foundry Local](../../../../04-PracticalSamples/foundrylocal)
- [Запуск додатку](../../../../04-PracticalSamples/foundrylocal)
- [Очікуваний результат](../../../../04-PracticalSamples/foundrylocal)
- [Наступні кроки](../../../../04-PracticalSamples/foundrylocal)
- [Вирішення проблем](../../../../04-PracticalSamples/foundrylocal)

## Передумови

Перед початком цього підручника переконайтеся, що у вас є:

- **Java 21 або новіша версія**, встановлена на вашій системі
- **Maven 3.6+** для збірки проекту
- **Foundry Local**, встановлений і запущений

### **Встановлення Foundry Local:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```

## Огляд проекту

Цей проект складається з чотирьох основних компонентів:

1. **Application.java** - головна точка входу Spring Boot додатку
2. **FoundryLocalService.java** - сервісний шар, який обробляє комунікацію з AI
3. **application.properties** - конфігурація для підключення до Foundry Local
4. **pom.xml** - залежності Maven і конфігурація проекту

## Розуміння коду

### 1. Конфігурація додатку (application.properties)

**Файл:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```

**Що це робить:**
- **base-url**: Вказує, де запущений Foundry Local, включаючи шлях `/v1` для сумісності з OpenAI API. **Примітка**: Foundry Local динамічно призначає порт, тому перевірте фактичний порт за допомогою `foundry service status`
- **model**: Назва AI моделі для генерації тексту, включаючи номер версії (наприклад, `:1`). Використовуйте `foundry model list`, щоб побачити доступні моделі з їх точними ідентифікаторами

**Ключова концепція:** Spring Boot автоматично завантажує ці властивості та робить їх доступними для вашого додатку за допомогою анотації `@Value`.

### 2. Головний клас додатку (Application.java)

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

**Що це робить:**
- `@SpringBootApplication` активує автоматичну конфігурацію Spring Boot
- `WebApplicationType.NONE` вказує Spring, що це консольний додаток, а не веб-сервер
- Головний метод запускає Spring додаток

**Демонстраційний запуск:**
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

**Що це робить:**
- `@Bean` створює компонент, який управляється Spring
- `CommandLineRunner` виконує код після запуску Spring Boot
- `foundryLocalService` автоматично впроваджується Spring (впровадження залежностей)
- Надсилає тестове повідомлення до AI і відображає відповідь

### 3. Сервісний шар AI (FoundryLocalService.java)

**Файл:** `src/main/java/com/example/FoundryLocalService.java`

#### Впровадження конфігурації:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```

**Що це робить:**
- `@Service` вказує Spring, що цей клас надає бізнес-логіку
- `@Value` впроваджує значення конфігурації з application.properties
- Синтаксис `:default-value` забезпечує резервні значення, якщо властивості не встановлені

#### Ініціалізація клієнта:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```

**Що це робить:**
- `@PostConstruct` запускає цей метод після створення сервісу Spring
- Створює клієнт OpenAI, який підключається до вашого локального Foundry Local
- Базовий URL з `application.properties` вже включає `/v1` для сумісності з OpenAI API
- API ключ встановлений як "not-needed", оскільки локальна розробка не потребує аутентифікації

#### Метод чату:
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

**Що це робить:**
- **ChatCompletionCreateParams**: Налаштовує запит до AI
  - `model`: Вказує, яку AI модель використовувати (має точно відповідати ідентифікатору з `foundry model list`)
  - `addUserMessage`: Додає ваше повідомлення до розмови
  - `maxCompletionTokens`: Обмежує довжину відповіді (економить ресурси)
  - `temperature`: Контролює випадковість (0.0 = детермінованість, 1.0 = креативність)
- **API виклик**: Надсилає запит до Foundry Local
- **Обробка відповіді**: Безпечно витягує текстову відповідь AI
- **Обробка помилок**: Обгортає виключення з корисними повідомленнями про помилки

### 4. Залежності проекту (pom.xml)

**Основні залежності:**

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

**Що вони роблять:**
- **spring-boot-starter**: Забезпечує основну функціональність Spring Boot
- **openai-java**: Офіційний Java SDK OpenAI для API комунікації
- **jackson-databind**: Обробляє серіалізацію/десеріалізацію JSON для API викликів

## Як усе працює разом

Ось повний процес, коли ви запускаєте додаток:

1. **Запуск**: Spring Boot запускається і читає `application.properties`
2. **Створення сервісу**: Spring створює `FoundryLocalService` і впроваджує значення конфігурації
3. **Налаштування клієнта**: `@PostConstruct` ініціалізує клієнт OpenAI для підключення до Foundry Local
4. **Виконання демо**: `CommandLineRunner` виконується після запуску
5. **Виклик AI**: Демо викликає `foundryLocalService.chat()` з тестовим повідомленням
6. **Запит API**: Сервіс створює і надсилає запит, сумісний з OpenAI, до Foundry Local
7. **Обробка відповіді**: Сервіс витягує і повертає відповідь AI
8. **Відображення**: Додаток друкує відповідь і завершує роботу

## Налаштування Foundry Local

Щоб налаштувати Foundry Local, виконайте наступні кроки:

1. **Встановіть Foundry Local** за інструкціями в розділі [Передумови](../../../../04-PracticalSamples/foundrylocal).

2. **Перевірте динамічно призначений порт**. Foundry Local автоматично призначає порт при запуску. Знайдіть ваш порт за допомогою:
   ```bash
   foundry service status
   ```
   
   **Опціонально**: Якщо ви віддаєте перевагу використовувати конкретний порт (наприклад, 5273), ви можете налаштувати його вручну:
   ```bash
   foundry service set --port 5273
   ```

3. **Завантажте AI модель**, яку ви хочете використовувати, наприклад, `phi-3.5-mini`, за допомогою наступної команди:
   ```bash
   foundry model run phi-3.5-mini
   ```

4. **Налаштуйте файл application.properties** відповідно до ваших налаштувань Foundry Local:
   - Оновіть порт у `base-url` (з кроку 2), переконавшись, що він включає `/v1` в кінці
   - Оновіть назву моделі, включаючи номер версії (перевірте за допомогою `foundry model list`)
   
   Приклад:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```

## Запуск додатку

### Крок 1: Запустіть Foundry Local
```bash
foundry model run phi-3.5-mini
```

### Крок 2: Зберіть і запустіть додаток
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Очікуваний результат

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

## Наступні кроки

Для отримання додаткових прикладів дивіться [Розділ 04: Практичні приклади](../README.md)

## Вирішення проблем

### Поширені проблеми

**"Connection refused" або "Service unavailable"**
- Переконайтеся, що Foundry Local запущений: `foundry model list`
- Перевірте фактичний порт, який використовує Foundry Local: `foundry service status`
- Оновіть ваш `application.properties` з правильним портом, переконавшись, що URL закінчується на `/v1`
- Альтернативно, встановіть конкретний порт, якщо це необхідно: `foundry service set --port 5273`
- Спробуйте перезапустити Foundry Local: `foundry model run phi-3.5-mini`

**"Model not found" або "404 Not Found" помилки**
- Перевірте доступні моделі з їх точними ідентифікаторами: `foundry model list`
- Оновіть назву моделі в `application.properties`, щоб вона точно відповідала, включаючи номер версії (наприклад, `Phi-3.5-mini-instruct-cuda-gpu:1`)
- Переконайтеся, що `base-url` включає `/v1` в кінці: `http://localhost:5273/v1`
- Завантажте модель, якщо це необхідно: `foundry model run phi-3.5-mini`

**"400 Bad Request" помилки**
- Переконайтеся, що базовий URL включає `/v1`: `http://localhost:5273/v1`
- Перевірте, що ідентифікатор моделі точно відповідає тому, що показано в `foundry model list`
- Переконайтеся, що ви використовуєте `maxCompletionTokens()` у вашому коді (а не застарілий `maxTokens()`)

**Помилки компіляції Maven**
- Переконайтеся, що у вас встановлена Java 21 або новіша: `java -version`
- Очистіть і зберіть проект заново: `mvn clean compile`
- Перевірте інтернет-з'єднання для завантаження залежностей

**Додаток запускається, але немає результату**
- Переконайтеся, що Foundry Local відповідає: Перевірте `http://localhost:5273/v1/models` або запустіть `foundry service status`
- Перевірте журнали додатку на наявність конкретних повідомлень про помилки
- Переконайтеся, що модель повністю завантажена і готова

---

**Відмова від відповідальності**:  
Цей документ був перекладений за допомогою сервісу автоматичного перекладу [Co-op Translator](https://github.com/Azure/co-op-translator). Хоча ми прагнемо до точності, будь ласка, майте на увазі, що автоматичні переклади можуть містити помилки або неточності. Оригінальний документ на його рідній мові слід вважати авторитетним джерелом. Для критичної інформації рекомендується професійний людський переклад. Ми не несемо відповідальності за будь-які непорозуміння або неправильні тлумачення, що виникають внаслідок використання цього перекладу.