package hal.hem.world.gen.feature;

import hal.hem.HEMCommon;
import hal.hem.registry.ModBlocks;
import hal.hem.registry.ModFeatures;
import me.shedaniel.architectury.registry.DeferredRegister;
import me.shedaniel.architectury.registry.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.Features;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.blockplacers.DoublePlantPlacer;
import net.minecraft.world.level.levelgen.feature.blockplacers.SimpleBlockPlacer;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.placement.FrequencyWithExtraChanceDecoratorConfiguration;

import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final ConfiguredFeature<?, ?> ORE_ROSE_COPPER = register("ore_rose_copper", () -> Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NATURAL_STONE, ModBlocks.ROSE_COPPER_ORE.get().defaultBlockState(), 8)).range(16).squared().count(8));;
    public static final ConfiguredFeature<?, ?> PATCH_GRASS_BLUELEAF = register("patch_grass_blueleaf", () -> Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder((new WeightedStateProvider()).add(ModBlocks.BLUELEAF_SHORT_GRASS.get().defaultBlockState(), 1).add(ModBlocks.BLUELEAF_MEDIUM_GRASS.get().defaultBlockState(), 1).add(ModBlocks.BLUELEAF_TALL_GRASS.get().defaultBlockState(), 1), SimpleBlockPlacer.INSTANCE)).tries(32).build()).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(25));
    public static final ConfiguredFeature<?, ?> STONE_PILLAR = register("stone_pillar", () -> ModFeatures.STONE_PILLAR.get().configured(FeatureConfiguration.NONE).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(3));
    public static final ConfiguredFeature<?, ?> BLUELEAF_WHEAT = register("blueleaf_wheat", () -> Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(new SimpleStateProvider(ModBlocks.BLUELEAF_WHEAT.get().defaultBlockState()), DoublePlantPlacer.INSTANCE)).tries(32).build()).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(50));
    public static final ConfiguredFeature<?, ?> PATCH_MUSHROOM_BLUELEAF = register("patch_mushroom_blueleaf", () -> Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(new SimpleStateProvider(ModBlocks.BLUELEAF_MUSHROOM.get().defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(64).noProjection().build()).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).count(2));
    public static final ConfiguredFeature<?, ?> BLUELEAF_BUSH = register("blueleaf_bush", () -> Feature.RANDOM_PATCH.configured((new RandomPatchConfiguration.GrassConfigurationBuilder(new SimpleStateProvider(ModBlocks.BLUELEAF_BUSH.get().defaultBlockState()), SimpleBlockPlacer.INSTANCE)).tries(32).build()).decorated(Features.Decorators.HEIGHTMAP_DOUBLE_SQUARE).chance(10));
    public static final ConfiguredFeature<?, ?> SMALL_BLUELEAF_TREE = register("small_blueleaf_tree", () -> ModFeatures.SMALL_BLUELEAF_TREE.get().configured(FeatureConfiguration.NONE).decorated(Features.Decorators.HEIGHTMAP_SQUARE).decorated(FeatureDecorator.COUNT_EXTRA.configured(new FrequencyWithExtraChanceDecoratorConfiguration(10, 0.1F, 1))));

    public static ConfiguredFeature<?, ?> register(String path, Supplier<ConfiguredFeature<?,?>> featureSupplier) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(HEMCommon.MOD_ID, path), featureSupplier.get());
    }
}
