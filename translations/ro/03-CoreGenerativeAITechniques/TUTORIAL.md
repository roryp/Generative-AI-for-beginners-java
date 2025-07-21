<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "59454ab4ec36d89840df6fcfe7633cbd",
  "translation_date": "2025-07-21T20:45:41+00:00",
  "source_file": "03-CoreGenerativeAITechniques/TUTORIAL.md",
  "language_code": "ro"
}
-->
# Tutorial Tehnici de Bază în AI Generativ

## Cuprins

- [Cerințe preliminare](../../../03-CoreGenerativeAITechniques)
- [Introducere](../../../03-CoreGenerativeAITechniques)
  - [Pasul 1: Setează variabila de mediu](../../../03-CoreGenerativeAITechniques)
  - [Pasul 2: Navighează la directorul de exemple](../../../03-CoreGenerativeAITechniques)
- [Tutorial 1: Completări și Chat cu LLM](../../../03-CoreGenerativeAITechniques)
- [Tutorial 2: Apelarea Funcțiilor](../../../03-CoreGenerativeAITechniques)
- [Tutorial 3: RAG (Generare Augmentată prin Recuperare)](../../../03-CoreGenerativeAITechniques)
- [Tutorial 4: AI Responsabil](../../../03-CoreGenerativeAITechniques)
- [Modele comune în exemple](../../../03-CoreGenerativeAITechniques)
- [Pași următori](../../../03-CoreGenerativeAITechniques)
- [Depanare](../../../03-CoreGenerativeAITechniques)
  - [Probleme comune](../../../03-CoreGenerativeAITechniques)

## Prezentare generală

Acest tutorial oferă exemple practice ale tehnicilor de bază în AI generativ folosind Java și GitHub Models. Vei învăța cum să interacționezi cu Modele de Limbaj de Mari Dimensiuni (LLM), să implementezi apelarea funcțiilor, să utilizezi generarea augmentată prin recuperare (RAG) și să aplici practici de AI responsabil.

## Cerințe preliminare

Înainte de a începe, asigură-te că ai:
- Java 21 sau o versiune mai recentă instalată
- Maven pentru gestionarea dependențelor
- Un cont GitHub cu un token de acces personal (PAT)

## Introducere

### Pasul 1: Setează variabila de mediu

Mai întâi, trebuie să setezi token-ul GitHub ca variabilă de mediu. Acest token îți permite să accesezi gratuit GitHub Models.

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

### Pasul 2: Navighează la directorul de exemple

```bash
cd 03-CoreGenerativeAITechniques/examples/
```

## Tutorial 1: Completări și Chat cu LLM

**Fișier:** `src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

### Ce învață acest exemplu

Acest exemplu demonstrează mecanismele de bază ale interacțiunii cu Modele de Limbaj de Mari Dimensiuni (LLM) prin API-ul OpenAI, inclusiv inițializarea clientului cu GitHub Models, structura mesajelor pentru prompturi de sistem și utilizator, gestionarea stării conversației prin acumularea istoricului mesajelor și ajustarea parametrilor pentru controlul lungimii răspunsurilor și nivelului de creativitate.

### Concepte cheie în cod

#### 1. Configurarea clientului
```java
// Create the AI client
OpenAIClient client = new OpenAIClientBuilder()
    .endpoint("https://models.inference.ai.azure.com")
    .credential(new StaticTokenCredential(pat))
    .buildClient();
```

Aceasta creează o conexiune cu GitHub Models folosind token-ul tău.

#### 2. Completare simplă
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

#### 3. Memoria conversației
```java
// Add AI's response to maintain conversation history
messages.add(new ChatRequestAssistantMessage(aiResponse));
messages.add(new ChatRequestUserMessage("Follow-up question"));
```

AI își amintește mesajele anterioare doar dacă le incluzi în cererile ulterioare.

### Rulează exemplul
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
```

### Ce se întâmplă când îl rulezi

1. **Completare simplă**: AI răspunde la o întrebare despre Java, ghidat de promptul de sistem.
2. **Chat pe mai multe rânduri**: AI menține contextul pe parcursul mai multor întrebări.
3. **Chat interactiv**: Poți avea o conversație reală cu AI-ul.

## Tutorial 2: Apelarea Funcțiilor

**Fișier:** `src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

### Ce învață acest exemplu

Apelarea funcțiilor permite modelelor AI să solicite execuția unor instrumente și API-uri externe printr-un protocol structurat, în care modelul analizează cererile în limbaj natural, determină apelurile de funcții necesare cu parametrii corespunzători folosind definiții JSON Schema și procesează rezultatele returnate pentru a genera răspunsuri contextuale, în timp ce execuția efectivă a funcțiilor rămâne sub controlul dezvoltatorului pentru securitate și fiabilitate.

### Concepte cheie în cod

#### 1. Definirea funcției
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

Aceasta spune AI-ului ce funcții sunt disponibile și cum să le folosească.

#### 2. Fluxul de execuție al funcției
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

#### 3. Implementarea funcției
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

### Rulează exemplul
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
```

### Ce se întâmplă când îl rulezi

