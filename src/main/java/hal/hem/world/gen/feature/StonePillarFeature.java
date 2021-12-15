package hal.hem.world.gen.feature;

import com.mojang.serialization.Codec;
import hal.hem.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class StonePillarFeature extends Feature<NoFeatureConfig> {

    public StonePillarFeature(Codec<NoFeatureConfig> pCodec) {
        super(pCodec);
    }

    public static boolean isAirOrLeaves(IWorldGenerationBaseReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, (state) -> state.isAir() || state.is(BlockTags.LEAVES) || state.is(ModBlocks.BLUELEAF_SHORT_GRASS.get()) || state.is(ModBlocks.BLUELEAF_MEDIUM_GRASS.get()) || state.is(ModBlocks.BLUELEAF_TALL_GRASS.get()) || state.is(ModBlocks.BLUELEAF_WHEAT.get()));
    }

    @Override
    public boolean place(ISeedReader reader, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
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
