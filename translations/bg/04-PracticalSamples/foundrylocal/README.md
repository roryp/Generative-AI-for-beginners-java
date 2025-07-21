<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T21:18:33+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "bg"
}
-->
# Локално командно приложение Foundry

>**Забележка**: Тази глава включва [**Ръководство**](./TUTORIAL.md), което ви води през изпълнението на готовите примери.

Просто командно приложение Spring Boot, което демонстрира как да се свържете с Foundry Local, използвайки OpenAI Java SDK.

## Какво ще научите

- Как да интегрирате Foundry Local със Spring Boot приложения, използвайки OpenAI Java SDK
- Най-добри практики за локална AI разработка и тестване

## Съдържание

- [Какво ще научите](../../../../04-PracticalSamples/foundrylocal)
- [Предварителни изисквания](../../../../04-PracticalSamples/foundrylocal)
  - [Инсталиране на Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [Проверка](../../../../04-PracticalSamples/foundrylocal)
- [Конфигурация](../../../../04-PracticalSamples/foundrylocal)
- [Бърз старт](../../../../04-PracticalSamples/foundrylocal)
- [Какво прави приложението](../../../../04-PracticalSamples/foundrylocal)
- [Примерен изход](../../../../04-PracticalSamples/foundrylocal)
- [Архитектура](../../../../04-PracticalSamples/foundrylocal)
- [Ключови моменти в кода](../../../../04-PracticalSamples/foundrylocal)
  - [Интеграция с OpenAI Java SDK](../../../../04-PracticalSamples/foundrylocal)
  - [API за завършване на чат](../../../../04-PracticalSamples/foundrylocal)
- [Отстраняване на проблеми](../../../../04-PracticalSamples/foundrylocal)

## Предварителни изисквания

> **⚠️ Забележка**: Това приложение **не работи в предоставения devcontainer**, тъй като изисква Foundry Local да бъде инсталиран и стартиран на хост системата.

### Инсталиране на Foundry Local

Преди да стартирате това приложение, трябва да инсталирате и стартирате Foundry Local. Следвайте тези стъпки:

1. **Уверете се, че системата ви отговаря на изискванията**:
   - **Операционна система**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025 или macOS
   - **Хардуер**: 
     - Минимум: 8GB RAM, 3GB свободно дисково пространство
     - Препоръчително: 16GB RAM, 15GB свободно дисково пространство
   - **Мрежа**: Интернет връзка за първоначално изтегляне на модела (опционално за офлайн използване)
   - **Ускорение (опционално)**: NVIDIA GPU (серия 2000 или по-нова), AMD GPU (серия 6000 или по-нова), Qualcomm Snapdragon X Elite (8GB или повече памет) или Apple silicon
   - **Разрешения**: Административни права за инсталиране на софтуер на вашето устройство

2. **Инсталирайте Foundry Local**:
   
   **За Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **За macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Алтернативно, можете да изтеглите инсталатора от [GitHub хранилището на Foundry Local](https://github.com/microsoft/Foundry-Local).

3. **Стартирайте първия си модел**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   Моделът ще се изтегли (което може да отнеме няколко минути в зависимост от скоростта на интернет) и след това ще се стартира. Foundry Local автоматично избира най-добрия вариант на модела за вашата система (CUDA за NVIDIA GPU, CPU версия в противен случай).

4. **Тествайте модела**, като зададете въпрос в същия терминал:

   ```bash
   Why is the sky blue?
   ```

   Трябва да видите отговор от модела Phi, обясняващ защо небето изглежда синьо.

### Проверка

Можете да проверите дали всичко работи правилно с тези команди:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

Можете също да посетите `http://localhost:5273` в браузъра си, за да видите уеб интерфейса на Foundry Local.

## Конфигурация

Приложението може да бъде конфигурирано чрез `application.properties`:

- `foundry.local.base-url` - Основен URL за Foundry Local (по подразбиране: http://localhost:5273)
- `foundry.local.model` - AI модел за използване (по подразбиране: Phi-3.5-mini-instruct-cuda-gpu)

> **Забележка**: Името на модела в конфигурацията трябва да съвпада със специфичния вариант, който Foundry Local е изтеглил за вашата система. Когато стартирате `foundry model run phi-3.5-mini`, Foundry Local автоматично избира и изтегля най-добрия вариант (CUDA за NVIDIA GPU, CPU версия в противен случай). Използвайте `foundry model list`, за да видите точното име на модела, наличен във вашата локална инстанция.

## Бърз старт

### 1. Навигирайте до директорията на приложението Foundry Local
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Стартирайте приложението

```bash
mvn spring-boot:run
```

Или изградете и стартирайте JAR файла:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Зависимости

Това приложение използва OpenAI Java SDK за комуникация с Foundry Local. Основната зависимост е:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

Приложението е предварително конфигурирано да се свързва с Foundry Local, работещ на стандартния порт.

## Какво прави приложението

Когато стартирате приложението:

1. **Стартира** като командно приложение (без уеб сървър)
2. **Автоматично изпраща** тестово съобщение: "Здравей! Можеш ли да ми кажеш какво си и кой модел използваш?"
3. **Показва отговора** от Foundry Local в конзолата
4. **Завършва чисто** след демонстрацията

## Примерен изход

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Архитектура

- **Application.java** - Основно Spring Boot приложение с CommandLineRunner
- **FoundryLocalService.java** - Сервиз, който използва OpenAI Java SDK за комуникация с Foundry Local
- Използва **OpenAI Java SDK** за типово безопасни API извиквания
- Автоматична JSON сериализация/десериализация, обработвана от SDK
- Чиста конфигурация с помощта на анотациите `@Value` и `@PostConstruct` на Spring

## Ключови моменти в кода

### Интеграция с OpenAI Java SDK

Приложението използва OpenAI Java SDK за създаване на клиент, конфигуриран за Foundry Local:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### API за завършване на чат

Извикването на заявки за завършване на чат е просто и типово безопасно:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Отстраняване на проблеми

Ако видите грешки при свързване:
1. Уверете се, че Foundry Local работи на `http://localhost:5273`
2. Проверете дали е наличен вариант на модела Phi-3.5-mini с `foundry model list`
3. Уверете се, че името на модела в `application.properties` съвпада с точното име на модела, показано в списъка
4. Уверете се, че няма защитна стена, която блокира връзката

Чести проблеми:
- **Моделът не е намерен**: Стартирайте `foundry model run phi-3.5-mini`, за да изтеглите и стартирате модела
- **Сервизът не работи**: Услугата Foundry Local може да е спряла; рестартирайте я с командата за стартиране на модела
- **Грешно име на модела**: Използвайте `foundry model list`, за да видите наличните модели и актуализирайте конфигурацията си съответно

**Отказ от отговорност**:  
Този документ е преведен с помощта на AI услуга за превод [Co-op Translator](https://github.com/Azure/co-op-translator). Въпреки че се стремим към точност, моля, имайте предвид, че автоматизираните преводи може да съдържат грешки или неточности. Оригиналният документ на неговия роден език трябва да се счита за авторитетен източник. За критична информация се препоръчва професионален човешки превод. Не носим отговорност за недоразумения или погрешни интерпретации, произтичащи от използването на този превод.