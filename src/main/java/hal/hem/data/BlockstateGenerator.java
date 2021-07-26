package hal.hem.data;

import hal.hem.HEM;
import hal.hem.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockstateGenerator extends BlockStateProvider {
    public BlockstateGenerator(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, HEM.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        saplingBlock(ModBlocks.BLUELEAF_SAPLING.get());
        logBlock(ModBlocks.BLUELEAF_LOG.get());
        simpleBlock(ModBlocks.BLUELEAF_DIRT.get());
        logBlock(ModBlocks.BLUELEAF_PINE_LOG.get());
    }

    private void saplingBlock(Block sapling) {
        simpleBlock(sapling, models().cross(sapling.getRegistryName().getPath(), modLoc("block/" + sapling.getRegistryName().getPath())));
    }

    private void woodBlocks(Block planks, SlabBlock slab, StairsBlock stairs, FenceBlock fence) {
        ResourceLocation planksTex = modLoc("block/" + planks.getRegistryName().getPath());
        simpleBlock(planks);
        slabBlock(slab, planksTex, planksTex);
        stairsBlock(stairs, planksTex);
        fenceBlock(fence, planksTex);
    }
}
