package com.mrbysco.miab.memes.actions.basis.entity;

import com.mojang.text2speech.Narrator;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.config.MemeConfig;
import com.mrbysco.miab.init.MemeEntities;
import com.mrbysco.miab.init.MemeSounds;
import com.mrbysco.miab.memes.actions.base.BasicEntityMeme;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class CenaMeme extends BasicEntityMeme {

	public CenaMeme() {
		super(Reference.MOD_PREFIX + "cena", 5, MemeEntities.JOHN_CENA, MemeSounds.cena_spawn);
	}

	@Override
	public void trigger(World world, BlockPos pos, EntityPlayer player) {
		super.trigger(world, pos, player);
		if(!world.isRemote) {
	        if(MemeConfig.general.UseNarator)
    		{
	        	Narrator.getNarrator().say("And his name is!\n JOHN CENA");
    		}
    		else
    		{
        		player.sendMessage(new TextComponentTranslation(Reference.MOD_PREFIX + "cena.itscena"));
    		}
		}
	}
}
