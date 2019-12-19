package com.mrbysco.miab.memes.actions;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface iFunny {
	
	/*
	 * What action happens when the meme is triggered
	 * 
	 * @param player The player who triggered the meme
	 */
	void trigger(World worldIn, BlockPos pos, EntityPlayer playerIn);
	
	/*
	 * @return Get's you the rarity of the meme
	 */
	int getMemeRarity();
	
	/*
	 * @return Set the rarity of the meme
	 */
	void setMemeRarity(int rarity);
	
	/*
	 * @return Unique name for meme
	 */
	String getName();
}
