package com.mrbysco.miab.items.music;

import com.google.common.collect.Maps;
import com.mrbysco.miab.init.MemeTab;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.function.Supplier;

public class ItemMemeRecord extends MusicDiscItem
{
	private static final Map<Supplier<? extends SoundEvent>, MusicDiscItem> RECORDS = Maps.newHashMap();
	private final Supplier<? extends SoundEvent> sound;

	public ItemMemeRecord(int comparatorValue, Supplier<? extends SoundEvent> soundIn, Properties builder)
	{
		super(comparatorValue, soundIn.get(), builder.maxDamage(1).group(MemeTab.MEME_TAB));
		this.sound = soundIn;
		RECORDS.put(this.sound, this);
	}

	@Nullable
	@OnlyIn(Dist.CLIENT)
	public static ItemMemeRecord getBySound(SoundEvent p_185074_0_) {
		Supplier<? extends SoundEvent> sound = () -> p_185074_0_;
		return (ItemMemeRecord)RECORDS.get(sound);
	}

	@Override
	public SoundEvent getSound() {
		return this.sound.get();
	}
}