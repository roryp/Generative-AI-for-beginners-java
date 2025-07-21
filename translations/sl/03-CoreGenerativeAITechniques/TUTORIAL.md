<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "59454ab4ec36d89840df6fcfe7633cbd",
  "translation_date": "2025-07-21T20:47:52+00:00",
  "source_file": "03-CoreGenerativeAITechniques/TUTORIAL.md",
  "language_code": "sl"
}
-->
# Vadnica o osnovnih tehnikah generativne umetne inteligence

## Kazalo

- [Predpogoji](../../../03-CoreGenerativeAITechniques)
- [Začetek](../../../03-CoreGenerativeAITechniques)
  - [1. korak: Nastavite okoljsko spremenljivko](../../../03-CoreGenerativeAITechniques)
  - [2. korak: Premaknite se v imenik primerov](../../../03-CoreGenerativeAITechniques)
- [Vadnica 1: Dokončanja in klepet z LLM](../../../03-CoreGenerativeAITechniques)
- [Vadnica 2: Klic funkcij](../../../03-CoreGenerativeAITechniques)
- [Vadnica 3: RAG (Generacija z obogatitvijo pridobljenih podatkov)](../../../03-CoreGenerativeAITechniques)
- [Vadnica 4: Odgovorna umetna inteligenca](../../../03-CoreGenerativeAITechniques)
- [Skupni vzorci v primerih](../../../03-CoreGenerativeAITechniques)
- [Naslednji koraki](../../../03-CoreGenerativeAITechniques)
- [Odpravljanje težav](../../../03-CoreGenerativeAITechniques)
  - [Pogoste težave](../../../03-CoreGenerativeAITechniques)

## Pregled

Ta vadnica ponuja praktične primere osnovnih tehnik generativne umetne inteligence z uporabo Jave in GitHub Modelov. Naučili se boste, kako komunicirati z velikimi jezikovnimi modeli (LLM), implementirati klice funkcij, uporabljati generacijo z obogatitvijo pridobljenih podatkov (RAG) in uporabljati prakse odgovorne umetne inteligence.

## Predpogoji

Pred začetkom se prepričajte, da imate:
- Nameščeno Javo 21 ali novejšo
- Maven za upravljanje odvisnosti
- GitHub račun z osebnim dostopnim žetonom (PAT)

## Začetek

### 1. korak: Nastavite okoljsko spremenljivko

Najprej morate nastaviti svoj GitHub žeton kot okoljsko spremenljivko. Ta žeton vam omogoča dostop do GitHub Modelov brezplačno.

**Windows (Command Prompt):**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Windows (PowerShell):**
```powershell
$env:GITHUB_TOKEN="your_github_token_here"
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

### 2. korak: Premaknite se v imenik primerov

```bash
cd 03-CoreGenerativeAITechniques/examples/
```

## Vadnica 1: Dokončanja in klepet z LLM

**Datoteka:** `src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

### Kaj se boste naučili v tem primeru

Ta primer prikazuje osnovne mehanizme interakcije z velikimi jezikovnimi modeli (LLM) prek OpenAI API-ja, vključno z inicializacijo odjemalca z GitHub Modeli, vzorci strukture sporočil za sistemske in uporabniške pozive, upravljanje stanja pogovora z akumulacijo zgodovine sporočil in prilagajanjem parametrov za nadzor dolžine odgovorov in ravni ustvarjalnosti.

### Ključni koncepti kode

#### 1. Nastavitev odjemalca
```java
// Create the AI client
OpenAIClient client = new OpenAIClientBuilder()
    .endpoint("https://models.inference.ai.azure.com")
    .credential(new StaticTokenCredential(pat))
    .buildClient();
```

To ustvari povezavo z GitHub Modeli z uporabo vašega žetona.

#### 2. Preprosto dokončanje
```java
List<ChatRequestMessage> messages = List.of(
    // System message sets AI behavior
    new ChatRequestSystemMessage("You are a helpful Java expert."),
    // User message contains the actual question
    new ChatRequestUserMessage("Explain Java streams briefly.")
);

ChatCompletionsOptions options = new ChatCompletionsOptions(messages)
    .setModel("gpt-4o-mini")
    .setMaxTokens(200)      // Limit response length
    .setTemperature(0.7);   // Control creativity (0.0-1.0)
```

#### 3. Spomin na pogovor
```java
// Add AI's response to maintain conversation history
messages.add(new ChatRequestAssistantMessage(aiResponse));
messages.add(new ChatRequestUserMessage("Follow-up question"));
```

AI si zapomni prejšnja sporočila le, če jih vključite v naslednje zahteve.

