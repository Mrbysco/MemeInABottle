package com.Mrbysco.miab.items.base;

import com.Mrbysco.miab.MemeInABottle;
import com.Mrbysco.miab.Reference;

import net.minecraft.item.ItemFood;

public class ItemCustomFood extends ItemFood
{
	public ItemCustomFood(int amount, float saturation, boolean isWolfFood, String registry) 
	{
		super(amount, saturation, isWolfFood);
		this.setUnlocalizedName(Reference.MOD_PREFIX + registry.replaceAll("_", ""));
		this.setRegistryName(registry);
		setCreativeTab(MemeInABottle.memetab);
	}
}
