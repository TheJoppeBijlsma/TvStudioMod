package io.github.joppebijlsma.tvstudio.items.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;

public class DyeableModArmorItem extends ArmorItem implements DyeableModItem {
    public DyeableModArmorItem(ArmorMaterial armorMaterial, ArmorItem.Type type, Item.Settings settings) {
        super(armorMaterial, type, settings);
    }

    @Override
    public int getColor(ItemStack stack) {
        NbtCompound nbtCompound = stack.getSubNbt("display");
        return nbtCompound != null && nbtCompound.contains("color", 99) ? nbtCompound.getInt("color") : 0xFFFFFF;
    }
}
