<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T21:20:28+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "uk"
}
-->
# Локальний додаток командного рядка Foundry

>**Примітка**: У цьому розділі є [**Підручник**](./TUTORIAL.md), який допоможе вам запустити готові приклади.

Простий додаток командного рядка на основі Spring Boot, який демонструє, як підключитися до Foundry Local за допомогою OpenAI Java SDK.

## Чого ви навчитеся

- Як інтегрувати Foundry Local у додатки Spring Boot за допомогою OpenAI Java SDK
- Найкращі практики для локальної розробки та тестування AI

## Зміст

- [Чого ви навчитеся](../../../../04-PracticalSamples/foundrylocal)
- [Передумови](../../../../04-PracticalSamples/foundrylocal)
  - [Встановлення Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [Перевірка](../../../../04-PracticalSamples/foundrylocal)
- [Конфігурація](../../../../04-PracticalSamples/foundrylocal)
- [Швидкий старт](../../../../04-PracticalSamples/foundrylocal)
- [Що робить додаток](../../../../04-PracticalSamples/foundrylocal)
- [Приклад виводу](../../../../04-PracticalSamples/foundrylocal)
- [Архітектура](../../../../04-PracticalSamples/foundrylocal)
- [Основні моменти коду](../../../../04-PracticalSamples/foundrylocal)
  - [Інтеграція OpenAI Java SDK](../../../../04-PracticalSamples/foundrylocal)
  - [API завершення чату](../../../../04-PracticalSamples/foundrylocal)
- [Усунення несправностей](../../../../04-PracticalSamples/foundrylocal)

## Передумови

> **⚠️ Примітка**: Цей додаток **не працює у наданому devcontainer**, оскільки для його роботи необхідно встановити та запустити Foundry Local на хост-системі.

### Встановлення Foundry Local

Перед запуском цього додатка вам потрібно встановити та запустити Foundry Local. Виконайте наступні кроки:

1. **Переконайтеся, що ваша система відповідає вимогам**:
   - **Операційна система**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025 або macOS
   - **Обладнання**: 
     - Мінімум: 8 ГБ оперативної пам’яті, 3 ГБ вільного місця на диску
     - Рекомендовано: 16 ГБ оперативної пам’яті, 15 ГБ вільного місця на диску
   - **Мережа**: Підключення до Інтернету для початкового завантаження моделі (опціонально для офлайн-режиму)
   - **Прискорення (опціонально)**: NVIDIA GPU (серія 2000 або новіше), AMD GPU (серія 6000 або новіше), Qualcomm Snapdragon X Elite (8 ГБ або більше пам’яті) або Apple silicon
   - **Дозволи**: Адміністративні права для встановлення програмного забезпечення на вашому пристрої

2. **Встановіть Foundry Local**:
   
   **Для Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **Для macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Або завантажте інсталятор із [репозиторію Foundry Local на GitHub](https://github.com/microsoft/Foundry-Local).

3. **Запустіть першу модель**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   Модель завантажується (це може зайняти кілька хвилин залежно від швидкості вашого інтернету) і запускається. Foundry Local автоматично вибирає найкращий варіант моделі для вашої системи (CUDA для NVIDIA GPU, версія для CPU в іншому випадку).

4. **Перевірте модель**, задавши питання в тому ж терміналі:

   ```bash
   Why is the sky blue?
   ```

   Ви повинні побачити відповідь від моделі Phi, яка пояснює, чому небо здається синім.

### Перевірка

Ви можете перевірити, чи все працює правильно, за допомогою цих команд:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

Також ви можете відкрити `http://localhost:5273` у вашому браузері, щоб побачити веб-інтерфейс Foundry Local.

## Конфігурація

Додаток можна налаштувати через файл `application.properties`:

- `foundry.local.base-url` - Базова URL-адреса для Foundry Local (за замовчуванням: http://localhost:5273)
- `foundry.local.model` - AI-модель для використання (за замовчуванням: Phi-3.5-mini-instruct-cuda-gpu)

> **Примітка**: Назва моделі в конфігурації повинна відповідати конкретному варіанту, який Foundry Local завантажив для вашої системи. Коли ви запускаєте `foundry model run phi-3.5-mini`, Foundry Local автоматично вибирає та завантажує найкращий варіант (CUDA для NVIDIA GPU, версія для CPU в іншому випадку). Використовуйте `foundry model list`, щоб побачити точну назву моделі, доступної у вашій локальній інстанції.

## Швидкий старт

### 1. Перейдіть до каталогу додатка Foundry Local
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Запустіть додаток

```bash
mvn spring-boot:run
```

Або зберіть і запустіть JAR:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Залежності

Цей додаток використовує OpenAI Java SDK для зв’язку з Foundry Local. Основна залежність:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

Додаток попередньо налаштований для підключення до Foundry Local, що працює на порту за замовчуванням.

## Що робить додаток

Коли ви запускаєте додаток:

1. **Запускається** як додаток командного рядка (без веб-сервера)
2. **Автоматично надсилає** тестове повідомлення: "Привіт! Чи можете ви розповісти, що ви таке і яку модель ви використовуєте?"
3. **Відображає відповідь** від Foundry Local у консолі
4. **Коректно завершує роботу** після демонстрації

## Приклад виводу

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Архітектура

- **Application.java** - Головний додаток Spring Boot із CommandLineRunner
- **FoundryLocalService.java** - Сервіс, який використовує OpenAI Java SDK для зв’язку з Foundry Local
- Використовує **OpenAI Java SDK** для типобезпечних API-запитів
- Автоматична серіалізація/десеріалізація JSON обробляється SDK
- Чиста конфігурація за допомогою анотацій Spring `@Value` та `@PostConstruct`

## Основні моменти коду

### Інтеграція OpenAI Java SDK

Додаток використовує OpenAI Java SDK для створення клієнта, налаштованого для Foundry Local:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### API завершення чату

Створення запитів на завершення чату є простим і типобезпечним:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Усунення несправностей

Якщо ви бачите помилки підключення:
1. Переконайтеся, що Foundry Local працює на `http://localhost:5273`
2. Перевірте, чи доступний варіант моделі Phi-3.5-mini за допомогою `foundry model list`
3. Переконайтеся, що назва моделі у `application.properties` відповідає точній назві моделі, показаній у списку
4. Переконайтеся, що жоден брандмауер не блокує підключення

Поширені проблеми:
- **Модель не знайдена**: Запустіть `foundry model run phi-3.5-mini`, щоб завантажити та запустити модель
- **Сервіс не працює**: Сервіс Foundry Local міг зупинитися; перезапустіть його за допомогою команди запуску моделі
- **Неправильна назва моделі**: Використовуйте `foundry model list`, щоб побачити доступні моделі, і оновіть вашу конфігурацію відповідно

**Відмова від відповідальності**:  
Цей документ було перекладено за допомогою сервісу автоматичного перекладу [Co-op Translator](https://github.com/Azure/co-op-translator). Хоча ми прагнемо до точності, зверніть увагу, що автоматичні переклади можуть містити помилки або неточності. Оригінальний документ на його рідній мові слід вважати авторитетним джерелом. Для критично важливої інформації рекомендується професійний людський переклад. Ми не несемо відповідальності за будь-які непорозуміння або неправильні тлумачення, що виникли внаслідок використання цього перекладу.