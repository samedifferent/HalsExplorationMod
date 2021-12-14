package hal.hem.block;

import hal.hem.registry.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class BlueleafWheatBlock extends DoublePlantBlock {
    public BlueleafWheatBlock() {
        super(AbstractBlock.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.CROP));
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, IBlockReader reader, BlockPos pos) {
        return state.is(Blocks.GRASS_BLOCK) || state.is(Blocks.DIRT) || state.is(Blocks.COARSE_DIRT) || state.is(Blocks.PODZOL) || state.is(Blocks.FARMLAND) || state.is((ModBlocks.BLUELEAF_GRASS_BLOCK.get())) || state.is((ModBlocks.BLUELEAF_DIRT.get()));
    }
}
