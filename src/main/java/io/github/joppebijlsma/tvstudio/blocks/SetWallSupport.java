package io.github.joppebijlsma.tvstudio.blocks;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class SetWallSupport extends Block {
	
	public static DirectionProperty FACING;
	private static final VoxelShape SUPPORT_BASE;
    private static final VoxelShape NORTH;
    private static final VoxelShape EAST;
    private static final VoxelShape SOUTH;
    private static final VoxelShape WEST;
    private static final VoxelShape COLLISION_NORTH;
    private static final VoxelShape COLLISION_EAST;
    private static final VoxelShape COLLISION_SOUTH;
    private static final VoxelShape COLLISION_WEST;

	public SetWallSupport() {
		super(Block.Settings.create().breakInstantly().sounds(BlockSoundGroup.STONE).solidBlock(SetWallSupport::never).nonOpaque().luminance((state) -> {
	         return 2;}));
		setDefaultState(getStateManager().getDefaultState().with(FACING, Direction.NORTH));
		   }

	@Override
	public BlockState getPlacementState(ItemPlacementContext context) {
		return this.getDefaultState().with(HorizontalFacingBlock.FACING, context.getHorizontalPlayerFacing().getOpposite());
	}
	
	 @Override
	    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
	        builder.add(FACING);
	    }

	    @Override
	    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
	        return this.getShape(state);
	    }

	    @Override
	    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
	        return this.getCollision(state);
	    }
	    
	    private VoxelShape getCollision(BlockState state) {
	        Direction direction = (Direction) state.get(FACING);
	        if (direction == Direction.NORTH) {
	            return COLLISION_NORTH;
	        } else if (direction == Direction.EAST) {
	            return COLLISION_EAST;
	        } else if (direction == Direction.SOUTH) {
	            return COLLISION_SOUTH;
	        } else if (direction == Direction.WEST) {
	            return COLLISION_WEST;
	        } else
	            return COLLISION_NORTH;
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
	    
	    
	    
	    static {
	        FACING = HorizontalFacingBlock.FACING;
	        SUPPORT_BASE = Block.createCuboidShape(0, 0, 0, 16, 16, 16);
	        NORTH = VoxelShapes.union(SUPPORT_BASE);
	        EAST = VoxelShapes.union(SUPPORT_BASE);
	        SOUTH = VoxelShapes.union(SUPPORT_BASE);
	        WEST = VoxelShapes.union(SUPPORT_BASE);
	        COLLISION_NORTH = VoxelShapes.union(Block.createCuboidShape(0, 0, 0, 1, 16, 16), Block.createCuboidShape(15, 0, 0, 16, 16, 16));
	        COLLISION_EAST = VoxelShapes.union(Block.createCuboidShape(0, 0, 0, 16, 16, 1), Block.createCuboidShape(0, 0, 15, 16, 16, 16));
	        COLLISION_SOUTH = VoxelShapes.union(Block.createCuboidShape(0, 0, 0, 1, 16, 16), Block.createCuboidShape(15, 0, 0, 16, 16, 16));
	        COLLISION_WEST = VoxelShapes.union(Block.createCuboidShape(0, 0, 0, 16, 16, 1), Block.createCuboidShape(0, 0, 15, 16, 16, 16));
	    }
	    
	    private static boolean never(BlockState state, BlockView world, BlockPos pos) {
	        return false;
	     }
}
