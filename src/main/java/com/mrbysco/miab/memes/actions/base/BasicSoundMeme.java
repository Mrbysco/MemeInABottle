package com.mrbysco.miab.memes.actions.base;

import com.mrbysco.miab.MemeInABottle;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

public class BasicSoundMeme extends BasicFunny {
	private final Supplier<SoundEvent> soundEvent;

	public BasicSoundMeme(String name, int rarity, Supplier<SoundEvent> soundEvent) {
		super(name, rarity);
		this.soundEvent = soundEvent;
	}

	@Override
	public void trigger(Level world, BlockPos pos, Player player) {
		if (!world.isClientSide) {
			if (soundEvent.get() != null) {
				world.playSound((Player) null, pos, soundEvent.get(), SoundSource.RECORDS, 0.75F, 1.0F);
			} else {
				MemeInABottle.logger.error("Meme by the name of: {} has an invalid SoundEvent", getName());
			}
		}
	}
}
