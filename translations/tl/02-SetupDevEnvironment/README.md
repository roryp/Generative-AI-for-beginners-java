<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0b563ac59362fb83f0f49dcfc442dd97",
  "translation_date": "2025-07-21T19:32:58+00:00",
  "source_file": "02-SetupDevEnvironment/README.md",
  "language_code": "tl"
}
-->
# Pagsasaayos ng Development Environment para sa Generative AI gamit ang Java

> **Mabilisang Simula**: Mag-code sa Cloud sa loob ng 2 minuto - Tumungo sa [GitHub Codespaces Setup](../../../02-SetupDevEnvironment) - walang kinakailangang lokal na pag-install at gumagamit ng mga modelo mula sa GitHub!

> **Interesado sa Azure OpenAI?**, tingnan ang aming [Azure OpenAI Setup Guide](getting-started-azure-openai.md) para sa mga hakbang sa paglikha ng bagong Azure OpenAI resource.

## Ano ang Iyong Matututuhan

- Paano mag-set up ng Java development environment para sa mga AI application
- Pumili at i-configure ang iyong gustong development environment (cloud-first gamit ang Codespaces, lokal na dev container, o full local setup)
- Subukan ang iyong setup sa pamamagitan ng pagkonekta sa GitHub Models

## Talaan ng Nilalaman

- [Ano ang Iyong Matututuhan](../../../02-SetupDevEnvironment)
- [Panimula](../../../02-SetupDevEnvironment)
- [Hakbang 1: I-set Up ang Iyong Development Environment](../../../02-SetupDevEnvironment)
  - [Opsyon A: GitHub Codespaces (Inirerekomenda)](../../../02-SetupDevEnvironment)
  - [Opsyon B: Lokal na Dev Container](../../../02-SetupDevEnvironment)
  - [Opsyon C: Gamitin ang Iyong Kasalukuyang Lokal na Pag-install](../../../02-SetupDevEnvironment)
- [Hakbang 2: Gumawa ng GitHub Personal Access Token](../../../02-SetupDevEnvironment)
- [Hakbang 3: Subukan ang Iyong Setup](../../../02-SetupDevEnvironment)
- [Pag-aayos ng Problema](../../../02-SetupDevEnvironment)
- [Buod](../../../02-SetupDevEnvironment)
- [Mga Susunod na Hakbang](../../../02-SetupDevEnvironment)

## Panimula

Ang kabanatang ito ay gagabay sa iyo sa pagsasaayos ng development environment. Gagamitin natin ang **GitHub Models** bilang pangunahing halimbawa dahil ito ay libre, madaling i-set up gamit lamang ang isang GitHub account, hindi nangangailangan ng credit card, at nagbibigay ng access sa maraming modelo para sa eksperimento.

**Walang kinakailangang lokal na setup!** Maaari kang magsimulang mag-code kaagad gamit ang GitHub Codespaces, na nagbibigay ng buong development environment sa iyong browser.

<img src="./images/models.webp" alt="Screenshot: GitHub Models" width="50%">

