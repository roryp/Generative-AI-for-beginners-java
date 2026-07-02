# Foundry Local Spring Boot Туторијал

## Садржај

- [Услови](#услови)
- [Преглед пројекта](#преглед-пројекта)
- [Разумевање кода](#разумевање-кода)
  - [1. Конфигурација апликације (application.properties)](#1-конфигурација-апликације-applicationproperties)
  - [2. Главна апликацијска класа (Application.java)](#2-главна-апликацијска-класа-applicationjava)
  - [3. Слој AI сервиса (FoundryLocalService.java)](#3-слој-ai-сервиса-foundrylocalservicejava)
  - [4. Пројектне зависности (pom.xml)](#4-пројектне-зависности-pomxml)
- [Како све функционише заједно](#како-све-функционише-заједно)
- [Подешавање Foundry Local](#подешавање-foundry-local)
- [Покретање апликације](#покретање-апликације)
- [Очекивани излаз](#очекивани-излаз)
- [Следећи кораци](#следећи-кораци)
- [Решавање проблема](#решавање-проблема)


## Услови

Пре почетка овог туторијала, уверите се да имате:

- **Java 21 или новију** верзију инсталирану на вашем систему
- **Maven 3.6+** за изградњу пројекта
- **Foundry Local** инсталиран и покренут

### **Инсталирање Foundry Local:**

> **Напомена:** Foundry Local CLI је доступан само на **Windows** и **macOS**. Linux је подржан преко [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Виндоус
winget install Microsoft.FoundryLocal

# макОС
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Проверите инсталацију:
```bash
foundry --version
```

## Преглед пројекта

Овај пројекат се састоји од четири главне компоненте:

1. **Application.java** - главна улазна тачка Spring Boot апликације
2. **FoundryLocalService.java** - сервисни слој који обрађује комуникацију са AI-ом
3. **application.properties** - конфигурација за повезивање са Foundry Local
4. **pom.xml** - Maven зависности и конфигурација пројекта

## Разумевање кода

### 1. Конфигурација апликације (application.properties)

**Датотека:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Шта ово ради:**
- **base-url**: Назначује где је покренут Foundry Local, укључујући путању `/v1` ради компатибилности са OpenAI API. Подразумевани порт је `5273`. Ако је порт другачији, проверите га са `foundry service status`.
- **model** (опционо): Назив AI модела за генерисање текста. **Апликација аутоматски детектује модел** тако што на почетку пита Foundry Local `/v1/models` endpoint, па га не морате ручно подешавати. Ипак, можете га ручно поставити да бисте надјачали аутоматско детектовање ако је потребно.

**Кључни концепт:** Spring Boot аутоматски учитава ове особине и чини их доступним апликацији коришћењем анотације `@Value`.

### 2. Главна апликацијска класа (Application.java)

**Датотека:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Није потребан веб сервер
        app.run(args);
    }
```

**Шта ово ради:**
- `@SpringBootApplication` омогућава Spring Boot аутоконфигурацију
- `WebApplicationType.NONE` говори Spring-у да је ово командно-линијска апликација, а не веб сервер
- главна метода покреће Spring апликацију

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

**Шта ово ради:**
- `@Bean` креира компоненту којом управља Spring
- `CommandLineRunner` извршава код након што Spring Boot стартује
- `foundryLocalService` аутоматски убризгава Spring (dependency injection)
- Слање тест поруке AI-у и приказ одговора

### 3. Слој AI сервиса (FoundryLocalService.java)

**Датотека:** `src/main/java/com/example/FoundryLocalService.java`

#### Инјекција конфигурације:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Аутоматски детектовано ако је празно
```

**Шта ово ради:**
- `@Service` говори Spring-у да ова класа пружа бизнис логику
- `@Value` убризгава конфигурационе вредности из application.properties
- Модел подразумевано буде празан, што покреће **аутоматско детектовање** из Foundry Local при покретању. То значи да апликација ради са било којим моделом учитаним у Foundry Local без потребе за ручном конфигурацијом.

#### Иницијализација клијента:
```java
@PostConstruct
public void init() {
    // Аутоматски откриј модел из Foundry Local ако није експлицитно конфигурисан
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Основни URL већ укључује /v1 из конфигурације
            .apiKey("not-needed")            // Локални сервер не захтева прави API кључ
            .build();
}
```

**Шта ово ради:**
- `@PostConstruct` покреће ову методу након што Spring направи сервис
- Ако није конфигурисан модел, упућује захтев Foundry Local `/v1/models` endpoint-у и бира први учитани модел
- Креира OpenAI клијента који показује на вашу локалну Foundry Local инстанцу
- Основни URL из `application.properties` већ укључује `/v1` ради компатибилности са OpenAI API
- API кључ је постављен на "not-needed" јер локални развој не захтева аутентификацију

#### Метода за ћаскање:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Који АИ модел користити
                .addUserMessage(message)         // Ваше питање/упит
                .maxCompletionTokens(150)        // Ограничите дужину одговора
                .temperature(0.7)                // Контролишите креативност (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Извуците одговор АИ из резултата API-ја
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**Шта ово ради:**
- **ChatCompletionCreateParams**: Конфигурише AI захтев
  - `model`: Назначује који AI модел да се користи (мора тачно одговарати ID-у из `foundry model list`)
  - `addUserMessage`: Додаје вашу поруку у разговор
  - `maxCompletionTokens`: Ограничава дужину одговора (чува ресурсе)
  - `temperature`: Контролише степеницу случајности (0.0 = детерминистички, 1.0 = креативан)
- **API позив**: Слање захтева Foundry Local-у
- **Обрада одговора**: Безбедно извлачење текста одговора од AI-а
- **Обрада грешака**: Омотање изузетака са корисним порукама о грешкама

### 4. Пројектне зависности (pom.xml)

**Кључне зависности:**

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

**Шта оне раде:**
- **spring-boot-starter**: Пружа основну Spring Boot функционалност
- **openai-java**: Службени OpenAI Java SDK за комуникацију са API
- **jackson-databind**: Обрађује JSON сериализацију/десериализацију за API позиве

## Како све функционише заједно

Ево комплетног тока када покренете апликацију:

1. **Покретање:** Spring Boot стартује и учитава `application.properties`
2. **Креирање сервиса:** Spring креира `FoundryLocalService` и убризгава конфигурационе вредности
3. **Детекција модела:** Ако модел није конфигурисан, сервис пита Foundry Local `/v1/models` endpoint и аутоматски користи први доступни модел
4. **Подешавање клијента:** `@PostConstruct` иницијализује OpenAI клијента за повезивање са Foundry Local
5. **Извршење демоа:** `CommandLineRunner` се извршава након старта
6. **AI позив:** Демо позива `foundryLocalService.chat()` са тест поруком
7. **API захтев:** Сервис креира и шаље OpenAI-компатибилан захтев Foundry Local-у
8. **Обрада одговора:** Сервис извлачи и враћа одговор AI-а
9. **Приказ:** Апликација исписује одговор и излази

## Подешавање Foundry Local

1. **Инсталирајте Foundry Local** користећи упутства у одељку [Претпоставка](#услови).

2. **Покрените сервис** (ако већ није покренут):
   ```bash
   foundry service start
   ```

3. **Проверите статус сервиса** да бисте били сигурни да ради и запамтите порт:
   ```bash
   foundry service status
   ```

4. **Преузмите и покрените модел** (преузима се приликом првог покретања, касније се кешира):
   ```bash
   foundry model run phi-4-mini
   ```
   Ово отвара интерактивну ћаскање сесију. Излаз из ње је са `Ctrl+C`. Модел остаје учитан у сервису.

   > **Савет:** Покрените `foundry model list` за преглед свих доступних модела. Замените `phi-4-mini` било којим алјасом из каталога (нпр. `qwen2.5-0.5b` за мањи/бржи модел).

5. **Проверите да је модел учитан:**
   ```bash
   foundry service ps
   ```

6. **Ажурирајте `application.properties` ако је потребно:**
   - Подразумевани `base-url` (`http://localhost:5273/v1`) одговара подразумеваном CLI порту. Ажурирајте само ако `foundry service status` прикаже други порт.
   - Модел се **аутоматски детектује** при покретању — није потребна додатна конфигурација.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Покретање апликације

### Корак 1: Уверите се да је модел учитан у Foundry Local
```bash
foundry service ps
```
Ако нема модела, учитајте један:
```bash
foundry model run phi-4-mini
```

### Корак 2: Изградите и покрените апликацију
У другом терминалу:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Или изградите и покрените као JAR:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Очекивани излаз

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

## Следећи кораци

За више примера погледајте [Поглавље 04: Практични примери](../README.md)

## Решавање проблема

### Уобичајени проблеми

**"Connection refused" или "Service unavailable"**
- Проверите сервис: `foundry service status`
- Поново покрените ако је потребно: `foundry service restart`
- Проверите да порт у `application.properties` одговара порталној вредности из `foundry service status`
- Уверите се да URL завршава са `/v1`: `http://localhost:5273/v1`

**"No model found" при покретању**
- Апликација аутоматски детектује модел. Уверите се да је учитан бар један модел: `foundry service ps`
- Ако нема учитаних модела: `foundry model run phi-4-mini`
- Ако сте ручно поставили име модела у `application.properties`, проверите да одговара из `foundry model list`

**Грешке "400 Bad Request"**
- Проверите да основни URL укључује `/v1`: `http://localhost:5273/v1`
- Уверите се да користите `maxCompletionTokens()` у коду (не застарели `maxTokens()`)

**Maven грешке при компилацији**
- Уверите се да имате Java 21 или новију: `java -version`
- Очистите и поново компајлирајте: `mvn clean compile`
- Проверите интернет конекцију за преузимање зависности

**Проблеми са везом ка сервису**
- Ако видите `Request to local service failed`, покрените: `foundry service restart`
- Проверите учитане моделе: `foundry service ps`
- Погледајте логове сервиса: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Одрицање одговорности**:
Овај документ је преведен коришћењем AI преводилачке услуге [Co-op Translator](https://github.com/Azure/co-op-translator). Иако тежимо прецизности, молимо да имате у виду да аутоматизовани преводи могу садржати грешке или нетачности. Оригинални документ на његовом матерњем језику треба сматрати ауторитетом. За критичне информације препоручује се професионални људски превод. Нисмо одговорни за било каква неспоразума или погрешне интерпретације које произилазе из употребе овог превода.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->