<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "efd82efe50711d7e257eb943151d682c",
  "translation_date": "2025-07-27T13:32:34+00:00",
  "source_file": "02-SetupDevEnvironment/examples/basic-chat-azure/README.md",
  "language_code": "fr"
}
-->
# Chat de Base avec Azure OpenAI - Exemple de Bout en Bout

Cet exemple montre comment créer une application Spring Boot simple qui se connecte à Azure OpenAI et teste votre configuration.

## Table des Matières

- [Prérequis](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Démarrage Rapide](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Options de Configuration](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Option 1 : Variables d'Environnement (fichier .env) - Recommandé](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Option 2 : Secrets GitHub Codespace](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Exécution de l'Application](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Avec Maven](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Avec VS Code](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Résultat Attendu](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Référence de Configuration](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Variables d'Environnement](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Configuration Spring](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Dépannage](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Problèmes Courants](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
  - [Mode Debug](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Étapes Suivantes](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)
- [Ressources](../../../../../02-SetupDevEnvironment/examples/basic-chat-azure)

## Prérequis

Avant d'exécuter cet exemple, assurez-vous d'avoir :

- Complété le [guide de configuration Azure OpenAI](../../getting-started-azure-openai.md)  
- Déployé une ressource Azure OpenAI (via le portail Azure AI Foundry)  
- Déployé le modèle gpt-4o-mini (ou une alternative)  
- Une clé API et une URL de point de terminaison depuis Azure  

## Démarrage Rapide

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/examples/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Options de Configuration

### Option 1 : Variables d'Environnement (fichier .env) - Recommandé

**Étape 1 : Créez votre fichier de configuration**  
```bash
cp .env.example .env
```

**Étape 2 : Ajoutez vos identifiants Azure OpenAI**  
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Note de Sécurité** :  
> - Ne jamais ajouter votre fichier `.env` au contrôle de version  
> - Le fichier `.env` est déjà inclus dans `.gitignore`  
> - Gardez vos clés API sécurisées et changez-les régulièrement  

### Option 2 : Secrets GitHub Codespace

Pour GitHub Codespaces, configurez ces secrets dans votre dépôt :  
- `AZURE_AI_KEY` - Votre clé API Azure OpenAI  
- `AZURE_AI_ENDPOINT` - L'URL de votre point de terminaison Azure OpenAI  

L'application détecte et utilise automatiquement ces secrets.

### Alternative : Variables d'Environnement Directes

<details>
<summary>Cliquez pour voir les commandes spécifiques à votre plateforme</summary>

**Linux/macOS (bash/zsh) :**  
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (Invite de Commandes) :**  
```cmd
set AZURE_AI_KEY=your-actual-api-key-here
set AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (PowerShell) :**  
```powershell
$env:AZURE_AI_KEY="your-actual-api-key-here"
$env:AZURE_AI_ENDPOINT="https://your-hub-name.openai.azure.com/"
```
</details>

## Exécution de l'Application

### Avec Maven

```bash
mvn spring-boot:run
```

### Avec VS Code

1. Ouvrez le projet dans VS Code  
2. Appuyez sur `F5` ou utilisez le panneau "Run and Debug"  
3. Sélectionnez la configuration "Spring Boot-BasicChatApplication"  

> **Note** : La configuration VS Code charge automatiquement votre fichier .env  

### Résultat Attendu

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

## Référence de Configuration

### Variables d'Environnement

| Variable | Description | Obligatoire | Exemple |
|----------|-------------|-------------|---------|
| `AZURE_AI_KEY` | Clé API Azure OpenAI | Oui | `abc123...` |
| `AZURE_AI_ENDPOINT` | URL du point de terminaison Azure OpenAI | Oui | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Nom du déploiement du modèle | Non | `gpt-4o-mini` (par défaut) |

### Configuration Spring

Le fichier `application.yml` configure :  
- **Clé API** : `${AZURE_AI_KEY}` - Depuis la variable d'environnement  
- **Point de Terminaison** : `${AZURE_AI_ENDPOINT}` - Depuis la variable d'environnement  
- **Modèle** : `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Depuis la variable d'environnement avec une valeur par défaut  
- **Température** : `0.7` - Contrôle la créativité (0.0 = déterministe, 1.0 = créatif)  
- **Max Tokens** : `500` - Longueur maximale de la réponse  

## Dépannage

### Problèmes Courants

<details>
<summary><strong>Erreur : "La clé API n'est pas valide"</strong></summary>

- Vérifiez que votre `AZURE_AI_KEY` est correctement définie dans votre fichier `.env`  
- Assurez-vous que la clé API est copiée exactement depuis le portail Azure AI Foundry  
- Vérifiez qu'il n'y a pas d'espaces ou de guillemets supplémentaires autour de la clé  
</details>

<details>
<summary><strong>Erreur : "Le point de terminaison n'est pas valide"</strong></summary>

- Assurez-vous que votre `AZURE_AI_ENDPOINT` inclut l'URL complète (par ex. `https://your-hub-name.openai.azure.com/`)  
- Vérifiez la cohérence des barres obliques finales  
- Confirmez que le point de terminaison correspond à votre région de déploiement Azure  
</details>

<details>
<summary><strong>Erreur : "Le déploiement n'a pas été trouvé"</strong></summary>

- Vérifiez que le nom de votre déploiement de modèle correspond exactement à celui déployé dans Azure  
- Assurez-vous que le modèle est déployé avec succès et actif  
- Essayez d'utiliser le nom de déploiement par défaut : `gpt-4o-mini`  
</details>

<details>
<summary><strong>VS Code : Les variables d'environnement ne se chargent pas</strong></summary>

- Assurez-vous que votre fichier `.env` est dans le répertoire racine du projet (au même niveau que `pom.xml`)  
- Essayez d'exécuter `mvn spring-boot:run` dans le terminal intégré de VS Code  
- Vérifiez que l'extension Java de VS Code est correctement installée  
- Confirmez que la configuration de lancement contient `"envFile": "${workspaceFolder}/.env"`  
</details>

### Mode Debug

Pour activer les journaux détaillés, décommentez ces lignes dans `application.yml` :  

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Étapes Suivantes

**Configuration Terminée !** Continuez votre apprentissage :  

[Chapitre 3 : Techniques Fondamentales d'IA Générative](../../../03-CoreGenerativeAITechniques/README.md)

## Ressources

- [Documentation Spring AI Azure OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)  
- [Documentation du Service Azure OpenAI](https://learn.microsoft.com/azure/ai-services/openai/)  
- [Portail Azure AI Foundry](https://ai.azure.com/)  
- [Documentation Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)  

**Avertissement** :  
Ce document a été traduit à l'aide du service de traduction automatique [Co-op Translator](https://github.com/Azure/co-op-translator). Bien que nous nous efforcions d'assurer l'exactitude, veuillez noter que les traductions automatisées peuvent contenir des erreurs ou des inexactitudes. Le document original dans sa langue d'origine doit être considéré comme la source faisant autorité. Pour des informations critiques, il est recommandé de recourir à une traduction humaine professionnelle. Nous déclinons toute responsabilité en cas de malentendus ou d'interprétations erronées résultant de l'utilisation de cette traduction.