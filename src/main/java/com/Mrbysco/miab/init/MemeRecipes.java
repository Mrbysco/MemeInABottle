package com.Mrbysco.miab.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MemeRecipes {

	public static void init()
	{
		GameRegistry.addSmelting(new ItemStack(MemeItems.knife), new ItemStack(MemeItems.hot_knife), 10);
	}
}
