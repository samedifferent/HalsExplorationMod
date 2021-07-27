package hal.hem.setup;

import hal.hem.HEM;
import hal.hem.registry.ModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = HEM.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler {
    @SubscribeEvent
    public static void init(final FMLClientSetupEvent event) {

        RenderTypeLookup.setRenderLayer(ModBlocks.BLUELEAF_SAPLING.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.DUSKWOOD_SAPLING.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SILVERWOOD_SAPLING.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.ROSEWOOD_SAPLING.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SILVERWOOD_TRAPDOOR.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLUELEAF_TALL_GRASS.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLUELEAF_MEDIUM_GRASS.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLUELEAF_SHORT_GRASS.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLUELEAF_WHEAT.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.BRONZIUM_CRYSTAL.get(), RenderType.cutout());

        RenderTypeLookup.setRenderLayer(ModBlocks.BLUELEAVES.get(), RenderType.cutoutMipped());
    }
}
