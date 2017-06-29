package com.Mrbysco.MIAB.items;

import com.Mrbysco.MIAB.MIAB;
import com.Mrbysco.MIAB.Reference;

import net.minecraft.item.ItemFood;

public class ItemPoptart extends ItemFood{

	public ItemPoptart(int amount, float saturation, boolean isWolfFood, String UnlocalisedName, String RegistryName) {
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(UnlocalisedName);
		setRegistryName(RegistryName);
		setCreativeTab(MIAB.tabMIAB);
	}
}
