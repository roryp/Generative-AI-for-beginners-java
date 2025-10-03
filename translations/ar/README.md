<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "4d04ae8088f6a3c3fcbab18cbdfe4002",
  "translation_date": "2025-10-03T08:02:26+00:00",
  "source_file": "README.md",
  "language_code": "ar"
}
-->
# الذكاء الاصطناعي التوليدي للمبتدئين - إصدار Java
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![الذكاء الاصطناعي التوليدي للمبتدئين - إصدار Java](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.ar.png)

**الوقت المطلوب**: يمكن إكمال الورشة بالكامل عبر الإنترنت دون الحاجة إلى إعداد محلي. يستغرق إعداد البيئة دقيقتين، بينما يتطلب استكشاف الأمثلة من 1 إلى 3 ساعات حسب عمق الاستكشاف.

> **البدء السريع**

1. قم بعمل Fork لهذا المستودع إلى حساب GitHub الخاص بك
2. انقر على **Code** → علامة تبويب **Codespaces** → **...** → **New with options...**
3. استخدم الإعدادات الافتراضية – سيتم اختيار حاوية التطوير التي تم إنشاؤها لهذه الدورة
4. انقر على **Create codespace**
5. انتظر حوالي دقيقتين حتى تكون البيئة جاهزة
6. انتقل مباشرة إلى [المثال الأول](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## دعم متعدد اللغات

### مدعوم عبر GitHub Action (تلقائي ودائم التحديث)

[الفرنسية](../fr/README.md) | [الإسبانية](../es/README.md) | [الألمانية](../de/README.md) | [الروسية](../ru/README.md) | [العربية](./README.md) | [الفارسية](../fa/README.md) | [الأردية](../ur/README.md) | [الصينية (المبسطة)](../zh/README.md) | [الصينية (التقليدية، ماكاو)](../mo/README.md) | [الصينية (التقليدية، هونغ كونغ)](../hk/README.md) | [الصينية (التقليدية، تايوان)](../tw/README.md) | [اليابانية](../ja/README.md) | [الكورية](../ko/README.md) | [الهندية](../hi/README.md) | [البنغالية](../bn/README.md) | [الماراثية](../mr/README.md) | [النيبالية](../ne/README.md) | [البنجابية (غورموخي)](../pa/README.md) | [البرتغالية (البرتغال)](../pt/README.md) | [البرتغالية (البرازيل)](../br/README.md) | [الإيطالية](../it/README.md) | [البولندية](../pl/README.md) | [التركية](../tr/README.md) | [اليونانية](../el/README.md) | [التايلاندية](../th/README.md) | [السويدية](../sv/README.md) | [الدانماركية](../da/README.md) | [النرويجية](../no/README.md) | [الفنلندية](../fi/README.md) | [الهولندية](../nl/README.md) | [العبرية](../he/README.md) | [الفيتنامية](../vi/README.md) | [الإندونيسية](../id/README.md) | [الماليزية](../ms/README.md) | [التاغالوغية (الفلبينية)](../tl/README.md) | [السواحيلية](../sw/README.md) | [الهنغارية](../hu/README.md) | [التشيكية](../cs/README.md) | [السلوفاكية](../sk/README.md) | [الرومانية](../ro/README.md) | [البلغارية](../bg/README.md) | [الصربية (السيريلية)](../sr/README.md) | [الكرواتية](../hr/README.md) | [السلوفينية](../sl/README.md) | [الأوكرانية](../uk/README.md) | [البورمية (ميانمار)](../my/README.md)

## هيكل الدورة ومسار التعلم

### **الفصل الأول: مقدمة في الذكاء الاصطناعي التوليدي**
- **المفاهيم الأساسية**: فهم نماذج اللغة الكبيرة، الرموز، التضمينات، وقدرات الذكاء الاصطناعي
- **نظام الذكاء الاصطناعي في Java**: نظرة عامة على Spring AI و OpenAI SDKs
- **بروتوكول سياق النموذج**: مقدمة عن MCP ودوره في تواصل وكلاء الذكاء الاصطناعي
- **التطبيقات العملية**: سيناريوهات واقعية تشمل روبوتات الدردشة وتوليد المحتوى
- **[→ ابدأ الفصل الأول](./01-IntroToGenAI/README.md)**

### **الفصل الثاني: إعداد بيئة التطوير**
- **تكوين متعدد المزودين**: إعداد نماذج GitHub، Azure OpenAI، و OpenAI Java SDK
- **Spring Boot + Spring AI**: أفضل الممارسات لتطوير تطبيقات الذكاء الاصطناعي للمؤسسات
- **نماذج GitHub**: الوصول إلى نماذج الذكاء الاصطناعي مجانًا للتجربة والتعلم (لا حاجة لبطاقة ائتمان)
- **أدوات التطوير**: إعداد حاويات Docker، VS Code، و GitHub Codespaces
- **[→ ابدأ الفصل الثاني](./02-SetupDevEnvironment/README.md)**

### **الفصل الثالث: تقنيات الذكاء الاصطناعي التوليدي الأساسية**
- **هندسة التوجيه**: تقنيات للحصول على استجابات مثالية من نماذج الذكاء الاصطناعي
- **التضمينات وعمليات المتجهات**: تنفيذ البحث الدلالي ومطابقة التشابه
- **توليد البيانات المعزز بالاسترجاع (RAG)**: دمج الذكاء الاصطناعي مع مصادر البيانات الخاصة بك
- **استدعاء الوظائف**: توسيع قدرات الذكاء الاصطناعي باستخدام أدوات ومكونات إضافية مخصصة
- **[→ ابدأ الفصل الثالث](./03-CoreGenerativeAITechniques/README.md)**

### **الفصل الرابع: التطبيقات العملية والمشاريع**
- **مولد قصص الحيوانات الأليفة** (`petstory/`): توليد محتوى إبداعي باستخدام نماذج GitHub
- **عرض محلي لـ Foundry** (`foundrylocal/`): دمج نماذج الذكاء الاصطناعي محليًا باستخدام OpenAI Java SDK
- **خدمة حاسبة MCP** (`calculator/`): تنفيذ بروتوكول سياق النموذج الأساسي باستخدام Spring AI
- **[→ ابدأ الفصل الرابع](./04-PracticalSamples/README.md)**

### **الفصل الخامس: تطوير الذكاء الاصطناعي المسؤول**
- **سلامة نماذج GitHub**: اختبار تصفية المحتوى وآليات السلامة المدمجة (الحظر الصارم والرفض الناعم)
- **عرض الذكاء الاصطناعي المسؤول**: مثال عملي يوضح كيفية عمل أنظمة السلامة الحديثة للذكاء الاصطناعي
- **أفضل الممارسات**: إرشادات أساسية لتطوير ونشر الذكاء الاصطناعي بشكل أخلاقي
- **[→ ابدأ الفصل الخامس](./05-ResponsibleGenAI/README.md)**

## موارد إضافية

- [Edge AI للمبتدئين](https://github.com/microsoft/edgeai-for-beginners)
- [MCP للمبتدئين](https://github.com/microsoft/mcp-for-beginners)
- [وكلاء الذكاء الاصطناعي للمبتدئين](https://github.com/microsoft/ai-agents-for-beginners)
- [الذكاء الاصطناعي التوليدي للمبتدئين باستخدام .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [الذكاء الاصطناعي التوليدي للمبتدئين باستخدام JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [الذكاء الاصطناعي التوليدي للمبتدئين](https://github.com/microsoft/generative-ai-for-beginners)
- [تعلم الآلة للمبتدئين](https://aka.ms/ml-beginners)
- [علم البيانات للمبتدئين](https://aka.ms/datascience-beginners)
- [الذكاء الاصطناعي للمبتدئين](https://aka.ms/ai-beginners)
- [الأمن السيبراني للمبتدئين](https://github.com/microsoft/Security-101)
- [تطوير الويب للمبتدئين](https://aka.ms/webdev-beginners)
- [إنترنت الأشياء للمبتدئين](https://aka.ms/iot-beginners)
- [تطوير XR للمبتدئين](https://github.com/microsoft/xr-development-for-beginners)
- [إتقان GitHub Copilot للبرمجة المزدوجة بالذكاء الاصطناعي](https://aka.ms/GitHubCopilotAI)
- [إتقان GitHub Copilot لمطوري C#/.NET](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [اختر مغامرتك مع Copilot](https://github.com/microsoft/CopilotAdventures)
- [تطبيق دردشة RAG مع خدمات Azure AI](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## الحصول على المساعدة

إذا واجهت أي صعوبات أو كانت لديك أسئلة حول بناء تطبيقات الذكاء الاصطناعي، انضم إلى:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

إذا كانت لديك ملاحظات حول المنتج أو أخطاء أثناء البناء، قم بزيارة:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**إخلاء المسؤولية**:  
تم ترجمة هذا المستند باستخدام خدمة الترجمة بالذكاء الاصطناعي [Co-op Translator](https://github.com/Azure/co-op-translator). بينما نسعى لتحقيق الدقة، يرجى العلم أن الترجمات الآلية قد تحتوي على أخطاء أو عدم دقة. يجب اعتبار المستند الأصلي بلغته الأصلية المصدر الرسمي. للحصول على معلومات حاسمة، يُوصى بالترجمة البشرية الاحترافية. نحن غير مسؤولين عن أي سوء فهم أو تفسيرات خاطئة ناتجة عن استخدام هذه الترجمة.