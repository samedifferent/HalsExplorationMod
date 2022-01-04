package hal.hem.block;

import hal.hem.registry.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class SmallTreeBlock extends BushBlock {
    private static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    public SmallTreeBlock() {
        super(AbstractBlock.Properties.of(Material.WOOD).noOcclusion().strength(2.0F).sound(SoundType.WOOD).lightLevel((light) -> 1));
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader p_200014_2_, BlockPos p_200014_3_) {
        return state.is((ModBlocks.BLUELEAF_GRASS_BLOCK.get())) || state.is((ModBlocks.BLUELEAF_DIRT.get())) || state.is((ModBlocks.COARSE_BLUELEAF_DIRT.get()))
                || state.is(ModBlocks.SMALL_SILVERWOOD_TREE_MIDDLE.get()) || state.is(ModBlocks.SMALL_SILVERWOOD_TREE_TOP.get())
                || state.is(ModBlocks.SMALL_BLUELEAF_TREE_BOTTOM.get()) || state.is(ModBlocks.SMALL_BLUELEAF_TREE_MIDDLE.get()) || state.is(ModBlocks.SMALL_BLUELEAF_TREE_MIDDLE_LEAVES.get()) || state.is(ModBlocks.SMALL_BLUELEAF_TREE_TOP.get());
    }

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        return SHAPE;
    }
}
