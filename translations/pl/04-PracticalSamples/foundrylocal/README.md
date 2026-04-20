# Foundry Local Spring Boot Tutorial

## Spis treści

- [Wymagania wstępne](#wymagania-wstępne)
- [Przegląd projektu](#przegląd-projektu)
- [Zrozumienie kodu](#zrozumienie-kodu)
  - [1. Konfiguracja aplikacji (application.properties)](#1-konfiguracja-aplikacji-applicationproperties)
  - [2. Główna klasa aplikacji (Application.java)](#2-główna-klasa-aplikacji-applicationjava)
  - [3. Warstwa serwisu AI (FoundryLocalService.java)](#3-warstwa-serwisu-ai-foundrylocalservicejava)
  - [4. Zależności projektu (pom.xml)](#4-zależności-projektu-pomxml)
- [Jak to wszystko działa razem](#jak-to-wszystko-działa-razem)
- [Konfiguracja Foundry Local](#konfiguracja-foundry-local)
- [Uruchamianie aplikacji](#uruchamianie-aplikacji)
- [Oczekiwany wynik](#oczekiwany-wynik)
- [Kolejne kroki](#kolejne-kroki)
- [Rozwiązywanie problemów](#rozwiązywanie-problemów)


## Wymagania wstępne

Przed rozpoczęciem tego samouczka upewnij się, że masz:

- **Java 21 lub wyższą** zainstalowaną na swoim systemie
- **Maven 3.6+** do budowania projektu
- **Foundry Local** zainstalowany i działający

### **Instalacja Foundry Local:**

> **Uwaga:** Foundry Local CLI jest dostępny tylko na **Windows** i **macOS**. Linux jest obsługiwany poprzez [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Zweryfikuj instalację:
```bash
foundry --version
```

## Przegląd projektu

Projekt składa się z czterech głównych komponentów:

1. **Application.java** - główny punkt wejścia aplikacji Spring Boot
2. **FoundryLocalService.java** - warstwa serwisu obsługująca komunikację z AI
3. **application.properties** - konfiguracja połączenia z Foundry Local
4. **pom.xml** - zależności Maven i konfiguracja projektu

## Zrozumienie kodu

### 1. Konfiguracja aplikacji (application.properties)

**Plik:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Co to robi:**
- **base-url**: Określa, gdzie działa Foundry Local, zawiera ścieżkę `/v1` dla zgodności z API OpenAI. Domyślny port to `5273`. Jeśli port jest inny, sprawdź go poleceniem `foundry service status`.
- **model** (opcjonalnie): Nazwa modelu AI do użycia przy generowaniu tekstu. **Domyślnie aplikacja wykrywa model automatycznie** poprzez zapytanie do endpointu Foundry Local `/v1/models` podczas uruchamiania, więc nie musisz tego ustawiać. Możesz jednak ustawić to ręcznie, aby nadpisać automatyczne wykrywanie.

**Kluczowa koncepcja:** Spring Boot automatycznie ładuje te właściwości i udostępnia je aplikacji poprzez adnotację `@Value`.

### 2. Główna klasa aplikacji (Application.java)

**Plik:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Nie jest potrzebny serwer sieciowy
        app.run(args);
    }
```

**Co to robi:**
- `@SpringBootApplication` włącza automatyczną konfigurację Spring Boot
- `WebApplicationType.NONE` informuje Spring, że to aplikacja konsolowa, a nie serwer WWW
- Metoda main uruchamia aplikację Spring

**Demo Runner:**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        System.out.println("Calling Foundry Local service...");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
        System.out.println("=========================");
    };
}
```

**Co to robi:**
- `@Bean` tworzy komponent zarządzany przez Spring
- `CommandLineRunner` uruchamia kod po starcie Spring Boot
- `foundryLocalService` jest wstrzykiwany automatycznie przez Spring (dependency injection)
- Wysyła testową wiadomość do AI i wyświetla odpowiedź

### 3. Warstwa serwisu AI (FoundryLocalService.java)

**Plik:** `src/main/java/com/example/FoundryLocalService.java`

#### Wstrzykiwanie konfiguracji:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Automatycznie wykrywane, jeśli puste
```

**Co to robi:**
- `@Service` oznacza, że klasa zawiera logikę biznesową
- `@Value` wstrzykuje wartości konfiguracyjne z application.properties
- Model domyślnie jest pusty, co uruchamia **automatyczne wykrywanie** modelu z Foundry Local podczas uruchomienia. Dzięki temu aplikacja działa z dowolnym modelem załadowanym w Foundry Local bez potrzeby ręcznej konfiguracji.

#### Inicjalizacja klienta:
```java
@PostConstruct
public void init() {
    // Automatycznie wykryj model z Foundry Local, jeśli nie jest wyraźnie skonfigurowany
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Podstawowy URL zawiera już /v1 z konfiguracji
            .apiKey("not-needed")            // Lokalny serwer nie wymaga prawdziwego klucza API
            .build();
}
```

**Co to robi:**
- `@PostConstruct` uruchamia tę metodę po utworzeniu usługi przez Spring
- Jeśli nie ustawiono modelu, pobiera listę modeli z endpointu `/v1/models` w Foundry Local i wybiera pierwszy załadowany model
- Tworzy klienta OpenAI wskazującego na lokalną instancję Foundry Local
- Podany base URL w `application.properties` zawiera już `/v1` dla zgodności z API OpenAI
- Klucz API jest ustawiony na "not-needed", ponieważ lokalny rozwój nie wymaga uwierzytelnienia

#### Metoda chat:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Którego modelu SI użyć
                .addUserMessage(message)         // Twoje pytanie/polecenie
                .maxCompletionTokens(150)        // Ogranicz długość odpowiedzi
                .temperature(0.7)                // Kontroluj kreatywność (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Wyodrębnij odpowiedź SI z wyniku API
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
- **ChatCompletionCreateParams**: Konfiguruje zapytanie do AI
  - `model`: Określa, którego modelu AI użyć (musi dokładnie zgadzać się z ID z `foundry model list`)
  - `addUserMessage`: Dodaje Twoją wiadomość do rozmowy
  - `maxCompletionTokens`: Ogranicza długość odpowiedzi (oszczędza zasoby)
  - `temperature`: Steruje losowością (0.0 = deterministyczne, 1.0 = kreatywne)
- **Wywołanie API**: Wysyła zapytanie do Foundry Local
- **Obsługa odpowiedzi**: Bezpiecznie wyciąga tekst odpowiedzi AI
- **Obsługa błędów**: Obejmuje wyjątki pomocnymi komunikatami

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
- **openai-java**: Oficjalne SDK Java OpenAI do komunikacji z API
- **jackson-databind**: Obsługuje serializację/deserializację JSON dla wywołań API

## Jak to wszystko działa razem

Oto pełny przebieg działania aplikacji po uruchomieniu:

1. **Start**: Spring Boot uruchamia się i odczytuje `application.properties`
2. **Tworzenie serwisu**: Spring tworzy `FoundryLocalService` i wstrzykuje wartości konfiguracyjne
3. **Wykrywanie modelu**: Jeśli nie skonfigurowano modelu, serwis pobiera z Foundry Local listę modeli z endpointu `/v1/models` i automatycznie używa pierwszego dostępnego
4. **Konfiguracja klienta**: `@PostConstruct` inicjalizuje klienta OpenAI do połączenia z Foundry Local
5. **Uruchomienie demo**: `CommandLineRunner` wykonuje się po starcie
6. **Wywołanie AI**: Demo wywołuje `foundryLocalService.chat()` z testową wiadomością
7. **Zapytanie API**: Serwis buduje i wysyła zapytanie kompatybilne z OpenAI do Foundry Local
8. **Przetwarzanie odpowiedzi**: Serwis wyciąga i zwraca odpowiedź AI
9. **Wyświetlenie**: Aplikacja drukuje odpowiedź i kończy działanie

## Konfiguracja Foundry Local

1. **Zainstaluj Foundry Local** zgodnie z instrukcjami w sekcji [Wymagania wstępne](#wymagania-wstępne).

2. **Uruchom usługę** (jeśli nie działa):
   ```bash
   foundry service start
   ```

3. **Sprawdź status usługi**, by potwierdzić, że działa i zanotuj port:
   ```bash
   foundry service status
   ```

4. **Pobierz i uruchom model** (pobierany przy pierwszym uruchomieniu, potem w cache):
   ```bash
   foundry model run phi-4-mini
   ```
   Otworzy to interaktywną sesję czatu. Możesz wyjść `Ctrl+C`. Model pozostaje załadowany w usłudze.

   > **Wskazówka:** Uruchom `foundry model list`, aby zobaczyć dostępne modele. Zamień `phi-4-mini` na dowolny alias katalogu (np. `qwen2.5-0.5b` dla mniejszego/szybszego modelu).

5. **Sprawdź, czy model jest załadowany:**
   ```bash
   foundry service ps
   ```

6. **Zaktualizuj `application.properties`** w razie potrzeby:
   - Domyślny `base-url` (`http://localhost:5273/v1`) jest zgodny ze standardowym portem CLI. Aktualizuj go tylko, jeśli `foundry service status` pokazuje inny port.
   - Model jest **automatycznie wykrywany** przy starcie — nie wymaga konfiguracji.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Uruchamianie aplikacji

### Krok 1: Upewnij się, że model jest załadowany w Foundry Local
```bash
foundry service ps
```
Jeśli nie ma modeli na liście, załaduj jeden:
```bash
foundry model run phi-4-mini
```

### Krok 2: Zbuduj i uruchom aplikację
W osobnym terminalu:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Lub zbuduj i uruchom jako JAR:
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
Hello! I'm Phi, an AI developed by Microsoft. I can assist with a wide variety of 
tasks including answering questions, helping with analysis, creative writing, coding, 
and general conversation. How can I help you today?
=========================
```

## Kolejne kroki

Aby zobaczyć więcej przykładów, zajrzyj do [Rozdział 04: Praktyczne przykłady](../README.md)

## Rozwiązywanie problemów

### Częste problemy

**"Connection refused" lub "Service unavailable"**  
- Sprawdź usługę: `foundry service status`  
- W razie potrzeby zrestartuj: `foundry service restart`  
- Zweryfikuj, czy port w `application.properties` odpowiada temu z `foundry service status`  
- Upewnij się, że adres URL kończy się na `/v1`: `http://localhost:5273/v1`  

**"No model found" przy starcie**  
- Aplikacja wykrywa model automatycznie. Upewnij się, że przynajmniej jeden jest załadowany: `foundry service ps`  
- Jeśli nie ma modeli: `foundry model run phi-4-mini`  
- Jeśli nadpisałeś nazwę modelu w `application.properties`, sprawdź, czy zgadza się z `foundry model list`  

**Błędy "400 Bad Request"**  
- Zweryfikuj, że base URL zawiera `/v1`: `http://localhost:5273/v1`  
- Używaj `maxCompletionTokens()` w kodzie, a nie przestarzałego `maxTokens()`  

**Błędy kompilacji Maven**  
- Upewnij się, że masz Java 21 lub wyższą: `java -version`  
- Wyczyść i skompiluj ponownie: `mvn clean compile`  
- Sprawdź połączenie internetowe do pobierania zależności  

**Problemy z połączeniem do usługi**  
- Jeśli pojawia się komunikat `Request to local service failed`, uruchom: `foundry service restart`  
- Sprawdź załadowane modele: `foundry service ps`  
- Zobacz logi usługi: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Zastrzeżenie**:  
Ten dokument został przetłumaczony za pomocą automatycznej usługi tłumaczeniowej AI [Co-op Translator](https://github.com/Azure/co-op-translator). Chociaż staramy się zapewnić dokładność, prosimy pamiętać, że tłumaczenia automatyczne mogą zawierać błędy lub nieścisłości. Oryginalny dokument w jego języku oryginalnym należy traktować jako źródło ostateczne. W przypadku informacji o kluczowym znaczeniu zalecane jest skorzystanie z profesjonalnego tłumaczenia wykonanego przez człowieka. Nie ponosimy odpowiedzialności za jakiekolwiek nieporozumienia lub błędne interpretacje wynikające z korzystania z tego tłumaczenia.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->