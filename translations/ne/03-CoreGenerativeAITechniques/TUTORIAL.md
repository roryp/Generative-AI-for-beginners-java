<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "59454ab4ec36d89840df6fcfe7633cbd",
  "translation_date": "2025-07-21T17:44:36+00:00",
  "source_file": "03-CoreGenerativeAITechniques/TUTORIAL.md",
  "language_code": "ne"
}
-->
# कोर जेनेरेटिभ एआई प्रविधिहरू ट्युटोरियल

## सामग्री सूची

- [पूर्वआवश्यकताहरू](../../../03-CoreGenerativeAITechniques)
- [सुरु गर्दै](../../../03-CoreGenerativeAITechniques)
  - [चरण १: आफ्नो वातावरण चर सेट गर्नुहोस्](../../../03-CoreGenerativeAITechniques)
  - [चरण २: उदाहरणहरूको डाइरेक्टरीमा जानुहोस्](../../../03-CoreGenerativeAITechniques)
- [ट्युटोरियल १: LLM कम्प्लिसन र च्याट](../../../03-CoreGenerativeAITechniques)
- [ट्युटोरियल २: फङ्सन कलिङ](../../../03-CoreGenerativeAITechniques)
- [ट्युटोरियल ३: RAG (रिट्रिभल-अग्मेन्टेड जेनेरेसन)](../../../03-CoreGenerativeAITechniques)
- [ट्युटोरियल ४: जिम्मेवार एआई](../../../03-CoreGenerativeAITechniques)
- [उदाहरणहरूमा साझा ढाँचाहरू](../../../03-CoreGenerativeAITechniques)
- [अर्को चरणहरू](../../../03-CoreGenerativeAITechniques)
- [समस्या समाधान](../../../03-CoreGenerativeAITechniques)
  - [सामान्य समस्याहरू](../../../03-CoreGenerativeAITechniques)

## अवलोकन

यो ट्युटोरियलले जाभा र GitHub Models प्रयोग गरेर कोर जेनेरेटिभ एआई प्रविधिहरूको व्यावहारिक उदाहरणहरू प्रदान गर्दछ। तपाईंले ठूलो भाषा मोडेलहरू (LLMs) सँग अन्तरक्रिया गर्न, फङ्सन कलिङ कार्यान्वयन गर्न, रिट्रिभल-अग्मेन्टेड जेनेरेसन (RAG) प्रयोग गर्न, र जिम्मेवार एआई अभ्यासहरू लागू गर्न सिक्नुहुनेछ।

## पूर्वआवश्यकताहरू

सुरु गर्नुअघि, सुनिश्चित गर्नुहोस् कि तपाईंले:
- जाभा २१ वा उच्च संस्करण स्थापना गर्नुभएको छ
- Maven निर्भरता व्यवस्थापनका लागि छ
- व्यक्तिगत पहुँच टोकन (PAT) सहितको GitHub खाता छ

## सुरु गर्दै

### चरण १: आफ्नो वातावरण चर सेट गर्नुहोस्

पहिले, तपाईंले आफ्नो GitHub टोकनलाई वातावरण चरको रूपमा सेट गर्न आवश्यक छ। यो टोकनले तपाईंलाई GitHub Models निःशुल्क पहुँच गर्न अनुमति दिन्छ।

**Windows (कमाण्ड प्रम्प्ट):**
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

### चरण २: उदाहरणहरूको डाइरेक्टरीमा जानुहोस्

```bash
cd 03-CoreGenerativeAITechniques/examples/
```

## ट्युटोरियल १: LLM कम्प्लिसन र च्याट

**फाइल:** `src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

### यो उदाहरणले के सिकाउँछ

यो उदाहरणले OpenAI API मार्फत ठूलो भाषा मोडेल (LLM) सँग अन्तरक्रियाको कोर मेकानिक्स प्रदर्शन गर्दछ। यसमा GitHub Models सँग क्लाइन्ट इनिसियलाइजेसन, प्रणाली र प्रयोगकर्ता प्रम्प्टहरूको लागि सन्देश संरचना ढाँचाहरू, सन्देश इतिहास संकलनद्वारा कुराकानीको अवस्था व्यवस्थापन, र प्रतिक्रिया लम्बाइ र सिर्जनात्मकता स्तर नियन्त्रण गर्नका लागि प्यारामिटर ट्युनिङ समावेश छ।

### मुख्य कोड अवधारणाहरू

#### १. क्लाइन्ट सेटअप
```java
// Create the AI client
OpenAIClient client = new OpenAIClientBuilder()
    .endpoint("https://models.inference.ai.azure.com")
    .credential(new StaticTokenCredential(pat))
    .buildClient();
```

यसले तपाईंको टोकन प्रयोग गरेर GitHub Models सँग जडान बनाउँछ।

#### २. साधारण कम्प्लिसन
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

#### ३. कुराकानी मेमोरी
```java
// Add AI's response to maintain conversation history
messages.add(new ChatRequestAssistantMessage(aiResponse));
messages.add(new ChatRequestUserMessage("Follow-up question"));
```

एआईले अघिल्लो सन्देशहरू सम्झन्छ यदि तपाईंले तिनीहरूलाई पछिल्ला अनुरोधहरूमा समावेश गर्नुभयो भने।

### उदाहरण चलाउनुहोस्
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
```

