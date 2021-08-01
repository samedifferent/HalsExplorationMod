package hal.hem.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class BluelampBlock extends LanternBlock {
    protected static final VoxelShape AABB = VoxelShapes.or(Block.box(4.0D, 0.0D, 4.0D, 12.0D, 12.0D, 12.0D));

    public BluelampBlock() {
        super(AbstractBlock.Properties.of(Material.WOOD).strength(1.5F).sound(SoundType.WOOD).lightLevel((light) -> 10));
    }

    @Override
    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        return AABB;
    }
}
