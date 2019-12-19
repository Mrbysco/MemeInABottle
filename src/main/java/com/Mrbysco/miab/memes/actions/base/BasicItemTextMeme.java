package com.mrbysco.miab.memes.actions.base;

import com.mojang.text2speech.Narrator;
import com.mrbysco.miab.config.MemeConfig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BasicItemTextMeme extends BasicFunny {

	private SoundEvent sound = null;
	private ItemStack stack;
	private String message = "";

	public BasicItemTextMeme(String name, int rarity, ItemStack stack) {
		super(name, rarity);
		this.stack = stack;
	}

	public BasicItemTextMeme(String name, int rarity, @Nullable SoundEvent sound, ItemStack stack) {
		super(name, rarity);
		this.sound = sound;
		this.stack = stack;
	}

	public BasicItemTextMeme(String name, int rarity, @Nullable SoundEvent sound, ItemStack stack, String message) {
		super(name, rarity);
		this.sound = sound;
		this.stack = stack;
		this.message = message;
	}

	@Override
	public void trigger(World world, BlockPos pos, EntityPlayer player) {
		if(!world.isRemote) {
			if(!message.isEmpty()) {
				if(MemeConfig.general.UseNarator)
				{
					Narrator.getNarrator().say(this.message);
				}
				else
				{
					String[] splitMessage = message.split("\n");
					for(String message : splitMessage) {
						player.sendMessage(new TextComponentString(TextFormatting.YELLOW + message.trim()));
					}
				}
			}
			if(this.sound != null) {
				world.playSound((EntityPlayer)null, pos, this.sound, SoundCategory.RECORDS, 0.75F, 1.0F);
			}
	    	spawnEntityItem(world, this.stack, pos);
		}
	}
}
