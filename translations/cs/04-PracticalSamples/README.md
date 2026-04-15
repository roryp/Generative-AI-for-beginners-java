# Praktické aplikace a projekty

[![Praktické aplikace a projekty](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "Praktické aplikace a projekty")

> **Přehled videa:** [Sledujte "Praktické aplikace a projekty" na YouTube](https://www.youtube.com/watch?v=01vJsYei3H0).

## Co se naučíte
V této části předvedeme tři praktické aplikace, které ukazují vývojové vzory generativní AI v Javě:
- Vytvořit multimodální generátor příběhů o domácích mazlíčcích kombinující AI na straně klienta i serveru
- Implementovat integraci lokálního AI modelu pomocí Foundry Local Spring Boot demo
- Vyvinout službu Model Context Protocol (MCP) s příkladem kalkulačky

## Obsah

- [Úvod](#úvod)
  - [Foundry Local Spring Boot demo](#foundry-local-spring-boot-demo)
  - [Generátor příběhů o domácích mazlíčcích](#generátor-příběhů-o-domácích-mazlíčcích)
  - [MCP kalkulačka (pro začátečníky)](#mcp-kalkulačka-pro-začátečníky)
- [Postup učení](#postup-učení)
- [Shrnutí](#shrnutí)
- [Další kroky](#další-kroky)

## Úvod

Tato kapitola ukazuje **ukázkové projekty**, které demonstrují vývojové vzory generativní AI v Javě. Každý projekt je plně funkční a demonstruje specifické AI technologie, architektonické vzory a osvědčené postupy, které můžete přizpůsobit pro vlastní aplikace.

### Foundry Local Spring Boot demo

**[Foundry Local Spring Boot demo](foundrylocal/README.md)** demonstruje, jak integrovat lokální AI modely pomocí **OpenAI Java SDK**. Ukazuje připojení k modelu **Phi-3.5-mini** běžícímu na Foundry Local, což umožňuje spouštět AI aplikace bez závislosti na cloudových službách.

### Generátor příběhů o domácích mazlíčcích

**[Generátor příběhů o domácích mazlíčcích](petstory/README.md)** je poutavá webová aplikace postavená na Spring Boot, která demonstruje **multimodální AI zpracování** pro tvorbu kreativních příběhů o mazlíčcích. Kombinuje AI schopnosti na straně klienta i serveru pomocí transformer.js pro AI interakce v prohlížeči a OpenAI SDK pro serverové zpracování.

### MCP kalkulačka (pro začátečníky)

**[MCP kalkulačka](calculator/README.md)** je jednoduchá demonstrace **Model Context Protocol (MCP)** využívající Spring AI. Poskytuje přívětivý úvod do konceptů MCP a ukazuje, jak vytvořit základní MCP Server komunikující s MCP klienty.

## Postup učení

Tyto projekty jsou navrženy tak, aby stavěly na konceptech z předchozích kapitol:

1. **Začněte jednoduše**: Začněte s Foundry Local Spring Boot demo pro pochopení základní AI integrace s lokálními modely
2. **Přidejte interaktivitu**: Pokračujte k generátoru příběhů o mazlíčcích pro multimodální AI a webové interakce
3. **Naučte se základy MCP**: Vyzkoušejte MCP kalkulačku, abyste pochopili základy Model Context Protocol

## Shrnutí

Dobrá práce! Prozkoumali jste skutečné aplikace:

- Multimodální AI zážitky fungující v prohlížeči i na serveru
- Integraci lokálního AI modelu s moderními Java frameworky a SDK
- Vaši první službu Model Context Protocol ukazující, jak nástroje spolupracují s AI

## Další kroky

[Kapitola 5: Zodpovědná generativní AI](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Prohlášení o vyloučení odpovědnosti**:  
Tento dokument byl přeložen pomocí AI překladatelské služby [Co-op Translator](https://github.com/Azure/co-op-translator). Přestože se snažíme o přesnost, mějte prosím na paměti, že automatizované překlady mohou obsahovat chyby nebo nepřesnosti. Původní dokument v jeho rodném jazyce by měl být považován za autoritativní zdroj. Pro kritické informace se doporučuje profesionální lidský překlad. Nejsme odpovědní za jakékoli nedorozumění nebo nesprávné výklady vyplývající z použití tohoto překladu.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->