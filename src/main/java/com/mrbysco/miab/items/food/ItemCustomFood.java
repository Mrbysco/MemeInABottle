package com.mrbysco.miab.items.food;

import com.mrbysco.miab.MemeInABottle;
import com.mrbysco.miab.Reference;
import net.minecraft.item.ItemFood;

public class ItemCustomFood extends ItemFood {
	public ItemCustomFood(int amount, float saturation, boolean isWolfFood, String registry)
	{
		super(amount, saturation, isWolfFood);
		setTranslationKey(Reference.MOD_PREFIX + registry);
		setRegistryName(registry);
		setCreativeTab(MemeInABottle.memeTab);
	}
}
