<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "b8a372dfc3e3e7ad9261231a22fd79c0",
  "translation_date": "2025-07-25T08:41:59+00:00",
  "source_file": "03-CoreGenerativeAITechniques/README.md",
  "language_code": "es"
}
-->
# Técnicas Fundamentales de IA Generativa

>**Nota**: Este capítulo incluye un [**Tutorial**](./TUTORIAL.md) detallado que te guía a través de los ejemplos.

## Qué Aprenderás
En este capítulo, exploramos 4 técnicas fundamentales de IA generativa mediante ejemplos prácticos:
- Completaciones de LLM y flujos de chat
- Llamadas a funciones
- Generación Aumentada por Recuperación (RAG)
- Medidas de seguridad en IA responsable

## Tabla de Contenidos

- [Qué Aprenderás](../../../03-CoreGenerativeAITechniques)
- [Requisitos Previos](../../../03-CoreGenerativeAITechniques)
- [Primeros Pasos](../../../03-CoreGenerativeAITechniques)
- [Resumen de Ejemplos](../../../03-CoreGenerativeAITechniques)
  - [1. Completaciones de LLM y Flujos de Chat](../../../03-CoreGenerativeAITechniques)
  - [2. Funciones y Plugins con LLMs](../../../03-CoreGenerativeAITechniques)
  - [3. Generación Aumentada por Recuperación (RAG)](../../../03-CoreGenerativeAITechniques)
  - [4. Demostración de Seguridad en IA Responsable](../../../03-CoreGenerativeAITechniques)
- [Resumen](../../../03-CoreGenerativeAITechniques)
- [Próximos Pasos](../../../03-CoreGenerativeAITechniques)

## Requisitos Previos

- Haber completado la configuración del [Capítulo 2](../../../02-SetupDevEnvironment)

## Primeros Pasos

1. **Navega a los ejemplos**:  
```bash
cd 03-CoreGenerativeAITechniques/examples/
```  
2. **Configura el entorno**:  
```bash
export GITHUB_TOKEN=your_token_here
```  
3. **Compila y ejecuta los ejemplos**:  
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

## Resumen de Ejemplos

Los ejemplos están organizados en la carpeta `examples/` con la siguiente estructura:

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

### 1. Completaciones de LLM y Flujos de Chat
**Archivo**: `examples/src/main/java/com/example/genai/techniques/completions/LLMCompletionsApp.java`

Aprende a construir IA conversacional con respuestas en streaming y gestión del historial de chat.

Este ejemplo demuestra:
- Completación de texto simple con indicaciones del sistema
- Conversaciones de múltiples turnos con gestión del historial
- Sesiones de chat interactivas
- Configuración de parámetros (temperatura, tokens máximos)

### 2. Funciones y Plugins con LLMs
**Archivo**: `examples/src/main/java/com/example/genai/techniques/functions/FunctionsApp.java`

Amplía las capacidades de la IA proporcionando acceso a funciones personalizadas y APIs externas.

Este ejemplo demuestra:
- Integración de una función de clima
- Implementación de una función de calculadora  
- Múltiples llamadas a funciones en una sola conversación
- Definición de funciones con esquemas JSON

### 3. Generación Aumentada por Recuperación (RAG)
**Archivo**: `examples/src/main/java/com/example/genai/techniques/rag/SimpleReaderDemo.java`

Aprende a combinar IA con tus propios documentos y fuentes de datos para obtener respuestas precisas y con contexto.

Este ejemplo demuestra:
- Respuestas a preguntas basadas en documentos con Azure OpenAI SDK
- Implementación del patrón RAG con Modelos de GitHub

**Uso**: Haz preguntas sobre el contenido en `document.txt` y obtén respuestas de la IA basadas únicamente en ese contexto.

### 4. Demostración de Seguridad en IA Responsable
**Archivo**: `examples/src/main/java/com/example/genai/techniques/responsibleai/ResponsibleGithubModels.java`

Obtén una vista previa de cómo funcionan las medidas de seguridad en IA probando las capacidades de filtrado de contenido de los Modelos de GitHub.

Este ejemplo demuestra:
- Filtrado de contenido para indicaciones potencialmente dañinas
- Manejo de respuestas seguras en aplicaciones
- Diferentes categorías de contenido bloqueado (violencia, discurso de odio, desinformación)
- Manejo adecuado de errores por violaciones de seguridad

> **Aprende Más**: Esto es solo una introducción a los conceptos de IA responsable. Para más información sobre ética, mitigación de sesgos, consideraciones de privacidad y marcos de IA responsable, consulta [Capítulo 5: IA Generativa Responsable](../05-ResponsibleGenAI/README.md).

## Resumen

En este capítulo, exploramos las completaciones de LLM y flujos de chat, implementamos llamadas a funciones para mejorar las capacidades de la IA, creamos un sistema de Generación Aumentada por Recuperación (RAG) y demostramos medidas de seguridad en IA responsable.

> **NOTA**: Profundiza más con el [**Tutorial**](./TUTORIAL.md) proporcionado.

## Próximos Pasos

[Capítulo 4: Aplicaciones Prácticas y Proyectos](../04-PracticalSamples/README.md)

**Descargo de responsabilidad**:  
Este documento ha sido traducido utilizando el servicio de traducción automática [Co-op Translator](https://github.com/Azure/co-op-translator). Aunque nos esforzamos por garantizar la precisión, tenga en cuenta que las traducciones automatizadas pueden contener errores o imprecisiones. El documento original en su idioma nativo debe considerarse como la fuente autorizada. Para información crítica, se recomienda una traducción profesional realizada por humanos. No nos hacemos responsables de malentendidos o interpretaciones erróneas que puedan surgir del uso de esta traducción.