package io.github.joppebijlsma.tvstudio.blocks;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationPropertyHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.function.ToIntFunction;

public class StudioLight extends PaintableBlock {
	public static final BooleanProperty LIT;

	public static DirectionProperty FACING;
	private static final VoxelShape LIGHT_NORTH;
	private static final VoxelShape LIGHT_SOUTH;
	private static final VoxelShape LIGHT_EAST;
	private static final VoxelShape LIGHT_WEST;
	private static final VoxelShape NORTH;
	private static final VoxelShape EAST;
	private static final VoxelShape SOUTH;
	private static final VoxelShape WEST;

	public StudioLight(Settings settings) {
		super(Block.Settings.create().breakInstantly().sounds(BlockSoundGroup.STONE).luminance(StudioLight.createLightLevelFromLitBlockState(15)));
		this.setDefaultState((BlockState)this.getDefaultState().with(FACING, Direction.NORTH).with(LIT, false));
	}

	@Override
	@Nullable
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		return (BlockState)this.getDefaultState().with(HorizontalFacingBlock.FACING, ctx.getHorizontalPlayerFacing()).with(LIT, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos()));
	}

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
		if (!world.isClient() && hand == Hand.MAIN_HAND) {
			world.setBlockState(pos, state.cycle(LIT));
		}

		return ActionResult.success(world.isClient);
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(FACING);
		builder.add(LIT);
	}

	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return this.getShape(state);
	}

	@Override
	public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
		return this.getShape(state);
	}

	private VoxelShape getShape(BlockState state) {
		Direction direction = (Direction) state.get(FACING);
		if (direction == Direction.NORTH) {
			return NORTH;
		} else if (direction == Direction.EAST) {
			return EAST;
		} else if (direction == Direction.SOUTH) {
			return SOUTH;
		} else if (direction == Direction.WEST) {
			return WEST;
		} else
			return NORTH;
	}

	private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
		return state -> state.get(Properties.LIT) != false ? litLevel : 0;
	}

	static {
		FACING = HorizontalFacingBlock.FACING;
		LIGHT_NORTH = Block.createCuboidShape(5, 4.75, 4, 11, 16, 15.25);
		LIGHT_SOUTH = Block.createCuboidShape(5, 4.75, 0.75, 11, 16, 12);
		LIGHT_EAST = Block.createCuboidShape(0.75, 4.75, 5, 12, 16, 11);
		LIGHT_WEST = Block.createCuboidShape(4, 4.75, 5, 15.25, 16, 11);
		NORTH = VoxelShapes.union(LIGHT_NORTH);
		EAST = VoxelShapes.union(LIGHT_EAST);
		SOUTH = VoxelShapes.union(LIGHT_SOUTH);
		WEST = VoxelShapes.union(LIGHT_WEST);
		LIT = RedstoneTorchBlock.LIT;
	}
}
