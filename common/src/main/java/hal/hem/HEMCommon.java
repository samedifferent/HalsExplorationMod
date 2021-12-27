package hal.hem;

import hal.hem.particle.BlossomParticle;
import hal.hem.particle.BlueleafSporeParticle;
import hal.hem.particle.FallingBlueleafParticle;
import hal.hem.particle.HeavySnowParticle;
import hal.hem.registry.*;
import hal.hem.world.gen.feature.ModConfiguredFeatures;
import me.shedaniel.architectury.event.events.LifecycleEvent;
import me.shedaniel.architectury.event.events.client.ClientLifecycleEvent;
import me.shedaniel.architectury.registry.BiomeModifications;
import me.shedaniel.architectury.registry.CreativeTabs;
import me.shedaniel.architectury.registry.ParticleProviderRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HEMCommon {

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "hem";

    public static final CreativeModeTab TAB = CreativeTabs.create(new ResourceLocation(HEMCommon.MOD_ID, "tab"), () -> new ItemStack(ModItems.AIRSHIP.get()));

    public HEMCommon() {
        ModBlocks.BLOCKS.register();
        ModItems.ITEMS.register();
        ModEntityTypes.ENTITIES.register();
        ModBiomes.BIOMES.register();
        ModFeatures.FEATURES.register();
        ModSurfaceBuilders.SURFACE_BUILDERS.register();
        ModBiomes.registerBiomes();

        // Register ore features
        LifecycleEvent.SETUP.register(() -> {
            BiomeModifications.addProperties((biomeContext, mutable) -> mutable.getGenerationProperties().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModConfiguredFeatures.ORE_ROSE_COPPER));
        });

        /* Forge doesn't like particles
        ClientLifecycleEvent.CLIENT_WORLD_LOAD.register((client) -> {
            // Particle
            ParticleProviderRegistry.register(ModParticleTypes.FALLING_BLUELEAF.get(), FallingBlueleafParticle.Factory::new);
            ParticleProviderRegistry.register(ModParticleTypes.HEAVY_SNOW.get(), HeavySnowParticle.Factory::new);
            ParticleProviderRegistry.register(ModParticleTypes.BLUELEAF_SPORE.get(), BlueleafSporeParticle.Factory::new);
            ParticleProviderRegistry.register(ModParticleTypes.BLOSSOM.get(), BlossomParticle.Factory::new);
        });*/
    }
}