### Zagon primera
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
```

### Kaj se zgodi, ko ga zaženete

1. **Preprosto dokončanje**: AI odgovori na vprašanje o Javi z uporabo sistemskega poziva
2. **Večkratni klepet**: AI ohranja kontekst med več vprašanji
3. **Interaktivni klepet**: Lahko imate pravi pogovor z AI

## Vadnica 2: Klic funkcij

**Datoteka:** `src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

### Kaj se boste naučili v tem primeru

Klic funkcij omogoča modelom AI, da zahtevajo izvajanje zunanjih orodij in API-jev prek strukturiranega protokola, kjer model analizira zahteve v naravnem jeziku, določi potrebne klice funkcij z ustreznimi parametri z uporabo definicij JSON Schema in obdela vrnjene rezultate za ustvarjanje kontekstualnih odgovorov, medtem ko dejansko izvajanje funkcij ostaja pod nadzorom razvijalca zaradi varnosti in zanesljivosti.

### Ključni koncepti kode

#### 1. Definicija funkcije
```java
ChatCompletionsFunctionToolDefinitionFunction weatherFunction = 
    new ChatCompletionsFunctionToolDefinitionFunction("get_weather");
weatherFunction.setDescription("Get current weather information for a city");

// Define parameters using JSON Schema
weatherFunction.setParameters(BinaryData.fromString("""
    {
        "type": "object",
        "properties": {
            "city": {
                "type": "string",
                "description": "The city name"
            }
        },
        "required": ["city"]
    }
    """));
```

To pove AI, katere funkcije so na voljo in kako jih uporabiti.

#### 2. Potek izvajanja funkcije
```java
// 1. AI requests a function call
if (choice.getFinishReason() == CompletionsFinishReason.TOOL_CALLS) {
    ChatCompletionsFunctionToolCall functionCall = ...;
    
    // 2. You execute the function
    String result = simulateWeatherFunction(functionCall.getFunction().getArguments());
    
    // 3. You give the result back to AI
    messages.add(new ChatRequestToolMessage(result, toolCall.getId()));
    
    // 4. AI provides final response with function result
    ChatCompletions finalResponse = client.getChatCompletions(MODEL, options);
}
```

#### 3. Implementacija funkcije
```java
private static String simulateWeatherFunction(String arguments) {
    // Parse arguments and call real weather API
    // For demo, we return mock data
    return """
        {
            "city": "Seattle",
            "temperature": "22",
            "condition": "partly cloudy"
        }
        """;
}
```

### Zagon primera
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
```

### Kaj se zgodi, ko ga zaženete

1. **Funkcija za vreme**: AI zahteva podatke o vremenu za Seattle, vi jih zagotovite, AI oblikuje odgovor
2. **Funkcija kalkulatorja**: AI zahteva izračun (15 % od 240), vi ga izvedete, AI razloži rezultat

## Vadnica 3: RAG (Generacija z obogatitvijo pridobljenih podatkov)

**Datoteka:** `src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

### Kaj se boste naučili v tem primeru

Generacija z obogatitvijo pridobljenih podatkov (RAG) združuje pridobivanje informacij z generacijo jezika tako, da v AI pozive vključi kontekst zunanjih dokumentov, kar modelom omogoča zagotavljanje natančnih odgovorov na podlagi specifičnih virov znanja, namesto da bi se zanašali na potencialno zastarele ali netočne podatke iz usposabljanja, pri čemer ohranja jasne meje med uporabniškimi poizvedbami in avtoritativnimi viri informacij z uporabo strateškega oblikovanja pozivov.

### Ključni koncepti kode

#### 1. Nalaganje dokumentov
```java
// Load your knowledge source
String doc = Files.readString(Paths.get("document.txt"));
```

#### 2. Vbrizgavanje konteksta
```java
List<ChatRequestMessage> messages = List.of(
    new ChatRequestSystemMessage(
        "Use only the CONTEXT to answer. If not in context, say you cannot find it."
    ),
    new ChatRequestUserMessage(
        "CONTEXT:\n\"\"\"\n" + doc + "\n\"\"\"\n\nQUESTION:\n" + question
    )
);
```

Trojni narekovaji pomagajo AI razlikovati med kontekstom in vprašanjem.

#### 3. Varno upravljanje odgovorov
```java
if (response != null && response.getChoices() != null && !response.getChoices().isEmpty()) {
    String answer = response.getChoices().get(0).getMessage().getContent();
    System.out.println("Assistant: " + answer);
} else {
    System.err.println("Error: No response received from the API.");
}
```

