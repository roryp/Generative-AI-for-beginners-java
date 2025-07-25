<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a49b35508745c032a0033d914df7901b",
  "translation_date": "2025-07-25T08:39:39+00:00",
  "source_file": "README.md",
  "language_code": "fr"
}
-->
# L'IA Générative pour Débutants - Édition Java
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![L'IA Générative pour Débutants - Édition Java](../../translated_images/beg-genai-series.61edc4a6b2cc54284fa2d70eda26dc0ca2669e26e49655b842ea799cd6e16d2a.fr.png)

**Temps requis** : L'ensemble de l'atelier peut être complété en ligne sans configuration locale. Si vous souhaitez exécuter les exemples, la configuration de l'environnement prend 2 minutes, et l'exploration des exemples nécessite entre 1 et 3 heures selon la profondeur d'exploration.

> **Démarrage rapide**

1. Forkez ce dépôt dans votre compte GitHub
2. Cliquez sur **Code** → onglet **Codespaces** → **...** → **New with options...**
3. Utilisez les paramètres par défaut – cela sélectionnera le conteneur de développement créé pour ce cours
4. Cliquez sur **Create codespace**
5. Attendez environ 2 minutes que l'environnement soit prêt
6. Passez directement à [Créer votre jeton GitHub Models](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Support multilingue

### Pris en charge via GitHub Action (Automatisé et toujours à jour)

[Français](./README.md) | [Espagnol](../es/README.md) | [Allemand](../de/README.md) | [Russe](../ru/README.md) | [Arabe](../ar/README.md) | [Persan (Farsi)](../fa/README.md) | [Ourdou](../ur/README.md) | [Chinois (Simplifié)](../zh/README.md) | [Chinois (Traditionnel, Macao)](../mo/README.md) | [Chinois (Traditionnel, Hong Kong)](../hk/README.md) | [Chinois (Traditionnel, Taïwan)](../tw/README.md) | [Japonais](../ja/README.md) | [Coréen](../ko/README.md) | [Hindi](../hi/README.md) | [Bengali](../bn/README.md) | [Marathi](../mr/README.md) | [Népalais](../ne/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Portugais (Portugal)](../pt/README.md) | [Portugais (Brésil)](../br/README.md) | [Italien](../it/README.md) | [Polonais](../pl/README.md) | [Turc](../tr/README.md) | [Grec](../el/README.md) | [Thaïlandais](../th/README.md) | [Suédois](../sv/README.md) | [Danois](../da/README.md) | [Norvégien](../no/README.md) | [Finnois](../fi/README.md) | [Néerlandais](../nl/README.md) | [Hébreu](../he/README.md) | [Vietnamien](../vi/README.md) | [Indonésien](../id/README.md) | [Malais](../ms/README.md) | [Tagalog (Filipino)](../tl/README.md) | [Swahili](../sw/README.md) | [Hongrois](../hu/README.md) | [Tchèque](../cs/README.md) | [Slovaque](../sk/README.md) | [Roumain](../ro/README.md) | [Bulgare](../bg/README.md) | [Serbe (Cyrillique)](../sr/README.md) | [Croate](../hr/README.md) | [Slovène](../sl/README.md) | [Ukrainien](../uk/README.md) | [Birman (Myanmar)](../my/README.md)

## Structure du cours et parcours d'apprentissage

### **Chapitre 1 : Introduction à l'IA Générative**
- **Concepts clés** : Comprendre les grands modèles de langage, les tokens, les embeddings et les capacités de l'IA
- **Écosystème Java pour l'IA** : Vue d'ensemble des SDK Spring AI et OpenAI
- **Protocole de Contexte Modèle** : Introduction au MCP et à son rôle dans la communication des agents IA
- **Applications pratiques** : Scénarios réels incluant les chatbots et la génération de contenu
- **[→ Commencer le Chapitre 1](./01-IntroToGenAI/README.md)**

### **Chapitre 2 : Configuration de l'environnement de développement**
- **Configuration multi-fournisseurs** : Intégration des GitHub Models, Azure OpenAI et OpenAI Java SDK
- **Spring Boot + Spring AI** : Bonnes pratiques pour le développement d'applications IA en entreprise
- **GitHub Models** : Accès gratuit aux modèles IA pour le prototypage et l'apprentissage (aucune carte de crédit requise)
- **Outils de développement** : Configuration des conteneurs Docker, VS Code et GitHub Codespaces
- **[→ Commencer le Chapitre 2](./02-SetupDevEnvironment/README.md)**

### **Chapitre 3 : Techniques fondamentales de l'IA Générative**
- **Ingénierie des prompts** : Techniques pour des réponses optimales des modèles IA
- **Embeddings et opérations vectorielles** : Implémenter la recherche sémantique et la correspondance de similarité
- **Génération augmentée par récupération (RAG)** : Combiner l'IA avec vos propres sources de données
- **Appels de fonctions** : Étendre les capacités de l'IA avec des outils et plugins personnalisés
- **[→ Commencer le Chapitre 3](./03-CoreGenerativeAITechniques/README.md)**

### **Chapitre 4 : Applications pratiques et projets**
- **Générateur d'histoires pour animaux** (`petstory/`) : Génération de contenu créatif avec GitHub Models
- **Démo locale Foundry** (`foundrylocal/`) : Intégration locale de modèles IA avec OpenAI Java SDK
- **Service de calculatrice MCP** (`mcp/calculator/`) : Implémentation basique du Protocole de Contexte Modèle avec Spring AI
- **[→ Commencer le Chapitre 4](./04-PracticalSamples/README.md)**

### **Chapitre 5 : Développement responsable de l'IA**
- **Sécurité des GitHub Models** : Tester les mécanismes intégrés de filtrage de contenu et de sécurité
- **Démo d'IA responsable** : Exemple pratique montrant le fonctionnement des filtres de sécurité de l'IA
- **Bonnes pratiques** : Lignes directrices essentielles pour un développement et un déploiement éthiques de l'IA
- **[→ Commencer le Chapitre 5](./05-ResponsibleGenAI/README.md)**

## Ressources supplémentaires 

- [Agents IA pour Débutants](https://github.com/microsoft/ai-agents-for-beginners)
- [L'IA Générative pour Débutants avec .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [L'IA Générative pour Débutants avec JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [L'IA Générative pour Débutants](https://github.com/microsoft/generative-ai-for-beginners)
- [ML pour Débutants](https://aka.ms/ml-beginners)
- [Science des Données pour Débutants](https://aka.ms/datascience-beginners)
- [IA pour Débutants](https://aka.ms/ai-beginners)
- [Cybersécurité pour Débutants](https://github.com/microsoft/Security-101)
- [Développement Web pour Débutants](https://aka.ms/webdev-beginners)
- [IoT pour Débutants](https://aka.ms/iot-beginners)
- [Développement XR pour Débutants](https://github.com/microsoft/xr-development-for-beginners)
- [Maîtriser GitHub Copilot pour la Programmation Assistée par IA](https://aka.ms/GitHubCopilotAI)
- [Maîtriser GitHub Copilot pour les Développeurs C#/.NET](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Choisissez votre propre aventure Copilot](https://github.com/microsoft/CopilotAdventures)
- [Application de Chat RAG avec les Services Azure AI](https://github.com/Azure-Samples/azure-search-openai-demo-java)

**Avertissement** :  
Ce document a été traduit à l'aide du service de traduction automatique [Co-op Translator](https://github.com/Azure/co-op-translator). Bien que nous nous efforcions d'assurer l'exactitude, veuillez noter que les traductions automatisées peuvent contenir des erreurs ou des inexactitudes. Le document original dans sa langue d'origine doit être considéré comme la source faisant autorité. Pour des informations critiques, il est recommandé de faire appel à une traduction professionnelle humaine. Nous déclinons toute responsabilité en cas de malentendus ou d'interprétations erronées résultant de l'utilisation de cette traduction.