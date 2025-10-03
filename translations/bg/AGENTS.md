<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "afc90918d008cf77fd1982691f681306",
  "translation_date": "2025-10-03T08:43:49+00:00",
  "source_file": "AGENTS.md",
  "language_code": "bg"
}
-->
# AGENTS.md

## Преглед на проекта

Това е образователно хранилище за изучаване на разработка на Генеративен AI с Java. То предоставя цялостен практически курс, обхващащ Големи Езикови Модели (LLMs), инженеринг на подсказки, вграждания, RAG (Генерация с Подобрено Извличане) и Протокола за Контекст на Модела (MCP).

**Основни технологии:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI и OpenAI SDKs

**Архитектура:**
- Множество самостоятелни Spring Boot приложения, организирани по глави
- Примерни проекти, демонстриращи различни AI модели
- Готово за GitHub Codespaces с предварително конфигурирани контейнери за разработка

## Команди за настройка

### Предпоставки
- Java 21 или по-нова версия
- Maven 3.x
- Личен достъп до GitHub токен (за GitHub Models)
- По избор: Удостоверения за Azure OpenAI

### Настройка на средата

**Опция 1: GitHub Codespaces (Препоръчително)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Опция 2: Локален контейнер за разработка**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Опция 3: Локална настройка**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Конфигурация

**Настройка на GitHub токен:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Настройка на Azure OpenAI (по избор):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Работен процес за разработка

### Структура на проекта
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

### Стартиране на приложения

**Стартиране на Spring Boot приложение:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Създаване на проект:**
```bash
cd [project-directory]
mvn clean install
```

**Стартиране на MCP Calculator Server:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Стартиране на клиентски примери:**
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

### Горещо презареждане
Spring Boot DevTools е включен в проекти, които поддържат горещо презареждане:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Инструкции за тестване

### Стартиране на тестове

**Стартиране на всички тестове в проект:**
```bash
cd [project-directory]
mvn test
```

**Стартиране на тестове с подробен изход:**
```bash
mvn test -X
```

**Стартиране на конкретен тестов клас:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Структура на тестовете
- Тестовите файлове използват JUnit 5 (Jupiter)
- Тестовите класове се намират в `src/test/java/`
- Клиентските примери в проекта за калкулатор са в `src/test/java/com/microsoft/mcp/sample/client/`

### Ръчно тестване
Много примери са интерактивни приложения, които изискват ръчно тестване:

1. Стартирайте приложението с `mvn spring-boot:run`
2. Тествайте крайните точки или взаимодействията с CLI
3. Уверете се, че очакваното поведение съответства на документацията във всяко README.md на проекта

### Тестване с GitHub Models
- Ограничения на безплатния план: 15 заявки/минута, 150/ден
- Максимум 5 едновременни заявки
- Тествайте филтриране на съдържание с примери за отговорен AI

## Насоки за стил на код

### Конвенции за Java
- **Версия на Java:** Java 21 с модерни функции
- **Стил:** Следвайте стандартните конвенции за Java
- **Именуване:** 
  - Класове: PascalCase
  - Методи/променливи: camelCase
  - Константи: UPPER_SNAKE_CASE
  - Имена на пакети: малки букви

### Модели на Spring Boot
- Използвайте `@Service` за бизнес логика
- Използвайте `@RestController` за REST крайни точки
- Конфигурация чрез `application.yml` или `application.properties`
- Предпочитайте променливи на средата пред твърдо кодирани стойности
- Използвайте анотацията `@Tool` за методи, изложени от MCP

### Организация на файлове
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

### Зависимости
- Управляват се чрез Maven `pom.xml`
- Spring AI BOM за управление на версии
- LangChain4j за AI интеграции
- Spring Boot starter parent за Spring зависимости

### Коментари в кода
- Добавяйте JavaDoc за публични API
- Включвайте обяснителни коментари за сложни AI взаимодействия
- Документирайте описанията на MCP инструментите ясно

## Създаване и разгръщане

### Създаване на проекти

**Създаване без тестове:**
```bash
mvn clean install -DskipTests
```

**Създаване с всички проверки:**
```bash
mvn clean install
```

**Опаковане на приложение:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Изходни директории
- Компилирани класове: `target/classes/`
- Тестови класове: `target/test-classes/`
- JAR файлове: `target/*.jar`
- Maven артефакти: `target/`

### Конфигурация, специфична за средата

**Разработка:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Продукция:**
- Използвайте Azure AI Foundry Models вместо GitHub Models
- Актуализирайте базовия URL към Azure OpenAI крайна точка
- Управлявайте тайните чрез Azure Key Vault или променливи на средата

### Съображения за разгръщане
- Това е образователно хранилище с примерни приложения
- Не е предназначено за разгръщане в продукция в текущия си вид
- Примерите демонстрират модели за адаптиране за продукция
- Вижте README.md на отделните проекти за конкретни бележки относно разгръщането

## Допълнителни бележки

### GitHub Models срещу Azure OpenAI
- **GitHub Models:** Безплатен план за обучение, не се изисква кредитна карта
- **Azure OpenAI:** Готов за продукция, изисква абонамент за Azure
- Кодът е съвместим и с двата - просто променете крайна точка и API ключ

### Работа с множество проекти
Всеки примерен проект е самостоятелен:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Чести проблеми

**Несъответствие на версията на Java:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Проблеми с изтегляне на зависимости:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub токен не е намерен:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Портът вече се използва:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Поддръжка на много езици
- Документацията е налична на над 45 езика чрез автоматичен превод
- Преводите се намират в директорията `translations/`
- Преводът се управлява от GitHub Actions workflow

### Път за обучение
1. Започнете с [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Следвайте главите по ред (01 → 05)
3. Завършете практическите примери във всяка глава
4. Разгледайте примерните проекти в Глава 4
5. Научете практики за отговорен AI в Глава 5

### Контейнер за разработка
Конфигурацията `.devcontainer/devcontainer.json` включва:
- Среда за разработка с Java 21
- Предварително инсталиран Maven
- Разширения за Java за VS Code
- Инструменти за Spring Boot
- Интеграция с GitHub Copilot
- Поддръжка на Docker-in-Docker
- Azure CLI

### Съображения за производителност
- Безплатният план на GitHub Models има ограничения на скоростта
- Използвайте подходящи размери на партидите за вграждания
- Обмислете кеширане за повтарящи се API заявки
- Наблюдавайте използването на токени за оптимизация на разходите

### Бележки за сигурност
- Никога не комитвайте `.env` файлове (вече са в `.gitignore`)
- Използвайте променливи на средата за API ключове
- GitHub токените трябва да имат минимално необходимите обхвати
- Следвайте насоките за отговорен AI в Глава 5

---

**Отказ от отговорност**:  
Този документ е преведен с помощта на AI услуга за превод [Co-op Translator](https://github.com/Azure/co-op-translator). Въпреки че се стремим към точност, моля, имайте предвид, че автоматизираните преводи може да съдържат грешки или неточности. Оригиналният документ на неговия изходен език трябва да се счита за авторитетен източник. За критична информация се препоръчва професионален превод от човек. Ние не носим отговорност за каквито и да било недоразумения или погрешни интерпретации, произтичащи от използването на този превод.