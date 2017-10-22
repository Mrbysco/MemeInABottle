package com.Mrbysco.miab.items.base;

import com.Mrbysco.miab.MemeInABottle;

import net.minecraft.item.Item;

public class ItemCustomItem extends Item{
	public ItemCustomItem(String unlocalized, String registry)
	{
		setUnlocalizedName(unlocalized);
		setRegistryName(registry);
		setCreativeTab(MemeInABottle.memetab);
	}
}
