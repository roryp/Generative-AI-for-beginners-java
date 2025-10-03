<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "afc90918d008cf77fd1982691f681306",
  "translation_date": "2025-10-03T08:35:23+00:00",
  "source_file": "AGENTS.md",
  "language_code": "pl"
}
-->
# AGENTS.md

## Przegląd projektu

To edukacyjne repozytorium służące do nauki rozwoju Generatywnej AI z użyciem Javy. Oferuje kompleksowy kurs praktyczny obejmujący modele językowe (LLMs), inżynierię promptów, osadzenia, RAG (Retrieval-Augmented Generation) oraz protokół kontekstu modelu (MCP).

**Kluczowe technologie:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- Modele GitHub, Azure OpenAI i SDK OpenAI

**Architektura:**
- Kilka samodzielnych aplikacji Spring Boot zorganizowanych według rozdziałów
- Projekty demonstracyjne prezentujące różne wzorce AI
- Gotowe do użycia w GitHub Codespaces z prekonfigurowanymi kontenerami deweloperskimi

## Polecenia konfiguracji

### Wymagania wstępne
- Java 21 lub nowsza
- Maven 3.x
- Osobisty token dostępu do GitHub (dla modeli GitHub)
- Opcjonalnie: dane uwierzytelniające Azure OpenAI

### Konfiguracja środowiska

**Opcja 1: GitHub Codespaces (zalecane)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Opcja 2: Lokalny kontener deweloperski**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Opcja 3: Lokalna konfiguracja**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Konfiguracja

**Konfiguracja tokena GitHub:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Konfiguracja Azure OpenAI (opcjonalna):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Przebieg pracy deweloperskiej

### Struktura projektu
```
/
├── 01-IntroToGenAI/              # Chapter 1: Introduction
├── 02-SetupDevEnvironment/       # Chapter 2: Environment setup
│   └── examples/                 # Working examples
├── 03-CoreGenerativeAITechniques/ # Chapter 3: Core techniques
├── 04-PracticalSamples/          # Chapter 4: Sample projects
│   ├── calculator/               # MCP service example
│   ├── foundrylocal/            # Local model integration
│   └── petstory/                # Multi-modal app
├── 05-ResponsibleGenAI/         # Chapter 5: Responsible AI
└── translations/                # Multi-language support
```

### Uruchamianie aplikacji

**Uruchamianie aplikacji Spring Boot:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Budowanie projektu:**
```bash
cd [project-directory]
mvn clean install
```

**Uruchamianie serwera MCP Calculator:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Uruchamianie przykładów klienta:**
```bash
# After starting the server in another terminal
cd 04-PracticalSamples/calculator

# Direct MCP client
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient"

# AI-powered client (requires GITHUB_TOKEN)
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient"

# Interactive bot
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.Bot"
```

### Hot Reload
Spring Boot DevTools jest dołączony do projektów wspierających hot reload:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Instrukcje testowania

### Uruchamianie testów

**Uruchom wszystkie testy w projekcie:**
```bash
cd [project-directory]
mvn test
```

**Uruchom testy z szczegółowym wyjściem:**
```bash
mvn test -X
```

**Uruchom konkretną klasę testową:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Struktura testów
- Pliki testowe używają JUnit 5 (Jupiter)
- Klasy testowe znajdują się w `src/test/java/`
- Przykłady klienta w projekcie kalkulatora znajdują się w `src/test/java/com/microsoft/mcp/sample/client/`

### Testowanie manualne
Wiele przykładów to interaktywne aplikacje wymagające testowania manualnego:

1. Uruchom aplikację za pomocą `mvn spring-boot:run`
2. Testuj punkty końcowe lub korzystaj z CLI
3. Zweryfikuj, czy oczekiwane zachowanie odpowiada dokumentacji w README.md każdego projektu

### Testowanie z modelami GitHub
- Limity darmowego poziomu: 15 żądań/minutę, 150/dzień
- Maksymalnie 5 równoczesnych żądań
- Testuj filtrowanie treści z przykładami odpowiedzialnej AI

## Wytyczne dotyczące stylu kodu

### Konwencje Java
- **Wersja Java:** Java 21 z nowoczesnymi funkcjami
- **Styl:** Przestrzegaj standardowych konwencji Java
- **Nazewnictwo:** 
  - Klasy: PascalCase
  - Metody/zmienne: camelCase
  - Stałe: UPPER_SNAKE_CASE
  - Nazwy pakietów: małe litery

### Wzorce Spring Boot
- Używaj `@Service` dla logiki biznesowej
- Używaj `@RestController` dla punktów końcowych REST
- Konfiguracja za pomocą `application.yml` lub `application.properties`
- Preferuj zmienne środowiskowe zamiast wartości zakodowanych na stałe
- Używaj adnotacji `@Tool` dla metod eksponowanych przez MCP

