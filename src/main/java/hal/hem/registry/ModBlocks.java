package hal.hem.registry;

import hal.hem.HEM;
import hal.hem.block.BlueleafBushBlock;
import hal.hem.block.BlueleafWheatBlock;
import hal.hem.block.BronziumCrystalBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.OakTree;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, HEM.MOD_ID);

    // PROPERTIES
    static AbstractBlock.Properties planks = AbstractBlock.Properties.copy(Blocks.OAK_PLANKS);
    static AbstractBlock.Properties log = AbstractBlock.Properties.copy(Blocks.OAK_LOG);
    static AbstractBlock.Properties leaves = AbstractBlock.Properties.copy(Blocks.OAK_LEAVES);

    // ENVIRONMENT
    public static final RegistryObject<Block> BLUELEAF_GRASS_BLOCK = registerBlock("blueleaf_grass_block", () -> new Block(AbstractBlock.Properties.of(Material.GRASS).strength(0.6F).sound(SoundType.GRASS)));
    public static final RegistryObject<BlueleafBushBlock> BLUELEAF_BUSH = registerBlock("blueleaf_bush", BlueleafBushBlock::new);
    public static final RegistryObject<Block> BLUELEAF_DIRT = registerBlock("blueleaf_dirt", () -> new Block(AbstractBlock.Properties.copy(Blocks.DIRT)));
    public static final RegistryObject<BlueleafBushBlock> BLUELEAF_TALL_GRASS = registerBlock("blueleaf_tall_grass", BlueleafBushBlock::new);
    public static final RegistryObject<BlueleafBushBlock> BLUELEAF_MEDIUM_GRASS = registerBlock("blueleaf_medium_grass", BlueleafBushBlock::new);
    public static final RegistryObject<BlueleafBushBlock> BLUELEAF_SHORT_GRASS = registerBlock("blueleaf_short_grass", BlueleafBushBlock::new);
    public static final RegistryObject<BronziumCrystalBlock> BRONZIUM_CRYSTAL = registerBlock("bronzium_crystal", BronziumCrystalBlock::new);
    public static final RegistryObject<Block> ROSE_COPPER_ORE = registerBlock("rose_copper_ore", () -> new Block(AbstractBlock.Properties.copy(Blocks.DIAMOND_ORE)));
    public static final RegistryObject<BlueleafWheatBlock> BLUELEAF_WHEAT = registerBlock("blueleaf_wheat", BlueleafWheatBlock::new);
    public static final RegistryObject<Block> BLUEROCK = registerBlock("bluerock", () -> new Block(AbstractBlock.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<SlabBlock> BLUEROCK_SLAB = registerBlock("bluerock_slab", () -> new SlabBlock(AbstractBlock.Properties.copy(Blocks.STONE_SLAB)));
    public static final RegistryObject<StairsBlock> BLUEROCK_STAIRS = registerBlock("bluerock_stairs", () -> new StairsBlock(Blocks.STONE::defaultBlockState, AbstractBlock.Properties.copy(Blocks.STONE_STAIRS)));
    public static final RegistryObject<Block> COBBLED_BLUEROCK = registerBlock("cobbled_bluerock", () -> new Block(AbstractBlock.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistryObject<SlabBlock> COBBLED_BLUEROCK_SLAB = registerBlock("cobbled_bluerock_slab", () -> new SlabBlock(AbstractBlock.Properties.copy(Blocks.COBBLESTONE_SLAB)));
    public static final RegistryObject<StairsBlock> COBBLED_BLUEROCK_STAIRS = registerBlock("cobbled_bluerock_stairs", () -> new StairsBlock(Blocks.COBBLESTONE::defaultBlockState, AbstractBlock.Properties.copy(Blocks.COBBLESTONE_STAIRS)));
    public static final RegistryObject<WallBlock> COBBLED_BLUEROCK_WALL = registerBlock("cobbled_bluerock_wall", () -> new WallBlock(AbstractBlock.Properties.copy(Blocks.COBBLESTONE_WALL)));

    // BLUELEAF WOOD
    public static final RegistryObject<LeavesBlock> BLUELEAVES = registerBlock("blueleaves", () -> new LeavesBlock(leaves));
    public static final RegistryObject<LeavesBlock> FLOWERING_BLUELEAVES = registerBlock("flowering_blueleaves", () -> new LeavesBlock(leaves));
    public static final RegistryObject<RotatedPillarBlock> BLUELEAF_LOG = registerBlock("blueleaf_log", () -> new RotatedPillarBlock(log));
    public static final RegistryObject<SaplingBlock> BLUELEAF_SAPLING = registerBlock("blueleaf_sapling", () -> new SaplingBlock(new OakTree(), AbstractBlock.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> BLUELEAF_PLANKS = registerBlock("blueleaf_planks", () -> new Block(planks));
    public static final RegistryObject<SlabBlock> BLUELEAF_SLAB = registerBlock("blueleaf_slab", () -> new SlabBlock(planks));
    public static final RegistryObject<StairsBlock> BLUELEAF_STAIRS = registerBlock("blueleaf_stairs", () -> new StairsBlock(Blocks.OAK_PLANKS::defaultBlockState, planks));
    public static final RegistryObject<FenceBlock> BLUELEAF_FENCE = registerBlock("blueleaf_fence", () -> new FenceBlock(planks));
    public static final RegistryObject<FenceGateBlock> BLUELEAF_FENCE_GATE = registerBlock("blueleaf_fence_gate", () -> new FenceGateBlock(planks));
    public static final RegistryObject<TrapDoorBlock> BLUELEAF_TRAPDOOR = registerBlock("blueleaf_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.copy(Blocks.OAK_TRAPDOOR)));
    public static final RegistryObject<WallBlock> BLUELEAF_WALL = registerBlock("blueleaf_wall", () -> new WallBlock(planks));

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

    // DUSKWOOD
    public static final RegistryObject<RotatedPillarBlock> DUSKWOOD_LOG = registerBlock("duskwood_log", () -> new RotatedPillarBlock(log));
    public static final RegistryObject<SaplingBlock> DUSKWOOD_SAPLING = registerBlock("duskwood_sapling", () -> new SaplingBlock(new OakTree(), AbstractBlock.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> DUSKWOOD_PLANKS = registerBlock("duskwood_planks", () -> new Block(planks));
    public static final RegistryObject<SlabBlock> DUSKWOOD_SLAB = registerBlock("duskwood_slab", () -> new SlabBlock(planks));
    public static final RegistryObject<StairsBlock> DUSKWOOD_STAIRS = registerBlock("duskwood_stairs", () -> new StairsBlock(Blocks.OAK_PLANKS::defaultBlockState, planks));
    public static final RegistryObject<FenceBlock> DUSKWOOD_FENCE = registerBlock("duskwood_fence", () -> new FenceBlock(planks));
    public static final RegistryObject<FenceGateBlock> DUSKWOOD_FENCE_GATE = registerBlock("duskwood_fence_gate", () -> new FenceGateBlock(planks));
    public static final RegistryObject<TrapDoorBlock> DUSKWOOD_TRAPDOOR = registerBlock("duskwood_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.copy(Blocks.OAK_TRAPDOOR)));
    public static final RegistryObject<WallBlock> DUSKWOOD_WALL = registerBlock("duskwood_wall", () -> new WallBlock(planks));

    // ROSEWOOD
    public static final RegistryObject<RotatedPillarBlock> ROSEWOOD_LOG = registerBlock("rosewood_log", () -> new RotatedPillarBlock(log));
    public static final RegistryObject<SaplingBlock> ROSEWOOD_SAPLING = registerBlock("rosewood_sapling", () -> new SaplingBlock(new OakTree(), AbstractBlock.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistryObject<Block> ROSEWOOD_PLANKS = registerBlock("rosewood_planks", () -> new Block(planks));
    public static final RegistryObject<SlabBlock> ROSEWOOD_SLAB = registerBlock("rosewood_slab", () -> new SlabBlock(planks));
    public static final RegistryObject<StairsBlock> ROSEWOOD_STAIRS = registerBlock("rosewood_stairs", () -> new StairsBlock(Blocks.OAK_PLANKS::defaultBlockState, planks));
    public static final RegistryObject<FenceBlock> ROSEWOOD_FENCE = registerBlock("rosewood_fence", () -> new FenceBlock(planks));
    public static final RegistryObject<FenceGateBlock> ROSEWOOD_FENCE_GATE = registerBlock("rosewood_fence_gate", () -> new FenceGateBlock(planks));
    public static final RegistryObject<TrapDoorBlock> ROSEWOOD_TRAPDOOR = registerBlock("rosewood_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.copy(Blocks.OAK_TRAPDOOR)));
    public static final RegistryObject<WallBlock> ROSEWOOD_WALL = registerBlock("rosewood_wall", () -> new WallBlock(planks));

    // HARDENED WOOD & CRYSTALS
    public static final RegistryObject<RotatedPillarBlock> HARDENED_LOG = registerBlock("hardened_log", () -> new RotatedPillarBlock(log));
    public static final RegistryObject<RotatedPillarBlock> CRYSTALIZED_HARDENED_LOG = registerBlock("crystalized_hardened_log", () -> new RotatedPillarBlock(log));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = ModBlocks.BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties().tab(HEM.GROUP)));
        return toReturn;
    }
}