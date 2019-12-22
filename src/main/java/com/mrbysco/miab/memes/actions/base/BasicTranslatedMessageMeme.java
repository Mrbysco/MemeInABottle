package com.mrbysco.miab.memes.actions.base;

import com.mojang.text2speech.Narrator;
import com.mrbysco.miab.config.MemeConfig;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

public class BasicTranslatedMessageMeme extends BasicFunny {

	private String[] messages;
	
	public BasicTranslatedMessageMeme(String name, int rarity, String[] messages) {
		super(name, rarity);
		this.messages = messages;
	}	

	@Override
	public void trigger(World world, BlockPos pos, PlayerEntity player) {
		if(!world.isRemote) {
			if(MemeConfig.SERVER.UseNarator.get())
    		{
    			Narrator.getNarrator().say(this.messages.toString(), false);
    		}
    		else
    		{
    			for(String message : this.messages) {
    				player.sendMessage(new StringTextComponent(message));
    			}
    		}
		}
	}
}
