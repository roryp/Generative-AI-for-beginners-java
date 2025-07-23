<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "79df2d245c12d6b8ad57148fd049f106",
  "translation_date": "2025-07-23T11:56:00+00:00",
  "source_file": "README.md",
  "language_code": "ar"
}
-->
# الذكاء الاصطناعي التوليدي للمبتدئين - إصدار Java

> **NOTE: Quick Start**: يمكن إتمام الدورة بالكامل عبر الإنترنت - لا حاجة لإعداد محلي!
1. قم بعمل Fork لهذا المستودع إلى حساب GitHub الخاص بك
2. انقر على **Code** → علامة تبويب **Codespaces** → **...** → **New with options...**
3. استخدم الإعدادات الافتراضية – سيقوم هذا باختيار حاوية التطوير المخصصة لهذه الدورة
4. انقر على **Create codespace**
5. انتظر حوالي دقيقتين حتى يصبح البيئة جاهزة
6. انتقل مباشرة إلى [إنشاء رمز GitHub Models Token الخاص بك](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## دعم متعدد اللغات

### مدعوم عبر GitHub Action (تلقائي ودائم التحديث)

[French](../fr/README.md) | [Spanish](../es/README.md) | [German](../de/README.md) | [Russian](../ru/README.md) | [Arabic](./README.md) | [Persian (Farsi)](../fa/README.md) | [Urdu](../ur/README.md) | [Chinese (Simplified)](../zh/README.md) | [Chinese (Traditional, Macau)](../mo/README.md) | [Chinese (Traditional, Hong Kong)](../hk/README.md) | [Chinese (Traditional, Taiwan)](../tw/README.md) | [Japanese](../ja/README.md) | [Korean](../ko/README.md) | [Hindi](../hi/README.md) | [Bengali](../bn/README.md) | [Marathi](../mr/README.md) | [Nepali](../ne/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Portuguese (Portugal)](../pt/README.md) | [Portuguese (Brazil)](../br/README.md) | [Italian](../it/README.md) | [Polish](../pl/README.md) | [Turkish](../tr/README.md) | [Greek](../el/README.md) | [Thai](../th/README.md) | [Swedish](../sv/README.md) | [Danish](../da/README.md) | [Norwegian](../no/README.md) | [Finnish](../fi/README.md) | [Dutch](../nl/README.md) | [Hebrew](../he/README.md) | [Vietnamese](../vi/README.md) | [Indonesian](../id/README.md) | [Malay](../ms/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Swahili](../sw/README.md) | [Hungarian](../hu/README.md) | [Czech](../cs/README.md) | [Slovak](../sk/README.md) | [Romanian](../ro/README.md) | [Bulgarian](../bg/README.md) | [Serbian (Cyrillic)](../sr/README.md) | [Croatian](../hr/README.md) | [Slovenian](../sl/README.md) | [Ukrainian](../uk/README.md) | [Burmese (Myanmar)](../my/README.md)

## هيكل الدورة ومسار التعلم

**الوقت المطلوب**: إعداد البيئة يستغرق دقيقتين، بينما تتطلب الدروس العملية من 1-3 ساعات لكل منها حسب عمق الاستكشاف.

### **الفصل الأول: مقدمة في الذكاء الاصطناعي التوليدي**
- **المفاهيم الأساسية**: فهم نماذج اللغة الكبيرة، الرموز، التضمينات، وقدرات الذكاء الاصطناعي
- **نظام Java للذكاء الاصطناعي**: نظرة عامة على Spring AI و OpenAI SDKs
- **بروتوكول سياق النموذج**: مقدمة عن MCP ودوره في تواصل وكلاء الذكاء الاصطناعي
- **التطبيقات العملية**: سيناريوهات واقعية تشمل روبوتات الدردشة وتوليد المحتوى
- **[→ ابدأ الفصل الأول](./01-IntroToGenAI/README.md)**

### **الفصل الثاني: إعداد بيئة التطوير**
- **إعداد متعدد المزودين**: تكامل GitHub Models و Azure OpenAI و OpenAI Java SDK
- **Spring Boot + Spring AI**: أفضل الممارسات لتطوير تطبيقات الذكاء الاصطناعي للمؤسسات
- **GitHub Models**: الوصول المجاني لنماذج الذكاء الاصطناعي للتجربة والتعلم (لا حاجة لبطاقة ائتمان)
- **أدوات التطوير**: إعداد حاويات Docker، VS Code، و GitHub Codespaces
- **[→ ابدأ الفصل الثاني](./02-SetupDevEnvironment/README.md)**

### **الفصل الثالث: تقنيات الذكاء الاصطناعي التوليدي الأساسية**
- **هندسة المطالبات**: تقنيات للحصول على استجابات مثالية من نماذج الذكاء الاصطناعي
- **التضمينات وعمليات المتجهات**: تنفيذ البحث الدلالي ومطابقة التشابه
- **توليد البيانات المعزز بالاسترجاع (RAG)**: دمج الذكاء الاصطناعي مع مصادر البيانات الخاصة بك
- **استدعاء الوظائف**: توسيع قدرات الذكاء الاصطناعي باستخدام أدوات ومكونات إضافية مخصصة
- **[→ ابدأ الفصل الثالث](./03-CoreGenerativeAITechniques/README.md)**

### **الفصل الرابع: التطبيقات العملية والمشاريع**
- **مولد قصص الحيوانات الأليفة** (`petstory/`): توليد محتوى إبداعي باستخدام GitHub Models
- **عرض Foundry المحلي** (`foundrylocal/`): تكامل نماذج الذكاء الاصطناعي المحلية مع OpenAI Java SDK
- **خدمة MCP للحسابات** (`mcp/calculator/`): تنفيذ بروتوكول سياق النموذج الأساسي باستخدام Spring AI
- **[→ ابدأ الفصل الرابع](./04-PracticalSamples/README.md)**

### **الفصل الخامس: تطوير الذكاء الاصطناعي المسؤول**
- **أمان GitHub Models**: اختبار تصفية المحتوى وآليات الأمان المدمجة
- **عرض الذكاء الاصطناعي المسؤول**: مثال عملي يوضح كيفية عمل فلاتر الأمان للذكاء الاصطناعي
- **أفضل الممارسات**: إرشادات أساسية لتطوير ونشر الذكاء الاصطناعي بشكل أخلاقي
- **[→ ابدأ الفصل الخامس](./05-ResponsibleGenAI/README.md)**

## موارد إضافية 

- [AI Agents For Beginners](https://github.com/microsoft/ai-agents-for-beginners)
- [Generative AI for Beginners using .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generative AI for Beginners using JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Generative AI for Beginners](https://github.com/microsoft/generative-ai-for-beginners)
- [ML for Beginners](https://aka.ms/ml-beginners)
- [Data Science for Beginners](https://aka.ms/datascience-beginners)
- [AI for Beginners](https://aka.ms/ai-beginners)
- [Cybersecurity for Beginners](https://github.com/microsoft/Security-101)
- [Web Dev for Beginners](https://aka.ms/webdev-beginners)
- [IoT for Beginners](https://aka.ms/iot-beginners)
- [XR Development for Beginners](https://github.com/microsoft/xr-development-for-beginners)
- [Mastering GitHub Copilot for AI Paired Programming](https://aka.ms/GitHubCopilotAI)
- [Mastering GitHub Copilot for C#/.NET Developers](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Choose Your Own Copilot Adventure](https://github.com/microsoft/CopilotAdventures)
- [RAG Chat App with Azure AI Services](https://github.com/Azure-Samples/azure-search-openai-demo-java)

**إخلاء المسؤولية**:  
تم ترجمة هذا المستند باستخدام خدمة الترجمة بالذكاء الاصطناعي [Co-op Translator](https://github.com/Azure/co-op-translator). بينما نسعى لتحقيق الدقة، يرجى العلم أن الترجمات الآلية قد تحتوي على أخطاء أو معلومات غير دقيقة. يجب اعتبار المستند الأصلي بلغته الأصلية المصدر الرسمي. للحصول على معلومات حاسمة، يُوصى بالاستعانة بترجمة بشرية احترافية. نحن غير مسؤولين عن أي سوء فهم أو تفسيرات خاطئة تنشأ عن استخدام هذه الترجمة.