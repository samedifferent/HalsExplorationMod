package hal.hem.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Lantern;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BluelampBlock extends Lantern {
    protected static final VoxelShape AABB = Shapes.or(Block.box(4.0D, 0.0D, 4.0D, 12.0D, 12.0D, 12.0D));

    public BluelampBlock() {
        super(BlockBehaviour.Properties.of(Material.WOOD).strength(1.5F).sound(SoundType.WOOD).lightLevel((light) -> 10));
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return AABB;
    }
}
