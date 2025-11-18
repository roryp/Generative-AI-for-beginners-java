<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "ff595bec5b6294cb68860d540eae6302",
  "translation_date": "2025-11-18T16:50:40+00:00",
  "source_file": "README.md",
  "language_code": "es"
}
-->
# Generative AI para Principiantes - Edición Java
[![Microsoft Foundry Discord](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

![Generative AI para Principiantes - Edición Java](../../translated_images/beg-genai-series.8b48be9951cc574c25f8a3accba949bfd03c2f008e2c613283a1b47316fbee68.es.png)

**Compromiso de Tiempo**: Todo el taller se puede completar en línea sin necesidad de configuración local. La configuración del entorno toma 2 minutos, y explorar los ejemplos requiere de 1 a 3 horas dependiendo de la profundidad de la exploración.

> **Inicio Rápido** 

1. Haz un fork de este repositorio en tu cuenta de GitHub
2. Haz clic en **Code** → pestaña **Codespaces** → **...** → **New with options...**
3. Usa los valores predeterminados: esto seleccionará el contenedor de desarrollo creado para este curso
4. Haz clic en **Create codespace**
5. Espera ~2 minutos para que el entorno esté listo
6. Ve directamente al [Primer ejemplo](./02-SetupDevEnvironment/README.md#step-2-create-a-github-personal-access-token)

## Soporte Multilenguaje

### Soportado a través de GitHub Action (Automatizado y Siempre Actualizado)

<!-- CO-OP TRANSLATOR LANGUAGES TABLE START -->
[Árabe](../ar/README.md) | [Bengalí](../bn/README.md) | [Búlgaro](../bg/README.md) | [Birmano (Myanmar)](../my/README.md) | [Chino (Simplificado)](../zh/README.md) | [Chino (Tradicional, Hong Kong)](../hk/README.md) | [Chino (Tradicional, Macao)](../mo/README.md) | [Chino (Tradicional, Taiwán)](../tw/README.md) | [Croata](../hr/README.md) | [Checo](../cs/README.md) | [Danés](../da/README.md) | [Holandés](../nl/README.md) | [Estonio](../et/README.md) | [Finlandés](../fi/README.md) | [Francés](../fr/README.md) | [Alemán](../de/README.md) | [Griego](../el/README.md) | [Hebreo](../he/README.md) | [Hindi](../hi/README.md) | [Húngaro](../hu/README.md) | [Indonesio](../id/README.md) | [Italiano](../it/README.md) | [Japonés](../ja/README.md) | [Coreano](../ko/README.md) | [Lituano](../lt/README.md) | [Malayo](../ms/README.md) | [Maratí](../mr/README.md) | [Nepalí](../ne/README.md) | [Pidgin Nigeriano](../pcm/README.md) | [Noruego](../no/README.md) | [Persa (Farsi)](../fa/README.md) | [Polaco](../pl/README.md) | [Portugués (Brasil)](../br/README.md) | [Portugués (Portugal)](../pt/README.md) | [Punjabi (Gurmukhi)](../pa/README.md) | [Rumano](../ro/README.md) | [Ruso](../ru/README.md) | [Serbio (Cirílico)](../sr/README.md) | [Eslovaco](../sk/README.md) | [Esloveno](../sl/README.md) | [Español](./README.md) | [Suajili](../sw/README.md) | [Sueco](../sv/README.md) | [Tagalo (Filipino)](../tl/README.md) | [Tamil](../ta/README.md) | [Tailandés](../th/README.md) | [Turco](../tr/README.md) | [Ucraniano](../uk/README.md) | [Urdu](../ur/README.md) | [Vietnamita](../vi/README.md)
<!-- CO-OP TRANSLATOR LANGUAGES TABLE END -->

## Estructura del Curso y Ruta de Aprendizaje

### **Capítulo 1: Introducción a la Generative AI**
- **Conceptos Básicos**: Comprender los Modelos de Lenguaje Extenso, tokens, embeddings y capacidades de IA
- **Ecosistema de IA en Java**: Resumen de Spring AI y OpenAI SDKs
- **Protocolo de Contexto del Modelo**: Introducción al MCP y su papel en la comunicación de agentes de IA
- **Aplicaciones Prácticas**: Escenarios del mundo real, incluyendo chatbots y generación de contenido
- **[→ Comienza el Capítulo 1](./01-IntroToGenAI/README.md)**

### **Capítulo 2: Configuración del Entorno de Desarrollo**
- **Configuración Multi-Proveedor**: Configura GitHub Models, Azure OpenAI y las integraciones de OpenAI Java SDK
- **Spring Boot + Spring AI**: Mejores prácticas para el desarrollo de aplicaciones empresariales de IA
- **GitHub Models**: Acceso gratuito a modelos de IA para prototipos y aprendizaje (sin necesidad de tarjeta de crédito)
- **Herramientas de Desarrollo**: Configuración de contenedores Docker, VS Code y GitHub Codespaces
- **[→ Comienza el Capítulo 2](./02-SetupDevEnvironment/README.md)**

### **Capítulo 3: Técnicas Básicas de Generative AI**
- **Ingeniería de Prompts**: Técnicas para obtener respuestas óptimas de los modelos de IA
- **Embeddings y Operaciones Vectoriales**: Implementa búsqueda semántica y coincidencia de similitud
- **Generación Aumentada por Recuperación (RAG)**: Combina IA con tus propias fuentes de datos
- **Llamadas a Funciones**: Extiende las capacidades de la IA con herramientas y plugins personalizados
- **[→ Comienza el Capítulo 3](./03-CoreGenerativeAITechniques/README.md)**

### **Capítulo 4: Aplicaciones Prácticas y Proyectos**
- **Generador de Historias de Mascotas** (`petstory/`): Generación creativa de contenido con GitHub Models
- **Demo Local de Foundry** (`foundrylocal/`): Integración de modelos de IA locales con OpenAI Java SDK
- **Servicio de Calculadora MCP** (`calculator/`): Implementación básica del Protocolo de Contexto del Modelo con Spring AI
- **[→ Comienza el Capítulo 4](./04-PracticalSamples/README.md)**

### **Capítulo 5: Desarrollo Responsable de IA**
- **Seguridad en GitHub Models**: Prueba los mecanismos de filtrado de contenido y seguridad integrados (bloqueos duros y rechazos suaves)
- **Demo de IA Responsable**: Ejemplo práctico que muestra cómo funcionan los sistemas modernos de seguridad en IA
- **Mejores Prácticas**: Directrices esenciales para el desarrollo y despliegue ético de IA
- **[→ Comienza el Capítulo 5](./05-ResponsibleGenAI/README.md)**

## Recursos Adicionales

<!-- CO-OP TRANSLATOR OTHER COURSES START -->
### Azure / Edge / MCP / Agentes
[![AZD para Principiantes](https://img.shields.io/badge/AZD%20para%20Principiantes-0078D4?style=for-the-badge&labelColor=E5E7EB&color=0078D4)](https://github.com/microsoft/AZD-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Edge AI para Principiantes](https://img.shields.io/badge/Edge%20AI%20para%20Principiantes-00B8E4?style=for-the-badge&labelColor=E5E7EB&color=00B8E4)](https://github.com/microsoft/edgeai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![MCP para Principiantes](https://img.shields.io/badge/MCP%20para%20Principiantes-009688?style=for-the-badge&labelColor=E5E7EB&color=009688)](https://github.com/microsoft/mcp-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Agentes de IA para Principiantes](https://img.shields.io/badge/Agentes%20de%20IA%20para%20Principiantes-00C49A?style=for-the-badge&labelColor=E5E7EB&color=00C49A)](https://github.com/microsoft/ai-agents-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Serie de Generative AI
[![Generative AI para Principiantes](https://img.shields.io/badge/Generative%20AI%20para%20Principiantes-8B5CF6?style=for-the-badge&labelColor=E5E7EB&color=8B5CF6)](https://github.com/microsoft/generative-ai-for-beginners?WT.mc_id=academic-105485-koreyst)
[![Generative AI (.NET)](https://img.shields.io/badge/Generative%20AI%20(.NET)-9333EA?style=for-the-badge&labelColor=E5E7EB&color=9333EA)](https://github.com/microsoft/Generative-AI-for-beginners-dotnet?WT.mc_id=academic-105485-koreyst)
[![Generative AI (Java)](https://img.shields.io/badge/Generative%20AI%20(Java)-C084FC?style=for-the-badge&labelColor=E5E7EB&color=C084FC)](https://github.com/microsoft/generative-ai-for-beginners-java?WT.mc_id=academic-105485-koreyst)
[![Generative AI (JavaScript)](https://img.shields.io/badge/Generative%20AI%20(JavaScript)-E879F9?style=for-the-badge&labelColor=E5E7EB&color=E879F9)](https://github.com/microsoft/generative-ai-with-javascript?WT.mc_id=academic-105485-koreyst)

---
 
### Aprendizaje Básico
[![ML para Principiantes](https://img.shields.io/badge/ML%20para%20Principiantes-22C55E?style=for-the-badge&labelColor=E5E7EB&color=22C55E)](https://aka.ms/ml-beginners?WT.mc_id=academic-105485-koreyst)
[![Ciencia de Datos para Principiantes](https://img.shields.io/badge/Ciencia%20de%20Datos%20para%20Principiantes-84CC16?style=for-the-badge&labelColor=E5E7EB&color=84CC16)](https://aka.ms/datascience-beginners?WT.mc_id=academic-105485-koreyst)
[![IA para Principiantes](https://img.shields.io/badge/IA%20para%20Principiantes-A3E635?style=for-the-badge&labelColor=E5E7EB&color=A3E635)](https://aka.ms/ai-beginners?WT.mc_id=academic-105485-koreyst)
[![Ciberseguridad para Principiantes](https://img.shields.io/badge/Ciberseguridad%20para%20Principiantes-F97316?style=for-the-badge&labelColor=E5E7EB&color=F97316)](https://github.com/microsoft/Security-101?WT.mc_id=academic-96948-sayoung)
[![Desarrollo Web para Principiantes](https://img.shields.io/badge/Desarrollo%20Web%20para%20Principiantes-EC4899?style=for-the-badge&labelColor=E5E7EB&color=EC4899)](https://aka.ms/webdev-beginners?WT.mc_id=academic-105485-koreyst)
[![IoT para Principiantes](https://img.shields.io/badge/IoT%20para%20Principiantes-14B8A6?style=for-the-badge&labelColor=E5E7EB&color=14B8A6)](https://aka.ms/iot-beginners?WT.mc_id=academic-105485-koreyst)
[![Desarrollo XR para Principiantes](https://img.shields.io/badge/Desarrollo%20XR%20para%20Principiantes-38BDF8?style=for-the-badge&labelColor=E5E7EB&color=38BDF8)](https://github.com/microsoft/xr-development-for-beginners?WT.mc_id=academic-105485-koreyst)

---
 
### Serie de Copilot
[![Copilot para Programación en Pareja con IA](https://img.shields.io/badge/Copilot%20para%20Programación%20en%20Pareja%20con%20IA-FACC15?style=for-the-badge&labelColor=E5E7EB&color=FACC15)](https://aka.ms/GitHubCopilotAI?WT.mc_id=academic-105485-koreyst)
[![Copilot para C#/.NET](https://img.shields.io/badge/Copilot%20for%20C%23/.NET-FBBF24?style=for-the-badge&labelColor=E5E7EB&color=FBBF24)](https://github.com/microsoft/mastering-github-copilot-for-dotnet-csharp-developers?WT.mc_id=academic-105485-koreyst)  
[![Aventura Copilot](https://img.shields.io/badge/Copilot%20Adventure-FDE68A?style=for-the-badge&labelColor=E5E7EB&color=FDE68A)](https://github.com/microsoft/CopilotAdventures?WT.mc_id=academic-105485-koreyst)  
<!-- FIN DE OTROS CURSOS DE CO-OP TRANSLATOR -->

## Obtener Ayuda

Si te quedas atascado o tienes preguntas sobre cómo construir aplicaciones de IA, únete a otros estudiantes y desarrolladores experimentados en discusiones sobre MCP. Es una comunidad de apoyo donde las preguntas son bienvenidas y el conocimiento se comparte libremente.

[![Discord de Microsoft Foundry](https://dcbadge.limes.pink/api/server/nTYy5BXMWG)](https://discord.gg/nTYy5BXMWG)

Si tienes comentarios sobre el producto o errores mientras construyes, visita:

[![Foro de Desarrolladores de Microsoft Foundry](https://img.shields.io/badge/GitHub-Microsoft_Foundry_Developer_Forum-blue?style=for-the-badge&logo=github&color=000000&logoColor=fff)](https://aka.ms/foundry/forum)

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Descargo de responsabilidad**:  
Este documento ha sido traducido utilizando el servicio de traducción automática [Co-op Translator](https://github.com/Azure/co-op-translator). Si bien nos esforzamos por lograr precisión, tenga en cuenta que las traducciones automáticas pueden contener errores o imprecisiones. El documento original en su idioma nativo debe considerarse la fuente autorizada. Para información crítica, se recomienda una traducción profesional realizada por humanos. No nos hacemos responsables de malentendidos o interpretaciones erróneas que surjan del uso de esta traducción.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->