package com.mrbysco.miab.items;

import com.mrbysco.miab.init.MemeTab;
import net.minecraft.item.Item;

public class MemeBaseItem extends Item {
	public MemeBaseItem(Item.Properties builder)
	{
		super(builder.group(MemeTab.MEME_TAB));
	}
}
