package hal.hem.registry;

import hal.hem.HEMCommon;
import hal.hem.block.*;
import hal.hem.block.extra.ExtraSaplingBlock;
import hal.hem.block.extra.ExtraStairBlock;
import hal.hem.block.extra.ExtraTrapDoorBlock;
import me.shedaniel.architectury.registry.DeferredRegister;
import me.shedaniel.architectury.registry.RegistrySupplier;
import net.minecraft.core.Registry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(HEMCommon.MOD_ID, Registry.BLOCK_REGISTRY);

    // PROPERTIES
    static BlockBehaviour.Properties planks = BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS);
    static BlockBehaviour.Properties log = BlockBehaviour.Properties.copy(Blocks.OAK_LOG);
    static BlockBehaviour.Properties leaves = BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).lightLevel((light) -> 1);
    static BlockBehaviour.Properties crystal = BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_PURPLE).strength(1.0F).sound(SoundType.GLASS).noOcclusion();

    // ENVIRONMENT
    public static final RegistrySupplier<Block> BLUELEAF_GRASS_BLOCK = registerBlock("blueleaf_grass_block", BlueleafGrassBlock::new);
    public static final RegistrySupplier<BlueleafBushBlock> BLUELEAF_BUSH = registerBlock("blueleaf_bush", BlueleafBushBlock::new);
    public static final RegistrySupplier<Block> BLUELEAF_DIRT = registerBlock("blueleaf_dirt", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    public static final RegistrySupplier<Block> COARSE_BLUELEAF_DIRT = registerBlock("coarse_blueleaf_dirt", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIRT)));
    public static final RegistrySupplier<BlueleafTallGrassBlock> BLUELEAF_TALL_GRASS = registerBlock("blueleaf_tall_grass", BlueleafTallGrassBlock::new);
    public static final RegistrySupplier<BlueleafTallGrassBlock> BLUELEAF_MEDIUM_GRASS = registerBlock("blueleaf_medium_grass", BlueleafTallGrassBlock::new);
    public static final RegistrySupplier<BlueleafTallGrassBlock> BLUELEAF_SHORT_GRASS = registerBlock("blueleaf_short_grass", BlueleafTallGrassBlock::new);
    public static final RegistrySupplier<FloweringLilyBlock> FLOWERING_LILY = BLOCKS.register("flowering_lily", FloweringLilyBlock::new);
    public static final RegistrySupplier<BlueleafPlantBlock> SMALL_BLOSSOM = registerBlock("small_blossom", BlueleafPlantBlock::new);
    public static final RegistrySupplier<BlueleafPlantBlock> GIANT_BLOSSOM = registerBlock("giant_blossom", BlueleafPlantBlock::new);
    public static final RegistrySupplier<BlueleafPlantBlock> BLUELEAF_MUSHROOM = registerBlock("blueleaf_mushroom", BlueleafPlantBlock::new);
    public static final RegistrySupplier<BlueleafPlantBlock> TALL_BLUELEAF_FLOWER = registerBlock("tall_blueleaf_flower", BlueleafPlantBlock::new);
    public static final RegistrySupplier<BronziumCrystalBlock> BRONZIUM_CRYSTAL = registerBlock("bronzium_crystal", BronziumCrystalBlock::new);
    public static final RegistrySupplier<Block> ROSE_COPPER_ORE = registerBlock("rose_copper_ore", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE)));
    public static final RegistrySupplier<BlueleafWheatBlock> BLUELEAF_WHEAT = registerBlock("blueleaf_wheat", BlueleafWheatBlock::new);
    public static final RegistrySupplier<Block> BLUEROCK = registerBlock("bluerock", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistrySupplier<SlabBlock> BLUEROCK_SLAB = registerBlock("bluerock_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)));
    public static final RegistrySupplier<StairBlock> BLUEROCK_STAIRS = registerBlock("bluerock_stairs", () -> new ExtraStairBlock(Blocks.STONE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)));
    public static final RegistrySupplier<Block> COBBLED_BLUEROCK = registerBlock("cobbled_bluerock", () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));
    public static final RegistrySupplier<SlabBlock> COBBLED_BLUEROCK_SLAB = registerBlock("cobbled_bluerock_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_SLAB)));
    public static final RegistrySupplier<StairBlock> COBBLED_BLUEROCK_STAIRS = registerBlock("cobbled_bluerock_stairs", () -> new ExtraStairBlock(Blocks.COBBLESTONE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_STAIRS)));
    public static final RegistrySupplier<WallBlock> COBBLED_BLUEROCK_WALL = registerBlock("cobbled_bluerock_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE_WALL)));

    // BLUELEAF WOOD
    public static final RegistrySupplier<LeavesBlock> BLUELEAVES = registerBlock("blueleaves", () -> new LeavesBlock(leaves));
    public static final RegistrySupplier<LeavesBlock> FLOWERING_BLUELEAVES = registerBlock("flowering_blueleaves", () -> new LeavesBlock(leaves));
    public static final RegistrySupplier<RotatedPillarBlock> BLUELEAF_LOG = registerBlock("blueleaf_log", () -> new RotatedPillarBlock(log));
    public static final RegistrySupplier<SaplingBlock> BLUELEAF_SAPLING = registerBlock("blueleaf_sapling", () -> new ExtraSaplingBlock(new OakTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistrySupplier<SmallTreeBlock> SMALL_BLUELEAF_TREE_TOP = registerBlock("small_blueleaf_tree_top", SmallTreeBlock::new);
    public static final RegistrySupplier<SmallTreeBlock> SMALL_BLUELEAF_TREE_MIDDLE = registerBlock("small_blueleaf_tree_middle", SmallTreeBlock::new);
    public static final RegistrySupplier<SmallTreeBlock> SMALL_BLUELEAF_TREE_MIDDLE_LEAVES = registerBlock("small_blueleaf_tree_middle_leaves", SmallTreeBlock::new);
    public static final RegistrySupplier<SmallTreeBlock> SMALL_BLUELEAF_TREE_BOTTOM = registerBlock("small_blueleaf_tree_bottom", SmallTreeBlock::new);
    public static final RegistrySupplier<Block> BLUELEAF_PLANKS = registerBlock("blueleaf_planks", () -> new Block(planks));
    public static final RegistrySupplier<SlabBlock> BLUELEAF_SLAB = registerBlock("blueleaf_slab", () -> new SlabBlock(planks));
    public static final RegistrySupplier<StairBlock> BLUELEAF_STAIRS = registerBlock("blueleaf_stairs", () -> new ExtraStairBlock(Blocks.OAK_PLANKS.defaultBlockState(), planks));
    public static final RegistrySupplier<FenceBlock> BLUELEAF_FENCE = registerBlock("blueleaf_fence", () -> new FenceBlock(planks));
    public static final RegistrySupplier<FenceGateBlock> BLUELEAF_FENCE_GATE = registerBlock("blueleaf_fence_gate", () -> new FenceGateBlock(planks));
    public static final RegistrySupplier<TrapDoorBlock> BLUELEAF_TRAPDOOR = registerBlock("blueleaf_trapdoor", () -> new ExtraTrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)));
    public static final RegistrySupplier<WallBlock> BLUELEAF_WALL = registerBlock("blueleaf_wall", () -> new WallBlock(planks));
    public static final RegistrySupplier<BluelampBlock> BLUELAMP = registerBlock("bluelamp", BluelampBlock::new);

    // SILVERWOOD
    public static final RegistrySupplier<RotatedPillarBlock> SILVERWOOD_LOG = registerBlock("silverwood_log", () -> new RotatedPillarBlock(log));
    public static final RegistrySupplier<SaplingBlock> SILVERWOOD_SAPLING = registerBlock("silverwood_sapling", () -> new ExtraSaplingBlock(new OakTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistrySupplier<SmallTreeBlock> SMALL_SILVERWOOD_TREE_TOP = registerBlock("small_silverwood_tree_top", SmallTreeBlock::new);
    public static final RegistrySupplier<SmallTreeBlock> SMALL_SILVERWOOD_TREE_MIDDLE = registerBlock("small_silverwood_tree_middle", SmallTreeBlock::new);
    public static final RegistrySupplier<Block> SILVERWOOD_PLANKS = registerBlock("silverwood_planks", () -> new Block(planks));
    public static final RegistrySupplier<SlabBlock> SILVERWOOD_SLAB = registerBlock("silverwood_slab", () -> new SlabBlock(planks));
    public static final RegistrySupplier<StairBlock> SILVERWOOD_STAIRS = registerBlock("silverwood_stairs", () -> new ExtraStairBlock(Blocks.OAK_PLANKS.defaultBlockState(), planks));
    public static final RegistrySupplier<FenceBlock> SILVERWOOD_FENCE = registerBlock("silverwood_fence", () -> new FenceBlock(planks));
    public static final RegistrySupplier<FenceGateBlock> SILVERWOOD_FENCE_GATE = registerBlock("silverwood_fence_gate", () -> new FenceGateBlock(planks));
    public static final RegistrySupplier<TrapDoorBlock> SILVERWOOD_TRAPDOOR = registerBlock("silverwood_trapdoor", () -> new ExtraTrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)));
    public static final RegistrySupplier<WallBlock> SILVERWOOD_WALL = registerBlock("silverwood_wall", () -> new WallBlock(planks));

    // DUSKWOOD
    public static final RegistrySupplier<LeavesBlock> DUSKWOOD_LEAVES = registerBlock("duskwood_leaves", () -> new LeavesBlock(leaves));
    public static final RegistrySupplier<RotatedPillarBlock> DUSKWOOD_LOG = registerBlock("duskwood_log", () -> new RotatedPillarBlock(log));
    public static final RegistrySupplier<SaplingBlock> DUSKWOOD_SAPLING = registerBlock("duskwood_sapling", () -> new ExtraSaplingBlock(new OakTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistrySupplier<Block> DUSKWOOD_PLANKS = registerBlock("duskwood_planks", () -> new Block(planks));
    public static final RegistrySupplier<SlabBlock> DUSKWOOD_SLAB = registerBlock("duskwood_slab", () -> new SlabBlock(planks));
    public static final RegistrySupplier<StairBlock> DUSKWOOD_STAIRS = registerBlock("duskwood_stairs", () -> new ExtraStairBlock(Blocks.OAK_PLANKS.defaultBlockState(), planks));
    public static final RegistrySupplier<FenceBlock> DUSKWOOD_FENCE = registerBlock("duskwood_fence", () -> new FenceBlock(planks));
    public static final RegistrySupplier<FenceGateBlock> DUSKWOOD_FENCE_GATE = registerBlock("duskwood_fence_gate", () -> new FenceGateBlock(planks));
    public static final RegistrySupplier<TrapDoorBlock> DUSKWOOD_TRAPDOOR = registerBlock("duskwood_trapdoor", () -> new ExtraTrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)));
    public static final RegistrySupplier<WallBlock> DUSKWOOD_WALL = registerBlock("duskwood_wall", () -> new WallBlock(planks));

    // ROSEWOOD
    public static final RegistrySupplier<RotatedPillarBlock> ROSEWOOD_LOG = registerBlock("rosewood_log", () -> new RotatedPillarBlock(log));
    public static final RegistrySupplier<SaplingBlock> ROSEWOOD_SAPLING = registerBlock("rosewood_sapling", () -> new ExtraSaplingBlock(new OakTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));
    public static final RegistrySupplier<Block> ROSEWOOD_PLANKS = registerBlock("rosewood_planks", () -> new Block(planks));
    public static final RegistrySupplier<SlabBlock> ROSEWOOD_SLAB = registerBlock("rosewood_slab", () -> new SlabBlock(planks));
    public static final RegistrySupplier<StairBlock> ROSEWOOD_STAIRS = registerBlock("rosewood_stairs", () -> new ExtraStairBlock(Blocks.OAK_PLANKS.defaultBlockState(), planks));
    public static final RegistrySupplier<FenceBlock> ROSEWOOD_FENCE = registerBlock("rosewood_fence", () -> new FenceBlock(planks));
    public static final RegistrySupplier<FenceGateBlock> ROSEWOOD_FENCE_GATE = registerBlock("rosewood_fence_gate", () -> new FenceGateBlock(planks));
    public static final RegistrySupplier<TrapDoorBlock> ROSEWOOD_TRAPDOOR = registerBlock("rosewood_trapdoor", () -> new ExtraTrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR)));
    public static final RegistrySupplier<WallBlock> ROSEWOOD_WALL = registerBlock("rosewood_wall", () -> new WallBlock(planks));

    // HARDENED WOOD & CRYSTALS
    public static final RegistrySupplier<RotatedPillarBlock> HARDENED_LOG = registerBlock("hardened_log", () -> new RotatedPillarBlock(log));
    public static final RegistrySupplier<RotatedPillarBlock> CRYSTALIZED_HARDENED_LOG = registerBlock("crystalized_hardened_log", () -> new RotatedPillarBlock(log));
    public static final RegistrySupplier<Block> PURPLE_CRYSTAL_BLOCK = registerBlock("purple_crystal_block", () -> new Block(crystal));
    public static final RegistrySupplier<Block> PINK_CRYSTAL_BLOCK = registerBlock("pink_crystal_block", () -> new Block(crystal));
    public static final RegistrySupplier<Block> LIGHT_PINK_CRYSTAL_BLOCK = registerBlock("light_pink_crystal_block", () -> new Block(crystal));
    public static final RegistrySupplier<Block> WHITE_CRYSTAL_BLOCK = registerBlock("white_crystal_block", () -> new Block(crystal));
    public static final RegistrySupplier<WallBlock> PURPLE_CRYSTAL_WALL = registerBlock("purple_crystal_wall", () -> new WallBlock(crystal));
    public static final RegistrySupplier<WallBlock> PINK_CRYSTAL_WALL = registerBlock("pink_crystal_wall", () -> new WallBlock(crystal));
    public static final RegistrySupplier<WallBlock> LIGHT_PINK_CRYSTAL_WALL = registerBlock("light_pink_crystal_wall", () -> new WallBlock(crystal));
    public static final RegistrySupplier<WallBlock> WHITE_CRYSTAL_WALL = registerBlock("white_crystal_wall", () -> new WallBlock(crystal));
    public static final RegistrySupplier<StainedGlassPaneBlock> PURPLE_CRYSTAL_PANE = registerBlock("purple_crystal_pane", () -> new StainedGlassPaneBlock(DyeColor.PURPLE, crystal));
    public static final RegistrySupplier<StainedGlassPaneBlock> PINK_CRYSTAL_PANE = registerBlock("pink_crystal_pane", () -> new StainedGlassPaneBlock(DyeColor.PINK, crystal));
    public static final RegistrySupplier<StainedGlassPaneBlock> LIGHT_PINK_CRYSTAL_PANE = registerBlock("light_pink_crystal_pane", () -> new StainedGlassPaneBlock(DyeColor.PINK, crystal));
    public static final RegistrySupplier<StainedGlassPaneBlock> WHITE_CRYSTAL_PANE = registerBlock("white_crystal_pane", () -> new StainedGlassPaneBlock(DyeColor.WHITE, crystal));

    // GENERATOR
    public static final RegistrySupplier<GeneratorPipeBlock> GENERATOR_PIPE = registerBlock("generator_pipe", GeneratorPipeBlock::new);
    public static final RegistrySupplier<TransporterBlock> TRANSPORTER = registerBlock("transporter", TransporterBlock::new);
    public static final RegistrySupplier<GeneratorBlock> GENERATOR = registerBlock("generator", GeneratorBlock::new);
    public static final RegistrySupplier<T1ComputerBlock> T1_COMPUTER = registerBlock("t1_computer", T1ComputerBlock::new);

    private static <T extends Block> RegistrySupplier<T> registerBlock(String name, Supplier<T> block) {
        RegistrySupplier<T> toReturn = ModBlocks.BLOCKS.register(name, block);
        ModItems.ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties().tab(HEMCommon.TAB)));
        return toReturn;
    }
}