package com.mrbysco.miab.items.music;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class InstrumentItem extends MusicalItem {

	public InstrumentItem(Item.Properties builder, Supplier<SoundEvent> soundIn, @Nullable Supplier<SoundEvent> soundIn2, int cooldown, String infoText) {
		super(builder.stacksTo(1), soundIn, soundIn2, cooldown, infoText);
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 40;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.BOW;
	}
}