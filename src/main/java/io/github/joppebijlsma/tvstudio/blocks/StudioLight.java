package io.github.joppebijlsma.tvstudio.blocks;

import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class StudioLight extends Block {
	
	public static final BooleanProperty LIT = BooleanProperty.of("lit");
	
	public static DirectionProperty FACING;
	private static final VoxelShape LIGHT_NORTH;
    private static final VoxelShape LIGHT_SOUTH;
    private static final VoxelShape LIGHT_EAST;
    private static final VoxelShape LIGHT_WEST;
    private static final VoxelShape NORTH;
    private static final VoxelShape EAST;
    private static final VoxelShape SOUTH;
    private static final VoxelShape WEST;
    
	public StudioLight() {
		super(Block.Settings.of(Material.STONE).breakInstantly().sounds(BlockSoundGroup.STONE).luminance((state) -> {
	         return 15;}));
		setDefaultState(getStateManager().getDefaultState().with(FACING, Direction.NORTH).with(LIT, true));
		   }

	@Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(FACING, context.getPlayerFacing());
    }
	
	 @Override
	    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
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
	    }
}
