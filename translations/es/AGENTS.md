# AGENTS.md

## Resumen del Proyecto

Este es un repositorio educativo para aprender desarrollo de IA Generativa con Java. Ofrece un curso práctico completo que cubre Modelos de Lenguaje Extenso (LLMs), ingeniería de prompts, embeddings, RAG (Generación Aumentada por Recuperación) y el Protocolo de Contexto del Modelo (MCP).

**Tecnologías Clave:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- Modelos de GitHub, Azure OpenAI y SDKs de OpenAI

**Arquitectura:**
- Múltiples aplicaciones independientes de Spring Boot organizadas por capítulos
- Proyectos de ejemplo que demuestran diferentes patrones de IA
- Listo para GitHub Codespaces con contenedores de desarrollo preconfigurados

## Comandos de Configuración

### Requisitos Previos
- Java 21 o superior
- Maven 3.x
- Token de acceso personal de GitHub (para Modelos de GitHub)
- Opcional: Credenciales de Azure OpenAI

### Configuración del Entorno

**Opción 1: GitHub Codespaces (Recomendado)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Opción 2: Contenedor de Desarrollo Local**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Opción 3: Configuración Local**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Configuración

**Configuración del Token de GitHub:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Configuración de Azure OpenAI (Opcional):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Flujo de Trabajo de Desarrollo

### Estructura del Proyecto
```
/
├── 01-IntroToGenAI/              # Chapter 1: Introduction
├── 02-SetupDevEnvironment/       # Chapter 2: Environment setup
│   └── examples/                 # Working examples
├── 03-CoreGenerativeAITechniques/ # Chapter 3: Core techniques
├── 04-PracticalSamples/          # Chapter 4: Sample projects
│   ├── calculator/               # MCP service example
│   ├── foundrylocal/            # Local model integration
│   └── petstory/                # Multi-modal app
├── 05-ResponsibleGenAI/         # Chapter 5: Responsible AI
└── translations/                # Multi-language support
```

### Ejecución de Aplicaciones

**Ejecutar una aplicación de Spring Boot:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Construir un proyecto:**
```bash
cd [project-directory]
mvn clean install
```

**Iniciar el Servidor Calculadora MCP:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Ejecutar Ejemplos de Cliente:**
```bash
# After starting the server in another terminal
cd 04-PracticalSamples/calculator

# Direct MCP client
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.SDKClient"

# AI-powered client (requires GITHUB_TOKEN)
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.LangChain4jClient"

# Interactive bot
mvn exec:java -Dexec.mainClass="com.microsoft.mcp.sample.client.Bot"
```

### Recarga en Caliente
Spring Boot DevTools está incluido en los proyectos que admiten recarga en caliente:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Instrucciones de Pruebas

### Ejecución de Pruebas

**Ejecutar todas las pruebas en un proyecto:**
```bash
cd [project-directory]
mvn test
```

**Ejecutar pruebas con salida detallada:**
```bash
mvn test -X
```

**Ejecutar una clase de prueba específica:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Estructura de Pruebas
- Los archivos de prueba utilizan JUnit 5 (Jupiter)
- Las clases de prueba están ubicadas en `src/test/java/`
- Los ejemplos de cliente en el proyecto de calculadora están en `src/test/java/com/microsoft/mcp/sample/client/`

### Pruebas Manuales
Muchos ejemplos son aplicaciones interactivas que requieren pruebas manuales:

1. Inicia la aplicación con `mvn spring-boot:run`
2. Prueba los endpoints o interactúa con la CLI
3. Verifica que el comportamiento esperado coincida con la documentación en el README.md de cada proyecto

### Pruebas con Modelos de GitHub
- Límites de la versión gratuita: 15 solicitudes/minuto, 150/día
- Máximo de 5 solicitudes concurrentes
- Prueba el filtrado de contenido con ejemplos de IA responsable

## Directrices de Estilo de Código

### Convenciones de Java
- **Versión de Java:** Java 21 con características modernas
- **Estilo:** Sigue las convenciones estándar de Java
- **Nomenclatura:** 
  - Clases: PascalCase
  - Métodos/variables: camelCase
  - Constantes: UPPER_SNAKE_CASE
  - Nombres de paquetes: minúsculas

### Patrones de Spring Boot
- Usa `@Service` para lógica de negocio
- Usa `@RestController` para endpoints REST
- Configuración mediante `application.yml` o `application.properties`
- Variables de entorno preferidas sobre valores codificados
- Usa la anotación `@Tool` para métodos expuestos por MCP

