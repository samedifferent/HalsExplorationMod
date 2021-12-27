package hal.hem.world.gen.surfacebuilders;

import com.mojang.serialization.Codec;
import hal.hem.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.level.levelgen.surfacebuilders.SurfaceBuilderBaseConfiguration;

import java.util.Random;

public class BlueleafPlainsSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderBaseConfiguration> {
    public static final BlockState BLUELEAF_GRASS = ModBlocks.BLUELEAF_GRASS_BLOCK.get().defaultBlockState();
    public static final BlockState BLUELEAVES = ModBlocks.BLUELEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true);
    public static final BlockState COARSE_BLUELEAF_DIRT = ModBlocks.COARSE_BLUELEAF_DIRT.get().defaultBlockState();
    public static final BlockState BLUELEAF_DIRT = ModBlocks.BLUELEAF_DIRT.get().defaultBlockState();
    public static final BlockState BLUEROCK = ModBlocks.BLUEROCK.get().defaultBlockState();

    public BlueleafPlainsSurfaceBuilder(Codec<SurfaceBuilderBaseConfiguration> surfaceBuilderBaseConfigurationCodec) {
        super(surfaceBuilderBaseConfigurationCodec);
    }

    @Override
    public void apply(Random random, ChunkAccess chunk, Biome biome, int x, int z, int terrainHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderBaseConfiguration config) {
        this.buildSurface(random, chunk, x, z, terrainHeight, noise, defaultFluid, seaLevel);
    }

    protected void buildSurface(Random random, ChunkAccess chunk, int x, int z, int terrainHeight, double noise, BlockState defaultFluid, int seaLevel) {
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        int depth = -1;
        int scaledNoise = (int)(noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);

        for(int y = terrainHeight; y >= 0; --y) {

            mutable.set(x, y, z);
            BlockState currentBlockInWorld = chunk.getBlockState(mutable);

            if (currentBlockInWorld.isAir()) {
                depth = -1;
            } else if (!currentBlockInWorld.getFluidState().isEmpty()) {
                chunk.setBlockState(mutable,defaultFluid, false);
            } else if (currentBlockInWorld.getBlock() != Blocks.BEDROCK) {
                if (depth == -1) {
                    depth = 0;

                    if(y >= seaLevel - 1){
                        switch (random.nextInt(10)) {
                            case 1 -> chunk.setBlockState(mutable, COARSE_BLUELEAF_DIRT, false);
                            case 2 -> chunk.setBlockState(mutable, BLUELEAVES, false);
                            default -> chunk.setBlockState(mutable, BLUELEAF_GRASS, false);
                        }
                    } else if(y >= seaLevel - scaledNoise - 7){
                        chunk.setBlockState(mutable, BLUELEAF_DIRT, false);
                    } else{
                        chunk.setBlockState(mutable, BLUELEAF_DIRT, false);
                    }
                } else if (depth <= scaledNoise) {
                    depth++;
                    chunk.setBlockState(mutable, BLUELEAF_DIRT, false);
                } else {
                    chunk.setBlockState(mutable, BLUEROCK, false);
                }
            }
        }
    }
}
