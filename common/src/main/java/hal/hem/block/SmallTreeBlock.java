package hal.hem.block;

import hal.hem.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SmallTreeBlock extends BushBlock {
    private static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    public SmallTreeBlock() {
        super(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().strength(2.0F).sound(SoundType.WOOD).lightLevel((light) -> 1));
    }

    @Override
    protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return blockState.is(Blocks.GRASS_BLOCK) || blockState.is(Blocks.DIRT) || blockState.is((ModBlocks.BLUELEAF_GRASS_BLOCK.get())) || blockState.is((ModBlocks.BLUELEAF_DIRT.get()))
                || blockState.is(ModBlocks.SMALL_SILVERWOOD_TREE_MIDDLE.get()) || blockState.is(ModBlocks.SMALL_SILVERWOOD_TREE_TOP.get())
                || blockState.is(ModBlocks.SMALL_BLUELEAF_TREE_BOTTOM.get()) || blockState.is(ModBlocks.SMALL_BLUELEAF_TREE_MIDDLE.get()) || blockState.is(ModBlocks.SMALL_BLUELEAF_TREE_MIDDLE_LEAVES.get()) || blockState.is(ModBlocks.SMALL_BLUELEAF_TREE_TOP.get());
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }
}
