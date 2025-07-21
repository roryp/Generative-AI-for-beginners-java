<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "69dffd84127360d3f9446b89de471abe",
  "translation_date": "2025-07-21T18:30:50+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "ur"
}
-->
# پالتو کہانی ایپ

>**نوٹ**: اس باب میں ایک [**رہنمائی**](./TUTORIAL.md) شامل ہے جو آپ کو مکمل نمونوں کو چلانے کے طریقے سے آگاہ کرتی ہے۔

ایک اسپرنگ بوٹ ویب ایپلیکیشن جو اپلوڈ کی گئی پالتو جانوروں کی تصاویر کے لیے GitHub ماڈلز کا استعمال کرتے ہوئے AI سے چلنے والے تفصیلات اور کہانیاں تیار کرتی ہے۔

## فہرست مضامین

- [ٹیکنالوجی اسٹیک](../../../../04-PracticalSamples/petstory)
- [ضروریات](../../../../04-PracticalSamples/petstory)
- [سیٹ اپ اور انسٹالیشن](../../../../04-PracticalSamples/petstory)
- [استعمال](../../../../04-PracticalSamples/petstory)

## ٹیکنالوجی اسٹیک

- **بیک اینڈ**: اسپرنگ بوٹ 3.5.3، جاوا 21
- **AI انضمام**: OpenAI جاوا SDK کے ساتھ GitHub ماڈلز
- **سیکیورٹی**: اسپرنگ سیکیورٹی
- **فرنٹ اینڈ**: تھائم لیف ٹیمپلیٹس کے ساتھ بوٹسٹریپ اسٹائلنگ
- **بلڈ ٹول**: میون
- **AI ماڈلز**: GitHub ماڈلز

## ضروریات

- جاوا 21 یا اس سے زیادہ
- میون 3.9+
- GitHub پرسنل ایکسیس ٹوکن جس میں `models:read` اسکوپ ہو

## سیٹ اپ اور انسٹالیشن

### 1. پالتو کہانی ایپلیکیشن ڈائریکٹری پر جائیں
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. ماحولیاتی متغیر سیٹ کریں
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. ایپلیکیشن کو بلڈ کریں
```bash
mvn clean compile
```

### 4. ایپلیکیشن کو چلائیں
```bash
mvn spring-boot:run
```

## استعمال

1. **ایپلیکیشن تک رسائی حاصل کریں**: `http://localhost:8080` پر جائیں
2. **تصویر اپلوڈ کریں**: "Choose File" پر کلک کریں اور پالتو جانور کی تصویر منتخب کریں
3. **تصویر کا تجزیہ کریں**: "Analyze Image" پر کلک کریں تاکہ AI تفصیل حاصل ہو
4. **کہانی بنائیں**: "Generate Story" پر کلک کریں تاکہ کہانی تخلیق ہو

**ڈسکلیمر**:  
یہ دستاویز AI ترجمہ سروس [Co-op Translator](https://github.com/Azure/co-op-translator) کا استعمال کرتے ہوئے ترجمہ کی گئی ہے۔ ہم درستگی کے لیے کوشش کرتے ہیں، لیکن براہ کرم آگاہ رہیں کہ خودکار ترجمے میں غلطیاں یا غیر درستیاں ہو سکتی ہیں۔ اصل دستاویز کو اس کی اصل زبان میں مستند ذریعہ سمجھا جانا چاہیے۔ اہم معلومات کے لیے، پیشہ ور انسانی ترجمہ کی سفارش کی جاتی ہے۔ ہم اس ترجمے کے استعمال سے پیدا ہونے والی کسی بھی غلط فہمی یا غلط تشریح کے ذمہ دار نہیں ہیں۔