<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "0a27b17f64f598a80b72d93b98b7ed04",
  "translation_date": "2025-07-21T16:01:22+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "fr"
}
-->
# Techniques fondamentales de l'IA générative

>**Note** : Ce chapitre inclut un [**Tutoriel**](./TUTORIAL.md) détaillé qui vous guide dans l'exécution des exemples terminés.

## Ce que vous allez apprendre
Dans ce chapitre, nous explorons 4 techniques fondamentales de l'IA générative à travers des exemples pratiques :
- Complétions LLM et flux de conversation
- Appels de fonctions
- Génération augmentée par récupération (RAG)
- Mesures de sécurité pour une IA responsable

## Table des matières

- [Ce que vous allez apprendre](../../../03-CoreGenerativeAITechniques)
- [Prérequis](../../../03-CoreGenerativeAITechniques)
- [Commencer](../../../03-CoreGenerativeAITechniques)
- [Aperçu des exemples](../../../03-CoreGenerativeAITechniques)
  - [1. Complétions LLM et flux de conversation](../../../03-CoreGenerativeAITechniques)
  - [2. Fonctions et plugins avec les LLM](../../../03-CoreGenerativeAITechniques)
  - [3. Génération augmentée par récupération (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Démonstration de sécurité pour une IA responsable](../../../03-CoreGenerativeAITechniques)
- [Résumé](../../../03-CoreGenerativeAITechniques)
- [Prochaines étapes](../../../03-CoreGenerativeAITechniques)

## Prérequis

- Configuration terminée à partir du [Chapitre 2](../../../02-SetupDevEnvironment)

## Commencer

1. **Accédez aux exemples** :  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **Configurez l'environnement** :  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **Compilez et exécutez les exemples** :  
```bash
   # Run completions example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.completions.LLMCompletionsApp"
   
   # Run functions example  
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.functions.FunctionsApp"
   
   # Run RAG example
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.rag.SimpleReaderDemo"
   
   # Run responsible AI demo
   mvn compile exec:java -Dexec.mainClass="com.example.genai.techniques.responsibleai.ResponsibleGithubModels"
   ```  

## Aperçu des exemples

Les exemples sont organisés dans le dossier `examples/` avec la structure suivante :

```
examples/
├── src/main/java/com/example/genai/techniques/
│   ├── completions/
│   │   └── LLMCompletionsApp.java        # Basic completions 
│   ├── functions/
│   │   └── FunctionsApp.java             # Function calling examples
│   ├── rag/
│   │   └── SimpleReaderDemo.java         # Retrieval-Augmented Generation
│   └── responsibleai/
│       └── ResponsibleGithubModels.java  # Responsible AI safety demonstration
├── document.txt                          # Sample document for RAG example
└── pom.xml                               # Maven configuration
```

### 1. Complétions LLM et flux de conversation
**Fichier** : `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Apprenez à créer une IA conversationnelle avec des réponses en streaming et une gestion de l'historique des conversations.

Cet exemple montre :
- Complétions de texte simples avec des invites système
- Conversations multi-tours avec gestion de l'historique
- Sessions de chat interactives
- Configuration des paramètres (température, nombre maximal de tokens)

### 2. Fonctions et plugins avec les LLM
**Fichier** : `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Étendez les capacités de l'IA en donnant aux modèles accès à des fonctions personnalisées et des API externes.

Cet exemple montre :
- Intégration d'une fonction météo
- Implémentation d'une fonction calculatrice  
- Appels multiples de fonctions dans une seule conversation
- Définition de fonctions avec des schémas JSON

### 3. Génération augmentée par récupération (RAG)
**Fichier** : `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Apprenez à combiner l'IA avec vos propres documents et sources de données pour des réponses précises et contextuelles.

Cet exemple montre :
- Réponses basées sur des documents avec le SDK Azure OpenAI
- Implémentation du modèle RAG avec les modèles GitHub

**Utilisation** : Posez des questions sur le contenu de `document.txt` et obtenez des réponses de l'IA basées uniquement sur ce contexte.

### 4. Démonstration de sécurité pour une IA responsable
**Fichier** : `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Découvrez comment fonctionnent les mesures de sécurité de l'IA en testant les capacités de filtrage de contenu des modèles GitHub.

Cet exemple montre :
- Filtrage de contenu pour des invites potentiellement nuisibles
- Gestion des réponses de sécurité dans les applications
- Différentes catégories de contenu bloqué (violence, discours haineux, désinformation)
- Gestion appropriée des erreurs pour les violations de sécurité

> **En savoir plus** : Ceci est une introduction aux concepts d'IA responsable. Pour plus d'informations sur l'éthique, la réduction des biais, les considérations de confidentialité et les cadres d'IA responsable, consultez [Chapitre 5 : IA générative responsable](../05-ResponsibleGenAI/README.md).

## Résumé

Dans ce chapitre, nous avons exploré les complétions LLM et les flux de conversation, mis en œuvre des appels de fonctions pour améliorer les capacités de l'IA, créé un système de génération augmentée par récupération (RAG) et démontré des mesures de sécurité pour une IA responsable.

> **NOTE** : Approfondissez avec le [**Tutoriel**](./TUTORIAL.md) fourni.

## Prochaines étapes

[Chapitre 4 : Applications pratiques et projets](../04-PracticalSamples/README.md)

**Avertissement** :  
Ce document a été traduit à l'aide du service de traduction automatique [Co-op Translator](https://github.com/Azure/co-op-translator). Bien que nous nous efforcions d'assurer l'exactitude, veuillez noter que les traductions automatisées peuvent contenir des erreurs ou des inexactitudes. Le document original dans sa langue d'origine doit être considéré comme la source faisant autorité. Pour des informations critiques, il est recommandé de recourir à une traduction professionnelle réalisée par un humain. Nous déclinons toute responsabilité en cas de malentendus ou d'interprétations erronées résultant de l'utilisation de cette traduction.