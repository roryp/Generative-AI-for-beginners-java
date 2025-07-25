<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b8a372dfc3e3e7ad9261231a22fd79c0",
  "translation_date": "2025-07-25T10:05:18+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "ro"
}
-->
# Tehnici de bază pentru AI generativ

>**Note**: Acest capitol include un [**Tutorial**](./TUTORIAL.md) detaliat care te ghidează prin exemplele prezentate.

## Ce vei învăța
În acest capitol, vom explora 4 tehnici de bază pentru AI generativ prin exemple practice:
- Completări LLM și fluxuri de conversație
- Apelarea funcțiilor
- Generare augmentată prin recuperare (RAG)
- Măsuri de siguranță pentru AI responsabil

## Cuprins

- [Ce vei învăța](../../../03-CoreGenerativeAITechniques)
- [Prerechizite](../../../03-CoreGenerativeAITechniques)
- [Începe](../../../03-CoreGenerativeAITechniques)
- [Prezentare generală a exemplelor](../../../03-CoreGenerativeAITechniques)
  - [1. Completări LLM și fluxuri de conversație](../../../03-CoreGenerativeAITechniques)
  - [2. Funcții și pluginuri cu LLM-uri](../../../03-CoreGenerativeAITechniques)
  - [3. Generare augmentată prin recuperare (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Demonstrație de siguranță AI responsabilă](../../../03-CoreGenerativeAITechniques)
- [Rezumat](../../../03-CoreGenerativeAITechniques)
- [Pași următori](../../../03-CoreGenerativeAITechniques)

## Prerechizite

- Configurarea completă din [Capitolul 2](../../../02-SetupDevEnvironment)

## Începe

1. **Navighează la exemple**: 
```bash
cd 03-CoreGenerativeAITechniques/examples/
```
2. **Setează mediul**: 
```bash
export GITHUB_TOKEN=your_token_here
```
3. **Compilează și rulează exemplele**:
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

## Prezentare generală a exemplelor

Exemplele sunt organizate în folderul `examples/` cu următoarea structură:

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

### 1. Completări LLM și fluxuri de conversație
**Fișier**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Învață să construiești AI conversațional cu răspunsuri în streaming și gestionarea istoricului conversațiilor.

Acest exemplu demonstrează:
- Completări simple de text cu prompturi de sistem
- Conversații multi-turn cu gestionarea istoricului
- Sesiuni de chat interactive
- Configurarea parametrilor (temperatura, numărul maxim de tokeni)

### 2. Funcții și pluginuri cu LLM-uri
**Fișier**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Extinde capacitățile AI oferind modelelor acces la funcții personalizate și API-uri externe.

Acest exemplu demonstrează:
- Integrarea unei funcții de vreme
- Implementarea unei funcții de calculator  
- Apeluri multiple de funcții într-o singură conversație
- Definirea funcțiilor cu scheme JSON

### 3. Generare augmentată prin recuperare (RAG)
**Fișier**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Învață cum să combini AI cu documentele și sursele tale de date pentru răspunsuri precise și conștiente de context.

Acest exemplu demonstrează:
- Răspunsuri la întrebări bazate pe documente folosind Azure OpenAI SDK
- Implementarea modelului RAG cu GitHub Models

**Utilizare**: Pune întrebări despre conținutul din `document.txt` și primește răspunsuri AI bazate exclusiv pe acel context.

### 4. Demonstrație de siguranță AI responsabilă
**Fișier**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Obține o previzualizare a modului în care funcționează măsurile de siguranță AI testând capacitățile de filtrare a conținutului ale GitHub Models.

Acest exemplu demonstrează:
- Filtrarea conținutului pentru prompturi potențial dăunătoare
- Gestionarea răspunsurilor de siguranță în aplicații
- Diferite categorii de conținut blocat (violență, discurs de ură, dezinformare)
- Gestionarea corectă a erorilor pentru încălcările de siguranță

> **Află mai multe**: Aceasta este doar o introducere în conceptele de AI responsabil. Pentru mai multe informații despre etică, reducerea prejudecăților, considerații de confidențialitate și cadrele AI responsabile, vezi [Capitolul 5: AI Generativ Responsabil](../05-ResponsibleGenAI/README.md).

## Rezumat

În acest capitol, am explorat completările LLM și fluxurile de conversație, am implementat apelarea funcțiilor pentru a extinde capacitățile AI, am creat un sistem de Generare Augmentată prin Recuperare (RAG) și am demonstrat măsuri de siguranță AI responsabilă. 

> **NOTE**: Explorează mai în detaliu cu [**Tutorialul**](./TUTORIAL.md)

## Pași următori

[Capitolul 4: Aplicații practice și proiecte](../04-PracticalSamples/README.md)

**Declinare de responsabilitate**:  
Acest document a fost tradus folosind serviciul de traducere AI [Co-op Translator](https://github.com/Azure/co-op-translator). Deși ne străduim să asigurăm acuratețea, vă rugăm să fiți conștienți că traducerile automate pot conține erori sau inexactități. Documentul original în limba sa natală ar trebui considerat sursa autoritară. Pentru informații critice, se recomandă traducerea profesională realizată de un specialist uman. Nu ne asumăm responsabilitatea pentru eventualele neînțelegeri sau interpretări greșite care pot apărea din utilizarea acestei traduceri.