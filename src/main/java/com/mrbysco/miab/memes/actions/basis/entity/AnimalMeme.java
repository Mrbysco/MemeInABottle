package com.mrbysco.miab.memes.actions.basis.entity;

import com.mrbysco.miab.memes.actions.base.BasicFunny;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class AnimalMeme extends BasicFunny {

	private final EntityType<? extends TamableAnimal> entry;
	private SoundEvent sound = null;

	public AnimalMeme(String name, int rarity, EntityType<? extends TamableAnimal> entry, @Nullable SoundEvent sound) {
		super(name, rarity);
		this.entry = entry;
		this.sound = sound;
	}

	public AnimalMeme(String name, int rarity, EntityType<? extends TamableAnimal> entry) {
		super(name, rarity);
		this.entry = entry;
	}

	@Override
	public void trigger(Level world, BlockPos pos, Player player) {
		if (!world.isClientSide) {
			TamableAnimal animal = entry.create(world);
			if (animal instanceof TamableAnimal) {
				spawnAnimal(world, animal, pos, player);
				if (this.sound != null) {
					world.playSound((Player) null, pos, this.sound, SoundSource.RECORDS, 0.75F, 1.0F);
				}
			}
		}
	}

	public static void spawnAnimal(Level world, @Nullable TamableAnimal entity, BlockPos pos, Player owner) {
		if (entity != null) {
			entity.teleportTo(pos.getX(), pos.getY(), pos.getZ());
			entity.tame(owner);
			world.addFreshEntity(entity);
		}
	}
}
