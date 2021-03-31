package com.mrbysco.miab.items.music;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.SoundEvent;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class InstrumentItem extends MusicalItem {

	public InstrumentItem(Item.Properties builder, Supplier<SoundEvent> soundIn, @Nullable Supplier<SoundEvent> soundIn2, int cooldown, String infoText) {
		super(builder.maxStackSize(1), soundIn, soundIn2, cooldown, infoText);
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 40;
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BOW;
	}
}