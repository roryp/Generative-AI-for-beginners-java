<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "d064108b2142d32246ccbd8a42e76b4d",
  "translation_date": "2025-07-25T10:05:50+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "ro"
}
-->
# Aplicație Locală Foundry în Linia de Comandă

>**Notă**: Acest capitol include un [**Tutorial**](./TUTORIAL.md) care te ghidează prin exemple.

O aplicație simplă Spring Boot în linia de comandă care demonstrează cum să te conectezi la Foundry Local folosind OpenAI Java SDK.

## Ce Vei Învăța

- Cum să integrezi Foundry Local cu aplicații Spring Boot utilizând OpenAI Java SDK
- Cele mai bune practici pentru dezvoltarea și testarea AI locală

## Cuprins

- [Ce Vei Învăța](../../../../04-PracticalSamples/foundrylocal)
- [Prerechizite](../../../../04-PracticalSamples/foundrylocal)
  - [Instalarea Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [Verificare](../../../../04-PracticalSamples/foundrylocal)
- [Configurare](../../../../04-PracticalSamples/foundrylocal)
- [Start Rapid](../../../../04-PracticalSamples/foundrylocal)
- [Ce Face Aplicația](../../../../04-PracticalSamples/foundrylocal)
- [Exemplu de Output](../../../../04-PracticalSamples/foundrylocal)
- [Arhitectură](../../../../04-PracticalSamples/foundrylocal)
- [Aspecte Cheie ale Codului](../../../../04-PracticalSamples/foundrylocal)
  - [Integrarea OpenAI Java SDK](../../../../04-PracticalSamples/foundrylocal)
  - [API-ul de Completare Chat](../../../../04-PracticalSamples/foundrylocal)
- [Depanare](../../../../04-PracticalSamples/foundrylocal)

## Prerechizite

> **⚠️ Notă**: Această aplicație **nu rulează în devcontainer-ul furnizat** deoarece necesită ca Foundry Local să fie instalat și să ruleze pe sistemul gazdă.

### Instalarea Foundry Local

Înainte de a rula această aplicație, trebuie să instalezi și să pornești Foundry Local. Urmează acești pași:

1. **Asigură-te că sistemul tău îndeplinește cerințele**:
   - **Sistem de Operare**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025 sau macOS
   - **Hardware**: 
     - Minim: 8GB RAM, 3GB spațiu liber pe disc
     - Recomandat: 16GB RAM, 15GB spațiu liber pe disc
   - **Rețea**: Conexiune la internet pentru descărcarea inițială a modelului (opțional pentru utilizare offline)
   - **Accelerare (opțional)**: GPU NVIDIA (seria 2,000 sau mai nouă), GPU AMD (seria 6,000 sau mai nouă), Qualcomm Snapdragon X Elite (8GB sau mai mult memorie) sau Apple silicon
   - **Permisiuni**: Privilegii administrative pentru instalarea software-ului pe dispozitivul tău

2. **Instalează Foundry Local**:
   
   **Pentru Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **Pentru macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Alternativ, poți descărca instalatorul din [repository-ul GitHub Foundry Local](https://github.com/microsoft/Foundry-Local).

3. **Pornește primul model**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   Modelul se descarcă (ceea ce poate dura câteva minute, în funcție de viteza internetului) și apoi rulează. Foundry Local selectează automat cea mai bună variantă de model pentru sistemul tău (CUDA pentru GPU-uri NVIDIA, versiunea CPU altfel).

4. **Testează modelul** punând o întrebare în același terminal:

   ```bash
   Why is the sky blue?
   ```

   Ar trebui să vezi un răspuns de la modelul Phi explicând de ce cerul pare albastru.

### Verificare

Poți verifica dacă totul funcționează corect cu aceste comenzi:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

De asemenea, poți vizita `http://localhost:5273` în browserul tău pentru a vedea interfața web Foundry Local.

## Configurare

Aplicația poate fi configurată prin `application.properties`:

- `foundry.local.base-url` - URL-ul de bază pentru Foundry Local (implicit: http://localhost:5273)
- `foundry.local.model` - Modelul AI utilizat (implicit: Phi-3.5-mini-instruct-cuda-gpu)

> **Notă**: Numele modelului din configurație ar trebui să corespundă variantei specifice pe care Foundry Local a descărcat-o pentru sistemul tău. Când rulezi `foundry model run phi-3.5-mini`, Foundry Local selectează și descarcă automat cea mai bună variantă (CUDA pentru GPU-uri NVIDIA, versiunea CPU altfel). Folosește `foundry model list` pentru a vedea numele exact al modelului disponibil în instanța ta locală.

## Start Rapid

### 1. Navighează la directorul aplicației Foundry Local
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Rulează Aplicația

```bash
mvn spring-boot:run
```

Sau construiește și rulează JAR-ul:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Dependențe

Această aplicație folosește OpenAI Java SDK pentru a comunica cu Foundry Local. Dependența cheie este:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

Aplicația este pre-configurată pentru a se conecta la Foundry Local care rulează pe portul implicit.

## Ce Face Aplicația

Când rulezi aplicația:

1. **Pornește** ca o aplicație în linia de comandă (fără server web)
2. **Trimite automat** un mesaj de test: "Salut! Poți să-mi spui ce ești și ce model rulezi?"
3. **Afișează răspunsul** de la Foundry Local în consolă
4. **Se închide curat** după demo

## Exemplu de Output

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Arhitectură

- **Application.java** - Aplicația principală Spring Boot cu CommandLineRunner
- **FoundryLocalService.java** - Serviciu care folosește OpenAI Java SDK pentru a comunica cu Foundry Local
- Folosește **OpenAI Java SDK** pentru apeluri API tip-safe
- Serializare/deserializare JSON automată gestionată de SDK
- Configurare curată utilizând adnotările `@Value` și `@PostConstruct` din Spring

## Aspecte Cheie ale Codului

### Integrarea OpenAI Java SDK

Aplicația folosește OpenAI Java SDK pentru a crea un client configurat pentru Foundry Local:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### API-ul de Completare Chat

Realizarea cererilor de completare chat este simplă și tip-safe:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Depanare

Dacă vezi erori de conexiune:
1. Verifică dacă Foundry Local rulează pe `http://localhost:5273`
2. Verifică dacă o variantă a modelului Phi-3.5-mini este disponibilă cu `foundry model list`
3. Asigură-te că numele modelului din `application.properties` corespunde exact numelui modelului afișat în listă
4. Asigură-te că niciun firewall nu blochează conexiunea

Probleme comune:
- **Modelul nu a fost găsit**: Rulează `foundry model run phi-3.5-mini` pentru a descărca și porni modelul
- **Serviciul nu rulează**: Serviciul Foundry Local s-ar putea să se fi oprit; repornește-l cu comanda de rulare a modelului
- **Nume greșit al modelului**: Folosește `foundry model list` pentru a vedea modelele disponibile și actualizează configurația în consecință

**Declinare de responsabilitate**:  
Acest document a fost tradus folosind serviciul de traducere AI [Co-op Translator](https://github.com/Azure/co-op-translator). Deși ne străduim să asigurăm acuratețea, vă rugăm să fiți conștienți că traducerile automate pot conține erori sau inexactități. Documentul original în limba sa natală ar trebui considerat sursa autoritară. Pentru informații critice, se recomandă traducerea profesională realizată de un specialist uman. Nu ne asumăm responsabilitatea pentru eventualele neînțelegeri sau interpretări greșite care pot apărea din utilizarea acestei traduceri.