<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "5bd7a347d6ed1d706443f9129dd29dd9",
  "translation_date": "2025-07-25T10:06:14+00:00",
  "source_file": "04-PracticalSamples/mcp/calculator/README.md",
  "language_code": "ro"
}
-->
# Serviciul de Calculator de Bază MCP

>**Notă**: Acest capitol include un [**Tutorial**](./TUTORIAL.md) care te ghidează prin exemple.

Bine ai venit la prima ta experiență practică cu **Model Context Protocol (MCP)**! În capitolele anterioare, ai învățat despre fundamentele AI generative și ai configurat mediul de dezvoltare. Acum este momentul să construim ceva practic.

Acest serviciu de calculator demonstrează cum modelele AI pot interacționa în siguranță cu instrumente externe folosind MCP. În loc să ne bazăm pe capacitățile uneori nesigure ale modelului AI în matematică, îți vom arăta cum să construiești un sistem robust în care AI poate apela servicii specializate pentru calcule precise.

## Cuprins

- [Ce Vei Învăța](../../../../../04-PracticalSamples/mcp/calculator)
- [Cerințe Prealabile](../../../../../04-PracticalSamples/mcp/calculator)
- [Concepte Cheie](../../../../../04-PracticalSamples/mcp/calculator)
- [Start Rapid](../../../../../04-PracticalSamples/mcp/calculator)
- [Operațiuni Disponibile ale Calculatorului](../../../../../04-PracticalSamples/mcp/calculator)
- [Clienți de Testare](../../../../../04-PracticalSamples/mcp/calculator)
  - [1. Client MCP Direct (SDKClient)](../../../../../04-PracticalSamples/mcp/calculator)
  - [2. Client Alimentat de AI (LangChain4jClient)](../../../../../04-PracticalSamples/mcp/calculator)
- [Inspector MCP (Interfață Web)](../../../../../04-PracticalSamples/mcp/calculator)
  - [Instrucțiuni Pas cu Pas](../../../../../04-PracticalSamples/mcp/calculator)

## Ce Vei Învăța

Lucrând prin acest exemplu, vei înțelege:
- Cum să creezi servicii compatibile MCP folosind Spring Boot
- Diferența dintre comunicarea directă prin protocol și interacțiunea alimentată de AI
- Cum modelele AI decid când și cum să utilizeze instrumente externe
- Cele mai bune practici pentru construirea aplicațiilor AI cu instrumente integrate

Perfect pentru începători care învață conceptele MCP și sunt pregătiți să construiască prima lor integrare AI cu instrumente!

## Cerințe Prealabile

- Java 21+
- Maven 3.6+
- **Token GitHub**: Necesar pentru clientul alimentat de AI. Dacă nu l-ai configurat încă, vezi [Capitolul 2: Configurarea mediului de dezvoltare](../../../02-SetupDevEnvironment/README.md) pentru instrucțiuni.

## Concepte Cheie

**Model Context Protocol (MCP)** este o metodă standardizată prin care aplicațiile AI se conectează în siguranță la instrumente externe. Gândește-te la el ca la un "pod" care permite modelelor AI să utilizeze servicii externe, cum ar fi calculatorul nostru. În loc ca modelul AI să încerce să facă calcule singur (ceea ce poate fi nesigur), acesta poate apela serviciul nostru de calculator pentru a obține rezultate precise. MCP asigură că această comunicare are loc în siguranță și în mod consecvent.

**Server-Sent Events (SSE)** permite comunicarea în timp real între server și clienți. Spre deosebire de cererile HTTP tradiționale, unde ceri și aștepți un răspuns, SSE permite serverului să trimită actualizări continue către client. Acest lucru este perfect pentru aplicațiile AI unde răspunsurile pot fi transmise în flux sau pot necesita timp pentru procesare.

