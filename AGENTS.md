# AGENTS.md

## Project Overview

This is an educational repository for learning Generative AI development with Java. It provides a comprehensive hands-on course covering Large Language Models (LLMs), prompt engineering, embeddings, RAG (Retrieval-Augmented Generation), and the Model Context Protocol (MCP).

**Key Technologies:**
- Java 21
- Spring Boot 3.5.x
- Spring AI 1.1.x
- Maven
- LangChain4j
- GitHub Models, Azure OpenAI, and OpenAI SDKs

**Architecture:**
- Multiple standalone Spring Boot applications organized by chapters
- Sample projects demonstrating different AI patterns
- GitHub Codespaces-ready with pre-configured dev containers

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

**Running a Spring Boot application:**
```bash
cd [project-directory]
mvn spring-boot:run
```

**Building a project:**
```bash
cd [project-directory]
mvn clean install
```

**Starting the MCP Calculator Server:**
```bash
cd 04-PracticalSamples/calculator
mvn spring-boot:run
# Server runs on http://localhost:8080
```

**Running Client Examples:**
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
Spring Boot DevTools is included in projects that support hot reload:
```bash
# Changes to Java files will automatically reload when saved
mvn spring-boot:run
```

## Testing Instructions

### Running Tests

**Run all tests in a project:**
```bash
cd [project-directory]
mvn test
```

**Run tests with verbose output:**
```bash
mvn test -X
```

**Run specific test class:**
```bash
mvn test -Dtest=CalculatorServiceTest
```

### Test Structure
- Test files use JUnit 5 (Jupiter)
- Test classes are located in `src/test/java/`
- Client examples in the calculator project are in `src/test/java/com/microsoft/mcp/sample/client/`

### Manual Testing
Many examples are interactive applications that require manual testing:

1. Start the application with `mvn spring-boot:run`
2. Test endpoints or interact with the CLI
3. Verify expected behavior matches documentation in each project's README.md

### Testing with GitHub Models
- Free tier limits: 15 requests/minute, 150/day
- 5 concurrent requests maximum
- Test content filtering with responsible AI examples

## Code Style Guidelines

### Java Conventions
- **Java Version:** Java 21 with modern features
- **Style:** Follow standard Java conventions
- **Naming:** 
  - Classes: PascalCase
  - Methods/variables: camelCase
  - Constants: UPPER_SNAKE_CASE
  - Package names: lowercase

### Spring Boot Patterns
- Use `@Service` for business logic
- Use `@RestController` for REST endpoints
- Configuration via `application.yml` or `application.properties`
- Environment variables preferred over hard-coded values
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
- Managed via Maven `pom.xml`
- Spring AI BOM for version management
- LangChain4j for AI integrations
- Spring Boot starter parent for Spring dependencies

### Code Comments
- Add JavaDoc for public APIs
- Include explanatory comments for complex AI interactions
- Document MCP tool descriptions clearly

## Build and Deployment

### Building Projects

**Build without tests:**
```bash
mvn clean install -DskipTests
```

**Build with all checks:**
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
- Update base-url to Azure OpenAI endpoint
- Manage secrets via Azure Key Vault or environment variables

### Deployment Considerations
- This is an educational repository with sample applications
- Not designed for production deployment as-is
- Samples demonstrate patterns to adapt for production use
- See individual project READMEs for specific deployment notes

## Additional Notes

### GitHub Models vs Azure OpenAI
- **GitHub Models:** Free tier for learning, no credit card required
- **Azure OpenAI:** Production-ready, requires Azure subscription
- Code is compatible between both - just change endpoint and API key

### Working with Multiple Projects
Each sample project is standalone:
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

**Dependency Download Issues:**
```bash
# Clear Maven cache and retry
rm -rf ~/.m2/repository
mvn clean install
```

**GitHub Token Not Found:**
```bash
# Set in current session
export GITHUB_TOKEN="your-token-here"

# Or use .env file in project directory
echo "GITHUB_TOKEN=your-token-here" > .env
```

**Port Already in Use:**
```bash
# Spring Boot uses port 8080 by default
# Change in application.properties:
server.port=8081
```

### Multi-Language Support
- Documentation available in 45+ languages via automated translation
- Translations in `translations/` directory
- Translation managed by GitHub Actions workflow

### Learning Path
1. Start with [02-SetupDevEnvironment](02-SetupDevEnvironment/README.md)
2. Follow chapters in order (01 → 05)
3. Complete hands-on examples in each chapter
4. Explore sample projects in Chapter 4
5. Learn responsible AI practices in Chapter 5

### Development Container
The `.devcontainer/devcontainer.json` configures:
- Java 21 development environment
- Maven pre-installed
- VS Code Java extensions
- Spring Boot tools
- GitHub Copilot integration
- Docker-in-Docker support
- Azure CLI

### Performance Considerations
- GitHub Models free tier has rate limits
- Use appropriate batch sizes for embeddings
- Consider caching for repeated API calls
- Monitor token usage for cost optimization

### Security Notes
- Never commit `.env` files (already in `.gitignore`)
- Use environment variables for API keys
- GitHub tokens should have minimal required scopes
- Follow responsible AI guidelines in Chapter 5
