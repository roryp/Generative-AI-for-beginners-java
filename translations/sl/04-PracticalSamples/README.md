<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "da1b6d87b8a73306b29f9a1bdd681221",
  "translation_date": "2025-07-21T21:15:25+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "sl"
}
-->
# Praktične aplikacije in projekti

> Note: Vsak primer vključuje tudi **TUTORIAL.md**, ki vas vodi skozi zagon aplikacije.

## Kaj se boste naučili
V tem poglavju bomo predstavili tri praktične aplikacije, ki prikazujejo vzorce razvoja generativne umetne inteligence z uporabo Jave:
- Ustvarite večmodalni generator zgodb o hišnih ljubljenčkih, ki združuje AI na strani odjemalca in strežnika
- Implementirajte integracijo lokalnega AI modela z demo aplikacijo Foundry Local Spring Boot
- Razvijte storitev Model Context Protocol (MCP) z uporabo primera Kalkulatorja

## Kazalo

- [Uvod](../../../04-PracticalSamples)
  - [Foundry Local Spring Boot Demo](../../../04-PracticalSamples)
  - [Generator zgodb o hišnih ljubljenčkih](../../../04-PracticalSamples)
  - [MCP Kalkulatorska storitev (prijazen uvod v MCP)](../../../04-PracticalSamples)
- [Napredovanje učenja](../../../04-PracticalSamples)
- [Povzetek](../../../04-PracticalSamples)
- [Naslednji koraki](../../../04-PracticalSamples)

## Uvod

To poglavje predstavlja **primeri projektov**, ki prikazujejo vzorce razvoja generativne umetne inteligence z uporabo Jave. Vsak projekt je popolnoma funkcionalen in prikazuje specifične AI tehnologije, arhitekturne vzorce ter najboljše prakse, ki jih lahko prilagodite za svoje aplikacije.

### Foundry Local Spring Boot Demo

**[Foundry Local Spring Boot Demo](foundrylocal/README.md)** prikazuje, kako se povezati z lokalnimi AI modeli z uporabo **OpenAI Java SDK**. Prikazuje povezovanje z modelom **Phi-3.5-mini**, ki deluje na Foundry Local, kar omogoča izvajanje AI aplikacij brez odvisnosti od oblačnih storitev.

### Generator zgodb o hišnih ljubljenčkih

**[Generator zgodb o hišnih ljubljenčkih](petstory/README.md)** je interaktivna spletna aplikacija Spring Boot, ki prikazuje **večmodalno AI obdelavo** za ustvarjanje kreativnih zgodb o hišnih ljubljenčkih. Združuje AI zmogljivosti na strani odjemalca in strežnika z uporabo transformer.js za interakcije v brskalniku ter OpenAI SDK za obdelavo na strežniku.

### MCP Kalkulatorska storitev (prijazen uvod v MCP)

**[MCP Kalkulatorska storitev](mcp/calculator/README.md)** je preprosta demonstracija **Model Context Protocol (MCP)** z uporabo Spring AI. Ponuja prijazen uvod v MCP koncepte, ki prikazuje, kako ustvariti osnovni MCP strežnik, ki komunicira z MCP odjemalci.

## Napredovanje učenja

Ti projekti so zasnovani tako, da gradijo na konceptih iz prejšnjih poglavij:

1. **Začnite preprosto**: Začnite z Foundry Local Spring Boot Demo, da razumete osnovno integracijo AI z lokalnimi modeli
2. **Dodajte interaktivnost**: Nadaljujte z Generatorjem zgodb o hišnih ljubljenčkih za večmodalno AI in spletne interakcije
3. **Spoznajte osnove MCP**: Preizkusite MCP Kalkulatorsko storitev, da razumete temeljne koncepte Model Context Protocol

## Povzetek

**Čestitamo!** Uspešno ste:

- **Ustvarili večmodalne AI izkušnje**, ki združujejo AI obdelavo na strani odjemalca in strežnika
- **Implementirali integracijo lokalnih AI modelov** z uporabo sodobnih Java ogrodij in SDK-jev
- **Razvili storitve Model Context Protocol**, ki prikazujejo vzorce integracije orodij

## Naslednji koraki

[Chapter 5: Responsible Generative AI](../05-ResponsibleGenAI/README.md)

**Omejitev odgovornosti**:  
Ta dokument je bil preveden z uporabo storitve AI za prevajanje [Co-op Translator](https://github.com/Azure/co-op-translator). Čeprav si prizadevamo za natančnost, vas prosimo, da upoštevate, da lahko avtomatizirani prevodi vsebujejo napake ali netočnosti. Izvirni dokument v njegovem maternem jeziku je treba obravnavati kot avtoritativni vir. Za ključne informacije priporočamo profesionalni človeški prevod. Ne prevzemamo odgovornosti za morebitna nesporazumevanja ali napačne razlage, ki izhajajo iz uporabe tega prevoda.