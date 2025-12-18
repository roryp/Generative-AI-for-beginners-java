<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "afc90918d008cf77fd1982691f681306",
  "translation_date": "2025-12-01T09:06:25+00:00",
  "source_file": "AGENTS.md",
  "language_code": "ml"
}
-->
# AGENTS.md

## പ്രോജക്റ്റ് അവലോകനം

Java ഉപയോഗിച്ച് Generative AI വികസനം പഠിക്കുന്നതിനുള്ള ഒരു വിദ്യാഭ്യാസ റിപോസിറ്ററിയാണ് ഇത്. Large Language Models (LLMs), prompt engineering, embeddings, RAG (Retrieval-Augmented Generation), Model Context Protocol (MCP) എന്നിവ ഉൾപ്പെടുന്ന ഒരു സമഗ്രമായ പ്രായോഗിക കോഴ്സ് ഇത് നൽകുന്നു.

**പ്രധാന സാങ്കേതികവിദ്യകൾ:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI, OpenAI SDKs

**ആർക്കിടെക്ചർ:**
- അദ്ധ്യായങ്ങൾ പ്രകാരം ക്രമീകരിച്ച നിരവധി സ്വതന്ത്ര Spring Boot ആപ്ലിക്കേഷനുകൾ
- വ്യത്യസ്ത AI പാറ്റേണുകൾ പ്രദർശിപ്പിക്കുന്ന സാമ്പിള് പ്രോജക്റ്റുകൾ
- GitHub Codespaces-Ready, മുൻകൂട്ടി ക്രമീകരിച്ച ഡെവ് കണ്ടെയ്‌നറുകൾ

## സെറ്റപ്പ് കമാൻഡുകൾ

### ആവശ്യമായവ
- Java 21 അല്ലെങ്കിൽ അതിനുമുകളിൽ
- Maven 3.x
- GitHub വ്യക്തിഗത ആക്സസ് ടോക്കൺ (GitHub Models-ക്കായി)
- ഓപ്ഷണൽ: Azure OpenAI ക്രെഡൻഷ്യലുകൾ

### പരിസ്ഥിതി ക്രമീകരണം

**ഓപ്ഷൻ 1: GitHub Codespaces (ശുപാർശ ചെയ്യുന്നു)**
```bash
# റിപോസിറ്ററി ഫോർക്ക് ചെയ്ത് GitHub UIയിൽ നിന്ന് ഒരു കോഡ്സ്പേസ് സൃഷ്ടിക്കുക
# ഡെവ് കണ്ടെയ്നർ സ്വയമേവ എല്ലാ ആശ്രിതങ്ങൾ ഇൻസ്റ്റാൾ ചെയ്യും
# പരിസ്ഥിതി സജ്ജീകരണത്തിന് ഏകദേശം 2 മിനിറ്റ് കാത്തിരിക്കുക
```

**ഓപ്ഷൻ 2: ലോക്കൽ ഡെവ് കണ്ടെയ്‌നർ**
```bash
# റിപ്പോസിറ്ററി ക്ലോൺ ചെയ്യുക
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# ഡെവ് കണ്ടെയ്‌നറുകൾ എക്സ്റ്റൻഷൻ ഉപയോഗിച്ച് VS കോഡിൽ തുറക്കുക
# ചോദിച്ചാൽ കണ്ടെയ്‌നറിൽ വീണ്ടും തുറക്കുക
```

**ഓപ്ഷൻ 3: ലോക്കൽ സെറ്റപ്പ്**
```bash
# ആശ്രിതങ്ങൾ ഇൻസ്റ്റാൾ ചെയ്യുക
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# ഇൻസ്റ്റലേഷൻ സ്ഥിരീകരിക്കുക
java -version
mvn -version
```

### കോൺഫിഗറേഷൻ

**GitHub ടോക്കൺ ക്രമീകരണം:**
```bash
# GitHub വ്യക്തിഗത ആക്സസ് ടോക്കൺ സൃഷ്ടിക്കുക
# പരിസ്ഥിതി ചോദ്യചിഹ്നം സജ്ജമാക്കുക
export GITHUB_TOKEN="your-token-here"
```

