# Osnovni Chat s Azure OpenAI - Primjer od početka do kraja

Ovaj primjer pokazuje kako napraviti jednostavnu Spring Boot aplikaciju koja se povezuje s Azure OpenAI i testira vašu konfiguraciju.

## Sadržaj

- [Preduvjeti](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Brzi početak](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Opcije konfiguracije](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Opcija 1: Varijable okruženja (.env datoteka) - Preporučeno](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Opcija 2: GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Pokretanje aplikacije](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Korištenje Mavena](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Korištenje VS Code-a](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Očekivani izlaz](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Referenca konfiguracije](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Varijable okruženja](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Spring konfiguracija](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Rješavanje problema](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Uobičajeni problemi](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Način rada za otklanjanje grešaka](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Sljedeći koraci](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Resursi](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## Preduvjeti

Prije pokretanja ovog primjera, osigurajte da imate:

- Dovršen [Azure OpenAI vodič za postavljanje](../../getting-started-azure-openai.md)  
- Implementiran Azure OpenAI resurs (putem Azure AI Foundry portala)  
- Implementiran gpt-4o-mini model (ili alternativni)  
- API ključ i URL krajnje točke iz Azure  

## Brzi početak

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Opcije konfiguracije

### Opcija 1: Varijable okruženja (.env datoteka) - Preporučeno

**Korak 1: Kreirajte svoju konfiguracijsku datoteku**
```bash
cp .env.example .env
```

**Korak 2: Dodajte svoje Azure OpenAI vjerodajnice**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Sigurnosna napomena**: 
> - Nikada ne dodajte `.env` datoteku u verzioniranje koda
> - `.env` datoteka je već uključena u `.gitignore`
> - Čuvajte svoje API ključeve sigurnima i redovito ih rotirajte

### Opcija 2: GitHub Codespace Secrets

Za GitHub Codespaces, postavite ove tajne u svom repozitoriju:
- `AZURE_AI_KEY` - Vaš Azure OpenAI API ključ
- `AZURE_AI_ENDPOINT` - Vaš Azure OpenAI URL krajnje točke

Aplikacija automatski prepoznaje i koristi ove tajne.

### Alternativa: Direktne varijable okruženja

<details>
<summary>Kliknite za prikaz platformskih naredbi</summary>

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

## Pokretanje aplikacije

### Korištenje Mavena

```bash
mvn spring-boot:run
```

### Korištenje VS Code-a

1. Otvorite projekt u VS Code-u
2. Pritisnite `F5` ili koristite panel "Run and Debug"
3. Odaberite konfiguraciju "Spring Boot-BasicChatApplication"

> **Napomena**: VS Code konfiguracija automatski učitava vašu .env datoteku

### Očekivani izlaz

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

## Referenca konfiguracije

### Varijable okruženja

| Varijabla | Opis | Obavezno | Primjer |
|-----------|------|----------|---------|
| `AZURE_AI_KEY` | Azure OpenAI API ključ | Da | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI URL krajnje točke | Da | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Naziv implementacije modela | Ne | `gpt-4o-mini` (zadano) |

### Spring konfiguracija

Datoteka `application.yml` konfigurira:
- **API ključ**: `${AZURE_AI_KEY}` - Iz varijable okruženja
- **Krajnja točka**: `${AZURE_AI_ENDPOINT}` - Iz varijable okruženja  
- **Model**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Iz varijable okruženja s rezervnim vrijednostima
- **Temperatura**: `0.7` - Kontrolira kreativnost (0.0 = deterministički, 1.0 = kreativno)
- **Maksimalni broj tokena**: `500` - Maksimalna duljina odgovora

## Rješavanje problema

### Uobičajeni problemi

<details>
<summary><strong>Greška: "API ključ nije valjan"</strong></summary>

- Provjerite je li vaš `AZURE_AI_KEY` ispravno postavljen u vašoj `.env` datoteci
- Provjerite je li API ključ točno kopiran iz Azure AI Foundry portala
- Osigurajte da nema dodatnih razmaka ili navodnika oko ključa
</details>

<details>
<summary><strong>Greška: "Krajnja točka nije valjana"</strong></summary>

- Osigurajte da vaš `AZURE_AI_ENDPOINT` uključuje puni URL (npr. `https://your-hub-name.openai.azure.com/`)
- Provjerite dosljednost završne kose crte
- Provjerite odgovara li krajnja točka vašoj Azure regiji implementacije
</details>

<details>
<summary><strong>Greška: "Implementacija nije pronađena"</strong></summary>

- Provjerite odgovara li naziv implementacije modela točno onome što je implementirano u Azure
- Provjerite je li model uspješno implementiran i aktivan
- Pokušajte koristiti zadani naziv implementacije: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: Varijable okruženja se ne učitavaju</strong></summary>

- Osigurajte da je vaša `.env` datoteka u korijenskom direktoriju projekta (na istoj razini kao `pom.xml`)
- Pokušajte pokrenuti `mvn spring-boot:run` u integriranom terminalu VS Code-a
- Provjerite je li VS Code Java ekstenzija ispravno instalirana
- Provjerite ima li konfiguracija pokretanja `"envFile": "${workspaceFolder}/.env"`
</details>

### Način rada za otklanjanje grešaka

Za omogućavanje detaljnog zapisivanja, poništite komentare ovih linija u `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Sljedeći koraci

**Postavljanje dovršeno!** Nastavite svoje učenje:

[3. poglavlje: Osnovne tehnike generativne umjetne inteligencije](../../../03-CoreGenerativeAITechniques/README.md)

## Resursi

- [Spring AI Azure OpenAI Dokumentacija](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Azure OpenAI Servis Dokumentacija](https://learn.microsoft.com/azure/ai-services/openai/)
- [Azure AI Foundry Portal](https://ai.azure.com/)
- [Azure AI Foundry Dokumentacija](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**Odricanje od odgovornosti**:  
Ovaj dokument je preveden pomoću AI usluge za prevođenje [Co-op Translator](https://github.com/Azure/co-op-translator). Iako nastojimo osigurati točnost, imajte na umu da automatski prijevodi mogu sadržavati pogreške ili netočnosti. Izvorni dokument na izvornom jeziku treba smatrati autoritativnim izvorom. Za kritične informacije preporučuje se profesionalni prijevod od strane čovjeka. Ne preuzimamo odgovornost za nesporazume ili pogrešna tumačenja koja mogu proizaći iz korištenja ovog prijevoda.