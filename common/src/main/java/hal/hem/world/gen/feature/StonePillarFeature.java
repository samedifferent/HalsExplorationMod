package hal.hem.world.gen.feature;

import com.mojang.serialization.Codec;
import hal.hem.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class StonePillarFeature extends Feature<NoneFeatureConfiguration> {

    public StonePillarFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public static boolean isAirOrLeaves(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, (state) -> state.isAir() || state.is(BlockTags.LEAVES) || state.is(ModBlocks.BLUELEAF_SHORT_GRASS.get()) || state.is(ModBlocks.BLUELEAF_MEDIUM_GRASS.get()) || state.is(ModBlocks.BLUELEAF_TALL_GRASS.get()) || state.is(ModBlocks.BLUELEAF_WHEAT.get()));
    }

    @Override
    public boolean place(WorldGenLevel reader, ChunkGenerator generator, Random random, BlockPos pos, NoneFeatureConfiguration config) {
        while (pos.getY() > 1 && isAirOrLeaves(reader, pos)) {
            pos = pos.below();
        }
        pos = pos.above();

        ArrayList<BlockState> BLOCKS = new ArrayList<>(Arrays.asList(Blocks.COBBLESTONE.defaultBlockState(), Blocks.ANDESITE.defaultBlockState(), Blocks.POLISHED_ANDESITE.defaultBlockState()));
        ArrayList<BlockState> WALLS = new ArrayList<>(Arrays.asList(Blocks.COBBLESTONE_WALL.defaultBlockState(), Blocks.ANDESITE_WALL.defaultBlockState()));

        if (!reader.isWaterAt(pos.below()) && !reader.isStateAtPosition(pos.below(), blockState -> blockState.is(BlockTags.WALLS))) {
            setBlock(reader, pos, BLOCKS.get(random.nextInt(BLOCKS.size())));
            setBlock(reader, pos.above(1), WALLS.get(random.nextInt(WALLS.size())));

        }

        return false;
    }
}
