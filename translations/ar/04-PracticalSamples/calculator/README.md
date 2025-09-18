<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b6c16b5514d524e415a94f6097ee7d4c",
  "translation_date": "2025-09-18T15:24:06+00:00",
  "source_file": "04-PracticalSamples/calculator/README.md",
  "language_code": "ar"
}
-->
# دليل استخدام MCP Calculator للمبتدئين

## جدول المحتويات

- [ما ستتعلمه](../../../../04-PracticalSamples/calculator)
- [المتطلبات الأساسية](../../../../04-PracticalSamples/calculator)
- [فهم هيكل المشروع](../../../../04-PracticalSamples/calculator)
- [شرح المكونات الأساسية](../../../../04-PracticalSamples/calculator)
  - [1. التطبيق الرئيسي](../../../../04-PracticalSamples/calculator)
  - [2. خدمة الآلة الحاسبة](../../../../04-PracticalSamples/calculator)
  - [3. عميل MCP المباشر](../../../../04-PracticalSamples/calculator)
  - [4. عميل مدعوم بالذكاء الاصطناعي](../../../../04-PracticalSamples/calculator)
- [تشغيل الأمثلة](../../../../04-PracticalSamples/calculator)
- [كيف تعمل جميع الأجزاء معًا](../../../../04-PracticalSamples/calculator)
- [الخطوات التالية](../../../../04-PracticalSamples/calculator)

## ما ستتعلمه

يشرح هذا الدليل كيفية بناء خدمة آلة حاسبة باستخدام بروتوكول Model Context Protocol (MCP). ستتعلم:

- كيفية إنشاء خدمة يمكن للذكاء الاصطناعي استخدامها كأداة
- كيفية إعداد اتصال مباشر مع خدمات MCP
- كيفية اختيار نماذج الذكاء الاصطناعي للأدوات المناسبة تلقائيًا
- الفرق بين استدعاءات البروتوكول المباشرة والتفاعلات المدعومة بالذكاء الاصطناعي

## المتطلبات الأساسية

قبل البدء، تأكد من توفر ما يلي:
- تثبيت Java 21 أو أعلى
- Maven لإدارة التبعيات
- حساب GitHub مع رمز وصول شخصي (PAT)
- فهم أساسي لـ Java وSpring Boot

## فهم هيكل المشروع

يحتوي مشروع الآلة الحاسبة على عدة ملفات مهمة:

```
calculator/
├── src/main/java/com/microsoft/mcp/sample/server/
│   ├── McpServerApplication.java          # Main Spring Boot app
│   └── service/CalculatorService.java     # Calculator operations
└── src/test/java/com/microsoft/mcp/sample/client/
    ├── SDKClient.java                     # Direct MCP communication
    ├── LangChain4jClient.java            # AI-powered client
    └── Bot.java                          # Simple chat interface
```

## شرح المكونات الأساسية

### 1. التطبيق الرئيسي

**الملف:** `McpServerApplication.java`

هذه هي نقطة البداية لخدمة الآلة الحاسبة. إنه تطبيق Spring Boot قياسي مع إضافة خاصة:

```java
@SpringBootApplication
public class McpServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(McpServerApplication.class, args);
    }
    
    @Bean
    public ToolCallbackProvider calculatorTools(CalculatorService calculator) {
        return MethodToolCallbackProvider.builder().toolObjects(calculator).build();
    }
}
```

**ما الذي يفعله:**
- يبدأ خادم ويب Spring Boot على المنفذ 8080
- ينشئ `ToolCallbackProvider` لجعل طرق الآلة الحاسبة متاحة كأدوات MCP
- تخبر التعليمة `@Bean` Spring بإدارة هذا كعنصر يمكن استخدامه من قبل أجزاء أخرى

### 2. خدمة الآلة الحاسبة

**الملف:** `CalculatorService.java`

هنا يتم تنفيذ العمليات الحسابية. يتم تمييز كل طريقة بـ `@Tool` لجعلها متاحة عبر MCP:

```java
@Service
public class CalculatorService {

    @Tool(description = "Add two numbers together")
    public String add(double a, double b) {
        double result = a + b;
        return formatResult(a, "+", b, result);
    }

    @Tool(description = "Subtract the second number from the first number")
    public String subtract(double a, double b) {
        double result = a - b;
        return formatResult(a, "-", b, result);
    }
    
    // More calculator operations...
    
    private String formatResult(double a, String operator, double b, double result) {
        return String.format("%.2f %s %.2f = %.2f", a, operator, b, result);
    }
}
```

**الميزات الرئيسية:**

