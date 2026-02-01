# Osnovni klepet z Azure OpenAI - Primer od začetka do konca

Ta primer prikazuje, kako ustvariti preprosto Spring Boot aplikacijo, ki se poveže z Azure OpenAI in preveri vašo nastavitev.

## Kazalo vsebine

- [Predpogoji](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Hiter začetek](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Možnosti konfiguracije](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Možnost 1: Spremenljivke okolja (.env datoteka) - Priporočeno](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Možnost 2: GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Zagon aplikacije](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Uporaba Mavena](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Uporaba VS Code](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Pričakovani izhod](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Referenca konfiguracije](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Spremenljivke okolja](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Spring konfiguracija](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Odpravljanje težav](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Pogoste težave](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Način za odpravljanje napak](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Naslednji koraki](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Viri](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## Predpogoji

Preden zaženete ta primer, poskrbite, da imate:

- Zaključen [vodnik za nastavitev Azure OpenAI](../../getting-started-azure-openai.md)  
- Ustvarjen Azure OpenAI vir (prek portala Azure AI Foundry)  
- Uveden model gpt-4o-mini (ali alternativni model)  
- API ključ in URL končne točke iz Azure  

## Hiter začetek

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Možnosti konfiguracije

### Možnost 1: Spremenljivke okolja (.env datoteka) - Priporočeno

**Korak 1: Ustvarite svojo konfiguracijsko datoteko**
```bash
cp .env.example .env
```

**Korak 2: Dodajte svoje Azure OpenAI poverilnice**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Varnostna opomba**: 
> - Nikoli ne vključite svoje `.env` datoteke v sistem za nadzor različic
> - `.env` datoteka je že vključena v `.gitignore`
> - Svoje API ključe hranite varno in jih redno rotirajte

### Možnost 2: GitHub Codespace Secrets

Za GitHub Codespaces nastavite te skrivnosti v svojem repozitoriju:
- `AZURE_AI_KEY` - Vaš Azure OpenAI API ključ
- `AZURE_AI_ENDPOINT` - Vaš Azure OpenAI URL končne točke

Aplikacija samodejno zazna in uporabi te skrivnosti.

### Alternativa: Neposredne spremenljivke okolja

<details>
<summary>Kliknite za prikaz ukazov, specifičnih za platformo</summary>

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

## Zagon aplikacije

### Uporaba Mavena

```bash
mvn spring-boot:run
```

### Uporaba VS Code

1. Odprite projekt v VS Code
2. Pritisnite `F5` ali uporabite ploščo "Run and Debug"
3. Izberite konfiguracijo "Spring Boot-BasicChatApplication"

> **Opomba**: Konfiguracija v VS Code samodejno naloži vašo `.env` datoteko

### Pričakovani izhod

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

### Spremenljivke okolja

| Spremenljivka | Opis | Zahtevano | Primer |
|---------------|-------|-----------|--------|
| `AZURE_AI_KEY` | Azure OpenAI API ključ | Da | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI URL končne točke | Da | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Ime uvedbe modela | Ne | `gpt-4o-mini` (privzeto) |

### Spring konfiguracija

Datoteka `application.yml` konfigurira:
- **API ključ**: `${AZURE_AI_KEY}` - Iz spremenljivke okolja
- **Končna točka**: `${AZURE_AI_ENDPOINT}` - Iz spremenljivke okolja  
- **Model**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Iz spremenljivke okolja z rezervno vrednostjo
- **Temperatura**: `0.7` - Nadzoruje ustvarjalnost (0.0 = deterministično, 1.0 = ustvarjalno)
- **Največje število tokenov**: `500` - Največja dolžina odgovora

## Odpravljanje težav

### Pogoste težave

<details>
<summary><strong>Napaka: "API ključ ni veljaven"</strong></summary>

- Preverite, ali je vaš `AZURE_AI_KEY` pravilno nastavljen v vaši `.env` datoteki
- Prepričajte se, da je API ključ natančno kopiran iz portala Azure AI Foundry
- Preverite, da ni dodatnih presledkov ali narekovajev okoli ključa
</details>

<details>
<summary><strong>Napaka: "Končna točka ni veljavna"</strong></summary>

- Prepričajte se, da vaš `AZURE_AI_ENDPOINT` vključuje celoten URL (npr. `https://your-hub-name.openai.azure.com/`)
- Preverite skladnost z zaključnimi poševnicami
- Preverite, ali se končna točka ujema z vašo regijo uvedbe Azure
</details>

<details>
<summary><strong>Napaka: "Uvedba ni bila najdena"</strong></summary>

- Preverite, ali se ime uvedbe modela natančno ujema z uvedenim v Azure
- Prepričajte se, da je model uspešno uveden in aktiven
- Poskusite uporabiti privzeto ime uvedbe: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: Spremenljivke okolja se ne nalagajo</strong></summary>

- Prepričajte se, da je vaša `.env` datoteka v korenski mapi projekta (na isti ravni kot `pom.xml`)
- Poskusite zagnati `mvn spring-boot:run` v integriranem terminalu VS Code
- Preverite, ali je razširitev Java za VS Code pravilno nameščena
- Preverite, ali konfiguracija zagona vsebuje `"envFile": "${workspaceFolder}/.env"`
</details>

### Način za odpravljanje napak

Za omogočanje podrobnega beleženja, odstranite komentarje iz teh vrstic v `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Naslednji koraki

**Nastavitev je zaključena!** Nadaljujte svojo učno pot:

[3. poglavje: Osnovne tehnike generativne umetne inteligence](../../../03-CoreGenerativeAITechniques/README.md)

## Viri

- [Spring AI Azure OpenAI Dokumentacija](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Azure OpenAI Service Dokumentacija](https://learn.microsoft.com/azure/ai-services/openai/)
- [Portal Azure AI Foundry](https://ai.azure.com/)
- [Azure AI Foundry Dokumentacija](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**Omejitev odgovornosti**:  
Ta dokument je bil preveden z uporabo storitve AI za prevajanje [Co-op Translator](https://github.com/Azure/co-op-translator). Čeprav si prizadevamo za natančnost, vas prosimo, da upoštevate, da lahko avtomatizirani prevodi vsebujejo napake ali netočnosti. Izvirni dokument v njegovem maternem jeziku je treba obravnavati kot avtoritativni vir. Za ključne informacije priporočamo profesionalni človeški prevod. Ne odgovarjamo za morebitna nesporazumevanja ali napačne razlage, ki izhajajo iz uporabe tega prevoda.