package com.mrbysco.miab.items;

import com.mrbysco.miab.init.MemeTab;
import net.minecraft.item.Item;

public class ItemMemeBase extends Item {
	public ItemMemeBase(Item.Properties builder)
	{
		super(builder.group(MemeTab.MEME_TAB));
	}
}
