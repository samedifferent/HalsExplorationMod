package hal.hem.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.Random;

public class GeneratorBlock extends HorizontalDirectionalBlock {
    public GeneratorBlock() {
        super(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).noOcclusion().sound(SoundType.METAL).lightLevel((light) -> 1));
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, Random random) {
        double x = blockPos.getX() + 0.5D;
        double y = blockPos.getY() + 0.7D;
        double z = blockPos.getZ() + 0.5D;
        level.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, x, y, z, 0.0D, 0.0D, 0.0D);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
