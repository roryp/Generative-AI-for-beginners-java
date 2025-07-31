<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c2a244c959e00da1ae1613d2ebfdac65",
  "translation_date": "2025-07-29T08:54:40+00:00",
  "source_file": "02-SetupDevEnvironment/README.md",
  "language_code": "pa"
}
-->
# ਜਾਵਾ ਲਈ ਜਨਰੇਟਿਵ AI ਦੇ ਵਿਕਾਸੀ ਮਾਹੌਲ ਦੀ ਸੈਟਿੰਗ

> **ਤੁਰੰਤ ਸ਼ੁਰੂਆਤ**: ਕਲਾਉਡ ਵਿੱਚ 2 ਮਿੰਟਾਂ ਵਿੱਚ ਕੋਡ ਕਰੋ - [GitHub Codespaces ਸੈਟਅੱਪ](../../../02-SetupDevEnvironment) 'ਤੇ ਜਾਓ - ਕੋਈ ਲੋਕਲ ਇੰਸਟਾਲੇਸ਼ਨ ਦੀ ਲੋੜ ਨਹੀਂ ਅਤੇ ਇਹ GitHub ਮਾਡਲ ਵਰਤਦਾ ਹੈ!

> **Azure OpenAI ਵਿੱਚ ਦਿਲਚਸਪੀ ਹੈ?**, ਸਾਡੇ [Azure OpenAI ਸੈਟਅੱਪ ਗਾਈਡ](getting-started-azure-openai.md) ਨੂੰ ਵੇਖੋ ਜਿਸ ਵਿੱਚ ਨਵਾਂ Azure OpenAI ਸਰੋਤ ਬਣਾਉਣ ਦੇ ਕਦਮ ਦਿੱਤੇ ਗਏ ਹਨ।

## ਤੁਸੀਂ ਕੀ ਸਿੱਖੋਗੇ

- AI ਐਪਲੀਕੇਸ਼ਨ ਲਈ ਜਾਵਾ ਵਿਕਾਸੀ ਮਾਹੌਲ ਸੈਟਅੱਪ ਕਰੋ
- ਆਪਣਾ ਪਸੰਦੀਦਾ ਵਿਕਾਸੀ ਮਾਹੌਲ ਚੁਣੋ ਅਤੇ ਕਨਫਿਗਰ ਕਰੋ (ਕਲਾਉਡ-ਪਹਿਲਾਂ Codespaces ਨਾਲ, ਲੋਕਲ ਡਿਵ ਕੰਟੇਨਰ, ਜਾਂ ਪੂਰੀ ਲੋਕਲ ਸੈਟਅੱਪ)
- GitHub ਮਾਡਲ ਨਾਲ ਕਨੈਕਟ ਕਰਕੇ ਆਪਣੀ ਸੈਟਅੱਪ ਦੀ ਜਾਂਚ ਕਰੋ

## ਸੂਚੀ

- [ਤੁਸੀਂ ਕੀ ਸਿੱਖੋਗੇ](../../../02-SetupDevEnvironment)
- [ਪ੍ਰਸਤਾਵਨਾ](../../../02-SetupDevEnvironment)
- [ਕਦਮ 1: ਆਪਣਾ ਵਿਕਾਸੀ ਮਾਹੌਲ ਸੈਟਅੱਪ ਕਰੋ](../../../02-SetupDevEnvironment)
  - [ਵਿਕਲਪ A: GitHub Codespaces (ਸਿਫਾਰਸ਼ ਕੀਤੀ)](../../../02-SetupDevEnvironment)
  - [ਵਿਕਲਪ B: ਲੋਕਲ ਡਿਵ ਕੰਟੇਨਰ](../../../02-SetupDevEnvironment)
  - [ਵਿਕਲਪ C: ਆਪਣੀ ਮੌਜੂਦਾ ਲੋਕਲ ਇੰਸਟਾਲੇਸ਼ਨ ਵਰਤੋ](../../../02-SetupDevEnvironment)
- [ਕਦਮ 2: GitHub ਪੈਰਸਨਲ ਐਕਸੈਸ ਟੋਕਨ ਬਣਾਓ](../../../02-SetupDevEnvironment)
- [ਕਦਮ 3: ਆਪਣੀ ਸੈਟਅੱਪ ਦੀ ਜਾਂਚ ਕਰੋ](../../../02-SetupDevEnvironment)
- [ਮਸਲੇ ਹੱਲ](../../../02-SetupDevEnvironment)
- [ਸੰਖੇਪ](../../../02-SetupDevEnvironment)
- [ਅਗਲੇ ਕਦਮ](../../../02-SetupDevEnvironment)

