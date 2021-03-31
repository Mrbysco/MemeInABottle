package com.mrbysco.miab.memes.actions.basis.entity;

import com.mojang.text2speech.Narrator;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.config.MemeConfig;
import com.mrbysco.miab.init.MemeEntities;
import com.mrbysco.miab.init.MemeSounds;
import com.mrbysco.miab.memes.actions.base.BasicEntityMeme;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class CenaMeme extends BasicEntityMeme {

	public CenaMeme() {
		super(Reference.MOD_PREFIX + "cena", 5, MemeEntities.JOHN_CENA.get(), MemeSounds.cena_spawn);
	}

	@Override
	public void trigger(World world, BlockPos pos, PlayerEntity player) {
		super.trigger(world, pos, player);
		if(!world.isRemote) {
			if(MemeConfig.SERVER.useNarator.get()) {
	        	Narrator.getNarrator().say("And his name is!\n JOHN CENA", false);
    		} else {
        		player.sendMessage(new TranslationTextComponent(Reference.MOD_PREFIX + "cena.itscena"), Util.DUMMY_UUID);
    		}
		}
	}
}
