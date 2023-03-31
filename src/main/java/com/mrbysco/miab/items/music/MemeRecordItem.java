package com.mrbysco.miab.items.music;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.RecordItem;

import java.util.function.Supplier;

public class MemeRecordItem extends RecordItem {
	public MemeRecordItem(int comparatorValue, Supplier<SoundEvent> soundIn, int length, Properties builder) {
		super(comparatorValue, soundIn, builder.durability(1), length);
	}
}