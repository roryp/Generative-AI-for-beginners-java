<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "59454ab4ec36d89840df6fcfe7633cbd",
  "translation_date": "2025-07-25T11:32:21+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "no"
}
-->
# Kjerneveiledning for Generative AI-teknikker

## Innholdsfortegnelse

- [Forutsetninger](../../../03-CoreGenerativeAITechniques)
- [Komme i gang](../../../03-CoreGenerativeAITechniques)
  - [Trinn 1: Sett miljøvariabelen din](../../../03-CoreGenerativeAITechniques)
  - [Trinn 2: Naviger til eksempelkatalogen](../../../03-CoreGenerativeAITechniques)
- [Veiledning 1: LLM-fullføringer og chat](../../../03-CoreGenerativeAITechniques)
- [Veiledning 2: Funksjonskall](../../../03-CoreGenerativeAITechniques)
- [Veiledning 3: RAG (Retrieval-Augmented Generation)](../../../03-CoreGenerativeAITechniques)
- [Veiledning 4: Ansvarlig AI](../../../03-CoreGenerativeAITechniques)
- [Felles mønstre på tvers av eksempler](../../../03-CoreGenerativeAITechniques)
- [Neste steg](../../../03-CoreGenerativeAITechniques)
- [Feilsøking](../../../03-CoreGenerativeAITechniques)
  - [Vanlige problemer](../../../03-CoreGenerativeAITechniques)

## Oversikt

Denne veiledningen gir praktiske eksempler på kjerne-teknikker innen generativ AI ved bruk av Java og GitHub Models. Du vil lære hvordan du interagerer med Large Language Models (LLMs), implementerer funksjonskall, bruker retrieval-augmented generation (RAG) og anvender ansvarlige AI-praksiser.

## Forutsetninger

Før du starter, sørg for at du har:
- Java 21 eller nyere installert
- Maven for avhengighetsstyring
- En GitHub-konto med en personlig tilgangstoken (PAT)

## Komme i gang

### Trinn 1: Sett miljøvariabelen din

Først må du sette GitHub-tokenet ditt som en miljøvariabel. Dette tokenet gir deg tilgang til GitHub Models gratis.

**Windows (Kommandolinje):**
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

### Trinn 2: Naviger til eksempelkatalogen

```bash
cd 03-CoreGenerativeAITechniques/examples/
```

## Veiledning 1: LLM-fullføringer og chat

**Fil:** `src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

### Hva dette eksemplet lærer deg

Dette eksemplet viser de grunnleggende mekanismene for interaksjon med Large Language Models (LLMs) via OpenAI API, inkludert klientinitialisering med GitHub Models, mønstre for meldingsstruktur for system- og brukerforespørsler, håndtering av samtalestatus gjennom akkumulering av meldingshistorikk, og justering av parametere for å kontrollere svarlengde og kreativitet.

### Viktige kodekonsepter

#### 1. Klientoppsett
```java
// Create the AI client
OpenAIClient client = new OpenAIClientBuilder()
    .endpoint("https://models.inference.ai.azure.com")
    .credential(new StaticTokenCredential(pat))
    .buildClient();
```

Dette oppretter en tilkobling til GitHub Models ved hjelp av tokenet ditt.

#### 2. Enkel fullføring
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

#### 3. Samtaleminne
```java
// Add AI's response to maintain conversation history
messages.add(new ChatRequestAssistantMessage(aiResponse));
messages.add(new ChatRequestUserMessage("Follow-up question"));
```

AI husker tidligere meldinger bare hvis du inkluderer dem i påfølgende forespørsler.

### Kjør eksemplet
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
```

### Hva som skjer når du kjører det

1. **Enkel fullføring**: AI svarer på et Java-spørsmål med veiledning fra systemprompt
2. **Flertrinns chat**: AI opprettholder kontekst på tvers av flere spørsmål
3. **Interaktiv chat**: Du kan ha en ekte samtale med AI-en

## Veiledning 2: Funksjonskall

**Fil:** `src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

### Hva dette eksemplet lærer deg

Funksjonskall gjør det mulig for AI-modeller å be om utførelse av eksterne verktøy og API-er gjennom en strukturert protokoll der modellen analyserer forespørsler i naturlig språk, bestemmer nødvendige funksjonskall med riktige parametere ved hjelp av JSON Schema-definisjoner, og behandler returnerte resultater for å generere kontekstuelle svar, mens selve funksjonsutførelsen forblir under utviklerens kontroll for sikkerhet og pålitelighet.

### Viktige kodekonsepter

#### 1. Funksjonsdefinisjon
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

Dette forteller AI hvilke funksjoner som er tilgjengelige og hvordan de skal brukes.

#### 2. Flyt for funksjonsutførelse
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

#### 3. Funksjonsimplementasjon
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

### Kjør eksemplet
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
```

### Hva som skjer når du kjører det

1. **Værfunksjon**: AI ber om værdata for Seattle, du gir det, AI formaterer et svar
2. **Kalkulatorfunksjon**: AI ber om en beregning (15 % av 240), du utfører den, AI forklarer resultatet

