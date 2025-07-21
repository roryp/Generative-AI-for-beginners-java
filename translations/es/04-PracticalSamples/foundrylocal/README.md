<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "a66dad62cdb2e141f05086feaf1a4a39",
  "translation_date": "2025-07-21T16:35:43+00:00",
  "source_file": "04-PracticalSamples/foundrylocal/README.md",
  "language_code": "es"
}
-->
# Aplicación de Línea de Comando Local de Foundry

>**Nota**: Este capítulo incluye un [**Tutorial**](./TUTORIAL.md) que te guía a través de la ejecución de los ejemplos terminados.

Una aplicación simple de línea de comando con Spring Boot que demuestra cómo conectarse a Foundry Local utilizando el OpenAI Java SDK.

## Lo Que Aprenderás

- Cómo integrar Foundry Local con aplicaciones Spring Boot utilizando el OpenAI Java SDK
- Mejores prácticas para el desarrollo y pruebas de IA locales

## Tabla de Contenidos

- [Lo Que Aprenderás](../../../../04-PracticalSamples/foundrylocal)
- [Requisitos Previos](../../../../04-PracticalSamples/foundrylocal)
  - [Instalación de Foundry Local](../../../../04-PracticalSamples/foundrylocal)
  - [Verificación](../../../../04-PracticalSamples/foundrylocal)
- [Configuración](../../../../04-PracticalSamples/foundrylocal)
- [Inicio Rápido](../../../../04-PracticalSamples/foundrylocal)
- [Qué Hace la Aplicación](../../../../04-PracticalSamples/foundrylocal)
- [Salida de Ejemplo](../../../../04-PracticalSamples/foundrylocal)
- [Arquitectura](../../../../04-PracticalSamples/foundrylocal)
- [Aspectos Destacados del Código](../../../../04-PracticalSamples/foundrylocal)
  - [Integración con OpenAI Java SDK](../../../../04-PracticalSamples/foundrylocal)
  - [API de Finalización de Chat](../../../../04-PracticalSamples/foundrylocal)
- [Solución de Problemas](../../../../04-PracticalSamples/foundrylocal)

## Requisitos Previos

> **⚠️ Nota**: Esta aplicación **no se ejecuta en el devcontainer proporcionado** ya que requiere que Foundry Local esté instalado y funcionando en el sistema anfitrión.

### Instalación de Foundry Local

Antes de ejecutar esta aplicación, necesitas instalar y arrancar Foundry Local. Sigue estos pasos:

1. **Asegúrate de que tu sistema cumpla con los requisitos**:
   - **Sistema Operativo**: Windows 10 (x64), Windows 11 (x64/ARM), Windows Server 2025 o macOS
   - **Hardware**: 
     - Mínimo: 8GB de RAM, 3GB de espacio libre en disco
     - Recomendado: 16GB de RAM, 15GB de espacio libre en disco
   - **Red**: Conexión a internet para la descarga inicial del modelo (opcional para uso sin conexión)
   - **Aceleración (opcional)**: GPU NVIDIA (serie 2000 o más reciente), GPU AMD (serie 6000 o más reciente), Qualcomm Snapdragon X Elite (8GB o más de memoria) o Apple silicon
   - **Permisos**: Privilegios administrativos para instalar software en tu dispositivo

