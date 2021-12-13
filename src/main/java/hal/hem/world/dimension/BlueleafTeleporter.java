package hal.hem.world.dimension;

import hal.hem.block.GeneratorPipeBlock;
import hal.hem.block.TransporterBlock;
import hal.hem.registry.ModBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluids;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.ITeleporter;

import java.util.function.Function;

public class BlueleafTeleporter implements ITeleporter {
    public static BlockPos thisPos = BlockPos.ZERO;
    public static boolean insideDimension = true;

    public BlueleafTeleporter(BlockPos pos, boolean insideDim) {
        thisPos = pos;
        insideDimension = insideDim;
    }

    @Override
    public Entity placeEntity(Entity entity, ServerWorld currentWorld, ServerWorld destinationWorld,
                              float yaw, Function<Boolean, Entity> repositionEntity) {
        entity = repositionEntity.apply(false);
        double y = 61;

        if (!insideDimension) {
            y = thisPos.getY();
        }

        BlockPos destinationPos = new BlockPos(thisPos.getX(), y, thisPos.getZ());

        int tries = 0;
        while ((destinationWorld.getBlockState(destinationPos).getMaterial() != Material.AIR) &&
                !destinationWorld.getBlockState(destinationPos).canBeReplaced(Fluids.WATER) &&
                destinationWorld.getBlockState(destinationPos.above()).getMaterial() != Material.AIR &&
                !destinationWorld.getBlockState(destinationPos.above()).canBeReplaced(Fluids.WATER) && tries < 25) {
            destinationPos = destinationPos.above(2);
            tries++;
        }

        entity.teleportTo(destinationPos.getX() + 1, destinationPos.getY(), destinationPos.getZ());

        if (insideDimension) {
            boolean doSetBlock = true;
            for (BlockPos checkPos : BlockPos.betweenClosed(destinationPos.below(10).west(10), destinationPos.above(10).east(10))) {
                if (destinationWorld.getBlockState(checkPos).getBlock() instanceof TransporterBlock) {
                    doSetBlock = false;
                    break;
                }
            }
            if (doSetBlock) {
                destinationWorld.setBlockAndUpdate(destinationPos, ModBlocks.TRANSPORTER.get().defaultBlockState());
                destinationWorld.setBlockAndUpdate(destinationPos.above(), ModBlocks.TRANSPORTER.get().defaultBlockState().setValue(TransporterBlock.HALF, DoubleBlockHalf.UPPER));
                destinationWorld.setBlockAndUpdate(destinationPos.east(), ModBlocks.T1_COMPUTER.get().defaultBlockState());
                destinationWorld.setBlockAndUpdate(destinationPos.west(), ModBlocks.GENERATOR_PIPE.get().defaultBlockState().setValue(GeneratorPipeBlock.FACING, Direction.EAST));
                destinationWorld.setBlockAndUpdate(destinationPos.west(2), ModBlocks.GENERATOR_PIPE.get().defaultBlockState().setValue(GeneratorPipeBlock.FACING, Direction.EAST));
                destinationWorld.setBlockAndUpdate(destinationPos.west(3), ModBlocks.GENERATOR.get().defaultBlockState());
            }
        }

        return entity;
    }
}
