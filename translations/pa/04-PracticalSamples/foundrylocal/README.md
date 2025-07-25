<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "d064108b2142d32246ccbd8a42e76b4d",
  "translation_date": "2025-07-25T09:18:24+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "pa"
}
-->
# Foundry Local ਕਮਾਂਡ-ਲਾਈਨ ਐਪਲੀਕੇਸ਼ਨ

>**Note**: ਇਸ ਅਧਿਆਇ ਵਿੱਚ ਇੱਕ [**Tutorial**](./TUTORIAL.md) ਸ਼ਾਮਲ ਹੈ ਜੋ ਤੁਹਾਨੂੰ ਨਮੂਨਿਆਂ ਦੇ ਜਰੀਏ ਗਾਈਡ ਕਰਦਾ ਹੈ।

ਇੱਕ ਸਧਾਰਨ Spring Boot ਕਮਾਂਡ-ਲਾਈਨ ਐਪਲੀਕੇਸ਼ਨ ਜੋ ਦਿਖਾਉਂਦਾ ਹੈ ਕਿ OpenAI Java SDK ਦੀ ਵਰਤੋਂ ਕਰਕੇ Foundry Local ਨਾਲ ਕਿਵੇਂ ਜੁੜਨਾ ਹੈ।

## ਤੁਸੀਂ ਕੀ ਸਿੱਖੋਗੇ

- Spring Boot ਐਪਲੀਕੇਸ਼ਨਜ਼ ਨੂੰ OpenAI Java SDK ਦੀ ਵਰਤੋਂ ਕਰਕੇ Foundry Local ਨਾਲ ਕਿਵੇਂ ਇੰਟੀਗਰੇਟ ਕਰਨਾ ਹੈ
- ਸਥਾਨਕ AI ਵਿਕਾਸ ਅਤੇ ਟੈਸਟਿੰਗ ਲਈ ਵਧੀਆ ਤਰੀਕੇ

## ਸੂਚੀ

- [ਤੁਸੀਂ ਕੀ ਸਿੱਖੋਗੇ](../../../../04-PracticalSamples/foundrylocal)
- [ਪੂਰਵ ਸ਼ਰਤਾਂ](../../../../04-PracticalSamples/foundrylocal)
  - [Foundry Local ਇੰਸਟਾਲ ਕਰਨਾ](../../../../04-PracticalSamples/foundrylocal)
  - [ਪ੍ਰਮਾਣਿਕਤਾ](../../../../04-PracticalSamples/foundrylocal)
- [ਕੰਫਿਗਰੇਸ਼ਨ](../../../../04-PracticalSamples/foundrylocal)
- [ਤੁਰੰਤ ਸ਼ੁਰੂਆਤ](../../../../04-PracticalSamples/foundrylocal)
- [ਐਪਲੀਕੇਸ਼ਨ ਕੀ ਕਰਦਾ ਹੈ](../../../../04-PracticalSamples/foundrylocal)
- [ਨਮੂਨਾ ਆਉਟਪੁੱਟ](../../../../04-PracticalSamples/foundrylocal)
- [ਆਰਕੀਟੈਕਚਰ](../../../../04-PracticalSamples/foundrylocal)
- [ਕੋਡ ਹਾਈਲਾਈਟਸ](../../../../04-PracticalSamples/foundrylocal)
  - [OpenAI Java SDK ਇੰਟੀਗਰੇਸ਼ਨ](../../../../04-PracticalSamples/foundrylocal)
  - [ਚੈਟ ਕੰਪਲੀਸ਼ਨ API](../../../../04-PracticalSamples/foundrylocal)
- [ਟ੍ਰਬਲਸ਼ੂਟਿੰਗ](../../../../04-PracticalSamples/foundrylocal)

## ਪੂਰਵ ਸ਼ਰਤਾਂ

> **⚠️ Note**: ਇਹ ਐਪਲੀਕੇਸ਼ਨ **ਦਿੱਤੇ ਗਏ devcontainer ਵਿੱਚ ਨਹੀਂ ਚਲਦਾ** ਕਿਉਂਕਿ ਇਸਨੂੰ Foundry Local ਨੂੰ ਹੋਸਟ ਸਿਸਟਮ 'ਤੇ ਇੰਸਟਾਲ ਅਤੇ ਚਲਾਉਣ ਦੀ ਲੋੜ ਹੈ।

### Foundry Local ਇੰਸਟਾਲ ਕਰਨਾ

