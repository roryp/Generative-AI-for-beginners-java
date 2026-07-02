// -----------------------------------------------------------------------------
// main.bicep  (deployment scope: subscription)
//
// Provisions the Azure AI Foundry resources used by the "Generative AI for
// Beginners - Java" course:
//   * An Azure AI Foundry (AI Services) account + project
//   * A chat model deployment        (gpt-4o-mini)
//   * An embedding model deployment  (text-embedding-3-small)
//   * A keyless (Microsoft Entra ID) data-plane role assignment
//
// Deploy with the Azure Developer CLI:
//   azd up
// -----------------------------------------------------------------------------
targetScope = 'subscription'

@minLength(1)
@maxLength(64)
@description('Name of the environment. azd uses this to name the resource group (rg-<name>) and tag resources.')
param environmentName string

@minLength(1)
@description('Primary Azure region for all resources. Pick a region where gpt-4o-mini and text-embedding-3-small are available (for example: eastus2 or swedencentral).')
param location string

@description('Object (principal) ID granted keyless data-plane access to the models. azd sets this to the signed-in user automatically.')
param principalId string = ''

@allowed([
  'User'
  'ServicePrincipal'
])
@description('Type of the principal referenced by principalId. Use "User" for a developer running azd, "ServicePrincipal" for CI.')
param principalType string = 'User'

// --- Model deployment configuration (override via azd env set if needed) ------
@description('Chat model to deploy.')
param chatModelName string = 'gpt-4o-mini'

@description('Chat model version.')
param chatModelVersion string = '2024-07-18'

@description('Chat deployment capacity, in thousands of tokens per minute (TPM).')
param chatDeploymentCapacity int = 10

@description('Embedding model to deploy.')
param embeddingModelName string = 'text-embedding-3-small'

@description('Embedding model version.')
param embeddingModelVersion string = '1'

@description('Embedding deployment capacity, in thousands of tokens per minute (TPM).')
param embeddingDeploymentCapacity int = 10

// Short, deterministic suffix so resource names are globally unique per environment.
var resourceToken = toLower(uniqueString(subscription().id, environmentName, location))
var tags = {
  'azd-env-name': environmentName
}

resource rg 'Microsoft.Resources/resourceGroups@2024-03-01' = {
  name: 'rg-${environmentName}'
  location: location
  tags: tags
}

module resources 'resources.bicep' = {
  name: 'foundry-resources'
  scope: rg
  params: {
    location: location
    tags: tags
    resourceToken: resourceToken
    principalId: principalId
    principalType: principalType
    chatModelName: chatModelName
    chatModelVersion: chatModelVersion
    chatDeploymentCapacity: chatDeploymentCapacity
    embeddingModelName: embeddingModelName
    embeddingModelVersion: embeddingModelVersion
    embeddingDeploymentCapacity: embeddingDeploymentCapacity
  }
}

// Outputs are captured by azd into the environment and consumed by the
// postprovision hook to write examples/basic-chat-azure/.env.
output AZURE_LOCATION string = location
output AZURE_RESOURCE_GROUP string = rg.name
output AZURE_AI_SERVICES_NAME string = resources.outputs.aiServicesName
output AZURE_OPENAI_ENDPOINT string = resources.outputs.endpoint
output AZURE_OPENAI_DEPLOYMENT string = resources.outputs.chatDeploymentName
output AZURE_OPENAI_EMBEDDING_DEPLOYMENT string = resources.outputs.embeddingDeploymentName
