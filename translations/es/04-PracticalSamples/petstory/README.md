<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T08:43:36+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "es"
}
-->
# Aplicación Pet Story

>**Nota**: Este capítulo incluye un [**Tutorial**](./TUTORIAL.md) que te guía a través de los ejemplos.

Una aplicación web de Spring Boot que genera descripciones y historias impulsadas por IA para imágenes de mascotas cargadas utilizando GitHub Models.

## Tabla de Contenidos

- [Tecnologías Utilizadas](../../../../04-PracticalSamples/petstory)
- [Requisitos Previos](../../../../04-PracticalSamples/petstory)
- [Configuración e Instalación](../../../../04-PracticalSamples/petstory)
- [Uso](../../../../04-PracticalSamples/petstory)

## Tecnologías Utilizadas

- **Backend**: Spring Boot 3.5.3, Java 21
- **Integración con IA**: OpenAI Java SDK con GitHub Models
- **Seguridad**: Spring Security
- **Frontend**: Plantillas Thymeleaf con estilos de Bootstrap
- **Herramienta de Construcción**: Maven
- **Modelos de IA**: GitHub Models

## Requisitos Previos

- Java 21 o superior
- Maven 3.9+
- Token de Acceso Personal de GitHub con el alcance `models:read`

## Configuración e Instalación

### 1. Navega al directorio de la aplicación petstory
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Configura la Variable de Entorno
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Construye la Aplicación
```bash
mvn clean compile
```

### 4. Ejecuta la Aplicación
```bash
mvn spring-boot:run
```

## Uso

1. **Accede a la Aplicación**: Navega a `http://localhost:8080`
2. **Sube una Imagen**: Haz clic en "Choose File" y selecciona una imagen de mascota
3. **Analiza la Imagen**: Haz clic en "Analyze Image" para obtener una descripción generada por IA
4. **Genera una Historia**: Haz clic en "Generate Story" para crear la historia

**Descargo de responsabilidad**:  
Este documento ha sido traducido utilizando el servicio de traducción automática [Co-op Translator](https://github.com/Azure/co-op-translator). Aunque nos esforzamos por garantizar la precisión, tenga en cuenta que las traducciones automatizadas pueden contener errores o imprecisiones. El documento original en su idioma nativo debe considerarse como la fuente autorizada. Para información crítica, se recomienda una traducción profesional realizada por humanos. No nos hacemos responsables de malentendidos o interpretaciones erróneas que puedan surgir del uso de esta traducción.