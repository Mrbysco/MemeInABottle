package com.mrbysco.miab.memes.actions.basis.item;

import com.mojang.text2speech.Narrator;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.config.MemeConfig;
import com.mrbysco.miab.init.MemeItems;
import com.mrbysco.miab.memes.actions.base.BasicItemMeme;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class FidgetSpinnerMeme extends BasicItemMeme {

	public FidgetSpinnerMeme() {
		super(Reference.MOD_PREFIX + "fidget_spinner", 10, new ItemStack(MemeItems.fidget_spinner));
	}

	@Override
	public void trigger(World world, BlockPos pos, PlayerEntity player) {
		super.trigger(world, pos, player);
		if(!world.isRemote) {
			if(MemeConfig.SERVER.UseNarator.get())
    		{
	        	Narrator.getNarrator().say("You know what to do!", false);
    		}
    		else
    		{
    			player.sendMessage(new TranslationTextComponent(Reference.MOD_PREFIX + "message.ykwtd"));
    		}
		}
	}
}
