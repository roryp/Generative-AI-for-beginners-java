# AGENTS.md

## Обзор проекта

Это образовательный репозиторий для изучения разработки Generative AI с использованием Java. Он предлагает всесторонний практический курс, охватывающий большие языковые модели (LLMs), инженеринг запросов, эмбеддинги, RAG (генерация с дополнением извлечения) и протокол контекста модели (MCP).

**Основные технологии:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI и OpenAI SDKs

**Архитектура:**
- Несколько автономных приложений Spring Boot, организованных по главам
- Примерные проекты, демонстрирующие различные AI-паттерны
- Готовность к работе с GitHub Codespaces с предварительно настроенными контейнерами разработки

## Команды настройки

### Предварительные требования
- Java 21 или выше
- Maven 3.x
- Личный токен доступа GitHub (для GitHub Models)
- Опционально: учетные данные Azure OpenAI

### Настройка окружения

**Вариант 1: GitHub Codespaces (рекомендуется)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Вариант 2: Локальный контейнер разработки**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Вариант 3: Локальная настройка**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Конфигурация

**Настройка токена GitHub:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Настройка Azure OpenAI (опционально):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Рабочий процесс разработки

### Структура проекта
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

### Запуск приложений

**Запуск приложения Spring Boot:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Сборка проекта:**
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

**Запуск клиентских примеров:**
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

### Горячая перезагрузка
Spring Boot DevTools включен в проекты, поддерживающие горячую перезагрузку:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Инструкции по тестированию

### Запуск тестов

**Запуск всех тестов в проекте:**
```bash
cd [project-directory]
mvn test
```

**Запуск тестов с подробным выводом:**
```bash
mvn test -X
```

**Запуск конкретного класса тестов:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Структура тестов
- Тестовые файлы используют JUnit 5 (Jupiter)
- Классы тестов находятся в `src/test/java/`
- Клиентские примеры в проекте калькулятора находятся в `src/test/java/com/microsoft/mcp/sample/client/`

### Ручное тестирование
Многие примеры являются интерактивными приложениями, требующими ручного тестирования:

1. Запустите приложение с помощью `mvn spring-boot:run`
2. Тестируйте конечные точки или взаимодействуйте с CLI
3. Убедитесь, что ожидаемое поведение соответствует документации в README.md каждого проекта

### Тестирование с GitHub Models
- Ограничения бесплатного тарифа: 15 запросов/минуту, 150/день
- Максимум 5 одновременных запросов
- Тестируйте фильтрацию контента с примерами ответственного AI

## Руководство по стилю кода

### Конвенции Java
- **Версия Java:** Java 21 с современными функциями
- **Стиль:** Следуйте стандартным конвенциям Java
- **Именование:** 
  - Классы: PascalCase
  - Методы/переменные: camelCase
  - Константы: UPPER_SNAKE_CASE
  - Имена пакетов: строчные буквы

### Паттерны Spring Boot
- Используйте `@Service` для бизнес-логики
- Используйте `@RestController` для REST-эндпоинтов
- Конфигурация через `application.yml` или `application.properties`
- Предпочтение переменным окружения вместо жестко заданных значений
- Используйте аннотацию `@Tool` для методов, доступных через MCP

### Организация файлов
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
- Управляются через Maven `pom.xml`
- Spring AI BOM для управления версиями
- LangChain4j для интеграции AI
- Родительский стартер Spring Boot для зависимостей Spring

### Комментарии к коду
- Добавляйте JavaDoc для публичных API
- Включайте пояснительные комментарии для сложных взаимодействий AI
- Четко документируйте описания инструментов MCP

## Сборка и развертывание

### Сборка проектов

**Сборка без тестов:**
```bash
mvn clean install -DskipTests
```

**Сборка с проверками:**
```bash
mvn clean install
```

**Упаковка приложения:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Выходные директории
- Скомпилированные классы: `target/classes/`
- Тестовые классы: `target/test-classes/`
- JAR-файлы: `target/*.jar`
- Артефакты Maven: `target/`

### Конфигурация для конкретных окружений

**Разработка:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Продакшн:**
- Используйте модели Azure AI Foundry вместо GitHub Models
- Обновите базовый URL на конечную точку Azure OpenAI
- Управляйте секретами через Azure Key Vault или переменные окружения

### Особенности развертывания
- Это образовательный репозиторий с примерными приложениями
- Не предназначен для развертывания в продакшн в текущем виде
- Примеры демонстрируют паттерны, которые можно адаптировать для продакшн
- См. README.md отдельных проектов для заметок о развертывании

## Дополнительные заметки

### GitHub Models vs Azure OpenAI
- **GitHub Models:** Бесплатный тариф для обучения, не требуется кредитная карта
- **Azure OpenAI:** Готово к продакшн, требуется подписка Azure
- Код совместим с обоими — просто измените конечную точку и ключ API

### Работа с несколькими проектами
Каждый примерный проект автономен:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Общие проблемы

**Несоответствие версии Java:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Проблемы с загрузкой зависимостей:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**Токен GitHub не найден:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Порт уже используется:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Поддержка нескольких языков
- Документация доступна на 45+ языках через автоматический перевод
- Переводы находятся в директории `translations/`
- Перевод управляется рабочим процессом GitHub Actions

### Путь обучения
1. Начните с [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Следуйте главам по порядку (01 → 05)
3. Выполните практические примеры в каждой главе
4. Исследуйте примерные проекты в главе 4
5. Изучите практики ответственного AI в главе 5

### Контейнер разработки
Файл `.devcontainer/devcontainer.json` настраивает:
- Среду разработки Java 21
- Предустановленный Maven
- Расширения Java для VS Code
- Инструменты Spring Boot
- Интеграцию GitHub Copilot
- Поддержку Docker-in-Docker
- Azure CLI

### Особенности производительности
- Бесплатный тариф GitHub Models имеет ограничения по скорости
- Используйте подходящие размеры пакетов для эмбеддингов
- Рассмотрите возможность кэширования для повторяющихся API-запросов
- Следите за использованием токенов для оптимизации затрат

### Заметки по безопасности
- Никогда не коммитите файлы `.env` (уже добавлены в `.gitignore`)
- Используйте переменные окружения для ключей API
- Токены GitHub должны иметь минимально необходимые права
- Следуйте рекомендациям ответственного AI в главе 5

---

**Отказ от ответственности**:  
Этот документ был переведен с помощью сервиса автоматического перевода [Co-op Translator](https://github.com/Azure/co-op-translator). Несмотря на наши усилия обеспечить точность, автоматические переводы могут содержать ошибки или неточности. Оригинальный документ на его родном языке следует считать авторитетным источником. Для получения критически важной информации рекомендуется профессиональный перевод человеком. Мы не несем ответственности за любые недоразумения или неправильные интерпретации, возникшие в результате использования данного перевода.