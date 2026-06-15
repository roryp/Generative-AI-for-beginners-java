# Applications pratiques et projets

[![Applications pratiques et projets](https://img.youtube.com/vi/01vJsYei3H0/0.jpg)](https://www.youtube.com/watch?v=01vJsYei3H0 "Applications pratiques et projets")

> **Présentation vidéo :** [Regardez « Applications pratiques et projets » sur YouTube](https://www.youtube.com/watch?v=01vJsYei3H0).

## Ce que vous allez apprendre
Dans cette section, nous allons présenter trois applications pratiques qui illustrent les modèles de développement d’IA générative avec Java :
- Créer un générateur d’histoires pour animaux de compagnie multimodal combinant IA côté client et côté serveur
- Implémenter l’intégration d’un modèle d’IA local avec la démo Foundry Local Spring Boot
- Développer un service Model Context Protocol (MCP) avec l’exemple de calculatrice

## Table des matières

- [Introduction](#introduction)
  - [Démo Foundry Local Spring Boot](#démo-foundry-local-spring-boot)
  - [Générateur d’histoires pour animaux](#générateur-d’histoires-pour-animaux)
  - [Service MCP Calculator (démo MCP conviviale pour débutants)](#service-mcp-calculator-démo-mcp-conviviale-pour-débutants)
- [Progression pédagogique](#progression-pédagogique)
- [Résumé](#résumé)
- [Prochaines étapes](#prochaines-étapes)

## Introduction

Ce chapitre présente des **projets exemples** qui démontrent les modèles de développement d’IA générative avec Java. Chaque projet est entièrement fonctionnel et illustre des technologies spécifiques d’IA, des modèles architecturaux ainsi que les meilleures pratiques que vous pouvez adapter pour vos propres applications.

### Démo Foundry Local Spring Boot

La **[démo Foundry Local Spring Boot](foundrylocal/README.md)** montre comment intégrer des modèles d’IA locaux en utilisant le **SDK Java OpenAI**. Elle présente la connexion à des modèles fonctionnant sur Foundry Local (par exemple, **Phi-4-mini**), avec une détection automatique du modèle, vous permettant ainsi d’exécuter des applications d’IA sans dépendre des services cloud.

### Générateur d’histoires pour animaux

Le **[Générateur d’histoires pour animaux](petstory/README.md)** est une application web Spring Boot captivante qui illustre le **traitement d’IA multimodal** pour générer des histoires créatives d’animaux de compagnie. Il combine les capacités IA côté client et côté serveur en utilisant transformer.js pour les interactions IA basées sur le navigateur et le SDK OpenAI pour le traitement côté serveur.

### Service MCP Calculator (démo MCP conviviale pour débutants)

Le **[service MCP Calculator](calculator/README.md)** est une démonstration simple du **Model Context Protocol (MCP)** utilisant Spring AI. Il offre une introduction facile à comprendre aux concepts MCP, en montrant comment créer un serveur MCP basique qui interagit avec les clients MCP.

## Progression pédagogique

Ces projets sont conçus pour s’appuyer sur les concepts des chapitres précédents :

1. **Commencer simple** : Débutez avec la démo Foundry Local Spring Boot pour comprendre l’intégration basique de l’IA avec des modèles locaux
2. **Ajouter de l’interactivité** : Passez au Générateur d’histoires pour animaux pour l’IA multimodale et les interactions web
3. **Apprendre les bases MCP** : Essayez le service MCP Calculator pour comprendre les fondamentaux du Model Context Protocol

## Résumé

Bravo ! Vous avez maintenant exploré quelques applications concrètes :

- Des expériences IA multimodales qui fonctionnent à la fois dans le navigateur et sur le serveur
- L’intégration de modèles d’IA locaux avec des frameworks et SDK Java modernes
- Votre premier service Model Context Protocol pour voir comment les outils s’intègrent avec l’IA

## Prochaines étapes

[Chapitre 5 : IA générative responsable](../05-ResponsibleGenAI/README.md)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Avertissement** :  
Ce document a été traduit à l’aide du service de traduction IA [Co-op Translator](https://github.com/Azure/co-op-translator). Bien que nous nous efforçons d’assurer l’exactitude, veuillez noter que les traductions automatiques peuvent contenir des erreurs ou des inexactitudes. Le document original dans sa langue native doit être considéré comme la source faisant autorité. Pour les informations critiques, une traduction professionnelle humaine est recommandée. Nous ne sommes pas responsables des malentendus ou des mauvaises interprétations découlant de l’utilisation de cette traduction.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->