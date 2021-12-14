package hal.hem.world.gen.surfacebuilders;

import com.mojang.serialization.Codec;
import hal.hem.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class BlueleafPlainsSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
    public static final BlockState BLUELEAF_GRASS = ModBlocks.BLUELEAF_GRASS_BLOCK.get().defaultBlockState();
    public static final BlockState BLUELEAVES = ModBlocks.BLUELEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true);
    public static final BlockState BLUELEAF_DIRT = ModBlocks.BLUELEAF_DIRT.get().defaultBlockState();

    public static final SurfaceBuilderConfig BLUELEAF_GRASS_CONFIG = new SurfaceBuilderConfig(BLUELEAF_GRASS, BLUELEAF_GRASS, BLUELEAF_GRASS);
    public static final SurfaceBuilderConfig BLUELEAVES_CONFIG = new SurfaceBuilderConfig(BLUELEAVES, BLUELEAVES, BLUELEAVES);
    public static final SurfaceBuilderConfig DIRT_CONFIG = new SurfaceBuilderConfig(BLUELEAF_DIRT, BLUELEAF_DIRT, BLUELEAF_DIRT);

    public BlueleafPlainsSurfaceBuilder(Codec<SurfaceBuilderConfig> pCodec) {
        super(pCodec);
    }

    @Override
    public void apply(Random random, IChunk chunk, Biome biome, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        switch (random.nextInt(10)) {
            case 1:
                SurfaceBuilder.DEFAULT.apply(random, chunk, biome, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BLUELEAVES_CONFIG);
                break;
            case 2:
                SurfaceBuilder.DEFAULT.apply(random, chunk, biome, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, DIRT_CONFIG);
                break;
            default:
                SurfaceBuilder.DEFAULT.apply(random, chunk, biome, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, BLUELEAF_GRASS_CONFIG);
                break;
        }
    }
}
