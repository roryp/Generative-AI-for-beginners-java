# Генеративний ШІ для Початківців - Java Випуск  
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Генеративний ШІ для Початківців - Java Випуск](../../translated_images/uk/beg-genai-series.8b48be9951cc574c.webp)

**Час, потрібний для проходження**: Весь воркшоп можна пройти онлайн без локальної установки. Налаштування середовища займає 2 хвилини, а ознайомлення з прикладами - від 1 до 3 годин залежно від глибини вивчення.

> **Швидкий початок**

1. Форкніть цей репозиторій у свій акаунт GitHub  
2. Натисніть **Code** → вкладку **Codespaces** → **...** → **New with options...**  
3. Використайте налаштування за замовчуванням – це вибере контейнер розробки, створений для цього курсу  
4. Натисніть **Create codespace**  
5. Почекайте приблизно 2 хвилини, доки середовище буде готове  
6. Перейдіть прямо до [Першого прикладу](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)  

> **Віддаєте перевагу клонувати локально?**  
>  
> Цей репозиторій містить понад 50 перекладів мовами, що значно збільшує розмір завантаження. Щоб клонувати без перекладів, використовуйте sparse checkout:  
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> Це дає все, що вам потрібно для проходження курсу з набагато швидшим завантаженням.


## Підтримка Багатьох Мов

### Підтримується через GitHub Action (Автоматично та Завжди Оновлено)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Арабська](../ar/README.md) | [Бенгальська](../bn/README.md) | [Болгарська](../bg/README.md) | [Бирманська (М’янма)](../my/README.md) | [Китайська (спрощена)](../zh-CN/README.md) | [Китайська (традиційна, Гонконг)](../zh-HK/README.md) | [Китайська (традиційна, Макао)](../zh-MO/README.md) | [Китайська (традиційна, Тайвань)](../zh-TW/README.md) | [Хорватська](../hr/README.md) | [Чеська](../cs/README.md) | [Данська](../da/README.md) | [Голландська](../nl/README.md) | [Естонська](../et/README.md) | [Фінська](../fi/README.md) | [Французька](../fr/README.md) | [Німецька](../de/README.md) | [Грецька](../el/README.md) | [Іврит](../he/README.md) | [Хінді](../hi/README.md) | [Угорська](../hu/README.md) | [Індонезійська](../id/README.md) | [Італійська](../it/README.md) | [Японська](../ja/README.md) | [Каннада](../kn/README.md) | [Корейська](../ko/README.md) | [Литовська](../lt/README.md) | [Малайська](../ms/README.md) | [Малаялам](../ml/README.md) | [Маратхі](../mr/README.md) | [Непальська](../ne/README.md) | [Нігерійський підійзьн](../pcm/README.md) | [Норвезька](../no/README.md) | [Перська (Фарсі)](../fa/README.md) | [Польська](../pl/README.md) | [Португальська (Бразилія)](../pt-BR/README.md) | [Португальська (Португалія)](../pt-PT/README.md) | [Пенджабі (Гурмукхі)](../pa/README.md) | [Румунська](../ro/README.md) | [Російська](../ru/README.md) | [Сербська (кирилиця)](../sr/README.md) | [Словацька](../sk/README.md) | [Словенська](../sl/README.md) | [Іспанська](../es/README.md) | [Суахілі](../sw/README.md) | [Шведська](../sv/README.md) | [Тагалог (філіппінська)](../tl/README.md) | [Тамільська](../ta/README.md) | [Телугу](../te/README.md) | [Тайська](../th/README.md) | [Турецька](../tr/README.md) | [Українська](./README.md) | [Урду](../ur/README.md) | [В’єтнамська](../vi/README.md)

> **Віддаєте перевагу клонувати локально?**  
>  
> Цей репозиторій містить понад 50 перекладів мовами, що значно збільшує розмір завантаження. Щоб клонувати без перекладів, використовуйте sparse checkout:  
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> Це дає все, що вам потрібно для проходження курсу з набагато швидшим завантаженням.  
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Структура Курсу та Шлях Навчання

### **Розділ 1: Вступ до Генеративного ШІ**  
- **Основні поняття**: Розуміння великих мовних моделей, токенів, вбудувань та можливостей ШІ  
- **Екосистема Java AI**: Огляд Spring AI і OpenAI SDK  
- **Протокол Контексту Моделі**: Введення в MCP і його роль у комунікації агентів ШІ  
- **Практичні застосування**: Реальні сценарії, включно з чатботами та генерацією контенту  
- **[→ Почати Розділ 1](./01-IntroToGenAI/README.md)**

