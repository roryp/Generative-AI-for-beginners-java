<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0b563ac59362fb83f0f49dcfc442dd97",
  "translation_date": "2025-07-21T16:20:15+00:00",
  "source_file": "02-SetupDevEnvironment/README.md",
  "language_code": "pl"
}
-->
# Konfigurowanie środowiska programistycznego dla Generative AI w Javie

> **Szybki start**: Kodowanie w chmurze w 2 minuty - Przejdź do [Konfiguracja GitHub Codespaces](../../../02-SetupDevEnvironment) - bez konieczności instalacji lokalnej, korzystając z modeli GitHub!

> **Zainteresowany Azure OpenAI?** Zobacz nasz [Przewodnik konfiguracji Azure OpenAI](getting-started-azure-openai.md) z krokami tworzenia nowego zasobu Azure OpenAI.

## Czego się nauczysz

- Jak skonfigurować środowisko programistyczne w Javie dla aplikacji AI
- Jak wybrać i skonfigurować preferowane środowisko programistyczne (chmura z Codespaces, lokalny kontener deweloperski lub pełna instalacja lokalna)
- Jak przetestować konfigurację, łącząc się z modelami GitHub

## Spis treści

- [Czego się nauczysz](../../../02-SetupDevEnvironment)
- [Wprowadzenie](../../../02-SetupDevEnvironment)
- [Krok 1: Konfiguracja środowiska programistycznego](../../../02-SetupDevEnvironment)
  - [Opcja A: GitHub Codespaces (zalecane)](../../../02-SetupDevEnvironment)
  - [Opcja B: Lokalny kontener deweloperski](../../../02-SetupDevEnvironment)
  - [Opcja C: Użyj istniejącej instalacji lokalnej](../../../02-SetupDevEnvironment)
- [Krok 2: Utwórz GitHub Personal Access Token](../../../02-SetupDevEnvironment)
- [Krok 3: Testowanie konfiguracji](../../../02-SetupDevEnvironment)
- [Rozwiązywanie problemów](../../../02-SetupDevEnvironment)
- [Podsumowanie](../../../02-SetupDevEnvironment)
- [Kolejne kroki](../../../02-SetupDevEnvironment)

## Wprowadzenie

Ten rozdział poprowadzi Cię przez proces konfiguracji środowiska programistycznego. Użyjemy **GitHub Models** jako głównego przykładu, ponieważ jest darmowy, łatwy w konfiguracji (wystarczy konto GitHub), nie wymaga karty kredytowej i zapewnia dostęp do wielu modeli do eksperymentowania.

**Nie wymaga instalacji lokalnej!** Możesz zacząć kodować natychmiast, korzystając z GitHub Codespaces, które oferuje pełne środowisko programistyczne w przeglądarce.

<img src="./images/models.webp" alt="Zrzut ekranu: GitHub Models" width="50%">

