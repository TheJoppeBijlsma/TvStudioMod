package io.github.joppebijlsma.tvstudio.items.custom;


import java.util.List;

import io.github.joppebijlsma.tvstudio.blocks.entity.PaintableBlockEntity;
import io.github.joppebijlsma.tvstudio.items.PaintBrushItem;
import io.github.joppebijlsma.tvstudio.items.TsDyeableItem;
import io.github.joppebijlsma.tvstudio.registries.ModBlockEntities;
import io.github.joppebijlsma.tvstudio.util.Colors;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
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


	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		@Nullable PaintableBlockEntity entity = context.getWorld().getBlockEntity(context.getBlockPos(), ModBlockEntities.PAINTABLE_BLOCK).orElse(null);

		if (entity != null) {
			return useOnDyeable(context, context.getWorld(), context.getStack(), entity, context.getPlayer());
		}

		return ActionResult.PASS;
	}

	public static ActionResult useOnDyeable(ItemUsageContext context, World world, ItemStack stack, PaintBrushItem.DyeTarget target, @Nullable PlayerEntity player) {
		if (world.isClient()) return ActionResult.SUCCESS;
		DyeableItem item = (DyeableItem) stack.getItem();
		PlayerEntity playerEntity = context.getPlayer();

		if (target.getColor() != Colors.TV_STUDIO_BLOCK_DEFAULT_COLOR) {

			target.setColorAndSync(Colors.TV_STUDIO_BLOCK_DEFAULT_COLOR);
			player.sendMessage(Text.translatable("tooltip.tvstudio.washed").formatted(Formatting.ITALIC), true);

			if (playerEntity != null && !player.getAbilities().creativeMode) {
				stack.decrement(1);
			}
		} else if (target.getColor() == Colors.TV_STUDIO_BLOCK_DEFAULT_COLOR) {
			player.sendMessage(Text.translatable("tooltip.tvstudio.nocolour").formatted(Formatting.ITALIC), true);
		}
		
		return ActionResult.CONSUME;
	}
}

