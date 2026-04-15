# Tutorial de Foundry Local con Spring Boot

## Tabla de Contenidos

- [Prerequisitos](#prerequisitos)
- [Resumen del Proyecto](#resumen-del-proyecto)
- [Entendiendo el Código](#entendiendo-el-código)
  - [1. Configuración de la Aplicación (application.properties)](#1-configuración-de-la-aplicación-applicationproperties)
  - [2. Clase Principal de la Aplicación (Application.java)](#2-clase-principal-de-la-aplicación-applicationjava)
  - [3. Capa de Servicio AI (FoundryLocalService.java)](#3-capa-de-servicio-ai-foundrylocalservicejava)
  - [4. Dependencias del Proyecto (pom.xml)](#4-dependencias-del-proyecto-pomxml)
- [Cómo Funciona Todo Junto](#cómo-funciona-todo-junto)
- [Configurando Foundry Local](#configurando-foundry-local)
- [Ejecutando la Aplicación](#ejecutando-la-aplicación)
- [Salida Esperada](#salida-esperada)
- [Próximos Pasos](#próximos-pasos)
- [Solución de Problemas](#solución-de-problemas)


## Prerequisitos

Antes de comenzar este tutorial, asegúrate de tener:

- **Java 21 o superior** instalado en tu sistema
- **Maven 3.6+** para compilar el proyecto
- **Foundry Local** instalado y en ejecución

### **Instalar Foundry Local:**

> **Nota:** La CLI de Foundry Local está disponible solo en **Windows** y **macOS**. Linux está soportado a través de los [Foundry Local SDKs](https://github.com/microsoft/Foundry-Local) (Python, JavaScript, C#, Rust).

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS
brew tap microsoft/foundrylocal
brew install foundrylocal
```

Verifica la instalación:
```bash
foundry --version
```

## Resumen del Proyecto

Este proyecto consta de cuatro componentes principales:

1. **Application.java** - Punto de entrada principal de la aplicación Spring Boot
2. **FoundryLocalService.java** - Capa de servicio que maneja la comunicación con la IA
3. **application.properties** - Configuración para la conexión a Foundry Local
4. **pom.xml** - Dependencias de Maven y configuración del proyecto

## Entendiendo el Código

### 1. Configuración de la Aplicación (application.properties)

**Archivo:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
# foundry.local.model is auto-detected from Foundry Local. Set it here to override:
# foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
```

**Qué hace esto:**
- **base-url**: Especifica dónde está ejecutándose Foundry Local, incluyendo la ruta `/v1` para compatibilidad con la API OpenAI. El puerto por defecto es `5273`. Si el puerto es diferente, verifícalo con `foundry service status`.
- **model** (opcional): Nombra el modelo de IA que se utilizará para generación de texto. **Por defecto, la aplicación detecta automáticamente el modelo** consultando el endpoint `/v1/models` de Foundry Local al inicio, así que no es necesario configurarlo. Aún puedes configurarlo explícitamente para sobrescribir la detección automática si lo deseas.

**Concepto clave:** Spring Boot carga automáticamente estas propiedades y las pone a disposición de tu aplicación mediante la anotación `@Value`.

### 2. Clase Principal de la Aplicación (Application.java)

**Archivo:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No se necesita servidor web
        app.run(args);
    }
```

**Qué hace esto:**
- `@SpringBootApplication` habilita la autoconfiguración de Spring Boot
- `WebApplicationType.NONE` indica a Spring que esta es una aplicación de línea de comandos, no un servidor web
- El método main inicia la aplicación Spring

**El Demo Runner:**
```java
@Bean
public CommandLineRunner foundryLocalRunner(FoundryLocalService foundryLocalService) {
    return args -> {
        System.out.println("=== Foundry Local Demo ===");
        System.out.println("Calling Foundry Local service...");
        
        String testMessage = "Hello! Can you tell me what you are and what model you're running?";
        System.out.println("Sending message: " + testMessage);
        
        String response = foundryLocalService.chat(testMessage);
        System.out.println("Response from Foundry Local:");
        System.out.println(response);
        System.out.println("=========================");
    };
}
```

**Qué hace esto:**
- `@Bean` crea un componente que Spring maneja
- `CommandLineRunner` ejecuta código después de que Spring Boot inicia
- `foundryLocalService` se inyecta automáticamente por Spring (inyección de dependencias)
- Envía un mensaje de prueba a la IA y muestra la respuesta

### 3. Capa de Servicio AI (FoundryLocalService.java)

**Archivo:** `src/main/java/com/example/FoundryLocalService.java`

#### Inyección de Configuración:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:}")
    private String model;    // Detectado automáticamente si está vacío
```

**Qué hace esto:**
- `@Service` indica a Spring que esta clase proporciona lógica de negocio
- `@Value` inyecta valores de configuración desde application.properties
- El modelo por defecto es vacío, lo que activa la **detección automática** desde Foundry Local al inicio. Esto permite que la app funcione con cualquier modelo cargado en Foundry Local sin configuración manual.

#### Inicialización del Cliente:
```java
@PostConstruct
public void init() {
    // Detectar automáticamente el modelo desde Foundry Local si no está configurado explícitamente
    if (model == null || model.isBlank()) {
        model = detectModel();
    }

    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // La URL base ya incluye /v1 de la configuración
            .apiKey("not-needed")            // El servidor local no necesita una clave API real
            .build();
}
```

**Qué hace esto:**
- `@PostConstruct` ejecuta este método tras crear el servicio Spring
- Si no hay modelo configurado, consulta el endpoint `/v1/models` de Foundry Local y toma el primer modelo cargado
- Crea un cliente OpenAI que apunta a tu instancia local de Foundry Local
- La URL base de `application.properties` ya incluye `/v1` para compatibilidad con la API OpenAI
- La clave API es "not-needed" porque el desarrollo local no requiere autenticación

#### Método de Chat:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Qué modelo de IA utilizar
                .addUserMessage(message)         // Tu pregunta/sugerencia
                .maxCompletionTokens(150)        // Limitar la longitud de la respuesta
                .temperature(0.7)                // Controlar la creatividad (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Extraer la respuesta de la IA del resultado de la API
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**Qué hace esto:**
- **ChatCompletionCreateParams**: Configura la solicitud a la IA
  - `model`: Especifica qué modelo de IA usar (debe coincidir con el ID exacto de `foundry model list`)
  - `addUserMessage`: Añade tu mensaje a la conversación
  - `maxCompletionTokens`: Limita la longitud de la respuesta (ahorra recursos)
  - `temperature`: Controla la aleatoriedad (0.0 = determinista, 1.0 = creativo)
- **Llamada API**: Envía la solicitud a Foundry Local
- **Manejo de Respuesta**: Extrae la respuesta textual de la IA de forma segura
- **Manejo de Errores**: Envuelve excepciones con mensajes de error claros

### 4. Dependencias del Proyecto (pom.xml)

**Dependencias Clave:**

```xml
<!-- Spring Boot - Application framework -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <version>${spring-boot.version}</version>
</dependency>

<!-- OpenAI Java SDK - For AI API calls -->
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>

<!-- Jackson - JSON processing -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.0</version>
</dependency>
```

**Qué hacen estas:**
- **spring-boot-starter**: Proporciona funcionalidad básica de Spring Boot
- **openai-java**: SDK oficial de OpenAI para Java para comunicación con la API
- **jackson-databind**: Maneja la serialización/deserialización JSON para llamadas API

## Cómo Funciona Todo Junto

Este es el flujo completo cuando ejecutas la aplicación:

1. **Inicio**: Spring Boot arranca y lee `application.properties`
2. **Creación del Servicio**: Spring crea `FoundryLocalService` e inyecta los valores de configuración
3. **Detección de Modelo**: Si no hay modelo configurado, el servicio consulta `/v1/models` de Foundry Local y usa automáticamente el primer modelo disponible
4. **Configuración del Cliente**: `@PostConstruct` inicializa el cliente OpenAI para conectar con Foundry Local
5. **Ejecución del Demo**: `CommandLineRunner` se ejecuta después del inicio
6. **Llamada IA**: El demo llama a `foundryLocalService.chat()` con un mensaje de prueba
7. **Solicitud API**: El servicio construye y envía una solicitud compatible con OpenAI a Foundry Local
8. **Procesamiento de Respuesta**: El servicio extrae y devuelve la respuesta de la IA
9. **Visualización**: La aplicación imprime la respuesta y finaliza

## Configurando Foundry Local

1. **Instala Foundry Local** siguiendo las instrucciones en la sección de [Prerequisitos](#prerequisitos).

2. **Inicia el servicio** (si no está corriendo):
   ```bash
   foundry service start
   ```

3. **Verifica el estado del servicio** para confirmar que está ejecutándose y anota el puerto:
   ```bash
   foundry service status
   ```

4. **Descarga y ejecuta un modelo** (se descarga la primera vez y se guarda en caché para futuras ejecuciones):
   ```bash
   foundry model run phi-4-mini
   ```
   Esto abre una sesión de chat interactiva. Puedes salir con `Ctrl+C`. El modelo permanece cargado en el servicio.

   > **Consejo:** Ejecuta `foundry model list` para ver todos los modelos disponibles. Reemplaza `phi-4-mini` con cualquier alias del catálogo (ej., `qwen2.5-0.5b` para un modelo más pequeño/rápido).

5. **Verifica que el modelo esté cargado:**
   ```bash
   foundry service ps
   ```

6. **Actualiza `application.properties`** si es necesario:
   - La `base-url` por defecto (`http://localhost:5273/v1`) coincide con el puerto por defecto de la CLI. Actualízala solo si `foundry service status` muestra un puerto diferente.
   - El modelo es **detectado automáticamente** al inicio — no requiere configuración.

   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   # Model is auto-detected. Uncomment below to override:
   # foundry.local.model=Phi-4-mini-instruct-cuda-gpu:5
   ```

## Ejecutando la Aplicación

### Paso 1: Asegúrate de que un modelo esté cargado en Foundry Local
```bash
foundry service ps
```
Si no hay modelos listados, carga uno:
```bash
foundry model run phi-4-mini
```

### Paso 2: Compila y Ejecuta la Aplicación
En una terminal separada:
```bash
cd 04-PracticalSamples/foundrylocal
mvn spring-boot:run
```

O compílala y ejecútala como JAR:
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Salida Esperada

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI developed by Microsoft. I can assist with a wide variety of 
tasks including answering questions, helping with analysis, creative writing, coding, 
and general conversation. How can I help you today?
=========================
```

## Próximos Pasos

Para más ejemplos, consulta [Capítulo 04: Ejemplos prácticos](../README.md)

## Solución de Problemas

### Problemas Comunes

**"Conexión rechazada" o "Servicio no disponible"**
- Verifica el servicio: `foundry service status`
- Reinicia si es necesario: `foundry service restart`
- Asegúrate que el puerto en `application.properties` coincida con la salida de `foundry service status`
- Verifica que la URL termine con `/v1`: `http://localhost:5273/v1`

**"No se encontró modelo" al iniciar**
- La aplicación detecta el modelo automáticamente. Asegúrate que haya al menos un modelo cargado: `foundry service ps`
- Si no hay modelos cargados: `foundry model run phi-4-mini`
- Si sobreescribiste el nombre del modelo en `application.properties`, verifica que coincida con `foundry model list`

**Errores "400 Bad Request"**
- Verifica que la URL base incluya `/v1`: `http://localhost:5273/v1`
- Asegúrate de usar `maxCompletionTokens()` en tu código (no el obsoleto `maxTokens()`)

**Errores de compilación en Maven**
- Asegúrate de tener Java 21 o superior: `java -version`
- Limpia y recompila: `mvn clean compile`
- Verifica la conexión a internet para descargar dependencias

**Problemas de conexión al servicio**
- Si ves `Request to local service failed`, ejecuta: `foundry service restart`
- Revisa los modelos cargados: `foundry service ps`
- Consulta los logs del servicio: `foundry service diag`

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Descargo de responsabilidad**:  
Este documento ha sido traducido utilizando el servicio de traducción automática [Co-op Translator](https://github.com/Azure/co-op-translator). Aunque nos esforzamos por la precisión, tenga en cuenta que las traducciones automáticas pueden contener errores o inexactitudes. El documento original en su idioma nativo debe considerarse la fuente autorizada. Para información crítica, se recomienda una traducción profesional realizada por humanos. No nos hacemos responsables de ningún malentendido o interpretación errónea derivada del uso de esta traducción.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->