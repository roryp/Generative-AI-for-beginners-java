<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "40abf4889418bff189039ac30ff44281",
  "translation_date": "2025-07-23T12:38:55+00:00",
  "source_file": "02-SetupDevEnvironment/README.md",
  "language_code": "sr"
}
-->
# Подешавање Развојног Окружења за Генеративну Вештачку Интелигенцију за Јаву

> **Брзи почетак**: Кодирајте у облаку за 2 минута - Пређите на [Подешавање GitHub Codespaces](../../../02-SetupDevEnvironment) - није потребна локална инсталација и користе се GitHub модели!

> **Интересује вас Azure OpenAI?** Погледајте наш [Водич за подешавање Azure OpenAI](getting-started-azure-openai.md) са корацима за креирање новог Azure OpenAI ресурса.

## Шта ћете научити

- Како подесити развојно окружење за AI апликације у Јави
- Како изабрати и конфигурисати жељено развојно окружење (облак-прво са Codespaces, локални dev container или потпуно локално окружење)
- Како тестирати своје окружење повезивањем са GitHub моделима

## Садржај

- [Шта ћете научити](../../../02-SetupDevEnvironment)
- [Увод](../../../02-SetupDevEnvironment)
- [Корак 1: Подешавање развојног окружења](../../../02-SetupDevEnvironment)
  - [Опција А: GitHub Codespaces (Препоручено)](../../../02-SetupDevEnvironment)
  - [Опција Б: Локални Dev Container](../../../02-SetupDevEnvironment)
  - [Опција В: Коришћење постојеће локалне инсталације](../../../02-SetupDevEnvironment)
- [Корак 2: Креирање GitHub Personal Access Token-а](../../../02-SetupDevEnvironment)
- [Корак 3: Тестирање окружења](../../../02-SetupDevEnvironment)
- [Решавање проблема](../../../02-SetupDevEnvironment)
- [Резиме](../../../02-SetupDevEnvironment)
- [Следећи кораци](../../../02-SetupDevEnvironment)

## Увод

Ово поглавље ће вас водити кроз процес подешавања развојног окружења. Користићемо **GitHub моделе** као примарни пример јер су бесплатни, лако се подешавају само са GitHub налогом, не захтевају кредитну картицу и пружају приступ разним моделима за експериментисање.

**Није потребно локално подешавање!** Можете одмах почети са кодирањем користећи GitHub Codespaces, који пружа потпуно развојно окружење у вашем претраживачу.

<img src="./images/models.webp" alt="Снимак екрана: GitHub модели" width="50%">

