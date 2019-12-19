package com.mrbysco.miab.memes.actions.base;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BasicItemMeme extends BasicFunny {

	private SoundEvent sound = null;
	private ItemStack stack;
	
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
	public void trigger(World world, BlockPos pos, EntityPlayer player) {
		if(!world.isRemote) {
			if(this.sound != null) {
				world.playSound((EntityPlayer)null, pos, this.sound, SoundCategory.RECORDS, 0.75F, 1.0F);
			}
	    	spawnEntityItem(world, this.stack, pos);
		}
	}
}
