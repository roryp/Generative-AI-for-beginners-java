<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "7bf9a4a832911269a8bd0decb97ff36c",
  "translation_date": "2025-07-21T21:27:19+00:00",
  "source_file": "04-PracticalSamples/mcp/calculator/README.md",
  "language_code": "cs"
}
-->
# Základní Kalkulačka MCP Služba

>**Poznámka**: Tato kapitola obsahuje [**Návod**](./TUTORIAL.md), který vás provede spuštěním hotových ukázek.

Vítejte u svého prvního praktického zážitku s **Model Context Protocol (MCP)**! V předchozích kapitolách jste se seznámili se základy generativní AI a nastavili si vývojové prostředí. Nyní je čas vytvořit něco praktického.

Tato služba kalkulačky ukazuje, jak mohou AI modely bezpečně komunikovat s externími nástroji pomocí MCP. Místo spoléhání se na občas nespolehlivé matematické schopnosti AI modelu vám ukážeme, jak vytvořit robustní systém, kde AI může volat specializované služby pro přesné výpočty.

## Obsah

- [Co se naučíte](../../../../../04-PracticalSamples/mcp/calculator)
- [Předpoklady](../../../../../04-PracticalSamples/mcp/calculator)
- [Klíčové koncepty](../../../../../04-PracticalSamples/mcp/calculator)
- [Rychlý start](../../../../../04-PracticalSamples/mcp/calculator)
- [Dostupné operace kalkulačky](../../../../../04-PracticalSamples/mcp/calculator)
- [Testovací klienti](../../../../../04-PracticalSamples/mcp/calculator)
  - [1. Přímý MCP klient (SDKClient)](../../../../../04-PracticalSamples/mcp/calculator)
  - [2. Klient s podporou AI (LangChain4jClient)](../../../../../04-PracticalSamples/mcp/calculator)
- [MCP Inspektor (Webové rozhraní)](../../../../../04-PracticalSamples/mcp/calculator)
  - [Podrobný návod](../../../../../04-PracticalSamples/mcp/calculator)

## Co se naučíte

Prací na tomto příkladu pochopíte:
- Jak vytvořit služby kompatibilní s MCP pomocí Spring Boot
- Rozdíl mezi přímou komunikací protokolu a interakcí s podporou AI
- Jak AI modely rozhodují, kdy a jak používat externí nástroje
- Nejlepší postupy pro vytváření AI aplikací s podporou nástrojů

Ideální pro začátečníky, kteří se učí koncepty MCP a jsou připraveni vytvořit svou první integraci AI nástroje!

## Předpoklady

- Java 21+
- Maven 3.6+
- **GitHub Token**: Požadováno pro klienta s podporou AI. Pokud jste jej ještě nenastavili, podívejte se na [Kapitolu 2: Nastavení vývojového prostředí](../../../02-SetupDevEnvironment/README.md) pro pokyny.

## Klíčové koncepty

**Model Context Protocol (MCP)** je standardizovaný způsob, jak mohou AI aplikace bezpečně připojit externí nástroje. Představte si to jako "most", který umožňuje AI modelům používat externí služby, jako je naše kalkulačka. Místo toho, aby se AI model pokoušel provádět matematiku sám (což může být nespolehlivé), může zavolat naši službu kalkulačky pro přesné výsledky. MCP zajišťuje, že tato komunikace probíhá bezpečně a konzistentně.

**Server-Sent Events (SSE)** umožňuje komunikaci v reálném čase mezi serverem a klienty. Na rozdíl od tradičních HTTP požadavků, kde čekáte na odpověď, SSE umožňuje serveru průběžně posílat aktualizace klientovi. To je ideální pro AI aplikace, kde mohou být odpovědi streamovány nebo zpracování trvá delší dobu.

