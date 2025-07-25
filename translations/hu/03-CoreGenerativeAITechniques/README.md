<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b8a372dfc3e3e7ad9261231a22fd79c0",
  "translation_date": "2025-07-25T09:58:24+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "hu"
}
-->
# Generatív AI Alapvető Technikák

>**Megjegyzés**: Ez a fejezet tartalmaz egy részletes [**Útmutatót**](./TUTORIAL.md), amely végigvezet a példákon.

## Amit Megtanulsz
Ebben a fejezetben 4 alapvető generatív AI technikát vizsgálunk meg gyakorlati példákon keresztül:
- LLM kiegészítések és csevegési folyamatok
- Funkcióhívások
- Visszakeresés-alapú generálás (RAG)
- Felelős AI biztonsági intézkedések

## Tartalomjegyzék

- [Amit Megtanulsz](../../../03-CoreGenerativeAITechniques)
- [Előfeltételek](../../../03-CoreGenerativeAITechniques)
- [Első Lépések](../../../03-CoreGenerativeAITechniques)
- [Példák Áttekintése](../../../03-CoreGenerativeAITechniques)
  - [1. LLM Kiegészítések és Csevegési Folyamatok](../../../03-CoreGenerativeAITechniques)
  - [2. Funkciók és Pluginok LLM-ekkel](../../../03-CoreGenerativeAITechniques)
  - [3. Visszakeresés-Alapú Generálás (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Felelős AI Biztonsági Bemutató](../../../03-CoreGenerativeAITechniques)
- [Összefoglalás](../../../03-CoreGenerativeAITechniques)
- [Következő Lépések](../../../03-CoreGenerativeAITechniques)

## Előfeltételek

- A [2. fejezetben](../../../02-SetupDevEnvironment) ismertetett beállítások elvégzése

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

A példák az `examples/` mappában találhatók a következő struktúrával:

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

### 1. LLM Kiegészítések és Csevegési Folyamatok
**Fájl**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Tanuld meg, hogyan építs beszélgető AI-t streaming válaszokkal és csevegési előzmények kezelésével.

Ez a példa bemutatja:
- Egyszerű szövegkiegészítést rendszerszintű utasításokkal
- Többfordulós beszélgetéseket előzménykezeléssel
- Interaktív csevegési munkameneteket
- Paraméterek konfigurálását (hőmérséklet, maximális tokenek)

### 2. Funkciók és Pluginok LLM-ekkel
**Fájl**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Bővítsd az AI képességeit egyedi funkciók és külső API-k integrálásával.

Ez a példa bemutatja:
- Időjárás-funkció integrációját
- Számológép-funkció megvalósítását  
- Több funkcióhívást egy beszélgetésen belül
- Funkciódefiníciókat JSON sémákkal

### 3. Visszakeresés-Alapú Generálás (RAG)
**Fájl**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Tanuld meg, hogyan kombinálhatod az AI-t saját dokumentumaiddal és adatforrásaiddal a pontos, kontextusfüggő válaszok érdekében.

Ez a példa bemutatja:
- Dokumentumalapú kérdés-válasz rendszert az Azure OpenAI SDK-val
- RAG minta megvalósítását GitHub Modellek segítségével

**Használat**: Tegyél fel kérdéseket a `document.txt` tartalmával kapcsolatban, és kapj AI válaszokat kizárólag az adott kontextus alapján.

### 4. Felelős AI Biztonsági Bemutató
**Fájl**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Nézd meg, hogyan működnek az AI biztonsági intézkedések a GitHub Modellek tartalomszűrési képességeinek tesztelésével.

Ez a példa bemutatja:
- Tartalomszűrést potenciálisan káros utasítások esetén
- Biztonsági válaszok kezelését alkalmazásokban
- Különböző blokkolt tartalomkategóriákat (erőszak, gyűlöletbeszéd, félretájékoztatás)
- Hibakezelést biztonsági szabálysértések esetén

> **Tudj meg többet**: Ez csak egy bevezetés a felelős AI koncepciókba. További információkért az etikáról, az elfogultság csökkentéséről, az adatvédelemről és a felelős AI keretrendszerekről lásd: [5. fejezet: Felelős Generatív AI](../05-ResponsibleGenAI/README.md).

## Összefoglalás

Ebben a fejezetben megvizsgáltuk az LLM kiegészítéseket és csevegési folyamatokat, megvalósítottuk a funkcióhívásokat az AI képességeinek bővítésére, létrehoztunk egy Visszakeresés-Alapú Generálási (RAG) rendszert, és bemutattuk a felelős AI biztonsági intézkedéseket.

> **MEGJEGYZÉS**: Merülj el mélyebben a mellékelt [**Útmutató**](./TUTORIAL.md) segítségével.

## Következő Lépések

[4. fejezet: Gyakorlati Alkalmazások és Projektek](../04-PracticalSamples/README.md)

**Felelősség kizárása**:  
Ez a dokumentum az [Co-op Translator](https://github.com/Azure/co-op-translator) AI fordítási szolgáltatás segítségével került lefordításra. Bár törekszünk a pontosságra, kérjük, vegye figyelembe, hogy az automatikus fordítások hibákat vagy pontatlanságokat tartalmazhatnak. Az eredeti dokumentum az eredeti nyelvén tekintendő hiteles forrásnak. Kritikus információk esetén javasolt professzionális emberi fordítást igénybe venni. Nem vállalunk felelősséget semmilyen félreértésért vagy téves értelmezésért, amely a fordítás használatából eredhet.