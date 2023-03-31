package com.mrbysco.miab.memes.actions.basis.entity;

import com.mojang.text2speech.Narrator;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.config.MemeConfig;
import com.mrbysco.miab.memes.actions.base.BasicEntityMeme;
import com.mrbysco.miab.registry.MemeEntities;
import com.mrbysco.miab.registry.MemeSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class CenaMeme extends BasicEntityMeme {

	public CenaMeme() {
		super(Reference.MOD_PREFIX + "cena", 5, MemeEntities.JOHN_CENA.get(), MemeSounds.cena_spawn);
	}

	@Override
	public void trigger(Level world, BlockPos pos, Player player) {
		super.trigger(world, pos, player);
		if (!world.isClientSide) {
			if (MemeConfig.SERVER.useNarator.get()) {
				Narrator.getNarrator().say("And his name is!\n JOHN CENA", false);
			} else {
				player.sendSystemMessage(Component.translatable(Reference.MOD_PREFIX + "cena.itscena"));
			}
		}
	}
}
