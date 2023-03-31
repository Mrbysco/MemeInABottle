package com.mrbysco.miab.memes.actions.base;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class BasicItemMeme extends BasicFunny {

	private SoundEvent sound = null;
	private final ItemStack stack;

	public BasicItemMeme(String name, int rarity, ItemStack stack) {
		super(name, rarity);
		this.stack = stack;
	}

	public BasicItemMeme(String name, int rarity, @Nullable SoundEvent sound, ItemStack stack) {
		super(name, rarity);
		this.sound = sound;
		this.stack = stack;
	}

	@Override
	public void trigger(Level world, BlockPos pos, Player player) {
		if (!world.isClientSide) {
			if (this.sound != null) {
				world.playSound((Player) null, pos, this.sound, SoundSource.RECORDS, 0.75F, 1.0F);
			}
			spawnEntityItem(world, this.stack, pos);
		}
	}
}