### यो चलाउँदा के हुन्छ

1. **साधारण कम्प्लिसन**: एआईले प्रणाली प्रम्प्टको मार्गदर्शनमा जाभासम्बन्धी प्रश्नको उत्तर दिन्छ
2. **बहु-चरण च्याट**: एआईले धेरै प्रश्नहरूमा सन्दर्भ कायम राख्छ
3. **इन्टरएक्टिभ च्याट**: तपाईं एआईसँग वास्तविक कुराकानी गर्न सक्नुहुन्छ

## ट्युटोरियल २: फङ्सन कलिङ

**फाइल:** `src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

### यो उदाहरणले के सिकाउँछ

फङ्सन कलिङले एआई मोडेलहरूलाई बाह्य उपकरणहरू र API हरूको कार्यान्वयन अनुरोध गर्न सक्षम बनाउँछ। यसले प्राकृतिक भाषाको अनुरोधहरू विश्लेषण गर्न, JSON Schema परिभाषाहरू प्रयोग गरेर आवश्यक फङ्सन कलहरू र उपयुक्त प्यारामिटरहरू निर्धारण गर्न, र सन्दर्भात्मक प्रतिक्रियाहरू उत्पन्न गर्न परिणामहरू प्रशोधन गर्न मोडेललाई अनुमति दिन्छ। यद्यपि, वास्तविक फङ्सन कार्यान्वयन सुरक्षा र विश्वसनीयताका लागि विकासकर्ताको नियन्त्रणमा रहन्छ।

### मुख्य कोड अवधारणाहरू

#### १. फङ्सन परिभाषा
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

यसले एआईलाई कुन फङ्सनहरू उपलब्ध छन् र तिनीहरू कसरी प्रयोग गर्ने भनेर बताउँछ।

#### २. फङ्सन कार्यान्वयन प्रवाह
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

#### ३. फङ्सन कार्यान्वयन
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

### उदाहरण चलाउनुहोस्
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
```

### यो चलाउँदा के हुन्छ

1. **मौसम फङ्सन**: एआईले सिएटलको मौसम डेटा अनुरोध गर्छ, तपाईंले प्रदान गर्नुहुन्छ, एआईले प्रतिक्रिया स्वरूप ढाँचा बनाउँछ
2. **क्याल्कुलेटर फङ्सन**: एआईले गणना (२४० को १५%) अनुरोध गर्छ, तपाईंले गणना गर्नुहुन्छ, एआईले परिणाम व्याख्या गर्छ

## ट्युटोरियल ३: RAG (रिट्रिभल-अग्मेन्टेड जेनेरेसन)

**फाइल:** `src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

### यो उदाहरणले के सिकाउँछ

रिट्रिभल-अग्मेन्टेड जेनेरेसन (RAG) ले जानकारी पुनःप्राप्ति र भाषा उत्पादनलाई संयोजन गर्दछ। यसले एआई प्रम्प्टहरूमा बाह्य कागजात सन्दर्भहरू समावेश गरेर मोडेलहरूलाई विशिष्ट ज्ञान स्रोतहरूमा आधारित सटीक उत्तरहरू प्रदान गर्न सक्षम बनाउँछ। यसले रणनीतिक प्रम्प्ट इन्जिनियरिङद्वारा प्रयोगकर्ता प्रश्नहरू र आधिकारिक जानकारी स्रोतहरू बीच स्पष्ट सीमाहरू कायम राख्छ।

### मुख्य कोड अवधारणाहरू

#### १. कागजात लोड गर्दै
```java
// Load your knowledge source
String doc = Files.readString(Paths.get("document.txt"));
```

#### २. सन्दर्भ समावेश
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

ट्रिपल उद्धरणले एआईलाई सन्दर्भ र प्रश्न बीच भिन्नता गर्न मद्दत गर्छ।

#### ३. सुरक्षित प्रतिक्रिया ह्यान्डलिङ
```java
if (response != null && response.getChoices() != null && !response.getChoices().isEmpty()) {
    String answer = response.getChoices().get(0).getMessage().getContent();
    System.out.println("Assistant: " + answer);
} else {
    System.err.println("Error: No response received from the API.");
}
```

API प्रतिक्रियाहरूलाई सधैं मान्य गर्नुहोस् ताकि क्र्यासहरू रोक्न सकियोस्।

### उदाहरण चलाउनुहोस्
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
```

### यो चलाउँदा के हुन्छ

1. प्रोग्रामले `document.txt` लोड गर्छ (यसमा GitHub Models को जानकारी हुन्छ)
2. तपाईं कागजातबारे प्रश्न सोध्नुहुन्छ
3. एआईले केवल कागजात सामग्रीमा आधारित उत्तर दिन्छ, यसको सामान्य ज्ञानमा होइन

प्रश्न सोधेर प्रयास गर्नुहोस्: "GitHub Models के हो?" बनाम "आजको मौसम कस्तो छ?"

