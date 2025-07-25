<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "139c227ef39d24287257d1aff6fc6973",
  "translation_date": "2025-07-25T10:03:23+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "sk"
}
-->
# Praktické aplikácie a projekty

> Poznámka: Každý príklad obsahuje aj súbor **TUTORIAL.md**, ktorý vás prevedie spustením ukážok.

## Čo sa naučíte
V tejto sekcii si ukážeme tri praktické aplikácie, ktoré demonštrujú vývojové vzory generatívnej AI s použitím Javy:
- Vytvorenie multimodálneho generátora príbehov o domácich miláčikoch, ktorý kombinuje AI na strane klienta a servera
- Implementácia integrácie lokálneho AI modelu pomocou ukážky Foundry Local Spring Boot
- Vývoj služby Model Context Protocol (MCP) na príklade kalkulačky

## Obsah

- [Úvod](../../../04-PracticalSamples)
  - [Ukážka Foundry Local Spring Boot](../../../04-PracticalSamples)
  - [Generátor príbehov o domácich miláčikoch](../../../04-PracticalSamples)
  - [MCP Kalkulačková služba (Jednoduchá ukážka MCP)](../../../04-PracticalSamples)
- [Postup učenia](../../../04-PracticalSamples)
- [Zhrnutie](../../../04-PracticalSamples)
- [Ďalšie kroky](../../../04-PracticalSamples)

## Úvod

Táto kapitola predstavuje **ukážkové projekty**, ktoré demonštrujú vývojové vzory generatívnej AI s použitím Javy. Každý projekt je plne funkčný a ukazuje konkrétne AI technológie, architektonické vzory a osvedčené postupy, ktoré môžete prispôsobiť pre svoje vlastné aplikácie.

### Ukážka Foundry Local Spring Boot

**[Foundry Local Spring Boot Demo](foundrylocal/README.md)** ukazuje, ako integrovať lokálne AI modely pomocou **OpenAI Java SDK**. Demonštruje pripojenie k modelu **Phi-3.5-mini**, ktorý beží na Foundry Local, čo vám umožňuje spúšťať AI aplikácie bez závislosti na cloudových službách.

### Generátor príbehov o domácich miláčikoch

**[Generátor príbehov o domácich miláčikoch](petstory/README.md)** je pútavá webová aplikácia postavená na Spring Boot, ktorá demonštruje **multimodálne AI spracovanie** na generovanie kreatívnych príbehov o domácich miláčikoch. Kombinuje AI na strane klienta a servera pomocou transformer.js pre interakcie v prehliadači a OpenAI SDK pre spracovanie na strane servera.

### MCP Kalkulačková služba (Jednoduchá ukážka MCP)

**[MCP Kalkulačková služba](mcp/calculator/README.md)** je jednoduchá ukážka **Model Context Protocol (MCP)** s použitím Spring AI. Poskytuje začiatočnícky úvod do konceptov MCP a ukazuje, ako vytvoriť základný MCP server, ktorý komunikuje s MCP klientmi.

## Postup učenia

Tieto projekty sú navrhnuté tak, aby stavali na konceptoch z predchádzajúcich kapitol:

1. **Začnite jednoducho**: Začnite s ukážkou Foundry Local Spring Boot, aby ste pochopili základnú integráciu AI s lokálnymi modelmi
2. **Pridajte interaktivitu**: Pokračujte s generátorom príbehov o domácich miláčikoch pre multimodálne AI a webové interakcie
3. **Naučte sa základy MCP**: Vyskúšajte MCP Kalkulačkovú službu, aby ste pochopili základy Model Context Protocol

## Zhrnutie

**Gratulujeme!** Úspešne ste:

- **Vytvorili multimodálne AI zážitky**, ktoré kombinujú AI spracovanie na strane klienta a servera
- **Implementovali integráciu lokálneho AI modelu** s použitím moderných Java frameworkov a SDK
- **Vyvinuli služby Model Context Protocol**, ktoré demonštrujú vzory integrácie nástrojov

## Ďalšie kroky

[5. kapitola: Zodpovedná generatívna AI](../05-ResponsibleGenAI/README.md)

**Zrieknutie sa zodpovednosti**:  
Tento dokument bol preložený pomocou služby AI prekladu [Co-op Translator](https://github.com/Azure/co-op-translator). Hoci sa snažíme o presnosť, prosím, berte na vedomie, že automatizované preklady môžu obsahovať chyby alebo nepresnosti. Pôvodný dokument v jeho rodnom jazyku by mal byť považovaný za autoritatívny zdroj. Pre kritické informácie sa odporúča profesionálny ľudský preklad. Nenesieme zodpovednosť za akékoľvek nedorozumenia alebo nesprávne interpretácie vyplývajúce z použitia tohto prekladu.