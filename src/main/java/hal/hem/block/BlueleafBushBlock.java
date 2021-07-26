package hal.hem.block;

import hal.hem.registry.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class BlueleafBushBlock extends BushBlock {
    public BlueleafBushBlock() {
        super(AbstractBlock.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS));
    }

    @Override
    protected boolean mayPlaceOn(BlockState p_200014_1_, IBlockReader p_200014_2_, BlockPos p_200014_3_) {
        return p_200014_1_.is(Blocks.GRASS_BLOCK) || p_200014_1_.is(Blocks.DIRT) || p_200014_1_.is(Blocks.COARSE_DIRT) || p_200014_1_.is(Blocks.PODZOL) || p_200014_1_.is(Blocks.FARMLAND) || p_200014_1_.is((ModBlocks.BLUELEAF_GRASS.get()));
    }
}
