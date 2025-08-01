<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T20:40:43+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "sk"
}
-->
# Základné techniky generatívnej AI

>**Note**: Táto kapitola obsahuje podrobný [**Návod**](./TUTORIAL.md), ktorý vás prevedie spustením hotových príkladov.

## Čo sa naučíte
V tejto kapitole sa pozrieme na 4 základné techniky generatívnej AI prostredníctvom praktických príkladov:
- Dokončovanie textu a chatovacie toky pomocou LLM
- Volanie funkcií
- Generovanie s podporou vyhľadávania (RAG)
- Bezpečnostné opatrenia pre zodpovednú AI

## Obsah

- [Čo sa naučíte](../../../03-CoreGenerativeAITechniques)
- [Predpoklady](../../../03-CoreGenerativeAITechniques)
- [Začíname](../../../03-CoreGenerativeAITechniques)
- [Prehľad príkladov](../../../03-CoreGenerativeAITechniques)
  - [1. Dokončovanie textu a chatovacie toky pomocou LLM](../../../03-CoreGenerativeAITechniques)
  - [2. Funkcie a pluginy s LLM](../../../03-CoreGenerativeAITechniques)
  - [3. Generovanie s podporou vyhľadávania (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Demonštrácia bezpečnostných opatrení pre zodpovednú AI](../../../03-CoreGenerativeAITechniques)
- [Zhrnutie](../../../03-CoreGenerativeAITechniques)
- [Ďalšie kroky](../../../03-CoreGenerativeAITechniques)

## Predpoklady

- Dokončené nastavenie z [kapitoly 2](../../../02-SetupDevEnvironment)

## Začíname

1. **Prejdite do priečinka s príkladmi**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **Nastavte prostredie**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **Skompilujte a spustite príklady**:  
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

## Prehľad príkladov

Príklady sú organizované v priečinku `examples/` s nasledujúcou štruktúrou:

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

### 1. Dokončovanie textu a chatovacie toky pomocou LLM
**Súbor**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Naučte sa vytvárať konverzačnú AI so streamovanými odpoveďami a správou histórie chatu.

Tento príklad demonštruje:
- Jednoduché dokončovanie textu pomocou systémových promptov
- Viackolové konverzácie so správou histórie
- Interaktívne chatovacie relácie
- Konfiguráciu parametrov (teplota, maximálny počet tokenov)

### 2. Funkcie a pluginy s LLM
**Súbor**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Rozšírte schopnosti AI pridaním prístupu k vlastným funkciám a externým API.

Tento príklad demonštruje:
- Integráciu funkcie počasia
- Implementáciu kalkulačky  
- Viacnásobné volania funkcií v jednej konverzácii
- Definíciu funkcií pomocou JSON schém

### 3. Generovanie s podporou vyhľadávania (RAG)
**Súbor**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Naučte sa kombinovať AI s vlastnými dokumentmi a zdrojmi dát pre presné, kontextovo relevantné odpovede.

Tento príklad demonštruje:
- Zodpovedanie otázok na základe dokumentov pomocou Azure OpenAI SDK
- Implementáciu vzoru RAG s modelmi GitHub

**Použitie**: Pýtajte sa otázky o obsahu v `document.txt` a získajte odpovede AI založené výlučne na tomto kontexte.

### 4. Demonštrácia bezpečnostných opatrení pre zodpovednú AI
**Súbor**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Získajte ukážku fungovania bezpečnostných opatrení AI testovaním schopností filtrovania obsahu modelov GitHub.

Tento príklad demonštruje:
- Filtrovanie obsahu pre potenciálne škodlivé prompty
- Spracovanie bezpečnostných odpovedí v aplikáciách
- Rôzne kategórie blokovaného obsahu (násilie, nenávistné prejavy, dezinformácie)
- Správne spracovanie chýb pri porušení bezpečnostných pravidiel

> **Viac informácií**: Toto je len úvod do konceptov zodpovednej AI. Pre viac informácií o etike, zmierňovaní zaujatosti, ochrane súkromia a rámcoch zodpovednej AI si pozrite [kapitolu 5: Zodpovedná generatívna AI](../05-ResponsibleGenAI/README.md).

## Zhrnutie

V tejto kapitole sme preskúmali dokončovanie textu a chatovacie toky pomocou LLM, implementovali volanie funkcií na rozšírenie schopností AI, vytvorili systém generovania s podporou vyhľadávania (RAG) a demonštrovali bezpečnostné opatrenia pre zodpovednú AI.

> **NOTE**: Prejdite hlbšie s poskytnutým [**Návodom**](./TUTORIAL.md)

## Ďalšie kroky

[Kap. 4: Praktické aplikácie a projekty](../04-PracticalSamples/README.md)

**Upozornenie**:  
Tento dokument bol preložený pomocou služby AI prekladu [Co-op Translator](https://github.com/Azure/co-op-translator). Aj keď sa snažíme o presnosť, prosím, berte na vedomie, že automatizované preklady môžu obsahovať chyby alebo nepresnosti. Pôvodný dokument v jeho rodnom jazyku by mal byť považovaný za autoritatívny zdroj. Pre kritické informácie sa odporúča profesionálny ľudský preklad. Nie sme zodpovední za akékoľvek nedorozumenia alebo nesprávne interpretácie vyplývajúce z použitia tohto prekladu.