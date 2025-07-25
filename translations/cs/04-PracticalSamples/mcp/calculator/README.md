<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "5bd7a347d6ed1d706443f9129dd29dd9",
  "translation_date": "2025-07-25T10:01:57+00:00",
  "source_file": "04-PracticalSamples/mcp/calculator/README.md",
  "language_code": "cs"
}
-->
# Základní kalkulační služba MCP

>**Note**: Tato kapitola obsahuje [**Návod**](./TUTORIAL.md), který vás provede ukázkami.

Vítejte u svého prvního praktického zážitku s **Model Context Protocol (MCP)**! V předchozích kapitolách jste se naučili základy generativní AI a nastavili si vývojové prostředí. Nyní je čas vytvořit něco praktického.

Tato kalkulační služba demonstruje, jak mohou AI modely bezpečně komunikovat s externími nástroji pomocí MCP. Místo spoléhání na občas nespolehlivé matematické schopnosti AI modelu vám ukážeme, jak vytvořit robustní systém, kde AI může volat specializované služby pro přesné výpočty.

## Obsah

- [Co se naučíte](../../../../../04-PracticalSamples/mcp/calculator)
- [Předpoklady](../../../../../04-PracticalSamples/mcp/calculator)
- [Klíčové koncepty](../../../../../04-PracticalSamples/mcp/calculator)
- [Rychlý start](../../../../../04-PracticalSamples/mcp/calculator)
- [Dostupné kalkulační operace](../../../../../04-PracticalSamples/mcp/calculator)
- [Testovací klienti](../../../../../04-PracticalSamples/mcp/calculator)
  - [1. Přímý MCP klient (SDKClient)](../../../../../04-PracticalSamples/mcp/calculator)
  - [2. Klient poháněný AI (LangChain4jClient)](../../../../../04-PracticalSamples/mcp/calculator)
- [MCP Inspector (Webové rozhraní)](../../../../../04-PracticalSamples/mcp/calculator)
  - [Podrobný návod](../../../../../04-PracticalSamples/mcp/calculator)

## Co se naučíte

Prostřednictvím tohoto příkladu pochopíte:
- Jak vytvořit služby kompatibilní s MCP pomocí Spring Boot
- Rozdíl mezi přímou komunikací protokolu a interakcí poháněnou AI
- Jak AI modely rozhodují, kdy a jak používat externí nástroje
- Nejlepší postupy pro vytváření AI aplikací s podporou nástrojů

Ideální pro začátečníky, kteří se učí koncepty MCP a jsou připraveni vytvořit svou první integraci AI nástroje!

## Předpoklady

- Java 21+
- Maven 3.6+
- **GitHub Token**: Vyžadováno pro klienta poháněného AI. Pokud jste si jej ještě nenastavili, podívejte se na [Kapitolu 2: Nastavení vývojového prostředí](../../../02-SetupDevEnvironment/README.md) pro pokyny.

## Klíčové koncepty

**Model Context Protocol (MCP)** je standardizovaný způsob, jak mohou AI aplikace bezpečně komunikovat s externími nástroji. Představte si to jako "most", který umožňuje AI modelům používat externí služby, jako je naše kalkulačka. Místo toho, aby se AI model pokoušel provádět matematické operace sám (což může být nespolehlivé), může zavolat naši kalkulační službu pro přesné výsledky. MCP zajišťuje, že tato komunikace probíhá bezpečně a konzistentně.

**Server-Sent Events (SSE)** umožňují komunikaci v reálném čase mezi serverem a klienty. Na rozdíl od tradičních HTTP požadavků, kde čekáte na odpověď, SSE umožňuje serveru neustále posílat aktualizace klientovi. To je ideální pro AI aplikace, kde odpovědi mohou být streamovány nebo vyžadovat čas na zpracování.

**AI nástroje a volání funkcí** umožňují AI modelům automaticky vybírat a používat externí funkce (jako kalkulační operace) na základě požadavků uživatele. Když se zeptáte "Kolik je 15 + 27?", AI model pochopí, že chcete sčítání, automaticky zavolá nástroj `add` s příslušnými parametry (15, 27) a vrátí výsledek v přirozeném jazyce. AI funguje jako inteligentní koordinátor, který ví, kdy a jak použít každý nástroj.

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
- **SDKClient**: Přímá interakce MCP protokolu
- **LangChain4jClient**: Interakce v přirozeném jazyce poháněná AI (vyžaduje GitHub token)

## Dostupné kalkulační operace

- `add(a, b)`, `subtract(a, b)`, `multiply(a, b)`, `divide(a, b)`
- `power(base, exponent)`, `squareRoot(number)`, `absolute(number)`
- `modulus(a, b)`, `help()`

## Testovací klienti

### 1. Přímý MCP klient (SDKClient)
Testuje surovou komunikaci MCP protokolu. Spusťte:
```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

### 2. Klient poháněný AI (LangChain4jClient)
Ukazuje interakci v přirozeném jazyce s GitHub modely. Vyžaduje GitHub token (viz [Předpoklady](../../../../../04-PracticalSamples/mcp/calculator)).

**Spusťte:**
```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

## MCP Inspector (Webové rozhraní)

MCP Inspector poskytuje vizuální webové rozhraní pro testování vaší MCP služby bez nutnosti psát kód. Ideální pro začátečníky, kteří chtějí pochopit, jak MCP funguje!

### Podrobný návod:

1. **Spusťte server kalkulačky** (pokud již neběží):
   ```bash
   java -jar target/calculator-server-0.0.1-SNAPSHOT.jar
   ```

2. **Nainstalujte a spusťte MCP Inspector** v novém terminálu:
   ```bash
   npx @modelcontextprotocol/inspector
   ```

3. **Otevřete webové rozhraní**:
   - Vyhledejte zprávu jako "Inspector running at http://localhost:6274"
   - Otevřete tuto URL adresu ve svém webovém prohlížeči

4. **Připojte se ke své kalkulační službě**:
   - Ve webovém rozhraní nastavte typ přenosu na "SSE"
   - Nastavte URL na: `http://localhost:8080/sse`
   - Klikněte na tlačítko "Connect"

5. **Prozkoumejte dostupné nástroje**:
   - Klikněte na "List Tools" pro zobrazení všech kalkulačních operací
   - Uvidíte funkce jako `add`, `subtract`, `multiply` atd.

6. **Otestujte kalkulační operaci**:
   - Vyberte nástroj (např. "add")
   - Zadejte parametry (např. `a: 15`, `b: 27`)
   - Klikněte na "Run Tool"
   - Zobrazí se výsledek vrácený vaší MCP službou!

Tento vizuální přístup vám pomůže přesně pochopit, jak funguje komunikace MCP, než začnete vytvářet vlastní klienty.

![npx inspector](../../../../../translated_images/tool.214c70103694335c4cfdc2d624373dfce4b0162f6aea089ac1da9051fb563b7f.cs.png)

---
**Reference:** [MCP Server Boot Starter Docs](https://docs.spring.io/spring-ai/reference/api/mcp/mcp-server-boot-starter-docs.html)

**Prohlášení:**  
Tento dokument byl přeložen pomocí služby pro automatický překlad [Co-op Translator](https://github.com/Azure/co-op-translator). I když se snažíme o přesnost, mějte prosím na paměti, že automatické překlady mohou obsahovat chyby nebo nepřesnosti. Původní dokument v jeho původním jazyce by měl být považován za autoritativní zdroj. Pro důležité informace doporučujeme profesionální lidský překlad. Neodpovídáme za žádná nedorozumění nebo nesprávné interpretace vyplývající z použití tohoto překladu.