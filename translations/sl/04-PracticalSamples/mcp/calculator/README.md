<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "5bd7a347d6ed1d706443f9129dd29dd9",
  "translation_date": "2025-07-25T10:15:05+00:00",
  "source_file": "04-PracticalSamples/mcp/calculator/README.md",
  "language_code": "sl"
}
-->
# Osnovna storitev kalkulatorja MCP

>**Opomba**: To poglavje vključuje [**Vadnico**](./TUTORIAL.md), ki vas vodi skozi primere.

Dobrodošli pri vašem prvem praktičnem delu z **Model Context Protocol (MCP)**! V prejšnjih poglavjih ste se naučili osnov generativne umetne inteligence in nastavili razvojno okolje. Zdaj je čas, da ustvarite nekaj praktičnega.

Ta storitev kalkulatorja prikazuje, kako lahko modeli umetne inteligence varno komunicirajo z zunanjimi orodji prek MCP. Namesto da bi se zanašali na včasih nezanesljive matematične sposobnosti modela AI, vam bomo pokazali, kako zgraditi robusten sistem, kjer AI kliče specializirane storitve za natančne izračune.

## Kazalo

- [Kaj se boste naučili](../../../../../04-PracticalSamples/mcp/calculator)
- [Predpogoji](../../../../../04-PracticalSamples/mcp/calculator)
- [Ključni koncepti](../../../../../04-PracticalSamples/mcp/calculator)
- [Hitri začetek](../../../../../04-PracticalSamples/mcp/calculator)
- [Razpoložljive operacije kalkulatorja](../../../../../04-PracticalSamples/mcp/calculator)
- [Testni odjemalci](../../../../../04-PracticalSamples/mcp/calculator)
  - [1. Neposredni MCP odjemalec (SDKClient)](../../../../../04-PracticalSamples/mcp/calculator)
  - [2. Odjemalec z umetno inteligenco (LangChain4jClient)](../../../../../04-PracticalSamples/mcp/calculator)
- [MCP Inspector (spletni vmesnik)](../../../../../04-PracticalSamples/mcp/calculator)
  - [Navodila po korakih](../../../../../04-PracticalSamples/mcp/calculator)

## Kaj se boste naučili

S tem primerom boste razumeli:
- Kako ustvariti storitve, združljive z MCP, z uporabo Spring Boot
- Razliko med neposredno komunikacijo prek protokola in interakcijo z umetno inteligenco
- Kako modeli umetne inteligence odločajo, kdaj in kako uporabiti zunanja orodja
- Najboljše prakse za gradnjo aplikacij z orodji, ki jih omogoča umetna inteligenca

Popolno za začetnike, ki se učijo konceptov MCP in so pripravljeni zgraditi svojo prvo integracijo AI orodij!

## Predpogoji

- Java 21+
- Maven 3.6+
- **GitHub žeton**: Potreben za odjemalca z umetno inteligenco. Če tega še niste nastavili, si oglejte [Poglavje 2: Nastavitev razvojnega okolja](../../../02-SetupDevEnvironment/README.md) za navodila.

## Ključni koncepti

**Model Context Protocol (MCP)** je standardiziran način, kako aplikacije umetne inteligence varno povezujejo z zunanjimi orodji. Pomislite nanj kot na "most", ki omogoča modelom umetne inteligence uporabo zunanjih storitev, kot je naš kalkulator. Namesto da bi model AI sam izvajal matematične operacije (kar je lahko nezanesljivo), lahko pokliče našo storitev kalkulatorja za natančne rezultate. MCP zagotavlja, da ta komunikacija poteka varno in dosledno.

**Server-Sent Events (SSE)** omogočajo komunikacijo v realnem času med strežnikom in odjemalci. Za razliko od tradicionalnih HTTP zahtevkov, kjer pošljete zahtevo in čakate na odgovor, SSE omogoča strežniku, da neprekinjeno pošilja posodobitve odjemalcu. To je idealno za aplikacije umetne inteligence, kjer se odgovori lahko pretakajo ali potrebujejo čas za obdelavo.

