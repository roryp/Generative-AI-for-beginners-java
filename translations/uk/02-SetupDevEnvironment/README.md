<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c2a244c959e00da1ae1613d2ebfdac65",
  "translation_date": "2025-07-29T10:31:11+00:00",
  "source_file": "02-SetupDevEnvironment/README.md",
  "language_code": "uk"
}
-->
# Налаштування середовища розробки для Generative AI на Java

> **Швидкий старт**: Код у хмарі за 2 хвилини – перейдіть до [Налаштування GitHub Codespaces](../../../02-SetupDevEnvironment) – без необхідності локальної інсталяції, використовуються моделі GitHub!

> **Цікавить Azure OpenAI?** Ознайомтеся з нашим [Посібником із налаштування Azure OpenAI](getting-started-azure-openai.md), де описані кроки для створення нового ресурсу Azure OpenAI.

## Що ви дізнаєтесь

- Як налаштувати середовище розробки Java для AI-додатків
- Як обрати та налаштувати бажане середовище розробки (хмарне через Codespaces, локальний dev-контейнер або повністю локальне налаштування)
- Як протестувати налаштування, підключившись до моделей GitHub

## Зміст

- [Що ви дізнаєтесь](../../../02-SetupDevEnvironment)
- [Вступ](../../../02-SetupDevEnvironment)
- [Крок 1: Налаштуйте середовище розробки](../../../02-SetupDevEnvironment)
  - [Варіант A: GitHub Codespaces (рекомендовано)](../../../02-SetupDevEnvironment)
  - [Варіант B: Локальний dev-контейнер](../../../02-SetupDevEnvironment)
  - [Варіант C: Використання існуючої локальної інсталяції](../../../02-SetupDevEnvironment)
- [Крок 2: Створіть персональний токен доступу GitHub](../../../02-SetupDevEnvironment)
- [Крок 3: Протестуйте налаштування](../../../02-SetupDevEnvironment)
- [Усунення несправностей](../../../02-SetupDevEnvironment)
- [Підсумок](../../../02-SetupDevEnvironment)
- [Наступні кроки](../../../02-SetupDevEnvironment)

## Вступ

Цей розділ допоможе вам налаштувати середовище розробки. Ми будемо використовувати **GitHub Models** як основний приклад, оскільки це безкоштовно, легко налаштовується за допомогою облікового запису GitHub, не потребує кредитної картки та надає доступ до кількох моделей для експериментів.

**Локальне налаштування не потрібне!** Ви можете почати писати код одразу, використовуючи GitHub Codespaces, який забезпечує повноцінне середовище розробки у вашому браузері.

<img src="./images/models.webp" alt="Скріншот: GitHub Models" width="50%">

