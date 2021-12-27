package hal.hem.registry;

import hal.hem.HEMCommon;
import hal.hem.world.gen.feature.SmallBlueleafTreeFeature;
import hal.hem.world.gen.feature.StonePillarFeature;
import me.shedaniel.architectury.registry.DeferredRegister;
import me.shedaniel.architectury.registry.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(HEMCommon.MOD_ID, Registry.FEATURE_REGISTRY);

    public static final RegistrySupplier<StonePillarFeature> STONE_PILLAR = FEATURES.register("stone_pillar", () -> new StonePillarFeature(NoneFeatureConfiguration.CODEC));
    public static final RegistrySupplier<SmallBlueleafTreeFeature> SMALL_BLUELEAF_TREE = FEATURES.register("small_blueleaf_tree", () -> new SmallBlueleafTreeFeature(NoneFeatureConfiguration.CODEC));
}
