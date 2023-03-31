package com.mrbysco.miab.memes.actions.base;

import com.mrbysco.miab.memes.actions.iFunny;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class BasicFunny implements iFunny {

	private final String name;
	private int rarity;

	public BasicFunny(String name, int rarity) {
		this.name = name;
		this.rarity = rarity;
	}

	@Override
	public void trigger(Level world, BlockPos pos, Player player) {

	}

	@Override
	public int getMemeRarity() {
		return this.rarity;
	}

	@Override
	public void setMemeRarity(int rarity) {
		this.rarity = rarity;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public static void spawnEntity(Level world, @Nullable Entity entity, BlockPos pos) {
		if (entity != null) {
			entity.teleportTo(pos.getX(), pos.getY(), pos.getZ());
			world.addFreshEntity(entity);
		}
	}

	public static void spawnEntityItem(Level world, ItemStack stack, BlockPos pos) {
		world.addFreshEntity(new ItemEntity(world, pos.getX(), pos.getY() + 0.5, pos.getZ(), stack));
	}
}
