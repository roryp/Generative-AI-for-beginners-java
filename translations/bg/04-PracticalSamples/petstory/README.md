<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T10:09:05+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "bg"
}
-->
# Приложение Pet Story

>**Note**: Тази глава включва [**Ръководство**](./TUTORIAL.md), което ви води през примерите.

Уеб приложение на Spring Boot, което генерира описания и истории, създадени от AI, за качени изображения на домашни любимци, използвайки GitHub Models.

## Съдържание

- [Технологичен стек](../../../../04-PracticalSamples/petstory)
- [Предварителни изисквания](../../../../04-PracticalSamples/petstory)
- [Настройка и инсталация](../../../../04-PracticalSamples/petstory)
- [Употреба](../../../../04-PracticalSamples/petstory)

## Технологичен стек

- **Backend**: Spring Boot 3.5.3, Java 21
- **AI интеграция**: OpenAI Java SDK с GitHub Models
- **Сигурност**: Spring Security
- **Frontend**: Thymeleaf шаблони с Bootstrap стилове
- **Инструмент за изграждане**: Maven
- **AI модели**: GitHub Models

## Предварителни изисквания

- Java 21 или по-нова версия
- Maven 3.9+
- GitHub Personal Access Token с обхват `models:read`

## Настройка и инсталация

### 1. Отидете в директорията на приложението petstory
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Задайте променлива на средата
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Изградете приложението
```bash
mvn clean compile
```

### 4. Стартирайте приложението
```bash
mvn spring-boot:run
```

## Употреба

1. **Достъп до приложението**: Отидете на `http://localhost:8080`
2. **Качете изображение**: Натиснете "Choose File" и изберете изображение на домашен любимец
3. **Анализирайте изображението**: Натиснете "Analyze Image", за да получите описание от AI
4. **Генерирайте история**: Натиснете "Generate Story", за да създадете история

**Отказ от отговорност**:  
Този документ е преведен с помощта на AI услуга за превод [Co-op Translator](https://github.com/Azure/co-op-translator). Въпреки че се стремим към точност, моля, имайте предвид, че автоматизираните преводи може да съдържат грешки или неточности. Оригиналният документ на неговия роден език трябва да се счита за авторитетен източник. За критична информация се препоръчва професионален човешки превод. Ние не носим отговорност за недоразумения или погрешни интерпретации, произтичащи от използването на този превод.