# Foundry Local Spring Boot Урок

## Съдържание

- [Предварителни изисквания](#предварителни-изисквания)
- [Преглед на проекта](#преглед-на-проекта)
- [Разбиране на кода](#разбиране-на-кода)
  - [1. Конфигурация на приложението (application.properties)](#1-конфигурация-на-приложението-applicationproperties)
  - [2. Главен клас на приложението (Application.java)](#2-главен-клас-на-приложението-applicationjava)
  - [3. Слой за AI услуги (FoundryLocalService.java)](#3-слой-за-ai-услуги-foundrylocalservicejava)
  - [4. Зависимости на проекта (pom.xml)](#4-зависимости-на-проекта-pomxml)
- [Как всичко работи заедно](#как-всичко-работи-заедно)
- [Настройване на Foundry Local](#настройване-на-foundry-local)
- [Стартиране на приложението](#стартиране-на-приложението)
- [Очакван изход](#очакван-изход)
- [Следващи стъпки](#следващи-стъпки)
- [Отстраняване на проблеми](#отстраняване-на-проблеми)


## Предварителни изисквания

Преди да започнете този урок, уверете се, че имате:

- **Java 21 или по-нова** инсталирана на вашата система
- **Maven 3.6+** за изграждане на проекта
- **Foundry Local** инсталиран и работещ

### **Инсталиране на Foundry Local:**

> **Забележка:** Foundry Local CLI е наличен само за **Windows** и **macOS**. Linux е поддържан чрез [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Проверете инсталацията:
```bash
foundry --version
```

## Преглед на проекта

Този проект се състои от четири основни компонента:

1. **Application.java** - Основната входна точка на Spring Boot приложението
2. **FoundryLocalService.java** - Слоят услуги, който обработва комуникацията с AI
3. **application.properties** - Конфигурация за свързване с Foundry Local
4. **pom.xml** - Maven зависимости и конфигурация на проекта

## Разбиране на кода

### 1. Конфигурация на приложението (application.properties)

**Файл:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Какво прави:**
- **base-url**: Посочва къде работи Foundry Local, включително пътя `/v1` за съвместимост с OpenAI API. По подразбиране портът е `5273`. Ако портът е различен, проверете го с `foundry service status`.
- **model** (по избор): Посочва името на AI модела за генериране на текст. **По подразбиране приложението автоматично открива модела** чрез заявка към `/v1/models` на Foundry Local при стартиране, така че не е необходимо да го задавате. Въпреки това можете да го посочите ръчно, за да презапишете автоматичното откриване.

**Основна концепция:** Spring Boot автоматично зарежда тези свойства и ги прави достъпни в приложението чрез анотацията `@Value`.

### 2. Главен клас на приложението (Application.java)

**Файл:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Не е необходим уеб сървър
        app.run(args);
    }
```

**Какво прави:**
- `@SpringBootApplication` активира автоматичната конфигурация на Spring Boot
- `WebApplicationType.NONE` указва на Spring, че това е командно приложение, а не уеб сървър
- Основният метод стартира Spring приложението

**Демонстрационен изпълнител:**
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

**Какво прави:**
- `@Bean` създава компонент, управляван от Spring
- `CommandLineRunner` изпълнява код след стартирането на Spring Boot
- `foundryLocalService` се инжектира автоматично от Spring (dependency injection)
- Изпраща тестово съобщение към AI и показва отговора

### 3. Слой за AI услуги (FoundryLocalService.java)

**Файл:** `src/main/java/com/example/FoundryLocalService.java`

#### Инжектиране на конфигурацията:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Автоматично засечено, ако е празно
```

**Какво прави:**
- `@Service` казва на Spring, че този клас предоставя бизнес логика
- `@Value` инжектира конфигурационните стойности от application.properties
- Моделът е по подразбиране празен, което задейства **автоматично откриване** от Foundry Local при стартиране. Това означава, че приложението работи с всеки модел, зареден във Foundry Local без ръчна конфигурация.

#### Инициализация на клиента:
```java
@PostConstruct
public void init() {
    // Автоматично откриване на модела от Foundry Local, ако не е конфигуриран изрично
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Базовият URL вече включва /v1 от конфигурацията
            .apiKey("not-needed")            // Локалният сървър не се нуждае от реален API ключ
            .build();
}
```

**Какво прави:**
- `@PostConstruct` изпълнява този метод след създаването на услугата от Spring
- Ако няма зададен модел, дава заявка към `/v1/models` на Foundry Local и избира първия зареден модел
- Създава OpenAI клиент, който сочи към вашия локален Foundry Local
- Базовият URL от `application.properties` вече включва `/v1` за съвместимост с OpenAI API
- API ключът е зададен на "not-needed", тъй като локалната разработка не изисква удостоверяване

#### Метод за чат:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Кой AI модел да използва
                .addUserMessage(message)         // Вашият въпрос/подканване
                .maxCompletionTokens(150)        // Ограничете дължината на отговора
                .temperature(0.7)                // Контролирайте креативността (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Извлечете отговора на AI от резултата на API-то
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**Какво прави:**
- **ChatCompletionCreateParams**: Конфигурира AI заявката
  - `model`: Посочва кой AI модел да се използва (трябва да съвпада с точния ID от `foundry model list`)
  - `addUserMessage`: Добавя вашето съобщение към разговора
  - `maxCompletionTokens`: Ограничва дължината на отговора (спестява ресурси)
  - `temperature`: Контролира случайността (0.0 = детерминистичен, 1.0 = креативен)
- **API заявка**: Изпраща заявката към Foundry Local
- **Обработка на отговор**: Извлича безопасно текстовия отговор от AI
- **Обработка на грешки**: Завива изключения с полезни съобщения за грешка

### 4. Зависимости на проекта (pom.xml)

**Ключови зависимости:**

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

**Какво правят те:**
- **spring-boot-starter**: Осигурява основна функционалност на Spring Boot
- **openai-java**: Официален OpenAI Java SDK за API комуникация
- **jackson-databind**: Обработва сериализация/десериализация на JSON за API обаждания

## Как всичко работи заедно

Ето пълния поток при стартиране на приложението:

1. **Стартиране:** Spring Boot се стартира и чете `application.properties`
2. **Създаване на услугата:** Spring създава `FoundryLocalService` и инжектира конфигурационните стойности
3. **Откриване на модел:** Ако няма конфигуриран модел, услугата прави заявка към `/v1/models` на Foundry Local и автоматично избира първия наличен модел
4. **Настройка на клиента:** `@PostConstruct` инициализира OpenAI клиента за връзка с Foundry Local
5. **Изпълнение на демото:** `CommandLineRunner` се изпълнява след стартирането
6. **AI обаждане:** Демото извиква `foundryLocalService.chat()` с тестово съобщение
7. **API заявка:** Услугата изгражда и изпраща заявка, съвместима с OpenAI, към Foundry Local
8. **Обработка на отговор:** Услугата извлича и връща отговора на AI
9. **Показване:** Приложението отпечатва отговора и излиза

## Настройване на Foundry Local

1. **Инсталирайте Foundry Local** според инструкциите в раздел [Предварителни изисквания](#предварителни-изисквания).

2. **Стартирайте услугата** (ако вече не работи):
   ```bash
   foundry service start
   ```

3. **Проверете статуса на услугата**, за да потвърдите, че работи, и отбележете порта:
   ```bash
   foundry service status
   ```

4. **Свалете и стартирайте модел** (сваля се при първото пускане, кешира се за следващи пускания):
   ```bash
   foundry model run phi-4-mini
   ```
   Това отваря интерактивна чат сесия. Можете да излезете с `Ctrl+C`. Моделът остава зареден в услугата.

   > **Съвет:** Изпълнете `foundry model list`, за да видите всички налични модели. Заместете `phi-4-mini` с всяко алиас от каталога (например, `qwen2.5-0.5b` за по-малък/по-бърз модел).

5. **Проверете дали моделът е зареден:**
   ```bash
   foundry service ps
   ```

6. **Актуализирайте `application.properties`, ако е необходимо:**
   - По подразбиране `base-url` (`http://localhost:5273/v1`) съответства на стандартния CLI порт. Променяйте само ако `foundry service status` показва различен порт.
   - Моделът се **открива автоматично** при стартиране — не се изисква конфигурация.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Стартиране на приложението

### Стъпка 1: Уверете се, че в Foundry Local има зареден модел
```bash
foundry service ps
```
Ако няма налични модели, заредете такъв:
```bash
foundry model run phi-4-mini
```

### Стъпка 2: Компилирайте и стартирайте приложението
В отделен терминал:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Или компилирайте и стартирайте като JAR:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Очакван изход

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

## Следващи стъпки

За повече примери вижте [Глава 04: Практически примери](../README.md)

## Отстраняване на проблеми

### Често срещани проблеми

**"Connection refused" или "Service unavailable"**
- Проверете услугата: `foundry service status`
- Рестартирайте при нужда: `foundry service restart`
- Уверете се, че портът в `application.properties` съвпада с този, показан от `foundry service status`
- Проверете дали URL завършва с `/v1`: `http://localhost:5273/v1`

**"No model found" при стартиране**
- Приложението автоматично открива модел. Уверете се, че има поне един зареден модел: `foundry service ps`
- Ако няма заредени модели: `foundry model run phi-4-mini`
- Ако сте задали ръчно име на модел в `application.properties`, уверете се че съвпада с изхода на `foundry model list`

**Грешки 400 Bad Request**
- Проверете, че базовият URL включва `/v1`: `http://localhost:5273/v1`
- Уверете се, че използвате `maxCompletionTokens()` в кода си (а не остарялото `maxTokens()`)

**Грешки при компилация с Maven**
- Уверете се, че имате Java 21 или по-нова: `java -version`
- Почистете и компилирайте отново: `mvn clean compile`
- Проверете интернет връзката за сваляне на зависимости

**Проблеми с връзката към услугата**
- Ако видите `Request to local service failed`, пуснете: `foundry service restart`
- Проверете заредените модели: `foundry service ps`
- Прегледайте логове на услугата: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Отказ от отговорност**:  
Този документ е преведен с помощта на AI преводаческия сервиз [Co-op Translator](https://github.com/Azure/co-op-translator). Въпреки че се стремим към точност, моля имайте предвид, че автоматизираните преводи могат да съдържат грешки или неточности. Оригиналният документ на неговия роден език трябва да се счита за авторитетен източник. За критична информация се препоръчва професионален човешки превод. Не носим отговорност за каквито и да е недоразумения или погрешни тълкувания, възникнали от използването на този превод.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->