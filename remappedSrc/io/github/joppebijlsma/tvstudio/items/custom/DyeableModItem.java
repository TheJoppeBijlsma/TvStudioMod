package io.github.joppebijlsma.tvstudio.items.custom;


import net.minecraft.item.DyeableItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;

public interface DyeableModItem extends DyeableItem {
    int DEFAULT_COLOR = 16777215; //White

    default int getColor(ItemStack stack) {
        NbtCompound nbtCompound = stack.getSubNbt("display");
        return nbtCompound != null && nbtCompound.contains("color", 99) ? nbtCompound.getInt("color") : 16777215;
    }
}