1. **Funcția Meteo**: AI solicită date meteo pentru Seattle, tu le furnizezi, AI formatează un răspuns.
2. **Funcția Calculator**: AI solicită un calcul (15% din 240), tu îl calculezi, AI explică rezultatul.

## Tutorial 3: RAG (Generare Augmentată prin Recuperare)

**Fișier:** `src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

### Ce învață acest exemplu

Generarea Augmentată prin Recuperare (RAG) combină recuperarea informațiilor cu generarea de limbaj prin injectarea contextului documentelor externe în prompturile AI, permițând modelelor să ofere răspunsuri precise bazate pe surse de cunoștințe specifice, mai degrabă decât pe date de antrenament potențial învechite sau inexacte, menținând în același timp limite clare între întrebările utilizatorului și sursele de informații autorizate prin inginerie strategică a prompturilor.

### Concepte cheie în cod

#### 1. Încărcarea documentelor
```java
// Load your knowledge source
String doc = Files.readString(Paths.get("document.txt"));
```

#### 2. Injectarea contextului
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

Triplele ghilimele ajută AI-ul să distingă între context și întrebare.

#### 3. Gestionarea sigură a răspunsurilor
```java
if (response != null && response.getChoices() != null && !response.getChoices().isEmpty()) {
    String answer = response.getChoices().get(0).getMessage().getContent();
    System.out.println("Assistant: " + answer);
} else {
    System.err.println("Error: No response received from the API.");
}
```

Validează întotdeauna răspunsurile API-ului pentru a preveni erorile.

### Rulează exemplul
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
```

### Ce se întâmplă când îl rulezi

1. Programul încarcă `document.txt` (conține informații despre GitHub Models).
2. Pui o întrebare despre document.
3. AI răspunde bazându-se doar pe conținutul documentului, nu pe cunoștințele sale generale.

Încearcă să întrebi: "Ce sunt GitHub Models?" vs "Cum este vremea?"

## Tutorial 4: AI Responsabil

**Fișier:** `src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

### Ce învață acest exemplu

Exemplul de AI Responsabil evidențiază importanța implementării măsurilor de siguranță în aplicațiile AI. Demonstrează filtre de siguranță care detectează categorii de conținut dăunător, inclusiv discurs de ură, hărțuire, auto-vătămare, conținut sexual și violență, arătând cum aplicațiile AI de producție ar trebui să gestioneze cu grație încălcările politicii de conținut prin gestionarea excepțiilor, mecanisme de feedback pentru utilizatori și strategii de răspuns de rezervă.

### Concepte cheie în cod

#### 1. Cadru de testare a siguranței
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

#### 2. Categorii de siguranță testate
- Instrucțiuni de violență/auto-vătămare
- Discurs de ură
- Încălcări ale confidențialității
- Dezinformare medicală
- Activități ilegale

### Rulează exemplul
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
```

### Ce se întâmplă când îl rulezi

Programul testează diverse prompturi dăunătoare și arată cum sistemul de siguranță AI:
1. **Blochează cererile periculoase** cu erori HTTP 400.
2. **Permite conținutul sigur** să fie generat normal.
3. **Protejează utilizatorii** de ieșiri AI dăunătoare.

## Modele comune în exemple

### Model de autentificare
Toate exemplele folosesc acest model pentru autentificarea cu GitHub Models:

```java
String pat = System.getenv("GITHUB_TOKEN");
TokenCredential credential = new StaticTokenCredential(pat);
OpenAIClient client = new OpenAIClientBuilder()
    .endpoint("https://models.inference.ai.azure.com")
    .credential(credential)
    .buildClient();
```

### Model de gestionare a erorilor
```java
try {
    // AI operation
} catch (HttpResponseException e) {
    // Handle API errors (rate limits, safety filters)
} catch (Exception e) {
    // Handle general errors (network, parsing)
}
```

### Model de structură a mesajelor
```java
List<ChatRequestMessage> messages = List.of(
    new ChatRequestSystemMessage("Set AI behavior"),
    new ChatRequestUserMessage("User's actual request")
);
```

## Pași următori

[Capitolul 04: Exemple practice](../04-PracticalSamples/README.md)

## Depanare

### Probleme comune

**"GITHUB_TOKEN not set"**
- Asigură-te că ai setat variabila de mediu.
- Verifică dacă token-ul tău are scopul `models:read`.

**"No response from API"**
- Verifică conexiunea la internet.
- Asigură-te că token-ul tău este valid.
- Verifică dacă ai atins limitele de rată.

**Erori de compilare Maven**
- Asigură-te că ai Java 21 sau o versiune mai recentă.
- Rulează `mvn clean compile` pentru a reîmprospăta dependențele.

**Declinare de responsabilitate**:  
Acest document a fost tradus folosind serviciul de traducere AI [Co-op Translator](https://github.com/Azure/co-op-translator). Deși ne străduim să asigurăm acuratețea, vă rugăm să fiți conștienți că traducerile automate pot conține erori sau inexactități. Documentul original în limba sa natală ar trebui considerat sursa autoritară. Pentru informații critice, se recomandă traducerea profesională realizată de un specialist uman. Nu ne asumăm responsabilitatea pentru eventualele neînțelegeri sau interpretări greșite care pot apărea din utilizarea acestei traduceri.