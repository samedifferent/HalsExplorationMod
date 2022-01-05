package hal.hem.registry;

import hal.hem.HEM;
import hal.hem.world.gen.feature.NbtFeature;
import hal.hem.world.gen.feature.SmallBlueleafTreeFeature;
import hal.hem.world.gen.feature.StonePillarFeature;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFeatures {
    private static final ResourceLocation[] PLAINS_TREES_RL = new ResourceLocation[]{new ResourceLocation(HEM.MOD_ID, "trees/plains_tree_small_1"), new ResourceLocation(HEM.MOD_ID, "trees/plains_tree_medium_1"), new ResourceLocation(HEM.MOD_ID, "trees/plains_tree_medium_2"), new ResourceLocation(HEM.MOD_ID, "trees/plains_tree_medium_3")};
    private static final ResourceLocation[] BOULDERS_RL = new ResourceLocation[]{new ResourceLocation(HEM.MOD_ID, "rocks/plains_boulder_large"), new ResourceLocation(HEM.MOD_ID, "rocks/plains_boulder_small")};

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, HEM.MOD_ID);

    public static final RegistryObject<StonePillarFeature> STONE_PILLAR = FEATURES.register("stone_pillar", () -> new StonePillarFeature(NoFeatureConfig.CODEC));
    public static final RegistryObject<SmallBlueleafTreeFeature> SMALL_BLUELEAF_TREE = FEATURES.register("small_blueleaf_tree", () -> new SmallBlueleafTreeFeature(NoFeatureConfig.CODEC));
    public static final RegistryObject<NbtFeature> BLUELEAF_PLAINS_TREE = FEATURES.register("plains_tree", () -> new NbtFeature(PLAINS_TREES_RL));
    public static final RegistryObject<NbtFeature> PLAINS_BOULDER = FEATURES.register("plains_boulder", () -> new NbtFeature(BOULDERS_RL));
}
