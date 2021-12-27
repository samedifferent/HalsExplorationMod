package hal.hem.client;

import hal.hem.setup.ClientRendererSetup;
import net.fabricmc.api.ClientModInitializer;

public class HEMClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientRendererSetup.init();

    }
}
