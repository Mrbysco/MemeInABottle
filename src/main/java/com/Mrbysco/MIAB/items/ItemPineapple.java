package com.Mrbysco.MIAB.items;

import com.Mrbysco.MIAB.MIAB;
import com.Mrbysco.MIAB.Reference;

import net.minecraft.item.ItemFood;

public class ItemPineapple extends ItemFood{

	public ItemPineapple(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(Reference.MIABItems.PINEAPPLE.getUnlocalisedName());
		setRegistryName(Reference.MIABItems.PINEAPPLE.getRegistryName());
		setCreativeTab(MIAB.tabMIAB);
	}

}
