# AGENTS.md

## Projekt Áttekintés

Ez egy oktatási célú adattár, amely a Generatív AI fejlesztésének elsajátítását segíti Java nyelven. Átfogó, gyakorlati kurzust kínál, amely lefedi a Nagy Nyelvi Modellek (LLM-ek), prompt tervezés, beágyazások, RAG (Retrieval-Augmented Generation) és a Model Context Protocol (MCP) témaköreit.

**Fő technológiák:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Modellek, Azure OpenAI és OpenAI SDK-k

**Architektúra:**
- Több önálló Spring Boot alkalmazás fejezetek szerint szervezve
- Mintaprojektek különböző AI minták bemutatására
- GitHub Codespaces-kompatibilis, előre konfigurált fejlesztői konténerekkel

## Telepítési Parancsok

### Előfeltételek
- Java 21 vagy újabb
- Maven 3.x
- GitHub személyes hozzáférési token (GitHub Modellekhez)
- Opcionális: Azure OpenAI hitelesítő adatok

### Környezet Beállítása

**1. lehetőség: GitHub Codespaces (Ajánlott)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**2. lehetőség: Helyi Fejlesztői Konténer**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**3. lehetőség: Helyi Beállítás**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Konfiguráció

**GitHub Token Beállítása:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Azure OpenAI Beállítás (Opcionális):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Fejlesztési Munkafolyamat

### Projekt Struktúra
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

### Alkalmazások Futtatása

**Spring Boot alkalmazás futtatása:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Projekt építése:**
```bash
cd [project-directory]
mvn clean install
```

**MCP Kalkulátor Szerver indítása:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Kliens példák futtatása:**
```bash
# After starting the server in another terminal
cd 04-PracticalSamples/calculator

# Direct MCP client
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient"

# AI-powered client (requires GITHUB_TOKEN)
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient"

# Interactive bot
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.Bot"
```

### Hot Reload
A Spring Boot DevTools támogatja a hot reload funkciót a projektekben:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Tesztelési Útmutató

### Tesztek Futtatása

**Az összes teszt futtatása egy projektben:**
```bash
cd [project-directory]
mvn test
```

**Tesztek futtatása részletes kimenettel:**
```bash
mvn test -X
```

**Konkrét teszt osztály futtatása:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Teszt Struktúra
- A tesztfájlok JUnit 5 (Jupiter) keretrendszert használnak
- A teszt osztályok a `src/test/java/` könyvtárban találhatók
- Kliens példák a kalkulátor projektben: `src/test/java/com/microsoft/mcp/sample/client/`

### Manuális Tesztelés
Számos példa interaktív alkalmazás, amely manuális tesztelést igényel:

1. Indítsd el az alkalmazást `mvn spring-boot:run` paranccsal
2. Teszteld az endpointokat vagy használd a CLI-t
3. Ellenőrizd, hogy a várt viselkedés megfelel-e az egyes projektek README.md dokumentációjának

### Tesztelés GitHub Modellekkel
- Ingyenes csomag korlátai: 15 kérés/perc, 150/nap
- Maximum 5 egyidejű kérés
- Teszteld a tartalomszűrést felelős AI példákkal

## Kódstílus Irányelvek

### Java Konvenciók
- **Java Verzió:** Java 21 modern funkciókkal
- **Stílus:** Kövesd a standard Java konvenciókat
- **Elnevezés:** 
  - Osztályok: PascalCase
  - Metódusok/változók: camelCase
  - Konstansok: UPPER_SNAKE_CASE
  - Csomagnevek: kisbetűs

### Spring Boot Minták
- Használj `@Service` annotációt az üzleti logikához
- Használj `@RestController` annotációt REST endpointokhoz
- Konfiguráció `application.yml` vagy `application.properties` fájlokon keresztül
- Környezeti változókat részesítsd előnyben a hard-coded értékekkel szemben
- Használj `@Tool` annotációt MCP által elérhető metódusokhoz

### Fájl Szervezés
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

### Függőségek
- Maven `pom.xml` fájlon keresztül kezelve
- Spring AI BOM verziókezeléshez
- LangChain4j AI integrációkhoz
- Spring Boot starter parent Spring függőségekhez

