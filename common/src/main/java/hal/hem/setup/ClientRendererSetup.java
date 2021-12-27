package hal.hem.setup;

import hal.hem.particle.BlossomParticle;
import hal.hem.particle.BlueleafSporeParticle;
import hal.hem.particle.FallingBlueleafParticle;
import hal.hem.particle.HeavySnowParticle;
import hal.hem.registry.ModBlocks;
import hal.hem.registry.ModEntityTypes;
import hal.hem.registry.ModParticleTypes;
import me.shedaniel.architectury.registry.ParticleProviderRegistry;
import me.shedaniel.architectury.registry.RenderTypes;
import me.shedaniel.architectury.registry.entity.EntityRenderers;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;

public class ClientRendererSetup {
    public static void init() {
        // CUTOUT
        RenderTypes.register(RenderType.cutout(), ModBlocks.BLUELEAF_SAPLING.get());
        RenderTypes.register(RenderType.cutout(), ModBlocks.DUSKWOOD_SAPLING.get());
        RenderTypes.register(RenderType.cutout(), ModBlocks.SILVERWOOD_SAPLING.get());
        RenderTypes.register(RenderType.cutout(), ModBlocks.ROSEWOOD_SAPLING.get());
        RenderTypes.register(RenderType.cutout(), ModBlocks.SILVERWOOD_TRAPDOOR.get());
        RenderTypes.register(RenderType.cutout(), ModBlocks.BLUELEAF_TALL_GRASS.get());
        RenderTypes.register(RenderType.cutout(), ModBlocks.BLUELEAF_MEDIUM_GRASS.get());
        RenderTypes.register(RenderType.cutout(), ModBlocks.BLUELEAF_SHORT_GRASS.get());
        RenderTypes.register(RenderType.cutout(), ModBlocks.BLUELEAF_WHEAT.get());
        RenderTypes.register(RenderType.cutout(), ModBlocks.BRONZIUM_CRYSTAL.get());
        RenderTypes.register(RenderType.cutout(), ModBlocks.FLOWERING_LILY.get());
        RenderTypes.register(RenderType.cutout(), ModBlocks.GIANT_BLOSSOM.get());
        RenderTypes.register(RenderType.cutout(), ModBlocks.SMALL_BLOSSOM.get());
        RenderTypes.register(RenderType.cutout(), ModBlocks.BLUELEAF_MUSHROOM.get());
        RenderTypes.register(RenderType.cutout(), ModBlocks.TALL_BLUELEAF_FLOWER.get());
        RenderTypes.register(RenderType.cutout(), ModBlocks.SMALL_SILVERWOOD_TREE_MIDDLE.get());
        RenderTypes.register(RenderType.cutout(), ModBlocks.SMALL_BLUELEAF_TREE_BOTTOM.get());
        RenderTypes.register(RenderType.cutout(), ModBlocks.SMALL_BLUELEAF_TREE_MIDDLE.get());
        RenderTypes.register(RenderType.cutout(), ModBlocks.SMALL_BLUELEAF_TREE_MIDDLE_LEAVES.get());
        RenderTypes.register(RenderType.cutout(), ModBlocks.SMALL_BLUELEAF_TREE_TOP.get());
        RenderTypes.register(RenderType.cutout(), ModBlocks.GENERATOR.get());
        RenderTypes.register(RenderType.cutout(), ModBlocks.TRANSPORTER.get());
        RenderTypes.register(RenderType.cutout(), ModBlocks.T1_COMPUTER.get());
        RenderTypes.register(RenderType.cutout(), ModBlocks.BLUELAMP.get());

        // CUTOUT MIPPED
        RenderTypes.register(RenderType.cutoutMipped(), ModBlocks.BLUELEAVES.get());
        RenderTypes.register(RenderType.cutoutMipped(), ModBlocks.FLOWERING_BLUELEAVES.get());
        RenderTypes.register(RenderType.cutoutMipped(), ModBlocks.BLUELEAF_BUSH.get());
        RenderTypes.register(RenderType.cutoutMipped(), ModBlocks.SMALL_SILVERWOOD_TREE_TOP.get());
        RenderTypes.register(RenderType.cutoutMipped(), ModBlocks.DUSKWOOD_LEAVES.get());

        // TRANSLUCENT
        RenderTypes.register(RenderType.translucent(), ModBlocks.LIGHT_PINK_CRYSTAL_BLOCK.get());
        RenderTypes.register(RenderType.translucent(), ModBlocks.PINK_CRYSTAL_BLOCK.get());
        RenderTypes.register(RenderType.translucent(), ModBlocks.PURPLE_CRYSTAL_BLOCK.get());
        RenderTypes.register(RenderType.translucent(), ModBlocks.WHITE_CRYSTAL_BLOCK.get());
        RenderTypes.register(RenderType.translucent(), ModBlocks.LIGHT_PINK_CRYSTAL_WALL.get());
        RenderTypes.register(RenderType.translucent(), ModBlocks.PINK_CRYSTAL_WALL.get());
        RenderTypes.register(RenderType.translucent(), ModBlocks.PURPLE_CRYSTAL_WALL.get());
        RenderTypes.register(RenderType.translucent(), ModBlocks.WHITE_CRYSTAL_WALL.get());
        RenderTypes.register(RenderType.translucent(), ModBlocks.LIGHT_PINK_CRYSTAL_PANE.get());
        RenderTypes.register(RenderType.translucent(), ModBlocks.PINK_CRYSTAL_PANE.get());
        RenderTypes.register(RenderType.translucent(), ModBlocks.PURPLE_CRYSTAL_PANE.get());
        RenderTypes.register(RenderType.translucent(), ModBlocks.WHITE_CRYSTAL_PANE.get());

        // Entity Renderers
        EntityRenderers.register(ModEntityTypes.BULLET.get(), (dispatcher) -> new ThrownItemRenderer<>(dispatcher, Minecraft.getInstance().getItemRenderer()));
    }
}
