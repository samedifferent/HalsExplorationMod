package hal.hem.block;

import hal.hem.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.SkyLightEngine;

import java.util.Random;

public class BlueleafGrassBlock extends Block {
    public BlueleafGrassBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK));
    }

    private static boolean canBeGrass(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        BlockPos aboveBlockPos = blockPos.above();
        BlockState aboveBlockState = levelReader.getBlockState(aboveBlockPos);
        if (aboveBlockState.is(Blocks.SNOW) && aboveBlockState.getValue(SnowLayerBlock.LAYERS) == 1) {
            return true;
        } else if (aboveBlockState.getFluidState().getAmount() == 8) {
            return false;
        } else {
            int lightLevel = SkyLightEngine.getLightBlockInto(levelReader, blockState, blockPos, aboveBlockState, aboveBlockPos, Direction.UP, aboveBlockState.getLightBlock(levelReader, aboveBlockPos));
            return lightLevel < levelReader.getMaxLightLevel();
        }
    }

    private static boolean canPropagate(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        BlockPos aboveBlockPos = blockPos.above();
        return canBeGrass(blockState, levelReader, blockPos) && !levelReader.getFluidState(aboveBlockPos).is(FluidTags.WATER);
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, Random random) {
        if (!canBeGrass(blockState, serverLevel, blockPos)) {
            if (!isAreaLoaded(serverLevel, blockPos, 3)) return;
            serverLevel.setBlockAndUpdate(blockPos, ModBlocks.BLUELEAF_DIRT.get().defaultBlockState());
        } else {
            if (serverLevel.getMaxLocalRawBrightness(blockPos.above()) >= 9) {
                BlockState blockstate = this.defaultBlockState();

                for(int i = 0; i < 4; ++i) {
                    BlockPos blockpos = blockPos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                    if (serverLevel.getBlockState(blockpos).is(ModBlocks.BLUELEAF_DIRT.get()) && canPropagate(blockstate, serverLevel, blockpos)) {
                        serverLevel.setBlockAndUpdate(blockpos, blockstate);
                    }
                }
            }

        }
    }

    // This is a Forge method, which is patched into the source code.
    boolean isAreaLoaded(ServerLevel serverLevel, BlockPos center, int range) {
        return serverLevel.hasChunksAt(center.offset(-range, -range, -range), center.offset(range, range, range));
    }
}
