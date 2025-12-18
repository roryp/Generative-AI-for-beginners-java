<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "f787307400de59adc25a1404466a35f3",
  "translation_date": "2025-11-04T07:35:05+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "sr"
}
-->
# Упутство за локални Foundry Spring Boot

## Садржај

- [Предуслови](../../../../04-PracticalSamples/foundrylocal)
- [Преглед пројекта](../../../../04-PracticalSamples/foundrylocal)
- [Разумевање кода](../../../../04-PracticalSamples/foundrylocal)
  - [1. Конфигурација апликације (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. Главна класа апликације (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. Слој AI услуге (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. Зависности пројекта (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [Како све функционише заједно](../../../../04-PracticalSamples/foundrylocal)
- [Подешавање Foundry Local](../../../../04-PracticalSamples/foundrylocal)
- [Покретање апликације](../../../../04-PracticalSamples/foundrylocal)
- [Очекивани резултати](../../../../04-PracticalSamples/foundrylocal)
- [Следећи кораци](../../../../04-PracticalSamples/foundrylocal)
- [Решавање проблема](../../../../04-PracticalSamples/foundrylocal)

## Предуслови

Пре него што започнете ово упутство, уверите се да имате:

- **Java 21 или новију верзију** инсталирану на вашем систему
- **Maven 3.6+** за изградњу пројекта
- **Foundry Local** инсталиран и покренут

### **Инсталирајте Foundry Local:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```


## Преглед пројекта

Овај пројекат се састоји од четири главне компоненте:

1. **Application.java** - Главна улазна тачка Spring Boot апликације
2. **FoundryLocalService.java** - Слој услуге који управља комуникацијом са AI
3. **application.properties** - Конфигурација за повезивање са Foundry Local
4. **pom.xml** - Maven зависности и конфигурација пројекта

## Разумевање кода

### 1. Конфигурација апликације (application.properties)

**Фајл:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```


**Шта ради:**
- **base-url**: Наводи где је покренут Foundry Local, укључујући путању `/v1` за компатибилност са OpenAI API. **Напомена**: Foundry Local динамички додељује порт, па проверите стварни порт користећи `foundry service status`
- **model**: Име AI модела који се користи за генерисање текста, укључујући број верзије (нпр. `:1`). Користите `foundry model list` да видите доступне моделе са њиховим тачним ID-јевима

**Кључни концепт:** Spring Boot аутоматски учитава ове параметре и чини их доступним вашој апликацији користећи `@Value` анотацију.

### 2. Главна класа апликације (Application.java)

**Фајл:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```


**Шта ради:**
- `@SpringBootApplication` омогућава аутоматску конфигурацију Spring Boot-а
- `WebApplicationType.NONE` говори Spring-у да је ово апликација командне линије, а не веб сервер
- Главни метод покреће Spring апликацију

**Демо покретач:**
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


**Шта ради:**
- `@Bean` креира компоненту којом Spring управља
- `CommandLineRunner` извршава код након што се Spring Boot покрене
- `foundryLocalService` се аутоматски убацује од стране Spring-а (убацивање зависности)
- Шаље тест поруку AI-ју и приказује одговор

### 3. Слој AI услуге (FoundryLocalService.java)

**Фајл:** `src/main/java/com/example/FoundryLocalService.java`

#### Убацивање конфигурације:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```


**Шта ради:**
- `@Service` говори Spring-у да ова класа пружа пословну логику
- `@Value` убацује вредности конфигурације из application.properties
- Синтакса `:default-value` пружа резервне вредности ако параметри нису постављени

#### Иницијализација клијента:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```


**Шта ради:**
- `@PostConstruct` извршава овај метод након што Spring креира услугу
- Креира OpenAI клијент који показује на вашу локалну Foundry Local инстанцу
- Основни URL из `application.properties` већ укључује `/v1` за компатибилност са OpenAI API
- API кључ је постављен на "not-needed" јер локални развој не захтева аутентификацију

#### Метод за ћаскање:
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


**Шта ради:**
- **ChatCompletionCreateParams**: Конфигурише AI захтев
  - `model`: Наводи који AI модел се користи (мора се поклапати са тачним ID-јем из `foundry model list`)
  - `addUserMessage`: Додаје вашу поруку у конверзацију
  - `maxCompletionTokens`: Ограничава дужину одговора (штеди ресурсе)
  - `temperature`: Контролише случајност (0.0 = детерминистички, 1.0 = креативно)
- **API позив**: Шаље захтев Foundry Local-у
- **Обрада одговора**: Безбедно извлачи текстуални одговор AI-ја
- **Руковање грешкама**: Обавија изузетке корисним порукама о грешкама

### 4. Зависности пројекта (pom.xml)

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


**Шта раде:**
- **spring-boot-starter**: Пружа основну функционалност Spring Boot-а
- **openai-java**: Званични OpenAI Java SDK за комуникацију са API-јем
- **jackson-databind**: Управља JSON серијализацијом/десеријализацијом за API позиве

## Како све функционише заједно

Ево комплетног тока када покренете апликацију:

1. **Покретање**: Spring Boot се покреће и чита `application.properties`
2. **Креирање услуге**: Spring креира `FoundryLocalService` и убацује вредности конфигурације
3. **Подешавање клијента**: `@PostConstruct` иницијализује OpenAI клијент за повезивање са Foundry Local
4. **Извршење демо-а**: `CommandLineRunner` се извршава након покретања
5. **AI позив**: Демо позива `foundryLocalService.chat()` са тест поруком
6. **API захтев**: Услуга гради и шаље OpenAI-компатибилан захтев Foundry Local-у
7. **Обрада одговора**: Услуга извлачи и враћа одговор AI-ја
8. **Приказ**: Апликација штампа одговор и излази

## Подешавање Foundry Local

Да бисте подесили Foundry Local, следите ове кораке:

1. **Инсталирајте Foundry Local** користећи упутства из секције [Предуслови](../../../../04-PracticalSamples/foundrylocal).

2. **Проверите динамички додељени порт**. Foundry Local аутоматски додељује порт када се покрене. Пронађите ваш порт помоћу:
   ```bash
   foundry service status
   ```
   
   **Опционо**: Ако желите да користите одређени порт (нпр. 5273), можете га ручно конфигурисати:
   ```bash
   foundry service set --port 5273
   ```


3. **Преузмите AI модел** који желите да користите, на пример, `phi-3.5-mini`, помоћу следеће команде:
   ```bash
   foundry model run phi-3.5-mini
   ```


4. **Конфигуришите фајл application.properties** да одговара вашим Foundry Local подешавањима:
   - Ажурирајте порт у `base-url` (из корака 2), осигуравајући да укључује `/v1` на крају
   - Ажурирајте име модела да укључује број верзије (проверите помоћу `foundry model list`)
   
   Пример:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```


## Покретање апликације

### Корак 1: Покрените Foundry Local
```bash
foundry model run phi-3.5-mini
```


### Корак 2: Изградите и покрените апликацију
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```


## Очекивани резултати

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


## Следећи кораци

За више примера, погледајте [Поглавље 04: Практични примери](../README.md)

## Решавање проблема

### Уобичајени проблеми

**"Connection refused" или "Service unavailable"**
- Уверите се да је Foundry Local покренут: `foundry model list`
- Проверите стварни порт који Foundry Local користи: `foundry service status`
- Ажурирајте ваш `application.properties` са исправним портом, осигуравајући да URL завршава са `/v1`
- Алтернативно, поставите одређени порт ако желите: `foundry service set --port 5273`
- Покушајте поново да покренете Foundry Local: `foundry model run phi-3.5-mini`

**"Model not found" или "404 Not Found" грешке**
- Проверите доступне моделе са њиховим тачним ID-јевима: `foundry model list`
- Ажурирајте име модела у `application.properties` да се тачно поклапа, укључујући број верзије (нпр. `Phi-3.5-mini-instruct-cuda-gpu:1`)
- Осигурајте да `base-url` укључује `/v1` на крају: `http://localhost:5273/v1`
- Преузмите модел ако је потребно: `foundry model run phi-3.5-mini`

**"400 Bad Request" грешке**
- Проверите да основни URL укључује `/v1`: `http://localhost:5273/v1`
- Проверите да се ID модела тачно поклапа са оним што је приказано у `foundry model list`
- Осигурајте да користите `maxCompletionTokens()` у вашем коду (а не застарели `maxTokens()`)

**Maven грешке при компилацији**
- Осигурајте Java 21 или новију верзију: `java -version`
- Очистите и поново изградите: `mvn clean compile`
- Проверите интернет конекцију за преузимање зависности

**Апликација се покреће, али нема излазних резултата**
- Проверите да ли Foundry Local одговара: Проверите `http://localhost:5273/v1/models` или покрените `foundry service status`
- Проверите логове апликације за специфичне поруке о грешкама
- Осигурајте да је модел у потпуности учитан и спреман

---

**Одрицање од одговорности**:  
Овај документ је преведен помоћу услуге за превођење уз помоћ вештачке интелигенције [Co-op Translator](https://github.com/Azure/co-op-translator). Иако настојимо да обезбедимо тачност, молимо вас да имате у виду да аутоматски преводи могу садржати грешке или нетачности. Оригинални документ на његовом изворном језику треба сматрати меродавним извором. За критичне информације препоручује се професионални превод од стране људи. Не преузимамо одговорност за било каква погрешна тумачења или неспоразуме који могу настати услед коришћења овог превода.