Препоручујемо коришћење [**GitHub модела**](https://github.com/marketplace?type=models) за овај курс јер су:
- **Бесплатни** за почетак
- **Лаки** за подешавање само са GitHub налогом
- **Не захтевају кредитну картицу**
- **Пружају више модела** за експериментисање

> **Напомена**: GitHub модели који се користе у овој обуци имају следећа бесплатна ограничења:
> - 15 захтева у минути (150 дневно)
> - ~8,000 речи улаз, ~4,000 речи излаз по захтеву
> - 5 истовремених захтева
> 
> За продукцијску употребу, надоградите на Azure AI Foundry моделе са вашим Azure налогом. Ваш код не мора да се мења. Погледајте [документацију Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/foundry-models/how-to/quickstart-github-models).

## Корак 1: Подешавање развојног окружења

<a name="quick-start-cloud"></a>

Креирали смо унапред конфигурисан развојни контејнер како бисмо минимизирали време подешавања и осигурали да имате све неопходне алате за овај курс о Генеративној Вештачкој Интелигенцији за Јаву. Изаберите жељени приступ развоју:

### Опције за подешавање окружења:

#### Опција А: GitHub Codespaces (Препоручено)

**Почните са кодирањем за 2 минута - није потребно локално подешавање!**

1. Fork-ујте овај репозиторијум на свој GitHub налог  
   > **Напомена**: Ако желите да измените основну конфигурацију, погледајте [Dev Container Configuration](../../../.devcontainer/devcontainer.json)
2. Кликните на **Code** → таб **Codespaces** → **...** → **New with options...**
3. Користите подразумеване вредности – ово ће изабрати **Dev container configuration**: **Generative AI Java Development Environment**, прилагођени devcontainer креиран за овај курс
4. Кликните на **Create codespace**
5. Сачекајте ~2 минута да окружење буде спремно
6. Наставите на [Корак 2: Креирање GitHub Token-а](../../../02-SetupDevEnvironment)

<img src="./images/codespaces.png" alt="Снимак екрана: Codespaces подмени" width="50%">

<img src="./images/image.png" alt="Снимак екрана: New with options" width="50%">

<img src="./images/codespaces-create.png" alt="Снимак екрана: Create codespace options" width="50%">

> **Предности Codespaces-а**:
> - Није потребна локална инсталација
> - Ради на било ком уређају са претраживачем
> - Унапред конфигурисан са свим алатима и зависностима
> - Бесплатно 60 сати месечно за личне налоге
> - Конзистентно окружење за све полазнике

#### Опција Б: Локални Dev Container

**За програмере који преферирају локални развој са Docker-ом**

1. Fork-ујте и клонирајте овај репозиторијум на свој локални рачунар  
   > **Напомена**: Ако желите да измените основну конфигурацију, погледајте [Dev Container Configuration](../../../.devcontainer/devcontainer.json)
2. Инсталирајте [Docker Desktop](https://www.docker.com/products/docker-desktop/) и [VS Code](https://code.visualstudio.com/)
3. Инсталирајте [Dev Containers екстензију](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) у VS Code
4. Отворите фасциклу репозиторијума у VS Code
5. Када се појави упит, кликните на **Reopen in Container** (или користите `Ctrl+Shift+P` → "Dev Containers: Reopen in Container")
6. Сачекајте да се контејнер изгради и покрене
7. Наставите на [Корак 2: Креирање GitHub Token-а](../../../02-SetupDevEnvironment)

<img src="./images/devcontainer.png" alt="Снимак екрана: Подешавање Dev container-а" width="50%">

<img src="./images/image-3.png" alt="Снимак екрана: Завршена изградња Dev container-а" width="50%">

#### Опција В: Коришћење постојеће локалне инсталације

**За програмере са постојећим Java окружењем**

Предуслови:
- [Java 21+](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) 
- [Maven 3.9+](https://maven.apache.org/download.cgi)
- [VS Code](https://code.visualstudio.com) или ваш омиљени IDE

Кораци:
1. Клонирајте овај репозиторијум на свој локални рачунар
2. Отворите пројекат у свом IDE-у
3. Наставите на [Корак 2: Креирање GitHub Token-а](../../../02-SetupDevEnvironment)

> **Савет за професионалце**: Ако имате рачунар са слабим перформансама, али желите VS Code локално, користите GitHub Codespaces! Можете повезати свој локални VS Code са облачно хостованим Codespace-ом за најбоље од оба света.

<img src="./images/image-2.png" alt="Снимак екрана: Креирана локална инстанца devcontainer-а" width="50%">

## Корак 2: Креирање GitHub Personal Access Token-а

1. Идите на [GitHub Settings](https://github.com/settings/profile) и изаберите **Settings** из менија вашег профила.
2. У левом менију кликните на **Developer settings** (обично на дну).
3. Под **Personal access tokens**, кликните на **Fine-grained tokens** (или пратите овај директан [линк](https://github.com/settings/personal-access-tokens)).
4. Кликните на **Generate new token**.
5. У пољу "Token name", унесите описно име (нпр. `GenAI-Java-Course-Token`).
6. Поставите датум истека (препоручено: 7 дана ради безбедности).
7. Под "Resource owner", изаберите свој кориснички налог.
8. Под "Repository access", изаберите репозиторијуме које желите да користите са GitHub моделима (или "All repositories" ако је потребно).
9. Под "Repository permissions", пронађите **Models** и поставите на **Read and write**.
10. Кликните на **Generate token**.
11. **Копирајте и сачувајте свој токен одмах** – нећете моћи поново да га видите!

> **Безбедносни савет**: Користите минимално потребан опсег и најкраћи могући рок истека за своје токене.

## Корак 3: Тестирање окружења са примером GitHub модела

Када је ваше развојно окружење спремно, тестирајте интеграцију GitHub модела са нашим примером апликације у [`02-SetupDevEnvironment/src/github-models`](../../../02-SetupDevEnvironment/src/github-models).

1. Отворите терминал у свом развојном окружењу.
2. Идите до примера GitHub модела:
   ```bash
   cd 02-SetupDevEnvironment/src/github-models
   ```
3. Поставите свој GitHub токен као променљиву окружења:
   ```bash
   # macOS/Linux
   export GITHUB_TOKEN=your_token_here
   
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_token_here"
   ```

4. Покрените апликацију:
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.githubmodels.App"
   ```

Требало би да видите излаз сличан овоме:
```text
Using model: gpt-4.1-nano
Sending request to GitHub Models...
Response: Hello World!
```

### Разумевање пример кода

Прво, хајде да разумемо шта смо управо покренули. Пример у `src/github-models` користи OpenAI Java SDK за повезивање са GitHub моделима:

**Шта овај код ради:**
- **Повезује се** са GitHub моделима користећи ваш personal access token
- **Шаље** једноставну поруку "Say Hello World!" AI моделу
- **Прима** и приказује одговор AI модела
- **Потврђује** да је ваше окружење исправно подешено

**Кључна зависност** (у `pom.xml`):
```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

**Главни код** (`App.java`):
```java
// Connect to GitHub Models using OpenAI Java SDK
OpenAIClient client = OpenAIOkHttpClient.builder()
    .apiKey(pat)
    .baseUrl("https://models.inference.ai.azure.com")
    .build();

// Create chat completion request
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .model(modelId)
    .addSystemMessage("You are a concise assistant.")
    .addUserMessage("Say Hello World!")
    .build();

// Get AI response
ChatCompletion response = client.chat().completions().create(params);
System.out.println("Response: " + response.choices().get(0).message().content().orElse("No response content"));
```

## Резиме

**Честитамо!** Успешно сте:

- **Креирали GitHub Personal Access Token** са одговарајућим дозволама за приступ AI моделима
- **Подесили своје Java развојно окружење** користећи Codespaces, dev container-е или локалну инсталацију
- **Повезали се са GitHub моделима** користећи OpenAI Java SDK за бесплатан приступ AI развоју
- **Тестирали интеграцију** са функционалним примером апликације која комуницира са AI моделима

## Следећи кораци

[Поглавље 3: Основне технике Генеративне Вештачке Интелигенције](../03-CoreGenerativeAITechniques/README.md)

## Решавање проблема

Имате проблема? Ево уобичајених проблема и решења:

- **Токен не ради?** 
  - Уверите се да сте копирали цео токен без додатних размака
  - Проверите да ли је токен исправно постављен као променљива окружења
  - Проверите да ли ваш токен има исправне дозволе (Models: Read and write)

- **Maven није пронађен?** 
  - Ако користите dev container-е/Codespaces, Maven би требало да буде унапред инсталиран
  - За локално окружење, уверите се да су инсталирани Java 21+ и Maven 3.9+
  - Покушајте `mvn --version` да проверите инсталацију

- **Проблеми са повезивањем?** 
  - Проверите своју интернет конекцију
  - Уверите се да је GitHub доступан са ваше мреже
  - Проверите да ли заштитни зид не блокира GitHub Models endpoint

- **Dev container се не покреће?** 
  - Уверите се да је Docker Desktop покренут (за локални развој)
  - Покушајте поново изградити контејнер: `Ctrl+Shift+P` → "Dev Containers: Rebuild Container"

- **Грешке у компилацији апликације?**
  - Уверите се да сте у исправном директоријуму: `02-SetupDevEnvironment/src/github-models`
  - Покушајте очистити и поново изградити: `mvn clean compile`

> **Потребна помоћ?**: И даље имате проблема? Отворите issue у репозиторијуму и помоћи ћемо вам.

**Одрицање од одговорности**:  
Овај документ је преведен коришћењем услуге за превођење помоћу вештачке интелигенције [Co-op Translator](https://github.com/Azure/co-op-translator). Иако се трудимо да обезбедимо тачност, молимо вас да имате у виду да аутоматски преводи могу садржати грешке или нетачности. Оригинални документ на његовом изворном језику треба сматрати меродавним извором. За критичне информације препоручује се професионални превод од стране људи. Не преузимамо одговорност за било каква погрешна тумачења или неспоразуме који могу настати услед коришћења овог превода.