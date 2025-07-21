<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2289320a74aeca1eb844cd7d3a7a9e12",
  "translation_date": "2025-07-21T21:09:29+00:00",
  "source_file": "02-SetupDevEnvironment/src/basic-chat-azure/README.md",
  "language_code": "sk"
}
-->
# Základný chat s Azure OpenAI - Kompletný príklad

Tento príklad ukazuje, ako vytvoriť jednoduchú Spring Boot aplikáciu, ktorá sa pripája k Azure OpenAI a testuje vaše nastavenie.

## Obsah

- [Predpoklady](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Rýchly štart](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Možnosti konfigurácie](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Možnosť 1: Premenné prostredia (.env súbor) - Odporúčané](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Možnosť 2: GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Spustenie aplikácie](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Použitie Maven](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Použitie VS Code](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Očakávaný výstup](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Referenčná konfigurácia](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Premenné prostredia](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Spring konfigurácia](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Riešenie problémov](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Bežné problémy](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Režim ladenia](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Ďalšie kroky](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Zdroje](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)

## Predpoklady

Pred spustením tohto príkladu sa uistite, že máte:

- Dokončený [sprievodca nastavením Azure OpenAI](../../getting-started-azure-openai.md)  
- Nasadený Azure OpenAI zdroj (cez portál Azure AI Foundry)  
- Nasadený model gpt-4o-mini (alebo alternatíva)  
- API kľúč a URL koncového bodu z Azure  

## Rýchly štart

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/src/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Možnosti konfigurácie

### Možnosť 1: Premenné prostredia (.env súbor) - Odporúčané

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

> **Bezpečnostná poznámka**: 
> - Nikdy neukladajte `.env` súbor do verzionovacieho systému
> - `.env` súbor je už zahrnutý v `.gitignore`
> - Udržujte svoje API kľúče v bezpečí a pravidelne ich rotujte

### Možnosť 2: GitHub Codespace Secrets

Pre GitHub Codespaces nastavte tieto tajomstvá vo vašom repozitári:
- `AZURE_AI_KEY` - Váš Azure OpenAI API kľúč
- `AZURE_AI_ENDPOINT` - URL koncového bodu Azure OpenAI

Aplikácia automaticky detekuje a používa tieto tajomstvá.

### Alternatíva: Priame premenné prostredia

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

## Spustenie aplikácie

### Použitie Maven

```bash
mvn spring-boot:run
```

### Použitie VS Code

1. Otvorte projekt vo VS Code
2. Stlačte `F5` alebo použite panel "Run and Debug"
3. Vyberte konfiguráciu "Spring Boot-BasicChatApplication"

> **Poznámka**: Konfigurácia VS Code automaticky načíta váš `.env` súbor

### Očakávaný výstup

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

## Referenčná konfigurácia

### Premenné prostredia

| Premenná | Popis | Povinné | Príklad |
|----------|-------|---------|---------|
| `AZURE_AI_KEY` | Azure OpenAI API kľúč | Áno | `abc123...` |
| `AZURE_AI_ENDPOINT` | URL koncového bodu Azure OpenAI | Áno | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Názov nasadenia modelu | Nie | `gpt-4o-mini` (predvolené) |

### Spring konfigurácia

Súbor `application.yml` konfiguruje:
- **API kľúč**: `${AZURE_AI_KEY}` - Z premennej prostredia
- **Koncový bod**: `${AZURE_AI_ENDPOINT}` - Z premennej prostredia  
- **Model**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Z premennej prostredia s predvolenou hodnotou
- **Teplota**: `0.7` - Riadi kreativitu (0.0 = deterministické, 1.0 = kreatívne)
- **Maximálny počet tokenov**: `500` - Maximálna dĺžka odpovede

## Riešenie problémov

### Bežné problémy

<details>
<summary><strong>Chyba: "API kľúč nie je platný"</strong></summary>

- Skontrolujte, či je váš `AZURE_AI_KEY` správne nastavený v `.env` súbore
- Overte, že API kľúč je presne skopírovaný z portálu Azure AI Foundry
- Uistite sa, že okolo kľúča nie sú žiadne extra medzery alebo úvodzovky
</details>

<details>
<summary><strong>Chyba: "Koncový bod nie je platný"</strong></summary>

- Uistite sa, že váš `AZURE_AI_ENDPOINT` obsahuje celú URL (napr. `https://your-hub-name.openai.azure.com/`)
- Skontrolujte konzistenciu so záverečnou lomkou
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
- Skontrolujte, či je správne nainštalované rozšírenie Java pre VS Code
- Overte, že konfigurácia spustenia obsahuje `"envFile": "${workspaceFolder}/.env"`
</details>

### Režim ladenia

Pre povolenie podrobného logovania odkomentujte tieto riadky v `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Ďalšie kroky

**Nastavenie dokončené!** Pokračujte vo vašom vzdelávaní:

[Kap. 3: Základné techniky generatívnej AI](../../../03-CoreGenerativeAITechniques/README.md)

## Zdroje

- [Spring AI Azure OpenAI Dokumentácia](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Dokumentácia Azure OpenAI Service](https://learn.microsoft.com/azure/ai-services/openai/)
- [Portál Azure AI Foundry](https://ai.azure.com/)
- [Dokumentácia Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**Zrieknutie sa zodpovednosti**:  
Tento dokument bol preložený pomocou služby AI prekladu [Co-op Translator](https://github.com/Azure/co-op-translator). Aj keď sa snažíme o presnosť, prosím, berte na vedomie, že automatizované preklady môžu obsahovať chyby alebo nepresnosti. Pôvodný dokument v jeho rodnom jazyku by mal byť považovaný za autoritatívny zdroj. Pre kritické informácie sa odporúča profesionálny ľudský preklad. Nenesieme zodpovednosť za akékoľvek nedorozumenia alebo nesprávne interpretácie vyplývajúce z použitia tohto prekladu.