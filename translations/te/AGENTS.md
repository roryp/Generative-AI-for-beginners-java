<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "afc90918d008cf77fd1982691f681306",
  "translation_date": "2025-12-01T09:04:29+00:00",
  "source_file": "AGENTS.md",
  "language_code": "te"
}
-->
# AGENTS.md

## ప్రాజెక్ట్ అవలోకనం

Javaతో Generative AI డెవలప్‌మెంట్ నేర్చుకోవడానికి ఇది ఒక విద్యా రిపోజిటరీ. ఇది Large Language Models (LLMs), prompt engineering, embeddings, RAG (Retrieval-Augmented Generation), మరియు Model Context Protocol (MCP) కవర్ చేసే సమగ్ర హ్యాండ్స్-ఆన్ కోర్సును అందిస్తుంది.

**ముఖ్యమైన టెక్నాలజీలు:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI, మరియు OpenAI SDKs

**ఆర్కిటెక్చర్:**
- చాప్టర్ల ద్వారా ఆర్గనైజ్ చేయబడిన అనేక స్టాండ్అలోన్ Spring Boot అప్లికేషన్లు
- వివిధ AI ప్యాటర్న్లను ప్రదర్శించే నమూనా ప్రాజెక్టులు
- GitHub Codespaces-కు సిద్ధంగా ఉన్న ప్రీ-కాన్ఫిగర్డ్ డెవ్ కంటైనర్లు

## సెటప్ కమాండ్లు

### అవసరమైనవి
- Java 21 లేదా అంతకంటే ఎక్కువ
- Maven 3.x
- GitHub వ్యక్తిగత యాక్సెస్ టోకెన్ (GitHub Models కోసం)
- ఐచ్ఛికం: Azure OpenAI క్రెడెన్షియల్స్

### ఎన్విరాన్‌మెంట్ సెటప్

**ఆప్షన్ 1: GitHub Codespaces (సిఫార్సు చేయబడింది)**
```bash
# రిపోజిటరీని ఫోర్క్ చేసి GitHub UI నుండి కోడ్‌స్పేస్‌ను సృష్టించండి
# డెవ్ కంటైనర్ స్వయంచాలకంగా అన్ని డిపెండెన్సీలను ఇన్‌స్టాల్ చేస్తుంది
# పరిసరాల సెటప్ కోసం సుమారు 2 నిమిషాలు వేచి ఉండండి
```

**ఆప్షన్ 2: లోకల్ డెవ్ కంటైనర్**
```bash
# రిపోజిటరీని క్లోన్ చేయండి
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# డెవ్ కంటైనర్స్ ఎక్స్‌టెన్షన్‌తో VS కోడ్‌లో తెరవండి
# అడిగినప్పుడు కంటైనర్‌లో మళ్లీ తెరవండి
```

**ఆప్షన్ 3: లోకల్ సెటప్**
```bash
# ఆధారాలను ఇన్స్టాల్ చేయండి
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# ఇన్స్టాలేషన్‌ను ధృవీకరించండి
java -version
mvn -version
```

### కాన్ఫిగరేషన్

**GitHub టోకెన్ సెటప్:**
```bash
# GitHub వ్యక్తిగత యాక్సెస్ టోకెన్ సృష్టించండి
# పర్యావరణ వేరియబుల్ సెట్ చేయండి
export GITHUB_TOKEN="your-token-here"
```

**Azure OpenAI సెటప్ (ఐచ్ఛికం):**
```bash
# Azure OpenAI ఉపయోగించే ఉదాహరణల కోసం
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# మీ Azure OpenAI ప్రమాణాలను .env లో సవరించండి
```

## డెవలప్‌మెంట్ వర్క్‌ఫ్లో

### ప్రాజెక్ట్ స్ట్రక్చర్
```
/
├── 01-IntroToGenAI/              # Chapter 1: Introduction
├── 02-SetupDevEnvironment/       # Chapter 2: Environment setup
│   └── examples/                 # Working examples
├── 03-CoreGenerativeAITechniques/ # Chapter 3: Core techniques
├── 04-PracticalSamples/          # Chapter 4: Sample projects
│   ├── calculator/               # MCP service example
│   ├── foundrylocal/            # Local model integration
│   └── petstory/                # Multi-modal app
├── 05-ResponsibleGenAI/         # Chapter 5: Responsible AI
└── translations/                # Multi-language support
```

### అప్లికేషన్లను రన్ చేయడం