### Organización de Archivos
```
src/
├── main/
│   ├── java/
│   │   └── com/microsoft/[component]/
│   │       ├── [Component]Application.java
│   │       ├── config/
│   │       ├── controller/
│   │       ├── service/
│   │       └── exception/
│   └── resources/
│       ├── application.yml
│       └── static/
└── test/
    └── java/
        └── com/microsoft/[component]/
```

### Dependencias
- Gestionadas mediante `pom.xml` de Maven
- BOM de Spring AI para gestión de versiones
- LangChain4j para integraciones de IA
- Spring Boot starter parent para dependencias de Spring

### Comentarios de Código
- Agrega JavaDoc para APIs públicas
- Incluye comentarios explicativos para interacciones complejas de IA
- Documenta claramente las descripciones de herramientas MCP

## Construcción y Despliegue

### Construcción de Proyectos

**Construir sin pruebas:**
```bash
mvn clean install -DskipTests
```

**Construir con todas las verificaciones:**
```bash
mvn clean install
```

**Empaquetar aplicación:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Directorios de Salida
- Clases compiladas: `target/classes/`
- Clases de prueba: `target/test-classes/`
- Archivos JAR: `target/*.jar`
- Artefactos de Maven: `target/`

### Configuración Específica del Entorno

**Desarrollo:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Producción:**
- Usa Modelos de Azure AI Foundry en lugar de Modelos de GitHub
- Actualiza la base-url al endpoint de Azure OpenAI
- Gestiona secretos mediante Azure Key Vault o variables de entorno

### Consideraciones de Despliegue
- Este es un repositorio educativo con aplicaciones de ejemplo
- No está diseñado para despliegue en producción tal cual
- Los ejemplos demuestran patrones para adaptar a producción
- Consulta los README.md de cada proyecto para notas específicas de despliegue

## Notas Adicionales

### Modelos de GitHub vs Azure OpenAI
- **Modelos de GitHub:** Versión gratuita para aprendizaje, no requiere tarjeta de crédito
- **Azure OpenAI:** Listo para producción, requiere suscripción a Azure
- El código es compatible entre ambos: solo cambia el endpoint y la clave API

### Trabajando con Múltiples Proyectos
Cada proyecto de ejemplo es independiente:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Problemas Comunes

**Incompatibilidad de Versión de Java:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Problemas de Descarga de Dependencias:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**Token de GitHub No Encontrado:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Puerto Ya en Uso:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Soporte Multilingüe
- Documentación disponible en más de 45 idiomas mediante traducción automática
- Traducciones en el directorio `translations/`
- Traducción gestionada por el flujo de trabajo de GitHub Actions

### Ruta de Aprendizaje
1. Comienza con [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Sigue los capítulos en orden (01 → 05)
3. Completa los ejemplos prácticos en cada capítulo
4. Explora los proyectos de ejemplo en el Capítulo 4
5. Aprende prácticas de IA responsable en el Capítulo 5

### Contenedor de Desarrollo
El archivo `.devcontainer/devcontainer.json` configura:
- Entorno de desarrollo con Java 21
- Maven preinstalado
- Extensiones de Java para VS Code
- Herramientas de Spring Boot
- Integración con GitHub Copilot
- Soporte para Docker-in-Docker
- CLI de Azure

### Consideraciones de Rendimiento
- La versión gratuita de Modelos de GitHub tiene límites de tasa
- Usa tamaños de lote apropiados para embeddings
- Considera el uso de caché para llamadas repetidas a la API
- Monitorea el uso de tokens para optimizar costos

### Notas de Seguridad
- Nunca comprometas archivos `.env` (ya están en `.gitignore`)
- Usa variables de entorno para claves API
- Los tokens de GitHub deben tener los permisos mínimos necesarios
- Sigue las directrices de IA responsable en el Capítulo 5

---

**Descargo de responsabilidad**:  
Este documento ha sido traducido utilizando el servicio de traducción automática [Co-op Translator](https://github.com/Azure/co-op-translator). Aunque nos esforzamos por garantizar la precisión, tenga en cuenta que las traducciones automatizadas pueden contener errores o imprecisiones. El documento original en su idioma nativo debe considerarse como la fuente autorizada. Para información crítica, se recomienda una traducción profesional realizada por humanos. No nos hacemos responsables de malentendidos o interpretaciones erróneas que puedan surgir del uso de esta traducción.