**AI orodja in klicanje funkcij** omogočajo modelom umetne inteligence, da samodejno izberejo in uporabijo zunanje funkcije (kot so operacije kalkulatorja) glede na zahteve uporabnika. Ko vprašate "Koliko je 15 + 27?", model umetne inteligence razume, da želite seštevanje, samodejno pokliče našo funkcijo `add` z ustreznimi parametri (15, 27) in vrne rezultat v naravnem jeziku. AI deluje kot inteligentni koordinator, ki ve, kdaj in kako uporabiti vsako orodje.

## Hitri začetek

### 1. Pomaknite se do direktorija aplikacije kalkulatorja
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/mcp/calculator
```

### 2. Zgradite in zaženite
```bash
mvn clean install -DskipTests
java -jar target/calculator-server-0.0.1-SNAPSHOT.jar
```

### 3. Testirajte z odjemalci
- **SDKClient**: Neposredna interakcija prek MCP protokola
- **LangChain4jClient**: Interakcija v naravnem jeziku z umetno inteligenco (zahteva GitHub žeton)

## Razpoložljive operacije kalkulatorja

- `add(a, b)`, `subtract(a, b)`, `multiply(a, b)`, `divide(a, b)`
- `power(base, exponent)`, `squareRoot(number)`, `absolute(number)`
- `modulus(a, b)`, `help()`

## Testni odjemalci

### 1. Neposredni MCP odjemalec (SDKClient)
Testira surovo komunikacijo prek MCP protokola. Zaženite z:
```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

### 2. Odjemalec z umetno inteligenco (LangChain4jClient)
Prikazuje interakcijo v naravnem jeziku z GitHub modeli. Zahteva GitHub žeton (glejte [Predpogoji](../../../../../04-PracticalSamples/mcp/calculator)).

**Zaženite:**
```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

## MCP Inspector (spletni vmesnik)

MCP Inspector ponuja vizualni spletni vmesnik za testiranje vaše MCP storitve brez pisanja kode. Odlično za začetnike, da razumejo, kako MCP deluje!

### Navodila po korakih:

1. **Zaženite strežnik kalkulatorja** (če še ni zagnan):
   ```bash
   java -jar target/calculator-server-0.0.1-SNAPSHOT.jar
   ```

2. **Namestite in zaženite MCP Inspector** v novem terminalu:
   ```bash
   npx @modelcontextprotocol/inspector
   ```

3. **Odprite spletni vmesnik**:
   - Poiščite sporočilo, kot je "Inspector running at http://localhost:6274"
   - Odprite ta URL v vašem spletnem brskalniku

4. **Povežite se s svojo storitvijo kalkulatorja**:
   - V spletnem vmesniku nastavite vrsto prenosa na "SSE"
   - Nastavite URL na: `http://localhost:8080/sse`
   - Kliknite gumb "Connect"

5. **Raziskujte razpoložljiva orodja**:
   - Kliknite "List Tools", da si ogledate vse operacije kalkulatorja
   - Videli boste funkcije, kot so `add`, `subtract`, `multiply` itd.

6. **Testirajte operacijo kalkulatorja**:
   - Izberite orodje (npr. "add")
   - Vnesite parametre (npr. `a: 15`, `b: 27`)
   - Kliknite "Run Tool"
   - Oglejte si rezultat, ki ga vrne vaša MCP storitev!

Ta vizualni pristop vam pomaga razumeti, kako natančno deluje komunikacija prek MCP, preden zgradite svoje odjemalce.

![npx inspector](../../../../../translated_images/tool.214c70103694335c4cfdc2d624373dfce4b0162f6aea089ac1da9051fb563b7f.sl.png)

---
**Referenca:** [MCP Server Boot Starter Docs](https://docs.spring.io/spring-ai/reference/api/mcp/mcp-server-boot-starter-docs.html)

**Omejitev odgovornosti**:  
Ta dokument je bil preveden z uporabo storitve za prevajanje z umetno inteligenco [Co-op Translator](https://github.com/Azure/co-op-translator). Čeprav si prizadevamo za natančnost, vas prosimo, da upoštevate, da lahko avtomatizirani prevodi vsebujejo napake ali netočnosti. Izvirni dokument v njegovem maternem jeziku je treba obravnavati kot avtoritativni vir. Za ključne informacije priporočamo profesionalni človeški prevod. Ne odgovarjamo za morebitna nesporazumevanja ali napačne razlage, ki izhajajo iz uporabe tega prevoda.