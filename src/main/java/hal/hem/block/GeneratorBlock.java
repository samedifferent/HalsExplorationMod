package hal.hem.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class GeneratorBlock extends HorizontalBlock {
    public GeneratorBlock() {
        super(AbstractBlock.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).noOcclusion().sound(SoundType.METAL).lightLevel((light) -> 1));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState p_180655_1_, World p_180655_2_, BlockPos p_180655_3_, Random p_180655_4_) {
        double d0 = (double)p_180655_3_.getX() + 0.5D;
        double d1 = (double)p_180655_3_.getY() + 0.7D;
        double d2 = (double)p_180655_3_.getZ() + 0.5D;
        p_180655_2_.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        return this.defaultBlockState().setValue(FACING, p_196258_1_.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(FACING);
    }
}
