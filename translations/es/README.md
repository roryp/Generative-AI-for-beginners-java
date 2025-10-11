<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "00950ee1a40a84676b50da356c3a964a",
  "translation_date": "2025-10-11T10:18:09+00:00",
  "source_file": "README.md",
  "language_code": "es"
}
-->
# IA Generativa para Principiantes - Edición Java
[![Microsoft Azure AI Foundry Discord](https://dcbadge.limes.pink/api/server/ByRwuEEgH4)](https://discord.com/invite/ByRwuEEgH4)

![IA Generativa para Principiantes - Edición Java](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.es.png)

**Compromiso de Tiempo**: Todo el taller se puede completar en línea sin necesidad de configuración local. Configurar el entorno toma 2 minutos, y explorar los ejemplos requiere de 1 a 3 horas dependiendo de la profundidad de la exploración.

> **Inicio Rápido** 

1. Haz un fork de este repositorio en tu cuenta de GitHub
2. Haz clic en **Code** → pestaña **Codespaces** → **...** → **New with options...**
3. Usa las opciones predeterminadas: esto seleccionará el contenedor de desarrollo creado para este curso
4. Haz clic en **Create codespace**
5. Espera ~2 minutos para que el entorno esté listo
6. Ve directamente a [El primer ejemplo](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Soporte Multilingüe

### Disponible a través de GitHub Action (Automatizado y Siempre Actualizado)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Árabe](../ar/README.md) | [Bengalí](../bn/README.md) | [Búlgaro](../bg/README.md) | [Birmano (Myanmar)](../my/README.md) | [Chino (Simplificado)](../zh/README.md) | [Chino (Tradicional, Hong Kong)](../hk/README.md) | [Chino (Tradicional, Macao)](../mo/README.md) | [Chino (Tradicional, Taiwán)](../tw/README.md) | [Croata](../hr/README.md) | [Checo](../cs/README.md) | [Danés](../da/README.md) | [Holandés](../nl/README.md) | [Estonio](../et/README.md) | [Finlandés](../fi/README.md) | [Francés](../fr/README.md) | [Alemán](../de/README.md) | [Griego](../el/README.md) | [Hebreo](../he/README.md) | [Hindi](../hi/README.md) | [Húngaro](../hu/README.md) | [Indonesio](../id/README.md) | [Italiano](../it/README.md) | [Japonés](../ja/README.md) | [Coreano](../ko/README.md) | [Lituano](../lt/README.md) | [Malayo](../ms/README.md) | [Maratí](../mr/README.md) | [Nepalí](../ne/README.md) | [Noruego](../no/README.md) | [Persa (Farsi)](../fa/README.md) | [Polaco](../pl/README.md) | [Portugués (Brasil)](../br/README.md) | [Portugués (Portugal)](../pt/README.md) | [Panyabí (Gurmukhi)](../pa/README.md) | [Rumano](../ro/README.md) | [Ruso](../ru/README.md) | [Serbio (Cirílico)](../sr/README.md) | [Eslovaco](../sk/README.md) | [Esloveno](../sl/README.md) | [Español](./README.md) | [Suajili](../sw/README.md) | [Sueco](../sv/README.md) | [Tagalo (Filipino)](../tl/README.md) | [Tamil](../ta/README.md) | [Tailandés](../th/README.md) | [Turco](../tr/README.md) | [Ucraniano](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamita](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Estructura del Curso y Ruta de Aprendizaje

### **Capítulo 1: Introducción a la IA Generativa**
- **Conceptos Básicos**: Comprender los Modelos de Lenguaje Extenso, tokens, embeddings y capacidades de la IA
- **Ecosistema de IA en Java**: Descripción general de Spring AI y los SDKs de OpenAI
- **Protocolo de Contexto del Modelo**: Introducción al MCP y su papel en la comunicación de agentes de IA
- **Aplicaciones Prácticas**: Escenarios del mundo real, incluyendo chatbots y generación de contenido
- **[→ Comenzar el Capítulo 1](./01-IntroToGenAI/README.md)**

### **Capítulo 2: Configuración del Entorno de Desarrollo**
- **Configuración Multi-Proveedor**: Configura modelos de GitHub, Azure OpenAI e integraciones del SDK de OpenAI para Java
- **Spring Boot + Spring AI**: Mejores prácticas para el desarrollo de aplicaciones empresariales de IA
- **Modelos de GitHub**: Acceso gratuito a modelos de IA para prototipos y aprendizaje (sin necesidad de tarjeta de crédito)
- **Herramientas de Desarrollo**: Configuración de contenedores Docker, VS Code y GitHub Codespaces
- **[→ Comenzar el Capítulo 2](./02-SetupDevEnvironment/README.md)**

### **Capítulo 3: Técnicas Básicas de IA Generativa**
- **Ingeniería de Prompts**: Técnicas para obtener respuestas óptimas de los modelos de IA
- **Embeddings y Operaciones Vectoriales**: Implementar búsqueda semántica y coincidencia de similitudes
- **Generación Aumentada por Recuperación (RAG)**: Combina IA con tus propias fuentes de datos
- **Llamadas a Funciones**: Extiende las capacidades de la IA con herramientas y complementos personalizados
- **[→ Comenzar el Capítulo 3](./03-CoreGenerativeAITechniques/README.md)**

### **Capítulo 4: Aplicaciones Prácticas y Proyectos**
- **Generador de Historias de Mascotas** (`petstory/`): Generación creativa de contenido con Modelos de GitHub
- **Demo Local de Foundry** (`foundrylocal/`): Integración de modelos de IA locales con el SDK de OpenAI para Java
- **Servicio de Calculadora MCP** (`calculator/`): Implementación básica del Protocolo de Contexto del Modelo con Spring AI
- **[→ Comenzar el Capítulo 4](./04-PracticalSamples/README.md)**

### **Capítulo 5: Desarrollo Responsable de IA**
- **Seguridad en los Modelos de GitHub**: Prueba de los mecanismos de filtrado de contenido y seguridad integrados (bloqueos duros y rechazos suaves)
- **Demo de IA Responsable**: Ejemplo práctico que muestra cómo funcionan los sistemas modernos de seguridad en IA
- **Mejores Prácticas**: Pautas esenciales para el desarrollo y despliegue ético de la IA
- **[→ Comenzar el Capítulo 5](./05-ResponsibleGenAI/README.md)**

## Recursos Adicionales 

- [Edge AI for Beginners](https://github.com/microsoft/edgeai-for-beginners)
- [MCP For Beginners](https://github.com/microsoft/mcp-for-beginners)
- [AI Agents For Beginners](https://github.com/microsoft/ai-agents-for-beginners)
- [Generative AI for Beginners using .NET](https://github.com/microsoft/Generative-AI-for-beginners-dotnet)
- [Generative AI for Beginners using JavaScript](https://github.com/microsoft/generative-ai-with-javascript)
- [Generative AI for Beginners](https://github.com/microsoft/generative-ai-for-beginners)
- [ML for Beginners](https://aka.ms/ml-beginners)
- [Data Science for Beginners](https://aka.ms/datascience-beginners)
- [AI for Beginners](https://aka.ms/ai-beginners)
- [Cybersecurity for Beginners](https://github.com/microsoft/Security-101)
- [Web Dev for Beginners](https://aka.ms/webdev-beginners)
- [IoT for Beginners](https://aka.ms/iot-beginners)
- [XR Development for Beginners](https://github.com/microsoft/xr-development-for-beginners)
- [Mastering GitHub Copilot for AI Paired Programming](https://aka.ms/GitHubCopilotAI)
- [Mastering GitHub Copilot for C#/.NET Developers](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers)
- [Choose Your Own Copilot Adventure](https://github.com/microsoft/CopilotAdventures)
- [RAG Chat App with Azure AI Services](https://github.com/Azure-Samples/azure-search-openai-demo-java)

## Obtener Ayuda

Si tienes problemas o preguntas sobre cómo construir aplicaciones de IA, únete a:

[![Azure AI Foundry Discord](https://img.shields.io/badge/Discord-Azure_AI_Foundry_Community_Discord-blue?style=for-the-badge&logo=discord&color=5865f2&logoColor=fff)](https://aka.ms/foundry/discord)

Si tienes comentarios sobre el producto o encuentras errores durante la construcción, visita:

[![Azure AI Foundry Developer Forum](https://img.shields.io/badge/GitHub-Azure_AI_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

**Descargo de responsabilidad**:  
Este documento ha sido traducido utilizando el servicio de traducción automática [Co-op Translator](https://github.com/Azure/co-op-translator). Aunque nos esforzamos por garantizar la precisión, tenga en cuenta que las traducciones automatizadas pueden contener errores o imprecisiones. El documento original en su idioma nativo debe considerarse como la fuente autorizada. Para información crítica, se recomienda una traducción profesional realizada por humanos. No nos hacemos responsables de malentendidos o interpretaciones erróneas que puedan surgir del uso de esta traducción.