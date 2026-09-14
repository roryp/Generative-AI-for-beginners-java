import { FoundryLocalManager } from "foundry-local-sdk";
import { homedir } from "node:os";
import { dirname, join } from "node:path";
import { fileURLToPath } from "node:url";
import { parseArgs } from "node:util";

async function main() {
    const { values } = parseArgs({
        options: {
            model: { type: "string", default: "qwen2.5-0.5b" },
            port: { type: "string", default: "5273" },
            download: { type: "boolean", default: false },
            list: { type: "boolean", default: false }
        }
    });
    const port = Number(values.port);
    if (!Number.isInteger(port) || port < 0 || port > 65535) {
        throw new Error("--port must be an integer between 0 and 65535; 0 chooses a free port.");
    }

    const sampleDirectory = dirname(dirname(fileURLToPath(import.meta.url)));
    const manager = FoundryLocalManager.create({
        appName: "foundry-local-java-sample",
        appDataDir: join(sampleDirectory, "target", "foundry-local"),
        logsDir: join(sampleDirectory, "target", "foundry-local", "logs"),
        modelCacheDir: process.env.FOUNDRY_LOCAL_CACHE_DIR ?? join(homedir(), ".foundry", "cache", "models"),
        webServiceUrls: `http://127.0.0.1:${port}`,
        disableNonessentialTelemetry: true,
        logLevel: "warn"
    });

    let model;
    try {
        const cachedModels = await manager.catalog.getCachedModels();
        if (values.list) {
            console.log(JSON.stringify(cachedModels.map(cached => ({
                id: cached.id,
                alias: cached.alias,
                cached: cached.isCached
            })), null, 2));
            return;
        }

        model = cachedModels.find(cached => cached.id === values.model)
            ?? cachedModels.find(cached => cached.alias === values.model);
        if (!model) {
            if (!values.download) {
                throw new Error(`Model ${values.model} is not cached. Use --list to choose a cached model, `
                    + "or add --download to allow a download.");
            }
            model = values.model.includes(":")
                ? await manager.catalog.getModelVariant(values.model)
                : await manager.catalog.getModel(values.model);
            if (!model.isCached) {
                console.log(`Downloading local model: ${model.id}`);
                await model.download();
            }
        }

        const provider = model.info.runtime?.executionProvider;
        if (provider && provider !== "CPUExecutionProvider") {
            console.log(`Registering execution provider: ${provider}`);
            await manager.downloadAndRegisterEps([provider]);
        }
        console.log(`Loading cached local model: ${model.id}`);
        await model.load();
        manager.startWebService();
        console.log(`FOUNDRY_LOCAL_BASE_URL=${manager.urls[0]}/v1`);
        console.log(`FOUNDRY_LOCAL_MODEL=${model.id}`);
        console.log(`Foundry Local SDK 2.0.1 server ready (PID ${process.pid}). Press Ctrl+C to stop.`);

        await new Promise(resolve => {
            process.once("SIGINT", resolve);
            process.once("SIGTERM", resolve);
            process.stdin.resume();
        });
    } finally {
        process.stdin.pause();
        if (manager.isWebServiceRunning) {
            manager.stopWebService();
        }
        if (model && await model.isLoaded()) {
            await model.unload();
        }
        manager.dispose();
    }
}

main().catch(error => {
    console.error(error.message);
    process.exitCode = 1;
});