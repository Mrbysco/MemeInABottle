package com.mrbysco.miab.memes.actions.basis.item;

import com.mojang.text2speech.Narrator;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.config.MemeConfig;
import com.mrbysco.miab.init.MemeItems;
import com.mrbysco.miab.memes.actions.base.BasicItemMeme;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class HotKnifeMeme extends BasicItemMeme {

	public HotKnifeMeme() {
		super(Reference.MOD_PREFIX + "knife", 10, new ItemStack(MemeItems.knife));
	}

	@Override
	public void trigger(World world, BlockPos pos, EntityPlayer player) {
		super.trigger(world, pos, player);
		if(!world.isRemote) {
	        if(MemeConfig.general.UseNarator)
    		{
	        	Narrator.getNarrator().say("You know what to do!");
    		}
    		else
    		{
    			player.sendMessage(new TextComponentTranslation(Reference.MOD_PREFIX + "message.ykwtd"));
    		}
		}
	}
}
