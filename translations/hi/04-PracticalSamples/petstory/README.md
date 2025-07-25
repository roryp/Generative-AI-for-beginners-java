<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T09:09:39+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "hi"
}
-->
# पेट स्टोरी ऐप

>**नोट**: इस अध्याय में एक [**ट्यूटोरियल**](./TUTORIAL.md) शामिल है जो आपको नमूनों के माध्यम से मार्गदर्शन करता है।

यह एक स्प्रिंग बूट वेब एप्लिकेशन है जो अपलोड की गई पालतू जानवरों की छवियों के लिए GitHub मॉडल्स का उपयोग करके एआई-आधारित विवरण और कहानियां तैयार करता है।

## सामग्री तालिका

- [तकनीकी स्टैक](../../../../04-PracticalSamples/petstory)
- [पूर्वापेक्षाएँ](../../../../04-PracticalSamples/petstory)
- [सेटअप और इंस्टॉलेशन](../../../../04-PracticalSamples/petstory)
- [उपयोग](../../../../04-PracticalSamples/petstory)

## तकनीकी स्टैक

- **बैकएंड**: स्प्रिंग बूट 3.5.3, जावा 21
- **एआई इंटीग्रेशन**: OpenAI Java SDK के साथ GitHub मॉडल्स
- **सुरक्षा**: स्प्रिंग सिक्योरिटी
- **फ्रंटएंड**: Thymeleaf टेम्पलेट्स के साथ Bootstrap स्टाइलिंग
- **बिल्ड टूल**: Maven
- **एआई मॉडल्स**: GitHub मॉडल्स

## पूर्वापेक्षाएँ

- जावा 21 या उससे अधिक
- Maven 3.9+
- `models:read` स्कोप के साथ GitHub पर्सनल एक्सेस टोकन

## सेटअप और इंस्टॉलेशन

### 1. पेटस्टोरी एप्लिकेशन डायरेक्टरी पर जाएं
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. पर्यावरण वेरिएबल सेट करें
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. एप्लिकेशन को बिल्ड करें
```bash
mvn clean compile
```

### 4. एप्लिकेशन चलाएं
```bash
mvn spring-boot:run
```

## उपयोग

1. **एप्लिकेशन एक्सेस करें**: `http://localhost:8080` पर जाएं
2. **छवि अपलोड करें**: "Choose File" पर क्लिक करें और एक पालतू जानवर की छवि चुनें
3. **छवि का विश्लेषण करें**: "Analyze Image" पर क्लिक करें और एआई विवरण प्राप्त करें
4. **कहानी बनाएं**: "Generate Story" पर क्लिक करें और कहानी तैयार करें

**अस्वीकरण**:  
यह दस्तावेज़ AI अनुवाद सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) का उपयोग करके अनुवादित किया गया है। जबकि हम सटीकता सुनिश्चित करने का प्रयास करते हैं, कृपया ध्यान दें कि स्वचालित अनुवाद में त्रुटियां या अशुद्धियां हो सकती हैं। मूल भाषा में उपलब्ध मूल दस्तावेज़ को प्रामाणिक स्रोत माना जाना चाहिए। महत्वपूर्ण जानकारी के लिए, पेशेवर मानव अनुवाद की सिफारिश की जाती है। इस अनुवाद के उपयोग से उत्पन्न किसी भी गलतफहमी या गलत व्याख्या के लिए हम जिम्मेदार नहीं हैं।