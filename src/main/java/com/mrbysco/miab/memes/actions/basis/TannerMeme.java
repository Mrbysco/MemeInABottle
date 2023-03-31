package com.mrbysco.miab.memes.actions.basis;

import com.mojang.text2speech.Narrator;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.config.MemeConfig;
import com.mrbysco.miab.memes.actions.base.BasicFunny;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class TannerMeme extends BasicFunny {

	public TannerMeme() {
		super(Reference.MOD_PREFIX + "tanner", 10);
	}

	@Override
	public void trigger(Level world, BlockPos pos, Player player) {
		if (!world.isClientSide) {
			String tannerMessage = "So you're going by \"" + player.getName() + "\" now nerd? \n "
					+ "Haha whats up douche bag, it's Tanner from Highschool.\n "
					+ "Remember me? Me and the guys used to give you a hard time in school.\n "
					+ "Sorry you were just an easy target lol.\n "
					+ "I can see not much has changed.\n "
					+ "Remember Sarah the girl you had a crush on? Yeah we're married now.\n "
					+ "I make over 200k a year and drive a mustang GT.\n "
					+ "I guess some things never change huh loser? Nice catching up lol.\n"
					+ " Pathetic..";
			if (MemeConfig.SERVER.useNarator.get()) {
				Narrator.getNarrator().say(tannerMessage, false);
			} else {
				String[] splitMessage = tannerMessage.split("\n");
				for (String message : splitMessage) {
					player.sendSystemMessage(Component.literal(message.trim()));
				}
			}
		}
	}
}
