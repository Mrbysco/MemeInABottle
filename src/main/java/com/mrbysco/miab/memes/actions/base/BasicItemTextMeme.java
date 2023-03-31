package com.mrbysco.miab.memes.actions.base;

import com.mojang.text2speech.Narrator;
import com.mrbysco.miab.config.MemeConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class BasicItemTextMeme extends BasicFunny {

	private SoundEvent sound = null;
	private final ItemStack stack;
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
	public void trigger(Level world, BlockPos pos, Player player) {
		if (!world.isClientSide) {
			if (!message.isEmpty()) {
				if (MemeConfig.SERVER.useNarator.get()) {
					Narrator.getNarrator().say(this.message, false);
				} else {
					String[] splitMessage = message.split("\n");
					for (String message : splitMessage) {
						player.sendSystemMessage(Component.literal(ChatFormatting.YELLOW + message.trim()));
					}
				}
			}
			if (this.sound != null) {
				world.playSound((Player) null, pos, this.sound, SoundSource.RECORDS, 0.75F, 1.0F);
			}
			spawnEntityItem(world, this.stack, pos);
		}
	}
}
