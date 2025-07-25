<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "139c227ef39d24287257d1aff6fc6973",
  "translation_date": "2025-07-25T08:42:23+00:00",
  "source_file": "04-PracticalSamples/README.md",
  "language_code": "es"
}
-->
# Aplicaciones Prácticas y Proyectos

> Nota: Cada ejemplo también incluye un archivo **TUTORIAL.md** que te guía para ejecutar las muestras.

## Lo Que Aprenderás
En esta sección, mostraremos tres aplicaciones prácticas que destacan patrones de desarrollo de IA generativa con Java:
- Crear un Generador de Historias de Mascotas multimodal que combina IA del lado del cliente y del servidor
- Implementar la integración de modelos de IA locales con el demo Foundry Local Spring Boot
- Desarrollar un servicio de Protocolo de Contexto de Modelo (MCP) con el ejemplo de Calculadora

## Tabla de Contenidos

- [Introducción](../../../04-PracticalSamples)
  - [Demo Foundry Local Spring Boot](../../../04-PracticalSamples)
  - [Generador de Historias de Mascotas](../../../04-PracticalSamples)
  - [Servicio MCP Calculadora (Demo MCP para Principiantes)](../../../04-PracticalSamples)
- [Progresión de Aprendizaje](../../../04-PracticalSamples)
- [Resumen](../../../04-PracticalSamples)
- [Próximos Pasos](../../../04-PracticalSamples)

## Introducción

Este capítulo presenta **proyectos de ejemplo** que demuestran patrones de desarrollo de IA generativa con Java. Cada proyecto es completamente funcional y muestra tecnologías específicas de IA, patrones arquitectónicos y mejores prácticas que puedes adaptar a tus propias aplicaciones.

### Demo Foundry Local Spring Boot

El **[Demo Foundry Local Spring Boot](foundrylocal/README.md)** demuestra cómo integrarse con modelos de IA locales utilizando el **OpenAI Java SDK**. Muestra cómo conectarse al modelo **Phi-3.5-mini** ejecutándose en Foundry Local, permitiéndote ejecutar aplicaciones de IA sin depender de servicios en la nube.

### Generador de Historias de Mascotas

El **[Generador de Historias de Mascotas](petstory/README.md)** es una aplicación web de Spring Boot que demuestra el **procesamiento de IA multimodal** para generar historias creativas de mascotas. Combina capacidades de IA del lado del cliente y del servidor utilizando transformer.js para interacciones de IA en el navegador y el OpenAI SDK para el procesamiento del lado del servidor.

### Servicio MCP Calculadora (Demo MCP para Principiantes)

El **[Servicio MCP Calculadora](mcp/calculator/README.md)** es una demostración sencilla del **Protocolo de Contexto de Modelo (MCP)** utilizando Spring AI. Proporciona una introducción amigable para principiantes a los conceptos de MCP, mostrando cómo crear un servidor MCP básico que interactúa con clientes MCP.

## Progresión de Aprendizaje

Estos proyectos están diseñados para construir conceptos basados en capítulos anteriores:

1. **Comienza Simple**: Inicia con el Demo Foundry Local Spring Boot para entender la integración básica de IA con modelos locales
2. **Añade Interactividad**: Avanza al Generador de Historias de Mascotas para procesamiento de IA multimodal e interacciones basadas en la web
3. **Aprende los Fundamentos de MCP**: Prueba el Servicio MCP Calculadora para comprender los conceptos básicos del Protocolo de Contexto de Modelo

## Resumen

**¡Felicidades!** Has logrado:

- **Crear experiencias de IA multimodal** combinando procesamiento de IA del lado del cliente y del servidor
- **Implementar integración de modelos de IA locales** utilizando frameworks y SDKs modernos de Java
- **Desarrollar servicios de Protocolo de Contexto de Modelo** que demuestran patrones de integración de herramientas

## Próximos Pasos

[Capítulo 5: IA Generativa Responsable](../05-ResponsibleGenAI/README.md)

**Descargo de responsabilidad**:  
Este documento ha sido traducido utilizando el servicio de traducción automática [Co-op Translator](https://github.com/Azure/co-op-translator). Aunque nos esforzamos por garantizar la precisión, tenga en cuenta que las traducciones automatizadas pueden contener errores o imprecisiones. El documento original en su idioma nativo debe considerarse como la fuente autorizada. Para información crítica, se recomienda una traducción profesional realizada por humanos. No nos hacemos responsables de malentendidos o interpretaciones erróneas que puedan surgir del uso de esta traducción.