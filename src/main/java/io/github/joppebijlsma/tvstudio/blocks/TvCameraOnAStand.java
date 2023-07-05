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

public class TvCameraOnAStand extends PaintableBlock {
	
    private static final VoxelShape STAND_NORTH;
    private static final VoxelShape STAND_SOUTH;
    private static final VoxelShape STAND_EAST;
    private static final VoxelShape STAND_WEST;
    private static final VoxelShape CAMERA_NORTH;
    private static final VoxelShape CAMERA_SOUTH;
    private static final VoxelShape CAMERA_EAST;
    private static final VoxelShape CAMERA_WEST;
    private static final VoxelShape NORTH;
    private static final VoxelShape EAST;
    private static final VoxelShape SOUTH;
    private static final VoxelShape WEST;
	public static DirectionProperty FACING;

	public TvCameraOnAStand(Settings settings) {
		super(Block.Settings.create().breakInstantly().sounds(BlockSoundGroup.STONE).luminance((state) -> {
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
	        STAND_NORTH = VoxelShapes.union(Block.createCuboidShape(6.5, 7, 6.5, 9.75, 14.5, 9.75),
	        		Block.createCuboidShape(6.5, 20.75, 7, 10, 21.75, 11.25),
	        		Block.createCuboidShape(6.5, 21.75, 7.75, 10, 22.25, 11.25),
	        		Block.createCuboidShape(6.5, 22.25, 7.75, 10, 23, 14),
	        		Block.createCuboidShape(6, 20.25, 10.75, 10.75, 21.25, 11.75),
	        		Block.createCuboidShape(6.5, 20.25, 5.5, 10, 21.25, 7),
	        		Block.createCuboidShape(6.5, 17.5, 7, 10, 20.75, 9.25),
	        		Block.createCuboidShape(6.5, 17, 6.75, 10, 17.75, 9.75),
	        		Block.createCuboidShape(6.5, 15.75, 3.25, 9.75, 17, 13.25),
	        		Block.createCuboidShape(3.25, 15.75, 6.5, 13.25, 17, 9.75),
	        		Block.createCuboidShape(4, 5.25, 6.75, 12.25, 7, 9.5),
	        		Block.createCuboidShape(7, 5.25, 4, 9.25, 7, 12.25),
	        		Block.createCuboidShape(7.5, 14.5, 7.5, 8.75, 15.75, 8.75),
	        		Block.createCuboidShape(-2, 0, 8, 18.5, 5.25, 17.75),
	        		Block.createCuboidShape(3, 0, 3, 13.25, 5.25, 8),
	        		Block.createCuboidShape(5, 0, -3, 11, 5.25, 13.5));
	        STAND_SOUTH = VoxelShapes.union(Block.createCuboidShape(6.25, 7, 6.25, 9.5, 14.5, 9.5),
	        		Block.createCuboidShape(6, 20.75, 4.75, 9.5, 21.75, 9),
	        		Block.createCuboidShape(6, 21.75, 4.75, 9.5, 22.25, 8.25),
	        		Block.createCuboidShape(6, 22.25, 2, 9.5, 23, 8.25),
	        		Block.createCuboidShape(5.25, 20.25, 4.25, 10, 21.25, 5.25),
	        		Block.createCuboidShape(6, 20.25, 9, 9.5, 21.25, 10.5),
	        		Block.createCuboidShape(6, 17.5, 6.75, 9.5, 20.75, 9),
	        		Block.createCuboidShape(6, 17, 6.25, 9.5, 17.75, 9.25),
	        		Block.createCuboidShape(6.25, 15.75, 2.75, 9.5, 17, 12.75),
	        		Block.createCuboidShape(2.75, 15.75, 6.25, 12.75, 17, 9.5),
	        		Block.createCuboidShape(3.75, 5.25, 6.5, 12, 7, 9.25),
	        		Block.createCuboidShape(6.75, 5.25, 3.75, 9, 7, 12),
	        		Block.createCuboidShape(7.25, 14.5, 7.25, 8.5, 15.75, 8.5),
	        		Block.createCuboidShape(-2.5, 0, -1.75, 18, 5.25, 8),
	        		Block.createCuboidShape(2.75, 0, 8, 13, 5.25, 13),
	        		Block.createCuboidShape(5, 0, 2.5, 11, 5.25, 19));
	        STAND_EAST = VoxelShapes.union(Block.createCuboidShape(6.25, 7, 6.25, 9.5, 14.5, 9.5),
	        		Block.createCuboidShape(4.75, 20.75, 6.25, 9, 21.75, 9.75),
	        		Block.createCuboidShape(4.75, 21.75, 6.25, 8.25, 22.25, 9.75),
	        		Block.createCuboidShape(2, 22.25, 6.25, 8.25, 23, 9.75),
	        		Block.createCuboidShape(4.25, 20.25, 5.75, 5.25, 21.25, 10.5),
	        		Block.createCuboidShape(9, 20.25, 6.25, 10.5, 21.25, 9.75),
	        		Block.createCuboidShape(6.75, 17.5, 6.25, 9, 20.75, 9.75),
	        		Block.createCuboidShape(6.25, 17, 6.25, 9.25, 17.75, 9.75),
	        		Block.createCuboidShape(2.75, 15.75, 6.25, 12.75, 17, 9.5),
	        		Block.createCuboidShape(6.25, 15.75, 3, 9.5, 17, 13),
	        		Block.createCuboidShape(6.5, 5.25, 3.75, 9.25, 7, 12),
	        		Block.createCuboidShape(3.75, 5.25, 6.75, 12, 7, 9),
	        		Block.createCuboidShape(7.25, 14.5, 7.25, 8.5, 15.75, 8.5),
	        		Block.createCuboidShape(-1.75, 0, -2.25, 8, 5.25, 18.25),
	        		Block.createCuboidShape(8, 0, 2.75, 13, 5.25, 13),
	        		Block.createCuboidShape(2.5, 0, 4.75, 19, 5.25, 10.75));
	        STAND_WEST = VoxelShapes.union(Block.createCuboidShape(6.5, 7, 6.25, 9.75, 14.5, 9.5),
	        		Block.createCuboidShape(7, 20.75, 6, 11.25, 21.75, 9.5),
	        		Block.createCuboidShape(7.75, 21.75, 6, 11.25, 22.25, 9.5),
	        		Block.createCuboidShape(7.75, 22.25, 6, 14, 23, 9.5),
	        		Block.createCuboidShape(10.75, 20.25, 5.25, 11.75, 21.25, 10),
	        		Block.createCuboidShape(5.5, 20.25, 6, 7, 21.25, 9.5),
	        		Block.createCuboidShape(7, 17.5, 6, 9.25, 20.75, 9.5),
	        		Block.createCuboidShape(6.75, 17, 6, 9.75, 17.75, 9.5),
	        		Block.createCuboidShape(3.25, 15.75, 6.25, 13.25, 17, 9.5),
	        		Block.createCuboidShape(6.5, 15.75, 2.75, 9.75, 17, 12.75),
	        		Block.createCuboidShape(6.75, 5.25, 3.75, 9.5, 7, 12),
	        		Block.createCuboidShape(4, 5.25, 6.75, 12.25, 7, 9),
	        		Block.createCuboidShape(7.5, 14.5, 7.25, 8.75, 15.75, 8.5),
	        		Block.createCuboidShape(8, 0, -2.5, 17.75, 5.25, 18),
	        		Block.createCuboidShape(3, 0, 2.75, 8, 5.25, 13),
	        		Block.createCuboidShape(-3, 0, 5, 13.5, 5.25, 11));
	        CAMERA_NORTH = VoxelShapes.union(Block.createCuboidShape(6, 23, 11, 10.5, 25.75, 14.5),
	        		Block.createCuboidShape(6, 23, 7.75, 10.5, 27, 11),
	        		Block.createCuboidShape(6.25, 23, -1.25, 10.25, 27, 7.75),
	        		Block.createCuboidShape(6.25, 25.75, 9.75, 10.25, 28, 16.75));
	        CAMERA_SOUTH = VoxelShapes.union(Block.createCuboidShape(6, 23, 1, 10.5, 25.75, 4.5),
	        		Block.createCuboidShape(6, 23, 4.5, 10.5, 27, 7.75),
	        		Block.createCuboidShape(6.25, 23, 7.75, 10.25, 27, 16.75),
	        		Block.createCuboidShape(6.25, 25.75, -1.25, 10.25, 28, 5.75));
	        CAMERA_EAST = VoxelShapes.union(Block.createCuboidShape(1.5, 23, 5.5, 5, 25.75, 10),
	        		Block.createCuboidShape(5, 23, 5.5, 8.25, 27, 10),
	        		Block.createCuboidShape(8.25, 23, 5.75, 17.25, 27, 9.75),
	        		Block.createCuboidShape(-0.75, 25.75, 5.75, 6.25, 28, 9.75));
	        CAMERA_WEST = VoxelShapes.union(Block.createCuboidShape(11.5, 23, 5.5, 15, 25.75, 10),
	        		Block.createCuboidShape(8.25, 23, 5.5, 11.5, 27, 10),
	        		Block.createCuboidShape(-0.75, 23, 5.75, 8.25, 27, 9.75),
	        		Block.createCuboidShape(10.25, 25.75, 5.75, 17.25, 28, 9.75));
	        NORTH = VoxelShapes.union(STAND_NORTH, CAMERA_NORTH);
	        EAST = VoxelShapes.union(STAND_EAST, CAMERA_EAST);
	        SOUTH = VoxelShapes.union(STAND_SOUTH, CAMERA_SOUTH);
	        WEST = VoxelShapes.union(STAND_WEST, CAMERA_WEST);
	    }
}
