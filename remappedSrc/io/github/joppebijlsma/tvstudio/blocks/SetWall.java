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

public class SetWall extends Block {
	
	public static DirectionProperty FACING;
	private static final VoxelShape WALL_NORTH;
    private static final VoxelShape WALL_SOUTH;
    private static final VoxelShape WALL_EAST;
    private static final VoxelShape WALL_WEST;
    private static final VoxelShape NORTH;
    private static final VoxelShape EAST;
    private static final VoxelShape SOUTH;
    private static final VoxelShape WEST;

	public SetWall() {
		super(Block.Settings.create(Material.STONE).breakInstantly().sounds(BlockSoundGroup.STONE).luminance((state) -> {
	         return 2;}));
		setDefaultState(getStateManager().getDefaultState().with(FACING, Direction.NORTH));
		   }

	@Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(FACING, context.getHorizontalPlayerFacing().getOpposite());
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
	    
	    static {
	        FACING = HorizontalFacingBlock.FACING;
	        WALL_NORTH = VoxelShapes.union(Block.createCuboidShape(0, 0, 0, 16, 16, 1),
	        		Block.createCuboidShape(0, 0, 1, 16, 1, 3),
	        		Block.createCuboidShape(0, 15, 1, 16, 16, 3),
	        		Block.createCuboidShape(15, 1, 1, 16, 15, 3),
	        		Block.createCuboidShape(0, 1, 1, 1, 15, 3));
	        WALL_SOUTH = VoxelShapes.union(Block.createCuboidShape(0, 0, 15, 16, 16, 16),
	        		Block.createCuboidShape(0, 0, 13, 16, 1, 15),
	        		Block.createCuboidShape(0, 15, 13, 16, 16, 15),
	        		Block.createCuboidShape(0, 1, 13, 1, 15, 15),
	        		Block.createCuboidShape(15, 1, 13, 16, 15, 15));
	        WALL_EAST = VoxelShapes.union(Block.createCuboidShape(15, 0, 0, 16, 16, 16),
	        		Block.createCuboidShape(13, 0, 0, 15, 1, 16),
	        		Block.createCuboidShape(13, 15, 0, 15, 16, 16),
	        		Block.createCuboidShape(13, 1, 15, 15, 15, 16),
	        		Block.createCuboidShape(13, 1, 0, 15, 15, 1));
	        WALL_WEST = VoxelShapes.union(Block.createCuboidShape(0, 0, 0, 1, 16, 16),
	        		Block.createCuboidShape(1, 0, 0, 3, 1, 16),
	        		Block.createCuboidShape(1, 15, 0, 3, 16, 16),
	        		Block.createCuboidShape(1, 1, 0, 3, 15, 1),
	        		Block.createCuboidShape(1, 1, 15, 3, 15, 16)); 
	        NORTH = VoxelShapes.union(WALL_NORTH);
	        EAST = VoxelShapes.union(WALL_EAST);
	        SOUTH = VoxelShapes.union(WALL_SOUTH);
	        WEST = VoxelShapes.union(WALL_WEST);
	    }
}
