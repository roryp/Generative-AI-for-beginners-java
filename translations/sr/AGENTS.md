<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "afc90918d008cf77fd1982691f681306",
  "translation_date": "2025-10-03T08:44:16+00:00",
  "source_file": "AGENTS.md",
  "language_code": "sr"
}
-->
# AGENTS.md

## Преглед пројекта

Ово је едукативни репозиторијум за учење развоја Генеративне вештачке интелигенције уз помоћ Јаве. Пружа свеобухватан практични курс који покрива моделе великог језика (LLMs), инжењеринг упита, уградње, RAG (генерација уз помоћ претраживања) и протокол контекста модела (MCP).

**Кључне технологије:**
- Јава 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI и OpenAI SDK-ови

**Архитектура:**
- Више самосталних Spring Boot апликација организованих по поглављима
- Пример пројекти који демонстрирају различите AI шаблоне
- Спремно за GitHub Codespaces са унапред конфигурисаним развојним контејнерима

## Команде за подешавање

### Предуслови
- Јава 21 или новија
- Maven 3.x
- Лични приступни токен за GitHub (за GitHub Models)
- Опционо: Azure OpenAI креденцијали

### Подешавање окружења

**Опција 1: GitHub Codespaces (препоручено)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Опција 2: Локални развојни контејнер**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Опција 3: Локално подешавање**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Конфигурација

**Подешавање GitHub токена:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Подешавање Azure OpenAI (опционо):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Радни ток развоја

### Структура пројекта
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

### Покретање апликација

**Покретање Spring Boot апликације:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Изградња пројекта:**
```bash
cd [project-directory]
mvn clean install
```

**Покретање MCP Calculator Server-а:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Покретање примера клијента:**
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

### Хот релоад
Spring Boot DevTools је укључен у пројекте који подржавају хот релоад:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Упутства за тестирање

### Покретање тестова

**Покрените све тестове у пројекту:**
```bash
cd [project-directory]
mvn test
```

**Покрените тестове са детаљним излазом:**
```bash
mvn test -X
```

**Покрените одређену тест класу:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Структура тестова
- Тест фајлови користе JUnit 5 (Jupiter)
- Тест класе се налазе у `src/test/java/`
- Примери клијената у пројекту калкулатора су у `src/test/java/com/microsoft/mcp/sample/client/`

### Ручно тестирање
Многи примери су интерактивне апликације које захтевају ручно тестирање:

1. Покрените апликацију са `mvn spring-boot:run`
2. Тестирајте ендпоинте или интеракцију преко CLI
3. Проверите да ли очекивано понашање одговара документацији у README.md сваког пројекта

### Тестирање са GitHub Models
- Ограничења бесплатног нивоа: 15 захтева/минут, 150/дан
- Максимум 5 истовремених захтева
- Тестирајте филтрирање садржаја са примерима одговорне AI

## Упутства за стил кода

### Јава конвенције
- **Верзија Јаве:** Јава 21 са модерним функцијама
- **Стил:** Пратите стандардне Јава конвенције
- **Именовање:** 
  - Класе: PascalCase
  - Методи/променљиве: camelCase
  - Константе: UPPER_SNAKE_CASE
  - Имена пакета: мала слова

### Spring Boot шаблони
- Користите `@Service` за пословну логику
- Користите `@RestController` за REST ендпоинте
- Конфигурација преко `application.yml` или `application.properties`
- Преферирајте променљиве окружења уместо вредности које су тврдо кодиране
- Користите `@Tool` анотацију за MCP методе

### Организација фајлова
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

### Зависности
- Управљање преко Maven `pom.xml`
- Spring AI BOM за управљање верзијама
- LangChain4j за AI интеграције
- Spring Boot starter parent за Spring зависности

### Коментари у коду
- Додајте JavaDoc за јавне API-је
- Укључите објашњавајуће коментаре за сложене AI интеракције
- Јасно документујте описе MCP алата

## Изградња и распоређивање

### Изградња пројеката

**Изградња без тестова:**
```bash
mvn clean install -DskipTests
```

**Изградња са свим проверама:**
```bash
mvn clean install
```

**Паковање апликације:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Излазни директоријуми
- Компилиране класе: `target/classes/`
- Тест класе: `target/test-classes/`
- JAR фајлови: `target/*.jar`
- Maven артефакти: `target/`

### Конфигурација специфична за окружење

**Развој:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Продукција:**
- Користите Azure AI Foundry Models уместо GitHub Models
- Ажурирајте base-url на Azure OpenAI ендпоинт
- Управљајте тајнама преко Azure Key Vault или променљивих окружења

### Разматрања за распоређивање
- Ово је едукативни репозиторијум са пример апликацијама
- Није дизајниран за продукцијско распоређивање у садашњем облику
- Примери демонстрирају шаблоне за адаптацију за продукцију
- Погледајте README.md сваког пројекта за специфичне белешке о распоређивању

## Додатне напомене

### GitHub Models vs Azure OpenAI
- **GitHub Models:** Бесплатан ниво за учење, није потребна кредитна картица
- **Azure OpenAI:** Спремно за продукцију, захтева Azure претплату
- Код је компатибилан између оба - само промените ендпоинт и API кључ

### Рад са више пројеката
Сваки пример пројекта је самосталан:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Уобичајени проблеми

**Неслагање верзије Јаве:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Проблеми са преузимањем зависности:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub токен није пронађен:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Порт је већ у употреби:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Подршка за више језика
- Документација доступна на 45+ језика преко аутоматизованог превода
- Преводи се налазе у директоријуму `translations/`
- Преводом управља GitHub Actions workflow

### Пут учења
1. Почните са [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Пратите поглавља редом (01 → 05)
3. Завршите практичне примере у сваком поглављу
4. Истражите пример пројекте у поглављу 4
5. Научите праксе одговорне AI у поглављу 5

### Развојни контејнер
Конфигурација `.devcontainer/devcontainer.json` укључује:
- Јава 21 развојно окружење
- Унапред инсталиран Maven
- VS Code Java екстензије
- Spring Boot алати
- Интеграција GitHub Copilot-а
- Docker-in-Docker подршка
- Azure CLI

### Разматрања о перформансама
- Бесплатни ниво GitHub Models има ограничења брзине
- Користите одговарајуће величине серија за уградње
- Размотрите кеширање за поновљене API позиве
- Пратите употребу токена ради оптимизације трошкова

### Напомене о безбедности
- Никада не комитујте `.env` фајлове (већ су у `.gitignore`)
- Користите променљиве окружења за API кључеве
- GitHub токени треба да имају минималне потребне опсеге
- Пратите смернице одговорне AI у поглављу 5

---

**Одрицање од одговорности**:  
Овај документ је преведен помоћу услуге за превођење уз помоћ вештачке интелигенције [Co-op Translator](https://github.com/Azure/co-op-translator). Иако се трудимо да обезбедимо тачност, молимо вас да имате у виду да аутоматски преводи могу садржати грешке или нетачности. Оригинални документ на његовом изворном језику треба сматрати меродавним извором. За критичне информације препоручује се професионални превод од стране људи. Не преузимамо одговорност за било каква погрешна тумачења или неспоразуме који могу настати услед коришћења овог превода.