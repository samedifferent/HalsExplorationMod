package hal.hem.registry;

import hal.hem.HEM;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, HEM.MOD_ID);

    static {
        createBiome("blueleaf_plains", BiomeMaker::theVoidBiome);
        createBiome("hayfever_fields", BiomeMaker::theVoidBiome);
        createBiome("duskwood_forest", BiomeMaker::theVoidBiome);
        createBiome("silverwood_heights", BiomeMaker::theVoidBiome);
        createBiome("rosewood_peaks", BiomeMaker::theVoidBiome);
        createBiome("luscious_woodlands", BiomeMaker::theVoidBiome);
    }

    public static final RegistryKey<Biome> BLUELEAF_PLAINS = registerBiome("blueleaf_plains");
    public static final RegistryKey<Biome> HAYFEVER_FIELDS = registerBiome("hayfever_fields");
    public static final RegistryKey<Biome> DUSKWOOD_FOREST = registerBiome("duskwood_forest");
    public static final RegistryKey<Biome> SILVERWOOD_HEIGHTS = registerBiome("silverwood_heights");
    public static final RegistryKey<Biome> ROSEWOOD_PEAKS = registerBiome("rosewood_peaks");
    public static final RegistryKey<Biome> LUSCUIOUS_WOODLANDS = registerBiome("luscious_woodlands");

    public static RegistryKey<Biome> registerBiome(String name) {
        return RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(HEM.MOD_ID, name));
    }

    public static RegistryObject<Biome> createBiome(String name, Supplier<Biome> biome) {
        return BIOMES.register(name, biome);
    }

    public static void registerBiomes() {
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(BLUELEAF_PLAINS, 10));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(HAYFEVER_FIELDS, 8));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(DUSKWOOD_FOREST, 6));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(SILVERWOOD_HEIGHTS, 10));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(ROSEWOOD_PEAKS, 6));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(LUSCUIOUS_WOODLANDS, 5));
    }
}
