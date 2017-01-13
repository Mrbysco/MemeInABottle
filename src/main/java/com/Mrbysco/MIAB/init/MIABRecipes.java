package com.Mrbysco.MIAB.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MIABRecipes {
	public static void init()
	{
		GameRegistry.addRecipe(new ItemStack(MIABItems.meme_in_a_bottle), new Object[]
	    		{" A"
	    		," G", 'A', Items.ARROW, 'G', Items.GLASS_BOTTLE });
	    	
	    	GameRegistry.addRecipe(new ItemStack(MIABItems.splash_meme_in_a_bottle), new Object[]
	        	{" G"
	        	," S", 'G', Items.GUNPOWDER, 'S', MIABItems.meme_in_a_bottle });
	}
}
