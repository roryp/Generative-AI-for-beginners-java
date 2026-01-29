# Azure OpenAI తో బేసిక్ చాట్ - ఎండ్-టు-ఎండ్ ఉదాహరణ

ఈ ఉదాహరణ Azure OpenAI కి కనెక్ట్ అయ్యే సింపుల్ స్ప్రింగ్ బూట్ అప్లికేషన్‌ను ఎలా సృష్టించాలో మరియు మీ సెటప్‌ను పరీక్షించాలో చూపిస్తుంది.

## విషయ సూచిక

- [ముందస్తు అవసరాలు](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [త్వరిత ప్రారంభం](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [కాన్ఫిగరేషన్ ఎంపికలు](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [ఎంపిక 1: ఎన్విరాన్‌మెంట్ వేరియబుల్స్ (.env ఫైల్) - సిఫార్సు](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [ఎంపిక 2: GitHub కోడ్స్‌పేస్ సీక్రెట్స్](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [అప్లికేషన్ నడపడం](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [మేవెన్ ఉపయోగించడం](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [VS కోడ్ ఉపయోగించడం](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [అంచనా ఫలితాలు](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [కాన్ఫిగరేషన్ రిఫరెన్స్](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [ఎన్విరాన్‌మెంట్ వేరియబుల్స్](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [స్ప్రింగ్ కాన్ఫిగరేషన్](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [ట్రబుల్‌షూటింగ్](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [సాధారణ సమస్యలు](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [డీబగ్ మోడ్](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [తదుపరి దశలు](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [వనరులు](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## ముందస్తు అవసరాలు

ఈ ఉదాహరణను నడిపే ముందు, మీరు ఈ క్రింది వాటిని పూర్తి చేసి ఉండాలి:

- [Azure OpenAI సెటప్ గైడ్](../../getting-started-azure-openai.md) పూర్తి చేయండి  
- Azure OpenAI రిసోర్స్‌ను (Azure AI Foundry పోర్టల్ ద్వారా) డిప్లాయ్ చేయండి  
- gpt-4o-mini మోడల్ (లేదా ప్రత్యామ్నాయం) డిప్లాయ్ చేయండి  
- Azure నుండి API కీ మరియు ఎండ్‌పాయింట్ URL పొందండి  

## త్వరిత ప్రారంభం

```bash
# 1. ప్రాజెక్ట్‌కు నావిగేట్ చేయండి
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. క్రెడెన్షియల్స్‌ను కాన్ఫిగర్ చేయండి
cp .env.example .env
# మీ Azure OpenAI క్రెడెన్షియల్స్‌తో .env ను సవరించండి

# 3. అప్లికేషన్‌ను రన్ చేయండి
mvn spring-boot:run
```

## కాన్ఫిగరేషన్ ఎంపికలు

### ఎంపిక 1: ఎన్విరాన్‌మెంట్ వేరియబుల్స్ (.env ఫైల్) - సిఫార్సు

**దశ 1: మీ కాన్ఫిగరేషన్ ఫైల్ సృష్టించండి**
```bash
cp .env.example .env
```

**దశ 2: మీ Azure OpenAI క్రెడెన్షియల్స్ జోడించండి**
```bash
# మీ Azure OpenAI API కీ (Azure AI Foundry పోర్టల్ నుండి)
AZURE_AI_KEY=your-actual-api-key-here

# మీ Azure OpenAI ఎండ్‌పాయింట్ URL (ఉదా., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **భద్రతా గమనిక**: 
> - మీ `.env` ఫైల్‌ను వెర్షన్ కంట్రోల్‌కు ఎప్పుడూ కమిట్ చేయవద్దు
> - `.env` ఫైల్ ఇప్పటికే `.gitignore` లో ఉంది
> - మీ API కీలు సురక్షితంగా ఉంచండి మరియు వాటిని తరచుగా రొటేట్ చేయండి

### ఎంపిక 2: GitHub కోడ్స్‌పేస్ సీక్రెట్స్

GitHub కోడ్స్‌పేస్‌ల కోసం, ఈ సీక్రెట్స్‌ను మీ రిపోజిటరీలో సెట్ చేయండి:
- `AZURE_AI_KEY` - మీ Azure OpenAI API కీ
- `AZURE_AI_ENDPOINT` - మీ Azure OpenAI ఎండ్‌పాయింట్ URL

అప్లికేషన్ ఈ సీక్రెట్స్‌ను ఆటోమేటిక్‌గా గుర్తించి ఉపయోగిస్తుంది.

### ప్రత్యామ్నాయం: డైరెక్ట్ ఎన్విరాన్‌మెంట్ వేరియబుల్స్

<details>
<summary>ప్లాట్‌ఫారమ్-స్పెసిఫిక్ కమాండ్లను చూడటానికి క్లిక్ చేయండి</summary>

**Linux/macOS (bash/zsh):**
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (కమాండ్ ప్రాంప్ట్):**
```cmd
set AZURE_AI_KEY=your-actual-api-key-here
set AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (పవర్‌షెల్):**
```powershell
$env:AZURE_AI_KEY="your-actual-api-key-here"
$env:AZURE_AI_ENDPOINT="https://your-hub-name.openai.azure.com/"
```
</details>

## అప్లికేషన్ నడపడం

### మేవెన్ ఉపయోగించడం

```bash
mvn spring-boot:run
```

### VS కోడ్ ఉపయోగించడం

1. ప్రాజెక్ట్‌ను VS కోడ్‌లో ఓపెన్ చేయండి  
2. `F5` నొక్కండి లేదా "Run and Debug" ప్యానెల్‌ను ఉపయోగించండి  
3. "Spring Boot-BasicChatApplication" కాన్ఫిగరేషన్‌ను ఎంచుకోండి  

> **గమనిక**: VS కోడ్ కాన్ఫిగరేషన్ మీ .env ఫైల్‌ను ఆటోమేటిక్‌గా లోడ్ చేస్తుంది

### అంచనా ఫలితాలు

```
Starting Basic Chat with Azure OpenAI...
Environment variables loaded successfully
Connecting to Azure OpenAI...
Sending prompt: What is AI in a short sentence? Max 100 words.

AI Response:
================
AI, or Artificial Intelligence, is the simulation of human intelligence in machines programmed to think and learn like humans.
================

Success! Azure OpenAI connection is working correctly.
```

## కాన్ఫిగరేషన్ రిఫరెన్స్

### ఎన్విరాన్‌మెంట్ వేరియబుల్స్

| వేరియబుల్ | వివరణ | అవసరం | ఉదాహరణ |
|-----------|--------|--------|---------|
| `AZURE_AI_KEY` | Azure OpenAI API కీ | అవును | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI ఎండ్‌పాయింట్ URL | అవును | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | మోడల్ డిప్లాయ్‌మెంట్ పేరు | కాదు | `gpt-4o-mini` (డిఫాల్ట్) |

### స్ప్రింగ్ కాన్ఫిగరేషన్

`application.yml` ఫైల్‌లో ఈ క్రింది అంశాలు కాన్ఫిగర్ చేయబడ్డాయి:
- **API కీ**: `${AZURE_AI_KEY}` - ఎన్విరాన్‌మెంట్ వేరియబుల్ నుండి  
- **ఎండ్‌పాయింట్**: `${AZURE_AI_ENDPOINT}` - ఎన్విరాన్‌మెంట్ వేరియబుల్ నుండి  
- **మోడల్**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - ఎన్విరాన్‌మెంట్ వేరియబుల్ నుండి ఫాల్బ్యాక్‌తో  
- **టెంపరేచర్**: `0.7` - క్రియేటివిటీని నియంత్రిస్తుంది (0.0 = డిటర్మినిస్టిక్, 1.0 = క్రియేటివ్)  
- **మాక్స్ టోకెన్స్**: `500` - గరిష్ట స్పందన పొడవు  

## ట్రబుల్‌షూటింగ్

### సాధారణ సమస్యలు

<details>
<summary><strong>లోపం: "API కీ చెల్లుబాటు కాదు"</strong></summary>

- మీ `.env` ఫైల్‌లో `AZURE_AI_KEY` సరిగ్గా సెట్ చేయబడిందో లేదో తనిఖీ చేయండి  
- API కీని Azure AI Foundry పోర్టల్ నుండి ఖచ్చితంగా కాపీ చేసారో లేదో నిర్ధారించుకోండి  
- కీ చుట్టూ అదనపు స్పేస్‌లు లేదా కోట్స్ లేవో చూడండి  
</details>

<details>
<summary><strong>లోపం: "ఎండ్‌పాయింట్ చెల్లుబాటు కాదు"</strong></summary>

- మీ `AZURE_AI_ENDPOINT` పూర్తి URL (ఉదా: `https://your-hub-name.openai.azure.com/`) కలిగి ఉందో చూడండి  
- ట్రైలింగ్ స్లాష్ సరిగా ఉందో తనిఖీ చేయండి  
- ఎండ్‌పాయింట్ మీ Azure డిప్లాయ్‌మెంట్ రీజియన్‌కు సరిపోతుందో చూడండి  
</details>

<details>
<summary><strong>లోపం: "డిప్లాయ్‌మెంట్ కనుగొనబడలేదు"</strong></summary>

- మీ మోడల్ డిప్లాయ్‌మెంట్ పేరు Azure లో డిప్లాయ్ చేసినదానికి సరిపోతుందో చూడండి  
- మోడల్ విజయవంతంగా డిప్లాయ్ చేయబడిందో, యాక్టివ్‌గా ఉందో తనిఖీ చేయండి  
- డిఫాల్ట్ డిప్లాయ్‌మెంట్ పేరు: `gpt-4o-mini` ఉపయోగించడానికి ప్రయత్నించండి  
</details>

<details>
<summary><strong>VS కోడ్: ఎన్విరాన్‌మెంట్ వేరియబుల్స్ లోడ్ కావడం లేదు</strong></summary>

- మీ `.env` ఫైల్ ప్రాజెక్ట్ రూట్ డైరెక్టరీలో ఉందో (అంటే `pom.xml` తో సమాన స్థాయిలో) చూడండి  
- VS కోడ్ ఇంటిగ్రేటెడ్ టెర్మినల్‌లో `mvn spring-boot:run` నడపడానికి ప్రయత్నించండి  
- VS కోడ్ జావా ఎక్స్‌టెన్షన్ సరిగా ఇన్‌స్టాల్ చేయబడిందో చూడండి  
- లాంచ్ కాన్ఫిగరేషన్‌లో `"envFile": "${workspaceFolder}/.env"` ఉందో నిర్ధారించుకోండి  
</details>

### డీబగ్ మోడ్

వివరణాత్మక లాగింగ్‌ను ఎనేబుల్ చేయడానికి, `application.yml` లో ఈ లైన్లను అన్‌కామెంట్ చేయండి:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## తదుపరి దశలు

**సెటప్ పూర్తయింది!** మీ లెర్నింగ్ జర్నీని కొనసాగించండి:

[చాప్టర్ 3: కోర్ జనరేటివ్ AI టెక్నిక్స్](../../../03-CoreGenerativeAITechniques/README.md)

## వనరులు

- [Spring AI Azure OpenAI డాక్యుమెంటేషన్](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)  
- [Azure OpenAI సర్వీస్ డాక్యుమెంటేషన్](https://learn.microsoft.com/azure/ai-services/openai/)  
- [Azure AI Foundry పోర్టల్](https://ai.azure.com/)  
- [Azure AI Foundry డాక్యుమెంటేషన్](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)  

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**అస్వీకరణ**:  
ఈ పత్రం AI అనువాద సేవ [Co-op Translator](https://github.com/Azure/co-op-translator) ఉపయోగించి అనువదించబడింది. మేము ఖచ్చితత్వానికి ప్రయత్నిస్తున్నప్పటికీ, ఆటోమేటెడ్ అనువాదాలు తప్పులు లేదా అసమగ్రతలను కలిగి ఉండవచ్చు. దాని స్వదేశ భాషలో ఉన్న అసలు పత్రాన్ని అధికారం కలిగిన మూలంగా పరిగణించాలి. కీలకమైన సమాచారం కోసం, ప్రొఫెషనల్ మానవ అనువాదాన్ని సిఫారసు చేస్తాము. ఈ అనువాదాన్ని ఉపయోగించడం వల్ల కలిగే ఏవైనా అపార్థాలు లేదా తప్పుదారులు కోసం మేము బాధ్యత వహించము.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->