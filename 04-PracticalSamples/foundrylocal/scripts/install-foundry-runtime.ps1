[CmdletBinding()]
param()

$ErrorActionPreference = 'Stop'
Set-StrictMode -Version Latest

$sampleDirectory = Split-Path -Parent $PSScriptRoot
$platform = & node -p 'process.platform + "-" + process.arch'
if ($LASTEXITCODE -ne 0 -or $platform -ne 'win32-x64') {
    throw 'This fallback installer supports Windows x64. On other platforms, use npm ci.'
}

$sdkDirectory = Join-Path $sampleDirectory 'node_modules/foundry-local-sdk'
$sdkManifest = Join-Path $sdkDirectory 'package.json'
if (-not (Test-Path $sdkManifest)) {
    throw 'Run npm ci --ignore-scripts in the sample directory before this fallback installer.'
}
$sdkVersion = (Get-Content -Raw $sdkManifest | ConvertFrom-Json).version
$release = Invoke-RestMethod -Uri "https://api.github.com/repos/microsoft/Foundry-Local/releases/tags/v$sdkVersion"
$asset = $release.assets | Where-Object name -eq 'foundry-local-win-x64.zip'
if (-not $asset -or $asset.digest -notmatch '^sha256:[a-fA-F0-9]{64}$') {
    throw "The official Foundry Local $sdkVersion release has no Windows x64 archive with a SHA-256 digest."
}

$expectedHash = $asset.digest.Substring(7)
$stagingDirectory = Join-Path $sampleDirectory "target/foundry-runtime-$sdkVersion"
New-Item -ItemType Directory -Path $stagingDirectory -Force | Out-Null
$archive = Join-Path $stagingDirectory $asset.name
if (-not (Test-Path $archive) -or (Get-FileHash -Algorithm SHA256 $archive).Hash -ne $expectedHash) {
    Write-Host "Downloading the official Foundry Local $sdkVersion Windows x64 runtime ($($asset.size) bytes)..."
    Invoke-WebRequest -Uri $asset.browser_download_url -OutFile $archive
}
if ((Get-FileHash -Algorithm SHA256 $archive).Hash -ne $expectedHash) {
    throw 'The runtime archive does not match its published SHA-256 digest.'
}

$expandedDirectory = Join-Path $stagingDirectory 'expanded'
Expand-Archive -Path $archive -DestinationPath $expandedDirectory -Force
$nativeDirectory = Join-Path $sdkDirectory "prebuilds/$platform"
$runtimeLibraries = @(Get-ChildItem -Path $expandedDirectory -Recurse -Filter '*.dll')
foreach ($requiredLibrary in @('foundry_local.dll', 'onnxruntime.dll', 'onnxruntime-genai.dll')) {
    if ($requiredLibrary -notin $runtimeLibraries.Name) {
        throw "The verified runtime archive is missing $requiredLibrary."
    }
}
foreach ($library in $runtimeLibraries) {
    Copy-Item -LiteralPath $library.FullName -Destination $nativeDirectory -Force
}
Write-Host "Installed verified Foundry Local $sdkVersion runtime libraries in $nativeDirectory."