package com.mrbysco.miab.memes.actions.basis.item;

import com.mojang.text2speech.Narrator;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.config.MemeConfig;
import com.mrbysco.miab.init.MemeRegister;
import com.mrbysco.miab.memes.actions.base.BasicItemMeme;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class OscarMeme extends BasicItemMeme {

	public OscarMeme() {
		super(Reference.MOD_PREFIX + "oscar", 10, new ItemStack(MemeRegister.OSCAR.get()));
	}

	@Override
	public void trigger(World world, BlockPos pos, PlayerEntity player) {
		super.trigger(world, pos, player);
		if(!world.isRemote) {
			if(MemeConfig.SERVER.UseNarator.get())
    		{
	        	Narrator.getNarrator().say("And the oscar goes to...", false);
    		}
    		else
    		{
    			player.sendMessage(new TranslationTextComponent(Reference.MOD_PREFIX + "oscar.text"));
    		}
		}
	}
}
