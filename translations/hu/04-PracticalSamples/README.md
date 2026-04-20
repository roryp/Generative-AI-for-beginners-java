# Gyakorlati alkalmazások és projektek

[![Gyakorlati alkalmazások és projektek](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "Gyakorlati alkalmazások és projektek")

> **Videó áttekintés:** [Nézze meg a „Gyakorlati alkalmazások és projektek” videót a YouTube-on](https://www.youtube.com/watch?v=01vJsYei3H0).

## Amit tanulni fogsz
Ebben a részben három olyan gyakorlati alkalmazást mutatunk be, amelyek a Java generatív MI fejlesztési mintáit szemléltetik:
- Többmodalitású Háziállat-történet generátor létrehozása, kliens- és szerveroldali MI kombinálásával
- Helyi MI modell integrálása a Foundry Local Spring Boot demóval
- Model Context Protocol (MCP) szolgáltatás fejlesztése a Számológép példán keresztül

## Tartalomjegyzék

- [Bevezetés](#bevezetés)
  - [Foundry Local Spring Boot demo](#foundry-local-spring-boot-demo)
  - [Háziállat-történet generátor](#háziállat-történet-generátor)
  - [MCP Számológép szolgáltatás (Kezdőbarát MCP demó)](#mcp-számológép-szolgáltatás-kezdőbarát-mcp-demó)
- [Tanulási előrehaladás](#tanulási-előrehaladás)
- [Összefoglalás](#összefoglalás)
- [Következő lépések](#következő-lépések)

## Bevezetés

Ez a fejezet olyan **mintaprojekteket** mutat be, amelyek a Java generatív MI fejlesztési mintáit szemléltetik. Minden projekt teljesen működőképes, és bemutat konkrét MI technológiákat, architekturális mintákat, valamint bevált gyakorlatokat, amelyeket saját alkalmazásaidhoz alakíthatsz.

### Foundry Local Spring Boot demo

A **[Foundry Local Spring Boot demo](foundrylocal/README.md)** bemutatja, hogyan integrálhatóak helyi MI modellek az **OpenAI Java SDK** segítségével. Megjeleníti a Foundry Local-on futó modellekhez (pl. **Phi-4-mini**) való csatlakozást, automatikus modellérzékeléssel, lehetővé téve MI alkalmazások futtatását felhőszolgáltatások igénybevétele nélkül.

### Háziállat-történet generátor

A **[Háziállat-történet generátor](petstory/README.md)** egy lebilincselő Spring Boot webalkalmazás, amely bemutatja a **többmodalitású MI feldolgozást** kreatív háziállat-történetek generálásához. Kombinálja a kliensoldali és szerveroldali MI képességeket a transformer.js segítségével böngészőalapú MI interakciókhoz és az OpenAI SDK-val a szerveroldali feldolgozáshoz.

### MCP Számológép szolgáltatás (Kezdőbarát MCP demó)

A **[MCP Számológép szolgáltatás](calculator/README.md)** egy egyszerű bemutatója a **Model Context Protocol (MCP)** használatának a Spring AI segítségével. Kezdőbarát bevezetést nyújt az MCP koncepciókhoz, megmutatva, hogyan hozható létre egy alap MCP szerver, amely MCP kliensekkel kommunikál.

## Tanulási előrehaladás

Ezek a projektek a korábbi fejezetek fogalmainak továbbépítésére készültek:

1. **Kezdj egyszerűen**: Kezdd a Foundry Local Spring Boot demóval, hogy megértsd az alapvető MI integrációt helyi modellekkel
2. **Adj interaktivitást**: Haladj a Háziállat-történet generátorra a többmodalitású MI és webalapú interakciók érdekében
3. **Tanuld meg az MCP alapjait**: Próbáld ki az MCP Számológép szolgáltatást, hogy megértsd a Model Context Protocol alapjait

## Összefoglalás

Szép munka! Most már megismertél néhány valós alkalmazást:

- Többmodalitású MI élmények, amelyek egyszerre működnek böngészőben és szerveren
- Helyi MI modell integráció modern Java keretrendszerekkel és SDK-kkal
- Az első Model Context Protocol szolgáltatásod, hogy lásd, hogyan integrálódnak az eszközök az MI-vel

## Következő lépések

[5. fejezet: Felelős generatív MI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Kizáró nyilatkozat**:  
Ez a dokumentum az AI fordítási szolgáltatás, a [Co-op Translator](https://github.com/Azure/co-op-translator) segítségével készült. Bár az pontosságra törekszünk, kérjük, vegye figyelembe, hogy az automatikus fordítások hibákat vagy pontatlanságokat tartalmazhatnak. Az eredeti dokumentum a saját nyelvén tekintendő hivatalos forrásnak. Kritikus információk esetén professzionális emberi fordítás ajánlott. Nem vállalunk felelősséget az ebből a fordításból eredő félreértésekért vagy félreértelmezésekért.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->