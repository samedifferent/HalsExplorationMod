package hal.hem.block;

import hal.hem.registry.ModBlocks;
import hal.hem.registry.ModDimensions;
import hal.hem.world.dimension.BlueleafTeleporter;
import hal.hem.world.dimension.EntityTeleporterDuck;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class TransporterBlock extends HorizontalDirectionalBlock {
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

    public TransporterBlock() {
        super(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).lightLevel((light) -> 10));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState neighborState, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        DoubleBlockHalf doubleblockhalf = blockState.getValue(HALF);
        if (direction.getAxis() == Direction.Axis.Y && doubleblockhalf == DoubleBlockHalf.LOWER == (direction == Direction.UP)) {
            return neighborState.is(this) && neighborState.getValue(HALF) != doubleblockhalf ? blockState.setValue(FACING, neighborState.getValue(FACING)) : Blocks.AIR.defaultBlockState();
        } else {
            return doubleblockhalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !blockState.canSurvive(levelAccessor, blockPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(blockState, direction, neighborState, levelAccessor, blockPos, blockPos2);
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        BlockPos blockPos = blockPlaceContext.getClickedPos();
        if (blockPos.getY() < 255 && blockPlaceContext.getLevel().getBlockState(blockPos.above()).canBeReplaced(blockPlaceContext)) {
            return this.defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection()).setValue(HALF, DoubleBlockHalf.LOWER);
        } else {
            return null;
        }
    }

    @Override
    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, @Nullable LivingEntity livingEntity, ItemStack itemStack) {
        level.setBlock(blockPos.above(), this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER), 3);
    }

    @Override
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        BlockPos belowBlockPos = blockPos.below();
        BlockState belowBlockState = levelReader.getBlockState(belowBlockPos);
        return blockState.getValue(HALF) == DoubleBlockHalf.LOWER ? belowBlockState.isFaceSturdy(levelReader, belowBlockPos, Direction.UP) : belowBlockState.is(this);
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        if (!level.isClientSide && player.isCreative()) {
            TransporterBlock.preventCreativeDropFromBottomPart(level, blockPos, blockState, player);
        }

        super.playerWillDestroy(level, blockPos, blockState, player);
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState blockState) {
        return PushReaction.DESTROY;
    }

    protected static void preventCreativeDropFromBottomPart(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        DoubleBlockHalf doubleblockhalf = blockState.getValue(HALF);
        if (doubleblockhalf == DoubleBlockHalf.UPPER) {
            BlockPos blockpos = blockPos.below();
            BlockState blockstate = level.getBlockState(blockpos);
            if (blockstate.getBlock() == blockState.getBlock() && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
                level.setBlock(blockpos, Blocks.AIR.defaultBlockState(), 35);
                level.levelEvent(player, 2001, blockpos, Block.getId(blockstate));
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HALF, FACING);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (!level.isClientSide) {
            if (!player.isCrouching()) {
                BlockState computerFlag = level.getBlockState(blockPos.east());
                BlockState pipe1Flag = level.getBlockState(blockPos.west());
                BlockState pipe2Flag = level.getBlockState(blockPos.west(2));
                BlockState generatorFlag = level.getBlockState(blockPos.west(3));
                MinecraftServer server = level.getServer();
                if (server != null) {
                    if (!(computerFlag.is(ModBlocks.T1_COMPUTER.get()) && pipe1Flag.is(ModBlocks.GENERATOR_PIPE.get()) && pipe2Flag.is(ModBlocks.GENERATOR_PIPE.get()) && generatorFlag.is(ModBlocks.GENERATOR.get()))) {
                        if (level.dimension().equals(ModDimensions.BLUELEAF_WORLD)) {
                            ServerLevel overworld = server.getLevel(Level.OVERWORLD);
                            if (overworld != null) {
                                // Casts the PlayerEntity to an EntityTeleporterDuck to be able to access changeDimensionForge
                                // The only reason for this to fail is if the EntityMixin doesn't apply.
                                ((EntityTeleporterDuck) player).changeDimensionForge(overworld, new BlueleafTeleporter(blockPos, false));
                            }
                        } else {
                            ServerLevel blueleaf = server.getLevel(ModDimensions.BLUELEAF_WORLD);
                            if (blueleaf != null) {
                                ((EntityTeleporterDuck) player).changeDimensionForge(blueleaf, new BlueleafTeleporter(blockPos, true));
                            }
                        }
                        return InteractionResult.SUCCESS;
                    }
                }
            }
        }

        return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }
}
