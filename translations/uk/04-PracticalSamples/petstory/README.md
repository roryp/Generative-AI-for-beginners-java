<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T10:20:07+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "uk"
}
-->
# Додаток Pet Story

>**Примітка**: Цей розділ включає [**Підручник**](./TUTORIAL.md), який проведе вас через приклади.

Веб-додаток на основі Spring Boot, який створює описи та історії для завантажених зображень домашніх тварин за допомогою моделей GitHub, що працюють на основі штучного інтелекту.

## Зміст

- [Технологічний стек](../../../../04-PracticalSamples/petstory)
- [Попередні вимоги](../../../../04-PracticalSamples/petstory)
- [Налаштування та встановлення](../../../../04-PracticalSamples/petstory)
- [Використання](../../../../04-PracticalSamples/petstory)

## Технологічний стек

- **Бекенд**: Spring Boot 3.5.3, Java 21
- **Інтеграція з AI**: OpenAI Java SDK з моделями GitHub
- **Безпека**: Spring Security
- **Фронтенд**: Шаблони Thymeleaf зі стилізацією Bootstrap
- **Інструмент збірки**: Maven
- **AI Моделі**: Моделі GitHub

## Попередні вимоги

- Java 21 або новіша версія
- Maven 3.9+
- Персональний токен доступу GitHub зі сферою `models:read`

## Налаштування та встановлення

### 1. Перейдіть до директорії додатка petstory
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Встановіть змінну середовища
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Зберіть додаток
```bash
mvn clean compile
```

### 4. Запустіть додаток
```bash
mvn spring-boot:run
```

## Використання

1. **Доступ до додатка**: Перейдіть за адресою `http://localhost:8080`
2. **Завантажте зображення**: Натисніть "Choose File" і виберіть зображення домашньої тварини
3. **Аналізуйте зображення**: Натисніть "Analyze Image", щоб отримати опис від AI
4. **Створіть історію**: Натисніть "Generate Story", щоб створити історію

**Відмова від відповідальності**:  
Цей документ був перекладений за допомогою сервісу автоматичного перекладу [Co-op Translator](https://github.com/Azure/co-op-translator). Хоча ми прагнемо до точності, будь ласка, майте на увазі, що автоматичні переклади можуть містити помилки або неточності. Оригінальний документ на його рідній мові слід вважати авторитетним джерелом. Для критичної інформації рекомендується професійний людський переклад. Ми не несемо відповідальності за будь-які непорозуміння або неправильні тлумачення, що виникають внаслідок використання цього перекладу.