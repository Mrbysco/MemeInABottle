package com.Mrbysco.miab.items.base;

import com.Mrbysco.miab.MemeInABottle;

import net.minecraft.item.ItemFood;

public class ItemCustomFood extends ItemFood{

	public ItemCustomFood(int amount, float saturation, boolean isWolfFood, String unlocalized, String registry) {
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(unlocalized);
		setRegistryName(registry);
		setCreativeTab(MemeInABottle.memetab);
	}
}
