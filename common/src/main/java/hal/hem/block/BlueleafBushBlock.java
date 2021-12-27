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
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlueleafBushBlock extends BushBlock {
    protected static final VoxelShape SHAPE = Shapes.join(Block.box(0, 4, 0, 16, 14, 16), Block.box(5, 0, 5, 11, 4, 11), BooleanOp.OR);

    public BlueleafBushBlock() {
        super(BlockBehaviour.Properties.of(Material.WOOD).noOcclusion().strength(2.0F).sound(SoundType.WOOD));
    }

    @Override
    protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return blockState.is(Blocks.GRASS_BLOCK) || blockState.is(Blocks.DIRT) || blockState.is(Blocks.COARSE_DIRT) || blockState.is(Blocks.PODZOL) || blockState.is(Blocks.FARMLAND) || blockState.is((ModBlocks.BLUELEAF_GRASS_BLOCK.get())) || blockState.is((ModBlocks.BLUELEAF_DIRT.get()));
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }
}