2. **Instala Foundry Local**:
   
   **Para Windows:**
   ```bash
   winget install Microsoft.FoundryLocal
   ```
   
   **Para macOS:**
   ```bash
   brew tap microsoft/foundrylocal
   brew install foundrylocal
   ```
   
   Alternativamente, puedes descargar el instalador desde el [repositorio de GitHub de Foundry Local](https://github.com/microsoft/Foundry-Local).

3. **Inicia tu primer modelo**:

   ```bash
   foundry model run phi-3.5-mini
   ```

   El modelo se descargará (esto puede tardar unos minutos, dependiendo de la velocidad de tu internet) y luego se ejecutará. Foundry Local selecciona automáticamente la mejor variante del modelo para tu sistema (CUDA para GPUs NVIDIA, versión CPU en caso contrario).

4. **Prueba el modelo** haciendo una pregunta en el mismo terminal:

   ```bash
   Why is the sky blue?
   ```

   Deberías ver una respuesta del modelo Phi explicando por qué el cielo parece azul.

### Verificación

Puedes verificar que todo funciona correctamente con estos comandos:

```bash
# List all available models
foundry model list

# Check the service status via REST API
curl http://localhost:5273/v1/models
```

También puedes visitar `http://localhost:5273` en tu navegador para ver la interfaz web de Foundry Local.

## Configuración

La aplicación puede configurarse a través de `application.properties`:

- `foundry.local.base-url` - URL base para Foundry Local (por defecto: http://localhost:5273)
- `foundry.local.model` - Modelo de IA a utilizar (por defecto: Phi-3.5-mini-instruct-cuda-gpu)

> **Nota**: El nombre del modelo en la configuración debe coincidir con la variante específica que Foundry Local descargó para tu sistema. Cuando ejecutas `foundry model run phi-3.5-mini`, Foundry Local selecciona y descarga automáticamente la mejor variante (CUDA para GPUs NVIDIA, versión CPU en caso contrario). Usa `foundry model list` para ver el nombre exacto del modelo disponible en tu instancia local.

## Inicio Rápido

### 1. Navega al directorio de la aplicación local de Foundry
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/foundrylocal
```

### 2. Ejecuta la Aplicación

```bash
mvn spring-boot:run
```

O construye y ejecuta el JAR:

```bash
mvn clean package
java -jar target/foundry-local-spring-boot-0.0.1-SNAPSHOT.jar
```

### Dependencias

Esta aplicación utiliza el OpenAI Java SDK para comunicarse con Foundry Local. La dependencia clave es:

```xml
<dependency>
    <groupId>com.openai</groupId>
    <artifactId>openai-java</artifactId>
    <version>2.12.0</version>
</dependency>
```

La aplicación está preconfigurada para conectarse a Foundry Local ejecutándose en el puerto predeterminado.

## Qué Hace la Aplicación

Cuando ejecutas la aplicación:

1. **Se inicia** como una aplicación de línea de comando (sin servidor web)
2. **Envía automáticamente** un mensaje de prueba: "¡Hola! ¿Puedes decirme qué eres y qué modelo estás ejecutando?"
3. **Muestra la respuesta** de Foundry Local en la consola
4. **Finaliza limpiamente** después de la demostración

## Salida de Ejemplo

```
=== Foundry Local Demo ===
Calling Foundry Local service...
Sending message: Hello! Can you tell me what you are and what model you're running?
Response from Foundry Local:
Hello! I'm Phi, an AI language model created by Microsoft. I don't have a physical form or a specific hardware model like a smartphone or a computer. I exist purely in software, and I operate on Microsoft's infrastructure...
=========================
```

## Arquitectura

- **Application.java** - Aplicación principal de Spring Boot con CommandLineRunner
- **FoundryLocalService.java** - Servicio que utiliza el OpenAI Java SDK para comunicarse con Foundry Local
- Utiliza **OpenAI Java SDK** para llamadas API con tipado seguro
- Serialización/deserialización automática de JSON manejada por el SDK
- Configuración limpia utilizando las anotaciones `@Value` y `@PostConstruct` de Spring

## Aspectos Destacados del Código

### Integración con OpenAI Java SDK

La aplicación utiliza el OpenAI Java SDK para crear un cliente configurado para Foundry Local:

```java
@PostConstruct
public void init() {
    this.openAIClient = OpenAIOkHttpClient.builder()
            .baseUrl(baseUrl + "/v1")
            .apiKey("unused") // Local server doesn't require real API key
            .build();
}
```

### API de Finalización de Chat

Hacer solicitudes de finalización de chat es simple y con tipado seguro:

```java
ChatCompletionCreateParams params = ChatCompletionCreateParams.builder()
        .model(model)
        .addUserMessage(message)
        .maxCompletionTokens(150)
        .temperature(0.7)
        .build();

ChatCompletion chatCompletion = openAIClient.chat().completions().create(params);
```

## Solución de Problemas

Si ves errores de conexión:
1. Verifica que Foundry Local esté ejecutándose en `http://localhost:5273`
2. Comprueba que una variante del modelo Phi-3.5-mini esté disponible con `foundry model list`
3. Asegúrate de que el nombre del modelo en `application.properties` coincida con el nombre exacto del modelo mostrado en la lista
4. Asegúrate de que ningún firewall esté bloqueando la conexión

Problemas comunes:
- **Modelo no encontrado**: Ejecuta `foundry model run phi-3.5-mini` para descargar e iniciar el modelo
- **Servicio no ejecutándose**: El servicio Foundry Local puede haberse detenido; reinícialo con el comando de ejecución del modelo
- **Nombre de modelo incorrecto**: Usa `foundry model list` para ver los modelos disponibles y actualiza tu configuración en consecuencia

**Descargo de responsabilidad**:  
Este documento ha sido traducido utilizando el servicio de traducción automática [Co-op Translator](https://github.com/Azure/co-op-translator). Si bien nos esforzamos por garantizar la precisión, tenga en cuenta que las traducciones automáticas pueden contener errores o imprecisiones. El documento original en su idioma nativo debe considerarse como la fuente autorizada. Para información crítica, se recomienda una traducción profesional realizada por humanos. No nos hacemos responsables de malentendidos o interpretaciones erróneas que puedan surgir del uso de esta traducción.