<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "79df2d245c12d6b8ad57148fd049f106",
  "translation_date": "2025-07-23T12:42:57+00:00",
  "source_file": "README.md",
  "language_code": "uk"
}
-->
# Генеративний AI для початківців - Java Edition
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Генеративний AI для початківців - Java Edition](../../translated_images/beg-genai-series.61edc4a6b2cc54284fa2d70eda26dc0ca2669e26e49655b842ea799cd6e16d2a.uk.png)

> **NOTE: Швидкий старт**: Увесь курс можна пройти онлайн - локальна установка не потрібна!
1. Форкніть цей репозиторій у свій GitHub акаунт
2. Натисніть **Code** → вкладка **Codespaces** → **...** → **New with options...**
3. Використовуйте налаштування за замовчуванням – це вибере контейнер розробки, створений для цього курсу
4. Натисніть **Create codespace**
5. Зачекайте ~2 хвилини, поки середовище буде готове
6. Перейдіть одразу до [Створення токена GitHub Models](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Підтримка багатомовності

### Підтримується через GitHub Action (автоматично та завжди актуально)

[French](../fr/README.md) | [Spanish](../es/README.md) | [German](../de/README.md) | [Russian](../ru/README.md) | [Arabic](../ar/README.md) | [Persian (Farsi)](../fa/README.md) | [Urdu](../ur/README.md) | [Chinese (Simplified)](../zh/README.md) | [Chinese (Traditional, Macau)](../mo/README.md) | [Chinese (Traditional, Hong Kong)](../hk/README.md) | [Chinese (Traditional, Taiwan)](../tw/README.md) | [Japanese](../ja/README.md) | [Korean](../ko/README.md) | [Hindi](../hi/README.md) | [Bengali](../bn/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Portuguese (Portugal)](../pt/README.md) | [Portuguese (Brazil)](../br/README.md) | [Italian](../it/README.md) | [Polish](../pl/README.md) | [Turkish](../tr/README.md) | [Greek](../el/README.md) | [Thai](../th/README.md) | [Swedish](../sv/README.md) | [Danish](../da/README.md) | [Norwegian](../no/README.md) | [Finnish](../fi/README.md) | [Dutch](../nl/README.md) | [Hebrew](../he/README.md) | [Vietnamese](../vi/README.md) | [Indonesian](../id/README.md) | [Malay](../ms/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Swahili](../sw/README.md) | [Hungarian](../hu/README.md) | [Czech](../cs/README.md) | [Slovak](../sk/README.md) | [Romanian](../ro/README.md) | [Bulgarian](../bg/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Croatian](../hr/README.md) | [Slovenian](../sl/README.md) | [Ukrainian](./README.md) | [Burmese (Myanmar)](../my/README.md)

## Структура курсу та навчальний шлях

**Часові витрати**: Налаштування середовища займає 2 хвилини, практичні уроки потребують 1-3 години кожен залежно від глибини дослідження.

### **Розділ 1: Вступ до Генеративного AI**
- **Основні концепції**: Розуміння великих мовних моделей, токенів, ембедингів та можливостей AI
- **Екосистема Java AI**: Огляд Spring AI та OpenAI SDK
- **Протокол контексту моделі**: Вступ до MCP та його ролі у комунікації AI-агентів
- **Практичні застосування**: Реальні сценарії, включаючи чат-ботів та генерацію контенту
- **[→ Почати розділ 1](./01-IntroToGenAI/README.md)**

### **Розділ 2: Налаштування середовища розробки**
- **Конфігурація для кількох провайдерів**: Налаштування інтеграцій GitHub Models, Azure OpenAI та OpenAI Java SDK
- **Spring Boot + Spring AI**: Найкращі практики для розробки корпоративних AI-додатків
- **GitHub Models**: Безкоштовний доступ до AI-моделей для прототипування та навчання (без необхідності кредитної картки)
- **Інструменти розробки**: Конфігурація Docker-контейнерів, VS Code та GitHub Codespaces
- **[→ Почати розділ 2](./02-SetupDevEnvironment/README.md)**

### **Розділ 3: Основні техніки Генеративного AI**
- **Інженерія запитів**: Техніки для отримання оптимальних відповідей від AI-моделей
- **Ембединги та операції з векторами**: Реалізація семантичного пошуку та порівняння схожості
- **Генерація з доповненням даних (RAG)**: Поєднання AI з вашими власними джерелами даних
- **Виклик функцій**: Розширення можливостей AI за допомогою власних інструментів та плагінів
- **[→ Почати розділ 3](./03-CoreGenerativeAITechniques/README.md)**

### **Розділ 4: Практичні застосування та проекти**
- **Генератор історій про домашніх тварин** (`petstory/`): Творча генерація контенту за допомогою GitHub Models
- **Локальна демонстрація Foundry** (`foundrylocal/`): Інтеграція локальних AI-моделей з OpenAI Java SDK
- **Сервіс калькулятора MCP** (`mcp/calculator/`): Базова реалізація протоколу контексту моделі з Spring AI
- **[→ Почати розділ 4](./04-PracticalSamples/README.md)**

### **Розділ 5: Відповідальна розробка AI**
- **Безпека GitHub Models**: Тестування вбудованих фільтрів контенту та механізмів безпеки
- **Демонстрація відповідального AI**: Практичний приклад роботи фільтрів безпеки AI
- **Найкращі практики**: Основні рекомендації для етичної розробки та впровадження AI
- **[→ Почати розділ 5](./05-ResponsibleGenAI/README.md)**

## Додаткові ресурси 

- [AI Agents For Beginners](https://github.com/microsoft/ai-agents-for-beginners)
- [Generative AI for Beginners using .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generative AI for Beginners using JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Generative AI for Beginners](https://github.com/microsoft/generative-ai-for-beginners)
- [ML for Beginners](https://aka.ms/ml-beginners)
- [Data Science for Beginners](https://aka.ms/datascience-beginners)
- [AI for Beginners](https://aka.ms/ai-beginners)
- [Cybersecurity for Beginners](https://github.com/microsoft/Security-101)
- [Web Dev for Beginners](https://aka.ms/webdev-beginners)
- [IoT for Beginners](https://aka.ms/iot-beginners)
- [XR Development for Beginners](https://github.com/microsoft/xr-development-for-beginners)
- [Mastering GitHub Copilot for AI Paired Programming](https://aka.ms/GitHubCopilotAI)
- [Mastering GitHub Copilot for C#/.NET Developers](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Choose Your Own Copilot Adventure](https://github.com/microsoft/CopilotAdventures)
- [RAG Chat App with Azure AI Services](https://github.com/Azure-Samples/azure-search-openai-demo-java)

**Відмова від відповідальності**:  
Цей документ було перекладено за допомогою сервісу автоматичного перекладу [Co-op Translator](https://github.com/Azure/co-op-translator). Хоча ми прагнемо до точності, звертаємо вашу увагу, що автоматичні переклади можуть містити помилки або неточності. Оригінальний документ на його рідній мові слід вважати авторитетним джерелом. Для критично важливої інформації рекомендується професійний людський переклад. Ми не несемо відповідальності за будь-які непорозуміння або неправильні тлумачення, що виникли внаслідок використання цього перекладу.