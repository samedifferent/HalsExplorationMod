package hal.hem.setup;

import hal.hem.HEM;
import hal.hem.world.gen.feature.ModConfiguredFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HEM.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonEventHandler {

    @SubscribeEvent
    public static void biomeModification(BiomeLoadingEvent event) {
        event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ModConfiguredFeatures.ORE_ROSE_COPPER);
        if (event.getName() != null) {
            if (event.getName().getPath().equals("blueleaf_plains")) {
                event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> ModConfiguredFeatures.PATCH_GRASS_BLUELEAF);
                event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> ModConfiguredFeatures.STONE_PILLAR);
            }
        }
    }
}
