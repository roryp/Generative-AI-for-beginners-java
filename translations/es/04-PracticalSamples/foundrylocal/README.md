# Tutorial de Foundry Local con Spring Boot

## Tabla de Contenidos

- [Requisitos previos](../../../../04-PracticalSamples/foundrylocal)
- [Descripción del proyecto](../../../../04-PracticalSamples/foundrylocal)
- [Entendiendo el código](../../../../04-PracticalSamples/foundrylocal)
  - [1. Configuración de la aplicación (application.properties)](../../../../04-PracticalSamples/foundrylocal)
  - [2. Clase principal de la aplicación (Application.java)](../../../../04-PracticalSamples/foundrylocal)
  - [3. Capa de servicio de IA (FoundryLocalService.java)](../../../../04-PracticalSamples/foundrylocal)
  - [4. Dependencias del proyecto (pom.xml)](../../../../04-PracticalSamples/foundrylocal)
- [Cómo funciona todo junto](../../../../04-PracticalSamples/foundrylocal)
- [Configurando Foundry Local](../../../../04-PracticalSamples/foundrylocal)
- [Ejecutando la aplicación](../../../../04-PracticalSamples/foundrylocal)
- [Salida esperada](../../../../04-PracticalSamples/foundrylocal)
- [Próximos pasos](../../../../04-PracticalSamples/foundrylocal)
- [Resolución de problemas](../../../../04-PracticalSamples/foundrylocal)

## Requisitos previos

Antes de comenzar este tutorial, asegúrate de tener:

- **Java 21 o superior** instalado en tu sistema
- **Maven 3.6+** para construir el proyecto
- **Foundry Local** instalado y en ejecución

### **Instalar Foundry Local:**

```bash
# Windows
winget install Microsoft.FoundryLocal

# macOS (after installing)
foundry model run phi-3.5-mini
```

## Descripción del proyecto

Este proyecto consta de cuatro componentes principales:

1. **Application.java** - El punto de entrada principal de la aplicación Spring Boot
2. **FoundryLocalService.java** - Capa de servicio que maneja la comunicación con la IA
3. **application.properties** - Configuración para la conexión con Foundry Local
4. **pom.xml** - Dependencias de Maven y configuración del proyecto

## Entendiendo el código

### 1. Configuración de la aplicación (application.properties)

**Archivo:** `src/main/resources/application.properties`

```properties
foundry.local.base-url=http://localhost:5273/v1
foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
```

**Qué hace:**
- **base-url**: Especifica dónde está ejecutándose Foundry Local, incluyendo el camino `/v1` para compatibilidad con la API de OpenAI. **Nota**: Foundry Local asigna dinámicamente un puerto, así que verifica tu puerto real usando `foundry service status`
- **model**: Nombra el modelo de IA que se utilizará para la generación de texto, incluyendo el número de versión (por ejemplo, `:1`). Usa `foundry model list` para ver los modelos disponibles con sus IDs exactos.

**Concepto clave:** Spring Boot carga automáticamente estas propiedades y las pone a disposición de tu aplicación usando la anotación `@Value`.

### 2. Clase principal de la aplicación (Application.java)

**Archivo:** `src/main/java/com/example/Application.java`

```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);  // No web server needed
        app.run(args);
    }
```

**Qué hace:**
- `@SpringBootApplication` habilita la configuración automática de Spring Boot
- `WebApplicationType.NONE` indica a Spring que esta es una aplicación de línea de comandos, no un servidor web
- El método principal inicia la aplicación Spring

**El ejecutor de demostración:**
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

**Qué hace:**
- `@Bean` crea un componente que Spring gestiona
- `CommandLineRunner` ejecuta código después de que Spring Boot se inicia
- `foundryLocalService` se inyecta automáticamente por Spring (inyección de dependencias)
- Envía un mensaje de prueba a la IA y muestra la respuesta

### 3. Capa de servicio de IA (FoundryLocalService.java)

**Archivo:** `src/main/java/com/example/FoundryLocalService.java`