### Organizacja plików
```
src/
├── main/
│   ├── java/
│   │   └── com/microsoft/[component]/
│   │       ├── [Component]Application.java
│   │       ├── config/
│   │       ├── controller/
│   │       ├── service/
│   │       └── exception/
│   └── resources/
│       ├── application.yml
│       └── static/
└── test/
    └── java/
        └── com/microsoft/[component]/
```

### Zależności
- Zarządzane za pomocą Maven `pom.xml`
- Spring AI BOM do zarządzania wersjami
- LangChain4j dla integracji AI
- Spring Boot starter parent dla zależności Spring

### Komentarze w kodzie
- Dodaj JavaDoc dla publicznych API
- Dołącz wyjaśniające komentarze dla złożonych interakcji AI
- Dokumentuj opisy narzędzi MCP jasno i przejrzyście

## Budowanie i wdrażanie

### Budowanie projektów

**Budowanie bez testów:**
```bash
mvn clean install -DskipTests
```

**Budowanie z wszystkimi kontrolami:**
```bash
mvn clean install
```

**Pakowanie aplikacji:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Katalogi wyjściowe
- Skompilowane klasy: `target/classes/`
- Klasy testowe: `target/test-classes/`
- Pliki JAR: `target/*.jar`
- Artefakty Maven: `target/`

### Konfiguracja specyficzna dla środowiska

**Rozwój:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Produkcja:**
- Używaj modeli Azure AI Foundry zamiast modeli GitHub
- Zaktualizuj base-url do punktu końcowego Azure OpenAI
- Zarządzaj sekretami za pomocą Azure Key Vault lub zmiennych środowiskowych

### Uwagi dotyczące wdrażania
- To edukacyjne repozytorium z aplikacjami przykładowymi
- Nie jest przeznaczone do wdrożeń produkcyjnych w obecnej formie
- Przykłady pokazują wzorce do adaptacji na potrzeby produkcji
- Zobacz README.md poszczególnych projektów dla szczegółowych uwag dotyczących wdrażania

## Dodatkowe uwagi

### Modele GitHub vs Azure OpenAI
- **Modele GitHub:** Darmowy poziom do nauki, bez konieczności podawania karty kredytowej
- **Azure OpenAI:** Gotowe do produkcji, wymaga subskrypcji Azure
- Kod jest kompatybilny z oboma - wystarczy zmienić punkt końcowy i klucz API

### Praca z wieloma projektami
Każdy projekt przykładowy jest samodzielny:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Typowe problemy

**Niezgodność wersji Java:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Problemy z pobieraniem zależności:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**Nie znaleziono tokena GitHub:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Port już używany:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Obsługa wielu języków
- Dokumentacja dostępna w ponad 45 językach dzięki automatycznym tłumaczeniom
- Tłumaczenia w katalogu `translations/`
- Tłumaczenia zarządzane przez workflow GitHub Actions

### Ścieżka nauki
1. Rozpocznij od [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Przejdź przez rozdziały w kolejności (01 → 05)
3. Wykonaj praktyczne przykłady w każdym rozdziale
4. Eksploruj projekty przykładowe w Rozdziale 4
5. Poznaj praktyki odpowiedzialnej AI w Rozdziale 5

### Kontener deweloperski
Plik `.devcontainer/devcontainer.json` konfiguruje:
- Środowisko rozwoju Java 21
- Maven zainstalowany
- Rozszerzenia Java dla VS Code
- Narzędzia Spring Boot
- Integracja GitHub Copilot
- Docker-in-Docker
- Azure CLI

### Uwagi dotyczące wydajności
- Darmowy poziom modeli GitHub ma limity
- Używaj odpowiednich rozmiarów batchów dla osadzeń
- Rozważ caching dla powtarzających się wywołań API
- Monitoruj użycie tokenów dla optymalizacji kosztów

### Uwagi dotyczące bezpieczeństwa
- Nigdy nie commituj plików `.env` (już w `.gitignore`)
- Używaj zmiennych środowiskowych dla kluczy API
- Tokeny GitHub powinny mieć minimalny wymagany zakres
- Przestrzegaj wytycznych odpowiedzialnej AI w Rozdziale 5

---

**Zastrzeżenie**:  
Ten dokument został przetłumaczony za pomocą usługi tłumaczenia AI [Co-op Translator](https://github.com/Azure/co-op-translator). Chociaż dokładamy wszelkich starań, aby tłumaczenie było precyzyjne, prosimy pamiętać, że automatyczne tłumaczenia mogą zawierać błędy lub nieścisłości. Oryginalny dokument w jego języku źródłowym powinien być uznawany za autorytatywne źródło. W przypadku informacji o kluczowym znaczeniu zaleca się skorzystanie z profesjonalnego tłumaczenia przez człowieka. Nie ponosimy odpowiedzialności za jakiekolwiek nieporozumienia lub błędne interpretacje wynikające z użycia tego tłumaczenia.