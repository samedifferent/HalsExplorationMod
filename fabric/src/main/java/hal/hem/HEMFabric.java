package hal.hem;

import net.fabricmc.api.ModInitializer;

public class HEMFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        new HEMCommon();
    }
}
