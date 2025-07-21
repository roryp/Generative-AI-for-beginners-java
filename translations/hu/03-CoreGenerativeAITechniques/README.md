<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T20:40:04+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "hu"
}
-->
# Generatív AI Alaptechnikák

>**Megjegyzés**: Ez a fejezet tartalmaz egy részletes [**Útmutatót**](./TUTORIAL.md), amely végigvezet a kész minták futtatásán.

## Amit Megtanulsz
Ebben a fejezetben 4 alapvető generatív AI technikát vizsgálunk meg gyakorlati példákon keresztül:
- LLM kiegészítések és chat folyamatok
- Funkcióhívások
- Visszakeresés-alapú generálás (RAG)
- Felelős AI biztonsági intézkedések

## Tartalomjegyzék

- [Amit Megtanulsz](../../../03-CoreGenerativeAITechniques)
- [Előfeltételek](../../../03-CoreGenerativeAITechniques)
- [Első Lépések](../../../03-CoreGenerativeAITechniques)
- [Példák Áttekintése](../../../03-CoreGenerativeAITechniques)
  - [1. LLM Kiegészítések és Chat Folyamatok](../../../03-CoreGenerativeAITechniques)
  - [2. Funkciók és Pluginok LLM-ekkel](../../../03-CoreGenerativeAITechniques)
  - [3. Visszakeresés-Alapú Generálás (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Felelős AI Biztonsági Bemutató](../../../03-CoreGenerativeAITechniques)
- [Összefoglalás](../../../03-CoreGenerativeAITechniques)
- [Következő Lépések](../../../03-CoreGenerativeAITechniques)

## Előfeltételek

- A [2. fejezetben](../../../02-SetupDevEnvironment) leírt beállítások elvégzése

## Első Lépések

1. **Navigálj a példákhoz**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **Állítsd be a környezetet**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **Fordítsd le és futtasd a példákat**:  
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

## Példák Áttekintése

A példák az `examples/` mappában találhatók az alábbi struktúrával:

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

### 1. LLM Kiegészítések és Chat Folyamatok
**Fájl**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Tanuld meg, hogyan építs beszélgetési AI-t streaming válaszokkal és chat történetkezeléssel.

Ez a példa bemutatja:
- Egyszerű szövegkiegészítést rendszerüzenetekkel
- Többfordulós beszélgetéseket történetkezeléssel
- Interaktív chat szekciókat
- Paraméterek konfigurálását (hőmérséklet, maximális tokenek)

### 2. Funkciók és Pluginok LLM-ekkel
**Fájl**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Bővítsd az AI képességeit egyedi funkciók és külső API-k integrálásával.

Ez a példa bemutatja:
- Időjárás funkció integrációját
- Számológép funkció implementációját  
- Több funkcióhívást egy beszélgetésen belül
- Funkciók definiálását JSON sémákkal

### 3. Visszakeresés-Alapú Generálás (RAG)
**Fájl**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Tanuld meg, hogyan kombináld az AI-t saját dokumentumaiddal és adatforrásaiddal a pontos, kontextusfüggő válaszok érdekében.

Ez a példa bemutatja:
- Dokumentum-alapú kérdés-válasz rendszert az Azure OpenAI SDK-val
- RAG mintázat implementációját GitHub Modellekkel

**Használat**: Tegyél fel kérdéseket a `document.txt` tartalmával kapcsolatban, és kapj AI válaszokat kizárólag annak kontextusára alapozva.

### 4. Felelős AI Biztonsági Bemutató
**Fájl**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Kapj betekintést az AI biztonsági intézkedések működésébe a GitHub Modellek tartalomszűrési képességeinek tesztelésével.

Ez a példa bemutatja:
- Tartalomszűrést potenciálisan káros üzenetek esetén
- Biztonsági válaszok kezelését alkalmazásokban
- Különböző blokkolt tartalomkategóriákat (erőszak, gyűlöletbeszéd, félretájékoztatás)
- Megfelelő hibakezelést biztonsági szabálysértések esetén

> **További Információ**: Ez csak egy bevezető a felelős AI koncepciókhoz. További információért az etikáról, elfogultság csökkentéséről, adatvédelemről és felelős AI keretrendszerekről lásd [5. fejezet: Felelős Generatív AI](../05-ResponsibleGenAI/README.md).

## Összefoglalás

Ebben a fejezetben megvizsgáltuk az LLM kiegészítéseket és chat folyamatokat, implementáltuk a funkcióhívásokat az AI képességek bővítésére, létrehoztunk egy Visszakeresés-Alapú Generálás (RAG) rendszert, és bemutattuk a felelős AI biztonsági intézkedéseket.

> **MEGJEGYZÉS**: Mélyedj el a mellékelt [**Útmutatóban**](./TUTORIAL.md).

## Következő Lépések

[4. fejezet: Gyakorlati Alkalmazások és Projektek](../04-PracticalSamples/README.md)

**Felelősség kizárása**:  
Ez a dokumentum az AI fordítási szolgáltatás [Co-op Translator](https://github.com/Azure/co-op-translator) segítségével lett lefordítva. Bár törekszünk a pontosságra, kérjük, vegye figyelembe, hogy az automatikus fordítások hibákat vagy pontatlanságokat tartalmazhatnak. Az eredeti dokumentum az eredeti nyelvén tekintendő hiteles forrásnak. Fontos információk esetén javasolt professzionális emberi fordítást igénybe venni. Nem vállalunk felelősséget semmilyen félreértésért vagy téves értelmezésért, amely a fordítás használatából eredhet.