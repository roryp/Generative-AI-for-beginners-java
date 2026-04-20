# Praktické aplikácie a projekty

[![Praktické aplikácie a projekty](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "Praktické aplikácie a projekty")

> **Prehľad videa:** [Pozrite si "Praktické aplikácie a projekty" na YouTube](https://www.youtube.com/watch?v=01vJsYei3H0).

## Čo sa naučíte
V tejto časti predvedieme tri praktické aplikácie, ktoré ukazujú vzory vývoja generatívnej AI v Jave:
- Vytvorte multimodálny generátor príbehov o domácich zvieratách kombinujúci klientskú a serverovú AI
- Implementujte integráciu lokálneho AI modelu s demo aplikáciou Foundry Local Spring Boot
- Vyvíjajte službu Model Context Protocol (MCP) na príklade kalkulačky

## Obsah

- [Úvod](#úvod)
  - [Foundry Local Spring Boot Demo](#foundry-local-spring-boot-demo)
  - [Generátor príbehov o domácich zvieratách](#generátor-príbehov-o-domácich-zvieratách)
  - [Služba MCP kalkulačky (začiatočnícka demo MCP)](#služba-mcp-kalkulačky-začiatočnícka-demo-mcp)
- [Postup učenia](#postup-účenia)
- [Zhrnutie](#zhrnutie)
- [Ďalšie kroky](#ďalšie-kroky)

## Úvod

Táto kapitola predstavuje **ukážkové projekty**, ktoré demonštrujú vzory vývoja generatívnej AI v Jave. Každý projekt je plne funkčný a demonštruje konkrétne AI technológie, architektonické vzory a najlepšie praktiky, ktoré môžete prispôsobiť pre svoje vlastné aplikácie.

### Foundry Local Spring Boot Demo

**[Foundry Local Spring Boot Demo](foundrylocal/README.md)** ukazuje, ako sa integrovať s lokálnymi AI modelmi pomocou **OpenAI Java SDK**. Demonštruje pripojenie k modelom bežiacim na Foundry Local (napr. **Phi-4-mini**) s automatickou detekciou modelov, čo umožňuje spúšťať AI aplikácie bez závislosti na cloudových službách.

### Generátor príbehov o domácich zvieratách

**[Generátor príbehov o domácich zvieratách](petstory/README.md)** je zábavná webová aplikácia Spring Boot, ktorá ukazuje **multimodálne spracovanie AI** na tvorbu kreatívnych príbehov o zvieratkách. Kombinuje schopnosti AI na strane klienta i servera použitím transformer.js pre AI interakcie v prehliadači a OpenAI SDK pre serverové spracovanie.

### Služba MCP kalkulačky (začiatočnícka demo MCP)

**[Služba MCP kalkulačky](calculator/README.md)** je jednoduchá ukážka **Model Context Protocol (MCP)** pomocou Spring AI. Poskytuje úvod priateľský pre začiatočníkov do konceptov MCP, ukazujúc, ako vytvoriť základný MCP server, ktorý komunikuje s MCP klientmi.

## Postup učenia

Tieto projekty sú navrhnuté tak, aby nadväzovali na koncepty z predchádzajúcich kapitol:

1. **Začnite jednoducho**: Začnite s Foundry Local Spring Boot Demo a pochopte základnú integráciu AI s lokálnymi modelmi
2. **Pridajte interaktivitu**: Pokračujte k Generátoru príbehov o domácich zvieratách pre multimodálne AI a webové interakcie
3. **Naučte sa základy MCP**: Vyskúšajte Službu MCP kalkulačky a pochopte základy Model Context Protocol

## Zhrnutie

Výborne! Práve ste preskúmali niektoré skutočné aplikácie:

- Multimodálne AI zážitky fungujúce v prehliadači aj na serveri
- Integráciu lokálneho AI modelu pomocou moderných Java frameworkov a SDK
- Vašu prvú službu Model Context Protocol, ako nástroj na integráciu s AI

## Ďalšie kroky

[5. kapitola: Zodpovedná generatívna AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Vyhlásenie o zodpovednosti**:
Tento dokument bol preložený pomocou AI prekladateľskej služby [Co-op Translator](https://github.com/Azure/co-op-translator). Hoci sa snažíme o presnosť, prosím berte na vedomie, že automatické preklady môžu obsahovať chyby alebo nepresnosti. Pôvodný dokument v jeho rodnom jazyku by mal byť považovaný za autoritatívny zdroj. Pre kritické informácie sa odporúča profesionálny ľudský preklad. Nie sme zodpovední za žiadne nedorozumenia alebo nesprávne interpretácie vyplývajúce z použitia tohto prekladu.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->