package com.mrbysco.miab.items.music;

import com.mrbysco.miab.init.MemeTab;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.util.SoundEvent;

public class ItemMemeRecord extends MusicDiscItem
{
	public ItemMemeRecord(int comparatorValue, SoundEvent soundIn, Properties builder)
	{
		super(comparatorValue, soundIn, builder.maxDamage(1).group(MemeTab.MEME_TAB));
	}
}