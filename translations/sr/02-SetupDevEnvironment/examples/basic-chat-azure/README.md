# Основни разговор са Azure OpenAI - Пример од почетка до краја

Овај пример показује како да направите једноставну Spring Boot апликацију која се повезује са Azure OpenAI и тестира вашу конфигурацију.

## Садржај

- [Предуслови](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Брзи почетак](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Опције конфигурације](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Опција 1: Променљиве окружења (.env датотека) - Препоручено](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Опција 2: Тајне у GitHub Codespace](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Покретање апликације](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Коришћење Maven-а](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Коришћење VS Code-а](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Очекивани резултат](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Референца конфигурације](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Променљиве окружења](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Spring конфигурација](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Решавање проблема](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Уобичајени проблеми](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Режим дебаговања](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Следећи кораци](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Ресурси](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## Предуслови

Пре него што покренете овај пример, уверите се да имате:

- Завршен [Azure OpenAI водич за подешавање](../../getting-started-azure-openai.md)  
- Деплојован Azure OpenAI ресурс (преко Azure AI Foundry портала)  
- Деплојован gpt-4o-mini модел (или алтернативни)  
- API кључ и URL крајње тачке из Azure  

## Брзи почетак

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Опције конфигурације

### Опција 1: Променљиве окружења (.env датотека) - Препоручено

**Корак 1: Направите вашу конфигурациону датотеку**
```bash
cp .env.example .env
```

**Корак 2: Додајте ваше Azure OpenAI акредитиве**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Безбедносна напомена**: 
> - Никада не додајте `.env` датотеку у верзионисање
> - `.env` датотека је већ у `.gitignore`
> - Чувајте ваше API кључеве безбедно и редовно их ротирајте

### Опција 2: Тајне у GitHub Codespace

За GitHub Codespaces, поставите ове тајне у вашем репозиторијуму:
- `AZURE_AI_KEY` - Ваш Azure OpenAI API кључ
- `AZURE_AI_ENDPOINT` - Ваш Azure OpenAI URL крајње тачке

Апликација аутоматски детектује и користи ове тајне.

### Алтернатива: Директне променљиве окружења

<details>
<summary>Кликните да видите команде специфичне за платформу</summary>

**Linux/macOS (bash/zsh):**
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (Command Prompt):**
```cmd
set AZURE_AI_KEY=your-actual-api-key-here
set AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (PowerShell):**
```powershell
$env:AZURE_AI_KEY="your-actual-api-key-here"
$env:AZURE_AI_ENDPOINT="https://your-hub-name.openai.azure.com/"
```
</details>

## Покретање апликације

### Коришћење Maven-а

```bash
mvn spring-boot:run
```

### Коришћење VS Code-а

1. Отворите пројекат у VS Code-у
2. Притисните `F5` или користите панел "Run and Debug"
3. Изаберите конфигурацију "Spring Boot-BasicChatApplication"

> **Напомена**: Конфигурација у VS Code-у аутоматски учитава вашу `.env` датотеку

### Очекивани резултат

```
Starting Basic Chat with Azure OpenAI...
Environment variables loaded successfully
Connecting to Azure OpenAI...
Sending prompt: What is AI in a short sentence? Max 100 words.

AI Response:
================
AI, or Artificial Intelligence, is the simulation of human intelligence in machines programmed to think and learn like humans.
================

Success! Azure OpenAI connection is working correctly.
```

## Референца конфигурације

### Променљиве окружења

| Променљива | Опис | Обавезно | Пример |
|------------|------|----------|--------|
| `AZURE_AI_KEY` | Azure OpenAI API кључ | Да | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI URL крајње тачке | Да | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Назив деплојованог модела | Не | `gpt-4o-mini` (подразумевано) |

### Spring конфигурација

Датотека `application.yml` конфигурише:
- **API кључ**: `${AZURE_AI_KEY}` - Из променљиве окружења
- **Крајња тачка**: `${AZURE_AI_ENDPOINT}` - Из променљиве окружења  
- **Модел**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Из променљиве окружења са резервном вредношћу
- **Температура**: `0.7` - Контролише креативност (0.0 = детерминистички, 1.0 = креативно)
- **Максимални број токена**: `500` - Максимална дужина одговора

## Решавање проблема

### Уобичајени проблеми

<details>
<summary><strong>Грешка: "API кључ није валидан"</strong></summary>

- Проверите да ли је ваш `AZURE_AI_KEY` правилно постављен у вашој `.env` датотеци
- Уверите се да је API кључ тачно копиран из Azure AI Foundry портала
- Проверите да нема додатних размака или наводника око кључа
</details>

<details>
<summary><strong>Грешка: "Крајња тачка није валидна"</strong></summary>

- Уверите се да ваш `AZURE_AI_ENDPOINT` укључује пун URL (нпр. `https://your-hub-name.openai.azure.com/`)
- Проверите конзистентност са косом цртом на крају
- Уверите се да крајња тачка одговара вашем Azure региону деплоја
</details>

<details>
<summary><strong>Грешка: "Деплојмент није пронађен"</strong></summary>

- Проверите да ли назив вашег модела деплоја тачно одговара ономе што је деплојовано у Azure
- Уверите се да је модел успешно деплојован и активан
- Покушајте да користите подразумевани назив деплојмента: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: Променљиве окружења се не учитавају</strong></summary>

- Уверите се да је ваша `.env` датотека у корену пројекта (исти ниво као `pom.xml`)
- Покушајте да покренете `mvn spring-boot:run` у интегрисаном терминалу VS Code-а
- Проверите да ли је VS Code Java екстензија правилно инсталирана
- Уверите се да конфигурација покретања има `"envFile": "${workspaceFolder}/.env"`
</details>

### Режим дебаговања

Да бисте омогућили детаљно логовање, уклоните коментаре са ових линија у `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Следећи кораци

**Подешавање завршено!** Наставите своје учење:

[Поглавље 3: Основне технике генеративне вештачке интелигенције](../../../03-CoreGenerativeAITechniques/README.md)

## Ресурси

- [Spring AI Azure OpenAI документација](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Azure OpenAI Service документација](https://learn.microsoft.com/azure/ai-services/openai/)
- [Azure AI Foundry портал](https://ai.azure.com/)
- [Azure AI Foundry документација](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**Одрицање од одговорности**:  
Овај документ је преведен коришћењем услуге за превођење помоћу вештачке интелигенције [Co-op Translator](https://github.com/Azure/co-op-translator). Иако се трудимо да обезбедимо тачност, молимо вас да имате у виду да аутоматски преводи могу садржати грешке или нетачности. Оригинални документ на његовом изворном језику треба сматрати ауторитативним извором. За критичне информације, препоручује се професионални превод од стране људи. Не преузимамо одговорност за било каква погрешна тумачења или неспоразуме који могу настати услед коришћења овог превода.