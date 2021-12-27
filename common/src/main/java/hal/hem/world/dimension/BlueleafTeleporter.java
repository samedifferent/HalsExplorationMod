package hal.hem.world.dimension;

import hal.hem.block.GeneratorPipeBlock;
import hal.hem.block.TransporterBlock;
import hal.hem.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;

import java.util.function.Function;

public class BlueleafTeleporter implements ITeleporter {
    public static BlockPos thisPos = BlockPos.ZERO;
    public static boolean insideDimension = true;

    public BlueleafTeleporter(BlockPos pos, boolean insideDim) {
        thisPos = pos;
        insideDimension = insideDim;
    }

    @Override
    public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destWorld, float yaw, Function<Boolean, Entity> repositionEntity) {
        entity = repositionEntity.apply(false);
        double y = 61;

        if (!insideDimension) {
            y = thisPos.getY();
        }

        BlockPos destinationPos = new BlockPos(thisPos.getX(), y, thisPos.getZ());

        int tries = 0;
        while ((destWorld.getBlockState(destinationPos).getMaterial() != Material.AIR) &&
                !destWorld.getBlockState(destinationPos).canBeReplaced(Fluids.WATER) &&
                destWorld.getBlockState(destinationPos.above()).getMaterial() != Material.AIR &&
                !destWorld.getBlockState(destinationPos.above()).canBeReplaced(Fluids.WATER) && tries < 25) {
            destinationPos = destinationPos.above(2);
            tries++;
        }

        entity.teleportTo(destinationPos.getX() + 1, destinationPos.getY(), destinationPos.getZ());

        if (insideDimension) {
            boolean doSetBlock = true;
            for (BlockPos checkPos : BlockPos.betweenClosed(destinationPos.below(10).west(10), destinationPos.above(10).east(10))) {
                if (destWorld.getBlockState(checkPos).getBlock() instanceof TransporterBlock) {
                    doSetBlock = false;
                    break;
                }
            }
            if (doSetBlock) {
                destWorld.setBlockAndUpdate(destinationPos, ModBlocks.TRANSPORTER.get().defaultBlockState());
                destWorld.setBlockAndUpdate(destinationPos.above(), ModBlocks.TRANSPORTER.get().defaultBlockState().setValue(TransporterBlock.HALF, DoubleBlockHalf.UPPER));
                destWorld.setBlockAndUpdate(destinationPos.east(), ModBlocks.T1_COMPUTER.get().defaultBlockState());
                destWorld.setBlockAndUpdate(destinationPos.west(), ModBlocks.GENERATOR_PIPE.get().defaultBlockState().setValue(GeneratorPipeBlock.FACING, Direction.EAST));
                destWorld.setBlockAndUpdate(destinationPos.west(2), ModBlocks.GENERATOR_PIPE.get().defaultBlockState().setValue(GeneratorPipeBlock.FACING, Direction.EAST));
                destWorld.setBlockAndUpdate(destinationPos.west(3), ModBlocks.GENERATOR.get().defaultBlockState());
            }
        }

        return entity;
    }
}
