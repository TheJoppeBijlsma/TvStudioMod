package io.github.joppebijlsma.tvstudio.items.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;

public class DyeableModArmorItem extends ArmorItem implements DyeableModItem {
    public DyeableModArmorItem(ArmorMaterial armorMaterial, EquipmentSlot equipmentSlot, Item.Settings settings) {
        super(armorMaterial, equipmentSlot, settings);
    }

    @Override
    public int getColor(ItemStack stack) {
        NbtCompound nbtCompound = stack.getSubNbt("display");
        return nbtCompound != null && nbtCompound.contains("color", 99) ? nbtCompound.getInt("color") : 0xFFFFFF;
    }
}
