<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T20:40:24+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "cs"
}
-->
# Základní techniky generativní AI

>**Poznámka**: Tato kapitola obsahuje podrobný [**Návod**](./TUTORIAL.md), který vás provede spuštěním hotových příkladů.

## Co se naučíte
V této kapitole se podíváme na 4 základní techniky generativní AI prostřednictvím praktických příkladů:
- Dokončování LLM a chatovací toky
- Volání funkcí
- Generování obohacené o vyhledávání (RAG)
- Bezpečnostní opatření pro odpovědnou AI

## Obsah

- [Co se naučíte](../../../03-CoreGenerativeAITechniques)
- [Předpoklady](../../../03-CoreGenerativeAITechniques)
- [Začínáme](../../../03-CoreGenerativeAITechniques)
- [Přehled příkladů](../../../03-CoreGenerativeAITechniques)
  - [1. Dokončování LLM a chatovací toky](../../../03-CoreGenerativeAITechniques)
  - [2. Funkce a pluginy s LLM](../../../03-CoreGenerativeAITechniques)
  - [3. Generování obohacené o vyhledávání (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Demonstrace bezpečnosti odpovědné AI](../../../03-CoreGenerativeAITechniques)
- [Shrnutí](../../../03-CoreGenerativeAITechniques)
- [Další kroky](../../../03-CoreGenerativeAITechniques)

## Předpoklady

- Dokončené nastavení z [kapitoly 2](../../../02-SetupDevEnvironment)

## Začínáme

1. **Přejděte do složky s příklady**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```
2. **Nastavte prostředí**:  
```bash
export GITHUB_TOKEN=your_token_here
```
3. **Zkompilujte a spusťte příklady**:  
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

## Přehled příkladů

Příklady jsou organizovány ve složce `examples/` s následující strukturou:

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

### 1. Dokončování LLM a chatovací toky
**Soubor**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Naučte se vytvářet konverzační AI s proudovými odpověďmi a správou historie chatu.

Tento příklad ukazuje:
- Jednoduché dokončování textu pomocí systémových promptů
- Vícekrokové konverzace se správou historie
- Interaktivní chatovací relace
- Konfiguraci parametrů (teplota, maximální počet tokenů)

### 2. Funkce a pluginy s LLM
**Soubor**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Rozšiřte schopnosti AI přidáním přístupu k vlastním funkcím a externím API.

Tento příklad ukazuje:
- Integraci funkce počasí
- Implementaci funkce kalkulačky  
- Více volání funkcí v jedné konverzaci
- Definici funkcí pomocí JSON schémat

### 3. Generování obohacené o vyhledávání (RAG)
**Soubor**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Naučte se kombinovat AI s vlastními dokumenty a datovými zdroji pro přesné a kontextově relevantní odpovědi.

Tento příklad ukazuje:
- Odpovídání na otázky na základě dokumentů pomocí Azure OpenAI SDK
- Implementaci vzoru RAG s modely GitHub

**Použití**: Ptejte se na obsah v souboru `document.txt` a získejte odpovědi AI založené pouze na tomto kontextu.

### 4. Demonstrace bezpečnosti odpovědné AI
**Soubor**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Získejte náhled na to, jak fungují bezpečnostní opatření AI, testováním schopností filtrování obsahu modelů GitHub.

Tento příklad ukazuje:
- Filtrování obsahu pro potenciálně škodlivé prompty
- Zpracování bezpečnostních odpovědí v aplikacích
- Různé kategorie blokovaného obsahu (násilí, nenávistné projevy, dezinformace)
- Správné zpracování chyb při porušení bezpečnostních pravidel

> **Další informace**: Toto je pouze úvod do konceptů odpovědné AI. Pro více informací o etice, zmírňování zaujatosti, ochraně soukromí a rámcích odpovědné AI si přečtěte [kapitolu 5: Odpovědná generativní AI](../05-ResponsibleGenAI/README.md).

## Shrnutí

V této kapitole jsme prozkoumali dokončování LLM a chatovací toky, implementovali volání funkcí pro rozšíření schopností AI, vytvořili systém Generování obohacené o vyhledávání (RAG) a demonstrovali bezpečnostní opatření odpovědné AI.

> **POZNÁMKA**: Projděte si podrobněji poskytnutý [**Návod**](./TUTORIAL.md)

## Další kroky

[Kapitola 4: Praktické aplikace a projekty](../04-PracticalSamples/README.md)

**Upozornění**:  
Tento dokument byl přeložen pomocí služby pro automatický překlad [Co-op Translator](https://github.com/Azure/co-op-translator). I když se snažíme o přesnost, mějte prosím na paměti, že automatické překlady mohou obsahovat chyby nebo nepřesnosti. Původní dokument v jeho původním jazyce by měl být považován za závazný zdroj. Pro důležité informace se doporučuje profesionální lidský překlad. Nezodpovídáme za jakékoli nedorozumění nebo nesprávné interpretace vyplývající z použití tohoto překladu.