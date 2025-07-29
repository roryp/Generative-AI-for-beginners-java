<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "63b6426b88f6f56398ca3f1fbfc30889",
  "translation_date": "2025-07-29T10:28:53+00:00",
  "source_file": "README.md",
  "language_code": "uk"
}
-->
# Генеративний штучний інтелект для початківців - Java Edition
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Генеративний штучний інтелект для початківців - Java Edition](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.uk.png)

**Часові витрати**: Увесь воркшоп можна пройти онлайн без локального налаштування. Налаштування середовища займає 2 хвилини, а дослідження прикладів потребує 1-3 години залежно від глибини вивчення.

> **Швидкий старт**

1. Форкніть цей репозиторій у свій обліковий запис GitHub
2. Натисніть **Code** → вкладка **Codespaces** → **...** → **New with options...**
3. Використовуйте налаштування за замовчуванням – це вибере контейнер розробки, створений для цього курсу
4. Натисніть **Create codespace**
5. Зачекайте ~2 хвилини, поки середовище буде готове
6. Перейдіть одразу до [Першого прикладу](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Підтримка кількох мов

### Підтримується через GitHub Action (автоматично та завжди актуально)

[Французька](../fr/README.md) | [Іспанська](../es/README.md) | [Німецька](../de/README.md) | [Російська](../ru/README.md) | [Арабська](../ar/README.md) | [Перська (фарсі)](../fa/README.md) | [Урду](../ur/README.md) | [Китайська (спрощена)](../zh/README.md) | [Китайська (традиційна, Макао)](../mo/README.md) | [Китайська (традиційна, Гонконг)](../hk/README.md) | [Китайська (традиційна, Тайвань)](../tw/README.md) | [Японська](../ja/README.md) | [Корейська](../ko/README.md) | [Гінді](../hi/README.md) | [Бенгальська](../bn/README.md) | [Маратхі](../mr/README.md) | [Непальська](../ne/README.md) | [Панджабі (гурмухі)](../pa/README.md) | [Португальська (Португалія)](../pt/README.md) | [Португальська (Бразилія)](../br/README.md) | [Італійська](../it/README.md) | [Польська](../pl/README.md) | [Турецька](../tr/README.md) | [Грецька](../el/README.md) | [Тайська](../th/README.md) | [Шведська](../sv/README.md) | [Данська](../da/README.md) | [Норвезька](../no/README.md) | [Фінська](../fi/README.md) | [Голландська](../nl/README.md) | [Іврит](../he/README.md) | [В'єтнамська](../vi/README.md) | [Індонезійська](../id/README.md) | [Малайська](../ms/README.md) | [Тагальська (філіппінська)](../tl/README.md) | [Суахілі](../sw/README.md) | [Угорська](../hu/README.md) | [Чеська](../cs/README.md) | [Словацька](../sk/README.md) | [Румунська](../ro/README.md) | [Болгарська](../bg/README.md) | [Сербська (кирилиця)](../sr/README.md) | [Хорватська](../hr/README.md) | [Словенська](../sl/README.md) | [Українська](./README.md) | [Бірманська (М'янма)](../my/README.md)

## Структура курсу та навчальний шлях

### **Розділ 1: Вступ до генеративного ШІ**
- **Основні концепції**: Розуміння великих мовних моделей, токенів, векторних уявлень та можливостей ШІ
- **Екосистема Java для ШІ**: Огляд Spring AI та OpenAI SDK
- **Протокол контексту моделі**: Вступ до MCP та його роль у комунікації агентів ШІ
- **Практичні застосування**: Реальні сценарії, включаючи чат-ботів та генерацію контенту
- **[→ Почати розділ 1](./01-IntroToGenAI/README.md)**

### **Розділ 2: Налаштування середовища розробки**
- **Конфігурація для кількох провайдерів**: Налаштування GitHub Models, Azure OpenAI та інтеграції OpenAI Java SDK
- **Spring Boot + Spring AI**: Найкращі практики для розробки корпоративних застосунків ШІ
- **GitHub Models**: Безкоштовний доступ до моделей ШІ для прототипування та навчання (без необхідності кредитної картки)
- **Інструменти розробки**: Конфігурація Docker-контейнерів, VS Code та GitHub Codespaces
- **[→ Почати розділ 2](./02-SetupDevEnvironment/README.md)**

### **Розділ 3: Основні техніки генеративного ШІ**
- **Інженерія запитів**: Техніки для отримання оптимальних відповідей від моделей ШІ
- **Векторні уявлення та операції**: Реалізація семантичного пошуку та порівняння схожості
- **Генерація з доповненням даних (RAG)**: Поєднання ШІ з вашими власними джерелами даних
- **Виклик функцій**: Розширення можливостей ШІ за допомогою власних інструментів та плагінів
- **[→ Почати розділ 3](./03-CoreGenerativeAITechniques/README.md)**

### **Розділ 4: Практичні застосування та проєкти**
- **Генератор історій про домашніх тварин** (`petstory/`): Творча генерація контенту за допомогою GitHub Models
- **Локальна демонстрація Foundry** (`foundrylocal/`): Інтеграція локальних моделей ШІ з OpenAI Java SDK
- **Сервіс калькулятора MCP** (`calculator/`): Базова реалізація протоколу контексту моделі з використанням Spring AI
- **[→ Почати розділ 4](./04-PracticalSamples/README.md)**

### **Розділ 5: Розробка відповідального ШІ**
- **Безпека GitHub Models**: Тестування вбудованих механізмів фільтрації контенту та систем безпеки (жорсткі блокування та м'які відмови)
- **Демонстрація відповідального ШІ**: Практичний приклад роботи сучасних систем безпеки ШІ
- **Найкращі практики**: Основні рекомендації для етичної розробки та впровадження ШІ
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
Цей документ було перекладено за допомогою сервісу автоматичного перекладу [Co-op Translator](https://github.com/Azure/co-op-translator). Хоча ми прагнемо до точності, звертаємо вашу увагу, що автоматичні переклади можуть містити помилки або неточності. Оригінальний документ мовою оригіналу слід вважати авторитетним джерелом. Для критично важливої інформації рекомендується професійний людський переклад. Ми не несемо відповідальності за будь-які непорозуміння або неправильні тлумачення, що виникли внаслідок використання цього перекладу.