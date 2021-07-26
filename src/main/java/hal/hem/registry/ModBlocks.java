package hal.hem.registry;

import hal.hem.HEM;
import hal.hem.block.BlueleafBushBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.SpruceTree;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, HEM.MOD_ID);

    // BLUELEAF
    public static final RegistryObject<BlueleafBushBlock> BLUELEAF_BUSH_BLOCK = registerBlock("blueleaf_bush", BlueleafBushBlock::new);

    public static final RegistryObject<Block> BLUELEAF_GRASS = registerBlock("blueleaf_grass", () -> new Block(AbstractBlock.Properties.of(Material.GRASS).strength(0.6F).sound(SoundType.GRASS)));
    public static final RegistryObject<SaplingBlock> BLUELEAF_SAPLING = registerBlock("blueleaf_sapling", () -> new SaplingBlock(new SpruceTree(), AbstractBlock.Properties.copy(Blocks.SPRUCE_SAPLING)));
    public static final RegistryObject<LeavesBlock> BLUELEAVES = registerBlock("blueleaves", () -> new LeavesBlock(AbstractBlock.Properties.copy(Blocks.SPRUCE_LEAVES)));
    public static final RegistryObject<RotatedPillarBlock> BLUELEAF_LOG = registerBlock("blueleaf_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.SPRUCE_LOG)));
    public static final RegistryObject<Block> BLUELEAF_DIRT = registerBlock("blueleaf_dirt", () -> new Block(AbstractBlock.Properties.copy(Blocks.DIRT)));
    public static final RegistryObject<Block> BLUELEAF_PLANKS = registerBlock("blueleaf_planks", () -> new Block(AbstractBlock.Properties.copy(Blocks.SPRUCE_PLANKS)));
    public static final RegistryObject<SlabBlock> BLUELEAF_SLAB = registerBlock("blueleaf_slab", () -> new SlabBlock(AbstractBlock.Properties.copy(Blocks.SPRUCE_SLAB)));
    public static final RegistryObject<StairsBlock> BLUELEAF_STAIRS = registerBlock("blueleaf_stairs", () -> new StairsBlock(Blocks.SPRUCE_PLANKS::defaultBlockState, AbstractBlock.Properties.copy(Blocks.SPRUCE_STAIRS)));
    public static final RegistryObject<FenceBlock> BLUELEAF_FENCE = registerBlock("blueleaf_fence", () -> new FenceBlock(AbstractBlock.Properties.copy(Blocks.SPRUCE_FENCE)));
    public static final RegistryObject<FenceGateBlock> BLUELEAF_FENCE_GATE = registerBlock("blueleaf_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.copy(Blocks.SPRUCE_FENCE_GATE)));
    public static final RegistryObject<TrapDoorBlock> BLUELEAF_TRAPDOOR = registerBlock("blueleaf_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.copy(Blocks.SPRUCE_TRAPDOOR)));
    public static final RegistryObject<RotatedPillarBlock> BLUELEAF_PINE_LOG = registerBlock("blueleaf_pine_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(Blocks.SPRUCE_LOG)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = ModBlocks.BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties().tab(HEM.GROUP)));
        return toReturn;
    }
}