package hal.hem.data;

import hal.hem.HEM;
import hal.hem.registry.ModBlocks;
import net.minecraft.block.*;
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
/*
        saplingBlock(ModBlocks.BLUELEAF_SAPLING.get());
        saplingBlock(ModBlocks.SILVERWOOD_SAPLING.get());
        saplingBlock(ModBlocks.ROSEWOOD_SAPLING.get());
        saplingBlock(ModBlocks.DUSKWOOD_SAPLING.get());


        woodBlocks(ModBlocks.BLUELEAF_LOG.get(), ModBlocks.BLUELEAF_PLANKS.get(), ModBlocks.BLUELEAF_SLAB.get(), ModBlocks.BLUELEAF_STAIRS.get(), ModBlocks.BLUELEAF_FENCE.get(), ModBlocks.BLUELEAF_FENCE_GATE.get(), ModBlocks.BLUELEAF_TRAPDOOR.get(), ModBlocks.BLUELEAF_WALL.get());
        
        woodBlocks(ModBlocks.SILVERWOOD_LOG.get(), ModBlocks.SILVERWOOD_PLANKS.get(), ModBlocks.SILVERWOOD_SLAB.get(), ModBlocks.SILVERWOOD_STAIRS.get(), ModBlocks.SILVERWOOD_FENCE.get(), ModBlocks.SILVERWOOD_FENCE_GATE.get(), ModBlocks.SILVERWOOD_TRAPDOOR.get(), ModBlocks.SILVERWOOD_WALL.get());
        
        woodBlocks(ModBlocks.ROSEWOOD_LOG.get(), ModBlocks.ROSEWOOD_PLANKS.get(), ModBlocks.ROSEWOOD_SLAB.get(), ModBlocks.ROSEWOOD_STAIRS.get(), ModBlocks.ROSEWOOD_FENCE.get(), ModBlocks.ROSEWOOD_FENCE_GATE.get(), ModBlocks.ROSEWOOD_TRAPDOOR.get(), ModBlocks.ROSEWOOD_WALL.get());
        
        woodBlocks(ModBlocks.DUSKWOOD_LOG.get(), ModBlocks.DUSKWOOD_PLANKS.get(), ModBlocks.DUSKWOOD_SLAB.get(), ModBlocks.DUSKWOOD_STAIRS.get(), ModBlocks.DUSKWOOD_FENCE.get(), ModBlocks.DUSKWOOD_FENCE_GATE.get(), ModBlocks.DUSKWOOD_TRAPDOOR.get(), ModBlocks.DUSKWOOD_WALL.get());
*/
/*        wallBlock(ModBlocks.BLUELEAF_WALL.get(), modLoc("block/" + ModBlocks.BLUELEAF_LOG.get().getRegistryName().getPath()));
        wallBlock(ModBlocks.SILVERWOOD_WALL.get(), modLoc("block/" + ModBlocks.SILVERWOOD_LOG.get().getRegistryName().getPath()));
        wallBlock(ModBlocks.DUSKWOOD_WALL.get(), modLoc("block/" + ModBlocks.DUSKWOOD_LOG.get().getRegistryName().getPath()));
        wallBlock(ModBlocks.ROSEWOOD_WALL.get(), modLoc("block/" + ModBlocks.ROSEWOOD_LOG.get().getRegistryName().getPath()));*/


    }

    private void saplingBlock(Block sapling) {
        simpleBlock(sapling, models().cross(sapling.getRegistryName().getPath(), modLoc("block/" + sapling.getRegistryName().getPath())));
    }

    private void woodBlocks(RotatedPillarBlock log, Block planks, SlabBlock slab, StairsBlock stairs, FenceBlock fence, FenceGateBlock gate, TrapDoorBlock trapdoor, WallBlock wall) {
        logBlock(log);
        ResourceLocation planksTex = modLoc("block/" + planks.getRegistryName().getPath());
        simpleBlock(planks);
        slabBlock(slab, planksTex, planksTex);
        stairsBlock(stairs, planksTex);
        fenceBlock(fence, planksTex);
        fenceGateBlock(gate, planksTex);
        trapdoorBlock(trapdoor, modLoc("block/" + trapdoor.getRegistryName().getPath()), true);
        wallBlock(wall, planksTex);
    }
}
