<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "59454ab4ec36d89840df6fcfe7633cbd",
  "translation_date": "2025-07-25T10:44:26+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "ar"
}
-->
# دليل تقنيات الذكاء الاصطناعي التوليدي الأساسية

## جدول المحتويات

- [المتطلبات الأساسية](../../../03-CoreGenerativeAITechniques)
- [البدء](../../../03-CoreGenerativeAITechniques)
  - [الخطوة 1: إعداد متغير البيئة](../../../03-CoreGenerativeAITechniques)
  - [الخطوة 2: الانتقال إلى دليل الأمثلة](../../../03-CoreGenerativeAITechniques)
- [الدرس 1: إكمالات LLM والدردشة](../../../03-CoreGenerativeAITechniques)
- [الدرس 2: استدعاء الوظائف](../../../03-CoreGenerativeAITechniques)
- [الدرس 3: RAG (التوليد المعزز بالاسترجاع)](../../../03-CoreGenerativeAITechniques)
- [الدرس 4: الذكاء الاصطناعي المسؤول](../../../03-CoreGenerativeAITechniques)
- [الأنماط المشتركة عبر الأمثلة](../../../03-CoreGenerativeAITechniques)
- [الخطوات التالية](../../../03-CoreGenerativeAITechniques)
- [استكشاف الأخطاء وإصلاحها](../../../03-CoreGenerativeAITechniques)
  - [المشاكل الشائعة](../../../03-CoreGenerativeAITechniques)

## نظرة عامة

يوفر هذا الدليل أمثلة عملية لتقنيات الذكاء الاصطناعي التوليدي الأساسية باستخدام Java ونماذج GitHub. ستتعلم كيفية التفاعل مع نماذج اللغة الكبيرة (LLMs)، تنفيذ استدعاء الوظائف، استخدام التوليد المعزز بالاسترجاع (RAG)، وتطبيق ممارسات الذكاء الاصطناعي المسؤول.

## المتطلبات الأساسية

قبل البدء، تأكد من توفر:
- Java 21 أو إصدار أعلى مثبت
- Maven لإدارة التبعيات
- حساب GitHub مع رمز وصول شخصي (PAT)

## البدء

### الخطوة 1: إعداد متغير البيئة

أولاً، تحتاج إلى إعداد رمز GitHub الخاص بك كمتغير بيئة. يتيح لك هذا الرمز الوصول إلى نماذج GitHub مجانًا.

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

### الخطوة 2: الانتقال إلى دليل الأمثلة

```bash
cd 03-CoreGenerativeAITechniques/examples/
```

## الدرس 1: إكمالات LLM والدردشة

**الملف:** `src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

### ما الذي يقدمه هذا المثال

يشرح هذا المثال الآليات الأساسية للتفاعل مع نماذج اللغة الكبيرة (LLM) عبر واجهة برمجة التطبيقات OpenAI، بما في ذلك تهيئة العميل باستخدام نماذج GitHub، أنماط هيكلة الرسائل للمطالبات النظامية والمستخدم، إدارة حالة المحادثة من خلال تراكم تاريخ الرسائل، وضبط المعلمات للتحكم في طول الرد ومستوى الإبداع.

### مفاهيم الكود الرئيسية

#### 1. إعداد العميل
```java
// Create the AI client
OpenAIClient client = new OpenAIClientBuilder()
    .endpoint("https://models.inference.ai.azure.com")
    .credential(new StaticTokenCredential(pat))
    .buildClient();
```

هذا ينشئ اتصالاً بنماذج GitHub باستخدام الرمز الخاص بك.

#### 2. الإكمال البسيط
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

#### 3. ذاكرة المحادثة
```java
// Add AI's response to maintain conversation history
messages.add(new ChatRequestAssistantMessage(aiResponse));
messages.add(new ChatRequestUserMessage("Follow-up question"));
```

يتذكر الذكاء الاصطناعي الرسائل السابقة فقط إذا قمت بتضمينها في الطلبات اللاحقة.

### تشغيل المثال
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
```

