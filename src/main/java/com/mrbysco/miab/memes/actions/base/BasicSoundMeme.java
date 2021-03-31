package com.mrbysco.miab.memes.actions.base;

import com.mrbysco.miab.MemeInABottle;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class BasicSoundMeme extends BasicFunny {
	private final Supplier<SoundEvent> soundEvent;
	
	public BasicSoundMeme(String name, int rarity, Supplier<SoundEvent> soundEvent) {
		super(name, rarity);
		this.soundEvent = soundEvent;
	}

	@Override
	public void trigger(World world, BlockPos pos, PlayerEntity player) {
		if(!world.isRemote) {
			if(soundEvent.get() != null) {
				world.playSound((PlayerEntity)null, pos, soundEvent.get(), SoundCategory.RECORDS, 0.75F, 1.0F);
			} else {
				MemeInABottle.logger.error("Meme by the name of: {} has an invalid SoundEvent", getName());
			}
		}
	}
}