### Kód Kommentek
- Adj JavaDoc-ot a publikus API-khoz
- Tartalmazz magyarázó kommenteket a komplex AI interakciókhoz
- Dokumentáld az MCP eszközök leírását egyértelműen

## Építés és Telepítés

### Projektek Építése

**Építés tesztek nélkül:**
```bash
mvn clean install -DskipTests
```

**Építés minden ellenőrzéssel:**
```bash
mvn clean install
```

**Alkalmazás csomagolása:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Kimeneti Könyvtárak
- Fordított osztályok: `target/classes/`
- Teszt osztályok: `target/test-classes/`
- JAR fájlok: `target/*.jar`
- Maven artefaktumok: `target/`

### Környezet-specifikus Konfiguráció

**Fejlesztés:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Éles Üzem:**
- Használj Azure AI Foundry Modelleket GitHub Modellek helyett
- Frissítsd az alap URL-t az Azure OpenAI végpontra
- Kezeld a titkokat Azure Key Vault vagy környezeti változók segítségével

### Telepítési Megfontolások
- Ez egy oktatási adattár mintaprogramokkal
- Nem alkalmas közvetlen éles telepítésre
- A minták bemutatják, hogyan adaptálhatók éles környezethez
- Lásd az egyes projektek README fájljait konkrét telepítési megjegyzésekért

## További Megjegyzések

### GitHub Modellek vs Azure OpenAI
- **GitHub Modellek:** Ingyenes csomag tanuláshoz, nem szükséges hitelkártya
- **Azure OpenAI:** Éles környezetre kész, Azure előfizetést igényel
- A kód kompatibilis mindkettővel - csak az endpointot és az API kulcsot kell módosítani

### Több Projekt Kezelése
Minden mintaprojekt önálló:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Gyakori Problémák

**Java Verzió Eltérés:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Függőség Letöltési Hibák:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub Token Nem Található:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Port Már Foglalt:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Többnyelvű Támogatás
- Dokumentáció elérhető több mint 45 nyelven automatikus fordítással
- Fordítások a `translations/` könyvtárban
- Fordítást GitHub Actions workflow kezeli

### Tanulási Útvonal
1. Kezdd a [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md) fejezettel
2. Kövesd a fejezeteket sorrendben (01 → 05)
3. Végezd el a gyakorlati példákat minden fejezetben
4. Fedezd fel a mintaprojekteket a 4. fejezetben
5. Tanuld meg a felelős AI gyakorlatokat az 5. fejezetben

### Fejlesztői Konténer
A `.devcontainer/devcontainer.json` konfigurálja:
- Java 21 fejlesztői környezet
- Maven előtelepítve
- VS Code Java bővítmények
- Spring Boot eszközök
- GitHub Copilot integráció
- Docker-in-Docker támogatás
- Azure CLI

### Teljesítmény Megfontolások
- A GitHub Modellek ingyenes csomagjának korlátai vannak
- Használj megfelelő batch méreteket beágyazásokhoz
- Fontold meg a cache használatát ismétlődő API hívásokhoz
- Figyeld a tokenhasználatot a költségoptimalizálás érdekében

### Biztonsági Megjegyzések
- Soha ne commitold a `.env` fájlokat (már szerepel a `.gitignore`-ban)
- Használj környezeti változókat az API kulcsokhoz
- A GitHub tokeneknek csak minimális szükséges jogosultságokat adj
- Kövesd a felelős AI irányelveket az 5. fejezetben

---

**Felelősség kizárása**:  
Ez a dokumentum az [Co-op Translator](https://github.com/Azure/co-op-translator) AI fordítási szolgáltatás segítségével került lefordításra. Bár törekszünk a pontosságra, kérjük, vegye figyelembe, hogy az automatikus fordítások hibákat vagy pontatlanságokat tartalmazhatnak. Az eredeti dokumentum az eredeti nyelvén tekintendő hiteles forrásnak. Kritikus információk esetén javasolt professzionális emberi fordítást igénybe venni. Nem vállalunk felelősséget semmilyen félreértésért vagy téves értelmezésért, amely a fordítás használatából eredhet.