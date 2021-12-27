package hal.hem.block;

import hal.hem.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class BlueleafWheatBlock extends DoublePlantBlock {
    public BlueleafWheatBlock() {
        super(BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.CROP));
    }

    @Override
    protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return blockState.is(Blocks.GRASS_BLOCK) || blockState.is(Blocks.DIRT) || blockState.is(Blocks.COARSE_DIRT) || blockState.is(Blocks.PODZOL) || blockState.is(Blocks.FARMLAND) || blockState.is((ModBlocks.BLUELEAF_GRASS_BLOCK.get())) || blockState.is((ModBlocks.BLUELEAF_DIRT.get()));
    }
}
