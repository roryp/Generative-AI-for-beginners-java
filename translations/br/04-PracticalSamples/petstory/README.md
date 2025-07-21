<!--
CO_OP_TRANSLATOR_METADATA:
{
  "original_hash": "69dffd84127360d3f9446b89de471abe",
  "translation_date": "2025-07-21T18:31:50+00:00",
  "source_file": "04-PracticalSamples/petstory/README.md",
  "language_code": "br"
}
-->
# Aplicativo Pet Story

>**Nota**: Este capítulo inclui um [**Tutorial**](./TUTORIAL.md) que orienta você a executar os exemplos finalizados.

Um aplicativo web Spring Boot que gera descrições e histórias impulsionadas por IA para imagens de pets enviadas, utilizando os Modelos do GitHub.

## Índice

- [Tecnologias Utilizadas](../../../../04-PracticalSamples/petstory)
- [Pré-requisitos](../../../../04-PracticalSamples/petstory)
- [Configuração e Instalação](../../../../04-PracticalSamples/petstory)
- [Uso](../../../../04-PracticalSamples/petstory)

## Tecnologias Utilizadas

- **Backend**: Spring Boot 3.5.3, Java 21
- **Integração com IA**: OpenAI Java SDK com Modelos do GitHub
- **Segurança**: Spring Security
- **Frontend**: Templates Thymeleaf com estilização Bootstrap
- **Ferramenta de Build**: Maven
- **Modelos de IA**: Modelos do GitHub

## Pré-requisitos

- Java 21 ou superior
- Maven 3.9+
- Token de Acesso Pessoal do GitHub com escopo `models:read`

## Configuração e Instalação

### 1. Navegue até o diretório do aplicativo petstory
```bash
cd Generative-AI-for-beginners-java/04-PracticalSamples/petstory
```

### 2. Configure a Variável de Ambiente
   ```bash
   # Windows (Command Prompt)
   set GITHUB_TOKEN=your_github_token_here
   
   # Windows (PowerShell)
   $env:GITHUB_TOKEN="your_github_token_here"
   
   # Linux/macOS
   export GITHUB_TOKEN=your_github_token_here
   ```

### 3. Compile o Aplicativo
```bash
mvn clean compile
```

### 4. Execute o Aplicativo
```bash
mvn spring-boot:run
```

## Uso

1. **Acesse o Aplicativo**: Navegue até `http://localhost:8080`
2. **Envie uma Imagem**: Clique em "Escolher Arquivo" e selecione uma imagem de pet
3. **Analise a Imagem**: Clique em "Analisar Imagem" para obter a descrição gerada pela IA
4. **Gere uma História**: Clique em "Gerar História" para criar a história

**Aviso Legal**:  
Este documento foi traduzido utilizando o serviço de tradução por IA [Co-op Translator](https://github.com/Azure/co-op-translator). Embora nos esforcemos para garantir a precisão, esteja ciente de que traduções automatizadas podem conter erros ou imprecisões. O documento original em seu idioma nativo deve ser considerado a fonte autoritativa. Para informações críticas, recomenda-se a tradução profissional realizada por humanos. Não nos responsabilizamos por quaisquer mal-entendidos ou interpretações equivocadas decorrentes do uso desta tradução.