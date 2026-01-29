# AGENTS.md

## Огляд проєкту

Це навчальний репозиторій для вивчення розробки Generative AI за допомогою Java. Він пропонує всебічний практичний курс, що охоплює великі мовні моделі (LLMs), інженерію запитів, вбудовування, RAG (генерація з доповненим пошуком) і протокол контексту моделі (MCP).

**Основні технології:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- Моделі GitHub, Azure OpenAI та OpenAI SDKs

**Архітектура:**
- Кілька автономних додатків Spring Boot, організованих за розділами
- Зразкові проєкти, що демонструють різні AI-патерни
- Готовність до GitHub Codespaces із попередньо налаштованими контейнерами для розробки

## Команди налаштування

### Попередні вимоги
- Java 21 або новіша
- Maven 3.x
- Персональний токен доступу GitHub (для моделей GitHub)
- Опціонально: облікові дані Azure OpenAI

### Налаштування середовища

**Варіант 1: GitHub Codespaces (рекомендовано)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Варіант 2: Локальний контейнер для розробки**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Варіант 3: Локальне налаштування**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Конфігурація

**Налаштування токена GitHub:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Налаштування Azure OpenAI (опціонально):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Робочий процес розробки

### Структура проєкту
```
/
├── 01-IntroToGenAI/              # Chapter 1: Introduction
├── 02-SetupDevEnvironment/       # Chapter 2: Environment setup
│   └── examples/                 # Working examples
├── 03-CoreGenerativeAITechniques/ # Chapter 3: Core techniques
├── 04-PracticalSamples/          # Chapter 4: Sample projects
│   ├── calculator/               # MCP service example
│   ├── foundrylocal/            # Local model integration
│   └── petstory/                # Multi-modal app
├── 05-ResponsibleGenAI/         # Chapter 5: Responsible AI
└── translations/                # Multi-language support
```

### Запуск додатків

**Запуск додатка Spring Boot:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Збірка проєкту:**
```bash
cd [project-directory]
mvn clean install
```

**Запуск сервера MCP Calculator:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Запуск прикладів клієнтів:**
```bash
# After starting the server in another terminal
cd 04-PracticalSamples/calculator

# Direct MCP client
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient"

# AI-powered client (requires GITHUB_TOKEN)
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient"

# Interactive bot
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.Bot"
```

### Гаряче перезавантаження
Spring Boot DevTools включено в проєкти, які підтримують гаряче перезавантаження:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Інструкції з тестування

### Запуск тестів

**Запустити всі тести в проєкті:**
```bash
cd [project-directory]
mvn test
```

**Запустити тести з детальним виводом:**
```bash
mvn test -X
```

**Запустити конкретний клас тестів:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Структура тестів
- Файли тестів використовують JUnit 5 (Jupiter)
- Класи тестів знаходяться в `src/test/java/`
- Приклади клієнтів у проєкті калькулятора знаходяться в `src/test/java/com/microsoft/mcp/sample/client/`

### Ручне тестування
Багато прикладів є інтерактивними додатками, які потребують ручного тестування:

1. Запустіть додаток за допомогою `mvn spring-boot:run`
2. Тестуйте кінцеві точки або взаємодійте через CLI
3. Перевірте, чи очікувана поведінка відповідає документації в README.md кожного проєкту

### Тестування з моделями GitHub
- Ліміти безкоштовного рівня: 15 запитів/хвилину, 150/день
- Максимум 5 одночасних запитів
- Тестуйте фільтрацію контенту за допомогою прикладів відповідального AI

## Рекомендації щодо стилю коду

### Конвенції Java
- **Версія Java:** Java 21 із сучасними функціями
- **Стиль:** Дотримуйтесь стандартних конвенцій Java
- **Іменування:** 
  - Класи: PascalCase
  - Методи/змінні: camelCase
  - Константи: UPPER_SNAKE_CASE
  - Імена пакетів: нижній регістр

### Патерни Spring Boot
- Використовуйте `@Service` для бізнес-логіки
- Використовуйте `@RestController` для REST-кінцевих точок
- Конфігурація через `application.yml` або `application.properties`
- Замість жорстко закодованих значень використовуйте змінні середовища
- Використовуйте анотацію `@Tool` для методів, доступних через MCP

