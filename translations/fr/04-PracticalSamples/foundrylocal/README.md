# Tutoriel Foundry Local Spring Boot

## Table des matières

- [Prérequis](#prérequis)
- [Présentation du projet](#présentation-du-projet)
- [Comprendre le code](#comprendre-le-code)
  - [1. Configuration de l'application (application.properties)](#1-configuration-de-lapplication-applicationproperties)
  - [2. Classe principale de l'application (Application.java)](#2-classe-principale-de-lapplication-applicationjava)
  - [3. Couche service IA (FoundryLocalService.java)](#3-couche-service-ia-foundrylocalservicejava)
  - [4. Dépendances du projet (pom.xml)](#4-dépendances-du-projet-pomxml)
- [Comment tout fonctionne ensemble](#comment-tout-fonctionne-ensemble)
- [Installation de Foundry Local](#installation-de-foundry-local)
- [Exécution de l'application](#exécution-de-lapplication)
- [Résultat attendu](#résultat-attendu)
- [Étapes suivantes](#étapes-suivantes)
- [Dépannage](#dépannage)


## Prérequis

Avant de commencer ce tutoriel, assurez-vous d'avoir :

- **Java 21 ou une version supérieure** installé sur votre système
- **Maven 3.6+** pour construire le projet
- **Foundry Local** installé et en cours d'exécution

### **Installer Foundry Local :**

> **Remarque :** Foundry Local CLI est disponible uniquement sur **Windows** et **macOS**. Linux est supporté via les [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Vérifiez l'installation :
```bash
foundry --version
```

## Présentation du projet

Ce projet est composé de quatre composants principaux :

1. **Application.java** - Point d'entrée principal de l'application Spring Boot
2. **FoundryLocalService.java** - Couche service qui gère la communication avec l'IA
3. **application.properties** - Configuration pour la connexion à Foundry Local
4. **pom.xml** - Dépendances Maven et configuration du projet

## Comprendre le code

### 1. Configuration de l'application (application.properties)

**Fichier :** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Ce que cela fait :**
- **base-url** : Spécifie où Foundry Local est en cours d'exécution, incluant le chemin `/v1` pour compatibilité avec l'API OpenAI. Le port par défaut est `5273`. Si le port diffère, vérifiez-le avec la commande `foundry service status`.
- **model** (optionnel) : Nom du modèle d'IA à utiliser pour la génération de texte. **Par défaut, l'application détecte automatiquement le modèle** en interrogeant l'endpoint `/v1/models` de Foundry Local au démarrage, donc vous n'avez pas besoin de le configurer. Vous pouvez toujours le définir explicitement pour remplacer la détection automatique si nécessaire.

**Concept clé :** Spring Boot charge automatiquement ces propriétés et les rend disponibles à votre application via l'annotation `@Value`.

### 2. Classe principale de l'application (Application.java)

**Fichier :** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // Aucun serveur web nécessaire
        app.run(args);
    }
```

**Ce que cela fait :**
- `@SpringBootApplication` active la configuration automatique Spring Boot
- `WebApplicationType.NONE` indique à Spring qu'il s'agit d'une application en ligne de commande, pas d'un serveur web
- La méthode principale démarre l'application Spring

**Le Demo Runner :**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        System.out.println("Calling Foundry Local service...");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
        System.out.println("=========================");
    };
}
```

**Ce que cela fait :**
- `@Bean` crée un composant géré par Spring
- `CommandLineRunner` exécute du code après le démarrage de Spring Boot
- `foundryLocalService` est injecté automatiquement par Spring (injection de dépendance)
- Envoie un message test à l'IA et affiche la réponse

### 3. Couche service IA (FoundryLocalService.java)

**Fichier :** `src/main/java/com/example/FoundryLocalService.java`

#### Injection de configuration :
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Détecté automatiquement si vide
```

**Ce que cela fait :**
- `@Service` indique à Spring que cette classe fournit la logique métier
- `@Value` injecte les valeurs de configuration à partir de application.properties
- Le modèle par défaut est vide, ce qui déclenche la **détection automatique** depuis Foundry Local au démarrage. Cela signifie que l'app fonctionne avec n'importe quel modèle chargé dans Foundry Local sans configuration manuelle.

#### Initialisation du client :
```java
@PostConstruct
public void init() {
    // Détecter automatiquement le modèle à partir de Foundry Local s'il n'est pas configuré explicitement
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // L'URL de base inclut déjà /v1 depuis la configuration
            .apiKey("not-needed")            // Le serveur local n'a pas besoin d'une vraie clé API
            .build();
}
```

**Ce que cela fait :**
- `@PostConstruct` exécute cette méthode après la création du service par Spring
- Si aucun modèle n'est configuré, elle interroge l'endpoint `/v1/models` de Foundry Local et sélectionne le premier modèle chargé
- Crée un client OpenAI qui pointe vers votre instance locale Foundry Local
- L'URL de base dans `application.properties` inclut déjà `/v1` pour compatibilité avec l'API OpenAI
- La clé API est définie sur "not-needed" car le développement local ne requiert pas d'authentification

#### Méthode chat :
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Quel modèle d'IA utiliser
                .addUserMessage(message)         // Votre question/invite
                .maxCompletionTokens(150)        // Limiter la longueur de la réponse
                .temperature(0.7)                // Contrôler la créativité (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Extraire la réponse de l'IA du résultat de l'API
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**Ce que cela fait :**
- **ChatCompletionCreateParams** : Configure la requête IA
  - `model` : Spécifie quel modèle IA utiliser (doit correspondre exactement à l'ID dans `foundry model list`)
  - `addUserMessage` : Ajoute votre message à la conversation
  - `maxCompletionTokens` : Limite la longueur de la réponse (économise des ressources)
  - `temperature` : Contrôle l'aléatoire (0.0 = déterministe, 1.0 = créatif)
- **Appel API** : Envoie la requête à Foundry Local
- **Gestion de la réponse** : Extrait en toute sécurité le texte de la réponse IA
- **Gestion des erreurs** : Enrobe les exceptions avec des messages d'erreur utiles

### 4. Dépendances du projet (pom.xml)

**Dépendances clés :**

```xml
<!-- Spring Boot - Application framework -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <version>${spring-boot.version}</version>
</dependency>

<!-- OpenAI Java SDK - For AI API calls -->
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>

<!-- Jackson - JSON processing -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.0</version>
</dependency>
```

**Ce que cela fait :**
- **spring-boot-starter** : Fournit les fonctionnalités principales de Spring Boot
- **openai-java** : SDK Java officiel d'OpenAI pour la communication avec l'API
- **jackson-databind** : Gère la sérialisation/désérialisation JSON pour les appels API

## Comment tout fonctionne ensemble

Voici le flux complet lorsque vous exécutez l'application :

1. **Démarrage** : Spring Boot démarre et lit `application.properties`
2. **Création du service** : Spring crée `FoundryLocalService` et injecte les valeurs de configuration
3. **Détection du modèle** : Si aucun modèle n'est configuré, le service interroge l'endpoint `/v1/models` de Foundry Local et utilise automatiquement le premier modèle disponible
4. **Configuration client** : `@PostConstruct` initialise le client OpenAI pour se connecter à Foundry Local
5. **Exécution de la démo** : `CommandLineRunner` s'exécute après le démarrage
6. **Appel IA** : La démo appelle `foundryLocalService.chat()` avec un message test
7. **Requête API** : Le service construit et envoie la requête compatible OpenAI à Foundry Local
8. **Traitement de la réponse** : Le service extrait et retourne la réponse de l'IA
9. **Affichage** : L'application affiche la réponse puis se termine

## Installation de Foundry Local

1. **Installez Foundry Local** en suivant les instructions de la section [Prérequis](#prérequis).

2. **Démarrez le service** (si ce n'est pas déjà fait) :
   ```bash
   foundry service start
   ```

3. **Vérifiez le statut du service** pour confirmer qu'il fonctionne et notez le port :
   ```bash
   foundry service status
   ```

4. **Téléchargez et lancez un modèle** (téléchargé au premier lancement, mis en cache pour les exécutions suivantes) :
   ```bash
   foundry model run phi-4-mini
   ```
   Cela ouvre une session de chat interactive. Vous pouvez sortir avec `Ctrl+C`. Le modèle reste chargé dans le service.

   > **Astuce :** Exécutez `foundry model list` pour voir tous les modèles disponibles. Remplacez `phi-4-mini` par n’importe quel alias du catalogue (par exemple, `qwen2.5-0.5b` pour un modèle plus petit/rapide).

5. **Vérifiez que le modèle est chargé :**
   ```bash
   foundry service ps
   ```

6. **Mettez à jour `application.properties`** si nécessaire :
   - L'`base-url` par défaut (`http://localhost:5273/v1`) correspond au port CLI par défaut. Modifiez-le uniquement si `foundry service status` affiche un port différent.
   - Le modèle est **détecté automatiquement** au démarrage — aucune configuration nécessaire.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Exécution de l'application

### Étape 1 : Assurez-vous qu'un modèle est chargé dans Foundry Local
```bash
foundry service ps
```
Si aucun modèle n'est listé, chargez-en un :
```bash
foundry model run phi-4-mini
```

### Étape 2 : Compilez et lancez l'application
Dans un terminal séparé :
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

Ou construisez et lancez le JAR :
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Résultat attendu

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI developed by Microsoft. I can assist with a wide variety of 
tasks including answering questions, helping with analysis, creative writing, coding, 
and general conversation. How can I help you today?
=========================
```

## Étapes suivantes

Pour plus d’exemples, consultez [Chapitre 04 : Exemples pratiques](../README.md)

## Dépannage

### Problèmes courants

**"Connection refused" ou "Service unavailable"**
- Vérifiez le service : `foundry service status`
- Redémarrez si nécessaire : `foundry service restart`
- Assurez-vous que le port dans `application.properties` correspond à la sortie de `foundry service status`
- Vérifiez que l’URL se termine bien par `/v1` : `http://localhost:5273/v1`

**"No model found" au démarrage**
- L'application détecte automatiquement le modèle. Assurez-vous qu'au moins un modèle est chargé : `foundry service ps`
- Si aucun modèle n'est chargé : `foundry model run phi-4-mini`
- Si vous avez surchargé le nom du modèle dans `application.properties`, vérifiez qu'il correspond à celui affiché par `foundry model list`

**Erreurs "400 Bad Request"**
- Vérifiez que l'URL de base inclut `/v1` : `http://localhost:5273/v1`
- Assurez-vous d’utiliser `maxCompletionTokens()` dans votre code (et non la méthode obsolète `maxTokens()`)

**Erreurs de compilation Maven**
- Vérifiez que Java 21 ou une version supérieure est installée : `java -version`
- Nettoyez et recompilez : `mvn clean compile`
- Assurez-vous d’avoir une connexion internet pour télécharger les dépendances

**Problèmes de connexion au service**
- Si vous voyez `Request to local service failed`, exécutez : `foundry service restart`
- Vérifiez les modèles chargés : `foundry service ps`
- Consultez les logs du service : `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Avertissement** :
Ce document a été traduit à l'aide du service de traduction automatique [Co-op Translator](https://github.com/Azure/co-op-translator). Bien que nous nous efforçons d'assurer l'exactitude, veuillez noter que les traductions automatiques peuvent contenir des erreurs ou des inexactitudes. Le document original dans sa langue d'origine doit être considéré comme la source faisant foi. Pour les informations critiques, une traduction professionnelle humaine est recommandée. Nous déclinons toute responsabilité en cas de malentendus ou de mauvaises interprétations résultant de l'utilisation de cette traduction.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->