<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b8a372dfc3e3e7ad9261231a22fd79c0",
  "translation_date": "2025-07-25T08:50:23+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "fa"
}
-->
# تکنیک‌های اصلی هوش مصنوعی مولد

>**توجه**: این فصل شامل یک [**آموزش**](./TUTORIAL.md) است که شما را با نمونه‌ها به صورت گام‌به‌گام راهنمایی می‌کند.

## آنچه خواهید آموخت
در این فصل، ۴ تکنیک اصلی هوش مصنوعی مولد را از طریق مثال‌های عملی بررسی می‌کنیم:
- تکمیل‌های LLM و جریان‌های گفتگو
- فراخوانی توابع
- تولید تقویت‌شده با بازیابی (RAG)
- اقدامات ایمنی هوش مصنوعی مسئولانه

## فهرست مطالب

- [آنچه خواهید آموخت](../../../03-CoreGenerativeAITechniques)
- [پیش‌نیازها](../../../03-CoreGenerativeAITechniques)
- [شروع به کار](../../../03-CoreGenerativeAITechniques)
- [بررسی اجمالی مثال‌ها](../../../03-CoreGenerativeAITechniques)
  - [۱. تکمیل‌های LLM و جریان‌های گفتگو](../../../03-CoreGenerativeAITechniques)
  - [۲. توابع و افزونه‌ها با LLMها](../../../03-CoreGenerativeAITechniques)
  - [۳. تولید تقویت‌شده با بازیابی (RAG)](../../../03-CoreGenerativeAITechniques)
  - [۴. نمایش ایمنی هوش مصنوعی مسئولانه](../../../03-CoreGenerativeAITechniques)
- [خلاصه](../../../03-CoreGenerativeAITechniques)
- [گام‌های بعدی](../../../03-CoreGenerativeAITechniques)

## پیش‌نیازها

- تکمیل تنظیمات از [فصل ۲](../../../02-SetupDevEnvironment)

## شروع به کار

۱. **به پوشه مثال‌ها بروید**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
۲. **محیط را تنظیم کنید**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
۳. **مثال‌ها را کامپایل و اجرا کنید**:  
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

## بررسی اجمالی مثال‌ها

مثال‌ها در پوشه `examples/` با ساختار زیر سازمان‌دهی شده‌اند:

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

### ۱. تکمیل‌های LLM و جریان‌های گفتگو
**فایل**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

یاد بگیرید که چگونه هوش مصنوعی مکالمه‌ای با پاسخ‌های جریانی و مدیریت تاریخچه گفتگو بسازید.

این مثال نشان می‌دهد:
- تکمیل متن ساده با دستورات سیستمی
- مکالمات چندمرحله‌ای با مدیریت تاریخچه
- جلسات چت تعاملی
- پیکربندی پارامترها (دمای مدل، حداکثر تعداد توکن‌ها)

### ۲. توابع و افزونه‌ها با LLMها
**فایل**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

قابلیت‌های هوش مصنوعی را با ارائه دسترسی به توابع سفارشی و APIهای خارجی گسترش دهید.

این مثال نشان می‌دهد:
- ادغام تابع آب‌وهوا
- پیاده‌سازی تابع ماشین‌حساب  
- فراخوانی چندین تابع در یک مکالمه
- تعریف توابع با استفاده از JSON Schema

### ۳. تولید تقویت‌شده با بازیابی (RAG)
**فایل**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

یاد بگیرید که چگونه هوش مصنوعی را با اسناد و منابع داده خود ترکیب کنید تا پاسخ‌های دقیق و مبتنی بر زمینه ارائه دهید.

این مثال نشان می‌دهد:
- پاسخ به سوالات مبتنی بر اسناد با استفاده از Azure OpenAI SDK
- پیاده‌سازی الگوی RAG با مدل‌های GitHub

**کاربرد**: سوالاتی درباره محتوای فایل `document.txt` بپرسید و پاسخ‌های هوش مصنوعی را فقط بر اساس آن زمینه دریافت کنید.

### ۴. نمایش ایمنی هوش مصنوعی مسئولانه
**فایل**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

پیش‌نمایشی از نحوه عملکرد اقدامات ایمنی هوش مصنوعی با آزمایش قابلیت‌های فیلتر محتوای مدل‌های GitHub دریافت کنید.

این مثال نشان می‌دهد:
- فیلتر محتوا برای دستورات بالقوه مضر
- مدیریت پاسخ‌های ایمنی در برنامه‌ها
- دسته‌بندی‌های مختلف محتوای مسدودشده (خشونت، سخنان نفرت‌انگیز، اطلاعات نادرست)
- مدیریت صحیح خطاها برای نقض‌های ایمنی

> **بیشتر بدانید**: این فقط مقدمه‌ای بر مفاهیم هوش مصنوعی مسئولانه است. برای اطلاعات بیشتر درباره اخلاق، کاهش سوگیری، ملاحظات حریم خصوصی، و چارچوب‌های هوش مصنوعی مسئولانه، به [فصل ۵: هوش مصنوعی مولد مسئولانه](../05-ResponsibleGenAI/README.md) مراجعه کنید.

## خلاصه

در این فصل، تکمیل‌های LLM و جریان‌های گفتگو را بررسی کردیم، فراخوانی توابع برای گسترش قابلیت‌های هوش مصنوعی را پیاده‌سازی کردیم، یک سیستم تولید تقویت‌شده با بازیابی (RAG) ایجاد کردیم، و اقدامات ایمنی هوش مصنوعی مسئولانه را نمایش دادیم.

> **توجه**: با [**آموزش**](./TUTORIAL.md) ارائه‌شده عمیق‌تر کاوش کنید.

## گام‌های بعدی

[فصل ۴: کاربردها و پروژه‌های عملی](../04-PracticalSamples/README.md)

**سلب مسئولیت**:  
این سند با استفاده از سرویس ترجمه هوش مصنوعی [Co-op Translator](https://github.com/Azure/co-op-translator) ترجمه شده است. در حالی که ما تلاش می‌کنیم دقت را حفظ کنیم، لطفاً توجه داشته باشید که ترجمه‌های خودکار ممکن است شامل خطاها یا نادرستی‌ها باشند. سند اصلی به زبان اصلی آن باید به عنوان منبع معتبر در نظر گرفته شود. برای اطلاعات حساس، توصیه می‌شود از ترجمه حرفه‌ای انسانی استفاده کنید. ما مسئولیتی در قبال سوء تفاهم‌ها یا تفسیرهای نادرست ناشی از استفاده از این ترجمه نداریم.