**Spring Boot అప్లికేషన్‌ను రన్ చేయడం:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**ప్రాజెక్ట్‌ను బిల్డ్ చేయడం:**
```bash
cd [project-directory]
mvn clean install
```

**MCP Calculator Server ప్రారంభించడం:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# సర్వర్ http://localhost:8080 పై నడుస్తుంది
```

**క్లయింట్ ఉదాహరణలను రన్ చేయడం:**
```bash
# మరో టెర్మినల్‌లో సర్వర్ ప్రారంభించిన తర్వాత
cd 04-PracticalSamples/calculator

# డైరెక్ట్ MCP క్లయింట్
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient"

# AI-చోదిత క్లయింట్ (GITHUB_TOKEN అవసరం)
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient"

# ఇంటరాక్టివ్ బాట్
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.Bot"
```

### హాట్ రీలోడ్
Spring Boot DevTools హాట్ రీలోడ్‌ను సపోర్ట్ చేసే ప్రాజెక్టుల్లో చేర్చబడింది:
```bash
# జావా ఫైళ్లలో మార్పులు సేవ్ చేసినప్పుడు స్వయంచాలకంగా రీలోడ్ అవుతాయి
mvn spring-boot:run
```

## టెస్టింగ్ సూచనలు

### టెస్టులు రన్ చేయడం

**ప్రాజెక్ట్‌లో అన్ని టెస్టులను రన్ చేయండి:**
```bash
cd [project-directory]
mvn test
```

**వర్బోస్ అవుట్‌పుట్‌తో టెస్టులను రన్ చేయండి:**
```bash
mvn test -X
```

**ఒక నిర్దిష్ట టెస్ట్ క్లాస్‌ను రన్ చేయండి:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### టెస్ట్ స్ట్రక్చర్
- టెస్ట్ ఫైళ్లు JUnit 5 (Jupiter) ఉపయోగిస్తాయి
- టెస్ట్ క్లాసులు `src/test/java/` లో ఉంటాయి
- Calculator ప్రాజెక్ట్‌లోని క్లయింట్ ఉదాహరణలు `src/test/java/com/microsoft/mcp/sample/client/` లో ఉంటాయి

### మాన్యువల్ టెస్టింగ్
చాలా ఉదాహరణలు ఇంటరాక్టివ్ అప్లికేషన్లు, మాన్యువల్ టెస్టింగ్ అవసరం:

1. `mvn spring-boot:run` తో అప్లికేషన్‌ను ప్రారంభించండి
2. ఎండ్‌పాయింట్లను టెస్ట్ చేయండి లేదా CLIతో ఇంటరాక్ట్ చేయండి
3. ప్రతి ప్రాజెక్ట్ README.md లోని డాక్యుమెంటేషన్‌కు సరిపోలే ఆశించిన ప్రవర్తనను ధృవీకరించండి

### GitHub Modelsతో టెస్టింగ్
- ఉచిత టియర్ పరిమితులు: 15 రిక్వెస్టులు/నిమిషం, 150/రోజు
- గరిష్టంగా 5 కాంకరెంట్ రిక్వెస్టులు
- బాధ్యతాయుతమైన AI ఉదాహరణలతో కంటెంట్ ఫిల్టరింగ్‌ను టెస్ట్ చేయండి

## కోడ్ స్టైల్ మార్గదర్శకాలు

### Java కన్వెన్షన్లు
- **Java వెర్షన్:** Java 21 ఆధునిక ఫీచర్లతో
- **స్టైల్:** ప్రామాణిక Java కన్వెన్షన్లను అనుసరించండి
- **నేమింగ్:** 
  - క్లాసులు: PascalCase
  - మెథడ్లు/వేరియబుల్స్: camelCase
  - కాన్స్టెంట్స్: UPPER_SNAKE_CASE
  - ప్యాకేజీ పేర్లు: చిన్న అక్షరాలు

### Spring Boot ప్యాటర్న్లు
- బిజినెస్ లాజిక్ కోసం `@Service` ఉపయోగించండి
- REST ఎండ్‌పాయింట్ల కోసం `@RestController` ఉపయోగించండి
- `application.yml` లేదా `application.properties` ద్వారా కాన్ఫిగరేషన్
- హార్డ్-కోడ్ చేసిన విలువల కంటే ఎన్విరాన్‌మెంట్ వేరియబుల్స్ ప్రాధాన్యత
- MCP-ఎక్స్‌పోజ్ చేసిన మెథడ్ల కోసం `@Tool` అనోటేషన్ ఉపయోగించండి

### ఫైల్ ఆర్గనైజేషన్
```
src/
├── main/
│   ├── java/
│   │   └── com/microsoft/[component]/
│   │       ├── [Component]Application.java
│   │       ├── config/
│   │       ├── controller/
│   │       ├── service/
│   │       └── exception/
│   └── resources/
│       ├── application.yml
│       └── static/
└── test/
    └── java/
        └── com/microsoft/[component]/
