package hal.hem.world.gen.feature;

import hal.hem.HEM;
import hal.hem.registry.ModBlocks;
import hal.hem.registry.ModFeatures;
import hal.hem.registry.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final ConfiguredFeature<?,?> ORE_ROSE_COPPER = register("ore_rose_copper", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.ROSE_COPPER_ORE.get().defaultBlockState(), 8)).range(16).squared().count(8));
    public static final ConfiguredFeature<?, ?> PATCH_GRASS_BLUELEAF = register("patch_grass_blueleaf", Feature.RANDOM_PATCH.configured((new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider()).add(ModBlocks.BLUELEAF_SHORT_GRASS.get().defaultBlockState(), 1).add(ModBlocks.BLUELEAF_MEDIUM_GRASS.get().defaultBlockState(), 1).add(ModBlocks.BLUELEAF_TALL_GRASS.get().defaultBlockState(), 1), SimpleBlockPlacer.INSTANCE)).tries(32).build()).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).count(25));
    public static final ConfiguredFeature<?, ?> STONE_PILLAR = register("stone_pillar", ModFeatures.STONE_PILLAR.get().configured(IFeatureConfig.NONE).decorated(Features.Placements.HEIGHTMAP_DOUBLE_SQUARE).count(3));

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> feature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(HEM.MOD_ID, name), feature);
    }
}
