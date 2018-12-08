package com.Mrbysco.miab.items;

import com.Mrbysco.miab.items.base.ItemMusical;

import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;

public class ItemInstrument extends ItemMusical
{
	
	public ItemInstrument(String registry, SoundEvent soundIn, SoundEvent soundIn2, int cooldown, String infoText) 
	{
		super(registry, soundIn, soundIn2, cooldown, infoText);
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