Inirerekomenda naming gamitin ang [**GitHub Models**](https://github.com/marketplace?type=models) para sa kursong ito dahil ito ay:
- **Libre** upang magsimula
- **Madaling** i-set up gamit lamang ang isang GitHub account
- **Hindi kailangan ng credit card**
- **Maraming modelo** ang magagamit para sa eksperimento

> **Tandaan**: Ang mga GitHub Models na ginagamit sa pagsasanay na ito ay may mga libreng limitasyon:
> - 15 kahilingan kada minuto (150 kada araw)
> - ~8,000 salita papasok, ~4,000 salita palabas kada kahilingan
> - 5 sabay-sabay na kahilingan
> 
> Para sa paggamit sa produksyon, mag-upgrade sa Azure AI Foundry Models gamit ang iyong Azure account. Hindi kailangang baguhin ang iyong code. Tingnan ang [Azure AI Foundry documentation](https://learn.microsoft.com/azure/ai-foundry/foundry-models/how-to/quickstart-github-models).

## Hakbang 1: I-set Up ang Iyong Development Environment

<a name="quick-start-cloud"></a>

Naghanda kami ng preconfigured development container upang mabawasan ang oras ng setup at matiyak na mayroon kang lahat ng kinakailangang tool para sa kursong Generative AI para sa Java. Piliin ang iyong gustong paraan ng development:

### Mga Opsyon sa Environment Setup:

#### Opsyon A: GitHub Codespaces (Inirerekomenda)

**Magsimula ng pag-code sa loob ng 2 minuto - walang kinakailangang lokal na setup!**

1. I-fork ang repositoryong ito sa iyong GitHub account
   > **Tandaan**: Kung nais mong i-edit ang pangunahing config, tingnan ang [Dev Container Configuration](../../../.devcontainer/devcontainer.json)
2. I-click ang **Code** → tab na **Codespaces** → **...** → **New with options...**
3. Gamitin ang mga default – pipiliin nito ang **Dev container configuration**: **Generative AI Java Development Environment** custom devcontainer na ginawa para sa kursong ito
4. I-click ang **Create codespace**
5. Maghintay ng ~2 minuto para maging handa ang environment
6. Tumungo sa [Hakbang 2: Gumawa ng GitHub Token](../../../02-SetupDevEnvironment)

<img src="./images/codespaces.png" alt="Screenshot: Codespaces submenu" width="50%">

<img src="./images/image.png" alt="Screenshot: New with options" width="50%">

<img src="./images/codespaces-create.png" alt="Screenshot: Create codespace options" width="50%">

> **Mga Benepisyo ng Codespaces**:
> - Walang kinakailangang lokal na pag-install
> - Gumagana sa anumang device na may browser
> - Pre-configured na may lahat ng tool at dependencies
> - Libreng 60 oras kada buwan para sa personal na account
> - Konsistent na environment para sa lahat ng mag-aaral

#### Opsyon B: Lokal na Dev Container

**Para sa mga developer na mas gusto ang lokal na development gamit ang Docker**

1. I-fork at i-clone ang repositoryong ito sa iyong lokal na makina
   > **Tandaan**: Kung nais mong i-edit ang pangunahing config, tingnan ang [Dev Container Configuration](../../../.devcontainer/devcontainer.json)
2. I-install ang [Docker Desktop](https://www.docker.com/products/docker-desktop/) at [VS Code](https://code.visualstudio.com/)
3. I-install ang [Dev Containers extension](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) sa VS Code
4. Buksan ang folder ng repositoryo sa VS Code
5. Kapag na-prompt, i-click ang **Reopen in Container** (o gamitin ang `Ctrl+Shift+P` → "Dev Containers: Reopen in Container")
6. Maghintay para sa container na mabuo at magsimula
7. Tumungo sa [Hakbang 2: Gumawa ng GitHub Token](../../../02-SetupDevEnvironment)

<img src="./images/devcontainer.png" alt="Screenshot: Dev container setup" width="50%">

<img src="./images/image-3.png" alt="Screenshot: Dev container build complete" width="50%">

#### Opsyon C: Gamitin ang Iyong Kasalukuyang Lokal na Pag-install

**Para sa mga developer na may kasalukuyang Java environment**

Mga Kinakailangan:
- [Java 21+](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) 
- [Maven 3.9+](https://maven.apache.org/download.cgi)
- [VS Code](https://code.visualstudio.com) o ang iyong gustong IDE

Mga Hakbang:
1. I-clone ang repositoryong ito sa iyong lokal na makina
2. Buksan ang proyekto sa iyong IDE
3. Tumungo sa [Hakbang 2: Gumawa ng GitHub Token](../../../02-SetupDevEnvironment)

> **Pro Tip**: Kung mababa ang specs ng iyong makina ngunit nais mong gamitin ang VS Code nang lokal, gamitin ang GitHub Codespaces! Maaari mong ikonekta ang iyong lokal na VS Code sa isang cloud-hosted na Codespace para sa pinakamahusay na kumbinasyon.

<img src="./images/image-2.png" alt="Screenshot: created local devcontainer instance" width="50%">

## Hakbang 2: Gumawa ng GitHub Personal Access Token

1. Pumunta sa [GitHub Settings](https://github.com/settings/profile) at piliin ang **Settings** mula sa iyong profile menu.
2. Sa kaliwang sidebar, i-click ang **Developer settings** (karaniwang nasa ibaba).
3. Sa ilalim ng **Personal access tokens**, i-click ang **Fine-grained tokens** (o sundan ang direktang [link](https://github.com/settings/personal-access-tokens)).
4. I-click ang **Generate new token**.
5. Sa "Token name", magbigay ng deskriptibong pangalan (hal., `GenAI-Java-Course-Token`).
6. Magtakda ng expiration date (inirerekomenda: 7 araw para sa seguridad).
7. Sa "Resource owner", piliin ang iyong user account.
8. Sa "Repository access", piliin ang mga repositoryong nais mong gamitin sa GitHub Models (o "All repositories" kung kinakailangan).
9. Sa "Repository permissions", hanapin ang **Models** at itakda ito sa **Read and write**.
10. I-click ang **Generate token**.
11. **Kopyahin at i-save ang iyong token ngayon** – hindi mo na ito makikita muli!

> **Tip sa Seguridad**: Gumamit ng pinakamababang kinakailangang saklaw at pinakamaikling praktikal na expiration time para sa iyong mga access token.

## Hakbang 3: Subukan ang Iyong Setup gamit ang GitHub Models Example

Kapag handa na ang iyong development environment, subukan natin ang GitHub Models integration gamit ang aming example application sa [`02-SetupDevEnvironment/src/github-models`](../../../02-SetupDevEnvironment/src/github-models).

1. Buksan ang terminal sa iyong development environment.
2. Tumungo sa GitHub Models example:
   ```bash
   cd 02-SetupDevEnvironment/src/github-models
   ```
3. Itakda ang iyong GitHub token bilang environment variable:
   ```bash
   # macOS/Linux
   export GITHUB_TOKEN=your_token_here
   
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_token_here"
   ```

4. Patakbuhin ang application:
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.githubmodels.App"
   ```

Makikita mo ang output na katulad ng:
```text
Using model: gpt-4.1-nano
Sending request to GitHub Models...
Response: Hello World!
```

### Pag-unawa sa Example Code

Unawain muna natin ang code na ating tatakbuhin. Ang halimbawa ay gumagamit ng OpenAI Java SDK upang kumonekta sa GitHub Models:

**Ano ang ginagawa ng code na ito:**
- **Kumokonekta** sa GitHub Models gamit ang iyong personal access token
- **Nagpapadala** ng simpleng mensaheng "Say Hello World!" sa AI model
- **Tumatanggap** at nagpapakita ng tugon mula sa AI
- **Sinusuri** kung gumagana nang tama ang iyong setup

**Pangunahing Dependency** (sa `pom.xml`):
```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

**Pangunahing Code** (`App.java`):
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

## Buod

**Binabati kita!** Matagumpay mong:

- **Nagawa ang GitHub Personal Access Token** na may tamang pahintulot para sa AI model access
- **Na-set up ang iyong Java development environment** gamit ang Codespaces, dev containers, o lokal na pag-install
- **Nakakonekta sa GitHub Models** gamit ang OpenAI Java SDK para sa libreng AI development access
- **Nasubukan ang integration** gamit ang gumaganang example application na nakikipag-usap sa AI models

## Mga Susunod na Hakbang

[Chapter 3: Core Generative AI Techniques](../03-CoreGenerativeAITechniques/README.md)

## Pag-aayos ng Problema

May mga isyu? Narito ang mga karaniwang problema at solusyon:

- **Hindi gumagana ang token?** 
  - Siguraduhing kinopya mo ang buong token nang walang dagdag na espasyo
  - Tiyaking tama ang pagkakatalaga ng token bilang environment variable
  - Suriin kung tama ang pahintulot ng iyong token (Models: Read and write)

- **Hindi mahanap ang Maven?** 
  - Kung gumagamit ng dev containers/Codespaces, dapat naka-pre-install ang Maven
  - Para sa lokal na setup, tiyaking naka-install ang Java 21+ at Maven 3.9+
  - Subukang patakbuhin ang `mvn --version` upang suriin ang pag-install

- **Mga isyu sa koneksyon?** 
  - Suriin ang iyong koneksyon sa internet
  - Tiyaking naa-access ang GitHub mula sa iyong network
  - Siguraduhing walang firewall na humaharang sa GitHub Models endpoint

- **Hindi nagsisimula ang dev container?** 
  - Siguraduhing tumatakbo ang Docker Desktop (para sa lokal na development)
  - Subukang i-rebuild ang container: `Ctrl+Shift+P` → "Dev Containers: Rebuild Container"

- **Mga error sa compilation ng application?**
  - Siguraduhing nasa tamang direktoryo ka: `02-SetupDevEnvironment/src/github-models`
  - Subukang linisin at i-rebuild: `mvn clean compile`

> **Kailangan ng tulong?**: May problema pa rin? Magbukas ng isyu sa repositoryo at tutulungan ka namin.

**Paunawa**:  
Ang dokumentong ito ay isinalin gamit ang AI translation service na [Co-op Translator](https://github.com/Azure/co-op-translator). Bagama't sinisikap naming maging tumpak, pakitandaan na ang mga awtomatikong pagsasalin ay maaaring maglaman ng mga pagkakamali o hindi pagkakatugma. Ang orihinal na dokumento sa kanyang katutubong wika ang dapat ituring na opisyal na sanggunian. Para sa mahalagang impormasyon, inirerekomenda ang propesyonal na pagsasalin ng tao. Hindi kami mananagot sa anumang hindi pagkakaunawaan o maling interpretasyon na dulot ng paggamit ng pagsasaling ito.