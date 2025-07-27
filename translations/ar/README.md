<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "7216baee4139fab32d7bfa0777d75551",
  "translation_date": "2025-07-27T18:47:10+00:00",
  "source_file": "README.md",
  "language_code": "ar"
}
-->
# الذكاء الاصطناعي التوليدي للمبتدئين - إصدار Java
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![الذكاء الاصطناعي التوليدي للمبتدئين - إصدار Java](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.ar.png)

**مدة الالتزام**: يمكن إكمال الورشة بالكامل عبر الإنترنت دون الحاجة إلى إعداد محلي. يستغرق إعداد البيئة دقيقتين، بينما يتطلب استكشاف الأمثلة من 1-3 ساعات حسب عمق الاستكشاف.

> **البدء السريع**

1. قم بعمل Fork لهذا المستودع إلى حساب GitHub الخاص بك  
2. انقر على **Code** → علامة تبويب **Codespaces** → **...** → **New with options...**  
3. استخدم الإعدادات الافتراضية – سيقوم هذا باختيار حاوية التطوير المخصصة لهذه الدورة  
4. انقر على **Create codespace**  
5. انتظر حوالي دقيقتين حتى تكون البيئة جاهزة  
6. انتقل مباشرة إلى [إنشاء رمز GitHub Models الخاص بك](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)  

## دعم متعدد اللغات

### مدعوم عبر GitHub Action (تلقائي ومحدث دائمًا)

[الفرنسية](../fr/README.md) | [الإسبانية](../es/README.md) | [الألمانية](../de/README.md) | [الروسية](../ru/README.md) | [العربية](./README.md) | [الفارسية (فارسي)](../fa/README.md) | [الأردية](../ur/README.md) | [الصينية (المبسطة)](../zh/README.md) | [الصينية (التقليدية، ماكاو)](../mo/README.md) | [الصينية (التقليدية، هونغ كونغ)](../hk/README.md) | [الصينية (التقليدية، تايوان)](../tw/README.md) | [اليابانية](../ja/README.md) | [الكورية](../ko/README.md) | [الهندية](../hi/README.md) | [البنغالية](../bn/README.md) | [الماراثية](../mr/README.md) | [النيبالية](../ne/README.md) | [البنجابية (غورموخي)](../pa/README.md) | [البرتغالية (البرتغال)](../pt/README.md) | [البرتغالية (البرازيل)](../br/README.md) | [الإيطالية](../it/README.md) | [البولندية](../pl/README.md) | [التركية](../tr/README.md) | [اليونانية](../el/README.md) | [التايلاندية](../th/README.md) | [السويدية](../sv/README.md) | [الدانماركية](../da/README.md) | [النرويجية](../no/README.md) | [الفنلندية](../fi/README.md) | [الهولندية](../nl/README.md) | [العبرية](../he/README.md) | [الفيتنامية](../vi/README.md) | [الإندونيسية](../id/README.md) | [الماليزية](../ms/README.md) | [التاغالوغية (الفلبينية)](../tl/README.md) | [السواحيلية](../sw/README.md) | [الهنغارية](../hu/README.md) | [التشيكية](../cs/README.md) | [السلوفاكية](../sk/README.md) | [الرومانية](../ro/README.md) | [البلغارية](../bg/README.md) | [الصربية (السيريلية)](../sr/README.md) | [الكرواتية](../hr/README.md) | [السلوفينية](../sl/README.md) | [الأوكرانية](../uk/README.md) | [البورمية (ميانمار)](../my/README.md)

## هيكل الدورة ومسار التعلم

### **الفصل الأول: مقدمة في الذكاء الاصطناعي التوليدي**
- **المفاهيم الأساسية**: فهم نماذج اللغة الكبيرة، الرموز، التضمينات، وقدرات الذكاء الاصطناعي  
- **نظام Java للذكاء الاصطناعي**: نظرة عامة على Spring AI وOpenAI SDKs  
- **بروتوكول سياق النموذج**: مقدمة عن MCP ودوره في تواصل وكلاء الذكاء الاصطناعي  
- **التطبيقات العملية**: سيناريوهات واقعية تشمل روبوتات الدردشة وتوليد المحتوى  
- **[→ ابدأ الفصل الأول](./01-IntroToGenAI/README.md)**  

### **الفصل الثاني: إعداد بيئة التطوير**
- **إعداد متعدد المزودين**: تكامل GitHub Models وAzure OpenAI وOpenAI Java SDK  
- **Spring Boot + Spring AI**: أفضل الممارسات لتطوير تطبيقات الذكاء الاصطناعي للمؤسسات  
- **GitHub Models**: الوصول إلى نماذج الذكاء الاصطناعي مجانًا للتجريب والتعلم (لا حاجة لبطاقة ائتمان)  
- **أدوات التطوير**: إعداد حاويات Docker، VS Code، وGitHub Codespaces  
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
- **خدمة حاسبة MCP** (`mcp/calculator/`): تنفيذ أساسي لبروتوكول سياق النموذج باستخدام Spring AI  
- **[→ ابدأ الفصل الرابع](./04-PracticalSamples/README.md)**  

### **الفصل الخامس: تطوير الذكاء الاصطناعي المسؤول**
- **أمان GitHub Models**: اختبار آليات تصفية المحتوى والأمان المدمجة  
- **عرض الذكاء الاصطناعي المسؤول**: مثال عملي يوضح كيفية عمل فلاتر أمان الذكاء الاصطناعي  
- **أفضل الممارسات**: إرشادات أساسية لتطوير ونشر الذكاء الاصطناعي الأخلاقي  
- **[→ ابدأ الفصل الخامس](./05-ResponsibleGenAI/README.md)**  

## موارد إضافية

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
- [تطوير الواقع الممتد للمبتدئين](https://github.com/microsoft/xr-development-for-beginners)  
- [إتقان GitHub Copilot للبرمجة المزدوجة بالذكاء الاصطناعي](https://aka.ms/GitHubCopilotAI)  
- [إتقان GitHub Copilot لمطوري C#/.NET](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)  
- [اختر مغامرتك الخاصة مع Copilot](https://github.com/microsoft/CopilotAdventures)  
- [تطبيق دردشة RAG مع خدمات Azure AI](https://github.com/Azure-Samples/azure-search-openai-demo-java)  

**إخلاء المسؤولية**:  
تم ترجمة هذا المستند باستخدام خدمة الترجمة بالذكاء الاصطناعي [Co-op Translator](https://github.com/Azure/co-op-translator). بينما نسعى لتحقيق الدقة، يرجى العلم أن الترجمات الآلية قد تحتوي على أخطاء أو معلومات غير دقيقة. يجب اعتبار المستند الأصلي بلغته الأصلية المصدر الموثوق. للحصول على معلومات حاسمة، يُوصى بالاستعانة بترجمة بشرية احترافية. نحن غير مسؤولين عن أي سوء فهم أو تفسيرات خاطئة تنشأ عن استخدام هذه الترجمة.