Vedno preverite odgovore API-ja, da preprečite zrušitve.

### Zagon primera
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
```

### Kaj se zgodi, ko ga zaženete

1. Program naloži `document.txt` (vsebuje informacije o GitHub Modelih)
2. Postavite vprašanje o dokumentu
3. AI odgovori samo na podlagi vsebine dokumenta, ne na podlagi splošnega znanja

Poskusite vprašati: "Kaj so GitHub Modeli?" v primerjavi z "Kakšno je vreme?"

## Vadnica 4: Odgovorna umetna inteligenca

**Datoteka:** `src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

### Kaj se boste naučili v tem primeru

Primer odgovorne umetne inteligence prikazuje pomen izvajanja varnostnih ukrepov v aplikacijah AI. Prikazuje varnostne filtre, ki zaznavajo škodljive vsebinske kategorije, vključno z govorom sovraštva, nadlegovanjem, samopoškodbami, spolno vsebino in nasiljem, ter prikazuje, kako naj produkcijske AI aplikacije elegantno obravnavajo kršitve vsebinskih politik z ustreznim upravljanjem izjem, mehanizmi povratnih informacij uporabnikov in strategijami nadomestnih odgovorov.

### Ključni koncepti kode

#### 1. Okvir za testiranje varnosti
```java
private void testPromptSafety(String prompt, String category) {
    try {
        // Attempt to get AI response
        ChatCompletions response = client.getChatCompletions(modelId, options);
        System.out.println("Response generated (content appears safe)");
        
    } catch (HttpResponseException e) {
        if (e.getResponse().getStatusCode() == 400) {
            System.out.println("[BLOCKED BY SAFETY FILTER]");
            System.out.println("This is GOOD - safety system working!");
        }
    }
}
```

#### 2. Testirane kategorije varnosti
- Navodila za nasilje/škodo
- Sovražni govor
- Kršitve zasebnosti
- Medicinske napačne informacije
- Nezakonite dejavnosti

### Zagon primera
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
```

### Kaj se zgodi, ko ga zaženete

Program testira različne škodljive pozive in pokaže, kako sistem za varnost AI:
1. **Blokira nevarne zahteve** z napakami HTTP 400
2. **Dovoli varno vsebino**, da se ustvari normalno
3. **Ščiti uporabnike** pred škodljivimi izhodi AI

## Skupni vzorci v primerih

### Vzorec avtentikacije
Vsi primeri uporabljajo ta vzorec za avtentikacijo z GitHub Modeli:

```java
String pat = System.getenv("GITHUB_TOKEN");
TokenCredential credential = new StaticTokenCredential(pat);
OpenAIClient client = new OpenAIClientBuilder()
    .endpoint("https://models.inference.ai.azure.com")
    .credential(credential)
    .buildClient();
```

### Vzorec za obravnavo napak
```java
try {
    // AI operation
} catch (HttpResponseException e) {
    // Handle API errors (rate limits, safety filters)
} catch (Exception e) {
    // Handle general errors (network, parsing)
}
```

### Vzorec strukture sporočil
```java
List<ChatRequestMessage> messages = List.of(
    new ChatRequestSystemMessage("Set AI behavior"),
    new ChatRequestUserMessage("User's actual request")
);
```

## Naslednji koraki

[Chapter 04: Practical samples](../04-PracticalSamples/README.md)

## Odpravljanje težav

### Pogoste težave

**"GITHUB_TOKEN not set"**
- Prepričajte se, da ste nastavili okoljsko spremenljivko
- Preverite, ali ima vaš žeton obseg `models:read`

**"No response from API"**
- Preverite svojo internetno povezavo
- Preverite, ali je vaš žeton veljaven
- Preverite, ali ste dosegli omejitve hitrosti

**Napake pri prevajanju z Maven**
- Prepričajte se, da imate Javo 21 ali novejšo
- Zaženite `mvn clean compile`, da osvežite odvisnosti

**Omejitev odgovornosti**:  
Ta dokument je bil preveden z uporabo storitve AI za prevajanje [Co-op Translator](https://github.com/Azure/co-op-translator). Čeprav si prizadevamo za natančnost, vas prosimo, da upoštevate, da lahko avtomatizirani prevodi vsebujejo napake ali netočnosti. Izvirni dokument v njegovem izvirnem jeziku je treba obravnavati kot avtoritativni vir. Za ključne informacije priporočamo profesionalni človeški prevod. Ne prevzemamo odgovornosti za morebitna nesporazumevanja ali napačne razlage, ki izhajajo iz uporabe tega prevoda.