**Azure OpenAI ക്രമീകരണം (ഓപ്ഷണൽ):**
```bash
# Azure OpenAI ഉപയോഗിക്കുന്ന ഉദാഹരണങ്ങൾക്കായി
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# നിങ്ങളുടെ Azure OpenAI ക്രെഡൻഷ്യലുകൾ ഉപയോഗിച്ച് .env എഡിറ്റ് ചെയ്യുക
```

## വികസന പ്രവൃത്തി പ്രവാഹം

### പ്രോജക്റ്റ് ഘടന
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

### ആപ്ലിക്കേഷനുകൾ പ്രവർത്തിപ്പിക്കൽ

**Spring Boot ആപ്ലിക്കേഷൻ പ്രവർത്തിപ്പിക്കൽ:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**പ്രോജക്റ്റ് നിർമ്മിക്കൽ:**
```bash
cd [project-directory]
mvn clean install
```

**MCP Calculator Server ആരംഭിക്കൽ:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# സെർവർ http://localhost:8080-ൽ പ്രവർത്തിക്കുന്നു
```

**Client ഉദാഹരണങ്ങൾ പ്രവർത്തിപ്പിക്കൽ:**
```bash
# മറ്റൊരു ടെർമിനലിൽ സെർവർ ആരംഭിച്ചതിന് ശേഷം
cd 04-PracticalSamples/calculator

# നേരിട്ടുള്ള MCP ക്ലയന്റ്
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient"

# AI-ചാലിത ക്ലയന്റ് (GITHUB_TOKEN ആവശ്യമാണ്)
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient"

