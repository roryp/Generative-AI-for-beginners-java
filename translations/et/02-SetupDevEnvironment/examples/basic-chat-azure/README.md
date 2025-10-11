<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "efd82efe50711d7e257eb943151d682c",
  "translation_date": "2025-10-11T10:45:49+00:00",
  "source_file": "02-SetupDevEnvironment/examples/basic-chat-azure/README.md",
  "language_code": "et"
}
-->
# Põhiline vestlus Azure OpenAI-ga - Näide algusest lõpuni

See näide näitab, kuidas luua lihtne Spring Boot rakendus, mis ühendub Azure OpenAI-ga ja testib teie seadistust.

## Sisukord

- [Eeltingimused](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Kiire alustamine](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Konfiguratsioonivalikud](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Valik 1: Keskkonnamuutujad (.env fail) - Soovitatav](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Valik 2: GitHub Codespace'i saladused](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Rakenduse käivitamine](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Maveni kasutamine](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [VS Code'i kasutamine](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Oodatav väljund](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Konfiguratsiooni viide](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Keskkonnamuutujad](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Spring konfiguratsioon](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Tõrkeotsing](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Levinud probleemid](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Debug-režiim](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Järgmised sammud](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Ressursid](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## Eeltingimused

Enne selle näite käivitamist veenduge, et teil on:

- Läbitud [Azure OpenAI seadistusjuhend](../../getting-started-azure-openai.md)  
- Azure OpenAI ressurss juurutatud (Azure AI Foundry portaalis)  
- gpt-4o-mini mudel (või alternatiiv) juurutatud  
- API võti ja lõpp-punkti URL Azure'ist  

## Kiire alustamine

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Konfiguratsioonivalikud

### Valik 1: Keskkonnamuutujad (.env fail) - Soovitatav

**Samm 1: Looge oma konfiguratsioonifail**
```bash
cp .env.example .env
```

**Samm 2: Lisage oma Azure OpenAI mandaadid**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Turvanõuanne**: 
> - Ärge kunagi lisage `.env` faili versioonihaldusse
> - `.env` fail on juba `.gitignore` failis
> - Hoidke oma API võtmed turvaliselt ja vahetage neid regulaarselt

### Valik 2: GitHub Codespace'i saladused

GitHub Codespace'i jaoks seadistage need saladused oma repositooriumis:
- `AZURE_AI_KEY` - Teie Azure OpenAI API võti
- `AZURE_AI_ENDPOINT` - Teie Azure OpenAI lõpp-punkti URL

Rakendus tuvastab ja kasutab neid saladusi automaatselt.

### Alternatiiv: Otsesed keskkonnamuutujad

<details>
<summary>Klõpsake, et näha platvormispetsiifilisi käske</summary>

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

## Rakenduse käivitamine

### Maveni kasutamine

```bash
mvn spring-boot:run
```

### VS Code'i kasutamine

1. Avage projekt VS Code'is
2. Vajutage `F5` või kasutage "Run and Debug" paneeli
3. Valige "Spring Boot-BasicChatApplication" konfiguratsioon

> **Märkus**: VS Code'i konfiguratsioon laadib automaatselt teie .env faili

### Oodatav väljund

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

## Konfiguratsiooni viide

### Keskkonnamuutujad

| Muutuja | Kirjeldus | Kohustuslik | Näide |
|---------|-----------|-------------|-------|
| `AZURE_AI_KEY` | Azure OpenAI API võti | Jah | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI lõpp-punkti URL | Jah | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Mudeli juurutamise nimi | Ei | `gpt-4o-mini` (vaikimisi) |

### Spring konfiguratsioon

`application.yml` fail konfigureerib:
- **API võti**: `${AZURE_AI_KEY}` - Keskkonnamuutujast
- **Lõpp-punkt**: `${AZURE_AI_ENDPOINT}` - Keskkonnamuutujast  
- **Mudel**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Keskkonnamuutujast koos varuvalikuga
- **Temperatuur**: `0.7` - Loovuse kontroll (0.0 = deterministlik, 1.0 = loov)
- **Maksimaalne tokenite arv**: `500` - Maksimaalne vastuse pikkus

## Tõrkeotsing

### Levinud probleemid

<details>
<summary><strong>Viga: "API võti ei ole kehtiv"</strong></summary>

- Kontrollige, et teie `AZURE_AI_KEY` oleks õigesti seadistatud teie `.env` failis
- Veenduge, et API võti oleks täpselt kopeeritud Azure AI Foundry portaalist
- Kontrollige, et võtme ümber ei oleks lisaruume ega jutumärke
</details>

<details>
<summary><strong>Viga: "Lõpp-punkt ei ole kehtiv"</strong></summary>

- Veenduge, et teie `AZURE_AI_ENDPOINT` sisaldaks täielikku URL-i (nt `https://your-hub-name.openai.azure.com/`)
- Kontrollige, et lõpus ei oleks üleliigset kaldkriipsu
- Veenduge, et lõpp-punkt vastaks teie Azure juurutamise piirkonnale
</details>

<details>
<summary><strong>Viga: "Juurutamist ei leitud"</strong></summary>

- Kontrollige, et teie mudeli juurutamise nimi vastaks täpselt Azure'is juurutatule
- Veenduge, et mudel oleks edukalt juurutatud ja aktiivne
- Proovige kasutada vaikimisi juurutamise nime: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: Keskkonnamuutujad ei laadi</strong></summary>

- Veenduge, et teie `.env` fail oleks projekti juurkataloogis (samal tasemel kui `pom.xml`)
- Proovige käivitada `mvn spring-boot:run` VS Code'i integreeritud terminalis
- Kontrollige, et VS Code'i Java laiendus oleks korralikult installitud
- Veenduge, et käivitamise konfiguratsioonis oleks `"envFile": "${workspaceFolder}/.env"`
</details>

### Debug-režiim

Üksikasjaliku logimise lubamiseks kommenteerige lahti need read `application.yml` failis:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Järgmised sammud

**Seadistus on valmis!** Jätkake oma õppe teekonda:

[3. peatükk: Generatiivse tehisintellekti põhitehnikad](../../../03-CoreGenerativeAITechniques/README.md)

## Ressursid

- [Spring AI Azure OpenAI dokumentatsioon](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Azure OpenAI teenuse dokumentatsioon](https://learn.microsoft.com/azure/ai-services/openai/)
- [Azure AI Foundry portaal](https://ai.azure.com/)
- [Azure AI Foundry dokumentatsioon](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

---

**Lahtiütlus**:  
See dokument on tõlgitud AI tõlketeenuse [Co-op Translator](https://github.com/Azure/co-op-translator) abil. Kuigi püüame tagada täpsust, palume arvestada, et automaatsed tõlked võivad sisaldada vigu või ebatäpsusi. Algne dokument selle algses keeles tuleks pidada autoriteetseks allikaks. Olulise teabe puhul soovitame kasutada professionaalset inimtõlget. Me ei vastuta selle tõlke kasutamisest tulenevate arusaamatuste või valesti tõlgenduste eest.