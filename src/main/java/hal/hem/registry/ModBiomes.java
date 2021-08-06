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
    }

    public static final RegistryKey<Biome> BLUELEAF_PLAINS = registerBiome("blueleaf_plains");

    public static RegistryKey<Biome> registerBiome(String name) {
        return RegistryKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(HEM.MOD_ID, name));
    }

    public static RegistryObject<Biome> createBiome(String name, Supplier<Biome> biome) {
        return BIOMES.register(name, biome);
    }

    public static void registerBiomes() {
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(BLUELEAF_PLAINS, 10));
    }
}
