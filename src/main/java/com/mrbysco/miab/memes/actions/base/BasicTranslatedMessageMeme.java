package com.mrbysco.miab.memes.actions.base;

import com.mojang.text2speech.Narrator;
import com.mrbysco.miab.config.MemeConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class BasicTranslatedMessageMeme extends BasicFunny {

	private final String[] messages;

	public BasicTranslatedMessageMeme(String name, int rarity, String... messages) {
		super(name, rarity);
		this.messages = messages;
	}

	@Override
	public void trigger(Level world, BlockPos pos, Player player) {
		if (!world.isClientSide) {
			if (MemeConfig.SERVER.useNarator.get()) {
				String message = String.join(" ", messages);
				Narrator.getNarrator().say(message, false);
			} else {
				for (String message : this.messages) {
					player.sendSystemMessage(Component.translatable(message));
				}
			}
		}
	}
}
