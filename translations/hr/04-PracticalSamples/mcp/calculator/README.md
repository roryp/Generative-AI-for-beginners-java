<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "7bf9a4a832911269a8bd0decb97ff36c",
  "translation_date": "2025-07-21T21:29:17+00:00",
  "source_file": "04-PracticalSamples/mcp/calculator/README.md",
  "language_code": "hr"
}
-->
# Osnovna Kalkulator MCP Usluga

>**Napomena**: Ovo poglavlje uključuje [**Vodič**](./TUTORIAL.md) koji vas vodi kroz pokretanje gotovih primjera.

Dobrodošli u vaše prvo praktično iskustvo s **Model Context Protocol (MCP)**! U prethodnim poglavljima naučili ste osnove generativne umjetne inteligencije i postavili razvojno okruženje. Sada je vrijeme da izgradite nešto praktično.

Ova kalkulator usluga pokazuje kako AI modeli mogu sigurno komunicirati s vanjskim alatima koristeći MCP. Umjesto da se oslanjamo na ponekad nepouzdane matematičke sposobnosti AI modela, pokazat ćemo kako izgraditi robustan sustav gdje AI može pozivati specijalizirane usluge za točne izračune.

## Sadržaj

- [Što ćete naučiti](../../../../../04-PracticalSamples/mcp/calculator)
- [Preduvjeti](../../../../../04-PracticalSamples/mcp/calculator)
- [Ključni pojmovi](../../../../../04-PracticalSamples/mcp/calculator)
- [Brzi početak](../../../../../04-PracticalSamples/mcp/calculator)
- [Dostupne operacije kalkulatora](../../../../../04-PracticalSamples/mcp/calculator)
- [Testni klijenti](../../../../../04-PracticalSamples/mcp/calculator)
  - [1. Direktni MCP klijent (SDKClient)](../../../../../04-PracticalSamples/mcp/calculator)
  - [2. Klijent s AI podrškom (LangChain4jClient)](../../../../../04-PracticalSamples/mcp/calculator)
- [MCP Inspektor (Web sučelje)](../../../../../04-PracticalSamples/mcp/calculator)
  - [Upute korak po korak](../../../../../04-PracticalSamples/mcp/calculator)

## Što ćete naučiti

Kroz ovaj primjer, razumjet ćete:
- Kako kreirati usluge kompatibilne s MCP-om koristeći Spring Boot
- Razliku između direktne komunikacije putem protokola i interakcije s AI podrškom
- Kako AI modeli odlučuju kada i kako koristiti vanjske alate
- Najbolje prakse za izgradnju AI aplikacija s podrškom za alate

Savršeno za početnike koji uče MCP koncepte i spremni su izgraditi svoju prvu AI integraciju s alatima!

## Preduvjeti

- Java 21+
- Maven 3.6+
- **GitHub Token**: Potreban za klijenta s AI podrškom. Ako ga još niste postavili, pogledajte [Poglavlje 2: Postavljanje razvojnog okruženja](../../../02-SetupDevEnvironment/README.md) za upute.

## Ključni pojmovi

**Model Context Protocol (MCP)** je standardizirani način za AI aplikacije da sigurno povežu vanjske alate. Zamislite ga kao "most" koji omogućuje AI modelima da koriste vanjske usluge poput našeg kalkulatora. Umjesto da AI model pokušava sam raditi matematičke izračune (što može biti nepouzdano), on može pozvati našu kalkulator uslugu za točne rezultate. MCP osigurava da ova komunikacija bude sigurna i dosljedna.

**Server-Sent Events (SSE)** omogućuju komunikaciju u stvarnom vremenu između servera i klijenata. Za razliku od tradicionalnih HTTP zahtjeva gdje postavljate pitanje i čekate odgovor, SSE omogućuje serveru da kontinuirano šalje ažuriranja klijentu. Ovo je idealno za AI aplikacije gdje odgovori mogu biti strujani ili zahtijevati vrijeme za obradu.

