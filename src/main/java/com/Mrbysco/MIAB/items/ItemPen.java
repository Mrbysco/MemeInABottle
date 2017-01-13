package com.Mrbysco.MIAB.items;

import com.Mrbysco.MIAB.MIAB;
import com.Mrbysco.MIAB.Reference;

import net.minecraft.item.Item;

public class ItemPen extends Item{
	public ItemPen() {
		setUnlocalizedName(Reference.MIABItems.PEN.getUnlocalisedName());
		setRegistryName(Reference.MIABItems.PEN.getRegistryName());
		setCreativeTab(MIAB.tabMIAB);
	}
}
