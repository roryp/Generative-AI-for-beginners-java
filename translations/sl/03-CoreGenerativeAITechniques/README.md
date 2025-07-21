<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T20:42:13+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "sl"
}
-->
# Osnovne tehnike generativne umetne inteligence

>**Opomba**: To poglavje vključuje podroben [**Vodič**](./TUTORIAL.md), ki vas korak za korakom vodi skozi zagon končnih primerov.

## Kaj se boste naučili
V tem poglavju bomo skozi praktične primere raziskali 4 osnovne tehnike generativne umetne inteligence:
- Dokončevanje z LLM in pogovorni tokovi
- Klicanje funkcij
- Generacija z dopolnitvijo pridobljenih podatkov (RAG)
- Varnostni ukrepi za odgovorno uporabo umetne inteligence

## Kazalo

- [Kaj se boste naučili](../../../03-CoreGenerativeAITechniques)
- [Predpogoji](../../../03-CoreGenerativeAITechniques)
- [Začetek](../../../03-CoreGenerativeAITechniques)
- [Pregled primerov](../../../03-CoreGenerativeAITechniques)
  - [1. Dokončevanje z LLM in pogovorni tokovi](../../../03-CoreGenerativeAITechniques)
  - [2. Funkcije in vtičniki z LLM](../../../03-CoreGenerativeAITechniques)
  - [3. Generacija z dopolnitvijo pridobljenih podatkov (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Demonstracija varnostnih ukrepov za odgovorno uporabo umetne inteligence](../../../03-CoreGenerativeAITechniques)
- [Povzetek](../../../03-CoreGenerativeAITechniques)
- [Naslednji koraki](../../../03-CoreGenerativeAITechniques)

## Predpogoji

- Zaključena nastavitev iz [Poglavja 2](../../../02-SetupDevEnvironment)

## Začetek

1. **Pomaknite se do primerov**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **Nastavite okolje**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **Prevedite in zaženite primere**:  
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

## Pregled primerov

Primeri so organizirani v mapi `examples/` z naslednjo strukturo:

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

### 1. Dokončevanje z LLM in pogovorni tokovi
**Datoteka**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Naučite se graditi pogovorno umetno inteligenco z odzivi v realnem času in upravljanjem zgodovine pogovorov.

Ta primer prikazuje:
- Preprosto dokončevanje besedila s sistemskimi pozivi
- Večkratne pogovore z upravljanjem zgodovine
- Interaktivne pogovorne seje
- Konfiguracijo parametrov (temperature, največje število tokenov)

### 2. Funkcije in vtičniki z LLM
**Datoteka**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Razširite zmogljivosti umetne inteligence z omogočanjem dostopa do prilagojenih funkcij in zunanjih API-jev.

Ta primer prikazuje:
- Integracijo funkcije za vreme
- Implementacijo funkcije kalkulatorja  
- Več klicev funkcij v enem pogovoru
- Definicijo funkcij z uporabo JSON shem

### 3. Generacija z dopolnitvijo pridobljenih podatkov (RAG)
**Datoteka**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Naučite se kombinirati umetno inteligenco z lastnimi dokumenti in viri podatkov za natančne in kontekstualno ustrezne odgovore.

Ta primer prikazuje:
- Odgovarjanje na vprašanja na podlagi dokumentov z uporabo Azure OpenAI SDK
- Implementacijo vzorca RAG z modeli GitHub

**Uporaba**: Postavite vprašanja o vsebini v `document.txt` in prejmite odgovore umetne inteligence, ki temeljijo izključno na tem kontekstu.

### 4. Demonstracija varnostnih ukrepov za odgovorno uporabo umetne inteligence
**Datoteka**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Oglejte si, kako delujejo varnostni ukrepi umetne inteligence, tako da preizkusite zmogljivosti filtriranja vsebine modelov GitHub.

Ta primer prikazuje:
- Filtriranje vsebine za potencialno škodljive pozive
- Upravljanje varnostnih odzivov v aplikacijah
- Različne kategorije blokirane vsebine (nasilje, sovražni govor, dezinformacije)
- Pravilno obravnavo napak pri varnostnih kršitvah

> **Več informacij**: To je le uvod v koncepte odgovorne umetne inteligence. Za več informacij o etiki, zmanjševanju pristranskosti, varovanju zasebnosti in okvirih za odgovorno uporabo umetne inteligence si oglejte [Poglavje 5: Odgovorna generativna umetna inteligenca](../05-ResponsibleGenAI/README.md).

## Povzetek

V tem poglavju smo raziskali dokončevanje z LLM in pogovorne tokove, implementirali klicanje funkcij za razširitev zmogljivosti umetne inteligence, ustvarili sistem za generacijo z dopolnitvijo pridobljenih podatkov (RAG) in prikazali varnostne ukrepe za odgovorno uporabo umetne inteligence.

> **OPOMBA**: Podrobneje raziščite s priloženim [**Vodičem**](./TUTORIAL.md)

## Naslednji koraki

[Poglavje 4: Praktične aplikacije in projekti](../04-PracticalSamples/README.md)

**Omejitev odgovornosti**:  
Ta dokument je bil preveden z uporabo storitve AI za prevajanje [Co-op Translator](https://github.com/Azure/co-op-translator). Čeprav si prizadevamo za natančnost, vas prosimo, da upoštevate, da lahko avtomatizirani prevodi vsebujejo napake ali netočnosti. Izvirni dokument v njegovem izvirnem jeziku je treba obravnavati kot avtoritativni vir. Za ključne informacije priporočamo profesionalni človeški prevod. Ne odgovarjamo za morebitne nesporazume ali napačne razlage, ki bi nastale zaradi uporabe tega prevoda.