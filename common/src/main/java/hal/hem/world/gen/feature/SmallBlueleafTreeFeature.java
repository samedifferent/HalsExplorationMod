package hal.hem.world.gen.feature;

import com.mojang.serialization.Codec;
import hal.hem.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Random;

public class SmallBlueleafTreeFeature extends Feature<NoneFeatureConfiguration> {
    public SmallBlueleafTreeFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(WorldGenLevel reader, ChunkGenerator generator, Random random, BlockPos pos, NoneFeatureConfiguration config) {
        BlockState BOTTOM = ModBlocks.SMALL_BLUELEAF_TREE_BOTTOM.get().defaultBlockState();
        BlockState MIDDLE = ModBlocks.SMALL_BLUELEAF_TREE_MIDDLE.get().defaultBlockState();
        BlockState LEAVES = ModBlocks.SMALL_BLUELEAF_TREE_MIDDLE_LEAVES.get().defaultBlockState();
        BlockState TOP = ModBlocks.SMALL_BLUELEAF_TREE_TOP.get().defaultBlockState();

        if (reader.isStateAtPosition(pos.below(), blockState -> blockState.is(ModBlocks.BLUELEAF_GRASS_BLOCK.get())) || reader.isStateAtPosition(pos.below(), blockState -> blockState.is(ModBlocks.COARSE_BLUELEAF_DIRT.get()))) {
            int trunkHeight = random.nextInt(4);
            setBlock(reader, pos, BOTTOM);
            for (int i = 0; i < trunkHeight; i++) {
                setBlock(reader, pos.above(1 + i), MIDDLE);
            }
            setBlock(reader, pos.above(trunkHeight + 1), LEAVES);
            setBlock(reader, pos.above(trunkHeight + 2), TOP);
        }

        return false;
    }
}
