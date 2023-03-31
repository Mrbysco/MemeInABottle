package com.mrbysco.miab.memes.actions.basis.item;

import com.mojang.text2speech.Narrator;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.config.MemeConfig;
import com.mrbysco.miab.memes.actions.base.BasicItemMeme;
import com.mrbysco.miab.registry.MemeRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class OscarMeme extends BasicItemMeme {

	public OscarMeme() {
		super(Reference.MOD_PREFIX + "oscar", 10, new ItemStack(MemeRegistry.OSCAR.get()));
	}

	@Override
	public void trigger(Level world, BlockPos pos, Player player) {
		super.trigger(world, pos, player);
		if (!world.isClientSide) {
			if (MemeConfig.SERVER.useNarator.get()) {
				Narrator.getNarrator().say("And the oscar goes to...", false);
			} else {
				player.sendSystemMessage(Component.translatable(Reference.MOD_PREFIX + "oscar.text"));
			}
		}
	}
}
