package hal.hem.block;

import hal.hem.registry.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class SmallTreeBlock extends BushBlock {
    public SmallTreeBlock() {
        super(AbstractBlock.Properties.of(Material.WOOD).noOcclusion().strength(2.0F).sound(SoundType.WOOD).lightLevel((light) -> 1));
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader p_200014_2_, BlockPos p_200014_3_) {
        return state.is(Blocks.GRASS_BLOCK) || state.is(Blocks.DIRT) || state.is((ModBlocks.BLUELEAF_GRASS_BLOCK.get())) || state.is((ModBlocks.BLUELEAF_DIRT.get()))
                || state.is(ModBlocks.SMALL_SILVERWOOD_TREE_MIDDLE.get()) || state.is(ModBlocks.SMALL_SILVERWOOD_TREE_TOP.get())
                || state.is(ModBlocks.SMALL_BLUELEAF_TREE_BOTTOM.get()) || state.is(ModBlocks.SMALL_BLUELEAF_TREE_MIDDLE.get()) || state.is(ModBlocks.SMALL_BLUELEAF_TREE_MIDDLE_LEAVES.get()) || state.is(ModBlocks.SMALL_BLUELEAF_TREE_TOP.get());
    }
}
