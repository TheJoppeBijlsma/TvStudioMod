package io.github.joppebijlsma.tvstudio.items.custom;


import java.util.List;

import io.github.joppebijlsma.tvstudio.blocks.entity.PaintableBlockEntity;
import io.github.joppebijlsma.tvstudio.items.PaintBrushItem;
import io.github.joppebijlsma.tvstudio.items.TsDyeableItem;
import io.github.joppebijlsma.tvstudio.registries.ModBlockEntities;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class WashingTowel extends Item implements TsDyeableItem {

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
