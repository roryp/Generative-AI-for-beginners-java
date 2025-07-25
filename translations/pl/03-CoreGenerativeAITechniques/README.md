<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b8a372dfc3e3e7ad9261231a22fd79c0",
  "translation_date": "2025-07-25T09:26:06+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "pl"
}
-->
# Podstawowe Techniki Generatywnej Sztucznej Inteligencji

>**Note**: Ten rozdział zawiera szczegółowy [**Samouczek**](./TUTORIAL.md), który przeprowadzi Cię przez przykłady.

## Czego się nauczysz
W tym rozdziale omówimy 4 podstawowe techniki generatywnej sztucznej inteligencji na praktycznych przykładach:
- Uzupełnianie LLM i przepływy rozmów
- Wywoływanie funkcji
- Generowanie wspomagane wyszukiwaniem (RAG)
- Środki bezpieczeństwa odpowiedzialnej AI

## Spis treści

- [Czego się nauczysz](../../../03-CoreGenerativeAITechniques)
- [Wymagania wstępne](../../../03-CoreGenerativeAITechniques)
- [Pierwsze kroki](../../../03-CoreGenerativeAITechniques)
- [Przegląd przykładów](../../../03-CoreGenerativeAITechniques)
  - [1. Uzupełnianie LLM i przepływy rozmów](../../../03-CoreGenerativeAITechniques)
  - [2. Funkcje i wtyczki z LLM](../../../03-CoreGenerativeAITechniques)
  - [3. Generowanie wspomagane wyszukiwaniem (RAG)](../../../03-CoreGenerativeAITechniques)
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

Przykłady są zorganizowane w folderze `examples/` w następującej strukturze:

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

### 1. Uzupełnianie LLM i przepływy rozmów
**Plik**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Naucz się budować konwersacyjną AI z odpowiedziami strumieniowymi i zarządzaniem historią rozmów.

Ten przykład pokazuje:
- Proste uzupełnianie tekstu z użyciem systemowych podpowiedzi
- Rozmowy wieloetapowe z zarządzaniem historią
- Interaktywne sesje czatu
- Konfigurację parametrów (temperatura, maksymalna liczba tokenów)

### 2. Funkcje i wtyczki z LLM
**Plik**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Rozszerz możliwości AI, dając modelom dostęp do niestandardowych funkcji i zewnętrznych API.

Ten przykład pokazuje:
- Integrację funkcji pogodowej
- Implementację funkcji kalkulatora  
- Wiele wywołań funkcji w jednej rozmowie
- Definicję funkcji z użyciem schematów JSON

### 3. Generowanie wspomagane wyszukiwaniem (RAG)
**Plik**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Dowiedz się, jak łączyć AI z własnymi dokumentami i źródłami danych, aby uzyskać dokładne, kontekstowe odpowiedzi.

Ten przykład pokazuje:
- Odpowiadanie na pytania na podstawie dokumentów z użyciem Azure OpenAI SDK
- Implementację wzorca RAG z modelami GitHub

**Zastosowanie**: Zadawaj pytania dotyczące treści w `document.txt` i otrzymuj odpowiedzi AI wyłącznie na podstawie tego kontekstu.

### 4. Demonstracja bezpieczeństwa odpowiedzialnej AI
**Plik**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Zobacz, jak działają środki bezpieczeństwa AI, testując możliwości filtrowania treści w modelach GitHub.

Ten przykład pokazuje:
- Filtrowanie treści dla potencjalnie szkodliwych podpowiedzi
- Obsługę odpowiedzi bezpieczeństwa w aplikacjach
- Różne kategorie blokowanych treści (przemoc, mowa nienawiści, dezinformacja)
- Prawidłowe obsługiwanie błędów związanych z naruszeniami bezpieczeństwa

> **Dowiedz się więcej**: To tylko wprowadzenie do koncepcji odpowiedzialnej AI. Aby uzyskać więcej informacji na temat etyki, łagodzenia uprzedzeń, kwestii prywatności i ram odpowiedzialnej AI, zobacz [Rozdział 5: Odpowiedzialna Generatywna AI](../05-ResponsibleGenAI/README.md).

## Podsumowanie

W tym rozdziale omówiliśmy uzupełnianie LLM i przepływy rozmów, wdrożyliśmy wywoływanie funkcji w celu rozszerzenia możliwości AI, stworzyliśmy system Generowania Wspomaganego Wyszukiwaniem (RAG) oraz zaprezentowaliśmy środki bezpieczeństwa odpowiedzialnej AI.

> **NOTE**: Zgłębiaj temat dzięki dostarczonemu [**Samouczkowi**](./TUTORIAL.md)

## Kolejne kroki

[Rozdział 4: Praktyczne Zastosowania i Projekty](../04-PracticalSamples/README.md)

**Zastrzeżenie**:  
Ten dokument został przetłumaczony za pomocą usługi tłumaczenia AI [Co-op Translator](https://github.com/Azure/co-op-translator). Chociaż dokładamy wszelkich starań, aby tłumaczenie było precyzyjne, prosimy pamiętać, że automatyczne tłumaczenia mogą zawierać błędy lub nieścisłości. Oryginalny dokument w jego rodzimym języku powinien być uznawany za autorytatywne źródło. W przypadku informacji o kluczowym znaczeniu zaleca się skorzystanie z profesjonalnego tłumaczenia przez człowieka. Nie ponosimy odpowiedzialności za jakiekolwiek nieporozumienia lub błędne interpretacje wynikające z użycia tego tłumaczenia.