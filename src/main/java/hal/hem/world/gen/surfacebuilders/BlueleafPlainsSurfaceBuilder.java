package hal.hem.world.gen.surfacebuilders;

import com.mojang.serialization.Codec;
import hal.hem.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class BlueleafPlainsSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
    public BlueleafPlainsSurfaceBuilder(Codec<SurfaceBuilderConfig> pCodec) {
        super(pCodec);
    }

    @Override
    public void apply(Random random, IChunk chunk, Biome biome, int x, int z, int terrainHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        this.buildSurface(random, chunk, x, z, terrainHeight, noise, defaultFluid, seaLevel);
    }

    protected void buildSurface(Random random, IChunk chunk, int x, int z, int terrainHeight, double noise, BlockState defaultFluid, int seaLevel) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
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
                            case 1:
                                chunk.setBlockState(mutable, ModBlocks.COARSE_BLUELEAF_DIRT.get().defaultBlockState(), false);
                                break;
                            case 2:
                                chunk.setBlockState(mutable, ModBlocks.BLUELEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), false);
                                break;
                            default:
                                chunk.setBlockState(mutable, ModBlocks.BLUELEAF_GRASS_BLOCK.get().defaultBlockState(), false);
                                break;
                        }
                    } else if(y >= seaLevel - scaledNoise - 7){
                        chunk.setBlockState(mutable, ModBlocks.BLUELEAF_DIRT.get().defaultBlockState(), false);
                    } else{
                        chunk.setBlockState(mutable, ModBlocks.BLUELEAF_DIRT.get().defaultBlockState(), false);
                    }
                } else if (depth <= scaledNoise) {
                    depth++;
                    chunk.setBlockState(mutable, ModBlocks.BLUELEAF_DIRT.get().defaultBlockState(), false);
                } else {
                    chunk.setBlockState(mutable, ModBlocks.BLUELEAF_DIRT.get().defaultBlockState(), false);
                }
            }
        }
    }
}
