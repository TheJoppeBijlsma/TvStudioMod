package io.github.joppebijlsma.tvstudio.items;


import java.util.List;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class WashingTowel extends Item {

	public WashingTowel(Settings settings) {
		super(settings);
	}
	
	@Override
	   public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {	
		
		if(Screen.hasShiftDown()) {
			tooltip.add( new TranslatableText("tooltip.tvstudio.washing_towel.line1") );
			tooltip.add( new TranslatableText("tooltip.tvstudio.washing_towel.line2") );
		}
		
		else {
			tooltip.add( new TranslatableText("tooltip.tvstudio.washing_towel.hold.shift") );			
		}
	}
}
