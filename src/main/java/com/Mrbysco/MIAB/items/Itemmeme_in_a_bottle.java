package com.Mrbysco.MIAB.items;

import com.Mrbysco.MIAB.MIAB;
import com.Mrbysco.MIAB.Reference;

import net.minecraft.item.Item;

public class Itemmeme_in_a_bottle extends Item{
	
	public Itemmeme_in_a_bottle()
    {
        this.maxStackSize = 16;
        setUnlocalizedName(Reference.MIABItems.MEMEINABOTTLE.getUnlocalisedName());
		setRegistryName(Reference.MIABItems.MEMEINABOTTLE.getRegistryName());
		setCreativeTab(MIAB.tabMIAB);
    }

}
