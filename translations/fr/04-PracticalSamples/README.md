<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "da1b6d87b8a73306b29f9a1bdd681221",
  "translation_date": "2025-07-21T16:31:05+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "fr"
}
-->
# Applications Pratiques & Projets

> Note : Chaque exemple inclut également un fichier **TUTORIAL.md** qui vous guide dans l'exécution de l'application.

## Ce que vous allez apprendre
Dans cette section, nous présenterons trois applications pratiques illustrant des modèles de développement d'IA générative avec Java :
- Créer un générateur d'histoires pour animaux de compagnie multi-modal combinant IA côté client et côté serveur
- Implémenter une intégration de modèle IA local avec la démo Foundry Local Spring Boot
- Développer un service Model Context Protocol (MCP) avec l'exemple de calculatrice

## Table des matières

- [Introduction](../../../04-PracticalSamples)
  - [Démo Foundry Local Spring Boot](../../../04-PracticalSamples)
  - [Générateur d'histoires pour animaux de compagnie](../../../04-PracticalSamples)
  - [Service MCP Calculatrice (Démo MCP pour débutants)](../../../04-PracticalSamples)
- [Progression d'apprentissage](../../../04-PracticalSamples)
- [Résumé](../../../04-PracticalSamples)
- [Prochaines étapes](../../../04-PracticalSamples)

## Introduction

Ce chapitre présente des **projets exemples** qui illustrent des modèles de développement d'IA générative avec Java. Chaque projet est entièrement fonctionnel et met en avant des technologies spécifiques d'IA, des modèles architecturaux et des bonnes pratiques que vous pouvez adapter à vos propres applications.

### Démo Foundry Local Spring Boot

La **[Démo Foundry Local Spring Boot](foundrylocal/README.md)** montre comment intégrer des modèles IA locaux en utilisant le **OpenAI Java SDK**. Elle illustre la connexion au modèle **Phi-3.5-mini** exécuté sur Foundry Local, vous permettant de créer des applications IA sans dépendre des services cloud.

### Générateur d'histoires pour animaux de compagnie

Le **[Générateur d'histoires pour animaux de compagnie](petstory/README.md)** est une application web Spring Boot captivante qui démontre le **traitement IA multi-modal** pour générer des histoires créatives sur les animaux de compagnie. Elle combine des capacités IA côté client et côté serveur en utilisant transformer.js pour les interactions IA dans le navigateur et le SDK OpenAI pour le traitement côté serveur.

### Service MCP Calculatrice (Démo MCP pour débutants)

Le **[Service MCP Calculatrice](mcp/calculator/README.md)** est une démonstration simple du **Model Context Protocol (MCP)** utilisant Spring AI. Il offre une introduction accessible aux concepts MCP, montrant comment créer un serveur MCP basique qui interagit avec des clients MCP.

## Progression d'apprentissage

Ces projets sont conçus pour s'appuyer sur les concepts des chapitres précédents :

1. **Commencez simplement** : Débutez avec la démo Foundry Local Spring Boot pour comprendre l'intégration de base des modèles IA locaux
2. **Ajoutez de l'interactivité** : Passez au Générateur d'histoires pour animaux de compagnie pour explorer l'IA multi-modal et les interactions web
3. **Apprenez les bases du MCP** : Essayez le Service MCP Calculatrice pour comprendre les fondamentaux du Model Context Protocol

## Résumé

**Félicitations !** Vous avez réussi à :

- **Créer des expériences IA multi-modales** combinant traitement IA côté client et côté serveur
- **Implémenter une intégration de modèles IA locaux** en utilisant des frameworks et SDK modernes pour Java
- **Développer des services Model Context Protocol** illustrant des modèles d'intégration d'outils

## Prochaines étapes

[Chapitre 5 : IA générative responsable](../05-ResponsibleGenAI/README.md)

**Avertissement** :  
Ce document a été traduit à l'aide du service de traduction automatique [Co-op Translator](https://github.com/Azure/co-op-translator). Bien que nous nous efforcions d'assurer l'exactitude, veuillez noter que les traductions automatisées peuvent contenir des erreurs ou des inexactitudes. Le document original dans sa langue d'origine doit être considéré comme la source faisant autorité. Pour des informations critiques, il est recommandé de faire appel à une traduction professionnelle humaine. Nous déclinons toute responsabilité en cas de malentendus ou d'interprétations erronées résultant de l'utilisation de cette traduction.