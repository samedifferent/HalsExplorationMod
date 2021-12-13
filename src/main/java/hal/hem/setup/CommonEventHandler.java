package hal.hem.setup;

import hal.hem.HEM;
import hal.hem.world.gen.feature.OreFeature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HEM.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonEventHandler {

    @SubscribeEvent
    public static void biomeModification(BiomeLoadingEvent event) {
        event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> OreFeature.ROSE_COPPER_ORE);
    }
}
