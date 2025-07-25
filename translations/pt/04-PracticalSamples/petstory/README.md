<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "c1ac1fbe111c9882e869f1453b915a17",
  "translation_date": "2025-07-25T09:21:37+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "pt"
}
-->
# Aplicação Pet Story

>**Nota**: Este capítulo inclui um [**Tutorial**](./TUTORIAL.md) que o orienta através dos exemplos.

Uma aplicação web Spring Boot que gera descrições e histórias baseadas em IA para imagens de animais de estimação carregadas, utilizando os GitHub Models.

## Índice

- [Tecnologias Utilizadas](../../../../04-PracticalSamples/petstory)
- [Pré-requisitos](../../../../04-PracticalSamples/petstory)
- [Configuração e Instalação](../../../../04-PracticalSamples/petstory)
- [Utilização](../../../../04-PracticalSamples/petstory)

## Tecnologias Utilizadas

- **Backend**: Spring Boot 3.5.3, Java 21
- **Integração com IA**: OpenAI Java SDK com GitHub Models
- **Segurança**: Spring Security
- **Frontend**: Templates Thymeleaf com estilo Bootstrap
- **Ferramenta de Build**: Maven
- **Modelos de IA**: GitHub Models

## Pré-requisitos

- Java 21 ou superior
- Maven 3.9+
- Token de Acesso Pessoal do GitHub com o âmbito `models:read`

## Configuração e Instalação

### 1. Navegue até ao diretório da aplicação petstory
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Defina a Variável de Ambiente
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Construa a Aplicação
```bash
mvn clean compile
```

### 4. Execute a Aplicação
```bash
mvn spring-boot:run
```

## Utilização

1. **Aceda à Aplicação**: Navegue para `http://localhost:8080`
2. **Carregue uma Imagem**: Clique em "Escolher Ficheiro" e selecione uma imagem de um animal de estimação
3. **Analise a Imagem**: Clique em "Analisar Imagem" para obter a descrição gerada pela IA
4. **Gere uma História**: Clique em "Gerar História" para criar a história

**Aviso Legal**:  
Este documento foi traduzido utilizando o serviço de tradução por IA [Co-op Translator](https://github.com/Azure/co-op-translator). Embora nos esforcemos para garantir a precisão, tenha em atenção que traduções automáticas podem conter erros ou imprecisões. O documento original na sua língua nativa deve ser considerado a fonte autoritária. Para informações críticas, recomenda-se a tradução profissional realizada por humanos. Não nos responsabilizamos por quaisquer mal-entendidos ou interpretações incorretas decorrentes da utilização desta tradução.