<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c670445516e119888d8aaaa207bbee34",
  "translation_date": "2025-07-27T13:25:19+00:00",
  "source_file": "02-SetupDevEnvironment/README.md",
  "language_code": "ro"
}
-->
# Configurarea Mediului de Dezvoltare pentru Generative AI în Java

> **Start Rapid**: Cod în Cloud în 2 minute - Sari direct la [Configurarea GitHub Codespaces](../../../02-SetupDevEnvironment) - fără instalare locală necesară și folosind modelele GitHub!

> **Interesat de Azure OpenAI?** Vezi [Ghidul nostru de Configurare Azure OpenAI](getting-started-azure-openai.md) cu pași pentru a crea o resursă nouă Azure OpenAI.

## Ce Vei Învăța

- Cum să configurezi un mediu de dezvoltare Java pentru aplicații AI
- Cum să alegi și să configurezi mediul de dezvoltare preferat (cloud-first cu Codespaces, container local de dezvoltare sau configurare completă locală)
- Cum să testezi configurarea conectându-te la Modelele GitHub

## Cuprins

- [Ce Vei Învăța](../../../02-SetupDevEnvironment)
- [Introducere](../../../02-SetupDevEnvironment)
- [Pasul 1: Configurarea Mediului de Dezvoltare](../../../02-SetupDevEnvironment)
  - [Opțiunea A: GitHub Codespaces (Recomandat)](../../../02-SetupDevEnvironment)
  - [Opțiunea B: Container Local de Dezvoltare](../../../02-SetupDevEnvironment)
  - [Opțiunea C: Folosește Instalarea Locală Existentă](../../../02-SetupDevEnvironment)
- [Pasul 2: Crearea unui Token Personal de Acces GitHub](../../../02-SetupDevEnvironment)
- [Pasul 3: Testarea Configurării](../../../02-SetupDevEnvironment)
- [Depanare](../../../02-SetupDevEnvironment)
- [Rezumat](../../../02-SetupDevEnvironment)
- [Pași Următori](../../../02-SetupDevEnvironment)

## Introducere

Acest capitol te va ghida prin configurarea unui mediu de dezvoltare. Vom folosi **Modelele GitHub** ca exemplu principal, deoarece sunt gratuite, ușor de configurat doar cu un cont GitHub, nu necesită card de credit și oferă acces la mai multe modele pentru experimentare.

**Fără configurare locală necesară!** Poți începe să scrii cod imediat folosind GitHub Codespaces, care oferă un mediu complet de dezvoltare direct în browser.

<img src="./images/models.webp" alt="Captură de ecran: Modelele GitHub" width="50%">

