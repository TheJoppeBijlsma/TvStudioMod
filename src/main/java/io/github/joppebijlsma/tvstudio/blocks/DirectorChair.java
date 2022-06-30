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

public class DirectorChair extends Block {
	
	public static DirectionProperty FACING;
	private static final VoxelShape CHAIR_NORTH;
    private static final VoxelShape CHAIR_SOUTH;
    private static final VoxelShape CHAIR_EAST;
    private static final VoxelShape CHAIR_WEST;
    private static final VoxelShape NORTH;
    private static final VoxelShape EAST;
    private static final VoxelShape SOUTH;
    private static final VoxelShape WEST;

	public DirectorChair() {
		super(Block.Settings.of(Material.STONE).breakInstantly().sounds(BlockSoundGroup.STONE).luminance((state) -> 2));
		setDefaultState(getStateManager().getDefaultState().with(FACING, Direction.NORTH));
		   }

	@Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(FACING, context.getPlayerFacing().getOpposite());
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
	        Direction direction = state.get(FACING);
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
	        CHAIR_NORTH = VoxelShapes.union(Block.createCuboidShape(0, 15, 1.5, 1, 15.5, 12.5),
	        		Block.createCuboidShape(15, 15, 1.5, 16, 15.5, 12.5),
	        		Block.createCuboidShape(15, 18.25, 3, 16, 19.5, 11.25),
	        		Block.createCuboidShape(0, 18.25, 3, 1, 19.5, 11.25),
	        		Block.createCuboidShape(15, 15.5, 11.25, 16, 26.5, 12.5),
	        		Block.createCuboidShape(14.75, 19.5, 11, 16.25, 25.5, 12.75),
	        		Block.createCuboidShape(-0.25, 19.5, 11, 1.25, 25.5, 12.75),
	        		Block.createCuboidShape(1.25, 19.5, 11.75, 14.75, 25.5, 12.25),
	        		Block.createCuboidShape(0, 15.5, 11.25, 1, 26.5, 12.5),
	        		Block.createCuboidShape(0.25, 15.5, 3.5, 0.75, 18.25, 5.5),
	        		Block.createCuboidShape(15.25, 15.5, 3.5, 15.75, 18.25, 5.5),
	        		Block.createCuboidShape(0, 0, 1.5, 16, 15, 12.5));
	        CHAIR_SOUTH = VoxelShapes.union(Block.createCuboidShape(15, 15, 3.5, 16, 15.5, 14.5),
	        		Block.createCuboidShape(0, 15, 3.5, 1, 15.5, 14.5),
	        		Block.createCuboidShape(0, 18.25, 4.75, 1, 19.5, 13),
	        		Block.createCuboidShape(15, 18.25, 4.75, 16, 19.5, 13),
	        		Block.createCuboidShape(0, 15.5, 3.5, 1, 26.5, 4.75),
	        		Block.createCuboidShape(-0.25, 19.5, 3.25, 1.25, 25.5, 5),
	        		Block.createCuboidShape(14.75, 19.5, 3.25, 16.25, 25.5, 5),
	        		Block.createCuboidShape(1.25, 19.5, 3.75, 14.75, 25.5, 4.25),
	        		Block.createCuboidShape(15, 15.5, 3.5, 16, 26.5, 4.75),
	        		Block.createCuboidShape(15.25, 15.5, 10.5, 15.75, 18.25, 12.5),
	        		Block.createCuboidShape(0.25, 15.5, 10.5, 0.75, 18.25, 12.5),
	        		Block.createCuboidShape(0, 0, 3.5, 16, 15, 14.5));
	        CHAIR_EAST = VoxelShapes.union(Block.createCuboidShape(3.5, 15, 0, 14.5, 15.5, 1),
	        		Block.createCuboidShape(3.5, 15, 15, 14.5, 15.5, 16),
	        		Block.createCuboidShape(4.75, 18.25, 15, 13, 19.5, 16),
	        		Block.createCuboidShape(4.75, 18.25, 0, 13, 19.5, 1),
	        		Block.createCuboidShape(3.5, 15.5, 15, 4.75, 26.5, 16),
	        		Block.createCuboidShape(3.25, 19.5, 14.75, 5, 25.5, 16.25),
	        		Block.createCuboidShape(3.25, 19.5, -0.25, 5, 25.5, 1.25),
	        		Block.createCuboidShape(3.75, 19.5, 1.25, 4.25, 25.5, 14.75),
	        		Block.createCuboidShape(3.5, 15.5, 0, 4.75, 26.5, 1),
	        		Block.createCuboidShape(10.5, 15.5, 0.25, 12.5, 18.25, 0.75),
	        		Block.createCuboidShape(10.5, 15.5, 15.25, 12.5, 18.25, 15.75),
	        		Block.createCuboidShape(3.5, 0, 0, 14.5, 15, 16));
	        CHAIR_WEST = VoxelShapes.union(Block.createCuboidShape(1.5, 15, 15, 12.5, 15.5, 16),
	        		Block.createCuboidShape(1.5, 15, 0, 12.5, 15.5, 1),
	        		Block.createCuboidShape(3, 18.25, 0, 11.25, 19.5, 1),
	        		Block.createCuboidShape(3, 18.25, 15, 11.25, 19.5, 16),
	        		Block.createCuboidShape(11.25, 15.5, 0, 12.5, 26.5, 1),
	        		Block.createCuboidShape(11, 19.5, -0.25, 12.75, 25.5, 1.25),
	        		Block.createCuboidShape(11, 19.5, 14.75, 12.75, 25.5, 16.25),
	        		Block.createCuboidShape(11.75, 19.5, 1.25, 12.25, 25.5, 14.75),
	        		Block.createCuboidShape(11.25, 15.5, 15, 12.5, 26.5, 16),
	        		Block.createCuboidShape(3.5, 15.5, 15.25, 5.5, 18.25, 15.75),
	        		Block.createCuboidShape(3.5, 15.5, 0.25, 5.5, 18.25, 0.75),
	        		Block.createCuboidShape(1.5, 0, 0, 12.5, 15, 16)); 
	        NORTH = VoxelShapes.union(CHAIR_NORTH);
	        EAST = VoxelShapes.union(CHAIR_EAST);
	        SOUTH = VoxelShapes.union(CHAIR_SOUTH);
	        WEST = VoxelShapes.union(CHAIR_WEST);
	    }
}