## ਪ੍ਰਸਤਾਵਨਾ

ਇਹ ਅਧਿਆਇ ਤੁਹਾਨੂੰ ਵਿਕਾਸੀ ਮਾਹੌਲ ਸੈਟਅੱਪ ਕਰਨ ਵਿੱਚ ਮਦਦ ਕਰੇਗਾ। ਅਸੀਂ **GitHub ਮਾਡਲ** ਨੂੰ ਆਪਣੀ ਮੁੱਖ ਉਦਾਹਰਣ ਵਜੋਂ ਵਰਤਾਂਗੇ ਕਿਉਂਕਿ ਇਹ ਮੁਫ਼ਤ ਹੈ, ਸਿਰਫ਼ ਇੱਕ GitHub ਖਾਤੇ ਨਾਲ ਸੈਟਅੱਪ ਕਰਨਾ ਆਸਾਨ ਹੈ, ਕਿਸੇ ਕਰੈਡਿਟ ਕਾਰਡ ਦੀ ਲੋੜ ਨਹੀਂ ਹੈ, ਅਤੇ ਪ੍ਰਯੋਗ ਲਈ ਕਈ ਮਾਡਲਾਂ ਤੱਕ ਪਹੁੰਚ ਪ੍ਰਦਾਨ ਕਰਦਾ ਹੈ।

**ਕੋਈ ਲੋਕਲ ਸੈਟਅੱਪ ਦੀ ਲੋੜ ਨਹੀਂ!** ਤੁਸੀਂ ਤੁਰੰਤ GitHub Codespaces ਵਰਤ ਕੇ ਬ੍ਰਾਊਜ਼ਰ ਵਿੱਚ ਪੂਰੇ ਵਿਕਾਸੀ ਮਾਹੌਲ ਨਾਲ ਕੋਡਿੰਗ ਸ਼ੁਰੂ ਕਰ ਸਕਦੇ ਹੋ।

<img src="./images/models.webp" alt="Screenshot: GitHub Models" width="50%">