## Veiledning 3: RAG (Retrieval-Augmented Generation)

**Fil:** `src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

### Hva dette eksemplet lærer deg

Retrieval-Augmented Generation (RAG) kombinerer informasjonsinnhenting med språkproduksjon ved å injisere ekstern dokumentkontekst i AI-prompter, slik at modeller kan gi nøyaktige svar basert på spesifikke kunnskapskilder i stedet for potensielt utdaterte eller unøyaktige treningsdata, samtidig som klare grenser opprettholdes mellom brukerforespørsler og autoritative informasjonskilder gjennom strategisk promptdesign.

### Viktige kodekonsepter

#### 1. Dokumentlasting
```java
// Load your knowledge source
String doc = Files.readString(Paths.get("document.txt"));
```

#### 2. Kontekstinjeksjon
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

De triple anførselstegnene hjelper AI med å skille mellom kontekst og spørsmål.

#### 3. Sikker håndtering av svar
```java
if (response != null && response.getChoices() != null && !response.getChoices().isEmpty()) {
    String answer = response.getChoices().get(0).getMessage().getContent();
    System.out.println("Assistant: " + answer);
} else {
    System.err.println("Error: No response received from the API.");
}
```

Valider alltid API-svar for å unngå krasj.

### Kjør eksemplet
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
```

### Hva som skjer når du kjører det

1. Programmet laster inn `document.txt` (inneholder info om GitHub Models)
2. Du stiller et spørsmål om dokumentet
3. AI svarer kun basert på dokumentinnholdet, ikke sin generelle kunnskap

Prøv å spørre: "Hva er GitHub Models?" vs "Hvordan er været?"

## Veiledning 4: Ansvarlig AI

**Fil:** `src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

### Hva dette eksemplet lærer deg

Eksemplet på ansvarlig AI viser viktigheten av å implementere sikkerhetstiltak i AI-applikasjoner. Det demonstrerer sikkerhetsfiltre som oppdager skadelige innholdskategorier, inkludert hatprat, trakassering, selvskading, seksuelt innhold og vold, og viser hvordan produksjons-AI-applikasjoner bør håndtere brudd på innholdspolicyer på en god måte gjennom riktig unntakshåndtering, brukerfeedbackmekanismer og fallback-strategier.

### Viktige kodekonsepter

#### 1. Rammeverk for sikkerhetstesting
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

#### 2. Testede sikkerhetskategorier
- Vold/skadeinstruksjoner
- Hatprat
- Brudd på personvern
- Medisinsk feilinformasjon
- Ulovlige aktiviteter

### Kjør eksemplet
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
```

### Hva som skjer når du kjører det

Programmet tester ulike skadelige forespørsler og viser hvordan AI-sikkerhetssystemet:
1. **Blokkerer farlige forespørsler** med HTTP 400-feil
2. **Tillater trygt innhold** å genereres normalt
3. **Beskytter brukere** mot skadelige AI-utganger

## Felles mønstre på tvers av eksempler

### Autentiseringsmønster
Alle eksempler bruker dette mønsteret for å autentisere med GitHub Models:

```java
String pat = System.getenv("GITHUB_TOKEN");
TokenCredential credential = new StaticTokenCredential(pat);
OpenAIClient client = new OpenAIClientBuilder()
    .endpoint("https://models.inference.ai.azure.com")
    .credential(credential)
    .buildClient();
```

### Feilhåndteringsmønster
```java
try {
    // AI operation
} catch (HttpResponseException e) {
    // Handle API errors (rate limits, safety filters)
} catch (Exception e) {
    // Handle general errors (network, parsing)
}
```

### Meldingstrukturmønster
```java
List<ChatRequestMessage> messages = List.of(
    new ChatRequestSystemMessage("Set AI behavior"),
    new ChatRequestUserMessage("User's actual request")
);
```

## Neste steg

[Kapittel 04: Praktiske eksempler](../04-PracticalSamples/README.md)

## Feilsøking

### Vanlige problemer

**"GITHUB_TOKEN ikke satt"**
- Sørg for at du har satt miljøvariabelen
- Verifiser at tokenet ditt har `models:read`-tillatelse

**"Ingen respons fra API"**
- Sjekk internettforbindelsen din
- Verifiser at tokenet ditt er gyldig
- Sjekk om du har nådd grenseverdier

**Maven-kompileringsfeil**
- Sørg for at du har Java 21 eller nyere
- Kjør `mvn clean compile` for å oppdatere avhengigheter

**Ansvarsfraskrivelse**:  
Dette dokumentet er oversatt ved hjelp av AI-oversettelsestjenesten [Co-op Translator](https://github.com/Azure/co-op-translator). Selv om vi streber etter nøyaktighet, vær oppmerksom på at automatiserte oversettelser kan inneholde feil eller unøyaktigheter. Det originale dokumentet på sitt opprinnelige språk bør anses som den autoritative kilden. For kritisk informasjon anbefales profesjonell menneskelig oversettelse. Vi er ikke ansvarlige for misforståelser eller feiltolkninger som oppstår ved bruk av denne oversettelsen.