package com.mrbysco.miab.memes.actions.base;

import com.mrbysco.miab.MemeInABottle;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BasicEntityMeme extends BasicFunny {

	private EntityType<? extends LivingEntity> entry;
	private SoundEvent sound = null;

	public BasicEntityMeme(String name, int rarity, EntityType<? extends LivingEntity> entry, @Nullable SoundEvent sound) {
		super(name, rarity);
		this.entry = entry;
		this.sound = sound;
	}

	public BasicEntityMeme(String name, int rarity, EntityType<? extends LivingEntity> entry) {
		super(name, rarity);
		this.entry = entry;
	}

	@Override
	public void trigger(World world, BlockPos pos, PlayerEntity player) {
		if(!world.isRemote) {
			spawnEntity(world, entry.create(world), pos);
			if(this.sound != null) { 
				world.playSound((PlayerEntity)null, pos, this.sound, SoundCategory.RECORDS, 0.75F, 1.0F);
			} else {
				MemeInABottle.logger.error("Meme sound by the name of: " + this.getName() + "has a null SoundEvent" );
			}
		}
	}
}
