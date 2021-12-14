package hal.hem.registry;

import hal.hem.HEM;
import hal.hem.world.gen.feature.StonePillarFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, HEM.MOD_ID);

    public static final RegistryObject<StonePillarFeature> STONE_PILLAR = FEATURES.register("stone_pillar", () -> new StonePillarFeature(NoFeatureConfig.CODEC));
}
