package com.mrbysco.miab.memes.actions.base;

import com.mojang.text2speech.Narrator;
import com.mrbysco.miab.config.MemeConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class BasicTranslatedMessageMeme extends BasicFunny {

	private String[] messages;
	
	public BasicTranslatedMessageMeme(String name, int rarity, String[] messages) {
		super(name, rarity);
		this.messages = messages;
	}	

	@Override
	public void trigger(World world, BlockPos pos, EntityPlayer player) {
		if(!world.isRemote) {
			if(MemeConfig.general.UseNarator)
    		{
    			Narrator.getNarrator().say(this.messages.toString());
    		}
    		else
    		{
    			for(String message : this.messages) {
    				player.sendMessage(new TextComponentTranslation(message));
    			}
    		}
		}
	}
}
