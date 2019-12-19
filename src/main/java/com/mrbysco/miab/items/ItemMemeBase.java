package com.mrbysco.miab.items;

import com.mrbysco.miab.MemeInABottle;
import com.mrbysco.miab.Reference;
import net.minecraft.item.Item;

public class ItemMemeBase extends Item {
	public ItemMemeBase(String registry)
	{
		setTranslationKey(Reference.MOD_PREFIX + registry);
		setRegistryName(registry);
		setCreativeTab(MemeInABottle.memeTab);
	}
}
