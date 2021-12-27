package hal.hem.block.extra;

import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ExtraStairBlock extends StairBlock {

    // This is just to get around the protected constructor
    public ExtraStairBlock(BlockState blockState, Properties properties) {
        super(blockState, properties);
    }
}
