package com.Mrbysco.MIAB.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MIABRecipes {
	public static void init()
	{
		GameRegistry.addSmelting(new ItemStack(MIABItems.knife), new ItemStack(MIABItems.hot_knife), 10);
		/*
		GameRegistry.addShapelessRecipe(Reference.MOD_ID, new ItemStack(MIABItems.meme_in_a_bottle)," A"," G", 'A', Items.ARROW, 'G', Items.GLASS_BOTTLE);
		GameRegistry.addShapelessRecipe(new ItemStack(MIABItems.splash_meme_in_a_bottle)," G"," S", 'G', Items.GUNPOWDER, 's', MIABItems.meme_in_a_bottle);
		*/
	}
}