ਇਸ ਐਪਲੀਕੇਸ਼ਨ ਨੂੰ ਚਲਾਉਣ ਤੋਂ ਪਹਿਲਾਂ, ਤੁਹਾਨੂੰ Foundry Local ਨੂੰ ਇੰਸਟਾਲ ਅਤੇ ਸ਼ੁਰੂ ਕਰਨ ਦੀ ਲੋੜ ਹੈ। ਹੇਠਾਂ ਦਿੱਤੇ ਕਦਮਾਂ ਦੀ ਪਾਲਣਾ ਕਰੋ:

1. **ਸੁਨਿਸ਼ਚਿਤ ਕਰੋ ਕਿ ਤੁਹਾਡਾ ਸਿਸਟਮ ਲੋੜਾਂ ਨੂੰ ਪੂਰਾ ਕਰਦਾ ਹੈ**:
   - **ਓਪਰੇਟਿੰਗ ਸਿਸਟਮ**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025, ਜਾਂ macOS
   - **ਹਾਰਡਵੇਅਰ**: 
     - ਘੱਟੋ-ਘੱਟ: 8GB RAM, 3GB ਖਾਲੀ ਡਿਸਕ ਸਪੇਸ
     - ਸਿਫਾਰਸ਼ੀ: 16GB RAM, 15GB ਖਾਲੀ ਡਿਸਕ ਸਪੇਸ
   - **ਨੈਟਵਰਕ**: ਸ਼ੁਰੂਆਤੀ ਮਾਡਲ ਡਾਊਨਲੋਡ ਲਈ ਇੰਟਰਨੈਟ ਕਨੈਕਸ਼ਨ (ਆਫਲਾਈਨ ਵਰਤੋਂ ਲਈ ਵਿਕਲਪਿਕ)
   - **ਐਕਸਲੇਰੇਸ਼ਨ (ਵਿਕਲਪਿਕ)**: NVIDIA GPU (2,000 ਸੀਰੀਜ਼ ਜਾਂ ਨਵਾਂ), AMD GPU (6,000 ਸੀਰੀਜ਼ ਜਾਂ ਨਵਾਂ), Qualcomm Snapdragon X Elite (8GB ਜਾਂ ਵੱਧ ਮੈਮੋਰੀ), ਜਾਂ Apple silicon
   - **ਪ੍ਰਮਾਣਿਕਤਾ**: ਤੁਹਾਡੇ ਡਿਵਾਈਸ 'ਤੇ ਸੌਫਟਵੇਅਰ ਇੰਸਟਾਲ ਕਰਨ ਲਈ ਪ੍ਰਸ਼ਾਸਕੀ ਅਧਿਕਾਰ

2. **Foundry Local ਇੰਸਟਾਲ ਕਰੋ**:
   
   **Windows ਲਈ:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **macOS ਲਈ:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   ਵਿਕਲਪਕ ਤੌਰ 'ਤੇ, ਤੁਸੀਂ [Foundry Local GitHub ਰਿਪੋਜ਼ਟਰੀ](https://github.com/microsoft/Foundry-Local) ਤੋਂ ਇੰਸਟਾਲਰ ਡਾਊਨਲੋਡ ਕਰ ਸਕਦੇ ਹੋ।

