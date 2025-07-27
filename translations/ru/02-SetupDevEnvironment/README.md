<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c670445516e119888d8aaaa207bbee34",
  "translation_date": "2025-07-27T12:50:26+00:00",
  "source_file": "02-SetupDevEnvironment/README.md",
  "language_code": "ru"
}
-->
# Настройка среды разработки для Generative AI на Java

> **Быстрый старт**: Код в облаке за 2 минуты — перейдите к [Настройке GitHub Codespaces](../../../02-SetupDevEnvironment) — без необходимости локальной установки, с использованием моделей GitHub!

> **Интересует Azure OpenAI?** Ознакомьтесь с нашим [Руководством по настройке Azure OpenAI](getting-started-azure-openai.md), где описаны шаги по созданию нового ресурса Azure OpenAI.

## Чему вы научитесь

- Настраивать среду разработки Java для AI-приложений
- Выбирать и конфигурировать предпочитаемую среду разработки (облачную с Codespaces, локальный dev-контейнер или полную локальную установку)
- Тестировать настройку, подключаясь к моделям GitHub

## Содержание

- [Чему вы научитесь](../../../02-SetupDevEnvironment)
- [Введение](../../../02-SetupDevEnvironment)
- [Шаг 1: Настройка среды разработки](../../../02-SetupDevEnvironment)
  - [Вариант A: GitHub Codespaces (рекомендуется)](../../../02-SetupDevEnvironment)
  - [Вариант B: Локальный dev-контейнер](../../../02-SetupDevEnvironment)
  - [Вариант C: Использование существующей локальной установки](../../../02-SetupDevEnvironment)
- [Шаг 2: Создание персонального токена доступа GitHub](../../../02-SetupDevEnvironment)
- [Шаг 3: Тестирование настройки](../../../02-SetupDevEnvironment)
- [Устранение неполадок](../../../02-SetupDevEnvironment)
- [Итоги](../../../02-SetupDevEnvironment)
- [Следующие шаги](../../../02-SetupDevEnvironment)

## Введение

В этой главе вы узнаете, как настроить среду разработки. Мы будем использовать **GitHub Models** в качестве основного примера, так как это бесплатно, легко настраивается с помощью учетной записи GitHub, не требует кредитной карты и предоставляет доступ к нескольким моделям для экспериментов.

**Локальная установка не требуется!** Вы можете начать кодить сразу, используя GitHub Codespaces, который предоставляет полную среду разработки прямо в вашем браузере.

<img src="./images/models.webp" alt="Скриншот: GitHub Models" width="50%">

