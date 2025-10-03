<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "afc90918d008cf77fd1982691f681306",
  "translation_date": "2025-10-03T08:24:32+00:00",
  "source_file": "AGENTS.md",
  "language_code": "fr"
}
-->
# AGENTS.md

## Aperçu du projet

Ce dépôt éducatif est conçu pour apprendre le développement d'IA générative avec Java. Il propose un cours pratique complet couvrant les modèles de langage étendus (LLMs), l'ingénierie des invites, les embeddings, RAG (génération augmentée par récupération) et le protocole de contexte de modèle (MCP).

**Technologies clés :**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- Modèles GitHub, Azure OpenAI et SDK OpenAI

**Architecture :**
- Plusieurs applications Spring Boot autonomes organisées par chapitres
- Projets d'exemple illustrant différents modèles d'IA
- Prêt pour GitHub Codespaces avec des conteneurs de développement préconfigurés

## Commandes d'installation

### Prérequis
- Java 21 ou supérieur
- Maven 3.x
- Jeton d'accès personnel GitHub (pour les modèles GitHub)
- Facultatif : Identifiants Azure OpenAI

### Configuration de l'environnement

**Option 1 : GitHub Codespaces (recommandé)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Option 2 : Conteneur de développement local**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Option 3 : Configuration locale**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Configuration

**Configuration du jeton GitHub :**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Configuration Azure OpenAI (facultatif) :**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Flux de travail de développement

### Structure du projet
```
/
├── 01-IntroToGenAI/              # Chapter 1: Introduction
├── 02-SetupDevEnvironment/       # Chapter 2: Environment setup
│   └── examples/                 # Working examples
├── 03-CoreGenerativeAITechniques/ # Chapter 3: Core techniques
├── 04-PracticalSamples/          # Chapter 4: Sample projects
│   ├── calculator/               # MCP service example
│   ├── foundrylocal/            # Local model integration
│   └── petstory/                # Multi-modal app
├── 05-ResponsibleGenAI/         # Chapter 5: Responsible AI
└── translations/                # Multi-language support
```

### Exécution des applications

**Exécuter une application Spring Boot :**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Construire un projet :**
```bash
cd [project-directory]
mvn clean install
```

**Démarrer le serveur MCP Calculator :**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Exécuter des exemples clients :**
```bash
# After starting the server in another terminal
cd 04-PracticalSamples/calculator

# Direct MCP client
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient"

# AI-powered client (requires GITHUB_TOKEN)
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient"

# Interactive bot
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.Bot"
```

### Rechargement à chaud
Spring Boot DevTools est inclus dans les projets qui prennent en charge le rechargement à chaud :
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Instructions de test

### Exécution des tests

**Exécuter tous les tests d'un projet :**
```bash
cd [project-directory]
mvn test
```

**Exécuter les tests avec une sortie détaillée :**
```bash
mvn test -X
```

**Exécuter une classe de test spécifique :**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Structure des tests
- Les fichiers de test utilisent JUnit 5 (Jupiter)
- Les classes de test se trouvent dans `src/test/java/`
- Les exemples clients du projet de calculatrice se trouvent dans `src/test/java/com/microsoft/mcp/sample/client/`

### Tests manuels
De nombreux exemples sont des applications interactives nécessitant des tests manuels :

1. Démarrez l'application avec `mvn spring-boot:run`
2. Testez les points de terminaison ou interagissez avec le CLI
3. Vérifiez que le comportement attendu correspond à la documentation dans le README.md de chaque projet

### Tests avec les modèles GitHub
- Limites du niveau gratuit : 15 requêtes/minute, 150/jour
- Maximum de 5 requêtes simultanées
- Testez le filtrage de contenu avec des exemples d'IA responsable

## Directives de style de code

### Conventions Java
- **Version Java :** Java 21 avec des fonctionnalités modernes
- **Style :** Respecter les conventions standard de Java
- **Nommage :** 
  - Classes : PascalCase
  - Méthodes/variables : camelCase
  - Constantes : UPPER_SNAKE_CASE
  - Noms de packages : minuscules

### Modèles Spring Boot
- Utilisez `@Service` pour la logique métier
- Utilisez `@RestController` pour les points de terminaison REST
- Configuration via `application.yml` ou `application.properties`
- Variables d'environnement préférées aux valeurs codées en dur
- Utilisez l'annotation `@Tool` pour les méthodes exposées par MCP

