<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T10:06:43+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "ro"
}
-->
# Aplicația Pet Story

>**Notă**: Acest capitol include un [**Tutorial**](./TUTORIAL.md) care te ghidează prin exemple.

O aplicație web Spring Boot care generează descrieri și povești bazate pe AI pentru imaginile încărcate cu animale de companie, utilizând GitHub Models.

## Cuprins

- [Tehnologii Utilizate](../../../../04-PracticalSamples/petstory)
- [Cerințe Prealabile](../../../../04-PracticalSamples/petstory)
- [Configurare și Instalare](../../../../04-PracticalSamples/petstory)
- [Utilizare](../../../../04-PracticalSamples/petstory)

## Tehnologii Utilizate

- **Backend**: Spring Boot 3.5.3, Java 21
- **Integrare AI**: OpenAI Java SDK cu GitHub Models
- **Securitate**: Spring Security
- **Frontend**: Șabloane Thymeleaf cu stilizare Bootstrap
- **Instrument de Build**: Maven
- **Modele AI**: GitHub Models

## Cerințe Prealabile

- Java 21 sau o versiune mai nouă
- Maven 3.9+
- Token Personal de Acces GitHub cu permisiunea `models:read`

## Configurare și Instalare

### 1. Navighează la directorul aplicației petstory
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Setează Variabila de Mediu
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Construiește Aplicația
```bash
mvn clean compile
```

### 4. Rulează Aplicația
```bash
mvn spring-boot:run
```

## Utilizare

1. **Accesează Aplicația**: Navighează la `http://localhost:8080`
2. **Încarcă Imagine**: Apasă pe "Choose File" și selectează o imagine cu un animal de companie
3. **Analizează Imaginea**: Apasă pe "Analyze Image" pentru a obține descrierea generată de AI
4. **Generează Poveste**: Apasă pe "Generate Story" pentru a crea povestea

**Declinarea responsabilității**:  
Acest document a fost tradus folosind serviciul de traducere AI [Co-op Translator](https://github.com/Azure/co-op-translator). Deși ne străduim să asigurăm acuratețea, vă rugăm să rețineți că traducerile automate pot conține erori sau inexactități. Documentul original în limba sa natală ar trebui considerat sursa autoritară. Pentru informații critice, se recomandă traducerea profesională realizată de un specialist uman. Nu ne asumăm răspunderea pentru eventualele neînțelegeri sau interpretări greșite care pot apărea din utilizarea acestei traduceri.