package hal.hem.world.gen.feature;

import hal.hem.HEM;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.Random;

public class NbtFeature extends Feature<NoFeatureConfig> {
    private ResourceLocation[] nbts;

    public NbtFeature(ResourceLocation[] nbts) {
        super(NoFeatureConfig.CODEC);
        this.nbts = nbts;
    }

    PlacementSettings placementSettings = new PlacementSettings().setMirror(Mirror.NONE).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_AND_AIR).setIgnoreEntities(false);

    @Override
    public boolean place(ISeedReader world, ChunkGenerator chunkGenerator, Random random, BlockPos pos, NoFeatureConfig config) {
        BlockPos.Mutable mutable = new BlockPos.Mutable().set(pos);
        for (mutable.move(Direction.UP); world.isEmptyBlock(mutable) && mutable.getY() > 2; ) {
            mutable.move(Direction.DOWN);
        }

        if (!world.getBlockState(mutable).isAir() && !world.isEmptyBlock(mutable.below()) && !world.isEmptyBlock(mutable.below(2))) {
            mutable.move(Direction.DOWN);
        } else{
            return false;
        }

        BlockPos.Mutable blockpos$Mutable = new BlockPos.Mutable();
        TemplateManager templatemanager = world.getLevel().getServer().getStructureManager();
        Template template = templatemanager.get(nbts[random.nextInt(nbts.length)]);

        if (template == null) {
            HEM.LOGGER.warn("NBT does not exist!");
            return false;
        }

        int radius = template.getSize().getX() / 2;
        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                if ((x * x) + (z * z) < radius * radius + 1) {
                    blockpos$Mutable.set(pos).move(x, 0, z);

                    if (!world.getFluidState(blockpos$Mutable).isEmpty() || !world.getFluidState(blockpos$Mutable.below()).isEmpty()) {
                        return false;
                    } else if(world.getBlockState(blockpos$Mutable.move(Direction.UP)).canOcclude() || !world.getBlockState(blockpos$Mutable.move(Direction.DOWN, 3)).canOcclude()){
                        return false;
                    }
                }
            }
        }

        BlockPos halfLengths = new BlockPos(template.getSize().getX() / 2, 0, template.getSize().getZ() / 2);
        placementSettings.setRotation(Rotation.getRandom(random)).setRotationPivot(halfLengths).setIgnoreEntities(false);
        blockpos$Mutable.set(pos);
        BlockPos offset = new BlockPos(-template.getSize().getX() / 2, 0, -template.getSize().getZ() / 2);
        template.placeInWorld(world, blockpos$Mutable.offset(offset), placementSettings, random);

        return true;
    }
}
