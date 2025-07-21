<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T16:03:19+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "pl"
}
-->
# Podstawowe techniki generatywnej AI

>**Note**: Ten rozdział zawiera szczegółowy [**Samouczek**](./TUTORIAL.md), który przeprowadzi Cię przez uruchamianie gotowych przykładów.

## Czego się nauczysz
W tym rozdziale przyjrzymy się 4 podstawowym technikom generatywnej AI poprzez praktyczne przykłady:
- Uzupełnienia LLM i przepływy rozmów
- Wywoływanie funkcji
- Generacja wspomagana wyszukiwaniem (RAG)
- Środki bezpieczeństwa odpowiedzialnej AI

## Spis treści

- [Czego się nauczysz](../../../03-CoreGenerativeAITechniques)
- [Wymagania wstępne](../../../03-CoreGenerativeAITechniques)
- [Pierwsze kroki](../../../03-CoreGenerativeAITechniques)
- [Przegląd przykładów](../../../03-CoreGenerativeAITechniques)
  - [1. Uzupełnienia LLM i przepływy rozmów](../../../03-CoreGenerativeAITechniques)
  - [2. Funkcje i wtyczki z LLM](../../../03-CoreGenerativeAITechniques)
  - [3. Generacja wspomagana wyszukiwaniem (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Demonstracja bezpieczeństwa odpowiedzialnej AI](../../../03-CoreGenerativeAITechniques)
- [Podsumowanie](../../../03-CoreGenerativeAITechniques)
- [Kolejne kroki](../../../03-CoreGenerativeAITechniques)

## Wymagania wstępne

- Ukończona konfiguracja z [Rozdziału 2](../../../02-SetupDevEnvironment)

## Pierwsze kroki

1. **Przejdź do przykładów**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **Ustaw środowisko**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **Skompiluj i uruchom przykłady**:  
```bash
   # Run completions example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
   
   # Run functions example  
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
   
   # Run RAG example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
   
   # Run responsible AI demo
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
   ```  

## Przegląd przykładów

Przykłady są zorganizowane w folderze `examples/` według następującej struktury:

```
examples/
├── src/main/java/com/example/genai/techniques/
│   ├── completions/
│   │   └── LLMCompletionsApp.java        # Basic completions 
│   ├── functions/
│   │   └── FunctionsApp.java             # Function calling examples
│   ├── rag/
│   │   └── SimpleReaderDemo.java         # Retrieval-Augmented Generation
│   └── responsibleai/
│       └── ResponsibleGithubModels.java  # Responsible AI safety demonstration
├── document.txt                          # Sample document for RAG example
└── pom.xml                               # Maven configuration
```

### 1. Uzupełnienia LLM i przepływy rozmów
**Plik**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Dowiedz się, jak budować konwersacyjną AI z odpowiedziami strumieniowymi i zarządzaniem historią rozmów.

Ten przykład pokazuje:
- Proste uzupełnianie tekstu z systemowymi podpowiedziami
- Wieloetapowe rozmowy z zarządzaniem historią
- Interaktywne sesje czatu
- Konfigurację parametrów (temperatura, maksymalna liczba tokenów)

### 2. Funkcje i wtyczki z LLM
**Plik**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Rozszerz możliwości AI, dając modelom dostęp do niestandardowych funkcji i zewnętrznych API.

Ten przykład pokazuje:
- Integrację funkcji pogodowych
- Implementację funkcji kalkulatora  
- Wielokrotne wywołania funkcji w jednej rozmowie
- Definicję funkcji z użyciem schematów JSON

### 3. Generacja wspomagana wyszukiwaniem (RAG)
**Plik**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Dowiedz się, jak połączyć AI z własnymi dokumentami i źródłami danych, aby uzyskać precyzyjne, kontekstowe odpowiedzi.

Ten przykład pokazuje:
- Odpowiadanie na pytania na podstawie dokumentów z użyciem Azure OpenAI SDK
- Implementację wzorca RAG z modelami GitHub

**Zastosowanie**: Zadawaj pytania dotyczące treści w `document.txt` i otrzymuj odpowiedzi AI oparte wyłącznie na tym kontekście.

### 4. Demonstracja bezpieczeństwa odpowiedzialnej AI
**Plik**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Zobacz, jak działają środki bezpieczeństwa AI, testując możliwości filtrowania treści w modelach GitHub.

Ten przykład pokazuje:
- Filtrowanie treści dla potencjalnie szkodliwych podpowiedzi
- Obsługę odpowiedzi związanych z bezpieczeństwem w aplikacjach
- Różne kategorie blokowanych treści (przemoc, mowa nienawiści, dezinformacja)
- Poprawne obsługiwanie błędów związanych z naruszeniami bezpieczeństwa

> **Dowiedz się więcej**: To tylko wprowadzenie do koncepcji odpowiedzialnej AI. Aby uzyskać więcej informacji na temat etyki, ograniczania uprzedzeń, kwestii prywatności i ram odpowiedzialnej AI, zobacz [Rozdział 5: Odpowiedzialna generatywna AI](../05-ResponsibleGenAI/README.md).

## Podsumowanie

W tym rozdziale przyjrzeliśmy się uzupełnieniom LLM i przepływom rozmów, wdrożyliśmy wywoływanie funkcji w celu rozszerzenia możliwości AI, stworzyliśmy system Generacji Wspomaganej Wyszukiwaniem (RAG) oraz zademonstrowaliśmy środki bezpieczeństwa odpowiedzialnej AI.

> **NOTE**: Zgłębiaj temat dzięki dostarczonemu [**Samouczkowi**](./TUTORIAL.md)

## Kolejne kroki

[Rozdział 4: Praktyczne zastosowania i projekty](../04-PracticalSamples/README.md)

**Zastrzeżenie**:  
Ten dokument został przetłumaczony za pomocą usługi tłumaczenia AI [Co-op Translator](https://github.com/Azure/co-op-translator). Chociaż dokładamy wszelkich starań, aby tłumaczenie było precyzyjne, prosimy pamiętać, że automatyczne tłumaczenia mogą zawierać błędy lub nieścisłości. Oryginalny dokument w jego rodzimym języku powinien być uznawany za wiarygodne źródło. W przypadku informacji o kluczowym znaczeniu zaleca się skorzystanie z profesjonalnego tłumaczenia przez człowieka. Nie ponosimy odpowiedzialności za jakiekolwiek nieporozumienia lub błędne interpretacje wynikające z użycia tego tłumaczenia.