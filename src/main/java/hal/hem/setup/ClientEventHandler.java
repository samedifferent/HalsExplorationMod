package hal.hem.setup;

import hal.hem.HEM;
import hal.hem.particle.BlossomParticle;
import hal.hem.particle.BlueleafSporeParticle;
import hal.hem.particle.FallingBlueleafParticle;
import hal.hem.particle.HeavySnowParticle;
import hal.hem.registry.ModBlocks;
import hal.hem.registry.ModParticleTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.UnderwaterParticle;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = HEM.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventHandler {
    @SubscribeEvent
    public static void init(final FMLClientSetupEvent event) {

        // CUTOUT
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
        RenderTypeLookup.setRenderLayer(ModBlocks.FLOWERING_LILY.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GIANT_BLOSSOM.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SMALL_BLOSSOM.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLUELEAF_MUSHROOM.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.TALL_BLUELEAF_FLOWER.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SMALL_SILVERWOOD_TREE_MIDDLE.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SMALL_BLUELEAF_TREE_BOTTOM.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SMALL_BLUELEAF_TREE_MIDDLE.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SMALL_BLUELEAF_TREE_MIDDLE_LEAVES.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.SMALL_BLUELEAF_TREE_TOP.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.GENERATOR.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.TRANSPORTER.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.T1_COMPUTER.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLUELAMP.get(), RenderType.cutout());

        // CUTOUT MIPPED
        RenderTypeLookup.setRenderLayer(ModBlocks.BLUELEAVES.get(), RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(ModBlocks.FLOWERING_BLUELEAVES.get(), RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(ModBlocks.BLUELEAF_BUSH.get(), RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(ModBlocks.SMALL_SILVERWOOD_TREE_TOP.get(), RenderType.cutoutMipped());
        RenderTypeLookup.setRenderLayer(ModBlocks.DUSKWOOD_LEAVES.get(), RenderType.cutoutMipped());

        // TRANSLUCENT
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_PINK_CRYSTAL_BLOCK.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PINK_CRYSTAL_BLOCK.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PURPLE_CRYSTAL_BLOCK.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.WHITE_CRYSTAL_BLOCK.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_PINK_CRYSTAL_WALL.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PINK_CRYSTAL_WALL.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PURPLE_CRYSTAL_WALL.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.WHITE_CRYSTAL_WALL.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.LIGHT_PINK_CRYSTAL_PANE.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PINK_CRYSTAL_PANE.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.PURPLE_CRYSTAL_PANE.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.WHITE_CRYSTAL_PANE.get(), RenderType.translucent());
    }

    @SubscribeEvent
    public static void registerFactory(ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticleTypes.FALLING_BLUELEAF.get(), FallingBlueleafParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticleTypes.HEAVY_SNOW.get(), HeavySnowParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticleTypes.BLUELEAF_SPORE.get(), BlueleafSporeParticle.Factory::new);
        Minecraft.getInstance().particleEngine.register(ModParticleTypes.BLOSSOM.get(), BlossomParticle.Factory::new);
    }
}
