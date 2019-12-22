package com.mrbysco.miab.memes.actions.basis.entity;

import com.mrbysco.miab.memes.actions.base.BasicFunny;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class AnimalMeme extends BasicFunny {

	private EntityType<? extends TameableEntity> entry;
	private SoundEvent sound = null;

	public AnimalMeme(String name, int rarity, EntityType<? extends TameableEntity> entry, @Nullable SoundEvent sound) {
		super(name, rarity);
		this.entry = entry;
		this.sound = sound;
	}

	public AnimalMeme(String name, int rarity, EntityType<? extends TameableEntity> entry) {
		super(name, rarity);
		this.entry = entry;
	}

	@Override
	public void trigger(World world, BlockPos pos, PlayerEntity player) {
		if(!world.isRemote) {
			Entity animal = entry.create(world);
			if(animal instanceof TameableEntity) {
				spawnAnimal(world, (TameableEntity)entry.create(world), pos, player);
				if(this.sound != null) {
					world.playSound((PlayerEntity)null, pos, this.sound, SoundCategory.RECORDS, 0.75F, 1.0F);
				}
			}
		}
	}

	public static void spawnAnimal(World world, TameableEntity entity, BlockPos pos, PlayerEntity owner)
	{
		entity.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
		entity.setTamedBy(owner);
		world.addEntity(entity);
	}
}
