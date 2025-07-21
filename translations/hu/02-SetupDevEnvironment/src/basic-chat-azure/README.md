<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2289320a74aeca1eb844cd7d3a7a9e12",
  "translation_date": "2025-07-21T21:08:33+00:00",
  "source_file": "02-SetupDevEnvironment/src/basic-chat-azure/README.md",
  "language_code": "hu"
}
-->
# Alapvető Chat az Azure OpenAI-val - Végponttól végpontig példa

Ez a példa bemutatja, hogyan lehet létrehozni egy egyszerű Spring Boot alkalmazást, amely csatlakozik az Azure OpenAI-hoz, és teszteli a beállításokat.

## Tartalomjegyzék

- [Előfeltételek](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Gyors kezdés](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Konfigurációs lehetőségek](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [1. lehetőség: Környezeti változók (.env fájl) - Ajánlott](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [2. lehetőség: GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Az alkalmazás futtatása](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Maven használatával](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [VS Code használatával](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Várt kimenet](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Konfigurációs referencia](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Környezeti változók](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Spring konfiguráció](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Hibaelhárítás](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Gyakori problémák](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Hibakeresési mód](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Következő lépések](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Források](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)

## Előfeltételek

Mielőtt futtatnád ezt a példát, győződj meg róla, hogy rendelkezel az alábbiakkal:

- A [Azure OpenAI beállítási útmutató](../../getting-started-azure-openai.md) elvégzése  
- Azure OpenAI erőforrás telepítése (az Azure AI Foundry portálon keresztül)  
- gpt-4o-mini modell (vagy alternatíva) telepítése  
- API kulcs és végpont URL az Azure-tól  

## Gyors kezdés

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/src/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Konfigurációs lehetőségek

### 1. lehetőség: Környezeti változók (.env fájl) - Ajánlott

**1. lépés: Hozd létre a konfigurációs fájlt**  
```bash
cp .env.example .env
```

**2. lépés: Add hozzá az Azure OpenAI hitelesítő adataidat**  
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Biztonsági megjegyzés**:  
> - Soha ne kötelezd el a `.env` fájlt verziókezelésbe  
> - A `.env` fájl már szerepel a `.gitignore` fájlban  
> - Tartsd biztonságban az API kulcsaidat, és rendszeresen cseréld őket  

### 2. lehetőség: GitHub Codespace Secrets

GitHub Codespaces esetén állítsd be ezeket a titkokat a repozitóriumodban:
- `AZURE_AI_KEY` - Az Azure OpenAI API kulcsod
- `AZURE_AI_ENDPOINT` - Az Azure OpenAI végpont URL-je

Az alkalmazás automatikusan felismeri és használja ezeket a titkokat.

### Alternatíva: Közvetlen környezeti változók

<details>
<summary>Platformspecifikus parancsok megtekintése</summary>

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

## Az alkalmazás futtatása

### Maven használatával

```bash
mvn spring-boot:run
```

### VS Code használatával

1. Nyisd meg a projektet a VS Code-ban  
2. Nyomd meg az `F5` gombot, vagy használd a "Run and Debug" panelt  
3. Válaszd ki a "Spring Boot-BasicChatApplication" konfigurációt  

> **Megjegyzés**: A VS Code konfiguráció automatikusan betölti a .env fájlt  

### Várt kimenet

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

## Konfigurációs referencia

### Környezeti változók

| Változó | Leírás | Kötelező | Példa |
|---------|--------|----------|-------|
| `AZURE_AI_KEY` | Azure OpenAI API kulcs | Igen | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI végpont URL | Igen | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Modell telepítési neve | Nem | `gpt-4o-mini` (alapértelmezett) |

### Spring konfiguráció

Az `application.yml` fájl konfigurálja:  
- **API kulcs**: `${AZURE_AI_KEY}` - Környezeti változóból  
- **Végpont**: `${AZURE_AI_ENDPOINT}` - Környezeti változóból  
- **Modell**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Környezeti változóból alapértelmezett értékkel  
- **Hőmérséklet**: `0.7` - Kreativitás szabályozása (0.0 = determinisztikus, 1.0 = kreatív)  
- **Maximális tokenek**: `500` - Maximális válasz hossz  

## Hibaelhárítás

### Gyakori problémák

<details>
<summary><strong>Hiba: "Az API kulcs nem érvényes"</strong></summary>

- Ellenőrizd, hogy az `AZURE_AI_KEY` helyesen van-e beállítva a `.env` fájlban  
- Győződj meg róla, hogy az API kulcs pontosan az Azure AI Foundry portálról lett másolva  
- Ellenőrizd, hogy nincsenek extra szóközök vagy idézőjelek a kulcs körül  
</details>

<details>
<summary><strong>Hiba: "A végpont nem érvényes"</strong></summary>

- Győződj meg róla, hogy az `AZURE_AI_ENDPOINT` tartalmazza a teljes URL-t (pl. `https://your-hub-name.openai.azure.com/`)  
- Ellenőrizd a perjelek következetességét  
- Ellenőrizd, hogy a végpont megfelel-e az Azure telepítési régiójának  
</details>

<details>
<summary><strong>Hiba: "A telepítés nem található"</strong></summary>

- Ellenőrizd, hogy a modell telepítési neve pontosan megegyezik az Azure-ban telepítettel  
- Győződj meg róla, hogy a modell sikeresen telepítve és aktív  
- Próbáld meg az alapértelmezett telepítési nevet használni: `gpt-4o-mini`  
</details>

<details>
<summary><strong>VS Code: A környezeti változók nem töltődnek be</strong></summary>

- Győződj meg róla, hogy a `.env` fájl a projekt gyökérkönyvtárában van (ugyanazon a szinten, mint a `pom.xml`)  
- Próbáld meg futtatni a `mvn spring-boot:run` parancsot a VS Code integrált termináljában  
- Ellenőrizd, hogy a VS Code Java bővítménye megfelelően telepítve van  
- Győződj meg róla, hogy az indítási konfiguráció tartalmazza: `"envFile": "${workspaceFolder}/.env"`  
</details>

### Hibakeresési mód

A részletes naplózás engedélyezéséhez kommenteld ki ezeket a sorokat az `application.yml` fájlban:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Következő lépések

**A beállítás kész!** Folytasd a tanulási utadat:

[3. fejezet: Generatív AI alaptechnikák](../../../03-CoreGenerativeAITechniques/README.md)

## Források

- [Spring AI Azure OpenAI dokumentáció](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)  
- [Azure OpenAI Szolgáltatás dokumentáció](https://learn.microsoft.com/azure/ai-services/openai/)  
- [Azure AI Foundry portál](https://ai.azure.com/)  
- [Azure AI Foundry dokumentáció](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)  

**Felelősség kizárása**:  
Ez a dokumentum az AI fordítási szolgáltatás [Co-op Translator](https://github.com/Azure/co-op-translator) segítségével lett lefordítva. Bár törekszünk a pontosságra, kérjük, vegye figyelembe, hogy az automatikus fordítások hibákat vagy pontatlanságokat tartalmazhatnak. Az eredeti dokumentum az eredeti nyelvén tekintendő hiteles forrásnak. Kritikus információk esetén javasolt professzionális emberi fordítást igénybe venni. Nem vállalunk felelősséget semmilyen félreértésért vagy téves értelmezésért, amely a fordítás használatából eredhet.