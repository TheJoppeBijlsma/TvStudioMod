package io.github.joppebijlsma.tvstudio.registries;

import io.github.joppebijlsma.tvstudio.TvStudio;
import io.github.joppebijlsma.tvstudio.items.ModItemGroup;
import io.github.joppebijlsma.tvstudio.items.custom.DyeableModArmorItem;
import io.github.joppebijlsma.tvstudio.items.custom.DyeableModItem;
import io.github.joppebijlsma.tvstudio.items.custom.ModArmorMaterial;
import io.github.joppebijlsma.tvstudio.items.custom.WashingTowel;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

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

	private static Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(TvStudio.MOD_ID, name), item);
	}

	public static void registerModItems() {
		TvStudio.TVSTUDIO_LOGGER.debug("Registering Mod Items for " + TvStudio.MOD_ID);
		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> tintIndex > 0 ? -1 : ((DyeableModItem) ((Object) stack.getItem())).getColor(stack), HEADSET);
	}
}
