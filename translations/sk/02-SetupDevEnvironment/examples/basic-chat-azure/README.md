<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "efd82efe50711d7e257eb943151d682c",
  "translation_date": "2025-07-27T13:46:40+00:00",
  "source_file": "02-SetupDevEnvironment/examples/basic-chat-azure/README.md",
  "language_code": "sk"
}
-->
# Základný Chat s Azure OpenAI - Kompletný Príklad

Tento príklad ukazuje, ako vytvoriť jednoduchú aplikáciu Spring Boot, ktorá sa pripojí k Azure OpenAI a otestuje vaše nastavenie.

## Obsah

- [Predpoklady](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Rýchly Štart](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Možnosti Konfigurácie](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Možnosť 1: Premenné Prostredia (.env súbor) - Odporúčané](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Možnosť 2: GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Spustenie Aplikácie](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Použitie Maven](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Použitie VS Code](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Očakávaný Výstup](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Referenčná Konfigurácia](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Premenné Prostredia](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Spring Konfigurácia](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Riešenie Problémov](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Bežné Problémy](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Režim Debugovania](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Ďalšie Kroky](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Zdroje](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## Predpoklady

Pred spustením tohto príkladu sa uistite, že máte:

- Dokončený [návod na nastavenie Azure OpenAI](../../getting-started-azure-openai.md)  
- Nasadený Azure OpenAI zdroj (cez portál Azure AI Foundry)  
- Nasadený model gpt-4o-mini (alebo alternatíva)  
- API kľúč a URL koncového bodu z Azure  

## Rýchly Štart

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Možnosti Konfigurácie

### Možnosť 1: Premenné Prostredia (.env súbor) - Odporúčané

**Krok 1: Vytvorte konfiguračný súbor**
```bash
cp .env.example .env
```

**Krok 2: Pridajte svoje Azure OpenAI prihlasovacie údaje**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Bezpečnostná Poznámka**: 
> - Nikdy neukladajte `.env` súbor do verzovacieho systému
> - `.env` súbor je už zahrnutý v `.gitignore`
> - Udržujte svoje API kľúče v bezpečí a pravidelne ich obnovujte

### Možnosť 2: GitHub Codespace Secrets

Pre GitHub Codespaces nastavte tieto tajné údaje vo vašom repozitári:
- `AZURE_AI_KEY` - Váš Azure OpenAI API kľúč
- `AZURE_AI_ENDPOINT` - URL koncového bodu Azure OpenAI

Aplikácia automaticky detekuje a používa tieto tajné údaje.

### Alternatíva: Priame Premenné Prostredia

<details>
<summary>Kliknite pre zobrazenie príkazov špecifických pre platformu</summary>

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

## Spustenie Aplikácie

### Použitie Maven

```bash
mvn spring-boot:run
```

### Použitie VS Code

1. Otvorte projekt vo VS Code
2. Stlačte `F5` alebo použite panel "Run and Debug"
3. Vyberte konfiguráciu "Spring Boot-BasicChatApplication"

> **Poznámka**: Konfigurácia VS Code automaticky načíta váš .env súbor

### Očakávaný Výstup

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

## Referenčná Konfigurácia

### Premenné Prostredia

| Premenná | Popis | Povinné | Príklad |
|----------|-------|---------|---------|
| `AZURE_AI_KEY` | Azure OpenAI API kľúč | Áno | `abc123...` |
| `AZURE_AI_ENDPOINT` | URL koncového bodu Azure OpenAI | Áno | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Názov nasadenia modelu | Nie | `gpt-4o-mini` (predvolené) |

### Spring Konfigurácia

Súbor `application.yml` konfiguruje:
- **API kľúč**: `${AZURE_AI_KEY}` - Z premennej prostredia
- **Koncový bod**: `${AZURE_AI_ENDPOINT}` - Z premennej prostredia  
- **Model**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Z premennej prostredia s predvolenou hodnotou
- **Teplota**: `0.7` - Riadi kreativitu (0.0 = deterministické, 1.0 = kreatívne)
- **Maximálny Počet Tokenov**: `500` - Maximálna dĺžka odpovede

## Riešenie Problémov

### Bežné Problémy

<details>
<summary><strong>Chyba: "API kľúč nie je platný"</strong></summary>

- Skontrolujte, či je váš `AZURE_AI_KEY` správne nastavený v `.env` súbore
- Overte, že API kľúč je presne skopírovaný z portálu Azure AI Foundry
- Uistite sa, že okolo kľúča nie sú žiadne extra medzery alebo úvodzovky
</details>

<details>
<summary><strong>Chyba: "Koncový bod nie je platný"</strong></summary>

- Uistite sa, že váš `AZURE_AI_ENDPOINT` obsahuje úplnú URL (napr. `https://your-hub-name.openai.azure.com/`)
- Skontrolujte konzistenciu s koncovým lomítkom
- Overte, že koncový bod zodpovedá vášmu regiónu nasadenia Azure
</details>

<details>
<summary><strong>Chyba: "Nasadenie nebolo nájdené"</strong></summary>

- Overte, že názov nasadenia modelu presne zodpovedá tomu, čo je nasadené v Azure
- Skontrolujte, či je model úspešne nasadený a aktívny
- Skúste použiť predvolený názov nasadenia: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: Premenné prostredia sa nenačítavajú</strong></summary>

- Uistite sa, že váš `.env` súbor je v koreňovom adresári projektu (na rovnakej úrovni ako `pom.xml`)
- Skúste spustiť `mvn spring-boot:run` v integrovanom termináli VS Code
- Skontrolujte, či je rozšírenie Java pre VS Code správne nainštalované
- Overte, že konfigurácia spustenia obsahuje `"envFile": "${workspaceFolder}/.env"`
</details>

### Režim Debugovania

Na povolenie podrobného logovania odkomentujte tieto riadky v `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Ďalšie Kroky

**Nastavenie dokončené!** Pokračujte vo vašom vzdelávaní:

[Kap. 3: Základné Techniky Generatívnej AI](../../../03-CoreGenerativeAITechniques/README.md)

## Zdroje

- [Spring AI Azure OpenAI Dokumentácia](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Azure OpenAI Service Dokumentácia](https://learn.microsoft.com/azure/ai-services/openai/)
- [Portál Azure AI Foundry](https://ai.azure.com/)
- [Azure AI Foundry Dokumentácia](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**Upozornenie**:  
Tento dokument bol preložený pomocou služby na automatický preklad [Co-op Translator](https://github.com/Azure/co-op-translator). Hoci sa snažíme o presnosť, upozorňujeme, že automatické preklady môžu obsahovať chyby alebo nepresnosti. Pôvodný dokument v jeho pôvodnom jazyku by mal byť považovaný za autoritatívny zdroj. Pre kritické informácie sa odporúča profesionálny ľudský preklad. Nenesieme zodpovednosť za akékoľvek nedorozumenia alebo nesprávne interpretácie vyplývajúce z použitia tohto prekladu.