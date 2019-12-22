package com.mrbysco.miab.memes.actions.base;

import com.mrbysco.miab.MemeInABottle;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BasicSoundMeme extends BasicFunny {

	private SoundEvent sound;
	
	public BasicSoundMeme(String name, int rarity, SoundEvent sound) {
		super(name, rarity);
		this.sound = sound;
	}

	@Override
	public void trigger(World world, BlockPos pos, PlayerEntity player) {
		if(!world.isRemote) {
			if(this.sound != null) { 
				world.playSound((PlayerEntity)null, pos, this.sound, SoundCategory.RECORDS, 0.75F, 1.0F);
			} else {
				MemeInABottle.logger.error("Meme sound by the name of: " + this.getName() + "has a null SoundEvent" );
			}
		}
	}
}
