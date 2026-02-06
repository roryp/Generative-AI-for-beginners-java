# Intelligence Artificielle Générative pour Débutants - Édition Java
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Intelligence Artificielle Générative pour Débutants - Édition Java](../../translated_images/fr/beg-genai-series.8b48be9951cc574c.webp)

**Engagement en Temps** : L'atelier complet peut être réalisé en ligne sans installation locale. La configuration de l'environnement prend 2 minutes, avec l'exploration des exemples nécessitant 1 à 3 heures selon la profondeur d'exploration.

> **Démarrage Rapide**

1. Forkez ce dépôt dans votre compte GitHub  
2. Cliquez sur **Code** → onglet **Codespaces** → **...** → **Nouveau avec options...**  
3. Utilisez les paramètres par défaut – cela sélectionnera le conteneur de développement créé pour ce cours  
4. Cliquez sur **Créer un codespace**  
5. Patientez environ 2 minutes que l'environnement soit prêt  
6. Passez directement à [Le premier exemple](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

> **Préférez Cloner Localement ?**  
>  
> Ce dépôt comprend plus de 50 traductions de langues ce qui augmente significativement la taille du téléchargement. Pour cloner sans traductions, utilisez le checkout sparse :  
> ```bash
> git clone --filter=blob:none --sparse https://github.com/microsoft/Generative-AI-for-beginners-java.git
> cd Generative-AI-for-beginners-java
> git sparse-checkout set --no-cone '/*' '!translations' '!translated_images'
> ```
> Cela vous donne tout ce dont vous avez besoin pour suivre le cours avec un téléchargement beaucoup plus rapide.

## Support Multilingue

### Pris en charge via GitHub Action (Automatisé & Toujours à jour)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Arabe](../ar/README.md) | [Bengali](../bn/README.md) | [Bulgare](../bg/README.md) | [Birman (Myanmar)](../my/README.md) | [Chinois (Simplifié)](../zh-CN/README.md) | [Chinois (Traditionnel, Hong Kong)](../zh-HK/README.md) | [Chinois (Traditionnel, Macau)](../zh-MO/README.md) | [Chinois (Traditionnel, Taiwan)](../zh-TW/README.md) | [Croate](../hr/README.md) | [Tchèque](../cs/README.md) | [Danois](../da/README.md) | [Néerlandais](../nl/README.md) | [Estonien](../et/README.md) | [Finnois](../fi/README.md) | [Français](./README.md) | [Allemand](../de/README.md) | [Grec](../el/README.md) | [Hébreu](../he/README.md) | [Hindi](../hi/README.md) | [Hongrois](../hu/README.md) | [Indonésien](../id/README.md) | [Italien](../it/README.md) | [Japonais](../ja/README.md) | [Kannada](../kn/README.md) | [Coréen](../ko/README.md) | [Lituanien](../lt/README.md) | [Malais](../ms/README.md) | [Malayalam](../ml/README.md) | [Marathi](../mr/README.md) | [Népalais](../ne/README.md) | [Pidgin nigérian](../pcm/README.md) | [Norvégien](../no/README.md) | [Persan (Farsi)](../fa/README.md) | [Polonais](../pl/README.md) | [Portugais (Brésil)](../pt-BR/README.md) | [Portugais (Portugal)](../pt-PT/README.md) | [Pendjabi (Gurmukhi)](../pa/README.md) | [Roumain](../ro/README.md) | [Russe](../ru/README.md) | [Serbe (Cyrillique)](../sr/README.md) | [Slovaque](../sk/README.md) | [Slovène](../sl/README.md) | [Espagnol](../es/README.md) | [Swahili](../sw/README.md) | [Suédois](../sv/README.md) | [Tagalog (Philippin)](../tl/README.md) | [Tamoul](../ta/README.md) | [Télougou](../te/README.md) | [Thaï](../th/README.md) | [Turc](../tr/README.md) | [Ukrainien](../uk/README.md) | [Ourdou](../ur/README.md) | [Vietnamien](../vi/README.md)

## Structure du Cours & Parcours d'Apprentissage

### **Chapitre 1 : Introduction à l'IA Générative**
- **Concepts Clés** : Comprendre les grands modèles de langage, les tokens, les embeddings et les capacités de l'IA  
- **Écosystème Java AI** : Vue d'ensemble des SDK Spring AI et OpenAI  
- **Protocole de Contexte de Modèle** : Introduction au MCP et son rôle dans la communication des agents IA  
- **Applications Pratiques** : Scénarios réels incluant chatbots et génération de contenu  
- **[→ Commencer le Chapitre 1](./01-IntroToGenAI/README.md)**

### **Chapitre 2 : Configuration de l'Environnement de Développement**
- **Configuration Multi-Fournisseurs** : Mise en place des intégrations GitHub Models, Azure OpenAI et OpenAI Java SDK  
- **Spring Boot + Spring AI** : Bonnes pratiques pour le développement d'applications IA d'entreprise  
- **GitHub Models** : Accès gratuit aux modèles IA pour prototypage et apprentissage (pas de carte de crédit requise)  
- **Outils de Développement** : Conteneurs Docker, VS Code, et configuration GitHub Codespaces  
- **[→ Commencer le Chapitre 2](./02-SetupDevEnvironment/README.md)**

### **Chapitre 3 : Techniques Fondamentales d'IA Générative**
- **Ingénierie des Prompts** : Techniques pour des réponses optimales des modèles IA  
- **Embeddings & Opérations Vectorielles** : Implémenter la recherche sémantique et la correspondance de similarité  
- **Retrieval-Augmented Generation (RAG)** : Combiner l'IA avec vos propres sources de données  
- **Appels de Fonction** : Étendre les capacités IA avec des outils et plugins personnalisés  
- **[→ Commencer le Chapitre 3](./03-CoreGenerativeAITechniques/README.md)**

### **Chapitre 4 : Applications Pratiques & Projets**
- **Générateur d'Histoires d'Animaux de Compagnie** (`petstory/`) : Génération créative de contenu avec GitHub Models  
- **Démo Locale Foundry** (`foundrylocal/`) : Intégration locale d’un modèle IA avec OpenAI Java SDK  
- **Service Calculatrice MCP** (`calculator/`) : Implémentation basique du Protocole de Contexte de Modèle avec Spring AI  
- **[→ Commencer le Chapitre 4](./04-PracticalSamples/README.md)**

### **Chapitre 5 : Développement Responsable de l'IA**
- **Sécurité GitHub Models** : Tester les filtrages de contenu intégrés et mécanismes de sécurité (blocages stricts et refus souples)  
- **Démo d'IA Responsable** : Exemple pratique montrant le fonctionnement des systèmes de sécurité IA modernes  
- **Bonnes Pratiques** : Directives essentielles pour un développement et un déploiement éthiques de l'IA  
- **[→ Commencer le Chapitre 5](./05-ResponsibleGenAI/README.md)**

## Ressources Supplémentaires

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### LangChain
[![LangChain4j pour Débutants](https://img.shields.io/badge/LangChain4j%20for%20Beginners-22C55E?style=for-the-badge&&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchain4j-for-beginners)
[![LangChain.js pour Débutants](https://img.shields.io/badge/LangChain.js%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://aka.ms/langchainjs-for-beginners?WT.mc_id=m365-94501-dwahlin)
[![LangChain pour Débutants](https://img.shields.io/badge/LangChain%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=0553D6)](https://github.com/microsoft/langchain-for-beginners?WT.mc_id=m365-94501-dwahlin)
---

### Azure / Edge / MCP / Agents
[![AZD pour Débutants](https://img.shields.io/badge/AZD%20for%20Beginners-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI pour Débutants](https://img.shields.io/badge/Edge%20AI%20for%20Beginners-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP pour Débutants](https://img.shields.io/badge/MCP%20for%20Beginners-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Agents IA pour Débutants](https://img.shields.io/badge/AI%20Agents%20for%20Beginners-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### Série IA Générative
[![Intelligence Artificielle Générative pour Débutants](https://img.shields.io/badge/Generative%20AI%20for%20Beginners-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Intelligence Artificielle Générative (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Intelligence Artificielle Générative (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Intelligence Artificielle Générative (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---

### Apprentissage Fondamental
[![ML pour Débutants](https://img.shields.io/badge/ML%20for%20Beginners-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Science des Données pour Débutants](https://img.shields.io/badge/Data%20Science%20for%20Beginners-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![IA pour Débutants](https://img.shields.io/badge/AI%20for%20Beginners-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Cybersécurité pour Débutants](https://img.shields.io/badge/Cybersecurity%20for%20Beginners-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Développement Web pour Débutants](https://img.shields.io/badge/Web%20Dev%20for%20Beginners-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT pour Débutants](https://img.shields.io/badge/IoT%20for%20Beginners-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![Développement XR pour Débutants](https://img.shields.io/badge/XR%20Development%20for%20Beginners-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---

### Série Copilot
[![Copilot pour Programmation Assistée par IA](https://img.shields.io/badge/Copilot%20for%20AI%20Paired%20Programming-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot pour C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)
[![Aventure Copilot](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)
<!-- CO-OP TRANSLATOR OTHER COURSES END -->

## Obtenir de l’aide

Si vous êtes bloqué ou avez des questions sur la création d’applications IA, rejoignez d’autres apprenants et développeurs expérimentés dans les discussions sur MCP. C’est une communauté bienveillante où les questions sont les bienvenues et les connaissances librement partagées.

[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

Si vous avez des retours produits ou rencontrez des erreurs lors de la création, visitez :

[![Forum des développeurs Microsoft Foundry](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Avertissement** :  
Ce document a été traduit à l’aide du service de traduction automatisée [Co-op Translator](https://github.com/Azure/co-op-translator). Bien que nous nous efforcions d’assurer l’exactitude, veuillez noter que les traductions automatiques peuvent contenir des erreurs ou des inexactitudes. Le document original dans sa langue d’origine doit être considéré comme la source faisant foi. Pour les informations critiques, il est recommandé de recourir à une traduction professionnelle réalisée par un humain. Nous déclinons toute responsabilité en cas de malentendus ou de mauvaises interprétations résultant de l’utilisation de cette traduction.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->