### Організація файлів
```
src/
├── main/
│   ├── java/
│   │   └── com/microsoft/[component]/
│   │       ├── [Component]Application.java
│   │       ├── config/
│   │       ├── controller/
│   │       ├── service/
│   │       └── exception/
│   └── resources/
│       ├── application.yml
│       └── static/
└── test/
    └── java/
        └── com/microsoft/[component]/
```

### Залежності
- Керуються через Maven `pom.xml`
- Spring AI BOM для управління версіями
- LangChain4j для інтеграції AI
- Spring Boot starter parent для залежностей Spring

### Коментарі до коду
- Додавайте JavaDoc для публічних API
- Включайте пояснювальні коментарі для складних AI-взаємодій
- Чітко документуйте описи інструментів MCP

## Збірка та розгортання

### Збірка проєктів

**Збірка без тестів:**
```bash
mvn clean install -DskipTests
```

**Збірка з усіма перевірками:**
```bash
mvn clean install
```

**Пакування додатка:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Вихідні каталоги
- Скомпільовані класи: `target/classes/`
- Тестові класи: `target/test-classes/`
- JAR-файли: `target/*.jar`
- Артефакти Maven: `target/`

### Конфігурація для конкретного середовища

**Розробка:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Продакшн:**
- Використовуйте моделі Azure AI Foundry замість моделей GitHub
- Оновіть базовий URL до кінцевої точки Azure OpenAI
- Керуйте секретами через Azure Key Vault або змінні середовища

### Міркування щодо розгортання
- Це навчальний репозиторій із зразковими додатками
- Не призначений для розгортання в продакшн у поточному вигляді
- Зразки демонструють патерни, які можна адаптувати для продакшн
- Дивіться README.md окремих проєктів для конкретних приміток щодо розгортання

## Додаткові примітки

### Моделі GitHub vs Azure OpenAI
- **Моделі GitHub:** Безкоштовний рівень для навчання, не потрібна кредитна картка
- **Azure OpenAI:** Готовий до продакшн, потрібна підписка Azure
- Код сумісний між обома - просто змініть кінцеву точку та ключ API

### Робота з кількома проєктами
Кожен зразковий проєкт є автономним:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Поширені проблеми

**Невідповідність версії Java:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Проблеми із завантаженням залежностей:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**Токен GitHub не знайдено:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Порт уже використовується:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Підтримка багатомовності
- Документація доступна більш ніж на 45 мовах через автоматичний переклад
- Переклади знаходяться в каталозі `translations/`
- Переклад управляється через GitHub Actions workflow

### Шлях навчання
1. Почніть із [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Дотримуйтесь порядку розділів (01 → 05)
3. Виконайте практичні приклади в кожному розділі
4. Досліджуйте зразкові проєкти в розділі 4
5. Вивчайте практики відповідального AI у розділі 5

### Контейнер для розробки
Файл `.devcontainer/devcontainer.json` налаштовує:
- Середовище розробки Java 21
- Попередньо встановлений Maven
- Розширення Java для VS Code
- Інструменти Spring Boot
- Інтеграцію GitHub Copilot
- Docker-in-Docker підтримку
- Azure CLI

### Міркування щодо продуктивності
- Безкоштовний рівень моделей GitHub має обмеження швидкості
- Використовуйте відповідні розміри пакетів для вбудовування
- Розгляньте кешування для повторюваних API-запитів
- Моніторте використання токенів для оптимізації витрат

### Примітки щодо безпеки
- Ніколи не комітьте файли `.env` (вже додані до `.gitignore`)
- Використовуйте змінні середовища для ключів API
- Токени GitHub повинні мати мінімально необхідні права
- Дотримуйтесь рекомендацій відповідального AI у розділі 5

---

**Відмова від відповідальності**:  
Цей документ було перекладено за допомогою сервісу автоматичного перекладу [Co-op Translator](https://github.com/Azure/co-op-translator). Хоча ми прагнемо до точності, звертаємо вашу увагу, що автоматичні переклади можуть містити помилки або неточності. Оригінальний документ на його рідній мові слід вважати авторитетним джерелом. Для критичної інформації рекомендується професійний людський переклад. Ми не несемо відповідальності за будь-які непорозуміння або неправильні тлумачення, що виникли внаслідок використання цього перекладу.