## ट्युटोरियल ४: जिम्मेवार एआई

**फाइल:** `src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

### यो उदाहरणले के सिकाउँछ

जिम्मेवार एआई उदाहरणले एआई अनुप्रयोगहरूमा सुरक्षा उपायहरू कार्यान्वयनको महत्त्वलाई प्रदर्शन गर्दछ। यसले घृणास्पद भाषण, उत्पीडन, आत्म-हानि, यौन सामग्री, र हिंसालगायत हानिकारक सामग्री कोटीहरू पत्ता लगाउने सुरक्षा फिल्टरहरू प्रदर्शन गर्दछ। यसले उत्पादन एआई अनुप्रयोगहरूले सामग्री नीति उल्लङ्घनहरूलाई उचित अपवाद ह्यान्डलिङ, प्रयोगकर्ता प्रतिक्रिया संयन्त्रहरू, र फलब्याक प्रतिक्रिया रणनीतिहरू मार्फत कसरी सुन्दर रूपमा व्यवस्थापन गर्नुपर्छ भन्ने देखाउँछ।

### मुख्य कोड अवधारणाहरू

#### १. सुरक्षा परीक्षण फ्रेमवर्क
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

#### २. परीक्षण गरिएका सुरक्षा कोटीहरू
- हिंसा/हानि निर्देशन
- घृणास्पद भाषण
- गोपनीयता उल्लङ्घन
- चिकित्सा गलत जानकारी
- गैरकानुनी गतिविधिहरू

### उदाहरण चलाउनुहोस्
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
```

### यो चलाउँदा के हुन्छ

कार्यक्रमले विभिन्न हानिकारक प्रम्प्टहरू परीक्षण गर्छ र एआई सुरक्षा प्रणालीले कसरी:
1. **खतरनाक अनुरोधहरू ब्लक गर्छ** HTTP 400 त्रुटिहरूको साथ
2. **सुरक्षित सामग्रीलाई अनुमति दिन्छ** सामान्य रूपमा उत्पन्न गर्न
3. **प्रयोगकर्ताहरूलाई सुरक्षा प्रदान गर्छ** हानिकारक एआई आउटपुटबाट

## उदाहरणहरूमा साझा ढाँचाहरू

### प्रमाणीकरण ढाँचा
सबै उदाहरणहरूले GitHub Models सँग प्रमाणीकरण गर्न यो ढाँचा प्रयोग गर्छन्:

```java
String pat = System.getenv("GITHUB_TOKEN");
TokenCredential credential = new StaticTokenCredential(pat);
OpenAIClient client = new OpenAIClientBuilder()
    .endpoint("https://models.inference.ai.azure.com")
    .credential(credential)
    .buildClient();
```

### त्रुटि ह्यान्डलिङ ढाँचा
```java
try {
    // AI operation
} catch (HttpResponseException e) {
    // Handle API errors (rate limits, safety filters)
} catch (Exception e) {
    // Handle general errors (network, parsing)
}
```

### सन्देश संरचना ढाँचा
```java
List<ChatRequestMessage> messages = List.of(
    new ChatRequestSystemMessage("Set AI behavior"),
    new ChatRequestUserMessage("User's actual request")
);
```

## अर्को चरणहरू

[अध्याय ०४: व्यावहारिक नमूनाहरू](../04-PracticalSamples/README.md)

## समस्या समाधान

### सामान्य समस्याहरू

**"GITHUB_TOKEN सेट गरिएको छैन"**
- सुनिश्चित गर्नुहोस् कि तपाईंले वातावरण चर सेट गर्नुभएको छ
- तपाईंको टोकनमा `models:read` स्कोप छ कि छैन जाँच गर्नुहोस्

**"API बाट कुनै प्रतिक्रिया छैन"**
- आफ्नो इन्टरनेट जडान जाँच गर्नुहोस्
- तपाईंको टोकन मान्य छ कि छैन जाँच गर्नुहोस्
- तपाईंले दर सीमा पार गर्नुभएको छ कि छैन जाँच गर्नुहोस्

**Maven संकलन त्रुटिहरू**
- सुनिश्चित गर्नुहोस् कि तपाईंले जाभा २१ वा उच्च संस्करण स्थापना गर्नुभएको छ
- निर्भरता ताजा गर्न `mvn clean compile` चलाउनुहोस्

**अस्वीकरण**:  
यो दस्तावेज़ AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) प्रयोग गरेर अनुवाद गरिएको छ। हामी यथार्थताको लागि प्रयास गर्छौं, तर कृपया ध्यान दिनुहोस् कि स्वचालित अनुवादमा त्रुटिहरू वा अशुद्धताहरू हुन सक्छ। यसको मूल भाषा मा रहेको मूल दस्तावेज़लाई आधिकारिक स्रोत मानिनुपर्छ। महत्वपूर्ण जानकारीको लागि, व्यावसायिक मानव अनुवाद सिफारिस गरिन्छ। यस अनुवादको प्रयोगबाट उत्पन्न हुने कुनै पनि गलतफहमी वा गलत व्याख्याको लागि हामी जिम्मेवार हुने छैनौं।