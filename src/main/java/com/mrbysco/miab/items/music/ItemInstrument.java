package com.mrbysco.miab.items.music;

import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;

import javax.annotation.Nullable;

public class ItemInstrument extends ItemMusical {

	public ItemInstrument(String registry, SoundEvent soundIn, @Nullable SoundEvent soundIn2, int cooldown, String infoText)
	{
		super(registry, soundIn, soundIn2, cooldown, infoText);
		maxStackSize = 1;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 40;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack)
	{
		return EnumAction.BOW;
	}
}