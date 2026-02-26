# Podstawowy Chat z Azure OpenAI - Przykład End-to-End

Ten przykład pokazuje, jak stworzyć prostą aplikację Spring Boot, która łączy się z Azure OpenAI i testuje Twoją konfigurację.

## Spis Treści

- [Wymagania wstępne](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Szybki Start](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Opcje Konfiguracji](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Opcja 1: Zmienne środowiskowe (plik .env) - Zalecane](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Opcja 2: Sekrety GitHub Codespace](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Uruchamianie Aplikacji](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Za pomocą Maven](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Za pomocą VS Code](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Oczekiwany Wynik](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Referencje Konfiguracji](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Zmienne środowiskowe](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Konfiguracja Spring](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Rozwiązywanie Problemów](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Typowe Problemy](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Tryb Debugowania](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Kolejne Kroki](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Zasoby](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## Wymagania wstępne

Przed uruchomieniem tego przykładu upewnij się, że:

- Ukończyłeś [przewodnik konfiguracji Azure OpenAI](../../getting-started-azure-openai.md)  
- Wdrożyłeś zasób Azure OpenAI (przez portal Azure AI Foundry)  
- Wdrożyłeś model gpt-4o-mini (lub alternatywny)  
- Posiadasz klucz API i URL punktu końcowego z Azure  

## Szybki Start

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Opcje Konfiguracji

### Opcja 1: Zmienne środowiskowe (plik .env) - Zalecane

**Krok 1: Utwórz plik konfiguracyjny**
```bash
cp .env.example .env
```

**Krok 2: Dodaj swoje dane uwierzytelniające Azure OpenAI**
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Uwaga dotycząca bezpieczeństwa**: 
> - Nigdy nie commituj pliku `.env` do systemu kontroli wersji
> - Plik `.env` jest już dodany do `.gitignore`
> - Chroń swoje klucze API i regularnie je rotuj

### Opcja 2: Sekrety GitHub Codespace

Dla GitHub Codespaces ustaw następujące sekrety w swoim repozytorium:
- `AZURE_AI_KEY` - Twój klucz API Azure OpenAI
- `AZURE_AI_ENDPOINT` - Twój URL punktu końcowego Azure OpenAI

Aplikacja automatycznie wykrywa i używa tych sekretów.

### Alternatywa: Bezpośrednie zmienne środowiskowe

<details>
<summary>Kliknij, aby zobaczyć polecenia specyficzne dla platformy</summary>

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

## Uruchamianie Aplikacji

### Za pomocą Maven

```bash
mvn spring-boot:run
```

### Za pomocą VS Code

1. Otwórz projekt w VS Code
2. Naciśnij `F5` lub użyj panelu "Run and Debug"
3. Wybierz konfigurację "Spring Boot-BasicChatApplication"

> **Uwaga**: Konfiguracja VS Code automatycznie ładuje plik .env

### Oczekiwany Wynik

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

## Referencje Konfiguracji

### Zmienne środowiskowe

| Zmienna | Opis | Wymagana | Przykład |
|---------|------|----------|----------|
| `AZURE_AI_KEY` | Klucz API Azure OpenAI | Tak | `abc123...` |
| `AZURE_AI_ENDPOINT` | URL punktu końcowego Azure OpenAI | Tak | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Nazwa wdrożenia modelu | Nie | `gpt-4o-mini` (domyślnie) |

### Konfiguracja Spring

Plik `application.yml` konfiguruje:
- **Klucz API**: `${AZURE_AI_KEY}` - Pobierany ze zmiennej środowiskowej
- **Punkt końcowy**: `${AZURE_AI_ENDPOINT}` - Pobierany ze zmiennej środowiskowej  
- **Model**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Pobierany ze zmiennej środowiskowej z wartością domyślną
- **Temperatura**: `0.7` - Kontroluje kreatywność (0.0 = deterministyczne, 1.0 = kreatywne)
- **Maksymalna liczba tokenów**: `500` - Maksymalna długość odpowiedzi

## Rozwiązywanie Problemów

### Typowe Problemy

<details>
<summary><strong>Błąd: "Klucz API jest nieprawidłowy"</strong></summary>

- Sprawdź, czy `AZURE_AI_KEY` jest poprawnie ustawiony w pliku `.env`
- Upewnij się, że klucz API został dokładnie skopiowany z portalu Azure AI Foundry
- Upewnij się, że nie ma dodatkowych spacji lub cudzysłowów wokół klucza
</details>

<details>
<summary><strong>Błąd: "Punkt końcowy jest nieprawidłowy"</strong></summary>

- Upewnij się, że `AZURE_AI_ENDPOINT` zawiera pełny URL (np. `https://your-hub-name.openai.azure.com/`)
- Sprawdź spójność ukośników na końcu URL
- Zweryfikuj, czy punkt końcowy odpowiada regionowi wdrożenia Azure
</details>

<details>
<summary><strong>Błąd: "Nie znaleziono wdrożenia"</strong></summary>

- Zweryfikuj, czy nazwa wdrożenia modelu dokładnie odpowiada temu, co zostało wdrożone w Azure
- Sprawdź, czy model został pomyślnie wdrożony i jest aktywny
- Spróbuj użyć domyślnej nazwy wdrożenia: `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code: Zmienne środowiskowe nie ładują się</strong></summary>

- Upewnij się, że plik `.env` znajduje się w katalogu głównym projektu (na tym samym poziomie co `pom.xml`)
- Spróbuj uruchomić `mvn spring-boot:run` w zintegrowanym terminalu VS Code
- Sprawdź, czy rozszerzenie Java dla VS Code jest poprawnie zainstalowane
- Zweryfikuj, czy konfiguracja uruchamiania zawiera `"envFile": "${workspaceFolder}/.env"`
</details>

### Tryb Debugowania

Aby włączyć szczegółowe logowanie, odkomentuj te linie w pliku `application.yml`:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Kolejne Kroki

**Konfiguracja zakończona!** Kontynuuj swoją naukę:

[Rozdział 3: Podstawowe Techniki Generatywnej AI](../../../03-CoreGenerativeAITechniques/README.md)

## Zasoby

- [Dokumentacja Spring AI Azure OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Dokumentacja usługi Azure OpenAI](https://learn.microsoft.com/azure/ai-services/openai/)
- [Portal Azure AI Foundry](https://ai.azure.com/)
- [Dokumentacja Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

**Zastrzeżenie**:  
Ten dokument został przetłumaczony za pomocą usługi tłumaczenia AI [Co-op Translator](https://github.com/Azure/co-op-translator). Chociaż dokładamy wszelkich starań, aby tłumaczenie było precyzyjne, prosimy pamiętać, że automatyczne tłumaczenia mogą zawierać błędy lub nieścisłości. Oryginalny dokument w jego rodzimym języku powinien być uznawany za autorytatywne źródło. W przypadku informacji o kluczowym znaczeniu zaleca się skorzystanie z profesjonalnego tłumaczenia przez człowieka. Nie ponosimy odpowiedzialności za jakiekolwiek nieporozumienia lub błędne interpretacje wynikające z użycia tego tłumaczenia.