```

### డిపెండెన్సీలు
- Maven `pom.xml` ద్వారా నిర్వహించబడతాయి
- Spring AI BOM వెర్షన్ మేనేజ్‌మెంట్ కోసం
- AI ఇంటిగ్రేషన్ల కోసం LangChain4j
- Spring డిపెండెన్సీల కోసం Spring Boot స్టార్టర్ పేరెంట్

### కోడ్ కామెంట్లు
- పబ్లిక్ APIs కోసం JavaDoc చేర్చండి
- క్లిష్టమైన AI ఇంటరాక్షన్లకు వివరణాత్మక కామెంట్లు చేర్చండి
- MCP టూల్ వివరణలను స్పష్టంగా డాక్యుమెంట్ చేయండి

## బిల్డ్ మరియు డిప్లాయ్‌మెంట్

### ప్రాజెక్ట్‌లను బిల్డ్ చేయడం

**టెస్టులు లేకుండా బిల్డ్ చేయండి:**
```bash
mvn clean install -DskipTests
```

**అన్ని చెక్స్‌తో బిల్డ్ చేయండి:**
```bash
mvn clean install
```

**అప్లికేషన్‌ను ప్యాకేజ్ చేయండి:**
```bash
mvn package
# టార్గెట్/ డైరెక్టరీలో JARని సృష్టిస్తుంది
```

### అవుట్‌పుట్ డైరెక్టరీలు
- కంపైల్ చేసిన క్లాసులు: `target/classes/`
- టెస్ట్ క్లాసులు: `target/test-classes/`
- JAR ఫైళ్లు: `target/*.jar`
- Maven ఆర్టిఫాక్ట్స్: `target/`

### ఎన్విరాన్‌మెంట్-స్పెసిఫిక్ కాన్ఫిగరేషన్

**డెవలప్‌మెంట్:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**ప్రొడక్షన్:**
- GitHub Models స్థానంలో Azure AI Foundry Models ఉపయోగించండి
- బేస్-urlను Azure OpenAI ఎండ్‌పాయింట్‌కు అప్‌డేట్ చేయండి
- సీక్రెట్స్‌ను Azure Key Vault లేదా ఎన్విరాన్‌మెంట్ వేరియబుల్స్ ద్వారా నిర్వహించండి

### డిప్లాయ్‌మెంట్ పరిశీలనలు
- ఇది విద్యా రిపోజిటరీ, నమూనా అప్లికేషన్లతో
- ప్రొడక్షన్ డిప్లాయ్‌మెంట్ కోసం డిజైన్ చేయబడలేదు
- నమూనాలు ప్రొడక్షన్ ఉపయోగానికి అనుకూలంగా మార్చడానికి ప్యాటర్న్లను ప్రదర్శిస్తాయి
- ప్రత్యేక డిప్లాయ్‌మెంట్ నోట్స్ కోసం వ్యక్తిగత ప్రాజెక్ట్ READMEలను చూడండి

## అదనపు గమనికలు

### GitHub Models vs Azure OpenAI
- **GitHub Models:** నేర్చుకోవడానికి ఉచిత టియర్, క్రెడిట్ కార్డ్ అవసరం లేదు
- **Azure OpenAI:** ప్రొడక్షన్-రెడీ, Azure సబ్‌స్క్రిప్షన్ అవసరం
- కోడ్ రెండింటికీ అనుకూలంగా ఉంటుంది - ఎండ్‌పాయింట్ మరియు API కీని మార్చండి

### బహుళ ప్రాజెక్టులతో పని చేయడం
ప్రతి నమూనా ప్రాజెక్ట్ స్టాండ్అలోన్:
```bash
# నిర్దిష్ట ప్రాజెక్ట్‌కు నావిగేట్ చేయండి
cd 04-PracticalSamples/[project-name]

# ప్రతి ఒక్కదానికి తన స్వంత pom.xml ఉంటుంది మరియు స్వతంత్రంగా నిర్మించవచ్చు
mvn clean install
```

### సాధారణ సమస్యలు

**Java వెర్షన్ మిస్‌మ్యాచ్:**
```bash
# జావా 21ని ధృవీకరించండి
java -version
# అవసరమైతే JAVA_HOMEని నవీకరించండి
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**డిపెండెన్సీ డౌన్‌లోడ్ సమస్యలు:**
```bash
# మావెన్ క్యాష్‌ను క్లియర్ చేసి మళ్లీ ప్రయత్నించండి
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub టోకెన్ కనుగొనబడలేదు:**
```bash
# ప్రస్తుత సెషన్‌లో సెట్ చేయండి
export GITHUB_TOKEN="your-token-here"

# లేదా ప్రాజెక్ట్ డైరెక్టరీలో .env ఫైల్ ఉపయోగించండి
echo "GITHUB_TOKEN=your-token-here" > .env
```

**పోర్ట్ ఇప్పటికే ఉపయోగంలో ఉంది:**
```bash
# స్ప్రింగ్ బూట్ డిఫాల్ట్‌గా 8080 పోర్ట్‌ను ఉపయోగిస్తుంది
# application.properties లో మార్పు:
server.port=8081
```

### బహుళ-భాషా మద్దతు
- 45+ భాషల్లో డాక్యుమెంటేషన్ అందుబాటులో ఉంది ఆటోమేటెడ్ అనువాదం ద్వారా
- అనువాదాలు `translations/` డైరెక్టరీలో
- GitHub Actions వర్క్‌ఫ్లో ద్వారా అనువాదం నిర్వహించబడుతుంది

### లెర్నింగ్ పాత్
1. [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md) తో ప్రారంభించండి
2. చాప్టర్లను క్రమంగా అనుసరించండి (01 → 05)
3. ప్రతి చాప్టర్‌లో హ్యాండ్స్-ఆన్ ఉదాహరణలను పూర్తి చేయండి
4. చాప్టర్ 4లో నమూనా ప్రాజెక్టులను అన్వేషించండి
5. చాప్టర్ 5లో బాధ్యతాయుతమైన AI ఆచరణలను నేర్చుకోండి

### డెవలప్‌మెంట్ కంటైనర్
`.devcontainer/devcontainer.json` కాంటైనర్‌ను కాన్ఫిగర్ చేస్తుంది:
- Java 21 డెవలప్‌మెంట్ ఎన్విరాన్‌మెంట్
- Maven ప్రీ-ఇన్‌స్టాల్ చేయబడింది
- VS Code Java ఎక్స్‌టెన్షన్లు
- Spring Boot టూల్స్
- GitHub Copilot ఇంటిగ్రేషన్
- Docker-in-Docker మద్దతు
- Azure CLI

### పనితీరు పరిశీలనలు
- GitHub Models ఉచిత టియర్ రేట్ పరిమితులు ఉన్నాయి
- Embeddings కోసం సరైన బ్యాచ్ సైజ్‌లను ఉపయోగించండి
- పునరావృత API కాల్స్ కోసం క్యాషింగ్‌ను పరిగణించండి
- ఖర్చు ఆప్టిమైజేషన్ కోసం టోకెన్ వినియోగాన్ని మానిటర్ చేయండి

### భద్రత గమనికలు
- `.env` ఫైళ్లను ఎప్పుడూ కమిట్ చేయవద్దు (`.gitignore`లో ఇప్పటికే ఉంది)
- API కీల కోసం ఎన్విరాన్‌మెంట్ వేరియబుల్స్ ఉపయోగించండి
- GitHub టోకెన్లు అవసరమైన కనీస స్కోప్స్ కలిగి ఉండాలి
- చాప్టర్ 5లో బాధ్యతాయుతమైన AI మార్గదర్శకాలను అనుసరించండి

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**అస్వీకరణ**:  
ఈ పత్రం AI అనువాద సేవ [Co-op Translator](https://github.com/Azure/co-op-translator) ఉపయోగించి అనువదించబడింది. మేము ఖచ్చితత్వానికి ప్రయత్నిస్తున్నప్పటికీ, ఆటోమేటెడ్ అనువాదాలు తప్పులు లేదా అసమగ్రతలను కలిగి ఉండవచ్చు. దాని స్వదేశ భాషలో ఉన్న అసలు పత్రాన్ని అధికారం కలిగిన మూలంగా పరిగణించాలి. ముఖ్యమైన సమాచారం కోసం, ప్రొఫెషనల్ మానవ అనువాదాన్ని సిఫారసు చేస్తాము. ఈ అనువాదాన్ని ఉపయోగించడం వల్ల కలిగే ఏవైనా అపార్థాలు లేదా తప్పుదారులు కోసం మేము బాధ్యత వహించము.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->