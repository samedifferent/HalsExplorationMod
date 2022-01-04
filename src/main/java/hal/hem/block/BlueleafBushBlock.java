package hal.hem.block;

import hal.hem.registry.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class BlueleafBushBlock extends BushBlock {
    protected static final VoxelShape SHAPE = VoxelShapes.join(Block.box(0, 4, 0, 16, 14, 16), Block.box(5, 0, 5, 11, 4, 11), IBooleanFunction.OR);

    public BlueleafBushBlock() {
        super(AbstractBlock.Properties.of(Material.WOOD).noOcclusion().strength(2.0F).sound(SoundType.WOOD));
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader reader, BlockPos pos) {
        return state.is((ModBlocks.BLUELEAF_GRASS_BLOCK.get())) || state.is((ModBlocks.BLUELEAF_DIRT.get())) || state.is((ModBlocks.COARSE_BLUELEAF_DIRT.get()));
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
}
