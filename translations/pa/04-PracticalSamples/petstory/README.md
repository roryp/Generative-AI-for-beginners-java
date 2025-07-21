<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "69dffd84127360d3f9446b89de471abe",
  "translation_date": "2025-07-21T18:31:39+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "pa"
}
-->
# ਪੈਟ ਸਟੋਰੀ ਐਪ

>**Note**: ਇਸ ਅਧਿਆਇ ਵਿੱਚ ਇੱਕ [**ਟਿਊਟੋਰਿਯਲ**](./TUTORIAL.md) ਸ਼ਾਮਲ ਹੈ ਜੋ ਤੁਹਾਨੂੰ ਤਿਆਰ ਨਮੂਨਿਆਂ ਨੂੰ ਚਲਾਉਣ ਦੀ ਪ੍ਰਕਿਰਿਆ ਦਿਖਾਉਂਦਾ ਹੈ।

ਇੱਕ ਸਪ੍ਰਿੰਗ ਬੂਟ ਵੈੱਬ ਐਪਲੀਕੇਸ਼ਨ ਜੋ GitHub ਮਾਡਲਾਂ ਦੀ ਵਰਤੋਂ ਕਰਕੇ ਅੱਪਲੋਡ ਕੀਤੀਆਂ ਪੈਟ ਤਸਵੀਰਾਂ ਲਈ AI-ਚਲਿਤ ਵਰਣਨ ਅਤੇ ਕਹਾਣੀਆਂ ਤਿਆਰ ਕਰਦਾ ਹੈ।

## ਸੂਚੀ

- [ਟੈਕਨੋਲੋਜੀ ਸਟੈਕ](../../../../04-PracticalSamples/petstory)
- [ਪੂਰਵ ਸ਼ਰਤਾਂ](../../../../04-PracticalSamples/petstory)
- [ਸੈਟਅੱਪ ਅਤੇ ਇੰਸਟਾਲੇਸ਼ਨ](../../../../04-PracticalSamples/petstory)
- [ਵਰਤੋਂ](../../../../04-PracticalSamples/petstory)

## ਟੈਕਨੋਲੋਜੀ ਸਟੈਕ

- **ਬੈਕਐਂਡ**: ਸਪ੍ਰਿੰਗ ਬੂਟ 3.5.3, ਜਾਵਾ 21  
- **AI ਇੰਟੀਗ੍ਰੇਸ਼ਨ**: OpenAI ਜਾਵਾ SDK ਨਾਲ GitHub ਮਾਡਲ  
- **ਸੁਰੱਖਿਆ**: ਸਪ੍ਰਿੰਗ ਸਿਕਿਊਰਿਟੀ  
- **ਫਰੰਟਐਂਡ**: ਥਾਈਮਲੀਫ ਟੈਂਪਲੇਟ ਬੂਟਸਟਰੈਪ ਸਟਾਈਲਿੰਗ ਨਾਲ  
- **ਬਿਲਡ ਟੂਲ**: Maven  
- **AI ਮਾਡਲ**: GitHub ਮਾਡਲ  

## ਪੂਰਵ ਸ਼ਰਤਾਂ

- ਜਾਵਾ 21 ਜਾਂ ਇਸ ਤੋਂ ਉੱਚਾ  
- Maven 3.9+  
- `models:read` ਸਕੋਪ ਵਾਲਾ GitHub ਪਰਸਨਲ ਐਕਸੈਸ ਟੋਕਨ  

## ਸੈਟਅੱਪ ਅਤੇ ਇੰਸਟਾਲੇਸ਼ਨ

### 1. ਪੈਟ ਸਟੋਰੀ ਐਪਲੀਕੇਸ਼ਨ ਡਾਇਰੈਕਟਰੀ ਵਿੱਚ ਜਾਓ  
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. ਵਾਤਾਵਰਣ ਵੈਰੀਏਬਲ ਸੈਟ ਕਰੋ  
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. ਐਪਲੀਕੇਸ਼ਨ ਬਿਲਡ ਕਰੋ  
```bash
mvn clean compile
```

### 4. ਐਪਲੀਕੇਸ਼ਨ ਚਲਾਓ  
```bash
mvn spring-boot:run
```

## ਵਰਤੋਂ

1. **ਐਪਲੀਕੇਸ਼ਨ ਐਕਸੈਸ ਕਰੋ**: `http://localhost:8080` 'ਤੇ ਜਾਓ  
2. **ਤਸਵੀਰ ਅੱਪਲੋਡ ਕਰੋ**: "Choose File" 'ਤੇ ਕਲਿਕ ਕਰੋ ਅਤੇ ਪੈਟ ਦੀ ਤਸਵੀਰ ਚੁਣੋ  
3. **ਤਸਵੀਰ ਦਾ ਵਿਸ਼ਲੇਸ਼ਣ ਕਰੋ**: "Analyze Image" 'ਤੇ ਕਲਿਕ ਕਰੋ ਤਾਂ ਜੋ AI ਵਰਣਨ ਪ੍ਰਾਪਤ ਹੋਵੇ  
4. **ਕਹਾਣੀ ਬਣਾਓ**: "Generate Story" 'ਤੇ ਕਲਿਕ ਕਰੋ ਤਾਂ ਜੋ ਕਹਾਣੀ ਤਿਆਰ ਹੋਵੇ  

**ਅਸਵੀਕਰਤੀ**:  
ਇਹ ਦਸਤਾਵੇਜ਼ AI ਅਨੁਵਾਦ ਸੇਵਾ [Co-op Translator](https://github.com/Azure/co-op-translator) ਦੀ ਵਰਤੋਂ ਕਰਕੇ ਅਨੁਵਾਦ ਕੀਤਾ ਗਿਆ ਹੈ। ਜਦੋਂ ਕਿ ਅਸੀਂ ਸਹੀ ਹੋਣ ਦਾ ਯਤਨ ਕਰਦੇ ਹਾਂ, ਕਿਰਪਾ ਕਰਕੇ ਧਿਆਨ ਦਿਓ ਕਿ ਸਵੈਚਾਲਿਤ ਅਨੁਵਾਦਾਂ ਵਿੱਚ ਗਲਤੀਆਂ ਜਾਂ ਅਸੁਣੀਕਤਾਵਾਂ ਹੋ ਸਕਦੀਆਂ ਹਨ। ਇਸ ਦੀ ਮੂਲ ਭਾਸ਼ਾ ਵਿੱਚ ਮੌਜੂਦ ਅਸਲ ਦਸਤਾਵੇਜ਼ ਨੂੰ ਅਧਿਕਾਰਤ ਸਰੋਤ ਮੰਨਿਆ ਜਾਣਾ ਚਾਹੀਦਾ ਹੈ। ਮਹੱਤਵਪੂਰਨ ਜਾਣਕਾਰੀ ਲਈ, ਪੇਸ਼ੇਵਰ ਮਨੁੱਖੀ ਅਨੁਵਾਦ ਦੀ ਸਿਫਾਰਸ਼ ਕੀਤੀ ਜਾਂਦੀ ਹੈ। ਇਸ ਅਨੁਵਾਦ ਦੀ ਵਰਤੋਂ ਤੋਂ ਪੈਦਾ ਹੋਣ ਵਾਲੇ ਕਿਸੇ ਵੀ ਗਲਤਫਹਿਮੀ ਜਾਂ ਗਲਤ ਵਿਆਖਿਆ ਲਈ ਅਸੀਂ ਜ਼ਿੰਮੇਵਾਰ ਨਹੀਂ ਹਾਂ।