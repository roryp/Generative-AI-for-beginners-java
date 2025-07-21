<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "59454ab4ec36d89840df6fcfe7633cbd",
  "translation_date": "2025-07-21T17:42:43+00:00",
  "source_file": "03-CoreGenerativeAITechniques/TUTORIAL.md",
  "language_code": "ur"
}
-->
# کور جنریٹیو اے آئی تکنیکس ٹیوٹوریل

## فہرست

- [پیشگی ضروریات](../../../03-CoreGenerativeAITechniques)
- [شروع کریں](../../../03-CoreGenerativeAITechniques)
  - [پہلا مرحلہ: اپنا انوائرمنٹ ویریبل سیٹ کریں](../../../03-CoreGenerativeAITechniques)
  - [دوسرا مرحلہ: ایگزامپلز ڈائریکٹری پر جائیں](../../../03-CoreGenerativeAITechniques)
- [ٹیوٹوریل 1: ایل ایل ایم کمپلیشنز اور چیٹ](../../../03-CoreGenerativeAITechniques)
- [ٹیوٹوریل 2: فنکشن کالنگ](../../../03-CoreGenerativeAITechniques)
- [ٹیوٹوریل 3: آر اے جی (ریٹریول-آگمینٹڈ جنریشن)](../../../03-CoreGenerativeAITechniques)
- [ٹیوٹوریل 4: ذمہ دار اے آئی](../../../03-CoreGenerativeAITechniques)
- [مشترکہ پیٹرنز تمام مثالوں میں](../../../03-CoreGenerativeAITechniques)
- [اگلے مراحل](../../../03-CoreGenerativeAITechniques)
- [مسائل کا حل](../../../03-CoreGenerativeAITechniques)
  - [عام مسائل](../../../03-CoreGenerativeAITechniques)

## جائزہ

یہ ٹیوٹوریل جاوا اور گٹ ہب ماڈلز کا استعمال کرتے ہوئے بنیادی جنریٹیو اے آئی تکنیکس کے عملی مثالیں فراہم کرتا ہے۔ آپ سیکھیں گے کہ بڑے لینگویج ماڈلز (LLMs) کے ساتھ کیسے تعامل کریں، فنکشن کالنگ کو نافذ کریں، ریٹریول-آگمینٹڈ جنریشن (RAG) کا استعمال کریں، اور ذمہ دار اے آئی کے اصول اپنائیں۔

## پیشگی ضروریات

شروع کرنے سے پہلے، یقینی بنائیں کہ آپ کے پاس یہ چیزیں موجود ہیں:
- جاوا 21 یا اس سے زیادہ انسٹال ہو
- Maven ڈپینڈنسی مینجمنٹ کے لیے
- گٹ ہب اکاؤنٹ اور ایک پرسنل ایکسیس ٹوکن (PAT)

## شروع کریں

### پہلا مرحلہ: اپنا انوائرمنٹ ویریبل سیٹ کریں

سب سے پہلے، آپ کو اپنا گٹ ہب ٹوکن انوائرمنٹ ویریبل کے طور پر سیٹ کرنا ہوگا۔ یہ ٹوکن آپ کو گٹ ہب ماڈلز تک مفت رسائی فراہم کرتا ہے۔

**ونڈوز (کمانڈ پرامپٹ):**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**ونڈوز (پاور شیل):**
```powershell
$env:GITHUB_TOKEN="your_github_token_here"
```

**لینکس/میک او ایس:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

### دوسرا مرحلہ: ایگزامپلز ڈائریکٹری پر جائیں

```bash
cd 03-CoreGenerativeAITechniques/examples/
```

## ٹیوٹوریل 1: ایل ایل ایم کمپلیشنز اور چیٹ

**فائل:** `src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

### یہ مثال کیا سکھاتی ہے

یہ مثال بڑے لینگویج ماڈلز (LLMs) کے ساتھ تعامل کے بنیادی اصولوں کو ظاہر کرتی ہے، جن میں شامل ہیں:
- گٹ ہب ماڈلز کے ساتھ کلائنٹ کی شروعات
- سسٹم اور یوزر پرامپٹس کے لیے میسج اسٹرکچر پیٹرنز
- میسج ہسٹری کے ذریعے گفتگو کی حالت کا انتظام
- ریسپانس کی لمبائی اور تخلیقی سطح کو کنٹرول کرنے کے لیے پیرامیٹر ٹیوننگ

### اہم کوڈ تصورات

#### 1. کلائنٹ سیٹ اپ
```java
// Create the AI client
OpenAIClient client = new OpenAIClientBuilder()
    .endpoint("https://models.inference.ai.azure.com")
    .credential(new StaticTokenCredential(pat))
    .buildClient();