**AI alati i pozivanje funkcija** omogućuju AI modelima da automatski biraju i koriste vanjske funkcije (poput operacija kalkulatora) na temelju korisničkih zahtjeva. Kada pitate "Koliko je 15 + 27?", AI model razumije da želite zbrajanje, automatski poziva našu `add` funkciju s odgovarajućim parametrima (15, 27) i vraća rezultat u prirodnom jeziku. AI djeluje kao inteligentni koordinator koji zna kada i kako koristiti svaki alat.

## Brzi početak

### 1. Idite u direktorij aplikacije kalkulatora
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/mcp/calculator
```

### 2. Izgradite i pokrenite
```bash
mvn clean install -DskipTests
java -jar target/calculator-server-0.0.1-SNAPSHOT.jar
```

### 2. Testirajte s klijentima
- **SDKClient**: Direktna interakcija putem MCP protokola
- **LangChain4jClient**: Interakcija putem prirodnog jezika s AI podrškom (zahtijeva GitHub token)

## Dostupne operacije kalkulatora

- `add(a, b)`, `subtract(a, b)`, `multiply(a, b)`, `divide(a, b)`
- `power(base, exponent)`, `squareRoot(number)`, `absolute(number)`
- `modulus(a, b)`, `help()`

## Testni klijenti

### 1. Direktni MCP klijent (SDKClient)
Testira osnovnu komunikaciju putem MCP protokola. Pokrenite s:
```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

### 2. Klijent s AI podrškom (LangChain4jClient)
Pokazuje interakciju putem prirodnog jezika s GitHub modelima. Zahtijeva GitHub token (pogledajte [Preduvjeti](../../../../../04-PracticalSamples/mcp/calculator)).

**Pokrenite:**
```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

## MCP Inspektor (Web sučelje)

MCP Inspektor pruža vizualno web sučelje za testiranje vaše MCP usluge bez pisanja koda. Savršeno za početnike koji žele razumjeti kako MCP funkcionira!

### Upute korak po korak:

1. **Pokrenite kalkulator server** (ako već nije pokrenut):
   ```bash
   java -jar target/calculator-server-0.0.1-SNAPSHOT.jar
   ```

2. **Instalirajte i pokrenite MCP Inspektor** u novom terminalu:
   ```bash
   npx @modelcontextprotocol/inspector
   ```

3. **Otvorite web sučelje**:
   - Potražite poruku poput "Inspektor radi na http://localhost:6274"
   - Otvorite tu URL adresu u vašem web pregledniku

4. **Povežite se s vašom kalkulator uslugom**:
   - U web sučelju, postavite tip transporta na "SSE"
   - Postavite URL na: `http://localhost:8080/sse`
   - Kliknite gumb "Connect"

5. **Istražite dostupne alate**:
   - Kliknite "List Tools" da vidite sve operacije kalkulatora
   - Vidjet ćete funkcije poput `add`, `subtract`, `multiply`, itd.

6. **Testirajte operaciju kalkulatora**:
   - Odaberite alat (npr. "add")
   - Unesite parametre (npr. `a: 15`, `b: 27`)
   - Kliknite "Run Tool"
   - Pogledajte rezultat koji vraća vaša MCP usluga!

Ovaj vizualni pristup pomaže vam da točno razumijete kako MCP komunikacija funkcionira prije nego što izgradite vlastite klijente.

![npx inspektor](../../../../../translated_images/tool.214c70103694335c4cfdc2d624373dfce4b0162f6aea089ac1da9051fb563b7f.hr.png)

---
**Referenca:** [MCP Server Boot Starter Dokumentacija](https://docs.spring.io/spring-ai/reference/api/mcp/mcp-server-boot-starter-docs.html)

**Odricanje od odgovornosti**:  
Ovaj dokument je preveden pomoću AI usluge za prevođenje [Co-op Translator](https://github.com/Azure/co-op-translator). Iako nastojimo osigurati točnost, imajte na umu da automatski prijevodi mogu sadržavati pogreške ili netočnosti. Izvorni dokument na izvornom jeziku treba smatrati autoritativnim izvorom. Za kritične informacije preporučuje se profesionalni prijevod od strane čovjeka. Ne preuzimamo odgovornost za nesporazume ili pogrešna tumačenja koja mogu proizaći iz korištenja ovog prijevoda.