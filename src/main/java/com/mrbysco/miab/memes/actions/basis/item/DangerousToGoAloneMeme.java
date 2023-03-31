package com.mrbysco.miab.memes.actions.basis.item;

import com.mojang.text2speech.Narrator;
import com.mrbysco.miab.Reference;
import com.mrbysco.miab.config.MemeConfig;
import com.mrbysco.miab.memes.actions.base.BasicFunny;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class DangerousToGoAloneMeme extends BasicFunny {

	public DangerousToGoAloneMeme() {
		super(Reference.MOD_PREFIX + "dangerous", 10);
	}

	@Override
	public void trigger(Level world, BlockPos pos, Player player) {
		super.trigger(world, pos, player);
		if (!world.isClientSide) {
			ItemStack sword = new ItemStack(Items.WOODEN_SWORD);
			sword.setHoverName(Component.literal("Zelda Sword"));
			spawnEntityItem(world, sword, pos);

			if (MemeConfig.SERVER.useNarator.get()) {
				Narrator.getNarrator().say("It's dangerous to go alone, take this", false);
			} else {
				player.sendSystemMessage(Component.translatable(Reference.MOD_PREFIX + "dangerous"));
			}
		}
	}
}
