<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b8a372dfc3e3e7ad9261231a22fd79c0",
  "translation_date": "2025-07-25T09:17:32+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "pa"
}
-->
# ਕੋਰ ਜਨਰੇਟਿਵ AI ਤਕਨੀਕਾਂ

>**Note**: ਇਸ ਅਧਿਆਇ ਵਿੱਚ ਇੱਕ ਵਿਸਤ੍ਰਿਤ [**ਟਿਊਟੋਰਿਯਲ**](./TUTORIAL.md) ਸ਼ਾਮਲ ਹੈ ਜੋ ਤੁਹਾਨੂੰ ਨਮੂਨਿਆਂ ਦੇ ਜਰੀਏ ਗਾਈਡ ਕਰਦਾ ਹੈ।

## ਤੁਸੀਂ ਕੀ ਸਿੱਖੋਗੇ
ਇਸ ਅਧਿਆਇ ਵਿੱਚ, ਅਸੀਂ 4 ਮੁੱਖ ਜਨਰੇਟਿਵ AI ਤਕਨੀਕਾਂ ਨੂੰ ਵਿਹੰਗੀ ਦ੍ਰਿਸ਼ਟੀ ਨਾਲ ਅਧਿਐਨ ਕਰਦੇ ਹਾਂ:
- LLM ਪੂਰਨ ਅਤੇ ਚੈਟ ਫਲੋਜ਼
- ਫੰਕਸ਼ਨ ਕਾਲਿੰਗ
- ਰੀਟਰੀਵਲ-ਅਗਮੈਂਟਡ ਜਨਰੇਸ਼ਨ (RAG)
- ਜ਼ਿੰਮੇਵਾਰ AI ਸੁਰੱਖਿਆ ਉਪਾਅ

## ਸਮੱਗਰੀ ਦੀ ਸੂਚੀ