### ماذا يحدث عند تشغيله

1. **الإكمال البسيط**: يجيب الذكاء الاصطناعي على سؤال Java مع توجيه من مطالبة النظام
2. **الدردشة متعددة الأدوار**: يحافظ الذكاء الاصطناعي على السياق عبر أسئلة متعددة
3. **الدردشة التفاعلية**: يمكنك إجراء محادثة حقيقية مع الذكاء الاصطناعي

## الدرس 2: استدعاء الوظائف

**الملف:** `src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

### ما الذي يقدمه هذا المثال

يتيح استدعاء الوظائف لنماذج الذكاء الاصطناعي طلب تنفيذ أدوات وواجهات برمجة تطبيقات خارجية عبر بروتوكول منظم حيث يقوم النموذج بتحليل الطلبات الطبيعية، تحديد استدعاءات الوظائف المطلوبة مع المعلمات المناسبة باستخدام تعريفات JSON Schema، ومعالجة النتائج المسترجعة لتوليد ردود سياقية، بينما يبقى تنفيذ الوظائف الفعلي تحت سيطرة المطور لضمان الأمان والموثوقية.

### مفاهيم الكود الرئيسية

#### 1. تعريف الوظيفة
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

هذا يخبر الذكاء الاصطناعي بالوظائف المتاحة وكيفية استخدامها.

#### 2. تدفق تنفيذ الوظيفة
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

#### 3. تنفيذ الوظيفة
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

### تشغيل المثال
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
```

### ماذا يحدث عند تشغيله

1. **وظيفة الطقس**: يطلب الذكاء الاصطناعي بيانات الطقس لمدينة سياتل، تقدمها له، يقوم الذكاء الاصطناعي بتنسيق الرد
2. **وظيفة الحاسبة**: يطلب الذكاء الاصطناعي حساب (15% من 240)، تقوم بحسابه، يشرح الذكاء الاصطناعي النتيجة

## الدرس 3: RAG (التوليد المعزز بالاسترجاع)

**الملف:** `src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

### ما الذي يقدمه هذا المثال

يجمع التوليد المعزز بالاسترجاع (RAG) بين استرجاع المعلومات وتوليد اللغة عن طريق حقن سياق الوثائق الخارجية في مطالبات الذكاء الاصطناعي، مما يتيح للنماذج تقديم إجابات دقيقة بناءً على مصادر المعرفة المحددة بدلاً من البيانات التدريبية التي قد تكون قديمة أو غير دقيقة، مع الحفاظ على حدود واضحة بين استفسارات المستخدم والمصادر المعلوماتية الموثوقة من خلال هندسة المطالبات الاستراتيجية.

### مفاهيم الكود الرئيسية

#### 1. تحميل الوثائق
```java
// Load your knowledge source
String doc = Files.readString(Paths.get("document.txt"));
```

#### 2. حقن السياق
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

تساعد علامات الاقتباس الثلاثية الذكاء الاصطناعي على التمييز بين السياق والسؤال.

#### 3. التعامل مع الردود بأمان
```java
if (response != null && response.getChoices() != null && !response.getChoices().isEmpty()) {
    String answer = response.getChoices().get(0).getMessage().getContent();
    System.out.println("Assistant: " + answer);
} else {
    System.err.println("Error: No response received from the API.");
}
```

قم دائمًا بالتحقق من ردود واجهة برمجة التطبيقات لتجنب الأعطال.

### تشغيل المثال
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
```

### ماذا يحدث عند تشغيله

1. يقوم البرنامج بتحميل `document.txt` (يحتوي على معلومات حول نماذج GitHub)
2. تسأل سؤالاً حول الوثيقة
3. يجيب الذكاء الاصطناعي بناءً فقط على محتوى الوثيقة، وليس معرفته العامة

جرب السؤال: "ما هي نماذج GitHub؟" مقابل "كيف هو الطقس؟"

## الدرس 4: الذكاء الاصطناعي المسؤول