```

یہ آپ کے ٹوکن کا استعمال کرتے ہوئے گٹ ہب ماڈلز سے کنکشن بناتا ہے۔

#### 2. سادہ کمپلیشن
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

#### 3. گفتگو کی یادداشت
```java
// Add AI's response to maintain conversation history
messages.add(new ChatRequestAssistantMessage(aiResponse));
messages.add(new ChatRequestUserMessage("Follow-up question"));
```

اے آئی پچھلے میسجز کو صرف اسی وقت یاد رکھتی ہے جب آپ انہیں اگلی درخواستوں میں شامل کریں۔

### مثال چلائیں
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
```

### جب آپ اسے چلائیں گے تو کیا ہوگا

1. **سادہ کمپلیشن**: اے آئی جاوا کے سوال کا جواب دیتی ہے، سسٹم پرامپٹ کی رہنمائی کے ساتھ
2. **ملٹی ٹرن چیٹ**: اے آئی متعدد سوالات کے دوران سیاق و سباق کو برقرار رکھتی ہے
3. **انٹرایکٹو چیٹ**: آپ اے آئی کے ساتھ حقیقی گفتگو کر سکتے ہیں

## ٹیوٹوریل 2: فنکشن کالنگ

**فائل:** `src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

### یہ مثال کیا سکھاتی ہے

فنکشن کالنگ اے آئی ماڈلز کو ایک منظم پروٹوکول کے ذریعے بیرونی ٹولز اور APIs کو چلانے کی درخواست کرنے کے قابل بناتی ہے۔ ماڈل قدرتی زبان کی درخواستوں کا تجزیہ کرتا ہے، JSON اسکیمہ ڈیفینیشنز کا استعمال کرتے ہوئے مطلوبہ فنکشن کالز اور پیرامیٹرز کا تعین کرتا ہے، اور واپس کیے گئے نتائج کو سیاق و سباق کے جوابات پیدا کرنے کے لیے استعمال کرتا ہے، جبکہ اصل فنکشن کا عمل ڈویلپر کے کنٹرول میں رہتا ہے تاکہ سیکیورٹی اور اعتبار کو یقینی بنایا جا سکے۔

### اہم کوڈ تصورات

#### 1. فنکشن کی تعریف
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

یہ اے آئی کو بتاتا ہے کہ کون سے فنکشن دستیاب ہیں اور انہیں کیسے استعمال کرنا ہے۔

#### 2. فنکشن عمل کا بہاؤ
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

#### 3. فنکشن کی عمل درآمد
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

### مثال چلائیں
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
```

### جب آپ اسے چلائیں گے تو کیا ہوگا

1. **موسم کا فنکشن**: اے آئی سیئٹل کے موسم کا ڈیٹا مانگتی ہے، آپ فراہم کرتے ہیں، اے آئی جواب کو فارمیٹ کرتی ہے
2. **کیلکولیٹر فنکشن**: اے آئی ایک حساب (240 کا 15%) مانگتی ہے، آپ اسے حل کرتے ہیں، اے آئی نتیجہ کی وضاحت کرتی ہے

## ٹیوٹوریل 3: آر اے جی (ریٹریول-آگمینٹڈ جنریشن)

**فائل:** `src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

### یہ مثال کیا سکھاتی ہے

ریٹریول-آگمینٹڈ جنریشن (RAG) معلومات کی بازیافت کو زبان کی تخلیق کے ساتھ جوڑتی ہے، جس سے ماڈلز کو مخصوص علم کے ذرائع کی بنیاد پر درست جوابات فراہم کرنے کے قابل بنایا جاتا ہے، بجائے اس کے کہ وہ ممکنہ طور پر پرانے یا غلط تربیتی ڈیٹا پر انحصار کریں۔ اس میں صارف کی درخواستوں اور مستند معلومات کے ذرائع کے درمیان واضح حدود کو برقرار رکھنے کے لیے اسٹریٹجک پرامپٹ انجینئرنگ شامل ہے۔

### اہم کوڈ تصورات

#### 1. دستاویز لوڈ کرنا
```java
// Load your knowledge source
String doc = Files.readString(Paths.get("document.txt"));
```

#### 2. سیاق و سباق کا انجیکشن
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

ٹرپل کوٹس اے آئی کو سیاق و سباق اور سوال کے درمیان فرق کرنے میں مدد دیتے ہیں۔

#### 3. محفوظ جواب کی ہینڈلنگ
```java
if (response != null && response.getChoices() != null && !response.getChoices().isEmpty()) {
    String answer = response.getChoices().get(0).getMessage().getContent();
    System.out.println("Assistant: " + answer);
} else {
    System.err.println("Error: No response received from the API.");
}
```

ہمیشہ API جوابات کی توثیق کریں تاکہ کریشز سے بچا جا سکے۔

### مثال چلائیں
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
```

### جب آپ اسے چلائیں گے تو کیا ہوگا

1. پروگرام `document.txt` لوڈ کرتا ہے (جس میں گٹ ہب ماڈلز کے بارے میں معلومات ہوتی ہیں)
2. آپ دستاویز کے بارے میں سوال پوچھتے ہیں
3. اے آئی صرف دستاویز کے مواد کی بنیاد پر جواب دیتی ہے، اپنے عمومی علم پر نہیں

