package com.mrbysco.miab.items.music;

import com.mrbysco.miab.init.MemeTab;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.util.SoundEvent;

import java.util.function.Supplier;

public class MemeRecordItem extends MusicDiscItem {
	public MemeRecordItem(int comparatorValue, Supplier<SoundEvent> soundIn, Properties builder) {
		super(comparatorValue, soundIn, builder.maxDamage(1).group(MemeTab.MEME_TAB));
	}
}