Ми рекомендуємо використовувати [**GitHub Models**](https://github.com/marketplace?type=models) для цього курсу, оскільки це:
- **Безкоштовно** для початку
- **Просто** налаштувати за допомогою облікового запису GitHub
- **Не потребує кредитної картки**
- **Доступно кілька моделей** для експериментів

> **Примітка**: Моделі GitHub, які використовуються в цьому тренінгу, мають такі безкоштовні обмеження:
> - 15 запитів на хвилину (150 на день)
> - ~8,000 слів на вхід, ~4,000 слів на вихід за запит
> - 5 одночасних запитів
> 
> Для використання в продакшені оновіть до Azure AI Foundry Models за допомогою вашого облікового запису Azure. Ваш код не потребує змін. Дивіться [документацію Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/foundry-models/how-to/quickstart-github-models).

## Крок 1: Налаштуйте середовище розробки

<a name="quick-start-cloud"></a>

Ми створили попередньо налаштований dev-контейнер, щоб мінімізувати час налаштування та забезпечити наявність усіх необхідних інструментів для цього курсу Generative AI на Java. Оберіть бажаний підхід до налаштування:

### Варіанти налаштування середовища:

#### Варіант A: GitHub Codespaces (рекомендовано)

**Почніть писати код за 2 хвилини – локальне налаштування не потрібне!**

1. Форкніть цей репозиторій у свій обліковий запис GitHub
   > **Примітка**: Якщо ви хочете змінити базову конфігурацію, перегляньте [Конфігурацію dev-контейнера](../../../.devcontainer/devcontainer.json)
2. Натисніть **Code** → вкладка **Codespaces** → **...** → **New with options...**
3. Використовуйте налаштування за замовчуванням – це вибере **Конфігурацію dev-контейнера**: **Generative AI Java Development Environment**, спеціально створену для цього курсу
4. Натисніть **Create codespace**
5. Зачекайте ~2 хвилини, поки середовище буде готове
6. Перейдіть до [Кроку 2: Створіть GitHub Token](../../../02-SetupDevEnvironment)

<img src="./images/codespaces.png" alt="Скріншот: Підменю Codespaces" width="50%">

<img src="./images/image.png" alt="Скріншот: New with options" width="50%">

<img src="./images/codespaces-create.png" alt="Скріншот: Опції створення Codespace" width="50%">

> **Переваги Codespaces**:
> - Локальна інсталяція не потрібна
> - Працює на будь-якому пристрої з браузером
> - Попередньо налаштовано з усіма інструментами та залежностями
> - Безкоштовно 60 годин на місяць для персональних облікових записів
> - Стабільне середовище для всіх учасників

#### Варіант B: Локальний dev-контейнер

**Для розробників, які віддають перевагу локальній розробці з Docker**

1. Форкніть і клонуйте цей репозиторій на свій локальний комп'ютер
   > **Примітка**: Якщо ви хочете змінити базову конфігурацію, перегляньте [Конфігурацію dev-контейнера](../../../.devcontainer/devcontainer.json)
2. Встановіть [Docker Desktop](https://www.docker.com/products/docker-desktop/) і [VS Code](https://code.visualstudio.com/)
3. Встановіть розширення [Dev Containers](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) у VS Code
4. Відкрийте папку репозиторію у VS Code
5. Коли з'явиться запит, натисніть **Reopen in Container** (або використовуйте `Ctrl+Shift+P` → "Dev Containers: Reopen in Container")
6. Зачекайте, поки контейнер буде зібрано та запущено
7. Перейдіть до [Кроку 2: Створіть GitHub Token](../../../02-SetupDevEnvironment)

<img src="./images/devcontainer.png" alt="Скріншот: Налаштування dev-контейнера" width="50%">

<img src="./images/image-3.png" alt="Скріншот: Завершення збірки dev-контейнера" width="50%">

#### Варіант C: Використання існуючої локальної інсталяції

**Для розробників із вже налаштованим середовищем Java**

Необхідні умови:
- [Java 21+](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) 
- [Maven 3.9+](https://maven.apache.org/download.cgi)
- [VS Code](https://code.visualstudio.com) або ваш улюблений IDE

Кроки:
1. Клонуйте цей репозиторій на свій локальний комп'ютер
2. Відкрийте проєкт у вашому IDE
3. Перейдіть до [Кроку 2: Створіть GitHub Token](../../../02-SetupDevEnvironment)

> **Порада**: Якщо у вас малопотужний комп'ютер, але ви хочете використовувати VS Code локально, скористайтеся GitHub Codespaces! Ви можете підключити свій локальний VS Code до хмарного Codespace для найкращого досвіду.

<img src="./images/image-2.png" alt="Скріншот: створений локальний dev-контейнер" width="50%">

## Крок 2: Створіть персональний токен доступу GitHub

1. Перейдіть до [Налаштувань GitHub](https://github.com/settings/profile) і виберіть **Settings** у меню профілю.
2. У лівій панелі натисніть **Developer settings** (зазвичай внизу).
3. У розділі **Personal access tokens** натисніть **Fine-grained tokens** (або скористайтеся цим [посиланням](https://github.com/settings/personal-access-tokens)).
4. Натисніть **Generate new token**.
5. У полі "Token name" вкажіть описову назву (наприклад, `GenAI-Java-Course-Token`).
6. Встановіть дату закінчення терміну дії (рекомендується: 7 днів для безпеки).
7. У полі "Resource owner" виберіть свій обліковий запис.
8. У полі "Repository access" виберіть репозиторії, які ви хочете використовувати з GitHub Models (або "All repositories", якщо потрібно).
9. У полі "Repository permissions" знайдіть **Models** і встановіть значення **Read and write**.
10. Натисніть **Generate token**.
11. **Скопіюйте та збережіть ваш токен зараз** – ви більше не побачите його!

> **Порада з безпеки**: Використовуйте мінімально необхідний обсяг доступу та найкоротший практичний термін дії для ваших токенів.

## Крок 3: Протестуйте налаштування з прикладом моделей GitHub

Коли ваше середовище розробки готове, протестуйте інтеграцію GitHub Models за допомогою нашого прикладного додатка в [`02-SetupDevEnvironment/examples/github-models`](../../../02-SetupDevEnvironment/examples/github-models).

1. Відкрийте термінал у вашому середовищі розробки.
2. Перейдіть до прикладу GitHub Models:
   ```bash
   cd 02-SetupDevEnvironment/examples/github-models
   ```
3. Встановіть ваш GitHub токен як змінну середовища:
   ```bash
   # macOS/Linux
   export GITHUB_TOKEN=your_token_here
   
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_token_here"
   ```

4. Запустіть додаток:
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.githubmodels.App"
   ```

Ви повинні побачити результат, схожий на:
```text
Using model: gpt-4.1-nano
Sending request to GitHub Models...
Response: Hello World!
```

### Розуміння прикладного коду

Спочатку розберемо, що ми щойно запустили. Приклад у `examples/github-models` використовує OpenAI Java SDK для підключення до GitHub Models:

**Що робить цей код:**
- **Підключається** до GitHub Models за допомогою вашого персонального токена доступу
- **Надсилає** просте повідомлення "Say Hello World!" до AI-моделі
- **Отримує** та відображає відповідь AI
- **Перевіряє**, чи працює ваше налаштування правильно

**Ключова залежність** (у `pom.xml`):
```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

**Основний код** (`App.java`):
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

## Підсумок

Відмінно! Тепер у вас усе налаштовано:

- Створено персональний токен доступу GitHub із правильними дозволами для доступу до AI-моделей
- Запущено середовище розробки Java (будь то Codespaces, dev-контейнери або локальне)
- Підключено до GitHub Models за допомогою OpenAI Java SDK для безкоштовної розробки AI
- Протестовано все за допомогою простого прикладу, який взаємодіє з AI-моделями

## Наступні кроки

[Розділ 3: Основні техніки Generative AI](../03-CoreGenerativeAITechniques/README.md)

## Усунення несправностей

Виникли проблеми? Ось поширені проблеми та їх вирішення:

- **Токен не працює?** 
  - Переконайтеся, що ви скопіювали весь токен без зайвих пробілів
  - Перевірте, чи правильно встановлено токен як змінну середовища
  - Переконайтеся, що ваш токен має правильні дозволи (Models: Read and write)

- **Maven не знайдено?** 
  - Якщо ви використовуєте dev-контейнери/Codespaces, Maven має бути попередньо встановлений
  - Для локального налаштування переконайтеся, що встановлено Java 21+ і Maven 3.9+
  - Спробуйте `mvn --version`, щоб перевірити інсталяцію

- **Проблеми з підключенням?** 
  - Перевірте ваше інтернет-з'єднання
  - Переконайтеся, що GitHub доступний з вашої мережі
  - Перевірте, чи не блокує ваш брандмауер доступ до GitHub Models

- **Dev-контейнер не запускається?** 
  - Переконайтеся, що Docker Desktop запущений (для локальної розробки)
  - Спробуйте перебудувати контейнер: `Ctrl+Shift+P` → "Dev Containers: Rebuild Container"

- **Помилки компіляції додатка?**
  - Переконайтеся, що ви перебуваєте в правильній директорії: `02-SetupDevEnvironment/examples/github-models`
  - Спробуйте очистити та перебудувати: `mvn clean compile`

> **Потрібна допомога?**: Все ще виникають проблеми? Відкрийте issue в репозиторії, і ми вам допоможемо.

**Відмова від відповідальності**:  
Цей документ було перекладено за допомогою сервісу автоматичного перекладу [Co-op Translator](https://github.com/Azure/co-op-translator). Хоча ми прагнемо до точності, зверніть увагу, що автоматичні переклади можуть містити помилки або неточності. Оригінальний документ мовою оригіналу слід вважати авторитетним джерелом. Для критично важливої інформації рекомендується професійний переклад людиною. Ми не несемо відповідальності за будь-які непорозуміння або неправильні тлумачення, що виникли внаслідок використання цього перекладу.