package com.Mrbysco.miab.items.base;

import com.Mrbysco.miab.MemeInABottle;
import com.Mrbysco.miab.Reference;

import net.minecraft.item.Item;

public class ItemCustomItem extends Item
{
	public ItemCustomItem(String registry)
	{
		this.setUnlocalizedName(Reference.MOD_PREFIX + registry.replaceAll("_", ""));
		this.setRegistryName(registry);
		setCreativeTab(MemeInABottle.memetab);
	}
}
