<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "14c0a61ecc1cd2012a9c129236dfdf71",
  "translation_date": "2025-07-29T09:59:14+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "hu"
}
-->
# Gyakorlati Alkalmazások és Projektek

## Amit Megtanulsz
Ebben a részben három gyakorlati alkalmazást mutatunk be, amelyek a generatív AI fejlesztési mintáit szemléltetik Java-val:
- Egy többmódú Kisállat Történet Generátor létrehozása, amely kliens- és szerveroldali AI-t kombinál
- Helyi AI modell integráció megvalósítása a Foundry Local Spring Boot demóval
- Egy Model Context Protocol (MCP) szolgáltatás fejlesztése a Számológép példával

## Tartalomjegyzék

- [Bevezetés](../../../04-PracticalSamples)
  - [Foundry Local Spring Boot Demó](../../../04-PracticalSamples)
  - [Kisállat Történet Generátor](../../../04-PracticalSamples)
  - [MCP Számológép Szolgáltatás (Kezdőbarát MCP Demó)](../../../04-PracticalSamples)
- [Tanulási Haladás](../../../04-PracticalSamples)
- [Összefoglalás](../../../04-PracticalSamples)
- [Következő Lépések](../../../04-PracticalSamples)

## Bevezetés

Ez a fejezet **példaprojekteket** mutat be, amelyek a generatív AI fejlesztési mintáit szemléltetik Java-val. Minden projekt teljesen működőképes, és bemutatja az AI technológiák, architekturális minták és bevált gyakorlatok konkrét alkalmazását, amelyeket saját projektjeidhez is adaptálhatsz.

### Foundry Local Spring Boot Demó

A **[Foundry Local Spring Boot Demó](foundrylocal/README.md)** bemutatja, hogyan lehet helyi AI modellekkel integrálódni az **OpenAI Java SDK** segítségével. A demó a **Phi-3.5-mini** modellhez való csatlakozást szemlélteti, amely a Foundry Local-on fut, lehetővé téve AI alkalmazások futtatását felhőszolgáltatások nélkül.

### Kisállat Történet Generátor

A **[Kisállat Történet Generátor](petstory/README.md)** egy szórakoztató Spring Boot webalkalmazás, amely a **többmódú AI feldolgozást** demonstrálja kreatív kisállat történetek generálásához. Kombinálja a kliensoldali és szerveroldali AI képességeket a transformer.js használatával böngészőalapú AI interakciókhoz, valamint az OpenAI SDK-t a szerveroldali feldolgozáshoz.

### MCP Számológép Szolgáltatás (Kezdőbarát MCP Demó)

Az **[MCP Számológép Szolgáltatás](calculator/README.md)** egy egyszerű bemutató a **Model Context Protocol (MCP)** használatáról Spring AI segítségével. Ez egy kezdőbarát bevezetést nyújt az MCP fogalmaiba, bemutatva, hogyan lehet létrehozni egy alapvető MCP szervert, amely MCP kliensekkel kommunikál.

## Tanulási Haladás

Ezek a projektek az előző fejezetekben tanult fogalmakra építenek:

1. **Kezdd Egyszerűen**: Kezdd a Foundry Local Spring Boot Demóval, hogy megértsd az alapvető AI integrációt helyi modellekkel
2. **Adj Interaktivitást**: Haladj tovább a Kisállat Történet Generátorral, hogy megismerd a többmódú AI-t és a webalapú interakciókat
3. **Ismerd Meg az MCP Alapjait**: Próbáld ki az MCP Számológép Szolgáltatást, hogy megértsd a Model Context Protocol alapjait

## Összefoglalás

Szép munka! Most már megismertél néhány valós alkalmazást:

- Többmódú AI élmények, amelyek böngészőben és szerveren is működnek
- Helyi AI modell integráció modern Java keretrendszerek és SDK-k használatával
- Az első Model Context Protocol szolgáltatásod, amely bemutatja, hogyan integrálódnak az eszközök az AI-val

## Következő Lépések

[5. fejezet: Felelős Generatív AI](../05-ResponsibleGenAI/README.md)

**Felelősségkizárás**:  
Ez a dokumentum az [Co-op Translator](https://github.com/Azure/co-op-translator) AI fordítási szolgáltatás segítségével készült. Bár törekszünk a pontosságra, kérjük, vegye figyelembe, hogy az automatikus fordítások hibákat vagy pontatlanságokat tartalmazhatnak. Az eredeti dokumentum az eredeti nyelvén tekintendő hiteles forrásnak. Kritikus információk esetén javasolt a professzionális, emberi fordítás igénybevétele. Nem vállalunk felelősséget a fordítás használatából eredő félreértésekért vagy téves értelmezésekért.