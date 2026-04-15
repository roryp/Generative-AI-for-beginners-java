# Підручник Foundry Local для Spring Boot

## Зміст

- [Вимоги до системи](#вимоги-до-системи)
- [Огляд проекту](#огляд-проекту)
- [Розуміння коду](#розуміння-коду)
  - [1. Конфігурація додатка (application.properties)](#1-конфігурація-додатка-applicationproperties)
  - [2. Основний клас додатка (Application.java)](#2-основний-клас-додатка-applicationjava)
  - [3. Сервісний шар AI (FoundryLocalService.java)](#3-сервісний-шар-ai-foundrylocalservicejava)
  - [4. Залежності проекту (pom.xml)](#4-залежності-проекту-pomxml)
- [Як це працює разом](#як-це-працює-разом)
- [Налаштування Foundry Local](#налаштування-foundry-local)
- [Запуск додатка](#запуск-додатка)
- [Очікуваний результат](#очікуваний-результат)
- [Наступні кроки](#наступні-кроки)
- [Вирішення проблем](#вирішення-проблем)


## Вимоги до системи

Перед початком цього підручника переконайтеся, що у вас встановлено:

- **Java 21 або вище**
- **Maven 3.6+** для збірки проекту
- **Foundry Local** встановлено та запущено

### **Встановлення Foundry Local:**

> **Примітка:** Foundry Local CLI доступний лише для **Windows** та **macOS**. Linux підтримується через [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Перевірка встановлення:
```bash
foundry --version
```

## Огляд проекту

Цей проект складається з чотирьох основних компонентів:

1. **Application.java** - головна точка входу Spring Boot додатка
2. **FoundryLocalService.java** - сервісний шар, що обробляє спілкування з AI
3. **application.properties** - конфігурація підключення Foundry Local
4. **pom.xml** - залежності Maven і налаштування проекту

## Розуміння коду

### 1. Конфігурація додатка (application.properties)

**Файл:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Що це робить:**
- **base-url**: вказує, де запущено Foundry Local, включно з шляхом `/v1` для сумісності з OpenAI API. Порт за замовчуванням `5273`. Якщо порт інший, перевірте за допомогою `foundry service status`.
- **model** (опціонально): ім'я AI-моделі для генерації тексту. **За замовчуванням додаток визначає модель автоматично**, звертаючись до інтерфейсу Foundry Local `/v1/models` на старті, тому вказувати не обов’язково. Можна встановити явно, щоб переоприділити авто-визначення.

**Ключова ідея:** Spring Boot автоматично завантажує ці властивості і робить їх доступними у додатку через анотацію `@Value`.

### 2. Основний клас додатка (Application.java)

**Файл:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Веб-сервер не потрібен
        app.run(args);
    }
```

**Що це робить:**
- `@SpringBootApplication` активує автоконфігурацію Spring Boot
- `WebApplicationType.NONE` вказує, що це консольний додаток, а не веб-сервер
- Головний метод запускає Spring додаток

**Demo Runner:**
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
- `@Bean` створює компонент під управлінням Spring
- `CommandLineRunner` виконує код після запуску Spring Boot
- `foundryLocalService` автоматично впроваджується Spring (впровадження залежностей)
- Надсилає тестове повідомлення AI і виводить відповідь

### 3. Сервісний шар AI (FoundryLocalService.java)

**Файл:** `src/main/java/com/example/FoundryLocalService.java`

#### Впровадження конфігурації:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Автоматично визначено, якщо порожньо
```

**Що це робить:**
- `@Service` позначає цей клас як бізнес-логіку Spring
- `@Value` впроваджує значення конфігурації з application.properties
- За замовчуванням модель порожня, що запускає **автоматичне визначення** з Foundry Local на старті. Отже, додаток працює з будь-якою моделлю, завантаженою у Foundry Local, без необхідності ручного налаштування.

#### Ініціалізація клієнта:
```java
@PostConstruct
public void init() {
    // Автоматично виявляти модель з Foundry Local, якщо вона явно не налаштована
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Базовий URL вже включає /v1 з конфігурації
            .apiKey("not-needed")            // Локальному серверу не потрібен справжній API ключ
            .build();
}
```

**Що це робить:**
- `@PostConstruct` виконує метод після створення сервісу Spring'ом
- Якщо модель не налаштована, робить запит до `/v1/models` Foundry Local і вибирає першу завантажену модель
- Створює OpenAI клієнт, що підключається до місцевої інстанції Foundry Local
- Базова URL з `application.properties` вже містить `/v1` для сумісності з OpenAI API
- Ключ API встановлено в "not-needed", бо локальна розробка не вимагає автентифікації

#### Метод чату:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Яку модель ШІ використовувати
                .addUserMessage(message)         // Ваше питання/підказка
                .maxCompletionTokens(150)        // Обмежити довжину відповіді
                .temperature(0.7)                // Керування креативністю (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Витягнути відповідь ШІ з результату API
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
- **ChatCompletionCreateParams**: налаштовує запит до AI
  - `model`: вказує модель AI (повинна точно відповідати ID з `foundry model list`)
  - `addUserMessage`: додає ваше повідомлення до розмови
  - `maxCompletionTokens`: обмежує довжину відповіді (економить ресурси)
  - `temperature`: керує випадковістю (0.0 = детермінований, 1.0 = креативний)
- **API виклик**: надсилає запит до Foundry Local
- **Обробка відповіді**: безпечно отримує текст відповіді AI
- **Обробка помилок**: обгортає виключення з корисними повідомленнями

### 4. Залежності проекту (pom.xml)

**Ключові залежності:**

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
- **spring-boot-starter**: основний функціонал Spring Boot
- **openai-java**: офіційний Java SDK для OpenAI API
- **jackson-databind**: серіалізація/десеріалізація JSON для API

## Як це працює разом

Ось повний процес під час запуску додатка:

1. **Старт**: Spring Boot запускається і читає `application.properties`
2. **Створення сервісу**: Spring створює `FoundryLocalService` і впроваджує значення конфігурації
3. **Визначення моделі**: Якщо модель не вказана, сервіс запитує Foundry Local `/v1/models` і автоматично обирає першу доступну модель
4. **Підключення клієнта**: `@PostConstruct` ініціалізує OpenAI клієнт для з'єднання з Foundry Local
5. **Виконання демо**: `CommandLineRunner` запускається після старту
6. **Виклик AI**: демо викликає `foundryLocalService.chat()` з тестовим повідомленням
7. **API Запит**: сервіс формує і відправляє сумісний з OpenAI запит до Foundry Local
8. **Обробка відповіді**: сервіс отримує і повертає відповідь AI
9. **Відображення**: додаток друкує відповідь і завершує роботу

## Налаштування Foundry Local

1. **Встановіть Foundry Local** за інструкціями у розділі [Вимоги до системи](#вимоги-до-системи).

2. **Запустіть сервіс** (якщо він ще не працює):
   ```bash
   foundry service start
   ```

3. **Перевірте стан сервісу**, щоб підтвердити роботу і дізнатися порт:
   ```bash
   foundry service status
   ```

4. **Завантажте та запустіть модель** (завантаження при першому запуску, кешується для наступних):
   ```bash
   foundry model run phi-4-mini
   ```
   Це відкриває інтерактивну сесію чату. Вийти можна за допомогою `Ctrl+C`. Модель залишається завантаженою в сервісі.

   > **Підказка:** Виконайте `foundry model list`, щоб побачити всі доступні моделі. Замініть `phi-4-mini` на будь-який псевдонім із каталогу (наприклад, `qwen2.5-0.5b` для меншої/швидшої моделі).

5. **Переконайтеся, що модель завантажена:**
   ```bash
   foundry service ps
   ```

6. **Оновіть `application.properties`, якщо потрібно:**
   - Стандартний `base-url` (`http://localhost:5273/v1`) відповідає порту за замовчуванням CLI. Змінюйте лише у випадку, якщо `foundry service status` показує інший порт.
   - Модель визначається **автоматично** при запуску — ніяких налаштувань не потрібно.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Запуск додатка

### Крок 1: Переконайтеся, що модель завантажена у Foundry Local
```bash
foundry service ps
```
Якщо моделей немає, завантажте одну:
```bash
foundry model run phi-4-mini
```

### Крок 2: Збірка і запуск додатка
В іншому терміналі:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Або збірка і запуск як JAR:
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
Hello! I'm Phi, an AI developed by Microsoft. I can assist with a wide variety of 
tasks including answering questions, helping with analysis, creative writing, coding, 
and general conversation. How can I help you today?
=========================
```

## Наступні кроки

Для більше прикладів дивіться [Розділ 04: Практичні приклади](../README.md)

## Вирішення проблем

### Поширені проблеми

**"Connection refused" або "Service unavailable"**
- Перевірте сервіс: `foundry service status`
- Перезапустіть, якщо потрібно: `foundry service restart`
- Переконайтеся, що порт у `application.properties` збігається з `foundry service status`
- Упевніться, що URL закінчується на `/v1`: `http://localhost:5273/v1`

**"No model found" при запуску**
- Додаток визначає модель автоматично. Переконайтеся, що хоч одна модель завантажена: `foundry service ps`
- Якщо моделей немає: `foundry model run phi-4-mini`
- Якщо ви задали модель явно в `application.properties`, перевірте, що вона співпадає з `foundry model list`

**Помилки "400 Bad Request"**
- Переконайтеся, що базовий URL містить `/v1`: `http://localhost:5273/v1`
- Використовуйте `maxCompletionTokens()`, а не застарілий `maxTokens()`

**Помилки компіляції Maven**
- Впевніться, що у вас Java 21 чи вище: `java -version`
- Очистіть і знову зберіть: `mvn clean compile`
- Перевірте підключення до інтернету для завантаження залежностей

**Проблеми з підключенням до сервісу**
- Якщо бачите `Request to local service failed`, виконайте: `foundry service restart`
- Перевірте завантажені моделі: `foundry service ps`
- Перегляньте логи сервісу: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Відмова від відповідальності**:  
Цей документ було перекладено за допомогою сервісу автоматичного перекладу [Co-op Translator](https://github.com/Azure/co-op-translator). Хоч ми й прагнемо до точності, будь ласка, зверніть увагу, що автоматичні переклади можуть містити помилки або неточності. Оригінальний документ рідною мовою слід вважати авторитетним джерелом. Для критично важливої інформації рекомендується звернутися до професійного людського перекладу. Ми не несемо відповідальності за будь-які непорозуміння чи неправильні тлумачення, що виникли внаслідок використання цього перекладу.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->