<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "e00bbea0f95c611aa3bec676d23e8b43",
  "translation_date": "2025-07-21T21:03:26+00:00",
  "source_file": "02-SetupDevEnvironment/getting-started-azure-openai.md",
  "language_code": "hu"
}
-->
# Az Azure OpenAI fejlesztői környezet beállítása

> **Gyors kezdés**: Ez az útmutató az Azure OpenAI beállításához készült. Ha azonnal szeretnéd elkezdeni ingyenes modellekkel, használd a [GitHub Models with Codespaces](./README.md#quick-start-cloud) lehetőséget.

Ez az útmutató segít beállítani az Azure AI Foundry modelleket a Java AI alkalmazásokhoz ebben a kurzusban.

## Tartalomjegyzék

- [Gyors beállítási áttekintés](../../../02-SetupDevEnvironment)
- [1. lépés: Azure AI Foundry erőforrások létrehozása](../../../02-SetupDevEnvironment)
  - [Hub és projekt létrehozása](../../../02-SetupDevEnvironment)
  - [GPT-4o-mini modell telepítése](../../../02-SetupDevEnvironment)
- [2. lépés: Codespace létrehozása](../../../02-SetupDevEnvironment)
- [3. lépés: Környezet konfigurálása](../../../02-SetupDevEnvironment)
- [4. lépés: Beállítás tesztelése](../../../02-SetupDevEnvironment)
- [Mi a következő lépés?](../../../02-SetupDevEnvironment)
- [Források](../../../02-SetupDevEnvironment)
- [További források](../../../02-SetupDevEnvironment)

## Gyors beállítási áttekintés

1. Hozz létre Azure AI Foundry erőforrásokat (Hub, Projekt, Modell)
2. Hozz létre egy Codespace-t Java fejlesztői konténerrel
3. Konfiguráld a .env fájlt az Azure OpenAI hitelesítő adatokkal
4. Teszteld a beállítást a példa projekttel

## 1. lépés: Azure AI Foundry erőforrások létrehozása

### Hub és projekt létrehozása

1. Látogass el az [Azure AI Foundry Portálra](https://ai.azure.com/) és jelentkezz be
2. Kattints a **+ Létrehozás** → **Új hub** lehetőségre (vagy navigálj a **Kezelés** → **Összes hub** → **+ Új hub** menüpontra)
3. Konfiguráld a hubot:
   - **Hub neve**: pl. "MyAIHub"
   - **Előfizetés**: Válaszd ki az Azure előfizetésedet
   - **Erőforráscsoport**: Hozz létre újat vagy válassz meglévőt
   - **Helyszín**: Válaszd ki a hozzád legközelebbit
   - **Tárfiók**: Használd az alapértelmezettet vagy konfigurálj egyéni beállítást
   - **Kulcstartó**: Használd az alapértelmezettet vagy konfigurálj egyéni beállítást
   - Kattints a **Tovább** → **Áttekintés + létrehozás** → **Létrehozás** gombra
4. A létrehozás után kattints a **+ Új projekt** (vagy **Projekt létrehozása** a hub áttekintő oldaláról) lehetőségre
   - **Projekt neve**: pl. "GenAIJava"
   - Kattints a **Létrehozás** gombra

### GPT-4o-mini modell telepítése

1. A projektedben menj a **Modellek katalógusa** menüpontra, és keresd meg a **gpt-4o-mini** modellt
   - *Alternatíva: Menj a **Telepítések** → **+ Telepítés létrehozása** menüpontra*
2. Kattints a **Telepítés** gombra a gpt-4o-mini modell kártyáján
3. Konfiguráld a telepítést:
   - **Telepítés neve**: "gpt-4o-mini"
   - **Modell verziója**: Használd a legújabbat
   - **Telepítés típusa**: Standard
4. Kattints a **Telepítés** gombra
5. A telepítés után menj a **Telepítések** fülre, és másold ki az alábbi értékeket:
   - **Telepítés neve** (pl. "gpt-4o-mini")
   - **Cél URI** (pl. `https://your-hub-name.openai.azure.com/`)  
      > **Fontos**: Csak az alap URL-t másold ki (pl. `https://myhub.openai.azure.com/`), ne a teljes végpont útvonalát.
   - **Kulcs** (a Kulcsok és végpont szekcióból)

> **Még mindig problémád van?** Látogasd meg az [Azure AI Foundry Dokumentációt](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)

## 2. lépés: Codespace létrehozása

1. Forkold ezt a repót a GitHub fiókodba
   > **Megjegyzés**: Ha módosítani szeretnéd az alapértelmezett konfigurációt, nézd meg a [Fejlesztői konténer konfigurációt](../../../.devcontainer/devcontainer.json)
2. A forkolt repódban kattints a **Code** → **Codespaces** fülre
3. Kattints a **...** → **Új opciókkal...** lehetőségre  
![codespace létrehozása opciókkal](../../../translated_images/codespaces.9945ded8ceb431a58e8bee7f212e8c62b55733b7e302fd58194fadc95472fa3c.hu.png)
4. Válaszd ki a **Fejlesztői konténer konfigurációt**: 
   - **Generatív AI Java Fejlesztői Környezet**
5. Kattints a **Codespace létrehozása** gombra

## 3. lépés: Környezet konfigurálása

Amint a Codespace készen áll, állítsd be az Azure OpenAI hitelesítő adataidat:

1. **Navigálj a példa projekthez a repó gyökeréből:**
   ```bash
   cd 02-SetupDevEnvironment/src/basic-chat-azure
   ```

2. **Hozd létre a .env fájlt:**
   ```bash
   cp .env.example .env
   ```

3. **Szerkeszd a .env fájlt az Azure OpenAI hitelesítő adataiddal:**
   ```bash
   # Your Azure OpenAI API key (from Azure AI Foundry portal)
   AZURE_AI_KEY=your-actual-api-key-here
   
   # Your Azure OpenAI endpoint URL (e.g., https://myhub.openai.azure.com/)
   AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
   ```

   > **Biztonsági megjegyzés**: 
   > - Soha ne commitold a `.env` fájlt a verziókezelésbe
   > - A `.env` fájl már szerepel a `.gitignore` fájlban
   > - Tartsd biztonságban az API kulcsaidat, és rendszeresen cseréld őket

## 4. lépés: Beállítás tesztelése

Futtasd a példa alkalmazást, hogy teszteld az Azure OpenAI kapcsolatot:

```bash
mvn clean spring-boot:run
```

Látnod kell egy választ a GPT-4o-mini modelltől!

> **VS Code felhasználók**: A `F5` billentyű lenyomásával is futtathatod az alkalmazást a VS Code-ban. A futtatási konfiguráció már be van állítva, hogy automatikusan betöltse a `.env` fájlt.

> **Teljes példa**: Nézd meg a [Teljes Azure OpenAI Példát](./src/basic-chat-azure/README.md) részletes utasításokért és hibaelhárításért.

## Mi a következő lépés?

**Beállítás kész!** Most már rendelkezel:
- Azure OpenAI-val és telepített gpt-4o-mini modellel
- Helyi .env fájl konfigurációval
- Java fejlesztői környezettel

**Folytasd a** [3. fejezet: Generatív AI alaptechnikák](../03-CoreGenerativeAITechniques/README.md) tanulmányozásával, hogy elkezdj AI alkalmazásokat építeni!

## Források

- [Azure AI Foundry Dokumentáció](https://learn.microsoft.com/azure/ai-services/)
- [Spring AI Azure OpenAI Dokumentáció](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)
- [Azure OpenAI Java SDK](https://learn.microsoft.com/java/api/overview/azure/ai-openai-readme)

## További források

- [VS Code letöltése](https://code.visualstudio.com/Download)
- [Docker Desktop beszerzése](https://www.docker.com/products/docker-desktop)
- [Fejlesztői konténer konfiguráció](../../../.devcontainer/devcontainer.json)

**Felelősség kizárása**:  
Ez a dokumentum az AI fordítási szolgáltatás [Co-op Translator](https://github.com/Azure/co-op-translator) segítségével lett lefordítva. Bár törekszünk a pontosságra, kérjük, vegye figyelembe, hogy az automatikus fordítások hibákat vagy pontatlanságokat tartalmazhatnak. Az eredeti dokumentum az eredeti nyelvén tekintendő hiteles forrásnak. Kritikus információk esetén javasolt professzionális emberi fordítást igénybe venni. Nem vállalunk felelősséget semmilyen félreértésért vagy téves értelmezésért, amely a fordítás használatából eredhet.