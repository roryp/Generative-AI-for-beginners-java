<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "69dffd84127360d3f9446b89de471abe",
  "translation_date": "2025-07-21T18:31:29+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "ne"
}
-->
# पेट स्टोरी एप

>**Note**: यो अध्यायमा [**Tutorial**](./TUTORIAL.md) समावेश छ जसले तयार गरिएको नमूनाहरू चलाउन मार्गदर्शन गर्दछ।

एक स्प्रिंग बुट वेब एप्लिकेसन जसले अपलोड गरिएको पाल्तु जनावरको तस्बिरहरूको लागि GitHub Models प्रयोग गरेर AI-संचालित विवरणहरू र कथाहरू सिर्जना गर्दछ।

## सामग्री तालिका

- [प्रविधि स्ट्याक](../../../../04-PracticalSamples/petstory)
- [पूर्वापेक्षाहरू](../../../../04-PracticalSamples/petstory)
- [सेटअप र स्थापना](../../../../04-PracticalSamples/petstory)
- [प्रयोग](../../../../04-PracticalSamples/petstory)

## प्रविधि स्ट्याक

- **ब्याकएन्ड**: स्प्रिंग बुट 3.5.3, जाभा 21
- **AI एकीकरण**: OpenAI Java SDK GitHub Models सँग
- **सुरक्षा**: स्प्रिंग सुरक्षा
- **फ्रन्टएन्ड**: Thymeleaf टेम्प्लेटहरू Bootstrap शैलीसहित
- **बिल्ड उपकरण**: Maven
- **AI मोडेलहरू**: GitHub Models

## पूर्वापेक्षाहरू

- जाभा 21 वा उच्च
- Maven 3.9+
- `models:read` स्कोपसहित GitHub व्यक्तिगत पहुँच टोकन

## सेटअप र स्थापना

### 1. पेटस्टोरी एप्लिकेसनको डाइरेक्टरीमा जानुहोस्
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. वातावरण चर सेट गर्नुहोस्
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. एप्लिकेसन निर्माण गर्नुहोस्
```bash
mvn clean compile
```

### 4. एप्लिकेसन चलाउनुहोस्
```bash
mvn spring-boot:run
```

## प्रयोग

1. **एप्लिकेसन पहुँच गर्नुहोस्**: `http://localhost:8080` मा जानुहोस्
2. **तस्बिर अपलोड गर्नुहोस्**: "Choose File" क्लिक गर्नुहोस् र पाल्तु जनावरको तस्बिर चयन गर्नुहोस्
3. **तस्बिर विश्लेषण गर्नुहोस्**: "Analyze Image" क्लिक गरेर AI विवरण प्राप्त गर्नुहोस्
4. **कथा सिर्जना गर्नुहोस्**: "Generate Story" क्लिक गरेर कथा बनाउनुहोस्

**अस्वीकरण**:  
यो दस्तावेज़ AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) प्रयोग गरेर अनुवाद गरिएको छ। हामी यथार्थताको लागि प्रयास गर्छौं, तर कृपया ध्यान दिनुहोस् कि स्वचालित अनुवादहरूमा त्रुटिहरू वा अशुद्धताहरू हुन सक्छ। यसको मूल भाषा मा रहेको मूल दस्तावेज़लाई आधिकारिक स्रोत मानिनुपर्छ। महत्वपूर्ण जानकारीको लागि, व्यावसायिक मानव अनुवाद सिफारिस गरिन्छ। यस अनुवादको प्रयोगबाट उत्पन्न हुने कुनै पनि गलतफहमी वा गलत व्याख्याको लागि हामी जिम्मेवार हुने छैनौं।