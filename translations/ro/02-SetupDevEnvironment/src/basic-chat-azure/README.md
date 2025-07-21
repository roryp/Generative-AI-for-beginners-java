<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2289320a74aeca1eb844cd7d3a7a9e12",
  "translation_date": "2025-07-21T21:09:55+00:00",
  "source_file": "02-SetupDevEnvironment/src/basic-chat-azure/README.md",
  "language_code": "ro"
}
-->
# Chat de Bază cu Azure OpenAI - Exemplu End-to-End

Acest exemplu demonstrează cum să creezi o aplicație simplă Spring Boot care se conectează la Azure OpenAI și testează configurația ta.

## Cuprins

- [Cerințe preliminare](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Start Rapid](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Opțiuni de Configurare](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Opțiunea 1: Variabile de Mediu (fișier .env) - Recomandat](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Opțiunea 2: Secrete GitHub Codespace](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Rularea Aplicației](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Folosind Maven](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Folosind VS Code](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Rezultatul Așteptat](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Referință de Configurare](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Variabile de Mediu](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Configurație Spring](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Depanare](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Probleme Comune](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Modul Debug](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Pași Următori](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Resurse](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)

## Cerințe Preliminare

Înainte de a rula acest exemplu, asigură-te că ai:

- Finalizat [ghidul de configurare Azure OpenAI](../../getting-started-azure-openai.md)  
- Implementat resursa Azure OpenAI (prin portalul Azure AI Foundry)  
- Implementat modelul gpt-4o-mini (sau o alternativă)  
- Cheia API și URL-ul endpoint-ului de la Azure  

## Start Rapid

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/src/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Opțiuni de Configurare

### Opțiunea 1: Variabile de Mediu (fișier .env) - Recomandat

**Pasul 1: Creează fișierul de configurare**
```bash
cp .env.example .env
```

**Pasul 2: Adaugă acreditivele Azure OpenAI**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Notă de Securitate**: 
> - Nu comite niciodată fișierul `.env` în controlul versiunilor
> - Fișierul `.env` este deja inclus în `.gitignore`
> - Păstrează cheile API în siguranță și rotește-le periodic

### Opțiunea 2: Secrete GitHub Codespace

Pentru GitHub Codespaces, setează aceste secrete în depozitul tău:
- `AZURE_AI_KEY` - Cheia API Azure OpenAI
- `AZURE_AI_ENDPOINT` - URL-ul endpoint-ului Azure OpenAI

Aplicația detectează și folosește automat aceste secrete.

### Alternativă: Variabile de Mediu Directe

<details>
<summary>Click pentru a vedea comenzile specifice platformei</summary>

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

## Rularea Aplicației

### Folosind Maven

```bash
mvn spring-boot:run
```

### Folosind VS Code

1. Deschide proiectul în VS Code
2. Apasă `F5` sau folosește panoul "Run and Debug"
3. Selectează configurația "Spring Boot-BasicChatApplication"

> **Notă**: Configurația VS Code încarcă automat fișierul .env

### Rezultatul Așteptat

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

## Referință de Configurare

### Variabile de Mediu

| Variabilă | Descriere | Obligatoriu | Exemplu |
|-----------|-----------|-------------|---------|
| `AZURE_AI_KEY` | Cheia API Azure OpenAI | Da | `abc123...` |
| `AZURE_AI_ENDPOINT` | URL-ul endpoint-ului Azure OpenAI | Da | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Numele implementării modelului | Nu | `gpt-4o-mini` (implicit) |

### Configurație Spring

Fișierul `application.yml` configurează:
- **Cheia API**: `${AZURE_AI_KEY}` - Din variabila de mediu
- **Endpoint-ul**: `${AZURE_AI_ENDPOINT}` - Din variabila de mediu  
- **Modelul**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Din variabila de mediu cu valoare implicită
- **Temperatura**: `0.7` - Controlează creativitatea (0.0 = determinist, 1.0 = creativ)
- **Max Tokens**: `500` - Lungimea maximă a răspunsului

## Depanare

### Probleme Comune

<details>
<summary><strong>Eroare: "Cheia API nu este validă"</strong></summary>

- Verifică dacă `AZURE_AI_KEY` este setată corect în fișierul `.env`
- Asigură-te că cheia API este copiată exact din portalul Azure AI Foundry
- Verifică să nu existe spații suplimentare sau ghilimele în jurul cheii
</details>

<details>
<summary><strong>Eroare: "Endpoint-ul nu este valid"</strong></summary>

- Asigură-te că `AZURE_AI_ENDPOINT` include URL-ul complet (ex.: `https://your-hub-name.openai.azure.com/`)
- Verifică consistența slash-ului final
- Confirmă că endpoint-ul corespunde regiunii implementării tale Azure
</details>

<details>
<summary><strong>Eroare: "Implementarea nu a fost găsită"</strong></summary>

- Verifică dacă numele implementării modelului corespunde exact cu cel implementat în Azure
- Asigură-te că modelul este implementat cu succes și activ
- Încearcă să folosești numele implicit al implementării: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: Variabilele de mediu nu se încarcă</strong></summary>

- Asigură-te că fișierul `.env` este în directorul rădăcină al proiectului (același nivel cu `pom.xml`)
- Încearcă să rulezi `mvn spring-boot:run` în terminalul integrat al VS Code
- Verifică dacă extensia Java pentru VS Code este instalată corect
- Confirmă că configurația de lansare conține `"envFile": "${workspaceFolder}/.env"`
</details>

### Modul Debug

Pentru a activa logarea detaliată, decomentează aceste linii în `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Pași Următori

**Configurarea este completă!** Continuă călătoria ta de învățare:

[Capitolul 3: Tehnici Generative AI de Bază](../../../03-CoreGenerativeAITechniques/README.md)

## Resurse

- [Documentația Spring AI Azure OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Documentația Serviciului Azure OpenAI](https://learn.microsoft.com/azure/ai-services/openai/)
- [Portalul Azure AI Foundry](https://ai.azure.com/)
- [Documentația Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**Declinare de responsabilitate**:  
Acest document a fost tradus folosind serviciul de traducere AI [Co-op Translator](https://github.com/Azure/co-op-translator). Deși ne străduim să asigurăm acuratețea, vă rugăm să fiți conștienți că traducerile automate pot conține erori sau inexactități. Documentul original în limba sa natală ar trebui considerat sursa autoritară. Pentru informații critice, se recomandă traducerea profesională realizată de un specialist uman. Nu ne asumăm responsabilitatea pentru eventualele neînțelegeri sau interpretări greșite care pot apărea din utilizarea acestei traduceri.