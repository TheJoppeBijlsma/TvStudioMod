package io.github.joppebijlsma.tvstudio.items;


import java.util.List;
import java.util.Optional;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Instrument;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import net.minecraft.util.Formatting;
import net.minecraft.util.Util;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class WashingTowel extends Item {

	public WashingTowel(Settings settings) {
		super(settings);
	}

	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		if(Screen.hasShiftDown()) {
			tooltip.add(Text.translatable("tooltip.tvstudio.washing_towel.line1"));
			tooltip.add(Text.translatable("tooltip.tvstudio.washing_towel.line2"));
		} else {
			tooltip.add(Text.translatable("tooltip.tvstudio.washing_towel.hold.shift"));
		}
	}
}