Мы рекомендуем использовать [**GitHub Models**](https://github.com/marketplace?type=models) для этого курса, потому что это:
- **Бесплатно** для начала работы
- **Просто** в настройке с учетной записью GitHub
- **Не требуется кредитная карта**
- **Несколько моделей** доступны для экспериментов

> **Примечание**: Модели GitHub, используемые в этом обучении, имеют следующие бесплатные ограничения:
> - 15 запросов в минуту (150 в день)
> - ~8,000 слов на входе, ~4,000 слов на выходе за запрос
> - 5 одновременных запросов
> 
> Для использования в продакшене обновитесь до Azure AI Foundry Models с вашей учетной записью Azure. Ваш код не нужно менять. См. [документацию Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/foundry-models/how-to/quickstart-github-models).

## Шаг 1: Настройка среды разработки

<a name="quick-start-cloud"></a>

Мы создали предварительно настроенный контейнер разработки, чтобы минимизировать время настройки и обеспечить наличие всех необходимых инструментов для этого курса по Generative AI на Java. Выберите предпочитаемый подход к разработке:

### Варианты настройки среды:

#### Вариант A: GitHub Codespaces (рекомендуется)

**Начните кодить за 2 минуты — локальная настройка не требуется!**

1. Форкните этот репозиторий в свой аккаунт GitHub  
   > **Примечание**: Если вы хотите изменить базовую конфигурацию, ознакомьтесь с [конфигурацией dev-контейнера](../../../.devcontainer/devcontainer.json)
2. Нажмите **Code** → вкладка **Codespaces** → **...** → **New with options...**
3. Используйте настройки по умолчанию — это выберет **конфигурацию dev-контейнера**: **Generative AI Java Development Environment**, созданную для этого курса
4. Нажмите **Create codespace**
5. Подождите ~2 минуты, пока среда будет готова
6. Перейдите к [Шагу 2: Создание токена GitHub](../../../02-SetupDevEnvironment)

<img src="./images/codespaces.png" alt="Скриншот: подменю Codespaces" width="50%">

<img src="./images/image.png" alt="Скриншот: New with options" width="50%">

<img src="./images/codespaces-create.png" alt="Скриншот: параметры создания Codespace" width="50%">

> **Преимущества Codespaces**:
> - Локальная установка не требуется
> - Работает на любом устройстве с браузером
> - Предварительно настроено со всеми инструментами и зависимостями
> - Бесплатно 60 часов в месяц для личных аккаунтов
> - Единая среда для всех участников

#### Вариант B: Локальный dev-контейнер

**Для разработчиков, предпочитающих локальную разработку с Docker**

1. Форкните и клонируйте этот репозиторий на свой локальный компьютер  
   > **Примечание**: Если вы хотите изменить базовую конфигурацию, ознакомьтесь с [конфигурацией dev-контейнера](../../../.devcontainer/devcontainer.json)
2. Установите [Docker Desktop](https://www.docker.com/products/docker-desktop/) и [VS Code](https://code.visualstudio.com/)
3. Установите расширение [Dev Containers](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) в VS Code
4. Откройте папку репозитория в VS Code
5. При появлении запроса нажмите **Reopen in Container** (или используйте `Ctrl+Shift+P` → "Dev Containers: Reopen in Container")
6. Подождите, пока контейнер соберется и запустится
7. Перейдите к [Шагу 2: Создание токена GitHub](../../../02-SetupDevEnvironment)

<img src="./images/devcontainer.png" alt="Скриншот: настройка dev-контейнера" width="50%">

<img src="./images/image-3.png" alt="Скриншот: сборка dev-контейнера завершена" width="50%">

#### Вариант C: Использование существующей локальной установки

**Для разработчиков с уже настроенной средой Java**

Требования:
- [Java 21+](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) 
- [Maven 3.9+](https://maven.apache.org/download.cgi)
- [VS Code](https://code.visualstudio.com) или предпочитаемая IDE

Шаги:
1. Клонируйте этот репозиторий на свой локальный компьютер
2. Откройте проект в своей IDE
3. Перейдите к [Шагу 2: Создание токена GitHub](../../../02-SetupDevEnvironment)

> **Полезный совет**: Если у вас слабый компьютер, но вы хотите использовать VS Code локально, попробуйте GitHub Codespaces! Вы можете подключить локальный VS Code к облачному Codespace для лучшего опыта.

<img src="./images/image-2.png" alt="Скриншот: созданный локальный экземпляр dev-контейнера" width="50%">

## Шаг 2: Создание персонального токена доступа GitHub

1. Перейдите в [настройки GitHub](https://github.com/settings/profile) и выберите **Settings** в меню профиля.
2. В левой панели нажмите **Developer settings** (обычно внизу).
3. В разделе **Personal access tokens** выберите **Fine-grained tokens** (или перейдите по этой [ссылке](https://github.com/settings/personal-access-tokens)).
4. Нажмите **Generate new token**.
5. В поле "Token name" укажите описательное имя (например, `GenAI-Java-Course-Token`).
6. Установите срок действия токена (рекомендуется: 7 дней для повышения безопасности).
7. В разделе "Resource owner" выберите свою учетную запись.
8. В разделе "Repository access" выберите репозитории, которые вы хотите использовать с GitHub Models (или "All repositories", если нужно).
9. В разделе "Repository permissions" найдите **Models** и установите значение **Read and write**.
10. Нажмите **Generate token**.
11. **Скопируйте и сохраните токен сейчас** — вы больше не сможете его увидеть!

> **Совет по безопасности**: Используйте минимально необходимые права и самый короткий возможный срок действия для ваших токенов доступа.

## Шаг 3: Тестирование настройки с примером моделей GitHub

Когда ваша среда разработки готова, протестируйте интеграцию с GitHub Models, используя пример приложения в [`02-SetupDevEnvironment/examples/github-models`](../../../02-SetupDevEnvironment/examples/github-models).

1. Откройте терминал в своей среде разработки.
2. Перейдите в папку с примером GitHub Models:
   ```bash
   cd 02-SetupDevEnvironment/examples/github-models
   ```
3. Установите токен GitHub как переменную окружения:
   ```bash
   # macOS/Linux
   export GITHUB_TOKEN=your_token_here
   
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_token_here"
   ```

4. Запустите приложение:
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.githubmodels.App"
   ```

Вы должны увидеть вывод, похожий на:
```text
Using model: gpt-4.1-nano
Sending request to GitHub Models...
Response: Hello World!
```

### Понимание кода примера

Давайте разберем, что мы только что запустили. Пример в `examples/github-models` использует OpenAI Java SDK для подключения к GitHub Models:

**Что делает этот код:**
- **Подключается** к GitHub Models с использованием вашего персонального токена доступа
- **Отправляет** простое сообщение "Say Hello World!" модели AI
- **Получает** и отображает ответ AI
- **Проверяет**, что ваша настройка работает корректно

**Ключевая зависимость** (в `pom.xml`):
```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

**Основной код** (`App.java`):
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

## Итоги

**Поздравляем!** Вы успешно:

- **Создали персональный токен доступа GitHub** с правильными правами для доступа к моделям AI
- **Настроили среду разработки Java** с использованием Codespaces, dev-контейнеров или локальной установки
- **Подключились к GitHub Models** с использованием OpenAI Java SDK для бесплатного доступа к AI
- **Протестировали интеграцию** с рабочим примером приложения, которое взаимодействует с моделями AI

## Следующие шаги

[Глава 3: Основные техники Generative AI](../03-CoreGenerativeAITechniques/README.md)

## Устранение неполадок

Возникли проблемы? Вот распространенные ошибки и их решения:

- **Токен не работает?** 
  - Убедитесь, что вы скопировали весь токен без лишних пробелов
  - Проверьте, что токен правильно установлен как переменная окружения
  - Убедитесь, что у токена есть правильные права (Models: Read and write)

- **Maven не найден?** 
  - Если вы используете dev-контейнеры/Codespaces, Maven должен быть предустановлен
  - Для локальной настройки убедитесь, что установлены Java 21+ и Maven 3.9+
  - Проверьте установку с помощью `mvn --version`

- **Проблемы с подключением?** 
  - Проверьте ваше интернет-соединение
  - Убедитесь, что GitHub доступен из вашей сети
  - Убедитесь, что ваш брандмауэр не блокирует конечную точку GitHub Models

- **Dev-контейнер не запускается?** 
  - Убедитесь, что Docker Desktop запущен (для локальной разработки)
  - Попробуйте пересобрать контейнер: `Ctrl+Shift+P` → "Dev Containers: Rebuild Container"

- **Ошибки компиляции приложения?**
  - Убедитесь, что вы находитесь в правильной директории: `02-SetupDevEnvironment/examples/github-models`
  - Попробуйте очистить и пересобрать проект: `mvn clean compile`

> **Нужна помощь?**: Все еще есть проблемы? Откройте issue в репозитории, и мы вам поможем.

**Отказ от ответственности**:  
Этот документ был переведен с использованием сервиса автоматического перевода [Co-op Translator](https://github.com/Azure/co-op-translator). Несмотря на наши усилия обеспечить точность, автоматические переводы могут содержать ошибки или неточности. Оригинальный документ на его родном языке следует считать авторитетным источником. Для получения критически важной информации рекомендуется профессиональный перевод человеком. Мы не несем ответственности за любые недоразумения или неправильные интерпретации, возникающие в результате использования данного перевода.