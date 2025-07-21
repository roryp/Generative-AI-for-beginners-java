<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T16:36:50+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "pl"
}
-->
# Lokalna aplikacja wiersza poleceń Foundry

>**Uwaga**: Ten rozdział zawiera [**Samouczek**](./TUTORIAL.md), który przeprowadzi Cię przez uruchamianie gotowych przykładów.

Prosta aplikacja wiersza poleceń Spring Boot, która demonstruje, jak połączyć się z Foundry Local za pomocą OpenAI Java SDK.

## Czego się nauczysz

- Jak zintegrować Foundry Local z aplikacjami Spring Boot za pomocą OpenAI Java SDK
- Najlepsze praktyki w lokalnym rozwoju i testowaniu AI

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
  - [Integracja OpenAI Java SDK](../../../../04-PracticalSamples/foundrylocal)
  - [API uzupełniania czatu](../../../../04-PracticalSamples/foundrylocal)
- [Rozwiązywanie problemów](../../../../04-PracticalSamples/foundrylocal)

## Wymagania wstępne

> **⚠️ Uwaga**: Ta aplikacja **nie działa w dostarczonym devcontainerze**, ponieważ wymaga zainstalowanego i uruchomionego Foundry Local na systemie hosta.

### Instalacja Foundry Local

Przed uruchomieniem tej aplikacji musisz zainstalować i uruchomić Foundry Local. Wykonaj następujące kroki:

1. **Upewnij się, że Twój system spełnia wymagania**:
   - **System operacyjny**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025 lub macOS
   - **Sprzęt**: 
     - Minimalne: 8GB RAM, 3GB wolnego miejsca na dysku
     - Zalecane: 16GB RAM, 15GB wolnego miejsca na dysku
   - **Sieć**: Połączenie z internetem do początkowego pobrania modelu (opcjonalne dla trybu offline)
   - **Przyspieszenie (opcjonalne)**: NVIDIA GPU (seria 2000 lub nowsza), AMD GPU (seria 6000 lub nowsza), Qualcomm Snapdragon X Elite (8GB lub więcej pamięci) lub Apple silicon
   - **Uprawnienia**: Uprawnienia administracyjne do instalacji oprogramowania na urządzeniu

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

Możesz zweryfikować poprawność działania za pomocą tych poleceń:

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

> **Uwaga**: Nazwa modelu w konfiguracji powinna odpowiadać konkretnemu wariantowi, który Foundry Local pobrał dla Twojego systemu. Gdy uruchomisz `foundry model run phi-3.5-mini`, Foundry Local automatycznie wybiera i pobiera najlepszy wariant (CUDA dla GPU NVIDIA, wersja CPU w przeciwnym razie). Użyj `foundry model list`, aby zobaczyć dokładną nazwę modelu dostępną w Twojej lokalnej instancji.

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

Aplikacja korzysta z OpenAI Java SDK do komunikacji z Foundry Local. Kluczowa zależność to:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

Aplikacja jest wstępnie skonfigurowana do połączenia z Foundry Local działającym na domyślnym porcie.

## Co robi aplikacja

Po uruchomieniu aplikacji:

1. **Uruchamia się** jako aplikacja wiersza poleceń (bez serwera webowego)
2. **Automatycznie wysyła** wiadomość testową: "Cześć! Czy możesz powiedzieć, czym jesteś i jaki model uruchamiasz?"
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
- **FoundryLocalService.java** - Usługa korzystająca z OpenAI Java SDK do komunikacji z Foundry Local
- Korzysta z **OpenAI Java SDK** do bezpiecznych typowo wywołań API
- Automatyczna serializacja/deserializacja JSON obsługiwana przez SDK
- Czysta konfiguracja za pomocą adnotacji Spring `@Value` i `@PostConstruct`

## Najważniejsze fragmenty kodu

### Integracja OpenAI Java SDK

Aplikacja korzysta z OpenAI Java SDK do stworzenia klienta skonfigurowanego dla Foundry Local:

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

Wysyłanie zapytań do API uzupełniania czatu jest proste i bezpieczne typowo:

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

Jeśli pojawią się błędy połączenia:
1. Sprawdź, czy Foundry Local działa na `http://localhost:5273`
2. Upewnij się, że wariant modelu Phi-3.5-mini jest dostępny za pomocą `foundry model list`
3. Upewnij się, że nazwa modelu w `application.properties` odpowiada dokładnej nazwie modelu pokazanej na liście
4. Upewnij się, że żaden firewall nie blokuje połączenia

Typowe problemy:
- **Model nie znaleziony**: Uruchom `foundry model run phi-3.5-mini`, aby pobrać i uruchomić model
- **Usługa nie działa**: Usługa Foundry Local mogła się zatrzymać; uruchom ją ponownie za pomocą polecenia uruchomienia modelu
- **Nieprawidłowa nazwa modelu**: Użyj `foundry model list`, aby zobaczyć dostępne modele i zaktualizować konfigurację odpowiednio

**Zastrzeżenie**:  
Ten dokument został przetłumaczony za pomocą usługi tłumaczenia AI [Co-op Translator](https://github.com/Azure/co-op-translator). Chociaż dokładamy wszelkich starań, aby tłumaczenie było precyzyjne, prosimy pamiętać, że automatyczne tłumaczenia mogą zawierać błędy lub nieścisłości. Oryginalny dokument w jego rodzimym języku powinien być uznawany za wiarygodne źródło. W przypadku informacji o kluczowym znaczeniu zaleca się skorzystanie z profesjonalnego tłumaczenia przez człowieka. Nie ponosimy odpowiedzialności za jakiekolwiek nieporozumienia lub błędne interpretacje wynikające z użycia tego tłumaczenia.