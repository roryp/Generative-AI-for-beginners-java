<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "00950ee1a40a84676b50da356c3a964a",
  "translation_date": "2025-10-11T10:17:52+00:00",
  "source_file": "README.md",
  "language_code": "fr"
}
-->
# Intelligence Artificielle Générative pour Débutants - Édition Java
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![Intelligence Artificielle Générative pour Débutants - Édition Java](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.fr.png)

**Temps nécessaire** : L'atelier complet peut être réalisé en ligne sans installation locale. La configuration de l'environnement prend 2 minutes, et l'exploration des exemples nécessite entre 1 et 3 heures selon la profondeur d'exploration.

> **Démarrage rapide** 

1. Forkez ce dépôt sur votre compte GitHub
2. Cliquez sur **Code** → onglet **Codespaces** → **...** → **New with options...**
3. Utilisez les paramètres par défaut – cela sélectionnera le conteneur de développement créé pour ce cours
4. Cliquez sur **Create codespace**
5. Attendez environ 2 minutes pour que l'environnement soit prêt
6. Passez directement à [Le premier exemple](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Support multilingue

### Pris en charge via GitHub Action (Automatisé et toujours à jour)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabe](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgare](../bg/README.md) | [Birman (Myanmar)](../my/README.md) | [Chinois (Simplifié)](../zh/README.md) | [Chinois (Traditionnel, Hong Kong)](../hk/README.md) | [Chinois (Traditionnel, Macao)](../mo/README.md) | [Chinois (Traditionnel, Taïwan)](../tw/README.md) | [Croate](../hr/README.md) | [Tchèque](../cs/README.md) | [Danois](../da/README.md) | [Néerlandais](../nl/README.md) | [Estonien](../et/README.md) | [Finnois](../fi/README.md) | [Français](./README.md) | [Allemand](../de/README.md) | [Grec](../el/README.md) | [Hébreu](../he/README.md) | [Hindi](../hi/README.md) | [Hongrois](../hu/README.md) | [Indonésien](../id/README.md) | [Italien](../it/README.md) | [Japonais](../ja/README.md) | [Coréen](../ko/README.md) | [Lituanien](../lt/README.md) | [Malais](../ms/README.md) | [Marathi](../mr/README.md) | [Népalais](../ne/README.md) | [Norvégien](../no/README.md) | [Persan (Farsi)](../fa/README.md) | [Polonais](../pl/README.md) | [Portugais (Brésil)](../br/README.md) | [Portugais (Portugal)](../pt/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Roumain](../ro/README.md) | [Russe](../ru/README.md) | [Serbe (Cyrillique)](../sr/README.md) | [Slovaque](../sk/README.md) | [Slovène](../sl/README.md) | [Espagnol](../es/README.md) | [Swahili](../sw/README.md) | [Suédois](../sv/README.md) | [Tagalog (Philippin)](../tl/README.md) | [Tamoul](../ta/README.md) | [Thaï](../th/README.md) | [Turc](../tr/README.md) | [Ukrainien](../uk/README.md) | [Ourdou](../ur/README.md) | [Vietnamien](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Structure du cours et parcours d'apprentissage

### **Chapitre 1 : Introduction à l'IA Générative**
- **Concepts de base** : Comprendre les modèles de langage étendus, les tokens, les embeddings et les capacités de l'IA
- **Écosystème Java AI** : Vue d'ensemble des SDK Spring AI et OpenAI
- **Protocole de Contexte de Modèle** : Introduction au MCP et à son rôle dans la communication des agents IA
- **Applications pratiques** : Scénarios réels incluant les chatbots et la génération de contenu
- **[→ Commencer le Chapitre 1](./01-IntroToGenAI/README.md)**

### **Chapitre 2 : Configuration de l'environnement de développement**
- **Configuration multi-fournisseurs** : Configurer les modèles GitHub, Azure OpenAI et les intégrations du SDK OpenAI Java
- **Spring Boot + Spring AI** : Bonnes pratiques pour le développement d'applications IA d'entreprise
- **Modèles GitHub** : Accès gratuit aux modèles IA pour le prototypage et l'apprentissage (aucune carte de crédit requise)
- **Outils de développement** : Configuration des conteneurs Docker, de VS Code et de GitHub Codespaces
- **[→ Commencer le Chapitre 2](./02-SetupDevEnvironment/README.md)**

### **Chapitre 3 : Techniques de base en IA Générative**
- **Ingénierie des prompts** : Techniques pour des réponses optimales des modèles IA
- **Embeddings et opérations vectorielles** : Implémenter la recherche sémantique et la correspondance de similarité
- **Génération augmentée par récupération (RAG)** : Combiner l'IA avec vos propres sources de données
- **Appels de fonctions** : Étendre les capacités de l'IA avec des outils et plugins personnalisés
- **[→ Commencer le Chapitre 3](./03-CoreGenerativeAITechniques/README.md)**

### **Chapitre 4 : Applications pratiques et projets**
- **Générateur d'histoires pour animaux** (`petstory/`) : Génération de contenu créatif avec les modèles GitHub
- **Démo locale Foundry** (`foundrylocal/`) : Intégration locale de modèles IA avec le SDK OpenAI Java
- **Service de calculatrice MCP** (`calculator/`) : Implémentation de base du Protocole de Contexte de Modèle avec Spring AI
- **[→ Commencer le Chapitre 4](./04-PracticalSamples/README.md)**

### **Chapitre 5 : Développement responsable de l'IA**
- **Sécurité des modèles GitHub** : Tester les mécanismes intégrés de filtrage de contenu et de sécurité (blocages stricts et refus souples)
- **Démo d'IA responsable** : Exemple pratique montrant le fonctionnement des systèmes modernes de sécurité de l'IA
- **Bonnes pratiques** : Lignes directrices essentielles pour un développement et un déploiement éthiques de l'IA
- **[→ Commencer le Chapitre 5](./05-ResponsibleGenAI/README.md)**

## Ressources supplémentaires 

- [Edge AI pour Débutants](https://github.com/microsoft/edgeai-for-beginners)
- [MCP pour Débutants](https://github.com/microsoft/mcp-for-beginners)
- [Agents IA pour Débutants](https://github.com/microsoft/ai-agents-for-beginners)
- [IA Générative pour Débutants avec .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [IA Générative pour Débutants avec JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [IA Générative pour Débutants](https://github.com/microsoft/generative-ai-for-beginners)
- [ML pour Débutants](https://aka.ms/ml-beginners)
- [Data Science pour Débutants](https://aka.ms/datascience-beginners)
- [IA pour Débutants](https://aka.ms/ai-beginners)
- [Cybersécurité pour Débutants](https://github.com/microsoft/Security-101)
- [Développement Web pour Débutants](https://aka.ms/webdev-beginners)
- [IoT pour Débutants](https://aka.ms/iot-beginners)
- [Développement XR pour Débutants](https://github.com/microsoft/xr-development-for-beginners)
- [Maîtriser GitHub Copilot pour la Programmation Assistée par IA](https://aka.ms/GitHubCopilotAI)
- [Maîtriser GitHub Copilot pour les Développeurs C#/.NET](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Choisissez votre propre aventure avec Copilot](https://github.com/microsoft/CopilotAdventures)
- [Application de Chat RAG avec les services Azure AI](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## Obtenir de l'aide

Si vous êtes bloqué ou avez des questions sur la création d'applications IA, rejoignez :

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Si vous avez des retours sur le produit ou rencontrez des erreurs lors de la création, visitez :

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**Avertissement** :  
Ce document a été traduit à l'aide du service de traduction automatique [Co-op Translator](https://github.com/Azure/co-op-translator). Bien que nous nous efforcions d'assurer l'exactitude, veuillez noter que les traductions automatisées peuvent contenir des erreurs ou des inexactitudes. Le document original dans sa langue d'origine doit être considéré comme la source faisant autorité. Pour des informations critiques, il est recommandé de recourir à une traduction humaine professionnelle. Nous déclinons toute responsabilité en cas de malentendus ou d'interprétations erronées résultant de l'utilisation de cette traduction.