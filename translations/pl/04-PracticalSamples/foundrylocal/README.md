<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "fe08a184d8a753a0f497673921f77759",
  "translation_date": "2025-11-04T06:47:10+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "pl"
}
-->
# Lokalny Samouczek Spring Boot Foundry

## Spis Treści

- [Wymagania wstępne](../../../../04-PracticalSamples/foundrylocal)
- [Przegląd projektu](../../../../04-PracticalSamples/foundrylocal)
- [Zrozumienie kodu](../../../../04-PracticalSamples/foundrylocal)
  - [1. Konfiguracja aplikacji (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. Główna klasa aplikacji (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. Warstwa usług AI (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. Zależności projektu (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [Jak to wszystko działa razem](../../../../04-PracticalSamples/foundrylocal)
- [Konfigurowanie Foundry Local](../../../../04-PracticalSamples/foundrylocal)
- [Uruchamianie aplikacji](../../../../04-PracticalSamples/foundrylocal)
- [Oczekiwany wynik](../../../../04-PracticalSamples/foundrylocal)
- [Kolejne kroki](../../../../04-PracticalSamples/foundrylocal)
- [Rozwiązywanie problemów](../../../../04-PracticalSamples/foundrylocal)

## Wymagania wstępne

Przed rozpoczęciem tego samouczka upewnij się, że masz:

- **Java 21 lub wyższą** zainstalowaną na swoim systemie
- **Maven 3.6+** do budowania projektu
- **Foundry Local** zainstalowane i uruchomione

### **Instalacja Foundry Local:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```

## Przegląd projektu

Projekt składa się z czterech głównych komponentów:

1. **Application.java** - Główny punkt wejścia aplikacji Spring Boot
2. **FoundryLocalService.java** - Warstwa usług obsługująca komunikację AI
3. **application.properties** - Konfiguracja połączenia z Foundry Local
4. **pom.xml** - Zależności Maven i konfiguracja projektu

## Zrozumienie kodu

### 1. Konfiguracja aplikacji (application.properties)

**Plik:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```

**Co to robi:**
- **base-url**: Określa, gdzie działa Foundry Local, w tym ścieżkę `/v1` dla kompatybilności z API OpenAI. **Uwaga**: Foundry Local dynamicznie przypisuje port, więc sprawdź rzeczywisty port za pomocą `foundry service status`
- **model**: Nazwa modelu AI używanego do generowania tekstu, w tym numer wersji (np. `:1`). Użyj `foundry model list`, aby zobaczyć dostępne modele z ich dokładnymi identyfikatorami

**Kluczowa koncepcja:** Spring Boot automatycznie ładuje te właściwości i udostępnia je aplikacji za pomocą adnotacji `@Value`.

### 2. Główna klasa aplikacji (Application.java)

**Plik:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```

**Co to robi:**
- `@SpringBootApplication` umożliwia automatyczną konfigurację Spring Boot
- `WebApplicationType.NONE` informuje Spring, że jest to aplikacja wiersza poleceń, a nie serwer WWW
- Metoda main uruchamia aplikację Spring

**Uruchamianie demonstracyjne:**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
    };
}
```

**Co to robi:**
- `@Bean` tworzy komponent zarządzany przez Spring
- `CommandLineRunner` uruchamia kod po uruchomieniu Spring Boot
- `foundryLocalService` jest automatycznie wstrzykiwany przez Spring (wstrzykiwanie zależności)
- Wysyła wiadomość testową do AI i wyświetla odpowiedź

### 3. Warstwa usług AI (FoundryLocalService.java)

**Plik:** `src/main/java/com/example/FoundryLocalService.java`

#### Wstrzykiwanie konfiguracji:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```

**Co to robi:**
- `@Service` informuje Spring, że ta klasa dostarcza logikę biznesową
- `@Value` wstrzykuje wartości konfiguracji z application.properties
- Składnia `:default-value` zapewnia wartości domyślne, jeśli właściwości nie są ustawione

#### Inicjalizacja klienta:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```

**Co to robi:**
- `@PostConstruct` uruchamia tę metodę po utworzeniu usługi przez Spring
- Tworzy klienta OpenAI wskazującego na lokalną instancję Foundry Local
- URL bazowy z `application.properties` już zawiera `/v1` dla kompatybilności z API OpenAI
- Klucz API jest ustawiony na "not-needed", ponieważ lokalny rozwój nie wymaga uwierzytelnienia

#### Metoda czatu:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Which AI model to use
                .addUserMessage(message)         // Your question/prompt
                .maxCompletionTokens(150)        // Limit response length
                .temperature(0.7)                // Control creativity (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Extract the AI's response from the API result
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**Co to robi:**
- **ChatCompletionCreateParams**: Konfiguruje żądanie AI
  - `model`: Określa, który model AI ma być używany (musi dokładnie pasować do identyfikatora z `foundry model list`)
  - `addUserMessage`: Dodaje wiadomość użytkownika do rozmowy
  - `maxCompletionTokens`: Ogranicza długość odpowiedzi (oszczędza zasoby)
  - `temperature`: Kontroluje losowość (0.0 = deterministyczne, 1.0 = kreatywne)
- **Wywołanie API**: Wysyła żądanie do Foundry Local
- **Obsługa odpowiedzi**: Bezpiecznie wyodrębnia tekstową odpowiedź AI
- **Obsługa błędów**: Opakowuje wyjątki w pomocne komunikaty o błędach

### 4. Zależności projektu (pom.xml)

**Kluczowe zależności:**

```xml
<!-- Spring Boot - Application framework -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <version>${spring-boot.version}</version>
</dependency>

<!-- OpenAI Java SDK - For AI API calls -->
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>

<!-- Jackson - JSON processing -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.0</version>
</dependency>
```

**Co robią:**
- **spring-boot-starter**: Zapewnia podstawową funkcjonalność Spring Boot
- **openai-java**: Oficjalny SDK OpenAI dla komunikacji z API
- **jackson-databind**: Obsługuje serializację/deserializację JSON dla wywołań API

## Jak to wszystko działa razem

Oto pełny przepływ, gdy uruchamiasz aplikację:

1. **Uruchomienie**: Spring Boot uruchamia się i odczytuje `application.properties`
2. **Tworzenie usługi**: Spring tworzy `FoundryLocalService` i wstrzykuje wartości konfiguracji
3. **Konfiguracja klienta**: `@PostConstruct` inicjalizuje klienta OpenAI do połączenia z Foundry Local
4. **Wykonanie demonstracji**: `CommandLineRunner` wykonuje się po uruchomieniu
5. **Wywołanie AI**: Demonstracja wywołuje `foundryLocalService.chat()` z wiadomością testową
6. **Żądanie API**: Usługa buduje i wysyła żądanie kompatybilne z OpenAI do Foundry Local
7. **Przetwarzanie odpowiedzi**: Usługa wyodrębnia i zwraca odpowiedź AI
8. **Wyświetlanie**: Aplikacja drukuje odpowiedź i kończy działanie

## Konfigurowanie Foundry Local

Aby skonfigurować Foundry Local, wykonaj następujące kroki:

1. **Zainstaluj Foundry Local** zgodnie z instrukcjami w sekcji [Wymagania wstępne](../../../../04-PracticalSamples/foundrylocal).

2. **Sprawdź dynamicznie przypisany port**. Foundry Local automatycznie przypisuje port podczas uruchamiania. Znajdź swój port za pomocą:
   ```bash
   foundry service status
   ```
   
   **Opcjonalnie**: Jeśli wolisz używać konkretnego portu (np. 5273), możesz skonfigurować go ręcznie:
   ```bash
   foundry service set --port 5273
   ```

3. **Pobierz model AI**, który chcesz używać, na przykład `phi-3.5-mini`, za pomocą następującego polecenia:
   ```bash
   foundry model run phi-3.5-mini
   ```

4. **Skonfiguruj plik application.properties**, aby pasował do ustawień Foundry Local:
   - Zaktualizuj port w `base-url` (z kroku 2), upewniając się, że zawiera `/v1` na końcu
   - Zaktualizuj nazwę modelu, aby zawierała numer wersji (sprawdź za pomocą `foundry model list`)
   
   Przykład:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```

## Uruchamianie aplikacji

### Krok 1: Uruchom Foundry Local
```bash
foundry model run phi-3.5-mini
```

### Krok 2: Zbuduj i uruchom aplikację
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Oczekiwany wynik

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi-3.5, a small language model created by Microsoft. I'm currently running 
as the Phi-3.5-mini-instruct model, which is designed to be helpful, harmless, and honest 
in my interactions. I can assist with a wide variety of tasks including answering 
questions, helping with analysis, creative writing, coding, and general conversation. 
Is there something specific you'd like help with today?
=========================
```

## Kolejne kroki

Więcej przykładów znajdziesz w [Rozdziale 04: Praktyczne przykłady](../README.md)

## Rozwiązywanie problemów

### Typowe problemy

**"Connection refused" lub "Service unavailable"**
- Upewnij się, że Foundry Local działa: `foundry model list`
- Sprawdź rzeczywisty port używany przez Foundry Local: `foundry service status`
- Zaktualizuj swój `application.properties` z poprawnym portem, upewniając się, że URL kończy się na `/v1`
- Alternatywnie ustaw konkretny port, jeśli chcesz: `foundry service set --port 5273`
- Spróbuj ponownie uruchomić Foundry Local: `foundry model run phi-3.5-mini`

**"Model not found" lub błędy "404 Not Found"**
- Sprawdź dostępne modele z ich dokładnymi identyfikatorami: `foundry model list`
- Zaktualizuj nazwę modelu w `application.properties`, aby dokładnie pasowała, w tym numer wersji (np. `Phi-3.5-mini-instruct-cuda-gpu:1`)
- Upewnij się, że `base-url` zawiera `/v1` na końcu: `http://localhost:5273/v1`
- Pobierz model, jeśli to konieczne: `foundry model run phi-3.5-mini`

**Błędy "400 Bad Request"**
- Zweryfikuj, że URL bazowy zawiera `/v1`: `http://localhost:5273/v1`
- Sprawdź, czy identyfikator modelu dokładnie pasuje do tego, co pokazuje `foundry model list`
- Upewnij się, że używasz `maxCompletionTokens()` w swoim kodzie (nie przestarzałego `maxTokens()`)

**Błędy kompilacji Maven**
- Upewnij się, że masz Java 21 lub wyższą: `java -version`
- Wyczyść i zbuduj ponownie: `mvn clean compile`
- Sprawdź połączenie internetowe dla pobierania zależności

**Aplikacja uruchamia się, ale brak wyników**
- Zweryfikuj, czy Foundry Local odpowiada: Otwórz przeglądarkę na `http://localhost:5273`
- Sprawdź logi aplikacji pod kątem konkretnych komunikatów o błędach
- Upewnij się, że model jest w pełni załadowany i gotowy

---

**Zastrzeżenie**:  
Ten dokument został przetłumaczony za pomocą usługi tłumaczenia AI [Co-op Translator](https://github.com/Azure/co-op-translator). Chociaż staramy się zapewnić dokładność, należy pamiętać, że automatyczne tłumaczenia mogą zawierać błędy lub nieścisłości. Oryginalny dokument w jego rodzimym języku powinien być uznawany za źródło autorytatywne. W przypadku informacji krytycznych zaleca się skorzystanie z profesjonalnego tłumaczenia przez człowieka. Nie ponosimy odpowiedzialności za jakiekolwiek nieporozumienia lub błędne interpretacje wynikające z użycia tego tłumaczenia.