package io.github.joppebijlsma.tvstudio;

import io.github.joppebijlsma.tvstudio.registries.ModBlocks;
import io.github.joppebijlsma.tvstudio.registries.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class TvStudio implements ModInitializer {
	
	public static final ItemGroup BLOCKS_GROUP = FabricItemGroupBuilder.build(
			new Identifier("tvstudio", "studio_blocks"),
			() -> new ItemStack(ModBlocks.TV_CAMERA));
			
	public static final ItemGroup ITEMS_GROUP = FabricItemGroupBuilder.build(
			new Identifier("tvstudio", "studio_items"),
			() -> new ItemStack(ModItems.LENS));
	
	public static final ItemGroup SET_WALL_GROUP = FabricItemGroupBuilder.build(
			new Identifier("tvstudio", "studio_set_walls"),
			() -> new ItemStack(ModBlocks.SET_WALL));
	
	
	@Override
	public void onInitialize() {

		ModItems.register();
		ModBlocks.register();
	}
}
