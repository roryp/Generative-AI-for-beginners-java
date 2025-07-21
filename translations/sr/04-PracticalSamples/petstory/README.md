<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "69dffd84127360d3f9446b89de471abe",
  "translation_date": "2025-07-21T21:37:15+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "sr"
}
-->
# Апликација Pet Story

>**Напомена**: Ово поглавље укључује [**Туторијал**](./TUTORIAL.md) који вас води кроз покретање готових примера.

Веб апликација заснована на Spring Boot-у која генерише описа и приче за слике кућних љубимаца уз помоћ GitHub модела и вештачке интелигенције.

## Садржај

- [Технолошки стек](../../../../04-PracticalSamples/petstory)
- [Предуслови](../../../../04-PracticalSamples/petstory)
- [Подешавање и инсталација](../../../../04-PracticalSamples/petstory)
- [Коришћење](../../../../04-PracticalSamples/petstory)

## Технолошки стек

- **Бекенд**: Spring Boot 3.5.3, Java 21
- **Интеграција са вештачком интелигенцијом**: OpenAI Java SDK са GitHub моделима
- **Сигурност**: Spring Security
- **Фронтенд**: Thymeleaf шаблони са Bootstrap стиловима
- **Алат за изградњу**: Maven
- **Модели вештачке интелигенције**: GitHub модели

## Предуслови

- Java 21 или новија
- Maven 3.9+
- GitHub Personal Access Token са `models:read` дозволом

## Подешавање и инсталација

### 1. Идите у директоријум апликације petstory
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Поставите променљиву окружења
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Изградите апликацију
```bash
mvn clean compile
```

### 4. Покрените апликацију
```bash
mvn spring-boot:run
```

## Коришћење

1. **Приступите апликацији**: Идите на `http://localhost:8080`
2. **Отпремите слику**: Кликните на "Choose File" и изаберите слику кућног љубимца
3. **Анализирајте слику**: Кликните на "Analyze Image" да бисте добили опис уз помоћ вештачке интелигенције
4. **Генеришите причу**: Кликните на "Generate Story" да бисте креирали причу

**Одрицање од одговорности**:  
Овај документ је преведен коришћењем услуге за превођење помоћу вештачке интелигенције [Co-op Translator](https://github.com/Azure/co-op-translator). Иако настојимо да обезбедимо тачност, молимо вас да имате у виду да аутоматски преводи могу садржати грешке или нетачности. Оригинални документ на његовом изворном језику треба сматрати меродавним извором. За критичне информације препоручује се професионални превод од стране људи. Не преузимамо одговорност за било каква погрешна тумачења или неспоразуме који могу настати услед коришћења овог превода.