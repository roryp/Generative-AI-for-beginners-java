<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "14c0a61ecc1cd2012a9c129236dfdf71",
  "translation_date": "2025-07-29T10:20:29+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "hr"
}
-->
# Praktične Primjene i Projekti

## Što ćete naučiti
U ovom odjeljku prikazat ćemo tri praktične primjene koje demonstriraju obrasce razvoja generativne umjetne inteligencije s Javom:
- Kreiranje višemodalnog generatora priča o kućnim ljubimcima koji kombinira AI na strani klijenta i poslužitelja
- Implementacija integracije lokalnog AI modela s Foundry Local Spring Boot demonstracijom
- Razvoj usluge Model Context Protocol (MCP) s primjerom Kalkulatora

## Sadržaj

- [Uvod](../../../04-PracticalSamples)
  - [Foundry Local Spring Boot Demo](../../../04-PracticalSamples)
  - [Generator priča o kućnim ljubimcima](../../../04-PracticalSamples)
  - [MCP Kalkulator usluga (Prijateljska MCP demonstracija za početnike)](../../../04-PracticalSamples)
- [Napredak u učenju](../../../04-PracticalSamples)
- [Sažetak](../../../04-PracticalSamples)
- [Sljedeći koraci](../../../04-PracticalSamples)

## Uvod

Ovo poglavlje prikazuje **primjere projekata** koji demonstriraju obrasce razvoja generativne umjetne inteligencije s Javom. Svaki projekt je potpuno funkcionalan i prikazuje specifične AI tehnologije, arhitektonske obrasce i najbolje prakse koje možete prilagoditi za vlastite aplikacije.

### Foundry Local Spring Boot Demo

**[Foundry Local Spring Boot Demo](foundrylocal/README.md)** demonstrira kako se integrirati s lokalnim AI modelima koristeći **OpenAI Java SDK**. Prikazuje povezivanje s modelom **Phi-3.5-mini** koji radi na Foundry Local, omogućujući pokretanje AI aplikacija bez oslanjanja na cloud usluge.

### Generator priča o kućnim ljubimcima

**[Generator priča o kućnim ljubimcima](petstory/README.md)** je zanimljiva Spring Boot web aplikacija koja demonstrira **višemodalnu AI obradu** za generiranje kreativnih priča o kućnim ljubimcima. Kombinira AI mogućnosti na strani klijenta i poslužitelja koristeći transformer.js za AI interakcije u pregledniku i OpenAI SDK za obradu na strani poslužitelja.

### MCP Kalkulator usluga (Prijateljska MCP demonstracija za početnike)

**[MCP Kalkulator usluga](calculator/README.md)** je jednostavna demonstracija **Model Context Protocol (MCP)** koristeći Spring AI. Pruža uvod prilagođen početnicima u MCP koncepte, pokazujući kako stvoriti osnovni MCP poslužitelj koji komunicira s MCP klijentima.

## Napredak u učenju

Ovi projekti su osmišljeni tako da se nadovezuju na koncepte iz prethodnih poglavlja:

1. **Počnite jednostavno**: Započnite s Foundry Local Spring Boot Demo kako biste razumjeli osnovnu AI integraciju s lokalnim modelima
2. **Dodajte interaktivnost**: Nastavite s Generatorom priča o kućnim ljubimcima za višemodalnu AI obradu i web interakcije
3. **Naučite MCP osnove**: Isprobajte MCP Kalkulator uslugu kako biste razumjeli osnove Model Context Protocol-a

## Sažetak

Odlično! Sada ste istražili nekoliko stvarnih primjena:

- Višemodalna AI iskustva koja rade i u pregledniku i na poslužitelju
- Integracija lokalnih AI modela koristeći moderne Java okvire i SDK-ove
- Vaša prva usluga Model Context Protocol kako biste vidjeli kako alati integriraju AI

## Sljedeći koraci

[5. poglavlje: Odgovorna generativna umjetna inteligencija](../05-ResponsibleGenAI/README.md)

**Odricanje od odgovornosti**:  
Ovaj dokument je preveden korištenjem AI usluge za prevođenje [Co-op Translator](https://github.com/Azure/co-op-translator). Iako nastojimo osigurati točnost, imajte na umu da automatski prijevodi mogu sadržavati pogreške ili netočnosti. Izvorni dokument na izvornom jeziku treba smatrati mjerodavnim izvorom. Za ključne informacije preporučuje se profesionalni prijevod od strane stručnjaka. Ne preuzimamo odgovornost za bilo kakve nesporazume ili pogrešne interpretacije proizašle iz korištenja ovog prijevoda.