package hal.hem.registry;

import hal.hem.HEM;
import hal.hem.block.BlueleafBushBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.trees.OakTree;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, HEM.MOD_ID);

    static AbstractBlock.Properties planks = AbstractBlock.Properties.copy(Blocks.OAK_PLANKS);
    static AbstractBlock.Properties log = AbstractBlock.Properties.copy(Blocks.OAK_LOG);
    static AbstractBlock.Properties leaves = AbstractBlock.Properties.copy(Blocks.OAK_LEAVES);

    // BLUELEAF BIOME
    public static final RegistryObject<Block> BLUELEAF_GRASS = registerBlock("blueleaf_grass", () -> new Block(AbstractBlock.Properties.of(Material.GRASS).strength(0.6F).sound(SoundType.GRASS)));
    public static final RegistryObject<BlueleafBushBlock> BLUELEAF_BUSH_BLOCK = registerBlock("blueleaf_bush", BlueleafBushBlock::new);
    public static final RegistryObject<Block> BLUELEAF_DIRT = registerBlock("blueleaf_dirt", () -> new Block(AbstractBlock.Properties.copy(Blocks.DIRT)));

    // SILVERWOOD
    public static final RegistryObject<RotatedPillarBlock> SILVERWOOD_LOG = registerBlock("silverwood_log", () -> new RotatedPillarBlock(log));
    public static final RegistryObject<SaplingBlock> SILVERWOOD_SAPLING = registerBlock("silverwood_sapling", () -> new SaplingBlock(new OakTree(), AbstractBlock.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> SILVERWOOD_PLANKS = registerBlock("silverwood_planks", () -> new Block(planks));
    public static final RegistryObject<SlabBlock> SILVERWOOD_SLAB = registerBlock("silverwood_slab", () -> new SlabBlock(planks));
    public static final RegistryObject<StairsBlock> SILVERWOOD_STAIRS = registerBlock("silverwood_stairs", () -> new StairsBlock(Blocks.OAK_PLANKS::defaultBlockState, planks));
    public static final RegistryObject<FenceBlock> SILVERWOOD_FENCE = registerBlock("silverwood_fence", () -> new FenceBlock(planks));
    public static final RegistryObject<FenceGateBlock> SILVERWOOD_FENCE_GATE = registerBlock("silverwood_fence_gate", () -> new FenceGateBlock(planks));
    public static final RegistryObject<TrapDoorBlock> SILVERWOOD_TRAPDOOR = registerBlock("silverwood_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.copy(Blocks.OAK_TRAPDOOR)));
    public static final RegistryObject<WallBlock> SILVERWOOD_WALL = registerBlock("silverwood_wall", () -> new WallBlock(planks));
    
    // BLUELEAF WOOD
    public static final RegistryObject<RotatedPillarBlock> BLUELEAF_LOG = registerBlock("blueleaf_log", () -> new RotatedPillarBlock(log));
    public static final RegistryObject<LeavesBlock> BLUELEAVES = registerBlock("blueleaves", () -> new LeavesBlock(leaves));
    public static final RegistryObject<LeavesBlock> FLOWERING_BLUELEAVES = registerBlock("flowering_blueleaves", () -> new LeavesBlock(leaves));
    public static final RegistryObject<SaplingBlock> BLUELEAF_SAPLING = registerBlock("blueleaf_sapling", () -> new SaplingBlock(new OakTree(), AbstractBlock.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> BLUELEAF_PLANKS = registerBlock("blueleaf_planks", () -> new Block(planks));
    public static final RegistryObject<SlabBlock> BLUELEAF_SLAB = registerBlock("blueleaf_slab", () -> new SlabBlock(planks));
    public static final RegistryObject<StairsBlock> BLUELEAF_STAIRS = registerBlock("blueleaf_stairs", () -> new StairsBlock(Blocks.OAK_PLANKS::defaultBlockState, planks));
    public static final RegistryObject<FenceBlock> BLUELEAF_FENCE = registerBlock("blueleaf_fence", () -> new FenceBlock(planks));
    public static final RegistryObject<FenceGateBlock> BLUELEAF_FENCE_GATE = registerBlock("blueleaf_fence_gate", () -> new FenceGateBlock(planks));
    public static final RegistryObject<TrapDoorBlock> BLUELEAF_TRAPDOOR = registerBlock("blueleaf_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.copy(Blocks.OAK_TRAPDOOR)));
    public static final RegistryObject<WallBlock> BLUELEAF_WALL = registerBlock("blueleaf_wall", () -> new WallBlock(planks));

    // DARK PINE WOOD
    public static final RegistryObject<RotatedPillarBlock> DUSKWOOD_LOG = registerBlock("dark_pine_log", () -> new RotatedPillarBlock(log));
    public static final RegistryObject<SaplingBlock> DUSKWOOD_SAPLING = registerBlock("dark_pine_sapling", () -> new SaplingBlock(new OakTree(), AbstractBlock.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> DUSKWOOD_PLANKS = registerBlock("dark_pine_planks", () -> new Block(planks));
    public static final RegistryObject<SlabBlock> DUSKWOOD_SLAB = registerBlock("dark_pine_slab", () -> new SlabBlock(planks));
    public static final RegistryObject<StairsBlock> DUSKWOOD_STAIRS = registerBlock("dark_pine_stairs", () -> new StairsBlock(Blocks.OAK_PLANKS::defaultBlockState, planks));
    public static final RegistryObject<FenceBlock> DUSKWOOD_FENCE = registerBlock("dark_pine_fence", () -> new FenceBlock(planks));
    public static final RegistryObject<FenceGateBlock> DUSKWOOD_FENCE_GATE = registerBlock("dark_pine_fence_gate", () -> new FenceGateBlock(planks));
    public static final RegistryObject<TrapDoorBlock> DUSKWOOD_TRAPDOOR = registerBlock("dark_pine_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.copy(Blocks.OAK_TRAPDOOR)));
    public static final RegistryObject<WallBlock> DUSKWOOD_WALL = registerBlock("dark_pine_wall", () -> new WallBlock(planks));

    // RUBYWOOD
    public static final RegistryObject<RotatedPillarBlock> ROSEWOOD_LOG = registerBlock("rubywood_log", () -> new RotatedPillarBlock(log));
    public static final RegistryObject<SaplingBlock> ROSEWOOD_SAPLING = registerBlock("rubywood_sapling", () -> new SaplingBlock(new OakTree(), AbstractBlock.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> ROSEWOOD_PLANKS = registerBlock("rubywood_planks", () -> new Block(planks));
    public static final RegistryObject<SlabBlock> ROSEWOOD_SLAB = registerBlock("rubywood_slab", () -> new SlabBlock(planks));
    public static final RegistryObject<StairsBlock> ROSEWOOD_STAIRS = registerBlock("rubywood_stairs", () -> new StairsBlock(Blocks.OAK_PLANKS::defaultBlockState, planks));
    public static final RegistryObject<FenceBlock> ROSEWOOD_FENCE = registerBlock("rubywood_fence", () -> new FenceBlock(planks));
    public static final RegistryObject<FenceGateBlock> ROSEWOOD_FENCE_GATE = registerBlock("rubywood_fence_gate", () -> new FenceGateBlock(planks));
    public static final RegistryObject<TrapDoorBlock> ROSEWOOD_TRAPDOOR = registerBlock("rubywood_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.copy(Blocks.OAK_TRAPDOOR)));
    public static final RegistryObject<WallBlock> ROSEWOOD_WALL = registerBlock("rubywood_wall", () -> new WallBlock(planks));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = ModBlocks.BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties().tab(HEM.GROUP)));
        return toReturn;
    }
}