**AI nástroje a volání funkcí** umožňují AI modelům automaticky vybírat a používat externí funkce (např. operace kalkulačky) na základě požadavků uživatele. Když se zeptáte "Kolik je 15 + 27?", AI model pochopí, že chcete sčítání, automaticky zavolá nástroj `add` s příslušnými parametry (15, 27) a vrátí výsledek v přirozeném jazyce. AI funguje jako inteligentní koordinátor, který ví, kdy a jak použít každý nástroj.

## Rychlý start

### 1. Přejděte do adresáře aplikace kalkulačky
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/mcp/calculator
```

### 2. Sestavte a spusťte
```bash
mvn clean install -DskipTests
java -jar target/calculator-server-0.0.1-SNAPSHOT.jar
```

### 3. Testujte s klienty
- **SDKClient**: Přímá interakce s MCP protokolem
- **LangChain4jClient**: Interakce v přirozeném jazyce s podporou AI (vyžaduje GitHub token)

## Dostupné operace kalkulačky

- `add(a, b)`, `subtract(a, b)`, `multiply(a, b)`, `divide(a, b)`
- `power(base, exponent)`, `squareRoot(number)`, `absolute(number)`
- `modulus(a, b)`, `help()`

## Testovací klienti

### 1. Přímý MCP klient (SDKClient)
Testuje surovou komunikaci MCP protokolu. Spusťte:
```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

### 2. Klient s podporou AI (LangChain4jClient)
Ukazuje interakci v přirozeném jazyce s GitHub modely. Vyžaduje GitHub token (viz [Předpoklady](../../../../../04-PracticalSamples/mcp/calculator)).

**Spusťte:**
```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

## MCP Inspektor (Webové rozhraní)

MCP Inspektor poskytuje vizuální webové rozhraní pro testování vaší MCP služby bez nutnosti psát kód. Ideální pro začátečníky, kteří chtějí pochopit, jak MCP funguje!

### Podrobný návod:

1. **Spusťte server kalkulačky** (pokud již neběží):
   ```bash
   java -jar target/calculator-server-0.0.1-SNAPSHOT.jar
   ```

2. **Nainstalujte a spusťte MCP Inspektor** v novém terminálu:
   ```bash
   npx @modelcontextprotocol/inspector
   ```

3. **Otevřete webové rozhraní**:
   - Hledejte zprávu jako "Inspector running at http://localhost:6274"
   - Otevřete tuto URL adresu ve svém webovém prohlížeči

4. **Připojte se ke své službě kalkulačky**:
   - V webovém rozhraní nastavte typ přenosu na "SSE"
   - Nastavte URL na: `http://localhost:8080/sse`
   - Klikněte na tlačítko "Connect"

5. **Prozkoumejte dostupné nástroje**:
   - Klikněte na "List Tools" pro zobrazení všech operací kalkulačky
   - Uvidíte funkce jako `add`, `subtract`, `multiply` atd.

6. **Otestujte operaci kalkulačky**:
   - Vyberte nástroj (např. "add")
   - Zadejte parametry (např. `a: 15`, `b: 27`)
   - Klikněte na "Run Tool"
   - Zobrazí se výsledek vrácený vaší MCP službou!

Tento vizuální přístup vám pomůže přesně pochopit, jak funguje komunikace MCP, než začnete vytvářet vlastní klienty.

![npx inspector](../../../../../translated_images/tool.214c70103694335c4cfdc2d624373dfce4b0162f6aea089ac1da9051fb563b7f.cs.png)

---
**Reference:** [MCP Server Boot Starter Docs](https://docs.spring.io/spring-ai/reference/api/mcp/mcp-server-boot-starter-docs.html)

**Prohlášení:**  
Tento dokument byl přeložen pomocí služby pro automatický překlad [Co-op Translator](https://github.com/Azure/co-op-translator). Ačkoli se snažíme o přesnost, mějte prosím na paměti, že automatické překlady mohou obsahovat chyby nebo nepřesnosti. Původní dokument v jeho původním jazyce by měl být považován za autoritativní zdroj. Pro důležité informace se doporučuje profesionální lidský překlad. Neodpovídáme za žádná nedorozumění nebo nesprávné interpretace vyplývající z použití tohoto překladu.