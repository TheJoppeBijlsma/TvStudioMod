package io.github.joppebijlsma.tvstudio.items.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class ModArmorMaterial implements ArmorMaterial {
	
	public static final ArmorMaterial HEADSET_MATERIAL = new ModArmorMaterial();
    
	
	
	
	
	private static final int[] BASE_DURABILITY = new int[] {0, 0, 0, 0};
	private static final int[] PROTECTION_VALUES = new int[] {0, 0, 0, 0};
 
	@Override
	public int getDurability(EquipmentSlot slot) {
		return BASE_DURABILITY[slot.getEntitySlotId()] * 0;
	}
 
	@Override
	public int getProtectionAmount(EquipmentSlot slot) {
		return PROTECTION_VALUES[slot.getEntitySlotId()];
	}
 
	@Override
	public int getEnchantability() {
		return 0;
	}
 
	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
	}
 
	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(Items.LEATHER);
	}
 
	@Override
	public String getName() {
		return "headset";
	}
 
	@Override
	public float getToughness() {
		return 0.0F;
	}
 
	@Override
	public float getKnockbackResistance() {
		return 0.0F;
	}
}
