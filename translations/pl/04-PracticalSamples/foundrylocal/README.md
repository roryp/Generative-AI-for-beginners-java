<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "d064108b2142d32246ccbd8a42e76b4d",
  "translation_date": "2025-07-25T09:26:42+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "pl"
}
-->
# Lokalna aplikacja wiersza poleceń Foundry

>**Uwaga**: Ten rozdział zawiera [**Samouczek**](./TUTORIAL.md), który przeprowadzi Cię przez przykłady.

Prosta aplikacja wiersza poleceń Spring Boot, która demonstruje, jak połączyć się z Foundry Local za pomocą OpenAI Java SDK.

## Czego się nauczysz

- Jak zintegrować Foundry Local z aplikacjami Spring Boot przy użyciu OpenAI Java SDK
- Najlepsze praktyki w zakresie lokalnego rozwoju i testowania AI

## Spis treści

- [Czego się nauczysz](../../../../04-PracticalSamples/foundrylocal)
- [Wymagania wstępne](../../../../04-PracticalSamples/foundrylocal)
  - [Instalacja Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [Weryfikacja](../../../../04-PracticalSamples/foundrylocal)
- [Konfiguracja](../../../../04-PracticalSamples/foundrylocal)
- [Szybki start](../../../../04-PracticalSamples/foundrylocal)
- [Co robi aplikacja](../../../../04-PracticalSamples/foundrylocal)
- [Przykładowy wynik](../../../../04-PracticalSamples/foundrylocal)
- [Architektura](../../../../04-PracticalSamples/foundrylocal)
- [Najważniejsze fragmenty kodu](../../../../04-PracticalSamples/foundrylocal)
  - [Integracja z OpenAI Java SDK](../../../../04-PracticalSamples/foundrylocal)
  - [API uzupełniania czatu](../../../../04-PracticalSamples/foundrylocal)
- [Rozwiązywanie problemów](../../../../04-PracticalSamples/foundrylocal)

## Wymagania wstępne

> **⚠️ Uwaga**: Ta aplikacja **nie działa w dostarczonym devcontainerze**, ponieważ wymaga zainstalowanego i działającego Foundry Local na systemie hosta.

### Instalacja Foundry Local

Przed uruchomieniem tej aplikacji musisz zainstalować i uruchomić Foundry Local. Wykonaj następujące kroki:

1. **Upewnij się, że Twój system spełnia wymagania**:
   - **System operacyjny**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025 lub macOS
   - **Sprzęt**: 
     - Minimalne: 8GB RAM, 3GB wolnego miejsca na dysku
     - Zalecane: 16GB RAM, 15GB wolnego miejsca na dysku
   - **Sieć**: Połączenie z internetem do początkowego pobrania modelu (opcjonalne do pracy offline)
   - **Przyspieszenie (opcjonalne)**: NVIDIA GPU (seria 2000 lub nowsza), AMD GPU (seria 6000 lub nowsza), Qualcomm Snapdragon X Elite (8GB lub więcej pamięci) lub Apple silicon
   - **Uprawnienia**: Uprawnienia administratora do instalacji oprogramowania na urządzeniu

2. **Zainstaluj Foundry Local**:
   
   **Dla Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **Dla macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Alternatywnie możesz pobrać instalator z [repozytorium Foundry Local na GitHubie](https://github.com/microsoft/Foundry-Local).

3. **Uruchom swój pierwszy model**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   Model zostanie pobrany (co może zająć kilka minut, w zależności od prędkości internetu), a następnie uruchomiony. Foundry Local automatycznie wybiera najlepszy wariant modelu dla Twojego systemu (CUDA dla GPU NVIDIA, wersja CPU w przeciwnym razie).

4. **Przetestuj model**, zadając pytanie w tym samym terminalu:

   ```bash
   Why is the sky blue?
   ```

   Powinieneś zobaczyć odpowiedź od modelu Phi wyjaśniającą, dlaczego niebo jest niebieskie.

### Weryfikacja

Możesz zweryfikować, czy wszystko działa poprawnie, używając tych poleceń:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

Możesz również odwiedzić `http://localhost:5273` w przeglądarce, aby zobaczyć interfejs webowy Foundry Local.

## Konfiguracja

Aplikację można skonfigurować za pomocą pliku `application.properties`:

- `foundry.local.base-url` - Bazowy URL dla Foundry Local (domyślnie: http://localhost:5273)
- `foundry.local.model` - Model AI do użycia (domyślnie: Phi-3.5-mini-instruct-cuda-gpu)

> **Uwaga**: Nazwa modelu w konfiguracji powinna odpowiadać konkretnemu wariantowi, który Foundry Local pobrał dla Twojego systemu. Gdy uruchamiasz `foundry model run phi-3.5-mini`, Foundry Local automatycznie wybiera i pobiera najlepszy wariant (CUDA dla GPU NVIDIA, wersja CPU w przeciwnym razie). Użyj `foundry model list`, aby zobaczyć dokładną nazwę modelu dostępną w Twojej lokalnej instancji.

## Szybki start

### 1. Przejdź do katalogu aplikacji Foundry Local
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Uruchom aplikację

```bash
mvn spring-boot:run
```

Lub zbuduj i uruchom plik JAR:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Zależności

Ta aplikacja używa OpenAI Java SDK do komunikacji z Foundry Local. Kluczowa zależność to:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

Aplikacja jest wstępnie skonfigurowana do łączenia się z Foundry Local działającym na domyślnym porcie.

## Co robi aplikacja

Po uruchomieniu aplikacji:

1. **Uruchamia się** jako aplikacja wiersza poleceń (bez serwera webowego)
2. **Automatycznie wysyła** wiadomość testową: "Hello! Can you tell me what you are and what model you're running?"
3. **Wyświetla odpowiedź** od Foundry Local w konsoli
4. **Zamyka się** po zakończeniu demonstracji

## Przykładowy wynik

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Architektura

- **Application.java** - Główna aplikacja Spring Boot z CommandLineRunner
- **FoundryLocalService.java** - Usługa wykorzystująca OpenAI Java SDK do komunikacji z Foundry Local
- Wykorzystuje **OpenAI Java SDK** do bezpiecznych typowo wywołań API
- Automatyczna serializacja/deserializacja JSON obsługiwana przez SDK
- Czysta konfiguracja za pomocą adnotacji Springa `@Value` i `@PostConstruct`

## Najważniejsze fragmenty kodu

### Integracja z OpenAI Java SDK

Aplikacja używa OpenAI Java SDK do utworzenia klienta skonfigurowanego dla Foundry Local:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### API uzupełniania czatu

Wysyłanie żądań uzupełniania czatu jest proste i bezpieczne typowo:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Rozwiązywanie problemów

Jeśli pojawiają się błędy połączenia:
1. Sprawdź, czy Foundry Local działa na `http://localhost:5273`
2. Upewnij się, że wariant modelu Phi-3.5-mini jest dostępny, używając `foundry model list`
3. Upewnij się, że nazwa modelu w `application.properties` odpowiada dokładnej nazwie modelu pokazanej na liście
4. Sprawdź, czy żaden firewall nie blokuje połączenia

Typowe problemy:
- **Model nie znaleziony**: Uruchom `foundry model run phi-3.5-mini`, aby pobrać i uruchomić model
- **Usługa nie działa**: Usługa Foundry Local mogła się zatrzymać; uruchom ją ponownie za pomocą polecenia uruchamiania modelu
- **Nieprawidłowa nazwa modelu**: Użyj `foundry model list`, aby zobaczyć dostępne modele i zaktualizować konfigurację odpowiednio

**Zastrzeżenie**:  
Ten dokument został przetłumaczony za pomocą usługi tłumaczenia AI [Co-op Translator](https://github.com/Azure/co-op-translator). Chociaż dokładamy wszelkich starań, aby tłumaczenie było precyzyjne, prosimy pamiętać, że automatyczne tłumaczenia mogą zawierać błędy lub nieścisłości. Oryginalny dokument w jego rodzimym języku powinien być uznawany za autorytatywne źródło. W przypadku informacji o kluczowym znaczeniu zaleca się skorzystanie z profesjonalnego tłumaczenia przez człowieka. Nie ponosimy odpowiedzialności za jakiekolwiek nieporozumienia lub błędne interpretacje wynikające z użycia tego tłumaczenia.