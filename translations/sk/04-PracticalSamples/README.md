# Praktické aplikácie a projekty

[![Praktické aplikácie a projekty](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "Praktické aplikácie a projekty")

> **Prehľad videa:** [Pozrite si "Praktické aplikácie a projekty" na YouTube](https://www.youtube.com/watch?v=01vJsYei3H0).

## Čo sa naučíte
V tejto sekcii predvedieme tri praktické aplikácie, ktoré ilustrujú vývojové vzory generatívnej AI v Jave:
- Vytvoriť multimodálny generátor príbehov o zvieratkách kombinujúci klientskú a serverovú AI
- Implementovať integráciu lokálneho AI modelu s demo aplikáciou Foundry Local Spring Boot
- Vyvinúť službu Model Context Protocol (MCP) s príkladom kalkulačky

## Obsah

- [Úvod](#úvod)
  - [Foundry Local Spring Boot Demo](#foundry-local-spring-boot-demo)
  - [Generátor príbehov o zvieratkách](#generátor-príbehov-o-zvieratkách)
  - [MCP Kalkulačná služba (Začiatočnícka MCP Demo)](#mcp-kalkulačná-služba-začiatočnícka-mcp-demo)
- [Návrh učebného základu](#návrh-učebného-základu)
- [Zhrnutie](#zhrnutie)
- [Ďalšie kroky](#ďalšie-kroky)

## Úvod

Táto kapitola predstavuje **ukážkové projekty**, ktoré demonštrujú vývojové vzory generatívnej AI v Jave. Každý projekt je plne funkčný a ukazuje špecifické AI technológie, architektonické vzory a osvedčené postupy, ktoré môžete prispôsobiť pre svoje vlastné aplikácie.

### Foundry Local Spring Boot Demo

**[Foundry Local Spring Boot Demo](foundrylocal/README.md)** demonštruje, ako sa integrovať s lokálnymi AI modelmi pomocou **OpenAI Java SDK**. Ukazuje pripojenie k modelu **Phi-3.5-mini** bežiacemu na Foundry Local, čo vám umožňuje spúšťať AI aplikácie bez závislosti na cloudových službách.

### Generátor príbehov o zvieratkách

**[Generátor príbehov o zvieratkách](petstory/README.md)** je zábavná webová aplikácia Spring Boot, ktorá demonštruje **multimodálne AI spracovanie** pre tvorbu kreatívnych príbehov o zvieratkách. Kombinuje klientskú a serverovú AI pomocou transformer.js pre interakcie v prehliadači a OpenAI SDK pre serverové spracovanie.

### MCP Kalkulačná služba (Začiatočnícka MCP Demo)

**[MCP Kalkulačná služba](calculator/README.md)** je jednoduchá ukážka **Model Context Protocol (MCP)** využívajúca Spring AI. Poskytuje priateľský úvod do konceptov MCP a ukazuje, ako vytvoriť základný MCP server, ktorý komunikuje s MCP klientmi.

## Návrh učebného základu

Tieto projekty sú navrhnuté tak, aby nadväzovali na koncepty z predchádzajúcich kapitol:

1. **Začnite jednoducho**: Začnite s Foundry Local Spring Boot Demo pre základné pochopenie AI integrácie s lokálnymi modelmi
2. **Pridajte interaktivitu**: Pokračujte s Generátorom príbehov o zvieratkách pre multimodálne AI a webové interakcie
3. **Naučte sa základy MCP**: Vyskúšajte MCP Kalkulačnú službu pre pochopenie základov Model Context Protocol

## Zhrnutie

Výborne! Teraz ste preskúmali niekoľko reálnych aplikácií:

- Multimodálne AI zážitky fungujúce v prehliadači aj na serveri
- Integrácia lokálneho AI modelu s modernými Java frameworkmi a SDK
- Vaša prvá služba Model Context Protocol, ktorá ukazuje, ako nástroje integrujú AI

## Ďalšie kroky

[5. kapitola: Zodpovedná generatívna AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Zrieknutie sa zodpovednosti**:
Tento dokument bol preložený pomocou AI prekladateľskej služby [Co-op Translator](https://github.com/Azure/co-op-translator). Aj keď sa snažíme o presnosť, uvedomte si, že automatizované preklady môžu obsahovať chyby alebo nepresnosti. Pôvodný dokument v jeho pôvodnom jazyku by mal byť považovaný za autoritatívny zdroj. Pre kritické informácie sa odporúča profesionálny ľudský preklad. Nezodpovedáme za akékoľvek nedorozumenia alebo nesprávne interpretácie vyplývajúce z použitia tohto prekladu.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->