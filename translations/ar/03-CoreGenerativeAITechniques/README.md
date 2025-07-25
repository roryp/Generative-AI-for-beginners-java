<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b8a372dfc3e3e7ad9261231a22fd79c0",
  "translation_date": "2025-07-25T08:48:20+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "ar"
}
-->
# تقنيات الذكاء الاصطناعي التوليدي الأساسية

>**ملاحظة**: يتضمن هذا الفصل [**دليلًا تفصيليًا**](./TUTORIAL.md) يرشدك خطوة بخطوة عبر الأمثلة.

## ما الذي ستتعلمه
في هذا الفصل، سنستعرض 4 تقنيات أساسية للذكاء الاصطناعي التوليدي من خلال أمثلة عملية:
- إكمالات LLM وتدفقات المحادثة
- استدعاء الوظائف
- التوليد المعزز بالاسترجاع (RAG)
- تدابير الأمان للذكاء الاصطناعي المسؤول

## جدول المحتويات

- [ما الذي ستتعلمه](../../../03-CoreGenerativeAITechniques)
- [المتطلبات الأساسية](../../../03-CoreGenerativeAITechniques)
- [البدء](../../../03-CoreGenerativeAITechniques)
- [نظرة عامة على الأمثلة](../../../03-CoreGenerativeAITechniques)
  - [1. إكمالات LLM وتدفقات المحادثة](../../../03-CoreGenerativeAITechniques)
  - [2. الوظائف والإضافات مع LLMs](../../../03-CoreGenerativeAITechniques)
  - [3. التوليد المعزز بالاسترجاع (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. عرض تدابير الأمان للذكاء الاصطناعي المسؤول](../../../03-CoreGenerativeAITechniques)
- [الملخص](../../../03-CoreGenerativeAITechniques)
- [الخطوات التالية](../../../03-CoreGenerativeAITechniques)

## المتطلبات الأساسية

- إكمال الإعداد من [الفصل الثاني](../../../02-SetupDevEnvironment)

## البدء

1. **انتقل إلى الأمثلة**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **قم بضبط البيئة**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **قم بتجميع وتشغيل الأمثلة**:  
```bash
   # Run completions example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
   
   # Run functions example  
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
   
   # Run RAG example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
   
   # Run responsible AI demo
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
   ```  

## نظرة عامة على الأمثلة

تم تنظيم الأمثلة في مجلد `examples/` بالهيكل التالي:

```
examples/
├── src/main/java/com/example/genai/techniques/
│   ├── completions/
│   │   └── LLMCompletionsApp.java        # Basic completions 
│   ├── functions/
│   │   └── FunctionsApp.java             # Function calling examples
│   ├── rag/
│   │   └── SimpleReaderDemo.java         # Retrieval-Augmented Generation
│   └── responsibleai/
│       └── ResponsibleGithubModels.java  # Responsible AI safety demonstration
├── document.txt                          # Sample document for RAG example
└── pom.xml                               # Maven configuration
```

### 1. إكمالات LLM وتدفقات المحادثة
**الملف**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

تعلم كيفية بناء ذكاء اصطناعي محادثي مع استجابات متدفقة وإدارة تاريخ المحادثات.

يستعرض هذا المثال:
- إكمال نص بسيط باستخدام مطالبات النظام
- محادثات متعددة الأدوار مع إدارة التاريخ
- جلسات محادثة تفاعلية
- ضبط المعلمات (مثل درجة الحرارة، الحد الأقصى للرموز)

### 2. الوظائف والإضافات مع LLMs
**الملف**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

قم بتوسيع قدرات الذكاء الاصطناعي من خلال منح النماذج إمكانية الوصول إلى وظائف مخصصة وواجهات برمجة تطبيقات خارجية.

يستعرض هذا المثال:
- دمج وظيفة الطقس
- تنفيذ وظيفة الآلة الحاسبة  
- استدعاء وظائف متعددة في محادثة واحدة
- تعريف الوظائف باستخدام مخططات JSON

### 3. التوليد المعزز بالاسترجاع (RAG)
**الملف**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

تعلم كيفية دمج الذكاء الاصطناعي مع مستنداتك ومصادر بياناتك للحصول على استجابات دقيقة وواعية بالسياق.

يستعرض هذا المثال:
- الإجابة عن الأسئلة المستندة إلى المستندات باستخدام Azure OpenAI SDK
- تنفيذ نمط RAG مع نماذج GitHub

**الاستخدام**: اطرح أسئلة حول المحتوى في `document.txt` واحصل على استجابات الذكاء الاصطناعي بناءً على هذا السياق فقط.

### 4. عرض تدابير الأمان للذكاء الاصطناعي المسؤول
**الملف**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

احصل على معاينة لكيفية عمل تدابير الأمان في الذكاء الاصطناعي من خلال اختبار قدرات تصفية المحتوى لنماذج GitHub.

يستعرض هذا المثال:
- تصفية المحتوى للمطالبات التي قد تكون ضارة
- التعامل مع استجابات الأمان في التطبيقات
- فئات مختلفة من المحتوى المحظور (العنف، خطاب الكراهية، المعلومات المضللة)
- التعامل الصحيح مع الأخطاء الناتجة عن انتهاكات الأمان

> **تعرف أكثر**: هذا مجرد مقدمة لمفاهيم الذكاء الاصطناعي المسؤول. لمزيد من المعلومات حول الأخلاقيات، تخفيف التحيز، اعتبارات الخصوصية، وأطر الذكاء الاصطناعي المسؤول، راجع [الفصل الخامس: الذكاء الاصطناعي التوليدي المسؤول](../05-ResponsibleGenAI/README.md).

## الملخص

في هذا الفصل، استعرضنا إكمالات LLM وتدفقات المحادثة، وطبقنا استدعاء الوظائف لتعزيز قدرات الذكاء الاصطناعي، وأنشأنا نظام توليد معزز بالاسترجاع (RAG)، وعرضنا تدابير الأمان للذكاء الاصطناعي المسؤول.

> **ملاحظة**: تعمق أكثر مع [**الدليل**](./TUTORIAL.md) المقدم.

## الخطوات التالية

[الفصل الرابع: التطبيقات العملية والمشاريع](../04-PracticalSamples/README.md)

**إخلاء المسؤولية**:  
تم ترجمة هذا المستند باستخدام خدمة الترجمة بالذكاء الاصطناعي [Co-op Translator](https://github.com/Azure/co-op-translator). بينما نسعى لتحقيق الدقة، يرجى العلم أن الترجمات الآلية قد تحتوي على أخطاء أو معلومات غير دقيقة. يجب اعتبار المستند الأصلي بلغته الأصلية المصدر الموثوق. للحصول على معلومات حاسمة، يُوصى بالاستعانة بترجمة بشرية احترافية. نحن غير مسؤولين عن أي سوء فهم أو تفسيرات خاطئة تنشأ عن استخدام هذه الترجمة.