آزمائیں: "GitHub Models کیا ہیں؟" بمقابلہ "موسم کیسا ہے؟"

## ٹیوٹوریل 4: ذمہ دار اے آئی

**فائل:** `src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

### یہ مثال کیا سکھاتی ہے

ذمہ دار اے آئی کی مثال اے آئی ایپلیکیشنز میں حفاظتی اقدامات کے نفاذ کی اہمیت کو ظاہر کرتی ہے۔ یہ حفاظتی فلٹرز کو ظاہر کرتی ہے جو نقصان دہ مواد کی اقسام جیسے نفرت انگیز تقریر، ہراسانی، خود کو نقصان پہنچانے، جنسی مواد، اور تشدد کا پتہ لگاتے ہیں، اور یہ ظاہر کرتی ہے کہ پروڈکشن اے آئی ایپلیکیشنز مواد کی پالیسی کی خلاف ورزیوں کو مناسب ایکسیپشن ہینڈلنگ، صارف کی رائے کے میکانزم، اور فال بیک ریسپانس اسٹریٹجیز کے ذریعے کیسے سنبھالنی چاہیے۔

### اہم کوڈ تصورات

#### 1. حفاظتی ٹیسٹنگ فریم ورک
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

#### 2. آزمائے گئے حفاظتی زمرے
- تشدد/نقصان کی ہدایات
- نفرت انگیز تقریر
- پرائیویسی کی خلاف ورزیاں
- طبی غلط معلومات
- غیر قانونی سرگرمیاں

### مثال چلائیں
```bash
mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
```

### جب آپ اسے چلائیں گے تو کیا ہوگا

پروگرام مختلف نقصان دہ پرامپٹس کی جانچ کرتا ہے اور دکھاتا ہے کہ اے آئی حفاظتی نظام کیسے:
1. **خطرناک درخواستوں کو بلاک کرتا ہے** HTTP 400 ایررز کے ساتھ
2. **محفوظ مواد کو** عام طور پر پیدا ہونے دیتا ہے
3. **صارفین کو** نقصان دہ اے آئی آؤٹ پٹس سے محفوظ رکھتا ہے

## مشترکہ پیٹرنز تمام مثالوں میں

### تصدیق کا پیٹرن
تمام مثالیں گٹ ہب ماڈلز کے ساتھ تصدیق کے لیے یہ پیٹرن استعمال کرتی ہیں:

```java
String pat = System.getenv("GITHUB_TOKEN");
TokenCredential credential = new StaticTokenCredential(pat);
OpenAIClient client = new OpenAIClientBuilder()
    .endpoint("https://models.inference.ai.azure.com")
    .credential(credential)
    .buildClient();
```

### ایرر ہینڈلنگ پیٹرن
```java
try {
    // AI operation
} catch (HttpResponseException e) {
    // Handle API errors (rate limits, safety filters)
} catch (Exception e) {
    // Handle general errors (network, parsing)
}
```

### میسج اسٹرکچر پیٹرن
```java
List<ChatRequestMessage> messages = List.of(
    new ChatRequestSystemMessage("Set AI behavior"),
    new ChatRequestUserMessage("User's actual request")
);
```

## اگلے مراحل

[باب 04: عملی نمونے](../04-PracticalSamples/README.md)

## مسائل کا حل

### عام مسائل

**"GITHUB_TOKEN سیٹ نہیں کیا گیا"**
- یقینی بنائیں کہ آپ نے انوائرمنٹ ویریبل سیٹ کیا ہے
- تصدیق کریں کہ آپ کے ٹوکن میں `models:read` اسکوپ ہے

**"API سے کوئی جواب نہیں"**
- اپنا انٹرنیٹ کنکشن چیک کریں
- تصدیق کریں کہ آپ کا ٹوکن درست ہے
- چیک کریں کہ کیا آپ نے ریٹ لیمٹس کو عبور کیا ہے

**Maven کمپائلیشن ایررز**
- یقینی بنائیں کہ آپ کے پاس جاوا 21 یا اس سے زیادہ ہے
- `mvn clean compile` چلائیں تاکہ ڈپینڈنسیز کو ریفریش کیا جا سکے

**ڈسکلیمر**:  
یہ دستاویز AI ترجمہ سروس [Co-op Translator](https://github.com/Azure/co-op-translator) کا استعمال کرتے ہوئے ترجمہ کی گئی ہے۔ ہم درستگی کے لیے کوشش کرتے ہیں، لیکن براہ کرم آگاہ رہیں کہ خودکار ترجمے میں غلطیاں یا عدم درستگی ہو سکتی ہیں۔ اصل دستاویز کو اس کی اصل زبان میں مستند ذریعہ سمجھا جانا چاہیے۔ اہم معلومات کے لیے، پیشہ ور انسانی ترجمہ کی سفارش کی جاتی ہے۔ اس ترجمے کے استعمال سے پیدا ہونے والی کسی بھی غلط فہمی یا غلط تشریح کے لیے ہم ذمہ دار نہیں ہیں۔