package com.Mrbysco.miab.items;

import com.Mrbysco.miab.items.base.ItemMusical;

import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;

public class ItemInstrument extends ItemMusical
{
	
	public ItemInstrument(String unlocalized, String registry, SoundEvent soundIn, SoundEvent soundIn2, int cooldown, String infoText) 
	{
		super(unlocalized, registry, soundIn, soundIn2, cooldown, infoText);
		maxStackSize = 1;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack) 
	{
		return 40;
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack) 
	{
		return EnumAction.BOW;
	}
}