1. **تعليمة `@Tool`:** تخبر MCP أن هذه الطريقة يمكن استدعاؤها من قبل العملاء الخارجيين
2. **وصف واضح:** كل أداة تحتوي على وصف يساعد نماذج الذكاء الاصطناعي على فهم متى يجب استخدامها
3. **تنسيق نتائج متسق:** جميع العمليات تعيد نصوصًا قابلة للقراءة مثل "5.00 + 3.00 = 8.00"
4. **معالجة الأخطاء:** القسمة على الصفر والجذور التربيعية السالبة تعيد رسائل خطأ

**العمليات المتاحة:**
- `add(a, b)` - جمع رقمين
- `subtract(a, b)` - طرح الثاني من الأول
- `multiply(a, b)` - ضرب رقمين
- `divide(a, b)` - قسمة الأول على الثاني (مع فحص الصفر)
- `power(base, exponent)` - رفع الأساس إلى قوة الأس
- `squareRoot(number)` - حساب الجذر التربيعي (مع فحص السالب)
- `modulus(a, b)` - إرجاع باقي القسمة
- `absolute(number)` - إرجاع القيمة المطلقة
- `help()` - إرجاع معلومات حول جميع العمليات

### 3. عميل MCP المباشر

**الملف:** `SDKClient.java`

هذا العميل يتواصل مباشرة مع خادم MCP دون استخدام الذكاء الاصطناعي. يقوم باستدعاء وظائف الآلة الحاسبة يدويًا:

```java
public class SDKClient {
    
    public static void main(String[] args) {
        McpClientTransport transport = WebFluxSseClientTransport.builder(
            WebClient.builder().baseUrl("http://localhost:8080")
        ).build();
        new SDKClient(transport).run();
    }
    
    public void run() {
        var client = McpClient.sync(this.transport).build();
        client.initialize();
        
        // List available tools
        ListToolsResult toolsList = client.listTools();
        System.out.println("Available Tools = " + toolsList);
        
        // Call specific calculator functions
        CallToolResult resultAdd = client.callTool(
            new CallToolRequest("add", Map.of("a", 5.0, "b", 3.0))
        );
        System.out.println("Add Result = " + resultAdd);
        
        CallToolResult resultSqrt = client.callTool(
            new CallToolRequest("squareRoot", Map.of("number", 16.0))
        );
        System.out.println("Square Root Result = " + resultSqrt);
        
        client.closeGracefully();
    }
}
```

**ما الذي يفعله:**
1. **يتصل** بخادم الآلة الحاسبة على `http://localhost:8080` باستخدام نمط البناء
2. **يستعرض** جميع الأدوات المتاحة (وظائف الآلة الحاسبة)
3. **يستدعي** وظائف محددة بمعلمات دقيقة
4. **يعرض** النتائج مباشرة

**ملاحظة:** يستخدم هذا المثال إصدار Spring AI 1.1.0-SNAPSHOT الذي قدم نمط البناء لـ `WebFluxSseClientTransport`. إذا كنت تستخدم إصدارًا أقدم، قد تحتاج إلى استخدام المُنشئ المباشر بدلاً من ذلك.

**متى تستخدم هذا:** عندما تعرف بالضبط العملية الحسابية التي تريد تنفيذها وترغب في استدعائها برمجيًا.

### 4. عميل مدعوم بالذكاء الاصطناعي

**الملف:** `LangChain4jClient.java`

هذا العميل يستخدم نموذج ذكاء اصطناعي (GPT-4o-mini) يمكنه اختيار أدوات الآلة الحاسبة تلقائيًا:

```java
public class LangChain4jClient {
    
    public static void main(String[] args) throws Exception {
        // Set up the AI model (using GitHub Models)
        ChatLanguageModel model = OpenAiOfficialChatModel.builder()
                .isGitHubModels(true)
                .apiKey(System.getenv("GITHUB_TOKEN"))
                .modelName("gpt-4o-mini")
                .build();

        // Connect to our calculator MCP server
        McpTransport transport = new HttpMcpTransport.Builder()
                .sseUrl("http://localhost:8080/sse")
                .logRequests(true)  // Shows what the AI is doing
                .logResponses(true)
                .build();

        McpClient mcpClient = new DefaultMcpClient.Builder()
                .transport(transport)
                .build();

        // Give the AI access to our calculator tools
        ToolProvider toolProvider = McpToolProvider.builder()
                .mcpClients(List.of(mcpClient))
                .build();

        // Create an AI bot that can use our calculator
        Bot bot = AiServices.builder(Bot.class)
                .chatLanguageModel(model)
                .toolProvider(toolProvider)
                .build();

        // Now we can ask the AI to do calculations in natural language
        String response = bot.chat("Calculate the sum of 24.5 and 17.3 using the calculator service");
        System.out.println(response);

        response = bot.chat("What's the square root of 144?");
        System.out.println(response);
    }
}
```

