package hal.hem;

import hal.hem.setup.ClientRendererSetup;
import hal.hem.world.gen.feature.ModConfiguredFeatures;
import me.shedaniel.architectury.platform.forge.EventBuses;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(HEMCommon.MOD_ID)
public class HEM {
    public HEM() {
        EventBuses.registerModEventBus(HEMCommon.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        new HEMCommon();
    }

    /*private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(ModConfiguredFeatures:);
    }*/

    @Mod.EventBusSubscriber(modid = HEMCommon.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientEventHandler {
        @SubscribeEvent
        public static void init(final FMLClientSetupEvent event) {
            ClientRendererSetup.init();
        }
    }
}
