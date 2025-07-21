<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T16:34:06+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "fr"
}
-->
# Application en Ligne de Commande Foundry Local

>**Note** : Ce chapitre inclut un [**Tutoriel**](./TUTORIAL.md) qui vous guide à travers l'exécution des exemples finalisés.

Une application simple en ligne de commande Spring Boot qui démontre comment se connecter à Foundry Local en utilisant le SDK Java OpenAI.

## Ce que Vous Apprendrez

- Comment intégrer Foundry Local avec des applications Spring Boot en utilisant le SDK Java OpenAI
- Les meilleures pratiques pour le développement et les tests d'IA en local

## Table des Matières

- [Ce que Vous Apprendrez](../../../../04-PracticalSamples/foundrylocal)
- [Prérequis](../../../../04-PracticalSamples/foundrylocal)
  - [Installation de Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [Vérification](../../../../04-PracticalSamples/foundrylocal)
- [Configuration](../../../../04-PracticalSamples/foundrylocal)
- [Démarrage Rapide](../../../../04-PracticalSamples/foundrylocal)
- [Ce que Fait l'Application](../../../../04-PracticalSamples/foundrylocal)
- [Exemple de Résultat](../../../../04-PracticalSamples/foundrylocal)
- [Architecture](../../../../04-PracticalSamples/foundrylocal)
- [Points Forts du Code](../../../../04-PracticalSamples/foundrylocal)
  - [Intégration du SDK Java OpenAI](../../../../04-PracticalSamples/foundrylocal)
  - [API de Complétion de Chat](../../../../04-PracticalSamples/foundrylocal)
- [Dépannage](../../../../04-PracticalSamples/foundrylocal)

## Prérequis

> **⚠️ Note** : Cette application **ne fonctionne pas dans le devcontainer fourni** car elle nécessite que Foundry Local soit installé et en cours d'exécution sur le système hôte.

### Installation de Foundry Local

Avant d'exécuter cette application, vous devez installer et démarrer Foundry Local. Suivez ces étapes :

1. **Assurez-vous que votre système répond aux exigences** :
   - **Système d'exploitation** : Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025, ou macOS
   - **Matériel** : 
     - Minimum : 8 Go de RAM, 3 Go d'espace disque libre
     - Recommandé : 16 Go de RAM, 15 Go d'espace disque libre
   - **Réseau** : Connexion Internet pour le téléchargement initial du modèle (optionnel pour une utilisation hors ligne)
   - **Accélération (optionnel)** : GPU NVIDIA (série 2000 ou plus récent), GPU AMD (série 6000 ou plus récent), Qualcomm Snapdragon X Elite (8 Go ou plus de mémoire), ou Apple silicon
   - **Permissions** : Privilèges administratifs pour installer des logiciels sur votre appareil

2. **Installez Foundry Local** :
   
   **Pour Windows :**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **Pour macOS :**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Alternativement, vous pouvez télécharger l'installateur depuis le [dépôt GitHub de Foundry Local](https://github.com/microsoft/Foundry-Local).

3. **Démarrez votre premier modèle** :

   ```bash
   foundry model run phi-3.5-mini
   ```

   Le modèle se télécharge (ce qui peut prendre quelques minutes, selon la vitesse de votre connexion Internet) puis s'exécute. Foundry Local sélectionne automatiquement la meilleure variante de modèle pour votre système (CUDA pour les GPU NVIDIA, version CPU sinon).

4. **Testez le modèle** en posant une question dans le même terminal :

   ```bash
   Why is the sky blue?
   ```

   Vous devriez voir une réponse du modèle Phi expliquant pourquoi le ciel est bleu.

### Vérification

Vous pouvez vérifier que tout fonctionne correctement avec ces commandes :

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

Vous pouvez également visiter `http://localhost:5273` dans votre navigateur pour voir l'interface web de Foundry Local.

## Configuration

L'application peut être configurée via `application.properties` :

- `foundry.local.base-url` - URL de base pour Foundry Local (par défaut : http://localhost:5273)
- `foundry.local.model` - Modèle d'IA à utiliser (par défaut : Phi-3.5-mini-instruct-cuda-gpu)

> **Note** : Le nom du modèle dans la configuration doit correspondre à la variante spécifique que Foundry Local a téléchargée pour votre système. Lorsque vous exécutez `foundry model run phi-3.5-mini`, Foundry Local sélectionne et télécharge automatiquement la meilleure variante (CUDA pour les GPU NVIDIA, version CPU sinon). Utilisez `foundry model list` pour voir le nom exact du modèle disponible dans votre instance locale.

## Démarrage Rapide

### 1. Accédez au répertoire de l'application Foundry Local
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Exécutez l'Application

```bash
mvn spring-boot:run
```

Ou construisez et exécutez le JAR :

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Dépendances

Cette application utilise le SDK Java OpenAI pour communiquer avec Foundry Local. La dépendance clé est :

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

L'application est préconfigurée pour se connecter à Foundry Local fonctionnant sur le port par défaut.

## Ce que Fait l'Application

Lorsque vous exécutez l'application :

1. **Elle démarre** en tant qu'application en ligne de commande (sans serveur web)
2. **Envoie automatiquement** un message de test : "Bonjour ! Pouvez-vous me dire ce que vous êtes et quel modèle vous exécutez ?"
3. **Affiche la réponse** de Foundry Local dans la console
4. **Se termine proprement** après la démonstration

## Exemple de Résultat

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Architecture

- **Application.java** - Application principale Spring Boot avec CommandLineRunner
- **FoundryLocalService.java** - Service utilisant le SDK Java OpenAI pour communiquer avec Foundry Local
- Utilise **le SDK Java OpenAI** pour des appels API typés
- Sérialisation/désérialisation JSON automatique gérée par le SDK
- Configuration propre grâce aux annotations `@Value` et `@PostConstruct` de Spring

## Points Forts du Code

### Intégration du SDK Java OpenAI

L'application utilise le SDK Java OpenAI pour créer un client configuré pour Foundry Local :

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### API de Complétion de Chat

Faire des requêtes de complétion de chat est simple et typé :

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Dépannage

Si vous rencontrez des erreurs de connexion :
1. Vérifiez que Foundry Local est en cours d'exécution sur `http://localhost:5273`
2. Vérifiez qu'une variante du modèle Phi-3.5-mini est disponible avec `foundry model list`
3. Assurez-vous que le nom du modèle dans `application.properties` correspond exactement au nom du modèle affiché dans la liste
4. Assurez-vous qu'aucun pare-feu ne bloque la connexion

Problèmes courants :
- **Modèle introuvable** : Exécutez `foundry model run phi-3.5-mini` pour télécharger et démarrer le modèle
- **Service non démarré** : Le service Foundry Local peut s'être arrêté ; redémarrez-le avec la commande de démarrage du modèle
- **Nom de modèle incorrect** : Utilisez `foundry model list` pour voir les modèles disponibles et mettez à jour votre configuration en conséquence

**Avertissement** :  
Ce document a été traduit à l'aide du service de traduction automatique [Co-op Translator](https://github.com/Azure/co-op-translator). Bien que nous nous efforcions d'assurer l'exactitude, veuillez noter que les traductions automatisées peuvent contenir des erreurs ou des inexactitudes. Le document original dans sa langue d'origine doit être considéré comme la source faisant autorité. Pour des informations critiques, il est recommandé de recourir à une traduction professionnelle réalisée par un humain. Nous déclinons toute responsabilité en cas de malentendus ou d'interprétations erronées résultant de l'utilisation de cette traduction.