# ഇന്ററാക്ടീവ് ബോട്ട്
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.Bot"
```

### ഹോട്ട് റീലോഡ്
Spring Boot DevTools ഹോട്ട് റീലോഡ് പിന്തുണയ്ക്കുന്ന പ്രോജക്റ്റുകളിൽ ഉൾപ്പെടുത്തിയിട്ടുണ്ട്:
```bash
# ജാവ ഫയലുകളിൽ മാറ്റങ്ങൾ സേവ് ചെയ്താൽ സ്വയം റീലോഡ് ചെയ്യും
mvn spring-boot:run
```

## ടെസ്റ്റിംഗ് നിർദ്ദേശങ്ങൾ

### ടെസ്റ്റുകൾ പ്രവർത്തിപ്പിക്കൽ

**ഒരു പ്രോജക്റ്റിലെ എല്ലാ ടെസ്റ്റുകളും പ്രവർത്തിപ്പിക്കുക:**
```bash
cd [project-directory]
mvn test
```

**വിസ്തൃത ഔട്ട്പുട്ട് ഉപയോഗിച്ച് ടെസ്റ്റുകൾ പ്രവർത്തിപ്പിക്കുക:**
```bash
mvn test -X
```

**നിർദ്ദിഷ്ട ടെസ്റ്റ് ക്ലാസ് പ്രവർത്തിപ്പിക്കുക:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### ടെസ്റ്റ് ഘടന
- ടെസ്റ്റ് ഫയലുകൾ JUnit 5 (Jupiter) ഉപയോഗിക്കുന്നു
- ടെസ്റ്റ് ക്ലാസുകൾ `src/test/java/`-ൽ സ്ഥിതിചെയ്യുന്നു
- കാൽക്കുലേറ്റർ പ്രോജക്റ്റിലെ Client ഉദാഹരണങ്ങൾ `src/test/java/com/microsoft/mcp/sample/client/`-ൽ

### മാനുവൽ ടെസ്റ്റിംഗ്
ചില ഉദാഹരണങ്ങൾ ഇന്ററാക്ടീവ് ആപ്ലിക്കേഷനുകളാണ്, അവ മാനുവൽ ടെസ്റ്റിംഗ് ആവശ്യമാണ്:

1. `mvn spring-boot:run` ഉപയോഗിച്ച് ആപ്ലിക്കേഷൻ ആരംഭിക്കുക
2. എന്റ്പോയിന്റുകൾ ടെസ്റ്റ് ചെയ്യുക അല്ലെങ്കിൽ CLI ഉപയോഗിച്ച് ഇടപെടുക
3. ഓരോ പ്രോജക്റ്റിന്റെ README.md-ൽ ഉള്ള ഡോക്യുമെന്റേഷനുമായി പ്രതീക്ഷിക്കുന്ന പെരുമാറ്റം പൊരുത്തപ്പെടുന്നുണ്ടെന്ന് ഉറപ്പാക്കുക

### GitHub Models ഉപയോഗിച്ച് ടെസ്റ്റിംഗ്
- സൗജന്യ ടയർ പരിധികൾ: 15 അഭ്യർത്ഥനകൾ/മിനിറ്റ്, 150/ദിവസം
- പരമാവധി 5 സമകാലിക അഭ്യർത്ഥനകൾ
- ഉത്തരവാദിത്വമുള്ള AI ഉദാഹരണങ്ങൾ ഉപയോഗിച്ച് ഉള്ളടക്കം ഫിൽട്ടർ ചെയ്യുക

## കോഡ് സ്റ്റൈൽ മാർഗനിർദ്ദേശങ്ങൾ

### Java കൺവെൻഷനുകൾ
- **Java പതിപ്പ്:** Java 21, ആധുനിക സവിശേഷതകളോടെ
- **സ്റ്റൈൽ:** സാധാരണ Java കൺവെൻഷനുകൾ പിന്തുടരുക
- **നാമകരണം:** 
  - ക്ലാസുകൾ: PascalCase
  - മെത്തഡുകൾ/വേരിയബിളുകൾ: camelCase
  - Constants: UPPER_SNAKE_CASE
  - പാക്കേജ് നാമങ്ങൾ: ചെറിയക്ഷരങ്ങൾ

### Spring Boot പാറ്റേണുകൾ
- ബിസിനസ് ലജിക്‌ക്കായി `@Service` ഉപയോഗിക്കുക
- REST എന്റ്പോയിന്റുകൾക്കായി `@RestController` ഉപയോഗിക്കുക
- `application.yml` അല്ലെങ്കിൽ `application.properties` വഴി കോൺഫിഗറേഷൻ
- ഹാർഡ്-കോഡ് ചെയ്ത മൂല്യങ്ങൾക്കു പകരം പരിസ്ഥിതി വേരിയബിളുകൾ ഉപയോഗിക്കുക
- MCP-എക്സ്പോസ് ചെയ്ത മെത്തഡുകൾക്കായി `@Tool` അനോട്ടേഷൻ ഉപയോഗിക്കുക

### ഫയൽ ക്രമീകരണം
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

### ആശ്രിതങ്ങൾ
- Maven `pom.xml` വഴി മാനേജുചെയ്യുന്നു
- Spring AI BOM പതിപ്പ് മാനേജ്മെന്റിനായി
- AI ഇന്റഗ്രേഷനുകൾക്കായി LangChain4j
- Spring ആശ്രിതങ്ങൾക്കായി Spring Boot സ്റ്റാർട്ടർ പാരന്റ്

### കോഡ് കമന്റുകൾ
- പൊതു APIs-ക്കായി JavaDoc ചേർക്കുക
- സങ്കീർണ്ണമായ AI ഇടപെടലുകൾക്കായി വിശദീകരണ കമന്റുകൾ ഉൾപ്പെടുത്തുക
- MCP ടൂൾ വിവരണങ്ങൾ വ്യക്തമായി ഡോക്യുമെന്റ് ചെയ്യുക

## നിർമ്മാണവും ഡെപ്ലോയ്മെന്റും

### പ്രോജക്റ്റുകൾ നിർമ്മിക്കൽ

**ടെസ്റ്റുകൾ ഇല്ലാതെ നിർമ്മിക്കുക:**
```bash
mvn clean install -DskipTests
```

**എല്ലാ പരിശോധനകളോടും നിർമ്മിക്കുക:**
```bash
mvn clean install
```

**ആപ്ലിക്കേഷൻ പാക്കേജ് ചെയ്യുക:**
```bash
mvn package
# ലക്ഷ്യ/ ഡയറക്ടറിയിൽ JAR സൃഷ്ടിക്കുന്നു
```

### ഔട്ട്പുട്ട് ഡയറക്ടറികൾ
- കമ്പൈൽ ചെയ്ത ക്ലാസുകൾ: `target/classes/`
- ടെസ്റ്റ് ക്ലാസുകൾ: `target/test-classes/`
- JAR ഫയലുകൾ: `target/*.jar`
- Maven ആർട്ടിഫാക്ടുകൾ: `target/`

### പരിസ്ഥിതി-നിർദ്ദിഷ്ട കോൺഫിഗറേഷൻ

**വികസനം:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**ഉത്പാദനം:**
- GitHub Models-നു പകരം Azure AI Foundry Models ഉപയോഗിക്കുക
- ബേസ്-url Azure OpenAI എന്റ്പോയിന്റിലേക്ക് അപ്ഡേറ്റ് ചെയ്യുക
- രഹസ്യങ്ങൾ Azure Key Vault അല്ലെങ്കിൽ പരിസ്ഥിതി വേരിയബിളുകൾ വഴി കൈകാര്യം ചെയ്യുക

### ഡെപ്ലോയ്മെന്റ് പരിഗണനകൾ
- ഇത് സാമ്പിള് ആപ്ലിക്കേഷനുകളുള്ള ഒരു വിദ്യാഭ്യാസ റിപോസിറ്ററിയാണ്
- നിലവിലെ രൂപത്തിൽ ഉത്പാദന ഡെപ്ലോയ്മെന്റിനായി രൂപകൽപ്പന ചെയ്തിട്ടില്ല
- സാമ്പിളുകൾ ഉത്പാദന ഉപയോഗത്തിനായി അനുയോജ്യമായ പാറ്റേണുകൾ പ്രദർശിപ്പിക്കുന്നു
- പ്രത്യേക ഡെപ്ലോയ്മെന്റ് കുറിപ്പുകൾക്കായി ഓരോ പ്രോജക്റ്റിന്റെ README-കൾ കാണുക

## അധിക കുറിപ്പുകൾ

### GitHub Models vs Azure OpenAI
- **GitHub Models:** പഠനത്തിനുള്ള സൗജന്യ ടയർ, ക്രെഡിറ്റ് കാർഡ് ആവശ്യമില്ല
- **Azure OpenAI:** ഉത്പാദന-തയ്യാറായത്, Azure സബ്സ്ക്രിപ്ഷൻ ആവശ്യമാണ്
- കോഡ് ഇരുവരും തമ്മിൽ അനുയോജ്യമാണ് - എന്റ്പോയിന്റും API കീയും മാറ്റുക

### ഒന്നിലധികം പ്രോജക്റ്റുകളുമായി പ്രവർത്തിക്കൽ
ഓരോ സാമ്പിള് പ്രോജക്റ്റും സ്വതന്ത്രമാണ്:
```bash
# പ്രത്യേക പ്രോജക്റ്റിലേക്ക് നാവിഗേറ്റ് ചെയ്യുക
cd 04-PracticalSamples/[project-name]

# ഓരോന്നിനും സ്വന്തം pom.xml ഉണ്ട്, സ്വതന്ത്രമായി നിർമ്മിക്കാം
mvn clean install
```

### സാധാരണ പ്രശ്നങ്ങൾ

**Java പതിപ്പ് പൊരുത്തക്കേട്:**
```bash
# ജാവ 21 സ്ഥിരീകരിക്കുക
java -version
# ആവശ്യമെങ്കിൽ JAVA_HOME അപ്ഡേറ്റ് ചെയ്യുക
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**ആശ്രിത ഡൗൺലോഡ് പ്രശ്നങ്ങൾ:**
```bash
# മേവൻ കാഷെ മായ്ച്ച് വീണ്ടും ശ്രമിക്കുക
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub ടോക്കൺ കണ്ടെത്തിയില്ല:**
```bash
# നിലവിലെ സെഷനിൽ സജ്ജമാക്കുക
export GITHUB_TOKEN="your-token-here"

# അല്ലെങ്കിൽ പ്രോജക്റ്റ് ഡയറക്ടറിയിലെ .env ഫയൽ ഉപയോഗിക്കുക
echo "GITHUB_TOKEN=your-token-here" > .env
```

**പോർട്ട് ഇതിനകം ഉപയോഗത്തിലാണ്:**
```bash
# സ്പ്രിംഗ് ബൂട്ട് ഡിഫോൾട്ടായി 8080 പോർട്ട് ഉപയോഗിക്കുന്നു
# application.properties-ൽ മാറ്റം:
server.port=8081
```

### മൾട്ടി-ലാംഗ്വേജ് പിന്തുണ
- 45+ ഭാഷകളിൽ ഡോക്യുമെന്റേഷൻ ലഭ്യമാണ് ഓട്ടോമേറ്റഡ് പരിഭാഷയിലൂടെ
- `translations/` ഡയറക്ടറിയിൽ പരിഭാഷകൾ
- GitHub Actions പ്രവൃത്തി പ്രവാഹം വഴി പരിഭാഷ മാനേജുചെയ്യുന്നു

### പഠന പാത
1. [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md) ഉപയോഗിച്ച് ആരംഭിക്കുക
2. അദ്ധ്യായങ്ങൾ ക്രമത്തിൽ പിന്തുടരുക (01 → 05)
3. ഓരോ അദ്ധ്യായത്തിലെ പ്രായോഗിക ഉദാഹരണങ്ങൾ പൂർത്തിയാക്കുക
4. അദ്ധ്യായം 4-ൽ സാമ്പിള് പ്രോജക്റ്റുകൾ എക്സ്പ്ലോർ ചെയ്യുക
5. അദ്ധ്യായം 5-ൽ ഉത്തരവാദ AI പ്രാക്ടീസുകൾ പഠിക്കുക

### ഡെവലപ്മെന്റ് കണ്ടെയ്‌നർ
`.devcontainer/devcontainer.json` ക്രമീകരിക്കുന്നു:
- Java 21 വികസന പരിസ്ഥിതി
- Maven മുൻകൂട്ടി ഇൻസ്റ്റാൾ ചെയ്തിട്ടുണ്ട്
- VS Code Java എക്സ്റ്റൻഷനുകൾ
- Spring Boot ടൂളുകൾ
- GitHub Copilot ഇന്റഗ്രേഷൻ
- Docker-in-Docker പിന്തുണ
- Azure CLI

### പ്രകടന പരിഗണനകൾ
- GitHub Models സൗജന്യ ടയർ നിരക്കിന്റെ പരിധികളുണ്ട്
- embeddings-ക്കായി അനുയോജ്യമായ ബാച്ച് വലുപ്പങ്ങൾ ഉപയോഗിക്കുക
- ആവർത്തിക്കുന്ന API കോൾസിനായി കാഷിംഗ് പരിഗണിക്കുക
- ചെലവ് ഓപ്റ്റിമൈസേഷനായി ടോക്കൺ ഉപയോഗം നിരീക്ഷിക്കുക

### സുരക്ഷാ കുറിപ്പുകൾ
- `.env` ഫയലുകൾ ഒരിക്കലും കമ്മിറ്റ് ചെയ്യരുത് (`.gitignore`-ൽ ഇതിനകം ഉൾപ്പെടുത്തിയിട്ടുണ്ട്)
- API കീകൾക്കായി പരിസ്ഥിതി വേരിയബിളുകൾ ഉപയോഗിക്കുക
- GitHub ടോക്കണുകൾക്ക് ആവശ്യമായ കുറഞ്ഞ സ്കോപ്പുകൾ നൽകുക
- അദ്ധ്യായം 5-ൽ ഉത്തരവാദ AI മാർഗനിർദ്ദേശങ്ങൾ പിന്തുടരുക

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**അറിയിപ്പ്**:  
ഈ രേഖ AI വിവർത്തന സേവനം [Co-op Translator](https://github.com/Azure/co-op-translator) ഉപയോഗിച്ച് വിവർത്തനം ചെയ്തതാണ്. ഞങ്ങൾ കൃത്യതയ്ക്കായി ശ്രമിക്കുന്നുവെങ്കിലും, ഓട്ടോമേറ്റഡ് വിവർത്തനങ്ങളിൽ പിഴവുകൾ അല്ലെങ്കിൽ തെറ്റായ വിവരങ്ങൾ ഉണ്ടാകാൻ സാധ്യതയുണ്ട്. അതിന്റെ സ്വഭാവ ഭാഷയിലുള്ള അസൽ രേഖയാണ് പ്രാമാണികമായ ഉറവിടം എന്ന് പരിഗണിക്കണം. നിർണായകമായ വിവരങ്ങൾക്ക്, പ്രൊഫഷണൽ മനുഷ്യ വിവർത്തനം ശുപാർശ ചെയ്യുന്നു. ഈ വിവർത്തനം ഉപയോഗിച്ച് ഉണ്ടാകുന്ന തെറ്റിദ്ധാരണകൾ അല്ലെങ്കിൽ തെറ്റായ വ്യാഖ്യാനങ്ങൾക്കായി ഞങ്ങൾ ഉത്തരവാദികളല്ല.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->