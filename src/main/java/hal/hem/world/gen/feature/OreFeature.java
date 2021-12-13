package hal.hem.world.gen.feature;

import hal.hem.HEM;
import hal.hem.registry.ModBlocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class OreFeature {
    public static ConfiguredFeature<?,?> ROSE_COPPER_ORE;

    public static void registerOreFeatures() {
        ROSE_COPPER_ORE = Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.ROSE_COPPER_ORE.get().defaultBlockState(), 8)).range(16).squared().count(8);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(HEM.MOD_ID, "rose_copper_ore"), ROSE_COPPER_ORE);
    }
}