- [ਤੁਸੀਂ ਕੀ ਸਿੱਖੋਗੇ](../../../03-CoreGenerativeAITechniques)
- [ਪੂਰਵ ਸ਼ਰਤਾਂ](../../../03-CoreGenerativeAITechniques)
- [ਸ਼ੁਰੂਆਤ](../../../03-CoreGenerativeAITechniques)
- [ਨਮੂਨਿਆਂ ਦਾ ਜਾਇਜ਼ਾ](../../../03-CoreGenerativeAITechniques)
  - [1. LLM ਪੂਰਨ ਅਤੇ ਚੈਟ ਫਲੋਜ਼](../../../03-CoreGenerativeAITechniques)
  - [2. LLMs ਨਾਲ ਫੰਕਸ਼ਨ ਅਤੇ ਪਲੱਗਇਨ](../../../03-CoreGenerativeAITechniques)
  - [3. ਰੀਟਰੀਵਲ-ਅਗਮੈਂਟਡ ਜਨਰੇਸ਼ਨ (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. ਜ਼ਿੰਮੇਵਾਰ AI ਸੁਰੱਖਿਆ ਡੈਮੋ](../../../03-CoreGenerativeAITechniques)
- [ਸੰਖੇਪ](../../../03-CoreGenerativeAITechniques)
- [ਅਗਲੇ ਕਦਮ](../../../03-CoreGenerativeAITechniques)

## ਪੂਰਵ ਸ਼ਰਤਾਂ

- [ਅਧਿਆਇ 2](../../../02-SetupDevEnvironment) ਤੋਂ ਸੈਟਅਪ ਪੂਰਾ ਕੀਤਾ ਹੋਵੇ

## ਸ਼ੁਰੂਆਤ

1. **ਨਮੂਨਿਆਂ ਵੱਲ ਜਾਓ**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **ਵਾਤਾਵਰਣ ਸੈਟ ਕਰੋ**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **ਨਮੂਨਿਆਂ ਨੂੰ ਕੰਪਾਇਲ ਅਤੇ ਚਲਾਓ**:  
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

## ਨਮੂਨਿਆਂ ਦਾ ਜਾਇਜ਼ਾ

ਨਮੂਨੇ `examples/` ਫੋਲਡਰ ਵਿੱਚ ਹੇਠਾਂ ਦਿੱਤੇ ਸੰਗਠਨ ਨਾਲ ਸਜਾਏ ਗਏ ਹਨ:

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

### 1. LLM ਪੂਰਨ ਅਤੇ ਚੈਟ ਫਲੋਜ਼  
**ਫਾਇਲ**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

ਸਟ੍ਰੀਮਿੰਗ ਜਵਾਬਾਂ ਅਤੇ ਚੈਟ ਇਤਿਹਾਸ ਪ੍ਰਬੰਧਨ ਨਾਲ ਗੱਲਬਾਤੀ AI ਬਣਾਉਣ ਸਿੱਖੋ।

ਇਸ ਨਮੂਨੇ ਵਿੱਚ ਦਰਸਾਇਆ ਗਿਆ ਹੈ:
- ਸਿਸਟਮ ਪ੍ਰੋੰਪਟ ਨਾਲ ਸਧਾਰਨ ਟੈਕਸਟ ਪੂਰਨ
- ਇਤਿਹਾਸ ਪ੍ਰਬੰਧਨ ਨਾਲ ਬਹੁ-ਮੁੜ ਗੱਲਬਾਤ
- ਇੰਟਰਐਕਟਿਵ ਚੈਟ ਸੈਸ਼ਨ
- ਪੈਰਾਮੀਟਰ ਸੰਰਚਨਾ (ਤਾਪਮਾਨ, ਵੱਧ ਤੋਂ ਵੱਧ ਟੋਕਨ)

### 2. LLMs ਨਾਲ ਫੰਕਸ਼ਨ ਅਤੇ ਪਲੱਗਇਨ  
**ਫਾਇਲ**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

ਮਾਡਲਾਂ ਨੂੰ ਕਸਟਮ ਫੰਕਸ਼ਨ ਅਤੇ ਬਾਹਰੀ APIs ਤੱਕ ਪਹੁੰਚ ਦੇ ਕੇ AI ਦੀ ਸਮਰੱਥਾ ਵਧਾਓ।

ਇਸ ਨਮੂਨੇ ਵਿੱਚ ਦਰਸਾਇਆ ਗਿਆ ਹੈ:
- ਮੌਸਮ ਫੰਕਸ਼ਨ ਇੰਟੀਗ੍ਰੇਸ਼ਨ
- ਕੈਲਕੂਲੇਟਰ ਫੰਕਸ਼ਨ ਲਾਗੂ ਕਰਨਾ  
- ਇੱਕ ਗੱਲਬਾਤ ਵਿੱਚ ਕਈ ਫੰਕਸ਼ਨ ਕਾਲ
- JSON ਸਕੀਮਾਂ ਨਾਲ ਫੰਕਸ਼ਨ ਪਰਿਭਾਸ਼ਾ

### 3. ਰੀਟਰੀਵਲ-ਅਗਮੈਂਟਡ ਜਨਰੇਸ਼ਨ (RAG)  
**ਫਾਇਲ**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

ਆਪਣੇ ਦਸਤਾਵੇਜ਼ਾਂ ਅਤੇ ਡਾਟਾ ਸਰੋਤਾਂ ਨਾਲ AI ਨੂੰ ਜੋੜ ਕੇ ਸਹੀ ਅਤੇ ਸੰਦਰਭ-ਜਾਣੂ ਜਵਾਬ ਪ੍ਰਾਪਤ ਕਰਨ ਸਿੱਖੋ।

ਇਸ ਨਮੂਨੇ ਵਿੱਚ ਦਰਸਾਇਆ ਗਿਆ ਹੈ:
- Azure OpenAI SDK ਨਾਲ ਦਸਤਾਵੇਜ਼-ਅਧਾਰਿਤ ਪ੍ਰਸ਼ਨ ਉੱਤਰ
- GitHub ਮਾਡਲਾਂ ਨਾਲ RAG ਪੈਟਰਨ ਲਾਗੂ ਕਰਨਾ

**ਵਰਤੋਂ**: `document.txt` ਵਿੱਚ ਸਮੱਗਰੀ ਬਾਰੇ ਪ੍ਰਸ਼ਨ ਪੁੱਛੋ ਅਤੇ ਸਿਰਫ ਉਸ ਸੰਦਰਭ 'ਤੇ ਆਧਾਰਿਤ AI ਜਵਾਬ ਪ੍ਰਾਪਤ ਕਰੋ।

### 4. ਜ਼ਿੰਮੇਵਾਰ AI ਸੁਰੱਖਿਆ ਡੈਮੋ  
**ਫਾਇਲ**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

GitHub ਮਾਡਲਾਂ ਦੀ ਸਮੱਗਰੀ ਫਿਲਟਰੀੰਗ ਸਮਰੱਥਾ ਦੀ ਜਾਂਚ ਕਰਕੇ AI ਸੁਰੱਖਿਆ ਉਪਾਅਾਂ ਦਾ ਪੂਰਵ ਦਰਸ਼ਨ ਪ੍ਰਾਪਤ ਕਰੋ।

ਇਸ ਨਮੂਨੇ ਵਿੱਚ ਦਰਸਾਇਆ ਗਿਆ ਹੈ:
- ਸੰਭਾਵਿਤ ਹਾਨੀਕਾਰਕ ਪ੍ਰੋੰਪਟ ਲਈ ਸਮੱਗਰੀ ਫਿਲਟਰੀੰਗ
- ਐਪਲੀਕੇਸ਼ਨਾਂ ਵਿੱਚ ਸੁਰੱਖਿਆ ਜਵਾਬ ਸੰਭਾਲਣਾ
- ਰੋਕੀ ਗਈ ਸਮੱਗਰੀ ਦੇ ਵੱਖ-ਵੱਖ ਸ਼੍ਰੇਣੀਆਂ (ਹਿੰਸਾ, ਘ੍ਰਿਣਾ ਭਰਿਆ ਭਾਸ਼ਣ, ਗਲਤ ਜਾਣਕਾਰੀ)
- ਸੁਰੱਖਿਆ ਉਲੰਘਨਾਂ ਲਈ ਸਹੀ ਤਰੀਕੇ ਨਾਲ ਗਲਤੀ ਸੰਭਾਲਣਾ

> **ਹੋਰ ਜਾਣੋ**: ਇਹ ਜ਼ਿੰਮੇਵਾਰ AI ਸੰਕਲਪਾਂ ਦਾ ਸਿਰਫ਼ ਇੱਕ ਪਰਿਚਯ ਹੈ। ਨੈਤਿਕਤਾ, ਪੱਖਪਾਤ ਘਟਾਉਣ, ਗੋਪਨੀਯਤਾ ਦੇ ਵਿਚਾਰਾਂ, ਅਤੇ ਜ਼ਿੰਮੇਵਾਰ AI ਫਰੇਮਵਰਕਾਂ ਬਾਰੇ ਹੋਰ ਜਾਣਕਾਰੀ ਲਈ, [ਅਧਿਆਇ 5: ਜ਼ਿੰਮੇਵਾਰ ਜਨਰੇਟਿਵ AI](../05-ResponsibleGenAI/README.md) ਵੇਖੋ।

## ਸੰਖੇਪ

ਇਸ ਅਧਿਆਇ ਵਿੱਚ, ਅਸੀਂ LLM ਪੂਰਨ ਅਤੇ ਚੈਟ ਫਲੋਜ਼ ਦੀ ਪੜਚੋਲ ਕੀਤੀ, AI ਦੀ ਸਮਰੱਥਾ ਵਧਾਉਣ ਲਈ ਫੰਕਸ਼ਨ ਕਾਲਿੰਗ ਲਾਗੂ ਕੀਤੀ, ਰੀਟਰੀਵਲ-ਅਗਮੈਂਟਡ ਜਨਰੇਸ਼ਨ (RAG) ਸਿਸਟਮ ਬਣਾਇਆ, ਅਤੇ ਜ਼ਿੰਮੇਵਾਰ AI ਸੁਰੱਖਿਆ ਉਪਾਅਾਂ ਦਾ ਪ੍ਰਦਰਸ਼ਨ ਕੀਤਾ।

> **NOTE**: ਦਿੱਤੇ ਗਏ [**ਟਿਊਟੋਰਿਯਲ**](./TUTORIAL.md) ਨਾਲ ਹੋਰ ਡੂੰਘਾਈ ਵਿੱਚ ਜਾਓ।

## ਅਗਲੇ ਕਦਮ

[ਅਧਿਆਇ 4: ਵਿਹੰਗੀ ਪ੍ਰਯੋਗ ਅਤੇ ਪ੍ਰੋਜੈਕਟ](../04-PracticalSamples/README.md)

**ਅਸਵੀਕਾਰਨਾ**:  
ਇਹ ਦਸਤਾਵੇਜ਼ AI ਅਨੁਵਾਦ ਸੇਵਾ [Co-op Translator](https://github.com/Azure/co-op-translator) ਦੀ ਵਰਤੋਂ ਕਰਕੇ ਅਨੁਵਾਦ ਕੀਤਾ ਗਿਆ ਹੈ। ਜਦੋਂ ਕਿ ਅਸੀਂ ਸਹੀਤਾ ਲਈ ਯਤਨਸ਼ੀਲ ਹਾਂ, ਕਿਰਪਾ ਕਰਕੇ ਧਿਆਨ ਦਿਓ ਕਿ ਸਵੈਚਾਲਿਤ ਅਨੁਵਾਦਾਂ ਵਿੱਚ ਗਲਤੀਆਂ ਜਾਂ ਅਸੁਚਤਤਾਵਾਂ ਹੋ ਸਕਦੀਆਂ ਹਨ। ਮੂਲ ਦਸਤਾਵੇਜ਼ ਨੂੰ ਇਸਦੀ ਮੂਲ ਭਾਸ਼ਾ ਵਿੱਚ ਅਧਿਕਾਰਤ ਸਰੋਤ ਮੰਨਿਆ ਜਾਣਾ ਚਾਹੀਦਾ ਹੈ। ਮਹੱਤਵਪੂਰਨ ਜਾਣਕਾਰੀ ਲਈ, ਪੇਸ਼ੇਵਰ ਮਨੁੱਖੀ ਅਨੁਵਾਦ ਦੀ ਸਿਫਾਰਸ਼ ਕੀਤੀ ਜਾਂਦੀ ਹੈ। ਇਸ ਅਨੁਵਾਦ ਦੀ ਵਰਤੋਂ ਤੋਂ ਪੈਦਾ ਹੋਣ ਵਾਲੇ ਕਿਸੇ ਵੀ ਗਲਤਫਹਿਮੀ ਜਾਂ ਗਲਤ ਵਿਆਖਿਆ ਲਈ ਅਸੀਂ ਜ਼ਿੰਮੇਵਾਰ ਨਹੀਂ ਹਾਂ।