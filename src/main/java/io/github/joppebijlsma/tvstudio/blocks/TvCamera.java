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

public class TvCamera extends Block {
    private static final VoxelShape CAMERA_NORTH;
    private static final VoxelShape CAMERA_SOUTH;
    private static final VoxelShape CAMERA_EAST;
    private static final VoxelShape CAMERA_WEST;
    private static final VoxelShape NORTH;
    private static final VoxelShape EAST;
    private static final VoxelShape SOUTH;
    private static final VoxelShape WEST;
	public static DirectionProperty FACING;
	 
	public TvCamera() {
		super(Block.Settings.of(Material.STONE).breakInstantly().sounds(BlockSoundGroup.STONE).luminance((state) -> {
	         return 2;}));
		setDefaultState(getStateManager().getDefaultState().with(FACING, Direction.NORTH));
		   }
	
	
	@Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(FACING, context.getPlayerFacing());
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
	        CAMERA_SOUTH = VoxelShapes.union(Block.createCuboidShape(5.75, 0, 1.25, 10.25, 2.75, 4.75),
	        		Block.createCuboidShape(5.75, 0, 4.75, 10.25, 4, 8),
	        		Block.createCuboidShape(6, 0, 8, 10, 4, 17),
	        		Block.createCuboidShape(6, 2.75, -2.25, 10, 5, 4.75));
	        CAMERA_NORTH = VoxelShapes.union(Block.createCuboidShape(6, 2.75, 10, 10, 5, 17),
	        		Block.createCuboidShape(5.75, 0, 11.25, 10.25, 2.75, 14.75),
	        		Block.createCuboidShape(5.75, 0, 8, 10.25, 4, 11.25),
	        		Block.createCuboidShape(6, 0, -1, 10, 4, 8));
	        CAMERA_WEST = VoxelShapes.union(Block.createCuboidShape(10, 2.75, 6, 17, 5, 10),
	        		Block.createCuboidShape(11.25, 0, 5.75, 14.75, 2.75, 10.25),
	        		Block.createCuboidShape(8, 0, 5.75, 11.25, 4, 10.25),
	        		Block.createCuboidShape(-1, 0, 6, 8, 4, 10));
	        CAMERA_EAST = VoxelShapes.union(Block.createCuboidShape(1.25, 0, 5.75, 4.75, 2.75, 10.25),
	        		Block.createCuboidShape(4.75, 0, 5.75, 8, 4, 10.25),
	        		Block.createCuboidShape(8, 0, 6, 17, 4, 10),
	        		Block.createCuboidShape(-2.25, 2.75, 6, 4.75, 5, 10));
	        
	        NORTH = VoxelShapes.union(CAMERA_NORTH);
	        EAST = VoxelShapes.union(CAMERA_EAST);
	        SOUTH = VoxelShapes.union(CAMERA_SOUTH);
	        WEST = VoxelShapes.union(CAMERA_WEST);
	    }
}