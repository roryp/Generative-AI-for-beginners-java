<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "d45b8e2291ab1357592c904c103cbc81",
  "translation_date": "2025-07-28T11:07:51+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "cs"
}
-->
# Praktické aplikace a projekty

## Co se naučíte
V této části představíme tři praktické aplikace, které ukazují vzory vývoje generativní AI pomocí Javy:
- Vytvoření multimodálního generátoru příběhů o mazlíčcích kombinujícího AI na straně klienta i serveru
- Implementace integrace lokálního AI modelu s ukázkou Foundry Local Spring Boot
- Vývoj služby Model Context Protocol (MCP) na příkladu kalkulačky

## Obsah

- [Úvod](../../../04-PracticalSamples)
  - [Ukázka Foundry Local Spring Boot](../../../04-PracticalSamples)
  - [Generátor příběhů o mazlíčcích](../../../04-PracticalSamples)
  - [MCP Kalkulačka (Začátečnická ukázka MCP)](../../../04-PracticalSamples)
- [Postup učení](../../../04-PracticalSamples)
- [Shrnutí](../../../04-PracticalSamples)
- [Další kroky](../../../04-PracticalSamples)

## Úvod

Tato kapitola představuje **ukázkové projekty**, které demonstrují vzory vývoje generativní AI pomocí Javy. Každý projekt je plně funkční a ukazuje konkrétní AI technologie, architektonické vzory a osvědčené postupy, které můžete přizpůsobit pro své vlastní aplikace.

### Ukázka Foundry Local Spring Boot

**[Ukázka Foundry Local Spring Boot](foundrylocal/README.md)** demonstruje, jak integrovat lokální AI modely pomocí **OpenAI Java SDK**. Ukazuje připojení k modelu **Phi-3.5-mini** běžícímu na Foundry Local, což vám umožní provozovat AI aplikace bez závislosti na cloudových službách.

### Generátor příběhů o mazlíčcích

**[Generátor příběhů o mazlíčcích](petstory/README.md)** je poutavá webová aplikace Spring Boot, která demonstruje **multimodální AI zpracování** pro generování kreativních příběhů o mazlíčcích. Kombinuje AI na straně klienta i serveru pomocí transformer.js pro interakce v prohlížeči a OpenAI SDK pro zpracování na straně serveru.

### MCP Kalkulačka (Začátečnická ukázka MCP)

**[MCP Kalkulačka](calculator/README.md)** je jednoduchá ukázka **Model Context Protocol (MCP)** pomocí Spring AI. Poskytuje začátečnický úvod do konceptů MCP a ukazuje, jak vytvořit základní MCP server, který komunikuje s MCP klienty.

## Postup učení

Tyto projekty jsou navrženy tak, aby stavěly na konceptech z předchozích kapitol:

1. **Začněte jednoduše**: Začněte s ukázkou Foundry Local Spring Boot, abyste pochopili základní integraci AI s lokálními modely
2. **Přidejte interaktivitu**: Pokračujte ke Generátoru příběhů o mazlíčcích pro multimodální AI a interakce na webu
3. **Naučte se základy MCP**: Vyzkoušejte MCP Kalkulačku, abyste pochopili základy Model Context Protocol

## Shrnutí

**Gratulujeme!** Úspěšně jste:

- **Vytvořili multimodální AI zážitky**, které kombinují AI zpracování na straně klienta i serveru
- **Implementovali integraci lokálních AI modelů** pomocí moderních Java frameworků a SDK
- **Vyvinuli služby Model Context Protocol**, které demonstrují vzory integrace nástrojů

## Další kroky

[Kap. 5: Odpovědná generativní AI](../05-ResponsibleGenAI/README.md)

**Prohlášení:**  
Tento dokument byl přeložen pomocí služby pro automatizovaný překlad [Co-op Translator](https://github.com/Azure/co-op-translator). Ačkoli se snažíme o přesnost, mějte prosím na paměti, že automatizované překlady mohou obsahovat chyby nebo nepřesnosti. Původní dokument v jeho původním jazyce by měl být považován za autoritativní zdroj. Pro důležité informace doporučujeme profesionální lidský překlad. Neodpovídáme za žádná nedorozumění nebo nesprávné interpretace vyplývající z použití tohoto překladu.