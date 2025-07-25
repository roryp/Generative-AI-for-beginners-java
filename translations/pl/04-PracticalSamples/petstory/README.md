<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T09:27:34+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "pl"
}
-->
# Aplikacja Pet Story

>**Note**: Ten rozdział zawiera [**Samouczek**](./TUTORIAL.md), który przeprowadzi Cię przez przykłady.

Aplikacja webowa oparta na Spring Boot, która generuje opisy i historie oparte na AI dla przesłanych zdjęć zwierząt, wykorzystując modele GitHub.

## Spis Treści

- [Stos Technologiczny](../../../../04-PracticalSamples/petstory)
- [Wymagania Wstępne](../../../../04-PracticalSamples/petstory)
- [Konfiguracja i Instalacja](../../../../04-PracticalSamples/petstory)
- [Użytkowanie](../../../../04-PracticalSamples/petstory)

## Stos Technologiczny

- **Backend**: Spring Boot 3.5.3, Java 21
- **Integracja AI**: OpenAI Java SDK z modelami GitHub
- **Bezpieczeństwo**: Spring Security
- **Frontend**: Szablony Thymeleaf ze stylami Bootstrap
- **Narzędzie Budowania**: Maven
- **Modele AI**: Modele GitHub

## Wymagania Wstępne

- Java 21 lub nowsza
- Maven 3.9+
- Osobisty token dostępu do GitHub z zakresem `models:read`

## Konfiguracja i Instalacja

### 1. Przejdź do katalogu aplikacji petstory
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Ustaw zmienną środowiskową
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Zbuduj aplikację
```bash
mvn clean compile
```

### 4. Uruchom aplikację
```bash
mvn spring-boot:run
```

## Użytkowanie

1. **Dostęp do aplikacji**: Przejdź do `http://localhost:8080`
2. **Prześlij obraz**: Kliknij "Wybierz plik" i wybierz zdjęcie zwierzęcia
3. **Analizuj obraz**: Kliknij "Analizuj obraz", aby uzyskać opis AI
4. **Generuj historię**: Kliknij "Generuj historię", aby stworzyć opowieść

**Zastrzeżenie**:  
Ten dokument został przetłumaczony za pomocą usługi tłumaczenia AI [Co-op Translator](https://github.com/Azure/co-op-translator). Chociaż dokładamy wszelkich starań, aby tłumaczenie było precyzyjne, prosimy pamiętać, że automatyczne tłumaczenia mogą zawierać błędy lub nieścisłości. Oryginalny dokument w jego rodzimym języku powinien być uznawany za autorytatywne źródło. W przypadku informacji o kluczowym znaczeniu zaleca się skorzystanie z profesjonalnego tłumaczenia przez człowieka. Nie ponosimy odpowiedzialności za jakiekolwiek nieporozumienia lub błędne interpretacje wynikające z użycia tego tłumaczenia.