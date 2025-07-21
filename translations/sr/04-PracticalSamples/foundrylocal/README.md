<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T21:18:58+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "sr"
}
-->
# Локална командна апликација Foundry

>**Напомена**: Ово поглавље укључује [**Туторијал**](./TUTORIAL.md) који вас води кроз покретање готових примера.

Једноставна Spring Boot командна апликација која демонстрира како се повезати са Foundry Local користећи OpenAI Java SDK.

## Шта ћете научити

- Како интегрисати Foundry Local са Spring Boot апликацијама користећи OpenAI Java SDK
- Најбоље праксе за локални развој и тестирање AI-а

## Садржај

- [Шта ћете научити](../../../../04-PracticalSamples/foundrylocal)
- [Предуслови](../../../../04-PracticalSamples/foundrylocal)
  - [Инсталирање Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [Верификација](../../../../04-PracticalSamples/foundrylocal)
- [Конфигурација](../../../../04-PracticalSamples/foundrylocal)
- [Брзи почетак](../../../../04-PracticalSamples/foundrylocal)
- [Шта апликација ради](../../../../04-PracticalSamples/foundrylocal)
- [Пример излаз](../../../../04-PracticalSamples/foundrylocal)
- [Архитектура](../../../../04-PracticalSamples/foundrylocal)
- [Кључни делови кода](../../../../04-PracticalSamples/foundrylocal)
  - [Интеграција OpenAI Java SDK-а](../../../../04-PracticalSamples/foundrylocal)
  - [API за завршетак разговора](../../../../04-PracticalSamples/foundrylocal)
- [Решавање проблема](../../../../04-PracticalSamples/foundrylocal)

## Предуслови

> **⚠️ Напомена**: Ова апликација **не ради у приложеном devcontainer-у** јер захтева да Foundry Local буде инсталиран и покренут на хост систему.

### Инсталирање Foundry Local

Пре него што покренете ову апликацију, потребно је да инсталирате и покренете Foundry Local. Пратите ове кораке:

1. **Уверите се да ваш систем испуњава захтеве**:
   - **Оперативни систем**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025 или macOS
   - **Хардвер**: 
     - Минимум: 8GB RAM-а, 3GB слободног простора на диску
     - Препоручено: 16GB RAM-а, 15GB слободног простора на диску
   - **Мрежа**: Интернет конекција за почетно преузимање модела (опционо за офлајн коришћење)
   - **Убрзање (опционо)**: NVIDIA GPU (2,000 серија или новије), AMD GPU (6,000 серија или новије), Qualcomm Snapdragon X Elite (8GB или више меморије) или Apple silicon
   - **Дозволе**: Административне привилегије за инсталирање софтвера на вашем уређају

2. **Инсталирајте Foundry Local**:
   
   **За Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **За macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Алтернативно, можете преузети инсталер са [Foundry Local GitHub репозиторијума](https://github.com/microsoft/Foundry-Local).

3. **Покрените свој први модел**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   Модел се преузима (што може потрајати неколико минута, у зависности од брзине интернета) и затим се покреће. Foundry Local аутоматски бира најбољу варијанту модела за ваш систем (CUDA за NVIDIA GPU-ове, CPU верзија у супротном).

4. **Тестирајте модел** постављањем питања у истом терминалу:

   ```bash
   Why is the sky blue?
   ```

   Требало би да видите одговор од Phi модела који објашњава зашто небо изгледа плаво.

### Верификација

Можете проверити да ли све ради исправно помоћу ових команди:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

Такође можете посетити `http://localhost:5273` у вашем претраживачу да бисте видели веб интерфејс Foundry Local-а.

## Конфигурација

Апликација се може конфигурисати преко `application.properties`:

- `foundry.local.base-url` - Основни URL за Foundry Local (подразумевано: http://localhost:5273)
- `foundry.local.model` - AI модел који се користи (подразумевано: Phi-3.5-mini-instruct-cuda-gpu)

> **Напомена**: Назив модела у конфигурацији треба да одговара специфичној варијанти коју је Foundry Local преузео за ваш систем. Када покренете `foundry model run phi-3.5-mini`, Foundry Local аутоматски бира и преузима најбољу варијанту (CUDA за NVIDIA GPU-ове, CPU верзија у супротном). Користите `foundry model list` да бисте видели тачан назив модела доступан у вашој локалној инстанци.

## Брзи почетак

### 1. Навигирајте до директоријума апликације Foundry Local
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Покрените апликацију

```bash
mvn spring-boot:run
```

Или изградите и покрените JAR:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Зависности

Ова апликација користи OpenAI Java SDK за комуникацију са Foundry Local-ом. Кључна зависност је:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

Апликација је унапред конфигурисана за повезивање са Foundry Local-ом који ради на подразумеваном порту.

## Шта апликација ради

Када покренете апликацију:

1. **Покреће се** као командна апликација (без веб сервера)
2. **Аутоматски шаље** тест поруку: "Здраво! Можете ли ми рећи шта сте и који модел користите?"
3. **Приказује одговор** од Foundry Local-а у конзоли
4. **Чисто излази** након демонстрације

## Пример излаз

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Архитектура

- **Application.java** - Главна Spring Boot апликација са CommandLineRunner-ом
- **FoundryLocalService.java** - Сервис који користи OpenAI Java SDK за комуникацију са Foundry Local-ом
- Користи **OpenAI Java SDK** за типски сигурне API позиве
- Аутоматска JSON серијализација/десеријализација коју обрађује SDK
- Чиста конфигурација користећи Spring-ове `@Value` и `@PostConstruct` анотације

## Кључни делови кода

### Интеграција OpenAI Java SDK-а

Апликација користи OpenAI Java SDK за креирање клијента конфигурисаног за Foundry Local:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### API за завршетак разговора

Прављење захтева за завршетак разговора је једноставно и типски сигурно:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Решавање проблема

Ако видите грешке у вези:
1. Проверите да ли Foundry Local ради на `http://localhost:5273`
2. Проверите да ли је варијанта модела Phi-3.5-mini доступна помоћу `foundry model list`
3. Уверите се да назив модела у `application.properties` одговара тачном називу модела приказаном на листи
4. Уверите се да ниједан заштитни зид не блокира везу

Чести проблеми:
- **Модел није пронађен**: Покрените `foundry model run phi-3.5-mini` да бисте преузели и покренули модел
- **Сервис не ради**: Сервис Foundry Local можда је престао са радом; поново га покрените командом за покретање модела
- **Погрешан назив модела**: Користите `foundry model list` да бисте видели доступне моделе и ажурирали своју конфигурацију у складу с тим

**Одрицање од одговорности**:  
Овај документ је преведен коришћењем услуге за превођење помоћу вештачке интелигенције [Co-op Translator](https://github.com/Azure/co-op-translator). Иако настојимо да обезбедимо тачност, молимо вас да имате у виду да аутоматски преводи могу садржати грешке или нетачности. Оригинални документ на његовом изворном језику треба сматрати меродавним извором. За критичне информације препоручује се професионални превод од стране људи. Не преузимамо одговорност за било каква погрешна тумачења или неспоразуме који могу настати услед коришћења овог превода.