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
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;

public final class StudioBar extends PaintableBlock {
	
	public static DirectionProperty FACING;
	private static final VoxelShape BAR_NORTH_SOUTH;
    private static final VoxelShape BAR_EAST_WEST;
    private static final VoxelShape NORTH;
    private static final VoxelShape EAST;
    private static final VoxelShape SOUTH;
    private static final VoxelShape WEST;

	public StudioBar(Settings settings) {
		super(Settings.of(Material.STONE).breakInstantly().sounds(BlockSoundGroup.STONE).luminance((state) -> {
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
	        BAR_NORTH_SOUTH = Block.createCuboidShape(4, 0, 0, 12, 8, 16);
	        BAR_EAST_WEST = Block.createCuboidShape(0, 0, 4, 16, 8, 12);
	       
	        NORTH = VoxelShapes.union(BAR_NORTH_SOUTH);
	        EAST = VoxelShapes.union(BAR_EAST_WEST);
	        SOUTH = VoxelShapes.union(BAR_NORTH_SOUTH);
	        WEST = VoxelShapes.union(BAR_EAST_WEST);
	    }
}