**ما الذي يفعله:**
1. **ينشئ** اتصالًا بنموذج الذكاء الاصطناعي باستخدام رمز GitHub الخاص بك
2. **يتصل** بخادم MCP الخاص بالآلة الحاسبة
3. **يمنح** الذكاء الاصطناعي الوصول إلى جميع أدوات الآلة الحاسبة
4. **يسمح** بطلبات باللغة الطبيعية مثل "احسب مجموع 24.5 و17.3"

**الذكاء الاصطناعي تلقائيًا:**
- يفهم أنك تريد جمع الأرقام
- يختار أداة `add`
- يستدعي `add(24.5, 17.3)`
- يعيد النتيجة في استجابة طبيعية

## تشغيل الأمثلة

### الخطوة 1: بدء تشغيل خادم الآلة الحاسبة

أولاً، قم بتعيين رمز GitHub الخاص بك (مطلوب للعميل المدعوم بالذكاء الاصطناعي):

**Windows:**
```cmd
set GITHUB_TOKEN=your_github_token_here
```

**Linux/macOS:**
```bash
export GITHUB_TOKEN=your_github_token_here
```

ابدأ تشغيل الخادم:
```bash
cd 04-PracticalSamples/calculator
mvn clean spring-boot:run
```

سيبدأ الخادم على `http://localhost:8080`. يجب أن ترى:
```
Started McpServerApplication in X.XXX seconds
```

### الخطوة 2: اختبار العميل المباشر

في نافذة **جديدة** مع استمرار تشغيل الخادم، قم بتشغيل عميل MCP المباشر:
```bash
cd 04-PracticalSamples/calculator
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient" -Dexec.classpathScope=test
```

سترى مخرجات مثل:
```
Available Tools = [add, subtract, multiply, divide, power, squareRoot, modulus, absolute, help]
Add Result = 5.00 + 3.00 = 8.00
Square Root Result = √16.00 = 4.00
```

### الخطوة 3: اختبار العميل المدعوم بالذكاء الاصطناعي

```bash
mvn test-compile exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient" -Dexec.classpathScope=test
```

سترى الذكاء الاصطناعي يستخدم الأدوات تلقائيًا:
```
The sum of 24.5 and 17.3 is 41.8.
The square root of 144 is 12.
```

### الخطوة 4: إيقاف خادم MCP

عندما تنتهي من الاختبار، يمكنك إيقاف العميل المدعوم بالذكاء الاصطناعي بالضغط على `Ctrl+C` في نافذته. سيستمر خادم MCP في العمل حتى تقوم بإيقافه.
لإيقاف الخادم، اضغط على `Ctrl+C` في النافذة التي يعمل فيها.

## كيف تعمل جميع الأجزاء معًا

إليك التدفق الكامل عندما تسأل الذكاء الاصطناعي "ما هو 5 + 3؟":

1. **أنت** تسأل الذكاء الاصطناعي بلغة طبيعية
2. **الذكاء الاصطناعي** يحلل طلبك ويدرك أنك تريد عملية جمع
3. **الذكاء الاصطناعي** يستدعي خادم MCP: `add(5.0, 3.0)`
4. **خدمة الآلة الحاسبة** تنفذ: `5.0 + 3.0 = 8.0`
5. **خدمة الآلة الحاسبة** تعيد: `"5.00 + 3.00 = 8.00"`
6. **الذكاء الاصطناعي** يستلم النتيجة ويصيغ استجابة طبيعية
7. **أنت** تحصل على: "مجموع 5 و3 هو 8"

## الخطوات التالية

للحصول على المزيد من الأمثلة، راجع [الفصل 04: أمثلة عملية](../README.md)

---

**إخلاء المسؤولية**:  
تم ترجمة هذا المستند باستخدام خدمة الترجمة بالذكاء الاصطناعي [Co-op Translator](https://github.com/Azure/co-op-translator). بينما نسعى لتحقيق الدقة، يرجى العلم أن الترجمات الآلية قد تحتوي على أخطاء أو معلومات غير دقيقة. يجب اعتبار المستند الأصلي بلغته الأصلية المصدر الرسمي. للحصول على معلومات حاسمة، يُوصى بالاستعانة بترجمة بشرية احترافية. نحن غير مسؤولين عن أي سوء فهم أو تفسيرات خاطئة تنشأ عن استخدام هذه الترجمة.