Polecamy korzystanie z [**GitHub Models**](https://github.com/marketplace?type=models) w tym kursie, ponieważ:
- Jest **darmowy** na początek
- **Łatwy** w konfiguracji (wystarczy konto GitHub)
- **Nie wymaga karty kredytowej**
- Oferuje **wiele modeli** do eksperymentowania

> **Uwaga**: Modele GitHub używane w tym szkoleniu mają następujące limity:
> - 15 żądań na minutę (150 dziennie)
> - ~8,000 słów wejściowych, ~4,000 słów wyjściowych na żądanie
> - 5 równoczesnych żądań
> 
> Do zastosowań produkcyjnych, przejdź na modele Azure AI Foundry, korzystając z konta Azure. Twój kod nie wymaga zmian. Zobacz [dokumentację Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/foundry-models/how-to/quickstart-github-models).

## Krok 1: Konfiguracja środowiska programistycznego

<a name="quick-start-cloud"></a>

Przygotowaliśmy wstępnie skonfigurowany kontener deweloperski, aby zminimalizować czas konfiguracji i zapewnić wszystkie niezbędne narzędzia do tego kursu Generative AI w Javie. Wybierz preferowane podejście:

### Opcje konfiguracji środowiska:

#### Opcja A: GitHub Codespaces (zalecane)

**Zacznij kodować w 2 minuty - bez instalacji lokalnej!**

1. Zforkuj to repozytorium na swoje konto GitHub
   > **Uwaga**: Jeśli chcesz edytować podstawową konfigurację, zapoznaj się z [Konfiguracją kontenera deweloperskiego](../../../.devcontainer/devcontainer.json)
2. Kliknij **Code** → zakładka **Codespaces** → **...** → **New with options...**
3. Użyj domyślnych ustawień – zostanie wybrana konfiguracja kontenera deweloperskiego: **Generative AI Java Development Environment**, specjalnie przygotowana na potrzeby tego kursu
4. Kliknij **Create codespace**
5. Poczekaj ~2 minuty na przygotowanie środowiska
6. Przejdź do [Krok 2: Utwórz GitHub Token](../../../02-SetupDevEnvironment)

<img src="./images/codespaces.png" alt="Zrzut ekranu: submenu Codespaces" width="50%">

<img src="./images/image.png" alt="Zrzut ekranu: New with options" width="50%">

<img src="./images/codespaces-create.png" alt="Zrzut ekranu: Opcje tworzenia Codespace" width="50%">

> **Zalety Codespaces**:
> - Nie wymaga instalacji lokalnej
> - Działa na każdym urządzeniu z przeglądarką
> - Wstępnie skonfigurowane ze wszystkimi narzędziami i zależnościami
> - Darmowe 60 godzin miesięcznie dla kont osobistych
> - Spójne środowisko dla wszystkich uczestników

#### Opcja B: Lokalny kontener deweloperski

**Dla programistów preferujących lokalny rozwój z Dockerem**

1. Zforkuj i sklonuj to repozytorium na swój komputer
   > **Uwaga**: Jeśli chcesz edytować podstawową konfigurację, zapoznaj się z [Konfiguracją kontenera deweloperskiego](../../../.devcontainer/devcontainer.json)
2. Zainstaluj [Docker Desktop](https://www.docker.com/products/docker-desktop/) i [VS Code](https://code.visualstudio.com/)
3. Zainstaluj rozszerzenie [Dev Containers](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) w VS Code
4. Otwórz folder repozytorium w VS Code
5. Po wyświetleniu komunikatu kliknij **Reopen in Container** (lub użyj `Ctrl+Shift+P` → "Dev Containers: Reopen in Container")
6. Poczekaj na zbudowanie i uruchomienie kontenera
7. Przejdź do [Krok 2: Utwórz GitHub Token](../../../02-SetupDevEnvironment)

<img src="./images/devcontainer.png" alt="Zrzut ekranu: konfiguracja kontenera deweloperskiego" width="50%">

<img src="./images/image-3.png" alt="Zrzut ekranu: zakończone budowanie kontenera deweloperskiego" width="50%">

#### Opcja C: Użyj istniejącej instalacji lokalnej

**Dla programistów z istniejącym środowiskiem Java**

Wymagania:
- [Java 21+](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) 
- [Maven 3.9+](https://maven.apache.org/download.cgi)
- [VS Code](https://code.visualstudio.com) lub preferowane IDE

Kroki:
1. Sklonuj to repozytorium na swój komputer
2. Otwórz projekt w swoim IDE
3. Przejdź do [Krok 2: Utwórz GitHub Token](../../../02-SetupDevEnvironment)

> **Porada**: Jeśli masz komputer o niskiej specyfikacji, ale chcesz używać VS Code lokalnie, skorzystaj z GitHub Codespaces! Możesz połączyć lokalny VS Code z chmurowym Codespace, aby uzyskać najlepsze rozwiązanie.

<img src="./images/image-2.png" alt="Zrzut ekranu: utworzona lokalna instancja kontenera deweloperskiego" width="50%">

## Krok 2: Utwórz GitHub Personal Access Token

1. Przejdź do [Ustawień GitHub](https://github.com/settings/profile) i wybierz **Settings** z menu profilu.
2. W lewym pasku bocznym kliknij **Developer settings** (zwykle na dole).
3. W sekcji **Personal access tokens** kliknij **Fine-grained tokens** (lub skorzystaj z tego [linku](https://github.com/settings/personal-access-tokens)).
4. Kliknij **Generate new token**.
5. W polu "Token name" podaj opisową nazwę (np. `GenAI-Java-Course-Token`).
6. Ustaw datę wygaśnięcia (zalecane: 7 dni dla bezpieczeństwa).
7. W sekcji "Resource owner" wybierz swoje konto użytkownika.
8. W sekcji "Repository access" wybierz repozytoria, które chcesz używać z modelami GitHub (lub "All repositories", jeśli to konieczne).
9. W sekcji "Repository permissions" znajdź **Models** i ustaw na **Read and write**.
10. Kliknij **Generate token**.
11. **Skopiuj i zapisz swój token teraz** – nie będziesz mógł go zobaczyć ponownie!

> **Porada dotycząca bezpieczeństwa**: Używaj minimalnego wymaganego zakresu i najkrótszego praktycznego czasu wygaśnięcia dla swoich tokenów dostępu.

## Krok 3: Testowanie konfiguracji z przykładem GitHub Models

Gdy Twoje środowisko programistyczne jest gotowe, przetestuj integrację z modelami GitHub za pomocą naszej przykładowej aplikacji w [`02-SetupDevEnvironment/src/github-models`](../../../02-SetupDevEnvironment/src/github-models).

1. Otwórz terminal w swoim środowisku programistycznym.
2. Przejdź do przykładu GitHub Models:
   ```bash
   cd 02-SetupDevEnvironment/src/github-models
   ```
3. Ustaw swój token GitHub jako zmienną środowiskową:
   ```bash
   # macOS/Linux
   export GITHUB_TOKEN=your_token_here
   
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_token_here"
   ```

4. Uruchom aplikację:
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.githubmodels.App"
   ```

Powinieneś zobaczyć wynik podobny do:
```text
Using model: gpt-4.1-nano
Sending request to GitHub Models...
Response: Hello World!
```

### Zrozumienie kodu przykładowego

Najpierw zrozummy, co uruchomimy. Przykład używa OpenAI Java SDK do połączenia z modelami GitHub:

**Co robi ten kod:**
- **Łączy się** z modelami GitHub za pomocą Twojego tokenu dostępu
- **Wysyła** prostą wiadomość "Say Hello World!" do modelu AI
- **Odbiera** i wyświetla odpowiedź AI
- **Weryfikuje**, że konfiguracja działa poprawnie

**Kluczowa zależność** (w `pom.xml`):
```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

**Główny kod** (`App.java`):
```java
// Connect to GitHub Models using OpenAI Java SDK
OpenAIClient client = OpenAIOkHttpClient.builder()
    .apiKey(pat)
    .baseUrl("https://models.inference.ai.azure.com")
    .build();

// Create chat completion request
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .model(modelId)
    .addSystemMessage("You are a concise assistant.")
    .addUserMessage("Say Hello World!")
    .build();

// Get AI response
ChatCompletion response = client.chat().completions().create(params);
System.out.println("Response: " + response.choices().get(0).message().content().orElse("No response content"));
```

## Podsumowanie

**Gratulacje!** Pomyślnie:

- **Utworzyłeś GitHub Personal Access Token** z odpowiednimi uprawnieniami do dostępu do modeli AI
- **Skonfigurowałeś środowisko programistyczne w Javie** za pomocą Codespaces, kontenerów deweloperskich lub instalacji lokalnej
- **Połączyłeś się z modelami GitHub** za pomocą OpenAI Java SDK, uzyskując darmowy dostęp do rozwoju AI
- **Przetestowałeś integrację** za pomocą działającej aplikacji, która komunikuje się z modelami AI

## Kolejne kroki

[Rozdział 3: Podstawowe techniki Generative AI](../03-CoreGenerativeAITechniques/README.md)

## Rozwiązywanie problemów

Masz problemy? Oto typowe problemy i rozwiązania:

- **Token nie działa?** 
  - Upewnij się, że skopiowałeś cały token bez dodatkowych spacji
  - Zweryfikuj, że token jest poprawnie ustawiony jako zmienna środowiskowa
  - Sprawdź, czy Twój token ma odpowiednie uprawnienia (Models: Read and write)

- **Maven nie znaleziony?** 
  - Jeśli używasz kontenerów deweloperskich/Codespaces, Maven powinien być wstępnie zainstalowany
  - Dla konfiguracji lokalnej upewnij się, że Java 21+ i Maven 3.9+ są zainstalowane
  - Spróbuj `mvn --version`, aby zweryfikować instalację

- **Problemy z połączeniem?** 
  - Sprawdź swoje połączenie internetowe
  - Zweryfikuj, czy GitHub jest dostępny z Twojej sieci
  - Upewnij się, że nie jesteś za firewallem blokującym punkt końcowy modeli GitHub

- **Kontener deweloperski nie uruchamia się?** 
  - Upewnij się, że Docker Desktop działa (dla rozwoju lokalnego)
  - Spróbuj odbudować kontener: `Ctrl+Shift+P` → "Dev Containers: Rebuild Container"

- **Błędy kompilacji aplikacji?**
  - Upewnij się, że znajdujesz się w odpowiednim katalogu: `02-SetupDevEnvironment/src/github-models`
  - Spróbuj wyczyścić i odbudować: `mvn clean compile`

> **Potrzebujesz pomocy?**: Nadal masz problemy? Otwórz zgłoszenie w repozytorium, a pomożemy Ci.

**Zastrzeżenie**:  
Ten dokument został przetłumaczony za pomocą usługi tłumaczenia AI [Co-op Translator](https://github.com/Azure/co-op-translator). Chociaż dokładamy wszelkich starań, aby zapewnić poprawność tłumaczenia, prosimy pamiętać, że automatyczne tłumaczenia mogą zawierać błędy lub nieścisłości. Oryginalny dokument w jego rodzimym języku powinien być uznawany za autorytatywne źródło. W przypadku informacji o kluczowym znaczeniu zaleca się skorzystanie z profesjonalnego tłumaczenia przez człowieka. Nie ponosimy odpowiedzialności za jakiekolwiek nieporozumienia lub błędne interpretacje wynikające z korzystania z tego tłumaczenia.