### **Розділ 2: Налаштування Середовища Розробки**  
- **Конфігурація для кількох провайдерів**: Налаштування GitHub Models, Azure OpenAI та інтеграції OpenAI Java SDK  
- **Spring Boot + Spring AI**: Кращі практики для розробки корпоративних AI-додатків  
- **GitHub Models**: Безкоштовний доступ до AI-моделей для прототипування та навчання (без кредитної картки)  
- **Інструменти розробки**: Docker контейнери, VS Code та налаштування GitHub Codespaces  
- **[→ Почати Розділ 2](./02-SetupDevEnvironment/README.md)**

### **Розділ 3: Основні Техніки Генеративного ШІ**  
- **Інженерія підказок**: Техніки для оптимальних відповідей моделей ШІ  
- **Вбудування та операції з векторами**: Реалізація семантичного пошуку та порівняння схожості  
- **Ретривальна доповнена генерація (RAG)**: Комбінування ШІ з вашими власними джерелами даних  
- **Виклик функцій**: Розширення можливостей ШІ за допомогою власних інструментів і плагінів  
- **[→ Почати Розділ 3](./03-CoreGenerativeAITechniques/README.md)**

### **Розділ 4: Практичні Застосування та Проєкти**  
- **Генератор історій про домашніх улюбленців** (`petstory/`): Креативне генерування контенту з GitHub Models  
- **Демо Foundry Local** (`foundrylocal/`): Локальна інтеграція AI моделей з OpenAI Java SDK  
- **Сервіс калькулятора MCP** (`calculator/`): Базова реалізація Протоколу Контексту Моделі з Spring AI  
- **[→ Почати Розділ 4](./04-PracticalSamples/README.md)**

### **Розділ 5: Відповідальна Розробка ШІ**  
- **Безпека GitHub Models**: Тестування вбудованих фільтрів контенту та механізмів безпеки (жорсткі блоки та м'які відмови)  
- **Демо Відповідального ШІ**: Практичний приклад роботи сучасних систем безпеки ШІ  
- **Кращі практики**: Важливі настанови для етичної розробки та впровадження ШІ  
- **[→ Почати Розділ 5](./05-ResponsibleGenAI/README.md)**

## Додаткові Ресурси

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain  
[![LangChain4j для Початківців](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)  
[![LangChain.js для Початківців](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)

---

### Azure / Edge / MCP / Агенти  
[![AZD для Початківців](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![Edge AI для Початківців](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![MCP для Початківців](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![AI Агенти для Початківців](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### Серія Генеративного ШІ  
[![Генеративний ШІ для Початківців](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)  
[![Генеративний ШІ (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)  
[![Генеративний ШІ (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)  
[![Генеративний ШІ (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---

### Основне навчання  
[![Машинне навчання для Початківців](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)  
[![Data Science для Початківців](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)  
[![ШІ для Початківців](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)  
[![Кібербезпека для Початківців](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Web Dev for Beginners](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT for Beginners](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![XR Development for Beginners](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Серія Copilot
[![Copilot for AI Paired Programming](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot for C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Copilot Adventure](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## Отримання допомоги

Якщо ви застрягли або у вас є питання щодо створення AI-додатків. Приєднуйтесь до інших учнів і досвідчених розробників у дискусіях про MCP. Це підтримуюча спільнота, де питання вітаються, а знання вільно обмінюються.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

Якщо у вас є відгуки про продукт або помилки під час створення, відвідайте:

[![Microsoft Foundry Developer Forum](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Відмова від відповідальності**:  
Цей документ було перекладено за допомогою сервісу автоматичного перекладу [Co-op Translator](https://github.com/Azure/co-op-translator). Хоча ми прагнемо до точності, будь ласка, майте на увазі, що автоматичні переклади можуть містити помилки або неточності. Оригінальний документ мовою оригіналу слід вважати авторитетним джерелом. Для важливої інформації рекомендується звертатися до професійного людського перекладу. Ми не несемо відповідальності за будь-які непорозуміння або неправильні тлумачення, що виникли внаслідок використання цього перекладу.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->