<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b8a372dfc3e3e7ad9261231a22fd79c0",
  "translation_date": "2025-07-25T10:14:02+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "sl"
}
-->
# Osnovne tehnike generativne umetne inteligence

>**Note**: To poglavje vključuje podroben [**Vodič**](./TUTORIAL.md), ki vas vodi skozi primere.

## Kaj se boste naučili
V tem poglavju bomo skozi praktične primere raziskali 4 osnovne tehnike generativne umetne inteligence:
- Zaključevanje LLM in poteki klepeta
- Klicanje funkcij
- Generacija z obogatenim iskanjem (RAG)
- Varnostni ukrepi za odgovorno uporabo umetne inteligence

## Kazalo

- [Kaj se boste naučili](../../../03-CoreGenerativeAITechniques)
- [Predpogoji](../../../03-CoreGenerativeAITechniques)
- [Začetek](../../../03-CoreGenerativeAITechniques)
- [Pregled primerov](../../../03-CoreGenerativeAITechniques)
  - [1. Zaključevanje LLM in poteki klepeta](../../../03-CoreGenerativeAITechniques)
  - [2. Funkcije in vtičniki z LLM](../../../03-CoreGenerativeAITechniques)
  - [3. Generacija z obogatenim iskanjem (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Demonstracija varnosti odgovorne umetne inteligence](../../../03-CoreGenerativeAITechniques)
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

### 1. Zaključevanje LLM in poteki klepeta
**Datoteka**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Naučite se graditi pogovorno umetno inteligenco z odzivi v realnem času in upravljanjem zgodovine klepeta.

Ta primer prikazuje:
- Preprosto zaključevanje besedila s sistemskimi pozivi
- Večkratne pogovore z upravljanjem zgodovine
- Interaktivne seje klepeta
- Konfiguracijo parametrov (temperatura, največje število tokenov)

### 2. Funkcije in vtičniki z LLM
**Datoteka**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Razširite zmogljivosti umetne inteligence z dostopom do prilagojenih funkcij in zunanjih API-jev.

Ta primer prikazuje:
- Integracijo funkcije za vreme
- Implementacijo funkcije kalkulatorja  
- Več klicev funkcij v enem pogovoru
- Definicijo funkcij z JSON shemami

### 3. Generacija z obogatenim iskanjem (RAG)
**Datoteka**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Naučite se kombinirati umetno inteligenco z lastnimi dokumenti in podatkovnimi viri za natančne, kontekstualno zavedne odgovore.

Ta primer prikazuje:
- Odgovarjanje na vprašanja na podlagi dokumentov z Azure OpenAI SDK
- Implementacijo vzorca RAG z modeli GitHub

**Uporaba**: Postavite vprašanja o vsebini v `document.txt` in pridobite odgovore umetne inteligence, ki temeljijo izključno na tem kontekstu.

### 4. Demonstracija varnosti odgovorne umetne inteligence
**Datoteka**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Pridobite vpogled v delovanje varnostnih ukrepov umetne inteligence z testiranjem zmogljivosti filtriranja vsebine modelov GitHub.

Ta primer prikazuje:
- Filtriranje vsebine za potencialno škodljive pozive
- Upravljanje varnostnih odzivov v aplikacijah
- Različne kategorije blokirane vsebine (nasilje, sovražni govor, dezinformacije)
- Pravilno obravnavanje napak pri varnostnih kršitvah

> **Več informacij**: To je le uvod v koncepte odgovorne umetne inteligence. Za več informacij o etiki, zmanjševanju pristranskosti, varovanju zasebnosti in okvirih odgovorne umetne inteligence si oglejte [Poglavje 5: Odgovorna generativna umetna inteligenca](../05-ResponsibleGenAI/README.md).

## Povzetek

V tem poglavju smo raziskali zaključevanje LLM in poteke klepeta, implementirali klicanje funkcij za razširitev zmogljivosti umetne inteligence, ustvarili sistem generacije z obogatenim iskanjem (RAG) ter demonstrirali varnostne ukrepe odgovorne umetne inteligence. 

> **NOTE**: Podrobneje raziščite s priloženim [**Vodičem**](./TUTORIAL.md)

## Naslednji koraki

[Poglavje 4: Praktične aplikacije in projekti](../04-PracticalSamples/README.md)

**Izjava o omejitvi odgovornosti**:  
Ta dokument je bil preveden z uporabo storitve za strojno prevajanje [Co-op Translator](https://github.com/Azure/co-op-translator). Čeprav si prizadevamo za natančnost, vas prosimo, da upoštevate, da lahko avtomatizirani prevodi vsebujejo napake ali netočnosti. Izvirni dokument v njegovem izvirnem jeziku je treba obravnavati kot avtoritativni vir. Za ključne informacije priporočamo profesionalni človeški prevod. Ne prevzemamo odgovornosti za morebitna nesporazumevanja ali napačne razlage, ki izhajajo iz uporabe tega prevoda.