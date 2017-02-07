package com.Mrbysco.MIAB.items;

import com.Mrbysco.MIAB.MIAB;
import com.Mrbysco.MIAB.Reference;

import net.minecraft.item.ItemFood;

public class ItemMineBurger extends ItemFood{

	public ItemMineBurger(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(Reference.MIABItems.MINEBURGER.getUnlocalisedName());
		setRegistryName(Reference.MIABItems.MINEBURGER.getRegistryName());
		setCreativeTab(MIAB.tabMIAB);
	}
}
