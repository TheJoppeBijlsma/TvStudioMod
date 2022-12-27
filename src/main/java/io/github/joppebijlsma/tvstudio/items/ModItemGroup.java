package io.github.joppebijlsma.tvstudio.items;

import io.github.joppebijlsma.tvstudio.TvStudio;
import io.github.joppebijlsma.tvstudio.registries.ModBlocks;
import io.github.joppebijlsma.tvstudio.registries.ModItems;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup BLOCKS_GROUP = FabricItemGroupBuilder.build(
            new Identifier(TvStudio.MOD_ID, "studio_blocks"), () -> new ItemStack(ModBlocks.TV_CAMERA));

    public static final ItemGroup ITEMS_GROUP = FabricItemGroupBuilder.build(
            new Identifier(TvStudio.MOD_ID, "studio_items"), () -> new ItemStack(ModItems.LENS));

    public static final ItemGroup SET_WALL_GROUP = FabricItemGroupBuilder.build(
            new Identifier(TvStudio.MOD_ID, "studio_set_walls"), () -> new ItemStack(ModBlocks.SET_WALL));
}