ਅਸੀਂ ਇਸ ਕੋਰਸ ਲਈ [**GitHub ਮਾਡਲ**](https://github.com/marketplace?type=models) ਦੀ ਸਿਫਾਰਸ਼ ਕਰਦੇ ਹਾਂ ਕਿਉਂਕਿ ਇਹ:
- **ਮੁਫ਼ਤ** ਹੈ ਸ਼ੁਰੂਆਤ ਕਰਨ ਲਈ
- **ਆਸਾਨ** ਹੈ ਸੈਟਅੱਪ ਕਰਨ ਲਈ ਸਿਰਫ਼ ਇੱਕ GitHub ਖਾਤੇ ਨਾਲ
- **ਕੋਈ ਕਰੈਡਿਟ ਕਾਰਡ** ਦੀ ਲੋੜ ਨਹੀਂ
- **ਕਈ ਮਾਡਲ** ਪ੍ਰਯੋਗ ਲਈ ਉਪਲਬਧ ਹਨ

> **ਨੋਟ**: ਇਸ ਟ੍ਰੇਨਿੰਗ ਵਿੱਚ ਵਰਤੇ ਗਏ GitHub ਮਾਡਲਾਂ ਦੀਆਂ ਮੁਫ਼ਤ ਸੀਮਾਵਾਂ ਹਨ:
> - 15 ਬੇਨਤੀ ਪ੍ਰਤੀ ਮਿੰਟ (150 ਪ੍ਰਤੀ ਦਿਨ)
> - ~8,000 ਸ਼ਬਦ ਅੰਦਰ, ~4,000 ਸ਼ਬਦ ਬਾਹਰ ਪ੍ਰਤੀ ਬੇਨਤੀ
> - 5 ਸਮਕਾਲੀ ਬੇਨਤੀਆਂ
> 
> ਉਤਪਾਦਨ ਲਈ, ਆਪਣੇ Azure ਖਾਤੇ ਨਾਲ Azure AI Foundry ਮਾਡਲਾਂ 'ਤੇ ਅਪਗ੍ਰੇਡ ਕਰੋ। ਤੁਹਾਡਾ ਕੋਡ ਬਦਲਣ ਦੀ ਲੋੜ ਨਹੀਂ। [Azure AI Foundry ਦਸਤਾਵੇਜ਼](https://learn.microsoft.com/azure/ai-foundry/foundry-models/how-to/quickstart-github-models) ਵੇਖੋ।

## ਕਦਮ 1: ਆਪਣਾ ਵਿਕਾਸੀ ਮਾਹੌਲ ਸੈਟਅੱਪ ਕਰੋ

<a name="quick-start-cloud"></a>

ਅਸੀਂ ਇੱਕ ਪ੍ਰੀ-ਕਨਫਿਗਰਡ ਵਿਕਾਸੀ ਕੰਟੇਨਰ ਬਣਾਇਆ ਹੈ ਤਾਂ ਜੋ ਸੈਟਅੱਪ ਸਮਾਂ ਘਟਾਇਆ ਜਾ ਸਕੇ ਅਤੇ ਇਹ ਯਕੀਨੀ ਬਣਾਇਆ ਜਾ ਸਕੇ ਕਿ ਤੁਹਾਡੇ ਕੋਲ ਇਸ ਜਨਰੇਟਿਵ AI ਜਾਵਾ ਕੋਰਸ ਲਈ ਸਾਰੇ ਜ਼ਰੂਰੀ ਟੂਲ ਹਨ। ਆਪਣਾ ਪਸੰਦੀਦਾ ਵਿਕਾਸੀ ਢੰਗ ਚੁਣੋ:

### ਮਾਹੌਲ ਸੈਟਅੱਪ ਦੇ ਵਿਕਲਪ:

#### ਵਿਕਲਪ A: GitHub Codespaces (ਸਿਫਾਰਸ਼ ਕੀਤੀ)

**2 ਮਿੰਟਾਂ ਵਿੱਚ ਕੋਡਿੰਗ ਸ਼ੁਰੂ ਕਰੋ - ਕੋਈ ਲੋਕਲ ਸੈਟਅੱਪ ਦੀ ਲੋੜ ਨਹੀਂ!**

1. ਇਸ ਰਿਪੋਜ਼ਟਰੀ ਨੂੰ ਆਪਣੇ GitHub ਖਾਤੇ ਵਿੱਚ ਫੋਰਕ ਕਰੋ
   > **ਨੋਟ**: ਜੇ ਤੁਸੀਂ ਬੇਸਿਕ ਕਨਫਿਗਰੇਸ਼ਨ ਸੋਧਣਾ ਚਾਹੁੰਦੇ ਹੋ ਤਾਂ [ਡਿਵ ਕੰਟੇਨਰ ਕਨਫਿਗਰੇਸ਼ਨ](../../../.devcontainer/devcontainer.json) ਵੇਖੋ।
2. **Code** → **Codespaces** ਟੈਬ → **...** → **New with options...** 'ਤੇ ਕਲਿੱਕ ਕਰੋ।
3. ਡਿਫਾਲਟ ਵਰਤੋ – ਇਹ **Generative AI Java Development Environment** ਕਸਟਮ ਡਿਵ ਕੰਟੇਨਰ ਚੁਣੇਗਾ ਜੋ ਇਸ ਕੋਰਸ ਲਈ ਬਣਾਇਆ ਗਿਆ ਹੈ।
4. **Create codespace** 'ਤੇ ਕਲਿੱਕ ਕਰੋ।
5. ਮਾਹੌਲ ਤਿਆਰ ਹੋਣ ਲਈ ~2 ਮਿੰਟ ਰੁਕੋ।
6. [ਕਦਮ 2: GitHub ਟੋਕਨ ਬਣਾਓ](../../../02-SetupDevEnvironment) 'ਤੇ ਜਾਓ।

<img src="./images/codespaces.png" alt="Screenshot: Codespaces submenu" width="50%">

<img src="./images/image.png" alt="Screenshot: New with options" width="50%">

<img src="./images/codespaces-create.png" alt="Screenshot: Create codespace options" width="50%">

> **Codespaces ਦੇ ਫਾਇਦੇ**:
> - ਕੋਈ ਲੋਕਲ ਇੰਸਟਾਲੇਸ਼ਨ ਦੀ ਲੋੜ ਨਹੀਂ
> - ਕਿਸੇ ਵੀ ਡਿਵਾਈਸ 'ਤੇ ਬ੍ਰਾਊਜ਼ਰ ਨਾਲ ਕੰਮ ਕਰਦਾ ਹੈ
> - ਸਾਰੇ ਟੂਲ ਅਤੇ ਡਿਪੈਂਡੈਂਸੀਜ਼ ਨਾਲ ਪ੍ਰੀ-ਕਨਫਿਗਰਡ
> - ਨਿੱਜੀ ਖਾਤਿਆਂ ਲਈ ਪ੍ਰਤੀ ਮਹੀਨਾ 60 ਘੰਟੇ ਮੁਫ਼ਤ
> - ਸਾਰੇ ਸਿੱਖਣ ਵਾਲਿਆਂ ਲਈ ਇੱਕੋ ਜਿਹਾ ਮਾਹੌਲ

#### ਵਿਕਲਪ B: ਲੋਕਲ ਡਿਵ ਕੰਟੇਨਰ

**ਉਨ੍ਹਾਂ ਵਿਕਾਸਕਾਰਾਂ ਲਈ ਜੋ Docker ਨਾਲ ਲੋਕਲ ਵਿਕਾਸ ਨੂੰ ਤਰਜੀਹ ਦਿੰਦੇ ਹਨ**

1. ਇਸ ਰਿਪੋਜ਼ਟਰੀ ਨੂੰ ਆਪਣੇ ਲੋਕਲ ਮਸ਼ੀਨ 'ਤੇ ਫੋਰਕ ਅਤੇ ਕਲੋਨ ਕਰੋ।
   > **ਨੋਟ**: ਜੇ ਤੁਸੀਂ ਬੇਸਿਕ ਕਨਫਿਗਰੇਸ਼ਨ ਸੋਧਣਾ ਚਾਹੁੰਦੇ ਹੋ ਤਾਂ [ਡਿਵ ਕੰਟੇਨਰ ਕਨਫਿਗਰੇਸ਼ਨ](../../../.devcontainer/devcontainer.json) ਵੇਖੋ।
2. [Docker Desktop](https://www.docker.com/products/docker-desktop/) ਅਤੇ [VS Code](https://code.visualstudio.com/) ਇੰਸਟਾਲ ਕਰੋ।
3. VS Code ਵਿੱਚ [Dev Containers extension](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers) ਇੰਸਟਾਲ ਕਰੋ।
4. ਰਿਪੋਜ਼ਟਰੀ ਫੋਲਡਰ ਨੂੰ VS Code ਵਿੱਚ ਖੋਲ੍ਹੋ।
5. ਜਦੋਂ ਪ੍ਰਮਾਣਿਤ ਕੀਤਾ ਜਾਵੇ, **Reopen in Container** 'ਤੇ ਕਲਿੱਕ ਕਰੋ (ਜਾਂ `Ctrl+Shift+P` → "Dev Containers: Reopen in Container" ਵਰਤੋ)।
6. ਕੰਟੇਨਰ ਨੂੰ ਬਣਨ ਅਤੇ ਸ਼ੁਰੂ ਹੋਣ ਲਈ ਰੁਕੋ।
7. [ਕਦਮ 2: GitHub ਟੋਕਨ ਬਣਾਓ](../../../02-SetupDevEnvironment) 'ਤੇ ਜਾਓ।

<img src="./images/devcontainer.png" alt="Screenshot: Dev container setup" width="50%">

<img src="./images/image-3.png" alt="Screenshot: Dev container build complete" width="50%">

#### ਵਿਕਲਪ C: ਆਪਣੀ ਮੌਜੂਦਾ ਲੋਕਲ ਇੰਸਟਾਲੇਸ਼ਨ ਵਰਤੋ

**ਉਨ੍ਹਾਂ ਵਿਕਾਸਕਾਰਾਂ ਲਈ ਜਿਨ੍ਹਾਂ ਕੋਲ ਮੌਜੂਦਾ ਜਾਵਾ ਮਾਹੌਲ ਹੈ**

ਪੂਰਵ ਸ਼ਰਤਾਂ:
- [Java 21+](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) 
- [Maven 3.9+](https://maven.apache.org/download.cgi)
- [VS Code](https://code.visualstudio.com) ਜਾਂ ਤੁਹਾਡਾ ਪਸੰਦੀਦਾ IDE

ਕਦਮ:
1. ਇਸ ਰਿਪੋਜ਼ਟਰੀ ਨੂੰ ਆਪਣੇ ਲੋਕਲ ਮਸ਼ੀਨ 'ਤੇ ਕਲੋਨ ਕਰੋ।
2. ਪ੍ਰੋਜੈਕਟ ਨੂੰ ਆਪਣੇ IDE ਵਿੱਚ ਖੋਲ੍ਹੋ।
3. [ਕਦਮ 2: GitHub ਟੋਕਨ ਬਣਾਓ](../../../02-SetupDevEnvironment) 'ਤੇ ਜਾਓ।

> **ਪ੍ਰੋ ਟਿਪ**: ਜੇ ਤੁਹਾਡੇ ਕੋਲ ਘੱਟ-ਸਪੈਕ ਮਸ਼ੀਨ ਹੈ ਪਰ ਤੁਸੀਂ ਲੋਕਲ VS Code ਚਾਹੁੰਦੇ ਹੋ, ਤਾਂ GitHub Codespaces ਵਰਤੋ! ਤੁਸੀਂ ਆਪਣੇ ਲੋਕਲ VS Code ਨੂੰ ਕਲਾਉਡ-ਹੋਸਟ ਕੀਤੇ Codespace ਨਾਲ ਕਨੈਕਟ ਕਰ ਸਕਦੇ ਹੋ।

<img src="./images/image-2.png" alt="Screenshot: created local devcontainer instance" width="50%">

## ਕਦਮ 2: GitHub ਪੈਰਸਨਲ ਐਕਸੈਸ ਟੋਕਨ ਬਣਾਓ

1. [GitHub Settings](https://github.com/settings/profile) 'ਤੇ ਜਾਓ ਅਤੇ ਆਪਣੇ ਪ੍ਰੋਫਾਈਲ ਮੀਨੂ ਤੋਂ **Settings** ਚੁਣੋ।
2. ਖੱਬੇ ਸਾਈਡਬਾਰ ਵਿੱਚ, **Developer settings** 'ਤੇ ਕਲਿੱਕ ਕਰੋ (ਆਮ ਤੌਰ 'ਤੇ ਹੇਠਾਂ)।
3. **Personal access tokens** ਹੇਠ, **Fine-grained tokens** 'ਤੇ ਕਲਿੱਕ ਕਰੋ (ਜਾਂ ਇਸ ਸਿੱਧੇ [ਲਿੰਕ](https://github.com/settings/personal-access-tokens) ਨੂੰ ਫੋਲੋ ਕਰੋ)।
4. **Generate new token** 'ਤੇ ਕਲਿੱਕ ਕਰੋ।
5. "Token name" ਹੇਠ, ਇੱਕ ਵਰਣਨਾਤਮਕ ਨਾਮ ਦਿਓ (ਜਿਵੇਂ, `GenAI-Java-Course-Token`)।
6. ਮਿਆਦ ਦੀ ਮਿਤੀ ਸੈੱਟ ਕਰੋ (ਸੁਰੱਖਿਆ ਲਈ ਸਿਫਾਰਸ਼ ਕੀਤੀ: 7 ਦਿਨ)।
7. "Resource owner" ਹੇਠ, ਆਪਣਾ ਯੂਜ਼ਰ ਖਾਤਾ ਚੁਣੋ।
8. "Repository access" ਹੇਠ, ਉਹ ਰਿਪੋਜ਼ਟਰੀ ਚੁਣੋ ਜੋ ਤੁਸੀਂ GitHub ਮਾਡਲਾਂ ਨਾਲ ਵਰਤਣਾ ਚਾਹੁੰਦੇ ਹੋ (ਜਾਂ "All repositories" ਜੇ ਲੋੜ ਹੋਵੇ)।
9. "Repository permissions" ਹੇਠ, **Models** ਲੱਭੋ ਅਤੇ ਇਸਨੂੰ **Read and write** 'ਤੇ ਸੈੱਟ ਕਰੋ।
10. **Generate token** 'ਤੇ ਕਲਿੱਕ ਕਰੋ।
11. **ਹੁਣੇ ਆਪਣਾ ਟੋਕਨ ਕਾਪੀ ਅਤੇ ਸੇਵ ਕਰੋ** – ਤੁਸੀਂ ਇਸਨੂੰ ਮੁੜ ਨਹੀਂ ਦੇਖੋਗੇ!

> **ਸੁਰੱਖਿਆ ਟਿਪ**: ਆਪਣੀ ਪਹੁੰਚ ਟੋਕਨ ਲਈ ਘੱਟੋ-ਘੱਟ ਲੋੜੀਂਦੇ ਸਕੋਪ ਅਤੇ ਸਭ ਤੋਂ ਛੋਟੀ ਮਿਆਦ ਦੀ ਮਿਆਦ ਵਰਤੋ।

## ਕਦਮ 3: GitHub ਮਾਡਲ ਉਦਾਹਰਣ ਨਾਲ ਆਪਣੀ ਸੈਟਅੱਪ ਦੀ ਜਾਂਚ ਕਰੋ

ਜਦੋਂ ਤੁਹਾਡਾ ਵਿਕਾਸੀ ਮਾਹੌਲ ਤਿਆਰ ਹੋ ਜਾਵੇ, ਆਓ GitHub ਮਾਡਲ ਇੰਟੀਗ੍ਰੇਸ਼ਨ ਨੂੰ ਸਾਡੇ ਉਦਾਹਰਣ ਐਪਲੀਕੇਸ਼ਨ ਨਾਲ ਜਾਂਚੀਏ ਜੋ [`02-SetupDevEnvironment/examples/github-models`](../../../02-SetupDevEnvironment/examples/github-models) ਵਿੱਚ ਹੈ।

1. ਆਪਣੇ ਵਿਕਾਸੀ ਮਾਹੌਲ ਵਿੱਚ ਟਰਮੀਨਲ ਖੋਲ੍ਹੋ।
2. GitHub ਮਾਡਲ ਉਦਾਹਰਣ ਵਿੱਚ ਜਾਓ:
   ```bash
   cd 02-SetupDevEnvironment/examples/github-models
   ```
3. ਆਪਣਾ GitHub ਟੋਕਨ ਇੱਕ ਮਾਹੌਲ ਵੈਰੀਏਬਲ ਵਜੋਂ ਸੈੱਟ ਕਰੋ:
   ```bash
   # macOS/Linux
   export GITHUB_TOKEN=your_token_here
   
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_token_here"
   ```

4. ਐਪਲੀਕੇਸ਼ਨ ਚਲਾਓ:
   ```bash
   mvn compile exec:java -Dexec.mainClass="com.example.githubmodels.App"
   ```

ਤੁਹਾਨੂੰ ਇਸ ਤਰ੍ਹਾਂ ਦਾ ਆਉਟਪੁੱਟ ਵੇਖਣਾ ਚਾਹੀਦਾ ਹੈ:
```text
Using model: gpt-4.1-nano
Sending request to GitHub Models...
Response: Hello World!
```

### ਉਦਾਹਰਣ ਕੋਡ ਨੂੰ ਸਮਝਣਾ

ਸਭ ਤੋਂ ਪਹਿਲਾਂ, ਆਓ ਸਮਝੀਏ ਕਿ ਅਸੀਂ ਕੀ ਚਲਾਇਆ। `examples/github-models` ਹੇਠਲਾ ਉਦਾਹਰਣ OpenAI Java SDK ਵਰਤਦਾ ਹੈ GitHub ਮਾਡਲਾਂ ਨਾਲ ਕਨੈਕਟ ਕਰਨ ਲਈ:

**ਇਹ ਕੋਡ ਕੀ ਕਰਦਾ ਹੈ:**
- **GitHub ਮਾਡਲਾਂ ਨਾਲ ਕਨੈਕਟ ਕਰਦਾ ਹੈ** ਤੁਹਾਡੇ ਪੈਰਸਨਲ ਐਕਸੈਸ ਟੋਕਨ ਦੀ ਵਰਤੋਂ ਕਰਕੇ
- **ਇੱਕ ਸਧਾਰਨ ਸੁਨੇਹਾ ਭੇਜਦਾ ਹੈ** "Say Hello World!" ਮਾਡਲ ਨੂੰ
- **ਮਾਡਲ ਤੋਂ ਜਵਾਬ ਪ੍ਰਾਪਤ ਕਰਦਾ ਹੈ** ਅਤੇ ਦਿਖਾਉਂਦਾ ਹੈ
- **ਤਸਦੀਕ ਕਰਦਾ ਹੈ** ਕਿ ਤੁਹਾਡੀ ਸੈਟਅੱਪ ਸਹੀ ਤਰੀਕੇ ਨਾਲ ਕੰਮ ਕਰ ਰਹੀ ਹੈ

**ਮੁੱਖ ਡਿਪੈਂਡੈਂਸੀ** (`pom.xml` ਵਿੱਚ):
```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

**ਮੁੱਖ ਕੋਡ** (`App.java`):
```java
// Connect to GitHub Models using OpenAI Java SDK
OpenAIClient client = OpenAIOkHttpClient.builder()
    .apiKey(pat)
    .baseUrl("https://models.inference.ai.azure.com")
    .build();

// Create chat completion request
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
    .model(modelId)
    .addSystemMessage("You are a concise assistant.")
    .addUserMessage("Say Hello World!")
    .build();

// Get AI response
ChatCompletion response = client.chat().completions().create(params);
System.out.println("Response: " + response.choices().get(0).message().content().orElse("No response content"));
```

## ਸੰਖੇਪ

ਵਧੀਆ! ਹੁਣ ਤੁਹਾਡੀ ਸੈਟਅੱਪ ਤਿਆਰ ਹੈ:

- GitHub ਪੈਰਸਨਲ ਐਕਸੈਸ ਟੋਕਨ ਬਣਾਇਆ ਜਿਸ ਵਿੱਚ AI ਮਾਡਲ ਪਹੁੰਚ ਲਈ ਸਹੀ ਅਧਿਕਾਰ ਹਨ
- ਆਪਣਾ ਜਾਵਾ ਵਿਕਾਸੀ ਮਾਹੌਲ ਚਲਾਇਆ (ਚਾਹੇ ਉਹ Codespaces, ਡਿਵ ਕੰਟੇਨਰ, ਜਾਂ ਲੋਕਲ ਹੋਵੇ)
- OpenAI Java SDK ਦੀ ਵਰਤੋਂ ਕਰਕੇ GitHub ਮਾਡਲਾਂ ਨਾਲ ਕਨੈਕਟ ਕੀਤਾ ਮੁਫ਼ਤ AI ਵਿਕਾਸ ਲਈ
- ਇੱਕ ਸਧਾਰਣ ਉਦਾਹਰਣ ਨਾਲ ਸਭ ਕੁਝ ਜਾਂਚਿਆ ਜੋ AI ਮਾਡਲਾਂ ਨਾਲ ਗੱਲ ਕਰਦਾ ਹੈ

## ਅਗਲੇ ਕਦਮ

[ਅਧਿਆਇ 3: ਮੁੱਖ ਜਨਰੇਟਿਵ AI ਤਕਨੀਕਾਂ](../03-CoreGenerativeAITechniques/README.md)

## ਮਸਲੇ ਹੱਲ

ਮਸਲੇ ਆ ਰਹੇ ਹਨ? ਇੱਥੇ ਆਮ ਸਮੱਸਿਆਵਾਂ ਅਤੇ ਹੱਲ ਹਨ:

- **ਟੋਕਨ ਕੰਮ ਨਹੀਂ ਕਰ ਰਿਹਾ?** 
  - ਯਕੀਨੀ ਬਣਾਓ ਕਿ ਤੁਸੀਂ ਪੂਰਾ ਟੋਕਨ ਕਾਪੀ ਕੀਤਾ ਹੈ ਬਿਨਾਂ ਕਿਸੇ ਵਾਧੂ ਖਾਲੀ ਸਥਾਨ ਦੇ
  - ਟੋਕਨ ਨੂੰ ਸਹੀ ਤਰੀਕੇ ਨਾਲ ਮਾਹੌਲ ਵੈਰੀਏਬਲ ਵਜੋਂ ਸੈੱਟ ਕੀਤਾ ਹੈ ਜਾਂ ਨਹੀਂ ਜਾਂਚੋ
  - ਯਕੀਨੀ ਬਣਾਓ ਕਿ ਤੁਹਾਡੇ ਟੋਕਨ ਕੋਲ ਸਹੀ ਅਧਿਕਾਰ ਹਨ (Models: Read and write)

- **Maven ਨਹੀਂ ਮਿਲ ਰਿਹਾ?** 
  - ਜੇ ਤੁਸੀਂ ਡਿਵ ਕੰਟੇਨਰ/Codespaces ਵਰਤ ਰਹੇ ਹੋ, Maven ਪਹਿਲਾਂ ਤੋਂ ਇੰਸਟਾਲ ਹੋਣਾ ਚਾਹੀਦਾ ਹੈ
  - ਲੋਕਲ ਸੈਟਅੱਪ ਲਈ, ਯਕੀਨੀ ਬਣਾਓ ਕਿ Java 21+ ਅਤੇ Maven 3.9+ ਇੰਸਟਾਲ ਹਨ
  - `mvn --version` ਚਲਾਕੇ ਇੰਸਟਾਲੇਸ਼ਨ ਦੀ ਪੁਸ਼ਟੀ ਕਰੋ

- **ਕਨੈਕਸ਼ਨ ਸਮੱਸਿਆਵਾਂ?** 
  - ਆਪਣੀ ਇੰਟਰਨੈਟ ਕਨੈਕਸ਼ਨ ਜਾਂਚੋ
  - ਯਕੀਨੀ ਬਣਾਓ ਕਿ GitHub ਤੁਹਾਡੇ ਨੈੱਟਵਰਕ ਤੋਂ ਪਹੁੰਚਯੋਗ ਹੈ
  - ਯਕੀਨੀ ਬਣਾਓ ਕਿ ਤੁਸੀਂ ਕਿਸੇ ਫਾਇਰਵਾਲ ਦੇ ਪਿੱਛੇ ਨਹੀਂ ਹੋ ਜੋ GitHub ਮਾਡਲ ਐਂਡਪੌਇੰਟ ਨੂੰ ਰੋਕ ਰਿਹਾ ਹੈ

- **ਡਿਵ ਕੰਟੇਨਰ ਸ਼ੁਰੂ

**ਅਸਵੀਕਰਤੀ**:  
ਇਹ ਦਸਤਾਵੇਜ਼ AI ਅਨੁਵਾਦ ਸੇਵਾ [Co-op Translator](https://github.com/Azure/co-op-translator) ਦੀ ਵਰਤੋਂ ਕਰਕੇ ਅਨੁਵਾਦ ਕੀਤਾ ਗਿਆ ਹੈ। ਜਦੋਂ ਕਿ ਅਸੀਂ ਸਹੀ ਹੋਣ ਦਾ ਯਤਨ ਕਰਦੇ ਹਾਂ, ਕਿਰਪਾ ਕਰਕੇ ਧਿਆਨ ਦਿਓ ਕਿ ਸਵੈਚਾਲਿਤ ਅਨੁਵਾਦਾਂ ਵਿੱਚ ਗਲਤੀਆਂ ਜਾਂ ਅਸੁਣਤੀਆਂ ਹੋ ਸਕਦੀਆਂ ਹਨ। ਇਸ ਦਸਤਾਵੇਜ਼ ਦਾ ਮੂਲ ਰੂਪ, ਜੋ ਇਸਦੀ ਮੂਲ ਭਾਸ਼ਾ ਵਿੱਚ ਹੈ, ਪ੍ਰਮਾਣਿਕ ਸਰੋਤ ਮੰਨਿਆ ਜਾਣਾ ਚਾਹੀਦਾ ਹੈ। ਮਹੱਤਵਪੂਰਨ ਜਾਣਕਾਰੀ ਲਈ, ਪੇਸ਼ੇਵਰ ਮਨੁੱਖੀ ਅਨੁਵਾਦ ਦੀ ਸਿਫਾਰਸ਼ ਕੀਤੀ ਜਾਂਦੀ ਹੈ। ਇਸ ਅਨੁਵਾਦ ਦੇ ਪ੍ਰਯੋਗ ਤੋਂ ਪੈਦਾ ਹੋਣ ਵਾਲੇ ਕਿਸੇ ਵੀ ਗਲਤਫਹਿਮੀ ਜਾਂ ਗਲਤ ਵਿਆਖਿਆ ਲਈ ਅਸੀਂ ਜ਼ਿੰਮੇਵਾਰ ਨਹੀਂ ਹਾਂ।