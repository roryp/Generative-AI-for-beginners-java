<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T09:14:16+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "mr"
}
-->
# पाळीव प्राणी कथा अ‍ॅप

>**टीप**: या अध्यायात [**ट्युटोरियल**](./TUTORIAL.md) समाविष्ट आहे, जे तुम्हाला नमुन्यांद्वारे मार्गदर्शन करते.

हे एक स्प्रिंग बूट वेब अ‍ॅप्लिकेशन आहे, जे GitHub Models चा वापर करून अपलोड केलेल्या पाळीव प्राण्यांच्या प्रतिमांसाठी AI-चालित वर्णने आणि कथा तयार करते.

## विषय सूची

- [तंत्रज्ञान संच](../../../../04-PracticalSamples/petstory)
- [पूर्वअट](../../../../04-PracticalSamples/petstory)
- [सेटअप आणि स्थापना](../../../../04-PracticalSamples/petstory)
- [वापर](../../../../04-PracticalSamples/petstory)

## तंत्रज्ञान संच

- **बॅकएंड**: Spring Boot 3.5.3, Java 21  
- **AI एकत्रीकरण**: OpenAI Java SDK सह GitHub Models  
- **सुरक्षा**: Spring Security  
- **फ्रंटएंड**: Thymeleaf टेम्पलेट्स Bootstrap स्टाइलिंगसह  
- **बिल्ड साधन**: Maven  
- **AI मॉडेल्स**: GitHub Models  

## पूर्वअट

- Java 21 किंवा त्याहून अधिक  
- Maven 3.9+  
- `models:read` स्कोपसह GitHub वैयक्तिक प्रवेश टोकन  

## सेटअप आणि स्थापना

### 1. petstory अ‍ॅप्लिकेशन डिरेक्टरीमध्ये जा  
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. पर्यावरणीय चल सेट करा  
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. अ‍ॅप्लिकेशन तयार करा  
```bash
mvn clean compile
```

### 4. अ‍ॅप्लिकेशन चालवा  
```bash
mvn spring-boot:run
```

## वापर

1. **अ‍ॅप्लिकेशनमध्ये प्रवेश करा**: `http://localhost:8080` येथे जा  
2. **प्रतिमा अपलोड करा**: "Choose File" वर क्लिक करा आणि पाळीव प्राण्याची प्रतिमा निवडा  
3. **प्रतिमा विश्लेषण करा**: "Analyze Image" वर क्लिक करा, AI वर्णन मिळवा  
4. **कथा तयार करा**: "Generate Story" वर क्लिक करा, कथा तयार करा  

**अस्वीकरण**:  
हा दस्तऐवज AI भाषांतर सेवा [Co-op Translator](https://github.com/Azure/co-op-translator) वापरून भाषांतरित करण्यात आला आहे. आम्ही अचूकतेसाठी प्रयत्नशील असलो तरी कृपया लक्षात ठेवा की स्वयंचलित भाषांतरांमध्ये त्रुटी किंवा अचूकतेचा अभाव असू शकतो. मूळ भाषेतील दस्तऐवज हा अधिकृत स्रोत मानला जावा. महत्त्वाच्या माहितीसाठी व्यावसायिक मानवी भाषांतराची शिफारस केली जाते. या भाषांतराचा वापर करून उद्भवलेल्या कोणत्याही गैरसमज किंवा चुकीच्या अर्थासाठी आम्ही जबाबदार राहणार नाही.