<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T09:19:40+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "pa"
}
-->
# ਪੈਟ ਸਟੋਰੀ ਐਪ

>**Note**: ਇਸ ਅਧਿਆਇ ਵਿੱਚ ਇੱਕ [**ਟਿਊਟੋਰਿਯਲ**](./TUTORIAL.md) ਸ਼ਾਮਲ ਹੈ ਜੋ ਤੁਹਾਨੂੰ ਨਮੂਨਿਆਂ ਦੇ ਜਰੀਏ ਗਾਈਡ ਕਰਦਾ ਹੈ।

ਇੱਕ ਸਪ੍ਰਿੰਗ ਬੂਟ ਵੈੱਬ ਐਪਲੀਕੇਸ਼ਨ ਜੋ GitHub ਮਾਡਲਾਂ ਦੀ ਵਰਤੋਂ ਕਰਕੇ ਅੱਪਲੋਡ ਕੀਤੀਆਂ ਪੈਟ ਤਸਵੀਰਾਂ ਲਈ AI-ਚਲਿਤ ਵਰਣਨ ਅਤੇ ਕਹਾਣੀਆਂ ਤਿਆਰ ਕਰਦਾ ਹੈ।

## ਸਮੱਗਰੀ ਦੀ ਸੂਚੀ

- [ਟੈਕਨੋਲੋਜੀ ਸਟੈਕ](../../../../04-PracticalSamples/petstory)
- [ਪੂਰਵ ਸ਼ਰਤਾਂ](../../../../04-PracticalSamples/petstory)
- [ਸੈਟਅਪ ਅਤੇ ਇੰਸਟਾਲੇਸ਼ਨ](../../../../04-PracticalSamples/petstory)
- [ਵਰਤੋਂ](../../../../04-PracticalSamples/petstory)

## ਟੈਕਨੋਲੋਜੀ ਸਟੈਕ

- **ਬੈਕਐਂਡ**: ਸਪ੍ਰਿੰਗ ਬੂਟ 3.5.3, ਜਾਵਾ 21
- **AI ਇੰਟੀਗ੍ਰੇਸ਼ਨ**: OpenAI ਜਾਵਾ SDK ਨਾਲ GitHub ਮਾਡਲ
- **ਸੁਰੱਖਿਆ**: ਸਪ੍ਰਿੰਗ ਸੁਰੱਖਿਆ
- **ਫਰੰਟਐਂਡ**: Thymeleaf ਟੈਂਪਲੇਟ Bootstrap ਸਟਾਈਲਿੰਗ ਨਾਲ
- **ਬਿਲਡ ਟੂਲ**: Maven
- **AI ਮਾਡਲ**: GitHub ਮਾਡਲ

## ਪੂਰਵ ਸ਼ਰਤਾਂ

- ਜਾਵਾ 21 ਜਾਂ ਇਸ ਤੋਂ ਉੱਚਾ
- Maven 3.9+
- `models:read` ਸਕੋਪ ਵਾਲਾ GitHub ਪर्सਨਲ ਐਕਸੈਸ ਟੋਕਨ

## ਸੈਟਅਪ ਅਤੇ ਇੰਸਟਾਲੇਸ਼ਨ

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

### 3. ਐਪਲੀਕੇਸ਼ਨ ਬਣਾਓ
```bash
mvn clean compile
```

### 4. ਐਪਲੀਕੇਸ਼ਨ ਚਲਾਓ
```bash
mvn spring-boot:run
```

## ਵਰਤੋਂ

1. **ਐਪਲੀਕੇਸ਼ਨ ਤੱਕ ਪਹੁੰਚ ਕਰੋ**: `http://localhost:8080` ਤੇ ਜਾਓ
2. **ਤਸਵੀਰ ਅੱਪਲੋਡ ਕਰੋ**: "Choose File" 'ਤੇ ਕਲਿਕ ਕਰੋ ਅਤੇ ਪੈਟ ਤਸਵੀਰ ਚੁਣੋ
3. **ਤਸਵੀਰ ਦਾ ਵਿਸ਼ਲੇਸ਼ਣ ਕਰੋ**: "Analyze Image" 'ਤੇ ਕਲਿਕ ਕਰੋ ਤਾਂ ਜੋ AI ਵਰਣਨ ਪ੍ਰਾਪਤ ਹੋਵੇ
4. **ਕਹਾਣੀ ਬਣਾਓ**: "Generate Story" 'ਤੇ ਕਲਿਕ ਕਰੋ ਤਾਂ ਜੋ ਕਹਾਣੀ ਤਿਆਰ ਹੋਵੇ

**ਅਸਵੀਕਾਰਨਾ**:  
ਇਹ ਦਸਤਾਵੇਜ਼ AI ਅਨੁਵਾਦ ਸੇਵਾ [Co-op Translator](https://github.com/Azure/co-op-translator) ਦੀ ਵਰਤੋਂ ਕਰਕੇ ਅਨੁਵਾਦ ਕੀਤਾ ਗਿਆ ਹੈ। ਜਦੋਂ ਕਿ ਅਸੀਂ ਸਹੀਤਾ ਲਈ ਯਤਨਸ਼ੀਲ ਹਾਂ, ਕਿਰਪਾ ਕਰਕੇ ਧਿਆਨ ਦਿਓ ਕਿ ਸਵੈਚਾਲਿਤ ਅਨੁਵਾਦਾਂ ਵਿੱਚ ਗਲਤੀਆਂ ਜਾਂ ਅਸੁਚੀਤਤਾਵਾਂ ਹੋ ਸਕਦੀਆਂ ਹਨ। ਮੂਲ ਦਸਤਾਵੇਜ਼ ਨੂੰ ਇਸਦੀ ਮੂਲ ਭਾਸ਼ਾ ਵਿੱਚ ਅਧਿਕਾਰਤ ਸਰੋਤ ਮੰਨਿਆ ਜਾਣਾ ਚਾਹੀਦਾ ਹੈ। ਮਹੱਤਵਪੂਰਨ ਜਾਣਕਾਰੀ ਲਈ, ਪੇਸ਼ੇਵਰ ਮਨੁੱਖੀ ਅਨੁਵਾਦ ਦੀ ਸਿਫਾਰਸ਼ ਕੀਤੀ ਜਾਂਦੀ ਹੈ। ਇਸ ਅਨੁਵਾਦ ਦੀ ਵਰਤੋਂ ਤੋਂ ਪੈਦਾ ਹੋਣ ਵਾਲੇ ਕਿਸੇ ਵੀ ਗਲਤਫਹਿਮੀ ਜਾਂ ਗਲਤ ਵਿਆਖਿਆ ਲਈ ਅਸੀਂ ਜ਼ਿੰਮੇਵਾਰ ਨਹੀਂ ਹਾਂ।