**Instrumente AI & Apelarea Funcțiilor** permit modelelor AI să aleagă și să utilizeze automat funcții externe (cum ar fi operațiunile calculatorului) pe baza cererilor utilizatorului. Când întrebi "Cât face 15 + 27?", modelul AI înțelege că vrei o adunare, apelează automat instrumentul `add` cu parametrii corecți (15, 27) și returnează rezultatul în limbaj natural. AI-ul acționează ca un coordonator inteligent care știe când și cum să utilizeze fiecare instrument.

## Start Rapid

### 1. Navighează la directorul aplicației calculatorului
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/mcp/calculator
```

### 2. Construiește și Rulează
```bash
mvn clean install -DskipTests
java -jar target/calculator-server-0.0.1-SNAPSHOT.jar
```

### 3. Testează cu Clienți
- **SDKClient**: Interacțiune directă prin protocolul MCP
- **LangChain4jClient**: Interacțiune în limbaj natural alimentată de AI (necesită token GitHub)

## Operațiuni Disponibile ale Calculatorului

- `add(a, b)`, `subtract(a, b)`, `multiply(a, b)`, `divide(a, b)`
- `power(base, exponent)`, `squareRoot(number)`, `absolute(number)`
- `modulus(a, b)`, `help()`

## Clienți de Testare

### 1. Client MCP Direct (SDKClient)
Testează comunicarea brută prin protocolul MCP. Rulează cu:
```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

### 2. Client Alimentat de AI (LangChain4jClient)
Demonstrează interacțiunea în limbaj natural cu Modelele GitHub. Necesită token GitHub (vezi [Cerințe Prealabile](../../../../../04-PracticalSamples/mcp/calculator)).

**Rulează:**
```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

## Inspector MCP (Interfață Web)

Inspectorul MCP oferă o interfață web vizuală pentru a testa serviciul MCP fără a scrie cod. Perfect pentru începători care vor să înțeleagă cum funcționează MCP!

### Instrucțiuni Pas cu Pas:

1. **Pornește serverul calculatorului** (dacă nu este deja pornit):
   ```bash
   java -jar target/calculator-server-0.0.1-SNAPSHOT.jar
   ```

2. **Instalează și rulează Inspectorul MCP** într-un nou terminal:
   ```bash
   npx @modelcontextprotocol/inspector
   ```

3. **Deschide interfața web**:
   - Caută un mesaj de tipul "Inspector running at http://localhost:6274"
   - Deschide acel URL în browserul tău

4. **Conectează-te la serviciul calculatorului**:
   - În interfața web, setează tipul de transport la "SSE"
   - Setează URL-ul la: `http://localhost:8080/sse`
   - Apasă butonul "Connect"

5. **Explorează instrumentele disponibile**:
   - Apasă "List Tools" pentru a vedea toate operațiunile calculatorului
   - Vei vedea funcții precum `add`, `subtract`, `multiply`, etc.

6. **Testează o operațiune a calculatorului**:
   - Selectează un instrument (de exemplu, "add")
   - Introdu parametrii (de exemplu, `a: 15`, `b: 27`)
   - Apasă "Run Tool"
   - Vezi rezultatul returnat de serviciul MCP!

Această abordare vizuală te ajută să înțelegi exact cum funcționează comunicarea MCP înainte de a-ți construi propriii clienți.

![npx inspector](../../../../../translated_images/tool.214c70103694335c4cfdc2d624373dfce4b0162f6aea089ac1da9051fb563b7f.ro.png)

---
**Referință:** [Documentația MCP Server Boot Starter](https://docs.spring.io/spring-ai/reference/api/mcp/mcp-server-boot-starter-docs.html)

**Declinare de responsabilitate**:  
Acest document a fost tradus folosind serviciul de traducere AI [Co-op Translator](https://github.com/Azure/co-op-translator). Deși ne străduim să asigurăm acuratețea, vă rugăm să rețineți că traducerile automate pot conține erori sau inexactități. Documentul original în limba sa maternă ar trebui considerat sursa autoritară. Pentru informații critice, se recomandă traducerea profesională realizată de un specialist. Nu ne asumăm responsabilitatea pentru eventualele neînțelegeri sau interpretări greșite care pot apărea din utilizarea acestei traduceri.