### Organisation des fichiers
```
src/
├── main/
│   ├── java/
│   │   └── com/microsoft/[component]/
│   │       ├── [Component]Application.java
│   │       ├── config/
│   │       ├── controller/
│   │       ├── service/
│   │       └── exception/
│   └── resources/
│       ├── application.yml
│       └── static/
└── test/
    └── java/
        └── com/microsoft/[component]/
```

### Dépendances
- Gérées via Maven `pom.xml`
- BOM Spring AI pour la gestion des versions
- LangChain4j pour les intégrations IA
- Starter parent Spring Boot pour les dépendances Spring

### Commentaires de code
- Ajoutez JavaDoc pour les API publiques
- Incluez des commentaires explicatifs pour les interactions complexes avec l'IA
- Documentez clairement les descriptions des outils MCP

## Construction et déploiement

### Construction des projets

**Construire sans tests :**
```bash
mvn clean install -DskipTests
```

**Construire avec toutes les vérifications :**
```bash
mvn clean install
```

**Créer un package de l'application :**
```bash
mvn package
# Creates JAR in target/ directory
```

### Répertoires de sortie
- Classes compilées : `target/classes/`
- Classes de test : `target/test-classes/`
- Fichiers JAR : `target/*.jar`
- Artéfacts Maven : `target/`

### Configuration spécifique à l'environnement

**Développement :**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Production :**
- Utilisez les modèles Azure AI Foundry au lieu des modèles GitHub
- Mettez à jour l'URL de base vers le point de terminaison Azure OpenAI
- Gérez les secrets via Azure Key Vault ou des variables d'environnement

### Considérations de déploiement
- Ce dépôt est éducatif avec des applications d'exemple
- Non conçu pour un déploiement en production tel quel
- Les exemples démontrent des modèles à adapter pour une utilisation en production
- Consultez les README de chaque projet pour des notes spécifiques sur le déploiement

## Notes supplémentaires

### Modèles GitHub vs Azure OpenAI
- **Modèles GitHub :** Niveau gratuit pour l'apprentissage, aucune carte de crédit requise
- **Azure OpenAI :** Prêt pour la production, nécessite un abonnement Azure
- Le code est compatible entre les deux - il suffit de changer le point de terminaison et la clé API

### Travailler avec plusieurs projets
Chaque projet d'exemple est autonome :
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Problèmes courants

**Incompatibilité de version Java :**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Problèmes de téléchargement des dépendances :**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**Jeton GitHub introuvable :**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Port déjà utilisé :**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Support multilingue
- Documentation disponible en plus de 45 langues via traduction automatisée
- Traductions dans le répertoire `translations/`
- Traduction gérée par le workflow GitHub Actions

### Parcours d'apprentissage
1. Commencez par [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Suivez les chapitres dans l'ordre (01 → 05)
3. Complétez les exemples pratiques de chaque chapitre
4. Explorez les projets d'exemple du chapitre 4
5. Apprenez les pratiques d'IA responsable au chapitre 5

### Conteneur de développement
Le fichier `.devcontainer/devcontainer.json` configure :
- Environnement de développement Java 21
- Maven préinstallé
- Extensions Java pour VS Code
- Outils Spring Boot
- Intégration GitHub Copilot
- Support Docker-in-Docker
- CLI Azure

### Considérations de performance
- Le niveau gratuit des modèles GitHub a des limites de taux
- Utilisez des tailles de lot appropriées pour les embeddings
- Envisagez la mise en cache pour les appels API répétés
- Surveillez l'utilisation des jetons pour optimiser les coûts

### Notes de sécurité
- Ne jamais commettre de fichiers `.env` (déjà dans `.gitignore`)
- Utilisez des variables d'environnement pour les clés API
- Les jetons GitHub doivent avoir des portées minimales requises
- Suivez les directives d'IA responsable du chapitre 5

---

**Avertissement** :  
Ce document a été traduit à l'aide du service de traduction automatique [Co-op Translator](https://github.com/Azure/co-op-translator). Bien que nous nous efforcions d'assurer l'exactitude, veuillez noter que les traductions automatisées peuvent contenir des erreurs ou des inexactitudes. Le document original dans sa langue d'origine doit être considéré comme la source faisant autorité. Pour des informations critiques, il est recommandé de recourir à une traduction humaine professionnelle. Nous déclinons toute responsabilité en cas de malentendus ou d'interprétations erronées résultant de l'utilisation de cette traduction.