Recomandăm utilizarea [**Modelelor GitHub**](https://github.com/marketplace?type=models) pentru acest curs deoarece:
- Sunt **gratuite** pentru început
- Sunt **ușor** de configurat doar cu un cont GitHub
- **Nu necesită card de credit**
- Oferă **mai multe modele** pentru experimentare

> **Notă**: Modelele GitHub utilizate în acest curs au următoarele limite gratuite:
> - 15 cereri pe minut (150 pe zi)
> - ~8.000 de cuvinte de intrare, ~4.000 de cuvinte de ieșire per cerere
> - 5 cereri simultane
> 
> Pentru utilizare în producție, treci la Modelele Azure AI Foundry cu contul tău Azure. Codul tău nu trebuie modificat. Vezi [documentația Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/foundry-models/how-to/quickstart-github-models).

## Pasul 1: Configurarea Mediului de Dezvoltare

<a name="quick-start-cloud"></a>

Am creat un container de dezvoltare preconfigurat pentru a minimiza timpul de configurare și a ne asigura că ai toate instrumentele necesare pentru acest curs de Generative AI pentru Java. Alege abordarea de dezvoltare preferată:

### Opțiuni de Configurare a Mediului:

#### Opțiunea A: GitHub Codespaces (Recomandat)

**Începe să scrii cod în 2 minute - fără configurare locală necesară!**

1. Fă un fork acestui repository în contul tău GitHub  
   > **Notă**: Dacă vrei să editezi configurația de bază, consultă [Configurarea Containerului de Dezvoltare](../../../.devcontainer/devcontainer.json)
2. Apasă pe **Code** → fila **Codespaces** → **...** → **New with options...**
3. Folosește setările implicite – aceasta va selecta **Configurația containerului de dezvoltare**: **Generative AI Java Development Environment**, un container personalizat creat pentru acest curs
4. Apasă pe **Create codespace**
5. Așteaptă ~2 minute pentru ca mediul să fie gata
6. Continuă cu [Pasul 2: Crearea Tokenului GitHub](../../../02-SetupDevEnvironment)

<img src="./images/codespaces.png" alt="Captură de ecran: Submeniul Codespaces" width="50%">

<img src="./images/image.png" alt="Captură de ecran: New with options" width="50%">

<img src="./images/codespaces-create.png" alt="Captură de ecran: Opțiuni pentru crearea unui codespace" width="50%">

> **Beneficiile Codespaces**:
> - Nu necesită instalare locală
> - Funcționează pe orice dispozitiv cu browser
> - Preconfigurat cu toate instrumentele și dependențele
> - Gratuit 60 de ore pe lună pentru conturile personale
> - Mediu consistent pentru toți cursanții

#### Opțiunea B: Container Local de Dezvoltare

**Pentru dezvoltatorii care preferă dezvoltarea locală cu Docker**

1. Fă un fork și clonează acest repository pe mașina ta locală  
   > **Notă**: Dacă vrei să editezi configurația de bază, consultă [Configurarea Containerului de Dezvoltare](../../../.devcontainer/devcontainer.json)
2. Instalează [Docker Desktop](https://www.docker.com/products/docker-desktop/) și [VS Code](https://code.visualstudio.com/)
3. Instalează extensia [Dev Containers](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) în VS Code
4. Deschide folderul repository-ului în VS Code
5. Când ți se cere, apasă pe **Reopen in Container** (sau folosește `Ctrl+Shift+P` → "Dev Containers: Reopen in Container")
6. Așteaptă ca containerul să fie construit și pornit
7. Continuă cu [Pasul 2: Crearea Tokenului GitHub](../../../02-SetupDevEnvironment)

<img src="./images/devcontainer.png" alt="Captură de ecran: Configurarea containerului de dezvoltare" width="50%">

<img src="./images/image-3.png" alt="Captură de ecran: Construcția containerului de dezvoltare completă" width="50%">

#### Opțiunea C: Folosește Instalarea Locală Existentă

**Pentru dezvoltatorii cu medii Java existente**

Cerințe preliminare:
- [Java 21+](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) 
- [Maven 3.9+](https://maven.apache.org/download.cgi)
- [VS Code](https://code.visualstudio.com) sau IDE-ul preferat

Pași:
1. Clonează acest repository pe mașina ta locală
2. Deschide proiectul în IDE-ul tău
3. Continuă cu [Pasul 2: Crearea Tokenului GitHub](../../../02-SetupDevEnvironment)

> **Sfat Pro**: Dacă ai un calculator cu specificații reduse, dar vrei să folosești VS Code local, utilizează GitHub Codespaces! Poți conecta VS Code local la un Codespace găzduit în cloud pentru a beneficia de ambele lumi.

<img src="./images/image-2.png" alt="Captură de ecran: Instanță locală de container de dezvoltare creată" width="50%">

## Pasul 2: Crearea unui Token Personal de Acces GitHub

1. Accesează [Setările GitHub](https://github.com/settings/profile) și selectează **Settings** din meniul profilului tău.
2. În bara laterală din stânga, apasă pe **Developer settings** (de obicei în partea de jos).
3. Sub **Personal access tokens**, apasă pe **Fine-grained tokens** (sau urmează acest [link direct](https://github.com/settings/personal-access-tokens)).
4. Apasă pe **Generate new token**.
5. La "Token name", oferă un nume descriptiv (ex.: `GenAI-Java-Course-Token`).
6. Setează o dată de expirare (recomandat: 7 zile pentru cele mai bune practici de securitate).
7. La "Resource owner", selectează contul tău de utilizator.
8. La "Repository access", selectează repository-urile pe care vrei să le folosești cu Modelele GitHub (sau "All repositories" dacă este necesar).
9. La "Repository permissions", găsește **Models** și setează-l pe **Read and write**.
10. Apasă pe **Generate token**.
11. **Copiază și salvează tokenul acum** – nu îl vei mai vedea!

> **Sfat de Securitate**: Folosește cel mai mic domeniu de aplicare necesar și cea mai scurtă perioadă practică de expirare pentru tokenurile de acces.

## Pasul 3: Testarea Configurării cu Exemplul Modelelor GitHub

După ce mediul tău de dezvoltare este gata, să testăm integrarea Modelelor GitHub cu aplicația noastră exemplu din [`02-SetupDevEnvironment/examples/github-models`](../../../02-SetupDevEnvironment/examples/github-models).

1. Deschide terminalul în mediul tău de dezvoltare.
2. Navighează la exemplul Modelelor GitHub:
   ```bash
   cd 02-SetupDevEnvironment/examples/github-models
   ```
3. Setează tokenul GitHub ca variabilă de mediu:
   ```bash
   # macOS/Linux
   export GITHUB_TOKEN=your_token_here
   
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_token_here"
   ```

4. Rulează aplicația:
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.githubmodels.App"
   ```

Ar trebui să vezi un output similar cu:
```text
Using model: gpt-4.1-nano
Sending request to GitHub Models...
Response: Hello World!
```

### Înțelegerea Codului Exemplu

Mai întâi, să înțelegem ce am rulat. Exemplul din `examples/github-models` folosește SDK-ul OpenAI Java pentru a se conecta la Modelele GitHub:

**Ce face acest cod:**
- **Se conectează** la Modelele GitHub folosind tokenul tău personal de acces
- **Trimite** un mesaj simplu "Say Hello World!" către modelul AI
- **Primește** și afișează răspunsul AI-ului
- **Validează** că configurarea ta funcționează corect

**Dependență Cheie** (în `pom.xml`):
```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

**Cod Principal** (`App.java`):
```java
// Connect to GitHub Models using OpenAI Java SDK
OpenAIClient client = OpenAIOkHttpClient.builder()
    .apiKey(pat)
    .baseUrl("https://models.inference.ai.azure.com")
    .build();

// Create chat completion request
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .model(modelId)
    .addSystemMessage("You are a concise assistant.")
    .addUserMessage("Say Hello World!")
    .build();

// Get AI response
ChatCompletion response = client.chat().completions().create(params);
System.out.println("Response: " + response.choices().get(0).message().content().orElse("No response content"));
```

## Rezumat

**Felicitări!** Ai reușit să:

- **Creezi un Token Personal de Acces GitHub** cu permisiuni corecte pentru accesul la modelele AI
- **Configurezi mediul tău de dezvoltare Java** folosind Codespaces, containere de dezvoltare sau instalare locală
- **Te conectezi la Modelele GitHub** folosind SDK-ul OpenAI Java pentru acces gratuit la dezvoltarea AI
- **Testezi integrarea** cu o aplicație exemplu funcțională care comunică cu modelele AI

## Pași Următori

[Capitolul 3: Tehnici de Bază pentru Generative AI](../03-CoreGenerativeAITechniques/README.md)

## Depanare

Ai probleme? Iată probleme comune și soluții:

- **Tokenul nu funcționează?** 
  - Asigură-te că ai copiat întregul token fără spații suplimentare
  - Verifică dacă tokenul este setat corect ca variabilă de mediu
  - Verifică dacă tokenul are permisiunile corecte (Models: Read and write)

- **Maven nu este găsit?** 
  - Dacă folosești containere de dezvoltare/Codespaces, Maven ar trebui să fie preinstalat
  - Pentru configurarea locală, asigură-te că Java 21+ și Maven 3.9+ sunt instalate
  - Încearcă `mvn --version` pentru a verifica instalarea

- **Probleme de conexiune?** 
  - Verifică conexiunea la internet
  - Asigură-te că GitHub este accesibil din rețeaua ta
  - Verifică dacă nu ești în spatele unui firewall care blochează endpoint-ul Modelelor GitHub

- **Containerul de dezvoltare nu pornește?** 
  - Asigură-te că Docker Desktop este pornit (pentru dezvoltare locală)
  - Încearcă să reconstruiești containerul: `Ctrl+Shift+P` → "Dev Containers: Rebuild Container"

- **Erori de compilare a aplicației?**
  - Asigură-te că ești în directorul corect: `02-SetupDevEnvironment/examples/github-models`
  - Încearcă să cureți și să reconstruiești: `mvn clean compile`

> **Ai nevoie de ajutor?**: Încă ai probleme? Deschide un issue în repository și te vom ajuta.

**Declinarea responsabilității**:  
Acest document a fost tradus folosind serviciul de traducere AI [Co-op Translator](https://github.com/Azure/co-op-translator). Deși ne străduim să asigurăm acuratețea, vă rugăm să rețineți că traducerile automate pot conține erori sau inexactități. Documentul original în limba sa natală ar trebui considerat sursa autoritară. Pentru informații critice, se recomandă traducerea profesională realizată de un specialist uman. Nu ne asumăm răspunderea pentru eventualele neînțelegeri sau interpretări greșite care pot apărea din utilizarea acestei traduceri.