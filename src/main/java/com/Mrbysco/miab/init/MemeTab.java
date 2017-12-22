package com.Mrbysco.miab.init;

import com.Mrbysco.miab.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class MemeTab extends CreativeTabs{

	
	public MemeTab() 
	{
		super(Reference.MOD_ID);
	}

	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(MemeItems.splash_meme_in_a_bottle);
	}

}
