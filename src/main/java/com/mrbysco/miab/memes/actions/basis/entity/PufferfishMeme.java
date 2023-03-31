package com.mrbysco.miab.memes.actions.basis.entity;

import com.mojang.text2speech.Narrator;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.config.MemeConfig;
import com.mrbysco.miab.memes.actions.base.BasicEntityMeme;
import com.mrbysco.miab.registry.MemeSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class PufferfishMeme extends BasicEntityMeme {

	public PufferfishMeme() {
		super(Reference.MOD_PREFIX + "pufferfish", 5, EntityType.PUFFERFISH, MemeSounds.pufferfish);
	}

	@Override
	public void trigger(Level world, BlockPos pos, Player player) {
		super.trigger(world, pos, player);
		if (!world.isClientSide) {
			spawnEntityItem(world, new ItemStack(Items.CARROT, 1), pos);
			if (MemeConfig.SERVER.useNarator.get()) {
				Narrator.getNarrator().say("You know what to do!", false);
			} else {
				player.sendSystemMessage(Component.translatable(Reference.MOD_PREFIX + "message.ykwtd"));
			}
		}
	}
}
