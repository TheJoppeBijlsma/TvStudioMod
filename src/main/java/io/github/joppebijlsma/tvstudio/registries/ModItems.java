package io.github.joppebijlsma.tvstudio.registries;

import com.google.common.collect.ImmutableList;
import io.github.joppebijlsma.tvstudio.TvStudio;
import io.github.joppebijlsma.tvstudio.items.ModItemGroup;
import io.github.joppebijlsma.tvstudio.items.PaintBrushItem;
import io.github.joppebijlsma.tvstudio.items.custom.DyeableModArmorItem;
import io.github.joppebijlsma.tvstudio.items.custom.DyeableModItem;
import io.github.joppebijlsma.tvstudio.items.custom.ModArmorMaterial;
import io.github.joppebijlsma.tvstudio.items.custom.WashingTowel;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;

import java.util.List;

public class ModItems {
	public static final Item LENS = registerItem("lens",
			new Item(new FabricItemSettings().group(ModItemGroup.ITEMS_GROUP)));
	public static final Item CLAPBOARD = registerItem("clapboard",
			new Item(new FabricItemSettings().group(ModItemGroup.ITEMS_GROUP)));
	public static final Item BOOMPOLE_MICROPHONE = registerItem("boompole_microphone",
			new Item(new FabricItemSettings().group(ModItemGroup.ITEMS_GROUP)));
	public static final Item WASHING_TOWEL = registerItem("washing_towel",
			new WashingTowel(new FabricItemSettings().group(ModItemGroup.ITEMS_GROUP).maxCount(1)));
	public static final Item GREEN_NEON_ORB = registerItem("green_neon_orb",
			new Item(new FabricItemSettings().group(ModItemGroup.ITEMS_GROUP)));
	public static final Item BLUE_NEON_ORB = registerItem("blue_neon_orb",
			new Item(new FabricItemSettings().group(ModItemGroup.ITEMS_GROUP)));
	public static final Item GREEN_SCREEN_DYE = registerItem("green_screen_dye",
			new Item(new FabricItemSettings().group(ModItemGroup.ITEMS_GROUP)));
	public static final Item BLUE_SCREEN_DYE = registerItem("blue_screen_dye",
			new Item(new FabricItemSettings().group(ModItemGroup.ITEMS_GROUP)));
	public static final Item IRON_STICK = registerItem("iron_stick",
			new Item(new FabricItemSettings().group(ModItemGroup.ITEMS_GROUP)));
	public static final Item POLE = registerItem("pole",
			new Item(new FabricItemSettings().group(ModItemGroup.ITEMS_GROUP)));
	public static final Item TV_STAND_HEAD = registerItem("tv_stand_head",
			new Item(new FabricItemSettings().group(ModItemGroup.ITEMS_GROUP)));
	public static final Item HEADSET = registerItem("headset",
			new DyeableModArmorItem(ModArmorMaterial.HEADSET_MATERIAL, EquipmentSlot.HEAD, new FabricItemSettings().group(ModItemGroup.ITEMS_GROUP).maxCount(1)));
	public static final Item PAINT_BRUSH = register("paint_brush",
			new PaintBrushItem(new FabricItemSettings().group(ModItemGroup.ITEMS_GROUP)));

	private static Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(TvStudio.MOD_ID, name), item);
	}

	private static final List<ItemConvertible> ALL_BLOCK_LIKE_ITEMS = ImmutableList.<ItemConvertible>builder()
			.addAll(ModBlocks.ALL_BLOCKS)
			.build();

	public static final List<Item> ALL_DYEABLE_ITEMS = Util.make(ImmutableList.<Item>builder(), builder -> {
		for (ItemConvertible item : ALL_BLOCK_LIKE_ITEMS) {
			builder.add(item.asItem());
		}

		builder.add(PAINT_BRUSH);
	}).build();

	public static ItemConvertible[] blockLikeItems() {
		return ALL_BLOCK_LIKE_ITEMS.toArray(new ItemConvertible[0]);
	}

	private static <I extends Item> I register(String id, I item) {
		return Registry.register(Registry.ITEM, TvStudio.id(id), item);
	}

	public static void registerModItems() {
		TvStudio.TVSTUDIO_LOGGER.debug("Registering Mod Items for " + TvStudio.MOD_ID);
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> tintIndex > 0 ? -1 : ((DyeableModItem) ((Object) stack.getItem())).getColor(stack), HEADSET);

		for (Item item : ALL_DYEABLE_ITEMS) {
			CauldronBehavior.WATER_CAULDRON_BEHAVIOR.put(item, CauldronBehavior.CLEAN_DYEABLE_ITEM);
		}
	}
}
