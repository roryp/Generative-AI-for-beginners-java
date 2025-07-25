<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "df269f529a172a0197ef28460bf1da9f",
  "translation_date": "2025-07-25T11:49:53+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "hu"
}
-->
# Gyakorlati Alkalmazások és Projektek

## Amit Megtanulsz
Ebben a részben három gyakorlati alkalmazást mutatunk be, amelyek generatív AI fejlesztési mintákat szemléltetnek Java-val:
- Többmódú Kisállat Történet Generátor létrehozása, amely kliens- és szerveroldali AI-t kombinál
- Helyi AI modell integráció megvalósítása a Foundry Local Spring Boot demóval
- Model Context Protocol (MCP) szolgáltatás fejlesztése a Kalkulátor példával

## Tartalomjegyzék

- [Bevezetés](../../../04-PracticalSamples)
  - [Foundry Local Spring Boot Demó](../../../04-PracticalSamples)
  - [Kisállat Történet Generátor](../../../04-PracticalSamples)
  - [MCP Kalkulátor Szolgáltatás (Kezdőbarát MCP Demó)](../../../04-PracticalSamples)
- [Tanulási Haladás](../../../04-PracticalSamples)
- [Összefoglaló](../../../04-PracticalSamples)
- [Következő Lépések](../../../04-PracticalSamples)

## Bevezetés

Ez a fejezet **mintaprojekteket** mutat be, amelyek generatív AI fejlesztési mintákat szemléltetnek Java-val. Minden projekt teljesen működőképes, és bemutatja az AI technológiák, architekturális minták és legjobb gyakorlatok konkrét alkalmazását, amelyeket saját projektjeidben is felhasználhatsz.

### Foundry Local Spring Boot Demó

A **[Foundry Local Spring Boot Demó](foundrylocal/README.md)** bemutatja, hogyan lehet helyi AI modellekkel integrálni az **OpenAI Java SDK** segítségével. Szemlélteti a kapcsolatot a **Phi-3.5-mini** modellel, amely a Foundry Local-on fut, lehetővé téve AI alkalmazások futtatását felhőszolgáltatások nélkül.

### Kisállat Történet Generátor

A **[Kisállat Történet Generátor](petstory/README.md)** egy szórakoztató Spring Boot webalkalmazás, amely bemutatja a **többmódú AI feldolgozást**, hogy kreatív kisállat történeteket generáljon. Kliens- és szerveroldali AI képességeket kombinál, a transformer.js-t használva böngészőalapú AI interakciókhoz, valamint az OpenAI SDK-t szerveroldali feldolgozáshoz.

### MCP Kalkulátor Szolgáltatás (Kezdőbarát MCP Demó)

Az **[MCP Kalkulátor Szolgáltatás](mcp/calculator/README.md)** egy egyszerű bemutató a **Model Context Protocol (MCP)** használatáról Spring AI segítségével. Kezdőbarát bevezetést nyújt az MCP fogalmakba, bemutatva, hogyan lehet létrehozni egy alapvető MCP szervert, amely MCP kliensekkel kommunikál.

## Tanulási Haladás

Ezek a projektek az előző fejezetekben tanult fogalmakra épülnek:

1. **Kezdd egyszerűen**: Kezdd a Foundry Local Spring Boot Demóval, hogy megértsd az alapvető AI integrációt helyi modellekkel
2. **Adj interaktivitást**: Haladj tovább a Kisállat Történet Generátorral, hogy megismerd a többmódú AI-t és a webalapú interakciókat
3. **Tanuld meg az MCP alapjait**: Próbáld ki az MCP Kalkulátor Szolgáltatást, hogy megértsd a Model Context Protocol alapfogalmait

## Összefoglaló

**Gratulálunk!** Sikeresen:

- **Többmódú AI élményeket hoztál létre**, amelyek kliens- és szerveroldali AI feldolgozást kombinálnak
- **Helyi AI modell integrációt valósítottál meg** modern Java keretrendszerek és SDK-k segítségével
- **Model Context Protocol szolgáltatásokat fejlesztettél**, amelyek eszközintegrációs mintákat szemléltetnek

## Következő Lépések

[5. fejezet: Felelős Generatív AI](../05-ResponsibleGenAI/README.md)

**Felelősség kizárása**:  
Ez a dokumentum az AI fordítási szolgáltatás [Co-op Translator](https://github.com/Azure/co-op-translator) segítségével lett lefordítva. Bár törekszünk a pontosságra, kérjük, vegye figyelembe, hogy az automatikus fordítások hibákat vagy pontatlanságokat tartalmazhatnak. Az eredeti dokumentum az eredeti nyelvén tekintendő hiteles forrásnak. Fontos információk esetén javasolt professzionális emberi fordítást igénybe venni. Nem vállalunk felelősséget semmilyen félreértésért vagy téves értelmezésért, amely a fordítás használatából eredhet.