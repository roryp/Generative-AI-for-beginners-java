# Gyakorlati alkalmazások és projektek

[![Gyakorlati alkalmazások és projektek](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "Gyakorlati alkalmazások és projektek")

> **Videó áttekintése:** [Nézd meg a „Gyakorlati alkalmazások és projektek” videót a YouTube-on](https://www.youtube.com/watch?v=01vJsYei3H0).

## Amit megtanulsz
Ebben a részben három gyakorlati alkalmazást mutatunk be, amelyek a generatív MI fejlesztési mintákat szemléltetik Java nyelven:
- Többmodalitású Pet Story Generator létrehozása, amely kliens-oldali és szerver-oldali MI-t egyesít
- Helyi MI modell integrálása a Foundry Local Spring Boot demóval
- Model Context Protocol (MCP) szolgáltatás fejlesztése a Számológép példával

## Tartalomjegyzék

- [Bevezetés](#bevezetés)
  - [Foundry Local Spring Boot demó](#foundry-local-spring-boot-demó)
  - [Pet Story Generator](#pet-story-generator)
  - [MCP Számológép szolgáltatás (Kezdőbarát MCP demó)](#mcp-számológép-szolgáltatás-kezdőbarát-mcp-demó)
- [Tanulási folyamat](#tanulási-folyamat)
- [Összefoglaló](#összefoglaló)
- [Következő lépések](#következő-lépések)

## Bevezetés

Ez a fejezet **mintaprojekteket** mutat be, amelyek a generatív MI fejlesztési mintákat Java nyelven szemléltetik. Minden projekt teljesen működőképes, és konkrét MI technológiákat, architekturális mintákat és bevált gyakorlatokat mutat be, amelyeket alkalmazásaidhoz igazíthatsz.

### Foundry Local Spring Boot demó

A **[Foundry Local Spring Boot demó](foundrylocal/README.md)** bemutatja, hogyan lehet integrálódni helyi MI modellekkel az **OpenAI Java SDK** segítségével. Megmutatja a **Phi-3.5-mini** modellen való csatlakozást, amely a Foundry Local-on fut, lehetővé téve MI alkalmazások futtatását felhőszolgáltatás nélkül.

### Pet Story Generator

A **[Pet Story Generator](petstory/README.md)** egy lebilincselő Spring Boot webalkalmazás, amely a **többmodalitású MI feldolgozást** demonstrálja kreatív háziállat történetek generálására. Ötvözi a kliens-oldali és a szerver-oldali MI képességeket a transformer.js használatával a böngésző alapú MI interakciókhoz és az OpenAI SDK-val a szerver-oldali feldolgozáshoz.

### MCP Számológép szolgáltatás (Kezdőbarát MCP demó)

A **[MCP Számológép szolgáltatás](calculator/README.md)** egyszerű bemutatója a **Model Context Protocol-nak (MCP)** a Spring AI használatával. Kezdőbarát bevezetést nyújt az MCP fogalmaiba, megmutatva, hogyan készíthetünk alap MCP szervert, amely MCP kliensekkel kommunikál.

## Tanulási folyamat

Ezek a projektek úgy vannak kialakítva, hogy kapcsolódjanak a korábbi fejezetekben tanult fogalmakhoz:

1. **Kezdd egyszerűen**: Kezdd a Foundry Local Spring Boot demóval, hogy megértsd az alapvető MI integrációt helyi modellekkel
2. **Adj interaktivitást**: Haladj a Pet Story Generator felé a többmodalitású MI és a webes interakciók megismeréséhez
3. **Tanuld meg az MCP alapjait**: Próbáld ki az MCP Számológép szolgáltatást, hogy megértsd a Model Context Protocol alapelveit

## Összefoglaló

Jó munka! Most már megismerkedtél néhány valós alkalmazással:

- Többmodalitású MI élmények, amelyek egyszerre működnek a böngészőben és a szerveren
- Helyi MI modell integrálása modern Java keretrendszerekkel és SDK-kkal
- Az első Model Context Protocol szolgáltatásod, hogy lásd, hogyan integrálhatók az eszközök az MI-vel

## Következő lépések

[5. fejezet: Felelős generatív MI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Nyilatkozat**:  
Ez a dokumentum az AI fordító szolgáltatás, a [Co-op Translator](https://github.com/Azure/co-op-translator) segítségével készült. Bár a pontosságra törekszünk, kérjük, vegye figyelembe, hogy az automatikus fordítások hibákat vagy pontatlanságokat tartalmazhatnak. Az eredeti dokumentum az anyanyelvén tekintendő hiteles forrásnak. Kritikus információk esetén professzionális emberi fordítást javaslunk. Nem vállalunk felelősséget az ebből a fordításból eredő félreértésekért vagy félrefordításokért.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->