**الملف:** `src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

### ما الذي يقدمه هذا المثال

يبرز مثال الذكاء الاصطناعي المسؤول أهمية تنفيذ تدابير السلامة في تطبيقات الذكاء الاصطناعي. يوضح فلاتر السلامة التي تكتشف فئات المحتوى الضار بما في ذلك خطاب الكراهية، التحرش، إيذاء النفس، المحتوى الجنسي، والعنف، مما يوضح كيف يجب أن تتعامل تطبيقات الذكاء الاصطناعي الإنتاجية بشكل سلس مع انتهاكات سياسات المحتوى من خلال معالجة الاستثناءات بشكل صحيح، آليات تقديم ملاحظات المستخدم، واستراتيجيات الرد البديلة.

### مفاهيم الكود الرئيسية

#### 1. إطار اختبار السلامة
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

#### 2. فئات السلامة التي يتم اختبارها
- تعليمات العنف/الإيذاء
- خطاب الكراهية
- انتهاكات الخصوصية
- معلومات طبية خاطئة
- أنشطة غير قانونية

### تشغيل المثال
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
```

### ماذا يحدث عند تشغيله

يقوم البرنامج باختبار مطالبات ضارة مختلفة ويظهر كيف يقوم نظام سلامة الذكاء الاصطناعي:
1. **بحظر الطلبات الخطيرة** باستخدام أخطاء HTTP 400
2. **السماح بالمحتوى الآمن** ليتم توليده بشكل طبيعي
3. **حماية المستخدمين** من مخرجات الذكاء الاصطناعي الضارة

## الأنماط المشتركة عبر الأمثلة

### نمط المصادقة
تستخدم جميع الأمثلة هذا النمط للمصادقة مع نماذج GitHub:

```java
String pat = System.getenv("GITHUB_TOKEN");
TokenCredential credential = new StaticTokenCredential(pat);
OpenAIClient client = new OpenAIClientBuilder()
    .endpoint("https://models.inference.ai.azure.com")
    .credential(credential)
    .buildClient();
```

### نمط معالجة الأخطاء
```java
try {
    // AI operation
} catch (HttpResponseException e) {
    // Handle API errors (rate limits, safety filters)
} catch (Exception e) {
    // Handle general errors (network, parsing)
}
```

### نمط هيكلة الرسائل
```java
List<ChatRequestMessage> messages = List.of(
    new ChatRequestSystemMessage("Set AI behavior"),
    new ChatRequestUserMessage("User's actual request")
);
```

## الخطوات التالية

[الفصل 04: أمثلة عملية](../04-PracticalSamples/README.md)

## استكشاف الأخطاء وإصلاحها

### المشاكل الشائعة

**"GITHUB_TOKEN غير مضبوط"**
- تأكد من إعداد متغير البيئة
- تحقق من أن الرمز الخاص بك يحتوي على نطاق `models:read`

**"لا يوجد رد من واجهة برمجة التطبيقات"**
- تحقق من اتصالك بالإنترنت
- تحقق من صلاحية الرمز الخاص بك
- تحقق مما إذا كنت قد تجاوزت حدود المعدل

**أخطاء تجميع Maven**
- تأكد من أن لديك Java 21 أو إصدار أعلى
- قم بتشغيل `mvn clean compile` لتحديث التبعيات

**إخلاء المسؤولية**:  
تم ترجمة هذا المستند باستخدام خدمة الترجمة بالذكاء الاصطناعي [Co-op Translator](https://github.com/Azure/co-op-translator). بينما نسعى لتحقيق الدقة، يرجى العلم أن الترجمات الآلية قد تحتوي على أخطاء أو معلومات غير دقيقة. يجب اعتبار المستند الأصلي بلغته الأصلية المصدر الرسمي. للحصول على معلومات حاسمة، يُوصى بالاستعانة بترجمة بشرية احترافية. نحن غير مسؤولين عن أي سوء فهم أو تفسيرات خاطئة تنشأ عن استخدام هذه الترجمة.