#### Inyección de configuración:
```java
@Service
public class FoundryLocalService {
    
    @Value("${foundry.local.base-url:http://localhost:5273/v1}")
    private String baseUrl;
    
    @Value("${foundry.local.model:Phi-3.5-mini-instruct-cuda-gpu:1}")
    private String model;
```

**Qué hace:**
- `@Service` indica a Spring que esta clase proporciona lógica de negocio
- `@Value` inyecta valores de configuración desde application.properties
- La sintaxis `:default-value` proporciona valores predeterminados si las propiedades no están configuradas

#### Inicialización del cliente:
```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl)                // Base URL already includes /v1 from configuration
            .apiKey("not-needed")            // Local server doesn't need real API key
            .build();
}
```

**Qué hace:**
- `@PostConstruct` ejecuta este método después de que Spring crea el servicio
- Crea un cliente OpenAI que apunta a tu instancia local de Foundry Local
- La URL base de `application.properties` ya incluye `/v1` para compatibilidad con la API de OpenAI
- La clave API se establece en "not-needed" porque el desarrollo local no requiere autenticación

#### Método de chat:
```java
public String chat(String message) {
    try {
        ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
                .model(model)                    // Which AI model to use
                .addUserMessage(message)         // Your question/prompt
                .maxCompletionTokens(150)        // Limit response length
                .temperature(0.7)                // Control creativity (0.0-1.0)
                .build();
        
        ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
        
        // Extract the AI's response from the API result
        if (chatCompletion.choices() != null && !chatCompletion.choices().isEmpty()) {
            return chatCompletion.choices().get(0).message().content().orElse("No response found");
        }
        
        return "No response content found";
    } catch (Exception e) {
        throw new RuntimeException("Error calling chat completion: " + e.getMessage(), e);
    }
}
```

**Qué hace:**
- **ChatCompletionCreateParams**: Configura la solicitud de IA
  - `model`: Especifica qué modelo de IA usar (debe coincidir con el ID exacto de `foundry model list`)
  - `addUserMessage`: Agrega tu mensaje a la conversación
  - `maxCompletionTokens`: Limita la longitud de la respuesta (ahorra recursos)
  - `temperature`: Controla la aleatoriedad (0.0 = determinista, 1.0 = creativo)
- **Llamada a la API**: Envía la solicitud a Foundry Local
- **Manejo de respuesta**: Extrae de manera segura la respuesta de texto de la IA
- **Manejo de errores**: Envuelve excepciones con mensajes de error útiles

### 4. Dependencias del proyecto (pom.xml)

**Dependencias clave:**

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

**Qué hacen:**
- **spring-boot-starter**: Proporciona funcionalidad básica de Spring Boot
- **openai-java**: SDK oficial de OpenAI para comunicación con la API
- **jackson-databind**: Maneja la serialización/deserialización JSON para llamadas a la API

## Cómo funciona todo junto

Aquí está el flujo completo cuando ejecutas la aplicación:

1. **Inicio**: Spring Boot se inicia y lee `application.properties`
2. **Creación del servicio**: Spring crea `FoundryLocalService` e inyecta valores de configuración
3. **Configuración del cliente**: `@PostConstruct` inicializa el cliente OpenAI para conectarse a Foundry Local
4. **Ejecución de demostración**: `CommandLineRunner` se ejecuta después del inicio
5. **Llamada a la IA**: La demostración llama a `foundryLocalService.chat()` con un mensaje de prueba
6. **Solicitud a la API**: El servicio construye y envía una solicitud compatible con OpenAI a Foundry Local
7. **Procesamiento de respuesta**: El servicio extrae y devuelve la respuesta de la IA
8. **Visualización**: La aplicación imprime la respuesta y se cierra

## Configurando Foundry Local

Para configurar Foundry Local, sigue estos pasos:

1. **Instala Foundry Local** usando las instrucciones en la sección [Requisitos previos](../../../../04-PracticalSamples/foundrylocal).

