package com.mrbysco.miab.memes.actions;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public interface iFunny {

	/*
	 * What action happens when the meme is triggered
	 *
	 * @param player The player who triggered the meme
	 */
	void trigger(Level level, BlockPos pos, Player playerIn);

	/*
	 * @return Gets you the rarity of the meme
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
