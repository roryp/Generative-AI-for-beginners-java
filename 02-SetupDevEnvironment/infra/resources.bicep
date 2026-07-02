// -----------------------------------------------------------------------------
// resources.bicep  (deployment scope: resource group)
//
// Creates the Azure AI Foundry account, a project, two model deployments, and a
// keyless (Microsoft Entra ID) role assignment for data-plane access.
// -----------------------------------------------------------------------------

@description('Azure region for all resources.')
param location string

@description('Tags applied to every resource.')
param tags object = {}

@description('Deterministic suffix used to build globally unique resource names.')
param resourceToken string

@description('Principal granted keyless data-plane access. Empty skips the role assignment.')
param principalId string = ''

@allowed([
  'User'
  'ServicePrincipal'
])
@description('Type of the principal referenced by principalId.')
param principalType string = 'User'

param chatModelName string
param chatModelVersion string
param chatDeploymentCapacity int
param embeddingModelName string
param embeddingModelVersion string
param embeddingDeploymentCapacity int

var aiServicesName = 'aoai-${resourceToken}'

// Built-in role: "Cognitive Services OpenAI User" - grants data-plane access to
// call OpenAI model deployments via the Azure OpenAI endpoint. Required because
// local (key) auth is disabled below.
var cognitiveServicesOpenAiUserRoleId = '5e0bd9bd-7b93-4f28-af87-19fc36ad61bd'

// Built-in role: "Cognitive Services User" - grants data-plane access to the
// Foundry Models inference endpoint (/openai/v1 and /models). Used by the OpenAI
// SDK examples in chapter 04 that request tokens for the https://ai.azure.com scope.
var cognitiveServicesUserRoleId = 'a97b65f3-24c7-4388-baec-2e87135dc908'

// Azure AI Foundry account. kind=AIServices exposes the Azure OpenAI data plane
// at https://<customSubDomainName>.openai.azure.com/.
resource account 'Microsoft.CognitiveServices/accounts@2025-06-01' = {
  name: aiServicesName
  location: location
  tags: tags
  kind: 'AIServices'
  sku: {
    name: 'S0'
  }
  identity: {
    type: 'SystemAssigned'
  }
  properties: {
    // Required for token-based (Entra ID) auth and for the OpenAI endpoint host name.
    customSubDomainName: aiServicesName
    // Allow Foundry projects as child resources of this account.
    allowProjectManagement: true
    // Keyless only: turn off API keys so credentials can't leak into code or .env files.
    disableLocalAuth: true
    publicNetworkAccess: 'Enabled'
  }
}

// Foundry project - a logical container for assets under the account.
resource project 'Microsoft.CognitiveServices/accounts/projects@2025-06-01' = {
  parent: account
  name: 'genai-java'
  location: location
  tags: tags
  identity: {
    type: 'SystemAssigned'
  }
  properties: {
    displayName: 'GenAI for Beginners Java'
    description: 'Models for the Generative AI for Beginners - Java course.'
  }
}

// Chat model deployment (gpt-4o-mini).
resource chatDeployment 'Microsoft.CognitiveServices/accounts/deployments@2025-06-01' = {
  parent: account
  name: chatModelName
  sku: {
    name: 'GlobalStandard'
    capacity: chatDeploymentCapacity
  }
  properties: {
    model: {
      format: 'OpenAI'
      name: chatModelName
      version: chatModelVersion
    }
  }
}

// Embedding model deployment (text-embedding-3-small).
// Serialized after the chat deployment: an account processes one deployment
// operation at a time, so a parallel create would fail.
resource embeddingDeployment 'Microsoft.CognitiveServices/accounts/deployments@2025-06-01' = {
  parent: account
  name: embeddingModelName
  sku: {
    name: 'GlobalStandard'
    capacity: embeddingDeploymentCapacity
  }
  properties: {
    model: {
      format: 'OpenAI'
      name: embeddingModelName
      version: embeddingModelVersion
    }
  }
  dependsOn: [
    chatDeployment
  ]
}

// Keyless data-plane access for the signed-in developer (or CI principal).
resource openAiUserRoleAssignment 'Microsoft.Authorization/roleAssignments@2022-04-01' = if (!empty(principalId)) {
  name: guid(account.id, principalId, cognitiveServicesOpenAiUserRoleId)
  scope: account
  properties: {
    roleDefinitionId: subscriptionResourceId('Microsoft.Authorization/roleDefinitions', cognitiveServicesOpenAiUserRoleId)
    principalId: principalId
    principalType: principalType
  }
}

// Broader Foundry Models inference access (covers the /openai/v1 and /models endpoints).
resource cognitiveServicesUserRoleAssignment 'Microsoft.Authorization/roleAssignments@2022-04-01' = if (!empty(principalId)) {
  name: guid(account.id, principalId, cognitiveServicesUserRoleId)
  scope: account
  properties: {
    roleDefinitionId: subscriptionResourceId('Microsoft.Authorization/roleDefinitions', cognitiveServicesUserRoleId)
    principalId: principalId
    principalType: principalType
  }
}

output aiServicesName string = account.name
output endpoint string = 'https://${account.name}.openai.azure.com/'
output chatDeploymentName string = chatDeployment.name
output embeddingDeploymentName string = embeddingDeployment.name
