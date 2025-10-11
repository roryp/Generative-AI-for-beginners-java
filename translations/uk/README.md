<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "00950ee1a40a84676b50da356c3a964a",
  "translation_date": "2025-10-11T10:36:30+00:00",
  "source_file": "README.md",
  "language_code": "uk"
}
-->
# Генеративний AI для початківців - Java Edition
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Генеративний AI для початківців - Java Edition](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.uk.png)

**Часові витрати**: Весь воркшоп можна пройти онлайн без локального налаштування. Налаштування середовища займає 2 хвилини, а дослідження прикладів потребує 1-3 години залежно від глибини вивчення.

> **Швидкий старт**

1. Форкніть цей репозиторій у свій GitHub-акаунт
2. Натисніть **Code** → вкладка **Codespaces** → **...** → **New with options...**
3. Використовуйте налаштування за замовчуванням – це вибере контейнер розробки, створений для цього курсу
4. Натисніть **Create codespace**
5. Зачекайте ~2 хвилини, поки середовище буде готове
6. Перейдіть одразу до [Першого прикладу](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Підтримка багатомовності

### Підтримується через GitHub Action (автоматично та завжди актуально)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Арабська](../ar/README.md) | [Бенгальська](../bn/README.md) | [Болгарська](../bg/README.md) | [Бірманська (М'янма)](../my/README.md) | [Китайська (спрощена)](../zh/README.md) | [Китайська (традиційна, Гонконг)](../hk/README.md) | [Китайська (традиційна, Макао)](../mo/README.md) | [Китайська (традиційна, Тайвань)](../tw/README.md) | [Хорватська](../hr/README.md) | [Чеська](../cs/README.md) | [Данська](../da/README.md) | [Нідерландська](../nl/README.md) | [Естонська](../et/README.md) | [Фінська](../fi/README.md) | [Французька](../fr/README.md) | [Німецька](../de/README.md) | [Грецька](../el/README.md) | [Іврит](../he/README.md) | [Гінді](../hi/README.md) | [Угорська](../hu/README.md) | [Індонезійська](../id/README.md) | [Італійська](../it/README.md) | [Японська](../ja/README.md) | [Корейська](../ko/README.md) | [Литовська](../lt/README.md) | [Малайська](../ms/README.md) | [Маратхі](../mr/README.md) | [Непальська](../ne/README.md) | [Норвезька](../no/README.md) | [Перська (фарсі)](../fa/README.md) | [Польська](../pl/README.md) | [Португальська (Бразилія)](../br/README.md) | [Португальська (Португалія)](../pt/README.md) | [Панджабі (Гурмухі)](../pa/README.md) | [Румунська](../ro/README.md) | [Російська](../ru/README.md) | [Сербська (кирилиця)](../sr/README.md) | [Словацька](../sk/README.md) | [Словенська](../sl/README.md) | [Іспанська](../es/README.md) | [Суахілі](../sw/README.md) | [Шведська](../sv/README.md) | [Тагальська (Філіппіни)](../tl/README.md) | [Тамільська](../ta/README.md) | [Тайська](../th/README.md) | [Турецька](../tr/README.md) | [Українська](./README.md) | [Урду](../ur/README.md) | [В'єтнамська](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Структура курсу та навчальний шлях

### **Розділ 1: Вступ до генеративного AI**
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

### **Розділ 3: Основні техніки генеративного AI**
- **Інженерія запитів**: Техніки для отримання оптимальних відповідей від AI-моделей
- **Ембединги та операції з векторами**: Реалізація семантичного пошуку та порівняння схожості
- **Генерація з доповненням даних (RAG)**: Поєднання AI з вашими власними джерелами даних
- **Виклик функцій**: Розширення можливостей AI за допомогою власних інструментів та плагінів
- **[→ Почати розділ 3](./03-CoreGenerativeAITechniques/README.md)**

### **Розділ 4: Практичні застосування та проекти**
- **Генератор історій про домашніх тварин** (`petstory/`): Творча генерація контенту за допомогою GitHub Models
- **Локальна демонстрація Foundry** (`foundrylocal/`): Інтеграція локальних AI-моделей з OpenAI Java SDK
- **Сервіс калькулятора MCP** (`calculator/`): Базова реалізація протоколу контексту моделі з Spring AI
- **[→ Почати розділ 4](./04-PracticalSamples/README.md)**

### **Розділ 5: Відповідальна розробка AI**
- **Безпека GitHub Models**: Тестування вбудованих механізмів фільтрації контенту та безпеки (жорсткі блокування та м'які відмови)
- **Демонстрація відповідального AI**: Практичний приклад роботи сучасних систем безпеки AI
- **Найкращі практики**: Основні рекомендації для етичної розробки та впровадження AI
- **[→ Почати розділ 5](./05-ResponsibleGenAI/README.md)**

## Додаткові ресурси

- [Edge AI для початківців](https://github.com/microsoft/edgeai-for-beginners)
- [MCP для початківців](https://github.com/microsoft/mcp-for-beginners)
- [AI-агенти для початківців](https://github.com/microsoft/ai-agents-for-beginners)
- [Генеративний AI для початківців з використанням .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Генеративний AI для початківців з використанням JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Генеративний AI для початківців](https://github.com/microsoft/generative-ai-for-beginners)
- [ML для початківців](https://aka.ms/ml-beginners)
- [Data Science для початківців](https://aka.ms/datascience-beginners)
- [AI для початківців](https://aka.ms/ai-beginners)
- [Кібербезпека для початківців](https://github.com/microsoft/Security-101)
- [Веб-розробка для початківців](https://aka.ms/webdev-beginners)
- [IoT для початківців](https://aka.ms/iot-beginners)
- [XR-розробка для початківців](https://github.com/microsoft/xr-development-for-beginners)
- [Опанування GitHub Copilot для парного програмування з AI](https://aka.ms/GitHubCopilotAI)
- [Опанування GitHub Copilot для розробників C#/.NET](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Виберіть свою пригоду з Copilot](https://github.com/microsoft/CopilotAdventures)
- [RAG Chat App з Azure AI Services](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## Отримання допомоги

Якщо ви застрягли або маєте питання щодо створення AI-додатків, приєднуйтесь:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Якщо у вас є відгуки про продукт або виникають помилки під час розробки, відвідайте:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**Відмова від відповідальності**:  
Цей документ був перекладений за допомогою сервісу автоматичного перекладу [Co-op Translator](https://github.com/Azure/co-op-translator). Хоча ми прагнемо до точності, звертаємо вашу увагу, що автоматичні переклади можуть містити помилки або неточності. Оригінальний документ на його рідній мові слід вважати авторитетним джерелом. Для критично важливої інформації рекомендується професійний людський переклад. Ми не несемо відповідальності за будь-які непорозуміння або неправильне тлумачення, що виникли внаслідок використання цього перекладу.