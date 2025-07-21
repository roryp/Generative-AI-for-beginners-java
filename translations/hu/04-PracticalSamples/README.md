<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "da1b6d87b8a73306b29f9a1bdd681221",
  "translation_date": "2025-07-21T21:13:36+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "hu"
}
-->
# Gyakorlati Alkalmazások és Projektek

> Megjegyzés: Minden példához tartozik egy **TUTORIAL.md**, amely lépésről lépésre bemutatja az alkalmazás futtatását.

## Amit Megtanulsz
Ebben a részben három gyakorlati alkalmazást mutatunk be, amelyek a generatív AI fejlesztési mintáit szemléltetik Java nyelven:
- Többmodális Kisállat Történet Generátor létrehozása, amely kliens- és szerveroldali AI-t kombinál
- Helyi AI modell integráció megvalósítása a Foundry Local Spring Boot demóval
- Model Context Protocol (MCP) szolgáltatás fejlesztése a Számológép példával

## Tartalomjegyzék

- [Bevezetés](../../../04-PracticalSamples)
  - [Foundry Local Spring Boot Demó](../../../04-PracticalSamples)
  - [Kisállat Történet Generátor](../../../04-PracticalSamples)
  - [MCP Számológép Szolgáltatás (Kezdőbarát MCP Demó)](../../../04-PracticalSamples)
- [Tanulási Haladás](../../../04-PracticalSamples)
- [Összefoglalás](../../../04-PracticalSamples)
- [Következő Lépések](../../../04-PracticalSamples)

## Bevezetés

Ez a fejezet **minta projekteket** mutat be, amelyek a generatív AI fejlesztési mintáit szemléltetik Java nyelven. Minden projekt teljesen működőképes, és bemutatja az AI technológiák, architekturális minták és legjobb gyakorlatok konkrét alkalmazását, amelyeket saját projektjeidben is felhasználhatsz.

### Foundry Local Spring Boot Demó

A **[Foundry Local Spring Boot Demó](foundrylocal/README.md)** bemutatja, hogyan lehet helyi AI modellekkel integrálódni az **OpenAI Java SDK** segítségével. A demó a **Phi-3.5-mini** modellhez való csatlakozást szemlélteti, amely a Foundry Local-on fut, lehetővé téve AI alkalmazások futtatását felhőszolgáltatások nélkül.

### Kisállat Történet Generátor

A **[Kisállat Történet Generátor](petstory/README.md)** egy szórakoztató Spring Boot webalkalmazás, amely a **többmodális AI feldolgozást** használja kreatív kisállat történetek generálására. Kombinálja a kliensoldali és szerveroldali AI képességeket a transformer.js segítségével böngészőalapú AI interakciókhoz, valamint az OpenAI SDK-t a szerveroldali feldolgozáshoz.

### MCP Számológép Szolgáltatás (Kezdőbarát MCP Demó)

Az **[MCP Számológép Szolgáltatás](mcp/calculator/README.md)** egy egyszerű bemutató a **Model Context Protocol (MCP)** használatáról Spring AI segítségével. Ez egy kezdőbarát bevezetést nyújt az MCP alapfogalmaiba, bemutatva, hogyan lehet egy alapvető MCP szervert létrehozni, amely MCP kliensekkel kommunikál.

## Tanulási Haladás

Ezek a projektek az előző fejezetekben tanult fogalmakra épülnek:

1. **Kezdd Egyszerűen**: Kezdd a Foundry Local Spring Boot Demóval, hogy megértsd az alapvető AI integrációt helyi modellekkel
2. **Adj Interaktivitást**: Haladj tovább a Kisállat Történet Generátorral, hogy megismerd a többmodális AI-t és a webalapú interakciókat
3. **Ismerd Meg az MCP Alapjait**: Próbáld ki az MCP Számológép Szolgáltatást, hogy megértsd a Model Context Protocol alapfogalmait

## Összefoglalás

**Gratulálunk!** Sikeresen:

- **Többmodális AI élményeket hoztál létre**, amelyek kliens- és szerveroldali AI feldolgozást kombinálnak
- **Helyi AI modell integrációt valósítottál meg** modern Java keretrendszerek és SDK-k használatával
- **Model Context Protocol szolgáltatásokat fejlesztettél**, amelyek eszközintegrációs mintákat mutatnak be

## Következő Lépések

[5. fejezet: Felelős Generatív AI](../05-ResponsibleGenAI/README.md)

**Felelősség kizárása**:  
Ez a dokumentum az AI fordítási szolgáltatás, a [Co-op Translator](https://github.com/Azure/co-op-translator) segítségével lett lefordítva. Bár törekszünk a pontosságra, kérjük, vegye figyelembe, hogy az automatikus fordítások hibákat vagy pontatlanságokat tartalmazhatnak. Az eredeti dokumentum az eredeti nyelvén tekintendő hiteles forrásnak. Kritikus információk esetén javasolt professzionális emberi fordítást igénybe venni. Nem vállalunk felelősséget semmilyen félreértésért vagy téves értelmezésért, amely a fordítás használatából eredhet.