<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b8a372dfc3e3e7ad9261231a22fd79c0",
  "translation_date": "2025-07-25T10:00:54+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "cs"
}
-->
# Základní techniky generativní AI

>**Poznámka**: Tato kapitola obsahuje podrobný [**tutoriál**](./TUTORIAL.md), který vás provede ukázkami.

## Co se naučíte
V této kapitole se podíváme na 4 základní techniky generativní AI prostřednictvím praktických příkladů:
- Dokončování LLM a chatovací toky
- Volání funkcí
- Generování s podporou vyhledávání (RAG)
- Bezpečnostní opatření pro odpovědnou AI

## Obsah

- [Co se naučíte](../../../03-CoreGenerativeAITechniques)
- [Předpoklady](../../../03-CoreGenerativeAITechniques)
- [Začínáme](../../../03-CoreGenerativeAITechniques)
- [Přehled příkladů](../../../03-CoreGenerativeAITechniques)
  - [1. Dokončování LLM a chatovací toky](../../../03-CoreGenerativeAITechniques)
  - [2. Funkce a pluginy s LLM](../../../03-CoreGenerativeAITechniques)
  - [3. Generování s podporou vyhledávání (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Ukázka bezpečnosti odpovědné AI](../../../03-CoreGenerativeAITechniques)
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

Příklady jsou uspořádány ve složce `examples/` s následující strukturou:

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

Naučte se vytvářet konverzační AI s využitím streamovaných odpovědí a správy historie chatu.

Tento příklad ukazuje:
- Jednoduché dokončování textu pomocí systémových promptů
- Vícekrokové konverzace se správou historie
- Interaktivní chatovací relace
- Konfiguraci parametrů (teplota, maximální počet tokenů)

### 2. Funkce a pluginy s LLM
**Soubor**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Rozšiřte schopnosti AI přidáním přístupu k vlastním funkcím a externím API.

Tento příklad ukazuje:
- Integraci funkce pro počasí
- Implementaci funkce kalkulačky  
- Vícenásobné volání funkcí v jedné konverzaci
- Definici funkcí pomocí JSON schémat

### 3. Generování s podporou vyhledávání (RAG)
**Soubor**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Naučte se kombinovat AI s vlastními dokumenty a datovými zdroji pro přesné a kontextově relevantní odpovědi.

Tento příklad ukazuje:
- Odpovídání na otázky na základě dokumentů pomocí Azure OpenAI SDK
- Implementaci vzoru RAG s modely GitHub

**Použití**: Ptejte se na obsah v souboru `document.txt` a získávejte odpovědi AI založené pouze na tomto kontextu.

### 4. Ukázka bezpečnosti odpovědné AI
**Soubor**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Získejte přehled o tom, jak fungují bezpečnostní opatření AI, testováním schopností filtrování obsahu modelů GitHub.

Tento příklad ukazuje:
- Filtrování obsahu pro potenciálně škodlivé prompty
- Zpracování bezpečnostních odpovědí v aplikacích
- Různé kategorie blokovaného obsahu (násilí, nenávistné projevy, dezinformace)
- Správné zpracování chyb při porušení bezpečnostních pravidel

> **Zjistěte více**: Toto je pouze úvod do konceptů odpovědné AI. Další informace o etice, zmírňování předsudků, ochraně soukromí a rámcích odpovědné AI naleznete v [kapitole 5: Odpovědná generativní AI](../05-ResponsibleGenAI/README.md).

## Shrnutí

V této kapitole jsme prozkoumali dokončování LLM a chatovací toky, implementovali volání funkcí pro rozšíření schopností AI, vytvořili systém generování s podporou vyhledávání (RAG) a předvedli bezpečnostní opatření odpovědné AI.

> **Poznámka**: Podrobněji se ponořte do poskytnutého [**tutoriálu**](./TUTORIAL.md)

## Další kroky

[Kap. 4: Praktické aplikace a projekty](../04-PracticalSamples/README.md)

**Prohlášení:**  
Tento dokument byl přeložen pomocí služby pro automatický překlad [Co-op Translator](https://github.com/Azure/co-op-translator). Ačkoli se snažíme o přesnost, mějte na paměti, že automatické překlady mohou obsahovat chyby nebo nepřesnosti. Původní dokument v jeho původním jazyce by měl být považován za autoritativní zdroj. Pro důležité informace doporučujeme profesionální lidský překlad. Neodpovídáme za žádná nedorozumění nebo nesprávné interpretace vyplývající z použití tohoto překladu.