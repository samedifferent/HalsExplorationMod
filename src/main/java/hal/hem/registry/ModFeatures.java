package hal.hem.registry;

import hal.hem.HEM;
import hal.hem.world.gen.feature.SmallBlueleafTreeFeature;
import hal.hem.world.gen.feature.StonePillarFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, HEM.MOD_ID);

    public static final RegistryObject<StonePillarFeature> STONE_PILLAR = FEATURES.register("stone_pillar", () -> new StonePillarFeature(NoFeatureConfig.CODEC));
    public static final RegistryObject<SmallBlueleafTreeFeature> SMALL_BLUELEAF_TREE = FEATURES.register("small_blueleaf_tree", () -> new SmallBlueleafTreeFeature(NoFeatureConfig.CODEC));
}
