package hal.hem.data;

import hal.hem.HEM;
import hal.hem.registry.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class ItemModelGenerator extends ItemModelProvider {

    public ItemModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, HEM.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        toBlock(ModBlocks.BLUELEAF_DIRT);
        toBlock(ModBlocks.BLUELEAF_PLANKS);
        blockToItemGenerated(ModBlocks.BLUELEAF_SAPLING);
    }

    private void toBlock(RegistryObject block) {
        withExistingParent(block.getId().getPath(), modLoc("block/" + block.getId().getPath()));
    }

    private ItemModelBuilder blockToItemGenerated(RegistryObject block) {
        return getBuilder(block.getId().getPath()).parent(getExistingFile(mcLoc("item/generated"))).texture("layer0", "block" + "/" + block.getId().getPath());
    }

    private ItemModelBuilder itemGenerated (RegistryObject item) {
        return getBuilder(item.getId().getPath()).parent(getExistingFile(mcLoc("item/generated"))).texture("layer0", "item" + "/" + item.getId().getPath());
    }
}
