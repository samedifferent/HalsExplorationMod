package hal.hem;

import hal.hem.registry.*;
import hal.hem.world.gen.feature.ModFeatures;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(HEM.MOD_ID)
public class HEM {

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "hem";

    public static final ItemGroup TAB = new ItemGroup(HEM.MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.AIRSHIP.get());
        }
    };

    public HEM() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.BLOCKS.register(bus);
        ModItems.ITEMS.register(bus);
        ModEntityTypes.ENTITIES.register(bus);
        ModBiomes.BIOMES.register(bus);
        ModParticleTypes.PARTICLE_TYPES.register(bus);
        ModSurfaceBuilders.SURFACE_BUILDERS.register(bus);
        ModBiomes.registerBiomes();

        MinecraftForge.EVENT_BUS.register(this);
    }
}