3. **ਆਪਣਾ ਪਹਿਲਾ ਮਾਡਲ ਸ਼ੁਰੂ ਕਰੋ**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   ਮਾਡਲ ਡਾਊਨਲੋਡ ਹੁੰਦਾ ਹੈ (ਇਹ ਤੁਹਾਡੇ ਇੰਟਰਨੈਟ ਦੀ ਗਤੀ 'ਤੇ ਨਿਰਭਰ ਕਰਦਾ ਹੈ ਅਤੇ ਕੁਝ ਮਿੰਟ ਲੈ ਸਕਦਾ ਹੈ) ਅਤੇ ਫਿਰ ਚਲਦਾ ਹੈ। Foundry Local ਤੁਹਾਡੇ ਸਿਸਟਮ ਲਈ ਸਬ ਤੋਂ ਵਧੀਆ ਮਾਡਲ ਵੈਰੀਐਂਟ (CUDA NVIDIA GPUs ਲਈ, CPU ਵਰਜਨ ਨਹੀਂ ਤਾਂ) ਆਟੋਮੈਟਿਕ ਤੌਰ 'ਤੇ ਚੁਣਦਾ ਹੈ।

4. **ਮਾਡਲ ਦੀ ਜਾਂਚ ਕਰੋ** ਇੱਕੋ ਟਰਮੀਨਲ ਵਿੱਚ ਸਵਾਲ ਪੁੱਛ ਕੇ:

   ```bash
   Why is the sky blue?
   ```

   ਤੁਹਾਨੂੰ Phi ਮਾਡਲ ਤੋਂ ਇੱਕ ਜਵਾਬ ਮਿਲਣਾ ਚਾਹੀਦਾ ਹੈ ਜੋ ਸਮਝਾਉਂਦਾ ਹੈ ਕਿ ਅਸਮਾਨ ਨੀਲਾ ਕਿਉਂ ਦਿਖਾਈ ਦਿੰਦਾ ਹੈ।

### ਪ੍ਰਮਾਣਿਕਤਾ

ਤੁਸੀਂ ਹੇਠਾਂ ਦਿੱਤੇ ਕਮਾਂਡਾਂ ਨਾਲ ਸਭ ਕੁਝ ਸਹੀ ਤਰੀਕੇ ਨਾਲ ਚੱਲ ਰਿਹਾ ਹੈ ਜਾਂ ਨਹੀਂ, ਇਹ ਪ੍ਰਮਾਣਿਤ ਕਰ ਸਕਦੇ ਹੋ:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

ਤੁਸੀਂ `http://localhost:5273` ਨੂੰ ਆਪਣੇ ਬ੍ਰਾਊਜ਼ਰ ਵਿੱਚ ਵੀ ਵੇਖ ਸਕਦੇ ਹੋ Foundry Local ਵੈਬ ਇੰਟਰਫੇਸ ਦੇਖਣ ਲਈ।

## ਕੰਫਿਗਰੇਸ਼ਨ

ਐਪਲੀਕੇਸ਼ਨ ਨੂੰ `application.properties` ਰਾਹੀਂ ਕਨਫਿਗਰ ਕੀਤਾ ਜਾ ਸਕਦਾ ਹੈ:

- `foundry.local.base-url` - Foundry Local ਲਈ ਬੇਸ URL (ਡਿਫਾਲਟ: http://localhost:5273)
- `foundry.local.model` - ਵਰਤਣ ਲਈ AI ਮਾਡਲ (ਡਿਫਾਲਟ: Phi-3.5-mini-instruct-cuda-gpu)

> **Note**: ਕੰਫਿਗਰੇਸ਼ਨ ਵਿੱਚ ਮਾਡਲ ਦਾ ਨਾਮ Foundry Local ਦੁਆਰਾ ਤੁਹਾਡੇ ਸਿਸਟਮ ਲਈ ਡਾਊਨਲੋਡ ਕੀਤੇ ਗਏ ਖਾਸ ਵੈਰੀਐਂਟ ਨਾਲ ਮੇਲ ਖਾਣਾ ਚਾਹੀਦਾ ਹੈ। ਜਦੋਂ ਤੁਸੀਂ `foundry model run phi-3.5-mini` ਚਲਾਉਂਦੇ ਹੋ, Foundry Local ਆਟੋਮੈਟਿਕ ਤੌਰ 'ਤੇ ਸਭ ਤੋਂ ਵਧੀਆ ਵੈਰੀਐਂਟ ਚੁਣਦਾ ਹੈ ਅਤੇ ਡਾਊਨਲੋਡ ਕਰਦਾ ਹੈ (CUDA NVIDIA GPUs ਲਈ, CPU ਵਰਜਨ ਨਹੀਂ ਤਾਂ)। `foundry model list` ਚਲਾਕੇ ਆਪਣੇ ਸਥਾਨਕ ਇੰਸਟੈਂਸ ਵਿੱਚ ਉਪਲਬਧ ਖਾਸ ਮਾਡਲ ਨਾਮ ਵੇਖੋ।

## ਤੁਰੰਤ ਸ਼ੁਰੂਆਤ

### 1. Foundry Local ਐਪਲੀਕੇਸ਼ਨ ਡਾਇਰੈਕਟਰੀ ਵਿੱਚ ਜਾਓ
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. ਐਪਲੀਕੇਸ਼ਨ ਚਲਾਓ

```bash
mvn spring-boot:run
```

ਜਾਂ JAR ਬਣਾਓ ਅਤੇ ਚਲਾਓ:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Dependencies

ਇਹ ਐਪਲੀਕੇਸ਼ਨ Foundry Local ਨਾਲ ਸੰਚਾਰ ਕਰਨ ਲਈ OpenAI Java SDK ਦੀ ਵਰਤੋਂ ਕਰਦਾ ਹੈ। ਮੁੱਖ ਡਿਪੈਂਡੈਂਸੀ ਹੈ:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

ਐਪਲੀਕੇਸ਼ਨ ਡਿਫਾਲਟ ਪੋਰਟ 'ਤੇ ਚੱਲ ਰਹੇ Foundry Local ਨਾਲ ਜੁੜਨ ਲਈ ਪਹਿਲਾਂ ਤੋਂ ਕਨਫਿਗਰ ਕੀਤਾ ਗਿਆ ਹੈ।

## ਐਪਲੀਕੇਸ਼ਨ ਕੀ ਕਰਦਾ ਹੈ

ਜਦੋਂ ਤੁਸੀਂ ਐਪਲੀਕੇਸ਼ਨ ਚਲਾਉਂਦੇ ਹੋ:

1. **ਕਮਾਂਡ-ਲਾਈਨ ਐਪਲੀਕੇਸ਼ਨ ਵਜੋਂ ਸ਼ੁਰੂ ਹੁੰਦਾ ਹੈ** (ਕੋਈ ਵੈਬ ਸਰਵਰ ਨਹੀਂ)
2. **ਆਟੋਮੈਟਿਕ ਤੌਰ 'ਤੇ ਇੱਕ ਟੈਸਟ ਸੁਨੇਹਾ ਭੇਜਦਾ ਹੈ**: "ਹੈਲੋ! ਕੀ ਤੁਸੀਂ ਦੱਸ ਸਕਦੇ ਹੋ ਕਿ ਤੁਸੀਂ ਕੀ ਹੋ ਅਤੇ ਤੁਸੀਂ ਕਿਹੜਾ ਮਾਡਲ ਚਲਾ ਰਹੇ ਹੋ?"
3. **Foundry Local ਤੋਂ ਜਵਾਬ ਕਨਸੋਲ ਵਿੱਚ ਦਿਖਾਉਂਦਾ ਹੈ**
4. **ਡੈਮੋ ਦੇ ਬਾਅਦ ਸਾਫ਼ ਤਰੀਕੇ ਨਾਲ ਬੰਦ ਹੁੰਦਾ ਹੈ**

## ਨਮੂਨਾ ਆਉਟਪੁੱਟ

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## ਆਰਕੀਟੈਕਚਰ

- **Application.java** - ਮੁੱਖ Spring Boot ਐਪਲੀਕੇਸ਼ਨ CommandLineRunner ਨਾਲ
- **FoundryLocalService.java** - ਸੇਵਾ ਜੋ OpenAI Java SDK ਦੀ ਵਰਤੋਂ ਕਰਕੇ Foundry Local ਨਾਲ ਸੰਚਾਰ ਕਰਦੀ ਹੈ
- **OpenAI Java SDK** ਦੀ ਵਰਤੋਂ ਟਾਈਪ-ਸੇਫ API ਕਾਲਾਂ ਲਈ
- SDK ਦੁਆਰਾ ਆਟੋਮੈਟਿਕ JSON ਸੀਰੀਅਲਾਈਜ਼ੇਸ਼ਨ/ਡੀਸੀਰੀਅਲਾਈਜ਼ੇਸ਼ਨ
- Spring ਦੇ `@Value` ਅਤੇ `@PostConstruct` ਐਨੋਟੇਸ਼ਨ ਦੀ ਵਰਤੋਂ ਕਰਕੇ ਸਾਫ਼ ਕੰਫਿਗਰੇਸ਼ਨ

## ਕੋਡ ਹਾਈਲਾਈਟਸ

### OpenAI Java SDK ਇੰਟੀਗਰੇਸ਼ਨ

ਐਪਲੀਕੇਸ਼ਨ OpenAI Java SDK ਦੀ ਵਰਤੋਂ ਕਰਦਾ ਹੈ ਇੱਕ ਕਲਾਇੰਟ ਬਣਾਉਣ ਲਈ ਜੋ Foundry Local ਲਈ ਕਨਫਿਗਰ ਕੀਤਾ ਗਿਆ ਹੈ:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### ਚੈਟ ਕੰਪਲੀਸ਼ਨ API

ਚੈਟ ਕੰਪਲੀਸ਼ਨ ਰਿਕਵੈਸਟ ਕਰਨਾ ਸਧਾਰਨ ਅਤੇ ਟਾਈਪ-ਸੇਫ ਹੈ:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## ਟ੍ਰਬਲਸ਼ੂਟਿੰਗ

ਜੇ ਤੁਸੀਂ ਕਨੈਕਸ਼ਨ ਐਰਰ ਦੇਖਦੇ ਹੋ:
1. ਯਕੀਨੀ ਬਣਾਓ ਕਿ Foundry Local `http://localhost:5273` 'ਤੇ ਚੱਲ ਰਿਹਾ ਹੈ
2. ਜਾਂਚ ਕਰੋ ਕਿ `foundry model list` ਨਾਲ ਇੱਕ Phi-3.5-mini ਮਾਡਲ ਵੈਰੀਐਂਟ ਉਪਲਬਧ ਹੈ
3. ਯਕੀਨੀ ਬਣਾਓ ਕਿ `application.properties` ਵਿੱਚ ਮਾਡਲ ਦਾ ਨਾਮ ਸੂਚੀ ਵਿੱਚ ਦਿਖਾਏ ਗਏ ਖਾਸ ਮਾਡਲ ਨਾਮ ਨਾਲ ਮੇਲ ਖਾਂਦਾ ਹੈ
4. ਯਕੀਨੀ ਬਣਾਓ ਕਿ ਕੋਈ ਫਾਇਰਵਾਲ ਕਨੈਕਸ਼ਨ ਨੂੰ ਰੋਕ ਨਹੀਂ ਰਿਹਾ

ਆਮ ਸਮੱਸਿਆਵਾਂ:
- **ਮਾਡਲ ਨਹੀਂ ਮਿਲਿਆ**: `foundry model run phi-3.5-mini` ਚਲਾਕੇ ਮਾਡਲ ਡਾਊਨਲੋਡ ਅਤੇ ਸ਼ੁਰੂ ਕਰੋ
- **ਸੇਵਾ ਚੱਲ ਨਹੀਂ ਰਹੀ**: Foundry Local ਸੇਵਾ ਰੁਕ ਗਈ ਹੋ ਸਕਦੀ ਹੈ; ਇਸਨੂੰ ਮਾਡਲ ਰਨ ਕਮਾਂਡ ਨਾਲ ਮੁੜ ਸ਼ੁਰੂ ਕਰੋ
- **ਗਲਤ ਮਾਡਲ ਨਾਮ**: ਉਪਲਬਧ ਮਾਡਲ ਵੇਖਣ ਲਈ `foundry model list` ਦੀ ਵਰਤੋਂ ਕਰੋ ਅਤੇ ਆਪਣੀ ਕੰਫਿਗਰੇਸ਼ਨ ਨੂੰ ਅਨੁਕੂਲ ਬਣਾਓ

**ਅਸਵੀਕਰਤੀ**:  
ਇਹ ਦਸਤਾਵੇਜ਼ AI ਅਨੁਵਾਦ ਸੇਵਾ [Co-op Translator](https://github.com/Azure/co-op-translator) ਦੀ ਵਰਤੋਂ ਕਰਕੇ ਅਨੁਵਾਦ ਕੀਤਾ ਗਿਆ ਹੈ। ਜਦੋਂ ਕਿ ਅਸੀਂ ਸਹੀ ਹੋਣ ਦੀ ਕੋਸ਼ਿਸ਼ ਕਰਦੇ ਹਾਂ, ਕਿਰਪਾ ਕਰਕੇ ਧਿਆਨ ਦਿਓ ਕਿ ਸਵੈਚਾਲਿਤ ਅਨੁਵਾਦਾਂ ਵਿੱਚ ਗਲਤੀਆਂ ਜਾਂ ਅਸੁਣੀਕਤਾਵਾਂ ਹੋ ਸਕਦੀਆਂ ਹਨ। ਮੂਲ ਦਸਤਾਵੇਜ਼ ਨੂੰ ਇਸਦੀ ਮੂਲ ਭਾਸ਼ਾ ਵਿੱਚ ਅਧਿਕਾਰਤ ਸਰੋਤ ਮੰਨਿਆ ਜਾਣਾ ਚਾਹੀਦਾ ਹੈ। ਮਹੱਤਵਪੂਰਨ ਜਾਣਕਾਰੀ ਲਈ, ਪੇਸ਼ੇਵਰ ਮਨੁੱਖੀ ਅਨੁਵਾਦ ਦੀ ਸਿਫਾਰਸ਼ ਕੀਤੀ ਜਾਂਦੀ ਹੈ। ਇਸ ਅਨੁਵਾਦ ਦੀ ਵਰਤੋਂ ਤੋਂ ਪੈਦਾ ਹੋਣ ਵਾਲੇ ਕਿਸੇ ਵੀ ਗਲਤਫਹਿਮੀ ਜਾਂ ਗਲਤ ਵਿਆਖਿਆ ਲਈ ਅਸੀਂ ਜ਼ਿੰਮੇਵਾਰ ਨਹੀਂ ਹਾਂ।