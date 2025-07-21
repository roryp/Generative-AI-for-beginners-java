<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "2289320a74aeca1eb844cd7d3a7a9e12",
  "translation_date": "2025-07-21T16:28:09+00:00",
  "source_file": "02-SetupDevEnvironment/src/basic-chat-azure/README.md",
  "language_code": "es"
}
-->
# Chat Básico con Azure OpenAI - Ejemplo de Principio a Fin

Este ejemplo demuestra cómo crear una aplicación simple de Spring Boot que se conecta a Azure OpenAI y prueba tu configuración.

## Tabla de Contenidos

- [Requisitos Previos](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Inicio Rápido](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Opciones de Configuración](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Opción 1: Variables de Entorno (archivo .env) - Recomendado](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Opción 2: Secretos de GitHub Codespace](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Ejecutando la Aplicación](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Usando Maven](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Usando VS Code](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Salida Esperada](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Referencia de Configuración](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Variables de Entorno](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Configuración de Spring](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Solución de Problemas](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Problemas Comunes](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
  - [Modo Depuración](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Próximos Pasos](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)
- [Recursos](../../../../../02-SetupDevEnvironment/src/basic-chat-azure)

## Requisitos Previos

Antes de ejecutar este ejemplo, asegúrate de tener:

- Completada la [guía de configuración de Azure OpenAI](../../getting-started-azure-openai.md)  
- Un recurso de Azure OpenAI desplegado (a través del portal de Azure AI Foundry)  
- El modelo gpt-4o-mini desplegado (u otro modelo alternativo)  
- La clave API y la URL del endpoint de Azure  

## Inicio Rápido

```bash
# 1. Navigate to project
cd 02-SetupDevEnvironment/src/basic-chat-azure

# 2. Configure credentials
cp .env.example .env
# Edit .env with your Azure OpenAI credentials

# 3. Run the application
mvn spring-boot:run
```

## Opciones de Configuración

### Opción 1: Variables de Entorno (archivo .env) - Recomendado

**Paso 1: Crea tu archivo de configuración**  
```bash
cp .env.example .env
```

**Paso 2: Agrega tus credenciales de Azure OpenAI**  
```bash
# Your Azure OpenAI API key (from Azure AI Foundry portal)
AZURE_AI_KEY=your-actual-api-key-here

# Your Azure OpenAI endpoint URL (e.g., https://your-hub-name.openai.azure.com/)
AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

> **Nota de Seguridad**:  
> - Nunca subas tu archivo `.env` al control de versiones  
> - El archivo `.env` ya está incluido en `.gitignore`  
> - Mantén tus claves API seguras y rótalas regularmente  

### Opción 2: Secretos de GitHub Codespace

Para GitHub Codespaces, configura estos secretos en tu repositorio:  
- `AZURE_AI_KEY` - Tu clave API de Azure OpenAI  
- `AZURE_AI_ENDPOINT` - La URL del endpoint de Azure OpenAI  

La aplicación detecta y utiliza automáticamente estos secretos.

### Alternativa: Variables de Entorno Directas

<details>
<summary>Haz clic para ver los comandos específicos de la plataforma</summary>

**Linux/macOS (bash/zsh):**  
```bash
export AZURE_AI_KEY=your-actual-api-key-here
export AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (Command Prompt):**  
```cmd
set AZURE_AI_KEY=your-actual-api-key-here
set AZURE_AI_ENDPOINT=https://your-hub-name.openai.azure.com/
```

**Windows (PowerShell):**  
```powershell
$env:AZURE_AI_KEY="your-actual-api-key-here"
$env:AZURE_AI_ENDPOINT="https://your-hub-name.openai.azure.com/"
```
</details>

## Ejecutando la Aplicación

### Usando Maven

```bash
mvn spring-boot:run
```

### Usando VS Code

1. Abre el proyecto en VS Code  
2. Presiona `F5` o usa el panel "Run and Debug"  
3. Selecciona la configuración "Spring Boot-BasicChatApplication"  

> **Nota**: La configuración de VS Code carga automáticamente tu archivo .env  

### Salida Esperada

```
Starting Basic Chat with Azure OpenAI...
Environment variables loaded successfully
Connecting to Azure OpenAI...
Sending prompt: What is AI in a short sentence? Max 100 words.

AI Response:
================
AI, or Artificial Intelligence, is the simulation of human intelligence in machines programmed to think and learn like humans.
================

Success! Azure OpenAI connection is working correctly.
```

## Referencia de Configuración

### Variables de Entorno

| Variable | Descripción | Obligatoria | Ejemplo |
|----------|-------------|-------------|---------|
| `AZURE_AI_KEY` | Clave API de Azure OpenAI | Sí | `abc123...` |
| `AZURE_AI_ENDPOINT` | URL del endpoint de Azure OpenAI | Sí | `https://my-hub.openai.azure.com/` |
| `AZURE_AI_MODEL_DEPLOYMENT` | Nombre del despliegue del modelo | No | `gpt-4o-mini` (por defecto) |

### Configuración de Spring

El archivo `application.yml` configura:  
- **Clave API**: `${AZURE_AI_KEY}` - Desde la variable de entorno  
- **Endpoint**: `${AZURE_AI_ENDPOINT}` - Desde la variable de entorno  
- **Modelo**: `${AZURE_AI_MODEL_DEPLOYMENT:gpt-4o-mini}` - Desde la variable de entorno con valor predeterminado  
- **Temperatura**: `0.7` - Controla la creatividad (0.0 = determinista, 1.0 = creativo)  
- **Tokens Máximos**: `500` - Longitud máxima de la respuesta  

## Solución de Problemas

### Problemas Comunes

<details>
<summary><strong>Error: "La clave API no es válida"</strong></summary>

- Verifica que tu `AZURE_AI_KEY` esté correctamente configurada en tu archivo `.env`  
- Asegúrate de copiar la clave API exactamente como aparece en el portal de Azure AI Foundry  
- Comprueba que no haya espacios adicionales o comillas alrededor de la clave  
</details>

<details>
<summary><strong>Error: "El endpoint no es válido"</strong></summary>

- Asegúrate de que tu `AZURE_AI_ENDPOINT` incluya la URL completa (por ejemplo, `https://your-hub-name.openai.azure.com/`)  
- Verifica la consistencia de la barra final  
- Confirma que el endpoint coincide con la región de tu despliegue en Azure  
</details>

<details>
<summary><strong>Error: "El despliegue no fue encontrado"</strong></summary>

- Verifica que el nombre del despliegue del modelo coincida exactamente con lo que está desplegado en Azure  
- Asegúrate de que el modelo esté desplegado y activo  
- Intenta usar el nombre de despliegue predeterminado: `gpt-4o-mini`  
</details>

<details>
<summary><strong>VS Code: Las variables de entorno no se cargan</strong></summary>

- Asegúrate de que tu archivo `.env` esté en el directorio raíz del proyecto (al mismo nivel que `pom.xml`)  
- Intenta ejecutar `mvn spring-boot:run` en la terminal integrada de VS Code  
- Verifica que la extensión de Java para VS Code esté correctamente instalada  
- Confirma que la configuración de lanzamiento tenga `"envFile": "${workspaceFolder}/.env"`  
</details>

### Modo Depuración

Para habilitar el registro detallado, descomenta estas líneas en `application.yml`:  

```yaml
logging:
  level:
    org.springframework.ai: DEBUG
    com.azure: DEBUG
```

## Próximos Pasos

**¡Configuración Completa!** Continúa tu aprendizaje:  

[Capítulo 3: Técnicas Fundamentales de IA Generativa](../../../03-CoreGenerativeAITechniques/README.md)

## Recursos

- [Documentación de Spring AI Azure OpenAI](https://docs.spring.io/spring-ai/reference/api/clients/azure-openai-chat.html)  
- [Documentación del Servicio Azure OpenAI](https://learn.microsoft.com/azure/ai-services/openai/)  
- [Portal de Azure AI Foundry](https://ai.azure.com/)  
- [Documentación de Azure AI Foundry](https://learn.microsoft.com/azure/ai-foundry/how-to/create-projects?tabs=ai-foundry&pivots=hub-project)  

**Descargo de responsabilidad**:  
Este documento ha sido traducido utilizando el servicio de traducción automática [Co-op Translator](https://github.com/Azure/co-op-translator). Aunque nos esforzamos por garantizar la precisión, tenga en cuenta que las traducciones automatizadas pueden contener errores o imprecisiones. El documento original en su idioma nativo debe considerarse como la fuente autorizada. Para información crítica, se recomienda una traducción profesional realizada por humanos. No nos hacemos responsables de malentendidos o interpretaciones erróneas que puedan surgir del uso de esta traducción.