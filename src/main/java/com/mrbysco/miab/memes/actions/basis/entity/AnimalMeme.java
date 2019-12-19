package com.mrbysco.miab.memes.actions.basis.entity;

import com.mrbysco.miab.MemeInABottle;
import com.mrbysco.miab.memes.actions.base.BasicFunny;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.EntityEntry;

import javax.annotation.Nullable;

public class AnimalMeme extends BasicFunny {

	private EntityEntry entry;
	private SoundEvent sound = null;

	public AnimalMeme(String name, int rarity, EntityEntry entry, @Nullable SoundEvent sound) {
		super(name, rarity);
		this.entry = entry;
		this.sound = sound;
	}

	public AnimalMeme(String name, int rarity, EntityEntry entry) {
		super(name, rarity);
		this.entry = entry;
	}

	@Override
	public void trigger(World world, BlockPos pos, EntityPlayer player) {
		if(!world.isRemote) {
			Entity animal = entry.newInstance(world);
			if(animal instanceof EntityTameable) {
				spawnAnimal(world, (EntityTameable)entry.newInstance(world), pos, player);
				if(this.sound != null) {
					world.playSound((EntityPlayer)null, pos, this.sound, SoundCategory.RECORDS, 0.75F, 1.0F);
				}
			}
		}
	}

	public static void spawnAnimal(World world, EntityTameable entity, BlockPos pos, EntityPlayer owner)
	{
		entity.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
		entity.setTamedBy(owner);
		world.spawnEntity(entity);
	}
}
