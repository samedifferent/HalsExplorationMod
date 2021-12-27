package hal.hem.registry;

import hal.hem.HEMCommon;
import me.shedaniel.architectury.registry.BiomeModifications;
import me.shedaniel.architectury.registry.DeferredRegister;
import me.shedaniel.architectury.registry.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.biome.VanillaBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

import java.util.function.Supplier;

public class ModBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(HEMCommon.MOD_ID, Registry.BIOME_REGISTRY);

    static {
        createBiome("blueleaf_plains", VanillaBiomes::theVoidBiome);
        createBiome("hayfever_fields", VanillaBiomes::theVoidBiome);
        createBiome("duskwood_forest", VanillaBiomes::theVoidBiome);
    }

    public static final ResourceKey<Biome> BLUELEAF_PLAINS = registerBiome("blueleaf_plains");
    public static final ResourceKey<Biome> HAYFEVER_FIELDS = registerBiome("hayfever_fields");
    public static final ResourceKey<Biome> DUSKWOOD_FOREST = registerBiome("duskwood_forest");

    public static ResourceKey<Biome> registerBiome(String name) {
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(HEMCommon.MOD_ID, name));
    }

    public static RegistrySupplier<Biome> createBiome(String name, Supplier<Biome> biome) {
        return BIOMES.register(name, biome);
    }

    public static void registerBiomes() {
        BiomeModifications.addProperties((biomeContext) -> biomeContext.getProperties().getClimateProperties().getTemperature() > 1.0F, (biomeContext, mutable) -> BLUELEAF_PLAINS.location());
        BiomeModifications.addProperties((biomeContext) -> biomeContext.getProperties().getClimateProperties().getTemperature() > 1.0F, (biomeContext, mutable) -> HAYFEVER_FIELDS.location());
        BiomeModifications.addProperties((biomeContext) -> biomeContext.getProperties().getClimateProperties().getTemperature() < 0.5F, (biomeContext, mutable) -> HAYFEVER_FIELDS.location());
        /*BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(BLUELEAF_PLAINS, 10));
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(HAYFEVER_FIELDS, 10));
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(DUSKWOOD_FOREST, 10));*/
    }
}
