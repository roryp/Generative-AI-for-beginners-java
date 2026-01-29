# AGENTS.md

## Project Overview

Dis na one repo wey dem design make people learn how to develop Generative AI wit Java. E dey give full hands-on course wey cover Large Language Models (LLMs), prompt engineering, embeddings, RAG (Retrieval-Augmented Generation), and Model Context Protocol (MCP).

**Key Technologies:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI, and OpenAI SDKs

**Architecture:**
- Plenty standalone Spring Boot apps wey dem arrange by chapters
- Sample projects wey dey show different AI patterns
- GitHub Codespaces-ready wit dev containers wey dem don pre-configure

## Setup Commands

### Prerequisites
- Java 21 or higher
- Maven 3.x
- GitHub personal access token (for GitHub Models)
- Optional: Azure OpenAI credentials

### Environment Setup

**Option 1: GitHub Codespaces (Recommended)**
```bash
# Fork the repository and create a codespace from GitHub UI
# The dev container will automatically install all dependencies
# Wait ~2 minutes for environment setup
```

**Option 2: Local Dev Container**
```bash
# Clone repository
git clone https://github.com/microsoft/Generative-AI-for-beginners-java.git
cd Generative-AI-for-beginners-java

# Open in VS Code with Dev Containers extension
# Reopen in Container when prompted
```

**Option 3: Local Setup**
```bash
# Install dependencies
sudo apt-get update
sudo apt-get install -y maven openjdk-21-jdk

# Verify installation
java -version
mvn -version
```

### Configuration

**GitHub Token Setup:**
```bash
# Create a GitHub Personal Access Token
# Set environment variable
export GITHUB_TOKEN="your-token-here"
```

**Azure OpenAI Setup (Optional):**
```bash
# For examples using Azure OpenAI
cd 02-SetupDevEnvironment/examples/basic-chat-azure
cp .env.example .env
# Edit .env with your Azure OpenAI credentials
```

## Development Workflow

### Project Structure
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

### Running Applications

**How to run Spring Boot application:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**How to build project:**
```bash
cd [project-directory]
mvn clean install
```

**How to start MCP Calculator Server:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**How to run Client Examples:**
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

### Hot Reload
Spring Boot DevTools dey inside projects wey support hot reload:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Testing Instructions

### Running Tests

**How to run all tests for project:**
```bash
cd [project-directory]
mvn test
```

**How to run tests wit verbose output:**
```bash
mvn test -X
```

**How to run specific test class:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Test Structure
- Test files dey use JUnit 5 (Jupiter)
- Test classes dey inside `src/test/java/`
- Client examples for calculator project dey inside `src/test/java/com/microsoft/mcp/sample/client/`

### Manual Testing
Plenty examples na interactive apps wey need manual testing:

1. Start the app wit `mvn spring-boot:run`
2. Test endpoints or use the CLI
3. Check say the behavior wey you see match wetin dey for documentation inside each project README.md

### Testing wit GitHub Models
- Free tier limits: 15 requests/minute, 150/day
- Max 5 concurrent requests
- Test content filtering wit responsible AI examples

## Code Style Guidelines

### Java Conventions
- **Java Version:** Java 21 wit modern features
- **Style:** Follow standard Java conventions
- **Naming:** 
  - Classes: PascalCase
  - Methods/variables: camelCase
  - Constants: UPPER_SNAKE_CASE
  - Package names: lowercase

### Spring Boot Patterns
- Use `@Service` for business logic
- Use `@RestController` for REST endpoints
- Configure wit `application.yml` or `application.properties`
- Prefer environment variables over hard-coded values
- Use `@Tool` annotation for MCP-exposed methods

### File Organization
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

### Dependencies
- Manage am wit Maven `pom.xml`
- Spring AI BOM for version management
- LangChain4j for AI integrations
- Spring Boot starter parent for Spring dependencies

### Code Comments
- Add JavaDoc for public APIs
- Put explanatory comments for complex AI interactions
- Document MCP tool descriptions well

## Build and Deployment

### Building Projects

**Build without tests:**
```bash
mvn clean install -DskipTests
```

**Build wit all checks:**
```bash
mvn clean install
```

**Package application:**
```bash
mvn package
# Creates JAR in target/ directory
```

### Output Directories
- Compiled classes: `target/classes/`
- Test classes: `target/test-classes/`
- JAR files: `target/*.jar`
- Maven artifacts: `target/`

### Environment-Specific Configuration

**Development:**
```yaml
# application.yml
spring:
  ai:
    openai:
      api-key: ${GITHUB_TOKEN}
      base-url: https://models.inference.ai.azure.com
```

**Production:**
- Use Azure AI Foundry Models instead of GitHub Models
- Change base-url to Azure OpenAI endpoint
- Manage secrets wit Azure Key Vault or environment variables

### Deployment Considerations
- Dis na educational repo wit sample apps
- E no dey ready for production deployment as e dey
- Samples dey show patterns wey you fit adapt for production use
- Check individual project READMEs for deployment notes

## Additional Notes

### GitHub Models vs Azure OpenAI
- **GitHub Models:** Free tier for learning, no need credit card
- **Azure OpenAI:** Production-ready, e need Azure subscription
- Code dey compatible between both - just change endpoint and API key

### Working wit Multiple Projects
Each sample project dey standalone:
```bash
# Navigate to specific project
cd 04-PracticalSamples/[project-name]

# Each has its own pom.xml and can be built independently
mvn clean install
```

### Common Issues

**Java Version Mismatch:**
```bash
# Verify Java 21
java -version
# Update JAVA_HOME if needed
export JAVA_HOME=/usr/lib/jvm/msopenjdk-current
```

**Dependency Download Wahala:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub Token No Dey:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Port Don Already Dey Use:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Multi-Language Support
- Documentation dey available for 45+ languages wit automated translation
- Translations dey inside `translations/` directory
- Translation dey managed by GitHub Actions workflow

### Learning Path
1. Start wit [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Follow chapters one by one (01 → 05)
3. Do hands-on examples for each chapter
4. Check sample projects for Chapter 4
5. Learn responsible AI practices for Chapter 5

### Development Container
The `.devcontainer/devcontainer.json` dey configure:
- Java 21 development environment
- Maven don already dey
- VS Code Java extensions
- Spring Boot tools
- GitHub Copilot integration
- Docker-in-Docker support
- Azure CLI

### Performance Considerations
- GitHub Models free tier get rate limits
- Use correct batch sizes for embeddings
- Think about caching for repeated API calls
- Monitor token usage to save cost

### Security Notes
- No ever commit `.env` files (e dey already inside `.gitignore`)
- Use environment variables for API keys
- GitHub tokens suppose get only the scopes wey you need
- Follow responsible AI guidelines for Chapter 5

---

<!-- CO-OP TRANSLATOR DISCLAIMER START -->
**Disclaimer**:  
Dis docu don use AI translation service [Co-op Translator](https://github.com/Azure/co-op-translator) take translate am. Even though we dey try make sure say e correct, abeg no forget say automatic translation fit get mistake or no dey accurate well. Di original docu for di language wey dem first write am na di main correct one. For important information, e good make una use professional human translation. We no go fit take blame for any misunderstanding or wrong interpretation wey fit happen because of dis translation.
<!-- CO-OP TRANSLATOR DISCLAIMER END -->