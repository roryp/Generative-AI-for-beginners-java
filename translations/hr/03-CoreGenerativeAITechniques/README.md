<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T20:41:58+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "hr"
}
-->
# Osnovne tehnike generativne umjetne inteligencije

>**Napomena**: Ovo poglavlje uključuje detaljan [**Vodič**](./TUTORIAL.md) koji vas vodi kroz pokretanje gotovih primjera.

## Što ćete naučiti
U ovom poglavlju istražujemo 4 osnovne tehnike generativne umjetne inteligencije kroz praktične primjere:
- Završetke LLM-a i tokove razgovora
- Pozivanje funkcija
- Generiranje uz prošireno pretraživanje (RAG)
- Sigurnosne mjere odgovorne umjetne inteligencije

## Sadržaj

- [Što ćete naučiti](../../../03-CoreGenerativeAITechniques)
- [Preduvjeti](../../../03-CoreGenerativeAITechniques)
- [Početak rada](../../../03-CoreGenerativeAITechniques)
- [Pregled primjera](../../../03-CoreGenerativeAITechniques)
  - [1. Završetci LLM-a i tokovi razgovora](../../../03-CoreGenerativeAITechniques)
  - [2. Funkcije i dodaci s LLM-ovima](../../../03-CoreGenerativeAITechniques)
  - [3. Generiranje uz prošireno pretraživanje (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Demonstracija sigurnosnih mjera odgovorne umjetne inteligencije](../../../03-CoreGenerativeAITechniques)
- [Sažetak](../../../03-CoreGenerativeAITechniques)
- [Sljedeći koraci](../../../03-CoreGenerativeAITechniques)

## Preduvjeti

- Završena postavka iz [Poglavlja 2](../../../02-SetupDevEnvironment)

## Početak rada

1. **Navigirajte do primjera**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **Postavite okruženje**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **Kompilirajte i pokrenite primjere**:  
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

## Pregled primjera

Primjeri su organizirani u mapi `examples/` sa sljedećom strukturom:

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

### 1. Završetci LLM-a i tokovi razgovora
**Datoteka**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Naučite kako izgraditi konverzacijsku umjetnu inteligenciju s odgovorima u stvarnom vremenu i upravljanjem povijesti razgovora.

Ovaj primjer pokazuje:
- Jednostavno dovršavanje teksta uz sistemske upute
- Višekratne razgovore s upravljanjem povijesti
- Interaktivne sesije razgovora
- Konfiguraciju parametara (temperatura, maksimalan broj tokena)

### 2. Funkcije i dodaci s LLM-ovima
**Datoteka**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Proširite mogućnosti umjetne inteligencije omogućujući modelima pristup prilagođenim funkcijama i vanjskim API-jevima.

Ovaj primjer pokazuje:
- Integraciju funkcije za vremensku prognozu
- Implementaciju funkcije kalkulatora  
- Višestruke pozive funkcija u jednom razgovoru
- Definiciju funkcija pomoću JSON shema

### 3. Generiranje uz prošireno pretraživanje (RAG)
**Datoteka**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Naučite kako kombinirati umjetnu inteligenciju s vlastitim dokumentima i izvorima podataka za točne, kontekstualne odgovore.

Ovaj primjer pokazuje:
- Odgovaranje na pitanja temeljena na dokumentima uz Azure OpenAI SDK
- Implementaciju RAG uz GitHub modele

**Upotreba**: Postavite pitanja o sadržaju u `document.txt` i dobijte odgovore umjetne inteligencije temeljene isključivo na tom kontekstu.

### 4. Demonstracija sigurnosnih mjera odgovorne umjetne inteligencije
**Datoteka**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Dobijte pregled kako sigurnosne mjere umjetne inteligencije funkcioniraju testiranjem sposobnosti filtriranja sadržaja GitHub modela.

Ovaj primjer pokazuje:
- Filtriranje sadržaja za potencijalno štetne upite
- Upravljanje sigurnosnim odgovorima u aplikacijama
- Različite kategorije blokiranog sadržaja (nasilje, govor mržnje, dezinformacije)
- Ispravno rukovanje pogreškama kod kršenja sigurnosnih mjera

> **Saznajte više**: Ovo je samo uvod u koncepte odgovorne umjetne inteligencije. Za više informacija o etici, ublažavanju pristranosti, razmatranjima privatnosti i okvirima odgovorne umjetne inteligencije, pogledajte [Poglavlje 5: Odgovorna generativna umjetna inteligencija](../05-ResponsibleGenAI/README.md).

## Sažetak

U ovom poglavlju istražili smo završetke LLM-a i tokove razgovora, implementirali pozivanje funkcija za proširenje mogućnosti umjetne inteligencije, kreirali sustav generiranja uz prošireno pretraživanje (RAG) i demonstrirali sigurnosne mjere odgovorne umjetne inteligencije.

> **NAPOMENA**: Dublje istražite uz priloženi [**Vodič**](./TUTORIAL.md)

## Sljedeći koraci

[Poglavlje 4: Praktične primjene i projekti](../04-PracticalSamples/README.md)

**Odricanje od odgovornosti**:  
Ovaj dokument je preveden pomoću AI usluge za prevođenje [Co-op Translator](https://github.com/Azure/co-op-translator). Iako nastojimo osigurati točnost, imajte na umu da automatski prijevodi mogu sadržavati pogreške ili netočnosti. Izvorni dokument na izvornom jeziku treba smatrati autoritativnim izvorom. Za kritične informacije preporučuje se profesionalni prijevod od strane čovjeka. Ne preuzimamo odgovornost za nesporazume ili pogrešna tumačenja koja mogu proizaći iz korištenja ovog prijevoda.