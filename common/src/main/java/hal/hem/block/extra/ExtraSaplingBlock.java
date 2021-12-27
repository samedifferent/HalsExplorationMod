package hal.hem.block.extra;

import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;

public class ExtraSaplingBlock extends SaplingBlock {

    // This is just to get around the protected constructor
    public ExtraSaplingBlock(AbstractTreeGrower abstractTreeGrower, Properties properties) {
        super(abstractTreeGrower, properties);
    }
}
