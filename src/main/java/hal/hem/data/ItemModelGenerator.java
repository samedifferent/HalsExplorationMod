package hal.hem.data;

import hal.hem.HEM;
import hal.hem.registry.ModBlocks;
import hal.hem.registry.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class ItemModelGenerator extends ItemModelProvider {

    public ItemModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, HEM.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
/*        toBlock(ModBlocks.CRYSTALIZED_HARDENED_LOG);
        toBlock(ModBlocks.HARDENED_LOG);*/

/*        itemGenerated(ModItems.BRONZIUM_INGOT);
        itemGenerated(ModItems.COPPARITE_INGOT);
        itemGenerated(ModItems.ROSE_COPPER_INGOT);*/

/*        blockToItemGenerated(ModBlocks.BLUELEAF_SHORT_GRASS);
        blockToItemGenerated(ModBlocks.BLUELEAF_MEDIUM_GRASS);
        blockToItemGenerated(ModBlocks.BLUELEAF_TALL_GRASS);*/

/*        toBlock(ModBlocks.ROSE_COPPER_ORE);
        toBlock(ModBlocks.BLUEROCK);
        toBlock(ModBlocks.BLUEROCK_SLAB);
        toBlock(ModBlocks.BLUEROCK_STAIRS);
        toBlock(ModBlocks.COBBLED_BLUEROCK);
        toBlock(ModBlocks.COBBLED_BLUEROCK_SLAB);
        toBlock(ModBlocks.COBBLED_BLUEROCK_STAIRS);
        wall(ModBlocks.COBBLED_BLUEROCK_WALL, ModBlocks.COBBLED_BLUEROCK);*/

/*        blockToItemGenerated(ModBlocks.BLUELEAF_SAPLING);
        blockToItemGenerated(ModBlocks.SILVERWOOD_SAPLING);
        blockToItemGenerated(ModBlocks.DUSKWOOD_SAPLING);
        blockToItemGenerated(ModBlocks.ROSEWOOD_SAPLING);
        itemGenerated(ModItems.AIRSHIP);*/

/*        toBlock(ModBlocks.BLUELEAF_GRASS_BLOCK);
        toBlock(ModBlocks.BLUELEAF_DIRT);*/

/*        toBlock(ModBlocks.BLUELEAF_LOG);
        toBlock(ModBlocks.BLUELEAF_PLANKS);
        toBlock(ModBlocks.BLUELEAF_SLAB);
        toBlock(ModBlocks.BLUELEAF_STAIRS);
        fence(ModBlocks.BLUELEAF_FENCE, ModBlocks.BLUELEAF_PLANKS);
        toBlock(ModBlocks.BLUELEAF_FENCE_GATE);
        trapdoor(ModBlocks.BLUELEAF_TRAPDOOR);
        wall(ModBlocks.BLUELEAF_WALL, ModBlocks.BLUELEAF_PLANKS);*/

 /*       toBlock(ModBlocks.SILVERWOOD_LOG);
        toBlock(ModBlocks.SILVERWOOD_PLANKS);
        toBlock(ModBlocks.SILVERWOOD_SLAB);
        toBlock(ModBlocks.SILVERWOOD_STAIRS);
        fence(ModBlocks.SILVERWOOD_FENCE, ModBlocks.SILVERWOOD_PLANKS);
        toBlock(ModBlocks.SILVERWOOD_FENCE_GATE);
        trapdoor(ModBlocks.SILVERWOOD_TRAPDOOR);
        wall(ModBlocks.SILVERWOOD_WALL, ModBlocks.SILVERWOOD_PLANKS);

        toBlock(ModBlocks.DUSKWOOD_LOG);
        toBlock(ModBlocks.DUSKWOOD_PLANKS);
        toBlock(ModBlocks.DUSKWOOD_SLAB);
        toBlock(ModBlocks.DUSKWOOD_STAIRS);
        fence(ModBlocks.DUSKWOOD_FENCE, ModBlocks.DUSKWOOD_PLANKS);
        toBlock(ModBlocks.DUSKWOOD_FENCE_GATE);
        trapdoor(ModBlocks.DUSKWOOD_TRAPDOOR);
        wall(ModBlocks.DUSKWOOD_WALL, ModBlocks.DUSKWOOD_PLANKS);

        toBlock(ModBlocks.ROSEWOOD_LOG);
        toBlock(ModBlocks.ROSEWOOD_PLANKS);
        toBlock(ModBlocks.ROSEWOOD_SLAB);
        toBlock(ModBlocks.ROSEWOOD_STAIRS);
        fence(ModBlocks.ROSEWOOD_FENCE, ModBlocks.ROSEWOOD_PLANKS);
        toBlock(ModBlocks.ROSEWOOD_FENCE_GATE);
        trapdoor(ModBlocks.ROSEWOOD_TRAPDOOR);
        wall(ModBlocks.ROSEWOOD_WALL, ModBlocks.ROSEWOOD_PLANKS);*/
    }

    private void toBlock(RegistryObject block) {
        withExistingParent(block.getId().getPath(), modLoc("block/" + block.getId().getPath()));
    }

    private ItemModelBuilder blockToItemGenerated(RegistryObject block) {
        return getBuilder(block.getId().getPath()).parent(getExistingFile(mcLoc("item/generated"))).texture("layer0", "block/" + block.getId().getPath());
    }

    private ItemModelBuilder itemGenerated (RegistryObject item) {
        return getBuilder(item.getId().getPath()).parent(getExistingFile(mcLoc("item/generated"))).texture("layer0", "item/" + item.getId().getPath());
    }

    private ItemModelBuilder fence (RegistryObject fence, RegistryObject planks) {
        return getBuilder(fence.getId().getPath()).parent(getExistingFile(mcLoc("block/fence_inventory"))).texture("texture", "block/" + planks.getId().getPath());
    }

    private ItemModelBuilder wall (RegistryObject wall, RegistryObject planks) {
        return getBuilder(wall.getId().getPath()).parent(getExistingFile(mcLoc("block/wall_inventory"))).texture("wall", "block/" + planks.getId().getPath());
    }

    private void trapdoor (RegistryObject trapdoor) {
        withExistingParent(trapdoor.getId().getPath(), modLoc("block/" + trapdoor.getId().getPath() + "_bottom"));
    }
}
