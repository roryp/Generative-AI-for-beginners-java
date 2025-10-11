<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "00950ee1a40a84676b50da356c3a964a",
  "translation_date": "2025-10-11T10:18:45+00:00",
  "source_file": "README.md",
  "language_code": "ru"
}
-->
# Генеративный ИИ для начинающих - Java Edition
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Генеративный ИИ для начинающих - Java Edition](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.ru.png)

**Время на выполнение**: Весь воркшоп можно пройти онлайн без локальной настройки. Настройка окружения занимает 2 минуты, а изучение примеров требует от 1 до 3 часов, в зависимости от глубины изучения.

> **Быстрый старт**

1. Сделайте форк этого репозитория в свой аккаунт GitHub
2. Нажмите **Code** → вкладка **Codespaces** → **...** → **New with options...**
3. Используйте настройки по умолчанию – это выберет контейнер разработки, созданный для этого курса
4. Нажмите **Create codespace**
5. Подождите ~2 минуты, пока окружение будет готово
6. Перейдите сразу к [Первому примеру](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Поддержка нескольких языков

### Поддерживается через GitHub Action (автоматически и всегда актуально)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Арабский](../ar/README.md) | [Бенгальский](../bn/README.md) | [Болгарский](../bg/README.md) | [Бирманский (Мьянма)](../my/README.md) | [Китайский (упрощенный)](../zh/README.md) | [Китайский (традиционный, Гонконг)](../hk/README.md) | [Китайский (традиционный, Макао)](../mo/README.md) | [Китайский (традиционный, Тайвань)](../tw/README.md) | [Хорватский](../hr/README.md) | [Чешский](../cs/README.md) | [Датский](../da/README.md) | [Нидерландский](../nl/README.md) | [Эстонский](../et/README.md) | [Финский](../fi/README.md) | [Французский](../fr/README.md) | [Немецкий](../de/README.md) | [Греческий](../el/README.md) | [Иврит](../he/README.md) | [Хинди](../hi/README.md) | [Венгерский](../hu/README.md) | [Индонезийский](../id/README.md) | [Итальянский](../it/README.md) | [Японский](../ja/README.md) | [Корейский](../ko/README.md) | [Литовский](../lt/README.md) | [Малайский](../ms/README.md) | [Маратхи](../mr/README.md) | [Непальский](../ne/README.md) | [Норвежский](../no/README.md) | [Персидский (фарси)](../fa/README.md) | [Польский](../pl/README.md) | [Португальский (Бразилия)](../br/README.md) | [Португальский (Португалия)](../pt/README.md) | [Панджаби (Гурмукхи)](../pa/README.md) | [Румынский](../ro/README.md) | [Русский](./README.md) | [Сербский (кириллица)](../sr/README.md) | [Словацкий](../sk/README.md) | [Словенский](../sl/README.md) | [Испанский](../es/README.md) | [Суахили](../sw/README.md) | [Шведский](../sv/README.md) | [Тагальский (Филиппины)](../tl/README.md) | [Тамильский](../ta/README.md) | [Тайский](../th/README.md) | [Турецкий](../tr/README.md) | [Украинский](../uk/README.md) | [Урду](../ur/README.md) | [Вьетнамский](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Структура курса и учебный путь

### **Глава 1: Введение в генеративный ИИ**
- **Основные концепции**: Понимание больших языковых моделей, токенов, эмбеддингов и возможностей ИИ
- **Экосистема Java для ИИ**: Обзор Spring AI и OpenAI SDK
- **Протокол контекста модели**: Введение в MCP и его роль в коммуникации агентов ИИ
- **Практическое применение**: Реальные сценарии, включая чат-ботов и генерацию контента
- **[→ Начать главу 1](./01-IntroToGenAI/README.md)**

### **Глава 2: Настройка среды разработки**
- **Конфигурация для нескольких провайдеров**: Настройка GitHub Models, Azure OpenAI и OpenAI Java SDK
- **Spring Boot + Spring AI**: Лучшие практики для разработки корпоративных приложений ИИ
- **GitHub Models**: Бесплатный доступ к моделям ИИ для прототипирования и обучения (без необходимости кредитной карты)
- **Инструменты разработки**: Конфигурация Docker-контейнеров, VS Code и GitHub Codespaces
- **[→ Начать главу 2](./02-SetupDevEnvironment/README.md)**

### **Глава 3: Основные техники генеративного ИИ**
- **Инженерия запросов**: Техники для получения оптимальных ответов от моделей ИИ
- **Эмбеддинги и операции с векторами**: Реализация семантического поиска и сопоставления по схожести
- **Генерация с дополнением данных (RAG)**: Комбинирование ИИ с вашими собственными источниками данных
- **Вызов функций**: Расширение возможностей ИИ с помощью пользовательских инструментов и плагинов
- **[→ Начать главу 3](./03-CoreGenerativeAITechniques/README.md)**

### **Глава 4: Практическое применение и проекты**
- **Генератор историй о питомцах** (`petstory/`): Творческая генерация контента с использованием GitHub Models
- **Локальная демонстрация Foundry** (`foundrylocal/`): Интеграция локальных моделей ИИ с OpenAI Java SDK
- **Сервис калькулятора MCP** (`calculator/`): Базовая реализация протокола контекста модели с Spring AI
- **[→ Начать главу 4](./04-PracticalSamples/README.md)**

### **Глава 5: Ответственная разработка ИИ**
- **Безопасность GitHub Models**: Тестирование встроенной фильтрации контента и механизмов безопасности (жесткие блокировки и мягкие отказы)
- **Демонстрация ответственного ИИ**: Практический пример работы современных систем безопасности ИИ
- **Лучшие практики**: Основные рекомендации для этичной разработки и внедрения ИИ
- **[→ Начать главу 5](./05-ResponsibleGenAI/README.md)**

## Дополнительные ресурсы

- [Edge AI для начинающих](https://github.com/microsoft/edgeai-for-beginners)
- [MCP для начинающих](https://github.com/microsoft/mcp-for-beginners)
- [Агенты ИИ для начинающих](https://github.com/microsoft/ai-agents-for-beginners)
- [Генеративный ИИ для начинающих с использованием .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Генеративный ИИ для начинающих с использованием JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Генеративный ИИ для начинающих](https://github.com/microsoft/generative-ai-for-beginners)
- [Машинное обучение для начинающих](https://aka.ms/ml-beginners)
- [Наука о данных для начинающих](https://aka.ms/datascience-beginners)
- [ИИ для начинающих](https://aka.ms/ai-beginners)
- [Кибербезопасность для начинающих](https://github.com/microsoft/Security-101)
- [Веб-разработка для начинающих](https://aka.ms/webdev-beginners)
- [IoT для начинающих](https://aka.ms/iot-beginners)
- [Разработка XR для начинающих](https://github.com/microsoft/xr-development-for-beginners)
- [Мастерство GitHub Copilot для парного программирования с ИИ](https://aka.ms/GitHubCopilotAI)
- [Мастерство GitHub Copilot для разработчиков C#/.NET](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Выберите свое приключение с Copilot](https://github.com/microsoft/CopilotAdventures)
- [RAG Chat App с Azure AI Services](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## Получение помощи

Если вы столкнулись с трудностями или у вас есть вопросы о создании приложений ИИ, присоединяйтесь:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Если у вас есть отзывы о продукте или ошибки при разработке, посетите:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**Отказ от ответственности**:  
Этот документ был переведен с помощью сервиса автоматического перевода [Co-op Translator](https://github.com/Azure/co-op-translator). Несмотря на наши усилия обеспечить точность, автоматические переводы могут содержать ошибки или неточности. Оригинальный документ на его родном языке следует считать авторитетным источником. Для получения критически важной информации рекомендуется профессиональный перевод человеком. Мы не несем ответственности за любые недоразумения или неправильные интерпретации, возникшие в результате использования данного перевода.