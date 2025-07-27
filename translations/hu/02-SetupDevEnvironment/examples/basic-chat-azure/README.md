<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "efd82efe50711d7e257eb943151d682c",
  "translation_date": "2025-07-27T13:45:46+00:00",
  "source_file": "02-SetupDevEnvironment/examples/basic-chat-azure/README.md",
  "language_code": "hu"
}
-->
# Alapvető Chat az Azure OpenAI-val - Teljes Példa

Ez a példa bemutatja, hogyan lehet létrehozni egy egyszerű Spring Boot alkalmazást, amely csatlakozik az Azure OpenAI-hoz, és teszteli a beállításokat.

## Tartalomjegyzék

- [Előfeltételek](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Gyors Kezdés](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Konfigurációs Opciók](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [1. opció: Környezeti változók (.env fájl) - Ajánlott](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [2. opció: GitHub Codespace Secrets](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Az Alkalmazás Futtatása](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Maven használatával](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [VS Code használatával](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Várt Kimenet](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Konfigurációs Referencia](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Környezeti Változók](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Spring Konfiguráció](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Hibaelhárítás](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Gyakori Problémák](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Hibakeresési Mód](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Következő Lépések](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Források](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## Előfeltételek

Mielőtt futtatnád ezt a példát, győződj meg róla, hogy:

- Teljesítetted az [Azure OpenAI beállítási útmutatót](../../getting-started-azure-openai.md)  
- Telepítetted az Azure OpenAI erőforrást (az Azure AI Foundry portálon keresztül)  
- Telepítetted a gpt-4o-mini modellt (vagy alternatívát)  
- Rendelkezel API kulccsal és végpont URL-lel az Azure-tól  

## Gyors Kezdés

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Konfigurációs Opciók

### 1. opció: Környezeti változók (.env fájl) - Ajánlott

**1. lépés: Hozd létre a konfigurációs fájlt**  
```bash
cp .env.example .env
```

**2. lépés: Add hozzá az Azure OpenAI hitelesítési adataidat**  
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Biztonsági Megjegyzés**:  
> - Soha ne kötelezd el a `.env` fájlt verziókezelésbe  
> - A `.env` fájl már szerepel a `.gitignore` fájlban  
> - Tartsd biztonságban az API kulcsaidat, és rendszeresen cseréld őket  

### 2. opció: GitHub Codespace Secrets

GitHub Codespaces esetén állítsd be ezeket a titkokat a repódban:
- `AZURE_AI_KEY` - Az Azure OpenAI API kulcsod
- `AZURE_AI_ENDPOINT` - Az Azure OpenAI végpont URL-je

Az alkalmazás automatikusan felismeri és használja ezeket a titkokat.

### Alternatíva: Közvetlen Környezeti Változók

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

## Az Alkalmazás Futtatása

### Maven használatával

```bash
mvn spring-boot:run
```

### VS Code használatával

1. Nyisd meg a projektet a VS Code-ban  
2. Nyomd meg az `F5` gombot, vagy használd a "Run and Debug" panelt  
3. Válaszd ki a "Spring Boot-BasicChatApplication" konfigurációt  

> **Megjegyzés**: A VS Code konfiguráció automatikusan betölti a .env fájlt  

### Várt Kimenet

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

## Konfigurációs Referencia

### Környezeti Változók

| Változó | Leírás | Kötelező | Példa |
|---------|--------|----------|-------|
| `AZURE_AI_KEY` | Azure OpenAI API kulcs | Igen | `abc123...` |
| `AZURE_AI_ENDPOINT` | Azure OpenAI végpont URL | Igen | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Modell telepítési neve | Nem | `gpt-4o-mini` (alapértelmezett) |

### Spring Konfiguráció

Az `application.yml` fájl konfigurálja:  
- **API kulcs**: `${AZURE_AI_KEY}` - Környezeti változóból  
- **Végpont**: `${AZURE_AI_ENDPOINT}` - Környezeti változóból  
- **Modell**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Környezeti változóból alapértelmezéssel  
- **Hőmérséklet**: `0.7` - Kreativitás szabályozása (0.0 = determinisztikus, 1.0 = kreatív)  
- **Maximális Tokenek**: `500` - Maximális válasz hossz  

## Hibaelhárítás

### Gyakori Problémák

<details>
<summary><strong>Hiba: "Az API kulcs nem érvényes"</strong></summary>

- Ellenőrizd, hogy az `AZURE_AI_KEY` helyesen van-e beállítva a `.env` fájlban  
- Győződj meg róla, hogy az API kulcs pontosan lett másolva az Azure AI Foundry portálról  
- Ellenőrizd, hogy nincsenek extra szóközök vagy idézőjelek a kulcs körül  
</details>

<details>
<summary><strong>Hiba: "A végpont nem érvényes"</strong></summary>

- Győződj meg róla, hogy az `AZURE_AI_ENDPOINT` tartalmazza a teljes URL-t (pl. `https://your-hub-name.openai.azure.com/`)  
- Ellenőrizd a perjelek következetességét  
- Győződj meg róla, hogy a végpont megegyezik az Azure telepítési régiójával  
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
- Ellenőrizd, hogy a VS Code Java bővítmény megfelelően telepítve van  
- Győződj meg róla, hogy az indítási konfiguráció tartalmazza: `"envFile": "${workspaceFolder}/.env"`  
</details>

### Hibakeresési Mód

A részletes naplózás engedélyezéséhez kommenteld ki ezeket a sorokat az `application.yml` fájlban:

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Következő Lépések

**A beállítás kész!** Folytasd a tanulási utadat:

[3. fejezet: Generatív AI alaptechnikák](../../../03-CoreGenerativeAITechniques/README.md)

## Források

- [Spring AI Azure OpenAI Dokumentáció](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)  
- [Azure OpenAI Szolgáltatás Dokumentáció](https://learn.microsoft.com/azure/ai-services/openai/)  
- [Azure AI Foundry Portál](https://ai.azure.com/)  
- [Azure AI Foundry Dokumentáció](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)  

**Felelősségkizárás**:  
Ez a dokumentum az [Co-op Translator](https://github.com/Azure/co-op-translator) AI fordítási szolgáltatás segítségével készült. Bár törekszünk a pontosságra, kérjük, vegye figyelembe, hogy az automatikus fordítások hibákat vagy pontatlanságokat tartalmazhatnak. Az eredeti dokumentum az eredeti nyelvén tekintendő hiteles forrásnak. Kritikus információk esetén javasolt professzionális, emberi fordítást igénybe venni. Nem vállalunk felelősséget a fordítás használatából eredő félreértésekért vagy téves értelmezésekért.