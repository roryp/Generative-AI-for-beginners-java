<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "69dffd84127360d3f9446b89de471abe",
  "translation_date": "2025-07-21T16:51:38+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "fr"
}
-->
# Application Pet Story

>**Note** : Ce chapitre inclut un [**Tutoriel**](./TUTORIAL.md) qui vous guide à travers l'exécution des exemples finalisés.

Une application web Spring Boot qui génère des descriptions et des histoires alimentées par l'IA pour les images d'animaux téléchargées en utilisant les modèles GitHub.

## Table des matières

- [Technologies utilisées](../../../../04-PracticalSamples/petstory)
- [Prérequis](../../../../04-PracticalSamples/petstory)
- [Configuration et installation](../../../../04-PracticalSamples/petstory)
- [Utilisation](../../../../04-PracticalSamples/petstory)

## Technologies utilisées

- **Backend** : Spring Boot 3.5.3, Java 21
- **Intégration IA** : OpenAI Java SDK avec les modèles GitHub
- **Sécurité** : Spring Security
- **Frontend** : Modèles Thymeleaf avec style Bootstrap
- **Outil de build** : Maven
- **Modèles IA** : Modèles GitHub

## Prérequis

- Java 21 ou version supérieure
- Maven 3.9+
- Jeton d'accès personnel GitHub avec le scope `models:read`

## Configuration et installation

### 1. Accédez au répertoire de l'application petstory
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Définissez une variable d'environnement
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Construisez l'application
```bash
mvn clean compile
```

### 4. Lancez l'application
```bash
mvn spring-boot:run
```

## Utilisation

1. **Accédez à l'application** : Rendez-vous sur `http://localhost:8080`
2. **Téléchargez une image** : Cliquez sur "Choisir un fichier" et sélectionnez une image d'animal
3. **Analysez l'image** : Cliquez sur "Analyser l'image" pour obtenir une description générée par l'IA
4. **Générez une histoire** : Cliquez sur "Générer une histoire" pour créer l'histoire

**Avertissement** :  
Ce document a été traduit à l'aide du service de traduction automatique [Co-op Translator](https://github.com/Azure/co-op-translator). Bien que nous nous efforcions d'assurer l'exactitude, veuillez noter que les traductions automatisées peuvent contenir des erreurs ou des inexactitudes. Le document original dans sa langue d'origine doit être considéré comme la source faisant autorité. Pour des informations critiques, il est recommandé de recourir à une traduction professionnelle réalisée par un humain. Nous déclinons toute responsabilité en cas de malentendus ou d'interprétations erronées résultant de l'utilisation de cette traduction.