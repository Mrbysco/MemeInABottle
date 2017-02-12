package com.Mrbysco.MIAB.items;

import com.Mrbysco.MIAB.MIAB;
import com.Mrbysco.MIAB.Reference;

import net.minecraft.item.ItemFood;

public class ItemPoptart extends ItemFood{

	public ItemPoptart(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(Reference.MIABItems.POPTART.getUnlocalisedName());
		setRegistryName(Reference.MIABItems.POPTART.getRegistryName());
		setCreativeTab(MIAB.tabMIAB);
	}
}
