# Základní chat s Azure OpenAI - Kompletní příklad

Tento příklad ukazuje, jak vytvořit jednoduchou aplikaci Spring Boot, která se připojuje k Azure OpenAI a testuje vaše nastavení.

## Obsah

- [Předpoklady](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Rychlý start](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Možnosti konfigurace](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Možnost 1: Proměnné prostředí (soubor .env) - Doporučeno](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Možnost 2: Tajemství GitHub Codespace](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Spuštění aplikace](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Použití Maven](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Použití VS Code](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Očekávaný výstup](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Referenční konfigurace](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Proměnné prostředí](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Konfigurace Spring](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Řešení problémů](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Běžné problémy](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Režim ladění](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Další kroky](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Zdroje](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## Předpoklady

Před spuštěním tohoto příkladu se ujistěte, že máte:

- Dokončený [průvodce nastavením Azure OpenAI](../../getting-started-azure-openai.md)  
- Nasazený prostředek Azure OpenAI (přes portál Azure AI Foundry)  
- Nasazený model gpt-4o-mini (nebo alternativní)  
- API klíč a URL koncového bodu z Azure  

## Rychlý start

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Možnosti konfigurace

### Možnost 1: Proměnné prostředí (soubor .env) - Doporučeno

**Krok 1: Vytvořte konfigurační soubor**
```bash
cp .env.example .env
```

**Krok 2: Přidejte své přihlašovací údaje Azure OpenAI**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Bezpečnostní poznámka**: 
> - Nikdy neukládejte soubor `.env` do verzovacího systému
> - Soubor `.env` je již uveden v `.gitignore`
> - Udržujte své API klíče v bezpečí a pravidelně je měňte

### Možnost 2: Tajemství GitHub Codespace

Pro GitHub Codespaces nastavte tato tajemství ve svém repozitáři:
- `AZURE_AI_KEY` - Váš API klíč Azure OpenAI
- `AZURE_AI_ENDPOINT` - URL koncového bodu Azure OpenAI

Aplikace automaticky detekuje a používá tato tajemství.

### Alternativa: Přímé proměnné prostředí

<details>
<summary>Klikněte pro zobrazení příkazů specifických pro platformu</summary>

**Linux/macOS (bash/zsh):**
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (Příkazový řádek):**
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

## Spuštění aplikace

### Použití Maven

```bash
mvn spring-boot:run
```

### Použití VS Code

1. Otevřete projekt ve VS Code
2. Stiskněte `F5` nebo použijte panel "Run and Debug"
3. Vyberte konfiguraci "Spring Boot-BasicChatApplication"

> **Poznámka**: Konfigurace VS Code automaticky načítá váš soubor .env

### Očekávaný výstup

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

## Referenční konfigurace

### Proměnné prostředí

| Proměnná | Popis | Povinné | Příklad |
|----------|-------|---------|---------|
| `AZURE_AI_KEY` | API klíč Azure OpenAI | Ano | `abc123...` |
| `AZURE_AI_ENDPOINT` | URL koncového bodu Azure OpenAI | Ano | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Název nasazení modelu | Ne | `gpt-4o-mini` (výchozí) |

### Konfigurace Spring

Soubor `application.yml` konfiguruje:
- **API klíč**: `${AZURE_AI_KEY}` - Z proměnné prostředí
- **Koncový bod**: `${AZURE_AI_ENDPOINT}` - Z proměnné prostředí  
- **Model**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Z proměnné prostředí s výchozí hodnotou
- **Teplota**: `0.7` - Ovládá kreativitu (0.0 = deterministické, 1.0 = kreativní)
- **Maximální počet tokenů**: `500` - Maximální délka odpovědi

## Řešení problémů

### Běžné problémy

<details>
<summary><strong>Chyba: "API klíč není platný"</strong></summary>

- Zkontrolujte, zda je váš `AZURE_AI_KEY` správně nastaven v souboru `.env`
- Ověřte, že API klíč je přesně zkopírován z portálu Azure AI Foundry
- Ujistěte se, že kolem klíče nejsou žádné mezery nebo uvozovky
</details>

<details>
<summary><strong>Chyba: "Koncový bod není platný"</strong></summary>

- Ujistěte se, že váš `AZURE_AI_ENDPOINT` obsahuje celou URL (např. `https://your-hub-name.openai.azure.com/`)
- Zkontrolujte konzistenci s lomítkem na konci
- Ověřte, že koncový bod odpovídá vaší oblasti nasazení Azure
</details>

<details>
<summary><strong>Chyba: "Nasazení nebylo nalezeno"</strong></summary>

- Ověřte, že název nasazení modelu přesně odpovídá tomu, co je nasazeno v Azure
- Zkontrolujte, zda je model úspěšně nasazen a aktivní
- Zkuste použít výchozí název nasazení: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: Proměnné prostředí se nenačítají</strong></summary>

- Ujistěte se, že váš soubor `.env` je v kořenovém adresáři projektu (na stejné úrovni jako `pom.xml`)
- Zkuste spustit `mvn spring-boot:run` v integrovaném terminálu VS Code
- Zkontrolujte, zda je správně nainstalován rozšíření Java pro VS Code
- Ověřte, že konfigurace spuštění obsahuje `"envFile": "${workspaceFolder}/.env"`
</details>

### Režim ladění

Pro povolení podrobného logování odkomentujte tyto řádky v `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Další kroky

**Nastavení dokončeno!** Pokračujte ve svém vzdělávání:

[Kap. 3: Základní techniky generativní AI](../../../03-CoreGenerativeAITechniques/README.md)

## Zdroje

- [Dokumentace Spring AI Azure OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Dokumentace služby Azure OpenAI](https://learn.microsoft.com/azure/ai-services/openai/)
- [Portál Azure AI Foundry](https://ai.azure.com/)
- [Dokumentace Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**Upozornění**:  
Tento dokument byl přeložen pomocí služby pro automatický překlad [Co-op Translator](https://github.com/Azure/co-op-translator). I když se snažíme o přesnost, mějte prosím na paměti, že automatické překlady mohou obsahovat chyby nebo nepřesnosti. Původní dokument v jeho původním jazyce by měl být považován za závazný zdroj. Pro důležité informace se doporučuje profesionální lidský překlad. Nezodpovídáme za žádná nedorozumění nebo nesprávné interpretace vyplývající z použití tohoto překladu.