2. **Verifica el puerto asignado dinámicamente**. Foundry Local asigna automáticamente un puerto al iniciarse. Encuentra tu puerto con:
   ```bash
   foundry service status
   ```
   
   **Opcional**: Si prefieres usar un puerto específico (por ejemplo, 5273), puedes configurarlo manualmente:
   ```bash
   foundry service set --port 5273
   ```

3. **Descarga el modelo de IA** que deseas usar, por ejemplo, `phi-3.5-mini`, con el siguiente comando:
   ```bash
   foundry model run phi-3.5-mini
   ```

4. **Configura el archivo application.properties** para que coincida con tu configuración de Foundry Local:
   - Actualiza el puerto en `base-url` (del paso 2), asegurándote de que incluya `/v1` al final
   - Actualiza el nombre del modelo para incluir el número de versión (verifica con `foundry model list`)
   
   Ejemplo:
   ```properties
   foundry.local.base-url=http://localhost:5273/v1
   foundry.local.model=Phi-3.5-mini-instruct-cuda-gpu:1
   ```

## Ejecutando la aplicación

### Paso 1: Inicia Foundry Local
```bash
foundry model run phi-3.5-mini
```

### Paso 2: Construye y ejecuta la aplicación
```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

## Salida esperada

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi-3.5, a small language model created by Microsoft. I'm currently running 
as the Phi-3.5-mini-instruct model, which is designed to be helpful, harmless, and honest 
in my interactions. I can assist with a wide variety of tasks including answering 
questions, helping with analysis, creative writing, coding, and general conversation. 
Is there something specific you'd like help with today?
=========================
```

## Próximos pasos

Para más ejemplos, consulta [Capítulo 04: Ejemplos prácticos](../README.md)

## Resolución de problemas

### Problemas comunes

**"Conexión rechazada" o "Servicio no disponible"**
- Asegúrate de que Foundry Local esté en ejecución: `foundry model list`
- Verifica el puerto real que está usando Foundry Local: `foundry service status`
- Actualiza tu `application.properties` con el puerto correcto, asegurándote de que la URL termine con `/v1`
- Alternativamente, configura un puerto específico si lo deseas: `foundry service set --port 5273`
- Intenta reiniciar Foundry Local: `foundry model run phi-3.5-mini`

**"Modelo no encontrado" o errores "404 Not Found"**
- Verifica los modelos disponibles con sus IDs exactos: `foundry model list`
- Actualiza el nombre del modelo en `application.properties` para que coincida exactamente, incluyendo el número de versión (por ejemplo, `Phi-3.5-mini-instruct-cuda-gpu:1`)
- Asegúrate de que el `base-url` incluya `/v1` al final: `http://localhost:5273/v1`
- Descarga el modelo si es necesario: `foundry model run phi-3.5-mini`

**Errores "400 Bad Request"**
- Verifica que la URL base incluya `/v1`: `http://localhost:5273/v1`
- Asegúrate de que el ID del modelo coincida exactamente con lo que se muestra en `foundry model list`
- Asegúrate de usar `maxCompletionTokens()` en tu código (no el obsoleto `maxTokens()`)

**Errores de compilación de Maven**
- Asegúrate de tener Java 21 o superior: `java -version`
- Limpia y reconstruye: `mvn clean compile`
- Verifica la conexión a internet para descargar dependencias

**La aplicación se inicia pero no hay salida**
- Verifica que Foundry Local esté respondiendo: Consulta `http://localhost:5273/v1/models` o ejecuta `foundry service status`
- Revisa los registros de la aplicación para mensajes de error específicos
- Asegúrate de que el modelo esté completamente cargado y listo

---

**Descargo de responsabilidad**:  
Este documento ha sido traducido utilizando el servicio de traducción automática [Co-op Translator](https://github.com/Azure/co-op-translator). Aunque nos esforzamos por garantizar la precisión, tenga en cuenta que las traducciones automáticas pueden contener errores o imprecisiones. El documento original en su idioma nativo debe considerarse la fuente autorizada. Para información crítica, se recomienda una traducción profesional realizada por humanos. No nos hacemos responsables de malentendidos o interpretaciones erróneas que puedan surgir del uso de esta traducción.