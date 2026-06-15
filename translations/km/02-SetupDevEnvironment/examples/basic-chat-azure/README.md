# ការជជែកមូលដ្ឋានជាមួយ Azure OpenAI - ឧទាហរណ៍ពីដើមដល់ចុង

ឧទាហរណ៍នេះបង្ហាញពីរបៀបបង្កើតកម្មវិធី Spring Boot សាមញ្ញមួយ ដែលភ្ជាប់ទៅ Azure OpenAI ហើយសាកល្បងការតំឡើងរបស់អ្នក។

## តារាងមាតិកា

- [លក្ខខណ្ឌមុនចាប់ផ្តើម](#លក្ខខណ្ឌមុនចាប់ផ្តើម)
- [ការចាប់ផ្តើមយ៉ាងរហ័ស](#ការចាប់ផ្តើមយ៉ាងរហ័ស)
- [ជម្រើសកំណត់រចនា](#ជម្រើសកំណត់រចនា)
  - [ជម្រើស 1៖ អថេរស្រមោលបរិស្ថាន (.env file) - ជំពូកណែនាំ](#option-1-environment-variables-env-file---recommended)
  - [ជម្រើស 2៖ សម្ងាត់ GitHub Codespace](#ជម្រើស-2៖-សម្ងាត់-github-codespace)
- [ការបើកប្រ�ប្រតិបត្តិការ](#ការបើកប្រ�ប្រតិបត្តិការ)
  - [ការប្រើ Maven](#ការប្រើ-maven)
  - [ការប្រើ VS Code](#ការប្រើ-vs-code)
  - [លទ្ធផលដែលរំពឹងទុក](#លទ្ធផលដែលរំពឹងទុក)
- [ឯកសារយោងកំណត់រចនា](#ឯកសារយោងកំណត់រចនា)
  - [អថេរស្រមោលបរិស្ថាន](#អថេរស្រមោលបរិស្ថាន)
  - [កំណត់រចនា Spring](#កំណត់រចនា-spring)
- [ការដោះស្រាយបញ្ហាទូទៅ](#ការដោះស្រាយបញ្ហាទូទៅ)
  - [បញ្ហាទូទៅ](#បញ្ហាទូទៅ)
  - [ម៉ូដដឹងខុសត្រូវលំអិត](#ម៉ូដដឹងខុសត្រូវលំអិត)
- [ជំហានបន្ទាប់](#ជំហានបន្ទាប់)
- [ធនធាន](#ធនធាន)

## លក្ខខណ្ឌមុនចាប់ផ្តើម

មុនពេលបើកប្រ�ប្រតិបត្តិការឧទាហរណ៍នេះ សូមប្រាកដថាអ្នកមាន៖

- បានបញ្ចប់មេរៀន [ការដំឡើង Azure OpenAI](../../getting-started-azure-openai.md)  
- បានដាក់បញ្ចូលធនធាន Azure OpenAI (តាមរយៈទំនាក់ទំនង Azure AI Foundry portal)  
- បានដាក់បញ្ចូលម៉ូឌែល gpt-4o-mini (ឬជំនួស)  
- មានកូនសោ API និង URL ចុងផ្តើមពី Azure  

## ការចាប់ផ្តើមយ៉ាងរហ័ស

```bash
# ១. ទៅកាន់គម្រោង
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# ២. កំណត់រចនាសម្ព័ន្ធសម្ងាត់
cp .env.example .env
# កែសម្រួល .env ជាមួយអត្រាកម្ម Azure OpenAI របស់អ្នក

# ៣. ប្រតិបត្តិកម្មវិធី
mvn spring-boot:run
```

## ជម្រើសកំណត់រចនា

### ជម្រើស 1៖ អថេរស្រមោលបរិស្ថាន (.env file) - ជំពូកណែនាំ

**ជំហាន 1៖ បង្កើតឯកសារកំណត់រចនារបស់អ្នក**
```bash
cp .env.example .env
```

**ជំហាន 2៖ បន្ថែមអត្តសញ្ញាណ Azure OpenAI របស់អ្នក**
```bash
# កូនសោ API Azure OpenAI របស់អ្នក (ពីប៉ូរតាល់ Azure AI Foundry)
AZURE_AI_KEY=your-actual-api-key-here

# URL ចុងបញ្ចប់ Azure OpenAI របស់អ្នក (ឧទាហរណ៍, https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **ផ្សាយបញ្ញតិ**: 
> - ពុំដែលបញ្ចូលឯកសារ `.env` ទៅក្នុងការគ្រប់គ្រងកំណែ
> - ឯកសារ `.env` បានដាក់ក្នុង `.gitignore` រួចហើយ
> - រក្សាទុកកូនសោ API របស់អ្នកឱ្យមានសុវត្ថិភាព ហើយប្ដូរពួកវាប្រចាំ

### ជម្រើស 2៖ សម្ងាត់ GitHub Codespace

សម្រាប់ GitHub Codespaces សូមកំណត់សម្ងាត់ទាំងនេះនៅក្នុងឃ្លាំងរបស់អ្នក៖
- `AZURE_AI_KEY` - កូនសោ API Azure OpenAI របស់អ្នក
- `AZURE_AI_ENDPOINT` - URL ចុងផ្តើម Azure OpenAI របស់អ្នក

កម្មវិធីនឹងស្វ័យប្រវត្តិកំណត់ និងប្រើសម្ងាត់ទាំងនេះ។

### ជម្រើសជំនួស៖ អថេរស្រមោលបរិស្ថានផ្ទាល់

<details>
<summary>ចុចដើម្បីមើលពាក្យបញ្ជារពីប្រព័ន្ធផ្ទាល់ខ្លួន</summary>

**Linux/macOS (bash/zsh):**
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (Command Prompt):**
```cmd
set AZURE_AI_KEY=your-actual-api-key-here
set AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (PowerShell):**
```powershell
$env:AZURE_AI_KEY="your-actual-api-key-here"
$env:AZURE_AI_ENDPOINT="https://your-hub-name.openai.azure.com/"
```
</details>

## ការបើកប្រ�ប្រតិបត្តិការ

### ការប្រើ Maven

```bash
mvn spring-boot:run
```

### ការប្រើ VS Code

1. បើកគម្រោងនៅក្នុង VS Code
2. ចុច `F5` ឬប្រើផ្ទាំង "Run and Debug"
3. ជ្រើសរើស ការកំណត់រចនា "Spring Boot-BasicChatApplication"

> **សំគាល់**៖ ការកំណត់រចនា VS Code នឹងផ្ទុកឯកសារ .env របស់អ្នកដោយស្វ័យប្រវត្តិ

### លទ្ធផលដែលរំពឹងទុក

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

## ឯកសារយោងកំណត់រចនា

### អថេរស្រមោលបរិស្ថាន

| អថេរ | ការពិពណ៌នា | តម្រូវការ | ឧទាហរណ៍ |
|-------|-------------|------------|-----------|
| `AZURE_AI_KEY` | កូនសោ API Azure OpenAI | ត្រូវការ | `abc123...` |
| `AZURE_AI_ENDPOINT` | URL ចុងផ្តើម Azure OpenAI | ត្រូវការ | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | ឈ្មោះការដាក់បញ្ចូលម៉ូឌែល | មិនបាច់ | `gpt-4o-mini` (លំនាំដើម) |

### កំណត់រចនា Spring

ឯកសារ `application.yml` បញ្ជាក់ទាំងនេះ៖
- **កូនសោ API**: `${AZURE_AI_KEY}` - ពីអថេរបរិស្ថាន
- **ចុងផ្តើម**: `${AZURE_AI_ENDPOINT}` - ពីអថេរបរិស្ថាន  
- **ម៉ូឌែល**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - ពីអថេរបរិស្ថានជាមួយលំនាំដើម
- **សីតុណ្ហភាព**: `0.7` - កំណត់ការច្នៃប្រឌិត (0.0 = ត្រឹមត្រូវយ៉ាងណាមួយ, 1.0 = ច្នៃប្រឌិត)
- **តួអក្សរតែបរិមាណអតិបរមា**: `500` - ប្រវែងចម្លើយអតិផរណា

## ការដោះស្រាយបញ្ហាទូទៅ

### បញ្ហាទូទៅ

<details>
<summary><strong>កំហុស៖ "កូនសោ API មិនត្រឹមត្រូវ"</strong></summary>

- ពិនិត្យមើលថា `AZURE_AI_KEY` របស់អ្នកត្រូវបានកំណត់ត្រឹមត្រូវក្នុងឯកសារ `.env`
- បញ្ជាក់ថាកូនសោ API ត្រូវបានចម្លងពីទំព័រ Azure AI Foundry ពីរបៀបត្រឹមត្រូវ
- ប្រាកដថារក្សាទុកនៅលើគ្មានកន្លែងទំនេរឬសញ្ញាដាក់ក្នុងកូនសោ
</details>

<details>
<summary><strong>កំហុស៖ "ចុងផ្តើមមិនត្រឹមត្រូវ"</strong></summary>

- ប្រាកដថា `AZURE_AI_ENDPOINT` របស់អ្នកមាន URL ពេញលេញ (ឧ. `https://your-hub-name.openai.azure.com/`)
- ពិនិត្យការត្រូវគ្នារបស់សញ្ញាស្លាកក្រោយ
- បញ្ជាក់ថាចុងផ្តើមផ្គូរផ្គងជាតំបន់ដាក់បញ្ចូលរបស់ Azure
</details>

<details>
<summary><strong>កំហុស៖ "មិនរកមើលការដាក់បញ្ចូលបានទេ"</strong></summary>

- បញ្ជាក់ឈ្មោះការដាក់បញ្ចូលម៉ូឌែលត្រឹមត្រូវជាមួយនឹងអ្វីដែលបានដាក់នៅ Azure
- ពិនិត្យមើលថាម៉ូឌែលបានដាក់បញ្ចូលហើយមានសកម្មភាព
- សាកល្បងប្រើឈ្មោះការដាក់បញ្ចូលលំនាំដើម៖ `gpt-4o-mini`
</details>

<details>
<summary><strong>VS Code៖ អថេរស្រមោលបរិស្ថានមិនផ្ទុកឡើង</strong></summary>

- ពិនិត្យឲ្យប្រាកដថា ` .env` ស្ថិតនៅថតគម្រោងបណ្ដាដើម (កម្រិតដូចគ្នានឹង `pom.xml`)
- ព្យាយាមរត់ `mvn spring-boot:run` នៅក្នុងផ្ទាំងបញ្ជាការរបស់ VS Code
- កំណត់ឲ្យប្រាកដថាបន្ថែមកម្មវិធី Java នៅក្នុង VS Code ត្រូវបានដំឡើងគ្រប់គ្រាន់
- ពិនិត្យថាការកំណត់ការចាប់ផ្តើមមាន `"envFile": "${workspaceFolder}/.env"`
</details>

### ម៉ូដដឹងខុសត្រូវលំអិត

ដើម្បីបើកកំណត់ហេតុលម្អិត សូមដកស្រង់បន្ទាត់ទាំងនេះក្នុង `application.yml`៖

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## ជំហានបន្ទាប់

**ការតំឡើងបានបញ្ចប់!** បន្តដំណើរការរៀនរបស់អ្នក៖

[ជំពូក 3៖ បច្ចេកទេស Core Generative AI](../../../03-CoreGenerativeAITechniques/README.md)

## ធនធាន

- [ឯកសារយោង Spring AI Azure OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [ឯកសារយោងសេវាកម្ម Azure OpenAI](https://learn.microsoft.com/azure/ai-services/openai/)
- [ទ្វារចូល Azure AI Foundry](https://ai.azure.com/)
- [ឯកសារយោង Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**ការបដិសេធ**:  
ឯកសារនេះត្រូវបានបកប្រែដោយប្រើសេវាកម្មបកប្រែ AI [Co-op Translator](https://github.com/Azure/co-op-translator)។ ខណៈពួកយើងខិតខំព្យាយាមឱ្យបានត្រឹមត្រូវ សូមយល់ថាការបកប្រែដោយស្វ័យប្រវត្តិនេះអាចមានកំហុស ឬភាពមិនត្រឹមត្រូវ។ ឯកសារដើមនៅក្នុងភាសាបុរាណគឺជាដើមទិន្នន័យដែលមានសុពលភាព។ សម្រាប់ព័ត៌មានសំខាន់ៗ សូមផ្តល់អាទិភាពការបកប្រែដោយអ្នកជំនាញមនុស្សវិជ្ជាជីវៈ។ ពួកយើងមិនទទួលខុសត្រូវចំពោះការយល់ច្រឡំ ឬការបកប្រែខុសៗដែលកើតមានចេញពីការប្រើប្រាស់ការបកប្រែកំណត់នេះឡើយ។
<!-- CO-OP TRANSLATOR DISCLAIMER END -->