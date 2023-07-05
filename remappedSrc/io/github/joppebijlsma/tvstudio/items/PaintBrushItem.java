/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package io.github.joppebijlsma.tvstudio.items;

import io.github.joppebijlsma.tvstudio.blocks.entity.PaintableBlockEntity;
import io.github.joppebijlsma.tvstudio.registries.ModBlockEntities;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PaintBrushItem extends Item implements TsDyeableItem {
    public PaintBrushItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        @Nullable PaintableBlockEntity entity = context.getWorld().getBlockEntity(context.getBlockPos(), ModBlockEntities.PAINTABLE_BLOCK).orElse(null);

        if (entity != null) {
            return useOnDyeable(context.getWorld(), context.getStack(), entity, context.getPlayer());
        }

        return ActionResult.PASS;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        appendColorTooltip(stack, tooltip);
    }

    public int getColor(ItemStack stack, int tintIndex) {
        if (hasColor(stack) && tintIndex == 1) {
            return getColor(stack);
        }

        return -1;
    }

    public static ActionResult useOnDyeable(World world, ItemStack stack, DyeTarget target, @Nullable PlayerEntity player) {
        if (world.isClient()) return ActionResult.SUCCESS;
        DyeableItem item = (DyeableItem) stack.getItem();

        if (item.hasColor(stack)) {
            int color = item.getColor(stack);

            if (color != target.getColor()) {
                target.setColorAndSync(item.getColor(stack));

                if (player != null && !player.getAbilities().creativeMode) {
                    stack.decrement(1);
                }
            }
        } else if (player != null) {
            if (stack.getCount() == 1) {
                item.setColor(stack, target.getColor());
            } else {
                stack.decrement(1);
                ItemStack dyed = new ItemStack(stack.getItem());
                item.setColor(dyed, target.getColor());
                player.getInventory().offerOrDrop(dyed);
            }

            player.sendMessage(Text.translatable("item.dyed").formatted(Formatting.ITALIC), true);
        }

        return ActionResult.CONSUME;
    }

    public interface DyeTarget {
        int getColor();
        void setColorAndSync(int color);
    }
}