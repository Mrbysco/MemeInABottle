package com.mrbysco.miab.memes.actions.base;

import com.mrbysco.miab.memes.actions.iFunny;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BasicFunny implements iFunny {

	private String name;
	private int rarity;

	public BasicFunny(String name, int rarity)
	{
		this.name = name;
		this.rarity = rarity;
	}
	
	@Override
	public void trigger(World world, BlockPos pos, EntityPlayer player) {
		
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
	
	public static void spawnEntity(World world, Entity entity, BlockPos pos) 
	{		
		entity.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
		world.spawnEntity(entity);
	}
	
	public static void spawnEntityItem(World world, ItemStack stack, BlockPos pos)
	{
    	world.spawnEntity(new EntityItem(world, pos.getX(), pos.getY() + 0.5, pos.getZ(), stack));
	}
}
